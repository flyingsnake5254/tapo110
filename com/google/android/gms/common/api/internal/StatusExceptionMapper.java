package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;

@KeepForSdk
public abstract interface StatusExceptionMapper
{
  @KeepForSdk
  public abstract Exception getException(Status paramStatus);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\StatusExceptionMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */