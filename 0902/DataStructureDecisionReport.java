public class DataStructureDecisionReport {
    enum Requirement{ARRAYLIST,QUEUE,BST,HEAP
        ,HEASHMAP,GRAPH_LIST,FIFO,LIFO,SORTED_RANGE
        ,NEXT_PRIORITY,KEY_LOOPUP,RANDOM_ACCESS}
        static String choose(Requirement requirement){
            if(requirement == null) return "UNKNOWN";
            return switch(requirement){
                case ARRAYLIST -> "index access,O(1)";
               case QUEUE ->"固定端操作,O(1)";
               case BST ->"排序與range,O(log n)";
               case HEAP ->"取極值,O(log n)";
               case HEASHMAP ->"key lookup,O(1)";
               case GRAPH_LIST ->"關係走訪,O(V+E)";
               case FIFO -> "排隊,QUEUE,O(1)";
               case LIFO ->"上下頁,stack(只操作最新資料),O(1)";
               case SORTED_RANGE->"保持資料排序，並頻繁進行區間範圍查詢,Balanced BST,可快速限縮範圍,O(logN)";
               case NEXT_PRIORITY->"Heap/PriorityQueue";
               case KEY_LOOPUP->"可快速查詢資料,HashMap,透過Hash函數計算記憶體位置，所以不用遍歷資料,O(1)";
               case RANDOM_ACCESS->"頻繁查詢第K個元素,Dynamic Array,直接進行記憶體偏移,O(1)";
                        };
        }       
        public static void main(String[] args) {
            for(Requirement requirement:Requirement.values()){
                System.out.println(requirement+"->"+choose(requirement));
            }
            System.out.println(choose(null));
        }
    }
