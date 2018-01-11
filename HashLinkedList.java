package assignment4;

//NAME: RAMSHA IJAZ
//ID: 260665762

public class HashLinkedList<K,V>{
	/*
	 * Fields
	 */
	private HashNode<K,V> head;

	private Integer size;

	/*
	 * Constructor
	 */

	HashLinkedList(){
		head = null;
		size = 0;
	}


	/*
	 *Add (Hash)node at the front of the linked list
	 */

	public void add(K key, V value){

		// ADD CODE BELOW HERE

		HashNode<K, V> newNode = new HashNode <K, V>(key, value);
		size++;

		if(head == null) {
			head = newNode;
		}
		else {
			newNode.next = head;
			head = newNode;
		}


		// ADD CODE ABOVE HERE
	}

	/*
	 * Get Hash(node) by key
	 * returns the node with key
	 */

	public HashNode<K,V> getListNode(K key){

		// ADD CODE BELOW HERE

		HashNode <K, V> curr = head;
		while(curr != null) {
			if(curr.getKey().equals(key)) {
				return curr;
			}
			curr=curr.getNext();

		}
		return null;

		// ADD CODE ABOVE HERE
	}


	/*
	 * Remove the head node of the list
	 * Note: Used by remove method and next method of hash table Iterator
	 */

	public HashNode<K,V> removeFirst(){

		// ADD CODE BELOW HERE

		if(size == 0) {
			return null;
		}
		else {
			HashNode<K, V> curr = head;
			head = head.next;
			size--;
			return curr;

		} 

		// ADD CODE ABOVE HERE
	}

	/*
	 * Remove Node by key from linked list 
	 */

	public HashNode<K,V> remove(K key){

		// ADD CODE BELOW HERE

		HashNode<K, V> curr = head;
		HashNode<K, V> prev = null;
		while(curr != null) {
			if(curr.getKey().equals(key)) {
				if(prev == null) {
					head=head.next;
				}
				else{
					prev.next=curr.next;
				}
				size --;
				return curr;


			}
			else {
				prev = curr;
				curr=curr.next;
			}

		}

		// ADD CODE ABOVE HERE
		return null; // removing failed
	}



	/*
	 * Delete the whole linked list
	 */
	public void clear(){
		head = null;
		size = 0;
	}
	/*
	 * Check if the list is empty
	 */

	boolean isEmpty(){
		return size == 0? true:false;
	}

	int size(){
		return this.size;
	}

	//ADD YOUR HELPER  METHODS BELOW THIS

	//returns head node

	public HashNode <K, V> getHead (){
		return head;
	}

	//ADD YOUR HELPER METHODS ABOVE THIS


}
