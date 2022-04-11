package okhttp3;

import javax.annotation.Nullable;
import okio.ByteString;

public abstract interface WebSocket
{
  public abstract void cancel();
  
  public abstract boolean close(int paramInt, @Nullable String paramString);
  
  public abstract long queueSize();
  
  public abstract Request request();
  
  public abstract boolean send(String paramString);
  
  public abstract boolean send(ByteString paramByteString);
  
  public static abstract interface Factory
  {
    public abstract WebSocket newWebSocket(Request paramRequest, WebSocketListener paramWebSocketListener);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\WebSocket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */