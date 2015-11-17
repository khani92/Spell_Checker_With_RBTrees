/**
 * The Queue is a first in first out data structure. This Queue holds Java
 * Object references. It grows dynamically as long as memory is available.
 * 
 * @author Nikhil
 */
public class Queue {

	// array to implement the queue
	private Object[] array;

	// items variable to keep track of number of items in the array/queue i.e.
	// size of the data structure
	private int items = 0;
	private int front, rear = 0;

	/**
	 * Create a default empty queue that lives in a small array. PreCondition:
	 * Memory is available. PostCondition: Array created and indexes
	 * established.
	 */
	public Queue() {
		array = new Object[10];
	}

	/**
	 * Boolean method returns true on empty queue, false otherwise. Pre: None
	 * BigTheta No case: Big-Theta (1)
	 * 
	 * @return Returns true if queue is empty.
	 */
	public boolean isEmpty() {
		if (items == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Boolean method returns true if queue is currently at capacity, false
	 * otherwise. If isfull() returns true and additional enqueue calls are
	 * made, the queue will expand in size. Pre: None BigTheta No case:
	 * Big-Theta (1)
	 * 
	 * @return Returns true if queue is at current capacity.
	 */
	public boolean isFull() {
		if (items == array.length) {
			return true;
		}
		return false;
	}

	/**
	 * Object method removes and returns reference in front of queue.
	 * PreCondition: Queue should not be empty. PostCondition: The top/front
	 * item is removed from the queue. BigTheta No case: Big-Theta (1)
	 * 
	 * @return Object from the front of the queue.
	 */
	public Object deQueue() {
		Object data = null;
		if (!isEmpty()) {
			//decrease the items variable to keep the correct count of items
			items--;
			if (front == rear) {
				data = array[front];
				array[front] = null;
			}

			else if (front != rear) {
				data = array[front];
				array[front] = null;
				front = getNext(front);
			}
		}
		return data;
	}

	/**
	 * This method returns the next inderx based on the current index which is
	 * passed as a paramter. It uses modulo operator to implement circular queue
	 * 
	 * @param i
	 *            : current index
	 * @return
	 */
	private int getNext(int i) {
		return (i + 1) % array.length;
	}

	/**
	 * Add an object reference to the rear of the queue. Pre-condition Memory is
	 * available for doubling queue capacity when full. Post-condition: queue
	 * now contains x in the rear.
	 * BigTheta Best case: Queue is not full Big-Theta (1)
	 * BigTheta Worst case: Queue is full Big-Theta (N)
	 * @param x
	 *            : Is an object to be added to the rear of the queue.
	 */
	public void enQueue(Object x) {
		if (isEmpty()) {
			array[front] = x;
		}

		else if (!isFull()) {
			rear = getNext(rear);
			array[rear] = x;
		} else if (isFull()) {
			// Now copy the array to a bigger sized array
			Object[] temp = array;
			// Create a new and bigger array of double size
			array = new Object[temp.length * 2];
			// Copies the small array into the big one
			int count = front;
			for (int i = 0; i < temp.length; i++) {
				array[i] = temp[count];
				count = (count + 1) % temp.length;
			}
			front = 0;
			rear = temp.length;
			array[rear] = x;
			temp = null;
		}
		//increases the count of items
		items++;
	}

	/**
	 * Method getFront returns the front of the queue without removing it.
	 * Pre-condition: queue not empty
	 * BigTheta No case: Big-Theta (1)
	 * @return: The queue front without removal.
	 */
	public Object getFront() {
		Object data = null;
		if (!isEmpty()) {
			data = array[front];
		}
		return data;
	}

	/**
	 * The toString method returns a String representation of the current queue
	 * contents.
	 * BigTheta Best case: Big-Theta (1)
	 * @return: a string representation of the queue. It shows the front of the
	 *          queue first. It then shows the second and third and so on.
	 */
	public String toString() {
		StringBuffer s = new StringBuffer();
		for (int i = front; i != getNext(rear); getNext(i)) {
			s.append(array[i] + "  ");
		}
		return s.toString();
	}

	/**
	 * main is for testing the queue routines.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Queue queue = new Queue();

		for (int i = 0; i < 10; i++) {
			queue.enQueue(i);
		}
		System.out.println(queue.isEmpty());
		System.out.println(queue.isFull());

		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());

		for (int i = 0; i < 80; i++) {
			queue.enQueue(i);
		}
		queue.enQueue(111);
		queue.enQueue(12232);

		queue.enQueue(1212);
		System.out.println(queue.getFront());
	}
}
