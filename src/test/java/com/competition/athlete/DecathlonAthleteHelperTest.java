package com.competition.athlete;

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

public class DecathlonAthleteHelperTest {

    private DocumentParser documentParser;
    private File tempFile;
    private DecathlonAthleteList decathlonAthleteList;

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Before
    public void init() throws IOException {
        this.documentParser = new DocumentParser();
        this.tempFile = createMockFile();
        this.decathlonAthleteList = new DecathlonAthleteList();
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
    public void sortAthletesByTotalScore() throws Exception {

        DecathlonAthleteHelper.sortAthletesByTotalScore(decathlonAthleteList);
        ArrayList<DecathlonAthlete> list = decathlonAthleteList.getAthleteList();

        assertEquals(list.get(0).getName(), "Siim Susi");
        assert(list.get(0).getTotalScore() > list.get(1).getTotalScore());
    }

    @Test
    public void getEventResult() throws Exception {
        DecathlonAthleteHelper.sortAthletesByTotalScore(decathlonAthleteList);
        ArrayList<DecathlonAthlete> list = decathlonAthleteList.getAthleteList();

        assertEquals(list.get(0).get100m(), 12.61, 0);
        assertEquals(list.get(1).get100m(), 13.75, 0);
        assertEquals(list.get(0).getTotalScore(), 4200, 0);
        assertEquals(list.get(1).getTotalScore(), 3494, 0);
    }

    @Test
    public void setPlaces() throws Exception {
        DecathlonAthleteHelper.sortAthletesByTotalScore(decathlonAthleteList);
        DecathlonAthleteHelper.setPlaces(decathlonAthleteList.getAthleteList());
        ArrayList<DecathlonAthlete> list = decathlonAthleteList.getAthleteList();

        assertEquals(list.get(0).getPlace(), "1");
        assertEquals(list.get(1).getPlace(), "2-3");
        assertEquals(list.get(2).getPlace(), "2-3");
    }

}