package com.google.firebase;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;

@KeepForSdk
public class FirebaseExceptionMapper
  implements StatusExceptionMapper
{
  public Exception getException(Status paramStatus)
  {
    if (paramStatus.getStatusCode() == 8) {
      return new FirebaseException(paramStatus.zzg());
    }
    return new FirebaseApiNotAvailableException(paramStatus.zzg());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\FirebaseExceptionMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */