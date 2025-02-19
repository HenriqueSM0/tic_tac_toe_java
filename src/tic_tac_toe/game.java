package tic_tac_toe;

import java.io.IOException;

public class game {
    public static void main(String[] args) throws InterruptedException, IOException {
        table T = new table();
        boolean game_work = true;
        while (game_work) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            T.print();
            if (!(T.can_continue('1') && T.can_continue('2'))) {
                game_work = false;
            } else if (T.round == 9) {
                System.out.println("Draw !!!");
                game_work = false;
            } else {
                T.position_select();
            }  
        }
    }   
}
