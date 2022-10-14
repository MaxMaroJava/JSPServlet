package ua.crud.java;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ImmovableModel {
	private String adress;
	private int age;
	private double price;
	private int countOfRooms;
	private double countOfSquareMeters;
	private int floor;
	private int elevator;

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCountOfRooms() {
		return countOfRooms;
	}

	public void setCountOfRooms(int countOfRooms) {
		this.countOfRooms = countOfRooms;
	}

	public double getCountOfSquareMeters() {
		return countOfSquareMeters;
	}

	public void setCountOfSquareMeters(double countOfSquareMeters) {
		this.countOfSquareMeters = countOfSquareMeters;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int isElevator() {
		return elevator;
	}

	public void setElevator(int elevator) {
		this.elevator = elevator;
	}

	public ImmovableModel() {
		new ImmovableModel("", 0, 0.0, 0, 0.0, 0, 0);
	}

	public ImmovableModel(String adress, int age, double price, int countOfRooms, double countOfSquareMeters, int floor,
			int elevator) {
		this.adress = adress;
		this.age = age;
		this.price = price;
		this.countOfRooms = countOfRooms;
		this.countOfSquareMeters = countOfSquareMeters;
		this.floor = floor;
		this.elevator = elevator;
	}
}
