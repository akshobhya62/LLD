public class ParkingSpot{
    private String id;
    private int floorNumber;
    private VehicleType vehicleType;
    private boolean isOccupied;
    public ParkingSpot(String id, VehicleType vehicleType, int floorNumber){
        this.id = id;
        this.vehicleType = vehicleType;
        this.floorNumber = floorNumber;
        this.isOccupied = false;
    }
    public void occupySpot(){
        this.isOccupied = true;
    }
    public void freeSpot(){
        this.isOccupied = false;
    }
    public int getFloorNumber(){
        return this.floorNumber;
    }
    public VehicleType getVehicleType(){
        return this.vehicleType;
    }
    public boolean isOccupied(){
        return this.isOccupied;
    }
    public String getID(){
        return this.id;
    }
}

