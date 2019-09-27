import java.io.*;
import javax.crypto.*;

public class DES
{
	Cipher ecipher,dcipher;
	public static void main(String args[])
	{
		System.out.println("String entered:");
		System.out.println(args[0]);
		try
		{
			SecretKey key=KeyGenerator.getInstance("DES").generateKey();
			DES encrypter=new DES(key);
			String encrypted=encrypter.encrypt1(args[0]);
			String decrypted=encrypter.decrypt1(encrypted);
			
			System.out.println("Original string is:"+args[0]);
			System.out.println("Encrypted string is : "+encrypted);
			System.out.println("Decrypted String is : "+decrypted);
			
		}
		catch(Exception e)
		{
		}
	}
	public DES(SecretKey key)
	{
		try
		{
			ecipher=Cipher.getInstance("DES");
			ecipher.init(Cipher.ENCRYPT_MODE,key);
			dcipher=Cipher.getInstance("DES");
			dcipher.init(Cipher.DECRYPT_MODE,key);
			
			
			
		}
		catch(Exception e)
		{
		}
	}
	public String encrypt1(String str)
	{
		
		try
		{
			byte[] utf8=str.getBytes("UTF8");
			byte[] enc=ecipher.doFinal(utf8);
			return new sun.misc.BASE64Encoder().encode(enc);
		
		}
		catch(Exception e)
		{
		}
		return null;
		
	}
	public String decrypt1(String str)
	{
		try
		{
			byte[] dec=new sun.misc.BASE64Decoder().decodeBuffer(str); 
			byte[] utf8=dcipher.doFinal(dec);
			return new String(utf8,"UTF8");
		
		}
		catch(Exception e)
		{
		}
		return null;
	}
}

