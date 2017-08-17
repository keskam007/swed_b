package com.competition.utils;

import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

/**
 * Class to check if file path is valid.
 * Uses native java libs {@link Paths}, {@link InvalidPathException}
 */

public class FilePathValidation {

    /**
     *
     * @param path - string that user input as a file path
     * @return true or false of path is valid or not
     */
    public static boolean validateFilePath(String path) {

        try {
            Paths.get(path);
        } catch (InvalidPathException | NullPointerException ex) {
            return false;
        }
        return true;
    }
}
