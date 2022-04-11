package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class AsyncTimeout
  extends Timeout
{
  private static final long IDLE_TIMEOUT_MILLIS;
  private static final long IDLE_TIMEOUT_NANOS;
  private static final int TIMEOUT_WRITE_SIZE = 65536;
  @Nullable
  static AsyncTimeout head;
  private boolean inQueue;
  @Nullable
  private AsyncTimeout next;
  private long timeoutAt;
  
  static
  {
    long l = TimeUnit.SECONDS.toMillis(60L);
    IDLE_TIMEOUT_MILLIS = l;
    IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(l);
  }
  
  @Nullable
  static AsyncTimeout awaitTimeout()
    throws InterruptedException
  {
    Object localObject1 = head.next;
    Object localObject2 = null;
    long l1;
    if (localObject1 == null)
    {
      l1 = System.nanoTime();
      AsyncTimeout.class.wait(IDLE_TIMEOUT_MILLIS);
      localObject1 = localObject2;
      if (head.next == null)
      {
        localObject1 = localObject2;
        if (System.nanoTime() - l1 >= IDLE_TIMEOUT_NANOS) {
          localObject1 = head;
        }
      }
      return (AsyncTimeout)localObject1;
    }
    long l2 = ((AsyncTimeout)localObject1).remainingNanos(System.nanoTime());
    if (l2 > 0L)
    {
      l1 = l2 / 1000000L;
      AsyncTimeout.class.wait(l1, (int)(l2 - 1000000L * l1));
      return null;
    }
    head.next = ((AsyncTimeout)localObject1).next;
    ((AsyncTimeout)localObject1).next = null;
    return (AsyncTimeout)localObject1;
  }
  
  private static boolean cancelScheduledTimeout(AsyncTimeout paramAsyncTimeout)
  {
    try
    {
      AsyncTimeout localAsyncTimeout;
      for (Object localObject = head; localObject != null; localObject = localAsyncTimeout)
      {
        localAsyncTimeout = ((AsyncTimeout)localObject).next;
        if (localAsyncTimeout == paramAsyncTimeout)
        {
          ((AsyncTimeout)localObject).next = paramAsyncTimeout.next;
          paramAsyncTimeout.next = null;
          return false;
        }
      }
      return true;
    }
    finally {}
  }
  
  private long remainingNanos(long paramLong)
  {
    return this.timeoutAt - paramLong;
  }
  
  private static void scheduleTimeout(AsyncTimeout paramAsyncTimeout, long paramLong, boolean paramBoolean)
  {
    try
    {
      if (head == null)
      {
        localObject = new okio/AsyncTimeout;
        ((AsyncTimeout)localObject).<init>();
        head = (AsyncTimeout)localObject;
        localObject = new okio/AsyncTimeout$Watchdog;
        ((Watchdog)localObject).<init>();
        ((Thread)localObject).start();
      }
      long l = System.nanoTime();
      boolean bool = paramLong < 0L;
      if ((bool) && (paramBoolean))
      {
        paramAsyncTimeout.timeoutAt = (Math.min(paramLong, paramAsyncTimeout.deadlineNanoTime() - l) + l);
      }
      else if (bool)
      {
        paramAsyncTimeout.timeoutAt = (paramLong + l);
      }
      else
      {
        if (!paramBoolean) {
          break label188;
        }
        paramAsyncTimeout.timeoutAt = paramAsyncTimeout.deadlineNanoTime();
      }
      paramLong = paramAsyncTimeout.remainingNanos(l);
      for (Object localObject = head;; localObject = ((AsyncTimeout)localObject).next)
      {
        AsyncTimeout localAsyncTimeout = ((AsyncTimeout)localObject).next;
        if ((localAsyncTimeout == null) || (paramLong < localAsyncTimeout.remainingNanos(l))) {
          break;
        }
      }
      paramAsyncTimeout.next = ((AsyncTimeout)localObject).next;
      ((AsyncTimeout)localObject).next = paramAsyncTimeout;
      if (localObject == head) {
        AsyncTimeout.class.notify();
      }
      return;
      label188:
      paramAsyncTimeout = new java/lang/AssertionError;
      paramAsyncTimeout.<init>();
      throw paramAsyncTimeout;
    }
    finally {}
  }
  
  public final void enter()
  {
    if (!this.inQueue)
    {
      long l = timeoutNanos();
      boolean bool = hasDeadline();
      if ((l == 0L) && (!bool)) {
        return;
      }
      this.inQueue = true;
      scheduleTimeout(this, l, bool);
      return;
    }
    throw new IllegalStateException("Unbalanced enter/exit");
  }
  
  final IOException exit(IOException paramIOException)
    throws IOException
  {
    if (!exit()) {
      return paramIOException;
    }
    return newTimeoutException(paramIOException);
  }
  
  final void exit(boolean paramBoolean)
    throws IOException
  {
    if ((exit()) && (paramBoolean)) {
      throw newTimeoutException(null);
    }
  }
  
  public final boolean exit()
  {
    if (!this.inQueue) {
      return false;
    }
    this.inQueue = false;
    return cancelScheduledTimeout(this);
  }
  
  protected IOException newTimeoutException(@Nullable IOException paramIOException)
  {
    InterruptedIOException localInterruptedIOException = new InterruptedIOException("timeout");
    if (paramIOException != null) {
      localInterruptedIOException.initCause(paramIOException);
    }
    return localInterruptedIOException;
  }
  
  public final Sink sink(final Sink paramSink)
  {
    new Sink()
    {
      /* Error */
      public void close()
        throws IOException
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 19	okio/AsyncTimeout$1:this$0	Lokio/AsyncTimeout;
        //   4: invokevirtual 31	okio/AsyncTimeout:enter	()V
        //   7: aload_0
        //   8: getfield 21	okio/AsyncTimeout$1:val$sink	Lokio/Sink;
        //   11: invokeinterface 33 1 0
        //   16: aload_0
        //   17: getfield 19	okio/AsyncTimeout$1:this$0	Lokio/AsyncTimeout;
        //   20: iconst_1
        //   21: invokevirtual 37	okio/AsyncTimeout:exit	(Z)V
        //   24: return
        //   25: astore_1
        //   26: goto +13 -> 39
        //   29: astore_1
        //   30: aload_0
        //   31: getfield 19	okio/AsyncTimeout$1:this$0	Lokio/AsyncTimeout;
        //   34: aload_1
        //   35: invokevirtual 40	okio/AsyncTimeout:exit	(Ljava/io/IOException;)Ljava/io/IOException;
        //   38: athrow
        //   39: aload_0
        //   40: getfield 19	okio/AsyncTimeout$1:this$0	Lokio/AsyncTimeout;
        //   43: iconst_0
        //   44: invokevirtual 37	okio/AsyncTimeout:exit	(Z)V
        //   47: aload_1
        //   48: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	49	0	this	1
        //   25	1	1	localObject	Object
        //   29	19	1	localIOException	IOException
        // Exception table:
        //   from	to	target	type
        //   7	16	25	finally
        //   30	39	25	finally
        //   7	16	29	java/io/IOException
      }
      
      /* Error */
      public void flush()
        throws IOException
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 19	okio/AsyncTimeout$1:this$0	Lokio/AsyncTimeout;
        //   4: invokevirtual 31	okio/AsyncTimeout:enter	()V
        //   7: aload_0
        //   8: getfield 21	okio/AsyncTimeout$1:val$sink	Lokio/Sink;
        //   11: invokeinterface 44 1 0
        //   16: aload_0
        //   17: getfield 19	okio/AsyncTimeout$1:this$0	Lokio/AsyncTimeout;
        //   20: iconst_1
        //   21: invokevirtual 37	okio/AsyncTimeout:exit	(Z)V
        //   24: return
        //   25: astore_1
        //   26: goto +13 -> 39
        //   29: astore_1
        //   30: aload_0
        //   31: getfield 19	okio/AsyncTimeout$1:this$0	Lokio/AsyncTimeout;
        //   34: aload_1
        //   35: invokevirtual 40	okio/AsyncTimeout:exit	(Ljava/io/IOException;)Ljava/io/IOException;
        //   38: athrow
        //   39: aload_0
        //   40: getfield 19	okio/AsyncTimeout$1:this$0	Lokio/AsyncTimeout;
        //   43: iconst_0
        //   44: invokevirtual 37	okio/AsyncTimeout:exit	(Z)V
        //   47: aload_1
        //   48: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	49	0	this	1
        //   25	1	1	localObject	Object
        //   29	19	1	localIOException	IOException
        // Exception table:
        //   from	to	target	type
        //   7	16	25	finally
        //   30	39	25	finally
        //   7	16	29	java/io/IOException
      }
      
      public Timeout timeout()
      {
        return AsyncTimeout.this;
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("AsyncTimeout.sink(");
        localStringBuilder.append(paramSink);
        localStringBuilder.append(")");
        return localStringBuilder.toString();
      }
      
      /* Error */
      public void write(Buffer paramAnonymousBuffer, long paramAnonymousLong)
        throws IOException
      {
        // Byte code:
        //   0: aload_1
        //   1: getfield 72	okio/Buffer:size	J
        //   4: lconst_0
        //   5: lload_2
        //   6: invokestatic 78	okio/Util:checkOffsetAndCount	(JJJ)V
        //   9: lconst_0
        //   10: lstore 4
        //   12: lload_2
        //   13: lconst_0
        //   14: lcmp
        //   15: ifle +121 -> 136
        //   18: aload_1
        //   19: getfield 82	okio/Buffer:head	Lokio/Segment;
        //   22: astore 6
        //   24: lload 4
        //   26: lstore 7
        //   28: lload 4
        //   30: ldc2_w 83
        //   33: lcmp
        //   34: ifge +43 -> 77
        //   37: lload 4
        //   39: aload 6
        //   41: getfield 90	okio/Segment:limit	I
        //   44: aload 6
        //   46: getfield 93	okio/Segment:pos	I
        //   49: isub
        //   50: i2l
        //   51: ladd
        //   52: lstore 4
        //   54: lload 4
        //   56: lload_2
        //   57: lcmp
        //   58: iflt +9 -> 67
        //   61: lload_2
        //   62: lstore 7
        //   64: goto +13 -> 77
        //   67: aload 6
        //   69: getfield 96	okio/Segment:next	Lokio/Segment;
        //   72: astore 6
        //   74: goto -50 -> 24
        //   77: aload_0
        //   78: getfield 19	okio/AsyncTimeout$1:this$0	Lokio/AsyncTimeout;
        //   81: invokevirtual 31	okio/AsyncTimeout:enter	()V
        //   84: aload_0
        //   85: getfield 21	okio/AsyncTimeout$1:val$sink	Lokio/Sink;
        //   88: aload_1
        //   89: lload 7
        //   91: invokeinterface 98 4 0
        //   96: lload_2
        //   97: lload 7
        //   99: lsub
        //   100: lstore_2
        //   101: aload_0
        //   102: getfield 19	okio/AsyncTimeout$1:this$0	Lokio/AsyncTimeout;
        //   105: iconst_1
        //   106: invokevirtual 37	okio/AsyncTimeout:exit	(Z)V
        //   109: goto -100 -> 9
        //   112: astore_1
        //   113: goto +13 -> 126
        //   116: astore_1
        //   117: aload_0
        //   118: getfield 19	okio/AsyncTimeout$1:this$0	Lokio/AsyncTimeout;
        //   121: aload_1
        //   122: invokevirtual 40	okio/AsyncTimeout:exit	(Ljava/io/IOException;)Ljava/io/IOException;
        //   125: athrow
        //   126: aload_0
        //   127: getfield 19	okio/AsyncTimeout$1:this$0	Lokio/AsyncTimeout;
        //   130: iconst_0
        //   131: invokevirtual 37	okio/AsyncTimeout:exit	(Z)V
        //   134: aload_1
        //   135: athrow
        //   136: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	137	0	this	1
        //   0	137	1	paramAnonymousBuffer	Buffer
        //   0	137	2	paramAnonymousLong	long
        //   10	45	4	l1	long
        //   22	51	6	localSegment	Segment
        //   26	72	7	l2	long
        // Exception table:
        //   from	to	target	type
        //   84	96	112	finally
        //   117	126	112	finally
        //   84	96	116	java/io/IOException
      }
    };
  }
  
  public final Source source(final Source paramSource)
  {
    new Source()
    {
      /* Error */
      public void close()
        throws IOException
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 19	okio/AsyncTimeout$2:this$0	Lokio/AsyncTimeout;
        //   4: invokevirtual 31	okio/AsyncTimeout:enter	()V
        //   7: aload_0
        //   8: getfield 21	okio/AsyncTimeout$2:val$source	Lokio/Source;
        //   11: invokeinterface 33 1 0
        //   16: aload_0
        //   17: getfield 19	okio/AsyncTimeout$2:this$0	Lokio/AsyncTimeout;
        //   20: iconst_1
        //   21: invokevirtual 37	okio/AsyncTimeout:exit	(Z)V
        //   24: return
        //   25: astore_1
        //   26: goto +13 -> 39
        //   29: astore_1
        //   30: aload_0
        //   31: getfield 19	okio/AsyncTimeout$2:this$0	Lokio/AsyncTimeout;
        //   34: aload_1
        //   35: invokevirtual 40	okio/AsyncTimeout:exit	(Ljava/io/IOException;)Ljava/io/IOException;
        //   38: athrow
        //   39: aload_0
        //   40: getfield 19	okio/AsyncTimeout$2:this$0	Lokio/AsyncTimeout;
        //   43: iconst_0
        //   44: invokevirtual 37	okio/AsyncTimeout:exit	(Z)V
        //   47: aload_1
        //   48: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	49	0	this	2
        //   25	1	1	localObject	Object
        //   29	19	1	localIOException	IOException
        // Exception table:
        //   from	to	target	type
        //   7	16	25	finally
        //   30	39	25	finally
        //   7	16	29	java/io/IOException
      }
      
      /* Error */
      public long read(Buffer paramAnonymousBuffer, long paramAnonymousLong)
        throws IOException
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 19	okio/AsyncTimeout$2:this$0	Lokio/AsyncTimeout;
        //   4: invokevirtual 31	okio/AsyncTimeout:enter	()V
        //   7: aload_0
        //   8: getfield 21	okio/AsyncTimeout$2:val$source	Lokio/Source;
        //   11: aload_1
        //   12: lload_2
        //   13: invokeinterface 45 4 0
        //   18: lstore_2
        //   19: aload_0
        //   20: getfield 19	okio/AsyncTimeout$2:this$0	Lokio/AsyncTimeout;
        //   23: iconst_1
        //   24: invokevirtual 37	okio/AsyncTimeout:exit	(Z)V
        //   27: lload_2
        //   28: lreturn
        //   29: astore_1
        //   30: goto +13 -> 43
        //   33: astore_1
        //   34: aload_0
        //   35: getfield 19	okio/AsyncTimeout$2:this$0	Lokio/AsyncTimeout;
        //   38: aload_1
        //   39: invokevirtual 40	okio/AsyncTimeout:exit	(Ljava/io/IOException;)Ljava/io/IOException;
        //   42: athrow
        //   43: aload_0
        //   44: getfield 19	okio/AsyncTimeout$2:this$0	Lokio/AsyncTimeout;
        //   47: iconst_0
        //   48: invokevirtual 37	okio/AsyncTimeout:exit	(Z)V
        //   51: aload_1
        //   52: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	53	0	this	2
        //   0	53	1	paramAnonymousBuffer	Buffer
        //   0	53	2	paramAnonymousLong	long
        // Exception table:
        //   from	to	target	type
        //   7	19	29	finally
        //   34	43	29	finally
        //   7	19	33	java/io/IOException
      }
      
      public Timeout timeout()
      {
        return AsyncTimeout.this;
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("AsyncTimeout.source(");
        localStringBuilder.append(paramSource);
        localStringBuilder.append(")");
        return localStringBuilder.toString();
      }
    };
  }
  
  protected void timedOut() {}
  
  private static final class Watchdog
    extends Thread
  {
    Watchdog()
    {
      super();
      setDaemon(true);
    }
    
    public void run()
    {
      try
      {
        for (;;)
        {
          try
          {
            AsyncTimeout localAsyncTimeout = AsyncTimeout.awaitTimeout();
            if (localAsyncTimeout == null) {}
            if (localAsyncTimeout == AsyncTimeout.head)
            {
              AsyncTimeout.head = null;
              return;
            }
            localAsyncTimeout.timedOut();
          }
          finally {}
        }
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okio\AsyncTimeout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */