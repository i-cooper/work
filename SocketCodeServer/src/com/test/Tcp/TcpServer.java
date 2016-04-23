package com.test.Tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TcpServer
{

	ServerSocket ss=null;

	Socket sc=null;
	ThreadPoolExecutor threadPool=null;
	/**
	 * @param args
	 */

	public TcpServer()
	{
		threadPool=new ThreadPoolExecutor(2, 4, 3,  
				TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3),  
				new ThreadPoolExecutor.DiscardOldestPolicy());  
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new TcpServer().tcpMethod();
	}

	public void tcpMethod()
	{
		try
		{
			ss=new ServerSocket(10004);
			System.out.println("TCP Server start successfully....");
			while(true)
			{
				sc=ss.accept();
				threadPool.execute(new ThreadPoolTask(sc));
			}
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			threadPool.shutdown();
		}

	}
}

class ThreadPoolTask implements Runnable
{
	Socket sc=null;
	InputStream is=null;
	OutputStream os=null;
	String dataReceived="";
	byte [] b=new byte[1024];


	public ThreadPoolTask(Socket sc)
	{
		this.sc=sc;
	}
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		System.out.println("this is thread:"+Thread.currentThread().getId());
		tcpProcess();
	}

	public void tcpProcess()
	{
		try
		{
			is=sc.getInputStream();
			os=sc.getOutputStream();
			int n=is.read(b);
			dataReceived=new String(b,0,n);
			System.out.println("Server dataReceived="+dataReceived);
			if("hello day".equals(dataReceived))
			{
				
				os.write("I receive your message. Weclome....".getBytes());
			}
			else
			{
				os.write("I receive some other words. Weclome.....".getBytes());
			}
			
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(is!=null)
			{
				try
				{
					is.close();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(os!=null)
			{
				try
				{
					os.close();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(sc!=null)
			{
				try
				{
					sc.close();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
