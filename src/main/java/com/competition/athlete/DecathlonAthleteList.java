package com.competition.athlete;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Class that hold a list of all decathlon athletes.
 * Uses Java Architecture for XML Binding (JAXB) annotations to ease the job with XML to Object parsing.
 * JAXB support binding Java-to-XML, with the addition of the javax.xml.bind.annotation package to control this binding.
 */

@XmlRootElement(name = "DecathlonAthleteList")
public class DecathlonAthleteList {

    private ArrayList<DecathlonAthlete> athleteList = new ArrayList<>();

    @XmlElement(name = "Athlete")
    public void setAthleteList(ArrayList<DecathlonAthlete> athleteList) {
        this.athleteList = athleteList;
    }

    public ArrayList<DecathlonAthlete> getAthleteList() {
        return athleteList;
    }
}
