package com.example.algorithm;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * title: Floyd's cycle finding algorithm, Hare-Tortoise algorithm
 * date: 2025-05-18
 * tags: java, algorithm, Floyd's cycle finding algorithm, Hare-Tortoise algorithm, Detect Loop or Cycle in Linked List
 */
class FloydsCycleFindingAlgorithmTest {

    class Node {

        int data;
        Node next;

        Node(int x) {
            this.data = x;
            this.next = null;
        }
    }

    boolean isLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            System.out.printf("slow = %s, fast = %s \n", slow.data, fast.data);
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        Node n6 = new Node(6);
        Node n5 = new Node(5);
        Node n4 = new Node(4);
        Node n3 = new Node(3);
        Node n2 = new Node(2);
        Node n1 = new Node(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n5;
        assertThat(isLoop(n1)).isTrue();

        Node n8 = new Node(8);
        Node n7 = new Node(7);
        n7.next = n8;
        assertThat(isLoop(n1)).isFalse();

        Node n10 = new Node(10);
        Node n9 = new Node(9);
        n9.next = n10;
        n10.next = n9;
        assertThat(isLoop(n9)).isTrue();
    }
}
