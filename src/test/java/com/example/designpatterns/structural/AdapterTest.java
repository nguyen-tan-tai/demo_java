package com.example.designpatterns.structural;

import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-15 tags: java, design patterns, structural, adapter
 */
class AdapterTest {

    interface Printer {
        void print();
    }

    class LegacyPrinter {
        void printDocument() {
            System.out.println("Legacy Printer is printing a document.");
        }
    }

    class PrinterAdapter implements Printer {

        private LegacyPrinter legacyPrinter;

        public void print() {
            legacyPrinter.printDocument();
        }
    }

    @Test
    public void test() {
        PrinterAdapter adapter = new PrinterAdapter();
        adapter.print();
    }
}
