package org.bouncycastle.jce.spec;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.KeySpec;
import org.bouncycastle.jce.interfaces.IESKey;

public class IEKeySpec
  implements KeySpec, IESKey
{
  private PrivateKey privKey;
  private PublicKey pubKey;
  
  public IEKeySpec(PrivateKey paramPrivateKey, PublicKey paramPublicKey)
  {
    this.privKey = paramPrivateKey;
    this.pubKey = paramPublicKey;
  }
  
  public String getAlgorithm()
  {
    return "IES";
  }
  
  public byte[] getEncoded()
  {
    return null;
  }
  
  public String getFormat()
  {
    return null;
  }
  
  public PrivateKey getPrivate()
  {
    return this.privKey;
  }
  
  public PublicKey getPublic()
  {
    return this.pubKey;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jce\spec\IEKeySpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */