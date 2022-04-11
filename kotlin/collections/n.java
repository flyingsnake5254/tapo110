package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.j;

class n
  extends m
{
  public static <T> ArrayList<T> c(T... paramVarArgs)
  {
    j.e(paramVarArgs, "elements");
    if (paramVarArgs.length == 0) {
      paramVarArgs = new ArrayList();
    } else {
      paramVarArgs = new ArrayList(new d(paramVarArgs, true));
    }
    return paramVarArgs;
  }
  
  public static <T> List<T> d()
  {
    return EmptyList.INSTANCE;
  }
  
  public static kotlin.v.d e(Collection<?> paramCollection)
  {
    j.e(paramCollection, "$this$indices");
    return new kotlin.v.d(0, paramCollection.size() - 1);
  }
  
  public static <T> int f(List<? extends T> paramList)
  {
    j.e(paramList, "$this$lastIndex");
    return paramList.size() - 1;
  }
  
  public static <T> List<T> g(T... paramVarArgs)
  {
    j.e(paramVarArgs, "elements");
    if (paramVarArgs.length > 0) {
      paramVarArgs = e.b(paramVarArgs);
    } else {
      paramVarArgs = l.d();
    }
    return paramVarArgs;
  }
  
  public static <T> List<T> h(T... paramVarArgs)
  {
    j.e(paramVarArgs, "elements");
    if (paramVarArgs.length == 0) {
      paramVarArgs = new ArrayList();
    } else {
      paramVarArgs = new ArrayList(new d(paramVarArgs, true));
    }
    return paramVarArgs;
  }
  
  public static <T> List<T> i(List<? extends T> paramList)
  {
    j.e(paramList, "$this$optimizeReadOnlyList");
    int i = paramList.size();
    if (i != 0)
    {
      if (i == 1) {
        paramList = l.b(paramList.get(0));
      }
    }
    else {
      paramList = l.d();
    }
    return paramList;
  }
  
  public static void j()
  {
    throw new ArithmeticException("Count overflow has happened.");
  }
  
  public static void k()
  {
    throw new ArithmeticException("Index overflow has happened.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\collections\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */