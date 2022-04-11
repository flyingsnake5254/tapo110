package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public class RegistrationMethods<A extends Api.AnyClient, L>
{
  public final RegisterListenerMethod<A, L> zajz;
  public final UnregisterListenerMethod<A, L> zaka;
  
  private RegistrationMethods(RegisterListenerMethod<A, L> paramRegisterListenerMethod, UnregisterListenerMethod<A, L> paramUnregisterListenerMethod)
  {
    this.zajz = paramRegisterListenerMethod;
    this.zaka = paramUnregisterListenerMethod;
  }
  
  @KeepForSdk
  public static <A extends Api.AnyClient, L> Builder<A, L> builder()
  {
    return new Builder(null);
  }
  
  @KeepForSdk
  public static class Builder<A extends Api.AnyClient, L>
  {
    private boolean zajw = true;
    private RemoteCall<A, TaskCompletionSource<Void>> zakb;
    private RemoteCall<A, TaskCompletionSource<Boolean>> zakc;
    private ListenerHolder<L> zakd;
    private Feature[] zake;
    
    @KeepForSdk
    public RegistrationMethods<A, L> build()
    {
      RemoteCall localRemoteCall = this.zakb;
      boolean bool1 = true;
      boolean bool2;
      if (localRemoteCall != null) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      Preconditions.checkArgument(bool2, "Must set register function");
      if (this.zakc != null) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      Preconditions.checkArgument(bool2, "Must set unregister function");
      if (this.zakd != null) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
      Preconditions.checkArgument(bool2, "Must set holder");
      return new RegistrationMethods(new zaca(this, this.zakd, this.zake, this.zajw), new zacb(this, this.zakd.getListenerKey()), null);
    }
    
    @KeepForSdk
    public Builder<A, L> register(RemoteCall<A, TaskCompletionSource<Void>> paramRemoteCall)
    {
      this.zakb = paramRemoteCall;
      return this;
    }
    
    @Deprecated
    @KeepForSdk
    public Builder<A, L> register(BiConsumer<A, TaskCompletionSource<Void>> paramBiConsumer)
    {
      this.zakb = new zaby(paramBiConsumer);
      return this;
    }
    
    @KeepForSdk
    public Builder<A, L> setAutoResolveMissingFeatures(boolean paramBoolean)
    {
      this.zajw = paramBoolean;
      return this;
    }
    
    @KeepForSdk
    public Builder<A, L> setFeatures(Feature[] paramArrayOfFeature)
    {
      this.zake = paramArrayOfFeature;
      return this;
    }
    
    @KeepForSdk
    public Builder<A, L> unregister(RemoteCall<A, TaskCompletionSource<Boolean>> paramRemoteCall)
    {
      this.zakc = paramRemoteCall;
      return this;
    }
    
    @Deprecated
    @KeepForSdk
    public Builder<A, L> unregister(BiConsumer<A, TaskCompletionSource<Boolean>> paramBiConsumer)
    {
      this.zakb = new zabz(this);
      return this;
    }
    
    @KeepForSdk
    public Builder<A, L> withHolder(ListenerHolder<L> paramListenerHolder)
    {
      this.zakd = paramListenerHolder;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\RegistrationMethods.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */