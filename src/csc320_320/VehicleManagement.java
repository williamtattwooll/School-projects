package csc320_320;
import java.util.*;

public class VehicleManagement {

    // variables to do
    public Map<Integer, String[]> vehicles = new HashMap<>();

    public VehicleManagement() {
        // we are using a map for each vehicle, build array and assign it
        String[] vehicleArray = new String[5];
        vehicleArray[0] = "Ford";
        vehicleArray[1] = "Truck";
        vehicleArray[2] = "black";
        vehicleArray[3] = "2020";
        vehicleArray[4] = "10000";
        vehicles.put(0, vehicleArray);
    } // init

    public String addVehicle(String[] vehicleArray) {
        try {
            // We need to put the new car in the first available slot
            // because maps don't re-index, and removeVehicle may have removed a key, loop until we find a blank
			int key = 0;
			while (vehicles.containsKey(key)) {
				key++;
			}
			vehicles.put(key, vehicleArray);
			int serialNum=key+1;
            return ("success for " + serialNum);
        } catch (NullPointerException e) {
            return ("There was an error with passed variables");
        }
    } // add

    public String listVehicle() {
        try {
            if (vehicles.isEmpty()) {
                return "No vehicles found.";
            }

            StringBuilder output = new StringBuilder();
            for (Map.Entry<Integer, String[]> entry : vehicles.entrySet()) {
                int displaySerial = entry.getKey() + 1;
                output.append("Serial #: ").append(displaySerial)
                      .append(" - ").append(Arrays.toString(entry.getValue()))
                      .append("\n");
            }
            return output.toString();

        } catch (RuntimeException e) {
            return "Something went wrong listing vehicles: " + e.getMessage();
        }
    } // list

    public String removeVehicle(int serialNum) {
        try {
            // zero index
            if (serialNum > 0) {
                serialNum = serialNum - 1;
            } else {
                return ("Serial Number must be greater then 0");
            }
            // only remove if valid
            if (vehicles.containsKey(serialNum)) {
                // Key exists in the map
                vehicles.remove(serialNum);
                return ("removed");
            } else {
                return ("vehicle not found");
            }
        } catch (NullPointerException e) {
            return ("vehicle not found");
        } // try
    } // remove

    public String updateVehicle(int serialNum, String[] newVehicleArray) {
        try {
            // Fix case-sensitivity typo
                        
            boolean updated = false;
            
            // Convert 1-based display serial number to 0-based map key
            if (serialNum > 0) {
                serialNum = serialNum - 1;
            } else {
                return "Serial Number must be greater then 0";
            }

            if (vehicles.containsKey(serialNum)) {
                // Retrieve existing vehicle data array
                String[] vehicleArray = vehicles.get(serialNum);

                // Compare and update provided non-null values
                for (int i = 0; i < 5; i++) {
                    if (newVehicleArray[i] != null && !newVehicleArray[i].trim().isEmpty() 
                            && !newVehicleArray[i].equalsIgnoreCase(vehicleArray[i])) {
                        vehicleArray[i] = newVehicleArray[i];
                        updated = true;
                    }
                }

                if (updated) {
                    vehicles.put(serialNum, vehicleArray);
                    return "vehicle updated";
                } else {
                    return "nothing updated";
                }
            } else {
                return "vehicle not found";
            }

        } catch (NullPointerException e) {
            return "vehicle or detail not found";
        }
    } // update

    public static void main(String[] args) {
        try {
            String menu = """
            1. list vehicles:
            2. add vehicle:
            3. remove vehicle:
            4. update vehicle:
            5. Quit:
            """;
            // will loop through these when getting variables for the moethods
            String[] detailsArray = {"make", "model", "color", "year", "mileage"};
            int serialNum = 0;
            //to choose from menu
         Scanner menuChoice = new Scanner(System.in);
            String choice;
            boolean doMore = true;
            //to hold values of variables.
            String methodVar = "";
            String[] vehicleArray = new String[5];
            VehicleManagement vehicles = new VehicleManagement();
            
            while (doMore) {
                vehicleArray = new String[5];
                System.out.println(menu);
                choice = menuChoice.nextLine();
                switch (choice) {
                    case "1": {
                        System.out.println(vehicles.listVehicle());
                        break;
                    } //case 1
                    case "2": {
                        for (int i = 0; i < 5; i++) {
                            System.out.println("Ente a value for " + detailsArray[i]);
                            methodVar = menuChoice.nextLine();
                            vehicleArray[i] = methodVar;
                        } //for
                        System.out.println(vehicles.addVehicle(vehicleArray));
                        break;
                    } //case 2
                    case "3": {
                        System.out.println("enter the serial number of the vehicle to remove:");
                        methodVar = menuChoice.nextLine();
                        serialNum = Integer.parseInt(methodVar);
                        System.out.println(vehicles.removeVehicle(serialNum));
                        break;
                    } //case 3
                    case "4": {
                        System.out.println("Ente a value for serial number");
                        methodVar = menuChoice.nextLine();
                        serialNum = Integer.parseInt(methodVar);
                        for (int i = 0; i < 5; i++) {
                            System.out.println("Ente a value for (return for no change) " + detailsArray[i]);
                            methodVar = menuChoice.nextLine();
                            vehicleArray[i] = methodVar;
                        } //for
                        System.out.println(vehicles.updateVehicle(serialNum, vehicleArray));
                        break;
                    } //case 4
                    case "5": {
                        System.out.println("thank you for playing");
                        doMore = false;
						menuChoice.close();
                        break;
                    } //case 5
                    default: {
                        System.out.println("invalid menu option choose again");
                        break;
                    }
                } //switch
            } //while
        } catch (RuntimeException e) {
            System.out.println("something went wrong " + e);
        }
    } //method
} //class