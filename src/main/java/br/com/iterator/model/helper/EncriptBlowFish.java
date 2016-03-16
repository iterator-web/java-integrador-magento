package br.com.iterator.model.helper;

import javax.crypto.*;  
import javax.crypto.spec.*;

import br.com.iterator.model.util.EncriptConversion;
  
public final class EncriptBlowFish  
{  
   private static String passfrase="e9829608dd90ff6b";  
     
   public static final String cript(String str)  
   {  
      String strCript = str;  
        
      try  
      {  
         Cipher ch = Cipher.getInstance("Blowfish");  
         SecretKey k1 = new SecretKeySpec(passfrase.getBytes(), "Blowfish");  
         ch.init( Cipher.ENCRYPT_MODE, k1);  
         byte b[] = ch.doFinal(strCript.getBytes());  
         String s1 = EncriptConversion.byteArrayToBase64String(b);  
         strCript = s1;  
      }  
      catch( Exception e)  
      {  
         System.out.println(e.getMessage());  
         e.printStackTrace();  
      }  
              
      return strCript;  
   }  
     
   public static final String decript(String str)  
   {  
      String strDecript = str;  
        
      try  
      {  
         Cipher ch = Cipher.getInstance("Blowfish");  
         SecretKey k1 = new SecretKeySpec(passfrase.getBytes(), "Blowfish");  
         ch.init( Cipher.DECRYPT_MODE, k1);  
         byte b[] = EncriptConversion.base64StringToByteArray(strDecript);  
         byte b1[] = ch.doFinal(b);  
         String s1 = new String(b1);  
         strDecript = s1;  
      }  
      catch( Exception e)  
      {  
         System.out.println(e.getMessage());  
         e.printStackTrace();  
      }  
      return strDecript;  
   }    
} 