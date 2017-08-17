package com.competition.decathlon;

/**
 * Class to calculate decathlon events scores.
 * The distances in enum are all in metres and the times in seconds.
 * Results are measured in seconds for (running), metres for (throwing), or centimetres for (jumping)
 */

public enum DecathlonScoreCalculator {

    _100M (25.4347, 18, 1.81) {
        public int calculateEventScore(double result) {
            return calculateTrackEventScore(result);
        }
    },
    LONG_JUMP (0.14354, 220, 1.4) {
        public int calculateEventScore(double result) { return calculateFieldEventScore(result * 100); }
    },
    SHOT_PUT (51.39, 1.5, 1.05) {
        public int calculateEventScore(double result) {
            return calculateFieldEventScore(result);
        }
    },
    HIGH_JUMP (0.8465, 75, 1.42) {
        public int calculateEventScore(double result) {
            return calculateFieldEventScore(result * 100);
        }
    },
    _400M (1.53775, 82, 1.81) {
        public int calculateEventScore(double result) {
            return calculateTrackEventScore(result);
        }
    },
    _110MHURDLES (5.74352, 28.5, 1.92) {
        public int calculateEventScore(double result) {
            return calculateTrackEventScore(result);
        }
    },
    DISCUS_THROW (12.91, 4, 1.1) {
        public int calculateEventScore(double result) {
            return calculateFieldEventScore(result);
        }
    },
    POLE_VAULT (0.2797, 100, 1.35) {
        public int calculateEventScore(double result) {
            return calculateFieldEventScore(result * 100);
        }
    },
    JAVELIN_THROW (10.14, 7, 1.08) {
        public int calculateEventScore(double result) { return calculateFieldEventScore(result); }
    },
    _1500M (0.03768, 480, 1.85) {
        public int calculateEventScore(double result) {
            return calculateTrackEventScore(result);
        }
    };

    private final double a;
    private final double b;
    private final double c;

    DecathlonScoreCalculator(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public abstract int calculateEventScore(double result);

    /**
     * Track event points=A×(B−T)^C
     * @param result
     * @return score
     */
    protected int calculateTrackEventScore(double result) {
        Double score = a * Math.pow(b - result, c);
        return score.intValue();
    }

    /**
     * Field event points=A×(D−B)^C
     * @param result
     * @return score
     */
    protected int calculateFieldEventScore(double result) {
        Double temp = a * Math.pow(result - b, c);
        return temp.intValue();
    }
}
