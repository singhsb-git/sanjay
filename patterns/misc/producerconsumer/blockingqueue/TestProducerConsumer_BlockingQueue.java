package com.san.patterns.misc.producerconsumer.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestProducerConsumer_BlockingQueue {

    public static void main(String args[]){
   
     //Creating shared object
     BlockingQueue sharedQueue = new LinkedBlockingQueue();
  
     //Creating Producer and Consumer Thread
     Thread prodThread = new Thread(new Producer(sharedQueue));
     Thread consThread = new Thread(new Consumer(sharedQueue));

     //Starting producer and Consumer thread
     prodThread.start();
     consThread.start();
    }
  
}

