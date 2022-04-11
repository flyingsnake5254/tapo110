package io.reactivex.internal.disposables;

import io.reactivex.e0.c;
import java.util.LinkedList;
import java.util.List;

public final class b
  implements c, a
{
  List<c> c;
  volatile boolean d;
  
  public boolean a(c paramc)
  {
    if (c(paramc))
    {
      paramc.dispose();
      return true;
    }
    return false;
  }
  
  public boolean b(c paramc)
  {
    io.reactivex.h0.a.b.e(paramc, "d is null");
    if (!this.d) {
      try
      {
        if (!this.d)
        {
          List localList = this.c;
          Object localObject = localList;
          if (localList == null)
          {
            localObject = new java/util/LinkedList;
            ((LinkedList)localObject).<init>();
            this.c = ((List)localObject);
          }
          ((List)localObject).add(paramc);
          return true;
        }
      }
      finally {}
    }
    paramc.dispose();
    return false;
  }
  
  public boolean c(c paramc)
  {
    io.reactivex.h0.a.b.e(paramc, "Disposable item is null");
    if (this.d) {
      return false;
    }
    try
    {
      if (this.d) {
        return false;
      }
      List localList = this.c;
      return (localList != null) && (localList.remove(paramc));
    }
    finally {}
  }
  
  /* Error */
  void d(List<c> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aconst_null
    //   6: astore_2
    //   7: aload_1
    //   8: invokeinterface 57 1 0
    //   13: astore_3
    //   14: aload_2
    //   15: astore_1
    //   16: aload_3
    //   17: invokeinterface 63 1 0
    //   22: ifeq +57 -> 79
    //   25: aload_3
    //   26: invokeinterface 67 1 0
    //   31: checkcast 6	io/reactivex/e0/c
    //   34: astore_2
    //   35: aload_2
    //   36: invokeinterface 25 1 0
    //   41: goto -25 -> 16
    //   44: astore 4
    //   46: aload 4
    //   48: invokestatic 72	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   51: aload_1
    //   52: astore_2
    //   53: aload_1
    //   54: ifnonnull +11 -> 65
    //   57: new 74	java/util/ArrayList
    //   60: dup
    //   61: invokespecial 75	java/util/ArrayList:<init>	()V
    //   64: astore_2
    //   65: aload_2
    //   66: aload 4
    //   68: invokeinterface 47 2 0
    //   73: pop
    //   74: aload_2
    //   75: astore_1
    //   76: goto -60 -> 16
    //   79: aload_1
    //   80: ifnull +36 -> 116
    //   83: aload_1
    //   84: invokeinterface 79 1 0
    //   89: iconst_1
    //   90: if_icmpne +17 -> 107
    //   93: aload_1
    //   94: iconst_0
    //   95: invokeinterface 83 2 0
    //   100: checkcast 85	java/lang/Throwable
    //   103: invokestatic 90	io/reactivex/internal/util/e:e	(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
    //   106: athrow
    //   107: new 92	io/reactivex/exceptions/CompositeException
    //   110: dup
    //   111: aload_1
    //   112: invokespecial 95	io/reactivex/exceptions/CompositeException:<init>	(Ljava/lang/Iterable;)V
    //   115: athrow
    //   116: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	b
    //   0	117	1	paramList	List<c>
    //   6	69	2	localObject	Object
    //   13	13	3	localIterator	java.util.Iterator
    //   44	23	4	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   35	41	44	finally
  }
  
  public void dispose()
  {
    if (this.d) {
      return;
    }
    try
    {
      if (this.d) {
        return;
      }
      this.d = true;
      List localList = this.c;
      this.c = null;
      d(localList);
      return;
    }
    finally {}
  }
  
  public boolean isDisposed()
  {
    return this.d;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\disposables\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */