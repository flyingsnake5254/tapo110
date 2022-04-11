package com.google.android.exoplayer2.util;

import androidx.annotation.Nullable;
import com.google.common.base.e;
import java.nio.charset.Charset;
import java.util.Arrays;

public final class d0
{
  private byte[] a;
  private int b;
  private int c;
  
  public d0()
  {
    this.a = o0.f;
  }
  
  public d0(int paramInt)
  {
    this.a = new byte[paramInt];
    this.c = paramInt;
  }
  
  public d0(byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
    this.c = paramArrayOfByte.length;
  }
  
  public d0(byte[] paramArrayOfByte, int paramInt)
  {
    this.a = paramArrayOfByte;
    this.c = paramInt;
  }
  
  public String A(int paramInt)
  {
    return B(paramInt, e.c);
  }
  
  public String B(int paramInt, Charset paramCharset)
  {
    paramCharset = new String(this.a, this.b, paramInt, paramCharset);
    this.b += paramInt;
    return paramCharset;
  }
  
  public int C()
  {
    return D() << 21 | D() << 14 | D() << 7 | D();
  }
  
  public int D()
  {
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    return arrayOfByte[i] & 0xFF;
  }
  
  public int E()
  {
    byte[] arrayOfByte = this.a;
    int i = this.b;
    int j = i + 1;
    this.b = j;
    i = arrayOfByte[i];
    int k = j + 1;
    this.b = k;
    j = arrayOfByte[j];
    this.b = (k + 2);
    return j & 0xFF | (i & 0xFF) << 8;
  }
  
  public long F()
  {
    byte[] arrayOfByte = this.a;
    int i = this.b;
    int j = i + 1;
    this.b = j;
    long l1 = arrayOfByte[i];
    i = j + 1;
    this.b = i;
    long l2 = arrayOfByte[j];
    j = i + 1;
    this.b = j;
    long l3 = arrayOfByte[i];
    this.b = (j + 1);
    return (l1 & 0xFF) << 24 | (l2 & 0xFF) << 16 | (l3 & 0xFF) << 8 | arrayOfByte[j] & 0xFF;
  }
  
  public int G()
  {
    byte[] arrayOfByte = this.a;
    int i = this.b;
    int j = i + 1;
    this.b = j;
    int k = arrayOfByte[i];
    i = j + 1;
    this.b = i;
    j = arrayOfByte[j];
    this.b = (i + 1);
    return arrayOfByte[i] & 0xFF | (k & 0xFF) << 16 | (j & 0xFF) << 8;
  }
  
  public int H()
  {
    int i = n();
    if (i >= 0) {
      return i;
    }
    StringBuilder localStringBuilder = new StringBuilder(29);
    localStringBuilder.append("Top bit not zero: ");
    localStringBuilder.append(i);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public long I()
  {
    long l = w();
    if (l >= 0L) {
      return l;
    }
    StringBuilder localStringBuilder = new StringBuilder(38);
    localStringBuilder.append("Top bit not zero: ");
    localStringBuilder.append(l);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public int J()
  {
    byte[] arrayOfByte = this.a;
    int i = this.b;
    int j = i + 1;
    this.b = j;
    i = arrayOfByte[i];
    this.b = (j + 1);
    return arrayOfByte[j] & 0xFF | (i & 0xFF) << 8;
  }
  
  public long K()
  {
    long l = this.a[this.b];
    int j;
    int k;
    for (int i = 7;; i--)
    {
      j = 1;
      if (i < 0) {
        break;
      }
      k = 1 << i;
      if ((k & l) == 0L)
      {
        if (i < 6)
        {
          l &= k - 1;
          i = 7 - i;
          break label77;
        }
        if (i != 7) {
          break;
        }
        i = 1;
        break label77;
      }
    }
    i = 0;
    label77:
    if (i != 0)
    {
      while (j < i)
      {
        k = this.a[(this.b + j)];
        if ((k & 0xC0) == 128)
        {
          l = l << 6 | k & 0x3F;
          j++;
        }
        else
        {
          localStringBuilder = new StringBuilder(62);
          localStringBuilder.append("Invalid UTF-8 sequence continuation byte: ");
          localStringBuilder.append(l);
          throw new NumberFormatException(localStringBuilder.toString());
        }
      }
      this.b += i;
      return l;
    }
    StringBuilder localStringBuilder = new StringBuilder(55);
    localStringBuilder.append("Invalid UTF-8 sequence first byte: ");
    localStringBuilder.append(l);
    throw new NumberFormatException(localStringBuilder.toString());
  }
  
  public void L(int paramInt)
  {
    byte[] arrayOfByte;
    if (b() < paramInt) {
      arrayOfByte = new byte[paramInt];
    } else {
      arrayOfByte = this.a;
    }
    N(arrayOfByte, paramInt);
  }
  
  public void M(byte[] paramArrayOfByte)
  {
    N(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public void N(byte[] paramArrayOfByte, int paramInt)
  {
    this.a = paramArrayOfByte;
    this.c = paramInt;
    this.b = 0;
  }
  
  public void O(int paramInt)
  {
    boolean bool;
    if ((paramInt >= 0) && (paramInt <= this.a.length)) {
      bool = true;
    } else {
      bool = false;
    }
    g.a(bool);
    this.c = paramInt;
  }
  
  public void P(int paramInt)
  {
    boolean bool;
    if ((paramInt >= 0) && (paramInt <= this.c)) {
      bool = true;
    } else {
      bool = false;
    }
    g.a(bool);
    this.b = paramInt;
  }
  
  public void Q(int paramInt)
  {
    P(this.b + paramInt);
  }
  
  public int a()
  {
    return this.c - this.b;
  }
  
  public int b()
  {
    return this.a.length;
  }
  
  public void c(int paramInt)
  {
    if (paramInt > b()) {
      this.a = Arrays.copyOf(this.a, paramInt);
    }
  }
  
  public byte[] d()
  {
    return this.a;
  }
  
  public int e()
  {
    return this.b;
  }
  
  public int f()
  {
    return this.c;
  }
  
  public char g()
  {
    byte[] arrayOfByte = this.a;
    int i = this.b;
    int j = arrayOfByte[i];
    return (char)(arrayOfByte[(i + 1)] & 0xFF | (j & 0xFF) << 8);
  }
  
  public int h()
  {
    return this.a[this.b] & 0xFF;
  }
  
  public void i(c0 paramc0, int paramInt)
  {
    j(paramc0.a, 0, paramInt);
    paramc0.p(0);
  }
  
  public void j(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    System.arraycopy(this.a, this.b, paramArrayOfByte, paramInt1, paramInt2);
    this.b += paramInt2;
  }
  
  @Nullable
  public String k(char paramChar)
  {
    if (a() == 0) {
      return null;
    }
    for (char c1 = this.b; (c1 < this.c) && (this.a[c1] != paramChar); c1++) {}
    Object localObject = this.a;
    paramChar = this.b;
    localObject = o0.C((byte[])localObject, paramChar, c1 - paramChar);
    this.b = c1;
    if (c1 < this.c) {
      this.b = (c1 + '\001');
    }
    return (String)localObject;
  }
  
  public double l()
  {
    return Double.longBitsToDouble(w());
  }
  
  public float m()
  {
    return Float.intBitsToFloat(n());
  }
  
  public int n()
  {
    byte[] arrayOfByte = this.a;
    int i = this.b;
    int j = i + 1;
    this.b = j;
    i = arrayOfByte[i];
    int k = j + 1;
    this.b = k;
    j = arrayOfByte[j];
    int m = k + 1;
    this.b = m;
    k = arrayOfByte[k];
    this.b = (m + 1);
    return arrayOfByte[m] & 0xFF | (i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8;
  }
  
  public int o()
  {
    byte[] arrayOfByte = this.a;
    int i = this.b;
    int j = i + 1;
    this.b = j;
    int k = arrayOfByte[i];
    i = j + 1;
    this.b = i;
    j = arrayOfByte[j];
    this.b = (i + 1);
    return arrayOfByte[i] & 0xFF | (k & 0xFF) << 24 >> 8 | (j & 0xFF) << 8;
  }
  
  @Nullable
  public String p()
  {
    if (a() == 0) {
      return null;
    }
    for (int i = this.b; (i < this.c) && (!o0.l0(this.a[i])); i++) {}
    int j = this.b;
    if (i - j >= 3)
    {
      arrayOfByte = this.a;
      if ((arrayOfByte[j] == -17) && (arrayOfByte[(j + 1)] == -69) && (arrayOfByte[(j + 2)] == -65)) {
        this.b = (j + 3);
      }
    }
    byte[] arrayOfByte = this.a;
    j = this.b;
    String str = o0.C(arrayOfByte, j, i - j);
    this.b = i;
    j = this.c;
    if (i == j) {
      return str;
    }
    arrayOfByte = this.a;
    if (arrayOfByte[i] == 13)
    {
      i++;
      this.b = i;
      if (i == j) {
        return str;
      }
    }
    i = this.b;
    if (arrayOfByte[i] == 10) {
      this.b = (i + 1);
    }
    return str;
  }
  
  public int q()
  {
    byte[] arrayOfByte = this.a;
    int i = this.b;
    int j = i + 1;
    this.b = j;
    i = arrayOfByte[i];
    int k = j + 1;
    this.b = k;
    int m = arrayOfByte[j];
    j = k + 1;
    this.b = j;
    k = arrayOfByte[k];
    this.b = (j + 1);
    return (arrayOfByte[j] & 0xFF) << 24 | i & 0xFF | (m & 0xFF) << 8 | (k & 0xFF) << 16;
  }
  
  public long r()
  {
    byte[] arrayOfByte = this.a;
    int i = this.b;
    int j = i + 1;
    this.b = j;
    long l1 = arrayOfByte[i];
    i = j + 1;
    this.b = i;
    long l2 = arrayOfByte[j];
    j = i + 1;
    this.b = j;
    long l3 = arrayOfByte[i];
    i = j + 1;
    this.b = i;
    long l4 = arrayOfByte[j];
    int k = i + 1;
    this.b = k;
    long l5 = arrayOfByte[i];
    j = k + 1;
    this.b = j;
    long l6 = arrayOfByte[k];
    i = j + 1;
    this.b = i;
    long l7 = arrayOfByte[j];
    this.b = (i + 1);
    return l1 & 0xFF | (l2 & 0xFF) << 8 | (l3 & 0xFF) << 16 | (l4 & 0xFF) << 24 | (l5 & 0xFF) << 32 | (l6 & 0xFF) << 40 | (l7 & 0xFF) << 48 | (arrayOfByte[i] & 0xFF) << 56;
  }
  
  public short s()
  {
    byte[] arrayOfByte = this.a;
    int i = this.b;
    int j = i + 1;
    this.b = j;
    i = arrayOfByte[i];
    this.b = (j + 1);
    return (short)((arrayOfByte[j] & 0xFF) << 8 | i & 0xFF);
  }
  
  public long t()
  {
    byte[] arrayOfByte = this.a;
    int i = this.b;
    int j = i + 1;
    this.b = j;
    long l1 = arrayOfByte[i];
    i = j + 1;
    this.b = i;
    long l2 = arrayOfByte[j];
    j = i + 1;
    this.b = j;
    long l3 = arrayOfByte[i];
    this.b = (j + 1);
    return l1 & 0xFF | (l2 & 0xFF) << 8 | (l3 & 0xFF) << 16 | (arrayOfByte[j] & 0xFF) << 24;
  }
  
  public int u()
  {
    int i = q();
    if (i >= 0) {
      return i;
    }
    StringBuilder localStringBuilder = new StringBuilder(29);
    localStringBuilder.append("Top bit not zero: ");
    localStringBuilder.append(i);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public int v()
  {
    byte[] arrayOfByte = this.a;
    int i = this.b;
    int j = i + 1;
    this.b = j;
    i = arrayOfByte[i];
    this.b = (j + 1);
    return (arrayOfByte[j] & 0xFF) << 8 | i & 0xFF;
  }
  
  public long w()
  {
    byte[] arrayOfByte = this.a;
    int i = this.b;
    int j = i + 1;
    this.b = j;
    long l1 = arrayOfByte[i];
    i = j + 1;
    this.b = i;
    long l2 = arrayOfByte[j];
    j = i + 1;
    this.b = j;
    long l3 = arrayOfByte[i];
    i = j + 1;
    this.b = i;
    long l4 = arrayOfByte[j];
    j = i + 1;
    this.b = j;
    long l5 = arrayOfByte[i];
    i = j + 1;
    this.b = i;
    long l6 = arrayOfByte[j];
    j = i + 1;
    this.b = j;
    long l7 = arrayOfByte[i];
    this.b = (j + 1);
    return (l1 & 0xFF) << 56 | (l2 & 0xFF) << 48 | (l3 & 0xFF) << 40 | (l4 & 0xFF) << 32 | (l5 & 0xFF) << 24 | (l6 & 0xFF) << 16 | (l7 & 0xFF) << 8 | arrayOfByte[j] & 0xFF;
  }
  
  @Nullable
  public String x()
  {
    return k('\000');
  }
  
  public String y(int paramInt)
  {
    if (paramInt == 0) {
      return "";
    }
    int i = this.b;
    int j = i + paramInt - 1;
    if ((j < this.c) && (this.a[j] == 0)) {
      j = paramInt - 1;
    } else {
      j = paramInt;
    }
    String str = o0.C(this.a, i, j);
    this.b += paramInt;
    return str;
  }
  
  public short z()
  {
    byte[] arrayOfByte = this.a;
    int i = this.b;
    int j = i + 1;
    this.b = j;
    i = arrayOfByte[i];
    this.b = (j + 1);
    return (short)(arrayOfByte[j] & 0xFF | (i & 0xFF) << 8);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\util\d0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */