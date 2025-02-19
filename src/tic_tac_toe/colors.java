package tic_tac_toe;

public interface colors {
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";
    public static final String YELLOW = "\u001B[33m";
    public static final String RESET = "\u001B[0m";

    public static String paint (String text, String color) {
        return color + text + RESET;
    }

    public static String color_get (String text) {
        if (text.contains(RED)) {
            return RED;
        } else if (text.contains(BLUE)) {
            return BLUE;
        } else if (text.contains(YELLOW)) {
            return YELLOW;
        } else {
            return RESET;
        }
    }
}
