package io.netty.handler.codec.http.websocketx.extensions.compression;

import io.netty.handler.codec.compression.ZlibCodecFactory;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketClientExtensionHandshaker;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionData;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionDecoder;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionEncoder;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionFilterProvider;
import io.netty.handler.codec.http.websocketx.extensions.a;
import io.netty.util.internal.ObjectUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class PerMessageDeflateClientExtensionHandshaker
  implements WebSocketClientExtensionHandshaker
{
  private final boolean allowClientNoContext;
  private final boolean allowClientWindowSize;
  private final int compressionLevel;
  private final WebSocketExtensionFilterProvider extensionFilterProvider;
  private final boolean requestedServerNoContext;
  private final int requestedServerWindowSize;
  
  public PerMessageDeflateClientExtensionHandshaker()
  {
    this(6, ZlibCodecFactory.isSupportingWindowSizeAndMemLevel(), 15, false, false);
  }
  
  public PerMessageDeflateClientExtensionHandshaker(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3)
  {
    this(paramInt1, paramBoolean1, paramInt2, paramBoolean2, paramBoolean3, WebSocketExtensionFilterProvider.DEFAULT);
  }
  
  public PerMessageDeflateClientExtensionHandshaker(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3, WebSocketExtensionFilterProvider paramWebSocketExtensionFilterProvider)
  {
    if ((paramInt2 <= 15) && (paramInt2 >= 8))
    {
      if ((paramInt1 >= 0) && (paramInt1 <= 9))
      {
        this.compressionLevel = paramInt1;
        this.allowClientWindowSize = paramBoolean1;
        this.requestedServerWindowSize = paramInt2;
        this.allowClientNoContext = paramBoolean2;
        this.requestedServerNoContext = paramBoolean3;
        this.extensionFilterProvider = ((WebSocketExtensionFilterProvider)ObjectUtil.checkNotNull(paramWebSocketExtensionFilterProvider, "extensionFilterProvider"));
        return;
      }
      paramWebSocketExtensionFilterProvider = new StringBuilder();
      paramWebSocketExtensionFilterProvider.append("compressionLevel: ");
      paramWebSocketExtensionFilterProvider.append(paramInt1);
      paramWebSocketExtensionFilterProvider.append(" (expected: 0-9)");
      throw new IllegalArgumentException(paramWebSocketExtensionFilterProvider.toString());
    }
    paramWebSocketExtensionFilterProvider = new StringBuilder();
    paramWebSocketExtensionFilterProvider.append("requestedServerWindowSize: ");
    paramWebSocketExtensionFilterProvider.append(paramInt2);
    paramWebSocketExtensionFilterProvider.append(" (expected: 8-15)");
    throw new IllegalArgumentException(paramWebSocketExtensionFilterProvider.toString());
  }
  
  public a handshakeExtension(WebSocketExtensionData paramWebSocketExtensionData)
  {
    if (!"permessage-deflate".equals(paramWebSocketExtensionData.name())) {
      return null;
    }
    Iterator localIterator = paramWebSocketExtensionData.parameters().entrySet().iterator();
    int i = 0;
    int j = 1;
    boolean bool1 = false;
    int k = 15;
    boolean bool2 = false;
    int m = 15;
    int n;
    while ((j != 0) && (localIterator.hasNext()))
    {
      paramWebSocketExtensionData = (Map.Entry)localIterator.next();
      if ("client_max_window_bits".equalsIgnoreCase((String)paramWebSocketExtensionData.getKey()))
      {
        n = k;
        if (this.allowClientWindowSize)
        {
          m = Integer.parseInt((String)paramWebSocketExtensionData.getValue());
          continue;
        }
      }
      label187:
      label221:
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              j = 0;
              k = n;
              break;
              if (!"server_max_window_bits".equalsIgnoreCase((String)paramWebSocketExtensionData.getKey())) {
                break label187;
              }
              int i1 = Integer.parseInt((String)paramWebSocketExtensionData.getValue());
              n = i1;
              if (m <= 15)
              {
                k = i1;
                if (m >= 8) {
                  break;
                }
                n = i1;
              }
            }
            if (!"client_no_context_takeover".equalsIgnoreCase((String)paramWebSocketExtensionData.getKey())) {
              break label221;
            }
            n = k;
          } while (!this.allowClientNoContext);
          bool2 = true;
          break;
          n = k;
        } while (!"server_no_context_takeover".equalsIgnoreCase((String)paramWebSocketExtensionData.getKey()));
        n = k;
      } while (!this.requestedServerNoContext);
      bool1 = true;
    }
    if (this.requestedServerNoContext)
    {
      n = i;
      if (!bool1) {}
    }
    else if (this.requestedServerWindowSize != k)
    {
      n = i;
    }
    else
    {
      n = j;
    }
    if (n != 0) {
      return new PermessageDeflateExtension(bool1, k, bool2, m, this.extensionFilterProvider);
    }
    return null;
  }
  
  public WebSocketExtensionData newRequestData()
  {
    HashMap localHashMap = new HashMap(4);
    if (this.requestedServerWindowSize != 15) {
      localHashMap.put("server_no_context_takeover", null);
    }
    if (this.allowClientNoContext) {
      localHashMap.put("client_no_context_takeover", null);
    }
    int i = this.requestedServerWindowSize;
    if (i != 15) {
      localHashMap.put("server_max_window_bits", Integer.toString(i));
    }
    if (this.allowClientWindowSize) {
      localHashMap.put("client_max_window_bits", null);
    }
    return new WebSocketExtensionData("permessage-deflate", localHashMap);
  }
  
  private final class PermessageDeflateExtension
    implements a
  {
    private final boolean clientNoContext;
    private final int clientWindowSize;
    private final WebSocketExtensionFilterProvider extensionFilterProvider;
    private final boolean serverNoContext;
    private final int serverWindowSize;
    
    PermessageDeflateExtension(boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2, WebSocketExtensionFilterProvider paramWebSocketExtensionFilterProvider)
    {
      this.serverNoContext = paramBoolean1;
      this.serverWindowSize = paramInt1;
      this.clientNoContext = paramBoolean2;
      this.clientWindowSize = paramInt2;
      this.extensionFilterProvider = paramWebSocketExtensionFilterProvider;
    }
    
    public WebSocketExtensionDecoder newExtensionDecoder()
    {
      return new PerMessageDeflateDecoder(this.serverNoContext, this.extensionFilterProvider.decoderFilter());
    }
    
    public WebSocketExtensionEncoder newExtensionEncoder()
    {
      return new PerMessageDeflateEncoder(PerMessageDeflateClientExtensionHandshaker.this.compressionLevel, this.clientWindowSize, this.clientNoContext, this.extensionFilterProvider.encoderFilter());
    }
    
    public int rsv()
    {
      return 4;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\extensions\compression\PerMessageDeflateClientExtensionHandshaker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */