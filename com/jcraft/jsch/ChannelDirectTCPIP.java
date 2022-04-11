package com.jcraft.jsch;

import java.io.InputStream;
import java.io.OutputStream;

public class ChannelDirectTCPIP
  extends Channel
{
  private static final int LOCAL_MAXIMUM_PACKET_SIZE = 16384;
  private static final int LOCAL_WINDOW_SIZE_MAX = 131072;
  private static final byte[] _type = Util.str2byte("direct-tcpip");
  String host;
  String originator_IP_address = "127.0.0.1";
  int originator_port = 0;
  int port;
  
  ChannelDirectTCPIP()
  {
    this.type = _type;
    setLocalWindowSizeMax(131072);
    setLocalWindowSize(131072);
    setLocalPacketSize(16384);
  }
  
  public void connect(int paramInt)
    throws JSchException
  {
    this.connectTimeout = paramInt;
    try
    {
      Session localSession = getSession();
      Object localObject;
      if (localSession.isConnected())
      {
        if (this.io.in != null)
        {
          localObject = new java/lang/Thread;
          ((Thread)localObject).<init>(this);
          this.thread = ((Thread)localObject);
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          localStringBuilder.append("DirectTCPIP thread ");
          localStringBuilder.append(localSession.getHost());
          ((Thread)localObject).setName(localStringBuilder.toString());
          boolean bool = localSession.daemon_thread;
          if (bool) {
            this.thread.setDaemon(bool);
          }
          this.thread.start();
        }
        else
        {
          sendChannelOpen();
        }
      }
      else
      {
        localObject = new com/jcraft/jsch/JSchException;
        ((JSchException)localObject).<init>("session is down");
        throw ((Throwable)localObject);
      }
    }
    catch (Exception localException)
    {
      this.io.close();
      this.io = null;
      Channel.del(this);
      if (!(localException instanceof JSchException)) {
        return;
      }
      throw ((JSchException)localException);
    }
  }
  
  protected Packet genChannelOpenPacket()
  {
    Buffer localBuffer = new Buffer(this.host.length() + 50 + this.originator_IP_address.length() + 128);
    Packet localPacket = new Packet(localBuffer);
    localPacket.reset();
    localBuffer.putByte((byte)90);
    localBuffer.putString(this.type);
    localBuffer.putInt(this.id);
    localBuffer.putInt(this.lwsize);
    localBuffer.putInt(this.lmpsize);
    localBuffer.putString(Util.str2byte(this.host));
    localBuffer.putInt(this.port);
    localBuffer.putString(Util.str2byte(this.originator_IP_address));
    localBuffer.putInt(this.originator_port);
    return localPacket;
  }
  
  void init()
  {
    this.io = new IO();
  }
  
  public void run()
  {
    try
    {
      sendChannelOpen();
      Buffer localBuffer = new com/jcraft/jsch/Buffer;
      localBuffer.<init>(this.rmpsize);
      Packet localPacket = new com/jcraft/jsch/Packet;
      localPacket.<init>(localBuffer);
      Session localSession = getSession();
      while ((isConnected()) && (this.thread != null))
      {
        Object localObject2 = this.io;
        if (localObject2 != null)
        {
          InputStream localInputStream = ((IO)localObject2).in;
          if (localInputStream != null)
          {
            localObject2 = localBuffer.buffer;
            int i = localInputStream.read((byte[])localObject2, 14, localObject2.length - 14 - 128);
            if (i <= 0)
            {
              eof();
            }
            else
            {
              localPacket.reset();
              localBuffer.putByte((byte)94);
              localBuffer.putInt(this.recipient);
              localBuffer.putInt(i);
              localBuffer.skip(i);
              try
              {
                if (this.close) {
                  break;
                }
                localSession.write(localPacket, this, i);
              }
              finally {}
            }
          }
        }
      }
      eof();
      disconnect();
      return;
    }
    catch (Exception localException)
    {
      if (!this.connected) {
        this.connected = true;
      }
      disconnect();
    }
  }
  
  public void setHost(String paramString)
  {
    this.host = paramString;
  }
  
  public void setInputStream(InputStream paramInputStream)
  {
    this.io.setInputStream(paramInputStream);
  }
  
  public void setOrgIPAddress(String paramString)
  {
    this.originator_IP_address = paramString;
  }
  
  public void setOrgPort(int paramInt)
  {
    this.originator_port = paramInt;
  }
  
  public void setOutputStream(OutputStream paramOutputStream)
  {
    this.io.setOutputStream(paramOutputStream);
  }
  
  public void setPort(int paramInt)
  {
    this.port = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\ChannelDirectTCPIP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */