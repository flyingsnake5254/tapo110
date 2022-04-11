package com.jcraft.jsch;

class UserAuthKeyboardInteractive
  extends UserAuth
{
  public boolean start(Session paramSession)
    throws Exception
  {
    super.start(paramSession);
    Object localObject1 = this.userinfo;
    if ((localObject1 != null) && (!(localObject1 instanceof UIKeyboardInteractive))) {
      return false;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.username);
    ((StringBuilder)localObject1).append("@");
    ((StringBuilder)localObject1).append(paramSession.host);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = localObject1;
    if (paramSession.port != 22)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(":");
      ((StringBuilder)localObject3).append(paramSession.port);
      localObject2 = ((StringBuilder)localObject3).toString();
    }
    localObject1 = paramSession.password;
    byte[] arrayOfByte = Util.str2byte(this.username);
    int i = 0;
    if (paramSession.auth_failures >= paramSession.max_auth_tries) {
      return false;
    }
    this.packet.reset();
    this.buf.putByte((byte)50);
    this.buf.putString(arrayOfByte);
    this.buf.putString(Util.str2byte("ssh-connection"));
    this.buf.putString(Util.str2byte("keyboard-interactive"));
    Object localObject3 = this.buf;
    Object localObject4 = Util.empty;
    ((Buffer)localObject3).putString((byte[])localObject4);
    this.buf.putString((byte[])localObject4);
    paramSession.write(this.packet);
    int j = 1;
    for (;;)
    {
      localObject3 = paramSession.read(this.buf);
      this.buf = ((Buffer)localObject3);
      int k = ((Buffer)localObject3).getCommand() & 0xFF;
      if (k == 52) {
        return true;
      }
      if (k == 53)
      {
        this.buf.getInt();
        this.buf.getByte();
        this.buf.getByte();
        localObject3 = this.buf.getString();
        this.buf.getString();
        localObject3 = Util.byte2str((byte[])localObject3);
        localObject4 = this.userinfo;
        if (localObject4 != null) {
          ((UserInfo)localObject4).showMessage((String)localObject3);
        }
      }
      else
      {
        if (k == 51)
        {
          this.buf.getInt();
          this.buf.getByte();
          this.buf.getByte();
          localObject3 = this.buf.getString();
          if (this.buf.getByte() == 0)
          {
            if (j != 0) {
              return false;
            }
            paramSession.auth_failures += 1;
            if (i == 0) {
              break;
            }
            throw new JSchAuthCancelException("keyboard-interactive");
          }
          throw new JSchPartialAuthException(Util.byte2str((byte[])localObject3));
        }
        if (k != 60) {
          break label893;
        }
        this.buf.getInt();
        this.buf.getByte();
        this.buf.getByte();
        String str = Util.byte2str(this.buf.getString());
        localObject4 = Util.byte2str(this.buf.getString());
        Util.byte2str(this.buf.getString());
        int m = this.buf.getInt();
        String[] arrayOfString = new String[m];
        localObject3 = new boolean[m];
        for (k = 0; k < m; k++)
        {
          arrayOfString[k] = Util.byte2str(this.buf.getString());
          int n;
          if (this.buf.getByte() != 0) {
            n = 1;
          } else {
            n = 0;
          }
          localObject3[k] = n;
        }
        if ((localObject1 != null) && (m == 1) && (localObject3[0] == 0) && (arrayOfString[0].toLowerCase().indexOf("password:") >= 0))
        {
          localObject3 = new byte[1][];
          localObject3[0] = localObject1;
          localObject1 = null;
        }
        else
        {
          if ((m > 0) || (str.length() > 0) || (((String)localObject4).length() > 0))
          {
            UserInfo localUserInfo = this.userinfo;
            if (localUserInfo != null)
            {
              localObject4 = ((UIKeyboardInteractive)localUserInfo).promptKeyboardInteractive((String)localObject2, str, (String)localObject4, arrayOfString, (boolean[])localObject3);
              if (localObject4 != null)
              {
                localObject3 = new byte[localObject4.length][];
                for (k = 0; k < localObject4.length; k++) {
                  localObject3[k] = Util.str2byte(localObject4[k]);
                }
                break label737;
              }
            }
          }
          localObject3 = null;
        }
        label737:
        this.packet.reset();
        this.buf.putByte((byte)61);
        if ((m > 0) && ((localObject3 == null) || (m != localObject3.length)))
        {
          if (localObject3 == null)
          {
            this.buf.putInt(m);
            for (k = 0; k < m; k++) {
              this.buf.putString(Util.empty);
            }
          }
          this.buf.putInt(0);
          k = i;
          if (localObject3 == null) {
            k = 1;
          }
        }
        else
        {
          this.buf.putInt(m);
          for (j = 0;; j++)
          {
            k = i;
            if (j >= m) {
              break;
            }
            this.buf.putString(localObject3[j]);
          }
        }
        paramSession.write(this.packet);
        j = 0;
        i = k;
      }
    }
    label893:
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\UserAuthKeyboardInteractive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */