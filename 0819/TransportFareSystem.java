abstract class Transport{
    private String routeName;
    private int distance;

    Transport(String routeName,int daistance){
        this.routeName =routeName;
        this.distance = distance;
    }
        public String getrouteName(){
            return routeName;
        }
        public int getdistance(){
            return distance;
        }
    
    public abstract double calculatefare();
}
    class Bus extends Transport{
        public Bus(String routeName,int distance){
            super(routeName, distance);
        }
        
        public double calculatefare(){
            double baseFare = 20;
            if(getdistance() <=10){
                return baseFare;
            }else{
                return baseFare+(getdistance() -10)*5.0;
            }
        }
    }
    class Taxi extends Transport{
        public Taxi(String routeName,int distance){
            super(routeName,distance);
        }
        public double calculatefare(){
            double baseFare = 150;
            return baseFare + getdistance()*50;
        }
    }
public class TransportFareSystem {
    public static void main(String[] args){
        Transport[] transport = new Transport[]{
            new Taxi("001號路線",30),
            new Taxi("002號路線",35),
            new Bus ("001號公車",60),
            new Bus("002號公車",55)        
        };
        for(int x =0;x<transport.length;x++){
            System.out.println("名稱:"+ transport[x].getrouteName()+"價錢:"+transport[x].calculatefare());

        }
}}
