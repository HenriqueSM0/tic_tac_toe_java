package tic_tac_toe;

import java.util.Scanner;

public class table {
    position [][] spaces;
    char current_player;
    int round;

    table () {
        spaces = new position[3][3];
        int i, j;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                spaces[i][j] = new position();
                spaces[i][j].position_set('A');
            }
        }
        current_player = '1';
        round = 0;
    }

    boolean position_select () throws InterruptedException {
        System.out.println("Write where you want put your ball - ex : (A3) :");
        @SuppressWarnings("resource")
        Scanner SC = new Scanner(System.in);
        String answer = SC.nextLine();
        boolean valid_answer = false;
        if (answer.equals("A1") && (spaces[0][0].type_get() == 'A')) {
            spaces[0][0].position_set(current_player);
            valid_answer = true;
        } else if (answer.equals("B1") && (spaces[0][1].type_get() == 'A')) {
            spaces[0][1].position_set(current_player);
            valid_answer = true;
        } else if (answer.equals("C1") && (spaces[0][2].type_get() == 'A')) {
            spaces[0][2].position_set(current_player);
            valid_answer = true;
        } else if (answer.equals("A2") && (spaces[1][0].type_get() == 'A')) {
            spaces[1][0].position_set(current_player);
            valid_answer = true;
        } else if (answer.equals("B2") && (spaces[1][1].type_get() == 'A')) {
            spaces[1][1].position_set(current_player);
            valid_answer = true;
        } else if (answer.equals("C2") && (spaces[1][2].type_get() == 'A')) {
            spaces[1][2].position_set(current_player);
            valid_answer = true;
        } else if (answer.equals("A3") && (spaces[2][0].type_get() == 'A')) {
            spaces[2][0].position_set(current_player);
            valid_answer = true;
        } else if (answer.equals("B3") && (spaces[2][1].type_get() == 'A')) {
            spaces[2][1].position_set(current_player);
            valid_answer = true;
        } else if (answer.equals("C3") && (spaces[2][2].type_get() == 'A')) {
            spaces[2][2].position_set(current_player);
            valid_answer = true;
        } else {
            System.out.println(colors.paint("Invalid position !!!", colors.YELLOW));
            Thread.sleep(1000);
        }
        if (valid_answer) {
            if (current_player == '1') {
                current_player = '2';
            } else {
                current_player = '1';
            }
            round++;
        }
        return valid_answer;
    }

    private boolean analyze_x (char type) {
        int i;
        for (i = 0; i < 3; i++) {
            if ((spaces[i][0].type_get() == type) && (spaces[i][1].type_get() == type) && (spaces[i][2].type_get() == type)) {
                System.out.println(colors.paint("Player " + type + " Wins", colors.color_get(spaces[i][0].sprite_get())));
                return false;
            }
        }
        return true;
    }

    private boolean analyze_y (char type) {
        int j;
        for (j = 0; j < 3; j++) {
            if ((spaces[0][j].type_get() == type) && (spaces[1][j].type_get() == type) && (spaces[2][j].type_get() == type)) {
                System.out.println(colors.paint("Player " + type + " Wins", colors.color_get(spaces[0][j].sprite_get())));
                return false;
            }
        }
        return true;
    }

    private boolean analyse_cross (char type) {
        if ((spaces[0][0].type_get() == type) && (spaces[1][1].type_get() == type) && (spaces[2][2].type_get() == type)) {
            System.out.println(colors.paint("Player " + type + " Wins", colors.color_get(spaces[0][0].sprite_get())));
            return false;
        }
        if ((spaces[0][2].type_get() == type) && (spaces[1][1].type_get() == type) && (spaces[2][0].type_get() == type)) {
            System.out.println(colors.paint("Player " + type + " Wins", colors.color_get(spaces[1][1].sprite_get())));
            return false;
        }
        return true;
    }

    boolean can_continue (char type) {
        return (analyze_x(type) && analyze_y(type) && analyse_cross(type));
    }

    void print () {
        int i, j;
        if (current_player == '1') {
            System.out.println(colors.paint("P1", colors.BLUE));
        } else {
            System.out.println(colors.paint("P2", colors.RED));
        }
        System.out.println(" A  B  C");
        for (i = 0; i < 3; i++) {
            for (j =0; j < 3; j++) {
                System.out.print(" " + spaces[i][j].sprite_get() + " ");
            }
            System.out.println(" " + (i + 1));
        }
    } 
}
