
public class StackOverflowException extends RuntimeException{

	/**occurs when a push method is called on a full stack.
	 * @param message
	 */
	public StackOverflowException() {
		super("Error, the stack is full");
		// TODO Auto-generated constructor stub
	}

	

}
