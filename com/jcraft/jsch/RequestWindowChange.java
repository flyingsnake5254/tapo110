package com.jcraft.jsch;

class RequestWindowChange
  extends Request
{
  int height_pixels = 480;
  int height_rows = 24;
  int width_columns = 80;
  int width_pixels = 640;
  
  public void request(Session paramSession, Channel paramChannel)
    throws Exception
  {
    super.request(paramSession, paramChannel);
    paramSession = new Buffer();
    Packet localPacket = new Packet(paramSession);
    localPacket.reset();
    paramSession.putByte((byte)98);
    paramSession.putInt(paramChannel.getRecipient());
    paramSession.putString(Util.str2byte("window-change"));
    paramSession.putByte((byte)waitForReply());
    paramSession.putInt(this.width_columns);
    paramSession.putInt(this.height_rows);
    paramSession.putInt(this.width_pixels);
    paramSession.putInt(this.height_pixels);
    write(localPacket);
  }
  
  void setSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.width_columns = paramInt1;
    this.height_rows = paramInt2;
    this.width_pixels = paramInt3;
    this.height_pixels = paramInt4;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\RequestWindowChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */