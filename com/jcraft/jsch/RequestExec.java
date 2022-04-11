package com.jcraft.jsch;

class RequestExec
  extends Request
{
  private byte[] command = new byte[0];
  
  RequestExec(byte[] paramArrayOfByte)
  {
    this.command = paramArrayOfByte;
  }
  
  public void request(Session paramSession, Channel paramChannel)
    throws Exception
  {
    super.request(paramSession, paramChannel);
    paramSession = new Buffer();
    Packet localPacket = new Packet(paramSession);
    localPacket.reset();
    paramSession.putByte((byte)98);
    paramSession.putInt(paramChannel.getRecipient());
    paramSession.putString(Util.str2byte("exec"));
    paramSession.putByte((byte)waitForReply());
    paramSession.checkFreeSize(this.command.length + 4);
    paramSession.putString(this.command);
    write(localPacket);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\RequestExec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */