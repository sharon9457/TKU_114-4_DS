import java.util.Arrays;

interface  ReportExporter{
    void export(String title , int[] values);
}
class CsvExporter implements ReportExporter{
    public void export(String title,int[] values){
        StringBuilder sb = new StringBuilder(title);
        if(values != null){
                for(int v : values){
                    sb.append(",").append(v);
                }
            }
            System.out.println(sb.toString());
        }}
            class JsonExporter implements ReportExporter{
                public void export(String title,int[] values){
                String vals = (values == null)?"null":Arrays.toString(values);

            }
        }
        class TextExporter implements ReportExporter{
            public void export(String title ,int[] values){
                String vals = (values == null) ?"無資料":Arrays.toString(values);
                System.out.println("標題:"+title+"數值"+vals);
            }
        }
        public class ReportExporterFactory{
            public static ReportExporter createExporter(String format){
                if(format == null){
                    return new TextExporter();
                }
                switch(format.toLowerCase()){
                    case "csv":
                        return new CsvExporter();
                    case "json":
                        return new JsonExporter();
                   case "text":
                    default:
                        return new TextExporter();
                }
            }
            public static void exportReport(ReportExporter exporter,String title,int[] values){
                exporter.export(title,values);
            }
            public static void main(String[] args) {
                int[] data = {100,200,300};
                int[] nulldata = null;
                ReportExporter CsvExporter = createExporter("csv");
                exportReport(CsvExporter, "年收", data);
                ReportExporter jsonExporter = createExporter("json");
                exportReport(jsonExporter, "年收", data);
                 

            }
        }
    




