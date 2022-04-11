package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class zzf
  implements Runnable
{
  zzf(zze paramzze, Task paramTask) {}
  
  public final void run()
  {
    try
    {
      Task localTask = (Task)zze.zza(this.zzi).then(this.zzg);
      if (localTask == null)
      {
        this.zzi.onFailure(new NullPointerException("Continuation returned null"));
        return;
      }
      Executor localExecutor = TaskExecutors.zzw;
      localTask.addOnSuccessListener(localExecutor, this.zzi);
      localTask.addOnFailureListener(localExecutor, this.zzi);
      localTask.addOnCanceledListener(localExecutor, this.zzi);
      return;
    }
    catch (Exception localException)
    {
      zze.zzb(this.zzi).setException(localException);
      return;
    }
    catch (RuntimeExecutionException localRuntimeExecutionException)
    {
      if ((localRuntimeExecutionException.getCause() instanceof Exception))
      {
        zze.zzb(this.zzi).setException((Exception)localRuntimeExecutionException.getCause());
        return;
      }
      zze.zzb(this.zzi).setException(localRuntimeExecutionException);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\tasks\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */