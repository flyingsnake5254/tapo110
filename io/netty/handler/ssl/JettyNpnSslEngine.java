package io.netty.handler.ssl;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.util.LinkedHashSet;
import java.util.List;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;
import org.eclipse.jetty.npn.NextProtoNego;
import org.eclipse.jetty.npn.NextProtoNego.ClientProvider;
import org.eclipse.jetty.npn.NextProtoNego.ServerProvider;

final class JettyNpnSslEngine
  extends JdkSslEngine
{
  private static boolean available;
  
  JettyNpnSslEngine(SSLEngine paramSSLEngine, final JdkApplicationProtocolNegotiator paramJdkApplicationProtocolNegotiator, boolean paramBoolean)
  {
    super(paramSSLEngine);
    ObjectUtil.checkNotNull(paramJdkApplicationProtocolNegotiator, "applicationNegotiator");
    if (paramBoolean) {
      NextProtoNego.put(paramSSLEngine, new NextProtoNego.ServerProvider()
      {
        /* Error */
        public void protocolSelected(String paramAnonymousString)
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 22	io/netty/handler/ssl/JettyNpnSslEngine$1:val$protocolListener	Lio/netty/handler/ssl/JdkApplicationProtocolNegotiator$ProtocolSelectionListener;
          //   4: aload_1
          //   5: invokeinterface 35 2 0
          //   10: goto +8 -> 18
          //   13: astore_1
          //   14: aload_1
          //   15: invokestatic 41	io/netty/util/internal/PlatformDependent:throwException	(Ljava/lang/Throwable;)V
          //   18: return
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	19	0	this	1
          //   0	19	1	paramAnonymousString	String
          // Exception table:
          //   from	to	target	type
          //   0	10	13	finally
        }
        
        public List<String> protocols()
        {
          return paramJdkApplicationProtocolNegotiator.protocols();
        }
        
        public void unsupported()
        {
          this.val$protocolListener.unsupported();
        }
      });
    } else {
      NextProtoNego.put(paramSSLEngine, new NextProtoNego.ClientProvider()
      {
        public String selectProtocol(List<String> paramAnonymousList)
        {
          try
          {
            paramAnonymousList = this.val$protocolSelector.select(paramAnonymousList);
            return paramAnonymousList;
          }
          finally
          {
            PlatformDependent.throwException(paramAnonymousList);
          }
          return null;
        }
        
        public boolean supports()
        {
          return true;
        }
        
        public void unsupported()
        {
          this.val$protocolSelector.unsupported();
        }
      });
    }
  }
  
  static boolean isAvailable()
  {
    updateAvailability();
    return available;
  }
  
  private static void updateAvailability()
  {
    if (available) {
      return;
    }
    try
    {
      Class.forName("sun.security.ssl.NextProtoNegoExtension", true, null);
      available = true;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void closeInbound()
    throws SSLException
  {
    NextProtoNego.remove(getWrappedEngine());
    super.closeInbound();
  }
  
  public void closeOutbound()
  {
    NextProtoNego.remove(getWrappedEngine());
    super.closeOutbound();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\JettyNpnSslEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */