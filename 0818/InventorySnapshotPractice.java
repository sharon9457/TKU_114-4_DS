import java.util.Arrays;
final class InventorySnapshot{
    private final String warehouseId;
    private final int[] quantities;

    InventorySnapshot(String warehouseId,int[] quantities){
        this.warehouseId = warehouseId;
        if(quantities == null){
            this.quantities = new int[0];
        }else{
            this.quantities = Arrays.copyOf(quantities,quantities.length);
        }        
    }
    public String getWarehouseId(){
        return warehouseId;
    }
    public int[] getquantities(){
        return Arrays.copyOf(quantities,quantities.length);
    }
    public int totalQuantity(){
        int sum = 0;
        for(int q =0;q < quantities.length;q++){
            sum += q;
        }
        return sum;
    }
    public int outOfStockCount(){
        int count = 0;
        for(int q =0;q<quantities.length;q++){
           if(q == 0){
            count++;
           }
        }
        return count;
    }
}
public class InventorySnapshotPractice {
    public static void main(String[] args){
        int[] test = {5,0,3,0};
        InventorySnapshot snapshot = new InventorySnapshot("001", test);

        System.out.println("總數為:"+snapshot.totalQuantity());
        System.out.println("缺貨的商品為:"+snapshot.outOfStockCount());      

    }
}
