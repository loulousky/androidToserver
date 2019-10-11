package com.socketserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class WriterThread  extends Thread{
	
	
	private final Socket socket;
	private PrintWriter writer;
	public WriterThread(Socket socket) {
		this.socket=socket;
	  
	}
	
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		  BufferedReader br = null;
		  try {
			writer=new PrintWriter(socket.getOutputStream());
		    br = new BufferedReader(new InputStreamReader(System.in));
			while(!socket.isClosed()&&socket.isConnected()&&!socket.isOutputShutdown()){
				//������������Ϣ���ͻ���
				
				System.out.println("�����������ͻ��˵���Ϣ");
				writer.println("��������say"+br.readLine());
				writer.flush();
			}
			
			
			System.out.println("�ͻ����˳�д");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			
			try {
				writer.close();
				
				br.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
	}
	
	

}
