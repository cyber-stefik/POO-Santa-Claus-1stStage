package entities;

import java.util.ArrayList;

public final class Child {
	private final int id;
	private final String lastName;
	private final String firstName;
	private final int age;
	private final String city;
	private final Double niceScore;
	private final ArrayList<String> giftsPreference;

	public Child(int id, String lastName, String firstName, int age,
				 String city, Double niceScore,
				 ArrayList<String> giftsPreference) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.age = age;
		this.city = city;
		this.niceScore = niceScore;
		this.giftsPreference = giftsPreference;
	}

	public int getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public int getAge() {
		return age;
	}

	public String getCity() {
		return city;
	}

	public Double getNiceScore() {
		return niceScore;
	}

	public ArrayList<String> getGiftsPreference() {
		return giftsPreference;
	}

	@Override
	public String toString() {
		return "Child{" +
				"id=" + id +
				", lastName='" + lastName + '\'' +
				", firstName='" + firstName + '\'' +
				", age=" + age +
				", city='" + city + '\'' +
				", niceScore=" + niceScore +
				", giftsPreference=" + giftsPreference +
				'}';
	}
}
