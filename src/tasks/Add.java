package tasks;
/**
 * Example for a Task with Command Pattern
 * @author Michael Stoeger
 * @version 4.4.2016
 */
public class Add implements Task{
	private int i1,i2;
	/**
	 * Saves two integer values, which get added when execute is called
	 * @param i1
	 * @param i2
	 */
	public Add(int i1,int i2){
		this.i1=i1;
		this.i2=i2;
	}
	@Override
	/**
	 * Adds both integer values and prints the result
	 */
	public void execute() {
		System.out.println(i1+"+"+i2+"="+i1+i2);
	}
}
