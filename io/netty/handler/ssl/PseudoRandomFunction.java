package io.netty.handler.ssl;

import io.netty.util.internal.EmptyArrays;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

final class PseudoRandomFunction
{
  private static byte[] concat(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = Arrays.copyOf(paramArrayOfByte1, paramArrayOfByte1.length + paramArrayOfByte2.length);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
    return arrayOfByte;
  }
  
  static byte[] hash(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt, String paramString)
  {
    if (paramInt >= 0) {
      try
      {
        Mac localMac = Mac.getInstance(paramString);
        Object localObject = new javax/crypto/spec/SecretKeySpec;
        ((SecretKeySpec)localObject).<init>(paramArrayOfByte1, paramString);
        localMac.init((Key)localObject);
        int i = (int)Math.ceil(paramInt / localMac.getMacLength());
        localObject = EmptyArrays.EMPTY_BYTES;
        paramArrayOfByte3 = concat(paramArrayOfByte2, paramArrayOfByte3);
        int j = 0;
        paramArrayOfByte1 = paramArrayOfByte3;
        paramArrayOfByte2 = (byte[])localObject;
        while (j < i)
        {
          paramArrayOfByte1 = localMac.doFinal(paramArrayOfByte1);
          paramArrayOfByte2 = concat(paramArrayOfByte2, localMac.doFinal(concat(paramArrayOfByte1, paramArrayOfByte3)));
          j++;
        }
        paramArrayOfByte1 = Arrays.copyOf(paramArrayOfByte2, paramInt);
        return paramArrayOfByte1;
      }
      catch (GeneralSecurityException paramArrayOfByte1)
      {
        paramArrayOfByte2 = new StringBuilder();
        paramArrayOfByte2.append("Could not find algo: ");
        paramArrayOfByte2.append(paramString);
        throw new IllegalArgumentException(paramArrayOfByte2.toString(), paramArrayOfByte1);
      }
    }
    throw new IllegalArgumentException("You must provide a length greater than zero.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\PseudoRandomFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */