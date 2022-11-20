package com.javarush.games.minigames.mini05;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

/* 
Цвета радуги
*/

public class RainbowGame extends Game {

    @Override
    public void initialize() {
        setScreenSize(10, 7);
        for (int w = 0; w < 10; w++) {
            for (int h = 0; h < 7; h++) {
               switch (h) {
                    case 0 :
                        setCellColor(w, h, Color.RED);
                        break;
                    case 1 :
                        setCellColor(w, h, Color.ORANGE);
                        break;
                    case 2 :
                        setCellColor(w, h, Color.YELLOW);
                        break;
                    case 3 :
                        setCellColor(w, h, Color.GREEN);
                        break;
                    case 4 :
                        setCellColor(w, h, Color.BLUE);
                        break;
                    case 5 :
                        setCellColor(w, h, Color.INDIGO);
                        break;
                    case 6 :
                        setCellColor(w, h, Color.VIOLET);
                        break;
         }
              //  setCellColor(w, h, Color.RED);

            }
        }
    }
}
