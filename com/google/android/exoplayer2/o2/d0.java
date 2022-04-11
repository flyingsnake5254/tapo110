package com.google.android.exoplayer2.o2;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.u;
import java.util.Arrays;

public final class d0
{
  public static int a(int paramInt)
  {
    int i = 0;
    while (paramInt > 0)
    {
      i++;
      paramInt >>>= 1;
    }
    return i;
  }
  
  private static long b(long paramLong1, long paramLong2)
  {
    return Math.floor(Math.pow(paramLong1, 1.0D / paramLong2));
  }
  
  private static a c(c0 paramc0)
    throws ParserException
  {
    if (paramc0.d(24) == 5653314)
    {
      int i = paramc0.d(16);
      int j = paramc0.d(24);
      long[] arrayOfLong = new long[j];
      boolean bool1 = paramc0.c();
      long l = 0L;
      k = 0;
      if (!bool1)
      {
        boolean bool2 = paramc0.c();
        while (k < j)
        {
          if (bool2)
          {
            if (paramc0.c()) {
              arrayOfLong[k] = (paramc0.d(5) + 1);
            } else {
              arrayOfLong[k] = 0L;
            }
          }
          else {
            arrayOfLong[k] = (paramc0.d(5) + 1);
          }
          k++;
        }
      }
      k = paramc0.d(5) + 1;
      int m = 0;
      int i1;
      while (m < j)
      {
        int n = paramc0.d(a(j - m));
        for (i1 = 0; (i1 < n) && (m < j); i1++)
        {
          arrayOfLong[m] = k;
          m++;
        }
        k++;
      }
      k = paramc0.d(4);
      if (k <= 2)
      {
        if ((k == 1) || (k == 2))
        {
          paramc0.e(32);
          paramc0.e(32);
          i1 = paramc0.d(4);
          paramc0.e(1);
          if (k == 1)
          {
            if (i != 0) {
              l = b(j, i);
            }
          }
          else {
            l = j * i;
          }
          paramc0.e((int)(l * (i1 + 1)));
        }
        return new a(i, j, arrayOfLong, k, bool1);
      }
      paramc0 = new StringBuilder(53);
      paramc0.append("lookup type greater than 2 not decodable: ");
      paramc0.append(k);
      throw ParserException.createForMalformedContainer(paramc0.toString(), null);
    }
    int k = paramc0.b();
    paramc0 = new StringBuilder(66);
    paramc0.append("expected code book to start with [0x56, 0x43, 0x42] at ");
    paramc0.append(k);
    throw ParserException.createForMalformedContainer(paramc0.toString(), null);
  }
  
  private static void d(c0 paramc0)
    throws ParserException
  {
    int i = paramc0.d(6);
    for (int j = 0; j < i + 1; j++)
    {
      int k = paramc0.d(16);
      if (k != 0)
      {
        if (k == 1)
        {
          int m = paramc0.d(5);
          int n = -1;
          int[] arrayOfInt1 = new int[m];
          k = 0;
          while (k < m)
          {
            arrayOfInt1[k] = paramc0.d(4);
            i1 = n;
            if (arrayOfInt1[k] > n) {
              i1 = arrayOfInt1[k];
            }
            k++;
            n = i1;
          }
          n++;
          int[] arrayOfInt2 = new int[n];
          for (k = 0; k < n; k++)
          {
            arrayOfInt2[k] = (paramc0.d(3) + 1);
            i2 = paramc0.d(2);
            if (i2 > 0) {
              paramc0.e(8);
            }
            for (i1 = 0; i1 < 1 << i2; i1++) {
              paramc0.e(8);
            }
          }
          paramc0.e(2);
          int i2 = paramc0.d(4);
          i1 = 0;
          n = 0;
          k = 0;
          while (i1 < m)
          {
            n += arrayOfInt2[arrayOfInt1[i1]];
            while (k < n)
            {
              paramc0.e(i2);
              k++;
            }
            i1++;
          }
        }
        paramc0 = new StringBuilder(52);
        paramc0.append("floor type greater than 1 not decodable: ");
        paramc0.append(k);
        throw ParserException.createForMalformedContainer(paramc0.toString(), null);
      }
      paramc0.e(8);
      paramc0.e(16);
      paramc0.e(16);
      paramc0.e(6);
      paramc0.e(8);
      int i1 = paramc0.d(4);
      for (k = 0; k < i1 + 1; k++) {
        paramc0.e(8);
      }
    }
  }
  
  private static void e(int paramInt, c0 paramc0)
    throws ParserException
  {
    int i = paramc0.d(6);
    int j = 0;
    while (j < i + 1)
    {
      int k = paramc0.d(16);
      if (k != 0)
      {
        StringBuilder localStringBuilder = new StringBuilder(52);
        localStringBuilder.append("mapping type other than 0 not supported: ");
        localStringBuilder.append(k);
        u.c("VorbisUtil", localStringBuilder.toString());
      }
      else
      {
        if (paramc0.c()) {
          k = paramc0.d(4) + 1;
        } else {
          k = 1;
        }
        if (paramc0.c())
        {
          int m = paramc0.d(8);
          for (n = 0; n < m + 1; n++)
          {
            int i1 = paramInt - 1;
            paramc0.e(a(i1));
            paramc0.e(a(i1));
          }
        }
        if (paramc0.d(2) != 0) {
          break label221;
        }
        if (k > 1) {
          for (n = 0; n < paramInt; n++) {
            paramc0.e(4);
          }
        }
        for (int n = 0; n < k; n++)
        {
          paramc0.e(8);
          paramc0.e(8);
          paramc0.e(8);
        }
      }
      j++;
      continue;
      label221:
      throw ParserException.createForMalformedContainer("to reserved bits must be zero after mapping coupling steps", null);
    }
  }
  
  private static c[] f(c0 paramc0)
  {
    int i = paramc0.d(6) + 1;
    c[] arrayOfc = new c[i];
    for (int j = 0; j < i; j++) {
      arrayOfc[j] = new c(paramc0.c(), paramc0.d(16), paramc0.d(16), paramc0.d(8));
    }
    return arrayOfc;
  }
  
  private static void g(c0 paramc0)
    throws ParserException
  {
    int i = paramc0.d(6);
    int j = 0;
    while (j < i + 1) {
      if (paramc0.d(16) <= 2)
      {
        paramc0.e(24);
        paramc0.e(24);
        paramc0.e(24);
        int k = paramc0.d(6) + 1;
        paramc0.e(8);
        int[] arrayOfInt = new int[k];
        int i1;
        for (int m = 0; m < k; m++)
        {
          int n = paramc0.d(3);
          if (paramc0.c()) {
            i1 = paramc0.d(5);
          } else {
            i1 = 0;
          }
          arrayOfInt[m] = (i1 * 8 + n);
        }
        for (m = 0; m < k; m++) {
          for (i1 = 0; i1 < 8; i1++) {
            if ((arrayOfInt[m] & 1 << i1) != 0) {
              paramc0.e(8);
            }
          }
        }
        j++;
      }
      else
      {
        throw ParserException.createForMalformedContainer("residueType greater than 2 is not decodable", null);
      }
    }
  }
  
  public static b h(com.google.android.exoplayer2.util.d0 paramd0)
    throws ParserException
  {
    return i(paramd0, true, true);
  }
  
  public static b i(com.google.android.exoplayer2.util.d0 paramd0, boolean paramBoolean1, boolean paramBoolean2)
    throws ParserException
  {
    int i = 0;
    if (paramBoolean1) {
      l(3, paramd0, false);
    }
    String str = paramd0.A((int)paramd0.t());
    int j = str.length();
    long l = paramd0.t();
    String[] arrayOfString = new String[(int)l];
    j = 11 + j + 4;
    while (i < l)
    {
      arrayOfString[i] = paramd0.A((int)paramd0.t());
      j = j + 4 + arrayOfString[i].length();
      i++;
    }
    if ((paramBoolean2) && ((paramd0.D() & 0x1) == 0)) {
      throw ParserException.createForMalformedContainer("framing bit expected to be set", null);
    }
    return new b(str, arrayOfString, j + 1);
  }
  
  public static d j(com.google.android.exoplayer2.util.d0 paramd0)
    throws ParserException
  {
    boolean bool = true;
    l(1, paramd0, false);
    int i = paramd0.u();
    int j = paramd0.D();
    int k = paramd0.u();
    int m = paramd0.q();
    int n = m;
    if (m <= 0) {
      n = -1;
    }
    int i1 = paramd0.q();
    m = i1;
    if (i1 <= 0) {
      m = -1;
    }
    int i2 = paramd0.q();
    i1 = i2;
    if (i2 <= 0) {
      i1 = -1;
    }
    int i3 = paramd0.D();
    i2 = (int)Math.pow(2.0D, i3 & 0xF);
    i3 = (int)Math.pow(2.0D, (i3 & 0xF0) >> 4);
    if ((paramd0.D() & 0x1) <= 0) {
      bool = false;
    }
    return new d(i, j, k, n, m, i1, i2, i3, bool, Arrays.copyOf(paramd0.d(), paramd0.f()));
  }
  
  public static c[] k(com.google.android.exoplayer2.util.d0 paramd0, int paramInt)
    throws ParserException
  {
    int i = 0;
    l(5, paramd0, false);
    int j = paramd0.D();
    c0 localc0 = new c0(paramd0.d());
    localc0.e(paramd0.e() * 8);
    for (int k = 0; k < j + 1; k++) {
      c(localc0);
    }
    j = localc0.d(6);
    k = i;
    while (k < j + 1) {
      if (localc0.d(16) == 0) {
        k++;
      } else {
        throw ParserException.createForMalformedContainer("placeholder of time domain transforms not zeroed out", null);
      }
    }
    d(localc0);
    g(localc0);
    e(paramInt, localc0);
    paramd0 = f(localc0);
    if (localc0.c()) {
      return paramd0;
    }
    throw ParserException.createForMalformedContainer("framing bit after modes not set as expected", null);
  }
  
  public static boolean l(int paramInt, com.google.android.exoplayer2.util.d0 paramd0, boolean paramBoolean)
    throws ParserException
  {
    if (paramd0.a() < 7)
    {
      if (paramBoolean) {
        return false;
      }
      paramInt = paramd0.a();
      paramd0 = new StringBuilder(29);
      paramd0.append("too short header: ");
      paramd0.append(paramInt);
      throw ParserException.createForMalformedContainer(paramd0.toString(), null);
    }
    if (paramd0.D() != paramInt)
    {
      if (paramBoolean) {
        return false;
      }
      paramd0 = String.valueOf(Integer.toHexString(paramInt));
      if (paramd0.length() != 0) {
        paramd0 = "expected header type ".concat(paramd0);
      } else {
        paramd0 = new String("expected header type ");
      }
      throw ParserException.createForMalformedContainer(paramd0, null);
    }
    if ((paramd0.D() == 118) && (paramd0.D() == 111) && (paramd0.D() == 114) && (paramd0.D() == 98) && (paramd0.D() == 105) && (paramd0.D() == 115)) {
      return true;
    }
    if (paramBoolean) {
      return false;
    }
    throw ParserException.createForMalformedContainer("expected characters 'vorbis'", null);
  }
  
  private static final class a
  {
    public final int a;
    public final int b;
    public final long[] c;
    public final int d;
    public final boolean e;
    
    public a(int paramInt1, int paramInt2, long[] paramArrayOfLong, int paramInt3, boolean paramBoolean)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramArrayOfLong;
      this.d = paramInt3;
      this.e = paramBoolean;
    }
  }
  
  public static final class b
  {
    public final String a;
    public final String[] b;
    public final int c;
    
    public b(String paramString, String[] paramArrayOfString, int paramInt)
    {
      this.a = paramString;
      this.b = paramArrayOfString;
      this.c = paramInt;
    }
  }
  
  public static final class c
  {
    public final boolean a;
    public final int b;
    public final int c;
    public final int d;
    
    public c(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
    {
      this.a = paramBoolean;
      this.b = paramInt1;
      this.c = paramInt2;
      this.d = paramInt3;
    }
  }
  
  public static final class d
  {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final boolean i;
    public final byte[] j;
    
    public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, byte[] paramArrayOfByte)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
      this.d = paramInt4;
      this.e = paramInt5;
      this.f = paramInt6;
      this.g = paramInt7;
      this.h = paramInt8;
      this.i = paramBoolean;
      this.j = paramArrayOfByte;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\d0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */