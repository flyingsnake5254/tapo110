package androidx.core.os;

import android.os.Build.VERSION;
import android.os.Trace;
import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class TraceCompat
{
  private static final String TAG = "TraceCompat";
  private static Method sAsyncTraceBeginMethod;
  private static Method sAsyncTraceEndMethod;
  private static Method sIsTagEnabledMethod;
  private static Method sTraceCounterMethod;
  private static long sTraceTagApp;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if ((i >= 18) && (i < 29)) {
      try
      {
        sTraceTagApp = Trace.class.getField("TRACE_TAG_APP").getLong(null);
        Class localClass1 = Long.TYPE;
        sIsTagEnabledMethod = Trace.class.getMethod("isTagEnabled", new Class[] { localClass1 });
        Class localClass2 = Integer.TYPE;
        sAsyncTraceBeginMethod = Trace.class.getMethod("asyncTraceBegin", new Class[] { localClass1, String.class, localClass2 });
        sAsyncTraceEndMethod = Trace.class.getMethod("asyncTraceEnd", new Class[] { localClass1, String.class, localClass2 });
        sTraceCounterMethod = Trace.class.getMethod("traceCounter", new Class[] { localClass1, String.class, localClass2 });
      }
      catch (Exception localException)
      {
        Log.i("TraceCompat", "Unable to initialize via reflection.", localException);
      }
    }
  }
  
  public static void beginAsyncSection(@NonNull String paramString, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 29) {
      Trace.beginAsyncSection(paramString, paramInt);
    } else if (i >= 18) {
      try
      {
        sAsyncTraceBeginMethod.invoke(null, new Object[] { Long.valueOf(sTraceTagApp), paramString, Integer.valueOf(paramInt) });
      }
      catch (Exception paramString)
      {
        Log.v("TraceCompat", "Unable to invoke asyncTraceBegin() via reflection.");
      }
    }
  }
  
  public static void beginSection(@NonNull String paramString)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      Trace.beginSection(paramString);
    }
  }
  
  public static void endAsyncSection(@NonNull String paramString, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 29) {
      Trace.endAsyncSection(paramString, paramInt);
    } else if (i >= 18) {
      try
      {
        sAsyncTraceEndMethod.invoke(null, new Object[] { Long.valueOf(sTraceTagApp), paramString, Integer.valueOf(paramInt) });
      }
      catch (Exception paramString)
      {
        Log.v("TraceCompat", "Unable to invoke endAsyncSection() via reflection.");
      }
    }
  }
  
  public static void endSection()
  {
    if (Build.VERSION.SDK_INT >= 18) {
      Trace.endSection();
    }
  }
  
  public static boolean isEnabled()
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 29) {
      return Trace.isEnabled();
    }
    if (i >= 18) {
      try
      {
        boolean bool = ((Boolean)sIsTagEnabledMethod.invoke(null, new Object[] { Long.valueOf(sTraceTagApp) })).booleanValue();
        return bool;
      }
      catch (Exception localException)
      {
        Log.v("TraceCompat", "Unable to invoke isTagEnabled() via reflection.");
      }
    }
    return false;
  }
  
  public static void setCounter(@NonNull String paramString, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 29) {
      Trace.setCounter(paramString, paramInt);
    } else if (i >= 18) {
      try
      {
        sTraceCounterMethod.invoke(null, new Object[] { Long.valueOf(sTraceTagApp), paramString, Integer.valueOf(paramInt) });
      }
      catch (Exception paramString)
      {
        Log.v("TraceCompat", "Unable to invoke traceCounter() via reflection.");
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\os\TraceCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */