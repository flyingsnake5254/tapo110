package io.netty.handler.codec.http.websocketx;

import io.netty.util.AsciiString;

public enum WebSocketVersion
{
  private final AsciiString headerValue;
  
  static
  {
    WebSocketVersion localWebSocketVersion1 = new WebSocketVersion("UNKNOWN", 0, AsciiString.cached(""));
    UNKNOWN = localWebSocketVersion1;
    WebSocketVersion localWebSocketVersion2 = new WebSocketVersion("V00", 1, AsciiString.cached("0"));
    V00 = localWebSocketVersion2;
    WebSocketVersion localWebSocketVersion3 = new WebSocketVersion("V07", 2, AsciiString.cached("7"));
    V07 = localWebSocketVersion3;
    WebSocketVersion localWebSocketVersion4 = new WebSocketVersion("V08", 3, AsciiString.cached("8"));
    V08 = localWebSocketVersion4;
    WebSocketVersion localWebSocketVersion5 = new WebSocketVersion("V13", 4, AsciiString.cached("13"));
    V13 = localWebSocketVersion5;
    $VALUES = new WebSocketVersion[] { localWebSocketVersion1, localWebSocketVersion2, localWebSocketVersion3, localWebSocketVersion4, localWebSocketVersion5 };
  }
  
  private WebSocketVersion(AsciiString paramAsciiString)
  {
    this.headerValue = paramAsciiString;
  }
  
  AsciiString toAsciiString()
  {
    if (this != UNKNOWN) {
      return this.headerValue;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unknown web socket version: ");
    localStringBuilder.append(this);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public String toHttpHeaderValue()
  {
    return toAsciiString().toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\WebSocketVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */