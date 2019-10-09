package com.practice;

public class TestMyArraylist {
	
	public static void main(String[] args) {
		MyList<String> list = new MyArrayList<>();
		
		//Add elements to the list
		list.add("America");
		System.out.println("(1) " + list);
		
		//Add it to the beginning of the list
		list.add(0, "Canada");
		System.out.println("(2) " + list);
		
		//Add it to the end of the list
		list.add("Russia");
		System.out.println("(3) " + list);
		
		//Add it to the end of the list
		list.add("France");
		System.out.println("(4) "  + list);
		
		//Add it to the list at index 2
		list.add(2, "Germany");
		System.out.println("(5) " + list);
		
		//Add it to the list at index 5
		list.add(5, "Norway");
		System.out.println("(6) " + list);
		
		//Remove elements from the list
		list.remove("Canada");
		System.out.println("(7) " + list);
		
		//Remove the element at index 2
		list.remove(2);
		System.out.println("(8) " + list);
		
		//Remove the last element
		list.remove(list.size() - 1);
		System.out.println("(9) " + list + "\n(10) ");
		
		for(String s : list) {
			System.out.print(s.toUpperCase() + " ");
		}
		
	}

}
