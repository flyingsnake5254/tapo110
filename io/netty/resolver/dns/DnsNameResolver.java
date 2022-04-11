package io.netty.resolver.dns;

import io.netty.bootstrap.AbstractBootstrap;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFactory;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultAddressedEnvelope;
import io.netty.channel.EventLoop;
import io.netty.channel.FixedRecvByteBufAllocator;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.handler.codec.dns.AbstractDnsMessage;
import io.netty.handler.codec.dns.DatagramDnsQueryEncoder;
import io.netty.handler.codec.dns.DatagramDnsResponse;
import io.netty.handler.codec.dns.DatagramDnsResponseDecoder;
import io.netty.handler.codec.dns.DefaultDnsRawRecord;
import io.netty.handler.codec.dns.DefaultDnsResponse;
import io.netty.handler.codec.dns.DnsMessage;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsRawRecord;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.dns.DnsRecordType;
import io.netty.handler.codec.dns.DnsResponse;
import io.netty.handler.codec.dns.TcpDnsQueryEncoder;
import io.netty.handler.codec.dns.TcpDnsResponseDecoder;
import io.netty.resolver.HostsFileEntriesResolver;
import io.netty.resolver.InetNameResolver;
import io.netty.resolver.ResolvedAddressTypes;
import io.netty.resolver.SimpleNameResolver;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.NetUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.a;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DnsNameResolver
  extends InetNameResolver
{
  private static final DatagramDnsResponseDecoder DATAGRAM_DECODER = new DatagramDnsResponseDecoder()
  {
    protected DnsResponse decodeResponse(ChannelHandlerContext paramAnonymousChannelHandlerContext, DatagramPacket paramAnonymousDatagramPacket)
      throws Exception
    {
      DnsResponse localDnsResponse = super.decodeResponse(paramAnonymousChannelHandlerContext, paramAnonymousDatagramPacket);
      if (((ByteBuf)paramAnonymousDatagramPacket.content()).isReadable())
      {
        localDnsResponse.setTruncated(true);
        if (DnsNameResolver.logger.isDebugEnabled()) {
          DnsNameResolver.logger.debug("{} RECEIVED: UDP truncated packet received, consider adjusting maxPayloadSize for the {}.", paramAnonymousChannelHandlerContext.channel(), StringUtil.simpleClassName(DnsNameResolver.class));
        }
      }
      return localDnsResponse;
    }
  };
  private static final DatagramDnsQueryEncoder DATAGRAM_ENCODER = new DatagramDnsQueryEncoder();
  private static final UnixResolverOptions DEFAULT_OPTIONS;
  static final ResolvedAddressTypes DEFAULT_RESOLVE_ADDRESS_TYPES;
  static final String[] DEFAULT_SEARCH_DOMAINS;
  private static final DnsRecord[] EMPTY_ADDITIONALS;
  private static final InternetProtocolFamily[] IPV4_ONLY_RESOLVED_PROTOCOL_FAMILIES;
  private static final DnsRecordType[] IPV4_ONLY_RESOLVED_RECORD_TYPES;
  private static final InternetProtocolFamily[] IPV4_PREFERRED_RESOLVED_PROTOCOL_FAMILIES;
  private static final DnsRecordType[] IPV4_PREFERRED_RESOLVED_RECORD_TYPES;
  private static final InternetProtocolFamily[] IPV6_ONLY_RESOLVED_PROTOCOL_FAMILIES;
  private static final DnsRecordType[] IPV6_ONLY_RESOLVED_RECORD_TYPES;
  private static final InternetProtocolFamily[] IPV6_PREFERRED_RESOLVED_PROTOCOL_FAMILIES;
  private static final DnsRecordType[] IPV6_PREFERRED_RESOLVED_RECORD_TYPES;
  private static final String LOCALHOST = "localhost";
  private static final InetAddress LOCALHOST_ADDRESS;
  private static final TcpDnsQueryEncoder TCP_ENCODER = new TcpDnsQueryEncoder();
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(DnsNameResolver.class);
  private final AuthoritativeDnsServerCache authoritativeDnsServerCache;
  final Channel ch;
  final Future<Channel> channelFuture;
  private final DnsCnameCache cnameCache;
  private final boolean completeOncePreferredResolved;
  private final boolean decodeIdn;
  private final DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory;
  private final DnsServerAddressStreamProvider dnsServerAddressStreamProvider;
  private final HostsFileEntriesResolver hostsFileEntriesResolver;
  private final int maxPayloadSize;
  private final int maxQueriesPerResolve;
  private final FastThreadLocal<DnsServerAddressStream> nameServerAddrStream = new FastThreadLocal()
  {
    protected DnsServerAddressStream initialValue()
    {
      return DnsNameResolver.this.dnsServerAddressStreamProvider.nameServerAddressStream("");
    }
  };
  private final Comparator<InetSocketAddress> nameServerComparator;
  private final int ndots;
  private final boolean optResourceEnabled;
  private final InternetProtocolFamily preferredAddressType;
  final DnsQueryContextManager queryContextManager = new DnsQueryContextManager();
  private final long queryTimeoutMillis;
  private final boolean recursionDesired;
  private final DnsCache resolveCache;
  private final DnsRecordType[] resolveRecordTypes;
  private final ResolvedAddressTypes resolvedAddressTypes;
  private final InternetProtocolFamily[] resolvedInternetProtocolFamilies;
  private final String[] searchDomains;
  private final ChannelFactory<? extends SocketChannel> socketChannelFactory;
  private final boolean supportsAAAARecords;
  private final boolean supportsARecords;
  
  static
  {
    EMPTY_ADDITIONALS = new DnsRecord[0];
    Object localObject1 = DnsRecordType.A;
    IPV4_ONLY_RESOLVED_RECORD_TYPES = new DnsRecordType[] { localObject1 };
    InternetProtocolFamily localInternetProtocolFamily1 = InternetProtocolFamily.IPv4;
    IPV4_ONLY_RESOLVED_PROTOCOL_FAMILIES = new InternetProtocolFamily[] { localInternetProtocolFamily1 };
    DnsRecordType localDnsRecordType = DnsRecordType.AAAA;
    IPV4_PREFERRED_RESOLVED_RECORD_TYPES = new DnsRecordType[] { localObject1, localDnsRecordType };
    InternetProtocolFamily localInternetProtocolFamily2 = InternetProtocolFamily.IPv6;
    IPV4_PREFERRED_RESOLVED_PROTOCOL_FAMILIES = new InternetProtocolFamily[] { localInternetProtocolFamily1, localInternetProtocolFamily2 };
    IPV6_ONLY_RESOLVED_RECORD_TYPES = new DnsRecordType[] { localDnsRecordType };
    IPV6_ONLY_RESOLVED_PROTOCOL_FAMILIES = new InternetProtocolFamily[] { localInternetProtocolFamily2 };
    IPV6_PREFERRED_RESOLVED_RECORD_TYPES = new DnsRecordType[] { localDnsRecordType, localObject1 };
    IPV6_PREFERRED_RESOLVED_PROTOCOL_FAMILIES = new InternetProtocolFamily[] { localInternetProtocolFamily2, localInternetProtocolFamily1 };
    if ((!NetUtil.isIpV4StackPreferred()) && (anyInterfaceSupportsIpV6()))
    {
      if (NetUtil.isIpV6AddressesPreferred())
      {
        DEFAULT_RESOLVE_ADDRESS_TYPES = ResolvedAddressTypes.IPV6_PREFERRED;
        LOCALHOST_ADDRESS = NetUtil.LOCALHOST6;
      }
      else
      {
        DEFAULT_RESOLVE_ADDRESS_TYPES = ResolvedAddressTypes.IPV4_PREFERRED;
        LOCALHOST_ADDRESS = NetUtil.LOCALHOST4;
      }
    }
    else
    {
      DEFAULT_RESOLVE_ADDRESS_TYPES = ResolvedAddressTypes.IPV4_ONLY;
      LOCALHOST_ADDRESS = NetUtil.LOCALHOST4;
    }
    Object localObject2;
    try
    {
      if (PlatformDependent.isWindows()) {
        localObject1 = getSearchDomainsHack();
      } else {
        localObject1 = UnixResolverDnsServerAddressStreamProvider.parseEtcResolverSearchDomains();
      }
      localObject1 = (String[])((List)localObject1).toArray(new String[0]);
    }
    catch (Exception localException1)
    {
      localObject2 = EmptyArrays.EMPTY_STRINGS;
    }
    DEFAULT_SEARCH_DOMAINS = (String[])localObject2;
    UnixResolverOptions localUnixResolverOptions;
    try
    {
      localObject2 = UnixResolverDnsServerAddressStreamProvider.parseEtcResolverOptions();
    }
    catch (Exception localException2)
    {
      localUnixResolverOptions = UnixResolverOptions.newBuilder().build();
    }
    DEFAULT_OPTIONS = localUnixResolverOptions;
  }
  
  DnsNameResolver(EventLoop paramEventLoop, final ChannelFactory<? extends DatagramChannel> paramChannelFactory, ChannelFactory<? extends SocketChannel> paramChannelFactory1, final DnsCache paramDnsCache, final DnsCnameCache paramDnsCnameCache, final AuthoritativeDnsServerCache paramAuthoritativeDnsServerCache, DnsQueryLifecycleObserverFactory paramDnsQueryLifecycleObserverFactory, long paramLong, ResolvedAddressTypes paramResolvedAddressTypes, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2, boolean paramBoolean3, HostsFileEntriesResolver paramHostsFileEntriesResolver, DnsServerAddressStreamProvider paramDnsServerAddressStreamProvider, String[] paramArrayOfString, int paramInt3, boolean paramBoolean4, boolean paramBoolean5)
  {
    super(paramEventLoop);
    if (paramLong <= 0L) {
      paramLong = TimeUnit.SECONDS.toMillis(DEFAULT_OPTIONS.timeout());
    }
    this.queryTimeoutMillis = paramLong;
    ResolvedAddressTypes localResolvedAddressTypes;
    if (paramResolvedAddressTypes != null) {
      localResolvedAddressTypes = paramResolvedAddressTypes;
    } else {
      localResolvedAddressTypes = DEFAULT_RESOLVE_ADDRESS_TYPES;
    }
    this.resolvedAddressTypes = localResolvedAddressTypes;
    this.recursionDesired = paramBoolean1;
    if (paramInt1 <= 0) {
      paramInt1 = DEFAULT_OPTIONS.attempts();
    }
    this.maxQueriesPerResolve = paramInt1;
    this.maxPayloadSize = ObjectUtil.checkPositive(paramInt2, "maxPayloadSize");
    this.optResourceEnabled = paramBoolean3;
    this.hostsFileEntriesResolver = ((HostsFileEntriesResolver)ObjectUtil.checkNotNull(paramHostsFileEntriesResolver, "hostsFileEntriesResolver"));
    this.dnsServerAddressStreamProvider = ((DnsServerAddressStreamProvider)ObjectUtil.checkNotNull(paramDnsServerAddressStreamProvider, "dnsServerAddressStreamProvider"));
    this.resolveCache = ((DnsCache)ObjectUtil.checkNotNull(paramDnsCache, "resolveCache"));
    this.cnameCache = ((DnsCnameCache)ObjectUtil.checkNotNull(paramDnsCnameCache, "cnameCache"));
    if (paramBoolean2)
    {
      if ((paramDnsQueryLifecycleObserverFactory instanceof NoopDnsQueryLifecycleObserverFactory)) {
        paramEventLoop = new TraceDnsQueryLifeCycleObserverFactory();
      } else {
        paramEventLoop = new BiDnsQueryLifecycleObserverFactory(new TraceDnsQueryLifeCycleObserverFactory(), paramDnsQueryLifecycleObserverFactory);
      }
    }
    else {
      paramEventLoop = (DnsQueryLifecycleObserverFactory)ObjectUtil.checkNotNull(paramDnsQueryLifecycleObserverFactory, "dnsQueryLifecycleObserverFactory");
    }
    this.dnsQueryLifecycleObserverFactory = paramEventLoop;
    if (paramArrayOfString != null) {
      paramEventLoop = (String[])paramArrayOfString.clone();
    } else {
      paramEventLoop = DEFAULT_SEARCH_DOMAINS;
    }
    this.searchDomains = paramEventLoop;
    if (paramInt3 >= 0) {
      paramInt1 = paramInt3;
    } else {
      paramInt1 = DEFAULT_OPTIONS.ndots();
    }
    this.ndots = paramInt1;
    this.decodeIdn = paramBoolean4;
    this.completeOncePreferredResolved = paramBoolean5;
    this.socketChannelFactory = paramChannelFactory1;
    paramInt1 = 7.$SwitchMap$io$netty$resolver$ResolvedAddressTypes[localResolvedAddressTypes.ordinal()];
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3)
        {
          if (paramInt1 == 4)
          {
            this.supportsAAAARecords = true;
            this.supportsARecords = true;
            this.resolveRecordTypes = IPV6_PREFERRED_RESOLVED_RECORD_TYPES;
            this.resolvedInternetProtocolFamilies = IPV6_PREFERRED_RESOLVED_PROTOCOL_FAMILIES;
          }
          else
          {
            paramEventLoop = new StringBuilder();
            paramEventLoop.append("Unknown ResolvedAddressTypes ");
            paramEventLoop.append(paramResolvedAddressTypes);
            throw new IllegalArgumentException(paramEventLoop.toString());
          }
        }
        else
        {
          this.supportsAAAARecords = true;
          this.supportsARecords = false;
          this.resolveRecordTypes = IPV6_ONLY_RESOLVED_RECORD_TYPES;
          this.resolvedInternetProtocolFamilies = IPV6_ONLY_RESOLVED_PROTOCOL_FAMILIES;
        }
      }
      else
      {
        this.supportsAAAARecords = true;
        this.supportsARecords = true;
        this.resolveRecordTypes = IPV4_PREFERRED_RESOLVED_RECORD_TYPES;
        this.resolvedInternetProtocolFamilies = IPV4_PREFERRED_RESOLVED_PROTOCOL_FAMILIES;
      }
    }
    else
    {
      this.supportsAAAARecords = false;
      this.supportsARecords = true;
      this.resolveRecordTypes = IPV4_ONLY_RESOLVED_RECORD_TYPES;
      this.resolvedInternetProtocolFamilies = IPV4_ONLY_RESOLVED_PROTOCOL_FAMILIES;
    }
    paramEventLoop = preferredAddressType(localResolvedAddressTypes);
    this.preferredAddressType = paramEventLoop;
    this.authoritativeDnsServerCache = ((AuthoritativeDnsServerCache)ObjectUtil.checkNotNull(paramAuthoritativeDnsServerCache, "authoritativeDnsServerCache"));
    this.nameServerComparator = new NameServerComparator(paramEventLoop.addressType());
    paramEventLoop = new Bootstrap();
    paramEventLoop.group(executor());
    paramEventLoop.channelFactory(paramChannelFactory);
    paramEventLoop.option(ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION, Boolean.TRUE);
    paramChannelFactory = new DnsResponseHandler(executor().newPromise());
    paramEventLoop.handler(new ChannelInitializer()
    {
      protected void initChannel(DatagramChannel paramAnonymousDatagramChannel)
      {
        paramAnonymousDatagramChannel.pipeline().addLast(new ChannelHandler[] { DnsNameResolver.DATAGRAM_ENCODER, DnsNameResolver.DATAGRAM_DECODER, paramChannelFactory });
      }
    });
    this.channelFuture = paramChannelFactory.channelActivePromise;
    paramChannelFactory = paramEventLoop.register();
    paramEventLoop = paramChannelFactory.cause();
    if (paramEventLoop != null)
    {
      if (!(paramEventLoop instanceof RuntimeException))
      {
        if ((paramEventLoop instanceof Error)) {
          throw ((Error)paramEventLoop);
        }
        throw new IllegalStateException("Unable to create / register Channel", paramEventLoop);
      }
      throw ((RuntimeException)paramEventLoop);
    }
    paramEventLoop = paramChannelFactory.channel();
    this.ch = paramEventLoop;
    paramEventLoop.config().setRecvByteBufAllocator(new FixedRecvByteBufAllocator(paramInt2));
    paramEventLoop.closeFuture().addListener(new ChannelFutureListener()
    {
      public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
      {
        paramDnsCache.clear();
        paramDnsCnameCache.clear();
        paramAuthoritativeDnsServerCache.clear();
      }
    });
  }
  
  @Deprecated
  public DnsNameResolver(EventLoop paramEventLoop, ChannelFactory<? extends DatagramChannel> paramChannelFactory, DnsCache paramDnsCache, AuthoritativeDnsServerCache paramAuthoritativeDnsServerCache, DnsQueryLifecycleObserverFactory paramDnsQueryLifecycleObserverFactory, long paramLong, ResolvedAddressTypes paramResolvedAddressTypes, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2, boolean paramBoolean3, HostsFileEntriesResolver paramHostsFileEntriesResolver, DnsServerAddressStreamProvider paramDnsServerAddressStreamProvider, String[] paramArrayOfString, int paramInt3, boolean paramBoolean4)
  {
    this(paramEventLoop, paramChannelFactory, null, paramDnsCache, NoopDnsCnameCache.INSTANCE, paramAuthoritativeDnsServerCache, paramDnsQueryLifecycleObserverFactory, paramLong, paramResolvedAddressTypes, paramBoolean1, paramInt1, paramBoolean2, paramInt2, paramBoolean3, paramHostsFileEntriesResolver, paramDnsServerAddressStreamProvider, paramArrayOfString, paramInt3, paramBoolean4, false);
  }
  
  @Deprecated
  public DnsNameResolver(EventLoop paramEventLoop, ChannelFactory<? extends DatagramChannel> paramChannelFactory, DnsCache paramDnsCache1, DnsCache paramDnsCache2, DnsQueryLifecycleObserverFactory paramDnsQueryLifecycleObserverFactory, long paramLong, ResolvedAddressTypes paramResolvedAddressTypes, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2, boolean paramBoolean3, HostsFileEntriesResolver paramHostsFileEntriesResolver, DnsServerAddressStreamProvider paramDnsServerAddressStreamProvider, String[] paramArrayOfString, int paramInt3, boolean paramBoolean4)
  {
    this(paramEventLoop, paramChannelFactory, paramDnsCache1, new AuthoritativeDnsServerCacheAdapter(paramDnsCache2), paramDnsQueryLifecycleObserverFactory, paramLong, paramResolvedAddressTypes, paramBoolean1, paramInt1, paramBoolean2, paramInt2, paramBoolean3, paramHostsFileEntriesResolver, paramDnsServerAddressStreamProvider, paramArrayOfString, paramInt3, paramBoolean4);
  }
  
  private static boolean anyInterfaceSupportsIpV6()
  {
    try
    {
      boolean bool;
      do
      {
        InetAddress localInetAddress;
        do
        {
          Enumeration localEnumeration1 = NetworkInterface.getNetworkInterfaces();
          Enumeration localEnumeration2;
          while (!localEnumeration2.hasMoreElements())
          {
            if (!localEnumeration1.hasMoreElements()) {
              break;
            }
            localEnumeration2 = ((NetworkInterface)localEnumeration1.nextElement()).getInetAddresses();
          }
          localInetAddress = (InetAddress)localEnumeration2.nextElement();
        } while ((!(localInetAddress instanceof Inet6Address)) || (localInetAddress.isAnyLocalAddress()) || (localInetAddress.isLoopbackAddress()));
        bool = localInetAddress.isLinkLocalAddress();
      } while (bool);
      return true;
    }
    catch (SocketException localSocketException)
    {
      logger.debug("Unable to detect if any interface supports IPv6, assuming IPv4-only", localSocketException);
    }
    return false;
  }
  
  private static Promise<AddressedEnvelope<DnsResponse, InetSocketAddress>> cast(Promise<?> paramPromise)
  {
    return paramPromise;
  }
  
  static boolean doResolveAllCached(String paramString, DnsRecord[] paramArrayOfDnsRecord, Promise<List<InetAddress>> paramPromise, DnsCache paramDnsCache, InternetProtocolFamily[] paramArrayOfInternetProtocolFamily)
  {
    paramDnsCache = paramDnsCache.get(paramString, paramArrayOfDnsRecord);
    if ((paramDnsCache != null) && (!paramDnsCache.isEmpty()))
    {
      paramString = ((DnsCacheEntry)paramDnsCache.get(0)).cause();
      if (paramString == null)
      {
        paramString = null;
        int i = paramDnsCache.size();
        int j = paramArrayOfInternetProtocolFamily.length;
        for (int k = 0; k < j; k++)
        {
          InternetProtocolFamily localInternetProtocolFamily = paramArrayOfInternetProtocolFamily[k];
          int m = 0;
          while (m < i)
          {
            DnsCacheEntry localDnsCacheEntry = (DnsCacheEntry)paramDnsCache.get(m);
            paramArrayOfDnsRecord = paramString;
            if (localInternetProtocolFamily.addressType().isInstance(localDnsCacheEntry.address()))
            {
              paramArrayOfDnsRecord = paramString;
              if (paramString == null) {
                paramArrayOfDnsRecord = new ArrayList(i);
              }
              paramArrayOfDnsRecord.add(localDnsCacheEntry.address());
            }
            m++;
            paramString = paramArrayOfDnsRecord;
          }
        }
        if (paramString != null)
        {
          trySuccess(paramPromise, paramString);
          return true;
        }
        return false;
      }
      tryFailure(paramPromise, paramString);
      return true;
    }
    return false;
  }
  
  private void doResolveAllUncached(final String paramString, final DnsRecord[] paramArrayOfDnsRecord, final Promise<?> paramPromise, final Promise<List<InetAddress>> paramPromise1, final DnsCache paramDnsCache, final boolean paramBoolean)
  {
    EventLoop localEventLoop = executor();
    if (localEventLoop.inEventLoop()) {
      doResolveAllUncached0(paramString, paramArrayOfDnsRecord, paramPromise, paramPromise1, paramDnsCache, paramBoolean);
    } else {
      localEventLoop.execute(new Runnable()
      {
        public void run()
        {
          DnsNameResolver.this.doResolveAllUncached0(paramString, paramArrayOfDnsRecord, paramPromise, paramPromise1, paramDnsCache, paramBoolean);
        }
      });
    }
  }
  
  private void doResolveAllUncached0(String paramString, DnsRecord[] paramArrayOfDnsRecord, Promise<?> paramPromise, Promise<List<InetAddress>> paramPromise1, DnsCache paramDnsCache, boolean paramBoolean)
  {
    new DnsAddressResolveContext(this, paramPromise, paramString, paramArrayOfDnsRecord, this.dnsServerAddressStreamProvider.nameServerAddressStream(paramString), paramDnsCache, this.authoritativeDnsServerCache, paramBoolean).resolve(paramPromise1);
  }
  
  private boolean doResolveCached(String paramString, DnsRecord[] paramArrayOfDnsRecord, Promise<InetAddress> paramPromise, DnsCache paramDnsCache)
  {
    paramString = paramDnsCache.get(paramString, paramArrayOfDnsRecord);
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      paramArrayOfDnsRecord = ((DnsCacheEntry)paramString.get(0)).cause();
      if (paramArrayOfDnsRecord == null)
      {
        int i = paramString.size();
        for (DnsRecord localDnsRecord : this.resolvedInternetProtocolFamilies) {
          for (int m = 0; m < i; m++)
          {
            paramDnsCache = (DnsCacheEntry)paramString.get(m);
            if (localDnsRecord.addressType().isInstance(paramDnsCache.address()))
            {
              trySuccess(paramPromise, paramDnsCache.address());
              return true;
            }
          }
        }
        return false;
      }
      tryFailure(paramPromise, paramArrayOfDnsRecord);
      return true;
    }
    return false;
  }
  
  private void doResolveUncached(String paramString, DnsRecord[] paramArrayOfDnsRecord, final Promise<InetAddress> paramPromise, DnsCache paramDnsCache, boolean paramBoolean)
  {
    Promise localPromise = executor().newPromise();
    doResolveAllUncached(paramString, paramArrayOfDnsRecord, paramPromise, localPromise, paramDnsCache, true);
    localPromise.addListener(new a()
    {
      public void operationComplete(Future<List<InetAddress>> paramAnonymousFuture)
      {
        if (paramAnonymousFuture.isSuccess()) {
          DnsNameResolver.trySuccess(paramPromise, ((List)paramAnonymousFuture.getNow()).get(0));
        } else {
          DnsNameResolver.tryFailure(paramPromise, paramAnonymousFuture.cause());
        }
      }
    });
  }
  
  private static List<String> getSearchDomainsHack()
    throws Exception
  {
    if (PlatformDependent.javaVersion() < 9)
    {
      Class localClass = Class.forName("sun.net.dns.ResolverConfiguration");
      Method localMethod = localClass.getMethod("open", new Class[0]);
      return (List)localClass.getMethod("searchlist", new Class[0]).invoke(localMethod.invoke(null, new Object[0]), new Object[0]);
    }
    return Collections.emptyList();
  }
  
  private static String hostname(String paramString)
  {
    String str1 = IDN.toASCII(paramString);
    String str2 = str1;
    if (StringUtil.endsWith(paramString, '.'))
    {
      str2 = str1;
      if (!StringUtil.endsWith(str1, '.'))
      {
        paramString = new StringBuilder();
        paramString.append(str1);
        paramString.append(".");
        str2 = paramString.toString();
      }
    }
    return str2;
  }
  
  public static boolean isTimeoutError(Throwable paramThrowable)
  {
    boolean bool;
    if ((paramThrowable != null) && ((paramThrowable.getCause() instanceof DnsNameResolverTimeoutException))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean isTransportOrTimeoutError(Throwable paramThrowable)
  {
    boolean bool;
    if ((paramThrowable != null) && ((paramThrowable.getCause() instanceof DnsNameResolverException))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private InetAddress loopbackAddress()
  {
    return preferredAddressType().localhost();
  }
  
  private InetSocketAddress nextNameServerAddress()
  {
    return ((DnsServerAddressStream)this.nameServerAddrStream.get()).next();
  }
  
  static InternetProtocolFamily preferredAddressType(ResolvedAddressTypes paramResolvedAddressTypes)
  {
    int i = 7.$SwitchMap$io$netty$resolver$ResolvedAddressTypes[paramResolvedAddressTypes.ordinal()];
    if ((i != 1) && (i != 2))
    {
      if ((i != 3) && (i != 4))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unknown ResolvedAddressTypes ");
        localStringBuilder.append(paramResolvedAddressTypes);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      return InternetProtocolFamily.IPv6;
    }
    return InternetProtocolFamily.IPv4;
  }
  
  private Future<List<DnsRecord>> resolveAll(DnsQuestion paramDnsQuestion, DnsRecord[] paramArrayOfDnsRecord, Promise<List<DnsRecord>> paramPromise)
  {
    ObjectUtil.checkNotNull(paramDnsQuestion, "question");
    ObjectUtil.checkNotNull(paramPromise, "promise");
    DnsRecordType localDnsRecordType1 = paramDnsQuestion.type();
    String str = paramDnsQuestion.name();
    DnsRecordType localDnsRecordType2 = DnsRecordType.A;
    if ((localDnsRecordType1 == localDnsRecordType2) || (localDnsRecordType1 == DnsRecordType.AAAA))
    {
      Object localObject = resolveHostsFileEntry(str);
      if (localObject != null)
      {
        if ((localObject instanceof Inet4Address))
        {
          if (localDnsRecordType1 != localDnsRecordType2) {}
        }
        else {
          for (localObject = Unpooled.wrappedBuffer(((InetAddress)localObject).getAddress());; localObject = Unpooled.wrappedBuffer(((InetAddress)localObject).getAddress()))
          {
            break label125;
            if ((!(localObject instanceof Inet6Address)) || (localDnsRecordType1 != DnsRecordType.AAAA)) {
              break;
            }
          }
        }
        localObject = null;
        label125:
        if (localObject != null)
        {
          trySuccess(paramPromise, Collections.singletonList(new DefaultDnsRawRecord(str, localDnsRecordType1, 86400L, (ByteBuf)localObject)));
          return paramPromise;
        }
      }
    }
    new DnsRecordResolveContext(this, paramPromise, paramDnsQuestion, paramArrayOfDnsRecord, this.dnsServerAddressStreamProvider.nameServerAddressStream(str)).resolve(paramPromise);
    return paramPromise;
  }
  
  private InetAddress resolveHostsFileEntry(String paramString)
  {
    Object localObject = this.hostsFileEntriesResolver;
    if (localObject == null) {
      return null;
    }
    localObject = ((HostsFileEntriesResolver)localObject).address(paramString, this.resolvedAddressTypes);
    if ((localObject == null) && (PlatformDependent.isWindows()) && ("localhost".equalsIgnoreCase(paramString))) {
      return LOCALHOST_ADDRESS;
    }
    return (InetAddress)localObject;
  }
  
  private static DnsRecord[] toArray(Iterable<DnsRecord> paramIterable, boolean paramBoolean)
  {
    ObjectUtil.checkNotNull(paramIterable, "additionals");
    Object localObject;
    if ((paramIterable instanceof Collection))
    {
      localObject = (Collection)paramIterable;
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        validateAdditional((DnsRecord)paramIterable.next(), paramBoolean);
      }
      return (DnsRecord[])((Collection)localObject).toArray(new DnsRecord[((Collection)localObject).size()]);
    }
    Iterator localIterator = paramIterable.iterator();
    if (!localIterator.hasNext()) {
      return EMPTY_ADDITIONALS;
    }
    paramIterable = new ArrayList();
    do
    {
      localObject = (DnsRecord)localIterator.next();
      validateAdditional((DnsRecord)localObject, paramBoolean);
      paramIterable.add(localObject);
    } while (localIterator.hasNext());
    return (DnsRecord[])paramIterable.toArray(new DnsRecord[paramIterable.size()]);
  }
  
  private static void tryFailure(Promise<?> paramPromise, Throwable paramThrowable)
  {
    if (!paramPromise.tryFailure(paramThrowable)) {
      logger.trace("Failed to notify failure to a promise: {}", paramPromise, paramThrowable);
    }
  }
  
  static <T> void trySuccess(Promise<T> paramPromise, T paramT)
  {
    if (!paramPromise.trySuccess(paramT)) {
      logger.trace("Failed to notify success ({}) to a promise: {}", paramT, paramPromise);
    }
  }
  
  private static void validateAdditional(DnsRecord paramDnsRecord, boolean paramBoolean)
  {
    ObjectUtil.checkNotNull(paramDnsRecord, "record");
    if ((paramBoolean) && ((paramDnsRecord instanceof DnsRawRecord)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DnsRawRecord implementations not allowed: ");
      localStringBuilder.append(paramDnsRecord);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
  }
  
  public AuthoritativeDnsServerCache authoritativeDnsServerCache()
  {
    return this.authoritativeDnsServerCache;
  }
  
  public void close()
  {
    if (this.ch.isOpen()) {
      this.ch.close();
    }
  }
  
  DnsCnameCache cnameCache()
  {
    return this.cnameCache;
  }
  
  final DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory()
  {
    return this.dnsQueryLifecycleObserverFactory;
  }
  
  protected void doResolve(String paramString, Promise<InetAddress> paramPromise)
    throws Exception
  {
    doResolve(paramString, EMPTY_ADDITIONALS, paramPromise, this.resolveCache);
  }
  
  protected void doResolve(String paramString, DnsRecord[] paramArrayOfDnsRecord, Promise<InetAddress> paramPromise, DnsCache paramDnsCache)
    throws Exception
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      Object localObject = NetUtil.createByteArrayFromIpAddressString(paramString);
      if (localObject != null)
      {
        paramPromise.setSuccess(InetAddress.getByAddress((byte[])localObject));
        return;
      }
      paramString = hostname(paramString);
      localObject = resolveHostsFileEntry(paramString);
      if (localObject != null)
      {
        paramPromise.setSuccess(localObject);
        return;
      }
      if (!doResolveCached(paramString, paramArrayOfDnsRecord, paramPromise, paramDnsCache)) {
        doResolveUncached(paramString, paramArrayOfDnsRecord, paramPromise, paramDnsCache, true);
      }
      return;
    }
    paramPromise.setSuccess(loopbackAddress());
  }
  
  protected void doResolveAll(String paramString, Promise<List<InetAddress>> paramPromise)
    throws Exception
  {
    doResolveAll(paramString, EMPTY_ADDITIONALS, paramPromise, this.resolveCache);
  }
  
  protected void doResolveAll(String paramString, DnsRecord[] paramArrayOfDnsRecord, Promise<List<InetAddress>> paramPromise, DnsCache paramDnsCache)
    throws Exception
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      Object localObject = NetUtil.createByteArrayFromIpAddressString(paramString);
      if (localObject != null)
      {
        paramPromise.setSuccess(Collections.singletonList(InetAddress.getByAddress((byte[])localObject)));
        return;
      }
      paramString = hostname(paramString);
      localObject = resolveHostsFileEntry(paramString);
      if (localObject != null)
      {
        paramPromise.setSuccess(Collections.singletonList(localObject));
        return;
      }
      if (!doResolveAllCached(paramString, paramArrayOfDnsRecord, paramPromise, paramDnsCache, this.resolvedInternetProtocolFamilies)) {
        doResolveAllUncached(paramString, paramArrayOfDnsRecord, paramPromise, paramPromise, paramDnsCache, this.completeOncePreferredResolved);
      }
      return;
    }
    paramPromise.setSuccess(Collections.singletonList(loopbackAddress()));
  }
  
  protected EventLoop executor()
  {
    return (EventLoop)super.executor();
  }
  
  final void flushQueries()
  {
    this.ch.flush();
  }
  
  public HostsFileEntriesResolver hostsFileEntriesResolver()
  {
    return this.hostsFileEntriesResolver;
  }
  
  final boolean isDecodeIdn()
  {
    return this.decodeIdn;
  }
  
  public boolean isOptResourceEnabled()
  {
    return this.optResourceEnabled;
  }
  
  public boolean isRecursionDesired()
  {
    return this.recursionDesired;
  }
  
  public int maxPayloadSize()
  {
    return this.maxPayloadSize;
  }
  
  public int maxQueriesPerResolve()
  {
    return this.maxQueriesPerResolve;
  }
  
  final int ndots()
  {
    return this.ndots;
  }
  
  final DnsServerAddressStream newNameServerAddressStream(String paramString)
  {
    return this.dnsServerAddressStreamProvider.nameServerAddressStream(paramString);
  }
  
  protected DnsServerAddressStream newRedirectDnsServerStream(String paramString, List<InetSocketAddress> paramList)
  {
    paramString = authoritativeDnsServerCache().get(paramString);
    if ((paramString != null) && (paramString.size() != 0)) {
      return paramString;
    }
    Collections.sort(paramList, this.nameServerComparator);
    return new SequentialDnsServerAddressStream(paramList, 0);
  }
  
  InetSocketAddress newRedirectServerAddress(InetAddress paramInetAddress)
  {
    return new InetSocketAddress(paramInetAddress, 53);
  }
  
  final InternetProtocolFamily preferredAddressType()
  {
    return this.preferredAddressType;
  }
  
  public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(DnsQuestion paramDnsQuestion)
  {
    return query(nextNameServerAddress(), paramDnsQuestion);
  }
  
  public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(DnsQuestion paramDnsQuestion, Promise<AddressedEnvelope<? extends DnsResponse, InetSocketAddress>> paramPromise)
  {
    return query(nextNameServerAddress(), paramDnsQuestion, Collections.emptyList(), paramPromise);
  }
  
  public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(DnsQuestion paramDnsQuestion, Iterable<DnsRecord> paramIterable)
  {
    return query(nextNameServerAddress(), paramDnsQuestion, paramIterable);
  }
  
  public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(InetSocketAddress paramInetSocketAddress, DnsQuestion paramDnsQuestion)
  {
    return query0(paramInetSocketAddress, paramDnsQuestion, EMPTY_ADDITIONALS, true, this.ch.newPromise(), this.ch.eventLoop().newPromise());
  }
  
  public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(InetSocketAddress paramInetSocketAddress, DnsQuestion paramDnsQuestion, Promise<AddressedEnvelope<? extends DnsResponse, InetSocketAddress>> paramPromise)
  {
    return query0(paramInetSocketAddress, paramDnsQuestion, EMPTY_ADDITIONALS, true, this.ch.newPromise(), paramPromise);
  }
  
  public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(InetSocketAddress paramInetSocketAddress, DnsQuestion paramDnsQuestion, Iterable<DnsRecord> paramIterable)
  {
    return query0(paramInetSocketAddress, paramDnsQuestion, toArray(paramIterable, false), true, this.ch.newPromise(), this.ch.eventLoop().newPromise());
  }
  
  public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(InetSocketAddress paramInetSocketAddress, DnsQuestion paramDnsQuestion, Iterable<DnsRecord> paramIterable, Promise<AddressedEnvelope<? extends DnsResponse, InetSocketAddress>> paramPromise)
  {
    return query0(paramInetSocketAddress, paramDnsQuestion, toArray(paramIterable, false), true, this.ch.newPromise(), paramPromise);
  }
  
  final Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query0(InetSocketAddress paramInetSocketAddress, DnsQuestion paramDnsQuestion, DnsRecord[] paramArrayOfDnsRecord, boolean paramBoolean, ChannelPromise paramChannelPromise, Promise<AddressedEnvelope<? extends DnsResponse, InetSocketAddress>> paramPromise)
  {
    paramPromise = cast((Promise)ObjectUtil.checkNotNull(paramPromise, "promise"));
    try
    {
      DatagramDnsQueryContext localDatagramDnsQueryContext = new io/netty/resolver/dns/DatagramDnsQueryContext;
      localDatagramDnsQueryContext.<init>(this, paramInetSocketAddress, paramDnsQuestion, paramArrayOfDnsRecord, paramPromise);
      localDatagramDnsQueryContext.query(paramBoolean, paramChannelPromise);
      return paramPromise;
    }
    catch (Exception paramInetSocketAddress) {}
    return paramPromise.setFailure(paramInetSocketAddress);
  }
  
  public long queryTimeoutMillis()
  {
    return this.queryTimeoutMillis;
  }
  
  public final Future<InetAddress> resolve(String paramString, Iterable<DnsRecord> paramIterable)
  {
    return resolve(paramString, paramIterable, executor().newPromise());
  }
  
  public final Future<InetAddress> resolve(String paramString, Iterable<DnsRecord> paramIterable, Promise<InetAddress> paramPromise)
  {
    ObjectUtil.checkNotNull(paramPromise, "promise");
    paramIterable = toArray(paramIterable, true);
    try
    {
      doResolve(paramString, paramIterable, paramPromise, this.resolveCache);
      return paramPromise;
    }
    catch (Exception paramString) {}
    return paramPromise.setFailure(paramString);
  }
  
  public final Future<List<DnsRecord>> resolveAll(DnsQuestion paramDnsQuestion)
  {
    return resolveAll(paramDnsQuestion, EMPTY_ADDITIONALS, executor().newPromise());
  }
  
  public final Future<List<DnsRecord>> resolveAll(DnsQuestion paramDnsQuestion, Iterable<DnsRecord> paramIterable)
  {
    return resolveAll(paramDnsQuestion, paramIterable, executor().newPromise());
  }
  
  public final Future<List<DnsRecord>> resolveAll(DnsQuestion paramDnsQuestion, Iterable<DnsRecord> paramIterable, Promise<List<DnsRecord>> paramPromise)
  {
    return resolveAll(paramDnsQuestion, toArray(paramIterable, true), paramPromise);
  }
  
  public final Future<List<InetAddress>> resolveAll(String paramString, Iterable<DnsRecord> paramIterable)
  {
    return resolveAll(paramString, paramIterable, executor().newPromise());
  }
  
  public final Future<List<InetAddress>> resolveAll(String paramString, Iterable<DnsRecord> paramIterable, Promise<List<InetAddress>> paramPromise)
  {
    ObjectUtil.checkNotNull(paramPromise, "promise");
    paramIterable = toArray(paramIterable, true);
    try
    {
      doResolveAll(paramString, paramIterable, paramPromise, this.resolveCache);
      return paramPromise;
    }
    catch (Exception paramString) {}
    return paramPromise.setFailure(paramString);
  }
  
  public DnsCache resolveCache()
  {
    return this.resolveCache;
  }
  
  final DnsRecordType[] resolveRecordTypes()
  {
    return this.resolveRecordTypes;
  }
  
  public ResolvedAddressTypes resolvedAddressTypes()
  {
    return this.resolvedAddressTypes;
  }
  
  InternetProtocolFamily[] resolvedInternetProtocolFamiliesUnsafe()
  {
    return this.resolvedInternetProtocolFamilies;
  }
  
  final String[] searchDomains()
  {
    return this.searchDomains;
  }
  
  final boolean supportsAAAARecords()
  {
    return this.supportsAAAARecords;
  }
  
  final boolean supportsARecords()
  {
    return this.supportsARecords;
  }
  
  private static final class AddressedEnvelopeAdapter
    implements AddressedEnvelope<DnsResponse, InetSocketAddress>
  {
    private final InetSocketAddress recipient;
    private final DnsResponse response;
    private final InetSocketAddress sender;
    
    AddressedEnvelopeAdapter(InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2, DnsResponse paramDnsResponse)
    {
      this.sender = paramInetSocketAddress1;
      this.recipient = paramInetSocketAddress2;
      this.response = paramDnsResponse;
    }
    
    public DnsResponse content()
    {
      return this.response;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof AddressedEnvelope)) {
        return false;
      }
      AddressedEnvelope localAddressedEnvelope = (AddressedEnvelope)paramObject;
      if (sender() == null)
      {
        if (localAddressedEnvelope.sender() != null) {
          return false;
        }
      }
      else if (!sender().equals(localAddressedEnvelope.sender())) {
        return false;
      }
      if (recipient() == null)
      {
        if (localAddressedEnvelope.recipient() != null) {
          return false;
        }
      }
      else if (!recipient().equals(localAddressedEnvelope.recipient())) {
        return false;
      }
      return this.response.equals(paramObject);
    }
    
    public int hashCode()
    {
      int i = this.response.hashCode();
      int j = i;
      if (sender() != null) {
        j = i * 31 + sender().hashCode();
      }
      i = j;
      if (recipient() != null) {
        i = j * 31 + recipient().hashCode();
      }
      return i;
    }
    
    public InetSocketAddress recipient()
    {
      return this.recipient;
    }
    
    public int refCnt()
    {
      return this.response.refCnt();
    }
    
    public boolean release()
    {
      return this.response.release();
    }
    
    public boolean release(int paramInt)
    {
      return this.response.release(paramInt);
    }
    
    public AddressedEnvelope<DnsResponse, InetSocketAddress> retain()
    {
      this.response.retain();
      return this;
    }
    
    public AddressedEnvelope<DnsResponse, InetSocketAddress> retain(int paramInt)
    {
      this.response.retain(paramInt);
      return this;
    }
    
    public InetSocketAddress sender()
    {
      return this.sender;
    }
    
    public AddressedEnvelope<DnsResponse, InetSocketAddress> touch()
    {
      this.response.touch();
      return this;
    }
    
    public AddressedEnvelope<DnsResponse, InetSocketAddress> touch(Object paramObject)
    {
      this.response.touch(paramObject);
      return this;
    }
  }
  
  private final class DnsResponseHandler
    extends ChannelInboundHandlerAdapter
  {
    private final Promise<Channel> channelActivePromise;
    
    DnsResponseHandler()
    {
      Promise localPromise;
      this.channelActivePromise = localPromise;
    }
    
    public void channelActive(ChannelHandlerContext paramChannelHandlerContext)
      throws Exception
    {
      super.channelActive(paramChannelHandlerContext);
      this.channelActivePromise.setSuccess(paramChannelHandlerContext.channel());
    }
    
    public void channelRead(final ChannelHandlerContext paramChannelHandlerContext, final Object paramObject)
    {
      paramObject = (DatagramDnsResponse)paramObject;
      final int i = ((AbstractDnsMessage)paramObject).id();
      if (DnsNameResolver.logger.isDebugEnabled()) {
        DnsNameResolver.logger.debug("{} RECEIVED: UDP [{}: {}], {}", new Object[] { DnsNameResolver.this.ch, Integer.valueOf(i), ((DatagramDnsResponse)paramObject).sender(), paramObject });
      }
      paramChannelHandlerContext = DnsNameResolver.this.queryContextManager.get(((DatagramDnsResponse)paramObject).sender(), i);
      if (paramChannelHandlerContext == null)
      {
        DnsNameResolver.logger.debug("Received a DNS response with an unknown ID: UDP [{}: {}]", DnsNameResolver.this.ch, Integer.valueOf(i));
        ((AbstractReferenceCounted)paramObject).release();
        return;
      }
      if ((((DefaultDnsResponse)paramObject).isTruncated()) && (DnsNameResolver.this.socketChannelFactory != null))
      {
        Bootstrap localBootstrap = new Bootstrap();
        ((Bootstrap)((Bootstrap)((Bootstrap)localBootstrap.option(ChannelOption.SO_REUSEADDR, Boolean.TRUE)).group(DnsNameResolver.this.executor())).channelFactory(DnsNameResolver.this.socketChannelFactory)).handler(DnsNameResolver.TCP_ENCODER);
        localBootstrap.connect(((DatagramDnsResponse)paramObject).sender()).addListener(new ChannelFutureListener()
        {
          public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
          {
            if (!paramAnonymousChannelFuture.isSuccess())
            {
              if (DnsNameResolver.logger.isDebugEnabled()) {
                DnsNameResolver.logger.debug("Unable to fallback to TCP [{}]", Integer.valueOf(i), paramAnonymousChannelFuture.cause());
              }
              paramChannelHandlerContext.finish(paramObject);
              return;
            }
            final Channel localChannel = paramAnonymousChannelFuture.channel();
            Promise localPromise = localChannel.eventLoop().newPromise();
            final TcpDnsQueryContext localTcpDnsQueryContext = new TcpDnsQueryContext(DnsNameResolver.this, localChannel, (InetSocketAddress)localChannel.remoteAddress(), paramChannelHandlerContext.question(), DnsNameResolver.EMPTY_ADDITIONALS, localPromise);
            localChannel.pipeline().addLast(new ChannelHandler[] { new TcpDnsResponseDecoder() });
            localChannel.pipeline().addLast(new ChannelHandler[] { new ChannelInboundHandlerAdapter()
            {
              public void channelRead(ChannelHandlerContext paramAnonymous2ChannelHandlerContext, Object paramAnonymous2Object)
              {
                Channel localChannel = paramAnonymous2ChannelHandlerContext.channel();
                paramAnonymous2Object = (DnsResponse)paramAnonymous2Object;
                int i = ((DnsMessage)paramAnonymous2Object).id();
                if (DnsNameResolver.logger.isDebugEnabled()) {
                  DnsNameResolver.logger.debug("{} RECEIVED: TCP [{}: {}], {}", new Object[] { localChannel, Integer.valueOf(i), localChannel.remoteAddress(), paramAnonymous2Object });
                }
                Object localObject = DnsNameResolver.DnsResponseHandler.1.this;
                localObject = ((DnsNameResolver.DnsResponseHandler.1)localObject).this$1.this$0.queryContextManager.get(((DnsNameResolver.DnsResponseHandler.1)localObject).val$res.sender(), i);
                TcpDnsQueryContext localTcpDnsQueryContext = localTcpDnsQueryContext;
                if (localObject == localTcpDnsQueryContext)
                {
                  localTcpDnsQueryContext.finish(new DnsNameResolver.AddressedEnvelopeAdapter((InetSocketAddress)paramAnonymous2ChannelHandlerContext.channel().remoteAddress(), (InetSocketAddress)paramAnonymous2ChannelHandlerContext.channel().localAddress(), (DnsResponse)paramAnonymous2Object));
                }
                else
                {
                  ((ReferenceCounted)paramAnonymous2Object).release();
                  localTcpDnsQueryContext.tryFailure("Received TCP DNS response with unexpected ID", null, false);
                  DnsNameResolver.logger.debug("Received a DNS response with an unexpected ID: TCP [{}: {}]", localChannel, Integer.valueOf(i));
                }
              }
              
              public void exceptionCaught(ChannelHandlerContext paramAnonymous2ChannelHandlerContext, Throwable paramAnonymous2Throwable)
              {
                if ((localTcpDnsQueryContext.tryFailure("TCP fallback error", paramAnonymous2Throwable, false)) && (DnsNameResolver.logger.isDebugEnabled())) {
                  DnsNameResolver.logger.debug("{} Error during processing response: TCP [{}: {}]", new Object[] { paramAnonymous2ChannelHandlerContext.channel(), Integer.valueOf(DnsNameResolver.DnsResponseHandler.1.this.val$queryId), paramAnonymous2ChannelHandlerContext.channel().remoteAddress(), paramAnonymous2Throwable });
                }
              }
            } });
            localPromise.addListener(new a()
            {
              public void operationComplete(Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> paramAnonymous2Future)
              {
                localChannel.close();
                if (paramAnonymous2Future.isSuccess())
                {
                  DnsNameResolver.DnsResponseHandler.1.this.val$qCtx.finish((AddressedEnvelope)paramAnonymous2Future.getNow());
                  DnsNameResolver.DnsResponseHandler.1.this.val$res.release();
                }
                else
                {
                  paramAnonymous2Future = DnsNameResolver.DnsResponseHandler.1.this;
                  paramAnonymous2Future.val$qCtx.finish(paramAnonymous2Future.val$res);
                }
              }
            });
            localTcpDnsQueryContext.query(true, paramAnonymousChannelFuture.channel().newPromise());
          }
        });
        return;
      }
      paramChannelHandlerContext.finish((AddressedEnvelope)paramObject);
    }
    
    public void exceptionCaught(ChannelHandlerContext paramChannelHandlerContext, Throwable paramThrowable)
    {
      if ((paramThrowable instanceof CorruptedFrameException)) {
        DnsNameResolver.logger.debug("Unable to decode DNS response: UDP [{}]", paramChannelHandlerContext.channel(), paramThrowable);
      } else {
        DnsNameResolver.logger.warn("Unexpected exception: UDP [{}]", paramChannelHandlerContext.channel(), paramThrowable);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\DnsNameResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */