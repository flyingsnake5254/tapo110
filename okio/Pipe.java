package okio;

import java.io.IOException;
import javax.annotation.Nullable;

public final class Pipe
{
  final Buffer buffer = new Buffer();
  @Nullable
  private Sink foldedSink;
  final long maxBufferSize;
  private final Sink sink = new PipeSink();
  boolean sinkClosed;
  private final Source source = new PipeSource();
  boolean sourceClosed;
  
  public Pipe(long paramLong)
  {
    if (paramLong >= 1L)
    {
      this.maxBufferSize = paramLong;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("maxBufferSize < 1: ");
    localStringBuilder.append(paramLong);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void fold(Sink arg1)
    throws IOException
  {
    synchronized (this.buffer)
    {
      for (;;)
      {
        if (this.foldedSink == null)
        {
          if (this.buffer.exhausted())
          {
            this.sourceClosed = true;
            this.foldedSink = ???;
            return;
          }
          boolean bool = this.sinkClosed;
          Buffer localBuffer2 = new okio/Buffer;
          localBuffer2.<init>();
          Buffer localBuffer3 = this.buffer;
          localBuffer2.write(localBuffer3, localBuffer3.size);
          this.buffer.notifyAll();
          try
          {
            ???.write(localBuffer2, localBuffer2.size);
            if (bool)
            {
              ???.close();
              continue;
            }
            ???.flush();
          }
          finally {}
        }
      }
    }
  }
  
  public final Sink sink()
  {
    return this.sink;
  }
  
  public final Source source()
  {
    return this.source;
  }
  
  final class PipeSink
    implements Sink
  {
    final PushableTimeout timeout = new PushableTimeout();
    
    PipeSink() {}
    
    /* Error */
    public void close()
      throws IOException
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 17	okio/Pipe$PipeSink:this$0	Lokio/Pipe;
      //   4: getfield 33	okio/Pipe:buffer	Lokio/Buffer;
      //   7: astore_1
      //   8: aload_1
      //   9: monitorenter
      //   10: aload_0
      //   11: getfield 17	okio/Pipe$PipeSink:this$0	Lokio/Pipe;
      //   14: astore_2
      //   15: aload_2
      //   16: getfield 37	okio/Pipe:sinkClosed	Z
      //   19: ifeq +6 -> 25
      //   22: aload_1
      //   23: monitorexit
      //   24: return
      //   25: aload_2
      //   26: invokestatic 41	okio/Pipe:access$000	(Lokio/Pipe;)Lokio/Sink;
      //   29: ifnull +14 -> 43
      //   32: aload_0
      //   33: getfield 17	okio/Pipe$PipeSink:this$0	Lokio/Pipe;
      //   36: invokestatic 41	okio/Pipe:access$000	(Lokio/Pipe;)Lokio/Sink;
      //   39: astore_2
      //   40: goto +61 -> 101
      //   43: aload_0
      //   44: getfield 17	okio/Pipe$PipeSink:this$0	Lokio/Pipe;
      //   47: astore_2
      //   48: aload_2
      //   49: getfield 44	okio/Pipe:sourceClosed	Z
      //   52: ifeq +30 -> 82
      //   55: aload_2
      //   56: getfield 33	okio/Pipe:buffer	Lokio/Buffer;
      //   59: invokevirtual 50	okio/Buffer:size	()J
      //   62: lconst_0
      //   63: lcmp
      //   64: ifgt +6 -> 70
      //   67: goto +15 -> 82
      //   70: new 29	java/io/IOException
      //   73: astore_2
      //   74: aload_2
      //   75: ldc 52
      //   77: invokespecial 55	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   80: aload_2
      //   81: athrow
      //   82: aload_0
      //   83: getfield 17	okio/Pipe$PipeSink:this$0	Lokio/Pipe;
      //   86: astore_2
      //   87: aload_2
      //   88: iconst_1
      //   89: putfield 37	okio/Pipe:sinkClosed	Z
      //   92: aload_2
      //   93: getfield 33	okio/Pipe:buffer	Lokio/Buffer;
      //   96: invokevirtual 58	java/lang/Object:notifyAll	()V
      //   99: aconst_null
      //   100: astore_2
      //   101: aload_1
      //   102: monitorexit
      //   103: aload_2
      //   104: ifnull +42 -> 146
      //   107: aload_0
      //   108: getfield 25	okio/Pipe$PipeSink:timeout	Lokio/PushableTimeout;
      //   111: aload_2
      //   112: invokeinterface 61 1 0
      //   117: invokevirtual 65	okio/PushableTimeout:push	(Lokio/Timeout;)V
      //   120: aload_2
      //   121: invokeinterface 67 1 0
      //   126: aload_0
      //   127: getfield 25	okio/Pipe$PipeSink:timeout	Lokio/PushableTimeout;
      //   130: invokevirtual 70	okio/PushableTimeout:pop	()V
      //   133: goto +13 -> 146
      //   136: astore_2
      //   137: aload_0
      //   138: getfield 25	okio/Pipe$PipeSink:timeout	Lokio/PushableTimeout;
      //   141: invokevirtual 70	okio/PushableTimeout:pop	()V
      //   144: aload_2
      //   145: athrow
      //   146: return
      //   147: astore_2
      //   148: aload_1
      //   149: monitorexit
      //   150: aload_2
      //   151: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	152	0	this	PipeSink
      //   7	142	1	localBuffer	Buffer
      //   14	107	2	localObject1	Object
      //   136	9	2	localObject2	Object
      //   147	4	2	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   120	126	136	finally
      //   10	24	147	finally
      //   25	40	147	finally
      //   43	67	147	finally
      //   70	82	147	finally
      //   82	99	147	finally
      //   101	103	147	finally
      //   148	150	147	finally
    }
    
    /* Error */
    public void flush()
      throws IOException
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 17	okio/Pipe$PipeSink:this$0	Lokio/Pipe;
      //   4: getfield 33	okio/Pipe:buffer	Lokio/Buffer;
      //   7: astore_1
      //   8: aload_1
      //   9: monitorenter
      //   10: aload_0
      //   11: getfield 17	okio/Pipe$PipeSink:this$0	Lokio/Pipe;
      //   14: astore_2
      //   15: aload_2
      //   16: getfield 37	okio/Pipe:sinkClosed	Z
      //   19: ifne +108 -> 127
      //   22: aload_2
      //   23: invokestatic 41	okio/Pipe:access$000	(Lokio/Pipe;)Lokio/Sink;
      //   26: ifnull +14 -> 40
      //   29: aload_0
      //   30: getfield 17	okio/Pipe$PipeSink:this$0	Lokio/Pipe;
      //   33: invokestatic 41	okio/Pipe:access$000	(Lokio/Pipe;)Lokio/Sink;
      //   36: astore_2
      //   37: goto +44 -> 81
      //   40: aload_0
      //   41: getfield 17	okio/Pipe$PipeSink:this$0	Lokio/Pipe;
      //   44: astore_2
      //   45: aload_2
      //   46: getfield 44	okio/Pipe:sourceClosed	Z
      //   49: ifeq +30 -> 79
      //   52: aload_2
      //   53: getfield 33	okio/Pipe:buffer	Lokio/Buffer;
      //   56: invokevirtual 50	okio/Buffer:size	()J
      //   59: lconst_0
      //   60: lcmp
      //   61: ifgt +6 -> 67
      //   64: goto +15 -> 79
      //   67: new 29	java/io/IOException
      //   70: astore_2
      //   71: aload_2
      //   72: ldc 52
      //   74: invokespecial 55	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   77: aload_2
      //   78: athrow
      //   79: aconst_null
      //   80: astore_2
      //   81: aload_1
      //   82: monitorexit
      //   83: aload_2
      //   84: ifnull +42 -> 126
      //   87: aload_0
      //   88: getfield 25	okio/Pipe$PipeSink:timeout	Lokio/PushableTimeout;
      //   91: aload_2
      //   92: invokeinterface 61 1 0
      //   97: invokevirtual 65	okio/PushableTimeout:push	(Lokio/Timeout;)V
      //   100: aload_2
      //   101: invokeinterface 74 1 0
      //   106: aload_0
      //   107: getfield 25	okio/Pipe$PipeSink:timeout	Lokio/PushableTimeout;
      //   110: invokevirtual 70	okio/PushableTimeout:pop	()V
      //   113: goto +13 -> 126
      //   116: astore_2
      //   117: aload_0
      //   118: getfield 25	okio/Pipe$PipeSink:timeout	Lokio/PushableTimeout;
      //   121: invokevirtual 70	okio/PushableTimeout:pop	()V
      //   124: aload_2
      //   125: athrow
      //   126: return
      //   127: new 76	java/lang/IllegalStateException
      //   130: astore_2
      //   131: aload_2
      //   132: ldc 78
      //   134: invokespecial 79	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
      //   137: aload_2
      //   138: athrow
      //   139: astore_2
      //   140: aload_1
      //   141: monitorexit
      //   142: aload_2
      //   143: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	144	0	this	PipeSink
      //   7	134	1	localBuffer	Buffer
      //   14	87	2	localObject1	Object
      //   116	9	2	localObject2	Object
      //   130	8	2	localIllegalStateException	IllegalStateException
      //   139	4	2	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   100	106	116	finally
      //   10	37	139	finally
      //   40	64	139	finally
      //   67	79	139	finally
      //   81	83	139	finally
      //   127	139	139	finally
      //   140	142	139	finally
    }
    
    public Timeout timeout()
    {
      return this.timeout;
    }
    
    public void write(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      synchronized (Pipe.this.buffer)
      {
        if (!Pipe.this.sinkClosed)
        {
          while (paramLong > 0L)
          {
            if (Pipe.this.foldedSink != null)
            {
              localObject = Pipe.this.foldedSink;
              break label158;
            }
            localObject = Pipe.this;
            if (!((Pipe)localObject).sourceClosed)
            {
              long l = ((Pipe)localObject).maxBufferSize - ((Pipe)localObject).buffer.size();
              if (l == 0L)
              {
                this.timeout.waitUntilNotified(Pipe.this.buffer);
              }
              else
              {
                l = Math.min(l, paramLong);
                Pipe.this.buffer.write(paramBuffer, l);
                paramLong -= l;
                Pipe.this.buffer.notifyAll();
              }
            }
            else
            {
              paramBuffer = new java/io/IOException;
              paramBuffer.<init>("source is closed");
              throw paramBuffer;
            }
          }
          Object localObject = null;
          label158:
          if (localObject != null) {
            this.timeout.push(((Sink)localObject).timeout());
          }
          try
          {
            ((Sink)localObject).write(paramBuffer, paramLong);
            this.timeout.pop();
          }
          finally
          {
            this.timeout.pop();
          }
        }
        paramBuffer = new java/lang/IllegalStateException;
        paramBuffer.<init>("closed");
        throw paramBuffer;
      }
    }
  }
  
  final class PipeSource
    implements Source
  {
    final Timeout timeout = new Timeout();
    
    PipeSource() {}
    
    public void close()
      throws IOException
    {
      synchronized (Pipe.this.buffer)
      {
        Pipe localPipe = Pipe.this;
        localPipe.sourceClosed = true;
        localPipe.buffer.notifyAll();
        return;
      }
    }
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      synchronized (Pipe.this.buffer)
      {
        if (!Pipe.this.sourceClosed)
        {
          while (Pipe.this.buffer.size() == 0L)
          {
            Pipe localPipe = Pipe.this;
            if (localPipe.sinkClosed) {
              return -1L;
            }
            this.timeout.waitUntilNotified(localPipe.buffer);
          }
          paramLong = Pipe.this.buffer.read(paramBuffer, paramLong);
          Pipe.this.buffer.notifyAll();
          return paramLong;
        }
        paramBuffer = new java/lang/IllegalStateException;
        paramBuffer.<init>("closed");
        throw paramBuffer;
      }
    }
    
    public Timeout timeout()
    {
      return this.timeout;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okio\Pipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */