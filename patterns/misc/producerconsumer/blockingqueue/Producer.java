package com.san.patterns.misc.producerconsumer.blockingqueue;

import java.util.concurrent.BlockingQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Producer implements Runnable {

    private final BlockingQueue sharedQueue;
    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    public Producer(BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            try {
                System.out.println("Produced: " + i);
                sharedQueue.put(i);
            } catch (InterruptedException ex) {
              //  Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            	LOGGER.error("****** Error ******");
            	ex.printStackTrace();
            }
        }
    }

}

