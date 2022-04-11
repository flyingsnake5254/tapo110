package com.jcraft.jsch.jce;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.interfaces.DSAKey;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;

public class KeyPairGenDSA
  implements com.jcraft.jsch.KeyPairGenDSA
{
  byte[] g;
  byte[] p;
  byte[] q;
  byte[] x;
  byte[] y;
  
  public byte[] getG()
  {
    return this.g;
  }
  
  public byte[] getP()
  {
    return this.p;
  }
  
  public byte[] getQ()
  {
    return this.q;
  }
  
  public byte[] getX()
  {
    return this.x;
  }
  
  public byte[] getY()
  {
    return this.y;
  }
  
  public void init(int paramInt)
    throws Exception
  {
    Object localObject1 = KeyPairGenerator.getInstance("DSA");
    ((KeyPairGenerator)localObject1).initialize(paramInt, new SecureRandom());
    Object localObject2 = ((KeyPairGenerator)localObject1).generateKeyPair();
    localObject1 = ((KeyPair)localObject2).getPublic();
    localObject2 = ((KeyPair)localObject2).getPrivate();
    this.x = ((DSAPrivateKey)localObject2).getX().toByteArray();
    this.y = ((DSAPublicKey)localObject1).getY().toByteArray();
    localObject1 = ((DSAKey)localObject2).getParams();
    this.p = ((DSAParams)localObject1).getP().toByteArray();
    this.q = ((DSAParams)localObject1).getQ().toByteArray();
    this.g = ((DSAParams)localObject1).getG().toByteArray();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\jce\KeyPairGenDSA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */