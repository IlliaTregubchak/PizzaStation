package station.pizza.dao.impl;

import station.pizza.config.DatabaseConfig;
import station.pizza.dao.PizzaDAO;
import station.pizza.model.Pizza;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class PizzaDAOImpl implements PizzaDAO {

    private final String SELECT_ALL_PIZZAS = "select * from pizzas";

    @Override
    public List<Pizza> findAll() {
        
        List<Pizza> pizzas = new LinkedList<>();
        try{
            final Connection connection = DatabaseConfig.connection;
            final Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery(SELECT_ALL_PIZZAS);
            while (resultSet.next()) {
                final long id = resultSet.getLong("id");
                final String name = resultSet.getString("name");
                final String ingredients = resultSet.getString("ingredients");
                final double price = resultSet.getDouble("price");
                
                Pizza pizza = new Pizza();
                pizza.setId(id);
                pizza.setName(name);
                pizza.setIngredients(ingredients);
                pizza.setPrice(price);
                
                pizzas.add(pizza);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return pizzas;
    }
}
