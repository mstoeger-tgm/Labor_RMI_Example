package server;

import java.rmi.RemoteException;

import tasks.Task;
/**
 * With this service a client can pass work to the server
 * @author Michael Borko
 */
public class ServerService implements WorkingService {

	@Override
	/**
	 * Gets called to pass work to the server
	 */
	public void work(Task t) throws RemoteException {
		t.execute();
	}

}
