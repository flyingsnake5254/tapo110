package com.airbnb.lottie.v;

import android.util.Log;
import com.airbnb.lottie.i;
import java.util.HashSet;
import java.util.Set;

public class c
  implements i
{
  private static final Set<String> a = new HashSet();
  
  public void a(String paramString)
  {
    b(paramString, null);
  }
  
  public void b(String paramString, Throwable paramThrowable)
  {
    Set localSet = a;
    if (localSet.contains(paramString)) {
      return;
    }
    Log.w("LOTTIE", paramString, paramThrowable);
    localSet.add(paramString);
  }
  
  public void c(String paramString, Throwable paramThrowable)
  {
    if (com.airbnb.lottie.c.a) {
      Log.d("LOTTIE", paramString, paramThrowable);
    }
  }
  
  public void debug(String paramString)
  {
    c(paramString, null);
  }
  
  public void error(String paramString, Throwable paramThrowable)
  {
    if (com.airbnb.lottie.c.a) {
      Log.d("LOTTIE", paramString, paramThrowable);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\v\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */