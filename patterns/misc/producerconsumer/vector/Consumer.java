package com.san.patterns.misc.producerconsumer.vector;

import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Consumer implements Runnable {

    private final Vector sharedQueue;
    private final int SIZE;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    public Consumer(Vector sharedQueue, int size) {
        this.sharedQueue = sharedQueue;
        this.SIZE = size;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumed: " + consume());
                Thread.sleep(50);
            } catch (InterruptedException ex) {
            	LOGGER.error("****** Error ******");
            }

        }
    }

    private int consume() throws InterruptedException {
        //wait if queue is empty
        while (sharedQueue.isEmpty()) {
            synchronized (sharedQueue) {
                System.out.println("Queue is empty " + Thread.currentThread().getName()
                                    + " is waiting , size: " + sharedQueue.size());

                sharedQueue.wait();
            }
        }

        //Otherwise consume element and notify waiting producer
        synchronized (sharedQueue) {
            sharedQueue.notifyAll();
            return (Integer) sharedQueue.remove(0);
        }
    }
}
