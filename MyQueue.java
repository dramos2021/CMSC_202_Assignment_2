import java.util.ArrayList;
/**@Author Diego Ramos
 * By Diego Ramos 3/3/22
 * A generic queue data structure.
 * 
 */

public class MyQueue<T> implements QueueInterface<T> {
	ArrayList <T> dataList;
	int maxSize;
	
	
	
	public MyQueue() {
		dataList = new ArrayList<>();
		
	}
	/**A parameterized constructor.
	 * @param An int that sets up the capacity of the queue. 
	 * */
	public MyQueue(int size) {
		
		dataList = new ArrayList<>();
		maxSize = size;
	}
	 /**Determines of the Queue is Full
	 * @return true if Queue is full, false if not*/
	@Override
	public boolean isEmpty() {
		
		if(dataList.size() == 0)
			return true;
		else
			return false;
	}
	/**
	 * Determines of the Queue is Full
	 * @return true if Queue is full, false if not
	 */
	@Override
	public boolean isFull() {
		if(dataList.size() == this.maxSize)
			return true;
		else
			return false;
	}
	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 * @throws QueueUnderflowException if queue is empty
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {
		if(this.isEmpty()) 
			throw new QueueUnderflowException();
			
		T returnElement = dataList.get(0);
		dataList.remove(0);
		
		return (T) returnElement;
	}
	/**
	 * Returns number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	@Override
	public int size() {
		
		return dataList.size();
	}
	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful
	 * @throws QueueOverflowException if queue is full
	 */
	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		if(this.isFull())
			throw new QueueOverflowException();
			
		dataList.add(e);
			return true;	
	}
	
	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
	@Override
	public String toString() {
		String returnString = "";
		
		for(int i = 0; i < dataList.size();i++)
				returnString += dataList.get(i);
			
		return returnString;
	}
	
	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		String withDelimeters="";
		
		for(int i = 0; i < dataList.size();i++)
			
			if(i != dataList.size()-1)
				withDelimeters += dataList.get(i) + delimiter;
			else 
				withDelimeters += dataList.get(i);
			
		return withDelimeters;
	}
	
	/**
	  * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
	  * is the first element in the Queue
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE QUEUE, if you use the
	  * list reference within your Queue, you will be allowing direct access to the data of
	  * your Queue causing a possible security breech.
	  * @param list elements to be added to the Queue
	  * @throws QueueOverflowException if queue is full
	 
	  */
	@Override
	public void fill(ArrayList<T> list) {
		ArrayList<T> listCopy = new ArrayList<>();
		
		for(T element: list)
			listCopy.add(element);
		
		for(T s: listCopy)
			this.enqueue(s);
		
	}


}
