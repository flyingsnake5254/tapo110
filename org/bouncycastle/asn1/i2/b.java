package org.bouncycastle.asn1.i2;

import org.bouncycastle.asn1.n0;

public class b
  extends n0
{
  public b(n0 paramn0)
  {
    super(paramn0.o(), paramn0.q());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NetscapeCertType: 0x");
    localStringBuilder.append(Integer.toHexString(this.d[0] & 0xFF));
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\i2\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */