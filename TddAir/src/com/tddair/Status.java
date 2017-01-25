package com.tddair;

public enum Status {

	RED("Red", 0, 10000), GOLD("Gold", 75000, 7000), BLUE("Blue", 50000, 8000), Green("Green", 25000, 9000);

	private String status;
	private int miles;
	private int purchaseSeatUpgradeMiles;

	private Status(String status, int miles, int purchaseSeatUpgradeMiles) {
		this.status = status;
		this.miles = miles;
		this.purchaseSeatUpgradeMiles = purchaseSeatUpgradeMiles;
	}

	public int getMiles() {
		return miles;
	}

	public String getStatus() {
		return status;
	}

	public int getPurchaseSeatUpgradeMiles() {
		return purchaseSeatUpgradeMiles;
	}

	public static Status getStatus(int miles) {
		Status status = Status.RED;
		if (miles >= GOLD.getMiles())
			status = Status.GOLD;
		else if (miles >= BLUE.getMiles())
			status = Status.BLUE;
		else if (miles >= Green.getMiles())
			status = Status.Green;
		return status;
	}
}
