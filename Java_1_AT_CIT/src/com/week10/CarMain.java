package com.week10;

public class CarMain {

	public static void main(String[] args) {
		
		CarYard yard = new CarYard();
		Vehicle car = new Car("YGC48X", "Hyunday", 2008, 8000);
		Vehicle truck = new Truck("PPP20T", "Toyota", 20000, 120000, 10);
		
		yard.addVehicles(car);
		yard.addVehicles(truck);
		
		car.setmYear(2000);
		
		yard.displayVehicles();

	}

}
