package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {

	public static void main(String[] args) {
		SimpleDateFormat format = new SimpleDateFormat ("dd.MM.yyyy");
		SimpleDateFormat year = new SimpleDateFormat ("yyyy");
		Date contractDate;
		
		try {
			contractDate = format.parse("24.03.2023");
			System.out.println(contractDate);
			System.out.println(year.format(contractDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
