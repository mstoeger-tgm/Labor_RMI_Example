package tasks;

import java.io.Serializable;
/**
 * Task for RMI Command Pattern Example
 * @author Michael Stoeger
 * @version 4.4.2016
 */
public interface Task extends Serializable {
	/**
	 * Is called by server when the task gets executed
	 * Doesn't return anything in this example
	 */
	public void execute();
}
