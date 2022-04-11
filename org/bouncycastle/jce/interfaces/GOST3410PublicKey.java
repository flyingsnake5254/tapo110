package org.bouncycastle.jce.interfaces;

import java.math.BigInteger;
import java.security.PublicKey;

public abstract interface GOST3410PublicKey
  extends PublicKey
{
  public abstract BigInteger getY();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jce\interfaces\GOST3410PublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */