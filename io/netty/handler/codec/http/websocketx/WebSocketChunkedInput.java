package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.stream.ChunkedInput;
import io.netty.util.internal.ObjectUtil;

public final class WebSocketChunkedInput
  implements ChunkedInput<WebSocketFrame>
{
  private final ChunkedInput<ByteBuf> input;
  private final int rsv;
  
  public WebSocketChunkedInput(ChunkedInput<ByteBuf> paramChunkedInput)
  {
    this(paramChunkedInput, 0);
  }
  
  public WebSocketChunkedInput(ChunkedInput<ByteBuf> paramChunkedInput, int paramInt)
  {
    this.input = ((ChunkedInput)ObjectUtil.checkNotNull(paramChunkedInput, "input"));
    this.rsv = paramInt;
  }
  
  public void close()
    throws Exception
  {
    this.input.close();
  }
  
  public boolean isEndOfInput()
    throws Exception
  {
    return this.input.isEndOfInput();
  }
  
  public long length()
  {
    return this.input.length();
  }
  
  public long progress()
  {
    return this.input.progress();
  }
  
  public WebSocketFrame readChunk(ByteBufAllocator paramByteBufAllocator)
    throws Exception
  {
    paramByteBufAllocator = (ByteBuf)this.input.readChunk(paramByteBufAllocator);
    if (paramByteBufAllocator == null) {
      return null;
    }
    return new ContinuationWebSocketFrame(this.input.isEndOfInput(), this.rsv, paramByteBufAllocator);
  }
  
  @Deprecated
  public WebSocketFrame readChunk(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    return readChunk(paramChannelHandlerContext.alloc());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\WebSocketChunkedInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */