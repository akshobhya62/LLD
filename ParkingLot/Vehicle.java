public class Vehicle{
    private String vehicleID;
    private VehicleType vehicleType;
    public Vehicle(String vehicleID, VehicleType vehicleType){
        this.vehicleID = vehicleID;
        this.vehicleType = vehicleType;
    }
    public VehicleType getVehicleType(){
        return this.vehicleType;
    }
    public String getVehicleID(){
        return this.vehicleID;
    }
}

