package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.ReferenceCounted;
import io.netty.util.concurrent.a;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;
import java.util.List;

public abstract class SslClientHelloHandler<T>
  extends ByteToMessageDecoder
  implements ChannelOutboundHandler
{
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(SslClientHelloHandler.class);
  private ByteBuf handshakeBuffer;
  private boolean handshakeFailed;
  private boolean readPending;
  private boolean suppressRead;
  
  private void releaseHandshakeBuffer()
  {
    releaseIfNotNull(this.handshakeBuffer);
    this.handshakeBuffer = null;
  }
  
  private static void releaseIfNotNull(ByteBuf paramByteBuf)
  {
    if (paramByteBuf != null) {
      paramByteBuf.release();
    }
  }
  
  private void select(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf)
    throws Exception
  {
    try
    {
      io.netty.util.concurrent.Future localFuture = lookup(paramChannelHandlerContext, paramByteBuf);
      if (localFuture.isDone())
      {
        onLookupComplete(paramChannelHandlerContext, localFuture);
      }
      else
      {
        this.suppressRead = true;
        a local1 = new io/netty/handler/ssl/SslClientHelloHandler$1;
        local1.<init>(this, paramByteBuf, paramChannelHandlerContext);
        localFuture.addListener(local1);
        paramByteBuf = null;
      }
    }
    finally {}
    try
    {
      PlatformDependent.throwException(paramChannelHandlerContext);
      return;
    }
    finally
    {
      releaseIfNotNull(paramByteBuf);
    }
  }
  
  public void bind(ChannelHandlerContext paramChannelHandlerContext, SocketAddress paramSocketAddress, ChannelPromise paramChannelPromise)
    throws Exception
  {
    paramChannelHandlerContext.bind(paramSocketAddress, paramChannelPromise);
  }
  
  public void close(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
    throws Exception
  {
    paramChannelHandlerContext.close(paramChannelPromise);
  }
  
  public void connect(ChannelHandlerContext paramChannelHandlerContext, SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2, ChannelPromise paramChannelPromise)
    throws Exception
  {
    paramChannelHandlerContext.connect(paramSocketAddress1, paramSocketAddress2, paramChannelPromise);
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    if ((!this.suppressRead) && (!this.handshakeFailed)) {
      try
      {
        int i = paramByteBuf.readerIndex();
        int j = paramByteBuf.readableBytes();
        int k = -1;
        while (j >= 5) {
          switch (paramByteBuf.getUnsignedByte(i))
          {
          default: 
            break;
          case 22: 
            if (paramByteBuf.getUnsignedByte(i + 1) == 3)
            {
              int m = paramByteBuf.getUnsignedShort(i + 3) + 5;
              if (j < m) {
                return;
              }
              if (m == 5)
              {
                select(paramChannelHandlerContext, null);
                return;
              }
              int n = i;
              int i1 = k;
              int i2 = m;
              if (k == -1)
              {
                n = i + 4;
                if (n > i + m) {
                  return;
                }
                i += 5;
                if (paramByteBuf.getUnsignedByte(i) != 1)
                {
                  select(paramChannelHandlerContext, null);
                  return;
                }
                i1 = paramByteBuf.getUnsignedMedium(i + 1);
                i2 = m - 4;
                if (i1 + 4 + 5 <= i2)
                {
                  select(paramChannelHandlerContext, paramByteBuf.retainedSlice(n + 5, i1));
                  return;
                }
                paramList = this.handshakeBuffer;
                if (paramList == null) {
                  this.handshakeBuffer = paramChannelHandlerContext.alloc().buffer(i1);
                } else {
                  paramList.clear();
                }
              }
              this.handshakeBuffer.writeBytes(paramByteBuf, n + 5, i2 - 5);
              i = n + i2;
              j -= i2;
              k = i1;
              if (i1 > this.handshakeBuffer.readableBytes()) {
                continue;
              }
              paramList = this.handshakeBuffer.setIndex(0, i1);
              this.handshakeBuffer = null;
              select(paramChannelHandlerContext, paramList);
            }
          case 20: 
          case 21: 
            i = SslUtils.getEncryptedPacketLength(paramByteBuf, i);
            if (i != -2)
            {
              if (i == -1) {
                return;
              }
              select(paramChannelHandlerContext, null);
              return;
            }
            this.handshakeFailed = true;
            paramList = new io/netty/handler/ssl/NotSslRecordException;
            localObject = new java/lang/StringBuilder;
            ((StringBuilder)localObject).<init>();
            ((StringBuilder)localObject).append("not an SSL/TLS record: ");
            ((StringBuilder)localObject).append(ByteBufUtil.hexDump(paramByteBuf));
            paramList.<init>(((StringBuilder)localObject).toString());
            paramByteBuf.skipBytes(paramByteBuf.readableBytes());
            localObject = new io/netty/handler/ssl/SniCompletionEvent;
            ((SniCompletionEvent)localObject).<init>(paramList);
            paramChannelHandlerContext.fireUserEventTriggered(localObject);
            SslUtils.handleHandshakeFailure(paramChannelHandlerContext, paramList, true);
            throw paramList;
            select(paramChannelHandlerContext, null);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject = logger;
        if (((InternalLogger)localObject).isDebugEnabled())
        {
          paramList = new StringBuilder();
          paramList.append("Unexpected client hello packet: ");
          paramList.append(ByteBufUtil.hexDump(paramByteBuf));
          ((InternalLogger)localObject).debug(paramList.toString(), localException);
        }
        select(paramChannelHandlerContext, null);
      }
      catch (NotSslRecordException paramChannelHandlerContext)
      {
        throw paramChannelHandlerContext;
      }
    }
  }
  
  public void deregister(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
    throws Exception
  {
    paramChannelHandlerContext.deregister(paramChannelPromise);
  }
  
  public void disconnect(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
    throws Exception
  {
    paramChannelHandlerContext.disconnect(paramChannelPromise);
  }
  
  public void flush(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    paramChannelHandlerContext.flush();
  }
  
  protected void handlerRemoved0(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    releaseHandshakeBuffer();
    super.handlerRemoved0(paramChannelHandlerContext);
  }
  
  protected abstract io.netty.util.concurrent.Future<T> lookup(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf)
    throws Exception;
  
  protected abstract void onLookupComplete(ChannelHandlerContext paramChannelHandlerContext, io.netty.util.concurrent.Future<T> paramFuture)
    throws Exception;
  
  public void read(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    if (this.suppressRead) {
      this.readPending = true;
    } else {
      paramChannelHandlerContext.read();
    }
  }
  
  public void write(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, ChannelPromise paramChannelPromise)
    throws Exception
  {
    paramChannelHandlerContext.write(paramObject, paramChannelPromise);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\SslClientHelloHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */