import java.io.FileWriter;
import java.io.IOException;

public class PizzaPTWriter {
    private String path;
    private PizzaOrder pizzaOrder;

    public PizzaPTWriter(String path, PizzaOrder pizzaOrder){
        if(path != null){
            this.path = path+".out";
            this.pizzaOrder = pizzaOrder;
        }
    }

    public void write(){
        try {

            FileWriter fw = new FileWriter(path, false);
            String numTypesOut = String.valueOf(pizzaOrder.getTypesOfPizzaOrder().size());
            String typesOfPizzaChosen = pizzaOrder.typesOfPizzaOrderToString();
            fw.write(numTypesOut+"\n"+typesOfPizzaChosen);
            fw.close();

        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}
