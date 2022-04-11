package b.d.d.m;

public class e
{
  private static final short[] a = { -21436, -17536, 32000 };
  private static final short[][][] b = { { { 0, 32, 64, 96, 128, 160, 192, 224, 256, 288, 320, 352, 384, 416, 448 }, { 0, 32, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384 }, { 0, 32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320 } }, { { 0, 32, 48, 56, 64, 80, 96, 112, 128, 144, 160, 176, 192, 224, 256 }, { 0, 8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160 }, { 0, 8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160 } } };
  
  private boolean a(int paramInt)
  {
    if ((paramInt & 0xFFE00000) != -2097152) {
      return false;
    }
    if ((paramInt >> 17 & 0x3) == 0) {
      return false;
    }
    if ((paramInt >> 12 & 0xF) == 15) {
      return false;
    }
    return (paramInt >> 10 & 0x3) != 3;
  }
  
  private b b(int paramInt)
  {
    if (!a(paramInt)) {
      return null;
    }
    b localb = new b(null);
    int i = 0;
    if ((0x100000 & paramInt) != 0)
    {
      if ((0x80000 & paramInt) != 0) {
        j = 0;
      } else {
        j = 1;
      }
      localb.j = j;
      j = i;
    }
    else
    {
      localb.j = 1;
      j = 1;
    }
    int k = 4 - (paramInt >> 17 & 0x3);
    localb.c = k;
    int m = paramInt >> 10 & 0x3;
    int n = a[m];
    i = localb.j;
    n >>= i + j;
    localb.e = (m + (j + i) * 3);
    localb.b = (paramInt >> 16 & 0x1 ^ 0x1);
    localb.d = n;
    m = paramInt >> 12 & 0xF;
    int j = paramInt >> 9 & 0x1;
    int i1 = paramInt >> 6 & 0x3;
    localb.h = i1;
    localb.i = (paramInt >> 4 & 0x3);
    if (i1 == 3) {
      localb.g = 1;
    } else {
      localb.g = 2;
    }
    if (m != 0)
    {
      paramInt = b[i][(k - 1)][m];
      localb.f = (paramInt * 1000);
      if (k != 1)
      {
        if (k != 2) {
          paramInt = paramInt * 144000 / (n << i);
        } else {
          paramInt = paramInt * 144000 / n;
        }
        paramInt += j;
      }
      else
      {
        paramInt = (paramInt * 12000 / n + j) * 4;
      }
      localb.a = paramInt;
      return localb;
    }
    return null;
  }
  
  private int i(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte[paramInt] & 0xFF) * 16777216 + (paramArrayOfByte[(paramInt + 1)] & 0xFF) * 65536 + (paramArrayOfByte[(paramInt + 2)] & 0xFF) * 256 + (paramArrayOfByte[(paramInt + 3)] & 0xFF);
  }
  
  public int c(int paramInt)
  {
    b localb = b(paramInt);
    if (localb != null) {
      paramInt = localb.f;
    } else {
      paramInt = 0;
    }
    return paramInt;
  }
  
  public int d(byte[] paramArrayOfByte, int paramInt)
  {
    return c(i(paramArrayOfByte, paramInt));
  }
  
  public int e(int paramInt)
  {
    b localb = b(paramInt);
    if (localb != null) {
      paramInt = localb.g;
    } else {
      paramInt = 0;
    }
    return paramInt;
  }
  
  public int f(byte[] paramArrayOfByte, int paramInt)
  {
    return e(i(paramArrayOfByte, paramInt));
  }
  
  public int g(int paramInt)
  {
    b localb = b(paramInt);
    if (localb != null) {
      paramInt = localb.a;
    } else {
      paramInt = 0;
    }
    return paramInt;
  }
  
  public int h(byte[] paramArrayOfByte, int paramInt)
  {
    return g(i(paramArrayOfByte, paramInt));
  }
  
  public int j(int paramInt)
  {
    b localb = b(paramInt);
    if (localb != null) {
      paramInt = localb.d;
    } else {
      paramInt = 0;
    }
    return paramInt;
  }
  
  public int k(byte[] paramArrayOfByte, int paramInt)
  {
    return j(i(paramArrayOfByte, paramInt));
  }
  
  private static class b
  {
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    int h;
    int i;
    int j;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d\m\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */