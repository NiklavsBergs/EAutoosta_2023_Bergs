package model;

import java.util.ArrayList;

public class BusDriver extends Employee{
	
	private int experiance;
	ArrayList<BusCategory> categories = new ArrayList<>();
	
	public BusDriver(){
		super();
	}
	
	public BusDriver(String name, String surname, String personCode, String date, int experiance){
		super(name, surname, personCode, date);
		setExperiance(experiance);
	}
	
	public void addCategory(BusCategory category) {
		if(category != null) {
			categories.add(category);
		}
	}
	
	public ArrayList<BusCategory> getCategories(){
		return categories;
	}
	
	public void removeCategory(BusCategory category) {
		if(category != null && categories.contains(category)) {
			categories.remove(category);
		}
	}

	public int getExperiance() {
		return experiance;
	}

	public void setExperiance(int experiance) {
		if(experiance >= 0 && experiance < 70) {
			this.experiance = experiance;
		}
		else {
			this.experiance = 0;
		}
		
	}
		
	public String toString() {
		return "[" + super.toString() + ", " + experiance + "]";
	}
	
}
