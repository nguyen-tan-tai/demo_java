package com.example.utils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MyUtils {

    public static int[][] convert2DIntListTo2DArray(List<List<Integer>> m) {
        int l = m.size();
        int[][] matrix = new int[l][];
        for (int i = 0; i < l; i++) {
            List<Integer> row = m.get(i);
            matrix[i] = new int[row.size()];
            for (int j = 0; j < row.size(); j++) {
                matrix[i][j] = row.get(j);
            }
        }
        return matrix;
    }

    public static String[][] convert2DStringListTo2DArray(List<List<String>> m) {
        int l = m.size();
        String[][] matrix = new String[l][];
        for (int i = 0; i < l; i++) {
            List<String> row = m.get(i);
            matrix[i] = new String[row.size()];
            for (int j = 0; j < row.size(); j++) {
                matrix[i][j] = row.get(j);
            }
        }
        return matrix;
    }

    public static void print2DStringList(List<List<String>> input) {
        String[][] matrix = convert2DStringListTo2DArray(input);
        print2DArray(matrix);
    }

    public static void print2DIntList(List<List<Integer>> input) {
        int[][] matrix = convert2DIntListTo2DArray(input);
        print2DArray(matrix);
    }

    public static void print2DArray(int[][] matrix) {
        print2DArray(matrix, "  ");
    }

    public static void print2DArray(int[][] matrix, String separator) {
        int padLength = Arrays.stream(matrix).flatMapToInt(x -> Arrays.stream(x)).boxed()
                .map(e -> e.toString().length())
                .sorted(Comparator.reverseOrder())
                .findFirst().get();
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(String.format("%" + padLength + "s", value));
                System.out.print(separator);
            }
            System.out.println();
        }
    }

    public static void print2DArray(String[][] matrix) {
        print2DArray(matrix, "  ");
    }

    public static void print2DArray(String[][] matrix, String separator) {
        int padLength = Arrays.stream(matrix).flatMap(e -> Arrays.stream(e))
                .map(e -> e.length())
                .sorted(Comparator.reverseOrder())
                .findFirst().get();
        for (String[] row : matrix) {
            for (String value : row) {
                System.out.print(String.format("%" + padLength + "s", value));
                System.out.print(separator);
            }
            System.out.println();
        }
    }

    public static void print(int[] matrix) {
        System.out.println(Arrays.toString(matrix));
    }

    public static void print(String[] matrix) {
        System.out.println(Arrays.toString(matrix));
    }
}
