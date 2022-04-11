package io.netty.channel.kqueue;

import io.netty.channel.ChannelOption;
import io.netty.channel.unix.UnixChannelOption;

public final class KQueueChannelOption<T>
  extends UnixChannelOption<T>
{
  public static final ChannelOption<Boolean> RCV_ALLOC_TRANSPORT_PROVIDES_GUESS = ChannelOption.valueOf(KQueueChannelOption.class, "RCV_ALLOC_TRANSPORT_PROVIDES_GUESS");
  public static final ChannelOption<AcceptFilter> SO_ACCEPTFILTER;
  public static final ChannelOption<Integer> SO_SNDLOWAT = ChannelOption.valueOf(KQueueChannelOption.class, "SO_SNDLOWAT");
  public static final ChannelOption<Boolean> TCP_NOPUSH = ChannelOption.valueOf(KQueueChannelOption.class, "TCP_NOPUSH");
  
  static
  {
    SO_ACCEPTFILTER = ChannelOption.valueOf(KQueueChannelOption.class, "SO_ACCEPTFILTER");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\kqueue\KQueueChannelOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */