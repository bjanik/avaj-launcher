import java.util.HashMap;

public class Aircraft {

	private static long idCounter = 0;
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	protected HashMap<String, String> weatherMap = new HashMap<String, String>();

	protected Aircraft(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
		this.id = this.nextId();
	}

	private long nextId() {
		this.idCounter += 1;
		return idCounter;
	}

	protected void land(){
		System.out.println(this.getClass().getName() + "#" + this.name + "(" + this.id + ") landing.");
		System.out.println("Tower says: " + this.getClass().getName() + "#" + this.name + "(" + this.id + ") unregistered to weather tower.");
	}
}