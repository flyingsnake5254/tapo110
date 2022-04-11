package org.bouncycastle.jce.interfaces;

import java.security.PublicKey;

public abstract interface MQVPublicKey
  extends PublicKey
{
  public abstract PublicKey getEphemeralKey();
  
  public abstract PublicKey getStaticKey();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jce\interfaces\MQVPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */