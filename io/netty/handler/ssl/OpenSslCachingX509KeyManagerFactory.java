package io.netty.handler.ssl;

import io.netty.util.internal.ObjectUtil;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.KeyManagerFactorySpi;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.X509KeyManager;

public final class OpenSslCachingX509KeyManagerFactory
  extends KeyManagerFactory
{
  private final int maxCachedEntries;
  
  public OpenSslCachingX509KeyManagerFactory(KeyManagerFactory paramKeyManagerFactory)
  {
    this(paramKeyManagerFactory, 1024);
  }
  
  public OpenSslCachingX509KeyManagerFactory(KeyManagerFactory paramKeyManagerFactory, int paramInt)
  {
    super(new KeyManagerFactorySpi()
    {
      protected KeyManager[] engineGetKeyManagers()
      {
        return OpenSslCachingX509KeyManagerFactory.this.getKeyManagers();
      }
      
      protected void engineInit(KeyStore paramAnonymousKeyStore, char[] paramAnonymousArrayOfChar)
        throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException
      {
        OpenSslCachingX509KeyManagerFactory.this.init(paramAnonymousKeyStore, paramAnonymousArrayOfChar);
      }
      
      protected void engineInit(ManagerFactoryParameters paramAnonymousManagerFactoryParameters)
        throws InvalidAlgorithmParameterException
      {
        OpenSslCachingX509KeyManagerFactory.this.init(paramAnonymousManagerFactoryParameters);
      }
    }, paramKeyManagerFactory.getProvider(), paramKeyManagerFactory.getAlgorithm());
    this.maxCachedEntries = ObjectUtil.checkPositive(paramInt, "maxCachedEntries");
  }
  
  OpenSslKeyMaterialProvider newProvider(String paramString)
  {
    X509KeyManager localX509KeyManager = ReferenceCountedOpenSslContext.chooseX509KeyManager(getKeyManagers());
    if ("sun.security.ssl.X509KeyManagerImpl".equals(localX509KeyManager.getClass().getName())) {
      return new OpenSslKeyMaterialProvider(localX509KeyManager, paramString);
    }
    return new OpenSslCachingKeyMaterialProvider(ReferenceCountedOpenSslContext.chooseX509KeyManager(getKeyManagers()), paramString, this.maxCachedEntries);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\OpenSslCachingX509KeyManagerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */