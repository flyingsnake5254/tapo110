package io.netty.handler.ssl;

import io.netty.util.internal.ObjectUtil;
import java.util.List;

@Deprecated
public final class OpenSslDefaultApplicationProtocolNegotiator
  implements OpenSslApplicationProtocolNegotiator
{
  private final ApplicationProtocolConfig config;
  
  public OpenSslDefaultApplicationProtocolNegotiator(ApplicationProtocolConfig paramApplicationProtocolConfig)
  {
    this.config = ((ApplicationProtocolConfig)ObjectUtil.checkNotNull(paramApplicationProtocolConfig, "config"));
  }
  
  public ApplicationProtocolConfig.Protocol protocol()
  {
    return this.config.protocol();
  }
  
  public List<String> protocols()
  {
    return this.config.supportedProtocols();
  }
  
  public ApplicationProtocolConfig.SelectedListenerFailureBehavior selectedListenerFailureBehavior()
  {
    return this.config.selectedListenerFailureBehavior();
  }
  
  public ApplicationProtocolConfig.SelectorFailureBehavior selectorFailureBehavior()
  {
    return this.config.selectorFailureBehavior();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\OpenSslDefaultApplicationProtocolNegotiator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */