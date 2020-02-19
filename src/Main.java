import java.io.*;

public class Main {
    public static final String DIR = "./Practice/";

    public static void main(String[] args) {

        long to = System.currentTimeMillis();
        File dir = new File(DIR);
        FilenameFilter inFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".in");
            }
        };
        File[] inFiles = dir.listFiles(inFilter);
        int totalPoints = 0, maxPoints = 0;

        for (File f : inFiles) {
            String filename = f.getName().substring(0, f.getName().lastIndexOf("."));
            PizzaPTReader pizzaPTReader = new PizzaPTReader(DIR+filename);
            pizzaPTReader.read();
            PizzaOrder pizzaOrder = pizzaPTReader.getPizzaOrder();
            pizzaOrder.generateOrder();
            PizzaPTWriter pizzaPTWriter = new PizzaPTWriter(DIR+filename, pizzaOrder);
            pizzaPTWriter.write();
            System.out.println(filename+".out finished!");
            System.out.println(pizzaOrder.getSlicesToOrder()+" points");
            totalPoints += pizzaOrder.getSlicesToOrder();
            maxPoints += pizzaOrder.getMaxSlicesToOrder();
        }

        double efficiency = ((double)totalPoints / (double)maxPoints) * 100;
        System.out.println(efficiency);
        System.out.println("Total points: " + totalPoints+" of "+maxPoints+" max -> "+efficiency+"% efficiency");
        long tMillis = System.currentTimeMillis() - to;
        System.out.println(tMillis+"ms time spent");

//        System.out.print("Write a filename from practice directory without extension: ");
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        try {
//            long to = System.currentTimeMillis();
//            String file = br.readLine();
//            String relPath = dir+file;
//            PizzaPTReader pizzaPTReader = new PizzaPTReader(relPath);
//            pizzaPTReader.read();
//            PizzaOrder pizzaOrder = pizzaPTReader.getPizzaOrder();
//            String plainText = pizzaPTReader.getPlainText();
//            System.out.println("Plain text: \n"+plainText);
//            System.out.println(pizzaOrder.toString());
//            pizzaOrder.generateOrder();
//            System.out.println("Types of pizza order: "+pizzaOrder.getTypesOfPizzaOrder().toString());
//            relPath = dir+file;
//            PizzaPTWriter pizzaPTWriter = new PizzaPTWriter(relPath, pizzaOrder);
//            pizzaPTWriter.write();
//            System.out.println("Pizzas ordered to "+relPath+".out");
//            long tMillis = System.currentTimeMillis() - to;
//            System.out.println(tMillis+"ms time spent");
//
//        } catch (IOException ex){
//            System.out.println(ex.getMessage());
//        }
    }

}
