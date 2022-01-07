package database;

import entities.AnnualChanges;
import entities.Child;
import entities.Present;
import fileio.Input;

import javax.xml.crypto.Data;
import java.util.ArrayList;

public final class Database {
	private int numberOfYears;
	private Double santaBudget;
	private ArrayList<Child> children = new ArrayList<>();
	private ArrayList<Present> presents = new ArrayList<>();
	private ArrayList<AnnualChanges> annualChanges = new ArrayList<>();
	private static final Database instance = new Database();
	private static int instanceCount = 0;

	private Database() {
		instanceCount++;
	}

	public static Database getDatabase() {
		return instance;
	}

	public static int getNumberOfInstances() {
		return instanceCount;
	}

	public void addData(Input input) {
		this.numberOfYears = input.getNumberOfYears();
		this.santaBudget = input.getSantaBudget();
		this.children = input.getChildren();
		this.presents = input.getPresents();
		this.annualChanges = input.getAnnualChanges();
	}

	public static int getInstanceCount() {
		return instanceCount;
	}

	public static void setInstanceCount(int instanceCount) {
		Database.instanceCount = instanceCount;
	}

	public ArrayList<Child> getChildren() {
		return children;
	}

	public ArrayList<Present> getPresents() {
		return presents;
	}

	public ArrayList<AnnualChanges> getAnnualChanges() {
		return annualChanges;
	}

	public int getNumberOfYears() {
		return numberOfYears;
	}

	public void setNumberOfYears(int numberOfYears) {
		this.numberOfYears = numberOfYears;
	}

	public Double getSantaBudget() {
		return santaBudget;
	}

	public void setSantaBudget(Double santaBudget) {
		this.santaBudget = santaBudget;
	}

	public void setChildren(ArrayList<Child> children) {
		this.children = children;
	}

	public void setPresents(ArrayList<Present> presents) {
		this.presents = presents;
	}

	public void setAnnualChanges(ArrayList<AnnualChanges> annualChanges) {
		this.annualChanges = annualChanges;
	}

	@Override
	public String toString() {
		return "Database{" +
				"numberOfYears=" + numberOfYears +
				", santaBudget=" + santaBudget +
				", children=" + children +
				", presents=" + presents +
				", annualChanges=" + annualChanges +
				'}';
	}
}
