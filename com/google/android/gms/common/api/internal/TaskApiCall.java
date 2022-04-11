package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public abstract class TaskApiCall<A extends Api.AnyClient, ResultT>
{
  private final Feature[] zake;
  private final boolean zakl;
  
  @Deprecated
  @KeepForSdk
  public TaskApiCall()
  {
    this.zake = null;
    this.zakl = false;
  }
  
  @KeepForSdk
  private TaskApiCall(Feature[] paramArrayOfFeature, boolean paramBoolean)
  {
    this.zake = paramArrayOfFeature;
    this.zakl = paramBoolean;
  }
  
  @KeepForSdk
  public static <A extends Api.AnyClient, ResultT> Builder<A, ResultT> builder()
  {
    return new Builder(null);
  }
  
  @KeepForSdk
  protected abstract void doExecute(A paramA, TaskCompletionSource<ResultT> paramTaskCompletionSource)
    throws RemoteException;
  
  @KeepForSdk
  public boolean shouldAutoResolveMissingFeatures()
  {
    return this.zakl;
  }
  
  @Nullable
  public final Feature[] zabt()
  {
    return this.zake;
  }
  
  @KeepForSdk
  public static class Builder<A extends Api.AnyClient, ResultT>
  {
    private Feature[] zake;
    private boolean zakl = true;
    private RemoteCall<A, TaskCompletionSource<ResultT>> zakm;
    
    @KeepForSdk
    public TaskApiCall<A, ResultT> build()
    {
      boolean bool;
      if (this.zakm != null) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "execute parameter required");
      return new zack(this, this.zake, this.zakl);
    }
    
    @Deprecated
    @KeepForSdk
    public Builder<A, ResultT> execute(BiConsumer<A, TaskCompletionSource<ResultT>> paramBiConsumer)
    {
      this.zakm = new zacj(paramBiConsumer);
      return this;
    }
    
    @KeepForSdk
    public Builder<A, ResultT> run(RemoteCall<A, TaskCompletionSource<ResultT>> paramRemoteCall)
    {
      this.zakm = paramRemoteCall;
      return this;
    }
    
    @KeepForSdk
    public Builder<A, ResultT> setAutoResolveMissingFeatures(boolean paramBoolean)
    {
      this.zakl = paramBoolean;
      return this;
    }
    
    @KeepForSdk
    public Builder<A, ResultT> setFeatures(Feature... paramVarArgs)
    {
      this.zake = paramVarArgs;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\TaskApiCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */