package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public class DefaultHttpContent
  extends DefaultHttpObject
  implements HttpContent
{
  private final ByteBuf content;
  
  public DefaultHttpContent(ByteBuf paramByteBuf)
  {
    this.content = ((ByteBuf)ObjectUtil.checkNotNull(paramByteBuf, "content"));
  }
  
  public ByteBuf content()
  {
    return this.content;
  }
  
  public HttpContent copy()
  {
    return replace(this.content.copy());
  }
  
  public HttpContent duplicate()
  {
    return replace(this.content.duplicate());
  }
  
  public int refCnt()
  {
    return this.content.refCnt();
  }
  
  public boolean release()
  {
    return this.content.release();
  }
  
  public boolean release(int paramInt)
  {
    return this.content.release(paramInt);
  }
  
  public HttpContent replace(ByteBuf paramByteBuf)
  {
    return new DefaultHttpContent(paramByteBuf);
  }
  
  public HttpContent retain()
  {
    this.content.retain();
    return this;
  }
  
  public HttpContent retain(int paramInt)
  {
    this.content.retain(paramInt);
    return this;
  }
  
  public HttpContent retainedDuplicate()
  {
    return replace(this.content.retainedDuplicate());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringUtil.simpleClassName(this));
    localStringBuilder.append("(data: ");
    localStringBuilder.append(content());
    localStringBuilder.append(", decoderResult: ");
    localStringBuilder.append(decoderResult());
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public HttpContent touch()
  {
    this.content.touch();
    return this;
  }
  
  public HttpContent touch(Object paramObject)
  {
    this.content.touch(paramObject);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\DefaultHttpContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */