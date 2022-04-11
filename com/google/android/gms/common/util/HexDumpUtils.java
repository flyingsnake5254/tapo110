package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class HexDumpUtils
{
  @KeepForSdk
  public static String dump(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0) && (paramInt1 >= 0) && (paramInt2 > 0) && (paramInt1 + paramInt2 <= paramArrayOfByte.length))
    {
      int i = 57;
      if (paramBoolean) {
        i = 75;
      }
      StringBuilder localStringBuilder = new StringBuilder(i * ((paramInt2 + 16 - 1) / 16));
      int j = paramInt2;
      i = 0;
      int m;
      for (int k = 0; j > 0; k = m)
      {
        if (i == 0)
        {
          if (paramInt2 < 65536) {
            localStringBuilder.append(String.format("%04X:", new Object[] { Integer.valueOf(paramInt1) }));
          } else {
            localStringBuilder.append(String.format("%08X:", new Object[] { Integer.valueOf(paramInt1) }));
          }
          m = paramInt1;
        }
        else
        {
          m = k;
          if (i == 8)
          {
            localStringBuilder.append(" -");
            m = k;
          }
        }
        localStringBuilder.append(String.format(" %02X", new Object[] { Integer.valueOf(paramArrayOfByte[paramInt1] & 0xFF) }));
        j--;
        k = i + 1;
        if ((paramBoolean) && ((k == 16) || (j == 0)))
        {
          int n = 16 - k;
          if (n > 0) {
            for (i = 0; i < n; i++) {
              localStringBuilder.append("   ");
            }
          }
          if (n >= 8) {
            localStringBuilder.append("  ");
          }
          localStringBuilder.append("  ");
          for (i = 0; i < k; i++)
          {
            n = (char)paramArrayOfByte[(m + i)];
            int i1;
            if ((n >= 32) && (n <= 126))
            {
              i1 = n;
            }
            else
            {
              n = 46;
              i1 = n;
            }
            localStringBuilder.append(i1);
          }
        }
        if (k != 16)
        {
          i = k;
          if (j != 0) {}
        }
        else
        {
          localStringBuilder.append('\n');
          i = 0;
        }
        paramInt1++;
      }
      return localStringBuilder.toString();
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\util\HexDumpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */