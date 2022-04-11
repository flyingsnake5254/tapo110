package io.netty.handler.codec.marshalling;

import io.netty.channel.ChannelHandlerContext;
import org.jboss.marshalling.Marshaller;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.MarshallingConfiguration;

public class DefaultMarshallerProvider
  implements MarshallerProvider
{
  private final MarshallingConfiguration config;
  private final MarshallerFactory factory;
  
  public DefaultMarshallerProvider(MarshallerFactory paramMarshallerFactory, MarshallingConfiguration paramMarshallingConfiguration)
  {
    this.factory = paramMarshallerFactory;
    this.config = paramMarshallingConfiguration;
  }
  
  public Marshaller getMarshaller(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    return this.factory.createMarshaller(this.config);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\marshalling\DefaultMarshallerProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */