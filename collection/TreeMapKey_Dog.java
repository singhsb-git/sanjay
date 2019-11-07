package com.san.collection;


class TreeMapKey_Dog implements Comparable<TreeMapKey_Dog>{  
	String color;
	int size;
	
	TreeMapKey_Dog(String c, int s) {
		color = c;
		size = s;
	}
	
	public String toString(){
		return "[" + color + " dog, size="+ size + "]";
	}
	
	@Override
	public int compareTo(TreeMapKey_Dog o) {
		return (this.size-o.size);
	}
}
