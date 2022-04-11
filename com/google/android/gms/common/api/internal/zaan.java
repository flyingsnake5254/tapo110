package com.google.android.gms.common.api.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.GoogleApiAvailabilityCache;
import com.google.android.gms.signin.zad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;

final class zaan
  extends zaau
{
  private final Map<Api.Client, zaam> zagl;
  
  public zaan(Map<Api.Client, zaam> paramMap)
  {
    super(paramMap, null);
    Map localMap;
    this.zagl = localMap;
  }
  
  @WorkerThread
  @GuardedBy("mLock")
  public final void zaan()
  {
    Object localObject1 = new GoogleApiAvailabilityCache(zaak.zab(this.zagj));
    Object localObject2 = new ArrayList();
    Object localObject3 = new ArrayList();
    Iterator localIterator = this.zagl.keySet().iterator();
    Api.Client localClient;
    while (localIterator.hasNext())
    {
      localClient = (Api.Client)localIterator.next();
      if ((localClient.requiresGooglePlayServices()) && (!zaam.zaa((zaam)this.zagl.get(localClient)))) {
        ((List)localObject2).add(localClient);
      } else {
        ((List)localObject3).add(localClient);
      }
    }
    int i = -1;
    boolean bool = ((List)localObject2).isEmpty();
    int j = 0;
    int k = 0;
    int m;
    if (bool)
    {
      m = ((ArrayList)localObject3).size();
      do
      {
        if (k >= m) {
          break;
        }
        localObject2 = ((ArrayList)localObject3).get(k);
        k++;
        localObject2 = (Api.Client)localObject2;
        j = ((GoogleApiAvailabilityCache)localObject1).getClientAvailability(zaak.zaa(this.zagj), (Api.Client)localObject2);
        i = j;
      } while (j != 0);
      i = j;
    }
    else
    {
      m = ((ArrayList)localObject2).size();
      k = j;
      while (k < m)
      {
        localObject3 = ((ArrayList)localObject2).get(k);
        k++;
        localObject3 = (Api.Client)localObject3;
        j = ((GoogleApiAvailabilityCache)localObject1).getClientAvailability(zaak.zaa(this.zagj), (Api.Client)localObject3);
        i = j;
        if (j != 0) {
          i = j;
        }
      }
    }
    if (i != 0)
    {
      localObject1 = new ConnectionResult(i, null);
      zaak.zad(this.zagj).zaa(new zaao(this, this.zagj, (ConnectionResult)localObject1));
      return;
    }
    if ((zaak.zae(this.zagj)) && (zaak.zaf(this.zagj) != null)) {
      zaak.zaf(this.zagj).connect();
    }
    localObject2 = this.zagl.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localClient = (Api.Client)((Iterator)localObject2).next();
      localObject3 = (BaseGmsClient.ConnectionProgressReportCallbacks)this.zagl.get(localClient);
      if ((localClient.requiresGooglePlayServices()) && (((GoogleApiAvailabilityCache)localObject1).getClientAvailability(zaak.zaa(this.zagj), localClient) != 0)) {
        zaak.zad(this.zagj).zaa(new zaap(this, this.zagj, (BaseGmsClient.ConnectionProgressReportCallbacks)localObject3));
      } else {
        localClient.connect((BaseGmsClient.ConnectionProgressReportCallbacks)localObject3);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\zaan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */