package com.google.android.datatransport.runtime.synchronization;

import androidx.annotation.WorkerThread;

@WorkerThread
public abstract interface a
{
  public abstract <T> T a(a<T> parama);
  
  public static abstract interface a<T>
  {
    public abstract T execute();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\runtime\synchronization\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */