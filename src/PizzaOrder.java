import java.util.ArrayList;

public class PizzaOrder {

    private final int maxSlicesToOrder;
    private final int numDifferentTypes;
    private final int[] slicesInEachType;
    private ArrayList<Integer> typesOfPizzaOrder;

    public PizzaOrder(int maxSlicesToOrder, int[] slicesInEachType){
        this.maxSlicesToOrder = maxSlicesToOrder;
        this.slicesInEachType = slicesInEachType;
        numDifferentTypes = slicesInEachType.length;
        typesOfPizzaOrder = new ArrayList<>();
    }


    public void generateOrder(){
        int index = numDifferentTypes - 1;
        int currentSlices = 0;
        while( index!=-1 ){

            int possibleSlices = currentSlices + slicesInEachType[index];
            if(possibleSlices <= maxSlicesToOrder){
                currentSlices = possibleSlices;
                typesOfPizzaOrder.add(0, index);
            }
            index--;
        }
    }

    public int[] getSlicesInEachType() {
        return slicesInEachType;
    }

    public String slicesInEachTypeToString() {
        String siet="";
        for(int i=0; i<numDifferentTypes-1; i++){
            siet = siet.concat(String.valueOf(slicesInEachType[i])+", ");
        }
        siet = siet.concat(String.valueOf(slicesInEachType[numDifferentTypes-1]));
        return siet;
    }

    public ArrayList<Integer> getTypesOfPizzaOrder() {
        return typesOfPizzaOrder;
    }

    public String typesOfPizzaOrderToString() {
        String out="";
        int numTypesOut = typesOfPizzaOrder.size();
        for(int i=0; i<numTypesOut-1; i++){
            out = out.concat(String.valueOf(typesOfPizzaOrder.get(i))+" ");
        }
        out = out.concat(String.valueOf(typesOfPizzaOrder.get(numTypesOut-1)));
        return out;
    }

    @Override
    public String toString() {
        return "Max slices: "+maxSlicesToOrder+"; slices in each type: ["+slicesInEachTypeToString()+"]";
    }
}
