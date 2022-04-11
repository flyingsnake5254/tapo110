package org.bouncycastle.crypto.prng.j;

import java.util.Hashtable;
import org.bouncycastle.crypto.g;
import org.bouncycastle.crypto.j;

class d
{
  static final Hashtable a;
  
  static
  {
    Hashtable localHashtable = new Hashtable();
    a = localHashtable;
    localHashtable.put("SHA-1", org.bouncycastle.util.d.b(128));
    localHashtable.put("SHA-224", org.bouncycastle.util.d.b(192));
    localHashtable.put("SHA-256", org.bouncycastle.util.d.b(256));
    localHashtable.put("SHA-384", org.bouncycastle.util.d.b(256));
    localHashtable.put("SHA-512", org.bouncycastle.util.d.b(256));
    localHashtable.put("SHA-512/224", org.bouncycastle.util.d.b(192));
    localHashtable.put("SHA-512/256", org.bouncycastle.util.d.b(256));
  }
  
  static int a(g paramg)
  {
    return ((Integer)a.get(paramg.b())).intValue();
  }
  
  static int b(j paramj)
  {
    paramj = paramj.b();
    return ((Integer)a.get(paramj.substring(0, paramj.indexOf("/")))).intValue();
  }
  
  static byte[] c(g paramg, byte[] paramArrayOfByte, int paramInt)
  {
    int i = (paramInt + 7) / 8;
    byte[] arrayOfByte1 = new byte[i];
    int j = i / paramg.e();
    int k = paramg.e();
    byte[] arrayOfByte2 = new byte[k];
    int m = 1;
    int n = 0;
    int i4;
    for (int i1 = 0; i1 <= j; i1++)
    {
      paramg.c((byte)m);
      paramg.c((byte)(paramInt >> 24));
      paramg.c((byte)(paramInt >> 16));
      paramg.c((byte)(paramInt >> 8));
      paramg.c((byte)paramInt);
      paramg.update(paramArrayOfByte, 0, paramArrayOfByte.length);
      paramg.doFinal(arrayOfByte2, 0);
      int i2 = i1 * k;
      int i3 = i - i2;
      i4 = i3;
      if (i3 > k) {
        i4 = k;
      }
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i2, i4);
      m++;
    }
    paramInt %= 8;
    if (paramInt != 0)
    {
      i4 = 8 - paramInt;
      i1 = 0;
      paramInt = n;
      while (paramInt != i)
      {
        m = arrayOfByte1[paramInt] & 0xFF;
        arrayOfByte1[paramInt] = ((byte)(byte)(i1 << 8 - i4 | m >>> i4));
        paramInt++;
        i1 = m;
      }
    }
    return arrayOfByte1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\prng\j\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */