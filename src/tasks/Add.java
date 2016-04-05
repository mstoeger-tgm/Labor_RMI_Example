package tasks;

import java.rmi.RemoteException;

import client.Callback;

/**
 * Example for a Task with Command Pattern and Callback
 * @author Michael Stoeger
 * @version 4.4.2016
 */
public class Add implements Task{
	private int i1,i2;
	private Callback<String> c;
	/**
	 * Saves two integer values, which get added when execute is called
	 * @param i1
	 * @param i2
	 */
	public Add(int i1,int i2, Callback<String> c){
		this.i1=i1;
		this.i2=i2;
		this.c = c;
	}
	@Override
	/**
	 * Adds both integer values and prints the result
	 */
	public void execute() {
		try {
			c.callback(i1+"+"+i2+"="+i1+i2);
		} catch (RemoteException e) {
			System.out.println("Error when calling callback");
		}
	}
}
