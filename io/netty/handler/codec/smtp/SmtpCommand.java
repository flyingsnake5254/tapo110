package io.netty.handler.codec.smtp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.util.AsciiString;
import io.netty.util.internal.ObjectUtil;
import java.util.HashMap;
import java.util.Map;

public final class SmtpCommand
{
  public static final SmtpCommand AUTH;
  private static final Map<String, SmtpCommand> COMMANDS;
  public static final SmtpCommand DATA;
  public static final SmtpCommand EHLO;
  public static final SmtpCommand EMPTY;
  public static final SmtpCommand EXPN;
  public static final SmtpCommand HELO;
  public static final SmtpCommand HELP;
  public static final SmtpCommand MAIL;
  public static final SmtpCommand NOOP;
  public static final SmtpCommand QUIT;
  public static final SmtpCommand RCPT;
  public static final SmtpCommand RSET;
  public static final SmtpCommand VRFY;
  private final AsciiString name;
  
  static
  {
    SmtpCommand localSmtpCommand1 = new SmtpCommand(AsciiString.cached("EHLO"));
    EHLO = localSmtpCommand1;
    SmtpCommand localSmtpCommand2 = new SmtpCommand(AsciiString.cached("HELO"));
    HELO = localSmtpCommand2;
    SmtpCommand localSmtpCommand3 = new SmtpCommand(AsciiString.cached("AUTH"));
    AUTH = localSmtpCommand3;
    SmtpCommand localSmtpCommand4 = new SmtpCommand(AsciiString.cached("MAIL"));
    MAIL = localSmtpCommand4;
    SmtpCommand localSmtpCommand5 = new SmtpCommand(AsciiString.cached("RCPT"));
    RCPT = localSmtpCommand5;
    SmtpCommand localSmtpCommand6 = new SmtpCommand(AsciiString.cached("DATA"));
    DATA = localSmtpCommand6;
    SmtpCommand localSmtpCommand7 = new SmtpCommand(AsciiString.cached("NOOP"));
    NOOP = localSmtpCommand7;
    SmtpCommand localSmtpCommand8 = new SmtpCommand(AsciiString.cached("RSET"));
    RSET = localSmtpCommand8;
    SmtpCommand localSmtpCommand9 = new SmtpCommand(AsciiString.cached("EXPN"));
    EXPN = localSmtpCommand9;
    SmtpCommand localSmtpCommand10 = new SmtpCommand(AsciiString.cached("VRFY"));
    VRFY = localSmtpCommand10;
    SmtpCommand localSmtpCommand11 = new SmtpCommand(AsciiString.cached("HELP"));
    HELP = localSmtpCommand11;
    SmtpCommand localSmtpCommand12 = new SmtpCommand(AsciiString.cached("QUIT"));
    QUIT = localSmtpCommand12;
    SmtpCommand localSmtpCommand13 = new SmtpCommand(AsciiString.cached(""));
    EMPTY = localSmtpCommand13;
    HashMap localHashMap = new HashMap();
    COMMANDS = localHashMap;
    localHashMap.put(localSmtpCommand1.name().toString(), localSmtpCommand1);
    localHashMap.put(localSmtpCommand2.name().toString(), localSmtpCommand2);
    localHashMap.put(localSmtpCommand3.name().toString(), localSmtpCommand3);
    localHashMap.put(localSmtpCommand4.name().toString(), localSmtpCommand4);
    localHashMap.put(localSmtpCommand5.name().toString(), localSmtpCommand5);
    localHashMap.put(localSmtpCommand6.name().toString(), localSmtpCommand6);
    localHashMap.put(localSmtpCommand7.name().toString(), localSmtpCommand7);
    localHashMap.put(localSmtpCommand8.name().toString(), localSmtpCommand8);
    localHashMap.put(localSmtpCommand9.name().toString(), localSmtpCommand9);
    localHashMap.put(localSmtpCommand10.name().toString(), localSmtpCommand10);
    localHashMap.put(localSmtpCommand11.name().toString(), localSmtpCommand11);
    localHashMap.put(localSmtpCommand12.name().toString(), localSmtpCommand12);
    localHashMap.put(localSmtpCommand13.name().toString(), localSmtpCommand13);
  }
  
  private SmtpCommand(AsciiString paramAsciiString)
  {
    this.name = paramAsciiString;
  }
  
  public static SmtpCommand valueOf(CharSequence paramCharSequence)
  {
    ObjectUtil.checkNotNull(paramCharSequence, "commandName");
    SmtpCommand localSmtpCommand = (SmtpCommand)COMMANDS.get(paramCharSequence.toString());
    if (localSmtpCommand != null) {
      paramCharSequence = localSmtpCommand;
    } else {
      paramCharSequence = new SmtpCommand(AsciiString.of(paramCharSequence));
    }
    return paramCharSequence;
  }
  
  void encode(ByteBuf paramByteBuf)
  {
    ByteBufUtil.writeAscii(paramByteBuf, this.name);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof SmtpCommand)) {
      return false;
    }
    return this.name.contentEqualsIgnoreCase(((SmtpCommand)paramObject).name());
  }
  
  public int hashCode()
  {
    return this.name.hashCode();
  }
  
  boolean isContentExpected()
  {
    return equals(DATA);
  }
  
  public AsciiString name()
  {
    return this.name;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SmtpCommand{name=");
    localStringBuilder.append(this.name);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\smtp\SmtpCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */