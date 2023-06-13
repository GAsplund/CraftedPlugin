package com.crafted.customname.util;

import javax.annotation.RegEx;

/**
 * Utility class for chat colors
 */
public class ChatColors {
    @RegEx
    private static final String COLOR_FORMATS = "&(([0-fr])|(#[0-f]{6}))";

    /**
     * Removes all color codes from a string
     * @param string The string to remove color codes from
     * @return The string without color codes
     */
    public static String stripColor(String string) {
        return string.replaceAll(COLOR_FORMATS, "");
    }

    // Removes spaces at start and end regardless of color codes
    /*public static String stripSpaces(String string) {

    }*/

    /**
     * Checks if a string is a valid color code
     * @param string The string to check
     * @return Whether the string is a valid color code
     */
    public static boolean validColor(String string) {
        return string.strip().matches(COLOR_FORMATS);
    }
}
