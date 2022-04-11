package org.apache.commons.lang.builder;

import java.util.Comparator;

public class a
{
  private int a = 0;
  
  public a a(byte paramByte1, byte paramByte2)
  {
    if (this.a != 0) {
      return this;
    }
    if (paramByte1 < paramByte2) {
      paramByte1 = -1;
    } else if (paramByte1 > paramByte2) {
      paramByte1 = 1;
    } else {
      paramByte1 = 0;
    }
    this.a = paramByte1;
    return this;
  }
  
  public a b(char paramChar1, char paramChar2)
  {
    if (this.a != 0) {
      return this;
    }
    if (paramChar1 < paramChar2) {
      paramChar1 = '￿';
    } else if (paramChar1 > paramChar2) {
      paramChar1 = '\001';
    } else {
      paramChar1 = '\000';
    }
    this.a = paramChar1;
    return this;
  }
  
  public a c(double paramDouble1, double paramDouble2)
  {
    if (this.a != 0) {
      return this;
    }
    this.a = org.apache.commons.lang.math.a.a(paramDouble1, paramDouble2);
    return this;
  }
  
  public a d(float paramFloat1, float paramFloat2)
  {
    if (this.a != 0) {
      return this;
    }
    this.a = org.apache.commons.lang.math.a.b(paramFloat1, paramFloat2);
    return this;
  }
  
  public a e(int paramInt1, int paramInt2)
  {
    if (this.a != 0) {
      return this;
    }
    if (paramInt1 < paramInt2) {
      paramInt1 = -1;
    } else if (paramInt1 > paramInt2) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    this.a = paramInt1;
    return this;
  }
  
  public a f(long paramLong1, long paramLong2)
  {
    if (this.a != 0) {
      return this;
    }
    boolean bool = paramLong1 < paramLong2;
    int i;
    if (bool) {
      i = -1;
    } else if (i > 0) {
      i = 1;
    } else {
      i = 0;
    }
    this.a = i;
    return this;
  }
  
  public a g(Object paramObject1, Object paramObject2)
  {
    return h(paramObject1, paramObject2, null);
  }
  
  public a h(Object paramObject1, Object paramObject2, Comparator paramComparator)
  {
    if (this.a != 0) {
      return this;
    }
    if (paramObject1 == paramObject2) {
      return this;
    }
    if (paramObject1 == null)
    {
      this.a = -1;
      return this;
    }
    if (paramObject2 == null)
    {
      this.a = 1;
      return this;
    }
    if (paramObject1.getClass().isArray())
    {
      if ((paramObject1 instanceof long[])) {
        p((long[])paramObject1, (long[])paramObject2);
      } else if ((paramObject1 instanceof int[])) {
        o((int[])paramObject1, (int[])paramObject2);
      } else if ((paramObject1 instanceof short[])) {
        r((short[])paramObject1, (short[])paramObject2);
      } else if ((paramObject1 instanceof char[])) {
        l((char[])paramObject1, (char[])paramObject2);
      } else if ((paramObject1 instanceof byte[])) {
        k((byte[])paramObject1, (byte[])paramObject2);
      } else if ((paramObject1 instanceof double[])) {
        m((double[])paramObject1, (double[])paramObject2);
      } else if ((paramObject1 instanceof float[])) {
        n((float[])paramObject1, (float[])paramObject2);
      } else if ((paramObject1 instanceof boolean[])) {
        s((boolean[])paramObject1, (boolean[])paramObject2);
      } else {
        q((Object[])paramObject1, (Object[])paramObject2, paramComparator);
      }
    }
    else if (paramComparator == null) {
      this.a = ((Comparable)paramObject1).compareTo(paramObject2);
    } else {
      this.a = paramComparator.compare(paramObject1, paramObject2);
    }
    return this;
  }
  
  public a i(short paramShort1, short paramShort2)
  {
    if (this.a != 0) {
      return this;
    }
    if (paramShort1 < paramShort2) {
      paramShort1 = -1;
    } else if (paramShort1 > paramShort2) {
      paramShort1 = 1;
    } else {
      paramShort1 = 0;
    }
    this.a = paramShort1;
    return this;
  }
  
  public a j(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.a != 0) {
      return this;
    }
    if (paramBoolean1 == paramBoolean2) {
      return this;
    }
    if (!paramBoolean1) {
      this.a = -1;
    } else {
      this.a = 1;
    }
    return this;
  }
  
  public a k(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (this.a != 0) {
      return this;
    }
    if (paramArrayOfByte1 == paramArrayOfByte2) {
      return this;
    }
    int i = -1;
    if (paramArrayOfByte1 == null)
    {
      this.a = -1;
      return this;
    }
    if (paramArrayOfByte2 == null)
    {
      this.a = 1;
      return this;
    }
    if (paramArrayOfByte1.length != paramArrayOfByte2.length)
    {
      if (paramArrayOfByte1.length >= paramArrayOfByte2.length) {
        i = 1;
      }
      this.a = i;
      return this;
    }
    for (i = 0; (i < paramArrayOfByte1.length) && (this.a == 0); i++) {
      a(paramArrayOfByte1[i], paramArrayOfByte2[i]);
    }
    return this;
  }
  
  public a l(char[] paramArrayOfChar1, char[] paramArrayOfChar2)
  {
    if (this.a != 0) {
      return this;
    }
    if (paramArrayOfChar1 == paramArrayOfChar2) {
      return this;
    }
    int i = -1;
    if (paramArrayOfChar1 == null)
    {
      this.a = -1;
      return this;
    }
    if (paramArrayOfChar2 == null)
    {
      this.a = 1;
      return this;
    }
    if (paramArrayOfChar1.length != paramArrayOfChar2.length)
    {
      if (paramArrayOfChar1.length >= paramArrayOfChar2.length) {
        i = 1;
      }
      this.a = i;
      return this;
    }
    for (i = 0; (i < paramArrayOfChar1.length) && (this.a == 0); i++) {
      b(paramArrayOfChar1[i], paramArrayOfChar2[i]);
    }
    return this;
  }
  
  public a m(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    if (this.a != 0) {
      return this;
    }
    if (paramArrayOfDouble1 == paramArrayOfDouble2) {
      return this;
    }
    int i = -1;
    if (paramArrayOfDouble1 == null)
    {
      this.a = -1;
      return this;
    }
    if (paramArrayOfDouble2 == null)
    {
      this.a = 1;
      return this;
    }
    if (paramArrayOfDouble1.length != paramArrayOfDouble2.length)
    {
      if (paramArrayOfDouble1.length >= paramArrayOfDouble2.length) {
        i = 1;
      }
      this.a = i;
      return this;
    }
    for (i = 0; (i < paramArrayOfDouble1.length) && (this.a == 0); i++) {
      c(paramArrayOfDouble1[i], paramArrayOfDouble2[i]);
    }
    return this;
  }
  
  public a n(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if (this.a != 0) {
      return this;
    }
    if (paramArrayOfFloat1 == paramArrayOfFloat2) {
      return this;
    }
    int i = -1;
    if (paramArrayOfFloat1 == null)
    {
      this.a = -1;
      return this;
    }
    if (paramArrayOfFloat2 == null)
    {
      this.a = 1;
      return this;
    }
    if (paramArrayOfFloat1.length != paramArrayOfFloat2.length)
    {
      if (paramArrayOfFloat1.length >= paramArrayOfFloat2.length) {
        i = 1;
      }
      this.a = i;
      return this;
    }
    for (i = 0; (i < paramArrayOfFloat1.length) && (this.a == 0); i++) {
      d(paramArrayOfFloat1[i], paramArrayOfFloat2[i]);
    }
    return this;
  }
  
  public a o(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (this.a != 0) {
      return this;
    }
    if (paramArrayOfInt1 == paramArrayOfInt2) {
      return this;
    }
    int i = -1;
    if (paramArrayOfInt1 == null)
    {
      this.a = -1;
      return this;
    }
    if (paramArrayOfInt2 == null)
    {
      this.a = 1;
      return this;
    }
    if (paramArrayOfInt1.length != paramArrayOfInt2.length)
    {
      if (paramArrayOfInt1.length >= paramArrayOfInt2.length) {
        i = 1;
      }
      this.a = i;
      return this;
    }
    for (i = 0; (i < paramArrayOfInt1.length) && (this.a == 0); i++) {
      e(paramArrayOfInt1[i], paramArrayOfInt2[i]);
    }
    return this;
  }
  
  public a p(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if (this.a != 0) {
      return this;
    }
    if (paramArrayOfLong1 == paramArrayOfLong2) {
      return this;
    }
    int i = -1;
    if (paramArrayOfLong1 == null)
    {
      this.a = -1;
      return this;
    }
    if (paramArrayOfLong2 == null)
    {
      this.a = 1;
      return this;
    }
    if (paramArrayOfLong1.length != paramArrayOfLong2.length)
    {
      if (paramArrayOfLong1.length >= paramArrayOfLong2.length) {
        i = 1;
      }
      this.a = i;
      return this;
    }
    for (i = 0; (i < paramArrayOfLong1.length) && (this.a == 0); i++) {
      f(paramArrayOfLong1[i], paramArrayOfLong2[i]);
    }
    return this;
  }
  
  public a q(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2, Comparator paramComparator)
  {
    if (this.a != 0) {
      return this;
    }
    if (paramArrayOfObject1 == paramArrayOfObject2) {
      return this;
    }
    int i = -1;
    if (paramArrayOfObject1 == null)
    {
      this.a = -1;
      return this;
    }
    if (paramArrayOfObject2 == null)
    {
      this.a = 1;
      return this;
    }
    if (paramArrayOfObject1.length != paramArrayOfObject2.length)
    {
      if (paramArrayOfObject1.length >= paramArrayOfObject2.length) {
        i = 1;
      }
      this.a = i;
      return this;
    }
    for (i = 0; (i < paramArrayOfObject1.length) && (this.a == 0); i++) {
      h(paramArrayOfObject1[i], paramArrayOfObject2[i], paramComparator);
    }
    return this;
  }
  
  public a r(short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    if (this.a != 0) {
      return this;
    }
    if (paramArrayOfShort1 == paramArrayOfShort2) {
      return this;
    }
    int i = -1;
    if (paramArrayOfShort1 == null)
    {
      this.a = -1;
      return this;
    }
    if (paramArrayOfShort2 == null)
    {
      this.a = 1;
      return this;
    }
    if (paramArrayOfShort1.length != paramArrayOfShort2.length)
    {
      if (paramArrayOfShort1.length >= paramArrayOfShort2.length) {
        i = 1;
      }
      this.a = i;
      return this;
    }
    for (i = 0; (i < paramArrayOfShort1.length) && (this.a == 0); i++) {
      i(paramArrayOfShort1[i], paramArrayOfShort2[i]);
    }
    return this;
  }
  
  public a s(boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2)
  {
    if (this.a != 0) {
      return this;
    }
    if (paramArrayOfBoolean1 == paramArrayOfBoolean2) {
      return this;
    }
    int i = -1;
    if (paramArrayOfBoolean1 == null)
    {
      this.a = -1;
      return this;
    }
    if (paramArrayOfBoolean2 == null)
    {
      this.a = 1;
      return this;
    }
    if (paramArrayOfBoolean1.length != paramArrayOfBoolean2.length)
    {
      if (paramArrayOfBoolean1.length >= paramArrayOfBoolean2.length) {
        i = 1;
      }
      this.a = i;
      return this;
    }
    for (i = 0; (i < paramArrayOfBoolean1.length) && (this.a == 0); i++) {
      j(paramArrayOfBoolean1[i], paramArrayOfBoolean2[i]);
    }
    return this;
  }
  
  public int t()
  {
    return this.a;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\lang\builder\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */