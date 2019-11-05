package com.san.newfeatures.java8;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream_ReadWriteTextFile {

	public static void main(String args[]) {

		String fileName = "C:\\Data\\Input\\Sample_JSON_1.txt";

		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			stream.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Reading thru BufferedReader
		List<String> list = new ArrayList<>();

		try  {

			BufferedReader br = Files.newBufferedReader(Paths.get(fileName));
			//br returns as stream and convert it into a List
			list = br.lines().collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}

		list.forEach(System.out::println);

        // write to different file		
		try{
			final FileWriter fw = new FileWriter("C:\\Data\\Input\\Sample_JSON_2.txt");
			list.stream()
	        .forEach(line -> writeToFile(fw, line));
	        fw.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void writeToFile(FileWriter fw, String line) {
        try {
            fw.write(String.format("%s%n", line));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
	
}