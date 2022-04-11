package io.reactivex.h0.c.a;

import io.reactivex.e;
import io.reactivex.e0.b;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class j
  extends io.reactivex.a
{
  final Iterable<? extends e> c;
  
  public j(Iterable<? extends e> paramIterable)
  {
    this.c = paramIterable;
  }
  
  /* Error */
  public void B(io.reactivex.c paramc)
  {
    // Byte code:
    //   0: new 24	io/reactivex/e0/b
    //   3: dup
    //   4: invokespecial 25	io/reactivex/e0/b:<init>	()V
    //   7: astore_2
    //   8: aload_1
    //   9: aload_2
    //   10: invokeinterface 31 2 0
    //   15: aload_0
    //   16: getfield 17	io/reactivex/h0/c/a/j:c	Ljava/lang/Iterable;
    //   19: invokeinterface 37 1 0
    //   24: ldc 39
    //   26: invokestatic 45	io/reactivex/h0/a/b:e	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   29: checkcast 47	java/util/Iterator
    //   32: astore_3
    //   33: new 49	java/util/concurrent/atomic/AtomicInteger
    //   36: dup
    //   37: iconst_1
    //   38: invokespecial 52	java/util/concurrent/atomic/AtomicInteger:<init>	(I)V
    //   41: astore 4
    //   43: new 6	io/reactivex/h0/c/a/j$a
    //   46: dup
    //   47: aload_1
    //   48: aload_2
    //   49: aload 4
    //   51: invokespecial 55	io/reactivex/h0/c/a/j$a:<init>	(Lio/reactivex/c;Lio/reactivex/e0/b;Ljava/util/concurrent/atomic/AtomicInteger;)V
    //   54: astore_1
    //   55: aload_2
    //   56: invokevirtual 59	io/reactivex/e0/b:isDisposed	()Z
    //   59: ifeq +4 -> 63
    //   62: return
    //   63: aload_3
    //   64: invokeinterface 62 1 0
    //   69: istore 5
    //   71: iload 5
    //   73: ifne +8 -> 81
    //   76: aload_1
    //   77: invokevirtual 65	io/reactivex/h0/c/a/j$a:onComplete	()V
    //   80: return
    //   81: aload_2
    //   82: invokevirtual 59	io/reactivex/e0/b:isDisposed	()Z
    //   85: ifeq +4 -> 89
    //   88: return
    //   89: aload_3
    //   90: invokeinterface 69 1 0
    //   95: ldc 71
    //   97: invokestatic 45	io/reactivex/h0/a/b:e	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   100: checkcast 73	io/reactivex/e
    //   103: astore 6
    //   105: aload_2
    //   106: invokevirtual 59	io/reactivex/e0/b:isDisposed	()Z
    //   109: ifeq +4 -> 113
    //   112: return
    //   113: aload 4
    //   115: invokevirtual 77	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   118: pop
    //   119: aload 6
    //   121: aload_1
    //   122: invokeinterface 79 2 0
    //   127: goto -72 -> 55
    //   130: astore_3
    //   131: aload_3
    //   132: invokestatic 85	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   135: aload_2
    //   136: invokevirtual 88	io/reactivex/e0/b:dispose	()V
    //   139: aload_1
    //   140: aload_3
    //   141: invokevirtual 91	io/reactivex/h0/c/a/j$a:onError	(Ljava/lang/Throwable;)V
    //   144: return
    //   145: astore_3
    //   146: aload_3
    //   147: invokestatic 85	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   150: aload_2
    //   151: invokevirtual 88	io/reactivex/e0/b:dispose	()V
    //   154: aload_1
    //   155: aload_3
    //   156: invokevirtual 91	io/reactivex/h0/c/a/j$a:onError	(Ljava/lang/Throwable;)V
    //   159: return
    //   160: astore_2
    //   161: aload_2
    //   162: invokestatic 85	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   165: aload_1
    //   166: aload_2
    //   167: invokeinterface 92 2 0
    //   172: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	j
    //   0	173	1	paramc	io.reactivex.c
    //   7	144	2	localb	b
    //   160	7	2	localThrowable1	Throwable
    //   32	58	3	localIterator	java.util.Iterator
    //   130	11	3	localThrowable2	Throwable
    //   145	11	3	localThrowable3	Throwable
    //   41	73	4	localAtomicInteger	AtomicInteger
    //   69	3	5	bool	boolean
    //   103	17	6	locale	e
    // Exception table:
    //   from	to	target	type
    //   89	105	130	finally
    //   63	71	145	finally
    //   15	33	160	finally
  }
  
  static final class a
    extends AtomicBoolean
    implements io.reactivex.c
  {
    final b c;
    final io.reactivex.c d;
    final AtomicInteger f;
    
    a(io.reactivex.c paramc, b paramb, AtomicInteger paramAtomicInteger)
    {
      this.d = paramc;
      this.c = paramb;
      this.f = paramAtomicInteger;
    }
    
    public void onComplete()
    {
      if ((this.f.decrementAndGet() == 0) && (compareAndSet(false, true))) {
        this.d.onComplete();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.c.dispose();
      if (compareAndSet(false, true)) {
        this.d.onError(paramThrowable);
      } else {
        io.reactivex.j0.a.r(paramThrowable);
      }
    }
    
    public void onSubscribe(io.reactivex.e0.c paramc)
    {
      this.c.b(paramc);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\h0\c\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */