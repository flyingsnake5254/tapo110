package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.i;

public class s0
  extends h
{
  public s0(String paramString)
  {
    super(paramString);
  }
  
  public s0(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }
  
  private byte[] v()
  {
    byte[] arrayOfByte1 = this.c;
    byte[] arrayOfByte2 = arrayOfByte1;
    if (arrayOfByte1[(arrayOfByte1.length - 1)] == 90)
    {
      if (!s())
      {
        arrayOfByte2 = this.c;
        arrayOfByte1 = new byte[arrayOfByte2.length + 4];
        System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, arrayOfByte2.length - 1);
        System.arraycopy(i.e("0000Z"), 0, arrayOfByte1, this.c.length - 1, 5);
        return arrayOfByte1;
      }
      if (!t())
      {
        arrayOfByte2 = this.c;
        arrayOfByte1 = new byte[arrayOfByte2.length + 2];
        System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, arrayOfByte2.length - 1);
        System.arraycopy(i.e("00Z"), 0, arrayOfByte1, this.c.length - 1, 3);
        return arrayOfByte1;
      }
      if (r())
      {
        for (int i = this.c.length - 2; (i > 0) && (this.c[i] == 48); i--) {}
        arrayOfByte2 = this.c;
        if (arrayOfByte2[i] == 46)
        {
          arrayOfByte1 = new byte[i + 1];
          System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, i);
          arrayOfByte1[i] = ((byte)90);
          return arrayOfByte1;
        }
        arrayOfByte1 = new byte[i + 2];
        i++;
        System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, i);
        arrayOfByte1[i] = ((byte)90);
        return arrayOfByte1;
      }
      arrayOfByte2 = this.c;
    }
    return arrayOfByte2;
  }
  
  void g(p paramp)
    throws IOException
  {
    paramp.g(24, v());
  }
  
  int h()
  {
    int i = v().length;
    return y1.a(i) + 1 + i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\s0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */