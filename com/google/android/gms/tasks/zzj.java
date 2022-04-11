package com.google.android.gms.tasks;

final class zzj
  implements Runnable
{
  zzj(zzi paramzzi, Task paramTask) {}
  
  public final void run()
  {
    synchronized (zzi.zza(this.zzm))
    {
      if (zzi.zzb(this.zzm) != null) {
        zzi.zzb(this.zzm).onComplete(this.zzg);
      }
      return;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\tasks\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */