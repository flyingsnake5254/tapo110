package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.DecoderResultProvider;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;

public class DefaultFullHttpResponse
  extends DefaultHttpResponse
  implements FullHttpResponse
{
  private final ByteBuf content;
  private int hash;
  private final HttpHeaders trailingHeaders;
  
  public DefaultFullHttpResponse(HttpVersion paramHttpVersion, HttpResponseStatus paramHttpResponseStatus)
  {
    this(paramHttpVersion, paramHttpResponseStatus, Unpooled.buffer(0));
  }
  
  public DefaultFullHttpResponse(HttpVersion paramHttpVersion, HttpResponseStatus paramHttpResponseStatus, ByteBuf paramByteBuf)
  {
    this(paramHttpVersion, paramHttpResponseStatus, paramByteBuf, true);
  }
  
  public DefaultFullHttpResponse(HttpVersion paramHttpVersion, HttpResponseStatus paramHttpResponseStatus, ByteBuf paramByteBuf, HttpHeaders paramHttpHeaders1, HttpHeaders paramHttpHeaders2)
  {
    super(paramHttpVersion, paramHttpResponseStatus, paramHttpHeaders1);
    this.content = ((ByteBuf)ObjectUtil.checkNotNull(paramByteBuf, "content"));
    this.trailingHeaders = ((HttpHeaders)ObjectUtil.checkNotNull(paramHttpHeaders2, "trailingHeaders"));
  }
  
  public DefaultFullHttpResponse(HttpVersion paramHttpVersion, HttpResponseStatus paramHttpResponseStatus, ByteBuf paramByteBuf, boolean paramBoolean)
  {
    this(paramHttpVersion, paramHttpResponseStatus, paramByteBuf, paramBoolean, false);
  }
  
  public DefaultFullHttpResponse(HttpVersion paramHttpVersion, HttpResponseStatus paramHttpResponseStatus, ByteBuf paramByteBuf, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramHttpVersion, paramHttpResponseStatus, paramBoolean1, paramBoolean2);
    this.content = ((ByteBuf)ObjectUtil.checkNotNull(paramByteBuf, "content"));
    if (paramBoolean2) {
      paramHttpVersion = new CombinedHttpHeaders(paramBoolean1);
    } else {
      paramHttpVersion = new DefaultHttpHeaders(paramBoolean1);
    }
    this.trailingHeaders = paramHttpVersion;
  }
  
  public DefaultFullHttpResponse(HttpVersion paramHttpVersion, HttpResponseStatus paramHttpResponseStatus, boolean paramBoolean)
  {
    this(paramHttpVersion, paramHttpResponseStatus, Unpooled.buffer(0), paramBoolean, false);
  }
  
  public DefaultFullHttpResponse(HttpVersion paramHttpVersion, HttpResponseStatus paramHttpResponseStatus, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramHttpVersion, paramHttpResponseStatus, Unpooled.buffer(0), paramBoolean1, paramBoolean2);
  }
  
  public ByteBuf content()
  {
    return this.content;
  }
  
  public FullHttpResponse copy()
  {
    return replace(content().copy());
  }
  
  public FullHttpResponse duplicate()
  {
    return replace(content().duplicate());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof DefaultFullHttpResponse;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (DefaultFullHttpResponse)paramObject;
    bool1 = bool2;
    if (super.equals(paramObject))
    {
      bool1 = bool2;
      if (content().equals(((DefaultFullHttpResponse)paramObject).content()))
      {
        bool1 = bool2;
        if (trailingHeaders().equals(((DefaultFullHttpResponse)paramObject).trailingHeaders())) {
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
  
  public FullHttpResponse replace(ByteBuf paramByteBuf)
  {
    paramByteBuf = new DefaultFullHttpResponse(protocolVersion(), status(), paramByteBuf, headers().copy(), trailingHeaders().copy());
    paramByteBuf.setDecoderResult(decoderResult());
    return paramByteBuf;
  }
  
  public FullHttpResponse retain()
  {
    this.content.retain();
    return this;
  }
  
  public FullHttpResponse retain(int paramInt)
  {
    this.content.retain(paramInt);
    return this;
  }
  
  public FullHttpResponse retainedDuplicate()
  {
    return replace(content().retainedDuplicate());
  }
  
  public FullHttpResponse setProtocolVersion(HttpVersion paramHttpVersion)
  {
    super.setProtocolVersion(paramHttpVersion);
    return this;
  }
  
  public FullHttpResponse setStatus(HttpResponseStatus paramHttpResponseStatus)
  {
    super.setStatus(paramHttpResponseStatus);
    return this;
  }
  
  public String toString()
  {
    return HttpMessageUtil.appendFullResponse(new StringBuilder(256), this).toString();
  }
  
  public FullHttpResponse touch()
  {
    this.content.touch();
    return this;
  }
  
  public FullHttpResponse touch(Object paramObject)
  {
    this.content.touch(paramObject);
    return this;
  }
  
  public HttpHeaders trailingHeaders()
  {
    return this.trailingHeaders;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\DefaultFullHttpResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */