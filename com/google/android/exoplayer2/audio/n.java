package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.o0;
import java.nio.ByteBuffer;

public final class n
{
  private static final int[] a = { 1, 2, 3, 6 };
  private static final int[] b = { 48000, 44100, 32000 };
  private static final int[] c = { 24000, 22050, 16000 };
  private static final int[] d = { 2, 1, 2, 3, 3, 4, 4, 5 };
  private static final int[] e = { 32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640 };
  private static final int[] f = { 69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393 };
  
  public static int a(ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.position();
    int j = paramByteBuffer.limit();
    for (int k = i; k <= j - 10; k++) {
      if ((o0.E(paramByteBuffer, k + 4) & 0xFFFFFFFE) == -126718022) {
        return k - i;
      }
    }
    return -1;
  }
  
  private static int b(int paramInt1, int paramInt2)
  {
    int i = paramInt2 / 2;
    if (paramInt1 >= 0)
    {
      int[] arrayOfInt1 = b;
      if ((paramInt1 < arrayOfInt1.length) && (paramInt2 >= 0))
      {
        int[] arrayOfInt2 = f;
        if (i < arrayOfInt2.length)
        {
          paramInt1 = arrayOfInt1[paramInt1];
          if (paramInt1 == 44100) {
            return (arrayOfInt2[i] + paramInt2 % 2) * 2;
          }
          paramInt2 = e[i];
          if (paramInt1 == 32000) {
            return paramInt2 * 6;
          }
          return paramInt2 * 4;
        }
      }
    }
    return -1;
  }
  
  public static Format c(d0 paramd0, String paramString1, String paramString2, @Nullable DrmInitData paramDrmInitData)
  {
    int i = paramd0.D();
    int j = b[((i & 0xC0) >> 6)];
    int k = paramd0.D();
    int m = d[((k & 0x38) >> 3)];
    i = m;
    if ((k & 0x4) != 0) {
      i = m + 1;
    }
    return new Format.b().S(paramString1).e0("audio/ac3").H(i).f0(j).L(paramDrmInitData).V(paramString2).E();
  }
  
  public static int d(ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.get(paramByteBuffer.position() + 5);
    int j = 3;
    if ((i & 0xF8) >> 3 > 10) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if ((paramByteBuffer.get(paramByteBuffer.position() + 4) & 0xC0) >> 6 == 3) {
        i = j;
      } else {
        i = (paramByteBuffer.get(paramByteBuffer.position() + 4) & 0x30) >> 4;
      }
      return a[i] * 256;
    }
    return 1536;
  }
  
  public static b e(c0 paramc0)
  {
    int i = paramc0.e();
    paramc0.r(40);
    int j;
    if (paramc0.h(5) > 10) {
      j = 1;
    } else {
      j = 0;
    }
    paramc0.p(i);
    i = -1;
    int k;
    int m;
    int n;
    int i6;
    int i2;
    if (j != 0)
    {
      paramc0.r(16);
      j = paramc0.h(2);
      if (j != 0)
      {
        if (j != 1)
        {
          if (j != 2) {
            j = i;
          } else {
            j = 2;
          }
        }
        else {
          j = 1;
        }
      }
      else {
        j = 0;
      }
      paramc0.r(3);
      k = paramc0.h(11);
      m = paramc0.h(2);
      if (m == 3)
      {
        i = c[paramc0.h(2)];
        n = 3;
        i1 = 6;
      }
      else
      {
        n = paramc0.h(2);
        i1 = a[n];
        i = b[m];
      }
      int i3 = paramc0.h(3);
      int i4 = paramc0.g();
      int i5 = d[i3];
      paramc0.r(10);
      if (paramc0.g()) {
        paramc0.r(8);
      }
      if (i3 == 0)
      {
        paramc0.r(5);
        if (paramc0.g()) {
          paramc0.r(8);
        }
      }
      if ((j == 1) && (paramc0.g())) {
        paramc0.r(16);
      }
      if (paramc0.g())
      {
        if (i3 > 2) {
          paramc0.r(2);
        }
        if (((i3 & 0x1) != 0) && (i3 > 2)) {
          paramc0.r(6);
        }
        if ((i3 & 0x4) != 0) {
          paramc0.r(6);
        }
        if ((i4 != 0) && (paramc0.g())) {
          paramc0.r(5);
        }
        if (j == 0)
        {
          if (paramc0.g()) {
            paramc0.r(6);
          }
          if ((i3 == 0) && (paramc0.g())) {
            paramc0.r(6);
          }
          if (paramc0.g()) {
            paramc0.r(6);
          }
          i6 = paramc0.h(2);
          if (i6 == 1)
          {
            paramc0.r(5);
          }
          else if (i6 == 2)
          {
            paramc0.r(12);
          }
          else if (i6 == 3)
          {
            i6 = paramc0.h(5);
            if (paramc0.g())
            {
              paramc0.r(5);
              if (paramc0.g()) {
                paramc0.r(4);
              }
              if (paramc0.g()) {
                paramc0.r(4);
              }
              if (paramc0.g()) {
                paramc0.r(4);
              }
              if (paramc0.g()) {
                paramc0.r(4);
              }
              if (paramc0.g()) {
                paramc0.r(4);
              }
              if (paramc0.g()) {
                paramc0.r(4);
              }
              if (paramc0.g()) {
                paramc0.r(4);
              }
              if (paramc0.g())
              {
                if (paramc0.g()) {
                  paramc0.r(4);
                }
                if (paramc0.g()) {
                  paramc0.r(4);
                }
              }
            }
            if (paramc0.g())
            {
              paramc0.r(5);
              if (paramc0.g())
              {
                paramc0.r(7);
                if (paramc0.g()) {
                  paramc0.r(8);
                }
              }
            }
            paramc0.r((i6 + 2) * 8);
            paramc0.c();
          }
          if (i3 < 2)
          {
            if (paramc0.g()) {
              paramc0.r(14);
            }
            if ((i3 == 0) && (paramc0.g())) {
              paramc0.r(14);
            }
          }
          if (paramc0.g()) {
            if (n == 0) {
              paramc0.r(5);
            } else {
              for (i6 = 0; i6 < i1; i6++) {
                if (paramc0.g()) {
                  paramc0.r(5);
                }
              }
            }
          }
        }
      }
      if (paramc0.g())
      {
        paramc0.r(5);
        if (i3 == 2) {
          paramc0.r(4);
        }
        if (i3 >= 6) {
          paramc0.r(2);
        }
        if (paramc0.g()) {
          paramc0.r(8);
        }
        if ((i3 == 0) && (paramc0.g())) {
          paramc0.r(8);
        }
        if (m < 3) {
          paramc0.q();
        }
      }
      if ((j == 0) && (n != 3)) {
        paramc0.q();
      }
      if ((j == 2) && ((n == 3) || (paramc0.g()))) {
        paramc0.r(6);
      }
      if ((paramc0.g()) && (paramc0.h(6) == 1) && (paramc0.h(8) == 1)) {
        paramc0 = "audio/eac3-joc";
      } else {
        paramc0 = "audio/eac3";
      }
      n = i1 * 256;
      i6 = (k + 1) * 2;
      int i1 = i;
      i = i5 + i4;
    }
    else
    {
      paramc0.r(32);
      j = paramc0.h(2);
      String str;
      if (j == 3) {
        str = null;
      } else {
        str = "audio/ac3";
      }
      i = b(j, paramc0.h(6));
      paramc0.r(8);
      n = paramc0.h(3);
      if (((n & 0x1) != 0) && (n != 1)) {
        paramc0.r(2);
      }
      if ((n & 0x4) != 0) {
        paramc0.r(2);
      }
      if (n == 2) {
        paramc0.r(2);
      }
      int[] arrayOfInt = b;
      if (j < arrayOfInt.length) {
        j = arrayOfInt[j];
      } else {
        j = -1;
      }
      i2 = paramc0.g();
      n = d[n];
      m = n + i2;
      k = -1;
      n = 1536;
      i6 = i;
      i2 = j;
      i = m;
      j = k;
      paramc0 = str;
    }
    return new b(paramc0, j, i, i2, i6, n, null);
  }
  
  public static int f(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length < 6) {
      return -1;
    }
    int i;
    if ((paramArrayOfByte[5] & 0xF8) >> 3 > 10) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      i = paramArrayOfByte[2];
      return ((paramArrayOfByte[3] & 0xFF | (i & 0x7) << 8) + 1) * 2;
    }
    return b((paramArrayOfByte[4] & 0xC0) >> 6, paramArrayOfByte[4] & 0x3F);
  }
  
  public static Format g(d0 paramd0, String paramString1, String paramString2, @Nullable DrmInitData paramDrmInitData)
  {
    paramd0.Q(2);
    int i = paramd0.D();
    int j = b[((i & 0xC0) >> 6)];
    int k = paramd0.D();
    int m = d[((k & 0xE) >> 1)];
    i = m;
    if ((k & 0x1) != 0) {
      i = m + 1;
    }
    m = i;
    if ((paramd0.D() & 0x1E) >> 1 > 0)
    {
      m = i;
      if ((0x2 & paramd0.D()) != 0) {
        m = i + 2;
      }
    }
    if ((paramd0.a() > 0) && ((paramd0.D() & 0x1) != 0)) {
      paramd0 = "audio/eac3-joc";
    } else {
      paramd0 = "audio/eac3";
    }
    return new Format.b().S(paramString1).e0(paramd0).H(m).f0(j).L(paramDrmInitData).V(paramString2).E();
  }
  
  public static int h(ByteBuffer paramByteBuffer, int paramInt)
  {
    int i;
    if ((paramByteBuffer.get(paramByteBuffer.position() + paramInt + 7) & 0xFF) == 187) {
      i = 1;
    } else {
      i = 0;
    }
    int j = paramByteBuffer.position();
    if (i != 0) {
      i = 9;
    } else {
      i = 8;
    }
    return 40 << (paramByteBuffer.get(j + paramInt + i) >> 4 & 0x7);
  }
  
  public static int i(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte[4];
    int j = 0;
    if ((i == -8) && (paramArrayOfByte[5] == 114) && (paramArrayOfByte[6] == 111) && ((paramArrayOfByte[7] & 0xFE) == 186))
    {
      if ((paramArrayOfByte[7] & 0xFF) == 187) {
        j = 1;
      }
      if (j != 0) {
        j = 9;
      } else {
        j = 8;
      }
      return 40 << (paramArrayOfByte[j] >> 4 & 0x7);
    }
    return 0;
  }
  
  public static final class b
  {
    @Nullable
    public final String a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    
    private b(@Nullable String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      this.a = paramString;
      this.b = paramInt1;
      this.d = paramInt2;
      this.c = paramInt3;
      this.e = paramInt4;
      this.f = paramInt5;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\audio\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */