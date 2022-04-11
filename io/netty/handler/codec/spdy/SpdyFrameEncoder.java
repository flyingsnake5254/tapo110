package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.internal.ObjectUtil;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.Set;

public class SpdyFrameEncoder
{
  private final int version;
  
  public SpdyFrameEncoder(SpdyVersion paramSpdyVersion)
  {
    this.version = ((SpdyVersion)ObjectUtil.checkNotNull(paramSpdyVersion, "spdyVersion")).getVersion();
  }
  
  private void writeControlFrameHeader(ByteBuf paramByteBuf, int paramInt1, byte paramByte, int paramInt2)
  {
    paramByteBuf.writeShort(this.version | 0x8000);
    paramByteBuf.writeShort(paramInt1);
    paramByteBuf.writeByte(paramByte);
    paramByteBuf.writeMedium(paramInt2);
  }
  
  public ByteBuf encodeDataFrame(ByteBufAllocator paramByteBufAllocator, int paramInt, boolean paramBoolean, ByteBuf paramByteBuf)
  {
    int i = paramByteBuf.readableBytes();
    paramByteBufAllocator = paramByteBufAllocator.ioBuffer(i + 8).order(ByteOrder.BIG_ENDIAN);
    paramByteBufAllocator.writeInt(paramInt & 0x7FFFFFFF);
    paramByteBufAllocator.writeByte(paramBoolean);
    paramByteBufAllocator.writeMedium(i);
    paramByteBufAllocator.writeBytes(paramByteBuf, paramByteBuf.readerIndex(), i);
    return paramByteBufAllocator;
  }
  
  public ByteBuf encodeGoAwayFrame(ByteBufAllocator paramByteBufAllocator, int paramInt1, int paramInt2)
  {
    paramByteBufAllocator = paramByteBufAllocator.ioBuffer(16).order(ByteOrder.BIG_ENDIAN);
    writeControlFrameHeader(paramByteBufAllocator, 7, (byte)0, 8);
    paramByteBufAllocator.writeInt(paramInt1);
    paramByteBufAllocator.writeInt(paramInt2);
    return paramByteBufAllocator;
  }
  
  public ByteBuf encodeHeadersFrame(ByteBufAllocator paramByteBufAllocator, int paramInt, boolean paramBoolean, ByteBuf paramByteBuf)
  {
    int i = paramByteBuf.readableBytes();
    int j = i + 4;
    paramByteBufAllocator = paramByteBufAllocator.ioBuffer(j + 8).order(ByteOrder.BIG_ENDIAN);
    writeControlFrameHeader(paramByteBufAllocator, 8, paramBoolean, j);
    paramByteBufAllocator.writeInt(paramInt);
    paramByteBufAllocator.writeBytes(paramByteBuf, paramByteBuf.readerIndex(), i);
    return paramByteBufAllocator;
  }
  
  public ByteBuf encodePingFrame(ByteBufAllocator paramByteBufAllocator, int paramInt)
  {
    paramByteBufAllocator = paramByteBufAllocator.ioBuffer(12).order(ByteOrder.BIG_ENDIAN);
    writeControlFrameHeader(paramByteBufAllocator, 6, (byte)0, 4);
    paramByteBufAllocator.writeInt(paramInt);
    return paramByteBufAllocator;
  }
  
  public ByteBuf encodeRstStreamFrame(ByteBufAllocator paramByteBufAllocator, int paramInt1, int paramInt2)
  {
    paramByteBufAllocator = paramByteBufAllocator.ioBuffer(16).order(ByteOrder.BIG_ENDIAN);
    writeControlFrameHeader(paramByteBufAllocator, 3, (byte)0, 8);
    paramByteBufAllocator.writeInt(paramInt1);
    paramByteBufAllocator.writeInt(paramInt2);
    return paramByteBufAllocator;
  }
  
  public ByteBuf encodeSettingsFrame(ByteBufAllocator paramByteBufAllocator, SpdySettingsFrame paramSpdySettingsFrame)
  {
    Object localObject = paramSpdySettingsFrame.ids();
    int i = ((Set)localObject).size();
    int j = paramSpdySettingsFrame.clearPreviouslyPersistedSettings();
    int k = i * 8 + 4;
    paramByteBufAllocator = paramByteBufAllocator.ioBuffer(k + 8).order(ByteOrder.BIG_ENDIAN);
    writeControlFrameHeader(paramByteBufAllocator, 4, j, k);
    paramByteBufAllocator.writeInt(i);
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      i = 0;
      if (paramSpdySettingsFrame.isPersistValue(localInteger.intValue())) {
        i = (byte)1;
      }
      k = i;
      if (paramSpdySettingsFrame.isPersisted(localInteger.intValue())) {
        k = (byte)(i | 0x2);
      }
      paramByteBufAllocator.writeByte(k);
      paramByteBufAllocator.writeMedium(localInteger.intValue());
      paramByteBufAllocator.writeInt(paramSpdySettingsFrame.getValue(localInteger.intValue()));
    }
    return paramByteBufAllocator;
  }
  
  public ByteBuf encodeSynReplyFrame(ByteBufAllocator paramByteBufAllocator, int paramInt, boolean paramBoolean, ByteBuf paramByteBuf)
  {
    int i = paramByteBuf.readableBytes();
    int j = i + 4;
    paramByteBufAllocator = paramByteBufAllocator.ioBuffer(j + 8).order(ByteOrder.BIG_ENDIAN);
    writeControlFrameHeader(paramByteBufAllocator, 2, paramBoolean, j);
    paramByteBufAllocator.writeInt(paramInt);
    paramByteBufAllocator.writeBytes(paramByteBuf, paramByteBuf.readerIndex(), i);
    return paramByteBufAllocator;
  }
  
  public ByteBuf encodeSynStreamFrame(ByteBufAllocator paramByteBufAllocator, int paramInt1, int paramInt2, byte paramByte, boolean paramBoolean1, boolean paramBoolean2, ByteBuf paramByteBuf)
  {
    int i = paramByteBuf.readableBytes();
    int j = paramBoolean1;
    if (paramBoolean2)
    {
      paramBoolean1 = (byte)(paramBoolean1 | true);
      j = paramBoolean1;
    }
    paramBoolean1 = i + 10;
    paramByteBufAllocator = paramByteBufAllocator.ioBuffer(paramBoolean1 + true).order(ByteOrder.BIG_ENDIAN);
    writeControlFrameHeader(paramByteBufAllocator, 1, j, paramBoolean1);
    paramByteBufAllocator.writeInt(paramInt1);
    paramByteBufAllocator.writeInt(paramInt2);
    paramByteBufAllocator.writeShort((paramByte & 0xFF) << 13);
    paramByteBufAllocator.writeBytes(paramByteBuf, paramByteBuf.readerIndex(), i);
    return paramByteBufAllocator;
  }
  
  public ByteBuf encodeWindowUpdateFrame(ByteBufAllocator paramByteBufAllocator, int paramInt1, int paramInt2)
  {
    paramByteBufAllocator = paramByteBufAllocator.ioBuffer(16).order(ByteOrder.BIG_ENDIAN);
    writeControlFrameHeader(paramByteBufAllocator, 9, (byte)0, 8);
    paramByteBufAllocator.writeInt(paramInt1);
    paramByteBufAllocator.writeInt(paramInt2);
    return paramByteBufAllocator;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\SpdyFrameEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */