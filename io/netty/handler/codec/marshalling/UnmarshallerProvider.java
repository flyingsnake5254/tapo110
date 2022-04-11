package io.netty.handler.codec.marshalling;

import io.netty.channel.ChannelHandlerContext;
import org.jboss.marshalling.Unmarshaller;

public abstract interface UnmarshallerProvider
{
  public abstract Unmarshaller getUnmarshaller(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\marshalling\UnmarshallerProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */