package model;

import java.text.DecimalFormat;
import java.util.Date;

public class Ticket{
	private long id;
	private Date date;
	private int discount;
	private float price;
	private Cashier cashier;
	private boolean VIP;
	
	private static long idCounter = 0;
	
	public Ticket(){
		setId();
		setDate();
		setDiscount(0);
		setPrice(0.0f);
		setCashier(new Cashier());
		setVIP(false);
	}
	
	public Ticket(int discount, float price, Cashier cashier, boolean VIP){
		setId();
		setDate();
		setDiscount(discount);
		setPrice(price);
		setCashier(cashier);
		setVIP(VIP);
	}
	
	public void setId() {
		this.id = idCounter;
		idCounter++;
	}

	public Date getDate() {
		return date;
	}

	public void setDate() {
		this.date = new Date();
	}
	
	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		if(discount<0 && discount>100) {
			this.discount = 0;
		}
		else {
			this.discount = discount;
		}
		
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		if(discount==0) {
			this.price = price;
		}
		else if(discount>0 && discount<100) {
			this.price = price * (discount/100);
		}
		else {
			this.price = 0;
		}
	}

	public Cashier getCashier() {
		return cashier;
	}

	public void setCashier(Cashier cashier) {
		if(cashier != null) {
			this.cashier = cashier;
		}
	}

	public boolean getVIP() {
		return VIP;
	}

	public void setVIP(boolean VIP) {
		this.VIP = VIP;
	}
	
	public String toString() {
		DecimalFormat floatFormat = new DecimalFormat("0.00");
		return "Nr." + id + ", " + floatFormat.format(price) + "eur, " + "VIP: " + VIP;
	}
	
}
