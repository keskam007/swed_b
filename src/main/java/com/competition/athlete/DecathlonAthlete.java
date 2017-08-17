package com.competition.athlete;

import com.competition.decathlon.DecathlonEvents;
import javax.xml.bind.annotation.XmlElement;

/**
 * Sets all data for decathlon athlete.
 * Implements {@link Athlete} and {@link DecathlonEvents} interfaces to get all required information.
 * Uses Java Architecture for XML Binding (JAXB) annotations to ease the job with XML to Object parsing.
 * JAXB support binding Java-to-XML, with the addition of the javax.xml.bind.annotation package to control this binding.
 */
public class DecathlonAthlete implements Athlete, DecathlonEvents {

    private String name;
    private double result100m;
    private double resultLongJump;
    private double resultShotPut;
    private double resultHighJump;
    private double result400m;
    private double result110Hurdles;
    private double resultDiscusThrow;
    private double resultPoleVault;
    private double resultJavelinThrow;
    private double result1500m;
    private int totalScore;
    private String place;

    @Override @XmlElement
    public void setName(String name) { this.name = name;}
    public String getName() { return name; }

    @Override @XmlElement(name = "_100m")
    public void set100m(double result100m) { this.result100m = result100m; }
    public double get100m() { return result100m; }

    @Override
    public void setLongJump(double resultLongJump) { this.resultLongJump = resultLongJump; }
    public double getLongJump() { return resultLongJump; }

    @Override
    public void setShotPut(double resultShotPut) { this.resultShotPut = resultShotPut; }
    public double getShotPut() { return resultShotPut; }

    @Override
    public void setHighJump(double resultHighJump) { this.resultHighJump = resultHighJump; }
    public double getHighJump() { return resultHighJump; }

    @Override @XmlElement(name = "_400m")
    public void set400m(double result400m) { this.result400m = result400m; }
    public double get400m() { return result400m; }

    @Override @XmlElement(name = "_110Hurdles")
    public void set110Hurdles(double result110Hurdles) { this.result110Hurdles = result110Hurdles; }
    public double get110Hurdles() { return result110Hurdles; }

    @Override
    public void setDiscusThrow(double resultDiscusThrow) { this.resultDiscusThrow = resultDiscusThrow; }
    public double getDiscusThrow() { return resultDiscusThrow; }

    @Override
    public void setPoleVault(double resultPoleVault) { this.resultPoleVault = resultPoleVault; }
    public double getPoleVault() { return resultPoleVault; }

    @Override
    public void setJavelinThrow(double resultJavelinThrow) { this.resultJavelinThrow = resultJavelinThrow; }
    public double getJavelinThrow() { return resultJavelinThrow; }

    @Override @XmlElement(name = "_1500m")
    public void set1500m(double result1500m) { this.result1500m = result1500m; }
    public double get1500m() { return result1500m; }

    @Override @XmlElement
    public void setTotalScore(int totalScore) { this.totalScore = totalScore; }
    public int getTotalScore() { return totalScore; }

    @Override @XmlElement
    public void setPlace(String place) { this.place = place; }
    public String getPlace() { return place; }
}


