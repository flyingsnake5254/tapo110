package com.jcraft.jsch.jce;

import com.jcraft.jsch.ECDH;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import javax.crypto.KeyAgreement;

public class ECDHN
  implements ECDH
{
  private static BigInteger three;
  private static BigInteger two;
  byte[] Q_array;
  private KeyAgreement myKeyAgree;
  ECPublicKey publicKey;
  
  static
  {
    BigInteger localBigInteger1 = BigInteger.ONE;
    BigInteger localBigInteger2 = localBigInteger1.add(localBigInteger1);
    two = localBigInteger2;
    three = localBigInteger2.add(localBigInteger1);
  }
  
  private void bzero(byte[] paramArrayOfByte)
  {
    for (int i = 0; i < paramArrayOfByte.length; i++) {
      paramArrayOfByte[i] = ((byte)0);
    }
  }
  
  private byte[] chop0(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte[0] != 0) {
      return paramArrayOfByte;
    }
    int i = paramArrayOfByte.length - 1;
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(paramArrayOfByte, 1, arrayOfByte, 0, i);
    bzero(paramArrayOfByte);
    return arrayOfByte;
  }
  
  private byte[] insert0(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte[0] & 0x80) == 0) {
      return paramArrayOfByte;
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + 1];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 1, paramArrayOfByte.length);
    bzero(paramArrayOfByte);
    return arrayOfByte;
  }
  
  private byte[] toPoint(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + 1 + paramArrayOfByte2.length];
    arrayOfByte[0] = ((byte)4);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 1, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length + 1, paramArrayOfByte2.length);
    return arrayOfByte;
  }
  
  public byte[] getQ()
    throws Exception
  {
    return this.Q_array;
  }
  
  public byte[] getSecret(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Exception
  {
    paramArrayOfByte1 = KeyFactory.getInstance("EC").generatePublic(new ECPublicKeySpec(new ECPoint(new BigInteger(1, paramArrayOfByte1), new BigInteger(1, paramArrayOfByte2)), this.publicKey.getParams()));
    this.myKeyAgree.doPhase(paramArrayOfByte1, true);
    return this.myKeyAgree.generateSecret();
  }
  
  public void init(int paramInt)
    throws Exception
  {
    this.myKeyAgree = KeyAgreement.getInstance("ECDH");
    KeyPairGenECDSA localKeyPairGenECDSA = new KeyPairGenECDSA();
    localKeyPairGenECDSA.init(paramInt);
    this.publicKey = localKeyPairGenECDSA.getPublicKey();
    this.Q_array = toPoint(localKeyPairGenECDSA.getR(), localKeyPairGenECDSA.getS());
    this.myKeyAgree.init(localKeyPairGenECDSA.getPrivateKey());
  }
  
  public boolean validate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Exception
  {
    BigInteger localBigInteger1 = new BigInteger(1, paramArrayOfByte1);
    paramArrayOfByte1 = new BigInteger(1, paramArrayOfByte2);
    if (new ECPoint(localBigInteger1, paramArrayOfByte1).equals(ECPoint.POINT_INFINITY)) {
      return false;
    }
    EllipticCurve localEllipticCurve = this.publicKey.getParams().getCurve();
    paramArrayOfByte2 = ((ECFieldFp)localEllipticCurve.getField()).getP();
    BigInteger localBigInteger2 = paramArrayOfByte2.subtract(BigInteger.ONE);
    if ((localBigInteger1.compareTo(localBigInteger2) <= 0) && (paramArrayOfByte1.compareTo(localBigInteger2) <= 0))
    {
      localBigInteger1 = localBigInteger1.multiply(localEllipticCurve.getA()).add(localEllipticCurve.getB()).add(localBigInteger1.modPow(three, paramArrayOfByte2)).mod(paramArrayOfByte2);
      return paramArrayOfByte1.modPow(two, paramArrayOfByte2).equals(localBigInteger1);
    }
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\jce\ECDHN.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */