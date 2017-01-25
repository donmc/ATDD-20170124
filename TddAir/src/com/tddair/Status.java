package com.tddair;

public enum Status {

	RED("Red"), GOLD("Gold"), BLUE("Blue"), Green("Green");

	private String status;

	public String getStatus() {
		return status;
	}

	private Status(String status) {
		this.status = status;
	}

}
