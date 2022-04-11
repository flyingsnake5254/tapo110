package io.netty.channel.udt.nio;

import com.barchart.udt.TypeUDT;
import com.barchart.udt.nio.SocketChannelUDT;
import io.netty.channel.udt.UdtChannel;

@Deprecated
public class NioUdtByteAcceptorChannel
  extends NioUdtAcceptorChannel
{
  public NioUdtByteAcceptorChannel()
  {
    super(TypeUDT.STREAM);
  }
  
  protected UdtChannel newConnectorChannel(SocketChannelUDT paramSocketChannelUDT)
  {
    return new NioUdtByteConnectorChannel(this, paramSocketChannelUDT);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\udt\nio\NioUdtByteAcceptorChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */