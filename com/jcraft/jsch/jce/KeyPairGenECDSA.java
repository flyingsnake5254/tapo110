package com.jcraft.jsch.jce;

import com.jcraft.jsch.JSchException;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;

public class KeyPairGenECDSA
  implements com.jcraft.jsch.KeyPairGenECDSA
{
  byte[] d;
  ECParameterSpec params;
  ECPrivateKey prvKey;
  ECPublicKey pubKey;
  byte[] r;
  byte[] s;
  
  private void bzero(byte[] paramArrayOfByte)
  {
    for (int i = 0; i < paramArrayOfByte.length; i++) {
      paramArrayOfByte[i] = ((byte)0);
    }
  }
  
  private byte[] chop0(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte[0] == 0) && ((paramArrayOfByte[1] & 0x80) != 0))
    {
      int i = paramArrayOfByte.length - 1;
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(paramArrayOfByte, 1, arrayOfByte, 0, i);
      bzero(paramArrayOfByte);
      return arrayOfByte;
    }
    return paramArrayOfByte;
  }
  
  private byte[] insert0(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + 1];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 1, paramArrayOfByte.length);
    bzero(paramArrayOfByte);
    return arrayOfByte;
  }
  
  public byte[] getD()
  {
    return this.d;
  }
  
  ECPrivateKey getPrivateKey()
  {
    return this.prvKey;
  }
  
  ECPublicKey getPublicKey()
  {
    return this.pubKey;
  }
  
  public byte[] getR()
  {
    return this.r;
  }
  
  public byte[] getS()
  {
    return this.s;
  }
  
  public void init(int paramInt)
    throws Exception
  {
    if (paramInt == 256)
    {
      localObject1 = "secp256r1";
    }
    else if (paramInt == 384)
    {
      localObject1 = "secp384r1";
    }
    else
    {
      if (paramInt != 521) {
        break label269;
      }
      localObject1 = "secp521r1";
    }
    for (int i = 0; i < 1000; i++)
    {
      Object localObject2 = KeyPairGenerator.getInstance("EC");
      ((KeyPairGenerator)localObject2).initialize(new ECGenParameterSpec((String)localObject1));
      localObject2 = ((KeyPairGenerator)localObject2).genKeyPair();
      this.prvKey = ((ECPrivateKey)((KeyPair)localObject2).getPrivate());
      localObject2 = (ECPublicKey)((KeyPair)localObject2).getPublic();
      this.pubKey = ((ECPublicKey)localObject2);
      this.params = ((ECPublicKey)localObject2).getParams();
      this.d = this.prvKey.getS().toByteArray();
      localObject2 = this.pubKey.getW();
      this.r = ((ECPoint)localObject2).getAffineX().toByteArray();
      localObject2 = ((ECPoint)localObject2).getAffineY().toByteArray();
      this.s = ((byte[])localObject2);
      byte[] arrayOfByte = this.r;
      if ((arrayOfByte.length == localObject2.length) && (((paramInt == 256) && (arrayOfByte.length == 32)) || ((paramInt == 384) && (arrayOfByte.length == 48)) || ((paramInt == 521) && (arrayOfByte.length == 66)))) {
        break;
      }
    }
    Object localObject1 = this.d;
    if (localObject1.length < this.r.length) {
      this.d = insert0((byte[])localObject1);
    }
    return;
    label269:
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("unsupported key size: ");
    ((StringBuilder)localObject1).append(paramInt);
    throw new JSchException(((StringBuilder)localObject1).toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\jce\KeyPairGenECDSA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */