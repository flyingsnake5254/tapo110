package org.bouncycastle.asn1.i2;

import org.bouncycastle.asn1.u0;

public class d
  extends u0
{
  public d(u0 paramu0)
  {
    super(paramu0.getString());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VerisignCzagExtension: ");
    localStringBuilder.append(getString());
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\i2\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */