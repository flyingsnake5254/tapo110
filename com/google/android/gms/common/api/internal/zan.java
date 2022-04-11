package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Dialog;
import androidx.annotation.MainThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;

final class zan
  implements Runnable
{
  private final zam zadj;
  
  zan(zal paramzal, zam paramzam)
  {
    this.zadj = paramzam;
  }
  
  @MainThread
  public final void run()
  {
    if (!this.zadk.mStarted) {
      return;
    }
    Object localObject1 = this.zadj.getConnectionResult();
    Object localObject2;
    if (((ConnectionResult)localObject1).hasResolution())
    {
      localObject2 = this.zadk;
      ((LifecycleCallback)localObject2).mLifecycleFragment.startActivityForResult(GoogleApiActivity.zaa(((LifecycleCallback)localObject2).getActivity(), ((ConnectionResult)localObject1).getResolution(), this.zadj.zar(), false), 1);
      return;
    }
    if (this.zadk.zacd.isUserResolvableError(((ConnectionResult)localObject1).getErrorCode()))
    {
      localObject2 = this.zadk;
      ((zal)localObject2).zacd.zaa(((LifecycleCallback)localObject2).getActivity(), this.zadk.mLifecycleFragment, ((ConnectionResult)localObject1).getErrorCode(), 2, this.zadk);
      return;
    }
    if (((ConnectionResult)localObject1).getErrorCode() == 18)
    {
      localObject2 = GoogleApiAvailability.zaa(this.zadk.getActivity(), this.zadk);
      localObject1 = this.zadk;
      ((zal)localObject1).zacd.zaa(((LifecycleCallback)localObject1).getActivity().getApplicationContext(), new zao(this, (Dialog)localObject2));
      return;
    }
    this.zadk.zaa((ConnectionResult)localObject1, this.zadj.zar());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\zan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */