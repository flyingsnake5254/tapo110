package androidx.core.util;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.Locale;
import java.util.Objects;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class Preconditions
{
  public static void checkArgument(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public static void checkArgument(boolean paramBoolean, @NonNull Object paramObject)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException(String.valueOf(paramObject));
  }
  
  public static int checkArgumentInRange(int paramInt1, int paramInt2, int paramInt3, @NonNull String paramString)
  {
    if (paramInt1 >= paramInt2)
    {
      if (paramInt1 <= paramInt3) {
        return paramInt1;
      }
      throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", new Object[] { paramString, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    }
    throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", new Object[] { paramString, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
  }
  
  @IntRange(from=0L)
  public static int checkArgumentNonnegative(int paramInt)
  {
    if (paramInt >= 0) {
      return paramInt;
    }
    throw new IllegalArgumentException();
  }
  
  @IntRange(from=0L)
  public static int checkArgumentNonnegative(int paramInt, @Nullable String paramString)
  {
    if (paramInt >= 0) {
      return paramInt;
    }
    throw new IllegalArgumentException(paramString);
  }
  
  @NonNull
  public static <T> T checkNotNull(@Nullable T paramT)
  {
    Objects.requireNonNull(paramT);
    return paramT;
  }
  
  @NonNull
  public static <T> T checkNotNull(@Nullable T paramT, @NonNull Object paramObject)
  {
    if (paramT != null) {
      return paramT;
    }
    throw new NullPointerException(String.valueOf(paramObject));
  }
  
  public static void checkState(boolean paramBoolean)
  {
    checkState(paramBoolean, null);
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalStateException(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\util\Preconditions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */