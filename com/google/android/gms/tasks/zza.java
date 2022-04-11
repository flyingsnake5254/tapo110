package com.google.android.gms.tasks;

import androidx.annotation.NonNull;

final class zza
  extends CancellationToken
{
  private final zzu<Void> zza = new zzu();
  
  public final void cancel()
  {
    this.zza.trySetResult(null);
  }
  
  public final boolean isCancellationRequested()
  {
    return this.zza.isComplete();
  }
  
  public final CancellationToken onCanceledRequested(@NonNull OnTokenCanceledListener paramOnTokenCanceledListener)
  {
    this.zza.addOnSuccessListener(new zzb(this, paramOnTokenCanceledListener));
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\tasks\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */