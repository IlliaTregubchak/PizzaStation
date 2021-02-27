package station.pizza.dto.orders;

import java.util.List;

public class SaveOrderPizzasDTO {
    private long orderId;
    private List<PizzaOrderDTO> pizzas;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public List<PizzaOrderDTO> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<PizzaOrderDTO> pizzas) {
        this.pizzas = pizzas;
    }
}

