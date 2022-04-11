package com.jcraft.jsch;

import java.io.IOException;
import java.util.Vector;

class ChannelAgentForwarding
  extends Channel
{
  private static final int LOCAL_MAXIMUM_PACKET_SIZE = 16384;
  private static final int LOCAL_WINDOW_SIZE_MAX = 131072;
  private final byte SSH2_AGENTC_ADD_IDENTITY = (byte)17;
  private final byte SSH2_AGENTC_REMOVE_ALL_IDENTITIES = (byte)19;
  private final byte SSH2_AGENTC_REMOVE_IDENTITY = (byte)18;
  private final byte SSH2_AGENTC_REQUEST_IDENTITIES = (byte)11;
  private final byte SSH2_AGENTC_SIGN_REQUEST = (byte)13;
  private final byte SSH2_AGENT_FAILURE = (byte)30;
  private final byte SSH2_AGENT_IDENTITIES_ANSWER = (byte)12;
  private final byte SSH2_AGENT_SIGN_RESPONSE = (byte)14;
  private final byte SSH_AGENTC_ADD_RSA_IDENTITY = (byte)7;
  private final byte SSH_AGENTC_REMOVE_ALL_RSA_IDENTITIES = (byte)9;
  private final byte SSH_AGENTC_REMOVE_RSA_IDENTITY = (byte)8;
  private final byte SSH_AGENTC_REQUEST_RSA_IDENTITIES = (byte)1;
  private final byte SSH_AGENTC_RSA_CHALLENGE = (byte)3;
  private final byte SSH_AGENT_FAILURE = (byte)5;
  private final byte SSH_AGENT_RSA_IDENTITIES_ANSWER = (byte)2;
  private final byte SSH_AGENT_RSA_RESPONSE = (byte)4;
  private final byte SSH_AGENT_SUCCESS = (byte)6;
  boolean init = true;
  private Buffer mbuf = null;
  private Packet packet = null;
  private Buffer rbuf = null;
  private Buffer wbuf = null;
  
  ChannelAgentForwarding()
  {
    setLocalWindowSizeMax(131072);
    setLocalWindowSize(131072);
    setLocalPacketSize(16384);
    this.type = Util.str2byte("auth-agent@openssh.com");
    Buffer localBuffer = new Buffer();
    this.rbuf = localBuffer;
    localBuffer.reset();
    this.mbuf = new Buffer();
    this.connected = true;
  }
  
  private void send(byte[] paramArrayOfByte)
  {
    this.packet.reset();
    this.wbuf.putByte((byte)94);
    this.wbuf.putInt(this.recipient);
    this.wbuf.putInt(paramArrayOfByte.length + 4);
    this.wbuf.putString(paramArrayOfByte);
    try
    {
      getSession().write(this.packet, this, paramArrayOfByte.length + 4);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;) {}
    }
  }
  
  void eof_remote()
  {
    super.eof_remote();
    eof();
  }
  
  public void run()
  {
    try
    {
      sendOpenConfirmation();
    }
    catch (Exception localException)
    {
      this.close = true;
      disconnect();
    }
  }
  
  void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.packet == null)
    {
      this.wbuf = new Buffer(this.rmpsize);
      this.packet = new Packet(this.wbuf);
    }
    this.rbuf.shift();
    Object localObject1 = this.rbuf;
    Object localObject2 = ((Buffer)localObject1).buffer;
    int i = localObject2.length;
    int j = ((Buffer)localObject1).index;
    int k = 0;
    int m = 0;
    if (i < j + paramInt2)
    {
      localObject1 = new byte[((Buffer)localObject1).s + paramInt2];
      System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
      this.rbuf.buffer = ((byte[])localObject1);
    }
    this.rbuf.putByte(paramArrayOfByte, paramInt1, paramInt2);
    if (this.rbuf.getInt() > this.rbuf.getLength())
    {
      paramArrayOfByte = this.rbuf;
      paramArrayOfByte.s -= 4;
      return;
    }
    for (paramInt1 = this.rbuf.getByte();; paramInt1++)
    {
      for (;;)
      {
        try
        {
          localObject2 = getSession();
          paramArrayOfByte = ((Session)localObject2).getIdentityRepository();
          UserInfo localUserInfo = ((Session)localObject2).getUserInfo();
          this.mbuf.reset();
          if (paramInt1 == 11)
          {
            this.mbuf.putByte((byte)12);
            paramArrayOfByte = paramArrayOfByte.getIdentities();
            k = 0;
            paramInt1 = 0;
            try
            {
              if (k < paramArrayOfByte.size())
              {
                paramInt2 = paramInt1;
                if (((Identity)paramArrayOfByte.elementAt(k)).getPublicKeyBlob() != null) {
                  paramInt2 = paramInt1 + 1;
                }
                k++;
                paramInt1 = paramInt2;
                continue;
              }
              this.mbuf.putInt(paramInt1);
              paramInt1 = m;
              if (paramInt1 < paramArrayOfByte.size())
              {
                localObject2 = ((Identity)paramArrayOfByte.elementAt(paramInt1)).getPublicKeyBlob();
                if (localObject2 != null)
                {
                  this.mbuf.putString((byte[])localObject2);
                  this.mbuf.putString(Util.empty);
                }
                paramInt1++;
                continue;
              }
            }
            finally {}
          }
          if (paramInt1 == 1)
          {
            this.mbuf.putByte((byte)2);
            this.mbuf.putInt(0);
          }
          else if (paramInt1 == 13)
          {
            byte[] arrayOfByte2 = this.rbuf.getString();
            localObject1 = this.rbuf.getString();
            this.rbuf.getInt();
            Vector localVector = paramArrayOfByte.getIdentities();
            paramInt1 = k;
            Object localObject4;
            try
            {
              paramInt2 = localVector.size();
              arrayOfByte1 = null;
              if (paramInt1 < paramInt2)
              {
                paramArrayOfByte = (Identity)localVector.elementAt(paramInt1);
                if ((paramArrayOfByte.getPublicKeyBlob() != null) && (Util.array_equals(arrayOfByte2, paramArrayOfByte.getPublicKeyBlob()))) {
                  if (paramArrayOfByte.isEncrypted())
                  {
                    if (localUserInfo == null) {
                      continue;
                    }
                    if (paramArrayOfByte.isEncrypted())
                    {
                      localObject4 = new java/lang/StringBuilder;
                      ((StringBuilder)localObject4).<init>();
                      ((StringBuilder)localObject4).append("Passphrase for ");
                      ((StringBuilder)localObject4).append(paramArrayOfByte.getName());
                      if (localUserInfo.promptPassphrase(((StringBuilder)localObject4).toString()))
                      {
                        localObject4 = localUserInfo.getPassphrase();
                        if (localObject4 != null) {
                          localObject4 = Util.str2byte((String)localObject4);
                        }
                      }
                    }
                  }
                }
              }
            }
            finally {}
          }
        }
        catch (JSchException paramArrayOfByte)
        {
          byte[] arrayOfByte1;
          boolean bool;
          int n;
          throw new IOException(paramArrayOfByte.toString());
        }
        try
        {
          bool = paramArrayOfByte.setPassphrase((byte[])localObject4);
          if (!bool) {}
        }
        catch (JSchException localJSchException) {}
      }
      if (!paramArrayOfByte.isEncrypted()) {
        break label597;
      }
    }
    paramArrayOfByte = null;
    label597:
    if (paramArrayOfByte != null) {
      arrayOfByte1 = paramArrayOfByte.getSignature((byte[])localObject1);
    }
    if (arrayOfByte1 == null)
    {
      this.mbuf.putByte((byte)30);
    }
    else
    {
      this.mbuf.putByte((byte)14);
      this.mbuf.putString(arrayOfByte1);
      break label824;
      paramInt2 = 6;
      if (paramInt1 == 18)
      {
        paramArrayOfByte.remove(this.rbuf.getString());
        this.mbuf.putByte((byte)6);
      }
      else if (paramInt1 == 9)
      {
        this.mbuf.putByte((byte)6);
      }
      else if (paramInt1 == 19)
      {
        paramArrayOfByte.removeAll();
        this.mbuf.putByte((byte)6);
      }
      else if (paramInt1 == 17)
      {
        arrayOfByte1 = new byte[this.rbuf.getLength()];
        this.rbuf.getByte(arrayOfByte1);
        bool = paramArrayOfByte.add(arrayOfByte1);
        paramArrayOfByte = this.mbuf;
        if (bool)
        {
          n = paramInt2;
        }
        else
        {
          paramInt1 = 5;
          n = paramInt1;
        }
        paramArrayOfByte.putByte(n);
      }
      else
      {
        paramArrayOfByte = this.rbuf;
        paramArrayOfByte.skip(paramArrayOfByte.getLength() - 1);
        this.mbuf.putByte((byte)5);
      }
    }
    label824:
    paramArrayOfByte = new byte[this.mbuf.getLength()];
    this.mbuf.getByte(paramArrayOfByte);
    send(paramArrayOfByte);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\ChannelAgentForwarding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */