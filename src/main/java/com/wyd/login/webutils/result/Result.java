package com.wyd.login.webutils.result;

public enum Result {
	SUCCESS("success"),FAIL("fail");
	
	private final String stauts;
	
	private Result(String stauts) {
		this.stauts = stauts;
	}

	public String getStauts() {
		return stauts;
	}
	
}
