package com.jcraft.jsch;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.Hashtable;

class ChannelSession
  extends Channel
{
  private static byte[] _session = Util.str2byte("session");
  protected boolean agent_forwarding = false;
  protected Hashtable env = null;
  protected boolean pty = false;
  protected int tcol = 80;
  protected byte[] terminal_mode = null;
  protected int thp = 480;
  protected int trow = 24;
  protected String ttype = "vt100";
  protected int twp = 640;
  protected boolean xforwading = false;
  
  ChannelSession()
  {
    this.type = _session;
    this.io = new IO();
  }
  
  private Hashtable getEnv()
  {
    if (this.env == null) {
      this.env = new Hashtable();
    }
    return this.env;
  }
  
  private byte[] toByteArray(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return Util.str2byte((String)paramObject);
    }
    return (byte[])paramObject;
  }
  
  public void run()
  {
    Buffer localBuffer = new Buffer(this.rmpsize);
    Packet localPacket = new Packet(localBuffer);
    try
    {
      while ((isConnected()) && (this.thread != null))
      {
        Object localObject2 = this.io;
        if (localObject2 == null) {
          break;
        }
        localObject2 = ((IO)localObject2).in;
        if (localObject2 == null) {
          break;
        }
        byte[] arrayOfByte = localBuffer.buffer;
        int i = ((InputStream)localObject2).read(arrayOfByte, 14, arrayOfByte.length - 14 - 128);
        if (i != 0)
        {
          if (i == -1)
          {
            eof();
            break;
          }
          if (this.close) {
            break;
          }
          localPacket.reset();
          localBuffer.putByte((byte)94);
          localBuffer.putInt(this.recipient);
          localBuffer.putInt(i);
          localBuffer.skip(i);
          getSession().write(localPacket, this, i);
        }
      }
      Thread localThread;
      return;
    }
    catch (Exception localException)
    {
      localThread = this.thread;
      if (localThread != null) {
        try
        {
          localThread.notifyAll();
        }
        finally {}
      }
      this.thread = null;
    }
  }
  
  protected void sendRequests()
    throws Exception
  {
    Session localSession = getSession();
    if (this.agent_forwarding) {
      new RequestAgentForwarding().request(localSession, this);
    }
    if (this.xforwading) {
      new RequestX11().request(localSession, this);
    }
    Object localObject1;
    if (this.pty)
    {
      localObject1 = new RequestPtyReq();
      ((RequestPtyReq)localObject1).setTType(this.ttype);
      ((RequestPtyReq)localObject1).setTSize(this.tcol, this.trow, this.twp, this.thp);
      localObject2 = this.terminal_mode;
      if (localObject2 != null) {
        ((RequestPtyReq)localObject1).setTerminalMode((byte[])localObject2);
      }
      ((Request)localObject1).request(localSession, this);
    }
    Object localObject2 = this.env;
    if (localObject2 != null)
    {
      Enumeration localEnumeration = ((Hashtable)localObject2).keys();
      while (localEnumeration.hasMoreElements())
      {
        localObject1 = localEnumeration.nextElement();
        Object localObject3 = this.env.get(localObject1);
        localObject2 = new RequestEnv();
        ((RequestEnv)localObject2).setEnv(toByteArray(localObject1), toByteArray(localObject3));
        ((Request)localObject2).request(localSession, this);
      }
    }
  }
  
  public void setAgentForwarding(boolean paramBoolean)
  {
    this.agent_forwarding = paramBoolean;
  }
  
  public void setEnv(String paramString1, String paramString2)
  {
    setEnv(Util.str2byte(paramString1), Util.str2byte(paramString2));
  }
  
  public void setEnv(Hashtable paramHashtable)
  {
    try
    {
      this.env = paramHashtable;
      return;
    }
    finally {}
  }
  
  public void setEnv(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      getEnv().put(paramArrayOfByte1, paramArrayOfByte2);
      return;
    }
    finally {}
  }
  
  public void setPty(boolean paramBoolean)
  {
    this.pty = paramBoolean;
  }
  
  public void setPtySize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    setPtyType(this.ttype, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.pty) && (isConnected())) {}
    try
    {
      RequestWindowChange localRequestWindowChange = new com/jcraft/jsch/RequestWindowChange;
      localRequestWindowChange.<init>();
      localRequestWindowChange.setSize(paramInt1, paramInt2, paramInt3, paramInt4);
      localRequestWindowChange.request(getSession(), this);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void setPtyType(String paramString)
  {
    setPtyType(paramString, 80, 24, 640, 480);
  }
  
  public void setPtyType(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.ttype = paramString;
    this.tcol = paramInt1;
    this.trow = paramInt2;
    this.twp = paramInt3;
    this.thp = paramInt4;
  }
  
  public void setTerminalMode(byte[] paramArrayOfByte)
  {
    this.terminal_mode = paramArrayOfByte;
  }
  
  public void setXForwarding(boolean paramBoolean)
  {
    this.xforwading = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\ChannelSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */