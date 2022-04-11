package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.encoders.d;

public class l0
  extends a
{
  l0(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte)
  {
    super(paramBoolean, paramInt, paramArrayOfByte);
  }
  
  void g(p paramp)
    throws IOException
  {
    int i;
    if (this.c) {
      i = 96;
    } else {
      i = 64;
    }
    paramp.f(i, this.d, this.f);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("[");
    if (j()) {
      localStringBuffer.append("CONSTRUCTED ");
    }
    localStringBuffer.append("APPLICATION ");
    localStringBuffer.append(Integer.toString(m()));
    localStringBuffer.append("]");
    String str;
    if (this.f != null)
    {
      localStringBuffer.append(" #");
      str = d.d(this.f);
    }
    else
    {
      str = " #null";
    }
    localStringBuffer.append(str);
    localStringBuffer.append(" ");
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\l0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */