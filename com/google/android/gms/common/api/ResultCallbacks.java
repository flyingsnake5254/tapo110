package com.google.android.gms.common.api;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;

public abstract class ResultCallbacks<R extends Result>
  implements ResultCallback<R>
{
  public abstract void onFailure(@NonNull Status paramStatus);
  
  @KeepForSdk
  public final void onResult(@NonNull R paramR)
  {
    Status localStatus = paramR.getStatus();
    if (localStatus.isSuccess())
    {
      onSuccess(paramR);
      return;
    }
    onFailure(localStatus);
    if ((paramR instanceof Releasable)) {
      try
      {
        ((Releasable)paramR).release();
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        String str = String.valueOf(paramR);
        paramR = new StringBuilder(str.length() + 18);
        paramR.append("Unable to release ");
        paramR.append(str);
        Log.w("ResultCallbacks", paramR.toString(), localRuntimeException);
      }
    }
  }
  
  public abstract void onSuccess(@NonNull R paramR);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\ResultCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */