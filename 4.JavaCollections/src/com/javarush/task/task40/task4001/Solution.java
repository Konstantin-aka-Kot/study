package com.javarush.task.task40.task4001;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/* 
POST, а не GET
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.sendPost(new URL("http://requestb.in/1cse9qt1"), "name=zapp&mood=good&locale=&id=777");
    }

    public void sendPost(URL url, String urlParameters) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");

        connection.connect();
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()))){
            writer.write(urlParameters);
        }

        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        StringBuilder response = new StringBuilder();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
                String responseLine;
                while ((responseLine = bufferedReader.readLine()) != null) {
                    response.append(responseLine);
                }
            }
        }
        System.out.println("Response: " + response.toString());
    }
}
