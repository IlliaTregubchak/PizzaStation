package station.pizza.service.impl;

import station.pizza.dao.OrderDAO;
import station.pizza.dao.impl.OrderDAOImpl;
import station.pizza.dto.orders.*;
import station.pizza.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO;
        // статична ініціалізація
    {
        orderDAO = new OrderDAOImpl();
    }

    @Override
    public long save(SaveOrderDTO saveOrderDTO) {
        return orderDAO.save(saveOrderDTO);
    }

    @Override
    public void savePizzas(SaveOrderPizzasDTO saveOrderPizzasDTO) {
        //
        final List<PizzaOrderDTO> pizzas = saveOrderPizzasDTO.getPizzas();
        for (PizzaOrderDTO pizza : pizzas) {
            orderDAO.savePizza(saveOrderPizzasDTO.getOrderId(), pizza.getPizzaId(), pizza.getCount());
        }
    }

    @Override
    public void updateStatus(long statusId, long orderId) {
        orderDAO.updateStatus(statusId, orderId);
    }

    @Override
    public void updateOrder(UpdateOrderDTO updateOrderDTO, long orderId) {
        orderDAO.updateOrder(updateOrderDTO, orderId);
    }

    @Override
    public void delete(long id) {
        // порядок виконання перенесено на бізнес-логіку
        // id у нас співпадає
        orderDAO.deletePizzas(id);
        orderDAO.delete(id);
    }

    @Override
    public List<OrderDTO> findAll() {
        return orderDAO.findAll();
    }


}
