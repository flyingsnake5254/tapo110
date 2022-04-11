package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.bouncycastle.util.a;

public class m
  extends q
{
  private static final ConcurrentMap<a, m> c = new ConcurrentHashMap();
  private final String d;
  private byte[] f;
  
  public m(String paramString)
  {
    if (paramString != null)
    {
      if (v(paramString))
      {
        this.d = paramString;
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("string ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" not an OID");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    throw new IllegalArgumentException("'identifier' cannot be null");
  }
  
  m(m paramm, String paramString)
  {
    if (u(paramString, 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramm.q());
      localStringBuilder.append(".");
      localStringBuilder.append(paramString);
      this.d = localStringBuilder.toString();
      return;
    }
    paramm = new StringBuilder();
    paramm.append("string ");
    paramm.append(paramString);
    paramm.append(" not a valid OID branch");
    throw new IllegalArgumentException(paramm.toString());
  }
  
  m(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 1;
    long l1 = 0L;
    int j = 0;
    Object localObject1 = null;
    while (j != paramArrayOfByte.length)
    {
      int k = paramArrayOfByte[j] & 0xFF;
      if (l1 <= 72057594037927808L)
      {
        long l2 = l1 + (k & 0x7F);
        if ((k & 0x80) == 0)
        {
          k = i;
          l1 = l2;
          if (i != 0)
          {
            if (l2 < 40L)
            {
              localStringBuffer.append('0');
              l1 = l2;
            }
            else if (l2 < 80L)
            {
              localStringBuffer.append('1');
              l1 = l2 - 40L;
            }
            else
            {
              localStringBuffer.append('2');
              l1 = l2 - 80L;
            }
            k = 0;
          }
          localStringBuffer.append('.');
          localStringBuffer.append(l1);
          l1 = 0L;
          i = k;
        }
        else
        {
          l1 = l2 << 7;
        }
      }
      else
      {
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = BigInteger.valueOf(l1);
        }
        localObject2 = ((BigInteger)localObject2).or(BigInteger.valueOf(k & 0x7F));
        if ((k & 0x80) == 0)
        {
          k = i;
          localObject1 = localObject2;
          if (i != 0)
          {
            localStringBuffer.append('2');
            localObject1 = ((BigInteger)localObject2).subtract(BigInteger.valueOf(80L));
            k = 0;
          }
          localStringBuffer.append('.');
          localStringBuffer.append(localObject1);
          l1 = 0L;
          localObject1 = null;
          i = k;
        }
        else
        {
          localObject1 = ((BigInteger)localObject2).shiftLeft(7);
        }
      }
      j++;
    }
    this.d = localStringBuffer.toString();
    this.f = a.g(paramArrayOfByte);
  }
  
  private void n(ByteArrayOutputStream paramByteArrayOutputStream)
  {
    x1 localx1 = new x1(this.d);
    int i = Integer.parseInt(localx1.b()) * 40;
    String str = localx1.b();
    if (str.length() <= 18) {
      w(paramByteArrayOutputStream, i + Long.parseLong(str));
    } else {
      x(paramByteArrayOutputStream, new BigInteger(str).add(BigInteger.valueOf(i)));
    }
    while (localx1.a())
    {
      str = localx1.b();
      if (str.length() <= 18) {
        w(paramByteArrayOutputStream, Long.parseLong(str));
      } else {
        x(paramByteArrayOutputStream, new BigInteger(str));
      }
    }
  }
  
  static m o(byte[] paramArrayOfByte)
  {
    Object localObject = new a(paramArrayOfByte);
    m localm = (m)c.get(localObject);
    localObject = localm;
    if (localm == null) {
      localObject = new m(paramArrayOfByte);
    }
    return (m)localObject;
  }
  
  private byte[] p()
  {
    try
    {
      if (this.f == null)
      {
        localObject1 = new java/io/ByteArrayOutputStream;
        ((ByteArrayOutputStream)localObject1).<init>();
        n((ByteArrayOutputStream)localObject1);
        this.f = ((ByteArrayOutputStream)localObject1).toByteArray();
      }
      Object localObject1 = this.f;
      return (byte[])localObject1;
    }
    finally {}
  }
  
  public static m r(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof m)))
    {
      if ((paramObject instanceof e))
      {
        e locale = (e)paramObject;
        if ((locale.c() instanceof m)) {
          return (m)locale.c();
        }
      }
      if ((paramObject instanceof byte[]))
      {
        paramObject = (byte[])paramObject;
        try
        {
          paramObject = (m)q.i((byte[])paramObject);
          return (m)paramObject;
        }
        catch (IOException localIOException)
        {
          paramObject = new StringBuilder();
          ((StringBuilder)paramObject).append("failed to construct object identifier from byte[]: ");
          ((StringBuilder)paramObject).append(localIOException.getMessage());
          throw new IllegalArgumentException(((StringBuilder)paramObject).toString());
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("illegal object in getInstance: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (m)paramObject;
  }
  
  public static m s(x paramx, boolean paramBoolean)
  {
    paramx = paramx.o();
    if ((!paramBoolean) && (!(paramx instanceof m))) {
      return o(n.m(paramx).o());
    }
    return r(paramx);
  }
  
  private static boolean u(String paramString, int paramInt)
  {
    int i = paramString.length();
    boolean bool;
    int j;
    do
    {
      for (bool = false;; bool = true)
      {
        i--;
        if (i < paramInt) {
          return bool;
        }
        j = paramString.charAt(i);
        if ((48 > j) || (j > 57)) {
          break;
        }
      }
    } while ((j == 46) && (bool));
    return false;
    return bool;
  }
  
  private static boolean v(String paramString)
  {
    if ((paramString.length() >= 3) && (paramString.charAt(1) == '.'))
    {
      int i = paramString.charAt(0);
      if ((i >= 48) && (i <= 50)) {
        return u(paramString, 2);
      }
    }
    return false;
  }
  
  private void w(ByteArrayOutputStream paramByteArrayOutputStream, long paramLong)
  {
    byte[] arrayOfByte = new byte[9];
    int i = (byte)((int)paramLong & 0x7F);
    int j = 8;
    arrayOfByte[8] = ((byte)i);
    while (paramLong >= 128L)
    {
      paramLong >>= 7;
      j--;
      arrayOfByte[j] = ((byte)(byte)((int)paramLong & 0x7F | 0x80));
    }
    paramByteArrayOutputStream.write(arrayOfByte, j, 9 - j);
  }
  
  private void x(ByteArrayOutputStream paramByteArrayOutputStream, BigInteger paramBigInteger)
  {
    int i = (paramBigInteger.bitLength() + 6) / 7;
    if (i == 0)
    {
      paramByteArrayOutputStream.write(0);
    }
    else
    {
      byte[] arrayOfByte = new byte[i];
      int j = i - 1;
      for (int k = j; k >= 0; k--)
      {
        arrayOfByte[k] = ((byte)(byte)(paramBigInteger.intValue() & 0x7F | 0x80));
        paramBigInteger = paramBigInteger.shiftRight(7);
      }
      arrayOfByte[j] = ((byte)(byte)(arrayOfByte[j] & 0x7F));
      paramByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  boolean f(q paramq)
  {
    if (paramq == this) {
      return true;
    }
    if (!(paramq instanceof m)) {
      return false;
    }
    return this.d.equals(((m)paramq).d);
  }
  
  void g(p paramp)
    throws IOException
  {
    byte[] arrayOfByte = p();
    paramp.c(6);
    paramp.i(arrayOfByte.length);
    paramp.d(arrayOfByte);
  }
  
  int h()
    throws IOException
  {
    int i = p().length;
    return y1.a(i) + 1 + i;
  }
  
  public int hashCode()
  {
    return this.d.hashCode();
  }
  
  boolean j()
  {
    return false;
  }
  
  public m m(String paramString)
  {
    return new m(this, paramString);
  }
  
  public String q()
  {
    return this.d;
  }
  
  public m t()
  {
    a locala = new a(p());
    ConcurrentMap localConcurrentMap = c;
    m localm1 = (m)localConcurrentMap.get(locala);
    m localm2 = localm1;
    if (localm1 == null)
    {
      localm1 = (m)localConcurrentMap.putIfAbsent(locala, this);
      localm2 = localm1;
      if (localm1 == null) {
        localm2 = this;
      }
    }
    return localm2;
  }
  
  public String toString()
  {
    return q();
  }
  
  private static class a
  {
    private final int a;
    private final byte[] b;
    
    a(byte[] paramArrayOfByte)
    {
      this.a = a.w(paramArrayOfByte);
      this.b = paramArrayOfByte;
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof a)) {
        return a.c(this.b, ((a)paramObject).b);
      }
      return false;
    }
    
    public int hashCode()
    {
      return this.a;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */