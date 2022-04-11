package com.google.android.exoplayer2.util;

import android.os.Trace;
import androidx.annotation.RequiresApi;

public final class m0
{
  public static void a(String paramString)
  {
    if (o0.a >= 18) {
      b(paramString);
    }
  }
  
  @RequiresApi(18)
  private static void b(String paramString)
  {
    Trace.beginSection(paramString);
  }
  
  public static void c()
  {
    if (o0.a >= 18) {
      d();
    }
  }
  
  @RequiresApi(18)
  private static void d() {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\util\m0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */