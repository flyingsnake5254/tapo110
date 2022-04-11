package io.netty.handler.codec.http.websocketx.extensions.compression;

import io.netty.handler.codec.compression.ZlibCodecFactory;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionData;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionDecoder;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionEncoder;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionFilterProvider;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketServerExtension;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketServerExtensionHandshaker;
import io.netty.util.internal.ObjectUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class PerMessageDeflateServerExtensionHandshaker
  implements WebSocketServerExtensionHandshaker
{
  static final String CLIENT_MAX_WINDOW = "client_max_window_bits";
  static final String CLIENT_NO_CONTEXT = "client_no_context_takeover";
  public static final int MAX_WINDOW_SIZE = 15;
  public static final int MIN_WINDOW_SIZE = 8;
  static final String PERMESSAGE_DEFLATE_EXTENSION = "permessage-deflate";
  static final String SERVER_MAX_WINDOW = "server_max_window_bits";
  static final String SERVER_NO_CONTEXT = "server_no_context_takeover";
  private final boolean allowServerNoContext;
  private final boolean allowServerWindowSize;
  private final int compressionLevel;
  private final WebSocketExtensionFilterProvider extensionFilterProvider;
  private final boolean preferredClientNoContext;
  private final int preferredClientWindowSize;
  
  public PerMessageDeflateServerExtensionHandshaker()
  {
    this(6, ZlibCodecFactory.isSupportingWindowSizeAndMemLevel(), 15, false, false);
  }
  
  public PerMessageDeflateServerExtensionHandshaker(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3)
  {
    this(paramInt1, paramBoolean1, paramInt2, paramBoolean2, paramBoolean3, WebSocketExtensionFilterProvider.DEFAULT);
  }
  
  public PerMessageDeflateServerExtensionHandshaker(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3, WebSocketExtensionFilterProvider paramWebSocketExtensionFilterProvider)
  {
    if ((paramInt2 <= 15) && (paramInt2 >= 8))
    {
      if ((paramInt1 >= 0) && (paramInt1 <= 9))
      {
        this.compressionLevel = paramInt1;
        this.allowServerWindowSize = paramBoolean1;
        this.preferredClientWindowSize = paramInt2;
        this.allowServerNoContext = paramBoolean2;
        this.preferredClientNoContext = paramBoolean3;
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
    paramWebSocketExtensionFilterProvider.append("preferredServerWindowSize: ");
    paramWebSocketExtensionFilterProvider.append(paramInt2);
    paramWebSocketExtensionFilterProvider.append(" (expected: 8-15)");
    throw new IllegalArgumentException(paramWebSocketExtensionFilterProvider.toString());
  }
  
  public WebSocketServerExtension handshakeExtension(WebSocketExtensionData paramWebSocketExtensionData)
  {
    if (!"permessage-deflate".equals(paramWebSocketExtensionData.name())) {
      return null;
    }
    Iterator localIterator = paramWebSocketExtensionData.parameters().entrySet().iterator();
    int i = 1;
    boolean bool1 = false;
    int j = 15;
    boolean bool2 = false;
    int k = 15;
    while ((i != 0) && (localIterator.hasNext()))
    {
      paramWebSocketExtensionData = (Map.Entry)localIterator.next();
      if ("client_max_window_bits".equalsIgnoreCase((String)paramWebSocketExtensionData.getKey()))
      {
        k = this.preferredClientWindowSize;
      }
      else
      {
        int m;
        if ("server_max_window_bits".equalsIgnoreCase((String)paramWebSocketExtensionData.getKey()))
        {
          m = j;
          if (this.allowServerWindowSize)
          {
            int n = Integer.parseInt((String)paramWebSocketExtensionData.getValue());
            m = n;
            if (n <= 15)
            {
              j = n;
              if (n >= 8) {
                continue;
              }
              m = n;
            }
          }
        }
        do
        {
          do
          {
            i = 0;
            j = m;
            break;
            if ("client_no_context_takeover".equalsIgnoreCase((String)paramWebSocketExtensionData.getKey()))
            {
              bool2 = this.preferredClientNoContext;
              break;
            }
            m = j;
          } while (!"server_no_context_takeover".equalsIgnoreCase((String)paramWebSocketExtensionData.getKey()));
          m = j;
        } while (!this.allowServerNoContext);
        bool1 = true;
      }
    }
    if (i != 0) {
      return new PermessageDeflateExtension(this.compressionLevel, bool1, j, bool2, k, this.extensionFilterProvider);
    }
    return null;
  }
  
  private static class PermessageDeflateExtension
    implements WebSocketServerExtension
  {
    private final boolean clientNoContext;
    private final int clientWindowSize;
    private final int compressionLevel;
    private final WebSocketExtensionFilterProvider extensionFilterProvider;
    private final boolean serverNoContext;
    private final int serverWindowSize;
    
    PermessageDeflateExtension(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, int paramInt3, WebSocketExtensionFilterProvider paramWebSocketExtensionFilterProvider)
    {
      this.compressionLevel = paramInt1;
      this.serverNoContext = paramBoolean1;
      this.serverWindowSize = paramInt2;
      this.clientNoContext = paramBoolean2;
      this.clientWindowSize = paramInt3;
      this.extensionFilterProvider = paramWebSocketExtensionFilterProvider;
    }
    
    public WebSocketExtensionDecoder newExtensionDecoder()
    {
      return new PerMessageDeflateDecoder(this.clientNoContext, this.extensionFilterProvider.decoderFilter());
    }
    
    public WebSocketExtensionEncoder newExtensionEncoder()
    {
      return new PerMessageDeflateEncoder(this.compressionLevel, this.serverWindowSize, this.serverNoContext, this.extensionFilterProvider.encoderFilter());
    }
    
    public WebSocketExtensionData newReponseData()
    {
      HashMap localHashMap = new HashMap(4);
      if (this.serverNoContext) {
        localHashMap.put("server_no_context_takeover", null);
      }
      if (this.clientNoContext) {
        localHashMap.put("client_no_context_takeover", null);
      }
      int i = this.serverWindowSize;
      if (i != 15) {
        localHashMap.put("server_max_window_bits", Integer.toString(i));
      }
      i = this.clientWindowSize;
      if (i != 15) {
        localHashMap.put("client_max_window_bits", Integer.toString(i));
      }
      return new WebSocketExtensionData("permessage-deflate", localHashMap);
    }
    
    public int rsv()
    {
      return 4;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\extensions\compression\PerMessageDeflateServerExtensionHandshaker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */