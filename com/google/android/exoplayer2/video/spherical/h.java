package com.google.android.exoplayer2.video.spherical;

import com.google.android.exoplayer2.util.g;

final class h
{
  public final a a;
  public final a b;
  public final int c;
  public final boolean d;
  
  public h(a parama, int paramInt)
  {
    this(parama, parama, paramInt);
  }
  
  public h(a parama1, a parama2, int paramInt)
  {
    this.a = parama1;
    this.b = parama2;
    this.c = paramInt;
    boolean bool;
    if (parama1 == parama2) {
      bool = true;
    } else {
      bool = false;
    }
    this.d = bool;
  }
  
  public static h a(float paramFloat1, int paramInt1, int paramInt2, float paramFloat2, float paramFloat3, int paramInt3)
  {
    int i = paramInt1;
    int j = paramInt2;
    boolean bool;
    if (paramFloat1 > 0.0F) {
      bool = true;
    } else {
      bool = false;
    }
    g.a(bool);
    if (i >= 1) {
      bool = true;
    } else {
      bool = false;
    }
    g.a(bool);
    if (j >= 1) {
      bool = true;
    } else {
      bool = false;
    }
    g.a(bool);
    if ((paramFloat2 > 0.0F) && (paramFloat2 <= 180.0F)) {
      bool = true;
    } else {
      bool = false;
    }
    g.a(bool);
    if ((paramFloat3 > 0.0F) && (paramFloat3 <= 360.0F)) {
      bool = true;
    } else {
      bool = false;
    }
    g.a(bool);
    float f1 = (float)Math.toRadians(paramFloat2);
    float f2 = (float)Math.toRadians(paramFloat3);
    float f3 = f1 / i;
    float f4 = f2 / j;
    int k = j + 1;
    i = (k * 2 + 2) * i;
    float[] arrayOfFloat1 = new float[i * 3];
    float[] arrayOfFloat2 = new float[i * 2];
    i = 0;
    int m = 0;
    int n = 0;
    while (i < paramInt1)
    {
      paramFloat3 = i;
      paramFloat2 = f1 / 2.0F;
      paramFloat3 = paramFloat3 * f3 - paramFloat2;
      int i1 = i + 1;
      paramFloat2 = i1 * f3 - paramFloat2;
      int i2 = 0;
      int i3 = i;
      i = i1;
      while (i2 < k)
      {
        int i4 = 0;
        i1 = i2;
        while (i4 < 2)
        {
          float f5;
          if (i4 == 0) {
            f5 = paramFloat3;
          } else {
            f5 = paramFloat2;
          }
          float f6 = i1 * f4;
          float f7 = f2 / 2.0F;
          i2 = m + 1;
          double d1 = paramFloat1;
          double d2 = f6 + 3.1415927F - f7;
          double d3 = Math.sin(d2);
          double d4 = f5;
          arrayOfFloat1[m] = (-(float)(d3 * d1 * Math.cos(d4)));
          j = i2 + 1;
          arrayOfFloat1[i2] = ((float)(d1 * Math.sin(d4)));
          i2 = j + 1;
          arrayOfFloat1[j] = ((float)(d1 * Math.cos(d2) * Math.cos(d4)));
          m = n + 1;
          arrayOfFloat2[n] = (f6 / f2);
          j = m + 1;
          arrayOfFloat2[m] = ((i3 + i4) * f3 / f1);
          if ((i1 == 0) && (i4 == 0)) {
            break label461;
          }
          if ((i1 == paramInt2) && (i4 == 1))
          {
            label461:
            System.arraycopy(arrayOfFloat1, i2 - 3, arrayOfFloat1, i2, 3);
            i2 += 3;
            float[] arrayOfFloat3 = arrayOfFloat2;
            System.arraycopy(arrayOfFloat3, j - 2, arrayOfFloat3, j, 2);
            j += 2;
          }
          n = j;
          i4++;
          j = paramInt2;
          m = i2;
        }
        i2 = i1 + 1;
      }
    }
    return new h(new a(new b[] { new b(0, arrayOfFloat1, arrayOfFloat2, 1) }), paramInt3);
  }
  
  public static h b(int paramInt)
  {
    return a(50.0F, 36, 72, 180.0F, 360.0F, paramInt);
  }
  
  public static final class a
  {
    private final h.b[] a;
    
    public a(h.b... paramVarArgs)
    {
      this.a = paramVarArgs;
    }
    
    public h.b a(int paramInt)
    {
      return this.a[paramInt];
    }
    
    public int b()
    {
      return this.a.length;
    }
  }
  
  public static final class b
  {
    public final int a;
    public final int b;
    public final float[] c;
    public final float[] d;
    
    public b(int paramInt1, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt2)
    {
      this.a = paramInt1;
      boolean bool;
      if (paramArrayOfFloat1.length * 2L == paramArrayOfFloat2.length * 3L) {
        bool = true;
      } else {
        bool = false;
      }
      g.a(bool);
      this.c = paramArrayOfFloat1;
      this.d = paramArrayOfFloat2;
      this.b = paramInt2;
    }
    
    public int a()
    {
      return this.c.length / 3;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\video\spherical\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */