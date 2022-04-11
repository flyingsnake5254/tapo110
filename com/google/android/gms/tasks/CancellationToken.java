package com.google.android.gms.tasks;

import androidx.annotation.NonNull;

public abstract class CancellationToken
{
  public abstract boolean isCancellationRequested();
  
  public abstract CancellationToken onCanceledRequested(@NonNull OnTokenCanceledListener paramOnTokenCanceledListener);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\tasks\CancellationToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */