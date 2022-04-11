package androidx.core.os;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class HandlerCompat
{
  private static final String TAG = "HandlerCompat";
  
  @NonNull
  public static Handler createAsync(@NonNull Looper paramLooper)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 28) {
      return Handler.createAsync(paramLooper);
    }
    if (i >= 16) {
      try
      {
        Handler localHandler = (Handler)Handler.class.getDeclaredConstructor(new Class[] { Looper.class, Handler.Callback.class, Boolean.TYPE }).newInstance(new Object[] { paramLooper, null, Boolean.TRUE });
        return localHandler;
      }
      catch (InvocationTargetException paramLooper)
      {
        paramLooper = paramLooper.getCause();
        if (!(paramLooper instanceof RuntimeException))
        {
          if ((paramLooper instanceof Error)) {
            throw ((Error)paramLooper);
          }
          throw new RuntimeException(paramLooper);
        }
        throw ((RuntimeException)paramLooper);
      }
      catch (IllegalAccessException|InstantiationException|NoSuchMethodException localIllegalAccessException)
      {
        Log.v("HandlerCompat", "Unable to invoke Handler(Looper, Callback, boolean) constructor");
      }
    }
    return new Handler(paramLooper);
  }
  
  @NonNull
  public static Handler createAsync(@NonNull Looper paramLooper, @NonNull Handler.Callback paramCallback)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 28) {
      return Handler.createAsync(paramLooper, paramCallback);
    }
    if (i >= 16) {
      try
      {
        Handler localHandler = (Handler)Handler.class.getDeclaredConstructor(new Class[] { Looper.class, Handler.Callback.class, Boolean.TYPE }).newInstance(new Object[] { paramLooper, paramCallback, Boolean.TRUE });
        return localHandler;
      }
      catch (InvocationTargetException paramLooper)
      {
        paramLooper = paramLooper.getCause();
        if (!(paramLooper instanceof RuntimeException))
        {
          if ((paramLooper instanceof Error)) {
            throw ((Error)paramLooper);
          }
          throw new RuntimeException(paramLooper);
        }
        throw ((RuntimeException)paramLooper);
      }
      catch (IllegalAccessException|InstantiationException|NoSuchMethodException localIllegalAccessException)
      {
        Log.v("HandlerCompat", "Unable to invoke Handler(Looper, Callback, boolean) constructor");
      }
    }
    return new Handler(paramLooper, paramCallback);
  }
  
  public static boolean postDelayed(@NonNull Handler paramHandler, @NonNull Runnable paramRunnable, @Nullable Object paramObject, long paramLong)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramHandler.postDelayed(paramRunnable, paramObject, paramLong);
    }
    paramRunnable = Message.obtain(paramHandler, paramRunnable);
    paramRunnable.obj = paramObject;
    return paramHandler.sendMessageDelayed(paramRunnable, paramLong);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\os\HandlerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */