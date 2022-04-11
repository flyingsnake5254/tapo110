package io.netty.channel.rxtx;

import java.net.SocketAddress;

@Deprecated
public class RxtxDeviceAddress
  extends SocketAddress
{
  private static final long serialVersionUID = -2907820090993709523L;
  private final String value;
  
  public RxtxDeviceAddress(String paramString)
  {
    this.value = paramString;
  }
  
  public String value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\rxtx\RxtxDeviceAddress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */