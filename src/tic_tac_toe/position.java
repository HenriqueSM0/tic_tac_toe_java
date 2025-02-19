package tic_tac_toe;

public class position {
    private char type;
    private String sprite;

    void position_set (char type) {
        this.type = type;
        if (type == 'A') {
            sprite = "o";
        } else if (type == '1') {
            sprite = colors.paint("o", colors.BLUE);
        } else {
            sprite = colors.paint("o", colors.RED);
        }
    }

    char type_get () {
        return type;
    }

    String sprite_get () {
        return sprite;
    }
}
