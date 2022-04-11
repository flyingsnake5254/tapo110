package com.jcraft.jsch;

class UserAuthNone
  extends UserAuth
{
  private static final int SSH_MSG_SERVICE_ACCEPT = 6;
  private String methods = null;
  
  String getMethods()
  {
    return this.methods;
  }
  
  public boolean start(Session paramSession)
    throws Exception
  {
    super.start(paramSession);
    this.packet.reset();
    this.buf.putByte((byte)5);
    this.buf.putString(Util.str2byte("ssh-userauth"));
    paramSession.write(this.packet);
    if (JSch.getLogger().isEnabled(1)) {
      JSch.getLogger().log(1, "SSH_MSG_SERVICE_REQUEST sent");
    }
    Object localObject = paramSession.read(this.buf);
    this.buf = ((Buffer)localObject);
    int i;
    if (((Buffer)localObject).getCommand() == 6) {
      i = 1;
    } else {
      i = 0;
    }
    if (JSch.getLogger().isEnabled(1)) {
      JSch.getLogger().log(1, "SSH_MSG_SERVICE_ACCEPT received");
    }
    if (i == 0) {
      return false;
    }
    localObject = Util.str2byte(this.username);
    this.packet.reset();
    this.buf.putByte((byte)50);
    this.buf.putString((byte[])localObject);
    this.buf.putString(Util.str2byte("ssh-connection"));
    this.buf.putString(Util.str2byte("none"));
    paramSession.write(this.packet);
    for (;;)
    {
      localObject = paramSession.read(this.buf);
      this.buf = ((Buffer)localObject);
      i = ((Buffer)localObject).getCommand() & 0xFF;
      if (i == 52) {
        return true;
      }
      if (i != 53) {
        break;
      }
      this.buf.getInt();
      this.buf.getByte();
      this.buf.getByte();
      localObject = this.buf.getString();
      this.buf.getString();
      String str = Util.byte2str((byte[])localObject);
      localObject = this.userinfo;
      if (localObject != null) {
        try
        {
          ((UserInfo)localObject).showMessage(str);
        }
        catch (RuntimeException localRuntimeException) {}
      }
    }
    if (i == 51)
    {
      this.buf.getInt();
      this.buf.getByte();
      this.buf.getByte();
      paramSession = this.buf.getString();
      this.buf.getByte();
      this.methods = Util.byte2str(paramSession);
      return false;
    }
    paramSession = new StringBuilder();
    paramSession.append("USERAUTH fail (");
    paramSession.append(i);
    paramSession.append(")");
    throw new JSchException(paramSession.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\UserAuthNone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */