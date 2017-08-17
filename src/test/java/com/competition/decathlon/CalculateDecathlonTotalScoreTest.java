package com.competition.decathlon;

import com.competition.athlete.DecathlonAthlete;
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

public class CalculateDecathlonTotalScoreTest {

    private DocumentParser documentParser;
    private File tempFile;
    private File badContentFile;

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Before
    public void init() throws IOException {
        this.documentParser = new DocumentParser();
        this.tempFile = createMockFile();
        this.badContentFile = createBadContentMockFile();
    }

    private File createMockFile() throws IOException {
        File mockFile = new File("test.txt");
        FileWriter writer = new FileWriter(mockFile);
        writer.write("Siim Susi;12.61;5.00;9.22;1.50;60.39;16.43;21.60;2.60;35.81;5.25.72");
        writer.close();

        return mockFile;
    }

    private File createBadContentMockFile() throws IOException {
        File mockFile = new File("badContent.txt");
        //mockFile.createNewFile();
        FileWriter writer = new FileWriter(mockFile);
        writer.write("Siim Susi;12.61;5.00;9.22;1.50;60.39;16.43;21.60;");
        writer.close();

        return mockFile;
    }

    @After
    public void clean() {
        tempFile.delete();
    }

    @Test
    public void calculateTotalScore() throws Exception {

        ArrayList<DecathlonAthlete> list = documentParser.parseDocumentToDecathlonAthlete("test.txt", ";");
        int score = CalculateDecathlonTotalScore.calculateTotalScore(list.get(0));

        assertEquals(score, 4200);
    }

    @Test
    public void calculateBadTotalScore() throws Exception {

        thrown.expect(ArrayIndexOutOfBoundsException.class);
        ArrayList<DecathlonAthlete> list = documentParser.parseDocumentToDecathlonAthlete("badContent.txt", ";");
        int score = CalculateDecathlonTotalScore.calculateTotalScore(list.get(0));

        assertEquals(score, 4200);
    }
}