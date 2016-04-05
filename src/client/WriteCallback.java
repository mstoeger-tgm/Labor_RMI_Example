package client;

import java.io.Serializable;
/**
 * Callback which prints out the result
 * @author Michael Stoeger
 * @version 5.4.2016
 */
public class WriteCallback implements Callback<String>,Serializable{
	public void callback(String out){
		System.out.println(out);
	}
}
