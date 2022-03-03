
public class StackUnderflowException extends RuntimeException{

	

	/**occurs when a top or pop method is called on an empty stack.
	 * @param message
	 */
	public StackUnderflowException() {
		super("Error, the stack is empty.");
		// TODO Auto-generated constructor stub
	}

}
