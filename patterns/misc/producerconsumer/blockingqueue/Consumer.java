package com.san.patterns.misc.producerconsumer.blockingqueue;

import java.util.concurrent.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


class Consumer implements Runnable{

    private final BlockingQueue sharedQueue;
    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    public Consumer (BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }
   
    @Override
    public void run() {
        while(true){
            try {
                System.out.println("Consumed: "+ sharedQueue.take());
            } catch (InterruptedException ex) {
               // Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            	LOGGER.error("****** Error ******");
            	ex.printStackTrace();
            }
        }
    }
  
 }
