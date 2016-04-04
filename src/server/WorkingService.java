package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import tasks.Task;
/**
 * Interface for ServerService
 * @author Michael Borko, Michael Stoeger
 * @version 4.4.2016
 */
public interface WorkingService extends Remote {
	/**
	 * Decides what to do with the new task
	 * @param c
	 * @throws RemoteException
	 */
	public void work(Task c) throws RemoteException;
}
