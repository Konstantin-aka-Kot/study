package com.javarush.task.pro.task08.task0805;

import java.util.Random;

public class MagicBall {
    private static final String CERTAIN = "Бесспорно";
    private static final String DEFINITELY = "Определённо да";
    private static final String MOST_LIKELY = "Вероятнее всего";
    private static final String OUTLOOK_GOOD = "Хорошие перспективы";
    private static final String ASK_AGAIN_LATER = "Спроси позже";
    private static final String TRY_AGAIN = "Попробуй снова";
    private static final String NO = "Мой ответ — нет";
    private static final String VERY_DOUBTFUL = "Весьма сомнительно";

    public static String getPrediction() {
        Random r = new Random();
        int x = r.nextInt(8);
        switch (x) {
            case 0 :
                return "Бесспорно";
            case 1 :
                return "Определённо да";
            case 2 :
                return "Вероятнее всего";
            case 3 :
                return "Хорошие перспективы";
            case 4 :
                return "Спроси позже";
            case 5 :
                return "Попробуй снова";
            case 6 :
                return "Мой ответ — нет";
            case 7 :
                return "Весьма сомнительно";
        }
        return null;
    }
}
