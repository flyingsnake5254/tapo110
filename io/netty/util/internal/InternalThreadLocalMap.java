package io.netty.util.internal;

import io.netty.util.concurrent.FastThreadLocalThread;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class InternalThreadLocalMap
  extends UnpaddedInternalThreadLocalMap
{
  private static final int DEFAULT_ARRAY_LIST_INITIAL_CAPACITY = 8;
  private static final int HANDLER_SHARABLE_CACHE_INITIAL_CAPACITY = 4;
  private static final int INDEXED_VARIABLE_TABLE_INITIAL_SIZE = 32;
  private static final int STRING_BUILDER_INITIAL_SIZE;
  private static final int STRING_BUILDER_MAX_SIZE;
  public static final Object UNSET;
  private static final InternalLogger logger;
  private BitSet cleanerFlags;
  public long rp1;
  public long rp2;
  public long rp3;
  public long rp4;
  public long rp5;
  public long rp6;
  public long rp7;
  public long rp8;
  public long rp9;
  
  static
  {
    InternalLogger localInternalLogger = InternalLoggerFactory.getInstance(InternalThreadLocalMap.class);
    logger = localInternalLogger;
    UNSET = new Object();
    int i = SystemPropertyUtil.getInt("io.netty.threadLocalMap.stringBuilder.initialSize", 1024);
    STRING_BUILDER_INITIAL_SIZE = i;
    localInternalLogger.debug("-Dio.netty.threadLocalMap.stringBuilder.initialSize: {}", Integer.valueOf(i));
    i = SystemPropertyUtil.getInt("io.netty.threadLocalMap.stringBuilder.maxSize", 4096);
    STRING_BUILDER_MAX_SIZE = i;
    localInternalLogger.debug("-Dio.netty.threadLocalMap.stringBuilder.maxSize: {}", Integer.valueOf(i));
  }
  
  private InternalThreadLocalMap()
  {
    super(newIndexedVariableTable());
  }
  
  public static void destroy()
  {
    UnpaddedInternalThreadLocalMap.slowThreadLocalMap.remove();
  }
  
  private void expandIndexedVariableTableAndSet(int paramInt, Object paramObject)
  {
    Object[] arrayOfObject = this.indexedVariables;
    int i = arrayOfObject.length;
    int j = paramInt >>> 1 | paramInt;
    j |= j >>> 2;
    j |= j >>> 4;
    j |= j >>> 8;
    arrayOfObject = Arrays.copyOf(arrayOfObject, (j | j >>> 16) + 1);
    Arrays.fill(arrayOfObject, i, arrayOfObject.length, UNSET);
    arrayOfObject[paramInt] = paramObject;
    this.indexedVariables = arrayOfObject;
  }
  
  private static InternalThreadLocalMap fastGet(FastThreadLocalThread paramFastThreadLocalThread)
  {
    InternalThreadLocalMap localInternalThreadLocalMap1 = paramFastThreadLocalThread.threadLocalMap();
    InternalThreadLocalMap localInternalThreadLocalMap2 = localInternalThreadLocalMap1;
    if (localInternalThreadLocalMap1 == null)
    {
      localInternalThreadLocalMap2 = new InternalThreadLocalMap();
      paramFastThreadLocalThread.setThreadLocalMap(localInternalThreadLocalMap2);
    }
    return localInternalThreadLocalMap2;
  }
  
  public static InternalThreadLocalMap get()
  {
    Thread localThread = Thread.currentThread();
    if ((localThread instanceof FastThreadLocalThread)) {
      return fastGet((FastThreadLocalThread)localThread);
    }
    return slowGet();
  }
  
  public static InternalThreadLocalMap getIfSet()
  {
    Thread localThread = Thread.currentThread();
    if ((localThread instanceof FastThreadLocalThread)) {
      return ((FastThreadLocalThread)localThread).threadLocalMap();
    }
    return (InternalThreadLocalMap)UnpaddedInternalThreadLocalMap.slowThreadLocalMap.get();
  }
  
  public static int lastVariableIndex()
  {
    return UnpaddedInternalThreadLocalMap.nextIndex.get() - 1;
  }
  
  private static Object[] newIndexedVariableTable()
  {
    Object[] arrayOfObject = new Object[32];
    Arrays.fill(arrayOfObject, UNSET);
    return arrayOfObject;
  }
  
  public static int nextVariableIndex()
  {
    AtomicInteger localAtomicInteger = UnpaddedInternalThreadLocalMap.nextIndex;
    int i = localAtomicInteger.getAndIncrement();
    if (i >= 0) {
      return i;
    }
    localAtomicInteger.decrementAndGet();
    throw new IllegalStateException("too many thread-local indexed variables");
  }
  
  public static void remove()
  {
    Thread localThread = Thread.currentThread();
    if ((localThread instanceof FastThreadLocalThread)) {
      ((FastThreadLocalThread)localThread).setThreadLocalMap(null);
    } else {
      UnpaddedInternalThreadLocalMap.slowThreadLocalMap.remove();
    }
  }
  
  private static InternalThreadLocalMap slowGet()
  {
    ThreadLocal localThreadLocal = UnpaddedInternalThreadLocalMap.slowThreadLocalMap;
    InternalThreadLocalMap localInternalThreadLocalMap1 = (InternalThreadLocalMap)localThreadLocal.get();
    InternalThreadLocalMap localInternalThreadLocalMap2 = localInternalThreadLocalMap1;
    if (localInternalThreadLocalMap1 == null)
    {
      localInternalThreadLocalMap2 = new InternalThreadLocalMap();
      localThreadLocal.set(localInternalThreadLocalMap2);
    }
    return localInternalThreadLocalMap2;
  }
  
  public <E> ArrayList<E> arrayList()
  {
    return arrayList(8);
  }
  
  public <E> ArrayList<E> arrayList(int paramInt)
  {
    ArrayList localArrayList = this.arrayList;
    if (localArrayList == null)
    {
      localArrayList = new ArrayList(paramInt);
      this.arrayList = localArrayList;
      return localArrayList;
    }
    localArrayList.clear();
    localArrayList.ensureCapacity(paramInt);
    return localArrayList;
  }
  
  public Map<Charset, CharsetDecoder> charsetDecoderCache()
  {
    Map localMap = this.charsetDecoderCache;
    Object localObject = localMap;
    if (localMap == null)
    {
      localObject = new IdentityHashMap();
      this.charsetDecoderCache = ((Map)localObject);
    }
    return (Map<Charset, CharsetDecoder>)localObject;
  }
  
  public Map<Charset, CharsetEncoder> charsetEncoderCache()
  {
    Map localMap = this.charsetEncoderCache;
    Object localObject = localMap;
    if (localMap == null)
    {
      localObject = new IdentityHashMap();
      this.charsetEncoderCache = ((Map)localObject);
    }
    return (Map<Charset, CharsetEncoder>)localObject;
  }
  
  @Deprecated
  public IntegerHolder counterHashCode()
  {
    return this.counterHashCode;
  }
  
  public int futureListenerStackDepth()
  {
    return this.futureListenerStackDepth;
  }
  
  public Map<Class<?>, Boolean> handlerSharableCache()
  {
    Map localMap = this.handlerSharableCache;
    Object localObject = localMap;
    if (localMap == null)
    {
      localObject = new WeakHashMap(4);
      this.handlerSharableCache = ((Map)localObject);
    }
    return (Map<Class<?>, Boolean>)localObject;
  }
  
  public Object indexedVariable(int paramInt)
  {
    Object localObject = this.indexedVariables;
    if (paramInt < localObject.length) {
      localObject = localObject[paramInt];
    } else {
      localObject = UNSET;
    }
    return localObject;
  }
  
  public boolean isCleanerFlagSet(int paramInt)
  {
    BitSet localBitSet = this.cleanerFlags;
    boolean bool;
    if ((localBitSet != null) && (localBitSet.get(paramInt))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isIndexedVariableSet(int paramInt)
  {
    Object[] arrayOfObject = this.indexedVariables;
    boolean bool;
    if ((paramInt < arrayOfObject.length) && (arrayOfObject[paramInt] != UNSET)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int localChannelReaderStackDepth()
  {
    return this.localChannelReaderStackDepth;
  }
  
  public ThreadLocalRandom random()
  {
    ThreadLocalRandom localThreadLocalRandom1 = this.random;
    ThreadLocalRandom localThreadLocalRandom2 = localThreadLocalRandom1;
    if (localThreadLocalRandom1 == null)
    {
      localThreadLocalRandom2 = new ThreadLocalRandom();
      this.random = localThreadLocalRandom2;
    }
    return localThreadLocalRandom2;
  }
  
  public Object removeIndexedVariable(int paramInt)
  {
    Object[] arrayOfObject = this.indexedVariables;
    if (paramInt < arrayOfObject.length)
    {
      Object localObject = arrayOfObject[paramInt];
      arrayOfObject[paramInt] = UNSET;
      return localObject;
    }
    return UNSET;
  }
  
  public void setCleanerFlag(int paramInt)
  {
    if (this.cleanerFlags == null) {
      this.cleanerFlags = new BitSet();
    }
    this.cleanerFlags.set(paramInt);
  }
  
  @Deprecated
  public void setCounterHashCode(IntegerHolder paramIntegerHolder)
  {
    this.counterHashCode = paramIntegerHolder;
  }
  
  public void setFutureListenerStackDepth(int paramInt)
  {
    this.futureListenerStackDepth = paramInt;
  }
  
  public boolean setIndexedVariable(int paramInt, Object paramObject)
  {
    Object[] arrayOfObject = this.indexedVariables;
    int i = arrayOfObject.length;
    boolean bool = true;
    if (paramInt < i)
    {
      Object localObject = arrayOfObject[paramInt];
      arrayOfObject[paramInt] = paramObject;
      if (localObject != UNSET) {
        bool = false;
      }
      return bool;
    }
    expandIndexedVariableTableAndSet(paramInt, paramObject);
    return true;
  }
  
  public void setLocalChannelReaderStackDepth(int paramInt)
  {
    this.localChannelReaderStackDepth = paramInt;
  }
  
  public int size()
  {
    int i = this.futureListenerStackDepth;
    int j = 0;
    if (i != 0) {
      k = 1;
    } else {
      k = 0;
    }
    i = k;
    if (this.localChannelReaderStackDepth != 0) {
      i = k + 1;
    }
    int k = i;
    if (this.handlerSharableCache != null) {
      k = i + 1;
    }
    i = k;
    if (this.counterHashCode != null) {
      i = k + 1;
    }
    int m = i;
    if (this.random != null) {
      m = i + 1;
    }
    k = m;
    if (this.typeParameterMatcherGetCache != null) {
      k = m + 1;
    }
    i = k;
    if (this.typeParameterMatcherFindCache != null) {
      i = k + 1;
    }
    k = i;
    if (this.stringBuilder != null) {
      k = i + 1;
    }
    i = k;
    if (this.charsetEncoderCache != null) {
      i = k + 1;
    }
    k = i;
    if (this.charsetDecoderCache != null) {
      k = i + 1;
    }
    i = k;
    if (this.arrayList != null) {
      i = k + 1;
    }
    Object[] arrayOfObject = this.indexedVariables;
    int n = arrayOfObject.length;
    k = j;
    for (m = i; k < n; m = i)
    {
      i = m;
      if (arrayOfObject[k] != UNSET) {
        i = m + 1;
      }
      k++;
    }
    return m - 1;
  }
  
  public StringBuilder stringBuilder()
  {
    StringBuilder localStringBuilder = this.stringBuilder;
    if (localStringBuilder == null)
    {
      localStringBuilder = new StringBuilder(STRING_BUILDER_INITIAL_SIZE);
      this.stringBuilder = localStringBuilder;
      return localStringBuilder;
    }
    if (localStringBuilder.capacity() > STRING_BUILDER_MAX_SIZE)
    {
      localStringBuilder.setLength(STRING_BUILDER_INITIAL_SIZE);
      localStringBuilder.trimToSize();
    }
    localStringBuilder.setLength(0);
    return localStringBuilder;
  }
  
  public Map<Class<?>, Map<String, TypeParameterMatcher>> typeParameterMatcherFindCache()
  {
    Map localMap = this.typeParameterMatcherFindCache;
    Object localObject = localMap;
    if (localMap == null)
    {
      localObject = new IdentityHashMap();
      this.typeParameterMatcherFindCache = ((Map)localObject);
    }
    return (Map<Class<?>, Map<String, TypeParameterMatcher>>)localObject;
  }
  
  public Map<Class<?>, TypeParameterMatcher> typeParameterMatcherGetCache()
  {
    Map localMap = this.typeParameterMatcherGetCache;
    Object localObject = localMap;
    if (localMap == null)
    {
      localObject = new IdentityHashMap();
      this.typeParameterMatcherGetCache = ((Map)localObject);
    }
    return (Map<Class<?>, TypeParameterMatcher>)localObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\InternalThreadLocalMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */