package com.competition.decathlon;

import org.junit.Test;
import static org.junit.Assert.*;

public class DecathlonScoreCalculatorTest {

    private DecathlonScoreCalculator dsc;

    @Test
    public void randomEventScore() throws Exception {
        DecathlonScoreCalculator event = dsc.values()[0];
        int result = event.calculateEventScore(12.61);

        assertEquals(event.name(), "_100M");
        assertEquals(result, 536);

        event = dsc.values()[3];
        result = event.calculateEventScore(1.50);
        assertEquals(event.name(), "HIGH_JUMP");
        assertEquals(result, 389);

        //TODO add all events
    }
}