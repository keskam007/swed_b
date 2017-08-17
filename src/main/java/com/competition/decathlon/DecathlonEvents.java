package com.competition.decathlon;

/**
 * Decathlon events interface to be implemented for every decathlon athlete
 */
public interface DecathlonEvents {

    void set100m(double seconds);
    void setLongJump(double meters);
    void setShotPut(double meters);
    void setHighJump(double meters);
    void set400m(double seconds);
    void set110Hurdles(double seconds);
    void setDiscusThrow(double meters);
    void setPoleVault(double meters);
    void setJavelinThrow(double meters);
    void set1500m(double minsec);
}
