package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.stream.ChunkedInput;

public class HttpChunkedInput
  implements ChunkedInput<HttpContent>
{
  private final ChunkedInput<ByteBuf> input;
  private final LastHttpContent lastHttpContent;
  private boolean sentLastChunk;
  
  public HttpChunkedInput(ChunkedInput<ByteBuf> paramChunkedInput)
  {
    this.input = paramChunkedInput;
    this.lastHttpContent = LastHttpContent.EMPTY_LAST_CONTENT;
  }
  
  public HttpChunkedInput(ChunkedInput<ByteBuf> paramChunkedInput, LastHttpContent paramLastHttpContent)
  {
    this.input = paramChunkedInput;
    this.lastHttpContent = paramLastHttpContent;
  }
  
  public void close()
    throws Exception
  {
    this.input.close();
  }
  
  public boolean isEndOfInput()
    throws Exception
  {
    if (this.input.isEndOfInput()) {
      return this.sentLastChunk;
    }
    return false;
  }
  
  public long length()
  {
    return this.input.length();
  }
  
  public long progress()
  {
    return this.input.progress();
  }
  
  public HttpContent readChunk(ByteBufAllocator paramByteBufAllocator)
    throws Exception
  {
    if (this.input.isEndOfInput())
    {
      if (this.sentLastChunk) {
        return null;
      }
      this.sentLastChunk = true;
      return this.lastHttpContent;
    }
    paramByteBufAllocator = (ByteBuf)this.input.readChunk(paramByteBufAllocator);
    if (paramByteBufAllocator == null) {
      return null;
    }
    return new DefaultHttpContent(paramByteBufAllocator);
  }
  
  @Deprecated
  public HttpContent readChunk(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    return readChunk(paramChannelHandlerContext.alloc());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\HttpChunkedInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */