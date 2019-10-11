package com.socketserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;
import java.net.Socket;
import java.net.SocketException;

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
				//加这个防止客户端突然中断报错，退出线程
				try {
					System.out.println("服务器加到消息:"+reader.readLine());
				} catch (SocketException e) {
					if(e.toString().contains("Connection reset")){
					
						break;
					
					}
					// TODO: handle exception
				}
				
				
			}
			System.out.println("客户端退出");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				reader.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
	}

}
