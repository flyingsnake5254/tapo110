package com.jcraft.jsch;

class RequestAgentForwarding
  extends Request
{
  public void request(Session paramSession, Channel paramChannel)
    throws Exception
  {
    super.request(paramSession, paramChannel);
    setReply(false);
    Buffer localBuffer = new Buffer();
    Packet localPacket = new Packet(localBuffer);
    localPacket.reset();
    localBuffer.putByte((byte)98);
    localBuffer.putInt(paramChannel.getRecipient());
    localBuffer.putString(Util.str2byte("auth-agent-req@openssh.com"));
    localBuffer.putByte((byte)waitForReply());
    write(localPacket);
    paramSession.agent_forwarding = true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\RequestAgentForwarding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */