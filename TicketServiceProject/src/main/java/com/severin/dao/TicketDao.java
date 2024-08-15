package com.severin.dao;

import com.severin.connection.ConnectionManager;
import com.severin.entity.TicketEntity;
import com.severin.exception.DaoException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Timestamp;

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

    private TicketDao(){}

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

}
