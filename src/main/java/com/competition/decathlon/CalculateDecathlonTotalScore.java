package com.competition.decathlon;

import com.competition.athlete.DecathlonAthlete;
import com.competition.athlete.DecathlonAthleteHelper;

/**
 * Class to calculate selected decathlon athlete total score based on event formula provided in {@link DecathlonScoreCalculator}
 */
public class CalculateDecathlonTotalScore {

    private static int totalScore;

    /**
     * Method to get total score of athlete.
     * Uses {@link DecathlonAthleteHelper} to get result from athlete object.
     * Uses {@link DecathlonScoreCalculator} to get decathlon event score from formula.
     * @param decathlonAthlete {@link DecathlonAthlete}
     * @return totalSroce the list of decathlon athletes
     */
    public static int calculateTotalScore(DecathlonAthlete decathlonAthlete){

        totalScore = 0;
        for (DecathlonScoreCalculator event : DecathlonScoreCalculator.values()) {
            totalScore += event.calculateEventScore(DecathlonAthleteHelper.getEventResult(event.name(), decathlonAthlete));
        }
        return totalScore;
    }
}
