package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class MurmurHash3
{
  @KeepForSdk
  public static int murmurhash3_x86_32(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = (paramInt2 & 0xFFFFFFFC) + paramInt1;
    while (paramInt1 < i)
    {
      j = (paramArrayOfByte[paramInt1] & 0xFF | (paramArrayOfByte[(paramInt1 + 1)] & 0xFF) << 8 | (paramArrayOfByte[(paramInt1 + 2)] & 0xFF) << 16 | paramArrayOfByte[(paramInt1 + 3)] << 24) * -862048943;
      paramInt3 ^= (j << 15 | j >>> 17) * 461845907;
      paramInt3 = (paramInt3 >>> 19 | paramInt3 << 13) * 5 - 430675100;
      paramInt1 += 4;
    }
    paramInt1 = 0;
    int j = 0;
    int k = paramInt2 & 0x3;
    if (k != 1)
    {
      paramInt1 = j;
      if (k != 2)
      {
        if (k == 3) {
          paramInt1 = (paramArrayOfByte[(i + 2)] & 0xFF) << 16;
        }
      }
      else {
        paramInt1 |= (paramArrayOfByte[(i + 1)] & 0xFF) << 8;
      }
    }
    else
    {
      paramInt1 = (paramArrayOfByte[i] & 0xFF | paramInt1) * -862048943;
      paramInt3 ^= (paramInt1 >>> 17 | paramInt1 << 15) * 461845907;
    }
    paramInt1 = paramInt3 ^ paramInt2;
    paramInt1 = (paramInt1 ^ paramInt1 >>> 16) * -2048144789;
    paramInt1 = (paramInt1 ^ paramInt1 >>> 13) * -1028477387;
    return paramInt1 ^ paramInt1 >>> 16;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\util\MurmurHash3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */