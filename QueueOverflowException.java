

public class QueueOverflowException extends RuntimeException{

	/**occurs when a  dequeue method is called on an empty queue.
	 * @param message
	 */
	public QueueOverflowException() {
		super("Error, the queue is empty.");
		// TODO Auto-generated constructor stub
	}

}
