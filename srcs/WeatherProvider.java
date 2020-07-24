

public class WeatherProvider {

	private WeatherProvider weatherProvider = new WeatherProvider();
	private static String[] weather = {
		"FOG",
		"RAIN",
		"SNOW",
		"SUN",
	};

	public WeatherProvider() {

	}

	public static WeatherProvider getProvider() {
		return this.weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates) {
		int index;

		index = (coordinates.getLatitude() + coordinates.getLongitude() + coordinates.getHeight()) % 4;
		return weather[index]; 
	}
}