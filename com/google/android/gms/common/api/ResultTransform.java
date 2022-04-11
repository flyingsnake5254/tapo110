package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.api.internal.zacd;

public abstract class ResultTransform<R extends Result, S extends Result>
{
  @NonNull
  public final PendingResult<S> createFailedResult(@NonNull Status paramStatus)
  {
    return new zacd(paramStatus);
  }
  
  @NonNull
  public Status onFailure(@NonNull Status paramStatus)
  {
    return paramStatus;
  }
  
  @Nullable
  @WorkerThread
  public abstract PendingResult<S> onSuccess(@NonNull R paramR);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\ResultTransform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */