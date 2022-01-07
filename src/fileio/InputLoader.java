package fileio;

import common.Constants;
import entities.AnnualChanges;
import entities.Child;
import entities.ChildUpdate;
import entities.Present;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import utils.Utils;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public final class InputLoader {
    private final String inputPath;

    public InputLoader(final String inputPath) {
		this.inputPath = inputPath;
	}

	public String getInputPath() {
		return inputPath;
	}

	public Input readData() {
		JSONParser jsonParser = new JSONParser();
		String numberOfYears = null;
		String santaBudget = null;
		ArrayList<Child> children = new ArrayList<>();
		ArrayList<Present> santaGiftsList = new ArrayList<>();
		ArrayList<AnnualChanges> annualChanges = new ArrayList<>();
		ArrayList<Present> newGifts = new ArrayList<>();
		ArrayList<Child> newChildren = new ArrayList<>();
		ArrayList<ChildUpdate> childUpdates = new ArrayList<>();

		try {
			JSONObject jsonObject = (JSONObject) jsonParser
					.parse(new FileReader(inputPath));
			numberOfYears = String.valueOf((jsonObject).
							get(Constants.NUMBEROFYEARS));
			santaBudget = String.valueOf((jsonObject).
							get(Constants.SANTABUDGET));
			JSONObject initialData = (JSONObject) jsonObject.
									get(Constants.INITIALDATA);
			JSONArray jsonAnnualChanges = (JSONArray) jsonObject.
									get(Constants.ANNUALCHANGES);
			JSONArray jsonChildren = (JSONArray)
					initialData.get(Constants.CHILDREN);
			JSONArray jsonPresents = (JSONArray)
					initialData.get(Constants.PRESENTS);

			if (jsonChildren != null) {
				for (Object jsonChild : jsonChildren) {
					createChild(children, (JSONObject) jsonChild);
				}
			} else {
				System.out.println("Nu exista copii");
			}

			if (jsonPresents != null) {
				createGifts(santaGiftsList, jsonPresents);
			} else {
				System.out.println("Nu exista cadouri");
			}

			if (jsonAnnualChanges != null) {
				for (Object annualChange : jsonAnnualChanges) {
					String newSantaBudget = String.valueOf(((JSONObject) annualChange)
							.get(Constants.NEWSANTABUDGET));
					JSONArray jsonNewGifts = ((JSONArray) ((JSONObject)
							annualChange).get(Constants.NEWGIFTS));
					JSONArray jsonNewChildren = ((JSONArray) ((JSONObject)
							annualChange).get(Constants.NEWCHILDREN));
					JSONArray jsonChildrenUpdates = ((JSONArray) ((JSONObject)
							annualChange).get(Constants.CHILDRENUPDATES));

					if (jsonNewGifts != null) {
						createGifts(newGifts, jsonNewGifts);
					} else {
						System.out.println("Nu exista cadouri noi");
					}

					if (jsonNewChildren != null) {
						for (Object jsonChild : jsonNewChildren) {
							createChild(newChildren, (JSONObject) jsonChild);
						}
					} else {
						System.out.println("Nu exista copii noi");
					}

					if (jsonChildrenUpdates != null) {
						for (Object jsonChild : jsonChildrenUpdates) {
							String id = String.valueOf(((JSONObject) jsonChild)
										.get(Constants.ID));
							String niceScore = String.valueOf(((JSONObject) jsonChild)
									.get(Constants.NICESCORE));
							if (niceScore.equals("null")) {
								niceScore = "-1";
							}
							childUpdates.add(new ChildUpdate(Integer.parseInt(id),
										Double.valueOf(niceScore),
										Utils.convertJSONArray((JSONArray)
										((JSONObject) jsonChild).
										get(Constants.CHILDRENUPDATES))));
						}
					} else {
						System.out.println("Nu exista update-uri");
					}

					annualChanges.add(new AnnualChanges(Double.valueOf(newSantaBudget),
										newGifts, newChildren, childUpdates));
				}
			}

		} catch (ParseException | IOException e) {
			e.printStackTrace();
		}
		assert numberOfYears != null;
		assert santaBudget != null;
		return new Input(Integer.parseInt(numberOfYears),
				Double.valueOf(santaBudget), children, santaGiftsList,
				annualChanges);
	}

	private void createGifts(ArrayList<Present> newGifts, JSONArray jsonNewGifts) {
		for (Object newGift : jsonNewGifts) {
			String productName = String.valueOf(((JSONObject) newGift)
					.get(Constants.PRODUCTNAME));
			String price = String.valueOf(((JSONObject) newGift)
					.get(Constants.PRICE));
			String category = String.valueOf(((JSONObject) newGift)
					.get(Constants.CATEGORY));
			newGifts.add(new Present(productName,
									Double.valueOf(price),
									category));
		}
	}

	private void createChild(ArrayList<Child> children, JSONObject jsonChild) {
		String id = String.valueOf(jsonChild
				.get(Constants.ID));
		String lastName = String.valueOf(jsonChild
				.get(Constants.LASTNAME));
		String firstName = String.valueOf(jsonChild
				.get(Constants.FIRSTNAME));
		String age = String.valueOf(jsonChild
				.get(Constants.AGE));
		String city = String.valueOf(jsonChild
				.get(Constants.CITY));
		String niceScore = String.valueOf(jsonChild
				.get(Constants.NICESCORE));
		children.add(new Child(
				Integer.parseInt(id),
				lastName,
				firstName,
				Integer.parseInt(age),
				city,
				Double.valueOf(niceScore),
				Utils.convertJSONArray((JSONArray) jsonChild.get(Constants.GIFTSPREFERENCES)
		)));
	}
}
