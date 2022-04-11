package org.bouncycastle.jce.interfaces;

import java.math.BigInteger;
import java.security.PrivateKey;

public abstract interface ECPrivateKey
  extends PrivateKey
{
  public abstract BigInteger getD();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jce\interfaces\ECPrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */