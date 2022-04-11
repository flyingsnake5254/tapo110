package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class zacp
{
  public static final Status zakx = new Status(8, "The connection to Google Play services was lost");
  private static final BasePendingResult<?>[] zaky = new BasePendingResult[0];
  private final Map<Api.AnyClientKey<?>, Api.Client> zagz;
  @VisibleForTesting
  final Set<BasePendingResult<?>> zakz = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
  private final zacs zala = new zacq(this);
  
  public zacp(Map<Api.AnyClientKey<?>, Api.Client> paramMap)
  {
    this.zagz = paramMap;
  }
  
  public final void release()
  {
    BasePendingResult[] arrayOfBasePendingResult = (BasePendingResult[])this.zakz.toArray(zaky);
    int i = arrayOfBasePendingResult.length;
    int j = 0;
    BasePendingResult localBasePendingResult;
    for (;;)
    {
      if (j >= i) {
        return;
      }
      localBasePendingResult = arrayOfBasePendingResult[j];
      localBasePendingResult.zaa(null);
      IBinder localIBinder;
      zacr localzacr;
      if (localBasePendingResult.zam() == null)
      {
        if (localBasePendingResult.zat()) {
          this.zakz.remove(localBasePendingResult);
        }
      }
      else
      {
        localBasePendingResult.setResultCallback(null);
        localIBinder = ((Api.Client)this.zagz.get(((BaseImplementation.ApiMethodImpl)localBasePendingResult).getClientKey())).getServiceBrokerBinder();
        if (localBasePendingResult.isReady())
        {
          localBasePendingResult.zaa(new zacr(localBasePendingResult, null, localIBinder, null));
        }
        else
        {
          if ((localIBinder == null) || (!localIBinder.isBinderAlive())) {
            break;
          }
          localzacr = new zacr(localBasePendingResult, null, localIBinder, null);
          localBasePendingResult.zaa(localzacr);
        }
      }
      try
      {
        localIBinder.linkToDeath(localzacr, 0);
        this.zakz.remove(localBasePendingResult);
        j++;
      }
      catch (RemoteException localRemoteException)
      {
        localBasePendingResult.cancel();
        localBasePendingResult.zam().intValue();
        throw null;
      }
    }
    localBasePendingResult.zaa(null);
    localBasePendingResult.cancel();
    localBasePendingResult.zam().intValue();
    throw null;
  }
  
  final void zab(BasePendingResult<? extends Result> paramBasePendingResult)
  {
    this.zakz.add(paramBasePendingResult);
    paramBasePendingResult.zaa(this.zala);
  }
  
  public final void zabx()
  {
    BasePendingResult[] arrayOfBasePendingResult = (BasePendingResult[])this.zakz.toArray(zaky);
    int i = arrayOfBasePendingResult.length;
    for (int j = 0; j < i; j++) {
      arrayOfBasePendingResult[j].zab(zakx);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\zacp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */