

public class Aircraft {

	private static long idCounter = 0;

	protected long id;
	protected String name;
	protected Coordinates coordinates;
	protected Map weatherMap<String, String> = new HashMap<String, String>();


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
	}
}