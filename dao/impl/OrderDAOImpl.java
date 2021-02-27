package station.pizza.dao.impl;

import station.pizza.config.DatabaseConfig;
import station.pizza.dao.OrderDAO;
import station.pizza.dto.orders.OrderDTO;
import station.pizza.dto.orders.SaveOrderDTO;
import station.pizza.dto.orders.SaveOrderPizzasDTO;
import station.pizza.dto.orders.UpdateOrderDTO;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    private final String INSERT_ORDER = "insert into orders(preferences, price, delivery_time, address, client_id, status_id) VALUES(?, ?, ?, ?, ?, ?) ";
    private final String INSERT_PIZZA_ORDER = "insert into order_pizzas(order_id, pizza_id, count) VALUES (?, ?, ?)";
    private final String UPDATE_STATUS = "update orders set status_id = ? where id = ?";
    private final String SELECT_ORDERS = "select o.id, o.preferences, o.price, o.delivery_time, o.address, s.name as status from orders o, statuses s where o.status_id = s.id;";
    private final String UPDATE_ORDER = "update orders set preferences = ?, price = ?, delivery_time = ?, address = ? where id = ?;";

    @Override
    public long save(SaveOrderDTO saveOrderDTO) {
        try {
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, saveOrderDTO.getPreferences());
            preparedStatement.setDouble(2, saveOrderDTO.getPrice());
            preparedStatement.setString(3, saveOrderDTO.getDeliveryTime());
            preparedStatement.setString(4, saveOrderDTO.getAddress());
            preparedStatement.setLong(5, saveOrderDTO.getClientId());
            preparedStatement.setLong(6, saveOrderDTO.getStatusId());
            preparedStatement.executeUpdate();
            final ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()) {
               return resultSet.getLong(1);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void savePizza(long orderId, long pizzaId, int count) {
        try{
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PIZZA_ORDER);
            preparedStatement.setLong(1, orderId);
            preparedStatement.setLong(2, pizzaId);
            preparedStatement.setInt(3, count);
            preparedStatement.execute();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStatus(long statusId, long orderId) {
        try {
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STATUS);
            preparedStatement.setLong(1, statusId);
            preparedStatement.setLong(2, orderId);
            preparedStatement.execute();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateOrder(UpdateOrderDTO updateOrderDTO, long orderId) {
        try{
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ORDER);
            preparedStatement.setString(1, updateOrderDTO.getPreferences());
            preparedStatement.setDouble(2, updateOrderDTO.getPrice());
            preparedStatement.setString(3, updateOrderDTO.getDeliveryTime());
            preparedStatement.setString(4, updateOrderDTO.getAddress());
            preparedStatement.setLong(5, orderId);
            preparedStatement.execute();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OrderDTO> findAll() {
        List<OrderDTO> orders = new LinkedList<>();
        try {
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDERS);
            final ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                final long id = resultSet.getLong("id");
                final String preferences = resultSet.getString("preferences");
                final double price = resultSet.getDouble("price");
                final String deliveryTime = resultSet.getString("delivery_time");
                final String address = resultSet.getString("address");
                final String status = resultSet.getString("status");

                OrderDTO orderDTO = new OrderDTO();
                orderDTO.setId(id);
                orderDTO.setPreferences(preferences);
                orderDTO.setPrice(price);
                orderDTO.setDeliveryTime(deliveryTime);
                orderDTO.setAddress(address);
                orderDTO.setStatus(status);

                orders.add(orderDTO);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    @Override
    public void deletePizzas(long orderId) {
        try{
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement("delete from order_pizzas where order_id = ?");
            preparedStatement.setLong(1, orderId);
            preparedStatement.execute();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(long id) {
        try{
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement("delete from orders where id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteByClientId(long clientId) {
        try{
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement("delete from orders where client_id = ?");
            preparedStatement.setLong(1, clientId);
            preparedStatement.execute();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
