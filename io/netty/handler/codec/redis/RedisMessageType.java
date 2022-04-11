package io.netty.handler.codec.redis;

import io.netty.buffer.ByteBuf;

public enum RedisMessageType
{
  private final boolean inline;
  private final Byte value;
  
  static
  {
    RedisMessageType localRedisMessageType1 = new RedisMessageType("INLINE_COMMAND", 0, null, true);
    INLINE_COMMAND = localRedisMessageType1;
    RedisMessageType localRedisMessageType2 = new RedisMessageType("SIMPLE_STRING", 1, Byte.valueOf((byte)43), true);
    SIMPLE_STRING = localRedisMessageType2;
    RedisMessageType localRedisMessageType3 = new RedisMessageType("ERROR", 2, Byte.valueOf((byte)45), true);
    ERROR = localRedisMessageType3;
    RedisMessageType localRedisMessageType4 = new RedisMessageType("INTEGER", 3, Byte.valueOf((byte)58), true);
    INTEGER = localRedisMessageType4;
    RedisMessageType localRedisMessageType5 = new RedisMessageType("BULK_STRING", 4, Byte.valueOf((byte)36), false);
    BULK_STRING = localRedisMessageType5;
    RedisMessageType localRedisMessageType6 = new RedisMessageType("ARRAY_HEADER", 5, Byte.valueOf((byte)42), false);
    ARRAY_HEADER = localRedisMessageType6;
    $VALUES = new RedisMessageType[] { localRedisMessageType1, localRedisMessageType2, localRedisMessageType3, localRedisMessageType4, localRedisMessageType5, localRedisMessageType6 };
  }
  
  private RedisMessageType(Byte paramByte, boolean paramBoolean)
  {
    this.value = paramByte;
    this.inline = paramBoolean;
  }
  
  public static RedisMessageType readFrom(ByteBuf paramByteBuf, boolean paramBoolean)
  {
    int i = paramByteBuf.readerIndex();
    RedisMessageType localRedisMessageType = valueOf(paramByteBuf.readByte());
    if (localRedisMessageType == INLINE_COMMAND) {
      if (paramBoolean) {
        paramByteBuf.readerIndex(i);
      } else {
        throw new RedisCodecException("Decoding of inline commands is disabled");
      }
    }
    return localRedisMessageType;
  }
  
  private static RedisMessageType valueOf(byte paramByte)
  {
    if (paramByte != 36)
    {
      if (paramByte != 45)
      {
        if (paramByte != 58)
        {
          if (paramByte != 42)
          {
            if (paramByte != 43) {
              return INLINE_COMMAND;
            }
            return SIMPLE_STRING;
          }
          return ARRAY_HEADER;
        }
        return INTEGER;
      }
      return ERROR;
    }
    return BULK_STRING;
  }
  
  public boolean isInline()
  {
    return this.inline;
  }
  
  public int length()
  {
    int i;
    if (this.value != null) {
      i = 1;
    } else {
      i = 0;
    }
    return i;
  }
  
  public void writeTo(ByteBuf paramByteBuf)
  {
    Byte localByte = this.value;
    if (localByte == null) {
      return;
    }
    paramByteBuf.writeByte(localByte.byteValue());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\redis\RedisMessageType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */