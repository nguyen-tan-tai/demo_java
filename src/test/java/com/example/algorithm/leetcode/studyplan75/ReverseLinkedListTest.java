package com.example.algorithm.leetcode.studyplan75;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * date: 2025-06-05
 * tags: java, algorithm, link list, recursion
 */
class ReverseLinkedListTest {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 1 2 3 4
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode rest = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    // 1 2 3 4
    public ListNode reverseList2(ListNode head) {
        ListNode currentTarget = head;
        ListNode previousTarget = null;
        ListNode nextTarget = null;
        while (currentTarget != null) {
            nextTarget = currentTarget.next;
            currentTarget.next = previousTarget;
            previousTarget = currentTarget;
            currentTarget = nextTarget;
        }
        return previousTarget;
    }

    @Test
    public void test() {
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode node1Reversed = reverseList(node1);
        assertThat(node1Reversed.val).isEqualTo(4);
        assertThat(node1Reversed.next.val).isEqualTo(3);
        assertThat(node1Reversed.next.next.val).isEqualTo(2);
        assertThat(node1Reversed.next.next.next.val).isEqualTo(1);
    }
}
