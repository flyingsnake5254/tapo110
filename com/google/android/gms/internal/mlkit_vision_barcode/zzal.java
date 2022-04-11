package com.google.android.gms.internal.mlkit_vision_barcode;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzal
{
  static int zza(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 & (paramInt3 ^ 0xFFFFFFFF) | paramInt2 & paramInt3;
  }
  
  static int zza(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof byte[])) {
      return ((byte[])paramObject)[paramInt] & 0xFF;
    }
    if ((paramObject instanceof short[])) {
      return ((short[])paramObject)[paramInt] & 0xFFFF;
    }
    return ((int[])paramObject)[paramInt];
  }
  
  static int zza(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2, int paramInt, Object paramObject3, int[] paramArrayOfInt, Object[] paramArrayOfObject1, @NullableDecl Object[] paramArrayOfObject2)
  {
    int i = zzak.zza(paramObject1);
    int j = i & paramInt;
    int k = zza(paramObject3, j);
    if (k == 0) {
      return -1;
    }
    int m = paramInt ^ 0xFFFFFFFF;
    int n = -1;
    for (;;)
    {
      k--;
      int i1 = paramArrayOfInt[k];
      if (((i1 & m) == (i & m)) && (zze.zza(paramObject1, paramArrayOfObject1[k])) && ((paramArrayOfObject2 == null) || (zze.zza(paramObject2, paramArrayOfObject2[k]))))
      {
        i1 &= paramInt;
        if (n == -1) {
          zza(paramObject3, j, i1);
        } else {
          paramArrayOfInt[n] = zza(paramArrayOfInt[n], i1, paramInt);
        }
        return k;
      }
      i1 &= paramInt;
      if (i1 == 0) {
        return -1;
      }
      n = k;
      k = i1;
    }
  }
  
  static Object zza(int paramInt)
  {
    if ((paramInt >= 2) && (paramInt <= 1073741824) && (Integer.highestOneBit(paramInt) == paramInt))
    {
      if (paramInt <= 256) {
        return new byte[paramInt];
      }
      if (paramInt <= 65536) {
        return new short[paramInt];
      }
      return new int[paramInt];
    }
    StringBuilder localStringBuilder = new StringBuilder(52);
    localStringBuilder.append("must be power of 2 between 2^1 and 2^30: ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  static void zza(Object paramObject, int paramInt1, int paramInt2)
  {
    if ((paramObject instanceof byte[]))
    {
      ((byte[])paramObject)[paramInt1] = ((byte)(byte)paramInt2);
      return;
    }
    if ((paramObject instanceof short[]))
    {
      ((short[])paramObject)[paramInt1] = ((short)(short)paramInt2);
      return;
    }
    ((int[])paramObject)[paramInt1] = paramInt2;
  }
  
  static int zzb(int paramInt)
  {
    int i;
    if (paramInt < 32) {
      i = 4;
    } else {
      i = 2;
    }
    return i * (paramInt + 1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */