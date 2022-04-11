package com.jcraft.jsch;

public class UserAuthGSSAPIWithMIC
  extends UserAuth
{
  private static final int SSH_MSG_USERAUTH_GSSAPI_ERROR = 64;
  private static final int SSH_MSG_USERAUTH_GSSAPI_ERRTOK = 65;
  private static final int SSH_MSG_USERAUTH_GSSAPI_EXCHANGE_COMPLETE = 63;
  private static final int SSH_MSG_USERAUTH_GSSAPI_MIC = 66;
  private static final int SSH_MSG_USERAUTH_GSSAPI_RESPONSE = 60;
  private static final int SSH_MSG_USERAUTH_GSSAPI_TOKEN = 61;
  private static final String[] supported_method = { "gssapi-with-mic.krb5" };
  private static final byte[][] supported_oid = { { 6, 9, 42, -122, 72, -122, -9, 18, 1, 2, 2 } };
  
  public boolean start(Session paramSession)
    throws Exception
  {
    super.start(paramSession);
    byte[] arrayOfByte = Util.str2byte(this.username);
    this.packet.reset();
    this.buf.putByte((byte)50);
    this.buf.putString(arrayOfByte);
    this.buf.putString(Util.str2byte("ssh-connection"));
    this.buf.putString(Util.str2byte("gssapi-with-mic"));
    this.buf.putInt(supported_oid.length);
    Object localObject1;
    for (int i = 0;; i++)
    {
      localObject1 = supported_oid;
      if (i >= localObject1.length) {
        break;
      }
      this.buf.putString(localObject1[i]);
    }
    paramSession.write(this.packet);
    GSSContext localGSSContext = null;
    for (;;)
    {
      localObject1 = paramSession.read(this.buf);
      this.buf = ((Buffer)localObject1);
      i = ((Buffer)localObject1).getCommand() & 0xFF;
      if (i == 51) {
        return false;
      }
      if (i == 60)
      {
        this.buf.getInt();
        this.buf.getByte();
        this.buf.getByte();
        localObject2 = this.buf.getString();
        for (i = 0;; i++)
        {
          byte[][] arrayOfByte1 = supported_oid;
          localObject1 = localGSSContext;
          if (i >= arrayOfByte1.length) {
            break;
          }
          if (Util.array_equals((byte[])localObject2, arrayOfByte1[i]))
          {
            localObject1 = supported_method[i];
            break;
          }
        }
        if (localObject1 == null) {
          return false;
        }
      }
      try
      {
        localGSSContext = (GSSContext)Class.forName(paramSession.getConfig((String)localObject1)).newInstance();
        localGSSContext.create(this.username, paramSession.host);
        localObject1 = new byte[0];
        while (!localGSSContext.isEstablished()) {
          try
          {
            localObject1 = localGSSContext.init((byte[])localObject1, 0, localObject1.length);
            if (localObject1 != null)
            {
              this.packet.reset();
              this.buf.putByte((byte)61);
              this.buf.putString((byte[])localObject1);
              paramSession.write(this.packet);
            }
            if (!localGSSContext.isEstablished())
            {
              localObject1 = paramSession.read(this.buf);
              this.buf = ((Buffer)localObject1);
              int j = ((Buffer)localObject1).getCommand() & 0xFF;
              if (j == 64)
              {
                localObject1 = paramSession.read(this.buf);
                this.buf = ((Buffer)localObject1);
              }
              for (i = ((Buffer)localObject1).getCommand();; i = ((Buffer)localObject1).getCommand())
              {
                i &= 0xFF;
                break;
                i = j;
                if (j != 65) {
                  break;
                }
                localObject1 = paramSession.read(this.buf);
                this.buf = ((Buffer)localObject1);
              }
              if (i == 51) {
                return false;
              }
              this.buf.getInt();
              this.buf.getByte();
              this.buf.getByte();
              localObject1 = this.buf.getString();
            }
          }
          catch (JSchException paramSession)
          {
            return false;
          }
        }
        localObject1 = new Buffer();
        ((Buffer)localObject1).putString(paramSession.getSessionId());
        ((Buffer)localObject1).putByte((byte)50);
        ((Buffer)localObject1).putString(arrayOfByte);
        ((Buffer)localObject1).putString(Util.str2byte("ssh-connection"));
        ((Buffer)localObject1).putString(Util.str2byte("gssapi-with-mic"));
        localObject1 = localGSSContext.getMIC(((Buffer)localObject1).buffer, 0, ((Buffer)localObject1).getLength());
        if (localObject1 == null) {
          return false;
        }
        this.packet.reset();
        this.buf.putByte((byte)66);
        this.buf.putString((byte[])localObject1);
        paramSession.write(this.packet);
        localGSSContext.dispose();
        paramSession = paramSession.read(this.buf);
        this.buf = paramSession;
        i = paramSession.getCommand() & 0xFF;
        if (i == 52) {
          return true;
        }
        if (i == 51)
        {
          this.buf.getInt();
          this.buf.getByte();
          this.buf.getByte();
          paramSession = this.buf.getString();
          if (this.buf.getByte() != 0) {
            throw new JSchPartialAuthException(Util.byte2str(paramSession));
          }
        }
      }
      catch (Exception|JSchException paramSession)
      {
        for (;;) {}
      }
      return false;
      if (i != 53) {
        break;
      }
      this.buf.getInt();
      this.buf.getByte();
      this.buf.getByte();
      localObject1 = this.buf.getString();
      this.buf.getString();
      Object localObject2 = Util.byte2str((byte[])localObject1);
      localObject1 = this.userinfo;
      if (localObject1 != null) {
        ((UserInfo)localObject1).showMessage((String)localObject2);
      }
    }
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\UserAuthGSSAPIWithMIC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */