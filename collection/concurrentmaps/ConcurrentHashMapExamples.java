package com.san.collection.concurrentmaps;

import java.util.concurrent.*;
 
public class ConcurrentHashMapExamples {
 
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
 
        new WriterThread(map, "Writer-1", 1).start();
        new WriterThread(map, "Writer-2", 2).start();
 
        for (int i = 1; i <= 5; i++) {
            new ReaderThread(map, "Reader-" + i).start();
        }
    }
}