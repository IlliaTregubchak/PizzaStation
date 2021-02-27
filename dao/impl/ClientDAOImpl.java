package station.pizza.dao.impl;

import station.pizza.config.DatabaseConfig;
import station.pizza.dao.ClientDAO;
import station.pizza.dto.clients.EditClientDTO;

import java.sql.*;

public class ClientDAOImpl implements ClientDAO {

    private final String INSERT_CLIENTS = "insert into clients(name, phone_number, discount) VALUES(?, ?, ?)";
    private final String SELECT_CLIENTS_BY_PHONE = "select * from clients where phone_number = ?";
    private final String SELECT_CLIENTS_ID_BY_PHONE = "select id from clients where phone_number = ?";

    public long save(EditClientDTO editClientDTO) {
        try {
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENTS, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, editClientDTO.getName());
            preparedStatement.setString(2, editClientDTO.getPhone());
            preparedStatement.setInt(3, editClientDTO.getDiscount());
            preparedStatement.executeUpdate();
            final ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean exists(String phone) {
        try{
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLIENTS_BY_PHONE);
            preparedStatement.setString(1, phone);
            final ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public long findIdByPhone(String phone) {
        try{
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLIENTS_ID_BY_PHONE);
            preparedStatement.setString(1, phone);
            final ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getLong("id");
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void delete(long id) {
        try{
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement("delete  from clients where id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
