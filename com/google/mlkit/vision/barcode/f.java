package com.google.mlkit.vision.barcode;

import androidx.annotation.Nullable;
import com.google.android.libraries.barhopper.Barcode;
import com.google.mlkit.vision.barcode.internal.h;

final class f
  implements h
{
  private final Barcode a;
  
  f(Barcode paramBarcode)
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\vision\barcode\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */