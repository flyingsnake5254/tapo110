package io.netty.handler.codec.redis;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.ByteProcessor;
import io.netty.util.CharsetUtil;
import java.util.List;

public final class RedisDecoder
  extends ByteToMessageDecoder
{
  private final boolean decodeInlineCommands;
  private final int maxInlineMessageLength;
  private final RedisMessagePool messagePool;
  private int remainingBulkLength;
  private State state = State.DECODE_TYPE;
  private final ToPositiveLongProcessor toPositiveLongProcessor = new ToPositiveLongProcessor(null);
  private RedisMessageType type;
  
  public RedisDecoder()
  {
    this(false);
  }
  
  public RedisDecoder(int paramInt, RedisMessagePool paramRedisMessagePool)
  {
    this(paramInt, paramRedisMessagePool, false);
  }
  
  public RedisDecoder(int paramInt, RedisMessagePool paramRedisMessagePool, boolean paramBoolean)
  {
    if ((paramInt > 0) && (paramInt <= 536870912))
    {
      this.maxInlineMessageLength = paramInt;
      this.messagePool = paramRedisMessagePool;
      this.decodeInlineCommands = paramBoolean;
      return;
    }
    paramRedisMessagePool = new StringBuilder();
    paramRedisMessagePool.append("maxInlineMessageLength: ");
    paramRedisMessagePool.append(paramInt);
    paramRedisMessagePool.append(" (expected: <= ");
    paramRedisMessagePool.append(536870912);
    paramRedisMessagePool.append(")");
    throw new RedisCodecException(paramRedisMessagePool.toString());
  }
  
  public RedisDecoder(boolean paramBoolean)
  {
    this(65536, FixedRedisMessagePool.INSTANCE, paramBoolean);
  }
  
  private boolean decodeBulkString(ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    int i = this.remainingBulkLength;
    if (i != -1)
    {
      if (i != 0)
      {
        paramList.add(new BulkStringHeaderRedisMessage(i));
        this.state = State.DECODE_BULK_STRING_CONTENT;
        return decodeBulkStringContent(paramByteBuf, paramList);
      }
      this.state = State.DECODE_BULK_STRING_EOL;
      return decodeBulkStringEndOfLine(paramByteBuf, paramList);
    }
    paramList.add(FullBulkStringRedisMessage.NULL_INSTANCE);
    resetDecoder();
    return true;
  }
  
  private boolean decodeBulkStringContent(ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    int i = paramByteBuf.readableBytes();
    if (i != 0)
    {
      int j = this.remainingBulkLength;
      if ((j != 0) || (i >= 2))
      {
        if (i >= j + 2)
        {
          ByteBuf localByteBuf = paramByteBuf.readSlice(j);
          readEndOfLine(paramByteBuf);
          paramList.add(new DefaultLastBulkStringRedisContent(localByteBuf.retain()));
          resetDecoder();
          return true;
        }
        i = Math.min(j, i);
        this.remainingBulkLength -= i;
        paramList.add(new DefaultBulkStringRedisContent(paramByteBuf.readSlice(i).retain()));
        return true;
      }
    }
    return false;
  }
  
  private boolean decodeBulkStringEndOfLine(ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    if (paramByteBuf.readableBytes() < 2) {
      return false;
    }
    readEndOfLine(paramByteBuf);
    paramList.add(FullBulkStringRedisMessage.EMPTY_INSTANCE);
    resetDecoder();
    return true;
  }
  
  private boolean decodeInline(ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    ByteBuf localByteBuf = readLine(paramByteBuf);
    if (localByteBuf == null)
    {
      if (paramByteBuf.readableBytes() <= this.maxInlineMessageLength) {
        return false;
      }
      paramList = new StringBuilder();
      paramList.append("length: ");
      paramList.append(paramByteBuf.readableBytes());
      paramList.append(" (expected: <= ");
      paramList.append(this.maxInlineMessageLength);
      paramList.append(")");
      throw new RedisCodecException(paramList.toString());
    }
    paramList.add(newInlineRedisMessage(this.type, localByteBuf));
    resetDecoder();
    return true;
  }
  
  private boolean decodeLength(ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    ByteBuf localByteBuf = readLine(paramByteBuf);
    if (localByteBuf == null) {
      return false;
    }
    long l = parseRedisNumber(localByteBuf);
    if (l >= -1L)
    {
      int i = 1.$SwitchMap$io$netty$handler$codec$redis$RedisMessageType[this.type.ordinal()];
      if (i != 1)
      {
        if (i == 2)
        {
          if (l <= 536870912L)
          {
            this.remainingBulkLength = ((int)l);
            return decodeBulkString(paramByteBuf, paramList);
          }
          paramByteBuf = new StringBuilder();
          paramByteBuf.append("length: ");
          paramByteBuf.append(l);
          paramByteBuf.append(" (expected: <= ");
          paramByteBuf.append(536870912);
          paramByteBuf.append(")");
          throw new RedisCodecException(paramByteBuf.toString());
        }
        paramByteBuf = new StringBuilder();
        paramByteBuf.append("bad type: ");
        paramByteBuf.append(this.type);
        throw new RedisCodecException(paramByteBuf.toString());
      }
      paramList.add(new ArrayHeaderRedisMessage(l));
      resetDecoder();
      return true;
    }
    paramByteBuf = new StringBuilder();
    paramByteBuf.append("length: ");
    paramByteBuf.append(l);
    paramByteBuf.append(" (expected: >= ");
    paramByteBuf.append(-1);
    paramByteBuf.append(")");
    throw new RedisCodecException(paramByteBuf.toString());
  }
  
  private boolean decodeType(ByteBuf paramByteBuf)
    throws Exception
  {
    if (!paramByteBuf.isReadable()) {
      return false;
    }
    paramByteBuf = RedisMessageType.readFrom(paramByteBuf, this.decodeInlineCommands);
    this.type = paramByteBuf;
    if (paramByteBuf.isInline()) {
      paramByteBuf = State.DECODE_INLINE;
    } else {
      paramByteBuf = State.DECODE_LENGTH;
    }
    this.state = paramByteBuf;
    return true;
  }
  
  private a newInlineRedisMessage(RedisMessageType paramRedisMessageType, ByteBuf paramByteBuf)
  {
    int i = 1.$SwitchMap$io$netty$handler$codec$redis$RedisMessageType[paramRedisMessageType.ordinal()];
    if (i != 3)
    {
      if (i != 4)
      {
        if (i != 5)
        {
          if (i == 6)
          {
            paramRedisMessageType = this.messagePool.getInteger(paramByteBuf);
            if (paramRedisMessageType == null) {
              paramRedisMessageType = new IntegerRedisMessage(parseRedisNumber(paramByteBuf));
            }
            return paramRedisMessageType;
          }
          paramByteBuf = new StringBuilder();
          paramByteBuf.append("bad type: ");
          paramByteBuf.append(paramRedisMessageType);
          throw new RedisCodecException(paramByteBuf.toString());
        }
        paramRedisMessageType = this.messagePool.getError(paramByteBuf);
        if (paramRedisMessageType == null) {
          paramRedisMessageType = new ErrorRedisMessage(paramByteBuf.toString(CharsetUtil.UTF_8));
        }
        return paramRedisMessageType;
      }
      paramRedisMessageType = this.messagePool.getSimpleString(paramByteBuf);
      if (paramRedisMessageType == null) {
        paramRedisMessageType = new SimpleStringRedisMessage(paramByteBuf.toString(CharsetUtil.UTF_8));
      }
      return paramRedisMessageType;
    }
    return new InlineCommandRedisMessage(paramByteBuf.toString(CharsetUtil.UTF_8));
  }
  
  private long parsePositiveNumber(ByteBuf paramByteBuf)
  {
    this.toPositiveLongProcessor.reset();
    paramByteBuf.forEachByte(this.toPositiveLongProcessor);
    return this.toPositiveLongProcessor.content();
  }
  
  private long parseRedisNumber(ByteBuf paramByteBuf)
  {
    int i = paramByteBuf.readableBytes();
    int j;
    if ((i > 0) && (paramByteBuf.getByte(paramByteBuf.readerIndex()) == 45)) {
      j = 1;
    } else {
      j = 0;
    }
    if (i > j)
    {
      if (i <= j + 19)
      {
        if (j != 0) {
          return -parsePositiveNumber(paramByteBuf.skipBytes(j));
        }
        return parsePositiveNumber(paramByteBuf);
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("too many characters to be a valid RESP Integer: ");
      localStringBuilder.append(paramByteBuf.toString(CharsetUtil.US_ASCII));
      throw new RedisCodecException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("no number to parse: ");
    localStringBuilder.append(paramByteBuf.toString(CharsetUtil.US_ASCII));
    throw new RedisCodecException(localStringBuilder.toString());
  }
  
  private static void readEndOfLine(ByteBuf paramByteBuf)
  {
    short s = paramByteBuf.readShort();
    if (RedisConstants.EOL_SHORT == s) {
      return;
    }
    byte[] arrayOfByte = RedisCodecUtil.shortToBytes(s);
    paramByteBuf = new StringBuilder();
    paramByteBuf.append("delimiter: [");
    paramByteBuf.append(arrayOfByte[0]);
    paramByteBuf.append(",");
    paramByteBuf.append(arrayOfByte[1]);
    paramByteBuf.append("] (expected: \\r\\n)");
    throw new RedisCodecException(paramByteBuf.toString());
  }
  
  private static ByteBuf readLine(ByteBuf paramByteBuf)
  {
    if (!paramByteBuf.isReadable(2)) {
      return null;
    }
    int i = paramByteBuf.forEachByte(ByteProcessor.FIND_LF);
    if (i < 0) {
      return null;
    }
    ByteBuf localByteBuf = paramByteBuf.readSlice(i - paramByteBuf.readerIndex() - 1);
    readEndOfLine(paramByteBuf);
    return localByteBuf;
  }
  
  private void resetDecoder()
  {
    this.state = State.DECODE_TYPE;
    this.remainingBulkLength = 0;
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    try
    {
      label92:
      label102:
      label112:
      label122:
      boolean bool;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                int i = 1.$SwitchMap$io$netty$handler$codec$redis$RedisDecoder$State[this.state.ordinal()];
                if (i == 1) {
                  break label122;
                }
                if (i == 2) {
                  break label112;
                }
                if (i == 3) {
                  break label102;
                }
                if (i == 4) {
                  break label92;
                }
                if (i != 5) {
                  break;
                }
              } while (decodeBulkStringContent(paramByteBuf, paramList));
              return;
              paramByteBuf = new io/netty/handler/codec/redis/RedisCodecException;
              paramChannelHandlerContext = new java/lang/StringBuilder;
              paramChannelHandlerContext.<init>();
              paramChannelHandlerContext.append("Unknown state: ");
              paramChannelHandlerContext.append(this.state);
              paramByteBuf.<init>(paramChannelHandlerContext.toString());
              throw paramByteBuf;
            } while (decodeBulkStringEndOfLine(paramByteBuf, paramList));
            return;
          } while (decodeLength(paramByteBuf, paramList));
          return;
        } while (decodeInline(paramByteBuf, paramList));
        return;
        bool = decodeType(paramByteBuf);
      } while (bool);
      return;
    }
    catch (Exception paramChannelHandlerContext)
    {
      resetDecoder();
      throw new RedisCodecException(paramChannelHandlerContext);
    }
    catch (RedisCodecException paramChannelHandlerContext)
    {
      resetDecoder();
      throw paramChannelHandlerContext;
    }
  }
  
  private static enum State
  {
    static
    {
      State localState1 = new State("DECODE_TYPE", 0);
      DECODE_TYPE = localState1;
      State localState2 = new State("DECODE_INLINE", 1);
      DECODE_INLINE = localState2;
      State localState3 = new State("DECODE_LENGTH", 2);
      DECODE_LENGTH = localState3;
      State localState4 = new State("DECODE_BULK_STRING_EOL", 3);
      DECODE_BULK_STRING_EOL = localState4;
      State localState5 = new State("DECODE_BULK_STRING_CONTENT", 4);
      DECODE_BULK_STRING_CONTENT = localState5;
      $VALUES = new State[] { localState1, localState2, localState3, localState4, localState5 };
    }
  }
  
  private static final class ToPositiveLongProcessor
    implements ByteProcessor
  {
    private long result;
    
    public long content()
    {
      return this.result;
    }
    
    public boolean process(byte paramByte)
      throws Exception
    {
      if ((paramByte >= 48) && (paramByte <= 57))
      {
        this.result = (this.result * 10L + (paramByte - 48));
        return true;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bad byte in number: ");
      localStringBuilder.append(paramByte);
      throw new RedisCodecException(localStringBuilder.toString());
    }
    
    public void reset()
    {
      this.result = 0L;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\redis\RedisDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */