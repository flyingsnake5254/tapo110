package com.jcraft.jsch.jce;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class KeyPairGenRSA
  implements com.jcraft.jsch.KeyPairGenRSA
{
  byte[] c;
  byte[] d;
  byte[] e;
  byte[] ep;
  byte[] eq;
  byte[] n;
  byte[] p;
  byte[] q;
  
  public byte[] getC()
  {
    return this.c;
  }
  
  public byte[] getD()
  {
    return this.d;
  }
  
  public byte[] getE()
  {
    return this.e;
  }
  
  public byte[] getEP()
  {
    return this.ep;
  }
  
  public byte[] getEQ()
  {
    return this.eq;
  }
  
  public byte[] getN()
  {
    return this.n;
  }
  
  public byte[] getP()
  {
    return this.p;
  }
  
  public byte[] getQ()
  {
    return this.q;
  }
  
  public void init(int paramInt)
    throws Exception
  {
    Object localObject1 = KeyPairGenerator.getInstance("RSA");
    ((KeyPairGenerator)localObject1).initialize(paramInt, new SecureRandom());
    Object localObject2 = ((KeyPairGenerator)localObject1).generateKeyPair();
    localObject1 = ((KeyPair)localObject2).getPublic();
    PrivateKey localPrivateKey = ((KeyPair)localObject2).getPrivate();
    localObject2 = (RSAPrivateKey)localPrivateKey;
    this.d = ((RSAPrivateKey)localObject2).getPrivateExponent().toByteArray();
    this.e = ((RSAPublicKey)localObject1).getPublicExponent().toByteArray();
    this.n = ((RSAPrivateKey)localObject2).getModulus().toByteArray();
    localObject1 = (RSAPrivateCrtKey)localPrivateKey;
    this.c = ((RSAPrivateCrtKey)localObject1).getCrtCoefficient().toByteArray();
    this.ep = ((RSAPrivateCrtKey)localObject1).getPrimeExponentP().toByteArray();
    this.eq = ((RSAPrivateCrtKey)localObject1).getPrimeExponentQ().toByteArray();
    this.p = ((RSAPrivateCrtKey)localObject1).getPrimeP().toByteArray();
    this.q = ((RSAPrivateCrtKey)localObject1).getPrimeQ().toByteArray();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\jce\KeyPairGenRSA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */