import java.lang.reflect.Constructor;

class Equipment {
    private String id;
    private String name;
    private int availableCount;

    Equipment(String id,String name, int availableCount){
        this.id = (id == null||id.trim().isEmpty())?"Unknown":id ;
        this.name = (name == null ||name.trim().isEmpty())?"Unknown":name;
        this.availableCount = Math.max(availableCount,0);
    }
    
    public boolean borrowOne(){
        if(availableCount >0){
            this.availableCount--;
            return true;
        }else{
            return false;
        }
    }
    public void returnItems(int quantity){
        if(quantity >0){
            this.availableCount += quantity;
        }
    }
    public String toString(){
        return "設備編號: "+id +"名稱"+name +"可借數量"+availableCount;

    }
}
public class EquipmentInventory {
    public static void main(String[] args){
        Equipment eq1 = new Equipment("123456789","手機",2);
        Equipment eq2 = new Equipment("0000123","電腦",-3);

        System.out.println(eq1);
        System.out.println(eq2);
        System.out.println("手機的借結果為:");
        System.out.println(eq1.borrowOne()?"成功":"失敗");
        System.out.println("電腦的借結果為:");
        System.out.println(eq2.borrowOne()?"成功":"失敗");
        System.out.println("歸還5個手機");
        eq1.returnItems(5);

        System.out.println(eq1);
        System.out.println(eq2);
    }
}
