package androidx.collection;

import kotlin.jvm.internal.j;

public final class ArraySetKt
{
  public static final <T> ArraySet<T> arraySetOf()
  {
    return new ArraySet();
  }
  
  public static final <T> ArraySet<T> arraySetOf(T... paramVarArgs)
  {
    j.f(paramVarArgs, "values");
    ArraySet localArraySet = new ArraySet(paramVarArgs.length);
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++) {
      localArraySet.add(paramVarArgs[j]);
    }
    return localArraySet;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\collection\ArraySetKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */