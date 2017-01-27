package com.tddair;

public enum Status {
	Red(0, 10000), Green(25000,9000), Blue(50000, 8000), Gold(70000,7000);
	
	private int seatUpgradeMilesCost;
	private int milesThreshold;
	
	private Status(int milesThreshold, int seatUgradeMilesCost) {
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
