package org.bouncycastle.crypto.prng;

public class f
{
  public static byte[] a(d paramd, int paramInt)
  {
    byte[] arrayOfByte1 = new byte[paramInt];
    if (paramInt * 8 <= paramd.b())
    {
      System.arraycopy(paramd.a(), 0, arrayOfByte1, 0, paramInt);
    }
    else
    {
      int i = paramd.b() / 8;
      int j = 0;
      while (j < paramInt)
      {
        byte[] arrayOfByte2 = paramd.a();
        int k = arrayOfByte2.length;
        int m = paramInt - j;
        if (k <= m) {
          System.arraycopy(arrayOfByte2, 0, arrayOfByte1, j, arrayOfByte2.length);
        } else {
          System.arraycopy(arrayOfByte2, 0, arrayOfByte1, j, m);
        }
        j += i;
      }
    }
    return arrayOfByte1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\prng\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */