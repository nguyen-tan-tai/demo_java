package com.example.problemsolving;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import org.junit.jupiter.api.Test;

public class MorganStringTest {

    public static String morganAndStringUsingStack(String a, String b) {
        Queue<Character> sa = new ArrayDeque<>();
        for (Character c : a.toCharArray()) {
            sa.add(c);
        }
        Queue<Character> sb = new ArrayDeque<>();
        for (Character c : b.toCharArray()) {
            sb.add(c);
        }
        StringBuilder output = new StringBuilder();
        while (sa.size() > 0 || sb.size() > 0) {
            Character ca = sa.peek();
            Character cb = sb.peek();
            if (ca == null) {
                output.append(sb.poll());
                continue;
            }
            if (cb == null) {
                output.append(sa.poll());
                continue;
            }
            if (ca.compareTo(cb) <= 0) {
                output.append(sa.poll());
            } else {
                output.append(sb.poll());
            }
        }
        return output.toString();
    }

    public static String morganAndStringArrayCompare(String a, String b) {
        int outputLength = a.length() + b.length();
        a = b + 'z';
        b = b + 'z';
        int la = a.length();
        int lb = b.length();
        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();
        char[] o = new char[outputLength];
        int ia = 0;
        int ib = 0;
        for (int i = 0; i < outputLength; i++) {
            o[i] = Arrays.compare(arrA, ia, la - 1, arrB, ib, lb - 1) < 0 ? arrA[ia++] : arrB[ib++];
        }
        return String.valueOf(o);
    }

    public static String morganAndStringCharCompare(String a, String b) {
        int outputLength = a.length() + b.length();
        int la = a.length();
        int lb = b.length();
        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();
        char[] o = new char[outputLength];
        int ia = 0;
        int ib = 0;
        for (int i = 0; i < outputLength; i++) {
            if (ia >= la) {
                o[i] = arrB[ib++];
                continue;
            }
            if (ib >= lb) {
                o[i] = arrA[ia++];
                continue;
            }
            if (Character.compare(arrA[ia], arrB[ib]) <= 0) {
                o[i] = arrA[ia++];
            } else {
                o[i] = arrB[ib++];
            }
        }
        return String.valueOf(o);
    }

    @Test
    public void test() {
        assertThat(morganAndStringCharCompare("ACAGHJ", "BCF")).isEqualTo("ABCACFGHJ");
        assertThat(morganAndStringCharCompare("JACK", "DANIEL")).isEqualTo("DAJACKNIEL");
    }
}
