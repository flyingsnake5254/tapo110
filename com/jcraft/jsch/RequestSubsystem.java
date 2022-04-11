package com.jcraft.jsch;

public class RequestSubsystem
  extends Request
{
  private String subsystem = null;
  
  public void request(Session paramSession, Channel paramChannel)
    throws Exception
  {
    super.request(paramSession, paramChannel);
    Buffer localBuffer = new Buffer();
    paramSession = new Packet(localBuffer);
    paramSession.reset();
    localBuffer.putByte((byte)98);
    localBuffer.putInt(paramChannel.getRecipient());
    localBuffer.putString(Util.str2byte("subsystem"));
    localBuffer.putByte((byte)waitForReply());
    localBuffer.putString(Util.str2byte(this.subsystem));
    write(paramSession);
  }
  
  public void request(Session paramSession, Channel paramChannel, String paramString, boolean paramBoolean)
    throws Exception
  {
    setReply(paramBoolean);
    this.subsystem = paramString;
    request(paramSession, paramChannel);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\RequestSubsystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */