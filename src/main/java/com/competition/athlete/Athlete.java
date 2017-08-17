package com.competition.athlete;

/**
 * Generic interface for athlete object.
 * All athletes must implement at least these values.
 */
public interface Athlete {
    void setName(String name);
    void setPlace(String place);

    void setTotalScore(int score);
    int getTotalScore();
}