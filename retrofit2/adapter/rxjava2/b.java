package retrofit2.adapter.rxjava2;

import io.reactivex.e0.c;
import io.reactivex.v;
import retrofit2.d;

final class b<T>
  extends io.reactivex.q<retrofit2.q<T>>
{
  private final retrofit2.b<T> c;
  
  b(retrofit2.b<T> paramb)
  {
    this.c = paramb;
  }
  
  protected void K0(v<? super retrofit2.q<T>> paramv)
  {
    retrofit2.b localb = this.c.clone();
    a locala = new a(localb, paramv);
    paramv.onSubscribe(locala);
    if (!locala.isDisposed()) {
      localb.i(locala);
    }
  }
  
  private static final class a<T>
    implements c, d<T>
  {
    private final retrofit2.b<?> c;
    private final v<? super retrofit2.q<T>> d;
    private volatile boolean f;
    boolean q = false;
    
    a(retrofit2.b<?> paramb, v<? super retrofit2.q<T>> paramv)
    {
      this.c = paramb;
      this.d = paramv;
    }
    
    /* Error */
    public void a(retrofit2.b<T> paramb, Throwable paramThrowable)
    {
      // Byte code:
      //   0: aload_1
      //   1: invokeinterface 42 1 0
      //   6: ifeq +4 -> 10
      //   9: return
      //   10: aload_0
      //   11: getfield 32	retrofit2/adapter/rxjava2/b$a:d	Lio/reactivex/v;
      //   14: aload_2
      //   15: invokeinterface 48 2 0
      //   20: goto +30 -> 50
      //   23: astore_1
      //   24: aload_1
      //   25: invokestatic 53	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   28: new 55	io/reactivex/exceptions/CompositeException
      //   31: dup
      //   32: iconst_2
      //   33: anewarray 57	java/lang/Throwable
      //   36: dup
      //   37: iconst_0
      //   38: aload_2
      //   39: aastore
      //   40: dup
      //   41: iconst_1
      //   42: aload_1
      //   43: aastore
      //   44: invokespecial 60	io/reactivex/exceptions/CompositeException:<init>	([Ljava/lang/Throwable;)V
      //   47: invokestatic 65	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
      //   50: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	51	0	this	a
      //   0	51	1	paramb	retrofit2.b<T>
      //   0	51	2	paramThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   10	20	23	finally
    }
    
    /* Error */
    public void b(retrofit2.b<T> paramb, retrofit2.q<T> paramq)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 69	retrofit2/adapter/rxjava2/b$a:f	Z
      //   4: ifeq +4 -> 8
      //   7: return
      //   8: aload_0
      //   9: getfield 32	retrofit2/adapter/rxjava2/b$a:d	Lio/reactivex/v;
      //   12: aload_2
      //   13: invokeinterface 73 2 0
      //   18: aload_0
      //   19: getfield 69	retrofit2/adapter/rxjava2/b$a:f	Z
      //   22: ifne +86 -> 108
      //   25: aload_0
      //   26: iconst_1
      //   27: putfield 28	retrofit2/adapter/rxjava2/b$a:q	Z
      //   30: aload_0
      //   31: getfield 32	retrofit2/adapter/rxjava2/b$a:d	Lio/reactivex/v;
      //   34: invokeinterface 76 1 0
      //   39: goto +69 -> 108
      //   42: astore_1
      //   43: aload_1
      //   44: invokestatic 53	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   47: aload_0
      //   48: getfield 28	retrofit2/adapter/rxjava2/b$a:q	Z
      //   51: ifeq +10 -> 61
      //   54: aload_1
      //   55: invokestatic 65	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
      //   58: goto +50 -> 108
      //   61: aload_0
      //   62: getfield 69	retrofit2/adapter/rxjava2/b$a:f	Z
      //   65: ifne +43 -> 108
      //   68: aload_0
      //   69: getfield 32	retrofit2/adapter/rxjava2/b$a:d	Lio/reactivex/v;
      //   72: aload_1
      //   73: invokeinterface 48 2 0
      //   78: goto +30 -> 108
      //   81: astore_2
      //   82: aload_2
      //   83: invokestatic 53	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   86: new 55	io/reactivex/exceptions/CompositeException
      //   89: dup
      //   90: iconst_2
      //   91: anewarray 57	java/lang/Throwable
      //   94: dup
      //   95: iconst_0
      //   96: aload_1
      //   97: aastore
      //   98: dup
      //   99: iconst_1
      //   100: aload_2
      //   101: aastore
      //   102: invokespecial 60	io/reactivex/exceptions/CompositeException:<init>	([Ljava/lang/Throwable;)V
      //   105: invokestatic 65	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
      //   108: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	109	0	this	a
      //   0	109	1	paramb	retrofit2.b<T>
      //   0	109	2	paramq	retrofit2.q<T>
      // Exception table:
      //   from	to	target	type
      //   8	39	42	finally
      //   68	78	81	finally
    }
    
    public void dispose()
    {
      this.f = true;
      this.c.cancel();
    }
    
    public boolean isDisposed()
    {
      return this.f;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\retrofit2\adapter\rxjava2\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */