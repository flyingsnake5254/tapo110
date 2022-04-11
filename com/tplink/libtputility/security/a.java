package com.tplink.libtputility.security;

import android.util.Base64;
import b.d.w.h.b;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class a
{
  private final Object a = new Object();
  private final Object b = new Object();
  private Cipher c = null;
  private Cipher d = null;
  private SecretKey e = null;
  private byte[] f = null;
  
  public a()
  {
    this(null, new SecureRandom().generateSeed(16), "AES/CBC/PKCS7Padding");
  }
  
  public a(String paramString)
  {
    this(null, null, paramString);
  }
  
  public a(String paramString1, String paramString2)
  {
    this(Base64.decode(paramString1, 0), Base64.decode(paramString2, 0));
  }
  
  public a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this(paramArrayOfByte1, paramArrayOfByte2, "AES/CBC/PKCS7Padding");
  }
  
  public a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString)
  {
    if (paramArrayOfByte1 == null) {}
    try
    {
      this.e = e();
      break label80;
      SecretKeySpec localSecretKeySpec = new javax/crypto/spec/SecretKeySpec;
      localSecretKeySpec.<init>(paramArrayOfByte1, "AES");
      this.e = localSecretKeySpec;
      label80:
      this.c = Cipher.getInstance(paramString);
      this.d = Cipher.getInstance(paramString);
      if (paramArrayOfByte2 == null)
      {
        this.c.init(1, this.e);
        this.d.init(2, this.e);
      }
      else
      {
        this.f = paramArrayOfByte2;
        paramArrayOfByte1 = new javax/crypto/spec/IvParameterSpec;
        paramArrayOfByte1.<init>(paramArrayOfByte2);
        this.c.init(1, this.e, paramArrayOfByte1);
        this.d.init(2, this.e, paramArrayOfByte1);
      }
    }
    catch (InvalidAlgorithmParameterException paramArrayOfByte1) {}catch (InvalidKeyException paramArrayOfByte1) {}catch (NoSuchPaddingException paramArrayOfByte1) {}catch (NoSuchAlgorithmException paramArrayOfByte1) {}
    b.d.w.c.a.g(paramArrayOfByte1, a.class.getSimpleName(), new Object[0]);
  }
  
  public String a(String paramString)
    throws Exception
  {
    if (b.d(paramString)) {
      return "";
    }
    synchronized (this.b)
    {
      paramString = this.d.doFinal(Base64.decode(paramString.getBytes("utf-8"), 0));
      return new String(paramString);
    }
  }
  
  public byte[] b(byte[] paramArrayOfByte)
    throws Exception
  {
    synchronized (this.b)
    {
      paramArrayOfByte = this.d.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
  }
  
  public String c(String paramString)
    throws Exception
  {
    if (b.d(paramString)) {
      return "";
    }
    synchronized (this.a)
    {
      paramString = this.c.doFinal(paramString.getBytes());
      return Base64.encodeToString(paramString, 0);
    }
  }
  
  public byte[] d(byte[] paramArrayOfByte)
    throws Exception
  {
    synchronized (this.a)
    {
      paramArrayOfByte = this.c.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
  }
  
  public SecretKey e()
    throws NoSuchAlgorithmException
  {
    KeyGenerator localKeyGenerator = KeyGenerator.getInstance("AES");
    localKeyGenerator.init(256);
    return localKeyGenerator.generateKey();
  }
  
  public byte[] f()
  {
    return this.e.getEncoded();
  }
  
  public String g()
  {
    return Base64.encodeToString(this.f, 0);
  }
  
  public String h()
  {
    return Base64.encodeToString(this.e.getEncoded(), 0);
  }
  
  public void i(SecretKey paramSecretKey)
    throws InvalidKeyException
  {
    this.e = paramSecretKey;
    this.c.init(1, paramSecretKey);
    this.d.init(2, paramSecretKey);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtputility\security\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */