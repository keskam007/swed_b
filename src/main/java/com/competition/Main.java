package com.competition;

import com.competition.athlete.DecathlonAthlete;
import com.competition.athlete.DecathlonAthleteHelper;
import com.competition.athlete.DecathlonAthleteList;
import com.competition.parser.DocumentParser;
import com.competition.decathlon.CalculateDecathlonTotalScore;
import com.competition.utils.ConvertObjectToXML;
import com.competition.utils.FilePathValidation;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Application which will take input file and convert it to XML file.
 * User should enter input and output files location on the machine and delimiter of the input file.
 * File content is converted to java object and after to XML file.
 *
 * Application is flexible as it uses intermediary java object. Any file content can be transferred to the object and then back to any file content.
 */

public class Main {

    private static String inputFileName = null;
    private static String outputFileName = null;
    private static String delimiter = null;
    private static String xslPath = null;

    public static void main(String[] args) {

        System.out.println("Please follow instructions to continue with file convert");

        Scanner in = new Scanner(System.in);
        setFileNames(in);
        setDelimiter(in);
        setXslPath(in);

        DocumentParser fp = new DocumentParser();
        ArrayList athleteList = fp.parseDocumentToDecathlonAthlete(inputFileName, delimiter);

        DecathlonAthleteList dal = new DecathlonAthleteList();
        dal.setAthleteList(athleteList);

        for(DecathlonAthlete decathlonAthlete: dal.getAthleteList()){
            int totalScore = CalculateDecathlonTotalScore.calculateTotalScore(decathlonAthlete);
            decathlonAthlete.setTotalScore(totalScore);
        }

        DecathlonAthleteHelper.sortAthletesByTotalScore(dal);
        DecathlonAthleteHelper.setPlaces(dal.getAthleteList());

        ConvertObjectToXML coXML = new ConvertObjectToXML();
        try {
            coXML.convertDecathlonAthletesToXML(outputFileName, xslPath, dal);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static void setFileNames(Scanner in) {

        while(inputFileName == null || outputFileName == null) {

            if(inputFileName == null) {System.out.println("Please enter INPUT file name");};
            String input = in.nextLine().trim();
            if(input.length() != 0) {
                if (inputFileName == null && FilePathValidation.validateFilePath(input)) {
                    inputFileName = input;
                    System.out.println("Please enter OUTPUT file name");
                } else if (FilePathValidation.validateFilePath(input)) {
                    outputFileName = input;
                }
            } else {
                System.out.println("File name cannot be empty");
                continue;
            }
        }
    }

    private static void setDelimiter(Scanner in) {
        System.out.println("Please enter delimiter");
        while(delimiter == null){
            String input = in.nextLine().trim();
            if(input.length() != 0) {
                delimiter = input;
            } else {
                System.out.println("Delimiter cannot be empty");
                continue;
            }
        }
    }

    private static void setXslPath(Scanner in) {
        System.out.println("Please enter xsl file path or 'NO' if style sheet is not needed");
        while(xslPath == null){
            String input = in.nextLine().trim();
            if(("NO").equals(input.toUpperCase())) {
                xslPath = input.toUpperCase();
            } else if(input.length() != 0) {
                xslPath = input;
            } else {
                System.out.println("Xsl file path cannot be empty");
                continue;
            }
        }
    }

}
