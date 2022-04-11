package com.jcraft.jsch.jce;

import com.jcraft.jsch.Buffer;
import com.jcraft.jsch.SignatureECDSA;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;

public abstract class SignatureECDSAN
  implements SignatureECDSA
{
  KeyFactory keyFactory;
  Signature signature;
  
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
  
  abstract String getName();
  
  public void init()
    throws Exception
  {
    String str = getName();
    if (str.equals("ecdsa-sha2-nistp384")) {
      str = "SHA384withECDSA";
    } else if (str.equals("ecdsa-sha2-nistp521")) {
      str = "SHA512withECDSA";
    } else {
      str = "SHA256withECDSA";
    }
    this.signature = Signature.getInstance(str);
    this.keyFactory = KeyFactory.getInstance("EC");
  }
  
  public void setPrvKey(byte[] paramArrayOfByte)
    throws Exception
  {
    Object localObject = insert0(paramArrayOfByte);
    if (localObject.length >= 64) {
      paramArrayOfByte = "secp521r1";
    } else if (localObject.length >= 48) {
      paramArrayOfByte = "secp384r1";
    } else {
      paramArrayOfByte = "secp256r1";
    }
    AlgorithmParameters localAlgorithmParameters = AlgorithmParameters.getInstance("EC");
    localAlgorithmParameters.init(new ECGenParameterSpec(paramArrayOfByte));
    paramArrayOfByte = (ECParameterSpec)localAlgorithmParameters.getParameterSpec(ECParameterSpec.class);
    localObject = new BigInteger(1, (byte[])localObject);
    paramArrayOfByte = this.keyFactory.generatePrivate(new ECPrivateKeySpec((BigInteger)localObject, paramArrayOfByte));
    this.signature.initSign(paramArrayOfByte);
  }
  
  public void setPubKey(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Exception
  {
    byte[] arrayOfByte = insert0(paramArrayOfByte1);
    paramArrayOfByte2 = insert0(paramArrayOfByte2);
    if (arrayOfByte.length >= 64) {
      paramArrayOfByte1 = "secp521r1";
    } else if (arrayOfByte.length >= 48) {
      paramArrayOfByte1 = "secp384r1";
    } else {
      paramArrayOfByte1 = "secp256r1";
    }
    AlgorithmParameters localAlgorithmParameters = AlgorithmParameters.getInstance("EC");
    localAlgorithmParameters.init(new ECGenParameterSpec(paramArrayOfByte1));
    paramArrayOfByte1 = (ECParameterSpec)localAlgorithmParameters.getParameterSpec(ECParameterSpec.class);
    paramArrayOfByte2 = new ECPoint(new BigInteger(1, arrayOfByte), new BigInteger(1, paramArrayOfByte2));
    paramArrayOfByte1 = this.keyFactory.generatePublic(new ECPublicKeySpec(paramArrayOfByte2, paramArrayOfByte1));
    this.signature.initVerify(paramArrayOfByte1);
  }
  
  public byte[] sign()
    throws Exception
  {
    byte[] arrayOfByte1 = this.signature.sign();
    byte[] arrayOfByte2 = arrayOfByte1;
    if (arrayOfByte1[0] == 48)
    {
      int i = arrayOfByte1[1];
      int j = arrayOfByte1.length;
      int k = 3;
      if (i + 2 != j)
      {
        arrayOfByte2 = arrayOfByte1;
        if ((arrayOfByte1[1] & 0x80) != 0)
        {
          arrayOfByte2 = arrayOfByte1;
          if ((arrayOfByte1[2] & 0xFF) + 3 != arrayOfByte1.length) {}
        }
      }
      else
      {
        i = k;
        if ((arrayOfByte1[1] & 0x80) != 0)
        {
          i = k;
          if ((arrayOfByte1[2] & 0xFF) + 3 == arrayOfByte1.length) {
            i = 4;
          }
        }
        j = arrayOfByte1[i];
        Object localObject = new byte[j];
        k = arrayOfByte1[(i + 2 + arrayOfByte1[i])];
        arrayOfByte2 = new byte[k];
        System.arraycopy(arrayOfByte1, i + 1, localObject, 0, j);
        System.arraycopy(arrayOfByte1, i + 3 + arrayOfByte1[i], arrayOfByte2, 0, k);
        arrayOfByte1 = chop0((byte[])localObject);
        arrayOfByte2 = chop0(arrayOfByte2);
        localObject = new Buffer();
        ((Buffer)localObject).putMPInt(arrayOfByte1);
        ((Buffer)localObject).putMPInt(arrayOfByte2);
        arrayOfByte2 = new byte[((Buffer)localObject).getLength()];
        ((Buffer)localObject).setOffSet(0);
        ((Buffer)localObject).getByte(arrayOfByte2);
      }
    }
    return arrayOfByte2;
  }
  
  public void update(byte[] paramArrayOfByte)
    throws Exception
  {
    this.signature.update(paramArrayOfByte);
  }
  
  public boolean verify(byte[] paramArrayOfByte)
    throws Exception
  {
    if (paramArrayOfByte[0] == 48)
    {
      arrayOfByte1 = paramArrayOfByte;
      if (paramArrayOfByte[1] + 2 == paramArrayOfByte.length) {
        break label270;
      }
      if ((paramArrayOfByte[1] & 0x80) != 0)
      {
        arrayOfByte1 = paramArrayOfByte;
        if ((paramArrayOfByte[2] & 0xFF) + 3 == paramArrayOfByte.length) {
          break label270;
        }
      }
    }
    paramArrayOfByte = new Buffer(paramArrayOfByte);
    paramArrayOfByte.getString();
    paramArrayOfByte.getInt();
    byte[] arrayOfByte1 = paramArrayOfByte.getMPInt();
    paramArrayOfByte = paramArrayOfByte.getMPInt();
    arrayOfByte1 = insert0(arrayOfByte1);
    byte[] arrayOfByte2 = insert0(paramArrayOfByte);
    if (arrayOfByte1.length < 64)
    {
      paramArrayOfByte = new byte[arrayOfByte1.length + 6 + arrayOfByte2.length];
      paramArrayOfByte[0] = ((byte)48);
      paramArrayOfByte[1] = ((byte)(byte)(arrayOfByte1.length + 4 + arrayOfByte2.length));
      paramArrayOfByte[2] = ((byte)2);
      paramArrayOfByte[3] = ((byte)(byte)arrayOfByte1.length);
      System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, 4, arrayOfByte1.length);
      paramArrayOfByte[(arrayOfByte1.length + 4)] = ((byte)2);
      paramArrayOfByte[(arrayOfByte1.length + 5)] = ((byte)(byte)arrayOfByte2.length);
      System.arraycopy(arrayOfByte2, 0, paramArrayOfByte, arrayOfByte1.length + 6, arrayOfByte2.length);
    }
    else
    {
      paramArrayOfByte = new byte[arrayOfByte1.length + 6 + arrayOfByte2.length + 1];
      paramArrayOfByte[0] = ((byte)48);
      paramArrayOfByte[1] = ((byte)-127);
      paramArrayOfByte[2] = ((byte)(byte)(arrayOfByte1.length + 4 + arrayOfByte2.length));
      paramArrayOfByte[3] = ((byte)2);
      paramArrayOfByte[4] = ((byte)(byte)arrayOfByte1.length);
      System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, 5, arrayOfByte1.length);
      paramArrayOfByte[(arrayOfByte1.length + 5)] = ((byte)2);
      paramArrayOfByte[(arrayOfByte1.length + 6)] = ((byte)(byte)arrayOfByte2.length);
      System.arraycopy(arrayOfByte2, 0, paramArrayOfByte, arrayOfByte1.length + 7, arrayOfByte2.length);
    }
    arrayOfByte1 = paramArrayOfByte;
    label270:
    return this.signature.verify(arrayOfByte1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\jce\SignatureECDSAN.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */