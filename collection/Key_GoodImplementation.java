package com.san.collection;

public class Key_GoodImplementation {

	int index;
	String Name;
	Key_GoodImplementation(int index, String Name){
		this.index = index;
		this.Name = Name;
	}

@Override
// A very bad implementation of hashcode
// done here for illustrative purpose only 
	public int hashCode(){
		System.out.println("hashCode()=> index : hashCode -->"+index+" : "+index%2);
		return index%2;
	}

@Override
// A very bad implementation of equals
// done here for illustrative purpose only 
	public boolean equals(Object obj){
	System.out.println("equals()=> this.index == obj.index -> "+this.index+ "==" +((Key_GoodImplementation)obj).index+" -->"+(this.index == ((Key_GoodImplementation)obj).index));
		return (this.index == ((Key_GoodImplementation)obj).index);
	}

}

