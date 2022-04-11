package org.bouncycastle.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class a
{
  public static int A(long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    if (paramArrayOfLong == null) {
      return 0;
    }
    int i = paramInt2 + 1;
    int j = paramInt2;
    long l;
    for (paramInt2 = i;; paramInt2 = (paramInt2 * 257 ^ (int)l) * 257 ^ (int)(l >>> 32))
    {
      j--;
      if (j < 0) {
        break;
      }
      l = paramArrayOfLong[(paramInt1 + j)];
    }
    return paramInt2;
  }
  
  public static int B(short[] paramArrayOfShort)
  {
    if (paramArrayOfShort == null) {
      return 0;
    }
    int i = paramArrayOfShort.length;
    for (int j = i + 1;; j = j * 257 ^ paramArrayOfShort[i] & 0xFF)
    {
      i--;
      if (i < 0) {
        break;
      }
    }
    return j;
  }
  
  public static int C(short[][] paramArrayOfShort)
  {
    int i = 0;
    int j = 0;
    while (i != paramArrayOfShort.length)
    {
      j = j * 257 + B(paramArrayOfShort[i]);
      i++;
    }
    return j;
  }
  
  public static int D(short[][][] paramArrayOfShort)
  {
    int i = 0;
    int j = 0;
    while (i != paramArrayOfShort.length)
    {
      j = j * 257 + C(paramArrayOfShort[i]);
      i++;
    }
    return j;
  }
  
  public static byte[] E(byte[] paramArrayOfByte, byte paramByte)
  {
    if (paramArrayOfByte == null) {
      return new byte[] { paramByte };
    }
    int i = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[i + 1];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 1, i);
    arrayOfByte[0] = paramByte;
    return arrayOfByte;
  }
  
  public static int[] F(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      return null;
    }
    int i = 0;
    int j = paramArrayOfInt.length;
    int[] arrayOfInt = new int[j];
    for (;;)
    {
      j--;
      if (j < 0) {
        break;
      }
      arrayOfInt[j] = paramArrayOfInt[i];
      i++;
    }
    return arrayOfInt;
  }
  
  public static int[] a(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt == null) {
      return new int[] { paramInt };
    }
    int i = paramArrayOfInt.length;
    int[] arrayOfInt = new int[i + 1];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, i);
    arrayOfInt[i] = paramInt;
    return arrayOfInt;
  }
  
  public static short[] b(short[] paramArrayOfShort, short paramShort)
  {
    if (paramArrayOfShort == null) {
      return new short[] { paramShort };
    }
    int i = paramArrayOfShort.length;
    short[] arrayOfShort = new short[i + 1];
    System.arraycopy(paramArrayOfShort, 0, arrayOfShort, 0, i);
    arrayOfShort[i] = paramShort;
    return arrayOfShort;
  }
  
  public static boolean c(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 == paramArrayOfByte2) {
      return true;
    }
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null))
    {
      if (paramArrayOfByte1.length != paramArrayOfByte2.length) {
        return false;
      }
      for (int i = 0; i != paramArrayOfByte1.length; i++) {
        if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public static boolean d(char[] paramArrayOfChar1, char[] paramArrayOfChar2)
  {
    if (paramArrayOfChar1 == paramArrayOfChar2) {
      return true;
    }
    if ((paramArrayOfChar1 != null) && (paramArrayOfChar2 != null))
    {
      if (paramArrayOfChar1.length != paramArrayOfChar2.length) {
        return false;
      }
      for (int i = 0; i != paramArrayOfChar1.length; i++) {
        if (paramArrayOfChar1[i] != paramArrayOfChar2[i]) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public static boolean e(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (paramArrayOfInt1 == paramArrayOfInt2) {
      return true;
    }
    if ((paramArrayOfInt1 != null) && (paramArrayOfInt2 != null))
    {
      if (paramArrayOfInt1.length != paramArrayOfInt2.length) {
        return false;
      }
      for (int i = 0; i != paramArrayOfInt1.length; i++) {
        if (paramArrayOfInt1[i] != paramArrayOfInt2[i]) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public static boolean f(short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    if (paramArrayOfShort1 == paramArrayOfShort2) {
      return true;
    }
    if ((paramArrayOfShort1 != null) && (paramArrayOfShort2 != null))
    {
      if (paramArrayOfShort1.length != paramArrayOfShort2.length) {
        return false;
      }
      for (int i = 0; i != paramArrayOfShort1.length; i++) {
        if (paramArrayOfShort1[i] != paramArrayOfShort2[i]) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public static byte[] g(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte.length];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    return arrayOfByte;
  }
  
  public static char[] h(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null) {
      return null;
    }
    char[] arrayOfChar = new char[paramArrayOfChar.length];
    System.arraycopy(paramArrayOfChar, 0, arrayOfChar, 0, paramArrayOfChar.length);
    return arrayOfChar;
  }
  
  public static int[] i(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      return null;
    }
    int[] arrayOfInt = new int[paramArrayOfInt.length];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, paramArrayOfInt.length);
    return arrayOfInt;
  }
  
  public static long[] j(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong == null) {
      return null;
    }
    long[] arrayOfLong = new long[paramArrayOfLong.length];
    System.arraycopy(paramArrayOfLong, 0, arrayOfLong, 0, paramArrayOfLong.length);
    return arrayOfLong;
  }
  
  public static short[] k(short[] paramArrayOfShort)
  {
    if (paramArrayOfShort == null) {
      return null;
    }
    short[] arrayOfShort = new short[paramArrayOfShort.length];
    System.arraycopy(paramArrayOfShort, 0, arrayOfShort, 0, paramArrayOfShort.length);
    return arrayOfShort;
  }
  
  public static byte[] l(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null))
    {
      byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length];
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
      System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
      return arrayOfByte;
    }
    if (paramArrayOfByte2 != null) {
      return g(paramArrayOfByte2);
    }
    return g(paramArrayOfByte1);
  }
  
  public static byte[] m(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null) && (paramArrayOfByte3 != null))
    {
      byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length + paramArrayOfByte3.length];
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
      System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
      System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, paramArrayOfByte1.length + paramArrayOfByte2.length, paramArrayOfByte3.length);
      return arrayOfByte;
    }
    if (paramArrayOfByte1 == null) {
      return l(paramArrayOfByte2, paramArrayOfByte3);
    }
    if (paramArrayOfByte2 == null) {
      return l(paramArrayOfByte1, paramArrayOfByte3);
    }
    return l(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public static byte[] n(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null) && (paramArrayOfByte3 != null) && (paramArrayOfByte4 != null))
    {
      byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length + paramArrayOfByte3.length + paramArrayOfByte4.length];
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
      System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
      System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, paramArrayOfByte1.length + paramArrayOfByte2.length, paramArrayOfByte3.length);
      System.arraycopy(paramArrayOfByte4, 0, arrayOfByte, paramArrayOfByte1.length + paramArrayOfByte2.length + paramArrayOfByte3.length, paramArrayOfByte4.length);
      return arrayOfByte;
    }
    if (paramArrayOfByte4 == null) {
      return m(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3);
    }
    if (paramArrayOfByte3 == null) {
      return m(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte4);
    }
    if (paramArrayOfByte2 == null) {
      return m(paramArrayOfByte1, paramArrayOfByte3, paramArrayOfByte4);
    }
    return m(paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4);
  }
  
  public static boolean o(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    boolean bool = true;
    if (paramArrayOfByte1 == paramArrayOfByte2) {
      return true;
    }
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null))
    {
      if (paramArrayOfByte1.length != paramArrayOfByte2.length) {
        return o(paramArrayOfByte1, paramArrayOfByte1) ^ true;
      }
      int i = 0;
      int j = 0;
      while (i != paramArrayOfByte1.length)
      {
        j |= paramArrayOfByte1[i] ^ paramArrayOfByte2[i];
        i++;
      }
      if (j != 0) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public static boolean p(int[] paramArrayOfInt, int paramInt)
  {
    for (int i = 0; i < paramArrayOfInt.length; i++) {
      if (paramArrayOfInt[i] == paramInt) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean q(short[] paramArrayOfShort, short paramShort)
  {
    for (int i = 0; i < paramArrayOfShort.length; i++) {
      if (paramArrayOfShort[i] == paramShort) {
        return true;
      }
    }
    return false;
  }
  
  public static byte[] r(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    if (paramInt >= paramArrayOfByte.length) {
      paramInt = paramArrayOfByte.length;
    }
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramInt);
    return arrayOfByte;
  }
  
  public static byte[] s(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = v(paramInt1, paramInt2);
    byte[] arrayOfByte = new byte[i];
    paramInt2 = i;
    if (paramArrayOfByte.length - paramInt1 < i) {
      paramInt2 = paramArrayOfByte.length - paramInt1;
    }
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
  
  public static int[] t(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i = v(paramInt1, paramInt2);
    int[] arrayOfInt = new int[i];
    paramInt2 = i;
    if (paramArrayOfInt.length - paramInt1 < i) {
      paramInt2 = paramArrayOfInt.length - paramInt1;
    }
    System.arraycopy(paramArrayOfInt, paramInt1, arrayOfInt, 0, paramInt2);
    return arrayOfInt;
  }
  
  public static void u(byte[] paramArrayOfByte, byte paramByte)
  {
    for (int i = 0; i < paramArrayOfByte.length; i++) {
      paramArrayOfByte[i] = ((byte)paramByte);
    }
  }
  
  private static int v(int paramInt1, int paramInt2)
  {
    int i = paramInt2 - paramInt1;
    if (i >= 0) {
      return i;
    }
    StringBuffer localStringBuffer = new StringBuffer(paramInt1);
    localStringBuffer.append(" > ");
    localStringBuffer.append(paramInt2);
    throw new IllegalArgumentException(localStringBuffer.toString());
  }
  
  public static int w(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return 0;
    }
    int i = paramArrayOfByte.length;
    for (int j = i + 1;; j = j * 257 ^ paramArrayOfByte[i])
    {
      i--;
      if (i < 0) {
        break;
      }
    }
    return j;
  }
  
  public static int x(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null) {
      return 0;
    }
    int i = paramArrayOfChar.length;
    for (int j = i + 1;; j = j * 257 ^ paramArrayOfChar[i])
    {
      i--;
      if (i < 0) {
        break;
      }
    }
    return j;
  }
  
  public static int y(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      return 0;
    }
    int i = paramArrayOfInt.length;
    for (int j = i + 1;; j = j * 257 ^ paramArrayOfInt[i])
    {
      i--;
      if (i < 0) {
        break;
      }
    }
    return j;
  }
  
  public static int z(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if (paramArrayOfInt == null) {
      return 0;
    }
    int i = paramInt2 + 1;
    int j = paramInt2;
    for (paramInt2 = i;; paramInt2 = paramInt2 * 257 ^ paramArrayOfInt[(paramInt1 + j)])
    {
      j--;
      if (j < 0) {
        break;
      }
    }
    return paramInt2;
  }
  
  public static class a<T>
    implements Iterator<T>
  {
    private final T[] c;
    private int d = 0;
    
    public a(T[] paramArrayOfT)
    {
      this.c = paramArrayOfT;
    }
    
    public boolean hasNext()
    {
      boolean bool;
      if (this.d < this.c.length) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public T next()
    {
      int i = this.d;
      Object localObject = this.c;
      if (i != localObject.length)
      {
        this.d = (i + 1);
        return localObject[i];
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Out of elements: ");
      ((StringBuilder)localObject).append(this.d);
      throw new NoSuchElementException(((StringBuilder)localObject).toString());
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException("Cannot remove element from an Array.");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\util\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */