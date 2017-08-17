package com.competition.utils;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FilePathValidationTest {

    @Test
    public void validFilePath() throws Exception {
        boolean valid = FilePathValidation.validateFilePath("c:/");

        assertEquals(valid, true);
    }

    @Test
    public void invalidFilePath() throws Exception {
        boolean valid = FilePathValidation.validateFilePath(" ");

        assertEquals(valid, false);
    }

    @Test
    public void nullFilePath() throws Exception {
        boolean valid = FilePathValidation.validateFilePath(null);

        assertEquals(valid, false);
    }

}