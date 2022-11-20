package com.javarush.games.minigames.mini09;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

/* 
Таймер
*/

public class TimerGame extends Game {

    @Override
    public void initialize() {
        setScreenSize(3, 3);
        setTurnTimer(1000);
    }

    @Override
    public void onTurn(int step) {
        setCellNumber(1, 1, step);
        if (step%2 == 0) {
            for (int w = 0; w < 3; w++) {
                for (int h = 0; h < 3; h++) {
                    setCellColor(w, h, Color.GREEN);
                }
            }
        } else {
            for (int w = 0; w < 3; w++) {
                for (int h = 0; h < 3; h++) {
                    setCellColor(w, h, Color.ORANGE);
                }
            }
        }
    }
}
