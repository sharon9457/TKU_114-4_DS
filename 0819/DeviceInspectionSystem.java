abstract class Device{
    protected String deviceId;
Device(String deviceId){
    this.deviceId = deviceId;
}
public abstract void runDiagonstic();
}
class Laptop extends Device{
    public Laptop(String deviceId){
        super(deviceId);
        }
        public void runDiagonstic(){
            System.out.println("Laptop"+deviceId);
        }
    }
class Printer extends Device{
    public Printer(String deviceId){
        super(deviceId);
    }
    public void runDiagonstic(){
        System.out.println("printer"+deviceId);
    }
    public void cleanPrintHead(){
        System.out.println("清潔");
    }
}
class Router extends Device{
    public Router (String dviceid){
        super(dviceid);
    }
    public void runDiagonstic(){
        System.out.println("router"+deviceId);
    }
}
class Devicess extends Device{
    public Devicess (String deviceid){
        super(deviceid);
    }
    public void runDiagonstic(){
        System.out.println("device"+deviceId);
    }
}
public class DeviceInspectionSystem {
    public static void main(String[] args) {      
    
    Device[] devices = new Device[]{
        new Laptop("aa-001"),
        new Printer("bb-002"),
        new Router("cc-003"),
        new Devicess("dd-004")
    };    
    for(int i =0;i<devices.length;i++){
        devices[i].runDiagonstic();

        if(devices[i] instanceof Printer p){
            p.cleanPrintHead();
        }
    }
}
}