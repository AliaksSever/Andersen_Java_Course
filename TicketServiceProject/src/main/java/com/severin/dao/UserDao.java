package com.severin.dao;

import com.severin.entity.UserEntity;
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

public class UserDao {

    private final static UserDao INSTANCE = new UserDao();

    private static final String SAVE_SQL = """
            INSERT INTO users(name)
            VALUES(?)
            """;
    private static final String DELETE_SQL = """
            DELETE FROM users
            WHERE id = ?
            """;

    private UserDao(){}

    public static UserDao getInstance() {
        return INSTANCE;
    }

    public UserEntity save(UserEntity user) {
        try(Connection connection = ConnectionManager.open();
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS);
        ) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.executeUpdate();

            ResultSet generatedKey = preparedStatement.getGeneratedKeys();
            if (generatedKey.next()) {
                user.setId(generatedKey.getInt("id"));

                long now = System.currentTimeMillis();
                Timestamp sqlTimestamp = new Timestamp(now);

                user.setCreationDate(sqlTimestamp);
            }
            return user;
        }
        catch(SQLException e) {
            throw new DaoException(e);
        }

    }

    public boolean delete(int id) {
        try(Connection connection = ConnectionManager.open();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL);
        ){
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate()>0;
        }
        catch(SQLException e) {
            throw new DaoException(e);
        }
    }

}
