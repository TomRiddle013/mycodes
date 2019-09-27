import java.io.*;
import java.net.*;
class CaeserClient
{
	CaeserClient()
	{
		try{
		//SEND
		DatagramSocket ds = new DatagramSocket(8080);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the string:");
		String str=br.readLine();
		String en=encrypt(str);
           //     System.out.pr
		byte[] b =en.getBytes();
		
		DatagramPacket dp = new DatagramPacket(b,b.length,InetAddress.getLocalHost(),8081);
		ds.send(dp);
		System.out.println("Encrypted msg sent "+en);

		//RECEIVE
		b = null;
		b = new byte[str.getBytes().length];
		dp = new DatagramPacket(b,b.length);
		ds.receive(dp);
		String dec =new String(dp.getData());
		dec=dec.trim();
		System.out.print("Decrypted plaintext is: "+dec);

		System.out.println("");
		}catch(Exception ae)
		{
				System.out.println("Err"+ae);
		}
	}

	public String encrypt(String str)
	{
		String s="";
		char ch;
		System.out.print("\n\t\t************Encryption*************\n");
		for(int i=0;i<str.length();i++)
		{			
			 if(str.charAt(i)=='x' )			
				s+='a';			
			else if(str.charAt(i)=='y' )			
				s+='b';			
			else if(str.charAt(i)=='z' )			
				s+='c';			
			else
			{
				ch=str.charAt(i);
				s+=(char)(ch+3);					
			}				
		}
		return s;				
	}

	
	public static void main(String args[])throws IOException
	{
		System.out.print("\n\t*********The Caesar Cipher Substitution Algo**********\n\n");
		new CaeserClient();
	}			
		
}