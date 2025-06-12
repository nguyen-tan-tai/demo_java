package com.example.lang;

/**
 * date: 2025-06-06
 * tags: java, lang, System.exit()
 */
public class SystemExitTest {

    public static void main(String... args) {
        try {
            System.out.println("Hello");
            System.exit(0);
        } finally {
            System.out.println("WEIRD");
        }
    }
}
