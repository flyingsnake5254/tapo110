package com.google.android.gms.tasks;

import androidx.annotation.NonNull;

abstract interface zzq<TResult>
{
  public abstract void cancel();
  
  public abstract void onComplete(@NonNull Task<TResult> paramTask);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\tasks\zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */