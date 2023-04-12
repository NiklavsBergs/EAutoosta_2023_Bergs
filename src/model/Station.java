package model;

public class Station {
	private City city;
	private String name;
	private long id;
	private String workingTime;
	
	private static long idCounter = 0;
	
	public Station() {
		setCity(City.Unknown);
		setName("--Name--");
		setWorkingTime("00:00-00:00");
		setId();
	}
	
	public Station(City city, String name, String workingTime) {
		setCity(city);
		setName(name);
		setWorkingTime(workingTime);
		setId();
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setId() {
		this.id = idCounter;
		idCounter++;
	}
	public long getId() {
		return id;
	}

	public String getWorkingTime() {
		return workingTime;
	}

	public void setWorkingTime(String workingTime) {
		if(workingTime != null && workingTime.matches("[0-9]{2}+[:][0-9]{2}+[-][0-9]{2}+[:][0-9]{2}")) {
			this.workingTime = workingTime;
		}
	}
	
	public String toString() {
		return "Nr." + id + ", " + name;
	}
	
	
	
	
}
