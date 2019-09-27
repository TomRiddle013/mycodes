import java.io.*;
import java.security.*;

public class RC4Algo
{	
	static char cipher[];
	static String plainText;
	
	public RC4Algo(String str,int []key)
	{
		plainText=str;
		int i=0,j=0,k;
		int S[]=new int[255];   //subkey array
		cipher=new char[str.length()];

		for(i=0;i<S.length;i++)		
			S[i]=i;		
		i=0;		
		
		for(k=0;k<plainText.length();k++)
		{
			int modk=(k%key.length);
			int Kc=key[modk];
			j=(S[i] + j + Kc) % 256 + 1;
			int temp=S[i];
			S[i]=S[j];
			S[j]=temp;
			int Sc=(S[i]+S[j])%256;
			int Ck=S[Sc];
			cipher[k]=(char)(Ck^(int)plainText.charAt(k));
			i++;	
		}	
	}
	public static void main(String args[])
	{
		String input;
		int k[]={1 , 2 , 3 , 4};	//key array	
	
		System.out.print("Enter the message:");
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			input=br.readLine();
			new RC4Algo(input,k);
			
			for(int i=0;i<cipher.length;i++)
				System.out.print(" "+cipher[i]);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}