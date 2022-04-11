package org.bouncycastle.pqc.jcajce.interfaces;

import java.security.PrivateKey;

public abstract interface NHPrivateKey
  extends NHKey, PrivateKey
{
  public abstract short[] getSecretData();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\jcajce\interfaces\NHPrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */