package org.bouncycastle.jce.interfaces;

import java.math.BigInteger;
import javax.crypto.interfaces.DHKey;
import javax.crypto.interfaces.DHPublicKey;

public abstract interface ElGamalPublicKey
  extends DHKey, DHPublicKey
{
  public abstract BigInteger getY();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jce\interfaces\ElGamalPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */