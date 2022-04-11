package com.google.android.libraries.barhopper;

import com.google.android.apps.common.proguard.UsedByNative;

@UsedByNative("jni_common.cc")
public class RecognitionOptions
{
  @UsedByNative("jni_common.cc")
  private int barcodeFormats = 0;
  @UsedByNative("jni_common.cc")
  private boolean outputUnrecognizedBarcodes = false;
  
  public void a(int paramInt)
  {
    this.barcodeFormats = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\libraries\barhopper\RecognitionOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */