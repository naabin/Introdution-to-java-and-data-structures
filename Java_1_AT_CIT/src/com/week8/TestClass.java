package com.week8;

public class TestClass {
	
	public static void main(String[] args) {
		Club c1 = new Club();
		Member m1 = new Member("Mickey Mouse");
		Member m2 = new Member("Donald Duck", 150);
		Member m3 = new Member("Melinda", 120);
		Member m4 = new LifeMember("Nabin Karki", 20);
			
		c1.addMember(m1);
		c1.addMember(m2);
		c1.addMember(m3);
		c1.addMember(m4);
		
		
		c1.printMembers();
		c1.printTotalCreditPoints();
		
		c1.printMembersWithMorePointsthan(100);
		c1.printMembersWithMostPoints();
	}

}
