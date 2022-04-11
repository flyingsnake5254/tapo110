package io.netty.handler.ssl.util;

import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public final class InsecureTrustManagerFactory
  extends SimpleTrustManagerFactory
{
  public static final TrustManagerFactory INSTANCE = new InsecureTrustManagerFactory();
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(InsecureTrustManagerFactory.class);
  private static final TrustManager tm = new X509TrustManager()
  {
    public void checkClientTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
    {
      if (InsecureTrustManagerFactory.logger.isDebugEnabled())
      {
        InternalLogger localInternalLogger = InsecureTrustManagerFactory.logger;
        paramAnonymousString = new StringBuilder();
        paramAnonymousString.append("Accepting a client certificate: ");
        paramAnonymousString.append(paramAnonymousArrayOfX509Certificate[0].getSubjectDN());
        localInternalLogger.debug(paramAnonymousString.toString());
      }
    }
    
    public void checkServerTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
    {
      if (InsecureTrustManagerFactory.logger.isDebugEnabled())
      {
        InternalLogger localInternalLogger = InsecureTrustManagerFactory.logger;
        paramAnonymousString = new StringBuilder();
        paramAnonymousString.append("Accepting a server certificate: ");
        paramAnonymousString.append(paramAnonymousArrayOfX509Certificate[0].getSubjectDN());
        localInternalLogger.debug(paramAnonymousString.toString());
      }
    }
    
    public X509Certificate[] getAcceptedIssuers()
    {
      return EmptyArrays.EMPTY_X509_CERTIFICATES;
    }
  };
  
  protected TrustManager[] engineGetTrustManagers()
  {
    return new TrustManager[] { tm };
  }
  
  protected void engineInit(KeyStore paramKeyStore)
    throws Exception
  {}
  
  protected void engineInit(ManagerFactoryParameters paramManagerFactoryParameters)
    throws Exception
  {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\util\InsecureTrustManagerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */