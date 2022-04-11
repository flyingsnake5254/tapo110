package io.netty.handler.codec.spdy;

import io.netty.util.internal.ObjectUtil;

public class SpdySessionStatus
  implements Comparable<SpdySessionStatus>
{
  public static final SpdySessionStatus INTERNAL_ERROR = new SpdySessionStatus(2, "INTERNAL_ERROR");
  public static final SpdySessionStatus OK = new SpdySessionStatus(0, "OK");
  public static final SpdySessionStatus PROTOCOL_ERROR = new SpdySessionStatus(1, "PROTOCOL_ERROR");
  private final int code;
  private final String statusPhrase;
  
  public SpdySessionStatus(int paramInt, String paramString)
  {
    this.statusPhrase = ((String)ObjectUtil.checkNotNull(paramString, "statusPhrase"));
    this.code = paramInt;
  }
  
  public static SpdySessionStatus valueOf(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("UNKNOWN (");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(')');
          return new SpdySessionStatus(paramInt, localStringBuilder.toString());
        }
        return INTERNAL_ERROR;
      }
      return PROTOCOL_ERROR;
    }
    return OK;
  }
  
  public int code()
  {
    return this.code;
  }
  
  public int compareTo(SpdySessionStatus paramSpdySessionStatus)
  {
    return code() - paramSpdySessionStatus.code();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof SpdySessionStatus;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    if (code() == ((SpdySessionStatus)paramObject).code()) {
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\SpdySessionStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */