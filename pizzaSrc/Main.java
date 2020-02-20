import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static final String dir = "./Practice/";

    public static void main(String[] args){

        System.out.print("Write a filename from practice directory without extension: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            long to = System.currentTimeMillis();
            String file = br.readLine();
            String relPath = dir+file;
            PizzaPTReader pizzaPTReader = new PizzaPTReader(relPath);
            pizzaPTReader.read();
            PizzaOrder pizzaOrder = pizzaPTReader.getPizzaOrder();
            String plainText = pizzaPTReader.getPlainText();
            System.out.println("Plain text: \n"+plainText);
            System.out.println(pizzaOrder.toString());
            pizzaOrder.generateOrder();
            System.out.println("Types of pizza order: "+pizzaOrder.getTypesOfPizzaOrder().toString());
            relPath = dir+file;
            PizzaPTWriter pizzaPTWriter = new PizzaPTWriter(relPath, pizzaOrder);
            pizzaPTWriter.write();
            System.out.println("Pizzas ordered to "+relPath+".out");
            long tMillis = System.currentTimeMillis() - to;
            System.out.println(tMillis+"ms time spent");

        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}
