package model;

import java.util.Comparator;

public class TripDateCompare implements Comparator<BusTrip>{

	@Override
	public int compare(BusTrip trip1, BusTrip trip2) {
		
		return trip1.getStartDate().compareTo(trip2.getStartDate());
	}

}
