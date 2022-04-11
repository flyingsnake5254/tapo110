package io.netty.handler.codec.http.websocketx.extensions.compression;

import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionData;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionDecoder;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionEncoder;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionFilterProvider;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketServerExtension;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketServerExtensionHandshaker;
import io.netty.util.internal.ObjectUtil;
import java.util.Collections;
import java.util.Map;

public final class DeflateFrameServerExtensionHandshaker
  implements WebSocketServerExtensionHandshaker
{
  static final String DEFLATE_FRAME_EXTENSION = "deflate-frame";
  static final String X_WEBKIT_DEFLATE_FRAME_EXTENSION = "x-webkit-deflate-frame";
  private final int compressionLevel;
  private final WebSocketExtensionFilterProvider extensionFilterProvider;
  
  public DeflateFrameServerExtensionHandshaker()
  {
    this(6);
  }
  
  public DeflateFrameServerExtensionHandshaker(int paramInt)
  {
    this(paramInt, WebSocketExtensionFilterProvider.DEFAULT);
  }
  
  public DeflateFrameServerExtensionHandshaker(int paramInt, WebSocketExtensionFilterProvider paramWebSocketExtensionFilterProvider)
  {
    if ((paramInt >= 0) && (paramInt <= 9))
    {
      this.compressionLevel = paramInt;
      this.extensionFilterProvider = ((WebSocketExtensionFilterProvider)ObjectUtil.checkNotNull(paramWebSocketExtensionFilterProvider, "extensionFilterProvider"));
      return;
    }
    paramWebSocketExtensionFilterProvider = new StringBuilder();
    paramWebSocketExtensionFilterProvider.append("compressionLevel: ");
    paramWebSocketExtensionFilterProvider.append(paramInt);
    paramWebSocketExtensionFilterProvider.append(" (expected: 0-9)");
    throw new IllegalArgumentException(paramWebSocketExtensionFilterProvider.toString());
  }
  
  public WebSocketServerExtension handshakeExtension(WebSocketExtensionData paramWebSocketExtensionData)
  {
    if ((!"x-webkit-deflate-frame".equals(paramWebSocketExtensionData.name())) && (!"deflate-frame".equals(paramWebSocketExtensionData.name()))) {
      return null;
    }
    if (paramWebSocketExtensionData.parameters().isEmpty()) {
      return new DeflateFrameServerExtension(this.compressionLevel, paramWebSocketExtensionData.name(), this.extensionFilterProvider);
    }
    return null;
  }
  
  private static class DeflateFrameServerExtension
    implements WebSocketServerExtension
  {
    private final int compressionLevel;
    private final WebSocketExtensionFilterProvider extensionFilterProvider;
    private final String extensionName;
    
    DeflateFrameServerExtension(int paramInt, String paramString, WebSocketExtensionFilterProvider paramWebSocketExtensionFilterProvider)
    {
      this.extensionName = paramString;
      this.compressionLevel = paramInt;
      this.extensionFilterProvider = paramWebSocketExtensionFilterProvider;
    }
    
    public WebSocketExtensionDecoder newExtensionDecoder()
    {
      return new PerFrameDeflateDecoder(false, this.extensionFilterProvider.decoderFilter());
    }
    
    public WebSocketExtensionEncoder newExtensionEncoder()
    {
      return new PerFrameDeflateEncoder(this.compressionLevel, 15, false, this.extensionFilterProvider.encoderFilter());
    }
    
    public WebSocketExtensionData newReponseData()
    {
      return new WebSocketExtensionData(this.extensionName, Collections.emptyMap());
    }
    
    public int rsv()
    {
      return 4;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\extensions\compression\DeflateFrameServerExtensionHandshaker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */