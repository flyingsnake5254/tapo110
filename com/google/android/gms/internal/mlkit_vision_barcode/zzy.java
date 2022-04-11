package com.google.android.gms.internal.mlkit_vision_barcode;

final class zzy
{
  static int zza(int paramInt, String paramString)
  {
    if (paramInt >= 0) {
      return paramInt;
    }
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString).length() + 40);
    localStringBuilder.append(paramString);
    localStringBuilder.append(" cannot be negative but was: ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */