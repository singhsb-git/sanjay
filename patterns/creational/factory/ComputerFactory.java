package com.san.patterns.creational.factory;

import com.san.patterns.creational.factory.Computer;
import com.san.patterns.creational.factory.PC;
import com.san.patterns.creational.factory.Server;

public class ComputerFactory {

	public static Computer getComputer(String type, String ram, String hdd, String cpu){
		if("PC".equalsIgnoreCase(type)) return new PC(ram, hdd, cpu);
		else if("Server".equalsIgnoreCase(type)) return new Server(ram, hdd, cpu);
		
		return null;
	}
}