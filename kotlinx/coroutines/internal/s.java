package kotlinx.coroutines.internal;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.jvm.internal.j;
import kotlin.n;
import kotlin.text.m;
import kotlinx.coroutines.g0;

public final class s
{
  private static final String a;
  private static final String b;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: getstatic 15	kotlin/Result:Companion	Lkotlin/Result$a;
    //   3: astore_0
    //   4: ldc 17
    //   6: invokestatic 23	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   9: astore_0
    //   10: aload_0
    //   11: ldc 25
    //   13: invokestatic 30	kotlin/jvm/internal/j:b	(Ljava/lang/Object;Ljava/lang/String;)V
    //   16: aload_0
    //   17: invokevirtual 34	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   20: invokestatic 38	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: astore_0
    //   24: goto +16 -> 40
    //   27: astore_0
    //   28: getstatic 15	kotlin/Result:Companion	Lkotlin/Result$a;
    //   31: astore_1
    //   32: aload_0
    //   33: invokestatic 43	kotlin/k:a	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   36: invokestatic 38	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   39: astore_0
    //   40: aload_0
    //   41: invokestatic 47	kotlin/Result:exceptionOrNull-impl	(Ljava/lang/Object;)Ljava/lang/Throwable;
    //   44: ifnonnull +6 -> 50
    //   47: goto +6 -> 53
    //   50: ldc 17
    //   52: astore_0
    //   53: aload_0
    //   54: checkcast 49	java/lang/String
    //   57: putstatic 51	kotlinx/coroutines/internal/s:a	Ljava/lang/String;
    //   60: getstatic 15	kotlin/Result:Companion	Lkotlin/Result$a;
    //   63: astore_0
    //   64: ldc 53
    //   66: invokestatic 23	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   69: astore_0
    //   70: aload_0
    //   71: ldc 55
    //   73: invokestatic 30	kotlin/jvm/internal/j:b	(Ljava/lang/Object;Ljava/lang/String;)V
    //   76: aload_0
    //   77: invokevirtual 34	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   80: invokestatic 38	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   83: astore_0
    //   84: goto +16 -> 100
    //   87: astore_1
    //   88: getstatic 15	kotlin/Result:Companion	Lkotlin/Result$a;
    //   91: astore_0
    //   92: aload_1
    //   93: invokestatic 43	kotlin/k:a	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   96: invokestatic 38	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   99: astore_0
    //   100: aload_0
    //   101: invokestatic 47	kotlin/Result:exceptionOrNull-impl	(Ljava/lang/Object;)Ljava/lang/Throwable;
    //   104: ifnonnull +6 -> 110
    //   107: goto +6 -> 113
    //   110: ldc 57
    //   112: astore_0
    //   113: aload_0
    //   114: checkcast 49	java/lang/String
    //   117: putstatic 59	kotlinx/coroutines/internal/s:b	Ljava/lang/String;
    //   120: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	21	0	localObject1	Object
    //   27	6	0	localThrowable1	Throwable
    //   39	75	0	localObject2	Object
    //   31	1	1	locala	kotlin.Result.a
    //   87	6	1	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	24	27	finally
    //   60	84	87	finally
  }
  
  public static final StackTraceElement a(String paramString)
  {
    j.f(paramString, "message");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\b\b\b(");
    localStringBuilder.append(paramString);
    return new StackTraceElement(localStringBuilder.toString(), "\b", "\b", -1);
  }
  
  private static final <E extends Throwable> Pair<E, StackTraceElement[]> b(E paramE)
  {
    Throwable localThrowable = paramE.getCause();
    if ((localThrowable != null) && (j.a(localThrowable.getClass(), paramE.getClass())))
    {
      StackTraceElement[] arrayOfStackTraceElement = paramE.getStackTrace();
      j.b(arrayOfStackTraceElement, "currentTrace");
      int i = arrayOfStackTraceElement.length;
      for (int j = 0; j < i; j++)
      {
        StackTraceElement localStackTraceElement = arrayOfStackTraceElement[j];
        j.b(localStackTraceElement, "it");
        if (g(localStackTraceElement))
        {
          j = 1;
          break label82;
        }
      }
      j = 0;
      label82:
      if (j != 0) {
        paramE = n.a(localThrowable, arrayOfStackTraceElement);
      } else {
        paramE = n.a(paramE, new StackTraceElement[0]);
      }
    }
    else
    {
      paramE = n.a(paramE, new StackTraceElement[0]);
    }
    return paramE;
  }
  
  private static final <E extends Throwable> E c(E paramE1, E paramE2, ArrayDeque<StackTraceElement> paramArrayDeque)
  {
    paramArrayDeque.addFirst(a("Coroutine boundary"));
    StackTraceElement[] arrayOfStackTraceElement = paramE1.getStackTrace();
    j.b(arrayOfStackTraceElement, "causeTrace");
    paramE1 = a;
    j.b(paramE1, "baseContinuationImplClassName");
    int i = f(arrayOfStackTraceElement, paramE1);
    int j = 0;
    if (i == -1)
    {
      paramE1 = paramArrayDeque.toArray(new StackTraceElement[0]);
      if (paramE1 != null)
      {
        paramE2.setStackTrace((StackTraceElement[])paramE1);
        return paramE2;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
    paramE1 = new StackTraceElement[paramArrayDeque.size() + i];
    for (int k = 0; k < i; k++) {
      paramE1[k] = arrayOfStackTraceElement[k];
    }
    paramArrayDeque = paramArrayDeque.iterator();
    for (k = j; paramArrayDeque.hasNext(); k++) {
      paramE1[(i + k)] = ((StackTraceElement)paramArrayDeque.next());
    }
    paramE2.setStackTrace(paramE1);
    return paramE2;
  }
  
  private static final ArrayDeque<StackTraceElement> d(kotlin.coroutines.jvm.internal.c paramc)
  {
    ArrayDeque localArrayDeque = new ArrayDeque();
    StackTraceElement localStackTraceElement = paramc.getStackTraceElement();
    kotlin.coroutines.jvm.internal.c localc = paramc;
    if (localStackTraceElement != null)
    {
      localArrayDeque.add(localStackTraceElement);
      localc = paramc;
    }
    while (localc != null)
    {
      paramc = localc.getCallerFrame();
      if (paramc == null) {
        break;
      }
      localStackTraceElement = paramc.getStackTraceElement();
      localc = paramc;
      if (localStackTraceElement != null)
      {
        localArrayDeque.add(localStackTraceElement);
        localc = paramc;
      }
    }
    return localArrayDeque;
  }
  
  private static final boolean e(StackTraceElement paramStackTraceElement1, StackTraceElement paramStackTraceElement2)
  {
    boolean bool;
    if ((paramStackTraceElement1.getLineNumber() == paramStackTraceElement2.getLineNumber()) && (j.a(paramStackTraceElement1.getMethodName(), paramStackTraceElement2.getMethodName())) && (j.a(paramStackTraceElement1.getFileName(), paramStackTraceElement2.getFileName())) && (j.a(paramStackTraceElement1.getClassName(), paramStackTraceElement2.getClassName()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static final int f(StackTraceElement[] paramArrayOfStackTraceElement, String paramString)
  {
    int i = paramArrayOfStackTraceElement.length;
    for (int j = 0; j < i; j++) {
      if (j.a(paramString, paramArrayOfStackTraceElement[j].getClassName())) {
        return j;
      }
    }
    j = -1;
    return j;
  }
  
  public static final boolean g(StackTraceElement paramStackTraceElement)
  {
    j.f(paramStackTraceElement, "$this$isArtificial");
    paramStackTraceElement = paramStackTraceElement.getClassName();
    j.b(paramStackTraceElement, "className");
    return m.A(paramStackTraceElement, "\b\b\b", false, 2, null);
  }
  
  private static final void h(StackTraceElement[] paramArrayOfStackTraceElement, ArrayDeque<StackTraceElement> paramArrayDeque)
  {
    int i = paramArrayOfStackTraceElement.length;
    for (int j = 0; j < i; j++) {
      if (g(paramArrayOfStackTraceElement[j])) {
        break label30;
      }
    }
    j = -1;
    label30:
    i = j + 1;
    j = paramArrayOfStackTraceElement.length - 1;
    if (j >= i) {
      for (;;)
      {
        StackTraceElement localStackTraceElement = paramArrayOfStackTraceElement[j];
        Object localObject = paramArrayDeque.getLast();
        j.b(localObject, "result.last");
        if (e(localStackTraceElement, (StackTraceElement)localObject)) {
          paramArrayDeque.removeLast();
        }
        paramArrayDeque.addFirst(paramArrayOfStackTraceElement[j]);
        if (j == i) {
          break;
        }
        j--;
      }
    }
  }
  
  private static final <E extends Throwable> E i(E paramE, kotlin.coroutines.jvm.internal.c paramc)
  {
    Object localObject = b(paramE);
    Throwable localThrowable1 = (Throwable)((Pair)localObject).component1();
    StackTraceElement[] arrayOfStackTraceElement = (StackTraceElement[])((Pair)localObject).component2();
    Throwable localThrowable2 = ExceptionsConstuctorKt.e(localThrowable1);
    localObject = paramE;
    if (localThrowable2 != null)
    {
      paramc = d(paramc);
      if (paramc.isEmpty()) {
        return paramE;
      }
      if (localThrowable1 != paramE) {
        h(arrayOfStackTraceElement, paramc);
      }
      localObject = c(localThrowable1, localThrowable2, paramc);
    }
    return (E)localObject;
  }
  
  public static final <E extends Throwable> E j(E paramE)
  {
    j.f(paramE, "exception");
    if (!g0.d()) {
      return paramE;
    }
    Throwable localThrowable = ExceptionsConstuctorKt.e(paramE);
    if (localThrowable != null) {
      paramE = l(localThrowable);
    }
    return paramE;
  }
  
  public static final <E extends Throwable> E k(E paramE, kotlin.coroutines.c<?> paramc)
  {
    j.f(paramE, "exception");
    j.f(paramc, "continuation");
    Object localObject = paramE;
    if (g0.d()) {
      if (!(paramc instanceof kotlin.coroutines.jvm.internal.c)) {
        localObject = paramE;
      } else {
        localObject = i(paramE, (kotlin.coroutines.jvm.internal.c)paramc);
      }
    }
    return (E)localObject;
  }
  
  private static final <E extends Throwable> E l(E paramE)
  {
    StackTraceElement[] arrayOfStackTraceElement1 = paramE.getStackTrace();
    int i = arrayOfStackTraceElement1.length;
    j.b(arrayOfStackTraceElement1, "stackTrace");
    Object localObject = b;
    j.b(localObject, "stackTraceRecoveryClassName");
    int j = f(arrayOfStackTraceElement1, (String)localObject);
    localObject = a;
    j.b(localObject, "baseContinuationImplClassName");
    int k = f(arrayOfStackTraceElement1, (String)localObject);
    int m = 0;
    if (k == -1) {
      k = 0;
    } else {
      k = i - k;
    }
    i = i - j - k;
    StackTraceElement[] arrayOfStackTraceElement2 = new StackTraceElement[i];
    for (k = m; k < i; k++)
    {
      if (k == 0) {
        localObject = a("Coroutine boundary");
      } else {
        localObject = arrayOfStackTraceElement1[(j + 1 + k - 1)];
      }
      arrayOfStackTraceElement2[k] = localObject;
    }
    paramE.setStackTrace(arrayOfStackTraceElement2);
    return paramE;
  }
  
  public static final <E extends Throwable> E m(E paramE)
  {
    j.f(paramE, "exception");
    if (!g0.d()) {
      return paramE;
    }
    Throwable localThrowable = paramE.getCause();
    if (localThrowable != null)
    {
      boolean bool = j.a(localThrowable.getClass(), paramE.getClass());
      int i = 1;
      if (!(bool ^ true))
      {
        StackTraceElement[] arrayOfStackTraceElement = paramE.getStackTrace();
        j.b(arrayOfStackTraceElement, "exception.stackTrace");
        int j = arrayOfStackTraceElement.length;
        for (int k = 0; k < j; k++)
        {
          StackTraceElement localStackTraceElement = arrayOfStackTraceElement[k];
          j.b(localStackTraceElement, "it");
          if (g(localStackTraceElement))
          {
            k = i;
            break label113;
          }
        }
        k = 0;
        label113:
        if (k != 0) {
          return localThrowable;
        }
      }
    }
    return paramE;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\internal\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */