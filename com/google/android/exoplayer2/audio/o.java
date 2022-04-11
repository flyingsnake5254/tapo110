package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import java.nio.ByteBuffer;

public final class o
{
  private static final int[] a = { 2002, 2000, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, 480, 400, 400, 2048 };
  
  public static void a(int paramInt, d0 paramd0)
  {
    paramd0.L(7);
    paramd0 = paramd0.d();
    paramd0[0] = ((byte)-84);
    paramd0[1] = ((byte)64);
    paramd0[2] = ((byte)-1);
    paramd0[3] = ((byte)-1);
    paramd0[4] = ((byte)(byte)(paramInt >> 16 & 0xFF));
    paramd0[5] = ((byte)(byte)(paramInt >> 8 & 0xFF));
    paramd0[6] = ((byte)(byte)(paramInt & 0xFF));
  }
  
  public static Format b(d0 paramd0, String paramString1, String paramString2, @Nullable DrmInitData paramDrmInitData)
  {
    paramd0.Q(1);
    int i;
    if ((paramd0.D() & 0x20) >> 5 == 1) {
      i = 48000;
    } else {
      i = 44100;
    }
    return new Format.b().S(paramString1).e0("audio/ac4").H(2).f0(i).L(paramDrmInitData).V(paramString2).E();
  }
  
  public static int c(ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte = new byte[16];
    int i = paramByteBuffer.position();
    paramByteBuffer.get(arrayOfByte);
    paramByteBuffer.position(i);
    return d(new c0(arrayOfByte)).e;
  }
  
  public static b d(c0 paramc0)
  {
    int i = paramc0.h(16);
    int j = paramc0.h(16);
    if (j == 65535)
    {
      j = paramc0.h(24);
      k = 7;
    }
    else
    {
      k = 4;
    }
    int k = j + k;
    j = k;
    if (i == 44097) {
      j = k + 2;
    }
    k = paramc0.h(2);
    i = k;
    if (k == 3) {
      i = k + f(paramc0, 2);
    }
    k = paramc0.h(10);
    if ((paramc0.g()) && (paramc0.h(3) > 0)) {
      paramc0.r(2);
    }
    int m;
    if (paramc0.g()) {
      m = 48000;
    } else {
      m = 44100;
    }
    int n = paramc0.h(4);
    if ((m == 44100) && (n == 13))
    {
      k = a[n];
    }
    else
    {
      if (m == 48000)
      {
        paramc0 = a;
        if (n < paramc0.length)
        {
          int i1 = paramc0[n];
          k %= 5;
          if (k != 1) {
            if (k != 2)
            {
              if (k != 3)
              {
                if (k != 4)
                {
                  k = i1;
                  break label267;
                }
                if ((n == 3) || (n == 8)) {
                  break label270;
                }
                k = i1;
                if (n != 11) {
                  break label267;
                }
                break label270;
              }
            }
            else
            {
              if (n == 8) {
                break label270;
              }
              k = i1;
              if (n != 11) {
                break label267;
              }
              break label270;
            }
          }
          if (n != 3)
          {
            k = i1;
            if (n == 8) {}
          }
          for (;;)
          {
            label267:
            break;
            label270:
            k = i1 + 1;
          }
        }
      }
      k = 0;
    }
    return new b(i, 2, m, j, k, null);
  }
  
  public static int e(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte.length;
    int j = 7;
    if (i < 7) {
      return -1;
    }
    i = (paramArrayOfByte[2] & 0xFF) << 8 | paramArrayOfByte[3] & 0xFF;
    if (i == 65535) {
      i = (paramArrayOfByte[4] & 0xFF) << 16 | (paramArrayOfByte[5] & 0xFF) << 8 | paramArrayOfByte[6] & 0xFF;
    } else {
      j = 4;
    }
    int k = j;
    if (paramInt == 44097) {
      k = j + 2;
    }
    return i + k;
  }
  
  private static int f(c0 paramc0, int paramInt)
  {
    for (int i = 0;; i = i + 1 << paramInt)
    {
      i += paramc0.h(paramInt);
      if (!paramc0.g()) {
        return i;
      }
    }
  }
  
  public static final class b
  {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    
    private b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      this.a = paramInt1;
      this.c = paramInt2;
      this.b = paramInt3;
      this.d = paramInt4;
      this.e = paramInt5;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\audio\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */