package io.netty.handler.codec.redis;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;
import io.netty.util.collection.LongObjectHashMap;
import io.netty.util.collection.LongObjectMap;
import java.util.HashMap;
import java.util.Map;

public final class FixedRedisMessagePool
  implements RedisMessagePool
{
  private static final String[] DEFAULT_ERRORS = { "ERR", "ERR index out of range", "ERR no such key", "ERR source and destination objects are the same", "ERR syntax error", "BUSY Redis is busy running a script. You can only call SCRIPT KILL or SHUTDOWN NOSAVE.", "BUSYKEY Target key name already exists.", "EXECABORT Transaction discarded because of previous errors.", "LOADING Redis is loading the dataset in memory", "MASTERDOWN Link with MASTER is down and slave-serve-stale-data is set to 'no'.", "MISCONF Redis is configured to save RDB snapshots, but is currently not able to persist on disk. Commands that may modify the data set are disabled. Please check Redis logs for details about the error.", "NOAUTH Authentication required.", "NOREPLICAS Not enough good slaves to write.", "NOSCRIPT No matching script. Please use EVAL.", "OOM command not allowed when used memory > 'maxmemory'.", "READONLY You can't write against a read only slave.", "WRONGTYPE Operation against a key holding the wrong kind of value" };
  private static final String[] DEFAULT_SIMPLE_STRINGS = { "OK", "PONG", "QUEUED" };
  public static final FixedRedisMessagePool INSTANCE = new FixedRedisMessagePool();
  private static final long MAX_CACHED_INTEGER_NUMBER = 128L;
  private static final long MIN_CACHED_INTEGER_NUMBER = -1L;
  private static final int SIZE_CACHED_INTEGER_NUMBER = 129;
  private final Map<ByteBuf, ErrorRedisMessage> byteBufToErrors;
  private final Map<ByteBuf, IntegerRedisMessage> byteBufToIntegers;
  private final Map<ByteBuf, SimpleStringRedisMessage> byteBufToSimpleStrings;
  private final LongObjectMap<byte[]> longToByteBufs;
  private final LongObjectMap<IntegerRedisMessage> longToIntegers;
  private final Map<String, ErrorRedisMessage> stringToErrors;
  private final Map<String, SimpleStringRedisMessage> stringToSimpleStrings;
  
  private FixedRedisMessagePool()
  {
    Object localObject1 = DEFAULT_SIMPLE_STRINGS;
    this.byteBufToSimpleStrings = new HashMap(localObject1.length, 1.0F);
    this.stringToSimpleStrings = new HashMap(localObject1.length, 1.0F);
    int i = localObject1.length;
    int j = 0;
    Object localObject2;
    Object localObject4;
    for (int k = 0; k < i; k++)
    {
      localObject2 = localObject1[k];
      localObject3 = Unpooled.unmodifiableBuffer(Unpooled.unreleasableBuffer(Unpooled.wrappedBuffer(((String)localObject2).getBytes(CharsetUtil.UTF_8))));
      localObject4 = new SimpleStringRedisMessage((String)localObject2);
      this.byteBufToSimpleStrings.put(localObject3, localObject4);
      this.stringToSimpleStrings.put(localObject2, localObject4);
    }
    Object localObject3 = DEFAULT_ERRORS;
    this.byteBufToErrors = new HashMap(localObject3.length, 1.0F);
    this.stringToErrors = new HashMap(localObject3.length, 1.0F);
    i = localObject3.length;
    for (k = j; k < i; k++)
    {
      localObject4 = localObject3[k];
      localObject2 = Unpooled.unmodifiableBuffer(Unpooled.unreleasableBuffer(Unpooled.wrappedBuffer(((String)localObject4).getBytes(CharsetUtil.UTF_8))));
      localObject1 = new ErrorRedisMessage((String)localObject4);
      this.byteBufToErrors.put(localObject2, localObject1);
      this.stringToErrors.put(localObject4, localObject1);
    }
    this.byteBufToIntegers = new HashMap(129, 1.0F);
    this.longToIntegers = new LongObjectHashMap(129, 1.0F);
    this.longToByteBufs = new LongObjectHashMap(129, 1.0F);
    for (long l = -1L; l < 128L; l += 1L)
    {
      localObject4 = RedisCodecUtil.longToAsciiBytes(l);
      localObject1 = Unpooled.unmodifiableBuffer(Unpooled.unreleasableBuffer(Unpooled.wrappedBuffer((byte[])localObject4)));
      localObject2 = new IntegerRedisMessage(l);
      this.byteBufToIntegers.put(localObject1, localObject2);
      this.longToIntegers.put(l, localObject2);
      this.longToByteBufs.put(l, localObject4);
    }
  }
  
  public byte[] getByteBufOfInteger(long paramLong)
  {
    return (byte[])this.longToByteBufs.get(paramLong);
  }
  
  public ErrorRedisMessage getError(ByteBuf paramByteBuf)
  {
    return (ErrorRedisMessage)this.byteBufToErrors.get(paramByteBuf);
  }
  
  public ErrorRedisMessage getError(String paramString)
  {
    return (ErrorRedisMessage)this.stringToErrors.get(paramString);
  }
  
  public IntegerRedisMessage getInteger(long paramLong)
  {
    return (IntegerRedisMessage)this.longToIntegers.get(paramLong);
  }
  
  public IntegerRedisMessage getInteger(ByteBuf paramByteBuf)
  {
    return (IntegerRedisMessage)this.byteBufToIntegers.get(paramByteBuf);
  }
  
  public SimpleStringRedisMessage getSimpleString(ByteBuf paramByteBuf)
  {
    return (SimpleStringRedisMessage)this.byteBufToSimpleStrings.get(paramByteBuf);
  }
  
  public SimpleStringRedisMessage getSimpleString(String paramString)
  {
    return (SimpleStringRedisMessage)this.stringToSimpleStrings.get(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\redis\FixedRedisMessagePool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */