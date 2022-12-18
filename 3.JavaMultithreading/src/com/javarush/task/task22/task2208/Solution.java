package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);
        System.out.println(getQuery(map));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> s : params.entrySet()) {
            if (s.getValue() == null) continue;
            if (sb.length() == 0) sb.append(s.getKey()).append(" = '").append(s.getValue()).append("'");
            else sb.append(" and ").append(s.getKey()).append(" = '").append(s.getValue()).append("'");
        }
        return sb.toString();
    }
}
