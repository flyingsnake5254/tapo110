package io.netty.handler.codec.marshalling;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.netty.util.AttributeMap;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.MarshallingConfiguration;
import org.jboss.marshalling.Unmarshaller;

public class ContextBoundUnmarshallerProvider
  extends DefaultUnmarshallerProvider
{
  private static final AttributeKey<Unmarshaller> UNMARSHALLER = AttributeKey.valueOf(ContextBoundUnmarshallerProvider.class, "UNMARSHALLER");
  
  public ContextBoundUnmarshallerProvider(MarshallerFactory paramMarshallerFactory, MarshallingConfiguration paramMarshallingConfiguration)
  {
    super(paramMarshallerFactory, paramMarshallingConfiguration);
  }
  
  public Unmarshaller getUnmarshaller(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    Attribute localAttribute = paramChannelHandlerContext.channel().attr(UNMARSHALLER);
    Unmarshaller localUnmarshaller1 = (Unmarshaller)localAttribute.get();
    Unmarshaller localUnmarshaller2 = localUnmarshaller1;
    if (localUnmarshaller1 == null)
    {
      localUnmarshaller2 = super.getUnmarshaller(paramChannelHandlerContext);
      localAttribute.set(localUnmarshaller2);
    }
    return localUnmarshaller2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\marshalling\ContextBoundUnmarshallerProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */