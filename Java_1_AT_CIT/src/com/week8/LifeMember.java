package com.week8;

public class LifeMember extends Member {
	
	private int yearsInService;
	
	public LifeMember(String fullName, int yearsInService) {
		super(fullName);
		this.yearsInService = yearsInService;
	}

	public int getYearsInService() {
		return yearsInService;
	}
	
	@Override
	public String toString() {
		return "* The member is life member with " + yearsInService + " years in service\n" + super.toString();
	}
}
