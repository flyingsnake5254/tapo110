package org.bouncycastle.util.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.Provider;
import java.security.SecureRandom;
import org.bouncycastle.util.encoders.d;
import org.bouncycastle.util.f;

public class FixedSecureRandom
  extends SecureRandom
{
  private static BigInteger ANDROID;
  private static BigInteger CLASSPATH;
  private static BigInteger REGULAR = new BigInteger("01020304ffffffff0506070811111111", 16);
  private static final boolean isAndroidStyle;
  private static final boolean isClasspathStyle;
  private static final boolean isRegularStyle;
  private byte[] _data;
  private int _index;
  
  static
  {
    ANDROID = new BigInteger("1111111105060708ffffffff01020304", 16);
    CLASSPATH = new BigInteger("3020104ffffffff05060708111111", 16);
    BigInteger localBigInteger1 = new BigInteger(128, new d());
    BigInteger localBigInteger2 = new BigInteger(120, new d());
    isAndroidStyle = localBigInteger1.equals(ANDROID);
    isRegularStyle = localBigInteger1.equals(REGULAR);
    isClasspathStyle = localBigInteger2.equals(CLASSPATH);
  }
  
  public FixedSecureRandom(byte[] paramArrayOfByte)
  {
    this(new e[] { new b(paramArrayOfByte) });
  }
  
  public FixedSecureRandom(e[] paramArrayOfe)
  {
    super(null, new c());
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    boolean bool = isRegularStyle;
    int i = 0;
    int j = 0;
    byte[] arrayOfByte;
    int k;
    if (bool)
    {
      if (isClasspathStyle)
      {
        i = j;
        for (;;)
        {
          if (i == paramArrayOfe.length) {
            break label380;
          }
          try
          {
            if ((paramArrayOfe[i] instanceof a))
            {
              arrayOfByte = paramArrayOfe[i].a;
              k = arrayOfByte.length - arrayOfByte.length % 4;
              for (j = arrayOfByte.length - k - 1; j >= 0; j--) {
                localByteArrayOutputStream.write(arrayOfByte[j]);
              }
              for (j = arrayOfByte.length - k; j < arrayOfByte.length; j += 4) {
                localByteArrayOutputStream.write(arrayOfByte, j, 4);
              }
            }
            localByteArrayOutputStream.write(paramArrayOfe[i].a);
            i++;
          }
          catch (IOException paramArrayOfe)
          {
            throw new IllegalArgumentException("can't save value source.");
          }
        }
      }
      for (;;)
      {
        if (i == paramArrayOfe.length) {
          break label380;
        }
        try
        {
          localByteArrayOutputStream.write(paramArrayOfe[i].a);
          i++;
        }
        catch (IOException paramArrayOfe)
        {
          throw new IllegalArgumentException("can't save value source.");
        }
      }
    }
    if (isAndroidStyle)
    {
      i = 0;
      while (i != paramArrayOfe.length) {
        try
        {
          if ((paramArrayOfe[i] instanceof a))
          {
            arrayOfByte = paramArrayOfe[i].a;
            k = arrayOfByte.length - arrayOfByte.length % 4;
            j = 0;
            while (j < k)
            {
              int m = arrayOfByte.length;
              j += 4;
              localByteArrayOutputStream.write(arrayOfByte, m - j, 4);
            }
            if (arrayOfByte.length - k != 0) {
              for (j = 0; j != 4 - (arrayOfByte.length - k); j++) {
                localByteArrayOutputStream.write(0);
              }
            }
            for (j = 0; j != arrayOfByte.length - k; j++) {
              localByteArrayOutputStream.write(arrayOfByte[(k + j)]);
            }
          }
          localByteArrayOutputStream.write(paramArrayOfe[i].a);
          i++;
        }
        catch (IOException paramArrayOfe)
        {
          throw new IllegalArgumentException("can't save value source.");
        }
      }
      label380:
      this._data = localByteArrayOutputStream.toByteArray();
      return;
    }
    throw new IllegalStateException("Unrecognized BigInteger implementation");
  }
  
  public FixedSecureRandom(byte[][] paramArrayOfByte)
  {
    this(buildDataArray(paramArrayOfByte));
  }
  
  private static b[] buildDataArray(byte[][] paramArrayOfByte)
  {
    b[] arrayOfb = new b[paramArrayOfByte.length];
    for (int i = 0; i != paramArrayOfByte.length; i++) {
      arrayOfb[i] = new b(paramArrayOfByte[i]);
    }
    return arrayOfb;
  }
  
  private static byte[] expandToBitLength(int paramInt, byte[] paramArrayOfByte)
  {
    int i = (paramInt + 7) / 8;
    if (i > paramArrayOfByte.length)
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, i - paramArrayOfByte.length, paramArrayOfByte.length);
      if (isAndroidStyle)
      {
        paramInt %= 8;
        if (paramInt != 0) {
          f.d(f.a(arrayOfByte, 0) << 8 - paramInt, arrayOfByte, 0);
        }
      }
      return arrayOfByte;
    }
    if ((isAndroidStyle) && (paramInt < paramArrayOfByte.length * 8))
    {
      paramInt %= 8;
      if (paramInt != 0) {
        f.d(f.a(paramArrayOfByte, 0) << 8 - paramInt, paramArrayOfByte, 0);
      }
    }
    return paramArrayOfByte;
  }
  
  private int nextValue()
  {
    byte[] arrayOfByte = this._data;
    int i = this._index;
    this._index = (i + 1);
    return arrayOfByte[i] & 0xFF;
  }
  
  public byte[] generateSeed(int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    nextBytes(arrayOfByte);
    return arrayOfByte;
  }
  
  public boolean isExhausted()
  {
    boolean bool;
    if (this._index == this._data.length) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void nextBytes(byte[] paramArrayOfByte)
  {
    System.arraycopy(this._data, this._index, paramArrayOfByte, 0, paramArrayOfByte.length);
    this._index += paramArrayOfByte.length;
  }
  
  public int nextInt()
  {
    return nextValue() << 24 | 0x0 | nextValue() << 16 | nextValue() << 8 | nextValue();
  }
  
  public long nextLong()
  {
    return nextValue() << 56 | 0L | nextValue() << 48 | nextValue() << 40 | nextValue() << 32 | nextValue() << 24 | nextValue() << 16 | nextValue() << 8 | nextValue();
  }
  
  public static class a
    extends FixedSecureRandom.e
  {
    public a(int paramInt, byte[] paramArrayOfByte)
    {
      super();
    }
    
    public a(byte[] paramArrayOfByte)
    {
      super();
    }
  }
  
  public static class b
    extends FixedSecureRandom.e
  {
    public b(byte[] paramArrayOfByte)
    {
      super();
    }
  }
  
  private static class c
    extends Provider
  {
    c()
    {
      super(1.0D, "BCFIPS Fixed Secure Random Provider");
    }
  }
  
  private static class d
    extends SecureRandom
  {
    byte[] c = d.a("01020304ffffffff0506070811111111");
    int d = 0;
    
    d()
    {
      super(new FixedSecureRandom.c());
    }
    
    public void nextBytes(byte[] paramArrayOfByte)
    {
      System.arraycopy(this.c, this.d, paramArrayOfByte, 0, paramArrayOfByte.length);
      this.d += paramArrayOfByte.length;
    }
  }
  
  public static class e
  {
    byte[] a;
    
    e(byte[] paramArrayOfByte)
    {
      this.a = paramArrayOfByte;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\util\test\FixedSecureRandom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */