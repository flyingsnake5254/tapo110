package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;

@KeepForSdk
public class ApiExceptionUtil
{
  @NonNull
  @KeepForSdk
  public static ApiException fromStatus(@NonNull Status paramStatus)
  {
    if (paramStatus.hasResolution()) {
      return new ResolvableApiException(paramStatus);
    }
    return new ApiException(paramStatus);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\internal\ApiExceptionUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */