package org.bouncycastle.jcajce;

import javax.crypto.interfaces.PBEKey;
import org.bouncycastle.util.a;

public class PKCS12KeyWithParameters
  extends PKCS12Key
  implements PBEKey
{
  private final int iterationCount;
  private final byte[] salt;
  
  public PKCS12KeyWithParameters(char[] paramArrayOfChar, boolean paramBoolean, byte[] paramArrayOfByte, int paramInt)
  {
    super(paramArrayOfChar, paramBoolean);
    this.salt = a.g(paramArrayOfByte);
    this.iterationCount = paramInt;
  }
  
  public PKCS12KeyWithParameters(char[] paramArrayOfChar, byte[] paramArrayOfByte, int paramInt)
  {
    super(paramArrayOfChar);
    this.salt = a.g(paramArrayOfByte);
    this.iterationCount = paramInt;
  }
  
  public int getIterationCount()
  {
    return this.iterationCount;
  }
  
  public byte[] getSalt()
  {
    return this.salt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\PKCS12KeyWithParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */