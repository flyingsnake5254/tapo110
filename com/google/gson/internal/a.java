package com.google.gson.internal;

import java.util.Objects;

public final class a
{
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public static <T> T b(T paramT)
  {
    Objects.requireNonNull(paramT);
    return paramT;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\internal\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */