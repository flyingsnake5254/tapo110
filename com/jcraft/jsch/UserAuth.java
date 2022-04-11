package com.jcraft.jsch;

public abstract class UserAuth
{
  protected static final int SSH_MSG_USERAUTH_BANNER = 53;
  protected static final int SSH_MSG_USERAUTH_FAILURE = 51;
  protected static final int SSH_MSG_USERAUTH_INFO_REQUEST = 60;
  protected static final int SSH_MSG_USERAUTH_INFO_RESPONSE = 61;
  protected static final int SSH_MSG_USERAUTH_PK_OK = 60;
  protected static final int SSH_MSG_USERAUTH_REQUEST = 50;
  protected static final int SSH_MSG_USERAUTH_SUCCESS = 52;
  protected Buffer buf;
  protected Packet packet;
  protected UserInfo userinfo;
  protected String username;
  
  public boolean start(Session paramSession)
    throws Exception
  {
    this.userinfo = paramSession.getUserInfo();
    Packet localPacket = paramSession.packet;
    this.packet = localPacket;
    this.buf = localPacket.getBuffer();
    this.username = paramSession.getUserName();
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\UserAuth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */