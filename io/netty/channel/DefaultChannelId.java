package io.netty.channel;

import io.netty.buffer.ByteBufUtil;
import io.netty.util.internal.MacAddressUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public final class DefaultChannelId
  implements ChannelId
{
  private static final byte[] MACHINE_ID;
  private static final int PROCESS_ID;
  private static final int PROCESS_ID_LEN = 4;
  private static final int RANDOM_LEN = 4;
  private static final int SEQUENCE_LEN = 4;
  private static final int TIMESTAMP_LEN = 8;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(DefaultChannelId.class);
  private static final AtomicInteger nextSequence = new AtomicInteger();
  private static final long serialVersionUID = 3884076183504074063L;
  private final byte[] data;
  private final int hashCode;
  private transient String longValue;
  private transient String shortValue;
  
  static
  {
    Object localObject1 = SystemPropertyUtil.get("io.netty.processId");
    int i = -1;
    int j = i;
    if (localObject1 != null)
    {
      try
      {
        j = Integer.parseInt((String)localObject1);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        j = -1;
      }
      if (j < 0)
      {
        logger.warn("-Dio.netty.processId: {} (malformed)", localObject1);
        j = i;
      }
      else
      {
        localObject1 = logger;
        if (((InternalLogger)localObject1).isDebugEnabled()) {
          ((InternalLogger)localObject1).debug("-Dio.netty.processId: {} (user-set)", Integer.valueOf(j));
        }
      }
    }
    i = j;
    if (j < 0)
    {
      j = defaultProcessId();
      localObject1 = logger;
      i = j;
      if (((InternalLogger)localObject1).isDebugEnabled())
      {
        ((InternalLogger)localObject1).debug("-Dio.netty.processId: {} (auto-detected)", Integer.valueOf(j));
        i = j;
      }
    }
    PROCESS_ID = i;
    localObject1 = null;
    Object localObject3 = null;
    Object localObject4 = SystemPropertyUtil.get("io.netty.machineId");
    Object localObject2;
    if (localObject4 != null)
    {
      try
      {
        localObject1 = MacAddressUtil.parseMAC((String)localObject4);
        localObject3 = localObject1;
      }
      catch (Exception localException)
      {
        logger.warn("-Dio.netty.machineId: {} (malformed)", localObject4, localException);
      }
      localObject2 = localObject3;
      if (localObject3 != null)
      {
        logger.debug("-Dio.netty.machineId: {} (user-set)", localObject4);
        localObject2 = localObject3;
      }
    }
    localObject3 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = MacAddressUtil.defaultMachineId();
      localObject4 = logger;
      localObject3 = localObject2;
      if (((InternalLogger)localObject4).isDebugEnabled())
      {
        ((InternalLogger)localObject4).debug("-Dio.netty.machineId: {} (auto-detected)", MacAddressUtil.formatAddress((byte[])localObject2));
        localObject3 = localObject2;
      }
    }
    MACHINE_ID = (byte[])localObject3;
  }
  
  private DefaultChannelId()
  {
    byte[] arrayOfByte1 = MACHINE_ID;
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 4 + 4 + 8 + 4];
    this.data = arrayOfByte2;
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
    writeInt(writeLong(writeInt(writeInt(arrayOfByte1.length + 0, PROCESS_ID), nextSequence.getAndIncrement()), Long.reverse(System.nanoTime()) ^ System.currentTimeMillis()), PlatformDependent.threadLocalRandom().nextInt());
    this.hashCode = Arrays.hashCode(arrayOfByte2);
  }
  
  private int appendHexDumpField(StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    paramStringBuilder.append(ByteBufUtil.hexDump(this.data, paramInt1, paramInt2));
    paramStringBuilder.append('-');
    return paramInt1 + paramInt2;
  }
  
  /* Error */
  private static int defaultProcessId()
  {
    // Byte code:
    //   0: ldc 2
    //   2: invokestatic 196	io/netty/util/internal/PlatformDependent:getClassLoader	(Ljava/lang/Class;)Ljava/lang/ClassLoader;
    //   5: astore_0
    //   6: ldc -58
    //   8: iconst_1
    //   9: aload_0
    //   10: invokestatic 204	java/lang/Class:forName	(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;
    //   13: astore_1
    //   14: ldc -50
    //   16: iconst_1
    //   17: aload_0
    //   18: invokestatic 204	java/lang/Class:forName	(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;
    //   21: astore_2
    //   22: getstatic 212	io/netty/util/internal/EmptyArrays:EMPTY_CLASSES	[Ljava/lang/Class;
    //   25: astore_3
    //   26: aload_1
    //   27: ldc -42
    //   29: aload_3
    //   30: invokevirtual 218	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   33: astore 4
    //   35: getstatic 222	io/netty/util/internal/EmptyArrays:EMPTY_OBJECTS	[Ljava/lang/Object;
    //   38: astore_1
    //   39: aload 4
    //   41: aconst_null
    //   42: aload_1
    //   43: invokevirtual 228	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   46: astore 4
    //   48: aload_2
    //   49: ldc -26
    //   51: aload_3
    //   52: invokevirtual 218	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   55: aload 4
    //   57: aload_1
    //   58: invokevirtual 228	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   61: checkcast 232	java/lang/String
    //   64: astore_2
    //   65: goto +65 -> 130
    //   68: astore_2
    //   69: goto +6 -> 75
    //   72: astore_2
    //   73: aconst_null
    //   74: astore_0
    //   75: getstatic 46	io/netty/channel/DefaultChannelId:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   78: ldc -22
    //   80: aload_2
    //   81: invokeinterface 237 3 0
    //   86: ldc -17
    //   88: iconst_1
    //   89: aload_0
    //   90: invokestatic 204	java/lang/Class:forName	(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;
    //   93: ldc -15
    //   95: getstatic 212	io/netty/util/internal/EmptyArrays:EMPTY_CLASSES	[Ljava/lang/Class;
    //   98: invokevirtual 218	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   101: aconst_null
    //   102: getstatic 222	io/netty/util/internal/EmptyArrays:EMPTY_OBJECTS	[Ljava/lang/Object;
    //   105: invokevirtual 228	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   108: invokevirtual 245	java/lang/Object:toString	()Ljava/lang/String;
    //   111: astore_2
    //   112: goto +18 -> 130
    //   115: astore_2
    //   116: getstatic 46	io/netty/channel/DefaultChannelId:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   119: ldc -9
    //   121: aload_2
    //   122: invokeinterface 237 3 0
    //   127: ldc -7
    //   129: astore_2
    //   130: aload_2
    //   131: bipush 64
    //   133: invokevirtual 253	java/lang/String:indexOf	(I)I
    //   136: istore 5
    //   138: aload_2
    //   139: astore_0
    //   140: iload 5
    //   142: iflt +11 -> 153
    //   145: aload_2
    //   146: iconst_0
    //   147: iload 5
    //   149: invokevirtual 257	java/lang/String:substring	(II)Ljava/lang/String;
    //   152: astore_0
    //   153: aload_0
    //   154: invokestatic 67	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   157: istore 5
    //   159: goto +7 -> 166
    //   162: astore_2
    //   163: iconst_m1
    //   164: istore 5
    //   166: iload 5
    //   168: istore 6
    //   170: iload 5
    //   172: ifge +28 -> 200
    //   175: invokestatic 163	io/netty/util/internal/PlatformDependent:threadLocalRandom	()Ljava/util/Random;
    //   178: invokevirtual 168	java/util/Random:nextInt	()I
    //   181: istore 6
    //   183: getstatic 46	io/netty/channel/DefaultChannelId:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   186: ldc_w 259
    //   189: aload_0
    //   190: iload 6
    //   192: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   195: invokeinterface 109 4 0
    //   200: iload 6
    //   202: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   5	185	0	localObject1	Object
    //   13	45	1	localObject2	Object
    //   21	44	2	localObject3	Object
    //   68	1	2	localObject4	Object
    //   72	9	2	localThrowable1	Throwable
    //   111	1	2	str1	String
    //   115	7	2	localThrowable2	Throwable
    //   129	17	2	str2	String
    //   162	1	2	localNumberFormatException	NumberFormatException
    //   25	27	3	arrayOfClass	Class[]
    //   33	23	4	localObject5	Object
    //   136	35	5	i	int
    //   168	33	6	j	int
    // Exception table:
    //   from	to	target	type
    //   6	65	68	finally
    //   0	6	72	finally
    //   86	112	115	finally
    //   153	159	162	java/lang/NumberFormatException
  }
  
  public static DefaultChannelId newInstance()
  {
    return new DefaultChannelId();
  }
  
  private String newLongValue()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.data.length * 2 + 5);
    appendHexDumpField(localStringBuilder, appendHexDumpField(localStringBuilder, appendHexDumpField(localStringBuilder, appendHexDumpField(localStringBuilder, appendHexDumpField(localStringBuilder, 0, MACHINE_ID.length), 4), 4), 8), 4);
    return localStringBuilder.substring(0, localStringBuilder.length() - 1);
  }
  
  private int writeInt(int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = this.data;
    int i = paramInt1 + 1;
    arrayOfByte[paramInt1] = ((byte)(byte)(paramInt2 >>> 24));
    paramInt1 = i + 1;
    arrayOfByte[i] = ((byte)(byte)(paramInt2 >>> 16));
    i = paramInt1 + 1;
    arrayOfByte[paramInt1] = ((byte)(byte)(paramInt2 >>> 8));
    arrayOfByte[i] = ((byte)(byte)paramInt2);
    return i + 1;
  }
  
  private int writeLong(int paramInt, long paramLong)
  {
    byte[] arrayOfByte = this.data;
    int i = paramInt + 1;
    arrayOfByte[paramInt] = ((byte)(byte)(int)(paramLong >>> 56));
    int j = i + 1;
    arrayOfByte[i] = ((byte)(byte)(int)(paramLong >>> 48));
    paramInt = j + 1;
    arrayOfByte[j] = ((byte)(byte)(int)(paramLong >>> 40));
    j = paramInt + 1;
    arrayOfByte[paramInt] = ((byte)(byte)(int)(paramLong >>> 32));
    paramInt = j + 1;
    arrayOfByte[j] = ((byte)(byte)(int)(paramLong >>> 24));
    j = paramInt + 1;
    arrayOfByte[paramInt] = ((byte)(byte)(int)(paramLong >>> 16));
    paramInt = j + 1;
    arrayOfByte[j] = ((byte)(byte)(int)(paramLong >>> 8));
    arrayOfByte[paramInt] = ((byte)(byte)(int)paramLong);
    return paramInt + 1;
  }
  
  public String asLongText()
  {
    String str1 = this.longValue;
    String str2 = str1;
    if (str1 == null)
    {
      str2 = newLongValue();
      this.longValue = str2;
    }
    return str2;
  }
  
  public String asShortText()
  {
    String str = this.shortValue;
    Object localObject = str;
    if (str == null)
    {
      localObject = this.data;
      localObject = ByteBufUtil.hexDump((byte[])localObject, localObject.length - 4, 4);
      this.shortValue = ((String)localObject);
    }
    return (String)localObject;
  }
  
  public int compareTo(ChannelId paramChannelId)
  {
    int i = 0;
    if (this == paramChannelId) {
      return 0;
    }
    if ((paramChannelId instanceof DefaultChannelId))
    {
      paramChannelId = ((DefaultChannelId)paramChannelId).data;
      int j = this.data.length;
      int k = paramChannelId.length;
      int m = Math.min(j, k);
      while (i < m)
      {
        int n = this.data[i];
        int i1 = paramChannelId[i];
        if (n != i1) {
          return (n & 0xFF) - (i1 & 0xFF);
        }
        i++;
      }
      return j - k;
    }
    return asLongText().compareTo(paramChannelId.asLongText());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof DefaultChannelId)) {
      return false;
    }
    paramObject = (DefaultChannelId)paramObject;
    if ((this.hashCode != ((DefaultChannelId)paramObject).hashCode) || (!Arrays.equals(this.data, ((DefaultChannelId)paramObject).data))) {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return this.hashCode;
  }
  
  public String toString()
  {
    return asShortText();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\DefaultChannelId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */