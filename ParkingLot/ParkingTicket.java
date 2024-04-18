import java.time.LocalDateTime;
public class ParkingTicket{
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private ParkingSpot parkingSpot;
    private double fee;
    private Vehicle vehicle;
    private boolean isPaid;

    public ParkingTicket(Vehicle vehicle, ParkingSpot parkingSpot, LocalDateTime checkIn){
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.checkIn = checkIn;
        this.isPaid = false;
    }
    public double getFee(LocalDateTime checkOut){
        this.checkOut = checkOut;
        this.fee = FeeCalculator.calculateFee(this.checkIn, this.checkOut, this.vehicle.getVehicleType());
        return this.fee;
    }
    public void markPaid(){
        this.isPaid = true;
    }
    public boolean IsPaid(){
        return this.isPaid;
    }
    public ParkingSpot getParkingSpot(){
        return this.parkingSpot;
    }
    public Vehicle getVehicle(){
        return this.vehicle;
    }
}

