package com.san.collection;



//This class' object is used as key
//in the HashMap
class Key_BadImplementation{
	int index;
	String Name;
	Key_BadImplementation(int index, String Name){
		this.index = index;
		this.Name = Name;
	}

@Override
// A very bad implementation of hashcode
// done here for illustrative purpose only 
	public int hashCode(){
		return 5;
	}

@Override
// A very bad implementation of equals
// done here for illustrative purpose only 
	public boolean equals(Object obj){
		return true;
	}

}

