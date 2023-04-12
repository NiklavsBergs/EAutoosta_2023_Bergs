package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.PriorityQueue;

public class BusTrip {
	private long id;
	private Station startStation;
	private Station endStation;
	private Date startDate;
	private Date endDate;
	private int capacity;
	private BusDriver driver;
	
	public PriorityQueue<Ticket> tripTickets;
	
	private static long idCounter = 0;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat ("dd.MM.yyyy kk:mm");
	private SimpleDateFormat dayFormat = new SimpleDateFormat ("dd.MM.yyyy");
	
	public BusTrip() {
		setId();
		setStartStation(new Station());
		setEndStation(new Station());
		setStartDate("00.00.0000 00:00");
		setEndDate("00.00.0000 00:00");
		setCapacity(0);
		setDriver(new BusDriver());
		tripTickets = new PriorityQueue<>(1);
	}
	
	public BusTrip(Station startStation, Station endStation, String startDate, String endDate, int capacity, BusDriver driver){
		setId();
		setStartStation(startStation);
		setEndStation(endStation);
		setStartDate(startDate);
		setEndDate(endDate);
		setCapacity(capacity);
		setDriver(driver);
		tripTickets = new PriorityQueue<>(capacity, new VipCompare());
	}
	
	public void setId() {
		this.id = idCounter;
		idCounter++;
	}
	
	public long getId() {
		return id;
	}

	public Station getStartStation() {
		return startStation;
	}

	public void setStartStation(Station startStation) {
		if(startStation != null) {
			this.startStation = startStation;
		}
	}

	public Station getEndStation() {
		return endStation;
	}

	public void setEndStation(Station endStation) {
		if(endStation != null) {
			if(endStation!=this.startStation) {
				this.endStation = endStation;
			}
		}
	}

	public String getStartDate() {
		return dateFormat.format(startDate);
	}
	
	public String getStartDay() {
		return dayFormat.format(startDate);
	}

	public void setStartDate(String startDate) {
		try {
			//Made the time in the check 00:00 (not exact time), so mainService would work any time when tested
			Date today = new Date();
			String todayString = dayFormat.format(today);
			if(startDate != null) {
				if(dateFormat.parse(startDate).after(dateFormat.parse(todayString + " 00:00"))) {
					this.startDate = dateFormat.parse(startDate);
				}
				else {
					this.startDate = dateFormat.parse("00.00.0000 00:00");
				}			
			}
			else {
				this.startDate = dateFormat.parse("00.00.0000 00:00");
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	

	public String getEndDate() {
		return dateFormat.format(endDate);
	}

	public void setEndDate(String endDate) {
		try {
			if(endDate != null) {
				if(dateFormat.parse(endDate).after(this.startDate)) {
					this.endDate = dateFormat.parse(endDate);
				}
				else {
					this.endDate = dateFormat.parse("00.00.0000 00:00");
				}
			}
			else {
				this.endDate = dateFormat.parse("00.00.0000 00:00");
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		if(capacity > 0 && capacity < 100) {
			this.capacity = capacity;
		}
		else {
			capacity = 0;
		}
	}

	public BusDriver getDriver() {
		return driver;
	}

	public void setDriver(BusDriver driver){
		if(driver != null) {
			if(capacity<30) {
				if (driver.categories.contains(BusCategory.minibus) || driver.categories.contains(BusCategory.largebus)){
				this.driver = driver;
				}
				else {
					this.driver = null;
				}
			}
			else {
				if (driver.categories.contains(BusCategory.largebus)) {
					this.driver = driver;
				}
				else {
					this.driver = null;
				}
			}
			
		}
	}
	
	public void addTicket(Ticket ticket) throws Exception{
		if(ticket != null) {
			if (tripTickets.size() <= capacity) {
				tripTickets.add(ticket);
			}
			else {
				throw(new Exception("Bus is full"));
			}
		}
		else {
			throw(new Exception("Ticket doesn't exist"));
		}
	}
	
	public void changeDriver(BusDriver driver) throws Exception {
		if(driver != null) {
			if(capacity<30) {
				if (driver.categories.contains(BusCategory.minibus) || driver.categories.contains(BusCategory.largebus)){
				this.driver = driver;
				}
				else {
					throw(new Exception("Driver isn't allowed to drive this bus"));
				}
			}
			else {
				if (driver.categories.contains(BusCategory.largebus)) {
					this.driver = driver;
				}
				else {
					throw(new Exception("Driver isn't allowed to drive this bus"));
				}
			}
			
		}
	}
	
	public int getTicketCount() {
		return tripTickets.size();
	}
	
	public String toString() {
		return "From: " + startStation + ", To: " + endStation + ", Start time: " + dateFormat.format(startDate) + ", End time: " + dateFormat.format(endDate) + ", capacity: " + capacity + ", driver: " + driver + "\n";
	}

}
