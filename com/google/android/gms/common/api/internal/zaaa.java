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

final class zaaa
  implements OnCompleteListener<Map<zai<?>, String>>
{
  private SignInConnectionListener zafj;
  
  zaaa(zax paramzax, SignInConnectionListener paramSignInConnectionListener)
  {
    this.zafj = paramSignInConnectionListener;
  }
  
  final void cancel()
  {
    this.zafj.onComplete();
  }
  
  public final void onComplete(@NonNull Task<Map<zai<?>, String>> paramTask)
  {
    zax.zaa(this.zafi).lock();
    try
    {
      if (!zax.zab(this.zafi))
      {
        this.zafj.onComplete();
        return;
      }
      Object localObject1;
      if (paramTask.isSuccessful())
      {
        localObject1 = this.zafi;
        paramTask = new androidx/collection/ArrayMap;
        paramTask.<init>(zax.zam((zax)localObject1).size());
        zax.zab((zax)localObject1, paramTask);
        paramTask = zax.zam(this.zafi).values().iterator();
        while (paramTask.hasNext())
        {
          localObject1 = (zaw)paramTask.next();
          zax.zag(this.zafi).put(((GoogleApi)localObject1).zak(), ConnectionResult.RESULT_SUCCESS);
        }
      }
      if ((paramTask.getException() instanceof AvailabilityException))
      {
        paramTask = (AvailabilityException)paramTask.getException();
        if (zax.zae(this.zafi))
        {
          Object localObject2 = this.zafi;
          localObject1 = new androidx/collection/ArrayMap;
          ((ArrayMap)localObject1).<init>(zax.zam((zax)localObject2).size());
          zax.zab((zax)localObject2, (Map)localObject1);
          localObject2 = zax.zam(this.zafi).values().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (zaw)((Iterator)localObject2).next();
            localObject1 = ((GoogleApi)localObject3).zak();
            ConnectionResult localConnectionResult = paramTask.getConnectionResult((GoogleApi)localObject3);
            if (zax.zaa(this.zafi, (zaw)localObject3, localConnectionResult))
            {
              localObject3 = zax.zag(this.zafi);
              localConnectionResult = new com/google/android/gms/common/ConnectionResult;
              localConnectionResult.<init>(16);
              ((Map)localObject3).put(localObject1, localConnectionResult);
            }
            else
            {
              zax.zag(this.zafi).put(localObject1, localConnectionResult);
            }
          }
        }
        zax.zab(this.zafi, paramTask.zaj());
      }
      else
      {
        Log.e("ConnectionlessGAC", "Unexpected availability exception", paramTask.getException());
        zax.zab(this.zafi, Collections.emptyMap());
      }
      if (this.zafi.isConnected())
      {
        zax.zad(this.zafi).putAll(zax.zag(this.zafi));
        if (zax.zaf(this.zafi) == null)
        {
          zax.zai(this.zafi);
          zax.zaj(this.zafi);
          zax.zal(this.zafi).signalAll();
        }
      }
      this.zafj.onComplete();
      return;
    }
    finally
    {
      zax.zaa(this.zafi).unlock();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\zaaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */