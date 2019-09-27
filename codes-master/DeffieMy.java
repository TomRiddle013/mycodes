import java.io.*;
import java.math.BigInteger;
class DeffieMy
{
	

	public static void main(String args[])
	{
		try
		{
		BigInteger n,g,x,y,A,B,k1,k2;
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

	//Accept values of n and g
		System.out.println("\n Enter two large Prime Numbers:");
		System.out.println("Enter value of n:");

		n=new BigInteger(br.readLine());
		chkPrime(n);
		System.out.println("Enter value of g:");
		g=new BigInteger(br.readLine());
		chkPrime(g);

	//Accept values for x and y
		System.out.println("Enter value of x:");
		x=new BigInteger(br.readLine());
		System.out.println("Enter value of y:");
		y=new BigInteger(br.readLine());

//Calculate A 

		A=g.modPow(x,n);

//Calculate B

		B=g.modPow(y,n);
	
//Calcute Key k1 and k2
		k1=B.modPow(x,n);
		k2=A.modPow(y,n);

		if(k1.equals(k2))
		{
		System.out.println("Key 1 is:"+k1+ "Key 2 is:"+k2);
		System.out.println("Both keys are equal !!!Succesfull");
		}
		}catch(Exception e)
		{
		System.out.println("Exception:"+e);
		}
	}


	public static void chkPrime(BigInteger n)
	{
	try{
		if(n.isProbablePrime(10))
		{
		System.out.println("Prime, Continue");
		}
		else
		{
			System.out.println("Not Prime");
			System.out.println("Enter value:");
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			BigInteger x=new BigInteger(br.readLine());
			chkPrime(x);
		}
	}catch(Exception ae){}
	}
}