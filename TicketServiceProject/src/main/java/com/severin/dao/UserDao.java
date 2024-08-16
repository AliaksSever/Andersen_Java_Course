package com.severin.dao;

import com.severin.entity.UserEntity;
import com.severin.connection.ConnectionManager;
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

    private static final String UPDATE_SQL = """
            UPDATE users
            SET name = ?
            WHERE id = ?
            """;

    private static final String DELETE_SQL = """
            DELETE FROM users
            WHERE id = ?
            """;

    private static final String FIND_ALL_SQL = """
            SELECT id,
                   name,
                   creation_date
            FROM users
            """;

    private final static String FIND_BY_ID_SQL = FIND_ALL_SQL + """
            WHERE id = ?
            """;

    private UserDao(){}

    public static UserDao getInstance() {
        return INSTANCE;
    }

    public List<UserEntity> findAll() {
        try(Connection connection = ConnectionManager.open();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_SQL);
        ){
            ResultSet resultSet = preparedStatement.executeQuery();
            List<UserEntity> users= new ArrayList<>();

            while (resultSet.next()) {
                users.add(buildUser(resultSet));
            }
            return users;
        }
        catch(SQLException e) {
            throw new DaoException(e);
        }
    }

    public Optional<UserEntity> findById(int id) {
        try(Connection connection = ConnectionManager.open();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_SQL);
        ){
            preparedStatement.setInt(1, id);

            ResultSet resSet = preparedStatement.executeQuery();

            UserEntity user = null;

            if(resSet.next()) {
                user = buildUser(resSet);
            }
            return Optional.ofNullable(user);
        }
        catch (SQLException e) {
            throw new DaoException(e);
        }
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

    public void update(UserEntity user) {
        try(Connection connection = ConnectionManager.open();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL);
        ) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getId());

            preparedStatement.executeUpdate();
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

    public UserEntity buildUser(ResultSet resultSet) throws SQLException{
        return new UserEntity(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getTimestamp("creation_date")
        );
    }

}
