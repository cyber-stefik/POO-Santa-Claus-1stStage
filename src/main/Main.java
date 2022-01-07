package main;

import action.Action;
import checker.Checker;
import checker.Checkstyle;
import common.Constants;
import database.Database;
import fileio.Input;
import fileio.InputLoader;
import org.json.simple.JSONArray;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        ///constructor for checkstyle
    }
    /**
     * This method is used to call the checker which calculates the score
     * @param args
     *          the arguments used to call the main method
     */
    public static void main(final String[] args) throws IOException {
        File directory = new File(Constants.TESTS_PATH);
        Path path = Paths.get(Constants.OUTPUT_PATH);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
        int count = 1;
        for (File file : Objects.requireNonNull(directory.listFiles())) {

            String filepath = Constants.OUTPUT_PATH + count + ".json";
            count++;
            InputLoader inputLoader = new InputLoader(file.getAbsolutePath());
            Input input = inputLoader.readData();
            File out = new File(filepath);
            boolean isCreated = out.createNewFile();
//            if (isCreated) {
//                action(file.getAbsolutePath(), filepath);
//            }
        }
        Checker.calculateScore();
    }

//    public static void action(final String filePath1,
//                              final String filePath2) throws IOException {
//        InputLoader inputLoader = new InputLoader(filePath1);
//        Input input = inputLoader.readData();
//
//        Writer fileWriter = new Writer(filePath2);
//        JSONArray arrayResult = new JSONArray();
//        // My EntryPoint
//        Database database = Database.getDatabase();
//        database.addData(input);
//        Action.choose(database, arrayResult, fileWriter, input.getCommands());
//
//        //TODO add here the entry point to your implementation
//
//        fileWriter.closeJSON(arrayResult);
//    }
}
