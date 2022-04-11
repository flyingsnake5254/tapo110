package com.jcraft.jsch.jce;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PBKDF
  implements com.jcraft.jsch.PBKDF
{
  public byte[] getKey(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    char[] arrayOfChar = new char[paramArrayOfByte1.length];
    for (int i = 0; i < paramArrayOfByte1.length; i++) {
      arrayOfChar[i] = ((char)(char)(paramArrayOfByte1[i] & 0xFF));
    }
    try
    {
      paramArrayOfByte1 = new javax/crypto/spec/PBEKeySpec;
      paramArrayOfByte1.<init>(arrayOfChar, paramArrayOfByte2, paramInt1, paramInt2 * 8);
      paramArrayOfByte1 = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(paramArrayOfByte1).getEncoded();
      return paramArrayOfByte1;
    }
    catch (InvalidKeySpecException|NoSuchAlgorithmException paramArrayOfByte1) {}
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\jce\PBKDF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */