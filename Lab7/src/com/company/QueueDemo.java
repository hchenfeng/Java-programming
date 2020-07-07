package com.company;

public class QueueDemo {

    public static void main(String[] args) {
        // create a queue of strings
        ArrayQueue<String> stringArrayQueue = new ArrayQueue<>();

        // add three strings to the queue
        stringArrayQueue.enQueue("add");
        stringArrayQueue.enQueue("three");
        stringArrayQueue.enQueue("strings");

        // remove two strings from the queue
        stringArrayQueue.deQueue();
        stringArrayQueue.deQueue();

        // display all elements in the queue
        System.out.println("One element in queue:");
        System.out.println(stringArrayQueue.toString());

        // add two strings to the queue
        stringArrayQueue.enQueue("are");
        stringArrayQueue.enQueue("added");

        // remove one string from the queue
        stringArrayQueue.deQueue();

        // display the list of strings in the queue
        System.out.println();
        System.out.println("Two elements in queue:");
        System.out.println(stringArrayQueue.toString());

        // create a queue of coins
        ArrayQueue<Coin> coinArrayQueue=new ArrayQueue<>();

        // add three coins to the queue
        coinArrayQueue.enQueue(new Coin(0.25, "quarter"));
        coinArrayQueue.enQueue(new Coin(0.10, "dime"));
        coinArrayQueue.enQueue(new Coin(0.05, "nickel"));

        // remove one coin to the queue
        coinArrayQueue.deQueue();

        // display the list of coins in the queue
        System.out.println();
        System.out.println("Two coins in queue:");
        System.out.println(coinArrayQueue.toString());
    }
}
