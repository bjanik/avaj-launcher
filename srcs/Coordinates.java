

public class Coordinates {

	private int longitude;
	private int latitude;
	private int height;

	public Coordinates(int longitude, int latitude, int height) {
		if (longitude < 0)
			longitude = 0;
		this.longitude = longitude;
		if (latitude < 0)
			latitude = 0;
		this.latitude = latitude;
		if (height < 0)
			height = 0;
		this.height = height;
	}

	public int getLongitude() { return this.longitude; }
	
	public int getLatitude() { return this.latitude; }

	public int getHeight() { return this.height; }
}