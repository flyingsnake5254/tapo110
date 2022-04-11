package com.google.android.gms.vision;

import android.annotation.SuppressLint;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class L
{
  @KeepForSdk
  public static final String TAG = "Vision";
  
  @KeepForSdk
  public static int d(String paramString, Object... paramVarArgs)
  {
    if (Log.isLoggable("Vision", 3)) {
      return Log.d("Vision", String.format(paramString, paramVarArgs));
    }
    return 0;
  }
  
  @KeepForSdk
  public static int d(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    if (Log.isLoggable("Vision", 3)) {
      return Log.d("Vision", String.format(paramString, paramVarArgs), paramThrowable);
    }
    return 0;
  }
  
  @KeepForSdk
  public static int e(String paramString, Object... paramVarArgs)
  {
    if (Log.isLoggable("Vision", 6)) {
      return Log.e("Vision", String.format(paramString, paramVarArgs));
    }
    return 0;
  }
  
  @SuppressLint({"LogTagMismatch"})
  @KeepForSdk
  public static int e(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    if (Log.isLoggable("Vision", 6))
    {
      if (Log.isLoggable("Vision", 3)) {
        return Log.e("Vision", String.format(paramString, paramVarArgs), paramThrowable);
      }
      paramString = String.format(paramString, paramVarArgs);
      paramThrowable = String.valueOf(paramThrowable);
      paramVarArgs = new StringBuilder(String.valueOf(paramString).length() + 2 + paramThrowable.length());
      paramVarArgs.append(paramString);
      paramVarArgs.append(": ");
      paramVarArgs.append(paramThrowable);
      return Log.e("Vision", paramVarArgs.toString());
    }
    return 0;
  }
  
  @KeepForSdk
  public static int i(String paramString, Object... paramVarArgs)
  {
    if (Log.isLoggable("Vision", 4)) {
      return Log.i("Vision", String.format(paramString, paramVarArgs));
    }
    return 0;
  }
  
  @KeepForSdk
  public static int v(String paramString, Object... paramVarArgs)
  {
    if (Log.isLoggable("Vision", 2)) {
      return Log.v("Vision", String.format(paramString, paramVarArgs));
    }
    return 0;
  }
  
  @KeepForSdk
  public static int w(String paramString, Object... paramVarArgs)
  {
    if (Log.isLoggable("Vision", 5)) {
      return Log.w("Vision", String.format(paramString, paramVarArgs));
    }
    return 0;
  }
  
  @SuppressLint({"LogTagMismatch"})
  @KeepForSdk
  public static int w(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    if (Log.isLoggable("Vision", 5))
    {
      if (Log.isLoggable("Vision", 3)) {
        return Log.w("Vision", String.format(paramString, paramVarArgs), paramThrowable);
      }
      paramString = String.format(paramString, paramVarArgs);
      paramThrowable = String.valueOf(paramThrowable);
      paramVarArgs = new StringBuilder(String.valueOf(paramString).length() + 2 + paramThrowable.length());
      paramVarArgs.append(paramString);
      paramVarArgs.append(": ");
      paramVarArgs.append(paramThrowable);
      return Log.w("Vision", paramVarArgs.toString());
    }
    return 0;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\vision\L.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */