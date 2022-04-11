package io.netty.buffer;

import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.concurrent.FastThreadLocalThread;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.ThreadExecutorMap;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class PooledByteBufAllocator
  extends AbstractByteBufAllocator
  implements ByteBufAllocatorMetricProvider
{
  public static final PooledByteBufAllocator DEFAULT = new PooledByteBufAllocator(PlatformDependent.directBufferPreferred());
  private static final int DEFAULT_CACHE_TRIM_INTERVAL;
  private static final long DEFAULT_CACHE_TRIM_INTERVAL_MILLIS;
  private static final int DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT;
  private static final int DEFAULT_MAX_CACHED_BUFFER_CAPACITY;
  static final int DEFAULT_MAX_CACHED_BYTEBUFFERS_PER_CHUNK;
  private static final int DEFAULT_MAX_ORDER;
  private static final int DEFAULT_NORMAL_CACHE_SIZE;
  private static final int DEFAULT_NUM_DIRECT_ARENA;
  private static final int DEFAULT_NUM_HEAP_ARENA;
  private static final int DEFAULT_PAGE_SIZE;
  private static final int DEFAULT_SMALL_CACHE_SIZE;
  private static final int DEFAULT_TINY_CACHE_SIZE;
  private static final boolean DEFAULT_USE_CACHE_FOR_ALL_THREADS;
  private static final int MAX_CHUNK_SIZE = 1073741824;
  private static final int MIN_PAGE_SIZE = 4096;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(PooledByteBufAllocator.class);
  private final int chunkSize;
  private final List<PoolArenaMetric> directArenaMetrics;
  private final PoolArena<ByteBuffer>[] directArenas;
  private final List<PoolArenaMetric> heapArenaMetrics;
  private final PoolArena<byte[]>[] heapArenas;
  private final PooledByteBufAllocatorMetric metric;
  private final int normalCacheSize;
  private final int smallCacheSize;
  private final PoolThreadLocalCache threadCache;
  private final int tinyCacheSize;
  private final Runnable trimTask = new Runnable()
  {
    public void run()
    {
      PooledByteBufAllocator.this.trimCurrentThreadCache();
    }
  };
  
  /* Error */
  static
  {
    // Byte code:
    //   0: ldc 2
    //   2: invokestatic 64	io/netty/util/internal/logging/InternalLoggerFactory:getInstance	(Ljava/lang/Class;)Lio/netty/util/internal/logging/InternalLogger;
    //   5: putstatic 66	io/netty/buffer/PooledByteBufAllocator:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   8: ldc 68
    //   10: sipush 8192
    //   13: invokestatic 74	io/netty/util/internal/SystemPropertyUtil:getInt	(Ljava/lang/String;I)I
    //   16: istore_0
    //   17: aconst_null
    //   18: astore_1
    //   19: iload_0
    //   20: invokestatic 78	io/netty/buffer/PooledByteBufAllocator:validateAndCalculatePageShifts	(I)I
    //   23: pop
    //   24: aconst_null
    //   25: astore_2
    //   26: goto +8 -> 34
    //   29: astore_2
    //   30: sipush 8192
    //   33: istore_0
    //   34: iload_0
    //   35: putstatic 80	io/netty/buffer/PooledByteBufAllocator:DEFAULT_PAGE_SIZE	I
    //   38: bipush 11
    //   40: istore_3
    //   41: ldc 82
    //   43: bipush 11
    //   45: invokestatic 74	io/netty/util/internal/SystemPropertyUtil:getInt	(Ljava/lang/String;I)I
    //   48: istore 4
    //   50: iload_0
    //   51: iload 4
    //   53: invokestatic 86	io/netty/buffer/PooledByteBufAllocator:validateAndCalculateChunkSize	(II)I
    //   56: pop
    //   57: iload 4
    //   59: istore_0
    //   60: goto +6 -> 66
    //   63: astore_1
    //   64: iload_3
    //   65: istore_0
    //   66: iload_0
    //   67: putstatic 88	io/netty/buffer/PooledByteBufAllocator:DEFAULT_MAX_ORDER	I
    //   70: invokestatic 94	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   73: astore 5
    //   75: invokestatic 100	io/netty/util/NettyRuntime:availableProcessors	()I
    //   78: istore_3
    //   79: getstatic 80	io/netty/buffer/PooledByteBufAllocator:DEFAULT_PAGE_SIZE	I
    //   82: istore 4
    //   84: iload_3
    //   85: iconst_2
    //   86: imul
    //   87: i2l
    //   88: lstore 6
    //   90: aload 5
    //   92: invokevirtual 104	java/lang/Runtime:maxMemory	()J
    //   95: lstore 8
    //   97: iload 4
    //   99: iload_0
    //   100: ishl
    //   101: i2l
    //   102: lstore 10
    //   104: iconst_0
    //   105: ldc 106
    //   107: lload 6
    //   109: lload 8
    //   111: lload 10
    //   113: ldiv
    //   114: ldc2_w 107
    //   117: ldiv
    //   118: ldc2_w 109
    //   121: ldiv
    //   122: invokestatic 116	java/lang/Math:min	(JJ)J
    //   125: l2i
    //   126: invokestatic 74	io/netty/util/internal/SystemPropertyUtil:getInt	(Ljava/lang/String;I)I
    //   129: invokestatic 119	java/lang/Math:max	(II)I
    //   132: istore 12
    //   134: iload 12
    //   136: putstatic 121	io/netty/buffer/PooledByteBufAllocator:DEFAULT_NUM_HEAP_ARENA	I
    //   139: iconst_0
    //   140: ldc 123
    //   142: lload 6
    //   144: invokestatic 128	io/netty/util/internal/PlatformDependent:maxDirectMemory	()J
    //   147: lload 10
    //   149: ldiv
    //   150: ldc2_w 107
    //   153: ldiv
    //   154: ldc2_w 109
    //   157: ldiv
    //   158: invokestatic 116	java/lang/Math:min	(JJ)J
    //   161: l2i
    //   162: invokestatic 74	io/netty/util/internal/SystemPropertyUtil:getInt	(Ljava/lang/String;I)I
    //   165: invokestatic 119	java/lang/Math:max	(II)I
    //   168: istore 13
    //   170: iload 13
    //   172: putstatic 130	io/netty/buffer/PooledByteBufAllocator:DEFAULT_NUM_DIRECT_ARENA	I
    //   175: ldc -124
    //   177: sipush 512
    //   180: invokestatic 74	io/netty/util/internal/SystemPropertyUtil:getInt	(Ljava/lang/String;I)I
    //   183: istore 14
    //   185: iload 14
    //   187: putstatic 134	io/netty/buffer/PooledByteBufAllocator:DEFAULT_TINY_CACHE_SIZE	I
    //   190: ldc -120
    //   192: sipush 256
    //   195: invokestatic 74	io/netty/util/internal/SystemPropertyUtil:getInt	(Ljava/lang/String;I)I
    //   198: istore 15
    //   200: iload 15
    //   202: putstatic 138	io/netty/buffer/PooledByteBufAllocator:DEFAULT_SMALL_CACHE_SIZE	I
    //   205: ldc -116
    //   207: bipush 64
    //   209: invokestatic 74	io/netty/util/internal/SystemPropertyUtil:getInt	(Ljava/lang/String;I)I
    //   212: istore 16
    //   214: iload 16
    //   216: putstatic 142	io/netty/buffer/PooledByteBufAllocator:DEFAULT_NORMAL_CACHE_SIZE	I
    //   219: ldc -112
    //   221: ldc -111
    //   223: invokestatic 74	io/netty/util/internal/SystemPropertyUtil:getInt	(Ljava/lang/String;I)I
    //   226: istore 17
    //   228: iload 17
    //   230: putstatic 147	io/netty/buffer/PooledByteBufAllocator:DEFAULT_MAX_CACHED_BUFFER_CAPACITY	I
    //   233: ldc -107
    //   235: sipush 8192
    //   238: invokestatic 74	io/netty/util/internal/SystemPropertyUtil:getInt	(Ljava/lang/String;I)I
    //   241: istore_3
    //   242: iload_3
    //   243: putstatic 151	io/netty/buffer/PooledByteBufAllocator:DEFAULT_CACHE_TRIM_INTERVAL	I
    //   246: ldc -103
    //   248: invokestatic 157	io/netty/util/internal/SystemPropertyUtil:contains	(Ljava/lang/String;)Z
    //   251: ifeq +45 -> 296
    //   254: getstatic 66	io/netty/buffer/PooledByteBufAllocator:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   257: ldc -97
    //   259: invokeinterface 165 2 0
    //   264: ldc -89
    //   266: invokestatic 157	io/netty/util/internal/SystemPropertyUtil:contains	(Ljava/lang/String;)Z
    //   269: ifeq +15 -> 284
    //   272: ldc -89
    //   274: lconst_0
    //   275: invokestatic 171	io/netty/util/internal/SystemPropertyUtil:getLong	(Ljava/lang/String;J)J
    //   278: putstatic 173	io/netty/buffer/PooledByteBufAllocator:DEFAULT_CACHE_TRIM_INTERVAL_MILLIS	J
    //   281: goto +24 -> 305
    //   284: ldc -103
    //   286: lconst_0
    //   287: invokestatic 171	io/netty/util/internal/SystemPropertyUtil:getLong	(Ljava/lang/String;J)J
    //   290: putstatic 173	io/netty/buffer/PooledByteBufAllocator:DEFAULT_CACHE_TRIM_INTERVAL_MILLIS	J
    //   293: goto +12 -> 305
    //   296: ldc -89
    //   298: lconst_0
    //   299: invokestatic 171	io/netty/util/internal/SystemPropertyUtil:getLong	(Ljava/lang/String;J)J
    //   302: putstatic 173	io/netty/buffer/PooledByteBufAllocator:DEFAULT_CACHE_TRIM_INTERVAL_MILLIS	J
    //   305: ldc -81
    //   307: iconst_1
    //   308: invokestatic 179	io/netty/util/internal/SystemPropertyUtil:getBoolean	(Ljava/lang/String;Z)Z
    //   311: istore 18
    //   313: iload 18
    //   315: putstatic 181	io/netty/buffer/PooledByteBufAllocator:DEFAULT_USE_CACHE_FOR_ALL_THREADS	Z
    //   318: ldc -73
    //   320: iconst_0
    //   321: invokestatic 74	io/netty/util/internal/SystemPropertyUtil:getInt	(Ljava/lang/String;I)I
    //   324: putstatic 185	io/netty/buffer/PooledByteBufAllocator:DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT	I
    //   327: ldc -69
    //   329: sipush 1023
    //   332: invokestatic 74	io/netty/util/internal/SystemPropertyUtil:getInt	(Ljava/lang/String;I)I
    //   335: istore 19
    //   337: iload 19
    //   339: putstatic 189	io/netty/buffer/PooledByteBufAllocator:DEFAULT_MAX_CACHED_BYTEBUFFERS_PER_CHUNK	I
    //   342: getstatic 66	io/netty/buffer/PooledByteBufAllocator:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   345: astore 5
    //   347: aload 5
    //   349: invokeinterface 193 1 0
    //   354: ifeq +229 -> 583
    //   357: aload 5
    //   359: ldc -61
    //   361: iload 12
    //   363: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   366: invokeinterface 205 3 0
    //   371: aload 5
    //   373: ldc -49
    //   375: iload 13
    //   377: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   380: invokeinterface 205 3 0
    //   385: aload_2
    //   386: ifnonnull +20 -> 406
    //   389: aload 5
    //   391: ldc -47
    //   393: iload 4
    //   395: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   398: invokeinterface 205 3 0
    //   403: goto +18 -> 421
    //   406: aload 5
    //   408: ldc -47
    //   410: iload 4
    //   412: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   415: aload_2
    //   416: invokeinterface 212 4 0
    //   421: aload_1
    //   422: ifnonnull +19 -> 441
    //   425: aload 5
    //   427: ldc -42
    //   429: iload_0
    //   430: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   433: invokeinterface 205 3 0
    //   438: goto +17 -> 455
    //   441: aload 5
    //   443: ldc -42
    //   445: iload_0
    //   446: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   449: aload_1
    //   450: invokeinterface 212 4 0
    //   455: aload 5
    //   457: ldc -40
    //   459: iload 4
    //   461: iload_0
    //   462: ishl
    //   463: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   466: invokeinterface 205 3 0
    //   471: aload 5
    //   473: ldc -38
    //   475: iload 14
    //   477: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   480: invokeinterface 205 3 0
    //   485: aload 5
    //   487: ldc -36
    //   489: iload 15
    //   491: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   494: invokeinterface 205 3 0
    //   499: aload 5
    //   501: ldc -34
    //   503: iload 16
    //   505: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   508: invokeinterface 205 3 0
    //   513: aload 5
    //   515: ldc -32
    //   517: iload 17
    //   519: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   522: invokeinterface 205 3 0
    //   527: aload 5
    //   529: ldc -30
    //   531: iload_3
    //   532: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   535: invokeinterface 205 3 0
    //   540: aload 5
    //   542: ldc -28
    //   544: getstatic 173	io/netty/buffer/PooledByteBufAllocator:DEFAULT_CACHE_TRIM_INTERVAL_MILLIS	J
    //   547: invokestatic 233	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   550: invokeinterface 205 3 0
    //   555: aload 5
    //   557: ldc -21
    //   559: iload 18
    //   561: invokestatic 240	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   564: invokeinterface 205 3 0
    //   569: aload 5
    //   571: ldc -14
    //   573: iload 19
    //   575: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   578: invokeinterface 205 3 0
    //   583: new 2	io/netty/buffer/PooledByteBufAllocator
    //   586: dup
    //   587: invokestatic 245	io/netty/util/internal/PlatformDependent:directBufferPreferred	()Z
    //   590: invokespecial 249	io/netty/buffer/PooledByteBufAllocator:<init>	(Z)V
    //   593: putstatic 251	io/netty/buffer/PooledByteBufAllocator:DEFAULT	Lio/netty/buffer/PooledByteBufAllocator;
    //   596: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   16	447	0	i	int
    //   18	1	1	localObject1	Object
    //   63	387	1	localObject2	Object
    //   25	1	2	localObject3	Object
    //   29	387	2	localObject4	Object
    //   40	492	3	j	int
    //   48	415	4	k	int
    //   73	497	5	localObject5	Object
    //   88	55	6	l1	long
    //   95	15	8	l2	long
    //   102	46	10	l3	long
    //   132	230	12	m	int
    //   168	208	13	n	int
    //   183	293	14	i1	int
    //   198	292	15	i2	int
    //   212	292	16	i3	int
    //   226	292	17	i4	int
    //   311	249	18	bool	boolean
    //   335	239	19	i5	int
    // Exception table:
    //   from	to	target	type
    //   19	24	29	finally
    //   50	57	63	finally
  }
  
  public PooledByteBufAllocator()
  {
    this(false);
  }
  
  public PooledByteBufAllocator(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(false, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public PooledByteBufAllocator(boolean paramBoolean)
  {
    this(paramBoolean, DEFAULT_NUM_HEAP_ARENA, DEFAULT_NUM_DIRECT_ARENA, DEFAULT_PAGE_SIZE, DEFAULT_MAX_ORDER);
  }
  
  @Deprecated
  public PooledByteBufAllocator(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4, DEFAULT_TINY_CACHE_SIZE, DEFAULT_SMALL_CACHE_SIZE, DEFAULT_NORMAL_CACHE_SIZE);
  }
  
  @Deprecated
  public PooledByteBufAllocator(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, DEFAULT_USE_CACHE_FOR_ALL_THREADS, DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT);
  }
  
  public PooledByteBufAllocator(boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean2)
  {
    this(paramBoolean1, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramBoolean2, DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT);
  }
  
  public PooledByteBufAllocator(boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean2, int paramInt8)
  {
    super(paramBoolean1);
    this.threadCache = new PoolThreadLocalCache(paramBoolean2);
    this.tinyCacheSize = paramInt5;
    this.smallCacheSize = paramInt6;
    this.normalCacheSize = paramInt7;
    this.chunkSize = validateAndCalculateChunkSize(paramInt3, paramInt4);
    ObjectUtil.checkPositiveOrZero(paramInt1, "nHeapArena");
    ObjectUtil.checkPositiveOrZero(paramInt2, "nDirectArena");
    ObjectUtil.checkPositiveOrZero(paramInt8, "directMemoryCacheAlignment");
    if ((paramInt8 > 0) && (!isDirectMemoryCacheAlignmentSupported())) {
      throw new IllegalArgumentException("directMemoryCacheAlignment is not supported");
    }
    if ((-paramInt8 & paramInt8) == paramInt8)
    {
      paramInt6 = validateAndCalculatePageShifts(paramInt3);
      paramInt5 = 0;
      ArrayList localArrayList;
      if (paramInt1 > 0)
      {
        localObject = newArenaArray(paramInt1);
        this.heapArenas = ((PoolArena[])localObject);
        localArrayList = new ArrayList(localObject.length);
        for (paramInt1 = 0; paramInt1 < this.heapArenas.length; paramInt1++)
        {
          localObject = new PoolArena.HeapArena(this, paramInt3, paramInt4, paramInt6, this.chunkSize, paramInt8);
          this.heapArenas[paramInt1] = localObject;
          localArrayList.add(localObject);
        }
        this.heapArenaMetrics = Collections.unmodifiableList(localArrayList);
      }
      else
      {
        this.heapArenas = null;
        this.heapArenaMetrics = Collections.emptyList();
      }
      if (paramInt2 > 0)
      {
        localObject = newArenaArray(paramInt2);
        this.directArenas = ((PoolArena[])localObject);
        localArrayList = new ArrayList(localObject.length);
        for (paramInt1 = paramInt5; paramInt1 < this.directArenas.length; paramInt1++)
        {
          localObject = new PoolArena.DirectArena(this, paramInt3, paramInt4, paramInt6, this.chunkSize, paramInt8);
          this.directArenas[paramInt1] = localObject;
          localArrayList.add(localObject);
        }
        this.directArenaMetrics = Collections.unmodifiableList(localArrayList);
      }
      else
      {
        this.directArenas = null;
        this.directArenaMetrics = Collections.emptyList();
      }
      this.metric = new PooledByteBufAllocatorMetric(this);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("directMemoryCacheAlignment: ");
    ((StringBuilder)localObject).append(paramInt8);
    ((StringBuilder)localObject).append(" (expected: power of two)");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public static int defaultMaxOrder()
  {
    return DEFAULT_MAX_ORDER;
  }
  
  public static int defaultNormalCacheSize()
  {
    return DEFAULT_NORMAL_CACHE_SIZE;
  }
  
  public static int defaultNumDirectArena()
  {
    return DEFAULT_NUM_DIRECT_ARENA;
  }
  
  public static int defaultNumHeapArena()
  {
    return DEFAULT_NUM_HEAP_ARENA;
  }
  
  public static int defaultPageSize()
  {
    return DEFAULT_PAGE_SIZE;
  }
  
  public static boolean defaultPreferDirect()
  {
    return PlatformDependent.directBufferPreferred();
  }
  
  public static int defaultSmallCacheSize()
  {
    return DEFAULT_SMALL_CACHE_SIZE;
  }
  
  public static int defaultTinyCacheSize()
  {
    return DEFAULT_TINY_CACHE_SIZE;
  }
  
  public static boolean defaultUseCacheForAllThreads()
  {
    return DEFAULT_USE_CACHE_FOR_ALL_THREADS;
  }
  
  public static boolean isDirectMemoryCacheAlignmentSupported()
  {
    return PlatformDependent.hasUnsafe();
  }
  
  private static <T> PoolArena<T>[] newArenaArray(int paramInt)
  {
    return new PoolArena[paramInt];
  }
  
  private static long usedMemory(PoolArena<?>[] paramArrayOfPoolArena)
  {
    if (paramArrayOfPoolArena == null) {
      return -1L;
    }
    int i = paramArrayOfPoolArena.length;
    int j = 0;
    long l = 0L;
    while (j < i)
    {
      l += paramArrayOfPoolArena[j].numActiveBytes();
      if (l < 0L) {
        return Long.MAX_VALUE;
      }
      j++;
    }
    return l;
  }
  
  private static int validateAndCalculateChunkSize(int paramInt1, int paramInt2)
  {
    if (paramInt2 <= 14)
    {
      int i = paramInt1;
      int j = paramInt2;
      while (j > 0) {
        if (i <= 536870912)
        {
          i <<= 1;
          j--;
        }
        else
        {
          throw new IllegalArgumentException(String.format("pageSize (%d) << maxOrder (%d) must not exceed %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(1073741824) }));
        }
      }
      return i;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("maxOrder: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" (expected: 0-14)");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private static int validateAndCalculatePageShifts(int paramInt)
  {
    if (paramInt >= 4096)
    {
      if ((paramInt - 1 & paramInt) == 0) {
        return 31 - Integer.numberOfLeadingZeros(paramInt);
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("pageSize: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" (expected: power of 2)");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pageSize: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" (expected: ");
    localStringBuilder.append(4096);
    localStringBuilder.append(")");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  @Deprecated
  public final int chunkSize()
  {
    return this.chunkSize;
  }
  
  @Deprecated
  public List<PoolArenaMetric> directArenas()
  {
    return this.directArenaMetrics;
  }
  
  public String dumpStats()
  {
    Object localObject = this.heapArenas;
    int i = 0;
    int j;
    if (localObject == null) {
      j = 0;
    } else {
      j = localObject.length;
    }
    localObject = new StringBuilder(512);
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append(" heap arena(s):");
    ((StringBuilder)localObject).append(StringUtil.NEWLINE);
    int k;
    if (j > 0)
    {
      arrayOfPoolArena = this.heapArenas;
      k = arrayOfPoolArena.length;
      for (j = 0; j < k; j++) {
        ((StringBuilder)localObject).append(arrayOfPoolArena[j]);
      }
    }
    PoolArena[] arrayOfPoolArena = this.directArenas;
    if (arrayOfPoolArena == null) {
      j = 0;
    } else {
      j = arrayOfPoolArena.length;
    }
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append(" direct arena(s):");
    ((StringBuilder)localObject).append(StringUtil.NEWLINE);
    if (j > 0)
    {
      arrayOfPoolArena = this.directArenas;
      k = arrayOfPoolArena.length;
      for (j = i; j < k; j++) {
        ((StringBuilder)localObject).append(arrayOfPoolArena[j]);
      }
    }
    return ((StringBuilder)localObject).toString();
  }
  
  @Deprecated
  public void freeThreadLocalCache()
  {
    this.threadCache.remove();
  }
  
  @Deprecated
  public boolean hasThreadLocalCache()
  {
    return this.threadCache.isSet();
  }
  
  @Deprecated
  public List<PoolArenaMetric> heapArenas()
  {
    return this.heapArenaMetrics;
  }
  
  public boolean isDirectBufferPooled()
  {
    boolean bool;
    if (this.directArenas != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public PooledByteBufAllocatorMetric metric()
  {
    return this.metric;
  }
  
  protected ByteBuf newDirectBuffer(int paramInt1, int paramInt2)
  {
    Object localObject = (PoolThreadCache)this.threadCache.get();
    PoolArena localPoolArena = ((PoolThreadCache)localObject).directArena;
    if (localPoolArena != null) {
      localObject = localPoolArena.allocate((PoolThreadCache)localObject, paramInt1, paramInt2);
    } else if (PlatformDependent.hasUnsafe()) {
      localObject = UnsafeByteBufUtil.newUnsafeDirectByteBuf(this, paramInt1, paramInt2);
    } else {
      localObject = new UnpooledDirectByteBuf(this, paramInt1, paramInt2);
    }
    return AbstractByteBufAllocator.toLeakAwareBuffer((ByteBuf)localObject);
  }
  
  protected ByteBuf newHeapBuffer(int paramInt1, int paramInt2)
  {
    PoolThreadCache localPoolThreadCache = (PoolThreadCache)this.threadCache.get();
    Object localObject = localPoolThreadCache.heapArena;
    if (localObject != null) {
      localObject = ((PoolArena)localObject).allocate(localPoolThreadCache, paramInt1, paramInt2);
    } else if (PlatformDependent.hasUnsafe()) {
      localObject = new UnpooledUnsafeHeapByteBuf(this, paramInt1, paramInt2);
    } else {
      localObject = new UnpooledHeapByteBuf(this, paramInt1, paramInt2);
    }
    return AbstractByteBufAllocator.toLeakAwareBuffer((ByteBuf)localObject);
  }
  
  @Deprecated
  public int normalCacheSize()
  {
    return this.normalCacheSize;
  }
  
  @Deprecated
  public int numDirectArenas()
  {
    return this.directArenaMetrics.size();
  }
  
  @Deprecated
  public int numHeapArenas()
  {
    return this.heapArenaMetrics.size();
  }
  
  @Deprecated
  public int numThreadLocalCaches()
  {
    PoolArena[] arrayOfPoolArena = this.heapArenas;
    if (arrayOfPoolArena == null) {
      arrayOfPoolArena = this.directArenas;
    }
    int i = 0;
    if (arrayOfPoolArena == null) {
      return 0;
    }
    int j = arrayOfPoolArena.length;
    int k = 0;
    while (i < j)
    {
      k += arrayOfPoolArena[i].numThreadCaches.get();
      i++;
    }
    return k;
  }
  
  @Deprecated
  public int smallCacheSize()
  {
    return this.smallCacheSize;
  }
  
  final PoolThreadCache threadCache()
  {
    return (PoolThreadCache)this.threadCache.get();
  }
  
  @Deprecated
  public int tinyCacheSize()
  {
    return this.tinyCacheSize;
  }
  
  public boolean trimCurrentThreadCache()
  {
    PoolThreadCache localPoolThreadCache = (PoolThreadCache)this.threadCache.getIfExists();
    if (localPoolThreadCache != null)
    {
      localPoolThreadCache.trim();
      return true;
    }
    return false;
  }
  
  final long usedDirectMemory()
  {
    return usedMemory(this.directArenas);
  }
  
  final long usedHeapMemory()
  {
    return usedMemory(this.heapArenas);
  }
  
  final class PoolThreadLocalCache
    extends FastThreadLocal<PoolThreadCache>
  {
    private final boolean useCacheForAllThreads;
    
    PoolThreadLocalCache(boolean paramBoolean)
    {
      this.useCacheForAllThreads = paramBoolean;
    }
    
    private <T> PoolArena<T> leastUsedArena(PoolArena<T>[] paramArrayOfPoolArena)
    {
      if ((paramArrayOfPoolArena != null) && (paramArrayOfPoolArena.length != 0))
      {
        Object localObject1 = paramArrayOfPoolArena[0];
        int i = 1;
        while (i < paramArrayOfPoolArena.length)
        {
          PoolArena<T> localPoolArena = paramArrayOfPoolArena[i];
          Object localObject2 = localObject1;
          if (localPoolArena.numThreadCaches.get() < ((PoolArena)localObject1).numThreadCaches.get()) {
            localObject2 = localPoolArena;
          }
          i++;
          localObject1 = localObject2;
        }
        return (PoolArena<T>)localObject1;
      }
      return null;
    }
    
    protected PoolThreadCache initialValue()
    {
      try
      {
        PoolArena localPoolArena = leastUsedArena(PooledByteBufAllocator.this.heapArenas);
        Object localObject1 = leastUsedArena(PooledByteBufAllocator.this.directArenas);
        Object localObject3 = Thread.currentThread();
        if ((!this.useCacheForAllThreads) && (!(localObject3 instanceof FastThreadLocalThread)))
        {
          localObject1 = new PoolThreadCache(localPoolArena, (PoolArena)localObject1, 0, 0, 0, 0, 0);
          return (PoolThreadCache)localObject1;
        }
        localObject3 = new io/netty/buffer/PoolThreadCache;
        ((PoolThreadCache)localObject3).<init>(localPoolArena, (PoolArena)localObject1, PooledByteBufAllocator.this.tinyCacheSize, PooledByteBufAllocator.this.smallCacheSize, PooledByteBufAllocator.this.normalCacheSize, PooledByteBufAllocator.DEFAULT_MAX_CACHED_BUFFER_CAPACITY, PooledByteBufAllocator.DEFAULT_CACHE_TRIM_INTERVAL);
        if (PooledByteBufAllocator.DEFAULT_CACHE_TRIM_INTERVAL_MILLIS > 0L)
        {
          localObject1 = ThreadExecutorMap.currentExecutor();
          if (localObject1 != null) {
            ((EventExecutorGroup)localObject1).scheduleAtFixedRate(PooledByteBufAllocator.this.trimTask, PooledByteBufAllocator.DEFAULT_CACHE_TRIM_INTERVAL_MILLIS, PooledByteBufAllocator.DEFAULT_CACHE_TRIM_INTERVAL_MILLIS, TimeUnit.MILLISECONDS);
          }
        }
        return (PoolThreadCache)localObject3;
      }
      finally {}
    }
    
    protected void onRemoval(PoolThreadCache paramPoolThreadCache)
    {
      paramPoolThreadCache.free(false);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\PooledByteBufAllocator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */