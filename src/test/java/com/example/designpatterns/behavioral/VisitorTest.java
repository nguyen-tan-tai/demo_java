package com.example.designpatterns.behavioral;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-15 tags: java, design patterns, behavioral, visitor
 */
class VisitorTest {
    interface ShoppingCartItem {
        double accept(ShoppingCartVisitor visitor);
    }

    class Book implements ShoppingCartItem {
        private String title;
        private double price;

        public Book(String title, double price) {
            this.title = title;
            this.price = price;
        }

        public double getPrice() {
            return price;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public double accept(ShoppingCartVisitor visitor) {
            return visitor.visit(this);
        }
    }

    class Clothing implements ShoppingCartItem {
        private String name;
        private double price;

        public Clothing(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public double getPrice() {
            return price;
        }

        public String getName() {
            return name;
        }

        @Override
        public double accept(ShoppingCartVisitor visitor) {
            return visitor.visit(this);
        }
    }

    interface ShoppingCartVisitor {
        double visit(Book book);

        double visit(Clothing clothing);
    }

    class DiscountCalculator implements ShoppingCartVisitor {
        @Override
        public double visit(Book book) {
            return book.getPrice() * 0.9; // 10% discount for books
        }

        @Override
        public double visit(Clothing clothing) {
            return clothing.getPrice() * 0.8; // 20% discount for clothing
        }
    }

    class ShoppingCart {
        private List<ShoppingCartItem> items = new ArrayList<>();

        public void addItem(ShoppingCartItem item) {
            items.add(item);
        }

        public double calculateTotal(ShoppingCartVisitor visitor) {
            double total = 0;
            for (ShoppingCartItem item : items) {
                total += item.accept(visitor);
            }
            return total;
        }
    }

    @Test
    public void test() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Book("Design Patterns", 2));
        cart.addItem(new Clothing("T-Shirt", 4));
        cart.addItem(new Book("Clean Code", 5));
        cart.addItem(new Clothing("Jeans", 8));

        DiscountCalculator discountCalculator = new DiscountCalculator();
        assertThat(cart.calculateTotal(discountCalculator)).isEqualTo(15.9d);
    }
}
