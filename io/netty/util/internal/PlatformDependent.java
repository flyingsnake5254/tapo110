package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import io.netty.util.internal.shaded.org.jctools.queues.MpscArrayQueue;
import io.netty.util.internal.shaded.org.jctools.queues.MpscChunkedArrayQueue;
import io.netty.util.internal.shaded.org.jctools.queues.MpscUnboundedArrayQueue;
import io.netty.util.internal.shaded.org.jctools.queues.SpscLinkedQueue;
import io.netty.util.internal.shaded.org.jctools.queues.atomic.MpscAtomicArrayQueue;
import io.netty.util.internal.shaded.org.jctools.queues.atomic.MpscChunkedAtomicArrayQueue;
import io.netty.util.internal.shaded.org.jctools.queues.atomic.MpscUnboundedAtomicArrayQueue;
import io.netty.util.internal.shaded.org.jctools.queues.atomic.SpscLinkedAtomicQueue;
import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class PlatformDependent
{
  private static final int ADDRESS_SIZE;
  private static final String[] ALLOWED_LINUX_OS_CLASSIFIERS;
  public static final boolean BIG_ENDIAN_NATIVE_ORDER;
  private static final int BIT_MODE;
  private static final long BYTE_ARRAY_BASE_OFFSET;
  private static final boolean CAN_ENABLE_TCP_NODELAY_BY_DEFAULT;
  private static final Cleaner CLEANER;
  private static final boolean DIRECT_BUFFER_PREFERRED;
  private static final AtomicLong DIRECT_MEMORY_COUNTER;
  private static final long DIRECT_MEMORY_LIMIT;
  private static final boolean IS_IVKVM_DOT_NET;
  private static final boolean IS_J9_JVM;
  private static final boolean IS_OSX;
  private static final boolean IS_WINDOWS;
  private static final String LINUX_ID_LIKE_PREFIX = "ID_LIKE=";
  private static final String LINUX_ID_PREFIX = "ID=";
  private static final Set<String> LINUX_OS_CLASSIFIERS;
  private static final int MAX_ALLOWED_MPSC_CAPACITY = 1073741824;
  private static final long MAX_DIRECT_MEMORY;
  private static final Pattern MAX_DIRECT_MEMORY_SIZE_ARG_PATTERN;
  private static final boolean MAYBE_SUPER_USER;
  private static final int MIN_MAX_MPSC_CAPACITY = 2048;
  private static final int MPSC_CHUNK_SIZE = 1024;
  private static final Cleaner NOOP;
  private static final String NORMALIZED_ARCH;
  private static final String NORMALIZED_OS;
  private static final String[] OS_RELEASE_FILES;
  private static final ThreadLocalRandomProvider RANDOM_PROVIDER;
  private static final File TMPDIR;
  private static final int UNINITIALIZED_ARRAY_ALLOCATION_THRESHOLD;
  private static final Throwable UNSAFE_UNAVAILABILITY_CAUSE;
  private static final boolean USE_DIRECT_BUFFER_NO_CLEANER;
  private static final InternalLogger logger;
  
  static
  {
    InternalLogger localInternalLogger = InternalLoggerFactory.getInstance(PlatformDependent.class);
    logger = localInternalLogger;
    MAX_DIRECT_MEMORY_SIZE_ARG_PATTERN = Pattern.compile("\\s*-XX:MaxDirectMemorySize\\s*=\\s*([0-9]+)\\s*([kKmMgG]?)\\s*$");
    IS_WINDOWS = isWindows0();
    IS_OSX = isOsx0();
    IS_J9_JVM = isJ9Jvm0();
    IS_IVKVM_DOT_NET = isIkvmDotNet0();
    CAN_ENABLE_TCP_NODELAY_BY_DEFAULT = isAndroid() ^ true;
    UNSAFE_UNAVAILABILITY_CAUSE = unsafeUnavailabilityCause0();
    long l1 = maxDirectMemory0();
    MAX_DIRECT_MEMORY = l1;
    BYTE_ARRAY_BASE_OFFSET = byteArrayBaseOffset0();
    TMPDIR = tmpdir0();
    BIT_MODE = bitMode0();
    NORMALIZED_ARCH = normalizeArch(SystemPropertyUtil.get("os.arch", ""));
    NORMALIZED_OS = normalizeOs(SystemPropertyUtil.get("os.name", ""));
    final Object localObject1 = new String[3];
    localObject1[0] = "fedora";
    localObject1[1] = "suse";
    localObject1[2] = "arch";
    ALLOWED_LINUX_OS_CLASSIFIERS = (String[])localObject1;
    ADDRESS_SIZE = addressSize0();
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "/etc/os-release";
    arrayOfString[1] = "/usr/lib/os-release";
    OS_RELEASE_FILES = arrayOfString;
    final Object localObject2 = ByteOrder.nativeOrder();
    final Object localObject3 = ByteOrder.BIG_ENDIAN;
    int i = 0;
    boolean bool1;
    if (localObject2 == localObject3) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    BIG_ENDIAN_NATIVE_ORDER = bool1;
    localObject3 = new Cleaner()
    {
      public void freeDirectBuffer(ByteBuffer paramAnonymousByteBuffer) {}
    };
    NOOP = (Cleaner)localObject3;
    if (javaVersion() >= 7) {
      RANDOM_PROVIDER = new ThreadLocalRandomProvider()
      {
        @SuppressJava6Requirement(reason="Usage guarded by java version check")
        public Random current()
        {
          return java.util.concurrent.ThreadLocalRandom.current();
        }
      };
    } else {
      RANDOM_PROVIDER = new ThreadLocalRandomProvider()
      {
        public Random current()
        {
          return ThreadLocalRandom.current();
        }
      };
    }
    long l2 = SystemPropertyUtil.getLong("io.netty.maxDirectMemory", -1L);
    boolean bool2 = l2 < 0L;
    if ((bool2) && (hasUnsafe()) && (PlatformDependent0.hasDirectBufferNoCleanerConstructor()))
    {
      USE_DIRECT_BUFFER_NO_CLEANER = true;
      if (bool2)
      {
        if (l1 <= 0L) {
          DIRECT_MEMORY_COUNTER = null;
        } else {
          DIRECT_MEMORY_COUNTER = new AtomicLong();
        }
        l2 = l1;
      }
      else
      {
        DIRECT_MEMORY_COUNTER = new AtomicLong();
      }
    }
    else
    {
      USE_DIRECT_BUFFER_NO_CLEANER = false;
      DIRECT_MEMORY_COUNTER = null;
    }
    localInternalLogger.debug("-Dio.netty.maxDirectMemory: {} bytes", Long.valueOf(l2));
    if (l2 >= 1L) {
      l1 = l2;
    }
    DIRECT_MEMORY_LIMIT = l1;
    int j = SystemPropertyUtil.getInt("io.netty.uninitializedArrayAllocationThreshold", 1024);
    if ((javaVersion() < 9) || (!PlatformDependent0.hasAllocateArrayMethod())) {
      j = -1;
    }
    UNINITIALIZED_ARRAY_ALLOCATION_THRESHOLD = j;
    localInternalLogger.debug("-Dio.netty.uninitializedArrayAllocationThreshold: {}", Integer.valueOf(j));
    MAYBE_SUPER_USER = maybeSuperUser0();
    if (!isAndroid())
    {
      if (javaVersion() >= 9)
      {
        if (CleanerJava9.isSupported()) {
          localObject2 = new CleanerJava9();
        } else {
          localObject2 = localObject3;
        }
        CLEANER = (Cleaner)localObject2;
      }
      else
      {
        if (CleanerJava6.isSupported()) {
          localObject2 = new CleanerJava6();
        } else {
          localObject2 = localObject3;
        }
        CLEANER = (Cleaner)localObject2;
      }
    }
    else {
      CLEANER = (Cleaner)localObject3;
    }
    localObject2 = CLEANER;
    if ((localObject2 != localObject3) && (!SystemPropertyUtil.getBoolean("io.netty.noPreferDirect", false))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    DIRECT_BUFFER_PREFERRED = bool1;
    if (localInternalLogger.isDebugEnabled()) {
      localInternalLogger.debug("-Dio.netty.noPreferDirect: {}", Boolean.valueOf(true ^ bool1));
    }
    if ((localObject2 == localObject3) && (!PlatformDependent0.isExplicitNoUnsafe())) {
      localInternalLogger.info("Your platform does not provide complete low-level API for accessing direct buffers reliably. Unless explicitly requested, heap buffer will always be preferred to avoid potential system instability.");
    }
    localObject2 = Collections.unmodifiableSet(new HashSet(Arrays.asList((Object[])localObject1)));
    localObject1 = new LinkedHashSet();
    int k = arrayOfString.length;
    for (j = i; j < k; j++)
    {
      localObject3 = arrayOfString[j];
      if (((Boolean)AccessController.doPrivileged(new PrivilegedAction()
      {
        /* Error */
        public Boolean run()
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 20	io/netty/util/internal/PlatformDependent$4:val$file	Ljava/io/File;
          //   4: invokevirtual 42	java/io/File:exists	()Z
          //   7: istore_1
          //   8: iload_1
          //   9: ifeq +271 -> 280
          //   12: new 44	java/io/BufferedReader
          //   15: astore_2
          //   16: new 46	java/io/InputStreamReader
          //   19: astore_3
          //   20: new 48	java/io/FileInputStream
          //   23: astore 4
          //   25: aload 4
          //   27: aload_0
          //   28: getfield 20	io/netty/util/internal/PlatformDependent$4:val$file	Ljava/io/File;
          //   31: invokespecial 51	java/io/FileInputStream:<init>	(Ljava/io/File;)V
          //   34: aload_3
          //   35: aload 4
          //   37: getstatic 57	io/netty/util/CharsetUtil:UTF_8	Ljava/nio/charset/Charset;
          //   40: invokespecial 60	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
          //   43: aload_2
          //   44: aload_3
          //   45: invokespecial 63	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
          //   48: aload_2
          //   49: astore_3
          //   50: aload_2
          //   51: invokevirtual 67	java/io/BufferedReader:readLine	()Ljava/lang/String;
          //   54: astore 4
          //   56: aload_2
          //   57: astore_3
          //   58: aload 4
          //   60: ifnull +102 -> 162
          //   63: aload_2
          //   64: astore_3
          //   65: aload 4
          //   67: ldc 69
          //   69: invokevirtual 75	java/lang/String:startsWith	(Ljava/lang/String;)Z
          //   72: ifeq +41 -> 113
          //   75: aload_2
          //   76: astore_3
          //   77: aload 4
          //   79: iconst_3
          //   80: invokevirtual 79	java/lang/String:substring	(I)Ljava/lang/String;
          //   83: invokestatic 83	io/netty/util/internal/PlatformDependent:access$000	(Ljava/lang/String;)Ljava/lang/String;
          //   86: astore 4
          //   88: aload_2
          //   89: astore_3
          //   90: aload_0
          //   91: getfield 22	io/netty/util/internal/PlatformDependent$4:val$allowedClassifiers	Ljava/util/Set;
          //   94: aload_0
          //   95: getfield 24	io/netty/util/internal/PlatformDependent$4:val$availableClassifiers	Ljava/util/Set;
          //   98: iconst_1
          //   99: anewarray 71	java/lang/String
          //   102: dup
          //   103: iconst_0
          //   104: aload 4
          //   106: aastore
          //   107: invokestatic 87	io/netty/util/internal/PlatformDependent:access$100	(Ljava/util/Set;Ljava/util/Set;[Ljava/lang/String;)V
          //   110: goto -62 -> 48
          //   113: aload_2
          //   114: astore_3
          //   115: aload 4
          //   117: ldc 89
          //   119: invokevirtual 75	java/lang/String:startsWith	(Ljava/lang/String;)Z
          //   122: ifeq -74 -> 48
          //   125: aload_2
          //   126: astore_3
          //   127: aload 4
          //   129: bipush 8
          //   131: invokevirtual 79	java/lang/String:substring	(I)Ljava/lang/String;
          //   134: invokestatic 83	io/netty/util/internal/PlatformDependent:access$000	(Ljava/lang/String;)Ljava/lang/String;
          //   137: astore 4
          //   139: aload_2
          //   140: astore_3
          //   141: aload_0
          //   142: getfield 22	io/netty/util/internal/PlatformDependent$4:val$allowedClassifiers	Ljava/util/Set;
          //   145: aload_0
          //   146: getfield 24	io/netty/util/internal/PlatformDependent$4:val$availableClassifiers	Ljava/util/Set;
          //   149: aload 4
          //   151: ldc 91
          //   153: invokevirtual 95	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
          //   156: invokestatic 87	io/netty/util/internal/PlatformDependent:access$100	(Ljava/util/Set;Ljava/util/Set;[Ljava/lang/String;)V
          //   159: goto -111 -> 48
          //   162: aload_3
          //   163: invokevirtual 98	java/io/BufferedReader:close	()V
          //   166: goto +81 -> 247
          //   169: astore 4
          //   171: goto +18 -> 189
          //   174: astore 4
          //   176: goto +44 -> 220
          //   179: astore_2
          //   180: aconst_null
          //   181: astore_3
          //   182: goto +72 -> 254
          //   185: astore 4
          //   187: aconst_null
          //   188: astore_2
          //   189: aload_2
          //   190: astore_3
          //   191: invokestatic 102	io/netty/util/internal/PlatformDependent:access$200	()Lio/netty/util/internal/logging/InternalLogger;
          //   194: ldc 104
          //   196: aload_0
          //   197: getfield 26	io/netty/util/internal/PlatformDependent$4:val$osReleaseFileName	Ljava/lang/String;
          //   200: aload 4
          //   202: invokeinterface 110 4 0
          //   207: aload_2
          //   208: ifnull +39 -> 247
          //   211: aload_2
          //   212: astore_3
          //   213: goto -51 -> 162
          //   216: astore 4
          //   218: aconst_null
          //   219: astore_2
          //   220: aload_2
          //   221: astore_3
          //   222: invokestatic 102	io/netty/util/internal/PlatformDependent:access$200	()Lio/netty/util/internal/logging/InternalLogger;
          //   225: ldc 112
          //   227: aload_0
          //   228: getfield 26	io/netty/util/internal/PlatformDependent$4:val$osReleaseFileName	Ljava/lang/String;
          //   231: aload 4
          //   233: invokeinterface 110 4 0
          //   238: aload_2
          //   239: ifnull +8 -> 247
          //   242: aload_2
          //   243: astore_3
          //   244: goto -82 -> 162
          //   247: getstatic 118	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
          //   250: astore_2
          //   251: aload_2
          //   252: areturn
          //   253: astore_2
          //   254: aload_3
          //   255: ifnull +7 -> 262
          //   258: aload_3
          //   259: invokevirtual 98	java/io/BufferedReader:close	()V
          //   262: aload_2
          //   263: athrow
          //   264: astore_2
          //   265: invokestatic 102	io/netty/util/internal/PlatformDependent:access$200	()Lio/netty/util/internal/logging/InternalLogger;
          //   268: ldc 120
          //   270: aload_0
          //   271: getfield 26	io/netty/util/internal/PlatformDependent$4:val$osReleaseFileName	Ljava/lang/String;
          //   274: aload_2
          //   275: invokeinterface 110 4 0
          //   280: getstatic 123	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
          //   283: areturn
          //   284: astore_2
          //   285: goto -38 -> 247
          //   288: astore_3
          //   289: goto -27 -> 262
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	292	0	this	4
          //   7	2	1	bool	boolean
          //   15	125	2	localBufferedReader	java.io.BufferedReader
          //   179	1	2	localObject1	Object
          //   188	64	2	localBoolean	Boolean
          //   253	10	2	localObject2	Object
          //   264	11	2	localSecurityException1	SecurityException
          //   284	1	2	localIOException1	java.io.IOException
          //   19	240	3	localObject3	Object
          //   288	1	3	localIOException2	java.io.IOException
          //   23	127	4	localObject4	Object
          //   169	1	4	localIOException3	java.io.IOException
          //   174	1	4	localSecurityException2	SecurityException
          //   185	16	4	localIOException4	java.io.IOException
          //   216	16	4	localSecurityException3	SecurityException
          // Exception table:
          //   from	to	target	type
          //   50	56	169	java/io/IOException
          //   65	75	169	java/io/IOException
          //   77	88	169	java/io/IOException
          //   90	110	169	java/io/IOException
          //   115	125	169	java/io/IOException
          //   127	139	169	java/io/IOException
          //   141	159	169	java/io/IOException
          //   50	56	174	java/lang/SecurityException
          //   65	75	174	java/lang/SecurityException
          //   77	88	174	java/lang/SecurityException
          //   90	110	174	java/lang/SecurityException
          //   115	125	174	java/lang/SecurityException
          //   127	139	174	java/lang/SecurityException
          //   141	159	174	java/lang/SecurityException
          //   12	48	179	finally
          //   12	48	185	java/io/IOException
          //   12	48	216	java/lang/SecurityException
          //   50	56	253	finally
          //   65	75	253	finally
          //   77	88	253	finally
          //   90	110	253	finally
          //   115	125	253	finally
          //   127	139	253	finally
          //   141	159	253	finally
          //   191	207	253	finally
          //   222	238	253	finally
          //   0	8	264	java/lang/SecurityException
          //   162	166	264	java/lang/SecurityException
          //   247	251	264	java/lang/SecurityException
          //   258	262	264	java/lang/SecurityException
          //   262	264	264	java/lang/SecurityException
          //   162	166	284	java/io/IOException
          //   258	262	288	java/io/IOException
        }
      })).booleanValue()) {
        break;
      }
    }
    LINUX_OS_CLASSIFIERS = Collections.unmodifiableSet((Set)localObject1);
  }
  
  private static void addClassifier(Set<String> paramSet1, Set<String> paramSet2, String... paramVarArgs)
  {
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      String str = paramVarArgs[j];
      if (paramSet1.contains(str)) {
        paramSet2.add(str);
      }
    }
  }
  
  public static int addressSize()
  {
    return ADDRESS_SIZE;
  }
  
  private static int addressSize0()
  {
    if (!hasUnsafe()) {
      return -1;
    }
    return PlatformDependent0.addressSize();
  }
  
  public static ByteBuffer allocateDirectNoCleaner(int paramInt)
  {
    incrementMemoryCounter(paramInt);
    try
    {
      ByteBuffer localByteBuffer = PlatformDependent0.allocateDirectNoCleaner(paramInt);
      return localByteBuffer;
    }
    finally
    {
      decrementMemoryCounter(paramInt);
      throwException(localThrowable);
    }
    return null;
  }
  
  public static long allocateMemory(long paramLong)
  {
    return PlatformDependent0.allocateMemory(paramLong);
  }
  
  public static byte[] allocateUninitializedArray(int paramInt)
  {
    int i = UNINITIALIZED_ARRAY_ALLOCATION_THRESHOLD;
    byte[] arrayOfByte;
    if ((i >= 0) && (i <= paramInt)) {
      arrayOfByte = PlatformDependent0.allocateUninitializedArray(paramInt);
    } else {
      arrayOfByte = new byte[paramInt];
    }
    return arrayOfByte;
  }
  
  public static int bitMode()
  {
    return BIT_MODE;
  }
  
  private static int bitMode0()
  {
    int i = SystemPropertyUtil.getInt("io.netty.bitMode", 0);
    if (i > 0)
    {
      logger.debug("-Dio.netty.bitMode: {}", Integer.valueOf(i));
      return i;
    }
    i = SystemPropertyUtil.getInt("sun.arch.data.model", 0);
    if (i > 0)
    {
      logger.debug("-Dio.netty.bitMode: {} (sun.arch.data.model)", Integer.valueOf(i));
      return i;
    }
    i = SystemPropertyUtil.getInt("com.ibm.vm.bitmode", 0);
    if (i > 0)
    {
      logger.debug("-Dio.netty.bitMode: {} (com.ibm.vm.bitmode)", Integer.valueOf(i));
      return i;
    }
    String str = SystemPropertyUtil.get("os.arch", "");
    Object localObject = Locale.US;
    str = str.toLowerCase((Locale)localObject).trim();
    if ((!"amd64".equals(str)) && (!"x86_64".equals(str)))
    {
      if (("i386".equals(str)) || ("i486".equals(str)) || ("i586".equals(str)) || ("i686".equals(str))) {
        i = 32;
      }
    }
    else {
      i = 64;
    }
    if (i > 0) {
      logger.debug("-Dio.netty.bitMode: {} (os.arch: {})", Integer.valueOf(i), str);
    }
    localObject = SystemPropertyUtil.get("java.vm.name", "").toLowerCase((Locale)localObject);
    localObject = Pattern.compile("([1-9][0-9]+)-?bit").matcher((CharSequence)localObject);
    if (((Matcher)localObject).find()) {
      return Integer.parseInt(((Matcher)localObject).group(1));
    }
    return 64;
  }
  
  private static long byteArrayBaseOffset0()
  {
    if (!hasUnsafe()) {
      return -1L;
    }
    return PlatformDependent0.byteArrayBaseOffset();
  }
  
  public static boolean canEnableTcpNoDelayByDefault()
  {
    return CAN_ENABLE_TCP_NODELAY_BY_DEFAULT;
  }
  
  public static void copyMemory(long paramLong1, long paramLong2, long paramLong3)
  {
    PlatformDependent0.copyMemory(paramLong1, paramLong2, paramLong3);
  }
  
  public static void copyMemory(long paramLong1, byte[] paramArrayOfByte, int paramInt, long paramLong2)
  {
    PlatformDependent0.copyMemory(null, paramLong1, paramArrayOfByte, BYTE_ARRAY_BASE_OFFSET + paramInt, paramLong2);
  }
  
  public static void copyMemory(byte[] paramArrayOfByte, int paramInt, long paramLong1, long paramLong2)
  {
    PlatformDependent0.copyMemory(paramArrayOfByte, BYTE_ARRAY_BASE_OFFSET + paramInt, null, paramLong1, paramLong2);
  }
  
  private static void decrementMemoryCounter(int paramInt)
  {
    AtomicLong localAtomicLong = DIRECT_MEMORY_COUNTER;
    if (localAtomicLong != null) {
      localAtomicLong.addAndGet(-paramInt);
    }
  }
  
  public static ByteBuffer directBuffer(long paramLong, int paramInt)
  {
    if (PlatformDependent0.hasDirectBufferNoCleanerConstructor()) {
      return PlatformDependent0.newDirectBuffer(paramLong, paramInt);
    }
    throw new UnsupportedOperationException("sun.misc.Unsafe or java.nio.DirectByteBuffer.<init>(long, int) not available");
  }
  
  public static long directBufferAddress(ByteBuffer paramByteBuffer)
  {
    return PlatformDependent0.directBufferAddress(paramByteBuffer);
  }
  
  public static boolean directBufferPreferred()
  {
    return DIRECT_BUFFER_PREFERRED;
  }
  
  public static boolean equals(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    boolean bool;
    if ((hasUnsafe()) && (PlatformDependent0.unalignedAccess())) {
      bool = PlatformDependent0.equals(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2, paramInt3);
    } else {
      bool = equalsSafe(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2, paramInt3);
    }
    return bool;
  }
  
  public static int equalsConstantTime(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    if ((hasUnsafe()) && (PlatformDependent0.unalignedAccess())) {
      paramInt1 = PlatformDependent0.equalsConstantTime(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2, paramInt3);
    } else {
      paramInt1 = ConstantTimeUtils.equalsConstantTime(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2, paramInt3);
    }
    return paramInt1;
  }
  
  private static boolean equalsSafe(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    int i = paramInt2;
    paramInt2 = paramInt1;
    while (paramInt2 < paramInt3 + paramInt1)
    {
      if (paramArrayOfByte1[paramInt2] != paramArrayOfByte2[i]) {
        return false;
      }
      paramInt2++;
      i++;
    }
    return true;
  }
  
  public static void freeDirectBuffer(ByteBuffer paramByteBuffer)
  {
    CLEANER.freeDirectBuffer(paramByteBuffer);
  }
  
  public static void freeDirectNoCleaner(ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.capacity();
    PlatformDependent0.freeMemory(PlatformDependent0.directBufferAddress(paramByteBuffer));
    decrementMemoryCounter(i);
  }
  
  public static void freeMemory(long paramLong)
  {
    PlatformDependent0.freeMemory(paramLong);
  }
  
  public static byte getByte(long paramLong)
  {
    return PlatformDependent0.getByte(paramLong);
  }
  
  public static byte getByte(byte[] paramArrayOfByte, int paramInt)
  {
    return PlatformDependent0.getByte(paramArrayOfByte, paramInt);
  }
  
  public static byte getByte(byte[] paramArrayOfByte, long paramLong)
  {
    return PlatformDependent0.getByte(paramArrayOfByte, paramLong);
  }
  
  public static ClassLoader getClassLoader(Class<?> paramClass)
  {
    return PlatformDependent0.getClassLoader(paramClass);
  }
  
  public static ClassLoader getContextClassLoader()
  {
    return PlatformDependent0.getContextClassLoader();
  }
  
  public static int getInt(long paramLong)
  {
    return PlatformDependent0.getInt(paramLong);
  }
  
  public static int getInt(Object paramObject, long paramLong)
  {
    return PlatformDependent0.getInt(paramObject, paramLong);
  }
  
  public static int getInt(byte[] paramArrayOfByte, int paramInt)
  {
    return PlatformDependent0.getInt(paramArrayOfByte, paramInt);
  }
  
  public static int getInt(int[] paramArrayOfInt, long paramLong)
  {
    return PlatformDependent0.getInt(paramArrayOfInt, paramLong);
  }
  
  private static int getIntSafe(byte[] paramArrayOfByte, int paramInt)
  {
    int i;
    int j;
    if (BIG_ENDIAN_NATIVE_ORDER)
    {
      i = paramArrayOfByte[paramInt] << 24 | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8;
      j = paramArrayOfByte[(paramInt + 3)] & 0xFF;
    }
    for (paramInt = i;; paramInt = i)
    {
      return j | paramInt;
      i = paramArrayOfByte[paramInt] & 0xFF | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 16;
      j = paramArrayOfByte[(paramInt + 3)] << 24;
    }
  }
  
  public static long getLong(long paramLong)
  {
    return PlatformDependent0.getLong(paramLong);
  }
  
  public static long getLong(byte[] paramArrayOfByte, int paramInt)
  {
    return PlatformDependent0.getLong(paramArrayOfByte, paramInt);
  }
  
  public static long getLong(long[] paramArrayOfLong, long paramLong)
  {
    return PlatformDependent0.getLong(paramArrayOfLong, paramLong);
  }
  
  private static long getLongSafe(byte[] paramArrayOfByte, int paramInt)
  {
    if (BIG_ENDIAN_NATIVE_ORDER)
    {
      l1 = paramArrayOfByte[paramInt];
      l2 = paramArrayOfByte[(paramInt + 1)];
      l3 = paramArrayOfByte[(paramInt + 2)];
      l4 = paramArrayOfByte[(paramInt + 3)];
      l5 = paramArrayOfByte[(paramInt + 4)];
      l6 = paramArrayOfByte[(paramInt + 5)];
      l7 = paramArrayOfByte[(paramInt + 6)];
      return paramArrayOfByte[(paramInt + 7)] & 0xFF | l1 << 56 | (l2 & 0xFF) << 48 | (l3 & 0xFF) << 40 | (l4 & 0xFF) << 32 | (l5 & 0xFF) << 24 | (l6 & 0xFF) << 16 | (l7 & 0xFF) << 8;
    }
    long l1 = paramArrayOfByte[paramInt];
    long l5 = paramArrayOfByte[(paramInt + 1)];
    long l7 = paramArrayOfByte[(paramInt + 2)];
    long l4 = paramArrayOfByte[(paramInt + 3)];
    long l2 = paramArrayOfByte[(paramInt + 4)];
    long l3 = paramArrayOfByte[(paramInt + 5)];
    long l6 = paramArrayOfByte[(paramInt + 6)];
    return paramArrayOfByte[(paramInt + 7)] << 56 | (l7 & 0xFF) << 16 | l1 & 0xFF | (l5 & 0xFF) << 8 | (l4 & 0xFF) << 24 | (l2 & 0xFF) << 32 | (l3 & 0xFF) << 40 | (l6 & 0xFF) << 48;
  }
  
  public static Object getObject(Object paramObject, long paramLong)
  {
    return PlatformDependent0.getObject(paramObject, paramLong);
  }
  
  public static short getShort(long paramLong)
  {
    return PlatformDependent0.getShort(paramLong);
  }
  
  public static short getShort(byte[] paramArrayOfByte, int paramInt)
  {
    return PlatformDependent0.getShort(paramArrayOfByte, paramInt);
  }
  
  private static short getShortSafe(byte[] paramArrayOfByte, int paramInt)
  {
    int i;
    int j;
    if (BIG_ENDIAN_NATIVE_ORDER)
    {
      i = paramArrayOfByte[paramInt] << 8;
      j = paramArrayOfByte[(paramInt + 1)] & 0xFF;
      paramInt = i;
    }
    for (;;)
    {
      return (short)(j | paramInt);
      j = paramArrayOfByte[paramInt] & 0xFF;
      i = paramArrayOfByte[(paramInt + 1)] << 8;
      paramInt = j;
      j = i;
    }
  }
  
  public static ClassLoader getSystemClassLoader()
  {
    return PlatformDependent0.getSystemClassLoader();
  }
  
  public static Throwable getUnsafeUnavailabilityCause()
  {
    return UNSAFE_UNAVAILABILITY_CAUSE;
  }
  
  public static boolean hasDirectBufferNoCleanerConstructor()
  {
    return PlatformDependent0.hasDirectBufferNoCleanerConstructor();
  }
  
  public static boolean hasUnsafe()
  {
    boolean bool;
    if (UNSAFE_UNAVAILABILITY_CAUSE == null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static int hashCodeAscii(CharSequence paramCharSequence)
  {
    int i = paramCharSequence.length();
    int j = i & 0x7;
    int k = -1028477387;
    int m;
    if (i >= 32)
    {
      i -= 8;
      m = k;
      for (;;)
      {
        k = m;
        if (i < j) {
          break;
        }
        m = hashCodeAsciiCompute(paramCharSequence, i, m);
        i -= 8;
      }
    }
    if (i >= 8)
    {
      m = hashCodeAsciiCompute(paramCharSequence, i - 8, -1028477387);
      k = m;
      if (i >= 16)
      {
        m = hashCodeAsciiCompute(paramCharSequence, i - 16, m);
        k = m;
        if (i >= 24) {
          k = hashCodeAsciiCompute(paramCharSequence, i - 24, m);
        }
      }
    }
    if (j == 0) {
      return k;
    }
    int n = 1;
    if (j != 2) {
      m = 1;
    } else {
      m = 0;
    }
    if (j != 4) {
      i = 1;
    } else {
      i = 0;
    }
    if (j != 6) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2 = -862048943;
    if ((m & i & i1) != 0)
    {
      m = k * -862048943 + hashCodeAsciiSanitizeByte(paramCharSequence.charAt(0));
      k = 1;
    }
    else
    {
      i = 0;
      m = k;
      k = i;
    }
    int i3;
    if (j != 1) {
      i3 = 1;
    } else {
      i3 = 0;
    }
    int i4;
    if (j != 4) {
      i4 = 1;
    } else {
      i4 = 0;
    }
    int i5;
    if (j != 5) {
      i5 = 1;
    } else {
      i5 = 0;
    }
    int i1 = k;
    i = m;
    if ((i3 & i4 & i5) != 0)
    {
      if (k == 0) {
        i = -862048943;
      } else {
        i = 461845907;
      }
      i = m * i + PlatformDependent0.hashCodeAsciiSanitize(hashCodeAsciiSanitizeShort(paramCharSequence, k));
      i1 = k + 2;
    }
    k = i;
    if (j >= 4)
    {
      if (i1 == 0) {
        k = 1;
      } else {
        k = 0;
      }
      if (i1 == 3) {
        m = n;
      } else {
        m = 0;
      }
      if ((k | m) != 0) {
        k = i2;
      } else {
        k = 461845907;
      }
      k = i * k + hashCodeAsciiSanitizeInt(paramCharSequence, i1);
    }
    return k;
  }
  
  public static int hashCodeAscii(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((hasUnsafe()) && (PlatformDependent0.unalignedAccess())) {
      paramInt1 = PlatformDependent0.hashCodeAscii(paramArrayOfByte, paramInt1, paramInt2);
    } else {
      paramInt1 = hashCodeAsciiSafe(paramArrayOfByte, paramInt1, paramInt2);
    }
    return paramInt1;
  }
  
  private static int hashCodeAsciiCompute(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (BIG_ENDIAN_NATIVE_ORDER) {
      paramInt2 = paramInt2 * -862048943 + hashCodeAsciiSanitizeInt(paramCharSequence, paramInt1 + 4) * 461845907;
    }
    for (paramInt1 = hashCodeAsciiSanitizeInt(paramCharSequence, paramInt1);; paramInt1 = hashCodeAsciiSanitizeInt(paramCharSequence, paramInt1 + 4))
    {
      return paramInt2 + paramInt1;
      paramInt2 = paramInt2 * -862048943 + hashCodeAsciiSanitizeInt(paramCharSequence, paramInt1) * 461845907;
    }
  }
  
  static int hashCodeAsciiSafe(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt2 & 0x7;
    paramInt2 = paramInt1 - 8 + paramInt2;
    int j = -1028477387;
    while (paramInt2 >= paramInt1 + i)
    {
      j = PlatformDependent0.hashCodeAsciiCompute(getLongSafe(paramArrayOfByte, paramInt2), j);
      paramInt2 -= 8;
    }
    switch (i)
    {
    default: 
      return j;
    case 7: 
      paramInt2 = ((j * -862048943 + PlatformDependent0.hashCodeAsciiSanitize(paramArrayOfByte[paramInt1])) * 461845907 + PlatformDependent0.hashCodeAsciiSanitize(getShortSafe(paramArrayOfByte, paramInt1 + 1))) * -862048943;
      paramInt1 = PlatformDependent0.hashCodeAsciiSanitize(getIntSafe(paramArrayOfByte, paramInt1 + 3));
    }
    for (;;)
    {
      return paramInt2 + paramInt1;
      paramInt2 = (j * -862048943 + PlatformDependent0.hashCodeAsciiSanitize(getShortSafe(paramArrayOfByte, paramInt1))) * 461845907;
      paramInt1 = PlatformDependent0.hashCodeAsciiSanitize(getIntSafe(paramArrayOfByte, paramInt1 + 2));
      continue;
      paramInt2 = (j * -862048943 + PlatformDependent0.hashCodeAsciiSanitize(paramArrayOfByte[paramInt1])) * 461845907;
      paramInt1 = PlatformDependent0.hashCodeAsciiSanitize(getIntSafe(paramArrayOfByte, paramInt1 + 1));
      continue;
      paramInt2 = j * -862048943;
      paramInt1 = PlatformDependent0.hashCodeAsciiSanitize(getIntSafe(paramArrayOfByte, paramInt1));
      continue;
      paramInt2 = (j * -862048943 + PlatformDependent0.hashCodeAsciiSanitize(paramArrayOfByte[paramInt1])) * 461845907;
      paramInt1 = PlatformDependent0.hashCodeAsciiSanitize(getShortSafe(paramArrayOfByte, paramInt1 + 1));
      continue;
      paramInt2 = j * -862048943;
      paramInt1 = PlatformDependent0.hashCodeAsciiSanitize(getShortSafe(paramArrayOfByte, paramInt1));
      continue;
      paramInt2 = j * -862048943;
      paramInt1 = PlatformDependent0.hashCodeAsciiSanitize(paramArrayOfByte[paramInt1]);
    }
  }
  
  private static int hashCodeAsciiSanitizeByte(char paramChar)
  {
    return paramChar & 0x1F;
  }
  
  private static int hashCodeAsciiSanitizeInt(CharSequence paramCharSequence, int paramInt)
  {
    int i;
    if (BIG_ENDIAN_NATIVE_ORDER) {
      i = paramCharSequence.charAt(paramInt + 3) & 0x1F | (paramCharSequence.charAt(paramInt + 2) & 0x1F) << '\b' | (paramCharSequence.charAt(paramInt + 1) & 0x1F) << '\020';
    }
    for (paramInt = (paramCharSequence.charAt(paramInt) & 0x1F) << '\030';; paramInt = paramCharSequence.charAt(paramInt) & 0x1F)
    {
      return paramInt | i;
      i = (paramCharSequence.charAt(paramInt + 3) & 0x1F) << '\030' | (paramCharSequence.charAt(paramInt + 2) & 0x1F) << '\020' | (paramCharSequence.charAt(paramInt + 1) & 0x1F) << '\b';
    }
  }
  
  private static int hashCodeAsciiSanitizeShort(CharSequence paramCharSequence, int paramInt)
  {
    int i;
    if (BIG_ENDIAN_NATIVE_ORDER) {
      i = paramCharSequence.charAt(paramInt + 1) & 0x1F;
    }
    for (paramInt = (paramCharSequence.charAt(paramInt) & 0x1F) << '\b';; paramInt = paramCharSequence.charAt(paramInt) & 0x1F)
    {
      return paramInt | i;
      i = (paramCharSequence.charAt(paramInt + 1) & 0x1F) << '\b';
    }
  }
  
  private static void incrementMemoryCounter(int paramInt)
  {
    Object localObject = DIRECT_MEMORY_COUNTER;
    if (localObject != null)
    {
      long l1 = paramInt;
      long l2 = ((AtomicLong)localObject).addAndGet(l1);
      long l3 = DIRECT_MEMORY_LIMIT;
      if (l2 > l3)
      {
        ((AtomicLong)localObject).addAndGet(-paramInt);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("failed to allocate ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(" byte(s) of direct memory (used: ");
        ((StringBuilder)localObject).append(l2 - l1);
        ((StringBuilder)localObject).append(", max: ");
        ((StringBuilder)localObject).append(l3);
        ((StringBuilder)localObject).append(')');
        throw new OutOfDirectMemoryError(((StringBuilder)localObject).toString());
      }
    }
  }
  
  public static boolean isAndroid()
  {
    return PlatformDependent0.isAndroid();
  }
  
  public static boolean isIkvmDotNet()
  {
    return IS_IVKVM_DOT_NET;
  }
  
  private static boolean isIkvmDotNet0()
  {
    return SystemPropertyUtil.get("java.vm.name", "").toUpperCase(Locale.US).equals("IKVM.NET");
  }
  
  public static boolean isJ9Jvm()
  {
    return IS_J9_JVM;
  }
  
  private static boolean isJ9Jvm0()
  {
    String str = SystemPropertyUtil.get("java.vm.name", "").toLowerCase();
    boolean bool;
    if ((!str.startsWith("ibm j9")) && (!str.startsWith("eclipse openj9"))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isOsx()
  {
    return IS_OSX;
  }
  
  private static boolean isOsx0()
  {
    String str = SystemPropertyUtil.get("os.name", "").toLowerCase(Locale.US).replaceAll("[^a-z0-9]+", "");
    boolean bool;
    if ((!str.startsWith("macosx")) && (!str.startsWith("osx"))) {
      bool = false;
    } else {
      bool = true;
    }
    if (bool) {
      logger.debug("Platform: MacOS");
    }
    return bool;
  }
  
  public static boolean isUnaligned()
  {
    return PlatformDependent0.isUnaligned();
  }
  
  public static boolean isWindows()
  {
    return IS_WINDOWS;
  }
  
  private static boolean isWindows0()
  {
    boolean bool = SystemPropertyUtil.get("os.name", "").toLowerCase(Locale.US).contains("win");
    if (bool) {
      logger.debug("Platform: Windows");
    }
    return bool;
  }
  
  public static boolean isZero(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    boolean bool;
    if ((hasUnsafe()) && (PlatformDependent0.unalignedAccess())) {
      bool = PlatformDependent0.isZero(paramArrayOfByte, paramInt1, paramInt2);
    } else {
      bool = isZeroSafe(paramArrayOfByte, paramInt1, paramInt2);
    }
    return bool;
  }
  
  private static boolean isZeroSafe(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    for (int i = paramInt1; i < paramInt2 + paramInt1; i++) {
      if (paramArrayOfByte[i] != 0) {
        return false;
      }
    }
    return true;
  }
  
  public static int javaVersion()
  {
    return PlatformDependent0.javaVersion();
  }
  
  public static long maxDirectMemory()
  {
    return DIRECT_MEMORY_LIMIT;
  }
  
  private static long maxDirectMemory0()
  {
    try
    {
      localObject1 = getSystemClassLoader();
      String str;
      Object localObject2;
      label81:
      if (l1 <= 0L) {
        break label91;
      }
    }
    finally
    {
      try
      {
        str = SystemPropertyUtil.get("java.vm.name", "").toLowerCase();
        localObject2 = localObject1;
        if (str.startsWith("ibm j9")) {
          break label81;
        }
        localObject2 = localObject1;
        if (str.startsWith("eclipse openj9")) {
          break label81;
        }
        l1 = ((Number)Class.forName("sun.misc.VM", true, (ClassLoader)localObject1).getDeclaredMethod("maxDirectMemory", new Class[0]).invoke(null, new Object[0])).longValue();
        localObject2 = localObject1;
      }
      finally
      {
        for (;;)
        {
          Object localObject1;
          long l1;
          Object localObject4;
          long l2;
          Object localObject7 = localObject1;
        }
      }
      localObject3 = finally;
      localObject4 = null;
      l1 = 0L;
    }
    return l1;
    label91:
    l2 = l1;
    try
    {
      localObject1 = Class.forName("java.lang.management.ManagementFactory", true, (ClassLoader)localObject4);
      l2 = l1;
      localObject4 = Class.forName("java.lang.management.RuntimeMXBean", true, (ClassLoader)localObject4);
      l2 = l1;
      localObject1 = ((Class)localObject1).getDeclaredMethod("getRuntimeMXBean", new Class[0]).invoke(null, new Object[0]);
      l2 = l1;
      localObject1 = (List)((Class)localObject4).getDeclaredMethod("getInputArguments", new Class[0]).invoke(localObject1, new Object[0]);
      l2 = l1;
      for (int i = ((List)localObject1).size() - 1;; i--)
      {
        l2 = l1;
        if (i < 0) {
          break label327;
        }
        l2 = l1;
        localObject4 = MAX_DIRECT_MEMORY_SIZE_ARG_PATTERN.matcher((CharSequence)((List)localObject1).get(i));
        l2 = l1;
        if (((Matcher)localObject4).matches()) {
          break;
        }
      }
      l2 = l1;
      l1 = Long.parseLong(((Matcher)localObject4).group(1));
      l2 = l1;
      i = ((Matcher)localObject4).group(2).charAt(0);
      if (i != 71)
      {
        if (i != 75)
        {
          if (i != 77)
          {
            if (i == 103) {
              break label312;
            }
            if (i == 107) {
              break label304;
            }
            if (i != 109)
            {
              l2 = l1;
              break label327;
            }
          }
          l2 = 1048576L;
          break label317;
        }
        label304:
        l2 = 1024L;
        break label317;
      }
      label312:
      l2 = 1073741824L;
      label317:
      l2 = l1 * l2;
    }
    finally {}
    label327:
    if (l2 <= 0L)
    {
      l2 = Runtime.getRuntime().maxMemory();
      logger.debug("maxDirectMemory: {} bytes (maybe)", Long.valueOf(l2));
    }
    else
    {
      logger.debug("maxDirectMemory: {} bytes", Long.valueOf(l2));
    }
    return l2;
  }
  
  public static boolean maybeSuperUser()
  {
    return MAYBE_SUPER_USER;
  }
  
  private static boolean maybeSuperUser0()
  {
    String str = SystemPropertyUtil.get("user.name");
    if (isWindows()) {
      return "Administrator".equals(str);
    }
    boolean bool;
    if ((!"root".equals(str)) && (!"toor".equals(str))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  @SuppressJava6Requirement(reason="Usage guarded by java version check")
  public static <C> Deque<C> newConcurrentDeque()
  {
    if (javaVersion() < 7) {
      return new LinkedBlockingDeque();
    }
    return new ConcurrentLinkedDeque();
  }
  
  public static <K, V> ConcurrentMap<K, V> newConcurrentHashMap()
  {
    return new ConcurrentHashMap();
  }
  
  public static <K, V> ConcurrentMap<K, V> newConcurrentHashMap(int paramInt)
  {
    return new ConcurrentHashMap(paramInt);
  }
  
  public static <K, V> ConcurrentMap<K, V> newConcurrentHashMap(int paramInt, float paramFloat)
  {
    return new ConcurrentHashMap(paramInt, paramFloat);
  }
  
  public static <K, V> ConcurrentMap<K, V> newConcurrentHashMap(int paramInt1, float paramFloat, int paramInt2)
  {
    return new ConcurrentHashMap(paramInt1, paramFloat, paramInt2);
  }
  
  public static <K, V> ConcurrentMap<K, V> newConcurrentHashMap(Map<? extends K, ? extends V> paramMap)
  {
    return new ConcurrentHashMap(paramMap);
  }
  
  public static <T> Queue<T> newFixedMpscQueue(int paramInt)
  {
    Object localObject;
    if (hasUnsafe()) {
      localObject = new MpscArrayQueue(paramInt);
    } else {
      localObject = new MpscAtomicArrayQueue(paramInt);
    }
    return (Queue<T>)localObject;
  }
  
  public static LongCounter newLongCounter()
  {
    if (javaVersion() >= 8) {
      return new LongAdderCounter();
    }
    return new AtomicLongCounter(null);
  }
  
  public static <T> Queue<T> newMpscQueue()
  {
    return Mpsc.newMpscQueue();
  }
  
  public static <T> Queue<T> newMpscQueue(int paramInt)
  {
    return Mpsc.newMpscQueue(paramInt);
  }
  
  public static <T> Queue<T> newSpscQueue()
  {
    Object localObject;
    if (hasUnsafe()) {
      localObject = new SpscLinkedQueue();
    } else {
      localObject = new SpscLinkedAtomicQueue();
    }
    return (Queue<T>)localObject;
  }
  
  private static String normalize(String paramString)
  {
    return paramString.toLowerCase(Locale.US).replaceAll("[^a-z0-9]+", "");
  }
  
  private static String normalizeArch(String paramString)
  {
    paramString = normalize(paramString);
    if (paramString.matches("^(x8664|amd64|ia32e|em64t|x64)$")) {
      return "x86_64";
    }
    if (paramString.matches("^(x8632|x86|i[3-6]86|ia32|x32)$")) {
      return "x86_32";
    }
    if (paramString.matches("^(ia64|itanium64)$")) {
      return "itanium_64";
    }
    if (paramString.matches("^(sparc|sparc32)$")) {
      return "sparc_32";
    }
    if (paramString.matches("^(sparcv9|sparc64)$")) {
      return "sparc_64";
    }
    if (paramString.matches("^(arm|arm32)$")) {
      return "arm_32";
    }
    if ("aarch64".equals(paramString)) {
      return "aarch_64";
    }
    if (paramString.matches("^(ppc|ppc32)$")) {
      return "ppc_32";
    }
    if ("ppc64".equals(paramString)) {
      return "ppc_64";
    }
    if ("ppc64le".equals(paramString)) {
      return "ppcle_64";
    }
    if ("s390".equals(paramString)) {
      return "s390_32";
    }
    if ("s390x".equals(paramString)) {
      return "s390_64";
    }
    return "unknown";
  }
  
  private static String normalizeOs(String paramString)
  {
    String str1 = normalize(paramString);
    if (str1.startsWith("aix")) {
      return "aix";
    }
    if (str1.startsWith("hpux")) {
      return "hpux";
    }
    if ((str1.startsWith("os400")) && ((str1.length() <= 5) || (!Character.isDigit(str1.charAt(5))))) {
      return "os400";
    }
    if (str1.startsWith("linux")) {
      return "linux";
    }
    boolean bool = str1.startsWith("macosx");
    String str2 = "osx";
    paramString = str2;
    if (!bool) {
      if (str1.startsWith("osx"))
      {
        paramString = str2;
      }
      else
      {
        if (str1.startsWith("freebsd")) {
          return "freebsd";
        }
        if (str1.startsWith("openbsd")) {
          return "openbsd";
        }
        if (str1.startsWith("netbsd")) {
          return "netbsd";
        }
        bool = str1.startsWith("solaris");
        str2 = "sunos";
        paramString = str2;
        if (!bool) {
          if (str1.startsWith("sunos"))
          {
            paramString = str2;
          }
          else
          {
            if (str1.startsWith("windows")) {
              return "windows";
            }
            return "unknown";
          }
        }
      }
    }
    return paramString;
  }
  
  private static String normalizeOsReleaseVariableValue(String paramString)
  {
    return paramString.trim().replaceAll("[\"']", "");
  }
  
  public static String normalizedArch()
  {
    return NORMALIZED_ARCH;
  }
  
  public static Set<String> normalizedLinuxClassifiers()
  {
    return LINUX_OS_CLASSIFIERS;
  }
  
  public static String normalizedOs()
  {
    return NORMALIZED_OS;
  }
  
  public static long objectFieldOffset(Field paramField)
  {
    return PlatformDependent0.objectFieldOffset(paramField);
  }
  
  public static void putByte(long paramLong, byte paramByte)
  {
    PlatformDependent0.putByte(paramLong, paramByte);
  }
  
  public static void putByte(byte[] paramArrayOfByte, int paramInt, byte paramByte)
  {
    PlatformDependent0.putByte(paramArrayOfByte, paramInt, paramByte);
  }
  
  public static void putInt(long paramLong, int paramInt)
  {
    PlatformDependent0.putInt(paramLong, paramInt);
  }
  
  public static void putInt(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    PlatformDependent0.putInt(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static void putLong(long paramLong1, long paramLong2)
  {
    PlatformDependent0.putLong(paramLong1, paramLong2);
  }
  
  public static void putLong(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    PlatformDependent0.putLong(paramArrayOfByte, paramInt, paramLong);
  }
  
  public static void putObject(Object paramObject1, long paramLong, Object paramObject2)
  {
    PlatformDependent0.putObject(paramObject1, paramLong, paramObject2);
  }
  
  public static void putShort(long paramLong, short paramShort)
  {
    PlatformDependent0.putShort(paramLong, paramShort);
  }
  
  public static void putShort(byte[] paramArrayOfByte, int paramInt, short paramShort)
  {
    PlatformDependent0.putShort(paramArrayOfByte, paramInt, paramShort);
  }
  
  public static ByteBuffer reallocateDirectNoCleaner(ByteBuffer paramByteBuffer, int paramInt)
  {
    int i = paramInt - paramByteBuffer.capacity();
    incrementMemoryCounter(i);
    try
    {
      paramByteBuffer = PlatformDependent0.reallocateDirectNoCleaner(paramByteBuffer, paramInt);
      return paramByteBuffer;
    }
    finally
    {
      decrementMemoryCounter(i);
      throwException(paramByteBuffer);
    }
    return null;
  }
  
  public static long reallocateMemory(long paramLong1, long paramLong2)
  {
    return PlatformDependent0.reallocateMemory(paramLong1, paramLong2);
  }
  
  public static void setMemory(long paramLong1, long paramLong2, byte paramByte)
  {
    PlatformDependent0.setMemory(paramLong1, paramLong2, paramByte);
  }
  
  public static void setMemory(byte[] paramArrayOfByte, int paramInt, long paramLong, byte paramByte)
  {
    PlatformDependent0.setMemory(paramArrayOfByte, BYTE_ARRAY_BASE_OFFSET + paramInt, paramLong, paramByte);
  }
  
  public static Random threadLocalRandom()
  {
    return RANDOM_PROVIDER.current();
  }
  
  public static void throwException(Throwable paramThrowable)
  {
    if (hasUnsafe()) {
      PlatformDependent0.throwException(paramThrowable);
    } else {
      throwException0(paramThrowable);
    }
  }
  
  private static <E extends Throwable> void throwException0(Throwable paramThrowable)
    throws Throwable
  {
    throw paramThrowable;
  }
  
  public static File tmpdir()
  {
    return TMPDIR;
  }
  
  private static File tmpdir0()
  {
    try
    {
      Object localObject1 = toDirectory(SystemPropertyUtil.get("io.netty.tmpdir"));
      if (localObject1 != null)
      {
        logger.debug("-Dio.netty.tmpdir: {}", localObject1);
        return (File)localObject1;
      }
      localObject1 = toDirectory(SystemPropertyUtil.get("java.io.tmpdir"));
      if (localObject1 != null)
      {
        logger.debug("-Dio.netty.tmpdir: {} (java.io.tmpdir)", localObject1);
        return (File)localObject1;
      }
      if (isWindows())
      {
        localObject1 = toDirectory(System.getenv("TEMP"));
        if (localObject1 != null)
        {
          logger.debug("-Dio.netty.tmpdir: {} (%TEMP%)", localObject1);
          return (File)localObject1;
        }
        localObject1 = System.getenv("USERPROFILE");
        if (localObject1 != null)
        {
          Object localObject3 = new java/lang/StringBuilder;
          ((StringBuilder)localObject3).<init>();
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append("\\AppData\\Local\\Temp");
          localObject3 = toDirectory(((StringBuilder)localObject3).toString());
          if (localObject3 != null)
          {
            logger.debug("-Dio.netty.tmpdir: {} (%USERPROFILE%\\AppData\\Local\\Temp)", localObject3);
            return (File)localObject3;
          }
          localObject3 = new java/lang/StringBuilder;
          ((StringBuilder)localObject3).<init>();
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append("\\Local Settings\\Temp");
          localObject1 = toDirectory(((StringBuilder)localObject3).toString());
          if (localObject1 != null)
          {
            logger.debug("-Dio.netty.tmpdir: {} (%USERPROFILE%\\Local Settings\\Temp)", localObject1);
            return (File)localObject1;
          }
        }
      }
      else
      {
        localObject1 = toDirectory(System.getenv("TMPDIR"));
        if (localObject1 != null)
        {
          logger.debug("-Dio.netty.tmpdir: {} ($TMPDIR)", localObject1);
          return (File)localObject1;
        }
      }
    }
    finally
    {
      File localFile;
      if (isWindows()) {
        localFile = new File("C:\\Windows\\Temp");
      } else {
        localFile = new File("/tmp");
      }
      logger.warn("Failed to get the temporary directory; falling back to: {}", localFile);
      return localFile;
    }
  }
  
  private static File toDirectory(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = new File(paramString);
    paramString.mkdirs();
    if (!paramString.isDirectory()) {
      return null;
    }
    try
    {
      File localFile = paramString.getAbsoluteFile();
      return localFile;
    }
    catch (Exception localException) {}
    return paramString;
  }
  
  private static Throwable unsafeUnavailabilityCause0()
  {
    if (isAndroid())
    {
      logger.debug("sun.misc.Unsafe: unavailable (Android)");
      return new UnsupportedOperationException("sun.misc.Unsafe: unavailable (Android)");
    }
    if (isIkvmDotNet())
    {
      logger.debug("sun.misc.Unsafe: unavailable (IKVM.NET)");
      return new UnsupportedOperationException("sun.misc.Unsafe: unavailable (IKVM.NET)");
    }
    Object localObject = PlatformDependent0.getUnsafeUnavailabilityCause();
    if (localObject != null) {
      return (Throwable)localObject;
    }
    try
    {
      boolean bool = PlatformDependent0.hasUnsafe();
      InternalLogger localInternalLogger = logger;
      if (bool) {
        localObject = "available";
      } else {
        localObject = "unavailable";
      }
      localInternalLogger.debug("sun.misc.Unsafe: {}", localObject);
      if (bool) {
        localObject = null;
      } else {
        localObject = PlatformDependent0.getUnsafeUnavailabilityCause();
      }
      return (Throwable)localObject;
    }
    finally
    {
      logger.trace("Could not determine if Unsafe is available", localThrowable);
      return new UnsupportedOperationException("Could not determine if Unsafe is available", localThrowable);
    }
  }
  
  public static boolean useDirectBufferNoCleaner()
  {
    return USE_DIRECT_BUFFER_NO_CLEANER;
  }
  
  public static long usedDirectMemory()
  {
    AtomicLong localAtomicLong = DIRECT_MEMORY_COUNTER;
    long l;
    if (localAtomicLong != null) {
      l = localAtomicLong.get();
    } else {
      l = -1L;
    }
    return l;
  }
  
  private static final class AtomicLongCounter
    extends AtomicLong
    implements LongCounter
  {
    private static final long serialVersionUID = 4074772784610639305L;
    
    public void add(long paramLong)
    {
      addAndGet(paramLong);
    }
    
    public void decrement()
    {
      decrementAndGet();
    }
    
    public void increment()
    {
      incrementAndGet();
    }
    
    public long value()
    {
      return get();
    }
  }
  
  private static final class Mpsc
  {
    private static final boolean USE_MPSC_CHUNKED_ARRAY_QUEUE;
    
    static
    {
      Object localObject;
      if (PlatformDependent.hasUnsafe()) {
        localObject = AccessController.doPrivileged(new PrivilegedAction()
        {
          public Object run()
          {
            return UnsafeAccess.UNSAFE;
          }
        });
      } else {
        localObject = null;
      }
      if (localObject == null)
      {
        PlatformDependent.logger.debug("org.jctools-core.MpscChunkedArrayQueue: unavailable");
        USE_MPSC_CHUNKED_ARRAY_QUEUE = false;
      }
      else
      {
        PlatformDependent.logger.debug("org.jctools-core.MpscChunkedArrayQueue: available");
        USE_MPSC_CHUNKED_ARRAY_QUEUE = true;
      }
    }
    
    static <T> Queue<T> newMpscQueue()
    {
      Object localObject;
      if (USE_MPSC_CHUNKED_ARRAY_QUEUE) {
        localObject = new MpscUnboundedArrayQueue(1024);
      } else {
        localObject = new MpscUnboundedAtomicArrayQueue(1024);
      }
      return (Queue<T>)localObject;
    }
    
    static <T> Queue<T> newMpscQueue(int paramInt)
    {
      paramInt = Math.max(Math.min(paramInt, 1073741824), 2048);
      Object localObject;
      if (USE_MPSC_CHUNKED_ARRAY_QUEUE) {
        localObject = new MpscChunkedArrayQueue(1024, paramInt);
      } else {
        localObject = new MpscChunkedAtomicArrayQueue(1024, paramInt);
      }
      return (Queue<T>)localObject;
    }
  }
  
  private static abstract interface ThreadLocalRandomProvider
  {
    public abstract Random current();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\PlatformDependent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */