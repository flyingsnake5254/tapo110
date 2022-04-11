package com.google.android.gms.internal.measurement;

final class zzmu
  extends zzmt
{
  final int zzb(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    while ((paramInt2 < paramInt3) && (paramArrayOfByte[paramInt2] >= 0)) {
      paramInt2++;
    }
    int i = 0;
    paramInt1 = paramInt2;
    if (paramInt2 >= paramInt3) {
      paramInt1 = i;
    }
    label273:
    label275:
    for (;;)
    {
      if (paramInt1 >= paramInt3)
      {
        paramInt1 = i;
      }
      else
      {
        int j = paramInt1 + 1;
        paramInt2 = paramArrayOfByte[paramInt1];
        paramInt1 = j;
        if (paramInt2 >= 0) {
          break label275;
        }
        if (paramInt2 < -32) {
          if (j < paramInt3) {
            if (paramInt2 >= -62)
            {
              paramInt1 = j + 1;
              if (paramArrayOfByte[j] <= -65) {
                continue;
              }
            }
          }
        }
        for (;;)
        {
          paramInt1 = -1;
          break label273;
          paramInt1 = paramInt2;
          break label273;
          if (paramInt2 < -16)
          {
            if (j >= paramInt3 - 1)
            {
              paramInt1 = zzmw.zzf(paramArrayOfByte, j, paramInt3);
              break label273;
            }
            int k = j + 1;
            paramInt1 = paramArrayOfByte[j];
            if ((paramInt1 > -65) || ((paramInt2 == -32) && (paramInt1 < -96)) || ((paramInt2 == -19) && (paramInt1 >= -96))) {
              continue;
            }
            paramInt1 = k + 1;
            if (paramArrayOfByte[k] <= -65) {
              break;
            }
            continue;
          }
          if (j >= paramInt3 - 2)
          {
            paramInt1 = zzmw.zzf(paramArrayOfByte, j, paramInt3);
            break label273;
          }
          paramInt1 = j + 1;
          j = paramArrayOfByte[j];
          if ((j <= -65) && ((paramInt2 << 28) + (j + 112) >> 30 == 0))
          {
            paramInt2 = paramInt1 + 1;
            if (paramArrayOfByte[paramInt1] <= -65)
            {
              paramInt1 = paramInt2 + 1;
              if (paramArrayOfByte[paramInt2] <= -65) {
                break label275;
              }
            }
          }
        }
      }
      return paramInt1;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzmu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */