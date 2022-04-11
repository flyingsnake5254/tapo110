package com.google.android.gms.tasks;

final class zzl
  implements Runnable
{
  zzl(zzk paramzzk, Task paramTask) {}
  
  public final void run()
  {
    synchronized (zzk.zza(this.zzo))
    {
      if (zzk.zzb(this.zzo) != null) {
        zzk.zzb(this.zzo).onFailure(this.zzg.getException());
      }
      return;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\tasks\zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */