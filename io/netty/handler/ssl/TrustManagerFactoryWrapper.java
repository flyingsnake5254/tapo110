package io.netty.handler.ssl;

import io.netty.handler.ssl.util.SimpleTrustManagerFactory;
import io.netty.util.internal.ObjectUtil;
import java.security.KeyStore;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.TrustManager;

final class TrustManagerFactoryWrapper
  extends SimpleTrustManagerFactory
{
  private final TrustManager tm;
  
  TrustManagerFactoryWrapper(TrustManager paramTrustManager)
  {
    this.tm = ((TrustManager)ObjectUtil.checkNotNull(paramTrustManager, "tm"));
  }
  
  protected TrustManager[] engineGetTrustManagers()
  {
    return new TrustManager[] { this.tm };
  }
  
  protected void engineInit(KeyStore paramKeyStore)
    throws Exception
  {}
  
  protected void engineInit(ManagerFactoryParameters paramManagerFactoryParameters)
    throws Exception
  {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\TrustManagerFactoryWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */