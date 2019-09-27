import javax.crypto.*;
import java.io.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.spec.*;
import javax.crypto.spec.IvParameterSpec;
import java.lang.*;
public class AesEncrypter
{      Cipher ecipher;
        Cipher dcipher;
        AesEncrypter(SecretKey key)
       {
      	  try
       {
            	    ecipher = Cipher.getInstance("AES");
                dcipher = Cipher.getInstance("AES");
    ecipher.init(Cipher.ENCRYPT_MODE, key);
                dcipher.init(Cipher.DECRYPT_MODE, key);
        }
 catch (Exception e) {  }
        }    
        public String encrypt(String str)
        {            try
          {
          	      // Encode the string into bytes using utf-8
                   byte[] utf8 = str.getBytes("UTF8");
                  // Encrypt
                   byte[] enc = ecipher.doFinal(utf8);
    			     // Encode bytes to base64 to get a string
	                return new sun.misc.BASE64Encoder().encode(enc);
    	            }
catch (Exception e) {}
            return null;
        }    
        public String decrypt(String str)
       {     try
 {	   // Decode base64 to get bytes
               byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);
    	                // Decrypt
            	    byte[] utf8 = dcipher.doFinal(dec);
    	                // Decode using utf-8
            	   return new String(utf8, "UTF8");
            } catch (Exception e) {}
             return null;
        }
	public static void main(String args[])
	{
		System.out.println();
		System.out.println("----*--Encrypting string using AES--*----");
		System.out.println();				
		try 
{
    			
			// Generate a temporary key. In practice, you would save this key.
		        SecretKey key = KeyGenerator.getInstance("AES").generateKey();    
		            // Create encrypter/decrypter class
		        AesEncrypter encrypter = new AesEncrypter(key);
		        String s="Don't tell anybody!";
		        String d="Hello";    
		           // Encrypt
		        String encrypted = encrypter.encrypt(s);
                                   // Decrypt
		        String decrypted = encrypter.decrypt(encrypted);
                                System.out.println("Original string is :  " + s);			
		        System.out.println("Encrypted string is:  " + encrypted);
		        System.out.println("Decrypted string is:  "+decrypted);
    		   }   catch (Exception e) {}
	}
    }// class AesEncrypter
