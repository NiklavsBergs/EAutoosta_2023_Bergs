package model;

public class Cashier extends Employee{
	private long id;
	private static long idCounter = 0;
	
	public Cashier(){
		super();
	}
	
	public Cashier(String name, String surname, String personCode, String date){
		super(name, surname, personCode, date);
		setId();
	}
	
	public long getId() {
		return id;
	}

	public void setId() {
		this.id = idCounter;
		idCounter++;
	}
	
	public String toString() {
		return "[" + super.toString() + ", Nr. " + id + " ]";
	}
}
