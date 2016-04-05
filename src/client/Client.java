package client;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import server.WorkingService;
import tasks.*;
/**
 * RMI Command Pattern Client Example
 * @author Michael Borko, Michael Stoeger
 * @version 5.4.2016
 */
public class Client {
	/**
	 * Connects to server, sends a task to server and waits for Callback
	 * @param args
	 */
	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		try {
			//Connect to registry
			Registry registry = LocateRegistry.getRegistry(1234);
			WorkingService uRemoteObject = (WorkingService) registry.lookup("MyWorkingService");
			System.out.println("Service found");
			
			//create and export Callback object
			Callback c = new WriteCallback();
			UnicastRemoteObject.exportObject(c, 0);
			
			//run task
			Add t = new Add(2,3,c);
			uRemoteObject.work(t);

		} catch (RemoteException re) {
			System.err.println("Service not found?" + " Check your RMI-Registry!");
			System.exit(1);
		} catch (Exception e) {
			System.err.println("Service exception:");
			e.printStackTrace();
			System.exit(1);
		}
	}
}
