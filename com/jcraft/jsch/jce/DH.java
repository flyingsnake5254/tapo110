package com.jcraft.jsch.jce;

import com.jcraft.jsch.JSchException;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.KeyAgreement;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;

public class DH
  implements com.jcraft.jsch.DH
{
  BigInteger K;
  byte[] K_array;
  BigInteger e;
  byte[] e_array;
  BigInteger f;
  BigInteger g;
  private KeyAgreement myKeyAgree;
  private KeyPairGenerator myKpairGen;
  BigInteger p;
  
  private void checkRange(BigInteger paramBigInteger)
    throws Exception
  {
    BigInteger localBigInteger1 = BigInteger.ONE;
    BigInteger localBigInteger2 = this.p.subtract(localBigInteger1);
    if ((localBigInteger1.compareTo(paramBigInteger) < 0) && (paramBigInteger.compareTo(localBigInteger2) < 0)) {
      return;
    }
    throw new JSchException("invalid DH value");
  }
  
  public void checkRange()
    throws Exception
  {}
  
  public byte[] getE()
    throws Exception
  {
    if (this.e == null)
    {
      Object localObject = new DHParameterSpec(this.p, this.g);
      this.myKpairGen.initialize((AlgorithmParameterSpec)localObject);
      localObject = this.myKpairGen.generateKeyPair();
      this.myKeyAgree.init(((KeyPair)localObject).getPrivate());
      localObject = ((DHPublicKey)((KeyPair)localObject).getPublic()).getY();
      this.e = ((BigInteger)localObject);
      this.e_array = ((BigInteger)localObject).toByteArray();
    }
    return this.e_array;
  }
  
  public byte[] getK()
    throws Exception
  {
    if (this.K == null)
    {
      Object localObject = KeyFactory.getInstance("DH").generatePublic(new DHPublicKeySpec(this.f, this.p, this.g));
      this.myKeyAgree.doPhase((Key)localObject, true);
      byte[] arrayOfByte = this.myKeyAgree.generateSecret();
      localObject = new BigInteger(1, arrayOfByte);
      this.K = ((BigInteger)localObject);
      this.K_array = ((BigInteger)localObject).toByteArray();
      this.K_array = arrayOfByte;
    }
    return this.K_array;
  }
  
  public void init()
    throws Exception
  {
    this.myKpairGen = KeyPairGenerator.getInstance("DH");
    this.myKeyAgree = KeyAgreement.getInstance("DH");
  }
  
  void setF(BigInteger paramBigInteger)
  {
    this.f = paramBigInteger;
  }
  
  public void setF(byte[] paramArrayOfByte)
  {
    setF(new BigInteger(1, paramArrayOfByte));
  }
  
  void setG(BigInteger paramBigInteger)
  {
    this.g = paramBigInteger;
  }
  
  public void setG(byte[] paramArrayOfByte)
  {
    setG(new BigInteger(1, paramArrayOfByte));
  }
  
  void setP(BigInteger paramBigInteger)
  {
    this.p = paramBigInteger;
  }
  
  public void setP(byte[] paramArrayOfByte)
  {
    setP(new BigInteger(1, paramArrayOfByte));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\jce\DH.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */