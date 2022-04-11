package com.jcraft.jsch;

class RequestShell
  extends Request
{
  public void request(Session paramSession, Channel paramChannel)
    throws Exception
  {
    super.request(paramSession, paramChannel);
    Buffer localBuffer = new Buffer();
    paramSession = new Packet(localBuffer);
    paramSession.reset();
    localBuffer.putByte((byte)98);
    localBuffer.putInt(paramChannel.getRecipient());
    localBuffer.putString(Util.str2byte("shell"));
    localBuffer.putByte((byte)waitForReply());
    write(paramSession);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\RequestShell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */