package com.example.challenges;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-01
 * tags: java, algorithm, project euler, problem 1, multiple of 3 and 5
 */
class C0001_MatrixRotationTest {

    /**
     * Given value = 100
     * s3: 3 -> 99 e.g. 3, 6, 9, 12, 15, 18, ..., 94, 87, 90, 93, 96, 99 -> 33 numbers
     * s5: 5 -> 95 e.g. 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95 -> 19 numbers
     * s15: 15 -> 95 e.g. 15, 30, 45, 60, 75, 90 -> 6 numbers
     * 
     * s3 = (3 + 99) * 33 / 2
     * s3 = 99 * (99 + 1) * 3 / 2
     * 
     * s5 = (5 + 95) * 19 / 2
     * s5 = 19 * (19 + 1) * 5 / 2
     * 
     * s15 = (15 + 90) * 6 / 2
     * s15 = 6 * (6 + 1) * 15 / 2
     * 
     * sum = s3 + s5 - s15
     * 
     * @param value
     * @return sum
     */
    public long calculateSumOfMultipleOf3And5(int num) {
        long sumOfMultipleOf3 = sumOfMultipleStep(num, 3);
        long sumOfMultipleOf5 = sumOfMultipleStep(num, 5);
        long sumOfMultipleOf15 = sumOfMultipleStep(num, 15);
        return sumOfMultipleOf3 + sumOfMultipleOf5 - sumOfMultipleOf15;
    }

    public long countOfMultipleStep(int endInclusive, int step) {
        return endInclusive / step;
    }

    /**
     * 
     * @param endInclusive
     * @param step
     * @return n * (n + 1) * step / 2
     */
    public long sumOfMultipleStep(int endInclusive, int step) {
        long count = this.countOfMultipleStep(endInclusive, step);
        return count * (count + 1) * step / 2;
    }

    @Test
    public void testCountOfMultipleStep() {
        assertThat(countOfMultipleStep(8, 3)).isEqualTo(2L);
        assertThat(countOfMultipleStep(9, 3)).isEqualTo(3L);
        assertThat(countOfMultipleStep(10, 3)).isEqualTo(3L);
        assertThat(countOfMultipleStep(11, 3)).isEqualTo(3L);
        assertThat(countOfMultipleStep(12, 3)).isEqualTo(4L);
        assertThat(countOfMultipleStep(99, 3)).isEqualTo(33L);
        assertThat(countOfMultipleStep(999, 3)).isEqualTo(333L);
        assertThat(countOfMultipleStep(1000, 3)).isEqualTo(333L);
        assertThat(countOfMultipleStep(1001, 3)).isEqualTo(333L);

        assertThat(countOfMultipleStep(9, 5)).isEqualTo(1L);
        assertThat(countOfMultipleStep(10, 5)).isEqualTo(2L);
        assertThat(countOfMultipleStep(11, 5)).isEqualTo(2L);
        assertThat(countOfMultipleStep(12, 5)).isEqualTo(2L);
        assertThat(countOfMultipleStep(13, 5)).isEqualTo(2L);
        assertThat(countOfMultipleStep(14, 5)).isEqualTo(2L);
        assertThat(countOfMultipleStep(15, 5)).isEqualTo(3L);

        assertThat(countOfMultipleStep(99, 5)).isEqualTo(19L);

        assertThat(countOfMultipleStep(99, 15)).isEqualTo(6L);
    }

    @Test
    public void testSumOfMultipleStep() {
        assertThat(sumOfMultipleStep(8, 3)).isEqualTo(9L);
        assertThat(sumOfMultipleStep(9, 3)).isEqualTo(18L);
        assertThat(sumOfMultipleStep(10, 3)).isEqualTo(18L);
        assertThat(sumOfMultipleStep(11, 3)).isEqualTo(18L);
        assertThat(sumOfMultipleStep(12, 3)).isEqualTo(30L);
        assertThat(sumOfMultipleStep(99, 3)).isEqualTo(1683L);

        assertThat(sumOfMultipleStep(9, 5)).isEqualTo(5L);
        assertThat(sumOfMultipleStep(10, 5)).isEqualTo(15L);
        assertThat(sumOfMultipleStep(11, 5)).isEqualTo(15L);
        assertThat(sumOfMultipleStep(12, 5)).isEqualTo(15L);
        assertThat(sumOfMultipleStep(13, 5)).isEqualTo(15L);
        assertThat(sumOfMultipleStep(14, 5)).isEqualTo(15L);
        assertThat(sumOfMultipleStep(15, 5)).isEqualTo(30L);
        assertThat(sumOfMultipleStep(99, 5)).isEqualTo(950L);

        assertThat(sumOfMultipleStep(99, 15)).isEqualTo(315L);
    }

    @Test
    public void testCalculateSumOfMultipleOf3And5() {
        assertThat(calculateSumOfMultipleOf3And5(9)).isEqualTo(23L);
        assertThat(calculateSumOfMultipleOf3And5(10)).isEqualTo(33L);
        assertThat(calculateSumOfMultipleOf3And5(11)).isEqualTo(33L);
        assertThat(calculateSumOfMultipleOf3And5(12)).isEqualTo(45L);
        assertThat(calculateSumOfMultipleOf3And5(13)).isEqualTo(45L);
        assertThat(calculateSumOfMultipleOf3And5(14)).isEqualTo(45L);
        assertThat(calculateSumOfMultipleOf3And5(15)).isEqualTo(60L);
        assertThat(calculateSumOfMultipleOf3And5(16)).isEqualTo(60L);
        assertThat(calculateSumOfMultipleOf3And5(99)).isEqualTo(2318L);
        assertThat(calculateSumOfMultipleOf3And5(100)).isEqualTo(2418L);
        assertThat(calculateSumOfMultipleOf3And5(999)).isEqualTo(233168L);
        assertThat(calculateSumOfMultipleOf3And5(1000)).isEqualTo(234168L);
        assertThat(calculateSumOfMultipleOf3And5(9999)).isEqualTo(23331668L);
        assertThat(calculateSumOfMultipleOf3And5(10000)).isEqualTo(23341668L);
        assertThat(calculateSumOfMultipleOf3And5(100000)).isEqualTo(2333416668L);
        assertThat(calculateSumOfMultipleOf3And5(1000000)).isEqualTo(233334166668L);
        assertThat(calculateSumOfMultipleOf3And5(10000000)).isEqualTo(23333341666668L);
        assertThat(calculateSumOfMultipleOf3And5(100000000)).isEqualTo(2333333416666668L);
    }
}
