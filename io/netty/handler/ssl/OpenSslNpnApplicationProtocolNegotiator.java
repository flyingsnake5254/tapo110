package io.netty.handler.ssl;

import io.netty.util.internal.ObjectUtil;
import java.util.List;

@Deprecated
public final class OpenSslNpnApplicationProtocolNegotiator
  implements OpenSslApplicationProtocolNegotiator
{
  private final List<String> protocols;
  
  public OpenSslNpnApplicationProtocolNegotiator(Iterable<String> paramIterable)
  {
    this.protocols = ((List)ObjectUtil.checkNotNull(ApplicationProtocolUtil.toList(paramIterable), "protocols"));
  }
  
  public OpenSslNpnApplicationProtocolNegotiator(String... paramVarArgs)
  {
    this.protocols = ((List)ObjectUtil.checkNotNull(ApplicationProtocolUtil.toList(paramVarArgs), "protocols"));
  }
  
  public ApplicationProtocolConfig.Protocol protocol()
  {
    return ApplicationProtocolConfig.Protocol.NPN;
  }
  
  public List<String> protocols()
  {
    return this.protocols;
  }
  
  public ApplicationProtocolConfig.SelectedListenerFailureBehavior selectedListenerFailureBehavior()
  {
    return ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT;
  }
  
  public ApplicationProtocolConfig.SelectorFailureBehavior selectorFailureBehavior()
  {
    return ApplicationProtocolConfig.SelectorFailureBehavior.CHOOSE_MY_LAST_PROTOCOL;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\OpenSslNpnApplicationProtocolNegotiator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */