package com.tplink.iot.k.b;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class a
{
  private DatagramChannel a;
  private InetSocketAddress b;
  private b c;
  
  public a(InetSocketAddress paramInetSocketAddress)
  {
    this.b = paramInetSocketAddress;
  }
  
  public void a(int paramInt, String paramString)
  {
    paramString = new b((byte)1, (byte)1, paramInt, paramString);
    this.c = paramString;
    try
    {
      this.a.send(ByteBuffer.wrap(paramString.d()), this.b);
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void b()
  {
    b.d.w.c.a.c("TDP", "DatagramChannel.open");
    try
    {
      DatagramChannel localDatagramChannel = DatagramChannel.open();
      this.a = localDatagramChannel;
      localDatagramChannel.socket().setReuseAddress(true);
      this.a.socket().setSoTimeout(8000);
      this.a.configureBlocking(false);
      this.a.socket().setBroadcast(true);
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\k\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */