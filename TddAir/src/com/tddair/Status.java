package com.tddair;

public enum Status {

	RED("Red", 0), GOLD("Gold", 75000), BLUE("Blue", 50000), Green("Green", 25000);

	private String status;
	private int miles;

	public String getStatus() {
		return status;
	}

	private Status(String status, int miles) {
		this.status = status;
		this.miles = miles;
	}

	public int getMiles() {
		return miles;
	}

	public static Status getStatus(int miles) {
		Status status = Status.RED;
		if (miles >= 75000)
			status = Status.GOLD;
		else if (miles >= 50000)
			status = Status.BLUE;
		else if (miles >= 25000)
			status = Status.Green;
		return status;
	}
}
