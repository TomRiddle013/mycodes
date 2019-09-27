import java.math.*;
import java.security.*;

public class RSA
{
	
	public static void main(String args[])
	{
		SecureRandom r;
		BigInteger p,q,p1,q1,n,n1,e,d,msg,ct,pt;	

		int bitLength=512;
		int certainty=100;
		r=new SecureRandom();
		
		//step 1: Generate prime no. p & q
		p=new BigInteger(bitLength,certainty , r) ;
		q=new  BigInteger(bitLength,certainty, r) ;

		//step 2: n=p*q
		n=p.multiply(q);  //n=p*q

		System.out.println("Prime no. P is:"+p.intValue());
		System.out.println("Prime no. Q is:"+q.intValue());
		System.out.println("N=P*Q is:"+n.intValue());

		//step 3: Generating public key(E)
		p1=p.subtract(new BigInteger("1"));
		q1=q.subtract(new BigInteger("1"));
		n1=p1.multiply(q1); 
		e=new BigInteger("2");

		while(n1.gcd(e).intValue()>1  || e.compareTo(p1)!=-1)		
			e=e.add(new BigInteger("1"));

		System.out.println("Public key is ("+n.intValue()+", "+e.intValue()+")");
		
		//step 4:D=E^-1 mod(P-1)(Q-1)
		d=e.modInverse(n1);		
		System.out.println("Private key is ("+n.intValue()+", "+d.intValue()+")");
		
		//step 5:Encryption CT=(PT)^e mod n
		msg=new BigInteger("5");
		ct=msg.modPow(e,n);
		System.out.println("Encrypted text is:"+ct.intValue());

		//step 6:Decryption PT=(CT)^d mod n
		pt=ct.modPow(d,n);
		System.out.println("Decrypted text is:"+pt.intValue());	
	}
}