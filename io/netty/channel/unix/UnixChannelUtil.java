package io.netty.channel.unix;

import io.netty.buffer.ByteBuf;
import io.netty.util.internal.PlatformDependent;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public final class UnixChannelUtil
{
  public static InetSocketAddress computeRemoteAddr(InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2)
  {
    if ((paramInetSocketAddress2 == null) || (PlatformDependent.javaVersion() >= 7)) {}
    try
    {
      paramInetSocketAddress1 = new InetSocketAddress(InetAddress.getByAddress(paramInetSocketAddress1.getHostString(), paramInetSocketAddress2.getAddress().getAddress()), paramInetSocketAddress2.getPort());
      return paramInetSocketAddress1;
    }
    catch (UnknownHostException paramInetSocketAddress1)
    {
      for (;;) {}
    }
    return paramInetSocketAddress2;
    return paramInetSocketAddress1;
  }
  
  public static boolean isBufferCopyNeededForWrite(ByteBuf paramByteBuf)
  {
    return isBufferCopyNeededForWrite(paramByteBuf, Limits.IOV_MAX);
  }
  
  static boolean isBufferCopyNeededForWrite(ByteBuf paramByteBuf, int paramInt)
  {
    boolean bool;
    if ((!paramByteBuf.hasMemoryAddress()) && ((!paramByteBuf.isDirect()) || (paramByteBuf.nioBufferCount() > paramInt))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\unix\UnixChannelUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */