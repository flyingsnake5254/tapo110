package io.netty.handler.codec.marshalling;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.concurrent.FastThreadLocal;
import org.jboss.marshalling.Marshaller;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.MarshallingConfiguration;

public class ThreadLocalMarshallerProvider
  implements MarshallerProvider
{
  private final MarshallingConfiguration config;
  private final MarshallerFactory factory;
  private final FastThreadLocal<Marshaller> marshallers = new FastThreadLocal();
  
  public ThreadLocalMarshallerProvider(MarshallerFactory paramMarshallerFactory, MarshallingConfiguration paramMarshallingConfiguration)
  {
    this.factory = paramMarshallerFactory;
    this.config = paramMarshallingConfiguration;
  }
  
  public Marshaller getMarshaller(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    Marshaller localMarshaller = (Marshaller)this.marshallers.get();
    paramChannelHandlerContext = localMarshaller;
    if (localMarshaller == null)
    {
      paramChannelHandlerContext = this.factory.createMarshaller(this.config);
      this.marshallers.set(paramChannelHandlerContext);
    }
    return paramChannelHandlerContext;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\marshalling\ThreadLocalMarshallerProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */