package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;

public class i0
  implements h
{
  public long a()
  {
    return SystemClock.uptimeMillis();
  }
  
  public r b(Looper paramLooper, @Nullable Handler.Callback paramCallback)
  {
    return new j0(new Handler(paramLooper, paramCallback));
  }
  
  public void c() {}
  
  public long elapsedRealtime()
  {
    return SystemClock.elapsedRealtime();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\util\i0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */