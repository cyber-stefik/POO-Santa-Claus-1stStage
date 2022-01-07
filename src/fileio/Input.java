package fileio;

import entities.AnnualChanges;
import entities.Child;
import entities.Present;

import java.util.ArrayList;

public final class Input {
	private final ArrayList<Child> children;
	private final ArrayList<Present> presents;
	private final ArrayList<AnnualChanges> annualChanges;

	public Input() {
		children = null;
		presents = null;
		annualChanges = null;
	}

	public Input(final ArrayList<Child> children, final ArrayList<Present>
			presents, final ArrayList<AnnualChanges> annualChanges) {
		this.children = children;
		this.presents = presents;
		this.annualChanges = annualChanges;
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
}
