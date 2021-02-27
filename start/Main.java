package station.pizza.start;

import station.pizza.config.DatabaseConfig;
import station.pizza.dto.clients.EditClientDTO;
import station.pizza.dto.orders.*;
import station.pizza.model.Pizza;
import station.pizza.service.ClientService;
import station.pizza.service.OrderService;
import station.pizza.service.PizzaService;
import station.pizza.service.impl.ClientServiceImpl;
import station.pizza.service.impl.OrderServiceImpl;
import station.pizza.service.impl.PizzaServiceImpl;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        DatabaseConfig.connect();

       // ЗАМОВЛЕННЯ 3-Х ПІЦ ПО-ОДНІЙ

        // 1. Save client (звонить кліент, номер телефону відображується, знижка за замовчуванням 0, питаємо як звати)

        // 2. Save order (клієнт хоче 3 піцци, запитуємо preferences, price - загальна ціна,
        //  це сума піц - знижка, якщо вона не 0, запитуємо адресу і на який час доставити,
        //  client_id - це результат виконання пункту 1, status_id 1 - "НА ОФОРМЛЕННІ" за замовчуванням)

        // 3. Save order_pizzas (order_id - це результат пункту 2, pizza_id - це та піцца, яку він вказав першою,
        // count - це та кількість, яку вказав клієнт(1) )

        // 4. Save order_pizzas (order_id - це результат пункту 2, pizza_id - це та піцца, яку він вказав другою,
        // count - це та кількість, яку вказав клієнт (1))

        // 5. Save order_pizzas (order_id - це результат пункту 2, pizza_id - це та піцца, яку він вказав третьою,
        // count - це та кількість, яку вказав клієнт (1))

        // !!! Кожна піца, яку замовив клієнт за 1 order буде записуватися в БД окремо із тим же самим order_id

        final ClientService clientService = new ClientServiceImpl();
//        final EditClientDTO editClientDTO = new EditClientDTO();
//
//        editClientDTO.setName("Boris");
//        editClientDTO.setPhone("0445678802");
//        editClientDTO.setDiscount(0);
//
//        final long clientId = clientService.save(editClientDTO);
//
//        System.out.println(clientId);

        /////////////////////////////////////


//        final PizzaService pizzaService = new PizzaServiceImpl();
//        final List<Pizza> pizzas = pizzaService.findAll();
//
        final OrderService orderService = new OrderServiceImpl();
//        final SaveOrderDTO saveOrderDTO = new SaveOrderDTO();
//
//        saveOrderDTO.setPreferences("No pepper");
//        saveOrderDTO.setPrice(pizzas.stream().mapToDouble(Pizza::getPrice).sum());
//        saveOrderDTO.setDeliveryTime("18:45");
//        saveOrderDTO.setAddress("Main Street 56");
//        saveOrderDTO.setClientId(clientId);
//        saveOrderDTO.setStatusId(1);

        // метод приймає обєкт, але повертає orderId
//        final long orderId = orderService.save(saveOrderDTO);
//        System.out.println(orderId);


        //////////////////////////////////

//        List<PizzaOrderDTO> orderedPizzas = new LinkedList<>();
//        orderedPizzas.add(new PizzaOrderDTO(1, 1));
//        orderedPizzas.add(new PizzaOrderDTO(2, 1));
//        orderedPizzas.add(new PizzaOrderDTO(3, 1));
//        orderedPizzas.add(new PizzaOrderDTO(3, 1));
//
//        final SaveOrderPizzasDTO saveOrderPizzasDTO = new SaveOrderPizzasDTO();
//        saveOrderPizzasDTO.setOrderId(orderId);
//        saveOrderPizzasDTO.setPizzas(orderedPizzas);
//
//        orderService.savePizzas(saveOrderPizzasDTO);
        ///////////////////////////////////////////

//        orderService.updateStatus(4, 1);

//        final List<OrderDTO> orders = orderService.findAll();
//
//        for (OrderDTO elem : orders) {
//            System.out.println(elem.toString());
//        }

//        final UpdateOrderDTO updateOrderDTO = new UpdateOrderDTO();
//        updateOrderDTO.setPreferences("no tomatoes");
//        updateOrderDTO.setPrice(149.99);
//        updateOrderDTO.setDeliveryTime("21:45");
//        updateOrderDTO.setAddress("Main Str 38");
//        orderService.updateOrder(updateOrderDTO, 2);

//        orderService.delete(2);

        clientService.delete(13);

        DatabaseConfig.close();
    }

}
