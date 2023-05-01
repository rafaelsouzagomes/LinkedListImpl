package datastruture;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import datastruture.LinkedList.Node;

/* Técnicas com LinkedLists*/
class LinkedListTest {

	@Test
	void findMiddleNode() {
		
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.addLast(1);
		linkedList.addLast(2);
		linkedList.addLast(3);
		linkedList.addLast(4);
		linkedList.addLast(5);
		linkedList.addLast(6);
		linkedList.addLast(7);
		
		Node<Integer> linkedInTheMiddle = LinkedList.findMidleNode(linkedList);
		
		assertEquals(4, linkedInTheMiddle.data);
	}
	
	@Test
	void printListWithRecursion() {
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.addLast(1);
		linkedList.addLast(2);
		linkedList.addLast(3);
		LinkedList.printListWithRecursion(linkedList.head);
	}
	
	@Test
	void sizeWithRecursion() {
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.addLast(1);
		linkedList.addLast(2);
		linkedList.addLast(3);
		int size =LinkedList.sizeWithRecursion(linkedList.head);
		assertEquals(3, size);
	}
	
	@Test
	void sumWithRecursion() {
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.addLast(1);
		linkedList.addLast(6);
		linkedList.addLast(3);
		int size =LinkedList.sumWithRecursion(linkedList.head);
		assertEquals(6, size);
	}
	
	@Test
	void addTwoNumbers() {
		LinkedList<Integer> l1 = new LinkedList<>();
		l1.addLast(7);
		l1.addLast(1);
		l1.addLast(6);
		
		LinkedList<Integer> l2 = new LinkedList<>();
		l2.addLast(5);
		l2.addLast(9);
		l2.addLast(2);
		
		Node response = LinkedList.addTwoNumbers(l1.head, l2.head);
		
		assertEquals(9, response.data);
		assertEquals(1, response.next.data);
		assertEquals(2, response.next.next.data);
	}
	
	@Test
	void addTwoNumbers2() {
		LinkedList<Integer> l1 = new LinkedList<>();
		l1.addLast(7);
		l1.addLast(1);
		l1.addLast(6);
		
		LinkedList<Integer> l2 = new LinkedList<>();
		l2.addLast(5);
		l2.addLast(9);
		l2.addLast(3);
		
		Node response = LinkedList.addTwoNumbers(l1.head, l2.head);
		assertEquals(1, response.data);
		assertEquals(0, response.next.data);
		assertEquals(1, response.next.next.data);
		assertEquals(2, response.next.next.next.data);
	}
	
	@Test
	void reverseLinkedList() {
		
		LinkedList<Integer> l1 = new LinkedList<>();
		l1.addLast(7);
		l1.addLast(1);
		l1.addLast(6);
	
		Node<Integer> response = LinkedList.reverse(l1.head);
		assertEquals(6, response.data);
		assertEquals(1, response.next.data);
		assertEquals(7, response.next.next.data);
	}
	
	@Test
	void checkIfTheListIsAPalindrome() {
		LinkedList<Character> l1 = new LinkedList<>();
		l1.addLast('a');
		l1.addLast('b');
		l1.addLast('a');
		
		boolean isPalindrome = LinkedList.checkIfIsAPalindrome(l1.head);
		
		assertEquals(true, isPalindrome);
	}
	
	@Test
	void checkIfTheListIsAPalindrome2() {
		LinkedList<Character> l1 = new LinkedList<>();
		l1.addLast('c');
		l1.addLast('a');
		l1.addLast('s');
		l1.addLast('a');
		
		boolean isPalindrome = LinkedList.checkIfIsAPalindrome(l1.head);
		
		assertEquals(false, isPalindrome);
	}
}
