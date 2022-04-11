package com.google.android.gms.internal.mlkit_vision_barcode;

abstract class zzja
{
  abstract int zza(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3);
  
  abstract int zza(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  final boolean zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return zza(0, paramArrayOfByte, paramInt1, paramInt2) == 0;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzja.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */