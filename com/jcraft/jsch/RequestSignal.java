package com.jcraft.jsch;

class RequestSignal
  extends Request
{
  private String signal = "KILL";
  
  public void request(Session paramSession, Channel paramChannel)
    throws Exception
  {
    super.request(paramSession, paramChannel);
    paramSession = new Buffer();
    Packet localPacket = new Packet(paramSession);
    localPacket.reset();
    paramSession.putByte((byte)98);
    paramSession.putInt(paramChannel.getRecipient());
    paramSession.putString(Util.str2byte("signal"));
    paramSession.putByte((byte)waitForReply());
    paramSession.putString(Util.str2byte(this.signal));
    write(localPacket);
  }
  
  public void setSignal(String paramString)
  {
    this.signal = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\RequestSignal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */