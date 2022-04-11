package com.jcraft.jsch.jce;

import com.jcraft.jsch.Buffer;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

public class SignatureRSA
  implements com.jcraft.jsch.SignatureRSA
{
  KeyFactory keyFactory;
  Signature signature;
  
  public void init()
    throws Exception
  {
    this.signature = Signature.getInstance("SHA1withRSA");
    this.keyFactory = KeyFactory.getInstance("RSA");
  }
  
  public void setPrvKey(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Exception
  {
    paramArrayOfByte1 = new RSAPrivateKeySpec(new BigInteger(paramArrayOfByte2), new BigInteger(paramArrayOfByte1));
    paramArrayOfByte1 = this.keyFactory.generatePrivate(paramArrayOfByte1);
    this.signature.initSign(paramArrayOfByte1);
  }
  
  public void setPubKey(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Exception
  {
    paramArrayOfByte1 = new RSAPublicKeySpec(new BigInteger(paramArrayOfByte2), new BigInteger(paramArrayOfByte1));
    paramArrayOfByte1 = this.keyFactory.generatePublic(paramArrayOfByte1);
    this.signature.initVerify(paramArrayOfByte1);
  }
  
  public byte[] sign()
    throws Exception
  {
    return this.signature.sign();
  }
  
  public void update(byte[] paramArrayOfByte)
    throws Exception
  {
    this.signature.update(paramArrayOfByte);
  }
  
  public boolean verify(byte[] paramArrayOfByte)
    throws Exception
  {
    Buffer localBuffer = new Buffer(paramArrayOfByte);
    byte[] arrayOfByte = paramArrayOfByte;
    if (new String(localBuffer.getString()).equals("ssh-rsa"))
    {
      int i = localBuffer.getInt();
      int j = localBuffer.getOffSet();
      arrayOfByte = new byte[i];
      System.arraycopy(paramArrayOfByte, j, arrayOfByte, 0, i);
    }
    return this.signature.verify(arrayOfByte);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\jce\SignatureRSA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */