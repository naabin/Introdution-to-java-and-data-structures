package com.week8;

import java.util.ArrayList;

public class Club{
	private ArrayList<Member> members = new ArrayList<Member>();

	
	private String spacer = "\n****************\n";
	
	public boolean addMember(Member inMember) {
		boolean added = false;
		if(members.contains(inMember)) {
			added = false;
		}
		else {
			members.add(inMember);
		}
		return added;
	}
	
	public boolean deleteMemeber(Member exMember) {
		boolean deleted = false;
		if(members.contains(exMember)) {
			members.remove(exMember);
			deleted = true;
		}
		else {
			deleted = false;
		}
		return deleted;
	}
	
	public boolean findMember(String name) {
		boolean found  = false;
		for(Member member: members) {
			if(name.equals(member.getFullName())) {
				found = true;
			}
		}
		return found;
	}
	public void printMembers() {
		System.out.println(this.spacer);
		for(Member m: members) {
			System.out.println(m.toString());
		}
	}
	
	public void printTotalCreditPoints() {
		System.out.println(this.spacer);
		System.out.println("Total credit points in the club.");
		int totalCredit =  0;
		for(Member m: members) {
			totalCredit += m.getCreditPoints();
		}
		
		System.out.println("Total credit points in the club is " + totalCredit);
	}
	
	public void printMembersWithMorePointsthan(int threshold) {
		System.out.println(this.spacer);
		System.out.println("Members with more than " + threshold + "  points");
		for(Member m : members) {
			if(m.getCreditPoints() > threshold) {
				System.out.println(m.getFullName() + " has more than minimum threshold credit points. The point is  " + m.getCreditPoints());
			}
		}
	}
	
	public void printMembersWithMostPoints() {
		System.out.println(this.spacer);
		System.out.println("Member with most point");
		int maxCreditPoint = members.get(0).getCreditPoints();
		String name = members.get(0).getFullName();
		for(Member m: members) {
			if(maxCreditPoint  < m.getCreditPoints()) {
				maxCreditPoint = m.getCreditPoints();
				name = m.getFullName();
			}
		}
		System.out.println(name + " has most credit points the club. He has " + maxCreditPoint);
	}
}
