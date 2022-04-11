package io.netty.handler.stream;

import io.netty.channel.Channel;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelProgressivePromise;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.ProgressivePromise;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;

public class ChunkedWriteHandler
  extends ChannelDuplexHandler
{
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(ChunkedWriteHandler.class);
  private volatile ChannelHandlerContext ctx;
  private final Queue<PendingWrite> queue = new ArrayDeque();
  
  public ChunkedWriteHandler() {}
  
  @Deprecated
  public ChunkedWriteHandler(int paramInt)
  {
    if (paramInt > 0) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("maxPendingWrites: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" (expected: > 0)");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  /* Error */
  private static void closeInput(ChunkedInput<?> paramChunkedInput)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 89 1 0
    //   6: goto +26 -> 32
    //   9: astore_0
    //   10: getstatic 30	io/netty/handler/stream/ChunkedWriteHandler:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   13: invokeinterface 95 1 0
    //   18: ifeq +14 -> 32
    //   21: getstatic 30	io/netty/handler/stream/ChunkedWriteHandler:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   24: ldc 97
    //   26: aload_0
    //   27: invokeinterface 101 3 0
    //   32: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	paramChunkedInput	ChunkedInput<?>
    // Exception table:
    //   from	to	target	type
    //   0	6	9	finally
  }
  
  private void discard(Throwable paramThrowable)
  {
    for (;;)
    {
      Object localObject1 = (PendingWrite)this.queue.poll();
      if (localObject1 == null) {
        return;
      }
      Object localObject2 = ((PendingWrite)localObject1).msg;
      if ((localObject2 instanceof ChunkedInput))
      {
        Object localObject4 = (ChunkedInput)localObject2;
        try
        {
          boolean bool = ((ChunkedInput)localObject4).isEndOfInput();
          long l = ((ChunkedInput)localObject4).length();
          closeInput((ChunkedInput)localObject4);
          if (!bool)
          {
            localObject2 = paramThrowable;
            if (paramThrowable == null) {
              localObject2 = new ClosedChannelException();
            }
            ((PendingWrite)localObject1).fail((Throwable)localObject2);
            paramThrowable = (Throwable)localObject2;
            continue;
          }
          ((PendingWrite)localObject1).success(l);
        }
        catch (Exception localException)
        {
          closeInput((ChunkedInput)localObject4);
          ((PendingWrite)localObject1).fail(localException);
          localObject1 = logger;
        }
        if (((InternalLogger)localObject1).isWarnEnabled())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(ChunkedInput.class.getSimpleName());
          ((StringBuilder)localObject4).append(" failed");
          ((InternalLogger)localObject1).warn(((StringBuilder)localObject4).toString(), localException);
        }
      }
      else
      {
        Object localObject3 = paramThrowable;
        if (paramThrowable == null) {
          localObject3 = new ClosedChannelException();
        }
        ((PendingWrite)localObject1).fail((Throwable)localObject3);
        paramThrowable = (Throwable)localObject3;
      }
    }
  }
  
  /* Error */
  private void doFlush(ChannelHandlerContext paramChannelHandlerContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 150 1 0
    //   6: astore_2
    //   7: aload_2
    //   8: invokeinterface 155 1 0
    //   13: istore_3
    //   14: aconst_null
    //   15: astore 4
    //   17: iload_3
    //   18: ifne +9 -> 27
    //   21: aload_0
    //   22: aconst_null
    //   23: invokespecial 157	io/netty/handler/stream/ChunkedWriteHandler:discard	(Ljava/lang/Throwable;)V
    //   26: return
    //   27: aload_1
    //   28: invokeinterface 161 1 0
    //   33: astore 5
    //   35: iconst_1
    //   36: istore 6
    //   38: iload 6
    //   40: istore 7
    //   42: aload_2
    //   43: invokeinterface 164 1 0
    //   48: ifeq +361 -> 409
    //   51: aload_0
    //   52: getfield 39	io/netty/handler/stream/ChunkedWriteHandler:queue	Ljava/util/Queue;
    //   55: invokeinterface 167 1 0
    //   60: checkcast 12	io/netty/handler/stream/ChunkedWriteHandler$PendingWrite
    //   63: astore 8
    //   65: aload 8
    //   67: ifnonnull +10 -> 77
    //   70: iload 6
    //   72: istore 7
    //   74: goto +335 -> 409
    //   77: aload 8
    //   79: getfield 171	io/netty/handler/stream/ChunkedWriteHandler$PendingWrite:promise	Lio/netty/channel/ChannelPromise;
    //   82: invokeinterface 176 1 0
    //   87: ifeq +16 -> 103
    //   90: aload_0
    //   91: getfield 39	io/netty/handler/stream/ChunkedWriteHandler:queue	Ljava/util/Queue;
    //   94: invokeinterface 179 1 0
    //   99: pop
    //   100: goto -62 -> 38
    //   103: aload 8
    //   105: getfield 117	io/netty/handler/stream/ChunkedWriteHandler$PendingWrite:msg	Ljava/lang/Object;
    //   108: astore 9
    //   110: aload 9
    //   112: instanceof 86
    //   115: ifeq +243 -> 358
    //   118: aload 9
    //   120: checkcast 86	io/netty/handler/stream/ChunkedInput
    //   123: astore 10
    //   125: aload 10
    //   127: aload 5
    //   129: invokeinterface 183 2 0
    //   134: astore 9
    //   136: aload 10
    //   138: invokeinterface 120 1 0
    //   143: istore_3
    //   144: aload 9
    //   146: ifnonnull +11 -> 157
    //   149: iload_3
    //   150: iconst_1
    //   151: ixor
    //   152: istore 7
    //   154: goto +6 -> 160
    //   157: iconst_0
    //   158: istore 7
    //   160: iload 7
    //   162: ifeq +10 -> 172
    //   165: iload 6
    //   167: istore 7
    //   169: goto +240 -> 409
    //   172: aload 9
    //   174: astore 11
    //   176: aload 9
    //   178: ifnonnull +8 -> 186
    //   181: getstatic 189	io/netty/buffer/Unpooled:EMPTY_BUFFER	Lio/netty/buffer/ByteBuf;
    //   184: astore 11
    //   186: aload_1
    //   187: aload 11
    //   189: invokeinterface 195 2 0
    //   194: astore 9
    //   196: iload_3
    //   197: ifeq +54 -> 251
    //   200: aload_0
    //   201: getfield 39	io/netty/handler/stream/ChunkedWriteHandler:queue	Ljava/util/Queue;
    //   204: invokeinterface 179 1 0
    //   209: pop
    //   210: aload 9
    //   212: invokeinterface 176 1 0
    //   217: ifeq +13 -> 230
    //   220: aload 9
    //   222: aload 8
    //   224: invokestatic 76	io/netty/handler/stream/ChunkedWriteHandler:handleEndOfInputFuture	(Lio/netty/channel/ChannelFuture;Lio/netty/handler/stream/ChunkedWriteHandler$PendingWrite;)V
    //   227: goto +74 -> 301
    //   230: aload 9
    //   232: new 8	io/netty/handler/stream/ChunkedWriteHandler$2
    //   235: dup
    //   236: aload_0
    //   237: aload 8
    //   239: invokespecial 198	io/netty/handler/stream/ChunkedWriteHandler$2:<init>	(Lio/netty/handler/stream/ChunkedWriteHandler;Lio/netty/handler/stream/ChunkedWriteHandler$PendingWrite;)V
    //   242: invokeinterface 204 2 0
    //   247: pop
    //   248: goto +53 -> 301
    //   251: aload_2
    //   252: invokeinterface 164 1 0
    //   257: iconst_1
    //   258: ixor
    //   259: istore_3
    //   260: aload 9
    //   262: invokeinterface 176 1 0
    //   267: ifeq +15 -> 282
    //   270: aload_0
    //   271: aload 9
    //   273: aload 8
    //   275: iload_3
    //   276: invokespecial 82	io/netty/handler/stream/ChunkedWriteHandler:handleFuture	(Lio/netty/channel/ChannelFuture;Lio/netty/handler/stream/ChunkedWriteHandler$PendingWrite;Z)V
    //   279: goto +22 -> 301
    //   282: aload 9
    //   284: new 10	io/netty/handler/stream/ChunkedWriteHandler$3
    //   287: dup
    //   288: aload_0
    //   289: aload 8
    //   291: iload_3
    //   292: invokespecial 207	io/netty/handler/stream/ChunkedWriteHandler$3:<init>	(Lio/netty/handler/stream/ChunkedWriteHandler;Lio/netty/handler/stream/ChunkedWriteHandler$PendingWrite;Z)V
    //   295: invokeinterface 204 2 0
    //   300: pop
    //   301: iconst_0
    //   302: istore 7
    //   304: goto +81 -> 385
    //   307: astore 11
    //   309: goto +9 -> 318
    //   312: astore 11
    //   314: aload 4
    //   316: astore 9
    //   318: aload_0
    //   319: getfield 39	io/netty/handler/stream/ChunkedWriteHandler:queue	Ljava/util/Queue;
    //   322: invokeinterface 179 1 0
    //   327: pop
    //   328: aload 9
    //   330: ifnull +9 -> 339
    //   333: aload 9
    //   335: invokestatic 213	io/netty/util/ReferenceCountUtil:release	(Ljava/lang/Object;)Z
    //   338: pop
    //   339: aload 10
    //   341: invokestatic 126	io/netty/handler/stream/ChunkedWriteHandler:closeInput	(Lio/netty/handler/stream/ChunkedInput;)V
    //   344: aload 8
    //   346: aload 11
    //   348: invokevirtual 132	io/netty/handler/stream/ChunkedWriteHandler$PendingWrite:fail	(Ljava/lang/Throwable;)V
    //   351: iload 6
    //   353: istore 7
    //   355: goto +54 -> 409
    //   358: aload_0
    //   359: getfield 39	io/netty/handler/stream/ChunkedWriteHandler:queue	Ljava/util/Queue;
    //   362: invokeinterface 179 1 0
    //   367: pop
    //   368: aload_1
    //   369: aload 9
    //   371: aload 8
    //   373: getfield 171	io/netty/handler/stream/ChunkedWriteHandler$PendingWrite:promise	Lio/netty/channel/ChannelPromise;
    //   376: invokeinterface 217 3 0
    //   381: pop
    //   382: iconst_1
    //   383: istore 7
    //   385: iload 7
    //   387: istore 6
    //   389: aload_2
    //   390: invokeinterface 155 1 0
    //   395: ifne -357 -> 38
    //   398: aload_0
    //   399: new 128	java/nio/channels/ClosedChannelException
    //   402: dup
    //   403: invokespecial 129	java/nio/channels/ClosedChannelException:<init>	()V
    //   406: invokespecial 157	io/netty/handler/stream/ChunkedWriteHandler:discard	(Ljava/lang/Throwable;)V
    //   409: iload 7
    //   411: ifeq +10 -> 421
    //   414: aload_1
    //   415: invokeinterface 221 1 0
    //   420: pop
    //   421: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	422	0	this	ChunkedWriteHandler
    //   0	422	1	paramChannelHandlerContext	ChannelHandlerContext
    //   6	384	2	localChannel	Channel
    //   13	279	3	bool	boolean
    //   15	300	4	localObject1	Object
    //   33	95	5	localByteBufAllocator	io.netty.buffer.ByteBufAllocator
    //   36	352	6	i	int
    //   40	370	7	j	int
    //   63	309	8	localPendingWrite	PendingWrite
    //   108	262	9	localObject2	Object
    //   123	217	10	localChunkedInput	ChunkedInput
    //   174	14	11	localObject3	Object
    //   307	1	11	localObject4	Object
    //   312	35	11	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   136	144	307	finally
    //   125	136	312	finally
  }
  
  private static void handleEndOfInputFuture(ChannelFuture paramChannelFuture, PendingWrite paramPendingWrite)
  {
    ChunkedInput localChunkedInput = (ChunkedInput)paramPendingWrite.msg;
    if (!paramChannelFuture.isSuccess())
    {
      closeInput(localChunkedInput);
      paramPendingWrite.fail(paramChannelFuture.cause());
    }
    else
    {
      long l1 = localChunkedInput.progress();
      long l2 = localChunkedInput.length();
      closeInput(localChunkedInput);
      paramPendingWrite.progress(l1, l2);
      paramPendingWrite.success(l2);
    }
  }
  
  private void handleFuture(ChannelFuture paramChannelFuture, PendingWrite paramPendingWrite, boolean paramBoolean)
  {
    ChunkedInput localChunkedInput = (ChunkedInput)paramPendingWrite.msg;
    if (!paramChannelFuture.isSuccess())
    {
      closeInput(localChunkedInput);
      paramPendingWrite.fail(paramChannelFuture.cause());
    }
    else
    {
      paramPendingWrite.progress(localChunkedInput.progress(), localChunkedInput.length());
      if ((paramBoolean) && (paramChannelFuture.channel().isWritable())) {
        resumeTransfer();
      }
    }
  }
  
  private void resumeTransfer0(ChannelHandlerContext paramChannelHandlerContext)
  {
    try
    {
      doFlush(paramChannelHandlerContext);
    }
    catch (Exception paramChannelHandlerContext)
    {
      logger.warn("Unexpected exception while sending chunks.", paramChannelHandlerContext);
    }
  }
  
  public void channelInactive(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    doFlush(paramChannelHandlerContext);
    paramChannelHandlerContext.fireChannelInactive();
  }
  
  public void channelWritabilityChanged(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    if (paramChannelHandlerContext.channel().isWritable()) {
      doFlush(paramChannelHandlerContext);
    }
    paramChannelHandlerContext.fireChannelWritabilityChanged();
  }
  
  public void flush(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    doFlush(paramChannelHandlerContext);
  }
  
  public void handlerAdded(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    this.ctx = paramChannelHandlerContext;
  }
  
  public void resumeTransfer()
  {
    final ChannelHandlerContext localChannelHandlerContext = this.ctx;
    if (localChannelHandlerContext == null) {
      return;
    }
    if (localChannelHandlerContext.executor().inEventLoop()) {
      resumeTransfer0(localChannelHandlerContext);
    } else {
      localChannelHandlerContext.executor().execute(new Runnable()
      {
        public void run()
        {
          ChunkedWriteHandler.this.resumeTransfer0(localChannelHandlerContext);
        }
      });
    }
  }
  
  public void write(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, ChannelPromise paramChannelPromise)
    throws Exception
  {
    this.queue.add(new PendingWrite(paramObject, paramChannelPromise));
  }
  
  private static final class PendingWrite
  {
    final Object msg;
    final ChannelPromise promise;
    
    PendingWrite(Object paramObject, ChannelPromise paramChannelPromise)
    {
      this.msg = paramObject;
      this.promise = paramChannelPromise;
    }
    
    void fail(Throwable paramThrowable)
    {
      ReferenceCountUtil.release(this.msg);
      this.promise.tryFailure(paramThrowable);
    }
    
    void progress(long paramLong1, long paramLong2)
    {
      ChannelPromise localChannelPromise = this.promise;
      if ((localChannelPromise instanceof ChannelProgressivePromise)) {
        ((ChannelProgressivePromise)localChannelPromise).tryProgress(paramLong1, paramLong2);
      }
    }
    
    void success(long paramLong)
    {
      if (this.promise.isDone()) {
        return;
      }
      progress(paramLong, paramLong);
      this.promise.trySuccess();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\stream\ChunkedWriteHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */