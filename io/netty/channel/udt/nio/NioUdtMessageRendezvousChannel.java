package io.netty.channel.udt.nio;

import com.barchart.udt.TypeUDT;

@Deprecated
public class NioUdtMessageRendezvousChannel
  extends NioUdtMessageConnectorChannel
{
  public NioUdtMessageRendezvousChannel()
  {
    super(NioUdtProvider.newRendezvousChannelUDT(TypeUDT.DATAGRAM));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\udt\nio\NioUdtMessageRendezvousChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */