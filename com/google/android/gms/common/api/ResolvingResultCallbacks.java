package com.google.android.gms.common.api;

import android.app.Activity;
import android.content.IntentSender.SendIntentException;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

public abstract class ResolvingResultCallbacks<R extends Result>
  extends ResultCallbacks<R>
{
  private final Activity mActivity;
  private final int zzao;
  
  protected ResolvingResultCallbacks(@NonNull Activity paramActivity, int paramInt)
  {
    this.mActivity = ((Activity)Preconditions.checkNotNull(paramActivity, "Activity must not be null"));
    this.zzao = paramInt;
  }
  
  @KeepForSdk
  public final void onFailure(@NonNull Status paramStatus)
  {
    if (paramStatus.hasResolution()) {
      try
      {
        paramStatus.startResolutionForResult(this.mActivity, this.zzao);
        return;
      }
      catch (IntentSender.SendIntentException paramStatus)
      {
        Log.e("ResolvingResultCallback", "Failed to start resolution", paramStatus);
        onUnresolvableFailure(new Status(8));
        return;
      }
    }
    onUnresolvableFailure(paramStatus);
  }
  
  public abstract void onSuccess(@NonNull R paramR);
  
  public abstract void onUnresolvableFailure(@NonNull Status paramStatus);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\ResolvingResultCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */