class Main{
    public static void main(String []args){
        ParkingLot parkingLot = new ParkingLot();
        ParkingSpot p1 = new ParkingSpot("1", VehicleType.COMPACT, 1);
        ParkingSpot p2 = new ParkingSpot("2", VehicleType.LARGE, 0);
        ParkingSpot p3 = new ParkingSpot("3", VehicleType.COMPACT, 1);
        parkingLot.addNewParkingSpot(p1);
        parkingLot.addNewParkingSpot(p2);
        // 1st vehicle comes of type compact
        Vehicle v1 = new Vehicle("ve1", VehicleType.COMPACT);
        ParkingSpot parkingSpot = parkingLot.getParkingSpot(v1);
        if(parkingSpot != null){
            parkingLot.issueTicket(parkingSpot, v1);
        }
        parkingLot.printUnavailableSpots();
        Vehicle v2 = new Vehicle("ve2", VehicleType.COMPACT);
        ParkingSpot parkingSpot2 = parkingLot.getParkingSpot(v2);
        if(parkingSpot != null){
            parkingLot.issueTicket(parkingSpot2, v2);
        }
        parkingLot.printUnavailableSpots();
        parkingLot.addNewParkingSpot(p3);
        Vehicle v3 = new Vehicle("ve3", VehicleType.COMPACT);
        ParkingSpot parkingSpot3 = parkingLot.getParkingSpot(v3);
        if(parkingSpot != null){
            parkingLot.issueTicket(parkingSpot3, v3);
        }
        parkingLot.printUnavailableSpots();
    }
}