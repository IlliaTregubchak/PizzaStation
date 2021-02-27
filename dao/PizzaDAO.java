package station.pizza.dao;

import station.pizza.model.Pizza;

import java.util.List;

public interface PizzaDAO {

    List<Pizza> findAll();
}
