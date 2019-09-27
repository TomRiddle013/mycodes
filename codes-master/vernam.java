import java.io.*;
class vernam
{
	vernam()
	{
	try{
		String msg,key;
		char[] alpha=new char[25];
		for(int i=0;i<alpha.length;i++)
		{
			alpha[i]=(char)('A'+i);
		}
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a Plain Text");
		msg=br.readLine();
		System.out.println("Enter Key same size as PT");
		key=br.readLine();
		
		
		int sum=0;
		int num1=0;
		int num2=0;
		for(int i=0;i<msg.length();i++)
		{
			char pt=msg.charAt(i);
			char k=key.charAt(i);
			for(int j=0;j<alpha.length;j++)
			{
				if(pt==alpha[j])
				{	num1=j;}
				if(k==alpha[j])
				{	num2=j;}
				sum=num1+num2;
				if(sum>25)
					sum=sum%26;
			}
			System.out.print(alpha[sum]);	
		}
		
	}catch(Exception ae)
	{}	
	}
	public static void main(String args[])
	{
		new vernam();
	}

}