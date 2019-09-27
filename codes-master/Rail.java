import java.io.*;
class Rail
{
	Rail()
	{
		try{
		String msg="";
		String str1="";
		String str2="";
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a msg");
		msg=br.readLine();
		for(int i=0;i<msg.length();i++)
		{
			if(i%2==0)
			{
				str1+=msg.charAt(i);
			}	
			else
			{
				str2+=msg.charAt(i);	
			}
		}
		System.out.println("Railfence is "+str1+str2);
		}catch(Exception ae)
		{}
	}
	public static void main(String args[])
	{
		new Rail();
	}
}