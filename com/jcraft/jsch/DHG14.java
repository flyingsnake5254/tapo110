package com.jcraft.jsch;

import java.io.PrintStream;

public class DHG14
  extends KeyExchange
{
  private static final int SSH_MSG_KEXDH_INIT = 30;
  private static final int SSH_MSG_KEXDH_REPLY = 31;
  static final byte[] g = { 2 };
  static final byte[] p = { 0, -1, -1, -1, -1, -1, -1, -1, -1, -55, 15, -38, -94, 33, 104, -62, 52, -60, -58, 98, -117, -128, -36, 28, -47, 41, 2, 78, 8, -118, 103, -52, 116, 2, 11, -66, -90, 59, 19, -101, 34, 81, 74, 8, 121, -114, 52, 4, -35, -17, -107, 25, -77, -51, 58, 67, 27, 48, 43, 10, 109, -14, 95, 20, 55, 79, -31, 53, 109, 109, 81, -62, 69, -28, -123, -75, 118, 98, 94, 126, -58, -12, 76, 66, -23, -90, 55, -19, 107, 11, -1, 92, -74, -12, 6, -73, -19, -18, 56, 107, -5, 90, -119, -97, -91, -82, -97, 36, 17, 124, 75, 31, -26, 73, 40, 102, 81, -20, -28, 91, 61, -62, 0, 124, -72, -95, 99, -65, 5, -104, -38, 72, 54, 28, 85, -45, -102, 105, 22, 63, -88, -3, 36, -49, 95, -125, 101, 93, 35, -36, -93, -83, -106, 28, 98, -13, 86, 32, -123, 82, -69, -98, -43, 41, 7, 112, -106, -106, 109, 103, 12, 53, 78, 74, -68, -104, 4, -15, 116, 108, 8, -54, 24, 33, 124, 50, -112, 94, 70, 46, 54, -50, 59, -29, -98, 119, 44, 24, 14, -122, 3, -101, 39, -125, -94, -20, 7, -94, -113, -75, -59, 93, -16, 111, 76, 82, -55, -34, 43, -53, -10, -107, 88, 23, 24, 57, -107, 73, 124, -22, -107, 106, -27, 21, -46, 38, 24, -104, -6, 5, 16, 21, 114, -114, 90, -118, -84, -86, 104, -1, -1, -1, -1, -1, -1, -1, -1 };
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
      paramArrayOfByte2 = (HASH)Class.forName(paramSession.getConfig("sha-1")).newInstance();
      this.sha = paramArrayOfByte2;
      paramArrayOfByte2.init();
    }
    catch (Exception paramArrayOfByte2)
    {
      System.err.println(paramArrayOfByte2);
    }
    this.buf = new Buffer();
    this.packet = new Packet(this.buf);
    try
    {
      paramArrayOfByte2 = (DH)Class.forName(paramSession.getConfig("dh")).newInstance();
      this.dh = paramArrayOfByte2;
      paramArrayOfByte2.init();
      this.dh.setP(p);
      this.dh.setG(g);
      this.e = this.dh.getE();
      this.packet.reset();
      this.buf.putByte((byte)30);
      this.buf.putMPInt(this.e);
      if (paramArrayOfByte1 == null) {
        return;
      }
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\DHG14.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */