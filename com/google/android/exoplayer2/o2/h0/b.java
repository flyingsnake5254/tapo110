package com.google.android.exoplayer2.o2.h0;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.o2.k;
import java.io.IOException;
import java.util.ArrayDeque;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

final class b
  implements d
{
  private final byte[] a = new byte[8];
  private final ArrayDeque<b> b = new ArrayDeque();
  private final g c = new g();
  private c d;
  private int e;
  private int f;
  private long g;
  
  @RequiresNonNull({"processor"})
  private long c(k paramk)
    throws IOException
  {
    paramk.e();
    for (;;)
    {
      paramk.n(this.a, 0, 4);
      int i = g.c(this.a[0]);
      if ((i != -1) && (i <= 4))
      {
        int j = (int)g.a(this.a, i, false);
        if (this.d.e(j))
        {
          paramk.l(i);
          return j;
        }
      }
      paramk.l(1);
    }
  }
  
  private double d(k paramk, int paramInt)
    throws IOException
  {
    long l = e(paramk, paramInt);
    double d1;
    if (paramInt == 4) {
      d1 = Float.intBitsToFloat((int)l);
    } else {
      d1 = Double.longBitsToDouble(l);
    }
    return d1;
  }
  
  private long e(k paramk, int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = this.a;
    int i = 0;
    paramk.readFully(arrayOfByte, 0, paramInt);
    long l = 0L;
    while (i < paramInt)
    {
      l = l << 8 | this.a[i] & 0xFF;
      i++;
    }
    return l;
  }
  
  private static String f(k paramk, int paramInt)
    throws IOException
  {
    if (paramInt == 0) {
      return "";
    }
    byte[] arrayOfByte = new byte[paramInt];
    paramk.readFully(arrayOfByte, 0, paramInt);
    while ((paramInt > 0) && (arrayOfByte[(paramInt - 1)] == 0)) {
      paramInt--;
    }
    return new String(arrayOfByte, 0, paramInt);
  }
  
  public boolean a(k paramk)
    throws IOException
  {
    com.google.android.exoplayer2.util.g.i(this.d);
    for (;;)
    {
      b localb = (b)this.b.peek();
      if ((localb != null) && (paramk.getPosition() >= b.a(localb)))
      {
        this.d.a(b.b((b)this.b.pop()));
        return true;
      }
      long l1;
      long l2;
      if (this.e == 0)
      {
        l1 = this.c.d(paramk, true, false, 4);
        l2 = l1;
        if (l1 == -2L) {
          l2 = c(paramk);
        }
        if (l2 == -1L) {
          return false;
        }
        this.f = ((int)l2);
        this.e = 1;
      }
      if (this.e == 1)
      {
        this.g = this.c.d(paramk, false, true, 8);
        this.e = 2;
      }
      int i = this.d.d(this.f);
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4)
              {
                if (i == 5)
                {
                  l2 = this.g;
                  if ((l2 != 4L) && (l2 != 8L))
                  {
                    paramk = new StringBuilder(40);
                    paramk.append("Invalid float size: ");
                    paramk.append(l2);
                    throw ParserException.createForMalformedContainer(paramk.toString(), null);
                  }
                  this.d.b(this.f, d(paramk, (int)l2));
                  this.e = 0;
                  return true;
                }
                paramk = new StringBuilder(32);
                paramk.append("Invalid element type ");
                paramk.append(i);
                throw ParserException.createForMalformedContainer(paramk.toString(), null);
              }
              this.d.f(this.f, (int)this.g, paramk);
              this.e = 0;
              return true;
            }
            l2 = this.g;
            if (l2 <= 2147483647L)
            {
              this.d.g(this.f, f(paramk, (int)l2));
              this.e = 0;
              return true;
            }
            paramk = new StringBuilder(41);
            paramk.append("String element size: ");
            paramk.append(l2);
            throw ParserException.createForMalformedContainer(paramk.toString(), null);
          }
          l2 = this.g;
          if (l2 <= 8L)
          {
            this.d.c(this.f, e(paramk, (int)l2));
            this.e = 0;
            return true;
          }
          paramk = new StringBuilder(42);
          paramk.append("Invalid integer size: ");
          paramk.append(l2);
          throw ParserException.createForMalformedContainer(paramk.toString(), null);
        }
        l2 = paramk.getPosition();
        l1 = this.g;
        this.b.push(new b(this.f, l1 + l2, null));
        this.d.h(this.f, l2, this.g);
        this.e = 0;
        return true;
      }
      paramk.l((int)this.g);
      this.e = 0;
    }
  }
  
  public void b(c paramc)
  {
    this.d = paramc;
  }
  
  public void reset()
  {
    this.e = 0;
    this.b.clear();
    this.c.e();
  }
  
  private static final class b
  {
    private final int a;
    private final long b;
    
    private b(int paramInt, long paramLong)
    {
      this.a = paramInt;
      this.b = paramLong;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\h0\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */