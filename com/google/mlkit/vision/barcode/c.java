package com.google.mlkit.vision.barcode;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.common.sdkinternal.j;
import com.google.mlkit.vision.barcode.internal.BarcodeScannerImpl.a;

public class c
{
  @NonNull
  public static BarcodeScanner a(@NonNull b paramb)
  {
    Preconditions.checkNotNull(paramb, "You must provide a valid BarcodeScannerOptions.");
    return ((BarcodeScannerImpl.a)j.c().a(BarcodeScannerImpl.a.class)).a(paramb);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\vision\barcode\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */