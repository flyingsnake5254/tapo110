package com.google.android.gms.internal.mlkit_vision_barcode;

public final class zzbj
  extends zzbi
{
  public static int zza(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 <= 1073741823) {
      paramInt3 = 1;
    } else {
      paramInt3 = 0;
    }
    if (paramInt3 != 0) {
      return Math.min(Math.max(paramInt1, paramInt2), 1073741823);
    }
    throw new IllegalArgumentException(zzg.zza("min (%s) must be less than or equal to max (%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(1073741823) }));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzbj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */