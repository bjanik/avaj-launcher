

public class Coordinates {

	private int longitude;
	private int latitude;
	private int height;

	public Coordinates(int longitude, int latitude, int height) {
		if (longitude < 0 || latitude < 0 || height < 0)
			System.exit(1);
		this.latitude = latitude;
		this.longitude = longitude;
		this.height = height;
	}

	public int getLongitude() { return this.longitude; }
	
	public int getLatitude() { return this.latitude; }

	public int getHeight() { return this.height; }

	public void setLongitude(int newLongtitude) {this.longitude = newLongtitude; }

	public void setLatitude(int newLatitude) { this.latitude = newLatitude; }

	public void setHeight(int newHeight) {
		if (newHeight < 0)
			newHeight = 0;
		if (newHeight > 100)
			newHeight = 100;
		this.height = newHeight;
	}
}