package com.socketserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务
 * @author admin
 *
 */

public class MyServerSocket {
	
	public static final int port=9124;
	
	
	public static void main(String[] args) {
		//启动服务器的socketserver 来监听客户端
		
		
       try {
    	System.out.println("服务器开启");
		ServerSocket mySocket=new ServerSocket(port);
		
		while(true){	
			Socket socket=mySocket.accept();
			System.out.println("有客户端接入了:客户端ID:"+	socket.hashCode());
			new ReadThread(socket).start();
			new WriterThread(socket).start();
		    //拿到读写监听
	       
	     }
		//循环监听没一个socket，可能多个客户端来发送		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}
