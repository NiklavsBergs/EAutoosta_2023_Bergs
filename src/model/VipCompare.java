package model;

import java.util.Comparator;

public class VipCompare implements Comparator<Ticket>{

	@Override
	public int compare(Ticket t1, Ticket t2) {
		if(t1.getVIP()) {
			if (t2.getVIP()) {
				return 0;
			}
			else {
				return -1;
			}
		}
		else {
			if (t2.getVIP()) {
				return 1;
			}
			return 0;
		}
	}
}
