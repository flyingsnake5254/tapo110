package io.netty.handler.codec.marshalling;

import io.netty.channel.ChannelHandlerContext;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.MarshallingConfiguration;
import org.jboss.marshalling.Unmarshaller;

public class DefaultUnmarshallerProvider
  implements UnmarshallerProvider
{
  private final MarshallingConfiguration config;
  private final MarshallerFactory factory;
  
  public DefaultUnmarshallerProvider(MarshallerFactory paramMarshallerFactory, MarshallingConfiguration paramMarshallingConfiguration)
  {
    this.factory = paramMarshallerFactory;
    this.config = paramMarshallingConfiguration;
  }
  
  public Unmarshaller getUnmarshaller(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    return this.factory.createUnmarshaller(this.config);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\marshalling\DefaultUnmarshallerProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */