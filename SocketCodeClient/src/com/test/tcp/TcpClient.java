package com.test.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient
{
	Socket sc=null;
	OutputStream os=null;
	InputStream is=null;
	String data="hello day";
	byte[] b=new byte [1024];

	public static void main(String[] args)
	{
		new TcpClient().tcpMethod();
	}

	public void tcpMethod()
	{
		try
		{
			Socket sc=new Socket("127.0.0.1",10004);
			System.out.println("start TCP client successfully......");
			is=sc.getInputStream();
			os=sc.getOutputStream();
			os.write(data.getBytes());
			int n = is.read(b);
			System.out.println("the server say---"+new String(b,0,n));
		} catch (UnknownHostException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
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
