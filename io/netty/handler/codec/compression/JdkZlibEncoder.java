package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPromise;
import io.netty.channel.ChannelPromiseNotifier;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

public class JdkZlibEncoder
  extends ZlibEncoder
{
  private static final byte[] gzipHeader = { 31, -117, 8, 0, 0, 0, 0, 0, 0, 0 };
  private final CRC32 crc = new CRC32();
  private volatile ChannelHandlerContext ctx;
  private final Deflater deflater;
  private volatile boolean finished;
  private final ZlibWrapper wrapper;
  private boolean writeHeader;
  
  public JdkZlibEncoder()
  {
    this(6);
  }
  
  public JdkZlibEncoder(int paramInt)
  {
    this(ZlibWrapper.ZLIB, paramInt);
  }
  
  public JdkZlibEncoder(int paramInt, byte[] paramArrayOfByte)
  {
    this.writeHeader = true;
    if ((paramInt >= 0) && (paramInt <= 9))
    {
      ObjectUtil.checkNotNull(paramArrayOfByte, "dictionary");
      this.wrapper = ZlibWrapper.ZLIB;
      Deflater localDeflater = new Deflater(paramInt);
      this.deflater = localDeflater;
      localDeflater.setDictionary(paramArrayOfByte);
      return;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("compressionLevel: ");
    paramArrayOfByte.append(paramInt);
    paramArrayOfByte.append(" (expected: 0-9)");
    throw new IllegalArgumentException(paramArrayOfByte.toString());
  }
  
  public JdkZlibEncoder(ZlibWrapper paramZlibWrapper)
  {
    this(paramZlibWrapper, 6);
  }
  
  public JdkZlibEncoder(ZlibWrapper paramZlibWrapper, int paramInt)
  {
    boolean bool = true;
    this.writeHeader = true;
    if ((paramInt >= 0) && (paramInt <= 9))
    {
      ObjectUtil.checkNotNull(paramZlibWrapper, "wrapper");
      ZlibWrapper localZlibWrapper = ZlibWrapper.ZLIB_OR_NONE;
      if (paramZlibWrapper != localZlibWrapper)
      {
        this.wrapper = paramZlibWrapper;
        if (paramZlibWrapper == ZlibWrapper.ZLIB) {
          bool = false;
        }
        this.deflater = new Deflater(paramInt, bool);
        return;
      }
      paramZlibWrapper = new StringBuilder();
      paramZlibWrapper.append("wrapper '");
      paramZlibWrapper.append(localZlibWrapper);
      paramZlibWrapper.append("' is not allowed for compression.");
      throw new IllegalArgumentException(paramZlibWrapper.toString());
    }
    paramZlibWrapper = new StringBuilder();
    paramZlibWrapper.append("compressionLevel: ");
    paramZlibWrapper.append(paramInt);
    paramZlibWrapper.append(" (expected: 0-9)");
    throw new IllegalArgumentException(paramZlibWrapper.toString());
  }
  
  public JdkZlibEncoder(byte[] paramArrayOfByte)
  {
    this(6, paramArrayOfByte);
  }
  
  private ChannelHandlerContext ctx()
  {
    ChannelHandlerContext localChannelHandlerContext = this.ctx;
    if (localChannelHandlerContext != null) {
      return localChannelHandlerContext;
    }
    throw new IllegalStateException("not added to a pipeline");
  }
  
  @SuppressJava6Requirement(reason="Usage guarded by java version check")
  private void deflate(ByteBuf paramByteBuf)
  {
    if (PlatformDependent.javaVersion() < 7) {
      deflateJdk6(paramByteBuf);
    }
    int j;
    do
    {
      int i = paramByteBuf.writerIndex();
      j = this.deflater.deflate(paramByteBuf.array(), paramByteBuf.arrayOffset() + i, paramByteBuf.writableBytes(), 2);
      paramByteBuf.writerIndex(i + j);
    } while (j > 0);
  }
  
  private void deflateJdk6(ByteBuf paramByteBuf)
  {
    int j;
    do
    {
      int i = paramByteBuf.writerIndex();
      j = this.deflater.deflate(paramByteBuf.array(), paramByteBuf.arrayOffset() + i, paramByteBuf.writableBytes());
      paramByteBuf.writerIndex(i + j);
    } while (j > 0);
  }
  
  private ChannelFuture finishEncode(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
  {
    if (this.finished)
    {
      paramChannelPromise.setSuccess();
      return paramChannelPromise;
    }
    this.finished = true;
    ByteBuf localByteBuf = paramChannelHandlerContext.alloc().heapBuffer();
    if ((this.writeHeader) && (this.wrapper == ZlibWrapper.GZIP))
    {
      this.writeHeader = false;
      localByteBuf.writeBytes(gzipHeader);
    }
    this.deflater.finish();
    while (!this.deflater.finished())
    {
      deflate(localByteBuf);
      if (!localByteBuf.isWritable())
      {
        paramChannelHandlerContext.write(localByteBuf);
        localByteBuf = paramChannelHandlerContext.alloc().heapBuffer();
      }
    }
    if (this.wrapper == ZlibWrapper.GZIP)
    {
      int i = (int)this.crc.getValue();
      int j = this.deflater.getTotalIn();
      localByteBuf.writeByte(i);
      localByteBuf.writeByte(i >>> 8);
      localByteBuf.writeByte(i >>> 16);
      localByteBuf.writeByte(i >>> 24);
      localByteBuf.writeByte(j);
      localByteBuf.writeByte(j >>> 8);
      localByteBuf.writeByte(j >>> 16);
      localByteBuf.writeByte(j >>> 24);
    }
    this.deflater.end();
    return paramChannelHandlerContext.writeAndFlush(localByteBuf, paramChannelPromise);
  }
  
  protected final ByteBuf allocateBuffer(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, boolean paramBoolean)
    throws Exception
  {
    int i = (int)Math.ceil(paramByteBuf.readableBytes() * 1.001D) + 12;
    int j = i;
    if (this.writeHeader)
    {
      j = 4.$SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[this.wrapper.ordinal()];
      if (j != 1)
      {
        if (j != 2) {
          j = i;
        } else {
          j = i + 2;
        }
      }
      else {
        j = i + gzipHeader.length;
      }
    }
    return paramChannelHandlerContext.alloc().heapBuffer(j);
  }
  
  public ChannelFuture close()
  {
    return close(ctx().newPromise());
  }
  
  public ChannelFuture close(final ChannelPromise paramChannelPromise)
  {
    final Object localObject = ctx();
    EventExecutor localEventExecutor = ((ChannelHandlerContext)localObject).executor();
    if (localEventExecutor.inEventLoop()) {
      return finishEncode((ChannelHandlerContext)localObject, paramChannelPromise);
    }
    localObject = ((ChannelOutboundInvoker)localObject).newPromise();
    localEventExecutor.execute(new Runnable()
    {
      public void run()
      {
        JdkZlibEncoder localJdkZlibEncoder = JdkZlibEncoder.this;
        localJdkZlibEncoder.finishEncode(JdkZlibEncoder.access$000(localJdkZlibEncoder), localObject).addListener(new ChannelPromiseNotifier(new ChannelPromise[] { paramChannelPromise }));
      }
    });
    return (ChannelFuture)localObject;
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
    int i = paramByteBuf1.readableBytes();
    if (i == 0) {
      return;
    }
    int j;
    if (paramByteBuf1.hasArray())
    {
      paramChannelHandlerContext = paramByteBuf1.array();
      j = paramByteBuf1.arrayOffset() + paramByteBuf1.readerIndex();
      paramByteBuf1.skipBytes(i);
    }
    else
    {
      paramChannelHandlerContext = new byte[i];
      paramByteBuf1.readBytes(paramChannelHandlerContext);
      j = 0;
    }
    if (this.writeHeader)
    {
      this.writeHeader = false;
      if (this.wrapper == ZlibWrapper.GZIP) {
        paramByteBuf2.writeBytes(gzipHeader);
      }
    }
    if (this.wrapper == ZlibWrapper.GZIP) {
      this.crc.update(paramChannelHandlerContext, j, i);
    }
    this.deflater.setInput(paramChannelHandlerContext, j, i);
    for (;;)
    {
      deflate(paramByteBuf2);
      if (this.deflater.needsInput()) {
        return;
      }
      if (!paramByteBuf2.isWritable()) {
        paramByteBuf2.ensureWritable(paramByteBuf2.writerIndex());
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
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\compression\JdkZlibEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */