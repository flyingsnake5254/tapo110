package io.netty.handler.codec.http.websocketx.extensions;

import io.netty.util.internal.ObjectUtil;
import java.util.Collections;
import java.util.Map;

public final class WebSocketExtensionData
{
  private final String name;
  private final Map<String, String> parameters;
  
  public WebSocketExtensionData(String paramString, Map<String, String> paramMap)
  {
    this.name = ((String)ObjectUtil.checkNotNull(paramString, "name"));
    this.parameters = Collections.unmodifiableMap((Map)ObjectUtil.checkNotNull(paramMap, "parameters"));
  }
  
  public String name()
  {
    return this.name;
  }
  
  public Map<String, String> parameters()
  {
    return this.parameters;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\extensions\WebSocketExtensionData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */