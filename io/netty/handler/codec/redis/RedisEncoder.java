package io.netty.handler.codec.redis;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.CodecException;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.internal.ObjectUtil;
import java.util.Iterator;
import java.util.List;

public class RedisEncoder
  extends MessageToMessageEncoder<a>
{
  private final RedisMessagePool messagePool;
  
  public RedisEncoder()
  {
    this(FixedRedisMessagePool.INSTANCE);
  }
  
  public RedisEncoder(RedisMessagePool paramRedisMessagePool)
  {
    this.messagePool = ((RedisMessagePool)ObjectUtil.checkNotNull(paramRedisMessagePool, "messagePool"));
  }
  
  private byte[] numberToBytes(long paramLong)
  {
    byte[] arrayOfByte = this.messagePool.getByteBufOfInteger(paramLong);
    if (arrayOfByte == null) {
      arrayOfByte = RedisCodecUtil.longToAsciiBytes(paramLong);
    }
    return arrayOfByte;
  }
  
  private void writeArrayHeader(ByteBufAllocator paramByteBufAllocator, ArrayHeaderRedisMessage paramArrayHeaderRedisMessage, List<Object> paramList)
  {
    writeArrayHeader(paramByteBufAllocator, paramArrayHeaderRedisMessage.isNull(), paramArrayHeaderRedisMessage.length(), paramList);
  }
  
  private void writeArrayHeader(ByteBufAllocator paramByteBufAllocator, boolean paramBoolean, long paramLong, List<Object> paramList)
  {
    if (paramBoolean)
    {
      paramByteBufAllocator = paramByteBufAllocator.ioBuffer(5);
      RedisMessageType.ARRAY_HEADER.writeTo(paramByteBufAllocator);
      paramByteBufAllocator.writeShort(RedisConstants.NULL_SHORT);
      paramByteBufAllocator.writeShort(RedisConstants.EOL_SHORT);
      paramList.add(paramByteBufAllocator);
    }
    else
    {
      paramByteBufAllocator = paramByteBufAllocator.ioBuffer(23);
      RedisMessageType.ARRAY_HEADER.writeTo(paramByteBufAllocator);
      paramByteBufAllocator.writeBytes(numberToBytes(paramLong));
      paramByteBufAllocator.writeShort(RedisConstants.EOL_SHORT);
      paramList.add(paramByteBufAllocator);
    }
  }
  
  private void writeArrayMessage(ByteBufAllocator paramByteBufAllocator, ArrayRedisMessage paramArrayRedisMessage, List<Object> paramList)
  {
    if (paramArrayRedisMessage.isNull())
    {
      writeArrayHeader(paramByteBufAllocator, paramArrayRedisMessage.isNull(), -1L, paramList);
    }
    else
    {
      writeArrayHeader(paramByteBufAllocator, paramArrayRedisMessage.isNull(), paramArrayRedisMessage.children().size(), paramList);
      paramArrayRedisMessage = paramArrayRedisMessage.children().iterator();
      while (paramArrayRedisMessage.hasNext()) {
        writeRedisMessage(paramByteBufAllocator, (a)paramArrayRedisMessage.next(), paramList);
      }
    }
  }
  
  private static void writeBulkStringContent(ByteBufAllocator paramByteBufAllocator, BulkStringRedisContent paramBulkStringRedisContent, List<Object> paramList)
  {
    paramList.add(paramBulkStringRedisContent.content().retain());
    if ((paramBulkStringRedisContent instanceof LastBulkStringRedisContent)) {
      paramList.add(paramByteBufAllocator.ioBuffer(2).writeShort(RedisConstants.EOL_SHORT));
    }
  }
  
  private void writeBulkStringHeader(ByteBufAllocator paramByteBufAllocator, BulkStringHeaderRedisMessage paramBulkStringHeaderRedisMessage, List<Object> paramList)
  {
    int i;
    if (paramBulkStringHeaderRedisMessage.isNull()) {
      i = 2;
    } else {
      i = 22;
    }
    paramByteBufAllocator = paramByteBufAllocator.ioBuffer(i + 1);
    RedisMessageType.BULK_STRING.writeTo(paramByteBufAllocator);
    if (paramBulkStringHeaderRedisMessage.isNull())
    {
      paramByteBufAllocator.writeShort(RedisConstants.NULL_SHORT);
    }
    else
    {
      paramByteBufAllocator.writeBytes(numberToBytes(paramBulkStringHeaderRedisMessage.bulkStringLength()));
      paramByteBufAllocator.writeShort(RedisConstants.EOL_SHORT);
    }
    paramList.add(paramByteBufAllocator);
  }
  
  private static void writeErrorMessage(ByteBufAllocator paramByteBufAllocator, ErrorRedisMessage paramErrorRedisMessage, List<Object> paramList)
  {
    writeString(paramByteBufAllocator, RedisMessageType.ERROR, paramErrorRedisMessage.content(), paramList);
  }
  
  private void writeFullBulkStringMessage(ByteBufAllocator paramByteBufAllocator, FullBulkStringRedisMessage paramFullBulkStringRedisMessage, List<Object> paramList)
  {
    if (paramFullBulkStringRedisMessage.isNull())
    {
      paramByteBufAllocator = paramByteBufAllocator.ioBuffer(5);
      RedisMessageType.BULK_STRING.writeTo(paramByteBufAllocator);
      paramByteBufAllocator.writeShort(RedisConstants.NULL_SHORT);
      paramByteBufAllocator.writeShort(RedisConstants.EOL_SHORT);
      paramList.add(paramByteBufAllocator);
    }
    else
    {
      ByteBuf localByteBuf = paramByteBufAllocator.ioBuffer(23);
      RedisMessageType.BULK_STRING.writeTo(localByteBuf);
      localByteBuf.writeBytes(numberToBytes(paramFullBulkStringRedisMessage.content().readableBytes()));
      int i = RedisConstants.EOL_SHORT;
      localByteBuf.writeShort(i);
      paramList.add(localByteBuf);
      paramList.add(paramFullBulkStringRedisMessage.content().retain());
      paramList.add(paramByteBufAllocator.ioBuffer(2).writeShort(i));
    }
  }
  
  private static void writeInlineCommandMessage(ByteBufAllocator paramByteBufAllocator, InlineCommandRedisMessage paramInlineCommandRedisMessage, List<Object> paramList)
  {
    writeString(paramByteBufAllocator, RedisMessageType.INLINE_COMMAND, paramInlineCommandRedisMessage.content(), paramList);
  }
  
  private void writeIntegerMessage(ByteBufAllocator paramByteBufAllocator, IntegerRedisMessage paramIntegerRedisMessage, List<Object> paramList)
  {
    paramByteBufAllocator = paramByteBufAllocator.ioBuffer(23);
    RedisMessageType.INTEGER.writeTo(paramByteBufAllocator);
    paramByteBufAllocator.writeBytes(numberToBytes(paramIntegerRedisMessage.value()));
    paramByteBufAllocator.writeShort(RedisConstants.EOL_SHORT);
    paramList.add(paramByteBufAllocator);
  }
  
  private void writeRedisMessage(ByteBufAllocator paramByteBufAllocator, a parama, List<Object> paramList)
  {
    if ((parama instanceof InlineCommandRedisMessage))
    {
      writeInlineCommandMessage(paramByteBufAllocator, (InlineCommandRedisMessage)parama, paramList);
    }
    else if ((parama instanceof SimpleStringRedisMessage))
    {
      writeSimpleStringMessage(paramByteBufAllocator, (SimpleStringRedisMessage)parama, paramList);
    }
    else if ((parama instanceof ErrorRedisMessage))
    {
      writeErrorMessage(paramByteBufAllocator, (ErrorRedisMessage)parama, paramList);
    }
    else if ((parama instanceof IntegerRedisMessage))
    {
      writeIntegerMessage(paramByteBufAllocator, (IntegerRedisMessage)parama, paramList);
    }
    else if ((parama instanceof FullBulkStringRedisMessage))
    {
      writeFullBulkStringMessage(paramByteBufAllocator, (FullBulkStringRedisMessage)parama, paramList);
    }
    else if ((parama instanceof BulkStringRedisContent))
    {
      writeBulkStringContent(paramByteBufAllocator, (BulkStringRedisContent)parama, paramList);
    }
    else if ((parama instanceof BulkStringHeaderRedisMessage))
    {
      writeBulkStringHeader(paramByteBufAllocator, (BulkStringHeaderRedisMessage)parama, paramList);
    }
    else if ((parama instanceof ArrayHeaderRedisMessage))
    {
      writeArrayHeader(paramByteBufAllocator, (ArrayHeaderRedisMessage)parama, paramList);
    }
    else
    {
      if (!(parama instanceof ArrayRedisMessage)) {
        break label174;
      }
      writeArrayMessage(paramByteBufAllocator, (ArrayRedisMessage)parama, paramList);
    }
    return;
    label174:
    paramByteBufAllocator = new StringBuilder();
    paramByteBufAllocator.append("unknown message type: ");
    paramByteBufAllocator.append(parama);
    throw new CodecException(paramByteBufAllocator.toString());
  }
  
  private static void writeSimpleStringMessage(ByteBufAllocator paramByteBufAllocator, SimpleStringRedisMessage paramSimpleStringRedisMessage, List<Object> paramList)
  {
    writeString(paramByteBufAllocator, RedisMessageType.SIMPLE_STRING, paramSimpleStringRedisMessage.content(), paramList);
  }
  
  private static void writeString(ByteBufAllocator paramByteBufAllocator, RedisMessageType paramRedisMessageType, String paramString, List<Object> paramList)
  {
    paramByteBufAllocator = paramByteBufAllocator.ioBuffer(paramRedisMessageType.length() + ByteBufUtil.utf8MaxBytes(paramString) + 2);
    paramRedisMessageType.writeTo(paramByteBufAllocator);
    ByteBufUtil.writeUtf8(paramByteBufAllocator, paramString);
    paramByteBufAllocator.writeShort(RedisConstants.EOL_SHORT);
    paramList.add(paramByteBufAllocator);
  }
  
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, a parama, List<Object> paramList)
    throws Exception
  {
    try
    {
      writeRedisMessage(paramChannelHandlerContext.alloc(), parama, paramList);
      return;
    }
    catch (Exception paramChannelHandlerContext)
    {
      throw new CodecException(paramChannelHandlerContext);
    }
    catch (CodecException paramChannelHandlerContext)
    {
      throw paramChannelHandlerContext;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\redis\RedisEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */