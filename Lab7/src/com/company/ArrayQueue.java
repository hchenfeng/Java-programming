package com.company;

import java.util.ArrayList;

public class ArrayQueue<T> {

    private final ArrayList<T> list;

    public ArrayQueue() {
        // instantiate the queue/list
        list = new ArrayList<>();
    }

    // returns true if the queue is empty, false otherwise
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // adds the element to the end of the queue
    public void enQueue(T element) {
        list.add(element);
    }

    // removes the element at the front of the queue and returns it
    // Throws IndexOutOfBoundsException if queue is empty
    public T deQueue() throws IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("The queue is empty.");
        }
        return list.remove(0);
    }

    // returns a String representation of the queue, which shows
    // a list of elements in the queue
    public String toString() {
        return String.valueOf(list);
    }

    // Removes all occurrences of element from the queue
    public void removeAll(T element) {
        list.removeIf(e -> e.equals(element));
    }
}
