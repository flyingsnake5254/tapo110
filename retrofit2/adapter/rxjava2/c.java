package retrofit2.adapter.rxjava2;

import retrofit2.b;

final class c<T>
  extends io.reactivex.q<retrofit2.q<T>>
{
  private final b<T> c;
  
  c(b<T> paramb)
  {
    this.c = paramb;
  }
  
  /* Error */
  protected void K0(io.reactivex.v<? super retrofit2.q<T>> paramv)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 18	retrofit2/adapter/rxjava2/c:c	Lretrofit2/b;
    //   4: invokeinterface 29 1 0
    //   9: astore_2
    //   10: new 7	retrofit2/adapter/rxjava2/c$a
    //   13: dup
    //   14: aload_2
    //   15: invokespecial 31	retrofit2/adapter/rxjava2/c$a:<init>	(Lretrofit2/b;)V
    //   18: astore_3
    //   19: aload_1
    //   20: aload_3
    //   21: invokeinterface 37 2 0
    //   26: aload_3
    //   27: invokevirtual 41	retrofit2/adapter/rxjava2/c$a:isDisposed	()Z
    //   30: ifeq +4 -> 34
    //   33: return
    //   34: aload_2
    //   35: invokeinterface 45 1 0
    //   40: astore_2
    //   41: aload_3
    //   42: invokevirtual 41	retrofit2/adapter/rxjava2/c$a:isDisposed	()Z
    //   45: ifne +10 -> 55
    //   48: aload_1
    //   49: aload_2
    //   50: invokeinterface 49 2 0
    //   55: aload_3
    //   56: invokevirtual 41	retrofit2/adapter/rxjava2/c$a:isDisposed	()Z
    //   59: istore 4
    //   61: iload 4
    //   63: ifne +83 -> 146
    //   66: aload_1
    //   67: invokeinterface 52 1 0
    //   72: goto +74 -> 146
    //   75: astore_2
    //   76: iconst_1
    //   77: istore 5
    //   79: goto +7 -> 86
    //   82: astore_2
    //   83: iconst_0
    //   84: istore 5
    //   86: aload_2
    //   87: invokestatic 58	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   90: iload 5
    //   92: ifeq +10 -> 102
    //   95: aload_2
    //   96: invokestatic 63	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
    //   99: goto +47 -> 146
    //   102: aload_3
    //   103: invokevirtual 41	retrofit2/adapter/rxjava2/c$a:isDisposed	()Z
    //   106: ifne +40 -> 146
    //   109: aload_1
    //   110: aload_2
    //   111: invokeinterface 66 2 0
    //   116: goto +30 -> 146
    //   119: astore_1
    //   120: aload_1
    //   121: invokestatic 58	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   124: new 68	io/reactivex/exceptions/CompositeException
    //   127: dup
    //   128: iconst_2
    //   129: anewarray 70	java/lang/Throwable
    //   132: dup
    //   133: iconst_0
    //   134: aload_2
    //   135: aastore
    //   136: dup
    //   137: iconst_1
    //   138: aload_1
    //   139: aastore
    //   140: invokespecial 73	io/reactivex/exceptions/CompositeException:<init>	([Ljava/lang/Throwable;)V
    //   143: invokestatic 63	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
    //   146: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	c
    //   0	147	1	paramv	io.reactivex.v<? super retrofit2.q<T>>
    //   9	41	2	localObject1	Object
    //   75	1	2	localObject2	Object
    //   82	53	2	localThrowable	Throwable
    //   18	85	3	locala	a
    //   59	3	4	bool	boolean
    //   77	14	5	i	int
    // Exception table:
    //   from	to	target	type
    //   66	72	75	finally
    //   34	55	82	finally
    //   55	61	82	finally
    //   109	116	119	finally
  }
  
  private static final class a
    implements io.reactivex.e0.c
  {
    private final b<?> c;
    private volatile boolean d;
    
    a(b<?> paramb)
    {
      this.c = paramb;
    }
    
    public void dispose()
    {
      this.d = true;
      this.c.cancel();
    }
    
    public boolean isDisposed()
    {
      return this.d;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\retrofit2\adapter\rxjava2\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */