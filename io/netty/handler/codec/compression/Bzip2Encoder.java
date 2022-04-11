package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPromise;
import io.netty.channel.ChannelPromiseNotifier;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.EventExecutorGroup;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Bzip2Encoder
  extends MessageToByteEncoder<ByteBuf>
{
  private Bzip2BlockCompressor blockCompressor;
  private volatile ChannelHandlerContext ctx;
  private State currentState = State.INIT;
  private volatile boolean finished;
  private final int streamBlockSize;
  private int streamCRC;
  private final Bzip2BitWriter writer = new Bzip2BitWriter();
  
  public Bzip2Encoder()
  {
    this(9);
  }
  
  public Bzip2Encoder(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 9))
    {
      this.streamBlockSize = (paramInt * 100000);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("blockSizeMultiplier: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" (expected: 1-9)");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private void closeBlock(ByteBuf paramByteBuf)
  {
    Bzip2BlockCompressor localBzip2BlockCompressor = this.blockCompressor;
    if (!localBzip2BlockCompressor.isEmpty())
    {
      localBzip2BlockCompressor.close(paramByteBuf);
      int i = localBzip2BlockCompressor.crc();
      int j = this.streamCRC;
      this.streamCRC = (i ^ (j >>> 31 | j << 1));
    }
  }
  
  private ChannelHandlerContext ctx()
  {
    ChannelHandlerContext localChannelHandlerContext = this.ctx;
    if (localChannelHandlerContext != null) {
      return localChannelHandlerContext;
    }
    throw new IllegalStateException("not added to a pipeline");
  }
  
  private ChannelFuture finishEncode(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
  {
    if (this.finished)
    {
      paramChannelPromise.setSuccess();
      return paramChannelPromise;
    }
    this.finished = true;
    ByteBuf localByteBuf = paramChannelHandlerContext.alloc().buffer();
    closeBlock(localByteBuf);
    int i = this.streamCRC;
    Bzip2BitWriter localBzip2BitWriter = this.writer;
    try
    {
      localBzip2BitWriter.writeBits(localByteBuf, 24, 1536581L);
      localBzip2BitWriter.writeBits(localByteBuf, 24, 3690640L);
      localBzip2BitWriter.writeInt(localByteBuf, i);
      localBzip2BitWriter.flush(localByteBuf);
      return paramChannelHandlerContext.writeAndFlush(localByteBuf, paramChannelPromise);
    }
    finally
    {
      this.blockCompressor = null;
    }
  }
  
  public ChannelFuture close()
  {
    return close(ctx().newPromise());
  }
  
  public ChannelFuture close(final ChannelPromise paramChannelPromise)
  {
    ChannelHandlerContext localChannelHandlerContext = ctx();
    EventExecutor localEventExecutor = localChannelHandlerContext.executor();
    if (localEventExecutor.inEventLoop()) {
      return finishEncode(localChannelHandlerContext, paramChannelPromise);
    }
    localEventExecutor.execute(new Runnable()
    {
      public void run()
      {
        Bzip2Encoder localBzip2Encoder = Bzip2Encoder.this;
        localBzip2Encoder.finishEncode(Bzip2Encoder.access$000(localBzip2Encoder), paramChannelPromise).addListener(new ChannelPromiseNotifier(new ChannelPromise[] { paramChannelPromise }));
      }
    });
    return paramChannelPromise;
  }
  
  public void close(final ChannelHandlerContext paramChannelHandlerContext, final ChannelPromise paramChannelPromise)
    throws Exception
  {
    ChannelFuture localChannelFuture = finishEncode(paramChannelHandlerContext, paramChannelHandlerContext.newPromise());
    localChannelFuture.addListener(new ChannelFutureListener()
    {
      public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
        throws Exception
      {
        paramChannelHandlerContext.close(paramChannelPromise);
      }
    });
    if (!localChannelFuture.isDone()) {
      paramChannelHandlerContext.executor().schedule(new Runnable()
      {
        public void run()
        {
          paramChannelHandlerContext.close(paramChannelPromise);
        }
      }, 10L, TimeUnit.SECONDS);
    }
  }
  
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf1, ByteBuf paramByteBuf2)
    throws Exception
  {
    if (this.finished)
    {
      paramByteBuf2.writeBytes(paramByteBuf1);
      return;
    }
    for (;;)
    {
      int i = 4.$SwitchMap$io$netty$handler$codec$compression$Bzip2Encoder$State[this.currentState.ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            break label123;
          }
          if (i == 4) {
            break label190;
          }
          throw new IllegalStateException();
        }
      }
      else
      {
        paramByteBuf2.ensureWritable(4);
        paramByteBuf2.writeMedium(4348520);
        paramByteBuf2.writeByte(this.streamBlockSize / 100000 + 48);
        this.currentState = State.INIT_BLOCK;
      }
      this.blockCompressor = new Bzip2BlockCompressor(this.writer, this.streamBlockSize);
      this.currentState = State.WRITE_DATA;
      label123:
      if (!paramByteBuf1.isReadable()) {
        return;
      }
      paramChannelHandlerContext = this.blockCompressor;
      i = Math.min(paramByteBuf1.readableBytes(), paramChannelHandlerContext.availableSize());
      paramByteBuf1.skipBytes(paramChannelHandlerContext.write(paramByteBuf1, paramByteBuf1.readerIndex(), i));
      if (!paramChannelHandlerContext.isFull())
      {
        if (paramByteBuf1.isReadable()) {}
      }
      else
      {
        this.currentState = State.CLOSE_BLOCK;
        label190:
        closeBlock(paramByteBuf2);
        this.currentState = State.INIT_BLOCK;
      }
    }
  }
  
  public void handlerAdded(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    this.ctx = paramChannelHandlerContext;
  }
  
  public boolean isClosed()
  {
    return this.finished;
  }
  
  private static enum State
  {
    static
    {
      State localState1 = new State("INIT", 0);
      INIT = localState1;
      State localState2 = new State("INIT_BLOCK", 1);
      INIT_BLOCK = localState2;
      State localState3 = new State("WRITE_DATA", 2);
      WRITE_DATA = localState3;
      State localState4 = new State("CLOSE_BLOCK", 3);
      CLOSE_BLOCK = localState4;
      $VALUES = new State[] { localState1, localState2, localState3, localState4 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\compression\Bzip2Encoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */