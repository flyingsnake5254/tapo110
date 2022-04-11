package com.jcraft.jsch;

class UserAuthPassword
  extends UserAuth
{
  private final int SSH_MSG_USERAUTH_PASSWD_CHANGEREQ = 60;
  
  public boolean start(Session paramSession)
    throws Exception
  {
    super.start(paramSession);
    Object localObject1 = paramSession.password;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.username);
    ((StringBuilder)localObject2).append("@");
    ((StringBuilder)localObject2).append(paramSession.host);
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = localObject2;
    Object localObject4;
    if (paramSession.port != 22)
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append((String)localObject2);
      ((StringBuilder)localObject4).append(":");
      ((StringBuilder)localObject4).append(paramSession.port);
      localObject3 = ((StringBuilder)localObject4).toString();
    }
    for (;;)
    {
      localObject4 = localObject1;
      try
      {
        int i = paramSession.auth_failures;
        localObject4 = localObject1;
        int j = paramSession.max_auth_tries;
        if (i >= j) {
          return false;
        }
        localObject2 = localObject1;
        Object localObject5;
        if (localObject1 == null)
        {
          localObject4 = localObject1;
          localObject2 = this.userinfo;
          if (localObject2 == null) {
            return false;
          }
          localObject4 = localObject1;
          localObject5 = new java/lang/StringBuilder;
          localObject4 = localObject1;
          ((StringBuilder)localObject5).<init>();
          localObject4 = localObject1;
          ((StringBuilder)localObject5).append("Password for ");
          localObject4 = localObject1;
          ((StringBuilder)localObject5).append((String)localObject3);
          localObject4 = localObject1;
          if (((UserInfo)localObject2).promptPassword(((StringBuilder)localObject5).toString()))
          {
            localObject4 = localObject1;
            localObject2 = this.userinfo.getPassword();
            if (localObject2 != null)
            {
              localObject4 = localObject1;
              localObject2 = Util.str2byte((String)localObject2);
            }
            else
            {
              localObject4 = localObject1;
              paramSession = new com/jcraft/jsch/JSchAuthCancelException;
              localObject4 = localObject1;
              paramSession.<init>("password");
              localObject4 = localObject1;
              throw paramSession;
            }
          }
          else
          {
            localObject4 = localObject1;
            paramSession = new com/jcraft/jsch/JSchAuthCancelException;
            localObject4 = localObject1;
            paramSession.<init>("password");
            localObject4 = localObject1;
            throw paramSession;
          }
        }
        localObject4 = localObject2;
        localObject1 = Util.str2byte(this.username);
        localObject4 = localObject2;
        this.packet.reset();
        localObject4 = localObject2;
        this.buf.putByte((byte)50);
        localObject4 = localObject2;
        this.buf.putString((byte[])localObject1);
        localObject4 = localObject2;
        this.buf.putString(Util.str2byte("ssh-connection"));
        localObject4 = localObject2;
        this.buf.putString(Util.str2byte("password"));
        localObject4 = localObject2;
        this.buf.putByte((byte)0);
        localObject4 = localObject2;
        this.buf.putString((byte[])localObject2);
        localObject4 = localObject2;
        paramSession.write(this.packet);
        UserInfo localUserInfo;
        for (;;)
        {
          localObject4 = localObject2;
          localObject5 = paramSession.read(this.buf);
          localObject4 = localObject2;
          this.buf = ((Buffer)localObject5);
          localObject4 = localObject2;
          j = ((Buffer)localObject5).getCommand();
          j &= 0xFF;
          if (j == 52) {
            return true;
          }
          if (j == 53)
          {
            localObject4 = localObject2;
            this.buf.getInt();
            localObject4 = localObject2;
            this.buf.getByte();
            localObject4 = localObject2;
            this.buf.getByte();
            localObject4 = localObject2;
            localObject5 = this.buf.getString();
            localObject4 = localObject2;
            this.buf.getString();
            localObject4 = localObject2;
            localObject5 = Util.byte2str((byte[])localObject5);
            localObject4 = localObject2;
            localUserInfo = this.userinfo;
            if (localUserInfo != null)
            {
              localObject4 = localObject2;
              localUserInfo.showMessage((String)localObject5);
            }
          }
          else
          {
            if (j != 60) {
              break label871;
            }
            localObject4 = localObject2;
            this.buf.getInt();
            localObject4 = localObject2;
            this.buf.getByte();
            localObject4 = localObject2;
            this.buf.getByte();
            localObject4 = localObject2;
            localObject5 = this.buf.getString();
            localObject4 = localObject2;
            this.buf.getString();
            localObject4 = localObject2;
            localUserInfo = this.userinfo;
            if (localUserInfo == null) {
              break label844;
            }
            localObject4 = localObject2;
            if (!(localUserInfo instanceof UIKeyboardInteractive)) {
              break label844;
            }
            localObject4 = localObject2;
            localObject5 = ((UIKeyboardInteractive)localUserInfo).promptKeyboardInteractive((String)localObject3, "Password Change Required", Util.byte2str((byte[])localObject5), new String[] { "New Password: " }, new boolean[] { false });
            if (localObject5 == null) {
              break;
            }
            localObject4 = localObject2;
            localObject5 = Util.str2byte(localObject5[0]);
            localObject4 = localObject2;
            this.packet.reset();
            localObject4 = localObject2;
            this.buf.putByte((byte)50);
            localObject4 = localObject2;
            this.buf.putString((byte[])localObject1);
            localObject4 = localObject2;
            this.buf.putString(Util.str2byte("ssh-connection"));
            localObject4 = localObject2;
            this.buf.putString(Util.str2byte("password"));
            localObject4 = localObject2;
            this.buf.putByte((byte)1);
            localObject4 = localObject2;
            this.buf.putString((byte[])localObject2);
            localObject4 = localObject2;
            this.buf.putString((byte[])localObject5);
            localObject4 = localObject2;
            Util.bzero((byte[])localObject5);
            localObject4 = localObject2;
            paramSession.write(this.packet);
          }
        }
        localObject4 = localObject2;
        paramSession = new com/jcraft/jsch/JSchAuthCancelException;
        localObject4 = localObject2;
        paramSession.<init>("password");
        localObject4 = localObject2;
        throw paramSession;
        label844:
        if (localUserInfo != null)
        {
          localObject4 = localObject2;
          localUserInfo.showMessage("Password must be changed.");
        }
        return false;
        label871:
        if (j == 51)
        {
          localObject4 = localObject2;
          this.buf.getInt();
          localObject4 = localObject2;
          this.buf.getByte();
          localObject4 = localObject2;
          this.buf.getByte();
          localObject4 = localObject2;
          localObject1 = this.buf.getString();
          localObject4 = localObject2;
          if (this.buf.getByte() == 0)
          {
            localObject4 = localObject2;
            paramSession.auth_failures += 1;
            localObject1 = localObject2;
            if (localObject2 == null) {
              continue;
            }
            localObject4 = localObject2;
            Util.bzero((byte[])localObject2);
            localObject1 = null;
            continue;
          }
          localObject4 = localObject2;
          paramSession = new com/jcraft/jsch/JSchPartialAuthException;
          localObject4 = localObject2;
          paramSession.<init>(Util.byte2str((byte[])localObject1));
          localObject4 = localObject2;
          throw paramSession;
        }
        return false;
      }
      finally
      {
        if (localObject4 != null) {
          Util.bzero((byte[])localObject4);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\UserAuthPassword.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */