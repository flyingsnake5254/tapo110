package com.jcraft.jsch;

class RequestX11
  extends Request
{
  public void request(Session paramSession, Channel paramChannel)
    throws Exception
  {
    super.request(paramSession, paramChannel);
    Buffer localBuffer = new Buffer();
    Packet localPacket = new Packet(localBuffer);
    localPacket.reset();
    localBuffer.putByte((byte)98);
    localBuffer.putInt(paramChannel.getRecipient());
    localBuffer.putString(Util.str2byte("x11-req"));
    localBuffer.putByte((byte)waitForReply());
    localBuffer.putByte((byte)0);
    localBuffer.putString(Util.str2byte("MIT-MAGIC-COOKIE-1"));
    localBuffer.putString(ChannelX11.getFakedCookie(paramSession));
    localBuffer.putInt(0);
    write(localPacket);
    paramSession.x11_forwarding = true;
  }
  
  public void setCookie(String paramString)
  {
    ChannelX11.cookie = Util.str2byte(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\RequestX11.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */