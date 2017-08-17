package com.competition.utils;

import com.competition.athlete.Athlete;

import java.util.Comparator;

/**
 * Custom comparator for all classes that implements {@link Athlete} interface or has getTotalScore() method to check against athletes total score
 * Uses {@link Athlete} for totalScore value and {@link Comparator} to compare
 * @param <T>
 */

public class TotalScoreComparator<T extends Athlete> implements Comparator<T> {

    @Override
    public int compare(T ob1, T ob2) {
        return (ob1.getTotalScore() > ob2.getTotalScore() ? -1 :
                (ob1.getTotalScore() == ob2.getTotalScore() ? 0 : 1));
    }
}
