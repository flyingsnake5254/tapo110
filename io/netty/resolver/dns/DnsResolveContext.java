package io.netty.resolver.dns;

import io.netty.buffer.ByteBufHolder;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.EventLoop;
import io.netty.handler.codec.dns.DefaultDnsQuestion;
import io.netty.handler.codec.dns.DnsMessage;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsRawRecord;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.dns.DnsRecordType;
import io.netty.handler.codec.dns.DnsResponse;
import io.netty.handler.codec.dns.DnsResponseCode;
import io.netty.handler.codec.dns.DnsSection;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.a;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.ThrowableUtil;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

abstract class DnsResolveContext<T>
{
  private static final RuntimeException CNAME_NOT_FOUND_QUERY_FAILED_EXCEPTION;
  private static final RuntimeException NAME_SERVERS_EXHAUSTED_EXCEPTION = (RuntimeException)ThrowableUtil.unknownStackTrace(DnsResolveContextException.newStatic("No name servers returned an answer"), DnsResolveContext.class, "tryToFinishResolve(..)");
  private static final RuntimeException NO_MATCHING_RECORD_QUERY_FAILED_EXCEPTION;
  private static final RuntimeException NXDOMAIN_QUERY_FAILED_EXCEPTION = (RuntimeException)ThrowableUtil.unknownStackTrace(DnsResolveContextException.newStatic("No answer found and NXDOMAIN response code returned"), DnsResolveContext.class, "onResponse(..)");
  private static final RuntimeException UNRECOGNIZED_TYPE_QUERY_FAILED_EXCEPTION;
  final DnsRecord[] additionals;
  private int allowedQueries;
  private boolean completeEarly;
  private final int dnsClass;
  private final DnsRecordType[] expectedTypes;
  private List<T> finalResult;
  private final String hostname;
  private final int maxAllowedQueries;
  private final DnsServerAddressStream nameServerAddrs;
  private final Promise<?> originalPromise;
  final DnsNameResolver parent;
  private final Set<io.netty.util.concurrent.Future<AddressedEnvelope<DnsResponse, InetSocketAddress>>> queriesInProgress = Collections.newSetFromMap(new IdentityHashMap());
  private boolean triedCNAME;
  
  static
  {
    CNAME_NOT_FOUND_QUERY_FAILED_EXCEPTION = (RuntimeException)ThrowableUtil.unknownStackTrace(DnsResolveContextException.newStatic("No matching CNAME record found"), DnsResolveContext.class, "onResponseCNAME(..)");
    NO_MATCHING_RECORD_QUERY_FAILED_EXCEPTION = (RuntimeException)ThrowableUtil.unknownStackTrace(DnsResolveContextException.newStatic("No matching record type found"), DnsResolveContext.class, "onResponseAorAAAA(..)");
    UNRECOGNIZED_TYPE_QUERY_FAILED_EXCEPTION = (RuntimeException)ThrowableUtil.unknownStackTrace(new RuntimeException("Response type was unrecognized"), DnsResolveContext.class, "onResponse(..)");
  }
  
  DnsResolveContext(DnsNameResolver paramDnsNameResolver, Promise<?> paramPromise, String paramString, int paramInt, DnsRecordType[] paramArrayOfDnsRecordType, DnsRecord[] paramArrayOfDnsRecord, DnsServerAddressStream paramDnsServerAddressStream)
  {
    this.parent = paramDnsNameResolver;
    this.originalPromise = paramPromise;
    this.hostname = paramString;
    this.dnsClass = paramInt;
    this.expectedTypes = paramArrayOfDnsRecordType;
    this.additionals = paramArrayOfDnsRecord;
    this.nameServerAddrs = ((DnsServerAddressStream)ObjectUtil.checkNotNull(paramDnsServerAddressStream, "nameServerAddrs"));
    paramInt = paramDnsNameResolver.maxQueriesPerResolve();
    this.maxAllowedQueries = paramInt;
    this.allowedQueries = paramInt;
  }
  
  private static Map<String, String> buildAliasMap(DnsResponse paramDnsResponse, DnsCnameCache paramDnsCnameCache, EventLoop paramEventLoop)
  {
    int i = paramDnsResponse.count(DnsSection.ANSWER);
    Object localObject1 = null;
    for (int j = 0; j < i; j++)
    {
      DnsRecord localDnsRecord = paramDnsResponse.recordAt(DnsSection.ANSWER, j);
      if ((localDnsRecord.type() == DnsRecordType.CNAME) && ((localDnsRecord instanceof DnsRawRecord)))
      {
        String str1 = decodeDomainName(((ByteBufHolder)localDnsRecord).content());
        if (str1 != null)
        {
          Object localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new HashMap(Math.min(8, i));
          }
          String str2 = localDnsRecord.name();
          localObject1 = Locale.US;
          str2 = str2.toLowerCase((Locale)localObject1);
          String str3 = str1.toLowerCase((Locale)localObject1);
          String str4 = hostnameWithDot(str2);
          str1 = hostnameWithDot(str3);
          localObject1 = localObject2;
          if (!str4.equalsIgnoreCase(str1))
          {
            paramDnsCnameCache.cache(str4, str1, localDnsRecord.timeToLive(), paramEventLoop);
            ((Map)localObject2).put(str2, str3);
            localObject1 = localObject2;
          }
        }
      }
    }
    if (localObject1 == null) {
      localObject1 = Collections.emptyMap();
    }
    return (Map<String, String>)localObject1;
  }
  
  private static void checkCnameLoop(String paramString1, String paramString2, String paramString3)
    throws UnknownHostException
  {
    if (!paramString2.equals(paramString3)) {
      return;
    }
    paramString2 = new StringBuilder();
    paramString2.append("CNAME loop detected for '");
    paramString2.append(paramString1);
    paramString2.append('\'');
    throw new UnknownHostException(paramString2.toString());
  }
  
  static String cnameResolveFromCache(DnsCnameCache paramDnsCnameCache, String paramString)
    throws UnknownHostException
  {
    String str1 = paramDnsCnameCache.get(hostnameWithDot(paramString));
    if (str1 == null) {
      return paramString;
    }
    String str2 = paramDnsCnameCache.get(hostnameWithDot(str1));
    if (str2 == null) {
      return str1;
    }
    checkCnameLoop(paramString, str1, str2);
    return cnameResolveFromCacheLoop(paramDnsCnameCache, paramString, str1, str2);
  }
  
  private static String cnameResolveFromCacheLoop(DnsCnameCache paramDnsCnameCache, String paramString1, String paramString2, String paramString3)
    throws UnknownHostException
  {
    int i = 0;
    for (;;)
    {
      String str = paramDnsCnameCache.get(hostnameWithDot(paramString3));
      if (str == null) {
        break;
      }
      checkCnameLoop(paramString1, paramString2, str);
      paramString3 = paramString2;
      if (i != 0) {
        paramString3 = paramDnsCnameCache.get(paramString2);
      }
      i ^= 0x1;
      paramString2 = paramString3;
      paramString3 = str;
    }
    return paramString3;
  }
  
  /* Error */
  static String decodeDomainName(io.netty.buffer.ByteBuf paramByteBuf)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 341	io/netty/buffer/ByteBuf:markReaderIndex	()Lio/netty/buffer/ByteBuf;
    //   4: pop
    //   5: aload_0
    //   6: invokestatic 346	io/netty/handler/codec/dns/DefaultDnsRecordDecoder:decodeName	(Lio/netty/buffer/ByteBuf;)Ljava/lang/String;
    //   9: astore_1
    //   10: aload_0
    //   11: invokevirtual 349	io/netty/buffer/ByteBuf:resetReaderIndex	()Lio/netty/buffer/ByteBuf;
    //   14: pop
    //   15: aload_1
    //   16: areturn
    //   17: astore_1
    //   18: aload_0
    //   19: invokevirtual 349	io/netty/buffer/ByteBuf:resetReaderIndex	()Lio/netty/buffer/ByteBuf;
    //   22: pop
    //   23: aload_1
    //   24: athrow
    //   25: astore_1
    //   26: aload_0
    //   27: invokevirtual 349	io/netty/buffer/ByteBuf:resetReaderIndex	()Lio/netty/buffer/ByteBuf;
    //   30: pop
    //   31: aconst_null
    //   32: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	paramByteBuf	io.netty.buffer.ByteBuf
    //   9	7	1	str	String
    //   17	7	1	localObject	Object
    //   25	1	1	localCorruptedFrameException	io.netty.handler.codec.CorruptedFrameException
    // Exception table:
    //   from	to	target	type
    //   5	10	17	finally
    //   5	10	25	io/netty/handler/codec/CorruptedFrameException
  }
  
  private static AuthoritativeNameServerList extractAuthoritativeNameServers(String paramString, DnsResponse paramDnsResponse)
  {
    int i = paramDnsResponse.count(DnsSection.AUTHORITY);
    Object localObject = null;
    if (i == 0) {
      return null;
    }
    paramString = new AuthoritativeNameServerList(paramString);
    for (int j = 0; j < i; j++) {
      paramString.add(paramDnsResponse.recordAt(DnsSection.AUTHORITY, j));
    }
    if (paramString.isEmpty()) {
      paramString = (String)localObject;
    }
    return paramString;
  }
  
  private void finishResolve(Promise<List<T>> paramPromise, Throwable paramThrowable)
  {
    if ((!this.completeEarly) && (!this.queriesInProgress.isEmpty()))
    {
      localObject = this.queriesInProgress.iterator();
      while (((Iterator)localObject).hasNext())
      {
        io.netty.util.concurrent.Future localFuture = (io.netty.util.concurrent.Future)((Iterator)localObject).next();
        ((Iterator)localObject).remove();
        localFuture.cancel(false);
      }
    }
    if (this.finalResult != null)
    {
      if (!paramPromise.isDone()) {
        DnsNameResolver.trySuccess(paramPromise, filterResults(this.finalResult));
      }
      return;
    }
    int i = this.maxAllowedQueries - this.allowedQueries;
    Object localObject = new StringBuilder(64);
    ((StringBuilder)localObject).append("failed to resolve '");
    ((StringBuilder)localObject).append(this.hostname);
    ((StringBuilder)localObject).append('\'');
    if (i > 1) {
      if (i < this.maxAllowedQueries)
      {
        ((StringBuilder)localObject).append(" after ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" queries ");
      }
      else
      {
        ((StringBuilder)localObject).append(". Exceeded max queries per resolve ");
        ((StringBuilder)localObject).append(this.maxAllowedQueries);
        ((StringBuilder)localObject).append(' ');
      }
    }
    localObject = new UnknownHostException(((StringBuilder)localObject).toString());
    if (paramThrowable == null) {
      cache(this.hostname, this.additionals, (UnknownHostException)localObject);
    } else {
      ((UnknownHostException)localObject).initCause(paramThrowable);
    }
    paramPromise.tryFailure((Throwable)localObject);
  }
  
  private void followCname(DnsQuestion paramDnsQuestion, String paramString, DnsQueryLifecycleObserver paramDnsQueryLifecycleObserver, Promise<List<T>> paramPromise)
  {
    try
    {
      String str = cnameResolveFromCache(cnameCache(), paramString);
      paramString = getNameServers(str);
      paramDnsQuestion = new DefaultDnsQuestion(str, paramDnsQuestion.type(), this.dnsClass);
      query(paramString, 0, paramDnsQuestion, paramDnsQueryLifecycleObserver.queryCNAMEd(paramDnsQuestion), true, paramPromise, null);
      return;
    }
    finally
    {
      paramDnsQueryLifecycleObserver.queryFailed(paramDnsQuestion);
      PlatformDependent.throwException(paramDnsQuestion);
    }
  }
  
  private DnsServerAddressStream getNameServers(String paramString)
  {
    DnsServerAddressStream localDnsServerAddressStream1 = getNameServersFromCache(paramString);
    DnsServerAddressStream localDnsServerAddressStream2 = localDnsServerAddressStream1;
    if (localDnsServerAddressStream1 == null) {
      localDnsServerAddressStream2 = this.parent.newNameServerAddressStream(paramString);
    }
    return localDnsServerAddressStream2;
  }
  
  private DnsServerAddressStream getNameServersFromCache(String paramString)
  {
    int i = paramString.length();
    if (i == 0) {
      return null;
    }
    Object localObject = paramString;
    if (paramString.charAt(i - 1) != '.')
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(".");
      localObject = ((StringBuilder)localObject).toString();
    }
    int j = ((String)localObject).indexOf('.');
    i = j;
    paramString = (String)localObject;
    if (j == ((String)localObject).length() - 1) {
      return null;
    }
    do
    {
      paramString = paramString.substring(i + 1);
      i = paramString.indexOf('.');
      if ((i <= 0) || (i == paramString.length() - 1)) {
        break;
      }
      localObject = authoritativeDnsServerCache().get(paramString);
    } while (localObject == null);
    return (DnsServerAddressStream)localObject;
    return null;
  }
  
  private boolean handleRedirect(DnsQuestion paramDnsQuestion, AddressedEnvelope<DnsResponse, InetSocketAddress> paramAddressedEnvelope, DnsQueryLifecycleObserver paramDnsQueryLifecycleObserver, Promise<List<T>> paramPromise)
  {
    DnsResponse localDnsResponse = (DnsResponse)paramAddressedEnvelope.content();
    if (localDnsResponse.count(DnsSection.ANSWER) == 0)
    {
      paramAddressedEnvelope = extractAuthoritativeNameServers(paramDnsQuestion.name(), localDnsResponse);
      if (paramAddressedEnvelope != null)
      {
        int i = localDnsResponse.count(DnsSection.ADDITIONAL);
        AuthoritativeDnsServerCache localAuthoritativeDnsServerCache = authoritativeDnsServerCache();
        for (int j = 0; j < i; j++)
        {
          DnsRecord localDnsRecord = localDnsResponse.recordAt(DnsSection.ADDITIONAL, j);
          if (((localDnsRecord.type() != DnsRecordType.A) || (this.parent.supportsARecords())) && ((localDnsRecord.type() != DnsRecordType.AAAA) || (this.parent.supportsAAAARecords()))) {
            paramAddressedEnvelope.handleWithAdditional(this.parent, localDnsRecord, localAuthoritativeDnsServerCache);
          }
        }
        paramAddressedEnvelope.handleWithoutAdditionals(this.parent, resolveCache(), localAuthoritativeDnsServerCache);
        paramAddressedEnvelope = paramAddressedEnvelope.addressList();
        paramAddressedEnvelope = this.parent.newRedirectDnsServerStream(paramDnsQuestion.name(), paramAddressedEnvelope);
        if (paramAddressedEnvelope != null)
        {
          query(paramAddressedEnvelope, 0, paramDnsQuestion, paramDnsQueryLifecycleObserver.queryRedirected(new DnsAddressStreamList(paramAddressedEnvelope)), true, paramPromise, null);
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean hasNDots()
  {
    int i = this.hostname.length() - 1;
    int k;
    for (int j = 0; i >= 0; j = k)
    {
      k = j;
      if (this.hostname.charAt(i) == '.')
      {
        j++;
        k = j;
        if (j >= this.parent.ndots()) {
          return true;
        }
      }
      i--;
    }
    return false;
  }
  
  private static String hostnameWithDot(String paramString)
  {
    if (StringUtil.endsWith(paramString, '.')) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append('.');
    return localStringBuilder.toString();
  }
  
  private void internalResolve(String paramString, Promise<List<T>> paramPromise)
  {
    try
    {
      String str = cnameResolveFromCache(cnameCache(), paramString);
      try
      {
        paramString = getNameServers(str);
        int i = this.expectedTypes.length - 1;
        for (int j = 0; j < i; j++)
        {
          boolean bool = query(str, this.expectedTypes[j], paramString.duplicate(), false, paramPromise);
          if (!bool) {
            return;
          }
        }
        query(str, this.expectedTypes[i], paramString, false, paramPromise);
        return;
      }
      finally
      {
        this.parent.flushQueries();
      }
      return;
    }
    finally {}
  }
  
  private DnsQueryLifecycleObserver newDnsQueryLifecycleObserver(DnsQuestion paramDnsQuestion)
  {
    return this.parent.dnsQueryLifecycleObserverFactory().newDnsQueryLifecycleObserver(paramDnsQuestion);
  }
  
  private void onExpectedResponse(DnsQuestion paramDnsQuestion, AddressedEnvelope<DnsResponse, InetSocketAddress> paramAddressedEnvelope, DnsQueryLifecycleObserver paramDnsQueryLifecycleObserver, Promise<List<T>> paramPromise)
  {
    DnsResponse localDnsResponse = (DnsResponse)paramAddressedEnvelope.content();
    Map localMap = buildAliasMap(localDnsResponse, cnameCache(), this.parent.executor());
    int i = localDnsResponse.count(DnsSection.ANSWER);
    boolean bool1 = this.completeEarly;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      DnsRecord localDnsRecord = localDnsResponse.recordAt(DnsSection.ANSWER, j);
      paramAddressedEnvelope = localDnsRecord.type();
      Object localObject = this.expectedTypes;
      int m = localObject.length;
      for (int n = 0; n < m; n++) {
        if (paramAddressedEnvelope == localObject[n])
        {
          n = 1;
          break label127;
        }
      }
      n = 0;
      label127:
      boolean bool2;
      if (n == 0)
      {
        bool2 = bool1;
      }
      else
      {
        paramAddressedEnvelope = paramDnsQuestion.name();
        localObject = Locale.US;
        paramAddressedEnvelope = paramAddressedEnvelope.toLowerCase((Locale)localObject);
        String str = localDnsRecord.name().toLowerCase((Locale)localObject);
        if (!str.equals(paramAddressedEnvelope))
        {
          HashMap localHashMap = new HashMap(localMap);
          do
          {
            localObject = (String)localHashMap.remove(paramAddressedEnvelope);
            if (str.equals(localObject)) {
              break;
            }
            paramAddressedEnvelope = (AddressedEnvelope<DnsResponse, InetSocketAddress>)localObject;
          } while (localObject != null);
          if (localObject == null)
          {
            bool2 = bool1;
            break label399;
          }
        }
        localObject = convertRecord(localDnsRecord, this.hostname, this.additionals, this.parent.executor());
        if (localObject == null)
        {
          bool2 = bool1;
        }
        else
        {
          bool2 = bool1;
          if (!bool1) {
            bool2 = isCompleteEarly(localObject);
          }
          if (this.finalResult == null)
          {
            paramAddressedEnvelope = new ArrayList(8);
            this.finalResult = paramAddressedEnvelope;
            paramAddressedEnvelope.add(localObject);
          }
          else
          {
            if ((!isDuplicateAllowed()) && (this.finalResult.contains(localObject)))
            {
              k = 1;
              break label369;
            }
            this.finalResult.add(localObject);
          }
          k = 0;
          label369:
          cache(this.hostname, this.additionals, localDnsRecord, localObject);
          if (k != 0) {
            ReferenceCountUtil.release(localObject);
          }
          k = 1;
        }
      }
      label399:
      j++;
      bool1 = bool2;
    }
    if (localMap.isEmpty())
    {
      if (k != 0)
      {
        if (bool1) {
          this.completeEarly = true;
        }
        paramDnsQueryLifecycleObserver.querySucceed();
        return;
      }
      paramDnsQueryLifecycleObserver.queryFailed(NO_MATCHING_RECORD_QUERY_FAILED_EXCEPTION);
    }
    else
    {
      paramDnsQueryLifecycleObserver.querySucceed();
      onResponseCNAME(paramDnsQuestion, localMap, newDnsQueryLifecycleObserver(paramDnsQuestion), paramPromise);
    }
  }
  
  private void onResponse(DnsServerAddressStream paramDnsServerAddressStream, int paramInt, DnsQuestion paramDnsQuestion, AddressedEnvelope<DnsResponse, InetSocketAddress> paramAddressedEnvelope, DnsQueryLifecycleObserver paramDnsQueryLifecycleObserver, Promise<List<T>> paramPromise)
  {
    try
    {
      DnsResponse localDnsResponse = (DnsResponse)paramAddressedEnvelope.content();
      Object localObject = localDnsResponse.code();
      if (localObject == DnsResponseCode.NOERROR)
      {
        boolean bool = handleRedirect(paramDnsQuestion, paramAddressedEnvelope, paramDnsQueryLifecycleObserver, paramPromise);
        if (bool) {
          return;
        }
        paramDnsServerAddressStream = paramDnsQuestion.type();
        if (paramDnsServerAddressStream == DnsRecordType.CNAME)
        {
          onResponseCNAME(paramDnsQuestion, buildAliasMap((DnsResponse)paramAddressedEnvelope.content(), cnameCache(), this.parent.executor()), paramDnsQueryLifecycleObserver, paramPromise);
          return;
        }
        localObject = this.expectedTypes;
        int i = localObject.length;
        for (paramInt = 0; paramInt < i; paramInt++) {
          if (paramDnsServerAddressStream == localObject[paramInt])
          {
            onExpectedResponse(paramDnsQuestion, paramAddressedEnvelope, paramDnsQueryLifecycleObserver, paramPromise);
            return;
          }
        }
        paramDnsQueryLifecycleObserver.queryFailed(UNRECOGNIZED_TYPE_QUERY_FAILED_EXCEPTION);
        return;
      }
      if (localObject != DnsResponseCode.NXDOMAIN)
      {
        query(paramDnsServerAddressStream, paramInt + 1, paramDnsQuestion, paramDnsQueryLifecycleObserver.queryNoAnswer((DnsResponseCode)localObject), true, paramPromise, null);
      }
      else
      {
        paramDnsQueryLifecycleObserver.queryFailed(NXDOMAIN_QUERY_FAILED_EXCEPTION);
        if (!localDnsResponse.isAuthoritativeAnswer()) {
          query(paramDnsServerAddressStream, paramInt + 1, paramDnsQuestion, newDnsQueryLifecycleObserver(paramDnsQuestion), true, paramPromise, null);
        }
      }
      return;
    }
    finally
    {
      ReferenceCountUtil.safeRelease(paramAddressedEnvelope);
    }
  }
  
  private void onResponseCNAME(DnsQuestion paramDnsQuestion, Map<String, String> paramMap, DnsQueryLifecycleObserver paramDnsQueryLifecycleObserver, Promise<List<T>> paramPromise)
  {
    Object localObject = paramDnsQuestion.name().toLowerCase(Locale.US);
    int i = 0;
    while (!paramMap.isEmpty())
    {
      String str = (String)paramMap.remove(localObject);
      if (str == null) {
        break;
      }
      i = 1;
      localObject = str;
    }
    if (i != 0) {
      followCname(paramDnsQuestion, (String)localObject, paramDnsQueryLifecycleObserver, paramPromise);
    } else {
      paramDnsQueryLifecycleObserver.queryFailed(CNAME_NOT_FOUND_QUERY_FAILED_EXCEPTION);
    }
  }
  
  private void query(final DnsServerAddressStream paramDnsServerAddressStream, final int paramInt, final DnsQuestion paramDnsQuestion, final DnsQueryLifecycleObserver paramDnsQueryLifecycleObserver, boolean paramBoolean, final Promise<List<T>> paramPromise, Throwable paramThrowable)
  {
    if ((!this.completeEarly) && (paramInt < paramDnsServerAddressStream.size()) && (this.allowedQueries != 0) && (!this.originalPromise.isCancelled()) && (!paramPromise.isCancelled()))
    {
      this.allowedQueries -= 1;
      InetSocketAddress localInetSocketAddress = paramDnsServerAddressStream.next();
      if (localInetSocketAddress.isUnresolved())
      {
        queryUnresolvedNameServer(localInetSocketAddress, paramDnsServerAddressStream, paramInt, paramDnsQuestion, paramDnsQueryLifecycleObserver, paramPromise, paramThrowable);
        return;
      }
      paramThrowable = this.parent.ch.newPromise();
      Object localObject = this.parent.ch.eventLoop().newPromise();
      localObject = this.parent.query0(localInetSocketAddress, paramDnsQuestion, this.additionals, paramBoolean, paramThrowable, (Promise)localObject);
      this.queriesInProgress.add(localObject);
      paramDnsQueryLifecycleObserver.queryWritten(localInetSocketAddress, paramThrowable);
      ((io.netty.util.concurrent.Future)localObject).addListener(new a()
      {
        public void operationComplete(io.netty.util.concurrent.Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> paramAnonymousFuture)
        {
          DnsResolveContext.this.queriesInProgress.remove(paramAnonymousFuture);
          if ((!paramPromise.isDone()) && (!paramAnonymousFuture.isCancelled()))
          {
            Throwable localThrowable = paramAnonymousFuture.cause();
            if (localThrowable == null) {}
            try
            {
              DnsResolveContext.this.onResponse(paramDnsServerAddressStream, paramInt, paramDnsQuestion, (AddressedEnvelope)paramAnonymousFuture.getNow(), paramDnsQueryLifecycleObserver, paramPromise);
              break label143;
              paramDnsQueryLifecycleObserver.queryFailed(localThrowable);
              paramAnonymousFuture = DnsResolveContext.this;
              DnsServerAddressStream localDnsServerAddressStream = paramDnsServerAddressStream;
              int i = paramInt;
              DnsQuestion localDnsQuestion = paramDnsQuestion;
              paramAnonymousFuture.query(localDnsServerAddressStream, i + 1, localDnsQuestion, DnsResolveContext.access$500(paramAnonymousFuture, localDnsQuestion), true, paramPromise, localThrowable);
              label143:
              return;
            }
            finally
            {
              DnsResolveContext.this.tryToFinishResolve(paramDnsServerAddressStream, paramInt, paramDnsQuestion, NoopDnsQueryLifecycleObserver.INSTANCE, paramPromise, localThrowable);
            }
          }
          paramDnsQueryLifecycleObserver.queryCancelled(DnsResolveContext.this.allowedQueries);
          paramAnonymousFuture = (AddressedEnvelope)paramAnonymousFuture.getNow();
          if (paramAnonymousFuture != null) {
            paramAnonymousFuture.release();
          }
        }
      });
      return;
    }
    tryToFinishResolve(paramDnsServerAddressStream, paramInt, paramDnsQuestion, paramDnsQueryLifecycleObserver, paramPromise, paramThrowable);
  }
  
  private boolean query(String paramString, DnsRecordType paramDnsRecordType, DnsServerAddressStream paramDnsServerAddressStream, boolean paramBoolean, Promise<List<T>> paramPromise)
  {
    try
    {
      localObject = new DefaultDnsQuestion(paramString, paramDnsRecordType, this.dnsClass);
      query(paramDnsServerAddressStream, 0, (DnsQuestion)localObject, newDnsQueryLifecycleObserver((DnsQuestion)localObject), paramBoolean, paramPromise, null);
      return true;
    }
    finally
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unable to create DNS Question for: [");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramDnsRecordType);
      ((StringBuilder)localObject).append(']');
      paramPromise.tryFailure(new IllegalArgumentException(((StringBuilder)localObject).toString(), paramDnsServerAddressStream));
    }
    return false;
  }
  
  private void queryUnresolvedNameServer(final InetSocketAddress paramInetSocketAddress, final DnsServerAddressStream paramDnsServerAddressStream, final int paramInt, final DnsQuestion paramDnsQuestion, final DnsQueryLifecycleObserver paramDnsQueryLifecycleObserver, final Promise<List<T>> paramPromise, final Throwable paramThrowable)
  {
    String str;
    if (PlatformDependent.javaVersion() >= 7) {
      str = paramInetSocketAddress.getHostString();
    } else {
      str = paramInetSocketAddress.getHostName();
    }
    final io.netty.util.concurrent.Future localFuture = this.parent.executor().newSucceededFuture(null);
    this.queriesInProgress.add(localFuture);
    Promise localPromise = this.parent.executor().newPromise();
    localPromise.addListener(new a()
    {
      public void operationComplete(io.netty.util.concurrent.Future<List<InetAddress>> paramAnonymousFuture)
      {
        DnsResolveContext.this.queriesInProgress.remove(localFuture);
        if (paramAnonymousFuture.isSuccess())
        {
          paramAnonymousFuture = (List)paramAnonymousFuture.getNow();
          paramAnonymousFuture = new DnsResolveContext.CombinedDnsServerAddressStream(DnsResolveContext.this, paramInetSocketAddress, paramAnonymousFuture, paramDnsServerAddressStream);
          DnsResolveContext.this.query(paramAnonymousFuture, paramInt, paramDnsQuestion, paramDnsQueryLifecycleObserver, true, paramPromise, paramThrowable);
        }
        else
        {
          DnsResolveContext.this.query(paramDnsServerAddressStream, paramInt + 1, paramDnsQuestion, paramDnsQueryLifecycleObserver, true, paramPromise, paramThrowable);
        }
      }
    });
    paramInetSocketAddress = resolveCache();
    if (!DnsNameResolver.doResolveAllCached(str, this.additionals, localPromise, paramInetSocketAddress, this.parent.resolvedInternetProtocolFamiliesUnsafe()))
    {
      paramDnsServerAddressStream = this.parent;
      new DnsAddressResolveContext(paramDnsServerAddressStream, this.originalPromise, str, this.additionals, paramDnsServerAddressStream.newNameServerAddressStream(str), paramInetSocketAddress, redirectAuthoritativeDnsServerCache(authoritativeDnsServerCache()), false).resolve(localPromise);
    }
  }
  
  private static AuthoritativeDnsServerCache redirectAuthoritativeDnsServerCache(AuthoritativeDnsServerCache paramAuthoritativeDnsServerCache)
  {
    if ((paramAuthoritativeDnsServerCache instanceof RedirectAuthoritativeDnsServerCache)) {
      return paramAuthoritativeDnsServerCache;
    }
    return new RedirectAuthoritativeDnsServerCache(paramAuthoritativeDnsServerCache);
  }
  
  private void tryToFinishResolve(DnsServerAddressStream paramDnsServerAddressStream, int paramInt, DnsQuestion paramDnsQuestion, DnsQueryLifecycleObserver paramDnsQueryLifecycleObserver, Promise<List<T>> paramPromise, Throwable paramThrowable)
  {
    if ((!this.completeEarly) && (!this.queriesInProgress.isEmpty()))
    {
      paramDnsQueryLifecycleObserver.queryCancelled(this.allowedQueries);
      return;
    }
    if (this.finalResult == null)
    {
      if (paramInt < paramDnsServerAddressStream.size())
      {
        if (paramDnsQueryLifecycleObserver == NoopDnsQueryLifecycleObserver.INSTANCE) {
          query(paramDnsServerAddressStream, 1 + paramInt, paramDnsQuestion, newDnsQueryLifecycleObserver(paramDnsQuestion), true, paramPromise, paramThrowable);
        } else {
          query(paramDnsServerAddressStream, 1 + paramInt, paramDnsQuestion, paramDnsQueryLifecycleObserver, true, paramPromise, paramThrowable);
        }
        return;
      }
      paramDnsQueryLifecycleObserver.queryFailed(NAME_SERVERS_EXHAUSTED_EXCEPTION);
      if ((paramThrowable == null) && (!this.triedCNAME))
      {
        this.triedCNAME = true;
        paramDnsServerAddressStream = this.hostname;
        query(paramDnsServerAddressStream, DnsRecordType.CNAME, getNameServers(paramDnsServerAddressStream), true, paramPromise);
      }
    }
    else
    {
      paramDnsQueryLifecycleObserver.queryCancelled(this.allowedQueries);
    }
    finishResolve(paramPromise, paramThrowable);
  }
  
  AuthoritativeDnsServerCache authoritativeDnsServerCache()
  {
    return this.parent.authoritativeDnsServerCache();
  }
  
  abstract void cache(String paramString, DnsRecord[] paramArrayOfDnsRecord, DnsRecord paramDnsRecord, T paramT);
  
  abstract void cache(String paramString, DnsRecord[] paramArrayOfDnsRecord, UnknownHostException paramUnknownHostException);
  
  DnsCnameCache cnameCache()
  {
    return this.parent.cnameCache();
  }
  
  abstract T convertRecord(DnsRecord paramDnsRecord, String paramString, DnsRecord[] paramArrayOfDnsRecord, EventLoop paramEventLoop);
  
  void doSearchDomainQuery(String paramString, Promise<List<T>> paramPromise)
  {
    newResolverContext(this.parent, this.originalPromise, paramString, this.dnsClass, this.expectedTypes, this.additionals, this.nameServerAddrs).internalResolve(paramString, paramPromise);
  }
  
  abstract List<T> filterResults(List<T> paramList);
  
  abstract boolean isCompleteEarly(T paramT);
  
  abstract boolean isDuplicateAllowed();
  
  abstract DnsResolveContext<T> newResolverContext(DnsNameResolver paramDnsNameResolver, Promise<?> paramPromise, String paramString, int paramInt, DnsRecordType[] paramArrayOfDnsRecordType, DnsRecord[] paramArrayOfDnsRecord, DnsServerAddressStream paramDnsServerAddressStream);
  
  void resolve(final Promise<List<T>> paramPromise)
  {
    final String[] arrayOfString = this.parent.searchDomains();
    if ((arrayOfString.length != 0) && (this.parent.ndots() != 0) && (!StringUtil.endsWith(this.hostname, '.')))
    {
      final boolean bool = hasNDots();
      Object localObject;
      if (bool)
      {
        localObject = this.hostname;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.hostname);
        ((StringBuilder)localObject).append('.');
        ((StringBuilder)localObject).append(arrayOfString[0]);
        localObject = ((StringBuilder)localObject).toString();
      }
      Promise localPromise = this.parent.executor().newPromise();
      localPromise.addListener(new a()
      {
        private int searchDomainIdx;
        
        public void operationComplete(io.netty.util.concurrent.Future<List<T>> paramAnonymousFuture)
        {
          Object localObject = paramAnonymousFuture.cause();
          if (localObject == null)
          {
            paramPromise.trySuccess(paramAnonymousFuture.getNow());
          }
          else if (DnsNameResolver.isTransportOrTimeoutError((Throwable)localObject))
          {
            paramPromise.tryFailure(new DnsResolveContext.SearchDomainUnknownHostException((Throwable)localObject, DnsResolveContext.this.hostname));
          }
          else if (this.searchDomainIdx < arrayOfString.length)
          {
            Promise localPromise = DnsResolveContext.this.parent.executor().newPromise();
            localPromise.addListener(this);
            DnsResolveContext localDnsResolveContext = DnsResolveContext.this;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(DnsResolveContext.this.hostname);
            ((StringBuilder)localObject).append('.');
            paramAnonymousFuture = arrayOfString;
            int i = this.searchDomainIdx;
            this.searchDomainIdx = (i + 1);
            ((StringBuilder)localObject).append(paramAnonymousFuture[i]);
            localDnsResolveContext.doSearchDomainQuery(((StringBuilder)localObject).toString(), localPromise);
          }
          else if (!bool)
          {
            paramAnonymousFuture = DnsResolveContext.this;
            paramAnonymousFuture.internalResolve(paramAnonymousFuture.hostname, paramPromise);
          }
          else
          {
            paramPromise.tryFailure(new DnsResolveContext.SearchDomainUnknownHostException((Throwable)localObject, DnsResolveContext.this.hostname));
          }
        }
      });
      doSearchDomainQuery((String)localObject, localPromise);
    }
    else
    {
      internalResolve(this.hostname, paramPromise);
    }
  }
  
  DnsCache resolveCache()
  {
    return this.parent.resolveCache();
  }
  
  private static final class AuthoritativeNameServer
  {
    private InetSocketAddress address;
    private final String domainName;
    private final int dots;
    final boolean isCopy;
    AuthoritativeNameServer next;
    final String nsName;
    private long ttl;
    
    AuthoritativeNameServer(int paramInt, long paramLong, String paramString1, String paramString2)
    {
      this.dots = paramInt;
      this.ttl = paramLong;
      this.nsName = paramString2;
      this.domainName = paramString1;
      this.isCopy = false;
    }
    
    AuthoritativeNameServer(AuthoritativeNameServer paramAuthoritativeNameServer)
    {
      this.dots = paramAuthoritativeNameServer.dots;
      this.ttl = paramAuthoritativeNameServer.ttl;
      this.nsName = paramAuthoritativeNameServer.nsName;
      this.domainName = paramAuthoritativeNameServer.domainName;
      this.isCopy = true;
    }
    
    boolean isRootServer()
    {
      int i = this.dots;
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      return bool;
    }
    
    void update(InetSocketAddress paramInetSocketAddress)
    {
      update(paramInetSocketAddress, Long.MAX_VALUE);
    }
    
    void update(InetSocketAddress paramInetSocketAddress, long paramLong)
    {
      this.address = paramInetSocketAddress;
      this.ttl = Math.min(this.ttl, paramLong);
    }
  }
  
  private static final class AuthoritativeNameServerList
  {
    private DnsResolveContext.AuthoritativeNameServer head;
    private int nameServerCount;
    private final String questionName;
    
    AuthoritativeNameServerList(String paramString)
    {
      this.questionName = paramString.toLowerCase(Locale.US);
    }
    
    private static void cache(DnsResolveContext.AuthoritativeNameServer paramAuthoritativeNameServer, AuthoritativeDnsServerCache paramAuthoritativeDnsServerCache, EventLoop paramEventLoop)
    {
      if (!paramAuthoritativeNameServer.isRootServer()) {
        paramAuthoritativeDnsServerCache.cache(paramAuthoritativeNameServer.domainName, paramAuthoritativeNameServer.address, paramAuthoritativeNameServer.ttl, paramEventLoop);
      }
    }
    
    private static void cacheUnresolved(DnsResolveContext.AuthoritativeNameServer paramAuthoritativeNameServer, AuthoritativeDnsServerCache paramAuthoritativeDnsServerCache, EventLoop paramEventLoop)
    {
      DnsResolveContext.AuthoritativeNameServer.access$1002(paramAuthoritativeNameServer, InetSocketAddress.createUnresolved(paramAuthoritativeNameServer.nsName, 53));
      cache(paramAuthoritativeNameServer, paramAuthoritativeDnsServerCache, paramEventLoop);
    }
    
    void add(DnsRecord paramDnsRecord)
    {
      if ((paramDnsRecord.type() == DnsRecordType.NS) && ((paramDnsRecord instanceof DnsRawRecord)))
      {
        if (this.questionName.length() < paramDnsRecord.name().length()) {
          return;
        }
        String str1 = paramDnsRecord.name().toLowerCase(Locale.US);
        int i = str1.length() - 1;
        int j = this.questionName.length() - 1;
        int n;
        for (int k = 0; i >= 0; k = n)
        {
          int m = str1.charAt(i);
          if (this.questionName.charAt(j) != m) {
            return;
          }
          n = k;
          if (m == 46) {
            n = k + 1;
          }
          i--;
          j--;
        }
        Object localObject = this.head;
        if ((localObject != null) && (((DnsResolveContext.AuthoritativeNameServer)localObject).dots > k)) {
          return;
        }
        String str2 = DnsResolveContext.decodeDomainName(((ByteBufHolder)paramDnsRecord).content());
        if (str2 == null) {
          return;
        }
        localObject = this.head;
        if ((localObject != null) && (((DnsResolveContext.AuthoritativeNameServer)localObject).dots >= k))
        {
          if (this.head.dots == k)
          {
            DnsResolveContext.AuthoritativeNameServer localAuthoritativeNameServer;
            for (localObject = this.head;; localObject = localAuthoritativeNameServer)
            {
              localAuthoritativeNameServer = ((DnsResolveContext.AuthoritativeNameServer)localObject).next;
              if (localAuthoritativeNameServer == null) {
                break;
              }
            }
            ((DnsResolveContext.AuthoritativeNameServer)localObject).next = new DnsResolveContext.AuthoritativeNameServer(k, paramDnsRecord.timeToLive(), str1, str2);
            this.nameServerCount += 1;
          }
        }
        else
        {
          this.nameServerCount = 1;
          this.head = new DnsResolveContext.AuthoritativeNameServer(k, paramDnsRecord.timeToLive(), str1, str2);
        }
      }
    }
    
    List<InetSocketAddress> addressList()
    {
      ArrayList localArrayList = new ArrayList(this.nameServerCount);
      for (DnsResolveContext.AuthoritativeNameServer localAuthoritativeNameServer = this.head; localAuthoritativeNameServer != null; localAuthoritativeNameServer = localAuthoritativeNameServer.next) {
        if (localAuthoritativeNameServer.address != null) {
          localArrayList.add(localAuthoritativeNameServer.address);
        }
      }
      return localArrayList;
    }
    
    void handleWithAdditional(DnsNameResolver paramDnsNameResolver, DnsRecord paramDnsRecord, AuthoritativeDnsServerCache paramAuthoritativeDnsServerCache)
    {
      Object localObject1 = this.head;
      Object localObject2 = paramDnsRecord.name();
      InetAddress localInetAddress = DnsAddressDecoder.decodeAddress(paramDnsRecord, (String)localObject2, paramDnsNameResolver.isDecodeIdn());
      if (localInetAddress == null) {
        return;
      }
      while (localObject1 != null)
      {
        if (((DnsResolveContext.AuthoritativeNameServer)localObject1).nsName.equalsIgnoreCase((String)localObject2))
        {
          localObject2 = localObject1;
          if (((DnsResolveContext.AuthoritativeNameServer)localObject1).address != null)
          {
            for (;;)
            {
              localObject2 = ((DnsResolveContext.AuthoritativeNameServer)localObject1).next;
              if ((localObject2 == null) || (!((DnsResolveContext.AuthoritativeNameServer)localObject2).isCopy)) {
                break;
              }
              localObject1 = localObject2;
            }
            localObject2 = new DnsResolveContext.AuthoritativeNameServer((DnsResolveContext.AuthoritativeNameServer)localObject1);
            ((DnsResolveContext.AuthoritativeNameServer)localObject2).next = ((DnsResolveContext.AuthoritativeNameServer)localObject1).next;
            ((DnsResolveContext.AuthoritativeNameServer)localObject1).next = ((DnsResolveContext.AuthoritativeNameServer)localObject2);
            this.nameServerCount += 1;
          }
          ((DnsResolveContext.AuthoritativeNameServer)localObject2).update(paramDnsNameResolver.newRedirectServerAddress(localInetAddress), paramDnsRecord.timeToLive());
          cache((DnsResolveContext.AuthoritativeNameServer)localObject2, paramAuthoritativeDnsServerCache, paramDnsNameResolver.executor());
          return;
        }
        localObject1 = ((DnsResolveContext.AuthoritativeNameServer)localObject1).next;
      }
    }
    
    void handleWithoutAdditionals(DnsNameResolver paramDnsNameResolver, DnsCache paramDnsCache, AuthoritativeDnsServerCache paramAuthoritativeDnsServerCache)
    {
      Object localObject2;
      for (Object localObject1 = this.head; localObject1 != null; localObject1 = ((DnsResolveContext.AuthoritativeNameServer)localObject2).next)
      {
        localObject2 = localObject1;
        if (((DnsResolveContext.AuthoritativeNameServer)localObject1).address == null)
        {
          cacheUnresolved((DnsResolveContext.AuthoritativeNameServer)localObject1, paramAuthoritativeDnsServerCache, paramDnsNameResolver.executor());
          List localList = paramDnsCache.get(((DnsResolveContext.AuthoritativeNameServer)localObject1).nsName, null);
          localObject2 = localObject1;
          if (localList != null)
          {
            localObject2 = localObject1;
            if (!localList.isEmpty())
            {
              InetAddress localInetAddress = ((DnsCacheEntry)localList.get(0)).address();
              localObject2 = localObject1;
              if (localInetAddress != null)
              {
                ((DnsResolveContext.AuthoritativeNameServer)localObject1).update(paramDnsNameResolver.newRedirectServerAddress(localInetAddress));
                int i = 1;
                for (;;)
                {
                  localObject2 = localObject1;
                  if (i >= localList.size()) {
                    break;
                  }
                  localInetAddress = ((DnsCacheEntry)localList.get(i)).address();
                  localObject2 = new DnsResolveContext.AuthoritativeNameServer((DnsResolveContext.AuthoritativeNameServer)localObject1);
                  ((DnsResolveContext.AuthoritativeNameServer)localObject2).next = ((DnsResolveContext.AuthoritativeNameServer)localObject1).next;
                  ((DnsResolveContext.AuthoritativeNameServer)localObject1).next = ((DnsResolveContext.AuthoritativeNameServer)localObject2);
                  ((DnsResolveContext.AuthoritativeNameServer)localObject2).update(paramDnsNameResolver.newRedirectServerAddress(localInetAddress));
                  this.nameServerCount += 1;
                  i++;
                  localObject1 = localObject2;
                }
              }
            }
          }
        }
      }
    }
    
    boolean isEmpty()
    {
      boolean bool;
      if (this.nameServerCount == 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  private final class CombinedDnsServerAddressStream
    implements DnsServerAddressStream
  {
    private final DnsServerAddressStream originalStream;
    private final InetSocketAddress replaced;
    private Iterator<InetAddress> resolved;
    private final List<InetAddress> resolvedAddresses;
    
    CombinedDnsServerAddressStream(List<InetAddress> paramList, DnsServerAddressStream paramDnsServerAddressStream)
    {
      this.replaced = paramList;
      this.resolvedAddresses = paramDnsServerAddressStream;
      DnsServerAddressStream localDnsServerAddressStream;
      this.originalStream = localDnsServerAddressStream;
      this.resolved = paramDnsServerAddressStream.iterator();
    }
    
    private InetSocketAddress nextResolved0()
    {
      return DnsResolveContext.this.parent.newRedirectServerAddress((InetAddress)this.resolved.next());
    }
    
    public DnsServerAddressStream duplicate()
    {
      return new CombinedDnsServerAddressStream(DnsResolveContext.this, this.replaced, this.resolvedAddresses, this.originalStream.duplicate());
    }
    
    public InetSocketAddress next()
    {
      if (this.resolved.hasNext()) {
        return nextResolved0();
      }
      InetSocketAddress localInetSocketAddress1 = this.originalStream.next();
      InetSocketAddress localInetSocketAddress2 = localInetSocketAddress1;
      if (localInetSocketAddress1.equals(this.replaced))
      {
        this.resolved = this.resolvedAddresses.iterator();
        localInetSocketAddress2 = nextResolved0();
      }
      return localInetSocketAddress2;
    }
    
    public int size()
    {
      return this.originalStream.size() + this.resolvedAddresses.size() - 1;
    }
  }
  
  private static final class DnsAddressStreamList
    extends AbstractList<InetSocketAddress>
  {
    private List<InetSocketAddress> addresses;
    private final DnsServerAddressStream duplicate;
    
    DnsAddressStreamList(DnsServerAddressStream paramDnsServerAddressStream)
    {
      this.duplicate = paramDnsServerAddressStream.duplicate();
    }
    
    public InetSocketAddress get(int paramInt)
    {
      if (this.addresses == null)
      {
        DnsServerAddressStream localDnsServerAddressStream = this.duplicate.duplicate();
        this.addresses = new ArrayList(size());
        for (int i = 0; i < localDnsServerAddressStream.size(); i++) {
          this.addresses.add(localDnsServerAddressStream.next());
        }
      }
      return (InetSocketAddress)this.addresses.get(paramInt);
    }
    
    public Iterator<InetSocketAddress> iterator()
    {
      new Iterator()
      {
        private int i;
        private final DnsServerAddressStream stream = DnsResolveContext.DnsAddressStreamList.this.duplicate.duplicate();
        
        public boolean hasNext()
        {
          boolean bool;
          if (this.i < this.stream.size()) {
            bool = true;
          } else {
            bool = false;
          }
          return bool;
        }
        
        public InetSocketAddress next()
        {
          if (hasNext())
          {
            this.i += 1;
            return this.stream.next();
          }
          throw new NoSuchElementException();
        }
        
        public void remove()
        {
          throw new UnsupportedOperationException();
        }
      };
    }
    
    public int size()
    {
      return this.duplicate.size();
    }
  }
  
  static final class DnsResolveContextException
    extends RuntimeException
  {
    private DnsResolveContextException(String paramString)
    {
      super();
    }
    
    @SuppressJava6Requirement(reason="uses Java 7+ Exception.<init>(String, Throwable, boolean, boolean) but is guarded by version checks")
    private DnsResolveContextException(String paramString, boolean paramBoolean)
    {
      super(null, false, true);
    }
    
    static DnsResolveContextException newStatic(String paramString)
    {
      if (PlatformDependent.javaVersion() >= 7) {
        return new DnsResolveContextException(paramString, true);
      }
      return new DnsResolveContextException(paramString);
    }
  }
  
  private static final class RedirectAuthoritativeDnsServerCache
    implements AuthoritativeDnsServerCache
  {
    private final AuthoritativeDnsServerCache wrapped;
    
    RedirectAuthoritativeDnsServerCache(AuthoritativeDnsServerCache paramAuthoritativeDnsServerCache)
    {
      this.wrapped = paramAuthoritativeDnsServerCache;
    }
    
    public void cache(String paramString, InetSocketAddress paramInetSocketAddress, long paramLong, EventLoop paramEventLoop)
    {
      this.wrapped.cache(paramString, paramInetSocketAddress, paramLong, paramEventLoop);
    }
    
    public void clear()
    {
      this.wrapped.clear();
    }
    
    public boolean clear(String paramString)
    {
      return this.wrapped.clear(paramString);
    }
    
    public DnsServerAddressStream get(String paramString)
    {
      return null;
    }
  }
  
  private static final class SearchDomainUnknownHostException
    extends UnknownHostException
  {
    private static final long serialVersionUID = -8573510133644997085L;
    
    SearchDomainUnknownHostException(Throwable paramThrowable, String paramString)
    {
      super();
      setStackTrace(paramThrowable.getStackTrace());
      initCause(paramThrowable.getCause());
    }
    
    public Throwable fillInStackTrace()
    {
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\DnsResolveContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */