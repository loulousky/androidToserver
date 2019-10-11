package com.socketserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����
 * @author admin
 *
 */

public class MyServerSocket {
	
	public static final int port=9124;
	
	
	public static void main(String[] args) {
		//������������socketserver �������ͻ���
		
		
       try {
    	System.out.println("����������");
		ServerSocket mySocket=new ServerSocket(port);
		
		while(true){	
			Socket socket=mySocket.accept();
			System.out.println("�пͻ��˽�����:�ͻ���ID:"+	socket.hashCode());
			new ReadThread(socket).start();
			new WriterThread(socket).start();
		    //�õ���д����
	       
	     }
		//ѭ������ûһ��socket�����ܶ���ͻ���������		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}
