package com.week8;

public class Member {
	
	private String fullName;
	private String nickName;
	private int creditPoints;
	
	public Member(String fullName) {
		this.fullName = fullName;
		this.nickName = NickNameGenerator.generatNickName(fullName);
		this.creditPoints = 100;
	}
	
	public Member(String fullName, int creditPoints) {
		this.fullName = fullName;
		this.nickName = NickNameGenerator.generatNickName(fullName);
		this.creditPoints = creditPoints;
	}
	
	@Override
	public String toString() {
		return getFullName() + " known as " + getNickName() + " has " + getCreditPoints()+ " points.";
	}
	
	public String getFullName() {
		return this.fullName;
	}
	
	public String getNickName() {
		return this.nickName;
	}
	
	public int getCreditPoints() {
		return this.creditPoints;
	}

}
