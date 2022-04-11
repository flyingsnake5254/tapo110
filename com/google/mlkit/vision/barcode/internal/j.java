package com.google.mlkit.vision.barcode.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.vision.barcode.Barcode;

public final class j
  implements h
{
  private final Barcode a;
  
  public j(Barcode paramBarcode)
  {
    this.a = paramBarcode;
  }
  
  @Nullable
  public final String zzc()
  {
    return this.a.rawValue;
  }
  
  public final int zzf()
  {
    return this.a.format;
  }
  
  public final int zzg()
  {
    return this.a.valueFormat;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\vision\barcode\internal\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */