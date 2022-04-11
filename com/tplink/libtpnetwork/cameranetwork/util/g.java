package com.tplink.libtpnetwork.cameranetwork.util;

import android.util.Base64;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class g
{
  private static volatile g a;
  private PublicKey b;
  private Cipher c;
  private Cipher d;
  private final Object e = new Object();
  
  private g()
  {
    try
    {
      Object localObject = KeyPairGenerator.getInstance("RSA");
      ((KeyPairGenerator)localObject).initialize(2048);
      localObject = ((KeyPairGenerator)localObject).genKeyPair();
      this.b = ((KeyPair)localObject).getPublic();
      localObject = ((KeyPair)localObject).getPrivate();
      Cipher localCipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
      this.c = localCipher;
      localCipher.init(1, this.b);
      localCipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
      this.d = localCipher;
      localCipher.init(2, (Key)localObject);
    }
    catch (InvalidKeyException localInvalidKeyException)
    {
      localInvalidKeyException.printStackTrace();
    }
    catch (NoSuchPaddingException localNoSuchPaddingException)
    {
      localNoSuchPaddingException.printStackTrace();
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
    }
  }
  
  public static g b()
  {
    if (a == null) {
      try
      {
        if (a == null)
        {
          g localg = new com/tplink/libtpnetwork/cameranetwork/util/g;
          localg.<init>();
          a = localg;
        }
      }
      finally {}
    }
    return a;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
    throws BadPaddingException, IllegalBlockSizeException
  {
    synchronized (this.e)
    {
      paramArrayOfByte = this.d.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
  }
  
  public String c()
    throws IOException
  {
    synchronized (this.e)
    {
      Object localObject2 = new char[64];
      StringWriter localStringWriter = new java/io/StringWriter;
      localStringWriter.<init>();
      BufferedWriter localBufferedWriter = new java/io/BufferedWriter;
      localBufferedWriter.<init>(localStringWriter);
      localBufferedWriter.write("-----BEGIN PUBLIC KEY-----");
      localBufferedWriter.newLine();
      byte[] arrayOfByte = Base64.encode(this.b.getEncoded(), 2);
      for (int i = 0; i < arrayOfByte.length; i += 64)
      {
        for (int j = 0; j != 64; j++)
        {
          int k = i + j;
          if (k >= arrayOfByte.length) {
            break;
          }
          localObject2[j] = ((char)(char)arrayOfByte[k]);
        }
        localBufferedWriter.write((char[])localObject2, 0, j);
        localBufferedWriter.newLine();
      }
      localBufferedWriter.write("-----END PUBLIC KEY-----");
      localBufferedWriter.newLine();
      localBufferedWriter.flush();
      localObject2 = localStringWriter.toString();
      return (String)localObject2;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\util\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */