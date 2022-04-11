package com.tplink.libtputility.security;

import b.d.w.c.a;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.MGF1ParameterSpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource.PSpecified;

public class c
{
  private int a;
  private int b;
  private int c;
  private PrivateKey d;
  private PublicKey e;
  private String f;
  private Cipher g;
  private Cipher h;
  
  private void c()
  {
    Object localObject = this.e;
    if (localObject != null) {
      this.a = ((RSAPublicKey)localObject).getModulus().bitLength();
    } else {
      this.a = ((RSAPrivateKey)this.d).getModulus().bitLength();
    }
    this.c = (this.a / 8);
    localObject = this.f;
    if ((localObject != null) && (!((String)localObject).equals("")))
    {
      localObject = this.f.split("/");
      if (localObject.length == 3) {
        if (localObject[2].equals("PKCS1Padding")) {
          this.b = (this.a / 8 - 11);
        } else if ((!localObject[2].equals("OAEPPadding")) && (!localObject[2].equals("OAEPWithSHA-1AndMGF1Padding")))
        {
          if (localObject[2].equals("OAEPWithSHA-256AndMGF1Padding")) {
            this.b = (this.a / 8 - 66);
          } else if (localObject[2].equals("NoPadding")) {
            this.b = (this.a / 8 - 11);
          }
        }
        else {
          this.b = (this.a / 8 - 42);
        }
      }
    }
    else
    {
      this.f = "RSA/ECB/PKCS1Padding";
      this.b = (this.a / 8 - 11);
    }
    try
    {
      if (this.e != null)
      {
        localObject = Cipher.getInstance(this.f);
        this.g = ((Cipher)localObject);
        f((Cipher)localObject, 1, this.f, this.e);
      }
      if (this.d == null) {
        return;
      }
      if ((!this.f.equals("RSA/ECB/NoPadding")) && (!this.f.equals("RSA/NONE/NoPadding"))) {
        this.h = Cipher.getInstance(this.f);
      } else {
        this.h = Cipher.getInstance("RSA");
      }
      f(this.h, 2, this.f, this.d);
    }
    catch (InvalidKeyException localInvalidKeyException) {}catch (InvalidAlgorithmParameterException localInvalidAlgorithmParameterException) {}catch (NoSuchPaddingException localNoSuchPaddingException) {}catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
    a.g(localNoSuchAlgorithmException, c.class.getSimpleName(), new Object[0]);
  }
  
  private void f(Cipher paramCipher, int paramInt, String paramString, Key paramKey)
    throws InvalidKeyException, InvalidAlgorithmParameterException
  {
    if ((!paramString.equals("RSA/ECB/PKCS1Padding")) && (!paramString.equals("RSA/ECB/OAEPPadding")) && (!paramString.equals("RSA/ECB/NoPadding")) && (!paramString.equals("RSA/NONE/PKCS1Padding")) && (!paramString.equals("RSA/NONE/OAEPPadding")) && (!paramString.equals("RSA/NONE/NoPadding")))
    {
      if ((!paramString.equals("RSA/ECB/OAEPWithSHA-256AndMGF1Padding")) && (!paramString.equals("RSA/NONE/OAEPWithSHA-256AndMGF1Padding")))
      {
        if ((paramString.equals("RSA/ECB/OAEPWithSHA-1AndMGF1Padding")) || (paramString.equals("RSA/NONE/OAEPWithSHA-1AndMGF1Padding"))) {
          paramCipher.init(paramInt, paramKey);
        }
      }
      else {
        paramCipher.init(paramInt, paramKey, new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT));
      }
    }
    else {
      paramCipher.init(paramInt, paramKey);
    }
  }
  
  public byte[] d(String paramString)
    throws Exception
  {
    try
    {
      paramString = e(paramString.getBytes("UTF8"));
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public byte[] e(byte[] paramArrayOfByte)
    throws Exception
  {
    try
    {
      int i = paramArrayOfByte.length;
      if (i <= this.b)
      {
        paramArrayOfByte = this.g.doFinal(paramArrayOfByte);
        return paramArrayOfByte;
      }
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>(2048);
      int j = 0;
      int k = 0;
      for (;;)
      {
        int m = i - k;
        if (m <= 0) {
          break;
        }
        int n = this.b;
        if (m > n)
        {
          localObject = new byte[n];
          System.arraycopy(paramArrayOfByte, k, localObject, 0, n);
        }
        else
        {
          localObject = new byte[m];
          System.arraycopy(paramArrayOfByte, k, localObject, 0, m);
        }
        localObject = this.g.doFinal((byte[])localObject);
        m = localObject.length;
        for (n = 0; n < m; n++) {
          localArrayList.add(Byte.valueOf(localObject[n]));
        }
        k += this.b;
      }
      paramArrayOfByte = new byte[localArrayList.size()];
      Object localObject = localArrayList.iterator();
      for (k = j; ((Iterator)localObject).hasNext(); k++) {
        paramArrayOfByte[k] = ((Byte)((Iterator)localObject).next()).byteValue();
      }
      return paramArrayOfByte;
    }
    finally {}
  }
  
  public static class b
  {
    private c a = new c(null);
    
    public c a()
    {
      c.b(this.a);
      return this.a;
    }
    
    public b b(PublicKey paramPublicKey)
    {
      c.a(this.a, paramPublicKey);
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtputility\security\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */