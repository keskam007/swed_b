package com.competition.athlete;

import com.competition.utils.TotalScoreComparator;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class that deals with the decathlon athlete object to keep it as simple as is.
 * Declare all decathlon athlete operations here that are more complicated than setter or getter.
 */
public class DecathlonAthleteHelper {

    /**
     * Sorts array of decathlon athlete objects based on total score.
     * {@link DecathlonAthleteList} {@link TotalScoreComparator} - custom comparator to check against totalScore value
     * @param decathlonAthleteList
     * @return sorted athlete list by total score
     */
    public static DecathlonAthleteList sortAthletesByTotalScore(DecathlonAthleteList decathlonAthleteList){
        Collections.sort(decathlonAthleteList.getAthleteList(), new TotalScoreComparator());
        return decathlonAthleteList;
    }

    /**
     * The method returns raw event result on passed athlete and event.
     * @param event - even on which the result will be returned
     * @param decathlonAthlete athlete on which the results needs to be returned
     * @return result of the athlete on current event
     */
    public static double getEventResult(String event, DecathlonAthlete decathlonAthlete){
        double result = 0;
        switch (event){
            case "_100M": {
                result = decathlonAthlete.get100m();
                break;
            }
            case "LONG_JUMP": {
                result = decathlonAthlete.getLongJump();
                break;
            }
            case "SHOT_PUT": {
                result = decathlonAthlete.getShotPut();
                break;
            }
            case "HIGH_JUMP": {
                result = decathlonAthlete.getHighJump();
                break;
            }
            case "_400M": {
                result = decathlonAthlete.get400m();
                break;
            }
            case "_110MHURDLES": {
                result = decathlonAthlete.get110Hurdles();
                break;
            }
            case "DISCUS_THROW": {
                result = decathlonAthlete.getDiscusThrow();
                break;
            }
            case "POLE_VAULT": {
                result = decathlonAthlete.getPoleVault();
                break;
            }
            case "JAVELIN_THROW": {
                result = decathlonAthlete.getJavelinThrow();
                break;
            }
            case "_1500M": {
                result = decathlonAthlete.get1500m();
                break;
            }
            default: {
                //TODO log incorrect get
                result = -1;
            }
        }
        return result;
    }

    /**
     * Method to set athlete places. In case of equal scores, athletes must share the places, e.g. 3-4 and 5-6 instead of 3, 4, 5, and 6).
     * Takes a list of athletes and sets places to all athlete objects {@link DecathlonAthlete} from givven list.
     * @param decathlonAthleteList - {@link DecathlonAthleteList}
     */
    public static void setPlaces(ArrayList<DecathlonAthlete> decathlonAthleteList){
        for(DecathlonAthlete decathlonAthlete: decathlonAthleteList) {
            int currentScore = decathlonAthlete.getTotalScore();
            String place = "";
            for (int i = 0; i < decathlonAthleteList.size(); i++) {
                if (currentScore == decathlonAthleteList.get(i).getTotalScore()) {
                    place += "-" + (i + 1);
                }
            }

            String correctPlace = place.substring(1);
            decathlonAthlete.setPlace(correctPlace);
        }
    }
}
