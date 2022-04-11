package org.bouncycastle.asn1;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class i
  extends FilterInputStream
{
  private final int c;
  private final boolean d;
  private final byte[][] f;
  
  public i(InputStream paramInputStream)
  {
    this(paramInputStream, y1.c(paramInputStream));
  }
  
  public i(InputStream paramInputStream, int paramInt)
  {
    this(paramInputStream, paramInt, false);
  }
  
  public i(InputStream paramInputStream, int paramInt, boolean paramBoolean)
  {
    super(paramInputStream);
    this.c = paramInt;
    this.d = paramBoolean;
    this.f = new byte[11][];
  }
  
  public i(InputStream paramInputStream, boolean paramBoolean)
  {
    this(paramInputStream, y1.c(paramInputStream), paramBoolean);
  }
  
  public i(byte[] paramArrayOfByte)
  {
    this(new ByteArrayInputStream(paramArrayOfByte), paramArrayOfByte.length);
  }
  
  public i(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    this(new ByteArrayInputStream(paramArrayOfByte), paramArrayOfByte.length, paramBoolean);
  }
  
  static q g(int paramInt, r1 paramr1, byte[][] paramArrayOfByte)
    throws IOException
  {
    if (paramInt != 10)
    {
      if (paramInt != 12)
      {
        if (paramInt != 30)
        {
          switch (paramInt)
          {
          default: 
            switch (paramInt)
            {
            default: 
              paramr1 = new StringBuilder();
              paramr1.append("unknown tag ");
              paramr1.append(paramInt);
              paramr1.append(" encountered");
              throw new IOException(paramr1.toString());
            case 28: 
              return new j1(paramr1.e());
            case 27: 
              return new r0(paramr1.e());
            case 26: 
              return new l1(paramr1.e());
            case 25: 
              return new t0(paramr1.e());
            case 24: 
              return new h(paramr1.e());
            case 23: 
              return new y(paramr1.e());
            case 22: 
              return new u0(paramr1.e());
            case 21: 
              return new k1(paramr1.e());
            case 20: 
              return new f1(paramr1.e());
            case 19: 
              return new a1(paramr1.e());
            }
            return new w0(paramr1.e());
          case 6: 
            return m.o(j(paramr1, paramArrayOfByte));
          case 5: 
            return v0.c;
          case 4: 
            return new x0(paramr1.e());
          case 3: 
            return b.n(paramr1.a(), paramr1);
          case 2: 
            return new j(paramr1.e(), false);
          }
          return c.m(j(paramr1, paramArrayOfByte));
        }
        return new m0(i(paramr1));
      }
      return new i1(paramr1.e());
    }
    return g.m(j(paramr1, paramArrayOfByte));
  }
  
  private static char[] i(r1 paramr1)
    throws IOException
  {
    int i = paramr1.a() / 2;
    char[] arrayOfChar = new char[i];
    for (int j = 0; j < i; j++)
    {
      int k = paramr1.read();
      if (k < 0) {
        break;
      }
      int m = paramr1.read();
      if (m < 0) {
        break;
      }
      arrayOfChar[j] = ((char)(char)(k << 8 | m & 0xFF));
    }
    return arrayOfChar;
  }
  
  private static byte[] j(r1 paramr1, byte[][] paramArrayOfByte)
    throws IOException
  {
    int i = paramr1.a();
    if (paramr1.a() < paramArrayOfByte.length)
    {
      byte[] arrayOfByte1 = paramArrayOfByte[i];
      byte[] arrayOfByte2 = arrayOfByte1;
      if (arrayOfByte1 == null)
      {
        arrayOfByte2 = new byte[i];
        paramArrayOfByte[i] = arrayOfByte2;
      }
      org.bouncycastle.util.io.b.c(paramr1, arrayOfByte2);
      return arrayOfByte2;
    }
    return paramr1.e();
  }
  
  static int s(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    int i = paramInputStream.read();
    if (i >= 0)
    {
      if (i == 128) {
        return -1;
      }
      int j = i;
      if (i > 127)
      {
        int k = i & 0x7F;
        if (k <= 4)
        {
          j = 0;
          i = 0;
          while (i < k)
          {
            int m = paramInputStream.read();
            if (m >= 0)
            {
              j = (j << 8) + m;
              i++;
            }
            else
            {
              throw new EOFException("EOF found reading length");
            }
          }
          if (j >= 0)
          {
            if (j >= paramInt) {
              throw new IOException("corrupted stream - out of bounds length found");
            }
          }
          else {
            throw new IOException("corrupted stream - negative length found");
          }
        }
        else
        {
          paramInputStream = new StringBuilder();
          paramInputStream.append("DER length more than 4 bytes: ");
          paramInputStream.append(k);
          throw new IOException(paramInputStream.toString());
        }
      }
      return j;
    }
    throw new EOFException("EOF found when length expected");
  }
  
  static int u(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    int i = paramInt & 0x1F;
    paramInt = i;
    if (i == 31)
    {
      paramInt = 0;
      i = paramInputStream.read();
      if ((i & 0x7F) != 0)
      {
        while ((i >= 0) && ((i & 0x80) != 0))
        {
          paramInt = (paramInt | i & 0x7F) << 7;
          i = paramInputStream.read();
        }
        if (i >= 0) {
          paramInt |= i & 0x7F;
        } else {
          throw new EOFException("EOF found inside tag value.");
        }
      }
      else
      {
        throw new IOException("corrupted stream - invalid high tag number found");
      }
    }
    return paramInt;
  }
  
  f a(r1 paramr1)
    throws IOException
  {
    return new i(paramr1).c();
  }
  
  f c()
    throws IOException
  {
    f localf = new f();
    for (;;)
    {
      q localq = t();
      if (localq == null) {
        break;
      }
      localf.a(localq);
    }
    return localf;
  }
  
  protected q e(int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    int i = 0;
    boolean bool;
    if ((paramInt1 & 0x20) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject = new r1(this, paramInt3);
    if ((paramInt1 & 0x40) != 0) {
      return new l0(bool, paramInt2, ((r1)localObject).e());
    }
    if ((paramInt1 & 0x80) != 0) {
      return new v((InputStream)localObject).c(bool, paramInt2);
    }
    if (bool)
    {
      if (paramInt2 != 4)
      {
        if (paramInt2 != 8)
        {
          if (paramInt2 != 16)
          {
            if (paramInt2 == 17) {
              return q0.b(a((r1)localObject));
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("unknown tag ");
            ((StringBuilder)localObject).append(paramInt2);
            ((StringBuilder)localObject).append(" encountered");
            throw new IOException(((StringBuilder)localObject).toString());
          }
          if (this.d) {
            return new v1(((r1)localObject).e());
          }
          return q0.a(a((r1)localObject));
        }
        return new o0(a((r1)localObject));
      }
      f localf = a((r1)localObject);
      paramInt2 = localf.c();
      localObject = new n[paramInt2];
      for (paramInt1 = i; paramInt1 != paramInt2; paramInt1++) {
        localObject[paramInt1] = ((n)localf.b(paramInt1));
      }
      return new c0((n[])localObject);
    }
    return g(paramInt2, (r1)localObject, this.f);
  }
  
  int k()
  {
    return this.c;
  }
  
  protected int l()
    throws IOException
  {
    return s(this, this.c);
  }
  
  public q t()
    throws IOException
  {
    int i = read();
    if (i <= 0)
    {
      if (i != 0) {
        return null;
      }
      throw new IOException("unexpected end-of-contents marker");
    }
    int j = u(this, i);
    int k;
    if ((i & 0x20) != 0) {
      k = 1;
    } else {
      k = 0;
    }
    int m = l();
    Object localObject;
    if (m < 0)
    {
      if (k != 0)
      {
        localObject = new v(new t1(this, this.c), this.c);
        if ((i & 0x40) != 0) {
          return new a0(j, (v)localObject).b();
        }
        if ((i & 0x80) != 0) {
          return new j0(true, j, (v)localObject).b();
        }
        if (j != 4)
        {
          if (j != 8)
          {
            if (j != 16)
            {
              if (j == 17) {
                return new h0((v)localObject).b();
              }
              throw new IOException("unknown BER object encountered");
            }
            return new f0((v)localObject).b();
          }
          return new p0((v)localObject).b();
        }
        return new d0((v)localObject).b();
      }
      throw new IOException("indefinite-length primitive encoding encountered");
    }
    try
    {
      localObject = e(i, j, m);
      return (q)localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new ASN1Exception("corrupted stream detected", localIllegalArgumentException);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */