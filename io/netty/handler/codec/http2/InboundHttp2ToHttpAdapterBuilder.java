package io.netty.handler.codec.http2;

public final class InboundHttp2ToHttpAdapterBuilder
  extends AbstractInboundHttp2ToHttpAdapterBuilder<InboundHttp2ToHttpAdapter, InboundHttp2ToHttpAdapterBuilder>
{
  public InboundHttp2ToHttpAdapterBuilder(Http2Connection paramHttp2Connection)
  {
    super(paramHttp2Connection);
  }
  
  public InboundHttp2ToHttpAdapter build()
  {
    return super.build();
  }
  
  protected InboundHttp2ToHttpAdapter build(Http2Connection paramHttp2Connection, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    throws Exception
  {
    return new InboundHttp2ToHttpAdapter(paramHttp2Connection, paramInt, paramBoolean1, paramBoolean2);
  }
  
  public InboundHttp2ToHttpAdapterBuilder maxContentLength(int paramInt)
  {
    return (InboundHttp2ToHttpAdapterBuilder)super.maxContentLength(paramInt);
  }
  
  public InboundHttp2ToHttpAdapterBuilder propagateSettings(boolean paramBoolean)
  {
    return (InboundHttp2ToHttpAdapterBuilder)super.propagateSettings(paramBoolean);
  }
  
  public InboundHttp2ToHttpAdapterBuilder validateHttpHeaders(boolean paramBoolean)
  {
    return (InboundHttp2ToHttpAdapterBuilder)super.validateHttpHeaders(paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\InboundHttp2ToHttpAdapterBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */