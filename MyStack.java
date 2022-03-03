import java.util.ArrayList;
/**@Author Diego Ramos
 * By Diego Ramos 3/3/22
 * A generic stack data structure.
 * 
 */
public class MyStack <T> implements StackInterface<T> {
	
	ArrayList <T> stackOfStrings;
	int maxSize;

	/**
	 * A default constructor.
	 * */
	
	public MyStack() {
		stackOfStrings = new ArrayList<>();
	}
	/**A parameterized constructor.
	 * @param An int value that determines the capacity of the stack.
	 * */
	public MyStack(int size) {
		stackOfStrings = new ArrayList<>();
		maxSize = size;
	}
	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		if(stackOfStrings.size() == 0)
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
		if(stackOfStrings.size() == this.maxSize)
			return true;
		else
			return false;
	}
	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	@Override
	public T pop() throws StackUnderflowException {
		if(this.isEmpty()) {
			
			throw new StackUnderflowException();
		}
			
		T returnElement = stackOfStrings.get(stackOfStrings.size()-1);
		stackOfStrings.remove(stackOfStrings.size()-1);
		
		return (T) returnElement;
	}
	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	@Override
	public T top() throws StackUnderflowException {
		if(this.isEmpty()) 
			throw new StackUnderflowException();
			
		T returnElement = stackOfStrings.get(stackOfStrings.size()-1);
		
		return (T) returnElement;
	}
	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	@Override
	public int size() {
		return stackOfStrings.size();
	}
	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 * @throws StackOverflowException if stack is full
	 */
	@Override
	public boolean push(T e) throws StackOverflowException {
		if(this.isFull())
			throw new StackOverflowException();
			
		stackOfStrings.add(e);
			return true;
	}
	/**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	@Override
	public String toString() {
		
		String returnString = "";
		
		for(int i = 0; i < stackOfStrings.size();i++)
				returnString += stackOfStrings.get(i);
	
		return returnString;
		
		/*Reverse return
		 * 
		 * String stackFormString = "";
		
		for(int i = stackOfStrings.length()-1;i >= 0; i--)
			stackFormString += Character.toString(stackOfStrings.charAt(i));
		
		return stackFormString;*/
	}
	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		
			String withDelimeters="";
			
			for(int i = 0; i < stackOfStrings.size();i++)
				
				if(i != stackOfStrings.size()-1)
					withDelimeters += stackOfStrings.get(i) + delimiter;
				else 
					withDelimeters += stackOfStrings.get(i);
				
			return withDelimeters;
	}
	 /**
	  * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
	  * is the first bottom element of the Stack
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE STACK, if you use the
	  * list reference within your Stack, you will be allowing direct access to the data of
	  * your Stack causing a possible security breech.
	  * @param list elements to be added to the Stack from bottom to top
	  * @throws StackOverflowException if stack gets full
	  */
	@Override
	public void fill(ArrayList<T> list) {
		ArrayList<T> listCopy = new ArrayList<>();
		
		for(T element: list)
			listCopy.add(element);
		
		for(T s: listCopy)
			this.push(s);
		
	}

}
