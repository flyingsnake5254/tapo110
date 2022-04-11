package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.u;

public final class m
{
  private static final int[] a = { 96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350 };
  private static final int[] b = { 0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1 };
  
  public static byte[] a(int paramInt1, int paramInt2, int paramInt3)
  {
    return new byte[] { (byte)(paramInt1 << 3 & 0xF8 | paramInt2 >> 1 & 0x7), (byte)(paramInt2 << 7 & 0x80 | paramInt3 << 3 & 0x78) };
  }
  
  private static int b(c0 paramc0)
  {
    int i = paramc0.h(5);
    int j = i;
    if (i == 31) {
      j = paramc0.h(6) + 32;
    }
    return j;
  }
  
  public static int c(int paramInt)
  {
    if (paramInt != 2)
    {
      if (paramInt != 5)
      {
        if (paramInt != 29)
        {
          if (paramInt != 42)
          {
            if (paramInt != 22)
            {
              if (paramInt != 23) {
                return 0;
              }
              return 15;
            }
            return 1073741824;
          }
          return 16;
        }
        return 12;
      }
      return 11;
    }
    return 10;
  }
  
  private static int d(c0 paramc0)
    throws ParserException
  {
    int i = paramc0.h(4);
    if (i == 15)
    {
      i = paramc0.h(24);
    }
    else
    {
      if (i >= 13) {
        break label36;
      }
      i = a[i];
    }
    return i;
    label36:
    throw ParserException.createForMalformedContainer(null, null);
  }
  
  public static b e(c0 paramc0, boolean paramBoolean)
    throws ParserException
  {
    int i = b(paramc0);
    int j = d(paramc0);
    int k = paramc0.h(4);
    Object localObject = new StringBuilder(19);
    ((StringBuilder)localObject).append("mp4a.40.");
    ((StringBuilder)localObject).append(i);
    localObject = ((StringBuilder)localObject).toString();
    int n;
    if (i != 5)
    {
      m = i;
      n = k;
      if (i != 29) {}
    }
    else
    {
      int i1 = d(paramc0);
      i = b(paramc0);
      m = i;
      j = i1;
      n = k;
      if (i == 22)
      {
        n = paramc0.h(4);
        j = i1;
        m = i;
      }
    }
    if (paramBoolean)
    {
      if ((m != 1) && (m != 2) && (m != 3) && (m != 4) && (m != 6) && (m != 7) && (m != 17)) {
        switch (m)
        {
        default: 
          paramc0 = new StringBuilder(42);
          paramc0.append("Unsupported audio object type: ");
          paramc0.append(m);
          throw ParserException.createForUnsupportedContainerFeature(paramc0.toString());
        }
      }
      g(paramc0, m, n);
      switch (m)
      {
      case 18: 
      default: 
        break;
      case 17: 
      case 19: 
      case 20: 
      case 21: 
      case 22: 
      case 23: 
        m = paramc0.h(2);
        if ((m == 2) || (m == 3))
        {
          paramc0 = new StringBuilder(33);
          paramc0.append("Unsupported epConfig: ");
          paramc0.append(m);
          throw ParserException.createForUnsupportedContainerFeature(paramc0.toString());
        }
        break;
      }
    }
    int m = b[n];
    if (m != -1) {
      return new b(j, m, (String)localObject, null);
    }
    throw ParserException.createForMalformedContainer(null, null);
  }
  
  public static b f(byte[] paramArrayOfByte)
    throws ParserException
  {
    return e(new c0(paramArrayOfByte), false);
  }
  
  private static void g(c0 paramc0, int paramInt1, int paramInt2)
  {
    if (paramc0.g()) {
      u.h("AacUtil", "Unexpected frameLengthFlag = 1");
    }
    if (paramc0.g()) {
      paramc0.r(14);
    }
    boolean bool = paramc0.g();
    if (paramInt2 != 0)
    {
      if ((paramInt1 == 6) || (paramInt1 == 20)) {
        paramc0.r(3);
      }
      if (bool)
      {
        if (paramInt1 == 22) {
          paramc0.r(16);
        }
        if ((paramInt1 == 17) || (paramInt1 == 19) || (paramInt1 == 20) || (paramInt1 == 23)) {
          paramc0.r(3);
        }
        paramc0.r(1);
      }
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  public static final class b
  {
    public final int a;
    public final int b;
    public final String c;
    
    private b(int paramInt1, int paramInt2, String paramString)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramString;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\audio\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */