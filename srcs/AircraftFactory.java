
public class AircraftFactory {

	public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws Exception
	{
		if (longitude < 0 || latitude < 0 || height < 0)
			throw new IrregularCoordinatesException();
		if (height > 100)
			height = 100;
		Coordinates coord = new Coordinates(longitude, latitude, height);
		if (type.toLowerCase().equals('baloon'))
			return new Baloon(name, coord);
		if (type.toLowerCase().equals('helicopter'))
			return new Helicopter(name, coord);
		if (type.toLowerCase().equals('jetplane'))
			return new JetPlane(name, coord);
	}
}