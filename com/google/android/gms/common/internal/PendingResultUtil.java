package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public class PendingResultUtil
{
  private static final zaa zaou = new zai();
  
  @KeepForSdk
  public static <R extends Result, T extends Response<R>> Task<T> toResponseTask(PendingResult<R> paramPendingResult, T paramT)
  {
    return toTask(paramPendingResult, new zak(paramT));
  }
  
  @KeepForSdk
  public static <R extends Result, T> Task<T> toTask(PendingResult<R> paramPendingResult, ResultConverter<R, T> paramResultConverter)
  {
    zaa localzaa = zaou;
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    paramPendingResult.addStatusListener(new zaj(paramPendingResult, localTaskCompletionSource, paramResultConverter, localzaa));
    return localTaskCompletionSource.getTask();
  }
  
  @KeepForSdk
  public static <R extends Result> Task<Void> toVoidTask(PendingResult<R> paramPendingResult)
  {
    return toTask(paramPendingResult, new zal());
  }
  
  @KeepForSdk
  public static abstract interface ResultConverter<R extends Result, T>
  {
    @KeepForSdk
    public abstract T convert(R paramR);
  }
  
  public static abstract interface zaa
  {
    public abstract ApiException zaf(Status paramStatus);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\internal\PendingResultUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */