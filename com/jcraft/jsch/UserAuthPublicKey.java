package com.jcraft.jsch;

import java.util.Vector;

class UserAuthPublicKey
  extends UserAuth
{
  public boolean start(Session paramSession)
    throws Exception
  {
    super.start(paramSession);
    synchronized (paramSession.getIdentityRepository().getIdentities())
    {
      if (???.size() <= 0) {
        return false;
      }
      byte[] arrayOfByte = Util.str2byte(this.username);
      for (int i = 0; i < ???.size(); i++)
      {
        if (paramSession.auth_failures >= paramSession.max_auth_tries) {
          return false;
        }
        Identity localIdentity = (Identity)???.elementAt(i);
        Object localObject1 = localIdentity.getPublicKeyBlob();
        Object localObject2;
        int j;
        Object localObject3;
        if (localObject1 != null)
        {
          this.packet.reset();
          this.buf.putByte((byte)50);
          this.buf.putString(arrayOfByte);
          this.buf.putString(Util.str2byte("ssh-connection"));
          this.buf.putString(Util.str2byte("publickey"));
          this.buf.putByte((byte)0);
          this.buf.putString(Util.str2byte(localIdentity.getAlgName()));
          this.buf.putString((byte[])localObject1);
          paramSession.write(this.packet);
          for (;;)
          {
            localObject2 = paramSession.read(this.buf);
            this.buf = ((Buffer)localObject2);
            j = ((Buffer)localObject2).getCommand() & 0xFF;
            if ((j == 60) || (j == 51) || (j != 53)) {
              break;
            }
            this.buf.getInt();
            this.buf.getByte();
            this.buf.getByte();
            localObject2 = this.buf.getString();
            this.buf.getString();
            localObject3 = Util.byte2str((byte[])localObject2);
            localObject2 = this.userinfo;
            if (localObject2 != null) {
              ((UserInfo)localObject2).showMessage((String)localObject3);
            }
          }
          if (j != 60) {}
        }
        else
        {
          j = 5;
          label452:
          int k;
          do
          {
            if (localIdentity.isEncrypted()) {
              if (this.userinfo != null)
              {
                if (localIdentity.isEncrypted())
                {
                  localObject3 = this.userinfo;
                  localObject2 = new java/lang/StringBuilder;
                  ((StringBuilder)localObject2).<init>();
                  ((StringBuilder)localObject2).append("Passphrase for ");
                  ((StringBuilder)localObject2).append(localIdentity.getName());
                  if (!((UserInfo)localObject3).promptPassphrase(((StringBuilder)localObject2).toString()))
                  {
                    paramSession = new com/jcraft/jsch/JSchAuthCancelException;
                    paramSession.<init>("publickey");
                    throw paramSession;
                  }
                }
                localObject2 = this.userinfo.getPassphrase();
                if (localObject2 != null)
                {
                  localObject2 = Util.str2byte((String)localObject2);
                  break label452;
                }
              }
              else
              {
                paramSession = new com/jcraft/jsch/JSchException;
                paramSession.<init>("USERAUTH fail");
                throw paramSession;
              }
            }
            localObject2 = null;
            if (((!localIdentity.isEncrypted()) || (localObject2 != null)) && (localIdentity.setPassphrase((byte[])localObject2)))
            {
              if ((localObject2 != null) && ((paramSession.getIdentityRepository() instanceof IdentityRepository.Wrapper))) {
                ((IdentityRepository.Wrapper)paramSession.getIdentityRepository()).check();
              }
              break;
            }
            Util.bzero((byte[])localObject2);
            k = j - 1;
            j = k;
          } while (k != 0);
          localObject2 = null;
          Util.bzero((byte[])localObject2);
          if (!localIdentity.isEncrypted())
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = localIdentity.getPublicKeyBlob();
            }
            if (localObject2 != null)
            {
              this.packet.reset();
              this.buf.putByte((byte)50);
              this.buf.putString(arrayOfByte);
              this.buf.putString(Util.str2byte("ssh-connection"));
              this.buf.putString(Util.str2byte("publickey"));
              this.buf.putByte((byte)1);
              this.buf.putString(Util.str2byte(localIdentity.getAlgName()));
              this.buf.putString((byte[])localObject2);
              localObject1 = paramSession.getSessionId();
              k = localObject1.length;
              j = k + 4;
              localObject2 = new byte[this.buf.index + j - 5];
              localObject2[0] = ((byte)(byte)(k >>> 24));
              localObject2[1] = ((byte)(byte)(k >>> 16));
              localObject2[2] = ((byte)(byte)(k >>> 8));
              localObject2[3] = ((byte)(byte)k);
              System.arraycopy(localObject1, 0, localObject2, 4, k);
              localObject1 = this.buf;
              System.arraycopy(((Buffer)localObject1).buffer, 5, localObject2, j, ((Buffer)localObject1).index - 5);
              localObject2 = localIdentity.getSignature((byte[])localObject2);
              if (localObject2 == null) {
                break;
              }
              this.buf.putString((byte[])localObject2);
              paramSession.write(this.packet);
              for (;;)
              {
                localObject2 = paramSession.read(this.buf);
                this.buf = ((Buffer)localObject2);
                j = ((Buffer)localObject2).getCommand() & 0xFF;
                if (j == 52) {
                  return true;
                }
                if (j != 53) {
                  break;
                }
                this.buf.getInt();
                this.buf.getByte();
                this.buf.getByte();
                localObject2 = this.buf.getString();
                this.buf.getString();
                localObject1 = Util.byte2str((byte[])localObject2);
                localObject2 = this.userinfo;
                if (localObject2 != null) {
                  ((UserInfo)localObject2).showMessage((String)localObject1);
                }
              }
              if (j == 51)
              {
                this.buf.getInt();
                this.buf.getByte();
                this.buf.getByte();
                localObject2 = this.buf.getString();
                if (this.buf.getByte() == 0)
                {
                  paramSession.auth_failures += 1;
                }
                else
                {
                  paramSession = new com/jcraft/jsch/JSchPartialAuthException;
                  paramSession.<init>(Util.byte2str((byte[])localObject2));
                  throw paramSession;
                }
              }
            }
          }
        }
      }
      return false;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\UserAuthPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */