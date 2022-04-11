package com.google.common.base;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class n
{
  private static String a(int paramInt1, int paramInt2, @NullableDecl String paramString)
  {
    if (paramInt1 < 0) {
      return s.b("%s (%s) must not be negative", new Object[] { paramString, Integer.valueOf(paramInt1) });
    }
    if (paramInt2 >= 0) {
      return s.b("%s (%s) must be less than size (%s)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    paramString = new StringBuilder();
    paramString.append("negative size: ");
    paramString.append(paramInt2);
    throw new IllegalArgumentException(paramString.toString());
  }
  
  private static String b(int paramInt1, int paramInt2, @NullableDecl String paramString)
  {
    if (paramInt1 < 0) {
      return s.b("%s (%s) must not be negative", new Object[] { paramString, Integer.valueOf(paramInt1) });
    }
    if (paramInt2 >= 0) {
      return s.b("%s (%s) must not be greater than size (%s)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    paramString = new StringBuilder();
    paramString.append("negative size: ");
    paramString.append(paramInt2);
    throw new IllegalArgumentException(paramString.toString());
  }
  
  private static String c(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= 0) && (paramInt1 <= paramInt3))
    {
      if ((paramInt2 >= 0) && (paramInt2 <= paramInt3)) {
        return s.b("end index (%s) must not be less than start index (%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      }
      return b(paramInt2, paramInt3, "end index");
    }
    return b(paramInt1, paramInt3, "start index");
  }
  
  public static void d(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public static void e(boolean paramBoolean, @NullableDecl Object paramObject)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException(String.valueOf(paramObject));
  }
  
  public static void f(boolean paramBoolean, @NullableDecl String paramString, int paramInt)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException(s.b(paramString, new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public static void g(boolean paramBoolean, @NullableDecl String paramString, int paramInt1, int paramInt2)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException(s.b(paramString, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
  }
  
  public static void h(boolean paramBoolean, @NullableDecl String paramString, long paramLong)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException(s.b(paramString, new Object[] { Long.valueOf(paramLong) }));
  }
  
  public static void i(boolean paramBoolean, @NullableDecl String paramString, long paramLong1, long paramLong2)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException(s.b(paramString, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
  }
  
  public static void j(boolean paramBoolean, @NullableDecl String paramString, @NullableDecl Object paramObject)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException(s.b(paramString, new Object[] { paramObject }));
  }
  
  public static void k(boolean paramBoolean, @NullableDecl String paramString, @NullableDecl Object paramObject1, @NullableDecl Object paramObject2)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException(s.b(paramString, new Object[] { paramObject1, paramObject2 }));
  }
  
  public static void l(boolean paramBoolean, @NullableDecl String paramString, @NullableDecl Object paramObject1, @NullableDecl Object paramObject2, @NullableDecl Object paramObject3, @NullableDecl Object paramObject4)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException(s.b(paramString, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 }));
  }
  
  @CanIgnoreReturnValue
  public static int m(int paramInt1, int paramInt2)
  {
    return n(paramInt1, paramInt2, "index");
  }
  
  @CanIgnoreReturnValue
  public static int n(int paramInt1, int paramInt2, @NullableDecl String paramString)
  {
    if ((paramInt1 >= 0) && (paramInt1 < paramInt2)) {
      return paramInt1;
    }
    throw new IndexOutOfBoundsException(a(paramInt1, paramInt2, paramString));
  }
  
  @NonNullDecl
  @CanIgnoreReturnValue
  public static <T> T o(@NonNullDecl T paramT)
  {
    Objects.requireNonNull(paramT);
    return paramT;
  }
  
  @NonNullDecl
  @CanIgnoreReturnValue
  public static <T> T p(@NonNullDecl T paramT, @NullableDecl Object paramObject)
  {
    if (paramT != null) {
      return paramT;
    }
    throw new NullPointerException(String.valueOf(paramObject));
  }
  
  @NonNullDecl
  @CanIgnoreReturnValue
  public static <T> T q(@NonNullDecl T paramT, @NullableDecl String paramString, @NullableDecl Object paramObject1, @NullableDecl Object paramObject2)
  {
    if (paramT != null) {
      return paramT;
    }
    throw new NullPointerException(s.b(paramString, new Object[] { paramObject1, paramObject2 }));
  }
  
  @CanIgnoreReturnValue
  public static int r(int paramInt1, int paramInt2)
  {
    return s(paramInt1, paramInt2, "index");
  }
  
  @CanIgnoreReturnValue
  public static int s(int paramInt1, int paramInt2, @NullableDecl String paramString)
  {
    if ((paramInt1 >= 0) && (paramInt1 <= paramInt2)) {
      return paramInt1;
    }
    throw new IndexOutOfBoundsException(b(paramInt1, paramInt2, paramString));
  }
  
  public static void t(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= 0) && (paramInt2 >= paramInt1) && (paramInt2 <= paramInt3)) {
      return;
    }
    throw new IndexOutOfBoundsException(c(paramInt1, paramInt2, paramInt3));
  }
  
  public static void u(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalStateException();
  }
  
  public static void v(boolean paramBoolean, @NullableDecl Object paramObject)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalStateException(String.valueOf(paramObject));
  }
  
  public static void w(boolean paramBoolean, @NullableDecl String paramString, int paramInt)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalStateException(s.b(paramString, new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public static void x(boolean paramBoolean, @NullableDecl String paramString, @NullableDecl Object paramObject)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalStateException(s.b(paramString, new Object[] { paramObject }));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\base\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */