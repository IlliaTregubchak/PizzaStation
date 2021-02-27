package station.pizza.service;

import station.pizza.dto.orders.OrderDTO;
import station.pizza.dto.orders.SaveOrderDTO;
import station.pizza.dto.orders.SaveOrderPizzasDTO;
import station.pizza.dto.orders.UpdateOrderDTO;
import station.pizza.model.Order;

import java.util.List;

public interface OrderService {

    long save(SaveOrderDTO saveOrderDTO);

    void savePizzas(SaveOrderPizzasDTO saveOrderPizzasDTO);

    void updateStatus(long statusId, long orderId);

    void updateOrder(UpdateOrderDTO updateOrderDTO, long orderId);

    void delete(long id);

    List<OrderDTO> findAll();
}
