package com.competition.utils;

import com.competition.athlete.DecathlonAthlete;
import com.competition.athlete.DecathlonAthleteHelper;
import com.competition.athlete.DecathlonAthleteList;
import com.competition.decathlon.CalculateDecathlonTotalScore;
import com.competition.parser.DocumentParser;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class TotalScoreComparatorTest {

    private DocumentParser documentParser;
    private File tempFile;
    private DecathlonAthleteList decathlonAthleteList;
    private TotalScoreComparator totalScoreComparator;

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Before
    public void init() throws IOException {
        this.documentParser = new DocumentParser();
        this.tempFile = createMockFile();
        this.decathlonAthleteList = new DecathlonAthleteList();
        this.totalScoreComparator = new TotalScoreComparator();
        this.setAthleteList();
        this.calculateTotalPoints();
    }

    private File createMockFile() throws IOException {
        File mockFile = new File("test.txt");
        FileWriter writer = new FileWriter(mockFile);
        writer.write("Jaana Lind;13.75;4.84;10.12;1.50;68.44;19.18;30.85;2.80;33.88;6.22.75\n");
        writer.write("Jaana1 Lind1;13.75;4.84;10.12;1.50;68.44;19.18;30.85;2.80;33.88;6.22.75\n");
        writer.write("Siim Susi;12.61;5.00;9.22;1.50;60.39;16.43;21.60;2.60;35.81;5.25.72\n");
        writer.close();

        return mockFile;
    }

    private void setAthleteList(){
        ArrayList<DecathlonAthlete> list = documentParser.parseDocumentToDecathlonAthlete("test.txt", ";");
        decathlonAthleteList.setAthleteList(list);
    }

    private void calculateTotalPoints(){
        for(DecathlonAthlete decathlonAthlete: decathlonAthleteList.getAthleteList()){
            int totalScore = CalculateDecathlonTotalScore.calculateTotalScore(decathlonAthlete);
            decathlonAthlete.setTotalScore(totalScore);
        }
    }

    @After
    public void clean() {
        tempFile.delete();
    }

    @Test
    public void compare() throws Exception {
        DecathlonAthleteHelper.sortAthletesByTotalScore(decathlonAthleteList);
        ArrayList<DecathlonAthlete> list = decathlonAthleteList.getAthleteList();

        int result = totalScoreComparator.compare(list.get(0), list.get(1));
        assertEquals(result, -1);

        result = totalScoreComparator.compare(list.get(1), list.get(0));
        assertEquals(result, 1);

        result = totalScoreComparator.compare(list.get(1), list.get(2));
        assertEquals(result, 0);

        result = totalScoreComparator.compare(list.get(2), list.get(1));
        assertEquals(result, 0);
    }

}