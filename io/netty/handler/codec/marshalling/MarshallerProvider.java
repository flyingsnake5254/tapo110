package io.netty.handler.codec.marshalling;

import io.netty.channel.ChannelHandlerContext;
import org.jboss.marshalling.Marshaller;

public abstract interface MarshallerProvider
{
  public abstract Marshaller getMarshaller(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\marshalling\MarshallerProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */