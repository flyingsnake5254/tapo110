package com.jcraft.jsch;

import java.io.PrintStream;

public class DHGEX
  extends KeyExchange
{
  private static final int SSH_MSG_KEX_DH_GEX_GROUP = 31;
  private static final int SSH_MSG_KEX_DH_GEX_INIT = 32;
  private static final int SSH_MSG_KEX_DH_GEX_REPLY = 33;
  private static final int SSH_MSG_KEX_DH_GEX_REQUEST = 34;
  static int min = 1024;
  static int preferred = 1024;
  byte[] I_C;
  byte[] I_S;
  byte[] V_C;
  byte[] V_S;
  private Buffer buf;
  DH dh;
  private byte[] e;
  private byte[] g;
  protected String hash = "sha-1";
  int max = 1024;
  private byte[] p;
  private Packet packet;
  private int state;
  
  protected int check2048(Class paramClass, int paramInt)
    throws Exception
  {
    DH localDH = (DH)paramClass.newInstance();
    localDH.init();
    paramClass = new byte['ā'];
    paramClass[1] = ((byte)-35);
    paramClass['Ā'] = ((byte)115);
    localDH.setP(paramClass);
    localDH.setG(new byte[] { 2 });
    try
    {
      localDH.getE();
      paramInt = 2048;
    }
    catch (Exception paramClass)
    {
      for (;;) {}
    }
    return paramInt;
  }
  
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
      paramArrayOfByte1 = (HASH)Class.forName(paramSession.getConfig(this.hash)).newInstance();
      this.sha = paramArrayOfByte1;
      paramArrayOfByte1.init();
    }
    catch (Exception paramArrayOfByte1)
    {
      System.err.println(paramArrayOfByte1);
    }
    this.buf = new Buffer();
    this.packet = new Packet(this.buf);
    try
    {
      paramArrayOfByte1 = Class.forName(paramSession.getConfig("dh"));
      int i = check2048(paramArrayOfByte1, this.max);
      this.max = i;
      preferred = i;
      paramArrayOfByte1 = (DH)paramArrayOfByte1.newInstance();
      this.dh = paramArrayOfByte1;
      paramArrayOfByte1.init();
      this.packet.reset();
      this.buf.putByte((byte)34);
      this.buf.putInt(min);
      this.buf.putInt(preferred);
      this.buf.putInt(this.max);
      paramSession.write(this.packet);
      if (JSch.getLogger().isEnabled(1))
      {
        paramArrayOfByte1 = JSch.getLogger();
        paramSession = new StringBuilder();
        paramSession.append("SSH_MSG_KEX_DH_GEX_REQUEST(");
        paramSession.append(min);
        paramSession.append("<");
        paramSession.append(preferred);
        paramSession.append("<");
        paramSession.append(this.max);
        paramSession.append(") sent");
        paramArrayOfByte1.log(1, paramSession.toString());
        JSch.getLogger().log(1, "expecting SSH_MSG_KEX_DH_GEX_GROUP");
      }
      this.state = 31;
      return;
    }
    catch (Exception paramSession)
    {
      throw paramSession;
    }
  }
  
  public boolean next(Buffer paramBuffer)
    throws Exception
  {
    int i = this.state;
    Object localObject;
    if (i != 31)
    {
      if (i != 33) {
        return false;
      }
      paramBuffer.getInt();
      paramBuffer.getByte();
      i = paramBuffer.getByte();
      if (i != 33)
      {
        localObject = System.err;
        paramBuffer = new StringBuilder();
        paramBuffer.append("type: must be SSH_MSG_KEX_DH_GEX_REPLY ");
        paramBuffer.append(i);
        ((PrintStream)localObject).println(paramBuffer.toString());
        return false;
      }
      this.K_S = paramBuffer.getString();
      localObject = paramBuffer.getMPInt();
      paramBuffer = paramBuffer.getString();
      this.dh.setF((byte[])localObject);
      this.dh.checkRange();
      this.K = normalize(this.dh.getK());
      this.buf.reset();
      this.buf.putString(this.V_C);
      this.buf.putString(this.V_S);
      this.buf.putString(this.I_C);
      this.buf.putString(this.I_S);
      this.buf.putString(this.K_S);
      this.buf.putInt(min);
      this.buf.putInt(preferred);
      this.buf.putInt(this.max);
      this.buf.putMPInt(this.p);
      this.buf.putMPInt(this.g);
      this.buf.putMPInt(this.e);
      this.buf.putMPInt((byte[])localObject);
      this.buf.putMPInt(this.K);
      i = this.buf.getLength();
      localObject = new byte[i];
      this.buf.getByte((byte[])localObject);
      this.sha.update((byte[])localObject, 0, i);
      this.H = this.sha.digest();
      localObject = this.K_S;
      i = localObject[0] << 24 & 0xFF000000 | localObject[1] << 16 & 0xFF0000 | localObject[2] << 8 & 0xFF00 | localObject[3] & 0xFF;
      boolean bool = verify(Util.byte2str((byte[])localObject, 4, i), this.K_S, 4 + i, paramBuffer);
      this.state = 0;
      return bool;
    }
    paramBuffer.getInt();
    paramBuffer.getByte();
    i = paramBuffer.getByte();
    if (i != 31)
    {
      paramBuffer = System.err;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("type: must be SSH_MSG_KEX_DH_GEX_GROUP ");
      ((StringBuilder)localObject).append(i);
      paramBuffer.println(((StringBuilder)localObject).toString());
      return false;
    }
    this.p = paramBuffer.getMPInt();
    this.g = paramBuffer.getMPInt();
    this.dh.setP(this.p);
    this.dh.setG(this.g);
    this.e = this.dh.getE();
    this.packet.reset();
    this.buf.putByte((byte)32);
    this.buf.putMPInt(this.e);
    this.session.write(this.packet);
    if (JSch.getLogger().isEnabled(1))
    {
      JSch.getLogger().log(1, "SSH_MSG_KEX_DH_GEX_INIT sent");
      JSch.getLogger().log(1, "expecting SSH_MSG_KEX_DH_GEX_REPLY");
    }
    this.state = 33;
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\DHGEX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */