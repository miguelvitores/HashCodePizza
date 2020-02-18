import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PizzaPTReader {

    private String path;
    private String plainText="";
    private PizzaOrder pizzaOrder;

    public PizzaPTReader(String path){
        if(path != null){
            this.path = path+".in";
        }
    }

    public void read(){
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            int maxSlices, diffTypes;
            int[] slicesEachType;
            String line = br.readLine();
            plainText = plainText.concat(line+"\n");
            maxSlices = Integer.parseInt(line.split(" ")[0]);
            diffTypes = Integer.parseInt(line.split(" ")[1]);
            slicesEachType = new int[diffTypes];
            line = br.readLine();
            plainText = plainText.concat(line);
            for(int i=0; i<diffTypes; i++){
                int slicesFromAType = Integer.parseInt(line.split(" ")[i]);
                slicesEachType[i] = slicesFromAType;
            }
            pizzaOrder = new PizzaOrder(maxSlices, slicesEachType);

        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public String getPlainText() {
        return plainText;
    }

    public PizzaOrder getPizzaOrder() {
        return pizzaOrder;
    }

}
