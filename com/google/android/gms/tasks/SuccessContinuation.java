package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract interface SuccessContinuation<TResult, TContinuationResult>
{
  @NonNull
  public abstract Task<TContinuationResult> then(@Nullable TResult paramTResult)
    throws Exception;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\tasks\SuccessContinuation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */