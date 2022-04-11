package com.jcraft.jsch;

import java.io.PrintStream;

public abstract class DHECN
  extends KeyExchange
{
  private static final int SSH_MSG_KEX_ECDH_INIT = 30;
  private static final int SSH_MSG_KEX_ECDH_REPLY = 31;
  byte[] I_C;
  byte[] I_S;
  byte[] Q_C;
  byte[] V_C;
  byte[] V_S;
  private Buffer buf;
  byte[] e;
  private ECDH ecdh;
  protected int key_size;
  private Packet packet;
  protected String sha_name;
  private int state;
  
  public int getState()
  {
    return this.state;
  }
  
  public void init(Session paramSession, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
    throws Exception
  {
    this.session = paramSession;
    this.V_S = paramArrayOfByte1;
    this.V_C = paramArrayOfByte2;
    this.I_S = paramArrayOfByte3;
    this.I_C = paramArrayOfByte4;
    try
    {
      paramArrayOfByte2 = (HASH)Class.forName(paramSession.getConfig(this.sha_name)).newInstance();
      this.sha = paramArrayOfByte2;
      paramArrayOfByte2.init();
    }
    catch (Exception paramArrayOfByte2)
    {
      System.err.println(paramArrayOfByte2);
    }
    this.buf = new Buffer();
    paramArrayOfByte2 = new Packet(this.buf);
    this.packet = paramArrayOfByte2;
    paramArrayOfByte2.reset();
    this.buf.putByte((byte)30);
    try
    {
      paramArrayOfByte2 = (ECDH)Class.forName(paramSession.getConfig("ecdh-sha2-nistp")).newInstance();
      this.ecdh = paramArrayOfByte2;
      paramArrayOfByte2.init(this.key_size);
      paramArrayOfByte2 = this.ecdh.getQ();
      this.Q_C = paramArrayOfByte2;
      this.buf.putString(paramArrayOfByte2);
      if (paramArrayOfByte1 == null) {
        return;
      }
      paramSession.write(this.packet);
      if (JSch.getLogger().isEnabled(1))
      {
        JSch.getLogger().log(1, "SSH_MSG_KEX_ECDH_INIT sent");
        JSch.getLogger().log(1, "expecting SSH_MSG_KEX_ECDH_REPLY");
      }
      this.state = 31;
      return;
    }
    catch (Exception paramSession)
    {
      throw new JSchException(paramSession.toString(), paramSession);
    }
  }
  
  public boolean next(Buffer paramBuffer)
    throws Exception
  {
    if (this.state != 31) {
      return false;
    }
    paramBuffer.getInt();
    paramBuffer.getByte();
    int i = paramBuffer.getByte();
    if (i != 31)
    {
      paramBuffer = System.err;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("type: must be 31 ");
      ((StringBuilder)localObject1).append(i);
      paramBuffer.println(((StringBuilder)localObject1).toString());
      return false;
    }
    this.K_S = paramBuffer.getString();
    Object localObject1 = paramBuffer.getString();
    Object localObject2 = KeyPairECDSA.fromPoint((byte[])localObject1);
    if (!this.ecdh.validate(localObject2[0], localObject2[1])) {
      return false;
    }
    localObject2 = this.ecdh.getSecret(localObject2[0], localObject2[1]);
    this.K = ((byte[])localObject2);
    this.K = normalize((byte[])localObject2);
    paramBuffer = paramBuffer.getString();
    this.buf.reset();
    this.buf.putString(this.V_C);
    this.buf.putString(this.V_S);
    this.buf.putString(this.I_C);
    this.buf.putString(this.I_S);
    this.buf.putString(this.K_S);
    this.buf.putString(this.Q_C);
    this.buf.putString((byte[])localObject1);
    this.buf.putMPInt(this.K);
    i = this.buf.getLength();
    localObject1 = new byte[i];
    this.buf.getByte((byte[])localObject1);
    this.sha.update((byte[])localObject1, 0, i);
    this.H = this.sha.digest();
    localObject1 = this.K_S;
    i = localObject1[0] << 24 & 0xFF000000 | localObject1[1] << 16 & 0xFF0000 | localObject1[2] << 8 & 0xFF00 | localObject1[3] & 0xFF;
    boolean bool = verify(Util.byte2str((byte[])localObject1, 4, i), this.K_S, 4 + i, paramBuffer);
    this.state = 0;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\DHECN.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */