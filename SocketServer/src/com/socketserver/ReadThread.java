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
		//�õ�������
		BufferedReader reader=null;
		try {
			reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(socket.isConnected()&&!socket.isInputShutdown()){
				//�������ֹ�ͻ���ͻȻ�жϱ����˳��߳�
				try {
					System.out.println("�������ӵ���Ϣ:"+reader.readLine());
				} catch (SocketException e) {
					if(e.toString().contains("Connection reset")){
					
						break;
					
					}
					// TODO: handle exception
				}
				
				
			}
			System.out.println("�ͻ����˳�");
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
