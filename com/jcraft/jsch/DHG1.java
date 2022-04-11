package com.jcraft.jsch;

import java.io.PrintStream;

public class DHG1
  extends KeyExchange
{
  private static final int SSH_MSG_KEXDH_INIT = 30;
  private static final int SSH_MSG_KEXDH_REPLY = 31;
  static final byte[] g = { 2 };
  static final byte[] p = { 0, -1, -1, -1, -1, -1, -1, -1, -1, -55, 15, -38, -94, 33, 104, -62, 52, -60, -58, 98, -117, -128, -36, 28, -47, 41, 2, 78, 8, -118, 103, -52, 116, 2, 11, -66, -90, 59, 19, -101, 34, 81, 74, 8, 121, -114, 52, 4, -35, -17, -107, 25, -77, -51, 58, 67, 27, 48, 43, 10, 109, -14, 95, 20, 55, 79, -31, 53, 109, 109, 81, -62, 69, -28, -123, -75, 118, 98, 94, 126, -58, -12, 76, 66, -23, -90, 55, -19, 107, 11, -1, 92, -74, -12, 6, -73, -19, -18, 56, 107, -5, 90, -119, -97, -91, -82, -97, 36, 17, 124, 75, 31, -26, 73, 40, 102, 81, -20, -26, 83, -127, -1, -1, -1, -1, -1, -1, -1, -1 };
  byte[] I_C;
  byte[] I_S;
  byte[] V_C;
  byte[] V_S;
  private Buffer buf;
  DH dh;
  byte[] e;
  private Packet packet;
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
      paramArrayOfByte1 = (HASH)Class.forName(paramSession.getConfig("sha-1")).newInstance();
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
      paramArrayOfByte1 = (DH)Class.forName(paramSession.getConfig("dh")).newInstance();
      this.dh = paramArrayOfByte1;
      paramArrayOfByte1.init();
      this.dh.setP(p);
      this.dh.setG(g);
      this.e = this.dh.getE();
      this.packet.reset();
      this.buf.putByte((byte)30);
      this.buf.putMPInt(this.e);
      paramSession.write(this.packet);
      if (JSch.getLogger().isEnabled(1))
      {
        JSch.getLogger().log(1, "SSH_MSG_KEXDH_INIT sent");
        JSch.getLogger().log(1, "expecting SSH_MSG_KEXDH_REPLY");
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
    if (this.state != 31) {
      return false;
    }
    paramBuffer.getInt();
    paramBuffer.getByte();
    int i = paramBuffer.getByte();
    if (i != 31)
    {
      paramBuffer = System.err;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("type: must be 31 ");
      ((StringBuilder)localObject).append(i);
      paramBuffer.println(((StringBuilder)localObject).toString());
      return false;
    }
    this.K_S = paramBuffer.getString();
    Object localObject = paramBuffer.getMPInt();
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
    this.buf.putMPInt(this.e);
    this.buf.putMPInt((byte[])localObject);
    this.buf.putMPInt(this.K);
    i = this.buf.getLength();
    localObject = new byte[i];
    this.buf.getByte((byte[])localObject);
    this.sha.update((byte[])localObject, 0, i);
    this.H = this.sha.digest();
    localObject = this.K_S;
    i = localObject[0];
    i = localObject[1] << 16 & 0xFF0000 | i << 24 & 0xFF000000 | localObject[2] << 8 & 0xFF00 | localObject[3] & 0xFF;
    boolean bool = verify(Util.byte2str((byte[])localObject, 4, i), this.K_S, 4 + i, paramBuffer);
    this.state = 0;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\DHG1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */