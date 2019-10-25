package com.week10;

import java.util.ArrayList;

public class CarYard {
	private ArrayList<Vehicle> vehicles = new ArrayList<>();
	
	public void addVehicles(Vehicle vehicle) {
		if(this.vehicles.contains(vehicle)) {
			System.out.println("The vehicle already exists in the ");
		}
		else {
			this.vehicles.add(vehicle);
			System.out.println("Vehicle " + vehicle.getmMake() + " has been added.");
		}
	}
	
	public boolean findVehicle(String vehicleRegoNum) {
		for(Vehicle vehicle : this.vehicles) {
			if(vehicle.getmRegoNum().equals(vehicleRegoNum)) {
				return true;
			}
		}
		return false;
	}
	
	public void calcTotal() {
		double total = 0;
		for(Vehicle v: this.vehicles) {
			total += v.getmPrice();
		}
		
		System.out.println("The total price for all vehicles in the caryard is " + total);
	}
	
	public void displayHeavyTrucks(int minTonnage) {
		String message = "The caryard has the following trucks with tonnage more than " + minTonnage + " is: \n";
		
		for(Vehicle v: this.vehicles) {
			if(v instanceof Truck) {
				if(((Truck) v).getmTonnage() > minTonnage) {
					message += v;
					System.out.println(message);
				}
				else {
					System.out.println("No greater tonnage found.");
				}
			}
		}
	}
	
	public void displayVehicles() {
		for(Vehicle v: this.vehicles) {
			System.out.println(v);
		}
	}
}
