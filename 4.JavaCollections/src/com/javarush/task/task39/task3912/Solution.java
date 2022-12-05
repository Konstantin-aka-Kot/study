package com.javarush.task.task39.task3912;

/* 
Максимальная площадь
*/

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                { 1, 1, 1, 1, 0, 1, 0, 0, 1, 1 },
                { 1, 0, 1, 1, 0, 1, 0, 0, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 1, 1, 1, 1, 1, 1 },
                { 0, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 0, 1, 0, 1, 1, 1 }
        };
        System.out.println(maxSquare(matrix));
    }

    public static int maxSquare(int[][] matrix) {
        int[][] fakeMatrix = matrix.clone();
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0 || j == 0) continue;
                else if (matrix[i][j] > 0) {
                    fakeMatrix[i][j] = 1 + Math.min(Math.min(fakeMatrix[i][j - 1], fakeMatrix[i - 1][j]), fakeMatrix[i - 1][j - 1]);
                }
                if (fakeMatrix[i][j] > result) result = fakeMatrix[i][j];
            }
        }
        return result * result;
    }
}

