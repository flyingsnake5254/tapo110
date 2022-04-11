package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.c0;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class b0
{
  private static final int[] a = { 1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8 };
  private static final int[] b = { -1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1 };
  private static final int[] c = { 64, 112, 128, 192, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680 };
  
  public static int a(byte[] paramArrayOfByte)
  {
    int i = 0;
    int j = paramArrayOfByte[0];
    if (j != -2)
    {
      if (j != -1)
      {
        if (j != 31)
        {
          j = (paramArrayOfByte[5] & 0x3) << 12 | (paramArrayOfByte[6] & 0xFF) << 4;
          k = paramArrayOfByte[7];
          break label147;
        }
        j = (paramArrayOfByte[6] & 0x3) << 12 | (paramArrayOfByte[7] & 0xFF) << 4;
        k = paramArrayOfByte[8];
      }
      else
      {
        j = (paramArrayOfByte[7] & 0x3) << 12 | (paramArrayOfByte[6] & 0xFF) << 4;
        k = paramArrayOfByte[9];
      }
      j = ((k & 0x3C) >> 2 | j) + 1;
      k = 1;
      break label161;
    }
    else
    {
      j = (paramArrayOfByte[4] & 0x3) << 12 | (paramArrayOfByte[7] & 0xFF) << 4;
      k = paramArrayOfByte[6];
    }
    label147:
    j = ((k & 0xF0) >> 4 | j) + 1;
    int k = i;
    label161:
    i = j;
    if (k != 0) {
      i = j * 16 / 14;
    }
    return i;
  }
  
  private static c0 b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte[0] == Byte.MAX_VALUE) {
      return new c0(paramArrayOfByte);
    }
    byte[] arrayOfByte = Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length);
    if (c(arrayOfByte)) {
      for (int i = 0; i < arrayOfByte.length - 1; i += 2)
      {
        int j = arrayOfByte[i];
        int k = i + 1;
        arrayOfByte[i] = ((byte)arrayOfByte[k]);
        arrayOfByte[k] = ((byte)j);
      }
    }
    c0 localc0 = new c0(arrayOfByte);
    if (arrayOfByte[0] == 31)
    {
      paramArrayOfByte = new c0(arrayOfByte);
      while (paramArrayOfByte.b() >= 16)
      {
        paramArrayOfByte.r(2);
        localc0.f(paramArrayOfByte.h(14), 14);
      }
    }
    localc0.n(arrayOfByte);
    return localc0;
  }
  
  private static boolean c(byte[] paramArrayOfByte)
  {
    boolean bool = false;
    if ((paramArrayOfByte[0] == -2) || (paramArrayOfByte[0] == -1)) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean d(int paramInt)
  {
    boolean bool;
    if ((paramInt != 2147385345) && (paramInt != -25230976) && (paramInt != 536864768) && (paramInt != -14745368)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static int e(ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.position();
    int j = paramByteBuffer.get(i);
    if (j != -2)
    {
      if (j != -1)
      {
        if (j != 31)
        {
          j = (paramByteBuffer.get(i + 4) & 0x1) << 6;
          i = paramByteBuffer.get(i + 5);
          break label128;
        }
        j = (paramByteBuffer.get(i + 5) & 0x7) << 4;
        i = paramByteBuffer.get(i + 6);
      }
      else
      {
        j = (paramByteBuffer.get(i + 4) & 0x7) << 4;
        i = paramByteBuffer.get(i + 7);
      }
      i &= 0x3C;
      break label134;
    }
    else
    {
      j = (paramByteBuffer.get(i + 5) & 0x1) << 6;
      i = paramByteBuffer.get(i + 4);
    }
    label128:
    i &= 0xFC;
    label134:
    return ((i >> 2 | j) + 1) * 32;
  }
  
  public static int f(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte[0];
    int j;
    if (i != -2)
    {
      if (i != -1)
      {
        if (i != 31)
        {
          i = (paramArrayOfByte[4] & 0x1) << 6;
          j = paramArrayOfByte[5];
          break label89;
        }
        i = (paramArrayOfByte[5] & 0x7) << 4;
        j = paramArrayOfByte[6];
      }
      else
      {
        i = (paramArrayOfByte[4] & 0x7) << 4;
        j = paramArrayOfByte[7];
      }
      j &= 0x3C;
      break label95;
    }
    else
    {
      i = (paramArrayOfByte[5] & 0x1) << 6;
      j = paramArrayOfByte[4];
    }
    label89:
    j &= 0xFC;
    label95:
    return ((j >> 2 | i) + 1) * 32;
  }
  
  public static Format g(byte[] paramArrayOfByte, @Nullable String paramString1, @Nullable String paramString2, @Nullable DrmInitData paramDrmInitData)
  {
    paramArrayOfByte = b(paramArrayOfByte);
    paramArrayOfByte.r(60);
    int i = paramArrayOfByte.h(6);
    int j = a[i];
    i = paramArrayOfByte.h(4);
    int k = b[i];
    i = paramArrayOfByte.h(5);
    int[] arrayOfInt = c;
    if (i >= arrayOfInt.length) {
      i = -1;
    } else {
      i = arrayOfInt[i] * 1000 / 2;
    }
    paramArrayOfByte.r(10);
    int m;
    if (paramArrayOfByte.h(2) > 0) {
      m = 1;
    } else {
      m = 0;
    }
    return new Format.b().S(paramString1).e0("audio/vnd.dts").G(i).H(j + m).f0(k).L(paramDrmInitData).V(paramString2).E();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\audio\b0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */