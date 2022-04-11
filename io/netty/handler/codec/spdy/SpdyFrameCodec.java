package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.UnsupportedMessageTypeException;
import io.netty.util.ReferenceCounted;
import java.net.SocketAddress;
import java.util.List;

public class SpdyFrameCodec
  extends ByteToMessageDecoder
  implements SpdyFrameDecoderDelegate, ChannelOutboundHandler
{
  private static final SpdyProtocolException INVALID_FRAME = new SpdyProtocolException("Received invalid frame");
  private ChannelHandlerContext ctx;
  private boolean read;
  private final SpdyFrameDecoder spdyFrameDecoder;
  private final SpdyFrameEncoder spdyFrameEncoder;
  private final SpdyHeaderBlockDecoder spdyHeaderBlockDecoder;
  private final SpdyHeaderBlockEncoder spdyHeaderBlockEncoder;
  private SpdyHeadersFrame spdyHeadersFrame;
  private SpdySettingsFrame spdySettingsFrame;
  private final boolean validateHeaders;
  
  public SpdyFrameCodec(SpdyVersion paramSpdyVersion)
  {
    this(paramSpdyVersion, true);
  }
  
  public SpdyFrameCodec(SpdyVersion paramSpdyVersion, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this(paramSpdyVersion, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, true);
  }
  
  public SpdyFrameCodec(SpdyVersion paramSpdyVersion, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    this(paramSpdyVersion, paramInt1, SpdyHeaderBlockDecoder.newInstance(paramSpdyVersion, paramInt2), SpdyHeaderBlockEncoder.newInstance(paramSpdyVersion, paramInt3, paramInt4, paramInt5), paramBoolean);
  }
  
  protected SpdyFrameCodec(SpdyVersion paramSpdyVersion, int paramInt, SpdyHeaderBlockDecoder paramSpdyHeaderBlockDecoder, SpdyHeaderBlockEncoder paramSpdyHeaderBlockEncoder, boolean paramBoolean)
  {
    this.spdyFrameDecoder = new SpdyFrameDecoder(paramSpdyVersion, this, paramInt);
    this.spdyFrameEncoder = new SpdyFrameEncoder(paramSpdyVersion);
    this.spdyHeaderBlockDecoder = paramSpdyHeaderBlockDecoder;
    this.spdyHeaderBlockEncoder = paramSpdyHeaderBlockEncoder;
    this.validateHeaders = paramBoolean;
  }
  
  public SpdyFrameCodec(SpdyVersion paramSpdyVersion, boolean paramBoolean)
  {
    this(paramSpdyVersion, 8192, 16384, 6, 15, 8, paramBoolean);
  }
  
  public void bind(ChannelHandlerContext paramChannelHandlerContext, SocketAddress paramSocketAddress, ChannelPromise paramChannelPromise)
    throws Exception
  {
    paramChannelHandlerContext.bind(paramSocketAddress, paramChannelPromise);
  }
  
  public void channelReadComplete(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    if ((!this.read) && (!paramChannelHandlerContext.channel().config().isAutoRead())) {
      paramChannelHandlerContext.read();
    }
    this.read = false;
    super.channelReadComplete(paramChannelHandlerContext);
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
    this.spdyFrameDecoder.decode(paramByteBuf);
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
  
  public void handlerAdded(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    super.handlerAdded(paramChannelHandlerContext);
    this.ctx = paramChannelHandlerContext;
    paramChannelHandlerContext.channel().closeFuture().addListener(new ChannelFutureListener()
    {
      public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
        throws Exception
      {
        SpdyFrameCodec.this.spdyHeaderBlockDecoder.end();
        SpdyFrameCodec.this.spdyHeaderBlockEncoder.end();
      }
    });
  }
  
  public void read(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    paramChannelHandlerContext.read();
  }
  
  public void readDataFrame(int paramInt, boolean paramBoolean, ByteBuf paramByteBuf)
  {
    this.read = true;
    paramByteBuf = new DefaultSpdyDataFrame(paramInt, paramByteBuf);
    paramByteBuf.setLast(paramBoolean);
    this.ctx.fireChannelRead(paramByteBuf);
  }
  
  public void readFrameError(String paramString)
  {
    this.ctx.fireExceptionCaught(INVALID_FRAME);
  }
  
  public void readGoAwayFrame(int paramInt1, int paramInt2)
  {
    this.read = true;
    DefaultSpdyGoAwayFrame localDefaultSpdyGoAwayFrame = new DefaultSpdyGoAwayFrame(paramInt1, paramInt2);
    this.ctx.fireChannelRead(localDefaultSpdyGoAwayFrame);
  }
  
  /* Error */
  public void readHeaderBlock(ByteBuf paramByteBuf)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 81	io/netty/handler/codec/spdy/SpdyFrameCodec:spdyHeaderBlockDecoder	Lio/netty/handler/codec/spdy/SpdyHeaderBlockDecoder;
    //   4: aload_0
    //   5: getfield 159	io/netty/handler/codec/spdy/SpdyFrameCodec:ctx	Lio/netty/channel/ChannelHandlerContext;
    //   8: invokeinterface 205 1 0
    //   13: aload_1
    //   14: aload_0
    //   15: getfield 207	io/netty/handler/codec/spdy/SpdyFrameCodec:spdyHeadersFrame	Lio/netty/handler/codec/spdy/SpdyHeadersFrame;
    //   18: invokevirtual 210	io/netty/handler/codec/spdy/SpdyHeaderBlockDecoder:decode	(Lio/netty/buffer/ByteBufAllocator;Lio/netty/buffer/ByteBuf;Lio/netty/handler/codec/spdy/SpdyHeadersFrame;)V
    //   21: goto +19 -> 40
    //   24: astore_2
    //   25: goto +23 -> 48
    //   28: astore_2
    //   29: aload_0
    //   30: getfield 159	io/netty/handler/codec/spdy/SpdyFrameCodec:ctx	Lio/netty/channel/ChannelHandlerContext;
    //   33: aload_2
    //   34: invokeinterface 194 2 0
    //   39: pop
    //   40: aload_1
    //   41: invokeinterface 215 1 0
    //   46: pop
    //   47: return
    //   48: aload_1
    //   49: invokeinterface 215 1 0
    //   54: pop
    //   55: aload_2
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	SpdyFrameCodec
    //   0	57	1	paramByteBuf	ByteBuf
    //   24	1	2	localObject	Object
    //   28	28	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	21	24	finally
    //   29	40	24	finally
    //   0	21	28	java/lang/Exception
  }
  
  public void readHeaderBlockEnd()
  {
    SpdyHeadersFrame localSpdyHeadersFrame;
    try
    {
      this.spdyHeaderBlockDecoder.endHeaderBlock(this.spdyHeadersFrame);
      localSpdyHeadersFrame = this.spdyHeadersFrame;
      try
      {
        this.spdyHeadersFrame = null;
      }
      catch (Exception localException1) {}
      this.ctx.fireExceptionCaught(localException2);
    }
    catch (Exception localException2)
    {
      localSpdyHeadersFrame = null;
    }
    if (localSpdyHeadersFrame != null)
    {
      this.read = true;
      this.ctx.fireChannelRead(localSpdyHeadersFrame);
    }
  }
  
  public void readHeadersFrame(int paramInt, boolean paramBoolean)
  {
    DefaultSpdyHeadersFrame localDefaultSpdyHeadersFrame = new DefaultSpdyHeadersFrame(paramInt, this.validateHeaders);
    this.spdyHeadersFrame = localDefaultSpdyHeadersFrame;
    localDefaultSpdyHeadersFrame.setLast(paramBoolean);
  }
  
  public void readPingFrame(int paramInt)
  {
    this.read = true;
    DefaultSpdyPingFrame localDefaultSpdyPingFrame = new DefaultSpdyPingFrame(paramInt);
    this.ctx.fireChannelRead(localDefaultSpdyPingFrame);
  }
  
  public void readRstStreamFrame(int paramInt1, int paramInt2)
  {
    this.read = true;
    DefaultSpdyRstStreamFrame localDefaultSpdyRstStreamFrame = new DefaultSpdyRstStreamFrame(paramInt1, paramInt2);
    this.ctx.fireChannelRead(localDefaultSpdyRstStreamFrame);
  }
  
  public void readSetting(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.spdySettingsFrame.setValue(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
  }
  
  public void readSettingsEnd()
  {
    this.read = true;
    SpdySettingsFrame localSpdySettingsFrame = this.spdySettingsFrame;
    this.spdySettingsFrame = null;
    this.ctx.fireChannelRead(localSpdySettingsFrame);
  }
  
  public void readSettingsFrame(boolean paramBoolean)
  {
    this.read = true;
    DefaultSpdySettingsFrame localDefaultSpdySettingsFrame = new DefaultSpdySettingsFrame();
    this.spdySettingsFrame = localDefaultSpdySettingsFrame;
    localDefaultSpdySettingsFrame.setClearPreviouslyPersistedSettings(paramBoolean);
  }
  
  public void readSynReplyFrame(int paramInt, boolean paramBoolean)
  {
    DefaultSpdySynReplyFrame localDefaultSpdySynReplyFrame = new DefaultSpdySynReplyFrame(paramInt, this.validateHeaders);
    localDefaultSpdySynReplyFrame.setLast(paramBoolean);
    this.spdyHeadersFrame = localDefaultSpdySynReplyFrame;
  }
  
  public void readSynStreamFrame(int paramInt1, int paramInt2, byte paramByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    DefaultSpdySynStreamFrame localDefaultSpdySynStreamFrame = new DefaultSpdySynStreamFrame(paramInt1, paramInt2, paramByte, this.validateHeaders);
    localDefaultSpdySynStreamFrame.setLast(paramBoolean1);
    localDefaultSpdySynStreamFrame.setUnidirectional(paramBoolean2);
    this.spdyHeadersFrame = localDefaultSpdySynStreamFrame;
  }
  
  public void readWindowUpdateFrame(int paramInt1, int paramInt2)
  {
    this.read = true;
    DefaultSpdyWindowUpdateFrame localDefaultSpdyWindowUpdateFrame = new DefaultSpdyWindowUpdateFrame(paramInt1, paramInt2);
    this.ctx.fireChannelRead(localDefaultSpdyWindowUpdateFrame);
  }
  
  public void write(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, ChannelPromise paramChannelPromise)
    throws Exception
  {
    Object localObject;
    if ((paramObject instanceof SpdyDataFrame))
    {
      paramObject = (SpdyDataFrame)paramObject;
      localObject = this.spdyFrameEncoder.encodeDataFrame(paramChannelHandlerContext.alloc(), ((SpdyStreamFrame)paramObject).streamId(), ((SpdyStreamFrame)paramObject).isLast(), ((SpdyDataFrame)paramObject).content());
      ((ReferenceCounted)paramObject).release();
      paramChannelHandlerContext.write(localObject, paramChannelPromise);
    }
    else
    {
      if ((paramObject instanceof SpdySynStreamFrame))
      {
        localObject = (SpdySynStreamFrame)paramObject;
        paramObject = this.spdyHeaderBlockEncoder.encode(paramChannelHandlerContext.alloc(), (SpdyHeadersFrame)localObject);
      }
      try
      {
        localObject = this.spdyFrameEncoder.encodeSynStreamFrame(paramChannelHandlerContext.alloc(), ((SpdyStreamFrame)localObject).streamId(), ((SpdySynStreamFrame)localObject).associatedStreamId(), ((SpdySynStreamFrame)localObject).priority(), ((SpdyStreamFrame)localObject).isLast(), ((SpdySynStreamFrame)localObject).isUnidirectional(), (ByteBuf)paramObject);
        ((ReferenceCounted)paramObject).release();
        paramChannelHandlerContext.write(localObject, paramChannelPromise);
      }
      finally
      {
        ((ReferenceCounted)paramObject).release();
      }
      localObject = (SpdySynReplyFrame)paramObject;
      paramObject = this.spdyHeaderBlockEncoder.encode(paramChannelHandlerContext.alloc(), (SpdyHeadersFrame)localObject);
      try
      {
        localObject = this.spdyFrameEncoder.encodeSynReplyFrame(paramChannelHandlerContext.alloc(), ((SpdyStreamFrame)localObject).streamId(), ((SpdyStreamFrame)localObject).isLast(), (ByteBuf)paramObject);
        ((ReferenceCounted)paramObject).release();
        paramChannelHandlerContext.write(localObject, paramChannelPromise);
      }
      finally
      {
        ((ReferenceCounted)paramObject).release();
      }
      paramObject = (SpdyRstStreamFrame)paramObject;
      paramChannelHandlerContext.write(this.spdyFrameEncoder.encodeRstStreamFrame(paramChannelHandlerContext.alloc(), ((SpdyStreamFrame)paramObject).streamId(), ((SpdyRstStreamFrame)paramObject).status().code()), paramChannelPromise);
      break label579;
      if ((paramObject instanceof SpdySettingsFrame))
      {
        paramObject = (SpdySettingsFrame)paramObject;
        paramChannelHandlerContext.write(this.spdyFrameEncoder.encodeSettingsFrame(paramChannelHandlerContext.alloc(), (SpdySettingsFrame)paramObject), paramChannelPromise);
      }
      else if ((paramObject instanceof SpdyPingFrame))
      {
        paramObject = (SpdyPingFrame)paramObject;
        paramChannelHandlerContext.write(this.spdyFrameEncoder.encodePingFrame(paramChannelHandlerContext.alloc(), ((SpdyPingFrame)paramObject).id()), paramChannelPromise);
      }
      else if ((paramObject instanceof SpdyGoAwayFrame))
      {
        paramObject = (SpdyGoAwayFrame)paramObject;
        paramChannelHandlerContext.write(this.spdyFrameEncoder.encodeGoAwayFrame(paramChannelHandlerContext.alloc(), ((SpdyGoAwayFrame)paramObject).lastGoodStreamId(), ((SpdyGoAwayFrame)paramObject).status().code()), paramChannelPromise);
      }
      else
      {
        if ((paramObject instanceof SpdyHeadersFrame))
        {
          localObject = (SpdyHeadersFrame)paramObject;
          paramObject = this.spdyHeaderBlockEncoder.encode(paramChannelHandlerContext.alloc(), (SpdyHeadersFrame)localObject);
        }
        try
        {
          localObject = this.spdyFrameEncoder.encodeHeadersFrame(paramChannelHandlerContext.alloc(), ((SpdyStreamFrame)localObject).streamId(), ((SpdyStreamFrame)localObject).isLast(), (ByteBuf)paramObject);
          ((ReferenceCounted)paramObject).release();
          paramChannelHandlerContext.write(localObject, paramChannelPromise);
        }
        finally
        {
          ((ReferenceCounted)paramObject).release();
        }
        paramObject = (SpdyWindowUpdateFrame)paramObject;
        paramChannelHandlerContext.write(this.spdyFrameEncoder.encodeWindowUpdateFrame(paramChannelHandlerContext.alloc(), ((SpdyWindowUpdateFrame)paramObject).streamId(), ((SpdyWindowUpdateFrame)paramObject).deltaWindowSize()), paramChannelPromise);
      }
    }
    label579:
    return;
    throw new UnsupportedMessageTypeException(paramObject, new Class[0]);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\SpdyFrameCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */