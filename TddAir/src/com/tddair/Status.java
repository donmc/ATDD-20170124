package com.tddair;

public enum Status {
	Red(10000), Green(9000), Blue(8000), Gold(7000);
	
	private int seatUpgradeMilesCost;
	
	private Status(int seatUgradeMilesCost) {
		this.seatUpgradeMilesCost = seatUgradeMilesCost;
	}

	public static Status calculateStatusFor(int ytdMiles) {
		Status status = Red;
		
		if (ytdMiles >= 75000) {
			status = Status.Gold;
		} else if (ytdMiles >= 50000) {
			status = Status.Blue;
		} else if (ytdMiles >= 25000) {
			status = Status.Green;
		} 
		
		return status;
	}

	public int getSeatUpgradeMilesCost() {
		return seatUpgradeMilesCost;
	}

}
