package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;
import org.bouncycastle.util.a;

public abstract class b
  extends q
  implements w
{
  private static final char[] c = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  protected final byte[] d;
  protected final int f;
  
  public b(byte[] paramArrayOfByte, int paramInt)
  {
    Objects.requireNonNull(paramArrayOfByte, "data cannot be null");
    if ((paramArrayOfByte.length == 0) && (paramInt != 0)) {
      throw new IllegalArgumentException("zero length data with non-zero pad bits");
    }
    if ((paramInt <= 7) && (paramInt >= 0))
    {
      this.d = a.g(paramArrayOfByte);
      this.f = paramInt;
      return;
    }
    throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
  }
  
  protected static byte[] m(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = a.g(paramArrayOfByte);
    if (paramInt > 0)
    {
      int i = paramArrayOfByte.length - 1;
      arrayOfByte[i] = ((byte)(byte)(255 << paramInt & arrayOfByte[i]));
    }
    return arrayOfByte;
  }
  
  static b n(int paramInt, InputStream paramInputStream)
    throws IOException
  {
    if (paramInt >= 1)
    {
      int i = paramInputStream.read();
      paramInt--;
      byte[] arrayOfByte = new byte[paramInt];
      if (paramInt != 0) {
        if (org.bouncycastle.util.io.b.c(paramInputStream, arrayOfByte) == paramInt)
        {
          if ((i > 0) && (i < 8))
          {
            paramInt--;
            if (arrayOfByte[paramInt] != (byte)(arrayOfByte[paramInt] & 255 << i)) {
              return new m1(arrayOfByte, i);
            }
          }
        }
        else {
          throw new EOFException("EOF encountered in middle of BIT STRING");
        }
      }
      return new n0(arrayOfByte, i);
    }
    throw new IllegalArgumentException("truncated BIT STRING detected");
  }
  
  protected boolean f(q paramq)
  {
    boolean bool1 = paramq instanceof b;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramq = (b)paramq;
    bool1 = bool2;
    if (this.f == paramq.f)
    {
      bool1 = bool2;
      if (a.c(o(), paramq.o())) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String getString()
  {
    Object localObject1 = new StringBuffer("#");
    Object localObject2 = new ByteArrayOutputStream();
    Object localObject3 = new p((OutputStream)localObject2);
    try
    {
      ((p)localObject3).j(this);
      localObject3 = ((ByteArrayOutputStream)localObject2).toByteArray();
      for (int i = 0; i != localObject3.length; i++)
      {
        localObject2 = c;
        ((StringBuffer)localObject1).append(localObject2[(localObject3[i] >>> 4 & 0xF)]);
        ((StringBuffer)localObject1).append(localObject2[(localObject3[i] & 0xF)]);
      }
      return ((StringBuffer)localObject1).toString();
    }
    catch (IOException localIOException)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Internal error encoding BitString: ");
      ((StringBuilder)localObject1).append(localIOException.getMessage());
      throw new ASN1ParsingException(((StringBuilder)localObject1).toString(), localIOException);
    }
  }
  
  public int hashCode()
  {
    return this.f ^ a.w(o());
  }
  
  q k()
  {
    return new n0(this.d, this.f);
  }
  
  q l()
  {
    return new m1(this.d, this.f);
  }
  
  public byte[] o()
  {
    return m(this.d, this.f);
  }
  
  public byte[] p()
  {
    if (this.f == 0) {
      return a.g(this.d);
    }
    throw new IllegalStateException("attempt to get non-octet aligned data from BIT STRING");
  }
  
  public int q()
  {
    return this.f;
  }
  
  public String toString()
  {
    return getString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */