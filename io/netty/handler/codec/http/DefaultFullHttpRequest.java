package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.DecoderResultProvider;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;

public class DefaultFullHttpRequest
  extends DefaultHttpRequest
  implements FullHttpRequest
{
  private final ByteBuf content;
  private int hash;
  private final HttpHeaders trailingHeader;
  
  public DefaultFullHttpRequest(HttpVersion paramHttpVersion, HttpMethod paramHttpMethod, String paramString)
  {
    this(paramHttpVersion, paramHttpMethod, paramString, Unpooled.buffer(0));
  }
  
  public DefaultFullHttpRequest(HttpVersion paramHttpVersion, HttpMethod paramHttpMethod, String paramString, ByteBuf paramByteBuf)
  {
    this(paramHttpVersion, paramHttpMethod, paramString, paramByteBuf, true);
  }
  
  public DefaultFullHttpRequest(HttpVersion paramHttpVersion, HttpMethod paramHttpMethod, String paramString, ByteBuf paramByteBuf, HttpHeaders paramHttpHeaders1, HttpHeaders paramHttpHeaders2)
  {
    super(paramHttpVersion, paramHttpMethod, paramString, paramHttpHeaders1);
    this.content = ((ByteBuf)ObjectUtil.checkNotNull(paramByteBuf, "content"));
    this.trailingHeader = ((HttpHeaders)ObjectUtil.checkNotNull(paramHttpHeaders2, "trailingHeader"));
  }
  
  public DefaultFullHttpRequest(HttpVersion paramHttpVersion, HttpMethod paramHttpMethod, String paramString, ByteBuf paramByteBuf, boolean paramBoolean)
  {
    super(paramHttpVersion, paramHttpMethod, paramString, paramBoolean);
    this.content = ((ByteBuf)ObjectUtil.checkNotNull(paramByteBuf, "content"));
    this.trailingHeader = new DefaultHttpHeaders(paramBoolean);
  }
  
  public DefaultFullHttpRequest(HttpVersion paramHttpVersion, HttpMethod paramHttpMethod, String paramString, boolean paramBoolean)
  {
    this(paramHttpVersion, paramHttpMethod, paramString, Unpooled.buffer(0), paramBoolean);
  }
  
  public ByteBuf content()
  {
    return this.content;
  }
  
  public FullHttpRequest copy()
  {
    return replace(content().copy());
  }
  
  public FullHttpRequest duplicate()
  {
    return replace(content().duplicate());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof DefaultFullHttpRequest;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (DefaultFullHttpRequest)paramObject;
    bool1 = bool2;
    if (super.equals(paramObject))
    {
      bool1 = bool2;
      if (content().equals(((DefaultFullHttpRequest)paramObject).content()))
      {
        bool1 = bool2;
        if (trailingHeaders().equals(((DefaultFullHttpRequest)paramObject).trailingHeaders())) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    int i = this.hash;
    int j = i;
    if ((i != 0) || (content().refCnt() != 0)) {}
    try
    {
      j = content().hashCode();
      j += 31;
    }
    catch (IllegalReferenceCountException localIllegalReferenceCountException)
    {
      for (;;) {}
    }
    j = 31;
    j = (j * 31 + trailingHeaders().hashCode()) * 31 + super.hashCode();
    this.hash = j;
    return j;
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
  
  public FullHttpRequest replace(ByteBuf paramByteBuf)
  {
    paramByteBuf = new DefaultFullHttpRequest(protocolVersion(), method(), uri(), paramByteBuf, headers().copy(), trailingHeaders().copy());
    paramByteBuf.setDecoderResult(decoderResult());
    return paramByteBuf;
  }
  
  public FullHttpRequest retain()
  {
    this.content.retain();
    return this;
  }
  
  public FullHttpRequest retain(int paramInt)
  {
    this.content.retain(paramInt);
    return this;
  }
  
  public FullHttpRequest retainedDuplicate()
  {
    return replace(content().retainedDuplicate());
  }
  
  public FullHttpRequest setMethod(HttpMethod paramHttpMethod)
  {
    super.setMethod(paramHttpMethod);
    return this;
  }
  
  public FullHttpRequest setProtocolVersion(HttpVersion paramHttpVersion)
  {
    super.setProtocolVersion(paramHttpVersion);
    return this;
  }
  
  public FullHttpRequest setUri(String paramString)
  {
    super.setUri(paramString);
    return this;
  }
  
  public String toString()
  {
    return HttpMessageUtil.appendFullRequest(new StringBuilder(256), this).toString();
  }
  
  public FullHttpRequest touch()
  {
    this.content.touch();
    return this;
  }
  
  public FullHttpRequest touch(Object paramObject)
  {
    this.content.touch(paramObject);
    return this;
  }
  
  public HttpHeaders trailingHeaders()
  {
    return this.trailingHeader;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\DefaultFullHttpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */