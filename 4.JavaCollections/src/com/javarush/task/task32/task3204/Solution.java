package com.javarush.task.task32.task3204;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
    /*    for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String password = getPassword().toString();
            if (password.equals(password.toLowerCase())) {
                System.out.printf("LowerCase - %s\n", password);
            } else if (password.equals(password.toUpperCase())) {
                System.out.printf("UpperCase - %s\n", password);
            } else if (noNumbers(password)) {
                System.out.printf("No Number - %s\n", password);
            }
       }

     */

        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    private static boolean noNumbers(String string) {
        for (char ch : string.toCharArray()) {
            if (Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    public static ByteArrayOutputStream getPassword() {

        String allsumbols = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        String nextPassword;
        do {
            sb.delete(0, sb.length());
            for (int i = 0; i < 8; i++) {
                int index = (int) (new SecureRandom().nextDouble() * allsumbols.length());
                sb.append(allsumbols.substring(index, index + 1));
            }
            nextPassword = sb.toString();
        } while (!(nextPassword.matches("(.*[0-9]+.*)") && nextPassword.matches("(.*[a-z]+.*)")
                && nextPassword.matches("(.*[A-Z]+.*)")));

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
try (InputStream is = new ByteArrayInputStream(nextPassword.getBytes())){
while (is.available() > 0){
    int data = is.read();
    baos.write(data);
}
baos.close();
} catch (IOException e) {
    throw new RuntimeException(e);
}


        return baos;
    }
}
