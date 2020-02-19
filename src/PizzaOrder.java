import java.util.ArrayList;

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
        int[] i;
        i = findBestFirstPair();
        typesOfPizzaOrder.add(0, i[0]);
        typesOfPizzaOrder.add(0, i[1]);
        int iy = i[1]-1;
        int currentSlices = slicesInEachType[i[0]] + slicesInEachType[i[1]];
        while( iy!=-1 ){
            int possibleSlices = currentSlices + slicesInEachType[iy];
            if(possibleSlices <= maxSlicesToOrder){
                currentSlices = possibleSlices;
                typesOfPizzaOrder.add(0, iy);
            }
            iy--;
        }
        slicesToOrder = currentSlices;
    }

    private int[] findBestFirstPair(){
        int[] bestPair = {0, 1};
        int max = 0;
        int ix, iy;
        ix = numDifferentTypes - 1;
        while(ix > numDifferentTypes/2){
            iy = ix-1;
            while(iy > -1){
                int sum = slicesInEachType[ix] + slicesInEachType[iy];
                if(sum <= maxSlicesToOrder && sum > max){
                    bestPair[0] = ix;
                    bestPair[1] = iy;
                    max = sum;
                    iy = 0;
                }
                iy--;
            }
            ix--;
        }
        return bestPair;
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
