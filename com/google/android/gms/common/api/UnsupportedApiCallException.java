package com.google.android.gms.common.api;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;

public final class UnsupportedApiCallException
  extends UnsupportedOperationException
{
  private final Feature zzas;
  
  @KeepForSdk
  public UnsupportedApiCallException(Feature paramFeature)
  {
    this.zzas = paramFeature;
  }
  
  public final String getMessage()
  {
    String str = String.valueOf(this.zzas);
    StringBuilder localStringBuilder = new StringBuilder(str.length() + 8);
    localStringBuilder.append("Missing ");
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\UnsupportedApiCallException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */