package server;

import java.rmi.RemoteException;

import tasks.Task;
/**
 * With this service a client can pass work to the server
 * @author Michael Borko, Michael Stoeger
 */
public class ServerService implements WorkingService {

	@Override
	/**
	 * Gets called to pass work to the server
	 */
	public void work(Task t) throws RemoteException {
		new NonBlockingExecute(t).start();
	}
	/**
	 * Executes Task in another Thread
	 * @author Michael Stoeger
	 * @version 5.4.2016
	 */
	private class NonBlockingExecute extends Thread{
		private Task t;
		public NonBlockingExecute(Task t){
			this.t=t;
		}
		public void run(){
			t.execute();
		}
	}
}
