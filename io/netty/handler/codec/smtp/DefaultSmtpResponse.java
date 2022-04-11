package io.netty.handler.codec.smtp;

import java.util.Collections;
import java.util.List;

public final class DefaultSmtpResponse
  implements SmtpResponse
{
  private final int code;
  private final List<CharSequence> details;
  
  public DefaultSmtpResponse(int paramInt)
  {
    this(paramInt, null);
  }
  
  DefaultSmtpResponse(int paramInt, List<CharSequence> paramList)
  {
    if ((paramInt >= 100) && (paramInt <= 599))
    {
      this.code = paramInt;
      if (paramList == null) {
        this.details = Collections.emptyList();
      } else {
        this.details = Collections.unmodifiableList(paramList);
      }
      return;
    }
    throw new IllegalArgumentException("code must be 100 <= code <= 599");
  }
  
  public DefaultSmtpResponse(int paramInt, CharSequence... paramVarArgs)
  {
    this(paramInt, SmtpUtils.toUnmodifiableList(paramVarArgs));
  }
  
  public int code()
  {
    return this.code;
  }
  
  public List<CharSequence> details()
  {
    return this.details;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof DefaultSmtpResponse;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    if (paramObject == this) {
      return true;
    }
    paramObject = (DefaultSmtpResponse)paramObject;
    bool1 = bool2;
    if (code() == ((DefaultSmtpResponse)paramObject).code())
    {
      bool1 = bool2;
      if (details().equals(((DefaultSmtpResponse)paramObject).details())) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return this.code * 31 + this.details.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DefaultSmtpResponse{code=");
    localStringBuilder.append(this.code);
    localStringBuilder.append(", details=");
    localStringBuilder.append(this.details);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\smtp\DefaultSmtpResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */