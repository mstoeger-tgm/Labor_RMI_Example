package client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Callback<T> extends Remote{
	public void callback(T answer) throws RemoteException;
}
