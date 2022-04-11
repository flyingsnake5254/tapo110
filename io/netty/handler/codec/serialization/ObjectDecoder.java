package io.netty.handler.codec.serialization;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import java.io.ObjectInputStream;

public class ObjectDecoder
  extends LengthFieldBasedFrameDecoder
{
  private final ClassResolver classResolver;
  
  public ObjectDecoder(int paramInt, ClassResolver paramClassResolver)
  {
    super(paramInt, 0, 4, 0, 4);
    this.classResolver = paramClassResolver;
  }
  
  public ObjectDecoder(ClassResolver paramClassResolver)
  {
    this(1048576, paramClassResolver);
  }
  
  protected Object decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf)
    throws Exception
  {
    paramChannelHandlerContext = (ByteBuf)super.decode(paramChannelHandlerContext, paramByteBuf);
    if (paramChannelHandlerContext == null) {
      return null;
    }
    paramChannelHandlerContext = new CompactObjectInputStream(new ByteBufInputStream(paramChannelHandlerContext, true), this.classResolver);
    try
    {
      paramByteBuf = paramChannelHandlerContext.readObject();
      return paramByteBuf;
    }
    finally
    {
      paramChannelHandlerContext.close();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\serialization\ObjectDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */