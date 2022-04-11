package io.netty.handler.codec.http.websocketx.extensions.compression;

import io.netty.buffer.AbstractReferenceCountedByteBuf;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.CodecException;
import io.netty.handler.codec.compression.ZlibCodecFactory;
import io.netty.handler.codec.compression.ZlibWrapper;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.ContinuationWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionDecoder;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionFilter;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

abstract class DeflateDecoder
  extends WebSocketExtensionDecoder
{
  static final ByteBuf EMPTY_DEFLATE_BLOCK = Unpooled.unreleasableBuffer(Unpooled.wrappedBuffer(new byte[] { 0 })).asReadOnly();
  static final ByteBuf FRAME_TAIL = Unpooled.unreleasableBuffer(Unpooled.wrappedBuffer(new byte[] { 0, 0, -1, -1 })).asReadOnly();
  private EmbeddedChannel decoder;
  private final WebSocketExtensionFilter extensionDecoderFilter;
  private final boolean noContext;
  
  DeflateDecoder(boolean paramBoolean, WebSocketExtensionFilter paramWebSocketExtensionFilter)
  {
    this.noContext = paramBoolean;
    this.extensionDecoderFilter = ((WebSocketExtensionFilter)ObjectUtil.checkNotNull(paramWebSocketExtensionFilter, "extensionDecoderFilter"));
  }
  
  private void cleanup()
  {
    EmbeddedChannel localEmbeddedChannel = this.decoder;
    if (localEmbeddedChannel != null)
    {
      localEmbeddedChannel.finishAndReleaseAll();
      this.decoder = null;
    }
  }
  
  private ByteBuf decompressContent(ChannelHandlerContext paramChannelHandlerContext, WebSocketFrame paramWebSocketFrame)
  {
    if (this.decoder == null)
    {
      if ((!(paramWebSocketFrame instanceof TextWebSocketFrame)) && (!(paramWebSocketFrame instanceof BinaryWebSocketFrame)))
      {
        paramChannelHandlerContext = new StringBuilder();
        paramChannelHandlerContext.append("unexpected initial frame type: ");
        paramChannelHandlerContext.append(paramWebSocketFrame.getClass().getName());
        throw new CodecException(paramChannelHandlerContext.toString());
      }
      this.decoder = new EmbeddedChannel(new ChannelHandler[] { ZlibCodecFactory.newZlibDecoder(ZlibWrapper.NONE) });
    }
    boolean bool1 = paramWebSocketFrame.content().isReadable();
    boolean bool2 = EMPTY_DEFLATE_BLOCK.equals(paramWebSocketFrame.content());
    this.decoder.writeInbound(new Object[] { paramWebSocketFrame.content().retain() });
    if (appendFrameTail(paramWebSocketFrame)) {
      this.decoder.writeInbound(new Object[] { FRAME_TAIL.duplicate() });
    }
    CompositeByteBuf localCompositeByteBuf = paramChannelHandlerContext.alloc().compositeBuffer();
    for (;;)
    {
      paramChannelHandlerContext = (ByteBuf)this.decoder.readInbound();
      if (paramChannelHandlerContext == null)
      {
        if ((!bool2) && (bool1) && (localCompositeByteBuf.numComponents() <= 0) && (!(paramWebSocketFrame instanceof ContinuationWebSocketFrame)))
        {
          localCompositeByteBuf.release();
          throw new CodecException("cannot read uncompressed buffer");
        }
        if ((paramWebSocketFrame.isFinalFragment()) && (this.noContext)) {
          cleanup();
        }
        return localCompositeByteBuf;
      }
      if (!paramChannelHandlerContext.isReadable()) {
        paramChannelHandlerContext.release();
      } else {
        localCompositeByteBuf.addComponent(true, paramChannelHandlerContext);
      }
    }
  }
  
  protected abstract boolean appendFrameTail(WebSocketFrame paramWebSocketFrame);
  
  public void channelInactive(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    cleanup();
    super.channelInactive(paramChannelHandlerContext);
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, WebSocketFrame paramWebSocketFrame, List<Object> paramList)
    throws Exception
  {
    paramChannelHandlerContext = decompressContent(paramChannelHandlerContext, paramWebSocketFrame);
    if ((paramWebSocketFrame instanceof TextWebSocketFrame))
    {
      paramChannelHandlerContext = new TextWebSocketFrame(paramWebSocketFrame.isFinalFragment(), newRsv(paramWebSocketFrame), paramChannelHandlerContext);
    }
    else if ((paramWebSocketFrame instanceof BinaryWebSocketFrame))
    {
      paramChannelHandlerContext = new BinaryWebSocketFrame(paramWebSocketFrame.isFinalFragment(), newRsv(paramWebSocketFrame), paramChannelHandlerContext);
    }
    else
    {
      if (!(paramWebSocketFrame instanceof ContinuationWebSocketFrame)) {
        break label97;
      }
      paramChannelHandlerContext = new ContinuationWebSocketFrame(paramWebSocketFrame.isFinalFragment(), newRsv(paramWebSocketFrame), paramChannelHandlerContext);
    }
    paramList.add(paramChannelHandlerContext);
    return;
    label97:
    paramChannelHandlerContext = new StringBuilder();
    paramChannelHandlerContext.append("unexpected frame type: ");
    paramChannelHandlerContext.append(paramWebSocketFrame.getClass().getName());
    throw new CodecException(paramChannelHandlerContext.toString());
  }
  
  protected WebSocketExtensionFilter extensionDecoderFilter()
  {
    return this.extensionDecoderFilter;
  }
  
  public void handlerRemoved(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    cleanup();
    super.handlerRemoved(paramChannelHandlerContext);
  }
  
  protected abstract int newRsv(WebSocketFrame paramWebSocketFrame);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\extensions\compression\DeflateDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */