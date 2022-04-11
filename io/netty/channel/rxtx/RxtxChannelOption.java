package io.netty.channel.rxtx;

import io.netty.channel.ChannelOption;

@Deprecated
public final class RxtxChannelOption<T>
  extends ChannelOption<T>
{
  public static final ChannelOption<Integer> BAUD_RATE = ChannelOption.valueOf(RxtxChannelOption.class, "BAUD_RATE");
  public static final ChannelOption<RxtxChannelConfig.Databits> DATA_BITS;
  public static final ChannelOption<Boolean> DTR = ChannelOption.valueOf(RxtxChannelOption.class, "DTR");
  public static final ChannelOption<RxtxChannelConfig.Paritybit> PARITY_BIT;
  public static final ChannelOption<Integer> READ_TIMEOUT = ChannelOption.valueOf(RxtxChannelOption.class, "READ_TIMEOUT");
  public static final ChannelOption<Boolean> RTS = ChannelOption.valueOf(RxtxChannelOption.class, "RTS");
  public static final ChannelOption<RxtxChannelConfig.Stopbits> STOP_BITS = ChannelOption.valueOf(RxtxChannelOption.class, "STOP_BITS");
  public static final ChannelOption<Integer> WAIT_TIME;
  
  static
  {
    DATA_BITS = ChannelOption.valueOf(RxtxChannelOption.class, "DATA_BITS");
    PARITY_BIT = ChannelOption.valueOf(RxtxChannelOption.class, "PARITY_BIT");
    WAIT_TIME = ChannelOption.valueOf(RxtxChannelOption.class, "WAIT_TIME");
  }
  
  private RxtxChannelOption()
  {
    super(null);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\rxtx\RxtxChannelOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */