package io.netty.handler.codec.http.websocketx.extensions.compression;

import io.netty.buffer.AbstractByteBuf;
import io.netty.buffer.AbstractReferenceCountedByteBuf;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.CodecException;
import io.netty.handler.codec.compression.ZlibCodecFactory;
import io.netty.handler.codec.compression.ZlibWrapper;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.ContinuationWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionEncoder;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionFilter;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

abstract class DeflateEncoder
  extends WebSocketExtensionEncoder
{
  private final int compressionLevel;
  private EmbeddedChannel encoder;
  private final WebSocketExtensionFilter extensionEncoderFilter;
  private final boolean noContext;
  private final int windowSize;
  
  DeflateEncoder(int paramInt1, int paramInt2, boolean paramBoolean, WebSocketExtensionFilter paramWebSocketExtensionFilter)
  {
    this.compressionLevel = paramInt1;
    this.windowSize = paramInt2;
    this.noContext = paramBoolean;
    this.extensionEncoderFilter = ((WebSocketExtensionFilter)ObjectUtil.checkNotNull(paramWebSocketExtensionFilter, "extensionEncoderFilter"));
  }
  
  private void cleanup()
  {
    EmbeddedChannel localEmbeddedChannel = this.encoder;
    if (localEmbeddedChannel != null)
    {
      localEmbeddedChannel.finishAndReleaseAll();
      this.encoder = null;
    }
  }
  
  private ByteBuf compressContent(ChannelHandlerContext paramChannelHandlerContext, WebSocketFrame paramWebSocketFrame)
  {
    if (this.encoder == null) {
      this.encoder = new EmbeddedChannel(new ChannelHandler[] { ZlibCodecFactory.newZlibEncoder(ZlibWrapper.NONE, this.compressionLevel, this.windowSize, 8) });
    }
    this.encoder.writeOutbound(new Object[] { paramWebSocketFrame.content().retain() });
    CompositeByteBuf localCompositeByteBuf = paramChannelHandlerContext.alloc().compositeBuffer();
    for (;;)
    {
      paramChannelHandlerContext = (ByteBuf)this.encoder.readOutbound();
      if (paramChannelHandlerContext == null)
      {
        if (localCompositeByteBuf.numComponents() > 0)
        {
          if ((paramWebSocketFrame.isFinalFragment()) && (this.noContext)) {
            cleanup();
          }
          paramChannelHandlerContext = localCompositeByteBuf;
          if (removeFrameTail(paramWebSocketFrame)) {
            paramChannelHandlerContext = localCompositeByteBuf.slice(0, localCompositeByteBuf.readableBytes() - DeflateDecoder.FRAME_TAIL.readableBytes());
          }
          return paramChannelHandlerContext;
        }
        localCompositeByteBuf.release();
        throw new CodecException("cannot read compressed buffer");
      }
      if (!paramChannelHandlerContext.isReadable()) {
        paramChannelHandlerContext.release();
      } else {
        localCompositeByteBuf.addComponent(true, paramChannelHandlerContext);
      }
    }
  }
  
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, WebSocketFrame paramWebSocketFrame, List<Object> paramList)
    throws Exception
  {
    if (paramWebSocketFrame.content().isReadable())
    {
      paramChannelHandlerContext = compressContent(paramChannelHandlerContext, paramWebSocketFrame);
    }
    else
    {
      if (!paramWebSocketFrame.isFinalFragment()) {
        break label163;
      }
      paramChannelHandlerContext = DeflateDecoder.EMPTY_DEFLATE_BLOCK.duplicate();
    }
    if ((paramWebSocketFrame instanceof TextWebSocketFrame))
    {
      paramChannelHandlerContext = new TextWebSocketFrame(paramWebSocketFrame.isFinalFragment(), rsv(paramWebSocketFrame), paramChannelHandlerContext);
    }
    else if ((paramWebSocketFrame instanceof BinaryWebSocketFrame))
    {
      paramChannelHandlerContext = new BinaryWebSocketFrame(paramWebSocketFrame.isFinalFragment(), rsv(paramWebSocketFrame), paramChannelHandlerContext);
    }
    else
    {
      if (!(paramWebSocketFrame instanceof ContinuationWebSocketFrame)) {
        break label124;
      }
      paramChannelHandlerContext = new ContinuationWebSocketFrame(paramWebSocketFrame.isFinalFragment(), rsv(paramWebSocketFrame), paramChannelHandlerContext);
    }
    paramList.add(paramChannelHandlerContext);
    return;
    label124:
    paramChannelHandlerContext = new StringBuilder();
    paramChannelHandlerContext.append("unexpected frame type: ");
    paramChannelHandlerContext.append(paramWebSocketFrame.getClass().getName());
    throw new CodecException(paramChannelHandlerContext.toString());
    label163:
    throw new CodecException("cannot compress content buffer");
  }
  
  protected WebSocketExtensionFilter extensionEncoderFilter()
  {
    return this.extensionEncoderFilter;
  }
  
  public void handlerRemoved(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    cleanup();
    super.handlerRemoved(paramChannelHandlerContext);
  }
  
  protected abstract boolean removeFrameTail(WebSocketFrame paramWebSocketFrame);
  
  protected abstract int rsv(WebSocketFrame paramWebSocketFrame);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\extensions\compression\DeflateEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */