package fileio;

import common.Constants;
import entities.AnnualChanges;
import entities.Child;
import entities.Present;
import lombok.val;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import utils.Utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

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
		ArrayList<Child> children = new ArrayList<>();
		ArrayList<Present> santaGiftsList = new ArrayList<>();
		ArrayList<AnnualChanges> annualChanges = new ArrayList<>();

		try {
			JSONObject jsonObject = (JSONObject) jsonParser
					.parse(new FileReader(inputPath));
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
					String id = String.valueOf(((JSONObject) jsonChild)
							.get(Constants.ID));
					String lastName = String.valueOf(((JSONObject) jsonChild)
							.get(Constants.LASTNAME));
					String firstName = String.valueOf(((JSONObject) jsonChild)
							.get(Constants.FIRSTNAME));
					String age = String.valueOf(((JSONObject) jsonChild)
							.get(Constants.AGE));
					String city = String.valueOf(((JSONObject) jsonChild)
							.get(Constants.CITY));
					String niceScore = String.valueOf(((JSONObject) jsonChild)
							.get(Constants.NICESCORE));
					String giftsPreferences = String.valueOf(((JSONObject)
							jsonChild).get(Constants.GIFTSPREFERENCES));
					children.add(new Child(
							Integer.parseInt(id),
							lastName,
							firstName,
							Integer.parseInt(age),
							city,
							Double.valueOf(niceScore),
							Utils.convertJSONArray((JSONArray) ((JSONObject)
									jsonChild).get(Constants.GIFTSPREFERENCES)
					)));
				}
			} else {
				System.out.println("Nu exista copii");
			}

			if (jsonPresents != null) {
				for (Object jsonPresent : santaGiftsList) {
					String productName = String.valueOf(((JSONObject) jsonPresent)
							.get(Constants.PRODUCTNAME));
					String price = String.valueOf(((JSONObject) jsonPresent)
							.get(Constants.PRICE));
					String category = String.valueOf(((JSONObject) jsonPresent)
							.get(Constants.CATEGORY));
					santaGiftsList.add(new Present(productName,
													Double.valueOf(price),
													category));
				}
			} else {
				System.out.println("Nu exista cadouri");
			}

//			if (jsonAnnualChanges != null) {
//				for (Object annualChange : jsonAnnualChanges) {
//					String newSantaBudget = String.valueOf(((JSONObject) annualChange)
//							.get(Constants.NEWSANTABUDGET));
//					System.out.println(Utils.convertJSONArray((JSONArray) ((JSONObject)
//							annualChange).get(Constants.NEWGIFTS)));
////					annualChanges.add(new AnnualChanges(Double.valueOf(newSantaBudget),
////										newGifts);
//				}

		} catch (ParseException | IOException e) {
			e.printStackTrace();
		}

		return new Input(children, santaGiftsList, annualChanges);
	}
}
