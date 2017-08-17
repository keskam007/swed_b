package com.competition.parser;

import com.competition.athlete.DecathlonAthlete;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class to parse input from the document to Java object.
 */
public class DocumentParser {

    private static Logger logger = Logger.getLogger(DocumentParser.class.getName());

    /**
     * Method to parse file content to proper value of {@link DecathlonAthlete} object
     * @param inputFileName
     * @param delimiter
     * @return the object of {@link DecathlonAthlete}
     * @throws {@link IllegalStateException} in case of an error and stops program from running.
     */
    public ArrayList<DecathlonAthlete> parseDocumentToDecathlonAthlete(String inputFileName, String delimiter) {

        String line = "";
        ArrayList<DecathlonAthlete> athleteList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
            while ((line = br.readLine()) != null) {
                String[] result = line.split(delimiter);

                DecathlonAthlete da = new DecathlonAthlete();
                da.setName(result[0]);
                da.set100m(Double.parseDouble(result[1]));
                da.setLongJump(Double.parseDouble(result[2]));
                da.setShotPut(Double.parseDouble(result[3]));
                da.setHighJump(Double.parseDouble(result[4]));
                da.set400m(Double.parseDouble(result[5]));
                da.set110Hurdles(Double.parseDouble(result[6]));
                da.setDiscusThrow(Double.parseDouble(result[7]));
                da.setPoleVault(Double.parseDouble(result[8]));
                da.setJavelinThrow(Double.parseDouble(result[9]));
                da.set1500m(convertMinutesToSeconds(result[10]));

                athleteList.add(da);
            }
        } catch (IOException e) {
            //TODO proper logger
            logger.setUseParentHandlers(false);
            logger.log(Level.SEVERE, Arrays.toString(e.getStackTrace()));
            //e.printStackTrace();
            throw new IllegalStateException(e.getMessage());
        }

        return athleteList;
    }

    private double convertMinutesToSeconds (String result) {
        String[] resultArray = result.split("\\.", 2);
        int minutes = Integer.parseInt(resultArray[0]);
        double secods = Double.parseDouble(resultArray[1]);

        return (minutes * 60) + secods;
    }
}
