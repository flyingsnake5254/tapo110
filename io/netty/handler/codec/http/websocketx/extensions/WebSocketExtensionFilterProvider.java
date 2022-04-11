package io.netty.handler.codec.http.websocketx.extensions;

public abstract interface WebSocketExtensionFilterProvider
{
  public static final WebSocketExtensionFilterProvider DEFAULT = new WebSocketExtensionFilterProvider()
  {
    public WebSocketExtensionFilter decoderFilter()
    {
      return WebSocketExtensionFilter.NEVER_SKIP;
    }
    
    public WebSocketExtensionFilter encoderFilter()
    {
      return WebSocketExtensionFilter.NEVER_SKIP;
    }
  };
  
  public abstract WebSocketExtensionFilter decoderFilter();
  
  public abstract WebSocketExtensionFilter encoderFilter();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\extensions\WebSocketExtensionFilterProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */