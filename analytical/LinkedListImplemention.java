package com.san.analytical;


public class LinkedListImplemention {
	
	private Node head;
	 
	private static class Node {
		private int value;
		private Node next;
 
		Node(int value) {
			this.value = value;
 
		}
	}
	
	public void add(Node node) {
		 
		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;
 
			temp.next = node;
		}
	}
	
	
	public void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.format("%d ", temp.value);
			temp = temp.next;
		}
		System.out.println();
	}
	
	
	public static Node reverseLinkedList(Node currentNode)
	{
		// For first node, previousNode will be null
		Node previousNode=null;
		Node nextNode;
		while(currentNode!=null)
		{
			nextNode=currentNode.next;
			// reversing the link
			currentNode.next=previousNode;
			// moving currentNode and previousNode by 1 node
			previousNode=currentNode;
			currentNode=nextNode;
		}
		
		return previousNode;
	}
	
	public static String ReverseString(String str){
		 
		 String tmpStr = "";
		 
		for(int i = str.length()-1; i >= 0; i--){
			tmpStr += str.charAt(i);
		}
		 
		return tmpStr;
	 }
	
	
	 // Function to check if linked list is palindrome or not
	 public static boolean checkPalindrome_thru_StringReverse (Node head)
	 {
		 String origVal = "";
		 Node tmp = head;
		 
		 // Read the original value into a string 
		 while(tmp != null){
			 origVal += String.valueOf(tmp.value);
			 tmp = tmp.next;
		 }
		 
		 // Check palindrome by String reverse
		 String tmpStr = ReverseString(origVal);
		 
		 if(origVal.compareTo(tmpStr) == 0){
			 //System.out.println("Palindrome Check = true, reversed string="+tmpStr);
			 return true;
		 }
		 else
		 {
			// System.out.println("Palindrome Check = false, reversed string="+tmpStr);
			 return false;
		 }
	 }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedListImplemention list = new LinkedListImplemention();
		// Creating a linked list
		Node head=new Node(5);
		list.add(head);
		list.add(new Node(6));
		list.add(new Node(7));
		list.add(new Node(1));
		list.add(new Node(2));
	
		System.out.println("Original String before reversing");
		list.printList(head);
		
		//Reversing LinkedList
		Node reverseHead=reverseLinkedList(head);
		System.out.println("After reversing");
				
		list.printList(reverseHead);
		
		LinkedListImplemention list1 = new LinkedListImplemention();
		// Creating a linked list
		Node head1=new Node(5);
		list1.add(head1);
		list1.add(new Node(6));
		list1.add(new Node(2));
		list1.add(new Node(6));
		list1.add(new Node(5));
		//list1.add(new Node(6));
		
		System.out.println("Original String before Palindrome Check");
		list.printList(head1);
		
		System.out.println("Linked list palidrome thru String reversal: "+checkPalindrome_thru_StringReverse(head1));

	}

}
