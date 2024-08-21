package com.severin.dao;

import com.severin.connection.ConnectionManager;
import com.severin.entity.TicketEntity;
import com.severin.enums.TicketType;
import com.severin.exception.DaoException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Optional;

import java.util.List;

public class TicketDao {

    private final static TicketDao INSTANCE = new TicketDao();
    private final static String DELETE_SQL = """
            DELETE FROM tickets
            WHERE id = ?
            """;
    private final static String SAVE_SQL = """
            INSERT INTO tickets(ticket_type, user_id)
            VALUES (CAST(? AS TICKET_TYPE), ?)
            """;
    public final static String UPDATE_SQL = """
            UPDATE tickets
            SET ticket_type = CAST(? AS TICKET_TYPE),
                user_id = ?
            WHERE id = ?
            """;

    private final static String FIND_ALL_SQL = """
            SELECT id,
                CAST(ticket_type AS VARCHAR),
                user_id,
                creation_date
            FROM tickets
            """;

    private final static String FIND_BY_ID_SQL = FIND_ALL_SQL + """
            WHERE id = ?
            """;

    private TicketDao(){}

    public List<TicketEntity> findAll() {
        try(Connection connection = ConnectionManager.open();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_SQL);
        ) {
            ResultSet resSet = preparedStatement.executeQuery();
            List<TicketEntity> tickets= new ArrayList<>();
            while (resSet.next()) {
                tickets.add(buildTicket(resSet));
            }
            return tickets;
        }
        catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public Optional<TicketEntity> findById(int id) {
        try(Connection connection = ConnectionManager.open();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_SQL);
        ) {
            preparedStatement.setInt(1, id);

            ResultSet resSet = preparedStatement.executeQuery();

            TicketEntity ticket = null;

            if (resSet.next()) {
                ticket = buildTicket(resSet);
            }

            return Optional.ofNullable(ticket);

        }
        catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public void update(TicketEntity ticket) {
        try(
                Connection connection = ConnectionManager.open();
                PreparedStatement prepStatement = connection.prepareStatement(UPDATE_SQL);
                ) {
            prepStatement.setString(1, ticket.getTicketType().name());
            prepStatement.setInt(2, ticket.getUserId());
            prepStatement.setInt(3, ticket.getId());

            prepStatement.executeUpdate();
        }
        catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public TicketEntity save(TicketEntity ticket) {
        try (
                Connection connection = ConnectionManager.open();
                PreparedStatement prepStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS);
                ) {
            prepStatement.setString(1, ticket.getTicketType().name());
            prepStatement.setInt(2, ticket.getUserId());

            prepStatement.executeUpdate();

            ResultSet generatedKey = prepStatement.getGeneratedKeys();
            if (generatedKey.next()) {
                ticket.setId(generatedKey.getInt("id"));

                long now = System.currentTimeMillis();
                Timestamp sqlTimestamp = new Timestamp(now);

                ticket.setCreationTime(sqlTimestamp);
            }

            return ticket;
        }
        catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public boolean delete(int id) {
        try(
                Connection connection = ConnectionManager.open();
                PreparedStatement prepStatement = connection.prepareStatement(DELETE_SQL);
                ) {
            prepStatement.setInt(1, id);
            return prepStatement.executeUpdate()>0;
        }
        catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public static TicketDao getInstance() {
        return INSTANCE;
    }

    public TicketEntity buildTicket(ResultSet resSet) throws SQLException{
        return new TicketEntity(
                resSet.getInt("id"),
                TicketType.valueOf(resSet.getString("ticket_type")),
                resSet.getInt("user_id"),
                resSet.getTimestamp("creation_date")
        );
    }
}
