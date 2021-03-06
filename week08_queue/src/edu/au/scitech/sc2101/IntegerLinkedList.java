package edu.au.scitech.sc2101;

public class IntegerLinkedList {
	Node head;
	Node tail;
	
	/**
	 * Add to the end of the list.
	 * @param newValue the new value to be added to the list
	 */
	
	public void add(int newValue) {
		// add to the end of the list
		// utilise tail pointer
		
		Node n = new Node(newValue);
		if (head == null) {
			// new list, just update head
			head = n;
			tail = head;
		} else {
			tail.next = n;
			tail = n;
		}
	}
	
	public class Node {
		int value;
		Node next;
		
		// Constructor for this node
		public Node(int v) {
			this.value = v;
			next = null;
		}
	}
	
	/**
	 *  Constructor for this list
	 */
	public IntegerLinkedList() {
		// New empty list
		head = null;
	}
	
	
	public void delete(int pos) {
		Node n = getNode(pos);
		if (n == null) return;
		
		// BE CAREFUL, if pos = 0
		if (pos == 0) {
			head = n.next;
		} else {
			Node prev = getNode(pos-1);
			prev.next = n.next;
		}		
	}
	public void insert(int pos, int newValue) {
		Node n = getNode(pos);
		if (n == null) return;	// do nothing
		Node newNode = new Node(newValue);
		if (pos == 0) {
			newNode.next = n;
			head = newNode;
		} else {
			newNode.next = n;
			Node prev = getNode(pos-1);
			prev.next = newNode;
		}
	}
	public void update(int pos, int newValue) {
		Node n = getNode(pos);
		if (n == null) return;
		n.value = newValue;
	}
	/**
	 * Get the node at the given position
	 * @param pos of the node
	 * @return the node
	 */
	public Node getNode(int pos) {
		
		if (pos >= size()) {
			// There is no node at that pos.
			return null;
		}
		
		Node n = head;
		for(int i=0; i<pos; i++) {
			n = n.next;
		}
		return n;
	}
	
	public void print() {
		// if empty, head is null
		if(head == null) {
			System.out.println("[ ]");
		} else {
			Node cur = head;
			System.out.print("[ ");
			while( cur != null) {
				System.out.print( cur.value );
				System.out.print(" "); 
				cur = cur.next;
			}
			System.out.println("]");
		}		
	}
	
	
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		if(head == null) {
			sb.append("[ ]");
		} else {
			Node cur = head;
			sb.append("[ ");
			while( cur != null) {
				sb.append( cur.value );
				sb.append(" "); 
				cur = cur.next;
			}
			sb.append("]");
		}
		return sb.toString();
	}


	/**
	 * Determine the size of the list
	 * @return size in integer
	 */
	public int size() {
		int s = 0;
		Node cur = head;		
		while( cur != null) {
			cur = cur.next;
			s++;
		}
		return s;
	}
}

