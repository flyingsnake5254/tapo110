package com.google.android.gms.tasks;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

final class zzp
  implements Runnable
{
  zzp(zzo paramzzo, Task paramTask) {}
  
  public final void run()
  {
    try
    {
      Task localTask = zzo.zza(this.zzs).then(this.zzg.getResult());
      if (localTask == null)
      {
        this.zzs.onFailure(new NullPointerException("Continuation returned null"));
        return;
      }
      Executor localExecutor = TaskExecutors.zzw;
      localTask.addOnSuccessListener(localExecutor, this.zzs);
      localTask.addOnFailureListener(localExecutor, this.zzs);
      localTask.addOnCanceledListener(localExecutor, this.zzs);
      return;
    }
    catch (Exception localException)
    {
      this.zzs.onFailure(localException);
      return;
    }
    catch (CancellationException localCancellationException)
    {
      this.zzs.onCanceled();
      return;
    }
    catch (RuntimeExecutionException localRuntimeExecutionException)
    {
      if ((localRuntimeExecutionException.getCause() instanceof Exception))
      {
        this.zzs.onFailure((Exception)localRuntimeExecutionException.getCause());
        return;
      }
      this.zzs.onFailure(localRuntimeExecutionException);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\tasks\zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */