package com.example.collection.queue;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-01 tags: java, collection, queue, array deque, priority queue
 */
class QueueTest {

    @Test
    public void testArrayQueue() {
        Queue<String> deque = new ArrayDeque<>();
        deque.add("First");
        deque.add("Second");
        deque.add("Third");
        deque.add("Fourth");
        assertThat(deque).hasSize(4).containsExactly("First", "Second", "Third", "Fourth");
        assertThat(deque.peek()).isEqualTo("First");
        assertThat(deque).hasSize(4).containsExactly("First", "Second", "Third", "Fourth");
        assertThat(deque.poll()).isEqualTo("First");
        assertThat(deque).hasSize(3).containsExactly("Second", "Third", "Fourth");
    }

    @Test
    public void testPriorityQueue() {
        Queue<Employee> queue = new PriorityQueue<>();
        queue.add(new Employee(3L, 30));
        queue.add(new Employee(1L, 10));
        queue.add(new Employee(2L, 20));
        queue.add(new Employee(5L, 50));
        queue.add(new Employee(4L, 40));
        assertThat(queue).hasSize(5);
        assertThat(queue.peek().getId()).isEqualTo(5L);
        assertThat(queue.poll().getId()).isEqualTo(5L);
        assertThat(queue.poll().getId()).isEqualTo(4L);
        assertThat(queue.poll().getId()).isEqualTo(3L);
        assertThat(queue.poll().getId()).isEqualTo(2L);
        assertThat(queue.poll().getId()).isEqualTo(1L);
        assertThat(queue.poll()).isNull();
    }

    static class Employee implements Comparable<Employee> {

        public Employee(long id, int age) {
            this.id = id;
            this.age = age;
        }

        private long id;
        private int age;

        public long getId() {
            return id;
        }

        public int getAge() {
            return age;
        }

        @Override
        public int compareTo(Employee e2) {
            if (this.getAge() != e2.getAge()) {
                return Integer.compare(e2.getAge(), this.getAge());
            }
            return Long.compare(this.getId(), e2.getId());
        }
    }
}
