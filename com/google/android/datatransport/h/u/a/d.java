package com.google.android.datatransport.h.u.a;

import java.util.Objects;

public final class d
{
  public static <T> void a(T paramT, Class<T> paramClass)
  {
    if (paramT != null) {
      return;
    }
    paramT = new StringBuilder();
    paramT.append(paramClass.getCanonicalName());
    paramT.append(" must be set");
    throw new IllegalStateException(paramT.toString());
  }
  
  public static <T> T b(T paramT)
  {
    Objects.requireNonNull(paramT);
    return paramT;
  }
  
  public static <T> T c(T paramT, String paramString)
  {
    Objects.requireNonNull(paramT, paramString);
    return paramT;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\h\u\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */