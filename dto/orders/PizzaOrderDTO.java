package station.pizza.dto.orders;

public class PizzaOrderDTO {
    private long pizzaId;
    private int count;

    public PizzaOrderDTO(long pizzaId, int count) {
        this.pizzaId = pizzaId;
        this.count = count;
    }

    public long getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(long pizzaId) {
        this.pizzaId = pizzaId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
