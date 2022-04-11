package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.dataflow.qual.Pure;

public final class g
{
  @Pure
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException();
  }
  
  @Pure
  public static void b(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException(String.valueOf(paramObject));
  }
  
  @Pure
  public static int c(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= paramInt2) && (paramInt1 < paramInt3)) {
      return paramInt1;
    }
    throw new IndexOutOfBoundsException();
  }
  
  @EnsuresNonNull({"#1"})
  @Pure
  public static String d(@Nullable String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    throw new IllegalArgumentException();
  }
  
  @EnsuresNonNull({"#1"})
  @Pure
  public static <T> T e(@Nullable T paramT)
  {
    Objects.requireNonNull(paramT);
    return paramT;
  }
  
  @EnsuresNonNull({"#1"})
  @Pure
  public static <T> T f(@Nullable T paramT, Object paramObject)
  {
    if (paramT != null) {
      return paramT;
    }
    throw new NullPointerException(String.valueOf(paramObject));
  }
  
  @Pure
  public static void g(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalStateException();
  }
  
  @Pure
  public static void h(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalStateException(String.valueOf(paramObject));
  }
  
  @EnsuresNonNull({"#1"})
  @Pure
  public static <T> T i(@Nullable T paramT)
  {
    if (paramT != null) {
      return paramT;
    }
    throw new IllegalStateException();
  }
  
  @EnsuresNonNull({"#1"})
  @Pure
  public static <T> T j(@Nullable T paramT, Object paramObject)
  {
    if (paramT != null) {
      return paramT;
    }
    throw new IllegalStateException(String.valueOf(paramObject));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\util\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */