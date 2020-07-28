import java.util.Map;
import java.util.HashMap;

public class Helicopter extends Aircraft implements Flyable {

	private WeatherTower weatherTower;

	public Helicopter(String name, Coordinates coordinates){
		this.super(name, coordinates);
		this.weatherTower.put("FOG", "Holy crap I can't see anything!");
		this.weatherTower.put("RAIN", "Damn it! Forgot my umbrella!");
		this.weatherTower.put("SNOW", "I'm freezing like dull boy Jack!");
		this.weatherTower.put("SUN", "It's getting hot in here!");
	}

	public void updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);
		switch(weather)
		{
			case "FOG":
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
				break;
			case "RAIN":
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
				break;
			case "SNOW":
				this.coordinates.setHeight(this.coordinates.getHeight() - 12);
				break;
			case "SUN":
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
				this.coordinates.setHeight(this.coordinates.getHeight() + 2);
				break;
		}
		// Need landing if height is 0
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
	}

	protected void land() {
		this.super();
		this.weatherTower.unregister(this);
	}
}