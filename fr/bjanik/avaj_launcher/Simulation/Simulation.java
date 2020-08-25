package fr.bjanik.avaj_launcher.Simulation;

import fr.bjanik.avaj_launcher.Interface.Flyable;
import fr.bjanik.avaj_launcher.Aircrafts.AircraftFactory;
import fr.bjanik.avaj_launcher.Tower.WeatherTower;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Simulation {

	public static PrintWriter writer;

	public static ArrayList<Flyable> readScenario(BufferedReader buffer)
	{
		String line;
		String[] strArray;
		ArrayList<Flyable> flyableList = new ArrayList<Flyable>();
		AircraftFactory factory = new AircraftFactory();
		int longitude, latitude, height;
		try {
			while ((line = buffer.readLine()) != null)
			{
		 		strArray = line.split(" ");
		 		if (strArray.length != 5){
		 			System.out.println("Line should be formatted like : TYPE(str) NAME(str) LONGITUDE(int) LATITUDE(int) HEIGHT(int)");
		 			System.exit(1);	
		 		}		 		
		 		longitude = Integer.parseInt(strArray[2]);
		 		latitude = Integer.parseInt(strArray[3]);
		 		height = Integer.parseInt(strArray[4]);
		 		Flyable aircraft = factory.newAircraft(strArray[0], strArray[1], longitude, latitude, height);
		 		if (aircraft != null)
		 			flyableList.add(aircraft);
		 		else
		 		{
		 			System.out.println("Unknown type of aircraft, aborting simulation");
		 			System.exit(1);
		 		}
			}
		} catch (IOException ioe){
			System.exit(1);
		} catch (NumberFormatException nfe){
			System.out.println("Coordinates badly formatted, aborting simulation");
			System.exit(1);
		}
		return flyableList;
	}

	public static void main(String[] args) {
		if (args.length < 1)
			return;
		
		try {
			File simulation = new File("simulation.txt");
			if (simulation.isDirectory())
			{
				System.out.println("Cannot log to a directory, aborting simualtion");
				System.exit(1);
			}
			writer = new PrintWriter(simulation);
			FileReader fileReader = new FileReader(args[0]);
			BufferedReader buffer = new BufferedReader(fileReader);
			String line = buffer.readLine();
			int simulationRounds = Integer.parseInt(line);
			if (simulationRounds < 0)
			{
				System.out.println("Number of simulations must be a positive integer");
				System.exit(1);
			}
			ArrayList<Flyable> flyableList = readScenario(buffer);
			WeatherTower weatherTower = new WeatherTower();
			// WeatherTower weatherTower2 = new WeatherTower();
			for (int i = 0; i < flyableList.size(); i++)
				flyableList.get(i).registerTower(weatherTower);
			while (simulationRounds > 0){
				weatherTower.changeWeather();
				simulationRounds--;
			}
			writer.close();
			buffer.close();
		} catch (NumberFormatException nfe){
			System.out.println("First line must be a positive integer, aborting simulation");
			System.exit(1);
		} catch (IOException ioe){
			System.exit(1);
		}
	}
}