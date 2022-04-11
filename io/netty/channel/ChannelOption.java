package io.netty.channel;

import io.netty.buffer.ByteBufAllocator;
import io.netty.util.AbstractConstant;
import io.netty.util.ConstantPool;
import io.netty.util.internal.ObjectUtil;
import java.net.InetAddress;
import java.net.NetworkInterface;

public class ChannelOption<T>
  extends AbstractConstant<ChannelOption<T>>
{
  public static final ChannelOption<ByteBufAllocator> ALLOCATOR;
  public static final ChannelOption<Boolean> ALLOW_HALF_CLOSURE;
  public static final ChannelOption<Boolean> AUTO_CLOSE;
  public static final ChannelOption<Boolean> AUTO_READ;
  public static final ChannelOption<Integer> CONNECT_TIMEOUT_MILLIS;
  @Deprecated
  public static final ChannelOption<Boolean> DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION = valueOf("DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION");
  public static final ChannelOption<InetAddress> IP_MULTICAST_ADDR;
  public static final ChannelOption<NetworkInterface> IP_MULTICAST_IF;
  public static final ChannelOption<Boolean> IP_MULTICAST_LOOP_DISABLED;
  public static final ChannelOption<Integer> IP_MULTICAST_TTL;
  public static final ChannelOption<Integer> IP_TOS;
  @Deprecated
  public static final ChannelOption<Integer> MAX_MESSAGES_PER_READ;
  public static final ChannelOption<MessageSizeEstimator> MESSAGE_SIZE_ESTIMATOR;
  public static final ChannelOption<RecvByteBufAllocator> RCVBUF_ALLOCATOR;
  public static final ChannelOption<Boolean> SINGLE_EVENTEXECUTOR_PER_GROUP = valueOf("SINGLE_EVENTEXECUTOR_PER_GROUP");
  public static final ChannelOption<Integer> SO_BACKLOG;
  public static final ChannelOption<Boolean> SO_BROADCAST;
  public static final ChannelOption<Boolean> SO_KEEPALIVE;
  public static final ChannelOption<Integer> SO_LINGER;
  public static final ChannelOption<Integer> SO_RCVBUF;
  public static final ChannelOption<Boolean> SO_REUSEADDR;
  public static final ChannelOption<Integer> SO_SNDBUF;
  public static final ChannelOption<Integer> SO_TIMEOUT;
  public static final ChannelOption<Boolean> TCP_NODELAY;
  @Deprecated
  public static final ChannelOption<Integer> WRITE_BUFFER_HIGH_WATER_MARK;
  @Deprecated
  public static final ChannelOption<Integer> WRITE_BUFFER_LOW_WATER_MARK;
  public static final ChannelOption<WriteBufferWaterMark> WRITE_BUFFER_WATER_MARK;
  public static final ChannelOption<Integer> WRITE_SPIN_COUNT;
  private static final ConstantPool<ChannelOption<Object>> pool = new ConstantPool()
  {
    protected ChannelOption<Object> newConstant(int paramAnonymousInt, String paramAnonymousString)
    {
      return new ChannelOption(paramAnonymousInt, paramAnonymousString, null);
    }
  };
  
  static
  {
    ALLOCATOR = valueOf("ALLOCATOR");
    RCVBUF_ALLOCATOR = valueOf("RCVBUF_ALLOCATOR");
    MESSAGE_SIZE_ESTIMATOR = valueOf("MESSAGE_SIZE_ESTIMATOR");
    CONNECT_TIMEOUT_MILLIS = valueOf("CONNECT_TIMEOUT_MILLIS");
    MAX_MESSAGES_PER_READ = valueOf("MAX_MESSAGES_PER_READ");
    WRITE_SPIN_COUNT = valueOf("WRITE_SPIN_COUNT");
    WRITE_BUFFER_HIGH_WATER_MARK = valueOf("WRITE_BUFFER_HIGH_WATER_MARK");
    WRITE_BUFFER_LOW_WATER_MARK = valueOf("WRITE_BUFFER_LOW_WATER_MARK");
    WRITE_BUFFER_WATER_MARK = valueOf("WRITE_BUFFER_WATER_MARK");
    ALLOW_HALF_CLOSURE = valueOf("ALLOW_HALF_CLOSURE");
    AUTO_READ = valueOf("AUTO_READ");
    AUTO_CLOSE = valueOf("AUTO_CLOSE");
    SO_BROADCAST = valueOf("SO_BROADCAST");
    SO_KEEPALIVE = valueOf("SO_KEEPALIVE");
    SO_SNDBUF = valueOf("SO_SNDBUF");
    SO_RCVBUF = valueOf("SO_RCVBUF");
    SO_REUSEADDR = valueOf("SO_REUSEADDR");
    SO_LINGER = valueOf("SO_LINGER");
    SO_BACKLOG = valueOf("SO_BACKLOG");
    SO_TIMEOUT = valueOf("SO_TIMEOUT");
    IP_TOS = valueOf("IP_TOS");
    IP_MULTICAST_ADDR = valueOf("IP_MULTICAST_ADDR");
    IP_MULTICAST_IF = valueOf("IP_MULTICAST_IF");
    IP_MULTICAST_TTL = valueOf("IP_MULTICAST_TTL");
    IP_MULTICAST_LOOP_DISABLED = valueOf("IP_MULTICAST_LOOP_DISABLED");
    TCP_NODELAY = valueOf("TCP_NODELAY");
  }
  
  private ChannelOption(int paramInt, String paramString)
  {
    super(paramInt, paramString);
  }
  
  @Deprecated
  protected ChannelOption(String paramString)
  {
    this(pool.nextId(), paramString);
  }
  
  public static boolean exists(String paramString)
  {
    return pool.exists(paramString);
  }
  
  @Deprecated
  public static <T> ChannelOption<T> newInstance(String paramString)
  {
    return (ChannelOption)pool.newInstance(paramString);
  }
  
  public static <T> ChannelOption<T> valueOf(Class<?> paramClass, String paramString)
  {
    return (ChannelOption)pool.valueOf(paramClass, paramString);
  }
  
  public static <T> ChannelOption<T> valueOf(String paramString)
  {
    return (ChannelOption)pool.valueOf(paramString);
  }
  
  public void validate(T paramT)
  {
    ObjectUtil.checkNotNull(paramT, "value");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\ChannelOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */