package com.google.android.gms.tasks;

import androidx.annotation.NonNull;

public abstract interface Continuation<TResult, TContinuationResult>
{
  public abstract TContinuationResult then(@NonNull Task<TResult> paramTask)
    throws Exception;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\tasks\Continuation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */