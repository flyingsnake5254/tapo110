package io.netty.handler.codec.smtp;

import io.netty.util.internal.ObjectUtil;
import java.util.Collections;
import java.util.List;

public final class DefaultSmtpRequest
  implements SmtpRequest
{
  private final SmtpCommand command;
  private final List<CharSequence> parameters;
  
  public DefaultSmtpRequest(SmtpCommand paramSmtpCommand)
  {
    this.command = ((SmtpCommand)ObjectUtil.checkNotNull(paramSmtpCommand, "command"));
    this.parameters = Collections.emptyList();
  }
  
  DefaultSmtpRequest(SmtpCommand paramSmtpCommand, List<CharSequence> paramList)
  {
    this.command = ((SmtpCommand)ObjectUtil.checkNotNull(paramSmtpCommand, "command"));
    if (paramList != null) {
      paramSmtpCommand = Collections.unmodifiableList(paramList);
    } else {
      paramSmtpCommand = Collections.emptyList();
    }
    this.parameters = paramSmtpCommand;
  }
  
  public DefaultSmtpRequest(SmtpCommand paramSmtpCommand, CharSequence... paramVarArgs)
  {
    this.command = ((SmtpCommand)ObjectUtil.checkNotNull(paramSmtpCommand, "command"));
    this.parameters = SmtpUtils.toUnmodifiableList(paramVarArgs);
  }
  
  public DefaultSmtpRequest(CharSequence paramCharSequence, CharSequence... paramVarArgs)
  {
    this(SmtpCommand.valueOf(paramCharSequence), paramVarArgs);
  }
  
  public SmtpCommand command()
  {
    return this.command;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof DefaultSmtpRequest;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    if (paramObject == this) {
      return true;
    }
    paramObject = (DefaultSmtpRequest)paramObject;
    bool1 = bool2;
    if (command().equals(((DefaultSmtpRequest)paramObject).command()))
    {
      bool1 = bool2;
      if (parameters().equals(((DefaultSmtpRequest)paramObject).parameters())) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return this.command.hashCode() * 31 + this.parameters.hashCode();
  }
  
  public List<CharSequence> parameters()
  {
    return this.parameters;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DefaultSmtpRequest{command=");
    localStringBuilder.append(this.command);
    localStringBuilder.append(", parameters=");
    localStringBuilder.append(this.parameters);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\smtp\DefaultSmtpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */