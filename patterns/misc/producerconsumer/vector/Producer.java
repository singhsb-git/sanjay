package com.san.patterns.misc.producerconsumer.vector;

import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


class Producer implements Runnable {

    private final Vector sharedQueue;
    private final int SIZE;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    public Producer(Vector sharedQueue, int size) {
        this.sharedQueue = sharedQueue;
        this.SIZE = size;
    }

    @Override
    public void run() {
        for (int i = 0; i < 7; i++) {
            System.out.println("Produced: " + i);
            try {
                produce(i);
            } catch (InterruptedException ex) {
                LOGGER.error("****** Error ******");
            }

        }
    }

    private void produce(int i) throws InterruptedException {

        //wait if queue is full
        while (sharedQueue.size() == SIZE) {
            synchronized (sharedQueue) {
                System.out.println("Queue is full " + Thread.currentThread().getName()
                                    + " is waiting , size: " + sharedQueue.size());

                sharedQueue.wait();
            }
        }

        //producing element and notify consumers
        synchronized (sharedQueue) {
        	sharedQueue.notifyAll();
            sharedQueue.add(i);
        }
    }
}

