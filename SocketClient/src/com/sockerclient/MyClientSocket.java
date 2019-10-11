package com.sockerclient;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClientSocket {
	
	public static void main(String[] args) {
		try {
			Socket clientsocket=new Socket("192.168.170.2", 9124);
			new WriterThread(clientsocket).start();
			new ReadThread(clientsocket).start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	

}
