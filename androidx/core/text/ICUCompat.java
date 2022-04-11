package androidx.core.text;

import android.icu.util.ULocale;
import android.os.Build.VERSION;
import android.util.Log;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public final class ICUCompat
{
  private static final String TAG = "ICUCompat";
  private static Method sAddLikelySubtagsMethod;
  private static Method sGetScriptMethod;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i < 21) {
      try
      {
        Class localClass = Class.forName("libcore.icu.ICU");
        sGetScriptMethod = localClass.getMethod("getScript", new Class[] { String.class });
        sAddLikelySubtagsMethod = localClass.getMethod("addLikelySubtags", new Class[] { String.class });
      }
      catch (Exception localException1)
      {
        sGetScriptMethod = null;
        sAddLikelySubtagsMethod = null;
        Log.w("ICUCompat", localException1);
      }
    } else if (i < 24) {
      try
      {
        sAddLikelySubtagsMethod = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[] { Locale.class });
      }
      catch (Exception localException2)
      {
        throw new IllegalStateException(localException2);
      }
    }
  }
  
  private static String addLikelySubtags(Locale paramLocale)
  {
    paramLocale = paramLocale.toString();
    try
    {
      Object localObject = sAddLikelySubtagsMethod;
      if (localObject != null)
      {
        localObject = (String)((Method)localObject).invoke(null, new Object[] { paramLocale });
        return (String)localObject;
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Log.w("ICUCompat", localInvocationTargetException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      Log.w("ICUCompat", localIllegalAccessException);
    }
    return paramLocale;
  }
  
  private static String getScript(String paramString)
  {
    try
    {
      Method localMethod = sGetScriptMethod;
      if (localMethod != null)
      {
        paramString = (String)localMethod.invoke(null, new Object[] { paramString });
        return paramString;
      }
    }
    catch (InvocationTargetException paramString)
    {
      Log.w("ICUCompat", paramString);
    }
    catch (IllegalAccessException paramString)
    {
      Log.w("ICUCompat", paramString);
    }
    return null;
  }
  
  @Nullable
  public static String maximizeAndGetScript(Locale paramLocale)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 24) {
      return ULocale.addLikelySubtags(ULocale.forLocale(paramLocale)).getScript();
    }
    if (i >= 21)
    {
      try
      {
        String str = ((Locale)sAddLikelySubtagsMethod.invoke(null, new Object[] { paramLocale })).getScript();
        return str;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        Log.w("ICUCompat", localIllegalAccessException);
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        Log.w("ICUCompat", localInvocationTargetException);
      }
      return paramLocale.getScript();
    }
    paramLocale = addLikelySubtags(paramLocale);
    if (paramLocale != null) {
      return getScript(paramLocale);
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\text\ICUCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */