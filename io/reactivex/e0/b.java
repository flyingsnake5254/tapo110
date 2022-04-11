package io.reactivex.e0;

import io.reactivex.internal.disposables.a;
import io.reactivex.internal.util.h;

public final class b
  implements c, a
{
  h<c> c;
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
    io.reactivex.h0.a.b.e(paramc, "disposable is null");
    if (!this.d) {
      try
      {
        if (!this.d)
        {
          h localh1 = this.c;
          h localh2 = localh1;
          if (localh1 == null)
          {
            localh2 = new io/reactivex/internal/util/h;
            localh2.<init>();
            this.c = localh2;
          }
          localh2.a(paramc);
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
    io.reactivex.h0.a.b.e(paramc, "disposables is null");
    if (this.d) {
      return false;
    }
    try
    {
      if (this.d) {
        return false;
      }
      h localh = this.c;
      return (localh != null) && (localh.e(paramc));
    }
    finally {}
  }
  
  public void d()
  {
    if (this.d) {
      return;
    }
    try
    {
      if (this.d) {
        return;
      }
      h localh = this.c;
      this.c = null;
      e(localh);
      return;
    }
    finally {}
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
      h localh = this.c;
      this.c = null;
      e(localh);
      return;
    }
    finally {}
  }
  
  /* Error */
  void e(h<c> paramh)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aconst_null
    //   6: astore_2
    //   7: aload_1
    //   8: invokevirtual 54	io/reactivex/internal/util/h:b	()[Ljava/lang/Object;
    //   11: astore_3
    //   12: aload_3
    //   13: arraylength
    //   14: istore 4
    //   16: iconst_0
    //   17: istore 5
    //   19: aload_2
    //   20: astore_1
    //   21: iload 5
    //   23: iload 4
    //   25: if_icmpge +72 -> 97
    //   28: aload_3
    //   29: iload 5
    //   31: aaload
    //   32: astore 6
    //   34: aload_1
    //   35: astore_2
    //   36: aload 6
    //   38: instanceof 6
    //   41: ifeq +48 -> 89
    //   44: aload 6
    //   46: checkcast 6	io/reactivex/e0/c
    //   49: invokeinterface 25 1 0
    //   54: aload_1
    //   55: astore_2
    //   56: goto +33 -> 89
    //   59: astore 6
    //   61: aload 6
    //   63: invokestatic 59	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   66: aload_1
    //   67: astore_2
    //   68: aload_1
    //   69: ifnonnull +11 -> 80
    //   72: new 61	java/util/ArrayList
    //   75: dup
    //   76: invokespecial 62	java/util/ArrayList:<init>	()V
    //   79: astore_2
    //   80: aload_2
    //   81: aload 6
    //   83: invokeinterface 67 2 0
    //   88: pop
    //   89: iinc 5 1
    //   92: aload_2
    //   93: astore_1
    //   94: goto -73 -> 21
    //   97: aload_1
    //   98: ifnull +36 -> 134
    //   101: aload_1
    //   102: invokeinterface 71 1 0
    //   107: iconst_1
    //   108: if_icmpne +17 -> 125
    //   111: aload_1
    //   112: iconst_0
    //   113: invokeinterface 75 2 0
    //   118: checkcast 77	java/lang/Throwable
    //   121: invokestatic 82	io/reactivex/internal/util/e:e	(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
    //   124: athrow
    //   125: new 84	io/reactivex/exceptions/CompositeException
    //   128: dup
    //   129: aload_1
    //   130: invokespecial 87	io/reactivex/exceptions/CompositeException:<init>	(Ljava/lang/Iterable;)V
    //   133: athrow
    //   134: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	b
    //   0	135	1	paramh	h<c>
    //   6	87	2	localObject1	Object
    //   11	18	3	arrayOfObject	Object[]
    //   14	12	4	i	int
    //   17	73	5	j	int
    //   32	13	6	localObject2	Object
    //   59	23	6	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   44	54	59	finally
  }
  
  public int f()
  {
    boolean bool = this.d;
    int i = 0;
    if (bool) {
      return 0;
    }
    try
    {
      if (this.d) {
        return 0;
      }
      h localh = this.c;
      if (localh != null) {
        i = localh.g();
      }
      return i;
    }
    finally {}
  }
  
  public boolean isDisposed()
  {
    return this.d;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\e0\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */