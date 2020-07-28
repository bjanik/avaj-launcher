

public class JetPlane extends Aircraft implements Flyable {

	private WeatherTower weatherTower;

	public JetPlane(String name, Coordinates coordinates){
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
				this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
				break;
			case "RAIN":
				this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
				break;
			case "SNOW":
				this.coordinates.setHeight(this.coordinates.getHeight() - 7);
				break;
			case "SUN":
				this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
				this.coordinates.setHeight(this.coordinates.getHeight() + 2);
				break;
		}
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
	}
}