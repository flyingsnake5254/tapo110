package com.google.android.exoplayer2.util;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class z
{
  public static final byte[] a = { 0, 0, 0, 1 };
  public static final float[] b = { 1.0F, 1.0F, 1.0909091F, 0.90909094F, 1.4545455F, 1.2121212F, 2.1818182F, 1.8181819F, 2.909091F, 2.4242425F, 1.6363636F, 1.3636364F, 1.939394F, 1.6161616F, 1.3333334F, 1.5F, 2.0F };
  private static final Object c = new Object();
  private static int[] d = new int[10];
  
  public static void a(boolean[] paramArrayOfBoolean)
  {
    paramArrayOfBoolean[0] = false;
    paramArrayOfBoolean[1] = false;
    paramArrayOfBoolean[2] = false;
  }
  
  public static void b(ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.position();
    int j = 0;
    int k = 0;
    for (;;)
    {
      int m = j + 1;
      if (m >= i) {
        break;
      }
      int n = paramByteBuffer.get(j) & 0xFF;
      int i1;
      if (k == 3)
      {
        i1 = k;
        if (n == 1)
        {
          i1 = k;
          if ((paramByteBuffer.get(m) & 0x1F) == 7)
          {
            ByteBuffer localByteBuffer = paramByteBuffer.duplicate();
            localByteBuffer.position(j - 3);
            localByteBuffer.limit(i);
            paramByteBuffer.position(0);
            paramByteBuffer.put(localByteBuffer);
          }
        }
      }
      else
      {
        i1 = k;
        if (n == 0) {
          i1 = k + 1;
        }
      }
      k = i1;
      if (n != 0) {
        k = 0;
      }
      j = m;
    }
    paramByteBuffer.clear();
  }
  
  public static int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean[] paramArrayOfBoolean)
  {
    int i = paramInt2 - paramInt1;
    boolean bool1 = false;
    if (i >= 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    g.g(bool2);
    if (i == 0) {
      return paramInt2;
    }
    if (paramArrayOfBoolean[0] != 0)
    {
      a(paramArrayOfBoolean);
      return paramInt1 - 3;
    }
    if ((i > 1) && (paramArrayOfBoolean[1] != 0) && (paramArrayOfByte[paramInt1] == 1))
    {
      a(paramArrayOfBoolean);
      return paramInt1 - 2;
    }
    if ((i > 2) && (paramArrayOfBoolean[2] != 0) && (paramArrayOfByte[paramInt1] == 0) && (paramArrayOfByte[(paramInt1 + 1)] == 1))
    {
      a(paramArrayOfBoolean);
      return paramInt1 - 1;
    }
    int j = paramInt2 - 1;
    paramInt1 += 2;
    while (paramInt1 < j)
    {
      if ((paramArrayOfByte[paramInt1] & 0xFE) == 0)
      {
        int k = paramInt1 - 2;
        if ((paramArrayOfByte[k] == 0) && (paramArrayOfByte[(paramInt1 - 1)] == 0) && (paramArrayOfByte[paramInt1] == 1))
        {
          a(paramArrayOfBoolean);
          return k;
        }
        paramInt1 -= 2;
      }
      paramInt1 += 3;
    }
    if (i > 2)
    {
      if ((paramArrayOfByte[(paramInt2 - 3)] == 0) && (paramArrayOfByte[(paramInt2 - 2)] == 0) && (paramArrayOfByte[j] == 1)) {}
    }
    else {
      while (i == 2 ? (paramArrayOfBoolean[2] == 0) || (paramArrayOfByte[(paramInt2 - 2)] != 0) || (paramArrayOfByte[j] != 1) : (paramArrayOfBoolean[1] == 0) || (paramArrayOfByte[j] != 1))
      {
        bool2 = false;
        break;
      }
    }
    boolean bool2 = true;
    paramArrayOfBoolean[0] = bool2;
    if (i > 1 ? (paramArrayOfByte[(paramInt2 - 2)] == 0) && (paramArrayOfByte[j] == 0) : (paramArrayOfBoolean[2] != 0) && (paramArrayOfByte[j] == 0)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    paramArrayOfBoolean[1] = bool2;
    bool2 = bool1;
    if (paramArrayOfByte[j] == 0) {
      bool2 = true;
    }
    paramArrayOfBoolean[2] = bool2;
    return paramInt2;
  }
  
  private static int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2 - 2)
    {
      if ((paramArrayOfByte[paramInt1] == 0) && (paramArrayOfByte[(paramInt1 + 1)] == 0) && (paramArrayOfByte[(paramInt1 + 2)] == 3)) {
        return paramInt1;
      }
      paramInt1++;
    }
    return paramInt2;
  }
  
  public static int e(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte[(paramInt + 3)] & 0x7E) >> 1;
  }
  
  public static int f(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[(paramInt + 3)] & 0x1F;
  }
  
  public static boolean g(@Nullable String paramString, byte paramByte)
  {
    boolean bool1 = "video/avc".equals(paramString);
    boolean bool2 = true;
    if (bool1)
    {
      bool1 = bool2;
      if ((paramByte & 0x1F) == 6) {}
    }
    else if (("video/hevc".equals(paramString)) && ((paramByte & 0x7E) >> 1 == 39))
    {
      bool1 = bool2;
    }
    else
    {
      bool1 = false;
    }
    return bool1;
  }
  
  public static a h(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte = new e0(paramArrayOfByte, paramInt1, paramInt2);
    paramArrayOfByte.l(8);
    paramInt1 = paramArrayOfByte.h();
    paramInt2 = paramArrayOfByte.h();
    paramArrayOfByte.k();
    return new a(paramInt1, paramInt2, paramArrayOfByte.d());
  }
  
  public static b i(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte = new e0(paramArrayOfByte, paramInt1, paramInt2);
    paramArrayOfByte.l(8);
    int i = paramArrayOfByte.e(8);
    int j = paramArrayOfByte.e(8);
    int k = paramArrayOfByte.e(8);
    int m = paramArrayOfByte.h();
    int n = 1;
    int i1;
    boolean bool1;
    if ((i != 100) && (i != 110) && (i != 122) && (i != 244) && (i != 44) && (i != 83) && (i != 86) && (i != 118) && (i != 128) && (i != 138))
    {
      i1 = 1;
      bool1 = false;
    }
    else
    {
      i2 = paramArrayOfByte.h();
      if (i2 == 3) {
        bool2 = paramArrayOfByte.d();
      } else {
        bool2 = false;
      }
      paramArrayOfByte.h();
      paramArrayOfByte.h();
      paramArrayOfByte.k();
      i1 = i2;
      bool1 = bool2;
      if (paramArrayOfByte.d())
      {
        if (i2 != 3) {
          paramInt1 = 8;
        } else {
          paramInt1 = 12;
        }
        for (paramInt2 = 0;; paramInt2++)
        {
          i1 = i2;
          bool1 = bool2;
          if (paramInt2 >= paramInt1) {
            break;
          }
          if (paramArrayOfByte.d())
          {
            if (paramInt2 < 6) {
              i1 = 16;
            } else {
              i1 = 64;
            }
            j(paramArrayOfByte, i1);
          }
        }
      }
    }
    int i3 = paramArrayOfByte.h();
    int i4 = paramArrayOfByte.h();
    if (i4 == 0)
    {
      paramInt1 = paramArrayOfByte.h() + 4;
    }
    else
    {
      if (i4 == 1)
      {
        bool2 = paramArrayOfByte.d();
        paramArrayOfByte.g();
        paramArrayOfByte.g();
        long l = paramArrayOfByte.h();
        for (paramInt1 = 0; paramInt1 < l; paramInt1++) {
          paramArrayOfByte.h();
        }
        paramInt2 = 0;
        break label332;
      }
      paramInt1 = 0;
    }
    boolean bool2 = false;
    paramInt2 = paramInt1;
    label332:
    paramArrayOfByte.h();
    paramArrayOfByte.k();
    int i2 = paramArrayOfByte.h();
    paramInt1 = paramArrayOfByte.h();
    boolean bool3 = paramArrayOfByte.d();
    if (!bool3) {
      paramArrayOfByte.k();
    }
    paramArrayOfByte.k();
    int i5 = (i2 + 1) * 16;
    int i6 = (true - bool3) * (paramInt1 + 1) * 16;
    i2 = i5;
    paramInt1 = i6;
    if (paramArrayOfByte.d())
    {
      int i7 = paramArrayOfByte.h();
      int i8 = paramArrayOfByte.h();
      int i9 = paramArrayOfByte.h();
      int i10 = paramArrayOfByte.h();
      if (i1 == 0)
      {
        paramInt1 = true - bool3;
        i1 = n;
      }
      else
      {
        if (i1 == 3) {
          paramInt1 = 1;
        } else {
          paramInt1 = 2;
        }
        i2 = 1;
        if (i1 == 1) {
          i2 = 2;
        }
        i2 = (true - bool3) * i2;
        i1 = paramInt1;
        paramInt1 = i2;
      }
      i2 = i5 - (i7 + i8) * i1;
      paramInt1 = i6 - (i9 + i10) * paramInt1;
    }
    float f1 = 1.0F;
    float f2;
    if ((paramArrayOfByte.d()) && (paramArrayOfByte.d()))
    {
      i1 = paramArrayOfByte.e(8);
      if (i1 == 255)
      {
        n = paramArrayOfByte.e(16);
        i1 = paramArrayOfByte.e(16);
        f2 = f1;
        if (n != 0)
        {
          f2 = f1;
          if (i1 != 0) {
            f2 = n / i1;
          }
        }
      }
      else
      {
        paramArrayOfByte = b;
        if (i1 < paramArrayOfByte.length)
        {
          f2 = paramArrayOfByte[i1];
        }
        else
        {
          paramArrayOfByte = new StringBuilder(46);
          paramArrayOfByte.append("Unexpected aspect_ratio_idc value: ");
          paramArrayOfByte.append(i1);
          u.h("NalUnitUtil", paramArrayOfByte.toString());
        }
      }
    }
    else
    {
      f2 = 1.0F;
    }
    return new b(i, j, k, m, i2, paramInt1, f2, bool1, bool3, i3 + 4, i4, paramInt2, bool2);
  }
  
  private static void j(e0 parame0, int paramInt)
  {
    int i = 8;
    int j = 8;
    int k = 0;
    while (k < paramInt)
    {
      int m = i;
      if (i != 0) {
        m = (parame0.g() + j + 256) % 256;
      }
      if (m != 0) {
        j = m;
      }
      k++;
      i = m;
    }
  }
  
  public static int k(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject = c;
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (i < paramInt) {
        try
        {
          k = d(paramArrayOfByte, i, paramInt);
          i = k;
          if (k < paramInt)
          {
            int[] arrayOfInt = d;
            if (arrayOfInt.length <= j) {
              d = Arrays.copyOf(arrayOfInt, arrayOfInt.length * 2);
            }
            d[j] = k;
            i = k + 3;
            j++;
          }
        }
        finally
        {
          break label182;
        }
      }
    }
    int m = paramInt - j;
    i = 0;
    int k = 0;
    paramInt = 0;
    while (i < j)
    {
      int n = d[i] - paramInt;
      System.arraycopy(paramArrayOfByte, paramInt, paramArrayOfByte, k, n);
      k += n;
      int i1 = k + 1;
      paramArrayOfByte[k] = ((byte)0);
      k = i1 + 1;
      paramArrayOfByte[i1] = ((byte)0);
      paramInt += n + 3;
      i++;
    }
    System.arraycopy(paramArrayOfByte, paramInt, paramArrayOfByte, k, m - k);
    return m;
    label182:
    throw paramArrayOfByte;
  }
  
  public static final class a
  {
    public final int a;
    public final int b;
    public final boolean c;
    
    public a(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramBoolean;
    }
  }
  
  public static final class b
  {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final float g;
    public final boolean h;
    public final boolean i;
    public final int j;
    public final int k;
    public final int l;
    public final boolean m;
    
    public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat, boolean paramBoolean1, boolean paramBoolean2, int paramInt7, int paramInt8, int paramInt9, boolean paramBoolean3)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
      this.d = paramInt4;
      this.e = paramInt5;
      this.f = paramInt6;
      this.g = paramFloat;
      this.h = paramBoolean1;
      this.i = paramBoolean2;
      this.j = paramInt7;
      this.k = paramInt8;
      this.l = paramInt9;
      this.m = paramBoolean3;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\util\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */