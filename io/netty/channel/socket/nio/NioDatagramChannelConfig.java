package io.netty.channel.socket.nio;

import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.socket.DatagramChannelConfig;
import io.netty.channel.socket.DefaultDatagramChannelConfig;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SocketUtils;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.nio.channels.DatagramChannel;
import java.util.Enumeration;
import java.util.Map;

class NioDatagramChannelConfig
  extends DefaultDatagramChannelConfig
{
  private static final Method GET_OPTION;
  private static final Object IP_MULTICAST_IF;
  private static final Object IP_MULTICAST_LOOP;
  private static final Object IP_MULTICAST_TTL;
  private static final Method SET_OPTION;
  private final DatagramChannel javaChannel;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: ldc 19
    //   2: invokestatic 25	io/netty/util/internal/PlatformDependent:getClassLoader	(Ljava/lang/Class;)Ljava/lang/ClassLoader;
    //   5: astore_0
    //   6: aconst_null
    //   7: astore_1
    //   8: ldc 27
    //   10: iconst_1
    //   11: aload_0
    //   12: invokestatic 33	java/lang/Class:forName	(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;
    //   15: astore_2
    //   16: goto +6 -> 22
    //   19: astore_2
    //   20: aconst_null
    //   21: astore_2
    //   22: ldc 35
    //   24: iconst_1
    //   25: aload_0
    //   26: invokestatic 33	java/lang/Class:forName	(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;
    //   29: astore_3
    //   30: goto +6 -> 36
    //   33: astore_3
    //   34: aconst_null
    //   35: astore_3
    //   36: aload_2
    //   37: ifnull +171 -> 208
    //   40: aload_3
    //   41: ldc 36
    //   43: invokevirtual 40	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   46: aconst_null
    //   47: invokevirtual 46	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   50: astore 4
    //   52: aload_3
    //   53: ldc 47
    //   55: invokevirtual 40	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   58: aconst_null
    //   59: invokevirtual 46	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   62: astore_1
    //   63: aload_3
    //   64: ldc 48
    //   66: invokevirtual 40	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   69: aconst_null
    //   70: invokevirtual 46	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   73: astore 5
    //   75: ldc 50
    //   77: iconst_1
    //   78: aload_0
    //   79: invokestatic 33	java/lang/Class:forName	(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;
    //   82: astore_3
    //   83: goto +6 -> 89
    //   86: astore_3
    //   87: aconst_null
    //   88: astore_3
    //   89: aload_3
    //   90: ifnonnull +18 -> 108
    //   93: aconst_null
    //   94: astore_3
    //   95: aload_3
    //   96: astore_2
    //   97: aload_3
    //   98: astore_0
    //   99: aload 4
    //   101: astore_3
    //   102: aload_1
    //   103: astore 4
    //   105: goto +117 -> 222
    //   108: aload_3
    //   109: ldc 52
    //   111: iconst_1
    //   112: anewarray 29	java/lang/Class
    //   115: dup
    //   116: iconst_0
    //   117: aload_2
    //   118: aastore
    //   119: invokevirtual 56	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   122: astore_0
    //   123: aload_3
    //   124: ldc 58
    //   126: iconst_2
    //   127: anewarray 29	java/lang/Class
    //   130: dup
    //   131: iconst_0
    //   132: aload_2
    //   133: aastore
    //   134: dup
    //   135: iconst_1
    //   136: ldc 60
    //   138: aastore
    //   139: invokevirtual 56	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   142: astore_2
    //   143: aload_0
    //   144: astore_3
    //   145: goto -48 -> 97
    //   148: astore_2
    //   149: new 62	java/lang/Error
    //   152: dup
    //   153: ldc 64
    //   155: aload_2
    //   156: invokespecial 68	java/lang/Error:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   159: athrow
    //   160: astore_2
    //   161: new 62	java/lang/Error
    //   164: dup
    //   165: ldc 70
    //   167: aload_2
    //   168: invokespecial 68	java/lang/Error:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   171: athrow
    //   172: astore_2
    //   173: new 62	java/lang/Error
    //   176: dup
    //   177: ldc 72
    //   179: aload_2
    //   180: invokespecial 68	java/lang/Error:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   183: athrow
    //   184: astore_2
    //   185: new 62	java/lang/Error
    //   188: dup
    //   189: ldc 74
    //   191: aload_2
    //   192: invokespecial 68	java/lang/Error:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   195: athrow
    //   196: astore_2
    //   197: new 62	java/lang/Error
    //   200: dup
    //   201: ldc 76
    //   203: aload_2
    //   204: invokespecial 68	java/lang/Error:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   207: athrow
    //   208: aconst_null
    //   209: astore_0
    //   210: aload_0
    //   211: astore_2
    //   212: aload_2
    //   213: astore_3
    //   214: aload_3
    //   215: astore 4
    //   217: aload_3
    //   218: astore 5
    //   220: aload_1
    //   221: astore_3
    //   222: aload_3
    //   223: putstatic 78	io/netty/channel/socket/nio/NioDatagramChannelConfig:IP_MULTICAST_TTL	Ljava/lang/Object;
    //   226: aload 4
    //   228: putstatic 80	io/netty/channel/socket/nio/NioDatagramChannelConfig:IP_MULTICAST_IF	Ljava/lang/Object;
    //   231: aload 5
    //   233: putstatic 82	io/netty/channel/socket/nio/NioDatagramChannelConfig:IP_MULTICAST_LOOP	Ljava/lang/Object;
    //   236: aload_0
    //   237: putstatic 84	io/netty/channel/socket/nio/NioDatagramChannelConfig:GET_OPTION	Ljava/lang/reflect/Method;
    //   240: aload_2
    //   241: putstatic 86	io/netty/channel/socket/nio/NioDatagramChannelConfig:SET_OPTION	Ljava/lang/reflect/Method;
    //   244: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   5	232	0	localObject1	Object
    //   7	214	1	localObject2	Object
    //   15	1	2	localClass1	Class
    //   19	1	2	localException1	Exception
    //   21	122	2	localObject3	Object
    //   148	8	2	localException2	Exception
    //   160	8	2	localException3	Exception
    //   172	8	2	localException4	Exception
    //   184	8	2	localException5	Exception
    //   196	8	2	localException6	Exception
    //   211	30	2	localObject4	Object
    //   29	1	3	localClass2	Class
    //   33	1	3	localException7	Exception
    //   35	48	3	localClass3	Class
    //   86	1	3	localObject5	Object
    //   88	135	3	localObject6	Object
    //   50	177	4	localObject7	Object
    //   73	159	5	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   8	16	19	java/lang/Exception
    //   22	30	33	java/lang/Exception
    //   75	83	86	finally
    //   123	143	148	java/lang/Exception
    //   108	123	160	java/lang/Exception
    //   63	75	172	java/lang/Exception
    //   52	63	184	java/lang/Exception
    //   40	52	196	java/lang/Exception
  }
  
  NioDatagramChannelConfig(NioDatagramChannel paramNioDatagramChannel, DatagramChannel paramDatagramChannel)
  {
    super(paramNioDatagramChannel, paramDatagramChannel.socket());
    this.javaChannel = paramDatagramChannel;
  }
  
  private Object getOption0(Object paramObject)
  {
    Method localMethod = GET_OPTION;
    if (localMethod != null) {
      try
      {
        paramObject = localMethod.invoke(this.javaChannel, new Object[] { paramObject });
        return paramObject;
      }
      catch (Exception paramObject)
      {
        throw new ChannelException((Throwable)paramObject);
      }
    }
    throw new UnsupportedOperationException();
  }
  
  private void setOption0(Object paramObject1, Object paramObject2)
  {
    Method localMethod = SET_OPTION;
    if (localMethod != null) {
      try
      {
        localMethod.invoke(this.javaChannel, new Object[] { paramObject1, paramObject2 });
        return;
      }
      catch (Exception paramObject1)
      {
        throw new ChannelException((Throwable)paramObject1);
      }
    }
    throw new UnsupportedOperationException();
  }
  
  protected void autoReadCleared()
  {
    ((NioDatagramChannel)this.channel).clearReadPending0();
  }
  
  public InetAddress getInterface()
  {
    Object localObject = getNetworkInterface();
    if (localObject != null)
    {
      localObject = SocketUtils.addressesFromNetworkInterface((NetworkInterface)localObject);
      if (((Enumeration)localObject).hasMoreElements()) {
        return (InetAddress)((Enumeration)localObject).nextElement();
      }
    }
    return null;
  }
  
  public NetworkInterface getNetworkInterface()
  {
    return (NetworkInterface)getOption0(IP_MULTICAST_IF);
  }
  
  public <T> T getOption(ChannelOption<T> paramChannelOption)
  {
    if ((PlatformDependent.javaVersion() >= 7) && ((paramChannelOption instanceof NioChannelOption))) {
      return (T)NioChannelOption.getOption(this.javaChannel, (NioChannelOption)paramChannelOption);
    }
    return (T)super.getOption(paramChannelOption);
  }
  
  public Map<ChannelOption<?>, Object> getOptions()
  {
    if (PlatformDependent.javaVersion() >= 7) {
      return getOptions(super.getOptions(), NioChannelOption.getOptions(this.javaChannel));
    }
    return super.getOptions();
  }
  
  public int getTimeToLive()
  {
    return ((Integer)getOption0(IP_MULTICAST_TTL)).intValue();
  }
  
  public boolean isLoopbackModeDisabled()
  {
    return ((Boolean)getOption0(IP_MULTICAST_LOOP)).booleanValue();
  }
  
  public DatagramChannelConfig setAutoRead(boolean paramBoolean)
  {
    super.setAutoRead(paramBoolean);
    return this;
  }
  
  public DatagramChannelConfig setInterface(InetAddress paramInetAddress)
  {
    try
    {
      setNetworkInterface(NetworkInterface.getByInetAddress(paramInetAddress));
      return this;
    }
    catch (SocketException paramInetAddress)
    {
      throw new ChannelException(paramInetAddress);
    }
  }
  
  public DatagramChannelConfig setLoopbackModeDisabled(boolean paramBoolean)
  {
    setOption0(IP_MULTICAST_LOOP, Boolean.valueOf(paramBoolean));
    return this;
  }
  
  public DatagramChannelConfig setNetworkInterface(NetworkInterface paramNetworkInterface)
  {
    setOption0(IP_MULTICAST_IF, paramNetworkInterface);
    return this;
  }
  
  public <T> boolean setOption(ChannelOption<T> paramChannelOption, T paramT)
  {
    if ((PlatformDependent.javaVersion() >= 7) && ((paramChannelOption instanceof NioChannelOption))) {
      return NioChannelOption.setOption(this.javaChannel, (NioChannelOption)paramChannelOption, paramT);
    }
    return super.setOption(paramChannelOption, paramT);
  }
  
  public DatagramChannelConfig setTimeToLive(int paramInt)
  {
    setOption0(IP_MULTICAST_TTL, Integer.valueOf(paramInt));
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\socket\nio\NioDatagramChannelConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */