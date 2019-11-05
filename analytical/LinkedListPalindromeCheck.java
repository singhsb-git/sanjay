package com.san.analytical;

/***
 * 
 * Write java program for checking Palindrome on a custom linkedlist
 * 
 * @author Huskytwin 
 */

public class LinkedListPalindromeCheck{
	 
	 private Node head;
	 
	 private static class Node {
		 private int value;
		 private Node next;
		 
		 Node(int value) {
		 this.value = value;
		 
		 }
	 }
	 
	 public void addToTheLast(Node node) {
	 
		 if (head == null) {
		 head = node;
		 } else {
		 Node temp = head;
		 while (temp.next != null)
		 temp = temp.next;
		 
		 temp.next = node;
		 }
	 }
	 
	 
	 public void printList() {
		 Node temp = head;
		 while (temp != null) {
		 System.out.format("%d ", temp.value);
		 temp = temp.next;
		 }
		 System.out.println();
	 }
	 

	 
	 // Function to check if linked list is palindrome or not
	 public static boolean checkPalindrome (Node head)
	 {
		 String origVal = "";
		 String reversedVal = "";
		 Node tmp = head;
		 
		 // Read the original value into a string 
		 while(tmp != null){
			 origVal += String.valueOf(tmp.value);
			 tmp = tmp.next;
		 }
		 
		 // reverse the string 
		Node reversed = reverseLinkedList(head);
		
		tmp = reversed;
		//Read the value from reversed linkedList
		while(tmp != null){
			reversedVal += tmp.value;
			tmp = tmp.next;
		 }
		
		// re-reverse to orginal-------
		Node reversed_1 = reverseLinkedList(reversed);
		
		// compare String to decide if it is palindrome
		if(origVal.compareTo(reversedVal) == 0)
			return true;
		else
			return false;
		
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
			 System.out.println("Palindrome Check = true, reversed string="+tmpStr);
			 return true;
		 }
		 else
		 {
			 System.out.println("Palindrome Check = false, reversed string="+tmpStr);
			 return false;
		 }
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
	 
	 
	 public static void main(String[] args) {
		 LinkedListPalindromeCheck list = new LinkedListPalindromeCheck();
		 // Creating a linked list
		 Node head=new Node(1);
		 list.addToTheLast(head);
		 list.addToTheLast(new Node(2));
		 list.addToTheLast(new Node(1));
		 list.addToTheLast(new Node(2));
		 list.addToTheLast(new Node(1));
		 //list.addToTheLast(new Node(7));
		 
		 System.out.println("List for Palidrome check: ");
		 list.printList();
		 System.out.println("Linked list palidrome thru LinkedList reversal: "+checkPalindrome(head));
		 System.out.println("List after Palidrome check: ");
		 list.printList();
		 
		 System.out.println("Linked list palidrome thru String reversal: "+checkPalindrome_thru_StringReverse(head));
		 
		 list.addToTheLast(new Node(7));
		 System.out.println("------------------------------------");
		 System.out.println("New List for Palidrome check: ");
		 list.printList();
		 System.out.println("Linked list palidrome: "+checkPalindrome(head));
		 System.out.println("List after Palidrome check: ");
		 list.printList();
		 
		 System.out.println("Linked list palidrome thru String reversal: "+checkPalindrome_thru_StringReverse(head));
		
		 
	 }

}
