package b.d.p;

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

public class a
{
  private Cipher a = null;
  private Cipher b = null;
  private final Object c = new Object();
  private final Object d = new Object();
  private SecretKey e = null;
  private byte[] f = null;
  
  public a()
  {
    try
    {
      this.a = Cipher.getInstance("AES/CBC/PKCS7Padding");
      this.b = Cipher.getInstance("AES/CBC/PKCS7Padding");
      this.e = c();
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
  
  public a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      SecretKeySpec localSecretKeySpec = new javax/crypto/spec/SecretKeySpec;
      localSecretKeySpec.<init>(paramArrayOfByte1, "AES");
      paramArrayOfByte1 = new javax/crypto/spec/IvParameterSpec;
      paramArrayOfByte1.<init>(paramArrayOfByte2);
      paramArrayOfByte2 = Cipher.getInstance("AES/CBC/PKCS7Padding");
      this.a = paramArrayOfByte2;
      paramArrayOfByte2.init(1, localSecretKeySpec, paramArrayOfByte1);
      paramArrayOfByte2 = Cipher.getInstance("AES/CBC/PKCS7Padding");
      this.b = paramArrayOfByte2;
      paramArrayOfByte2.init(2, localSecretKeySpec, paramArrayOfByte1);
    }
    catch (InvalidAlgorithmParameterException paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
    }
    catch (InvalidKeyException paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
    }
    catch (NoSuchPaddingException paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
    }
    catch (NoSuchAlgorithmException paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
    }
  }
  
  private SecretKey c()
    throws Exception
  {
    KeyGenerator localKeyGenerator = KeyGenerator.getInstance("AES");
    localKeyGenerator.init(128);
    return localKeyGenerator.generateKey();
  }
  
  public byte[] a(byte[] paramArrayOfByte, int paramInt)
    throws Exception
  {
    synchronized (this.d)
    {
      paramArrayOfByte = this.b.doFinal(paramArrayOfByte, 0, paramInt);
      return paramArrayOfByte;
    }
  }
  
  public byte[] b(byte[] paramArrayOfByte)
    throws Exception
  {
    synchronized (this.c)
    {
      paramArrayOfByte = this.a.doFinal(paramArrayOfByte, 0, paramArrayOfByte.length);
      return paramArrayOfByte;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\p\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */