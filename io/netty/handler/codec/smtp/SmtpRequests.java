package io.netty.handler.codec.smtp;

import io.netty.util.AsciiString;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class SmtpRequests
{
  private static final SmtpRequest DATA = new DefaultSmtpRequest(SmtpCommand.DATA);
  private static final AsciiString FROM_NULL_SENDER = AsciiString.cached("FROM:<>");
  private static final SmtpRequest HELP_NO_ARG;
  private static final SmtpRequest NOOP = new DefaultSmtpRequest(SmtpCommand.NOOP);
  private static final SmtpRequest QUIT;
  private static final SmtpRequest RSET = new DefaultSmtpRequest(SmtpCommand.RSET);
  
  static
  {
    HELP_NO_ARG = new DefaultSmtpRequest(SmtpCommand.HELP);
    QUIT = new DefaultSmtpRequest(SmtpCommand.QUIT);
  }
  
  public static SmtpRequest auth(CharSequence... paramVarArgs)
  {
    return new DefaultSmtpRequest(SmtpCommand.AUTH, paramVarArgs);
  }
  
  public static SmtpRequest data()
  {
    return DATA;
  }
  
  public static SmtpRequest ehlo(CharSequence paramCharSequence)
  {
    return new DefaultSmtpRequest(SmtpCommand.EHLO, new CharSequence[] { paramCharSequence });
  }
  
  public static SmtpRequest empty(CharSequence... paramVarArgs)
  {
    return new DefaultSmtpRequest(SmtpCommand.EMPTY, paramVarArgs);
  }
  
  public static SmtpRequest expn(CharSequence paramCharSequence)
  {
    return new DefaultSmtpRequest(SmtpCommand.EXPN, new CharSequence[] { (CharSequence)ObjectUtil.checkNotNull(paramCharSequence, "mailingList") });
  }
  
  public static SmtpRequest helo(CharSequence paramCharSequence)
  {
    return new DefaultSmtpRequest(SmtpCommand.HELO, new CharSequence[] { paramCharSequence });
  }
  
  public static SmtpRequest help(String paramString)
  {
    if (paramString == null) {
      paramString = HELP_NO_ARG;
    } else {
      paramString = new DefaultSmtpRequest(SmtpCommand.HELP, new CharSequence[] { paramString });
    }
    return paramString;
  }
  
  public static SmtpRequest mail(CharSequence paramCharSequence, CharSequence... paramVarArgs)
  {
    Object localObject;
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      localObject = new ArrayList(paramVarArgs.length + 1);
      if (paramCharSequence != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("FROM:<");
        localStringBuilder.append(paramCharSequence);
        localStringBuilder.append('>');
        paramCharSequence = localStringBuilder.toString();
      }
      else
      {
        paramCharSequence = FROM_NULL_SENDER;
      }
      ((List)localObject).add(paramCharSequence);
      Collections.addAll((Collection)localObject, paramVarArgs);
      return new DefaultSmtpRequest(SmtpCommand.MAIL, (List)localObject);
    }
    paramVarArgs = SmtpCommand.MAIL;
    if (paramCharSequence != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("FROM:<");
      ((StringBuilder)localObject).append(paramCharSequence);
      ((StringBuilder)localObject).append('>');
      paramCharSequence = ((StringBuilder)localObject).toString();
    }
    else
    {
      paramCharSequence = FROM_NULL_SENDER;
    }
    return new DefaultSmtpRequest(paramVarArgs, new CharSequence[] { paramCharSequence });
  }
  
  public static SmtpRequest noop()
  {
    return NOOP;
  }
  
  public static SmtpRequest quit()
  {
    return QUIT;
  }
  
  public static SmtpRequest rcpt(CharSequence paramCharSequence, CharSequence... paramVarArgs)
  {
    ObjectUtil.checkNotNull(paramCharSequence, "recipient");
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      localObject = new ArrayList(paramVarArgs.length + 1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TO:<");
      localStringBuilder.append(paramCharSequence);
      localStringBuilder.append('>');
      ((List)localObject).add(localStringBuilder.toString());
      Collections.addAll((Collection)localObject, paramVarArgs);
      return new DefaultSmtpRequest(SmtpCommand.RCPT, (List)localObject);
    }
    Object localObject = SmtpCommand.RCPT;
    paramVarArgs = new StringBuilder();
    paramVarArgs.append("TO:<");
    paramVarArgs.append(paramCharSequence);
    paramVarArgs.append('>');
    return new DefaultSmtpRequest((SmtpCommand)localObject, new CharSequence[] { paramVarArgs.toString() });
  }
  
  public static SmtpRequest rset()
  {
    return RSET;
  }
  
  public static SmtpRequest vrfy(CharSequence paramCharSequence)
  {
    return new DefaultSmtpRequest(SmtpCommand.VRFY, new CharSequence[] { (CharSequence)ObjectUtil.checkNotNull(paramCharSequence, "user") });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\smtp\SmtpRequests.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */