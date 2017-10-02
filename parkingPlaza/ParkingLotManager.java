package parkingPlaza;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ParkingLotManager { // 
	    private final ParkingLot parkingLot;
	    String[] AutomobileTypes = { "Truck", "Car", "Bus" };

	    public ParkingLotManager(int numberOfSlots) {
	        parkingLot = new ParkingLot(numberOfSlots);
	    }

	    public static void main(String[] args) {
	        int numberOfSlots = 10;// the number of slots 
	        int numberOfIterations = 3;// number of iteratons
	        new ParkingLotManager(numberOfSlots).start(numberOfIterations); //the main go through the number of iterations
	    }

	    private void start(int numberOfIterations) {
	        List<Ticket> tickets = new ArrayList<>();
	        Random random = new Random();
	        for (int i = 0; i < numberOfIterations; i++) {
	            int nextInt = random.nextInt(1 + tickets.size());
	            if (nextInt > tickets.size() * 2 / 3) {
	                parkingLot.unparkAutomobile(tickets.remove(random.nextInt(tickets.size())));
	            } else {
	                try {
	                    parkNewAutomobile(tickets, i);
	                } catch (Exception e) {
	                    System.out.println("Automobile not parked: "+e.getMessage());
	                }
	            }
	            System.out.println(parkingLot);
	        }
	    }

	    private void parkNewAutomobile(List<Ticket> tickets, int i) {
	        String AutomobileType = AutomobileTypes[new Random().nextInt(AutomobileTypes.length)];
	        int spacesNeeded = 1 + Arrays.asList(AutomobileTypes).indexOf(AutomobileType);
	        double priceFactor = 0.2 + (0.2 * spacesNeeded);
	        tickets.add(parkingLot.parkAutomobile(new Automobile(AutomobileType, i, spacesNeeded, priceFactor)));
	    }
}
