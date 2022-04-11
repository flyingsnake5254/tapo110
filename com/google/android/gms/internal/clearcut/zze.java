package com.google.android.gms.internal.clearcut;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.clearcut.zzb;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zze
  extends GoogleApi<Api.ApiOptions.NoOptions>
  implements zzb
{
  @VisibleForTesting
  private zze(@NonNull Context paramContext)
  {
    super(paramContext, ClearcutLogger.API, null, new ApiExceptionMapper());
  }
  
  public static zzb zzb(@NonNull Context paramContext)
  {
    return new zze(paramContext);
  }
  
  public final PendingResult<Status> zzb(com.google.android.gms.clearcut.zze paramzze)
  {
    return doBestEffortWrite(new zzh(paramzze, asGoogleApiClient()));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */