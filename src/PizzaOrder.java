import java.util.ArrayList;
import java.util.List;

public class PizzaOrder {

    private final int maxSlicesToOrder;
    private final int numDifferentTypes;
    private final int[] slicesInEachType;
    private ArrayList<Integer> typesOfPizzaOrder;
    private int slicesToOrder;

    public PizzaOrder(int maxSlicesToOrder, int[] slicesInEachType){
        this.maxSlicesToOrder = maxSlicesToOrder;
        this.slicesInEachType = slicesInEachType;
        numDifferentTypes = slicesInEachType.length;
        typesOfPizzaOrder = new ArrayList<>();
    }


    public void generateOrder(){
        int iRoot = slicesInEachType.length - 1;
        PizzaCombination pizzaCombination, bestPizzaCombination = new PizzaCombination();
        do{
            pizzaCombination = findBestCombination(iRoot);
            if(pizzaCombination.getSlices() > bestPizzaCombination.getSlices()){
                bestPizzaCombination = pizzaCombination;
            }
            iRoot--;
        } while(iRoot > slicesInEachType.length/2 || bestPizzaCombination.getSlices() == maxSlicesToOrder);
        typesOfPizzaOrder.addAll(bestPizzaCombination.getPizzaTypes());
        slicesToOrder = bestPizzaCombination.getSlices();
    }

    private PizzaCombination findBestCombination(int iRoot){
        PizzaCombination comb = new PizzaCombination();
        int currentSlices = slicesInEachType[iRoot];
        int maxSlices = 0;
        while( index >= 0 ) {
            findChildRecursive(iRoot - 1, currentSlices, maxSlices, comb);
        }
        return comb;
    }

    private int findChildRecursive(int index, int currentSlices, int maxSlices, PizzaCombination comb){

            int possibleSlices = currentSlices + slicesInEachType[index];
            if(possibleSlices <= maxSlicesToOrder){
                currentSlices = possibleSlices;
                combAux.add(0, index);
                if(currentSlices > maxSlices){
                    comb.clear();
                    maxSlices = currentSlices;
                    comb.addAll(combAux);
                    combAux.clear();
                }
                findChildRecursive(index-1, currentSlices, maxSlices, combAux);
            }
            index--;
    }

    private int getSlicesFromCombination(List<Integer> comb){
        int combSlices = 0;
        for(int p : comb){
            combSlices += slicesInEachType[p];
        }
        if(combSlices > maxSlicesToOrder)
            return -1;
        return combSlices;
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

    public int getSlicesToOrder() {
        return slicesToOrder;
    }

    public int getMaxSlicesToOrder() {
        return maxSlicesToOrder;
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
