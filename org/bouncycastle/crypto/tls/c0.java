package org.bouncycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import org.bouncycastle.util.a;

public final class c0
{
  private int a;
  private short b;
  private byte[] c;
  private h d;
  private byte[] e = null;
  private byte[] f = null;
  private byte[] g;
  
  private c0(int paramInt, short paramShort, byte[] paramArrayOfByte1, h paramh, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    this.a = paramInt;
    this.b = ((short)paramShort);
    this.c = a.g(paramArrayOfByte1);
    this.d = paramh;
    this.e = a.g(paramArrayOfByte2);
    this.f = a.g(paramArrayOfByte3);
    this.g = paramArrayOfByte4;
  }
  
  public void a()
  {
    byte[] arrayOfByte = this.c;
    if (arrayOfByte != null) {
      a.u(arrayOfByte, (byte)0);
    }
  }
  
  public c0 b()
  {
    return new c0(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
  }
  
  public int c()
  {
    return this.a;
  }
  
  public short d()
  {
    return this.b;
  }
  
  public byte[] e()
  {
    return this.c;
  }
  
  public Hashtable f()
    throws IOException
  {
    if (this.g == null) {
      return null;
    }
    return g1.M(new ByteArrayInputStream(this.g));
  }
  
  public static final class b
  {
    private int a = -1;
    private short b = (short)-1;
    private byte[] c = null;
    private h d = null;
    private byte[] e = null;
    private byte[] f = null;
    private byte[] g = null;
    
    private void i(boolean paramBoolean, String paramString)
    {
      if (paramBoolean) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Required session parameter '");
      localStringBuilder.append(paramString);
      localStringBuilder.append("' not configured");
      throw new IllegalStateException(localStringBuilder.toString());
    }
    
    public c0 a()
    {
      int i = this.a;
      boolean bool1 = true;
      boolean bool2;
      if (i >= 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      i(bool2, "cipherSuite");
      if (this.b >= 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      i(bool2, "compressionAlgorithm");
      if (this.c != null) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
      i(bool2, "masterSecret");
      return new c0(this.a, this.b, this.c, this.d, this.e, this.f, this.g, null);
    }
    
    public b b(int paramInt)
    {
      this.a = paramInt;
      return this;
    }
    
    public b c(short paramShort)
    {
      this.b = ((short)paramShort);
      return this;
    }
    
    public b d(byte[] paramArrayOfByte)
    {
      this.c = paramArrayOfByte;
      return this;
    }
    
    public b e(byte[] paramArrayOfByte)
    {
      this.e = paramArrayOfByte;
      return this;
    }
    
    public b f(h paramh)
    {
      this.d = paramh;
      return this;
    }
    
    public b g(byte[] paramArrayOfByte)
    {
      this.f = paramArrayOfByte;
      return this;
    }
    
    public b h(Hashtable paramHashtable)
      throws IOException
    {
      if (paramHashtable == null)
      {
        this.g = null;
      }
      else
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        g1.W(localByteArrayOutputStream, paramHashtable);
        this.g = localByteArrayOutputStream.toByteArray();
      }
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\c0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */