import java.util.Iterator;


public class Deque<Item> implements Iterable<Item> {
	private Node first = new Node();
	private Node last = new Node();
	private int N;
	private class Node
	   {
		   Item item;
		   Node next;
	   }
   public Deque() {                          // construct an empty deque
	   first = null;
	   last = null;
   }
   public boolean isEmpty() {                // is the deque empty?
	   return N == 0;
   }
   public int size() { 	                     // return the number of items on the deque
	   return N;
   }
   public void addFirst(Item item) {         // add the item to the front
	   if (item == null) {
		  throw new java.lang.NullPointerException();
	   }
	   Node oldfirst = first;
	   first = new Node();
	   first.item = item;
	   first.next = oldfirst;
	   N++;
	   if (N == 1) last = first;
	   
   }
   public void addLast(Item item) {          // add the item to the end
	   if (item == null) {
			  throw new java.lang.NullPointerException();
		   }
	   Node oldlast = last;
	   last = new Node();
	   last.item = item;
	   last.next = null;
	   if (isEmpty()) first = last;
	   else oldlast.next = last;
	   N++;
   }
   public Item removeFirst() {               // remove and return the item from the front
	   if (N == 0) {
		   throw new java.util.NoSuchElementException();
	   }
	   Item item = first.item;
	   first = first.next;
	   N--;
	   if (isEmpty()) last = null;
	   return item;
   }
   public Item removeLast() {                // remove and return the item from the end
	   if (N == 0) {
		   throw new java.util.NoSuchElementException();
	   }
	   Item item = last.item;
	   N--;
	   Node tmp = first;
	   for (int i = 0; i < N-1; ++i) {
		   tmp = tmp.next;
	   }
	   if (isEmpty()) {
		   first = null;
		   last = null;
	   } else {
		   last = tmp;
		   last.next = null;
	   }
	   
	   return item;
   }
   public Iterator<Item> iterator() {        // return an iterator over items in order from front to end
	   return new ListIterator();
   }
   private class ListIterator implements Iterator<Item> {
	   private Node current = first;
	   
	   public boolean hasNext() {
		   return current != null;
	   }
	   public void remove() {
		   throw new java.lang.UnsupportedOperationException();
	   }
	   public Item next() {
		   if (current == null) {
			   throw new java.util.NoSuchElementException();
		   }
		   Item item = current.item;
		   
		   current = current.next;
		   return item;
	   }
   }
   public static void main(String[] args) {  // unit testing
	   Deque<String> q = new Deque<String>();
	   q.addFirst("a");
	   q.addFirst("b");
	   q.addLast("c");
	   while(!q.isEmpty()){
		   System.out.println(q.removeFirst());
	   }
	   //System.out.println(q.removeLast());
   }
   
}