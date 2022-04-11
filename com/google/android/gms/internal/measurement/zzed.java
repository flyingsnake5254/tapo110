package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

final class zzed
  implements Application.ActivityLifecycleCallbacks
{
  zzed(zzee paramzzee) {}
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    zzee.zzQ(this.zza, new zzdw(this, paramBundle, paramActivity));
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    zzee.zzQ(this.zza, new zzec(this, paramActivity));
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    zzee.zzQ(this.zza, new zzdz(this, paramActivity));
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    zzee.zzQ(this.zza, new zzdy(this, paramActivity));
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    zzbz localzzbz = new zzbz();
    zzee.zzQ(this.zza, new zzeb(this, paramActivity, localzzbz));
    paramActivity = localzzbz.zzd(50L);
    if (paramActivity != null) {
      paramBundle.putAll(paramActivity);
    }
  }
  
  public final void onActivityStarted(Activity paramActivity)
  {
    zzee.zzQ(this.zza, new zzdx(this, paramActivity));
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    zzee.zzQ(this.zza, new zzea(this, paramActivity));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */