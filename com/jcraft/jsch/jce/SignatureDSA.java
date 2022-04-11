package com.jcraft.jsch.jce;

import com.jcraft.jsch.Buffer;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.spec.DSAPrivateKeySpec;
import java.security.spec.DSAPublicKeySpec;

public class SignatureDSA
  implements com.jcraft.jsch.SignatureDSA
{
  KeyFactory keyFactory;
  Signature signature;
  
  public void init()
    throws Exception
  {
    this.signature = Signature.getInstance("SHA1withDSA");
    this.keyFactory = KeyFactory.getInstance("DSA");
  }
  
  protected byte[] normalize(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte.length > 1)
    {
      arrayOfByte = paramArrayOfByte;
      if (paramArrayOfByte[0] == 0)
      {
        arrayOfByte = paramArrayOfByte;
        if ((paramArrayOfByte[1] & 0x80) == 0)
        {
          int i = paramArrayOfByte.length - 1;
          arrayOfByte = new byte[i];
          System.arraycopy(paramArrayOfByte, 1, arrayOfByte, 0, i);
          arrayOfByte = normalize(arrayOfByte);
        }
      }
    }
    return arrayOfByte;
  }
  
  public void setPrvKey(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
    throws Exception
  {
    paramArrayOfByte1 = new DSAPrivateKeySpec(new BigInteger(paramArrayOfByte1), new BigInteger(paramArrayOfByte2), new BigInteger(paramArrayOfByte3), new BigInteger(paramArrayOfByte4));
    paramArrayOfByte1 = this.keyFactory.generatePrivate(paramArrayOfByte1);
    this.signature.initSign(paramArrayOfByte1);
  }
  
  public void setPubKey(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
    throws Exception
  {
    paramArrayOfByte1 = new DSAPublicKeySpec(new BigInteger(paramArrayOfByte1), new BigInteger(paramArrayOfByte2), new BigInteger(paramArrayOfByte3), new BigInteger(paramArrayOfByte4));
    paramArrayOfByte1 = this.keyFactory.generatePublic(paramArrayOfByte1);
    this.signature.initVerify(paramArrayOfByte1);
  }
  
  public byte[] sign()
    throws Exception
  {
    byte[] arrayOfByte1 = this.signature.sign();
    int i = arrayOfByte1[3] & 0xFF;
    byte[] arrayOfByte2 = new byte[i];
    int j = 0;
    System.arraycopy(arrayOfByte1, 4, arrayOfByte2, 0, i);
    int k = 4 + i + 1;
    int m = arrayOfByte1[k] & 0xFF;
    byte[] arrayOfByte3 = new byte[m];
    System.arraycopy(arrayOfByte1, k + 1, arrayOfByte3, 0, m);
    arrayOfByte1 = new byte[40];
    if (i > 20) {
      k = 1;
    } else {
      k = 0;
    }
    int n;
    if (i > 20) {
      n = 0;
    } else {
      n = 20 - i;
    }
    int i1 = i;
    if (i > 20) {
      i1 = 20;
    }
    System.arraycopy(arrayOfByte2, k, arrayOfByte1, n, i1);
    k = j;
    if (m > 20) {
      k = 1;
    }
    if (m > 20) {
      n = 20;
    } else {
      n = 40 - m;
    }
    i1 = m;
    if (m > 20) {
      i1 = 20;
    }
    System.arraycopy(arrayOfByte3, k, arrayOfByte1, n, i1);
    return arrayOfByte1;
  }
  
  public void update(byte[] paramArrayOfByte)
    throws Exception
  {
    this.signature.update(paramArrayOfByte);
  }
  
  public boolean verify(byte[] paramArrayOfByte)
    throws Exception
  {
    Object localObject = new Buffer(paramArrayOfByte);
    byte[] arrayOfByte = paramArrayOfByte;
    int j;
    if (new String(((Buffer)localObject).getString()).equals("ssh-dss"))
    {
      i = ((Buffer)localObject).getInt();
      j = ((Buffer)localObject).getOffSet();
      arrayOfByte = new byte[i];
      System.arraycopy(paramArrayOfByte, j, arrayOfByte, 0, i);
    }
    paramArrayOfByte = new byte[20];
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, 20);
    paramArrayOfByte = normalize(paramArrayOfByte);
    localObject = new byte[20];
    System.arraycopy(arrayOfByte, 20, localObject, 0, 20);
    localObject = normalize((byte[])localObject);
    if ((paramArrayOfByte[0] & 0x80) != 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((localObject[0] & 0x80) != 0) {
      j = 1;
    } else {
      j = 0;
    }
    arrayOfByte = new byte[paramArrayOfByte.length + localObject.length + 6 + i + j];
    arrayOfByte[0] = ((byte)48);
    arrayOfByte[1] = ((byte)(byte)(paramArrayOfByte.length + localObject.length + 4));
    arrayOfByte[1] = ((byte)(byte)(arrayOfByte[1] + i));
    arrayOfByte[1] = ((byte)(byte)(arrayOfByte[1] + j));
    arrayOfByte[2] = ((byte)2);
    arrayOfByte[3] = ((byte)(byte)paramArrayOfByte.length);
    arrayOfByte[3] = ((byte)(byte)(arrayOfByte[3] + i));
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, i + 4, paramArrayOfByte.length);
    arrayOfByte[(arrayOfByte[3] + 4)] = ((byte)2);
    arrayOfByte[(arrayOfByte[3] + 5)] = ((byte)(byte)localObject.length);
    int i = arrayOfByte[3] + 5;
    arrayOfByte[i] = ((byte)(byte)(arrayOfByte[i] + j));
    System.arraycopy(localObject, 0, arrayOfByte, arrayOfByte[3] + 6 + j, localObject.length);
    return this.signature.verify(arrayOfByte);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\jce\SignatureDSA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */