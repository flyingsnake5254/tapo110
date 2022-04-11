package com.tplink.libtpnetwork.cameranetwork.util;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class b
{
  private Cipher a = null;
  private Cipher b = null;
  private final Object c = new Object();
  private final Object d = new Object();
  private SecretKey e = null;
  private byte[] f = null;
  
  public b()
  {
    try
    {
      this.a = Cipher.getInstance("AES/CBC/PKCS7Padding");
      this.b = Cipher.getInstance("AES/CBC/PKCS7Padding");
      this.e = b();
      Object localObject = new java/security/SecureRandom;
      ((SecureRandom)localObject).<init>();
      this.f = ((SecureRandom)localObject).generateSeed(16);
      localObject = new javax/crypto/spec/IvParameterSpec;
      ((IvParameterSpec)localObject).<init>(this.f);
      this.a.init(1, this.e, (AlgorithmParameterSpec)localObject);
      this.b.init(2, this.e, (AlgorithmParameterSpec)localObject);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
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
  
  private SecretKey b()
    throws Exception
  {
    KeyGenerator localKeyGenerator = KeyGenerator.getInstance("AES");
    localKeyGenerator.init(128);
    return localKeyGenerator.generateKey();
  }
  
  public int a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
    throws Exception
  {
    synchronized (this.d)
    {
      paramInt = this.b.doFinal(paramArrayOfByte1, 0, paramInt, paramArrayOfByte2);
      return paramInt;
    }
  }
  
  public void c(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws InvalidAlgorithmParameterException, InvalidKeyException
  {
    paramArrayOfByte1 = new SecretKeySpec(paramArrayOfByte1, "AES");
    paramArrayOfByte2 = new IvParameterSpec(paramArrayOfByte2);
    this.a.init(1, paramArrayOfByte1, paramArrayOfByte2);
    this.b.init(2, paramArrayOfByte1, paramArrayOfByte2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\util\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */