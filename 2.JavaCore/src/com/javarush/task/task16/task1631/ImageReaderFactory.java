package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes it) {
        ImageReader result = null;
        if (it == ImageTypes.JPG) {
            result = new JpgReader();
        } else if (it == ImageTypes.BMP) {
            result = new BmpReader();
        } else if (it == ImageTypes.PNG) {
            result = new PngReader();
        } else {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
        return result;
    }
}
