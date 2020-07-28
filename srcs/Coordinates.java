

public class Coordinates {

	private int longitude;
	private int latitude;
	private int height;

	public Coordinates(int longitude, int latitude, int height) {
		try {
			if (longitude < 0)
			throw new IrregularCoordinatesException();
			if (latitude < 0)
				throw new IrregularCoordinatesException();
			if (height < 0 || height > 100)
				throw new IrregularCoordinatesException();
		} catch (IrregularCoordinatesException ice)
		{
			System.exit(1);
		}
		
		this.latitude = latitude;
		this.longitude = longitude;
		this.height = height;
	}

	public int getLongitude() { return this.longitude; }
	
	public int getLatitude() { return this.latitude; }

	public int getHeight() { return this.height; }

	public int setLongitude(int newLongtitude) {this.longitude = newLongtitude; }

	public int setLatitude(int newLatitude) { this.latitude = newLatitude; }

	public int setHeight(int newHeight) {
		if (newHeight < 0)
			newHeight = 0;
		if (newHeight > 100)
			newHeight = 100;
		this.height = newHeight;
	}
}