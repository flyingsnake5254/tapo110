package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;

@KeepForSdk
public class ApiExceptionMapper
  implements StatusExceptionMapper
{
  public Exception getException(Status paramStatus)
  {
    return ApiExceptionUtil.fromStatus(paramStatus);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\ApiExceptionMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */