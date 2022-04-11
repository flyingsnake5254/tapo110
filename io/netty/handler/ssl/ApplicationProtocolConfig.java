package io.netty.handler.ssl;

import io.netty.util.internal.ObjectUtil;
import java.util.Collections;
import java.util.List;

public final class ApplicationProtocolConfig
{
  public static final ApplicationProtocolConfig DISABLED = new ApplicationProtocolConfig();
  private final Protocol protocol;
  private final SelectedListenerFailureBehavior selectedBehavior;
  private final SelectorFailureBehavior selectorBehavior;
  private final List<String> supportedProtocols;
  
  private ApplicationProtocolConfig()
  {
    this.supportedProtocols = Collections.emptyList();
    this.protocol = Protocol.NONE;
    this.selectorBehavior = SelectorFailureBehavior.CHOOSE_MY_LAST_PROTOCOL;
    this.selectedBehavior = SelectedListenerFailureBehavior.ACCEPT;
  }
  
  public ApplicationProtocolConfig(Protocol paramProtocol, SelectorFailureBehavior paramSelectorFailureBehavior, SelectedListenerFailureBehavior paramSelectedListenerFailureBehavior, Iterable<String> paramIterable)
  {
    this(paramProtocol, paramSelectorFailureBehavior, paramSelectedListenerFailureBehavior, ApplicationProtocolUtil.toList(paramIterable));
  }
  
  private ApplicationProtocolConfig(Protocol paramProtocol, SelectorFailureBehavior paramSelectorFailureBehavior, SelectedListenerFailureBehavior paramSelectedListenerFailureBehavior, List<String> paramList)
  {
    this.supportedProtocols = Collections.unmodifiableList((List)ObjectUtil.checkNotNull(paramList, "supportedProtocols"));
    this.protocol = ((Protocol)ObjectUtil.checkNotNull(paramProtocol, "protocol"));
    this.selectorBehavior = ((SelectorFailureBehavior)ObjectUtil.checkNotNull(paramSelectorFailureBehavior, "selectorBehavior"));
    this.selectedBehavior = ((SelectedListenerFailureBehavior)ObjectUtil.checkNotNull(paramSelectedListenerFailureBehavior, "selectedBehavior"));
    paramSelectorFailureBehavior = Protocol.NONE;
    if (paramProtocol != paramSelectorFailureBehavior)
    {
      if (!paramList.isEmpty()) {
        return;
      }
      throw new IllegalArgumentException("supportedProtocols must be not empty");
    }
    paramProtocol = new StringBuilder();
    paramProtocol.append("protocol (");
    paramProtocol.append(paramSelectorFailureBehavior);
    paramProtocol.append(") must not be ");
    paramProtocol.append(paramSelectorFailureBehavior);
    paramProtocol.append('.');
    throw new IllegalArgumentException(paramProtocol.toString());
  }
  
  public ApplicationProtocolConfig(Protocol paramProtocol, SelectorFailureBehavior paramSelectorFailureBehavior, SelectedListenerFailureBehavior paramSelectedListenerFailureBehavior, String... paramVarArgs)
  {
    this(paramProtocol, paramSelectorFailureBehavior, paramSelectedListenerFailureBehavior, ApplicationProtocolUtil.toList(paramVarArgs));
  }
  
  public Protocol protocol()
  {
    return this.protocol;
  }
  
  public SelectedListenerFailureBehavior selectedListenerFailureBehavior()
  {
    return this.selectedBehavior;
  }
  
  public SelectorFailureBehavior selectorFailureBehavior()
  {
    return this.selectorBehavior;
  }
  
  public List<String> supportedProtocols()
  {
    return this.supportedProtocols;
  }
  
  public static enum Protocol
  {
    static
    {
      Protocol localProtocol1 = new Protocol("NONE", 0);
      NONE = localProtocol1;
      Protocol localProtocol2 = new Protocol("NPN", 1);
      NPN = localProtocol2;
      Protocol localProtocol3 = new Protocol("ALPN", 2);
      ALPN = localProtocol3;
      Protocol localProtocol4 = new Protocol("NPN_AND_ALPN", 3);
      NPN_AND_ALPN = localProtocol4;
      $VALUES = new Protocol[] { localProtocol1, localProtocol2, localProtocol3, localProtocol4 };
    }
  }
  
  public static enum SelectedListenerFailureBehavior
  {
    static
    {
      SelectedListenerFailureBehavior localSelectedListenerFailureBehavior1 = new SelectedListenerFailureBehavior("ACCEPT", 0);
      ACCEPT = localSelectedListenerFailureBehavior1;
      SelectedListenerFailureBehavior localSelectedListenerFailureBehavior2 = new SelectedListenerFailureBehavior("FATAL_ALERT", 1);
      FATAL_ALERT = localSelectedListenerFailureBehavior2;
      SelectedListenerFailureBehavior localSelectedListenerFailureBehavior3 = new SelectedListenerFailureBehavior("CHOOSE_MY_LAST_PROTOCOL", 2);
      CHOOSE_MY_LAST_PROTOCOL = localSelectedListenerFailureBehavior3;
      $VALUES = new SelectedListenerFailureBehavior[] { localSelectedListenerFailureBehavior1, localSelectedListenerFailureBehavior2, localSelectedListenerFailureBehavior3 };
    }
  }
  
  public static enum SelectorFailureBehavior
  {
    static
    {
      SelectorFailureBehavior localSelectorFailureBehavior1 = new SelectorFailureBehavior("FATAL_ALERT", 0);
      FATAL_ALERT = localSelectorFailureBehavior1;
      SelectorFailureBehavior localSelectorFailureBehavior2 = new SelectorFailureBehavior("NO_ADVERTISE", 1);
      NO_ADVERTISE = localSelectorFailureBehavior2;
      SelectorFailureBehavior localSelectorFailureBehavior3 = new SelectorFailureBehavior("CHOOSE_MY_LAST_PROTOCOL", 2);
      CHOOSE_MY_LAST_PROTOCOL = localSelectorFailureBehavior3;
      $VALUES = new SelectorFailureBehavior[] { localSelectorFailureBehavior1, localSelectorFailureBehavior2, localSelectorFailureBehavior3 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\ApplicationProtocolConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */