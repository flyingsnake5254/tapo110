package com.google.mlkit.vision.barcode;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.util.RetainForClient;
import com.google.mlkit.vision.barcode.internal.BarcodeScannerOptionsParcel;
import com.google.mlkit.vision.barcode.internal.a;
import com.google.mlkit.vision.barcode.internal.l;

@KeepForSdk
@DynamiteApi
@RetainForClient
public class BarcodeScannerCreator
  extends l
{
  @KeepForSdk
  public a newBarcodeScanner(BarcodeScannerOptionsParcel paramBarcodeScannerOptionsParcel)
  {
    return new d(paramBarcodeScannerOptionsParcel);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\vision\barcode\BarcodeScannerCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */