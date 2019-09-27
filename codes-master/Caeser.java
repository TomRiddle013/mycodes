import java.io.*;
class Caeser
{
	static String en;
	static String de;
	static char ch;	
	
	public static String encrypt(String str)
	{
		en="";	
		System.out.print("\n\t\t************Encryption*************\n");
		for(int i=0;i<str.length();i++)
		{			
			 if(str.charAt(i)=='x' )			
				en+='a';			
			else if(str.charAt(i)=='y' )			
				en+='b';			
			else if(str.charAt(i)=='z' )			
				en+='c';			
			else
			{
				ch=str.charAt(i);
				en+=(char)(ch+3);					
			}				
		}
		return en;				
	}
	public static String decrypt(String str)
	{
		de="";		
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
				de+=(char)(ch-3);					
			}				
		}		
		return s;		
	}
	public static void main(String args[])throws IOException
	{

		String en;
		
		System.out.print("\n\t*********The Caesar Cipher Substitution Algo**********\n\n");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the string:");
		String str=br.readLine();
		en=encrypt(str);
		

		System.out.print("Ciphertext  is:"+en+"\n");
		System.out.print("Decrypted plaintext is:"+ decrypt(en));
	}			
		
}