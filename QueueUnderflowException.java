
public class QueueUnderflowException extends RuntimeException{

	/**occurs when a  dequeue method is called on an empty queue.
	 * @param message
	 */
	public QueueUnderflowException() {
		super("Error, the queue is empty.");
		// TODO Auto-generated constructor stub
	}

}
