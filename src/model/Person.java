package model;

public class Person {
	
	private String name;
	private String surname;
	private String personCode;
	
	public Person() {
		setName("Unknown");
		setSurname("Unknown");
		setPersonCode("000000-00000");
	}
	
	public Person(String name, String surname, String personCode) {
		setName(name);
		setSurname(surname);
		setPersonCode(personCode);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name!=null && name.matches("[A-ZĒŪĪĻĶĢŠĀČŅŽ]{1}[a-zēūīļķģšāčņž]+[ ]?([A-ZĒŪĪĻĶĢŠĀČŅŽ]{1}[a-zēūīļķģšāčņž]+)?")) {
			this.name = name;
		}
		else {
			this.name = "Unknown";
		}
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		if(surname!=null && surname.matches("[A-ZĒŪĪĻĶĢŠĀČŅŽ]{1}[a-zēūīļķģšāčņž]+[-]?([A-ZĒŪĪĻĶĢŠĀČŅŽ]{1}[a-zēūīļķģšāčņž]+)?")) {
			this.surname = surname;
		}
		else {
			this.surname = "Unknown";
		}
	}
	
	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		if(personCode!=null && personCode.matches("[0-9]{6}[-][0-9]{5}")) {
			this.personCode = personCode;
		}
		else {
			this.personCode = "000000-00000";
		}
	}
	
	public String toString() {
		
		return "" + name + ", " + surname + ", " + personCode;
	}
		
}
