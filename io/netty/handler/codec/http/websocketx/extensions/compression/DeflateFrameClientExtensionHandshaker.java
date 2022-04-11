package io.netty.handler.codec.http.websocketx.extensions.compression;

import io.netty.handler.codec.http.websocketx.extensions.WebSocketClientExtensionHandshaker;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionData;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionDecoder;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionEncoder;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionFilterProvider;
import io.netty.handler.codec.http.websocketx.extensions.a;
import io.netty.util.internal.ObjectUtil;
import java.util.Collections;
import java.util.Map;

public final class DeflateFrameClientExtensionHandshaker
  implements WebSocketClientExtensionHandshaker
{
  private final int compressionLevel;
  private final WebSocketExtensionFilterProvider extensionFilterProvider;
  private final boolean useWebkitExtensionName;
  
  public DeflateFrameClientExtensionHandshaker(int paramInt, boolean paramBoolean)
  {
    this(paramInt, paramBoolean, WebSocketExtensionFilterProvider.DEFAULT);
  }
  
  public DeflateFrameClientExtensionHandshaker(int paramInt, boolean paramBoolean, WebSocketExtensionFilterProvider paramWebSocketExtensionFilterProvider)
  {
    if ((paramInt >= 0) && (paramInt <= 9))
    {
      this.compressionLevel = paramInt;
      this.useWebkitExtensionName = paramBoolean;
      this.extensionFilterProvider = ((WebSocketExtensionFilterProvider)ObjectUtil.checkNotNull(paramWebSocketExtensionFilterProvider, "extensionFilterProvider"));
      return;
    }
    paramWebSocketExtensionFilterProvider = new StringBuilder();
    paramWebSocketExtensionFilterProvider.append("compressionLevel: ");
    paramWebSocketExtensionFilterProvider.append(paramInt);
    paramWebSocketExtensionFilterProvider.append(" (expected: 0-9)");
    throw new IllegalArgumentException(paramWebSocketExtensionFilterProvider.toString());
  }
  
  public DeflateFrameClientExtensionHandshaker(boolean paramBoolean)
  {
    this(6, paramBoolean);
  }
  
  public a handshakeExtension(WebSocketExtensionData paramWebSocketExtensionData)
  {
    if ((!"x-webkit-deflate-frame".equals(paramWebSocketExtensionData.name())) && (!"deflate-frame".equals(paramWebSocketExtensionData.name()))) {
      return null;
    }
    if (paramWebSocketExtensionData.parameters().isEmpty()) {
      return new DeflateFrameClientExtension(this.compressionLevel, this.extensionFilterProvider);
    }
    return null;
  }
  
  public WebSocketExtensionData newRequestData()
  {
    String str;
    if (this.useWebkitExtensionName) {
      str = "x-webkit-deflate-frame";
    } else {
      str = "deflate-frame";
    }
    return new WebSocketExtensionData(str, Collections.emptyMap());
  }
  
  private static class DeflateFrameClientExtension
    implements a
  {
    private final int compressionLevel;
    private final WebSocketExtensionFilterProvider extensionFilterProvider;
    
    DeflateFrameClientExtension(int paramInt, WebSocketExtensionFilterProvider paramWebSocketExtensionFilterProvider)
    {
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
    
    public int rsv()
    {
      return 4;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\extensions\compression\DeflateFrameClientExtensionHandshaker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */