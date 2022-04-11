package io.netty.handler.codec.http.websocketx;

import io.netty.util.internal.ObjectUtil;

public final class WebSocketCloseStatus
  implements Comparable<WebSocketCloseStatus>
{
  public static final WebSocketCloseStatus BAD_GATEWAY = new WebSocketCloseStatus(1014, "Bad Gateway");
  public static final WebSocketCloseStatus ENDPOINT_UNAVAILABLE;
  public static final WebSocketCloseStatus INTERNAL_SERVER_ERROR;
  public static final WebSocketCloseStatus INVALID_MESSAGE_TYPE;
  public static final WebSocketCloseStatus INVALID_PAYLOAD_DATA;
  public static final WebSocketCloseStatus MANDATORY_EXTENSION;
  public static final WebSocketCloseStatus MESSAGE_TOO_BIG;
  public static final WebSocketCloseStatus NORMAL_CLOSURE = new WebSocketCloseStatus(1000, "Bye");
  public static final WebSocketCloseStatus POLICY_VIOLATION;
  public static final WebSocketCloseStatus PROTOCOL_ERROR;
  public static final WebSocketCloseStatus SERVICE_RESTART;
  public static final WebSocketCloseStatus TRY_AGAIN_LATER;
  private final String reasonText;
  private final int statusCode;
  private String text;
  
  static
  {
    ENDPOINT_UNAVAILABLE = new WebSocketCloseStatus(1001, "Endpoint unavailable");
    PROTOCOL_ERROR = new WebSocketCloseStatus(1002, "Protocol error");
    INVALID_MESSAGE_TYPE = new WebSocketCloseStatus(1003, "Invalid message type");
    INVALID_PAYLOAD_DATA = new WebSocketCloseStatus(1007, "Invalid payload data");
    POLICY_VIOLATION = new WebSocketCloseStatus(1008, "Policy violation");
    MESSAGE_TOO_BIG = new WebSocketCloseStatus(1009, "Message too big");
    MANDATORY_EXTENSION = new WebSocketCloseStatus(1010, "Mandatory extension");
    INTERNAL_SERVER_ERROR = new WebSocketCloseStatus(1011, "Internal server error");
    SERVICE_RESTART = new WebSocketCloseStatus(1012, "Service Restart");
    TRY_AGAIN_LATER = new WebSocketCloseStatus(1013, "Try Again Later");
  }
  
  public WebSocketCloseStatus(int paramInt, String paramString)
  {
    if (isValidStatusCode(paramInt))
    {
      this.statusCode = paramInt;
      this.reasonText = ((String)ObjectUtil.checkNotNull(paramString, "reasonText"));
      return;
    }
    paramString = new StringBuilder();
    paramString.append("WebSocket close status code does NOT comply with RFC-6455: ");
    paramString.append(paramInt);
    throw new IllegalArgumentException(paramString.toString());
  }
  
  public static boolean isValidStatusCode(int paramInt)
  {
    boolean bool;
    if ((paramInt >= 0) && ((1000 > paramInt) || (paramInt > 1003)) && ((1007 > paramInt) || (paramInt > 1014)) && (3000 > paramInt)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static WebSocketCloseStatus valueOf(int paramInt)
  {
    switch (paramInt)
    {
    case 1004: 
    case 1005: 
    case 1006: 
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Close status #");
      localStringBuilder.append(paramInt);
      return new WebSocketCloseStatus(paramInt, localStringBuilder.toString());
    case 1014: 
      return BAD_GATEWAY;
    case 1013: 
      return TRY_AGAIN_LATER;
    case 1012: 
      return SERVICE_RESTART;
    case 1011: 
      return INTERNAL_SERVER_ERROR;
    case 1010: 
      return MANDATORY_EXTENSION;
    case 1009: 
      return MESSAGE_TOO_BIG;
    case 1008: 
      return POLICY_VIOLATION;
    case 1007: 
      return INVALID_PAYLOAD_DATA;
    case 1003: 
      return INVALID_MESSAGE_TYPE;
    case 1002: 
      return PROTOCOL_ERROR;
    case 1001: 
      return ENDPOINT_UNAVAILABLE;
    }
    return NORMAL_CLOSURE;
  }
  
  public int code()
  {
    return this.statusCode;
  }
  
  public int compareTo(WebSocketCloseStatus paramWebSocketCloseStatus)
  {
    return code() - paramWebSocketCloseStatus.code();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (WebSocketCloseStatus.class == paramObject.getClass()))
    {
      paramObject = (WebSocketCloseStatus)paramObject;
      if (this.statusCode != ((WebSocketCloseStatus)paramObject).statusCode) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.statusCode;
  }
  
  public String reasonText()
  {
    return this.reasonText;
  }
  
  public String toString()
  {
    String str = this.text;
    Object localObject = str;
    if (str == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(code());
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(reasonText());
      localObject = ((StringBuilder)localObject).toString();
      this.text = ((String)localObject);
    }
    return (String)localObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\WebSocketCloseStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */