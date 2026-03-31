import java.util.HashMap;
import java.util.Map;
public class BookMyStayApp {
    static abstract class Room{
        protected int numberofbeds;
        protected int squareFeet;
        protected double pricepernight;

        public Room(int numberofbeds,int squareFeet,double pricepernight){
            this.numberofbeds=numberofbeds;
            this.squareFeet=squareFeet;
            this.pricepernight=pricepernight;
        }
        public void displayroomdetails(){
            System.out.println("Beds: "+numberofbeds);
            System.out.println("Size: "+squareFeet+"sqft");
            System.out.println("Price: "+pricepernight);
        }

    }
    static class singleroom extends Room{
        public singleroom(){
            super(1,250,1500);
        }
    }
    static class doubleroom extends Room{
        public doubleroom(){
            super(2,400,2500);
        }
    }
    static class suiteroom extends Room{
        public suiteroom(){
            super(3,750,5000);
        }
    }
    static class RoomInventory{
        private Map<String,Integer> roomAvailability;
        public RoomInventory(){
            initializeInventory();
        }
        public void initializeInventory(){
            roomAvailability=new HashMap<>();
            roomAvailability.put("Single",5);
            roomAvailability.put("Double",3);
            roomAvailability.put("Suite",2);
        }
        public Map<String,Integer> getRoomAvailability(){
            return roomAvailability;
        }
        public void updateroomAvailability(String roomType,int count){
            roomAvailability.put(roomType,count);
        }
    }
    public static void main(String[] args){
        System.out.println("Hotel Room Inventory Status:");

        RoomInventory inventory=new RoomInventory();

        Room single=new singleroom();
        Room doubleRoom=new doubleroom();
        Room suite=new suiteroom();

        System.out.println("Single room:");
        single.displayroomdetails();
        System.out.println("Availability:"+inventory.getRoomAvailability().get("Single"));

        System.out.println("\n");

        System.out.println("Double room:");
        doubleRoom.displayroomdetails();
        System.out.println("Availability:"+inventory.getRoomAvailability().get("Double"));
        System.out.println("\n");

        System.out.println("Suite room:");
        suite.displayroomdetails();
        System.out.println("Availability:"+inventory.getRoomAvailability().get("Suite"));

    }
}
