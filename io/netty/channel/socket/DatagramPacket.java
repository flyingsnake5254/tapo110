package io.netty.channel.socket;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.DefaultAddressedEnvelope;
import java.net.InetSocketAddress;

public final class DatagramPacket
  extends DefaultAddressedEnvelope<ByteBuf, InetSocketAddress>
  implements ByteBufHolder
{
  public DatagramPacket(ByteBuf paramByteBuf, InetSocketAddress paramInetSocketAddress)
  {
    super(paramByteBuf, paramInetSocketAddress);
  }
  
  public DatagramPacket(ByteBuf paramByteBuf, InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2)
  {
    super(paramByteBuf, paramInetSocketAddress1, paramInetSocketAddress2);
  }
  
  public DatagramPacket copy()
  {
    return replace(((ByteBuf)content()).copy());
  }
  
  public DatagramPacket duplicate()
  {
    return replace(((ByteBuf)content()).duplicate());
  }
  
  public DatagramPacket replace(ByteBuf paramByteBuf)
  {
    return new DatagramPacket(paramByteBuf, (InetSocketAddress)recipient(), (InetSocketAddress)sender());
  }
  
  public DatagramPacket retain()
  {
    super.retain();
    return this;
  }
  
  public DatagramPacket retain(int paramInt)
  {
    super.retain(paramInt);
    return this;
  }
  
  public DatagramPacket retainedDuplicate()
  {
    return replace(((ByteBuf)content()).retainedDuplicate());
  }
  
  public DatagramPacket touch()
  {
    super.touch();
    return this;
  }
  
  public DatagramPacket touch(Object paramObject)
  {
    super.touch(paramObject);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\socket\DatagramPacket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */