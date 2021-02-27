package station.pizza.service.impl;

import station.pizza.dao.PizzaDAO;
import station.pizza.dao.impl.PizzaDAOImpl;
import station.pizza.model.Pizza;
import station.pizza.service.PizzaService;

import java.util.List;

public class PizzaServiceImpl implements PizzaService {

    @Override
    public List<Pizza> findAll() {
        final PizzaDAO pizzaDAO = new PizzaDAOImpl();
        return pizzaDAO.findAll();
    }
}
