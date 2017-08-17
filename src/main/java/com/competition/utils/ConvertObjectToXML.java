package com.competition.utils;

import com.competition.athlete.DecathlonAthleteList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class that takes java object and outputs as XML file.
 * Uses Java Architecture for XML Binding (JAXB) to ease the job.
 */
public class ConvertObjectToXML {

    private static Logger logger = Logger.getLogger(ConvertObjectToXML.class.getName());

    /**
     * Method to customise XML output file specific for decathlon athletes list
     * @param outputFileName
     * @throws JAXBException
     */
    public void convertDecathlonAthletesToXML(String outputFileName, String xslPath, DecathlonAthleteList dal) throws JAXBException {

        String customHeader = null;
        if(!xslPath.equals("NO")){
            customHeader = "\n<?xml-stylesheet type='text/xsl' href=\"" + xslPath + "\" ?>";
        }
        objectToXML(outputFileName, dal, customHeader);
    }

    /**
     * Generic method to parse object to XML
     * @param outputFileName
     * @param clazz - class that will be trasformed to XML
     * @param customHeader - include custom header upon the requirements
     * @param <T>
     * @throws - {@link IllegalStateException} in case of the error to stop application from running further.
     */
    public static <T> void objectToXML(String outputFileName, T clazz, String customHeader) {

        try {
            JAXBContext context = JAXBContext.newInstance(clazz.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            if(customHeader != null) {
                marshaller.setProperty("com.sun.xml.internal.bind.xmlHeaders", customHeader);
            }
            marshaller.marshal(clazz, new File(outputFileName));

        } catch (JAXBException e ) {
            //TODO proper logger
            logger.setUseParentHandlers(false);
            logger.log(Level.SEVERE, Arrays.toString(e.getStackTrace()));
            throw new IllegalStateException(e.getMessage());
        }
    }
}
