package com.javarush.games.minigames.mini11;

/*
Закрашиваем поле
*/

import com.javarush.engine.cell.Color;

public class FillOrangeGame extends FillGame {

    @Override
    public void fill() {
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                setCellColor(x, y, Color.ORANGE);
            }
        }
    }
}
