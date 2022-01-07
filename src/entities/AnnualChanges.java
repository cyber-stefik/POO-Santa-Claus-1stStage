package entities;

import java.util.ArrayList;

public final class AnnualChanges {
	private final Double newSantaBudget;
	private final ArrayList<Present> newGifts;
	private final ArrayList<Child> newChildren;
	private final ArrayList<ChildUpdate> childrenUpdates;

	public AnnualChanges(Double newSantaBudget, ArrayList<Present> newGifts,
						 ArrayList<Child> newChildren,
						 ArrayList<ChildUpdate> childrenUpdates) {
		this.newSantaBudget = newSantaBudget;
		this.newGifts = newGifts;
		this.newChildren = newChildren;
		this.childrenUpdates = childrenUpdates;
	}

	public Double getNewSantaBudget() {
		return newSantaBudget;
	}

	public ArrayList<Present> getNewGifts() {
		return newGifts;
	}

	public ArrayList<Child> getNewChildren() {
		return newChildren;
	}

	public ArrayList<ChildUpdate> getChildrenUpdates() {
		return childrenUpdates;
	}

	@Override
	public String toString() {
		return "AnnualChanges{" +
				"newSantaBudget=" + newSantaBudget +
				", newGifts=" + newGifts +
				", newChildren=" + newChildren +
				", childrenUpdates=" + childrenUpdates +
				'}';
	}
}
