package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;

@KeepForSdk
public class BaseImplementation
{
  @KeepForSdk
  public static abstract class ApiMethodImpl<R extends Result, A extends Api.AnyClient>
    extends BasePendingResult<R>
    implements BaseImplementation.ResultHolder<R>
  {
    @KeepForSdk
    private final Api<?> mApi;
    @KeepForSdk
    private final Api.AnyClientKey<A> mClientKey;
    
    @Deprecated
    @KeepForSdk
    protected ApiMethodImpl(@NonNull Api.AnyClientKey<A> paramAnyClientKey, @NonNull GoogleApiClient paramGoogleApiClient)
    {
      super();
      this.mClientKey = ((Api.AnyClientKey)Preconditions.checkNotNull(paramAnyClientKey));
      this.mApi = null;
    }
    
    @KeepForSdk
    protected ApiMethodImpl(@NonNull Api<?> paramApi, @NonNull GoogleApiClient paramGoogleApiClient)
    {
      super();
      Preconditions.checkNotNull(paramApi, "Api must not be null");
      this.mClientKey = paramApi.getClientKey();
      this.mApi = paramApi;
    }
    
    @VisibleForTesting
    @KeepForSdk
    protected ApiMethodImpl(@NonNull BasePendingResult.CallbackHandler<R> paramCallbackHandler)
    {
      super();
      this.mClientKey = null;
      this.mApi = null;
    }
    
    @KeepForSdk
    private void setFailedResult(@NonNull RemoteException paramRemoteException)
    {
      setFailedResult(new Status(8, paramRemoteException.getLocalizedMessage(), null));
    }
    
    @KeepForSdk
    protected abstract void doExecute(@NonNull A paramA)
      throws RemoteException;
    
    @KeepForSdk
    public final Api<?> getApi()
    {
      return this.mApi;
    }
    
    @KeepForSdk
    public final Api.AnyClientKey<A> getClientKey()
    {
      return this.mClientKey;
    }
    
    @KeepForSdk
    protected void onSetFailedResult(@NonNull R paramR) {}
    
    @KeepForSdk
    public final void run(@NonNull A paramA)
      throws DeadObjectException
    {
      Object localObject = paramA;
      if ((paramA instanceof SimpleClientAdapter)) {
        localObject = ((SimpleClientAdapter)paramA).getClient();
      }
      try
      {
        doExecute((Api.AnyClient)localObject);
        return;
      }
      catch (RemoteException paramA)
      {
        setFailedResult(paramA);
        return;
      }
      catch (DeadObjectException paramA)
      {
        setFailedResult(paramA);
        throw paramA;
      }
    }
    
    @KeepForSdk
    public final void setFailedResult(@NonNull Status paramStatus)
    {
      Preconditions.checkArgument(paramStatus.isSuccess() ^ true, "Failed result must not be success");
      paramStatus = createFailedResult(paramStatus);
      setResult(paramStatus);
      onSetFailedResult(paramStatus);
    }
  }
  
  @KeepForSdk
  public static abstract interface ResultHolder<R>
  {
    @KeepForSdk
    public abstract void setFailedResult(Status paramStatus);
    
    @KeepForSdk
    public abstract void setResult(R paramR);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\BaseImplementation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */