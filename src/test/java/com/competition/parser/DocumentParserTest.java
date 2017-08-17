package com.competition.parser;

import com.competition.athlete.DecathlonAthlete;
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

public class DocumentParserTest {

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
        badContentFile.delete();
    }

    @Test
    public void getAthleteListNoFile() {
        thrown.expect(IllegalStateException.class);
        documentParser.parseDocumentToDecathlonAthlete("c:/", null);
    }

    @Test
    public void getAthleteListBadFileContent() throws IOException {
        thrown.expect(ArrayIndexOutOfBoundsException.class);
        documentParser.parseDocumentToDecathlonAthlete("badContent.txt", ";");
    }

    @Test
    public void getAthleteListBadDelimiter() throws IOException {
        thrown.expect(ArrayIndexOutOfBoundsException.class);
        documentParser.parseDocumentToDecathlonAthlete("test.txt", "-");
    }

    @Test
    public void getAthleteList() throws IOException {
        ArrayList athleteList = documentParser.parseDocumentToDecathlonAthlete("test.txt", ";");
        DecathlonAthlete athlete = (DecathlonAthlete) athleteList.get(0);

        assertEquals(athlete.getName(), "Siim Susi");
        assertEquals(athlete.get1500m(), 325.72, 0);
    }

}