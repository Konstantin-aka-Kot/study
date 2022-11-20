package com.javarush.task.task19.task1918;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(br.readLine()))){
            StringBuilder sb = new StringBuilder();
            while (reader.ready()){
                sb.append(reader.readLine());
            }
            Document document = Jsoup.parse(sb.toString(), "", Parser.xmlParser());
            Elements elem = document.select(args[0]);
            for (Element elements : elem){
                System.out.println(elements);
            }
        }
    }
}
