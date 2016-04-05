package client;

import java.io.Serializable;

public class WriteCallback implements Callback<String>,Serializable{
	public void callback(String out){
		System.out.println(out);
	}
}
