package service;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

import model.BusCategory;
import model.BusDriver;
import model.BusTrip;
import model.Employee;
import model.Station;
import model.Ticket;
import model.TripDateCompare;
import model.Cashier;
import model.City;

public class mainService {

	//a
	static ArrayList<BusTrip> busTrips = new ArrayList<>();
	static ArrayList<Employee> employees = new ArrayList<>();
	static ArrayList<Station> stations = new ArrayList<>();
	
	public static void main(String[] args) {
		try {
			//c I
			BusDriver driver1 = new BusDriver("Janis", "Ozols", "123456-12345", "05.04.2023", 10);
			employees.add(driver1);
			BusDriver driver2 = new BusDriver("Andris", "Klava", "123457-12346", "02.04.2023", 5);
			employees.add(driver2);
			driver2.addCategory(BusCategory.minibus);
			BusDriver driver3 = new BusDriver("Sintija", "Kuzmina", "123458-12347", "29.03.2023", 11);
			employees.add(driver3);
			driver3.addCategory(BusCategory.largebus);
			BusDriver driver4 = new BusDriver("Santa", "Brice", "123458-12347", "03.04.2023", 7);
			employees.add(driver4);
			driver4.addCategory(BusCategory.minibus);
			
			//b
			// I
			Cashier cashier1 = new Cashier("Tomass", "Kaimins", "123459-12348", "27.03.2023");
			employees.add(cashier1);
			Cashier cashier2 = new Cashier("Diana", "Krastina", "123450-12349", "25.03.2023");
			employees.add(cashier2);
			Cashier cashier3 = new Cashier("Andis", "Birznieks", "123410-12340", "28.03.2023");
			employees.add(cashier3);
			Cashier cashier4 = new Cashier("Zane", "Abolina", "123411-12310", "30.03.2023");
			employees.add(cashier4);
			Cashier cashier5 = new Cashier("Peteris", "Lielais", "123412-12311", "31.03.2023");
			employees.add(cashier5);
			
			// II
			System.out.println("-----Cashier-----");
			System.out.println("--Find--");
			System.out.println(findCashier("123459-12348"));
			// III
			System.out.println("--Edit--");
			editCashier("123450-12349");
			// IV
			System.out.println("--Delete--");
			System.out.println("Before");
			System.out.println(employees);
			deleteCashier("123412-12311");
			System.out.println("After");
			System.out.println(employees);
			// V
			System.out.println("--All cashiers--");
			System.out.println(findAllCashiers());
			System.out.println();
			
			//c
			System.out.println("-----Bus Driver-----");
			// II
			System.out.println("--Drivers with category \"largebus\"--");
			System.out.println(findDriversByCategory(BusCategory.largebus));
			// III
			System.out.println("--Add category--");
			System.out.println("Drivers with category \"largebus\"");
			addDriverCategory("123456-12345", BusCategory.largebus);
			System.out.println(findDriversByCategory(BusCategory.largebus));
			// IV
			System.out.println("--All drivers--");
			System.out.println(findAllDrivers());
			System.out.println();
			
			//d
			Station ventspils = new Station(City.Ventspils, "Ventspils Autoosta", "00:00-00:00");
			stations.add(ventspils);
			Station riga = new Station(City.Riga, "Rigas Autoosta", "00:00-00:00");
			stations.add(riga);
			Station liepaja = new Station(City.Liepaja, "Liepajas Autoosta", "09:00-17:00");
			stations.add(liepaja);
			Station daugavpils = new Station(City.Daugavpils, "Daugavpils Autoosta", "00:00-00:00");
			stations.add(daugavpils);
			Station jelgava = new Station(City.Jelgava, "Jelgavas Autoosta", "00:00-00:00");
			stations.add(jelgava);
			
			//e
			SimpleDateFormat dateFormat3 = new SimpleDateFormat ("dd.MM.yyyy");
			Date todaysDate = new Date();
			String todayString = dateFormat3.format(todaysDate);
			System.out.println("-----Bus Trip-----");
			// I
			BusTrip VpDgp = new BusTrip(ventspils, daugavpils, todayString + " 14:00", todayString + " 22:00", 54, driver1);
			busTrips.add(VpDgp);
			BusTrip VpRiga = new BusTrip(ventspils, riga, todayString +  " 13:00", todayString + " 17:00", 54, driver1);
			busTrips.add(VpRiga);
			BusTrip RigaDgp = new BusTrip(riga, daugavpils, "05.08.2023 12:00", "05.08.2023 16:00", 29, driver2);
			busTrips.add(RigaDgp);
			System.out.println("--Free seats--");
			// II
			System.out.println("Available spots Ventspils-Riga, " + todayString + " 13:00:");
			System.out.println(availableSpots(ventspils, riga, todayString + " 13:00", todayString +  " 17:00"));
			System.out.println("--Tickets in trip: Ventspils-Riga--");
			VpRiga.addTicket(new Ticket(0, 5.00f, cashier1, false));
			VpRiga.addTicket(new Ticket(0, 7.00f, cashier1, true));
			VpRiga.addTicket(new Ticket(0, 5.00f, cashier1, false));
			// III
			System.out.println(allTicketsInTrip(ventspils, riga, todayString +  " 13:00", todayString + " 17:00"));
			System.out.println("Available spots Ventspils-Riga, " + todayString + " 13:00:");
			System.out.println(availableSpots(ventspils, riga, todayString + " 13:00", todayString +  " 17:00"));
			// IV
			System.out.println("--Trips from station: Ventspils--");
			System.out.println(tripsFromStation(ventspils));
			System.out.println();
			
			//f
			System.out.println("-----Ticket-----");
			// I
			RigaDgp.addTicket(new Ticket(0, 6.00f, cashier2, false));
			RigaDgp.addTicket(new Ticket(0, 8.00f, cashier2, true));
			RigaDgp.addTicket(new Ticket(0, 8.00f, cashier2, true));
			RigaDgp.addTicket(new Ticket(0, 6.00f, cashier2, false));
			RigaDgp.addTicket(new Ticket(0, 6.00f, cashier2, false));
			// II
			System.out.println("--VIP tickets--");
			System.out.println(allVIPTickets());
			// III
			System.out.println("--Cashier earnings, (123450-12349)--");
			DecimalFormat floatFormat = new DecimalFormat("0.00");
			System.out.println(floatFormat.format(cashierEarnings("123450-12349")) + "eur");
			System.out.println();
			
			//g
			System.out.println("--Trips from station: Ventspils(Sorted by time)--");
			// I
			System.out.println(tripsFromStationSorted(ventspils));
			System.out.println();
		
			// II - Generate Trips
			Random rand = new Random();
			int dayRand = 0;
			int hourRand = 0;
			int hourTo = 0;
			int driverRand = 0;
			int busSizeRand = 0;
			SimpleDateFormat dateFormat = new SimpleDateFormat ("dd");
			SimpleDateFormat dateFormat2 = new SimpleDateFormat ("MM.yyyy");
			String date = dateFormat2.format(todaysDate);
			String today = dateFormat.format(todaysDate);
			int day = Integer.valueOf(today);
			ArrayList<BusTrip> busTripsGen = new ArrayList<>();
			ArrayList<BusDriver> busDriversMini = findDriversByCategory(BusCategory.minibus);
			ArrayList<BusDriver> busDriversLarge = findDriversByCategory(BusCategory.largebus);
			
			for(Station station1: stations) {
				for(Station station2: stations) {
					if(station2!=station1) {
						dayRand = rand.nextInt(7);
						day = day + dayRand;
						hourRand = rand.nextInt(24);
						hourTo = hourRand + 4;
						driverRand = rand.nextInt(2);
						busSizeRand = rand.nextInt(2);
						if(busSizeRand==1) {
							busTripsGen.add(new BusTrip(station1, station2, day + "." + date + " " + hourRand + ":00", day + "." + date + " " + hourTo + ":00", 28, busDriversMini.get(driverRand)));
						}
						else {
							busTripsGen.add(new BusTrip(station1, station2, day + "." + date + " " + hourRand + ":00", day + "." + date + " " + hourTo + ":00", 54, busDriversLarge.get(driverRand)));
						}
						
					}
				}
			}
			
			System.out.println("--Generated Bus Trips--");
			System.out.println(busTripsGen);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	//Functions
	
	public static Cashier findCashier(String personCode) {
		if(personCode != null) {
			for(Employee employee: employees) {
				if(employee instanceof Cashier) {
					if(employee.getPersonCode() == personCode) {
						Cashier cashier = (Cashier) employee;
						return cashier;
					}
				}
			}
			return null;
		}
		
		else return null;
	}
	
	public static void editCashier(String personCode) throws ParseException {
		Scanner myObj = new Scanner(System.in);
		int selection = 0;
		String input;
		Cashier cashier = findCashier(personCode);
		
		System.out.println("Name: " + cashier.getName());
		System.out.println("Edit? (1-yes, 0 - no): ");
		selection = myObj.nextInt();
		myObj.nextLine();
		
		if(selection == 1) {
			System.out.println("Input name: ");
			input = myObj.nextLine();
			cashier.setName(input);
			System.out.println("New name: " + cashier.getName());
		}
		
		System.out.println("Surname: " + cashier.getSurname());
		System.out.println("Edit? (1-yes, 0 - no): ");
		selection = myObj.nextInt();
		myObj.nextLine();
		
		if(selection == 1) {
			System.out.println("Input surname: ");
			input = myObj.nextLine();
			cashier.setSurname(input);
			System.out.println("New surname: " + cashier.getSurname());
		}
		
		System.out.println("Contract date: " + cashier.getContractDate());
		System.out.println("Edit? (1-yes, 0 - no): ");
		selection = myObj.nextInt();
		myObj.nextLine();
		
		if(selection == 1) {
			System.out.println("Input date: ");
			input = myObj.nextLine();
			cashier.setContractDate(input);
			System.out.println("New contract date: " + cashier.getContractDate());
		}
		myObj.close();
	}
	
	public static void deleteCashier(String personCode) {
		if(personCode != null) {
			Cashier cashier = findCashier(personCode);
			if(cashier != null) {
				employees.remove(cashier);
			}
		}
	}
	
	public static ArrayList<Cashier> findAllCashiers(){
		ArrayList<Cashier> cashiers = new ArrayList<>();
		
		for(Employee employee: employees) {
			if(employee instanceof Cashier) {
				cashiers.add((Cashier)employee);
			}
		}
		return cashiers;
	}
	
	public static BusDriver findBusDriver(String personCode) {
		if(personCode != null) {
			for(Employee employee: employees) {
				if(employee instanceof BusDriver) {
					if(employee.getPersonCode() == personCode) {
						BusDriver driver = (BusDriver) employee;
						return driver;
					}
				}
			}
			return null;
		}
		
		else return null;
	}
	
	public static ArrayList<BusDriver> findDriversByCategory(BusCategory category){
		ArrayList<BusDriver> drivers = new ArrayList<>();
		
		for(Employee employee: employees) {
			if(employee instanceof BusDriver) {
				BusDriver driver = (BusDriver) employee;
				
				for(BusCategory busCategory: driver.getCategories()) {
					if(busCategory == category) {
						drivers.add(driver);
					}
				}
			}
		}
		return drivers;
	}
	
	public static void addDriverCategory(String personCode, BusCategory category) {
		if (personCode != null && category != null) {
			BusDriver driver = findBusDriver(personCode);
			if(driver != null) {
				driver.addCategory(category);
			}
		}
	}
	
	public static ArrayList<BusDriver> findAllDrivers(){
		ArrayList<BusDriver> drivers = new ArrayList<>();
		
		for(Employee employee: employees) {
			if(employee instanceof BusDriver) {
				drivers.add((BusDriver)employee);
			}
		}
		return drivers;
	}
	
	public static BusTrip findBusTrip(Station startStation, Station endStation, String startTime, String endTime) throws ParseException {
		
		if(startStation != null && endStation != null && startTime != null && endTime != null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat ("dd.MM.yyyy kk:mm");
			Date start = dateFormat.parse(startTime);
			Date end = dateFormat.parse(endTime);
			for(BusTrip trip : busTrips) {
				if((trip.getStartStation() == startStation) && (trip.getEndStation() == endStation) && (trip.getStartDate().compareTo(startTime) == 0)) {
					return trip;
				}
			}
		}
		return null;
				
	}
	
	public static int availableSpots(Station startStation, Station endStation, String startTime, String endTime) throws ParseException {
		BusTrip trip = findBusTrip(startStation, endStation, startTime, endTime);
		return trip.getCapacity() - trip.getTicketCount();
	}
	
	public static ArrayList<BusTrip> tripsFromStation(Station station){
		if(station != null) {
			ArrayList<BusTrip> trips = new ArrayList<>();
			SimpleDateFormat dateFormat = new SimpleDateFormat ("dd.MM.yyyy");
			Date todayDate = new Date();
			String today = dateFormat.format(todayDate);
			for(BusTrip trip: busTrips) {
				if((trip.getStartStation() == station) && (today.compareTo(trip.getStartDay()) == 0)) {
					trips.add(trip);
				}
			}
		return trips;
		}
		return null;
	}
	
	public static PriorityQueue<BusTrip> tripsFromStationSorted(Station station){
		if(station != null) {
			PriorityQueue<BusTrip> trips = new PriorityQueue<>(new TripDateCompare());
			SimpleDateFormat dateFormat = new SimpleDateFormat ("dd.MM.yyyy");
			Date todayDate = new Date();
			String today = dateFormat.format(todayDate);
			for(BusTrip trip: busTrips) {
				if((trip.getStartStation() == station) && (today.compareTo(trip.getStartDay()) == 0)) {
					trips.add(trip);
				}
			}
		return trips;
		}
		return null;
	}
	
	public static PriorityQueue<Ticket> allTicketsInTrip(Station startStation, Station endStation, String startTime, String endTime) throws ParseException{
		ArrayList<Ticket> tickets = new ArrayList<>();
		BusTrip trip = findBusTrip(startStation, endStation, startTime, endTime);
		return trip.tripTickets;
	}
		
	public static ArrayList<Ticket> allVIPTickets(){
		ArrayList<Ticket> tickets = new ArrayList<>();
		for(BusTrip trip: busTrips) {
			for(Ticket ticket: trip.tripTickets) {
				if(ticket.getVIP()) {
					tickets.add(ticket);
				}
			}
		}
		return tickets;
	}
	
	public static float cashierEarnings(String personCode) {
		if(personCode != null) {
			float earnings = 0;
			for(BusTrip trip: busTrips) {
				for(Ticket ticket: trip.tripTickets) {
					if(ticket.getCashier().getPersonCode() == personCode) {
						earnings += ticket.getPrice();
					}
				}
			}
			return earnings;
		}
		return 0;
	}
	
	
		
	

}
