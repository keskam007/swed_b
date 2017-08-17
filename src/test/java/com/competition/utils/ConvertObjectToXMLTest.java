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

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ConvertObjectToXMLTest {

    private DocumentParser documentParser;
    private DecathlonAthleteList dal;
    private File tempFile;
    private File outputFile;

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Before
    public void init() throws IOException {
        this.documentParser = new DocumentParser();
        this.dal = new DecathlonAthleteList();
        this.tempFile = createMockFile();
    }

    @After
    public void clean() {
        tempFile.delete();
        new File("outputTest.txt").delete();
    }

    private File createMockFile() throws IOException {
        File mockFile = new File("test.txt");
        FileWriter writer = new FileWriter(mockFile);
        writer.write("Siim Susi;12.61;5.00;9.22;1.50;60.39;16.43;21.60;2.60;35.81;5.25.72");
        writer.close();

        return mockFile;
    }

    private DecathlonAthleteList xmlToObject() throws Exception {
        JAXBContext jc = JAXBContext.newInstance(DecathlonAthleteList.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("outputTest.txt");
        DecathlonAthleteList decathlonAthleteList = (DecathlonAthleteList) unmarshaller.unmarshal(xml);

        return decathlonAthleteList;
    }

    @Test
    public void objectToXMLError() {
        thrown.expect(IllegalStateException.class);
        ConvertObjectToXML.objectToXML("outputTest.txt", String.class, null);
    }

    @Test
    public void objectToXML() throws Exception {

        ArrayList athleteList = documentParser.parseDocumentToDecathlonAthlete("test.txt", ";");
        DecathlonAthlete athlete = (DecathlonAthlete) athleteList.get(0);
        dal.setAthleteList(athleteList);

        ArrayList<DecathlonAthlete> d = dal.getAthleteList();
        ConvertObjectToXML.objectToXML("outputTest.txt", dal, null);

        DecathlonAthleteList decathlonAthleteList = xmlToObject();
        assertEquals(decathlonAthleteList.getAthleteList().get(0).getName(), "Siim Susi");
    }

}