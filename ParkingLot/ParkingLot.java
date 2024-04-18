import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
public class ParkingLot{
private Map<VehicleType, Queue<ParkingSpot>> availableSpot; ;
private Map<VehicleType, HashSet<ParkingSpot>> unAvailableSpot; 
    public ParkingLot(){
        this.availableSpot = new HashMap<>();
        this.unAvailableSpot = new HashMap<>();
        for(VehicleType type : VehicleType.values()){
            availableSpot.put(type, new LinkedList<>());
        }
        for (VehicleType type : VehicleType.values()) {
            unAvailableSpot.put(type, new HashSet<>());
        }
    }
    public ParkingSpot getParkingSpot(Vehicle vehicle){
        VehicleType vehicleType = vehicle.getVehicleType();
        if(availableSpot.get(vehicleType).isEmpty()){
            return null;
        }
        ParkingSpot parkingSpot = availableSpot.get(vehicleType).poll();
        unAvailableSpot.get(vehicleType).add(parkingSpot);
        return parkingSpot;
    }
    public ParkingTicket issueTicket(ParkingSpot parkingSpot, Vehicle vehicle){
        if(parkingSpot == null){
            System.out.println("No Space Available for " + vehicle.getVehicleID());
            return null;
        }
        System.out.println("Ticket issued to " + vehicle.getVehicleID());
        ParkingTicket parkingTicket = new ParkingTicket(vehicle, parkingSpot, LocalDateTime.now());
        return parkingTicket;
    }
    public double calculateFee(ParkingTicket ticket){
        return ticket.getFee(LocalDateTime.now());
    }
    public void processPayment(ParkingTicket ticket){
        ticket.getFee(LocalDateTime.now());
        //receive payment
        ticket.markPaid();
        //remove from unAvailableSpot and push back to availableSpot
        ParkingSpot parkingSpot = ticket.getParkingSpot();
        unAvailableSpot.get(ticket.getVehicle().getVehicleType()).remove(parkingSpot);
        availableSpot.get(ticket.getVehicle().getVehicleType()).add(parkingSpot);
    }
    public void addNewParkingSpot(ParkingSpot parkingSpot){
        availableSpot.get(parkingSpot.getVehicleType()).add(parkingSpot);
    }
    public void removeParkingSpot(ParkingSpot parkingSpot){
        //won't be able to easily remove thus this design is a failure
    }
    public void printUnavailableSpots() { //THIS METHOD IS IMPLEMENTED ONLY FOR TEST
        // Iterate over each entry in the map
        for (Map.Entry<VehicleType, HashSet<ParkingSpot>> entry : unAvailableSpot.entrySet()) {
            VehicleType type = entry.getKey();
            HashSet<ParkingSpot> spots = entry.getValue();

            // Print the vehicle type if there are some non-available spots
            if(!unAvailableSpot.get(type).isEmpty())
            System.out.println("Vehicle Type: " + type);

            // Print each parking spot in the HashSet
            for (ParkingSpot spot : spots) {
                System.out.println("=====>Parking Spot: " + spot.getID());
            }
        }
    }
}

