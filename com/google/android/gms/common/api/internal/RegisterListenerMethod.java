package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public abstract class RegisterListenerMethod<A extends Api.AnyClient, L>
{
  private final ListenerHolder<L> zaju;
  private final Feature[] zajv;
  private final boolean zajw;
  
  @KeepForSdk
  protected RegisterListenerMethod(ListenerHolder<L> paramListenerHolder)
  {
    this.zaju = paramListenerHolder;
    this.zajv = null;
    this.zajw = false;
  }
  
  @KeepForSdk
  protected RegisterListenerMethod(ListenerHolder<L> paramListenerHolder, Feature[] paramArrayOfFeature, boolean paramBoolean)
  {
    this.zaju = paramListenerHolder;
    this.zajv = paramArrayOfFeature;
    this.zajw = paramBoolean;
  }
  
  @KeepForSdk
  public void clearListener()
  {
    this.zaju.clear();
  }
  
  @KeepForSdk
  public ListenerHolder.ListenerKey<L> getListenerKey()
  {
    return this.zaju.getListenerKey();
  }
  
  @Nullable
  @KeepForSdk
  public Feature[] getRequiredFeatures()
  {
    return this.zajv;
  }
  
  @KeepForSdk
  protected abstract void registerListener(A paramA, TaskCompletionSource<Void> paramTaskCompletionSource)
    throws RemoteException;
  
  public final boolean shouldAutoResolveMissingFeatures()
  {
    return this.zajw;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\RegisterListenerMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */