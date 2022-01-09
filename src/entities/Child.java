package entities;

import java.util.ArrayList;

public final class Child {
    private final int id;
    private final String lastName;
    private final String firstName;
    private final String city;
    private int age;
    private ArrayList<String> giftsPreferences;
    private Double averageScore;
    private ArrayList<Double> niceScoreHistory;
    private Double assignedBudget;
    private ArrayList<Gift> receivedGifts;

    public Child(final int id, final String lastName, final String firstName,
                 final int age, final String city, final Double niceScore,
                 final ArrayList<String> giftsPreference) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.city = city;
        this.averageScore = niceScore;
        this.giftsPreferences = giftsPreference;
        niceScoreHistory = new ArrayList<>();
        niceScoreHistory.add(niceScore);
        assignedBudget = 0.0;
        receivedGifts = new ArrayList<>();
    }

    public Child(final Child child) {
        this.id = child.getId();
        this.lastName = child.getLastName();
        this.firstName = child.getFirstName();
        this.age = child.getAge();
        this.city = child.getCity();
        this.averageScore = child.getAverageScore();
        this.giftsPreferences = new ArrayList<>(child.getGiftsPreferences());
        niceScoreHistory = new ArrayList<>(child.getNiceScoreHistory());
        assignedBudget = child.getAssignedBudget();
        receivedGifts = new ArrayList<>(child.getReceivedGifts());
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

    public Double getAverageScore() {
        return averageScore;
    }

    public ArrayList<String> getGiftsPreferences() {
        return giftsPreferences;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public void setGiftsPreferences(final ArrayList<String> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    public ArrayList<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public void setNiceScoreHistory(final ArrayList<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    public Double getAssignedBudget() {
        return assignedBudget;
    }

    public void setAssignedBudget(final Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    public ArrayList<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    public void setReceivedGifts(final ArrayList<Gift> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }

    public void setAverageScore(final Double averageScore) {
        this.averageScore = averageScore;
    }

}
