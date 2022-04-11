package androidx.core.util;

import android.annotation.SuppressLint;

public abstract interface Predicate<T>
{
  @SuppressLint({"UnknownNullness"})
  public abstract boolean test(T paramT);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\util\Predicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */