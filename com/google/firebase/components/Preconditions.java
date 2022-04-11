package com.google.firebase.components;

import java.util.Objects;

public final class Preconditions
{
  public static void checkArgument(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException(paramString);
  }
  
  public static <T> T checkNotNull(T paramT)
  {
    Objects.requireNonNull(paramT);
    return paramT;
  }
  
  public static <T> T checkNotNull(T paramT, String paramString)
  {
    Objects.requireNonNull(paramT, paramString);
    return paramT;
  }
  
  public static void checkState(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalStateException(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\components\Preconditions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */