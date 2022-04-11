package org.bouncycastle.asn1;

import java.io.IOException;

public class m1
  extends b
{
  public m1(byte[] paramArrayOfByte, int paramInt)
  {
    super(paramArrayOfByte, paramInt);
  }
  
  void g(p paramp)
    throws IOException
  {
    byte[] arrayOfByte1 = this.d;
    int i = arrayOfByte1.length + 1;
    byte[] arrayOfByte2 = new byte[i];
    arrayOfByte2[0] = ((byte)(byte)q());
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 1, i - 1);
    paramp.g(3, arrayOfByte2);
  }
  
  int h()
  {
    return y1.a(this.d.length + 1) + 1 + this.d.length + 1;
  }
  
  boolean j()
  {
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\m1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */