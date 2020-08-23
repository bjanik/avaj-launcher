// import java.io.Reader.;
import java.io.BufferedReader.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class Simulation {

	public static void readFile(String filename){
		// FileReader fileReader = new FileReader(filename);
		// BufferedReader buf = new BufferedReader(fileReader);
		// String line = buf.readline(); // First Line should an integer
		// ArrayList<Flyable> flyableList = new ArrayList<Flyable>();
		
		// int longitude, latitude, height;
		// try{
		// 	int simulationRounds = Integer.parseInt(line);
		// } catch (NumberFormatException nfe){
		// 	System.out.println("Bad file formatting, aborting simulation");
		// 	System.exit(1);

		// }
		// while (line != null)
		// {
		// 	// Add custom exception handling bad line formatting?
		// 	String[] strArray = line.split(" "); // Format of line should be "TYPE(str) NAME(str) LONGITUDE(int) LATITUDE(int) HEIGHT(int)"
		// 	if (strArray.length != 5) // Bad Formatting
		// 		System.exit(1);
		// 	longitude = Integer.parseInt(strArray[2]);
		// 	latitude = Integer.parseInt(strArray[3]);
		// 	height = Integer.parseInt(strArray[4]);
		// 	// Call here formatting check function. QUIT PROGRAM if line is bad!
		// 	// Only if line formatting is ok then we pass retrieved args to our AircraftFactory to create the aircraft
		// 	// flyableList.add(new newAircraft(strArray[0], strArray[1], longitude, latitude, height));
		// 	line = buf.readline();
		// }
	}

	public static void main(String[] args) {
		// if (args.length < 1)
		// 	return;
		// Create a writer, that's where log will be written to
		// FileWriter outTxt = new FileWriter("simulation.txt");
		// AircraftFactory factory = new AircraftFactory();
		Flyable baloon = new Baloon("B1", new Coordinates(20, 45, 18));
		Flyable jet = new JetPlane("J1", new Coordinates(70, 14, 78));
		Flyable heli = new Helicopter("H1", new Coordinates(70, 14, 0));
		// baloon = factory.newAircraft("baloon", "B1", 20, 45, 18);
		WeatherTower tower = new WeatherTower();
		baloon.registerTower(tower);
		jet.registerTower(tower);
		heli.registerTower(tower);
		heli.land();
		jet.land();
		baloon.land();
		// tower.register(baloon);
		// tower.conditionsChanged();
	}
}