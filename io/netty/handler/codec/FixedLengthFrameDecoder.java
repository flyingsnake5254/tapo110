package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

public class FixedLengthFrameDecoder
  extends ByteToMessageDecoder
{
  private final int frameLength;
  
  public FixedLengthFrameDecoder(int paramInt)
  {
    ObjectUtil.checkPositive(paramInt, "frameLength");
    this.frameLength = paramInt;
  }
  
  protected Object decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf)
    throws Exception
  {
    int i = paramByteBuf.readableBytes();
    int j = this.frameLength;
    if (i < j) {
      return null;
    }
    return paramByteBuf.readRetainedSlice(j);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\FixedLengthFrameDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */