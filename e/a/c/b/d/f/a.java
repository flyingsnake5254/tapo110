package e.a.c.b.d.f;

public class a
{
  public static byte[] a(short[] paramArrayOfShort)
  {
    byte[] arrayOfByte = new byte[paramArrayOfShort.length];
    for (int i = 0; i < paramArrayOfShort.length; i++) {
      arrayOfByte[i] = ((byte)(byte)paramArrayOfShort[i]);
    }
    return arrayOfByte;
  }
  
  public static short[] b(byte[] paramArrayOfByte)
  {
    short[] arrayOfShort = new short[paramArrayOfByte.length];
    for (int i = 0; i < paramArrayOfByte.length; i++) {
      arrayOfShort[i] = ((short)(short)(paramArrayOfByte[i] & 0xFF));
    }
    return arrayOfShort;
  }
  
  public static byte[][] c(short[][] paramArrayOfShort)
  {
    byte[][] arrayOfByte = new byte[paramArrayOfShort.length][paramArrayOfShort[0].length];
    for (int i = 0; i < paramArrayOfShort.length; i++) {
      for (int j = 0; j < paramArrayOfShort[0].length; j++) {
        arrayOfByte[i][j] = ((byte)(byte)paramArrayOfShort[i][j]);
      }
    }
    return arrayOfByte;
  }
  
  public static short[][] d(byte[][] paramArrayOfByte)
  {
    short[][] arrayOfShort = new short[paramArrayOfByte.length][paramArrayOfByte[0].length];
    for (int i = 0; i < paramArrayOfByte.length; i++) {
      for (int j = 0; j < paramArrayOfByte[0].length; j++) {
        arrayOfShort[i][j] = ((short)(short)(paramArrayOfByte[i][j] & 0xFF));
      }
    }
    return arrayOfShort;
  }
  
  public static byte[][][] e(short[][][] paramArrayOfShort)
  {
    byte[][][] arrayOfByte = new byte[paramArrayOfShort.length][paramArrayOfShort[0].length][paramArrayOfShort[0][0].length];
    for (int i = 0; i < paramArrayOfShort.length; i++) {
      for (int j = 0; j < paramArrayOfShort[0].length; j++) {
        for (int k = 0; k < paramArrayOfShort[0][0].length; k++) {
          arrayOfByte[i][j][k] = ((byte)(byte)paramArrayOfShort[i][j][k]);
        }
      }
    }
    return arrayOfByte;
  }
  
  public static short[][][] f(byte[][][] paramArrayOfByte)
  {
    short[][][] arrayOfShort = new short[paramArrayOfByte.length][paramArrayOfByte[0].length][paramArrayOfByte[0][0].length];
    for (int i = 0; i < paramArrayOfByte.length; i++) {
      for (int j = 0; j < paramArrayOfByte[0].length; j++) {
        for (int k = 0; k < paramArrayOfByte[0][0].length; k++) {
          arrayOfShort[i][j][k] = ((short)(short)(paramArrayOfByte[i][j][k] & 0xFF));
        }
      }
    }
    return arrayOfShort;
  }
  
  public static int[] g(byte[] paramArrayOfByte)
  {
    int[] arrayOfInt = new int[paramArrayOfByte.length];
    for (int i = 0; i < paramArrayOfByte.length; i++) {
      paramArrayOfByte[i] &= 0xFF;
    }
    return arrayOfInt;
  }
  
  public static byte[] h(int[] paramArrayOfInt)
  {
    byte[] arrayOfByte = new byte[paramArrayOfInt.length];
    for (int i = 0; i < paramArrayOfInt.length; i++) {
      arrayOfByte[i] = ((byte)(byte)paramArrayOfInt[i]);
    }
    return arrayOfByte;
  }
  
  public static boolean i(short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    if (paramArrayOfShort1.length != paramArrayOfShort2.length) {
      return false;
    }
    int i = paramArrayOfShort1.length - 1;
    boolean bool1 = true;
    while (i >= 0)
    {
      boolean bool2;
      if (paramArrayOfShort1[i] == paramArrayOfShort2[i]) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      bool1 &= bool2;
      i--;
    }
    return bool1;
  }
  
  public static boolean j(short[][] paramArrayOfShort1, short[][] paramArrayOfShort2)
  {
    if (paramArrayOfShort1.length != paramArrayOfShort2.length) {
      return false;
    }
    int i = paramArrayOfShort1.length;
    boolean bool = true;
    i--;
    while (i >= 0)
    {
      bool &= i(paramArrayOfShort1[i], paramArrayOfShort2[i]);
      i--;
    }
    return bool;
  }
  
  public static boolean k(short[][][] paramArrayOfShort1, short[][][] paramArrayOfShort2)
  {
    if (paramArrayOfShort1.length != paramArrayOfShort2.length) {
      return false;
    }
    int i = paramArrayOfShort1.length;
    boolean bool = true;
    i--;
    while (i >= 0)
    {
      bool &= j(paramArrayOfShort1[i], paramArrayOfShort2[i]);
      i--;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\c\b\d\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */