package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPromise;
import io.netty.channel.ChannelPromiseNotifier;
import io.netty.handler.codec.EncoderException;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.ReferenceCounted;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.internal.ObjectUtil;
import java.nio.ByteBuffer;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.zip.Checksum;
import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Exception;
import net.jpountz.lz4.LZ4Factory;

public class Lz4FrameEncoder
  extends MessageToByteEncoder<ByteBuf>
{
  static final int DEFAULT_MAX_ENCODE_SIZE = Integer.MAX_VALUE;
  private final int blockSize;
  private ByteBuf buffer;
  private final ByteBufChecksum checksum;
  private final int compressionLevel;
  private final LZ4Compressor compressor;
  private volatile ChannelHandlerContext ctx;
  private volatile boolean finished;
  private final int maxEncodeSize;
  
  public Lz4FrameEncoder()
  {
    this(false);
  }
  
  public Lz4FrameEncoder(LZ4Factory paramLZ4Factory, boolean paramBoolean, int paramInt, Checksum paramChecksum)
  {
    this(paramLZ4Factory, paramBoolean, paramInt, paramChecksum, Integer.MAX_VALUE);
  }
  
  public Lz4FrameEncoder(LZ4Factory paramLZ4Factory, boolean paramBoolean, int paramInt1, Checksum paramChecksum, int paramInt2)
  {
    ObjectUtil.checkNotNull(paramLZ4Factory, "factory");
    ObjectUtil.checkNotNull(paramChecksum, "checksum");
    if (paramBoolean) {
      paramLZ4Factory = paramLZ4Factory.highCompressor();
    } else {
      paramLZ4Factory = paramLZ4Factory.fastCompressor();
    }
    this.compressor = paramLZ4Factory;
    this.checksum = ByteBufChecksum.wrapChecksum(paramChecksum);
    this.compressionLevel = compressionLevel(paramInt1);
    this.blockSize = paramInt1;
    this.maxEncodeSize = ObjectUtil.checkPositive(paramInt2, "maxEncodeSize");
    this.finished = false;
  }
  
  public Lz4FrameEncoder(boolean paramBoolean)
  {
    this(LZ4Factory.fastestInstance(), paramBoolean, 65536, new Lz4XXHash32(-1756908916));
  }
  
  private ByteBuf allocateBuffer(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = paramByteBuf.readableBytes() + this.buffer.readableBytes();
    if (i >= 0)
    {
      int j = 0;
      while (i > 0)
      {
        int k = Math.min(this.blockSize, i);
        i -= k;
        j += this.compressor.maxCompressedLength(k) + 21;
      }
      if ((j <= this.maxEncodeSize) && (j >= 0))
      {
        if ((paramBoolean2) && (j < this.blockSize)) {
          return Unpooled.EMPTY_BUFFER;
        }
        if (paramBoolean1) {
          return paramChannelHandlerContext.alloc().ioBuffer(j, j);
        }
        return paramChannelHandlerContext.alloc().heapBuffer(j, j);
      }
      throw new EncoderException(String.format("requested encode buffer size (%d bytes) exceeds the maximum allowable size (%d bytes)", new Object[] { Integer.valueOf(j), Integer.valueOf(this.maxEncodeSize) }));
    }
    throw new EncoderException("too much data to allocate a buffer for compression");
  }
  
  private static int compressionLevel(int paramInt)
  {
    if ((paramInt >= 64) && (paramInt <= 33554432)) {
      return Math.max(0, 32 - Integer.numberOfLeadingZeros(paramInt - 1) - 10);
    }
    throw new IllegalArgumentException(String.format("blockSize: %d (expected: %d-%d)", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(64), Integer.valueOf(33554432) }));
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
    ByteBuf localByteBuf = paramChannelHandlerContext.alloc().heapBuffer(this.compressor.maxCompressedLength(this.buffer.readableBytes()) + 21);
    flushBufferedData(localByteBuf);
    int i = localByteBuf.writerIndex();
    localByteBuf.setLong(i, 5501767354678207339L);
    localByteBuf.setByte(i + 8, (byte)(this.compressionLevel | 0x10));
    localByteBuf.setInt(i + 9, 0);
    localByteBuf.setInt(i + 13, 0);
    localByteBuf.setInt(i + 17, 0);
    localByteBuf.writerIndex(i + 21);
    return paramChannelHandlerContext.writeAndFlush(localByteBuf, paramChannelPromise);
  }
  
  private void flushBufferedData(ByteBuf paramByteBuf)
  {
    int i = this.buffer.readableBytes();
    if (i == 0) {
      return;
    }
    this.checksum.reset();
    Object localObject1 = this.checksum;
    Object localObject2 = this.buffer;
    ((ByteBufChecksum)localObject1).update((ByteBuf)localObject2, ((ByteBuf)localObject2).readerIndex(), i);
    int j = (int)this.checksum.getValue();
    paramByteBuf.ensureWritable(this.compressor.maxCompressedLength(i) + 21);
    int k = paramByteBuf.writerIndex();
    int m = k + 21;
    try
    {
      localObject1 = paramByteBuf.internalNioBuffer(m, paramByteBuf.writableBytes() - 21);
      int n = ((ByteBuffer)localObject1).position();
      localObject2 = this.compressor;
      ByteBuf localByteBuf = this.buffer;
      ((LZ4Compressor)localObject2).compress(localByteBuf.internalNioBuffer(localByteBuf.readerIndex(), i), (ByteBuffer)localObject1);
      int i1 = ((ByteBuffer)localObject1).position();
      i1 -= n;
      if (i1 >= i)
      {
        n = 16;
        paramByteBuf.setBytes(m, this.buffer, 0, i);
        i1 = i;
      }
      else
      {
        n = 32;
      }
      paramByteBuf.setLong(k, 5501767354678207339L);
      paramByteBuf.setByte(k + 8, (byte)(n | this.compressionLevel));
      paramByteBuf.setIntLE(k + 9, i1);
      paramByteBuf.setIntLE(k + 13, i);
      paramByteBuf.setIntLE(k + 17, j);
      paramByteBuf.writerIndex(m + i1);
      this.buffer.clear();
      return;
    }
    catch (LZ4Exception paramByteBuf)
    {
      throw new CompressionException(paramByteBuf);
    }
  }
  
  protected ByteBuf allocateBuffer(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, boolean paramBoolean)
  {
    return allocateBuffer(paramChannelHandlerContext, paramByteBuf, paramBoolean, true);
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
        Lz4FrameEncoder localLz4FrameEncoder = Lz4FrameEncoder.this;
        localLz4FrameEncoder.finishEncode(Lz4FrameEncoder.access$000(localLz4FrameEncoder), paramChannelPromise).addListener(new ChannelPromiseNotifier(new ChannelPromise[] { paramChannelPromise }));
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
      if (paramByteBuf2.isWritable(paramByteBuf1.readableBytes()))
      {
        paramByteBuf2.writeBytes(paramByteBuf1);
        return;
      }
      throw new IllegalStateException("encode finished and not enough space to write remaining data");
    }
    paramChannelHandlerContext = this.buffer;
    for (;;)
    {
      int i = paramByteBuf1.readableBytes();
      if (i <= 0) {
        break;
      }
      paramByteBuf1.readBytes(paramChannelHandlerContext, Math.min(i, paramChannelHandlerContext.writableBytes()));
      if (!paramChannelHandlerContext.isWritable()) {
        flushBufferedData(paramByteBuf2);
      }
    }
  }
  
  public void flush(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    ByteBuf localByteBuf = this.buffer;
    if ((localByteBuf != null) && (localByteBuf.isReadable()))
    {
      localByteBuf = allocateBuffer(paramChannelHandlerContext, Unpooled.EMPTY_BUFFER, isPreferDirect(), false);
      flushBufferedData(localByteBuf);
      paramChannelHandlerContext.write(localByteBuf);
    }
    paramChannelHandlerContext.flush();
  }
  
  final ByteBuf getBackingBuffer()
  {
    return this.buffer;
  }
  
  public void handlerAdded(ChannelHandlerContext paramChannelHandlerContext)
  {
    this.ctx = paramChannelHandlerContext;
    paramChannelHandlerContext = Unpooled.wrappedBuffer(new byte[this.blockSize]);
    this.buffer = paramChannelHandlerContext;
    paramChannelHandlerContext.clear();
  }
  
  public void handlerRemoved(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    super.handlerRemoved(paramChannelHandlerContext);
    paramChannelHandlerContext = this.buffer;
    if (paramChannelHandlerContext != null)
    {
      paramChannelHandlerContext.release();
      this.buffer = null;
    }
  }
  
  public boolean isClosed()
  {
    return this.finished;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\compression\Lz4FrameEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */