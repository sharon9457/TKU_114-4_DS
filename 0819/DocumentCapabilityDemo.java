interface Compressible{
    void compress();
}
interface Exportable{
    void export();
}
class BackupDocument implements Compressible,Exportable{
    private String name;

    public BackupDocument(String name){
        this.name = name;
    }

    public void compress(){
        System.out.println("壓縮"+name);
    }
    public void export(){
        System.out.println("匯出:"+name);
    }
}

public class DocumentCapabilityDemo {
    public static void main(String[] args) {
        BackupDocument x = new BackupDocument("迷因大全.pdf");
        Compressible tocompressible = x;
        Exportable toexportable =x;   
        
        tocompressible.compress();
        toexportable.export();
        if(tocompressible==toexportable){
            System.out.print("成功");
        }       

    }
}
