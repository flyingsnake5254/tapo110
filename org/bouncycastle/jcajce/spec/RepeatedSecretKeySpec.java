package org.bouncycastle.jcajce.spec;

import javax.crypto.SecretKey;

public class RepeatedSecretKeySpec
  implements SecretKey
{
  private String algorithm;
  
  public RepeatedSecretKeySpec(String paramString)
  {
    this.algorithm = paramString;
  }
  
  public String getAlgorithm()
  {
    return this.algorithm;
  }
  
  public byte[] getEncoded()
  {
    return null;
  }
  
  public String getFormat()
  {
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\spec\RepeatedSecretKeySpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */