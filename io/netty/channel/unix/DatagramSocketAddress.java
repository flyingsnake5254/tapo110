package io.netty.channel.unix;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public final class DatagramSocketAddress
  extends InetSocketAddress
{
  private static final long serialVersionUID = 3094819287843178401L;
  private final DatagramSocketAddress localAddress;
  private final int receivedAmount;
  
  DatagramSocketAddress(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, DatagramSocketAddress paramDatagramSocketAddress)
    throws UnknownHostException
  {
    super(newAddress(paramArrayOfByte, paramInt1), paramInt2);
    this.receivedAmount = paramInt3;
    this.localAddress = paramDatagramSocketAddress;
  }
  
  private static InetAddress newAddress(byte[] paramArrayOfByte, int paramInt)
    throws UnknownHostException
  {
    if (paramArrayOfByte.length == 4) {
      return InetAddress.getByAddress(paramArrayOfByte);
    }
    return Inet6Address.getByAddress(null, paramArrayOfByte, paramInt);
  }
  
  public DatagramSocketAddress localAddress()
  {
    return this.localAddress;
  }
  
  public int receivedAmount()
  {
    return this.receivedAmount;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\unix\DatagramSocketAddress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */