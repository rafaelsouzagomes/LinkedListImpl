package datastruture;

import java.util.List;
import java.util.NoSuchElementException;

public class LinkedList<T> {
	 public Node<T> head;
	    public int size;
	    
	    public static class Node<T> {
	        public T data;
	        public Node<T> next;
	        
	        public Node(T data) {
	            this.data = data;
	            this.next = null;
	        }
	        public Node() {}
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

		public static Node<Integer> findMidleNode(LinkedList<Integer> linkedList) {
			Node<Integer> runnerSlow = linkedList.head;
			Node<Integer>  runnerFast = linkedList.head;
			
			while(runnerFast.next != null && runnerFast.next.next !=null) {
				runnerSlow = runnerSlow.next;
				runnerFast = runnerFast.next.next;
			}
			
			return runnerSlow;
		}

		public static void printListWithRecursion(Node<Integer> node) {
			if(node !=null) {
				System.out.println(node.data);
				printListWithRecursion(node.next);
			}
		}

		public static int sizeWithRecursion(Node<Integer> node) {
			if(node == null) {
				return 0;
			} 
			return 1 + sizeWithRecursion(node.next);
		}

		public static int sumWithRecursion(Node<Integer> node) {
			if(node == null) {
				return Integer.MIN_VALUE;
			}
			int current = node.data;
			int nextMaxValue = sumWithRecursion(node.next);
			return Math.max(current, nextMaxValue);
		}
		
		public static Node<Integer> addTwoNumbers(Node<Integer> l1, Node<Integer> l2) {
			Node<Integer> dummy = new Node();
			Node<Integer> current = dummy;
		    int carry = 0;
		    
		    while (l1 != null || l2 != null || carry > 0) {
		        int sum = carry;
		        
		        if (l1 != null) {
		            sum += l1.data;
		            l1 = l1.next;
		        }
		        
		        if (l2 != null) {
		            sum += l2.data;
		            l2 = l2.next;
		        }
		        
		        carry = sum / 10;
		        sum = sum % 10;
		        
		        current.next = new Node(sum);
		        current = current.next;
		    }
		    
		    return reverse(dummy.next);
		}

		public static Node reverse(Node head) {
			  Node<Integer> current = head;
			  Node<Integer>  previous = null;
			  Node<Integer>  next = null;
			    
			    while (current != null) {
			        next = current.next;
			        current.next = previous;
			        previous = current;
			        current = next;
			    }
			    
			    return previous;
		}

		public static boolean checkIfIsAPalindrome(Node<Character> head) {
			 Node nodeReversed = reverse(head);
			 
			 while(head != null) {
				 if(head.data != nodeReversed.data) {
					 return false;
				 }
				 head = head.next;
				 nodeReversed = nodeReversed.next;
			 }
			 
			return true;
		}


}
