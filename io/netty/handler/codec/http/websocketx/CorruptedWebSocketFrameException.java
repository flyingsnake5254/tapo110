package io.netty.handler.codec.http.websocketx;

import io.netty.handler.codec.CorruptedFrameException;

public final class CorruptedWebSocketFrameException
  extends CorruptedFrameException
{
  private static final long serialVersionUID = 3918055132492988338L;
  private final WebSocketCloseStatus closeStatus;
  
  public CorruptedWebSocketFrameException()
  {
    this(WebSocketCloseStatus.PROTOCOL_ERROR, null, null);
  }
  
  public CorruptedWebSocketFrameException(WebSocketCloseStatus paramWebSocketCloseStatus, String paramString)
  {
    this(paramWebSocketCloseStatus, paramString, null);
  }
  
  public CorruptedWebSocketFrameException(WebSocketCloseStatus paramWebSocketCloseStatus, String paramString, Throwable paramThrowable)
  {
    super(str, paramThrowable);
    this.closeStatus = paramWebSocketCloseStatus;
  }
  
  public CorruptedWebSocketFrameException(WebSocketCloseStatus paramWebSocketCloseStatus, Throwable paramThrowable)
  {
    this(paramWebSocketCloseStatus, null, paramThrowable);
  }
  
  public WebSocketCloseStatus closeStatus()
  {
    return this.closeStatus;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\CorruptedWebSocketFrameException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */