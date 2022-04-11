package com.jcraft.jsch;

public class RequestSftp
  extends Request
{
  RequestSftp()
  {
    setReply(true);
  }
  
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
    localBuffer.putString(Util.str2byte("sftp"));
    write(paramSession);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\RequestSftp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */