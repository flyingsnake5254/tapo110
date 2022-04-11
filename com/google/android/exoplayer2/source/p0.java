package com.google.android.exoplayer2.source;

import java.util.Arrays;
import java.util.Random;

public abstract interface p0
{
  public abstract int a();
  
  public abstract p0 b(int paramInt1, int paramInt2);
  
  public abstract int c(int paramInt);
  
  public abstract int d(int paramInt);
  
  public abstract int e();
  
  public abstract p0 f();
  
  public abstract int g();
  
  public abstract p0 h(int paramInt1, int paramInt2);
  
  public static class a
    implements p0
  {
    private final Random a;
    private final int[] b;
    private final int[] c;
    
    public a(int paramInt)
    {
      this(paramInt, new Random());
    }
    
    private a(int paramInt, Random paramRandom)
    {
      this(i(paramInt, paramRandom), paramRandom);
    }
    
    private a(int[] paramArrayOfInt, Random paramRandom)
    {
      this.b = paramArrayOfInt;
      this.a = paramRandom;
      this.c = new int[paramArrayOfInt.length];
      for (int i = 0; i < paramArrayOfInt.length; i++) {
        this.c[paramArrayOfInt[i]] = i;
      }
    }
    
    private static int[] i(int paramInt, Random paramRandom)
    {
      int[] arrayOfInt = new int[paramInt];
      int j;
      for (int i = 0; i < paramInt; i = j)
      {
        j = i + 1;
        int k = paramRandom.nextInt(j);
        arrayOfInt[i] = arrayOfInt[k];
        arrayOfInt[k] = i;
      }
      return arrayOfInt;
    }
    
    public int a()
    {
      return this.b.length;
    }
    
    public p0 b(int paramInt1, int paramInt2)
    {
      int i = paramInt2 - paramInt1;
      int[] arrayOfInt1 = new int[this.b.length - i];
      int j = 0;
      int k = 0;
      for (;;)
      {
        int[] arrayOfInt2 = this.b;
        if (j >= arrayOfInt2.length) {
          break;
        }
        if ((arrayOfInt2[j] >= paramInt1) && (arrayOfInt2[j] < paramInt2))
        {
          k++;
        }
        else
        {
          int m;
          if (arrayOfInt2[j] >= paramInt1) {
            m = arrayOfInt2[j] - i;
          } else {
            m = arrayOfInt2[j];
          }
          arrayOfInt1[(j - k)] = m;
        }
        j++;
      }
      return new a(arrayOfInt1, new Random(this.a.nextLong()));
    }
    
    public int c(int paramInt)
    {
      int i = this.c[paramInt];
      paramInt = -1;
      i--;
      if (i >= 0) {
        paramInt = this.b[i];
      }
      return paramInt;
    }
    
    public int d(int paramInt)
    {
      paramInt = this.c[paramInt] + 1;
      int[] arrayOfInt = this.b;
      if (paramInt < arrayOfInt.length) {
        paramInt = arrayOfInt[paramInt];
      } else {
        paramInt = -1;
      }
      return paramInt;
    }
    
    public int e()
    {
      int[] arrayOfInt = this.b;
      int i;
      if (arrayOfInt.length > 0) {
        i = arrayOfInt[(arrayOfInt.length - 1)];
      } else {
        i = -1;
      }
      return i;
    }
    
    public p0 f()
    {
      return new a(0, new Random(this.a.nextLong()));
    }
    
    public int g()
    {
      int[] arrayOfInt = this.b;
      int i;
      if (arrayOfInt.length > 0) {
        i = arrayOfInt[0];
      } else {
        i = -1;
      }
      return i;
    }
    
    public p0 h(int paramInt1, int paramInt2)
    {
      int[] arrayOfInt1 = new int[paramInt2];
      int[] arrayOfInt2 = new int[paramInt2];
      int i = 0;
      Object localObject;
      for (int j = 0; j < paramInt2; j = k)
      {
        arrayOfInt1[j] = this.a.nextInt(this.b.length + 1);
        localObject = this.a;
        k = j + 1;
        int m = ((Random)localObject).nextInt(k);
        arrayOfInt2[j] = arrayOfInt2[m];
        arrayOfInt2[m] = (j + paramInt1);
      }
      Arrays.sort(arrayOfInt1);
      int[] arrayOfInt3 = new int[this.b.length + paramInt2];
      int k = 0;
      j = 0;
      for (;;)
      {
        localObject = this.b;
        if (i >= localObject.length + paramInt2) {
          break;
        }
        if ((k < paramInt2) && (j == arrayOfInt1[k]))
        {
          arrayOfInt3[i] = arrayOfInt2[k];
          k++;
        }
        else
        {
          arrayOfInt3[i] = localObject[j];
          if (arrayOfInt3[i] >= paramInt1) {
            arrayOfInt3[i] += paramInt2;
          }
          j++;
        }
        i++;
      }
      return new a(arrayOfInt3, new Random(this.a.nextLong()));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\p0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */