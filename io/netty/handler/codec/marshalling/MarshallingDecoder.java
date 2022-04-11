package io.netty.handler.codec.marshalling;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import org.jboss.marshalling.Unmarshaller;

public class MarshallingDecoder
  extends LengthFieldBasedFrameDecoder
{
  private final UnmarshallerProvider provider;
  
  public MarshallingDecoder(UnmarshallerProvider paramUnmarshallerProvider)
  {
    this(paramUnmarshallerProvider, 1048576);
  }
  
  public MarshallingDecoder(UnmarshallerProvider paramUnmarshallerProvider, int paramInt)
  {
    super(paramInt, 0, 4, 0, 4);
    this.provider = paramUnmarshallerProvider;
  }
  
  protected Object decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf)
    throws Exception
  {
    paramByteBuf = (ByteBuf)super.decode(paramChannelHandlerContext, paramByteBuf);
    if (paramByteBuf == null) {
      return null;
    }
    paramChannelHandlerContext = this.provider.getUnmarshaller(paramChannelHandlerContext);
    paramByteBuf = new ChannelBufferByteInput(paramByteBuf);
    try
    {
      paramChannelHandlerContext.start(paramByteBuf);
      paramByteBuf = paramChannelHandlerContext.readObject();
      paramChannelHandlerContext.finish();
      return paramByteBuf;
    }
    finally
    {
      paramChannelHandlerContext.close();
    }
  }
  
  protected ByteBuf extractFrame(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    return paramByteBuf.slice(paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\marshalling\MarshallingDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */