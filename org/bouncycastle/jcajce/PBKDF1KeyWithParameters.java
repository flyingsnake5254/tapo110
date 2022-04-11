package org.bouncycastle.jcajce;

import javax.crypto.interfaces.PBEKey;
import org.bouncycastle.crypto.d;
import org.bouncycastle.util.a;

public class PBKDF1KeyWithParameters
  extends PBKDF1Key
  implements PBEKey
{
  private final int iterationCount;
  private final byte[] salt;
  
  public PBKDF1KeyWithParameters(char[] paramArrayOfChar, d paramd, byte[] paramArrayOfByte, int paramInt)
  {
    super(paramArrayOfChar, paramd);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\PBKDF1KeyWithParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */