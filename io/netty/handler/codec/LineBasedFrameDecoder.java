package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ByteProcessor;
import java.util.List;

public class LineBasedFrameDecoder
  extends ByteToMessageDecoder
{
  private int discardedBytes;
  private boolean discarding;
  private final boolean failFast;
  private final int maxLength;
  private int offset;
  private final boolean stripDelimiter;
  
  public LineBasedFrameDecoder(int paramInt)
  {
    this(paramInt, true, false);
  }
  
  public LineBasedFrameDecoder(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.maxLength = paramInt;
    this.failFast = paramBoolean2;
    this.stripDelimiter = paramBoolean1;
  }
  
  private void fail(ChannelHandlerContext paramChannelHandlerContext, int paramInt)
  {
    fail(paramChannelHandlerContext, String.valueOf(paramInt));
  }
  
  private void fail(ChannelHandlerContext paramChannelHandlerContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("frame length (");
    localStringBuilder.append(paramString);
    localStringBuilder.append(") exceeds the allowed maximum (");
    localStringBuilder.append(this.maxLength);
    localStringBuilder.append(')');
    paramChannelHandlerContext.fireExceptionCaught(new TooLongFrameException(localStringBuilder.toString()));
  }
  
  private int findEndOfLine(ByteBuf paramByteBuf)
  {
    int i = paramByteBuf.readableBytes();
    int j = paramByteBuf.readerIndex();
    int k = this.offset;
    k = paramByteBuf.forEachByte(j + k, i - k, ByteProcessor.FIND_LF);
    if (k >= 0)
    {
      this.offset = 0;
      i = k;
      if (k > 0)
      {
        i = k;
        if (paramByteBuf.getByte(k - 1) == 13) {
          i = k - 1;
        }
      }
    }
    else
    {
      this.offset = i;
      i = k;
    }
    return i;
  }
  
  protected Object decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf)
    throws Exception
  {
    int i = findEndOfLine(paramByteBuf);
    boolean bool = this.discarding;
    int j = 2;
    int k;
    if (!bool)
    {
      if (i >= 0)
      {
        k = i - paramByteBuf.readerIndex();
        if (paramByteBuf.getByte(i) != 13) {
          j = 1;
        }
        if (k > this.maxLength)
        {
          paramByteBuf.readerIndex(i + j);
          fail(paramChannelHandlerContext, k);
          return null;
        }
        if (this.stripDelimiter)
        {
          paramChannelHandlerContext = paramByteBuf.readRetainedSlice(k);
          paramByteBuf.skipBytes(j);
        }
        else
        {
          paramChannelHandlerContext = paramByteBuf.readRetainedSlice(k + j);
        }
        return paramChannelHandlerContext;
      }
      j = paramByteBuf.readableBytes();
      if (j > this.maxLength)
      {
        this.discardedBytes = j;
        paramByteBuf.readerIndex(paramByteBuf.writerIndex());
        this.discarding = true;
        this.offset = 0;
        if (this.failFast)
        {
          paramByteBuf = new StringBuilder();
          paramByteBuf.append("over ");
          paramByteBuf.append(this.discardedBytes);
          fail(paramChannelHandlerContext, paramByteBuf.toString());
        }
      }
      return null;
    }
    if (i >= 0)
    {
      k = this.discardedBytes;
      int m = paramByteBuf.readerIndex();
      if (paramByteBuf.getByte(i) != 13) {
        j = 1;
      }
      paramByteBuf.readerIndex(i + j);
      this.discardedBytes = 0;
      this.discarding = false;
      if (!this.failFast) {
        fail(paramChannelHandlerContext, k + i - m);
      }
    }
    else
    {
      this.discardedBytes += paramByteBuf.readableBytes();
      paramByteBuf.readerIndex(paramByteBuf.writerIndex());
      this.offset = 0;
    }
    return null;
  }
  
  protected final void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    paramChannelHandlerContext = decode(paramChannelHandlerContext, paramByteBuf);
    if (paramChannelHandlerContext != null) {
      paramList.add(paramChannelHandlerContext);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\LineBasedFrameDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */