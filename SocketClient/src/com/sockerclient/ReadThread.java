package com.sockerclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;
import java.net.Socket;

public class ReadThread extends Thread{
	
	private final Socket socket;
	public ReadThread(Socket socket) {
		this.socket=socket;
		
	}
	
	
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		//拿到输入流
		BufferedReader reader=null;
		try {
			reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(socket.isConnected()&&!socket.isInputShutdown()){
				//
			
				System.out.println("客户端收到消息:"+reader.readLine());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
		
		
		
		
		
	}

}
