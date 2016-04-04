package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
/**
 * RMI Command Pattern Server Example
 * @author Michael Borko, Michael Stoeger
 * @version 4.4.2016
 */
public class Server {

	/**
	 * Creates a new registry and registers a service
	 * 
	 * Waits for work until "Enter" gets pressed
	 * @param args
	 */
	public static void main(String[] args) {

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		try {
			ServerService uRemoteObject = new ServerService();
			WorkingService stub = (WorkingService) UnicastRemoteObject.exportObject(uRemoteObject, 0);
			//Create registry and register service
			Registry registry = LocateRegistry.createRegistry(1234);
			registry.rebind("MyWorkingService", stub);
			
			System.out.println("Service bound! Press Enter to terminate ...");
			
			while (System.in.read() != '\n');
			//Shutting down server
			UnicastRemoteObject.unexportObject(uRemoteObject, true);
			System.out.println("Service unbound, System goes down ...");

		} catch (RemoteException re) {
			System.err.println("Service already bound?" + " Check your RMI-Registry settings!");
			re.printStackTrace();
			System.exit(1);
		} catch (Exception e) {
			System.err.println("Service exception:");
			e.printStackTrace();
			System.exit(1);
		}

	}

}
