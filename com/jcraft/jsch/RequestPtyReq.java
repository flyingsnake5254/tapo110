package com.jcraft.jsch;

class RequestPtyReq
  extends Request
{
  private int tcol = 80;
  private byte[] terminal_mode = Util.empty;
  private int thp = 480;
  private int trow = 24;
  private String ttype = "vt100";
  private int twp = 640;
  
  public void request(Session paramSession, Channel paramChannel)
    throws Exception
  {
    super.request(paramSession, paramChannel);
    paramSession = new Buffer();
    Packet localPacket = new Packet(paramSession);
    localPacket.reset();
    paramSession.putByte((byte)98);
    paramSession.putInt(paramChannel.getRecipient());
    paramSession.putString(Util.str2byte("pty-req"));
    paramSession.putByte((byte)waitForReply());
    paramSession.putString(Util.str2byte(this.ttype));
    paramSession.putInt(this.tcol);
    paramSession.putInt(this.trow);
    paramSession.putInt(this.twp);
    paramSession.putInt(this.thp);
    paramSession.putString(this.terminal_mode);
    write(localPacket);
  }
  
  void setCode(String paramString) {}
  
  void setTSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.tcol = paramInt1;
    this.trow = paramInt2;
    this.twp = paramInt3;
    this.thp = paramInt4;
  }
  
  void setTType(String paramString)
  {
    this.ttype = paramString;
  }
  
  void setTerminalMode(byte[] paramArrayOfByte)
  {
    this.terminal_mode = paramArrayOfByte;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\RequestPtyReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */