package com.google.android.gms.internal.mlkit_common;

import java.util.concurrent.Executor;

 enum zzr
  implements Executor
{
  static
  {
    zzr localzzr = new zzr("INSTANCE", 0);
    zza = localzzr;
    zzb = new zzr[] { localzzr };
  }
  
  public final void execute(Runnable paramRunnable)
  {
    paramRunnable.run();
  }
  
  public final String toString()
  {
    return "MoreExecutors.directExecutor()";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */