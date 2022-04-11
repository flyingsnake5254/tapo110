package org.bouncycastle.crypto.r;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.SecureRandom;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.e;
import org.bouncycastle.crypto.f;
import org.bouncycastle.crypto.w.b;
import org.bouncycastle.crypto.w.c0;

public class a
  implements org.bouncycastle.crypto.a
{
  private SecureRandom a;
  private org.bouncycastle.crypto.a b;
  private boolean c;
  private boolean d;
  private boolean e;
  private int f = -1;
  private byte[] g = null;
  private byte[] h;
  
  public a(org.bouncycastle.crypto.a parama)
  {
    this.b = parama;
    this.e = j();
  }
  
  private static int e(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0x0 | paramArrayOfByte[0] ^ 0x2;
    int j = paramArrayOfByte.length;
    int k = paramInt + 1;
    for (paramInt = 1; paramInt < j - k; paramInt++)
    {
      int m = paramArrayOfByte[paramInt];
      m |= m >> 1;
      m |= m >> 2;
      i |= ((m | m >> 4) & 0x1) - 1;
    }
    paramInt = paramArrayOfByte[(paramArrayOfByte.length - k)] | i;
    paramInt |= paramInt >> 1;
    paramInt |= paramInt >> 2;
    return ((paramInt | paramInt >> 4) & 0x1) - 1 ^ 0xFFFFFFFF;
  }
  
  private byte[] f(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws InvalidCipherTextException
  {
    if (this.f != -1) {
      return g(paramArrayOfByte, paramInt1, paramInt2);
    }
    byte[] arrayOfByte = this.b.d(paramArrayOfByte, paramInt1, paramInt2);
    int i = this.e;
    paramInt1 = arrayOfByte.length;
    paramInt2 = this.b.b();
    int j = 1;
    if (paramInt1 != paramInt2) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    paramArrayOfByte = arrayOfByte;
    if (arrayOfByte.length < b()) {
      paramArrayOfByte = this.h;
    }
    byte b1 = paramArrayOfByte[0];
    if (this.d) {
      if (b1 == 2) {}
    }
    for (;;)
    {
      paramInt2 = 1;
      break;
      do
      {
        paramInt2 = 0;
        break;
      } while (b1 == 1);
    }
    int k = i(b1, paramArrayOfByte) + 1;
    if (k >= 10) {
      j = 0;
    }
    if ((paramInt2 | j) == 0)
    {
      if ((i & paramInt1) == 0)
      {
        paramInt1 = paramArrayOfByte.length - k;
        arrayOfByte = new byte[paramInt1];
        System.arraycopy(paramArrayOfByte, k, arrayOfByte, 0, paramInt1);
        return arrayOfByte;
      }
      org.bouncycastle.util.a.u(paramArrayOfByte, (byte)0);
      throw new InvalidCipherTextException("block incorrect size");
    }
    org.bouncycastle.util.a.u(paramArrayOfByte, (byte)0);
    throw new InvalidCipherTextException("block incorrect");
  }
  
  private byte[] g(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws InvalidCipherTextException
  {
    if (this.d)
    {
      byte[] arrayOfByte1 = this.b.d(paramArrayOfByte, paramInt1, paramInt2);
      byte[] arrayOfByte2 = this.g;
      paramArrayOfByte = arrayOfByte2;
      if (arrayOfByte2 == null)
      {
        paramArrayOfByte = new byte[this.f];
        this.a.nextBytes(paramArrayOfByte);
      }
      int i = this.e;
      if (arrayOfByte1.length != this.b.b()) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      if ((i & paramInt1) != 0) {
        arrayOfByte1 = this.h;
      }
      paramInt2 = e(arrayOfByte1, this.f);
      arrayOfByte2 = new byte[this.f];
      for (paramInt1 = 0;; paramInt1++)
      {
        int j = this.f;
        if (paramInt1 >= j) {
          break;
        }
        arrayOfByte2[paramInt1] = ((byte)(byte)(arrayOfByte1[(arrayOfByte1.length - j + paramInt1)] & (paramInt2 ^ 0xFFFFFFFF) | paramArrayOfByte[paramInt1] & paramInt2));
      }
      org.bouncycastle.util.a.u(arrayOfByte1, (byte)0);
      return arrayOfByte2;
    }
    throw new InvalidCipherTextException("sorry, this method is only for decryption, not for signing");
  }
  
  private byte[] h(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws InvalidCipherTextException
  {
    if (paramInt2 <= c())
    {
      int i = this.b.c();
      byte[] arrayOfByte = new byte[i];
      if (this.d)
      {
        arrayOfByte[0] = ((byte)1);
        for (j = 1; j != i - paramInt2 - 1; j++) {
          arrayOfByte[j] = ((byte)-1);
        }
      }
      this.a.nextBytes(arrayOfByte);
      arrayOfByte[0] = ((byte)2);
      for (int j = 1; j != i - paramInt2 - 1; j++) {
        while (arrayOfByte[j] == 0) {
          arrayOfByte[j] = ((byte)(byte)this.a.nextInt());
        }
      }
      j = i - paramInt2;
      arrayOfByte[(j - 1)] = ((byte)0);
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, j, paramInt2);
      return this.b.d(arrayOfByte, 0, i);
    }
    throw new IllegalArgumentException("input data too large");
  }
  
  private int i(byte paramByte, byte[] paramArrayOfByte)
    throws InvalidCipherTextException
  {
    int i = 1;
    int j = 0;
    int k = -1;
    while (i != paramArrayOfByte.length)
    {
      int m = paramArrayOfByte[i];
      int n;
      if (m == 0) {
        n = 1;
      } else {
        n = 0;
      }
      int i1;
      if (k < 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if ((n & i1) != 0) {
        k = i;
      }
      if (paramByte == 1) {
        n = 1;
      } else {
        n = 0;
      }
      if (k < 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (m != -1) {
        m = 1;
      } else {
        m = 0;
      }
      j |= m & n & i1;
      i++;
    }
    if (j != 0) {
      return -1;
    }
    return k;
  }
  
  private boolean j()
  {
    String str1 = (String)AccessController.doPrivileged(new a());
    String str2 = (String)AccessController.doPrivileged(new b());
    boolean bool1 = true;
    if (str2 != null) {
      return str2.equals("true") ^ true;
    }
    boolean bool2 = bool1;
    if (str1 != null) {
      if (str1.equals("true")) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
    }
    return bool2;
  }
  
  public void a(boolean paramBoolean, e parame)
  {
    Object localObject;
    if ((parame instanceof c0))
    {
      localObject = (c0)parame;
      this.a = ((c0)localObject).b();
      localObject = (b)((c0)localObject).a();
    }
    else
    {
      b localb = (b)parame;
      localObject = localb;
      if (!localb.a())
      {
        localObject = localb;
        if (paramBoolean)
        {
          this.a = f.b();
          localObject = localb;
        }
      }
    }
    this.b.a(paramBoolean, parame);
    this.d = ((b)localObject).a();
    this.c = paramBoolean;
    this.h = new byte[this.b.b()];
    if ((this.f > 0) && (this.g == null) && (this.a == null)) {
      throw new IllegalArgumentException("encoder requires random");
    }
  }
  
  public int b()
  {
    int i = this.b.b();
    if (this.c) {
      return i;
    }
    return i - 10;
  }
  
  public int c()
  {
    int i = this.b.c();
    int j = i;
    if (this.c) {
      j = i - 10;
    }
    return j;
  }
  
  public byte[] d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws InvalidCipherTextException
  {
    if (this.c) {
      return h(paramArrayOfByte, paramInt1, paramInt2);
    }
    return f(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  class a
    implements PrivilegedAction
  {
    a() {}
    
    public Object run()
    {
      return System.getProperty("org.bouncycastle.pkcs1.strict");
    }
  }
  
  class b
    implements PrivilegedAction
  {
    b() {}
    
    public Object run()
    {
      return System.getProperty("org.bouncycastle.pkcs1.not_strict");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\r\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */