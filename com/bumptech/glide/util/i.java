package com.bumptech.glide.util;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.Objects;

public final class i
{
  public static void a(boolean paramBoolean, @NonNull String paramString)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException(paramString);
  }
  
  @NonNull
  public static String b(@Nullable String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    throw new IllegalArgumentException("Must not be null or empty");
  }
  
  @NonNull
  public static <T extends Collection<Y>, Y> T c(@NonNull T paramT)
  {
    if (!paramT.isEmpty()) {
      return paramT;
    }
    throw new IllegalArgumentException("Must not be empty.");
  }
  
  @NonNull
  public static <T> T d(@Nullable T paramT)
  {
    return (T)e(paramT, "Argument must not be null");
  }
  
  @NonNull
  public static <T> T e(@Nullable T paramT, @NonNull String paramString)
  {
    Objects.requireNonNull(paramT, paramString);
    return paramT;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\util\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */