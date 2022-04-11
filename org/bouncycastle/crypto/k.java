package org.bouncycastle.crypto;

import org.bouncycastle.util.i;

public abstract class k
{
  public static byte[] a(char[] paramArrayOfChar)
  {
    int i = 0;
    if ((paramArrayOfChar != null) && (paramArrayOfChar.length > 0))
    {
      byte[] arrayOfByte = new byte[(paramArrayOfChar.length + 1) * 2];
      while (i != paramArrayOfChar.length)
      {
        int j = i * 2;
        arrayOfByte[j] = ((byte)(byte)(paramArrayOfChar[i] >>> '\b'));
        arrayOfByte[(j + 1)] = ((byte)(byte)paramArrayOfChar[i]);
        i++;
      }
      return arrayOfByte;
    }
    return new byte[0];
  }
  
  public static byte[] b(char[] paramArrayOfChar)
  {
    int i = 0;
    if (paramArrayOfChar != null)
    {
      int j = paramArrayOfChar.length;
      byte[] arrayOfByte = new byte[j];
      while (i != j)
      {
        arrayOfByte[i] = ((byte)(byte)paramArrayOfChar[i]);
        i++;
      }
      return arrayOfByte;
    }
    return new byte[0];
  }
  
  public static byte[] c(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar != null) {
      return i.i(paramArrayOfChar);
    }
    return new byte[0];
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */