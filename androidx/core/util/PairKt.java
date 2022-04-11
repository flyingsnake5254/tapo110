package androidx.core.util;

import android.annotation.SuppressLint;
import kotlin.jvm.internal.j;

public final class PairKt
{
  @SuppressLint({"UnknownNullness"})
  public static final <F, S> F component1(android.util.Pair<F, S> paramPair)
  {
    j.f(paramPair, "$this$component1");
    return (F)paramPair.first;
  }
  
  @SuppressLint({"UnknownNullness"})
  public static final <F, S> S component2(android.util.Pair<F, S> paramPair)
  {
    j.f(paramPair, "$this$component2");
    return (S)paramPair.second;
  }
  
  public static final <F, S> android.util.Pair<F, S> toAndroidPair(kotlin.Pair<? extends F, ? extends S> paramPair)
  {
    j.f(paramPair, "$this$toAndroidPair");
    return new android.util.Pair(paramPair.getFirst(), paramPair.getSecond());
  }
  
  public static final <F, S> kotlin.Pair<F, S> toKotlinPair(android.util.Pair<F, S> paramPair)
  {
    j.f(paramPair, "$this$toKotlinPair");
    return new kotlin.Pair(paramPair.first, paramPair.second);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\util\PairKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */