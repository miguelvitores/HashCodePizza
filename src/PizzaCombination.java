import java.util.ArrayList;
import java.util.List;

public class PizzaCombination {
    private int slices;
    private List<Integer> pizzaTypes;

    public PizzaCombination(){
        pizzaTypes = new ArrayList<>();
        slices = 0;
    }

    public int getSlices() {
        return slices;
    }

    public List<Integer> getPizzaTypes() {
        return pizzaTypes;
    }

    public void setPizzaTypes(List<Integer> pizzaTypes) {
        this.pizzaTypes = pizzaTypes;
    }

    public void addPizzaTypes(int pizzaType) {
        this.pizzaTypes.add(pizzaType);
    }

    public void setSlices(int slices) {
        this.slices = slices;
    }

    public void addSlices(int slices) {
        this.slices += slices;
    }
}
