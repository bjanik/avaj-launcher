package fr.bjanik.avaj_launcher.Aircrafts;

import fr.bjanik.avaj_launcher.Interface.Flyable;

public class AircraftFactory {

	public Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
	{
		Coordinates coord = new Coordinates(longitude, latitude, height);
		if (type.toLowerCase().equals("baloon"))
			return new Baloon(name, coord);
		if (type.toLowerCase().equals("helicopter"))
			return new Helicopter(name, coord);
		if (type.toLowerCase().equals("jetplane"))
			return new JetPlane(name, coord);
		return null;
	}
}