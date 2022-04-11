package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

final class zav
  implements zabt
{
  private zav(zas paramzas) {}
  
  public final void zab(int paramInt, boolean paramBoolean)
  {
    zas.zaa(this.zaeq).lock();
    try
    {
      if (zas.zac(this.zaeq))
      {
        zas.zaa(this.zaeq, false);
        zas.zaa(this.zaeq, paramInt, paramBoolean);
        return;
      }
      zas.zaa(this.zaeq, true);
      zas.zaf(this.zaeq).onConnectionSuspended(paramInt);
      return;
    }
    finally
    {
      zas.zaa(this.zaeq).unlock();
    }
  }
  
  public final void zab(@Nullable Bundle paramBundle)
  {
    zas.zaa(this.zaeq).lock();
    try
    {
      zas.zab(this.zaeq, ConnectionResult.RESULT_SUCCESS);
      zas.zab(this.zaeq);
      return;
    }
    finally
    {
      zas.zaa(this.zaeq).unlock();
    }
  }
  
  public final void zac(@NonNull ConnectionResult paramConnectionResult)
  {
    zas.zaa(this.zaeq).lock();
    try
    {
      zas.zab(this.zaeq, paramConnectionResult);
      zas.zab(this.zaeq);
      return;
    }
    finally
    {
      zas.zaa(this.zaeq).unlock();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\zav.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */