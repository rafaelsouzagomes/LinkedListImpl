package datastruture;

import java.util.NoSuchElementException;

public class LinkedList<T> {
	 private Node<T> head;
	    private int size;
	    
	    private static class Node<T> {
	        private T data;
	        private Node<T> next;
	        
	        public Node(T data) {
	            this.data = data;
	            this.next = null;
	        }
	    }
	    
	    public LinkedList() {
	        this.head = null;
	        this.size = 0;
	    }
	    
	    public boolean isEmpty() {
	        return size == 0;
	    }
	    
	    public int size() {
	        return size;
	    }
	    
	    public void addFirst(T data) {
	        Node<T> newNode = new Node<>(data);
	        newNode.next = head;
	        head = newNode;
	        size++;
	    }
	    
	    public void addLast(T data) {
	        if (isEmpty()) {
	            addFirst(data);
	        } else {
	            Node<T> newNode = new Node<>(data);
	            Node<T> current = head;
	            while (current.next != null) {
	                current = current.next;
	            }
	            current.next = newNode;
	            size++;
	        }
	    }
	    
	    public T removeFirst() {
	        if (isEmpty()) {
	            throw new NoSuchElementException("LinkedList is empty.");
	        } else {
	            Node<T> removedNode = head;
	            head = head.next;
	            size--;
	            return removedNode.data;
	        }
	    }
	    
	    public T removeLast() {
	        if (isEmpty()) {
	            throw new NoSuchElementException("LinkedList is empty.");
	        } else if (size == 1) {
	            return removeFirst();
	        } else {
	            Node<T> current = head;
	            while (current.next.next != null) {
	                current = current.next;
	            }
	            Node<T> removedNode = current.next;
	            current.next = null;
	            size--;
	            return removedNode.data;
	        }
	    }
	    
	    public void printList() {
	        Node<T> current = head;
	        while (current != null) {
	            System.out.print(current.data + " ");
	            current = current.next;
	        }
	        System.out.println();
	    }
	    
	    public static void main(String[] args) {
	        LinkedList<String> list = new LinkedList<>();
	        list.addLast("apple");
	        list.addLast("banana");
	        list.addLast("cherry");
	        list.printList();
	        list.removeFirst();
	        list.printList();
	        list.removeLast();
	        list.printList();
	    }
}
