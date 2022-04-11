package org.bouncycastle.pqc.jcajce.interfaces;

import java.security.PublicKey;

public abstract interface NHPublicKey
  extends NHKey, PublicKey
{
  public abstract byte[] getPublicData();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\jcajce\interfaces\NHPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */