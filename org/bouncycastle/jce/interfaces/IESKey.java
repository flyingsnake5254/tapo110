package org.bouncycastle.jce.interfaces;

import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;

public abstract interface IESKey
  extends Key
{
  public abstract PrivateKey getPrivate();
  
  public abstract PublicKey getPublic();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jce\interfaces\IESKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */