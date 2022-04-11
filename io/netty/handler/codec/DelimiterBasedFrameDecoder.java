package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

public class DelimiterBasedFrameDecoder
  extends ByteToMessageDecoder
{
  private final ByteBuf[] delimiters;
  private boolean discardingTooLongFrame;
  private final boolean failFast;
  private final LineBasedFrameDecoder lineBasedDecoder;
  private final int maxFrameLength;
  private final boolean stripDelimiter;
  private int tooLongFrameLength;
  
  public DelimiterBasedFrameDecoder(int paramInt, ByteBuf paramByteBuf)
  {
    this(paramInt, true, paramByteBuf);
  }
  
  public DelimiterBasedFrameDecoder(int paramInt, boolean paramBoolean, ByteBuf paramByteBuf)
  {
    this(paramInt, paramBoolean, true, paramByteBuf);
  }
  
  public DelimiterBasedFrameDecoder(int paramInt, boolean paramBoolean1, boolean paramBoolean2, ByteBuf paramByteBuf)
  {
    this(paramInt, paramBoolean1, paramBoolean2, new ByteBuf[] { paramByteBuf.slice(paramByteBuf.readerIndex(), paramByteBuf.readableBytes()) });
  }
  
  public DelimiterBasedFrameDecoder(int paramInt, boolean paramBoolean1, boolean paramBoolean2, ByteBuf... paramVarArgs)
  {
    validateMaxFrameLength(paramInt);
    ObjectUtil.checkNonEmpty(paramVarArgs, "delimiters");
    if ((isLineBased(paramVarArgs)) && (!isSubclass()))
    {
      this.lineBasedDecoder = new LineBasedFrameDecoder(paramInt, paramBoolean1, paramBoolean2);
      this.delimiters = null;
    }
    else
    {
      this.delimiters = new ByteBuf[paramVarArgs.length];
      for (int i = 0; i < paramVarArgs.length; i++)
      {
        ByteBuf localByteBuf = paramVarArgs[i];
        validateDelimiter(localByteBuf);
        this.delimiters[i] = localByteBuf.slice(localByteBuf.readerIndex(), localByteBuf.readableBytes());
      }
      this.lineBasedDecoder = null;
    }
    this.maxFrameLength = paramInt;
    this.stripDelimiter = paramBoolean1;
    this.failFast = paramBoolean2;
  }
  
  public DelimiterBasedFrameDecoder(int paramInt, boolean paramBoolean, ByteBuf... paramVarArgs)
  {
    this(paramInt, paramBoolean, true, paramVarArgs);
  }
  
  public DelimiterBasedFrameDecoder(int paramInt, ByteBuf... paramVarArgs)
  {
    this(paramInt, true, paramVarArgs);
  }
  
  private void fail(long paramLong)
  {
    if (paramLong > 0L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("frame length exceeds ");
      localStringBuilder.append(this.maxFrameLength);
      localStringBuilder.append(": ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" - discarded");
      throw new TooLongFrameException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("frame length exceeds ");
    localStringBuilder.append(this.maxFrameLength);
    localStringBuilder.append(" - discarding");
    throw new TooLongFrameException(localStringBuilder.toString());
  }
  
  private static int indexOf(ByteBuf paramByteBuf1, ByteBuf paramByteBuf2)
  {
    for (int i = paramByteBuf1.readerIndex(); i < paramByteBuf1.writerIndex(); i++)
    {
      int j = 0;
      int k = i;
      while ((j < paramByteBuf2.capacity()) && (paramByteBuf1.getByte(k) == paramByteBuf2.getByte(j)))
      {
        k++;
        if ((k == paramByteBuf1.writerIndex()) && (j != paramByteBuf2.capacity() - 1)) {
          return -1;
        }
        j++;
      }
      if (j == paramByteBuf2.capacity()) {
        return i - paramByteBuf1.readerIndex();
      }
    }
    return -1;
  }
  
  private static boolean isLineBased(ByteBuf[] paramArrayOfByteBuf)
  {
    int i = paramArrayOfByteBuf.length;
    boolean bool1 = false;
    if (i != 2) {
      return false;
    }
    ByteBuf localByteBuf1 = paramArrayOfByteBuf[0];
    ByteBuf localByteBuf2 = paramArrayOfByteBuf[1];
    ByteBuf localByteBuf3 = localByteBuf1;
    ByteBuf localByteBuf4 = localByteBuf2;
    if (localByteBuf1.capacity() < localByteBuf2.capacity())
    {
      localByteBuf3 = paramArrayOfByteBuf[1];
      localByteBuf4 = paramArrayOfByteBuf[0];
    }
    boolean bool2 = bool1;
    if (localByteBuf3.capacity() == 2)
    {
      bool2 = bool1;
      if (localByteBuf4.capacity() == 1)
      {
        bool2 = bool1;
        if (localByteBuf3.getByte(0) == 13)
        {
          bool2 = bool1;
          if (localByteBuf3.getByte(1) == 10)
          {
            bool2 = bool1;
            if (localByteBuf4.getByte(0) == 10) {
              bool2 = true;
            }
          }
        }
      }
    }
    return bool2;
  }
  
  private boolean isSubclass()
  {
    boolean bool;
    if (getClass() != DelimiterBasedFrameDecoder.class) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static void validateDelimiter(ByteBuf paramByteBuf)
  {
    ObjectUtil.checkNotNull(paramByteBuf, "delimiter");
    if (paramByteBuf.isReadable()) {
      return;
    }
    throw new IllegalArgumentException("empty delimiter");
  }
  
  private static void validateMaxFrameLength(int paramInt)
  {
    ObjectUtil.checkPositive(paramInt, "maxFrameLength");
  }
  
  protected Object decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf)
    throws Exception
  {
    Object localObject = this.lineBasedDecoder;
    if (localObject != null) {
      return ((LineBasedFrameDecoder)localObject).decode(paramChannelHandlerContext, paramByteBuf);
    }
    int i = Integer.MAX_VALUE;
    ByteBuf[] arrayOfByteBuf = this.delimiters;
    int j = arrayOfByteBuf.length;
    paramChannelHandlerContext = null;
    int k = 0;
    int n;
    while (k < j)
    {
      ByteBuf localByteBuf = arrayOfByteBuf[k];
      int m = indexOf(paramByteBuf, localByteBuf);
      localObject = paramChannelHandlerContext;
      n = i;
      if (m >= 0)
      {
        localObject = paramChannelHandlerContext;
        n = i;
        if (m < i)
        {
          localObject = localByteBuf;
          n = m;
        }
      }
      k++;
      paramChannelHandlerContext = (ChannelHandlerContext)localObject;
      i = n;
    }
    if (paramChannelHandlerContext != null)
    {
      n = paramChannelHandlerContext.capacity();
      if (this.discardingTooLongFrame)
      {
        this.discardingTooLongFrame = false;
        paramByteBuf.skipBytes(i + n);
        i = this.tooLongFrameLength;
        this.tooLongFrameLength = 0;
        if (!this.failFast) {
          fail(i);
        }
        return null;
      }
      if (i > this.maxFrameLength)
      {
        paramByteBuf.skipBytes(n + i);
        fail(i);
        return null;
      }
      if (this.stripDelimiter)
      {
        paramChannelHandlerContext = paramByteBuf.readRetainedSlice(i);
        paramByteBuf.skipBytes(n);
      }
      else
      {
        paramChannelHandlerContext = paramByteBuf.readRetainedSlice(i + n);
      }
      return paramChannelHandlerContext;
    }
    if (!this.discardingTooLongFrame)
    {
      if (paramByteBuf.readableBytes() > this.maxFrameLength)
      {
        this.tooLongFrameLength = paramByteBuf.readableBytes();
        paramByteBuf.skipBytes(paramByteBuf.readableBytes());
        this.discardingTooLongFrame = true;
        if (this.failFast) {
          fail(this.tooLongFrameLength);
        }
      }
    }
    else
    {
      this.tooLongFrameLength += paramByteBuf.readableBytes();
      paramByteBuf.skipBytes(paramByteBuf.readableBytes());
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\DelimiterBasedFrameDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */