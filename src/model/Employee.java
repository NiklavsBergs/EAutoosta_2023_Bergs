package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee extends Person {
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat ("dd.MM.yyyy");
	
	private Date contractDate;
	private String contractNumber;
	
	public Employee(){
		super();
		setContractDate("00.00.0000");
		setContractNumber();
	}
	
	public Employee(String name, String surname, String personCode, String date){
		super(name, surname, personCode);
		setContractDate(date);
		setContractNumber();
	}
	
	public void setContractDate(String inputDate){
		try {
			if(inputDate != null) {
				Date limit = dateFormat.parse("24.03.2023");
				Date date = dateFormat.parse(inputDate);
				if (date.after(limit)) {
					contractDate = date;
				}
				else {
					contractDate = null;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Date getContractDate() {
		return contractDate;
	}
	
	public void setContractNumber(){
		
		if(contractDate != null) {
			SimpleDateFormat year = new SimpleDateFormat ("yyyy");
			contractNumber =  year.format(contractDate) + "_" + this.getName().charAt(0) + "_" + this.getSurname().charAt(0);
		}
		else {
			contractNumber = "No contract";
		}
		
	}
	
	public String getContractNumber() {
		return contractNumber;
	}
	
	public String toString() {
		return super.toString() + ", " + contractNumber;
	}
	
}
