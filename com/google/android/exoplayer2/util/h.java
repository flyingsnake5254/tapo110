package com.google.android.exoplayer2.util;

import android.os.Handler.Callback;
import android.os.Looper;
import androidx.annotation.Nullable;

public abstract interface h
{
  public static final h a = new i0();
  
  public abstract long a();
  
  public abstract r b(Looper paramLooper, @Nullable Handler.Callback paramCallback);
  
  public abstract void c();
  
  public abstract long elapsedRealtime();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\util\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */