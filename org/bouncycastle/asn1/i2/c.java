package org.bouncycastle.asn1.i2;

import org.bouncycastle.asn1.u0;

public class c
  extends u0
{
  public c(u0 paramu0)
  {
    super(paramu0.getString());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NetscapeRevocationURL: ");
    localStringBuilder.append(getString());
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\i2\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */