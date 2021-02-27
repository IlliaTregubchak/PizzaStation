package station.pizza.dao;

import station.pizza.dto.orders.OrderDTO;
import station.pizza.dto.orders.SaveOrderDTO;
import station.pizza.dto.orders.SaveOrderPizzasDTO;
import station.pizza.dto.orders.UpdateOrderDTO;

import java.util.List;

public interface OrderDAO {

    long save(SaveOrderDTO saveOrderDTO);

    void savePizza(long orderId, long pizzaId, int count);

    void updateStatus(long statusId, long orderId);

    void updateOrder(UpdateOrderDTO updateOrderDTO, long orderId);

    List<OrderDTO> findAll();

    void deletePizzas(long orderId);

    void delete(long id);

    void deleteByClientId(long clientId);
}
