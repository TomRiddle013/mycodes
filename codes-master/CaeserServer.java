import java.io.*;
import java.net.*;
class CaeserServer
{
	public static void main(String args[])
	{
		System.out.print("\n\t*********The Caesar Cipher Server**********\n\n");
		new CaeserServer();
	}

	 CaeserServer()
	{
		try{
		
		//RECEIVE
		String str="";
		DatagramSocket ds = new DatagramSocket(8081);

		byte[] br = new byte[1024];
		DatagramPacket dp = new DatagramPacket(br,br.length);
		ds.receive(dp);
		str =new String(dp.getData());
		str=str.trim();
		
		String dec=decrypt(str);

		//SEND
		
		byte[] bs = dec.getBytes();
		dp = new DatagramPacket(bs,bs.length,InetAddress.getLocalHost(),8080);
		ds.send(dp);
		
		System.out.println("Decrypted msg Sent");
		}catch(Exception ae)
		{
				System.out.println("Err");
		}
	}
	public String decrypt(String str)
	{
		String s="";
		char ch;		
		System.out.print("\n\t\t************Decryption*************\n");
		for(int i=0;i<str.length();i++)
		{
			 if(str.charAt(i)=='a' )			
				s+='x';			
			else if(str.charAt(i)=='b' )			
				s+='y';			
			else if(str.charAt(i)=='c' )			
				s+='z';
			
			else
			{			
				ch=str.charAt(i);
				s+=(char)(ch-3);					
			}				
		}		
		return s;		
	}	
}

