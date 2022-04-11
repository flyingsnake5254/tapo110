package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.nio.ByteOrder;
import java.util.List;

public class LengthFieldBasedFrameDecoder
  extends ByteToMessageDecoder
{
  private final ByteOrder byteOrder;
  private long bytesToDiscard;
  private boolean discardingTooLongFrame;
  private final boolean failFast;
  private final int initialBytesToStrip;
  private final int lengthAdjustment;
  private final int lengthFieldEndOffset;
  private final int lengthFieldLength;
  private final int lengthFieldOffset;
  private final int maxFrameLength;
  private long tooLongFrameLength;
  
  public LengthFieldBasedFrameDecoder(int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramInt1, paramInt2, paramInt3, 0, 0);
  }
  
  public LengthFieldBasedFrameDecoder(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, true);
  }
  
  public LengthFieldBasedFrameDecoder(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    this(ByteOrder.BIG_ENDIAN, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean);
  }
  
  public LengthFieldBasedFrameDecoder(ByteOrder paramByteOrder, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    this.byteOrder = ((ByteOrder)ObjectUtil.checkNotNull(paramByteOrder, "byteOrder"));
    ObjectUtil.checkPositive(paramInt1, "maxFrameLength");
    ObjectUtil.checkPositiveOrZero(paramInt2, "lengthFieldOffset");
    ObjectUtil.checkPositiveOrZero(paramInt5, "initialBytesToStrip");
    if (paramInt2 <= paramInt1 - paramInt3)
    {
      this.maxFrameLength = paramInt1;
      this.lengthFieldOffset = paramInt2;
      this.lengthFieldLength = paramInt3;
      this.lengthAdjustment = paramInt4;
      this.lengthFieldEndOffset = (paramInt2 + paramInt3);
      this.initialBytesToStrip = paramInt5;
      this.failFast = paramBoolean;
      return;
    }
    paramByteOrder = new StringBuilder();
    paramByteOrder.append("maxFrameLength (");
    paramByteOrder.append(paramInt1);
    paramByteOrder.append(") must be equal to or greater than lengthFieldOffset (");
    paramByteOrder.append(paramInt2);
    paramByteOrder.append(") + lengthFieldLength (");
    paramByteOrder.append(paramInt3);
    paramByteOrder.append(").");
    throw new IllegalArgumentException(paramByteOrder.toString());
  }
  
  private void discardingTooLongFrame(ByteBuf paramByteBuf)
  {
    long l = this.bytesToDiscard;
    int i = (int)Math.min(l, paramByteBuf.readableBytes());
    paramByteBuf.skipBytes(i);
    this.bytesToDiscard = (l - i);
    failIfNecessary(false);
  }
  
  private void exceededFrameLength(ByteBuf paramByteBuf, long paramLong)
  {
    long l = paramLong - paramByteBuf.readableBytes();
    this.tooLongFrameLength = paramLong;
    if (l < 0L)
    {
      paramByteBuf.skipBytes((int)paramLong);
    }
    else
    {
      this.discardingTooLongFrame = true;
      this.bytesToDiscard = l;
      paramByteBuf.skipBytes(paramByteBuf.readableBytes());
    }
    failIfNecessary(true);
  }
  
  private void fail(long paramLong)
  {
    if (paramLong > 0L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Adjusted frame length exceeds ");
      localStringBuilder.append(this.maxFrameLength);
      localStringBuilder.append(": ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" - discarded");
      throw new TooLongFrameException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Adjusted frame length exceeds ");
    localStringBuilder.append(this.maxFrameLength);
    localStringBuilder.append(" - discarding");
    throw new TooLongFrameException(localStringBuilder.toString());
  }
  
  private void failIfNecessary(boolean paramBoolean)
  {
    if (this.bytesToDiscard == 0L)
    {
      long l = this.tooLongFrameLength;
      this.tooLongFrameLength = 0L;
      this.discardingTooLongFrame = false;
      if ((!this.failFast) || (paramBoolean)) {
        fail(l);
      }
    }
    else if ((this.failFast) && (paramBoolean))
    {
      fail(this.tooLongFrameLength);
    }
  }
  
  private static void failOnFrameLengthLessThanInitialBytesToStrip(ByteBuf paramByteBuf, long paramLong, int paramInt)
  {
    paramByteBuf.skipBytes((int)paramLong);
    paramByteBuf = new StringBuilder();
    paramByteBuf.append("Adjusted frame length (");
    paramByteBuf.append(paramLong);
    paramByteBuf.append(") is less than initialBytesToStrip: ");
    paramByteBuf.append(paramInt);
    throw new CorruptedFrameException(paramByteBuf.toString());
  }
  
  private static void failOnFrameLengthLessThanLengthFieldEndOffset(ByteBuf paramByteBuf, long paramLong, int paramInt)
  {
    paramByteBuf.skipBytes(paramInt);
    paramByteBuf = new StringBuilder();
    paramByteBuf.append("Adjusted frame length (");
    paramByteBuf.append(paramLong);
    paramByteBuf.append(") is less than lengthFieldEndOffset: ");
    paramByteBuf.append(paramInt);
    throw new CorruptedFrameException(paramByteBuf.toString());
  }
  
  private static void failOnNegativeLengthField(ByteBuf paramByteBuf, long paramLong, int paramInt)
  {
    paramByteBuf.skipBytes(paramInt);
    paramByteBuf = new StringBuilder();
    paramByteBuf.append("negative pre-adjustment length field: ");
    paramByteBuf.append(paramLong);
    throw new CorruptedFrameException(paramByteBuf.toString());
  }
  
  protected Object decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf)
    throws Exception
  {
    if (this.discardingTooLongFrame) {
      discardingTooLongFrame(paramByteBuf);
    }
    if (paramByteBuf.readableBytes() < this.lengthFieldEndOffset) {
      return null;
    }
    long l = getUnadjustedFrameLength(paramByteBuf, paramByteBuf.readerIndex() + this.lengthFieldOffset, this.lengthFieldLength, this.byteOrder);
    if (l < 0L) {
      failOnNegativeLengthField(paramByteBuf, l, this.lengthFieldEndOffset);
    }
    int i = this.lengthAdjustment;
    int j = this.lengthFieldEndOffset;
    l += i + j;
    if (l < j) {
      failOnFrameLengthLessThanLengthFieldEndOffset(paramByteBuf, l, j);
    }
    if (l > this.maxFrameLength)
    {
      exceededFrameLength(paramByteBuf, l);
      return null;
    }
    j = (int)l;
    if (paramByteBuf.readableBytes() < j) {
      return null;
    }
    i = this.initialBytesToStrip;
    if (i > j) {
      failOnFrameLengthLessThanInitialBytesToStrip(paramByteBuf, l, i);
    }
    paramByteBuf.skipBytes(this.initialBytesToStrip);
    i = paramByteBuf.readerIndex();
    j -= this.initialBytesToStrip;
    paramChannelHandlerContext = extractFrame(paramChannelHandlerContext, paramByteBuf, i, j);
    paramByteBuf.readerIndex(i + j);
    return paramChannelHandlerContext;
  }
  
  protected final void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    paramChannelHandlerContext = decode(paramChannelHandlerContext, paramByteBuf);
    if (paramChannelHandlerContext != null) {
      paramList.add(paramChannelHandlerContext);
    }
  }
  
  protected ByteBuf extractFrame(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    return paramByteBuf.retainedSlice(paramInt1, paramInt2);
  }
  
  protected long getUnadjustedFrameLength(ByteBuf paramByteBuf, int paramInt1, int paramInt2, ByteOrder paramByteOrder)
  {
    paramByteBuf = paramByteBuf.order(paramByteOrder);
    if (paramInt2 != 1)
    {
      if (paramInt2 != 2)
      {
        if (paramInt2 != 3)
        {
          if (paramInt2 != 4)
          {
            if (paramInt2 == 8)
            {
              l = paramByteBuf.getLong(paramInt1);
              break label124;
            }
            paramByteBuf = new StringBuilder();
            paramByteBuf.append("unsupported lengthFieldLength: ");
            paramByteBuf.append(this.lengthFieldLength);
            paramByteBuf.append(" (expected: 1, 2, 3, 4, or 8)");
            throw new DecoderException(paramByteBuf.toString());
          }
          l = paramByteBuf.getUnsignedInt(paramInt1);
          break label124;
        }
        paramInt1 = paramByteBuf.getUnsignedMedium(paramInt1);
      }
      else
      {
        paramInt1 = paramByteBuf.getUnsignedShort(paramInt1);
      }
    }
    else {
      paramInt1 = paramByteBuf.getUnsignedByte(paramInt1);
    }
    long l = paramInt1;
    label124:
    return l;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\LengthFieldBasedFrameDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */