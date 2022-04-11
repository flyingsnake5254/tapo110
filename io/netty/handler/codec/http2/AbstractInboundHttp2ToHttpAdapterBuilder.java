package io.netty.handler.codec.http2;

import io.netty.util.internal.ObjectUtil;

public abstract class AbstractInboundHttp2ToHttpAdapterBuilder<T extends InboundHttp2ToHttpAdapter, B extends AbstractInboundHttp2ToHttpAdapterBuilder<T, B>>
{
  private final Http2Connection connection;
  private int maxContentLength;
  private boolean propagateSettings;
  private boolean validateHttpHeaders;
  
  protected AbstractInboundHttp2ToHttpAdapterBuilder(Http2Connection paramHttp2Connection)
  {
    this.connection = ((Http2Connection)ObjectUtil.checkNotNull(paramHttp2Connection, "connection"));
  }
  
  protected T build()
  {
    try
    {
      InboundHttp2ToHttpAdapter localInboundHttp2ToHttpAdapter = build(connection(), maxContentLength(), isValidateHttpHeaders(), isPropagateSettings());
      this.connection.addListener(localInboundHttp2ToHttpAdapter);
      return localInboundHttp2ToHttpAdapter;
    }
    finally {}
  }
  
  protected abstract T build(Http2Connection paramHttp2Connection, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    throws Exception;
  
  protected Http2Connection connection()
  {
    return this.connection;
  }
  
  protected boolean isPropagateSettings()
  {
    return this.propagateSettings;
  }
  
  protected boolean isValidateHttpHeaders()
  {
    return this.validateHttpHeaders;
  }
  
  protected int maxContentLength()
  {
    return this.maxContentLength;
  }
  
  protected B maxContentLength(int paramInt)
  {
    this.maxContentLength = paramInt;
    return self();
  }
  
  protected B propagateSettings(boolean paramBoolean)
  {
    this.propagateSettings = paramBoolean;
    return self();
  }
  
  protected final B self()
  {
    return this;
  }
  
  protected B validateHttpHeaders(boolean paramBoolean)
  {
    this.validateHttpHeaders = paramBoolean;
    return self();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\AbstractInboundHttp2ToHttpAdapterBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */