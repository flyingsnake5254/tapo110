package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.DecoderResult;

final class ComposedLastHttpContent
  implements LastHttpContent
{
  private DecoderResult result;
  private final HttpHeaders trailingHeaders;
  
  ComposedLastHttpContent(HttpHeaders paramHttpHeaders)
  {
    this.trailingHeaders = paramHttpHeaders;
  }
  
  ComposedLastHttpContent(HttpHeaders paramHttpHeaders, DecoderResult paramDecoderResult)
  {
    this(paramHttpHeaders);
    this.result = paramDecoderResult;
  }
  
  public ByteBuf content()
  {
    return Unpooled.EMPTY_BUFFER;
  }
  
  public LastHttpContent copy()
  {
    DefaultLastHttpContent localDefaultLastHttpContent = new DefaultLastHttpContent(Unpooled.EMPTY_BUFFER);
    localDefaultLastHttpContent.trailingHeaders().set(trailingHeaders());
    return localDefaultLastHttpContent;
  }
  
  public DecoderResult decoderResult()
  {
    return this.result;
  }
  
  public LastHttpContent duplicate()
  {
    return copy();
  }
  
  public DecoderResult getDecoderResult()
  {
    return decoderResult();
  }
  
  public int refCnt()
  {
    return 1;
  }
  
  public boolean release()
  {
    return false;
  }
  
  public boolean release(int paramInt)
  {
    return false;
  }
  
  public LastHttpContent replace(ByteBuf paramByteBuf)
  {
    paramByteBuf = new DefaultLastHttpContent(paramByteBuf);
    paramByteBuf.trailingHeaders().setAll(trailingHeaders());
    return paramByteBuf;
  }
  
  public LastHttpContent retain()
  {
    return this;
  }
  
  public LastHttpContent retain(int paramInt)
  {
    return this;
  }
  
  public LastHttpContent retainedDuplicate()
  {
    return copy();
  }
  
  public void setDecoderResult(DecoderResult paramDecoderResult)
  {
    this.result = paramDecoderResult;
  }
  
  public LastHttpContent touch()
  {
    return this;
  }
  
  public LastHttpContent touch(Object paramObject)
  {
    return this;
  }
  
  public HttpHeaders trailingHeaders()
  {
    return this.trailingHeaders;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\ComposedLastHttpContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */