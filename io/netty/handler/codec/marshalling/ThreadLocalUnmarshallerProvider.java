package io.netty.handler.codec.marshalling;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.concurrent.FastThreadLocal;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.MarshallingConfiguration;
import org.jboss.marshalling.Unmarshaller;

public class ThreadLocalUnmarshallerProvider
  implements UnmarshallerProvider
{
  private final MarshallingConfiguration config;
  private final MarshallerFactory factory;
  private final FastThreadLocal<Unmarshaller> unmarshallers = new FastThreadLocal();
  
  public ThreadLocalUnmarshallerProvider(MarshallerFactory paramMarshallerFactory, MarshallingConfiguration paramMarshallingConfiguration)
  {
    this.factory = paramMarshallerFactory;
    this.config = paramMarshallingConfiguration;
  }
  
  public Unmarshaller getUnmarshaller(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    Unmarshaller localUnmarshaller = (Unmarshaller)this.unmarshallers.get();
    paramChannelHandlerContext = localUnmarshaller;
    if (localUnmarshaller == null)
    {
      paramChannelHandlerContext = this.factory.createUnmarshaller(this.config);
      this.unmarshallers.set(paramChannelHandlerContext);
    }
    return paramChannelHandlerContext;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\marshalling\ThreadLocalUnmarshallerProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */