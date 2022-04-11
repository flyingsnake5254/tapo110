package io.netty.handler.codec.spdy;

import io.netty.util.internal.ObjectUtil;

public class SpdyStreamStatus
  implements Comparable<SpdyStreamStatus>
{
  public static final SpdyStreamStatus CANCEL;
  public static final SpdyStreamStatus FLOW_CONTROL_ERROR;
  public static final SpdyStreamStatus FRAME_TOO_LARGE = new SpdyStreamStatus(11, "FRAME_TOO_LARGE");
  public static final SpdyStreamStatus INTERNAL_ERROR;
  public static final SpdyStreamStatus INVALID_CREDENTIALS;
  public static final SpdyStreamStatus INVALID_STREAM;
  public static final SpdyStreamStatus PROTOCOL_ERROR = new SpdyStreamStatus(1, "PROTOCOL_ERROR");
  public static final SpdyStreamStatus REFUSED_STREAM;
  public static final SpdyStreamStatus STREAM_ALREADY_CLOSED;
  public static final SpdyStreamStatus STREAM_IN_USE;
  public static final SpdyStreamStatus UNSUPPORTED_VERSION;
  private final int code;
  private final String statusPhrase;
  
  static
  {
    INVALID_STREAM = new SpdyStreamStatus(2, "INVALID_STREAM");
    REFUSED_STREAM = new SpdyStreamStatus(3, "REFUSED_STREAM");
    UNSUPPORTED_VERSION = new SpdyStreamStatus(4, "UNSUPPORTED_VERSION");
    CANCEL = new SpdyStreamStatus(5, "CANCEL");
    INTERNAL_ERROR = new SpdyStreamStatus(6, "INTERNAL_ERROR");
    FLOW_CONTROL_ERROR = new SpdyStreamStatus(7, "FLOW_CONTROL_ERROR");
    STREAM_IN_USE = new SpdyStreamStatus(8, "STREAM_IN_USE");
    STREAM_ALREADY_CLOSED = new SpdyStreamStatus(9, "STREAM_ALREADY_CLOSED");
    INVALID_CREDENTIALS = new SpdyStreamStatus(10, "INVALID_CREDENTIALS");
  }
  
  public SpdyStreamStatus(int paramInt, String paramString)
  {
    if (paramInt != 0)
    {
      this.statusPhrase = ((String)ObjectUtil.checkNotNull(paramString, "statusPhrase"));
      this.code = paramInt;
      return;
    }
    throw new IllegalArgumentException("0 is not a valid status code for a RST_STREAM");
  }
  
  public static SpdyStreamStatus valueOf(int paramInt)
  {
    if (paramInt != 0)
    {
      switch (paramInt)
      {
      default: 
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("UNKNOWN (");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(')');
        return new SpdyStreamStatus(paramInt, localStringBuilder.toString());
      case 11: 
        return FRAME_TOO_LARGE;
      case 10: 
        return INVALID_CREDENTIALS;
      case 9: 
        return STREAM_ALREADY_CLOSED;
      case 8: 
        return STREAM_IN_USE;
      case 7: 
        return FLOW_CONTROL_ERROR;
      case 6: 
        return INTERNAL_ERROR;
      case 5: 
        return CANCEL;
      case 4: 
        return UNSUPPORTED_VERSION;
      case 3: 
        return REFUSED_STREAM;
      case 2: 
        return INVALID_STREAM;
      }
      return PROTOCOL_ERROR;
    }
    throw new IllegalArgumentException("0 is not a valid status code for a RST_STREAM");
  }
  
  public int code()
  {
    return this.code;
  }
  
  public int compareTo(SpdyStreamStatus paramSpdyStreamStatus)
  {
    return code() - paramSpdyStreamStatus.code();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof SpdyStreamStatus;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    if (code() == ((SpdyStreamStatus)paramObject).code()) {
      bool2 = true;
    }
    return bool2;
  }
  
  public int hashCode()
  {
    return code();
  }
  
  public String statusPhrase()
  {
    return this.statusPhrase;
  }
  
  public String toString()
  {
    return statusPhrase();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\SpdyStreamStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */