package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import java.net.UnknownHostException;
import org.checkerframework.dataflow.qual.Pure;

public final class u
{
  private static int a = 0;
  private static boolean b = true;
  
  @Pure
  private static String a(String paramString, @Nullable Throwable paramThrowable)
  {
    String str = e(paramThrowable);
    paramThrowable = paramString;
    if (!TextUtils.isEmpty(str))
    {
      paramString = String.valueOf(paramString);
      str = str.replace("\n", "\n  ");
      paramThrowable = new StringBuilder(paramString.length() + 4 + String.valueOf(str).length());
      paramThrowable.append(paramString);
      paramThrowable.append("\n  ");
      paramThrowable.append(str);
      paramThrowable.append('\n');
      paramThrowable = paramThrowable.toString();
    }
    return paramThrowable;
  }
  
  @Pure
  public static void b(String paramString1, String paramString2)
  {
    if (a == 0) {
      Log.d(paramString1, paramString2);
    }
  }
  
  @Pure
  public static void c(String paramString1, String paramString2)
  {
    if (a <= 3) {
      Log.e(paramString1, paramString2);
    }
  }
  
  @Pure
  public static void d(String paramString1, String paramString2, @Nullable Throwable paramThrowable)
  {
    c(paramString1, a(paramString2, paramThrowable));
  }
  
  @Pure
  @Nullable
  public static String e(@Nullable Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return null;
    }
    if (g(paramThrowable)) {
      return "UnknownHostException (no network)";
    }
    if (!b) {
      return paramThrowable.getMessage();
    }
    return Log.getStackTraceString(paramThrowable).trim().replace("\t", "    ");
  }
  
  @Pure
  public static void f(String paramString1, String paramString2)
  {
    if (a <= 1) {
      Log.i(paramString1, paramString2);
    }
  }
  
  @Pure
  private static boolean g(@Nullable Throwable paramThrowable)
  {
    while (paramThrowable != null)
    {
      if ((paramThrowable instanceof UnknownHostException)) {
        return true;
      }
      paramThrowable = paramThrowable.getCause();
    }
    return false;
  }
  
  @Pure
  public static void h(String paramString1, String paramString2)
  {
    if (a <= 2) {
      Log.w(paramString1, paramString2);
    }
  }
  
  @Pure
  public static void i(String paramString1, String paramString2, @Nullable Throwable paramThrowable)
  {
    h(paramString1, a(paramString2, paramThrowable));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\util\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */