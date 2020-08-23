

public class WeatherProvider {

	private static WeatherProvider weatherProvider = new WeatherProvider();
	private static String[] weather = {
		"FOG",
		"RAIN",
		"SNOW",
		"SUN",
	};

	private WeatherProvider() {
	}

	public static WeatherProvider getProvider() {
		return WeatherProvider.weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates) {
		int index;

		index = (coordinates.getLatitude() + coordinates.getLongitude() + coordinates.getHeight()) % 4;
		return this.weather[index];
	}
}