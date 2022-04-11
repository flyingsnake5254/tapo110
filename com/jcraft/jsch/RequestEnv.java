package com.jcraft.jsch;

class RequestEnv
  extends Request
{
  byte[] name = new byte[0];
  byte[] value = new byte[0];
  
  public void request(Session paramSession, Channel paramChannel)
    throws Exception
  {
    super.request(paramSession, paramChannel);
    paramSession = new Buffer();
    Packet localPacket = new Packet(paramSession);
    localPacket.reset();
    paramSession.putByte((byte)98);
    paramSession.putInt(paramChannel.getRecipient());
    paramSession.putString(Util.str2byte("env"));
    paramSession.putByte((byte)waitForReply());
    paramSession.putString(this.name);
    paramSession.putString(this.value);
    write(localPacket);
  }
  
  void setEnv(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.name = paramArrayOfByte1;
    this.value = paramArrayOfByte2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\RequestEnv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */