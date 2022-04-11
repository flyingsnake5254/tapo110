package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;

public final class zaf
  extends zad<Void>
{
  private final RegisterListenerMethod<Api.AnyClient, ?> zacp;
  private final UnregisterListenerMethod<Api.AnyClient, ?> zacq;
  
  public zaf(zabw paramzabw, TaskCompletionSource<Void> paramTaskCompletionSource)
  {
    super(3, paramTaskCompletionSource);
    this.zacp = paramzabw.zajx;
    this.zacq = paramzabw.zajy;
  }
  
  @Nullable
  public final Feature[] zab(GoogleApiManager.zaa<?> paramzaa)
  {
    return this.zacp.getRequiredFeatures();
  }
  
  public final boolean zac(GoogleApiManager.zaa<?> paramzaa)
  {
    return this.zacp.shouldAutoResolveMissingFeatures();
  }
  
  public final void zad(GoogleApiManager.zaa<?> paramzaa)
    throws RemoteException
  {
    this.zacp.registerListener(paramzaa.zaab(), this.zacn);
    if (this.zacp.getListenerKey() != null) {
      paramzaa.zabk().put(this.zacp.getListenerKey(), new zabw(this.zacp, this.zacq));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\zaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */