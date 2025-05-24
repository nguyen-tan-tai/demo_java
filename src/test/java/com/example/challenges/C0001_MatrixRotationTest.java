package com.example.challenges;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-01
 * tags: java, algorithm, matrix rotation, recursive
 */
class C0001_MatrixRotationTest {

    /**
     * 1 2 3 4
     * 5 6 7 8
     * 9 10 11 12
     * 13 14 15 16
     *
     * @param matrix
     * @param rotation
     */
    public static void matrixRotation(int[][] matrix, int rotation) {
        int rowCnt = matrix.length;
        int colCnt = matrix[0].length;
        int boundCnt = Math.min(rowCnt, colCnt) / 2;
        for (int boundIndex = 0; boundIndex < boundCnt; boundIndex++) {
            rotateBound(matrix, boundIndex, rotation);
        }
    }

    /**
     * 
     * Imagine boundary index 0 -> 2
     * 0 0 0 0 0 0
     * 0 1 1 1 1 0
     * 0 1 2 2 1 0
     * 0 1 1 1 1 0
     * 0 0 0 0 0 0
     * 
     * @param matrix
     * @param boundIndex
     * @param rotation
     */
    public static void rotateBound(int[][] matrix, int boundIndex, int rotation) {
        int rowCnt = matrix.length;
        int colCnt = matrix[0].length;
        List<Integer> boundList = new ArrayList<>();
        for (int j = boundIndex; j < colCnt - boundIndex; j++) {
            boundList.add(matrix[boundIndex][j]);
        }
        for (int j = boundIndex + 1; j < rowCnt - boundIndex - 1; j++) {
            boundList.add(matrix[j][colCnt - boundIndex - 1]);
        }
        for (int j = colCnt - boundIndex - 1; j > boundIndex - 1; j--) {
            boundList.add(matrix[rowCnt - boundIndex - 1][j]);
        }
        for (int j = rowCnt - boundIndex - 2; j >= boundIndex + 1; j--) {
            boundList.add(matrix[j][boundIndex]);
        }
        int boundarySize = boundList.size();
        if (boundarySize == 0) {
            return; // Nothing to do
        }
        int optimizedRotations = rotation % boundarySize; // reduce unnecessary loop
        List<Integer> rotatedBoundList = new ArrayList<>(boundList.subList(optimizedRotations, boundarySize));
        rotatedBoundList.addAll(boundList.subList(0, optimizedRotations));
        int index = 0;
        for (int j = boundIndex; j < colCnt - boundIndex; j++) {
            matrix[boundIndex][j] = rotatedBoundList.get(index++);
        }
        for (int j = boundIndex + 1; j < rowCnt - boundIndex - 1; j++) {
            matrix[j][colCnt - boundIndex - 1] = rotatedBoundList.get(index++);
        }
        for (int j = colCnt - boundIndex - 1; j > boundIndex - 1; j--) {
            matrix[rowCnt - boundIndex - 1][j] = rotatedBoundList.get(index++);
        }
        for (int j = rowCnt - boundIndex - 2; j >= boundIndex + 1; j--) {
            matrix[j][boundIndex] = rotatedBoundList.get(index++);
        }
    }

    @Test
    public void test() {
        int[][] m44 = new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        matrixRotation(m44, 1);
        assertThat(m44).isEqualTo(new int[][] {
                {2, 3, 4, 8},
                {1, 7, 11, 12},
                {5, 6, 10, 16},
                {9, 13, 14, 15}});
        matrixRotation(m44, 1);
        assertThat(m44).isEqualTo(new int[][] {
                {3, 4, 8, 12},
                {2, 11, 10, 16},
                {1, 7, 6, 15},
                {5, 9, 13, 14}});

        int[][] m22 = new int[][] {
                {1, 2},
                {3, 4}};
        matrixRotation(m22, 1);
        assertThat(m22).isEqualTo(new int[][] {
                {2, 4},
                {1, 3}});
        m22 = new int[][] {
                {1, 2},
                {3, 4}};
        matrixRotation(m22, 2);
        assertThat(m22).isEqualTo(new int[][] {
                {4, 3},
                {2, 1}
        });
        m22 = new int[][] {
                {1, 2},
                {3, 4}};
        matrixRotation(m22, 4);
        assertThat(m22).isEqualTo(new int[][] {
                {1, 2},
                {3, 4}});
    }
}
