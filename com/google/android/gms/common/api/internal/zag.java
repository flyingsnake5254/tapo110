package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zag<ResultT>
  extends zac
{
  private final TaskCompletionSource<ResultT> zacn;
  private final TaskApiCall<Api.AnyClient, ResultT> zacr;
  private final StatusExceptionMapper zacs;
  
  public zag(int paramInt, TaskApiCall<Api.AnyClient, ResultT> paramTaskApiCall, TaskCompletionSource<ResultT> paramTaskCompletionSource, StatusExceptionMapper paramStatusExceptionMapper)
  {
    super(paramInt);
    this.zacn = paramTaskCompletionSource;
    this.zacr = paramTaskApiCall;
    this.zacs = paramStatusExceptionMapper;
  }
  
  public final void zaa(@NonNull Status paramStatus)
  {
    this.zacn.trySetException(this.zacs.getException(paramStatus));
  }
  
  public final void zaa(GoogleApiManager.zaa<?> paramzaa)
    throws DeadObjectException
  {
    try
    {
      this.zacr.doExecute(paramzaa.zaab(), this.zacn);
      return;
    }
    catch (RuntimeException paramzaa)
    {
      zaa(paramzaa);
      return;
    }
    catch (RemoteException paramzaa)
    {
      zaa(zab.zab(paramzaa));
      return;
    }
    catch (DeadObjectException paramzaa)
    {
      throw paramzaa;
    }
  }
  
  public final void zaa(@NonNull zaab paramzaab, boolean paramBoolean)
  {
    paramzaab.zaa(this.zacn, paramBoolean);
  }
  
  public final void zaa(@NonNull RuntimeException paramRuntimeException)
  {
    this.zacn.trySetException(paramRuntimeException);
  }
  
  @Nullable
  public final Feature[] zab(GoogleApiManager.zaa<?> paramzaa)
  {
    return this.zacr.zabt();
  }
  
  public final boolean zac(GoogleApiManager.zaa<?> paramzaa)
  {
    return this.zacr.shouldAutoResolveMissingFeatures();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\zag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */