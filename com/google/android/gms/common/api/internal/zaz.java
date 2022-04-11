package com.google.android.gms.common.api.internal;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

final class zaz
  implements OnCompleteListener<Map<zai<?>, String>>
{
  private zaz(zax paramzax) {}
  
  public final void onComplete(@NonNull Task<Map<zai<?>, String>> paramTask)
  {
    zax.zaa(this.zafi).lock();
    try
    {
      boolean bool = zax.zab(this.zafi);
      if (!bool) {
        return;
      }
      Object localObject1;
      if (paramTask.isSuccessful())
      {
        paramTask = this.zafi;
        localObject1 = new androidx/collection/ArrayMap;
        ((ArrayMap)localObject1).<init>(zax.zac(paramTask).size());
        zax.zaa(paramTask, (Map)localObject1);
        localObject1 = zax.zac(this.zafi).values().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          paramTask = (zaw)((Iterator)localObject1).next();
          zax.zad(this.zafi).put(paramTask.zak(), ConnectionResult.RESULT_SUCCESS);
        }
      }
      if ((paramTask.getException() instanceof AvailabilityException))
      {
        paramTask = (AvailabilityException)paramTask.getException();
        if (zax.zae(this.zafi))
        {
          Object localObject2 = this.zafi;
          localObject1 = new androidx/collection/ArrayMap;
          ((ArrayMap)localObject1).<init>(zax.zac((zax)localObject2).size());
          zax.zaa((zax)localObject2, (Map)localObject1);
          localObject2 = zax.zac(this.zafi).values().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (zaw)((Iterator)localObject2).next();
            localObject1 = ((GoogleApi)localObject3).zak();
            Object localObject4 = paramTask.getConnectionResult((GoogleApi)localObject3);
            if (zax.zaa(this.zafi, (zaw)localObject3, (ConnectionResult)localObject4))
            {
              localObject4 = zax.zad(this.zafi);
              localObject3 = new com/google/android/gms/common/ConnectionResult;
              ((ConnectionResult)localObject3).<init>(16);
              ((Map)localObject4).put(localObject1, localObject3);
            }
            else
            {
              zax.zad(this.zafi).put(localObject1, localObject4);
            }
          }
        }
        zax.zaa(this.zafi, paramTask.zaj());
        paramTask = this.zafi;
        zax.zaa(paramTask, zax.zaf(paramTask));
      }
      else
      {
        Log.e("ConnectionlessGAC", "Unexpected availability exception", paramTask.getException());
        zax.zaa(this.zafi, Collections.emptyMap());
        localObject1 = this.zafi;
        paramTask = new com/google/android/gms/common/ConnectionResult;
        paramTask.<init>(8);
        zax.zaa((zax)localObject1, paramTask);
      }
      if (zax.zag(this.zafi) != null)
      {
        zax.zad(this.zafi).putAll(zax.zag(this.zafi));
        paramTask = this.zafi;
        zax.zaa(paramTask, zax.zaf(paramTask));
      }
      if (zax.zah(this.zafi) == null)
      {
        zax.zai(this.zafi);
        zax.zaj(this.zafi);
      }
      else
      {
        zax.zaa(this.zafi, false);
        zax.zak(this.zafi).zac(zax.zah(this.zafi));
      }
      zax.zal(this.zafi).signalAll();
      return;
    }
    finally
    {
      zax.zaa(this.zafi).unlock();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\zaz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */