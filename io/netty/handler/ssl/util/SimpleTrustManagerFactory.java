package io.netty.handler.ssl.util;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.Provider;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.TrustManagerFactorySpi;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;

public abstract class SimpleTrustManagerFactory
  extends TrustManagerFactory
{
  private static final FastThreadLocal<SimpleTrustManagerFactorySpi> CURRENT_SPI = new FastThreadLocal()
  {
    protected SimpleTrustManagerFactory.SimpleTrustManagerFactorySpi initialValue()
    {
      return new SimpleTrustManagerFactory.SimpleTrustManagerFactorySpi();
    }
  };
  private static final Provider PROVIDER = new Provider("", 0.0D, "")
  {
    private static final long serialVersionUID = -2680540247105807895L;
  };
  
  protected SimpleTrustManagerFactory()
  {
    this("");
  }
  
  protected SimpleTrustManagerFactory(String paramString)
  {
    super((TrustManagerFactorySpi)localFastThreadLocal.get(), PROVIDER, paramString);
    ((SimpleTrustManagerFactorySpi)localFastThreadLocal.get()).init(this);
    localFastThreadLocal.remove();
    ObjectUtil.checkNotNull(paramString, "name");
  }
  
  protected abstract TrustManager[] engineGetTrustManagers();
  
  protected abstract void engineInit(KeyStore paramKeyStore)
    throws Exception;
  
  protected abstract void engineInit(ManagerFactoryParameters paramManagerFactoryParameters)
    throws Exception;
  
  static final class SimpleTrustManagerFactorySpi
    extends TrustManagerFactorySpi
  {
    private SimpleTrustManagerFactory parent;
    private volatile TrustManager[] trustManagers;
    
    @SuppressJava6Requirement(reason="Usage guarded by java version check")
    private static void wrapIfNeeded(TrustManager[] paramArrayOfTrustManager)
    {
      for (int i = 0; i < paramArrayOfTrustManager.length; i++)
      {
        TrustManager localTrustManager = paramArrayOfTrustManager[i];
        if (((localTrustManager instanceof X509TrustManager)) && (!(localTrustManager instanceof X509ExtendedTrustManager))) {
          paramArrayOfTrustManager[i] = new X509TrustManagerWrapper((X509TrustManager)localTrustManager);
        }
      }
    }
    
    protected TrustManager[] engineGetTrustManagers()
    {
      TrustManager[] arrayOfTrustManager1 = this.trustManagers;
      TrustManager[] arrayOfTrustManager2 = arrayOfTrustManager1;
      if (arrayOfTrustManager1 == null)
      {
        arrayOfTrustManager2 = this.parent.engineGetTrustManagers();
        if (PlatformDependent.javaVersion() >= 7) {
          wrapIfNeeded(arrayOfTrustManager2);
        }
        this.trustManagers = arrayOfTrustManager2;
      }
      return (TrustManager[])arrayOfTrustManager2.clone();
    }
    
    protected void engineInit(KeyStore paramKeyStore)
      throws KeyStoreException
    {
      try
      {
        this.parent.engineInit(paramKeyStore);
        return;
      }
      catch (Exception paramKeyStore)
      {
        throw new KeyStoreException(paramKeyStore);
      }
      catch (KeyStoreException paramKeyStore)
      {
        throw paramKeyStore;
      }
    }
    
    protected void engineInit(ManagerFactoryParameters paramManagerFactoryParameters)
      throws InvalidAlgorithmParameterException
    {
      try
      {
        this.parent.engineInit(paramManagerFactoryParameters);
        return;
      }
      catch (Exception paramManagerFactoryParameters)
      {
        throw new InvalidAlgorithmParameterException(paramManagerFactoryParameters);
      }
      catch (InvalidAlgorithmParameterException paramManagerFactoryParameters)
      {
        throw paramManagerFactoryParameters;
      }
    }
    
    void init(SimpleTrustManagerFactory paramSimpleTrustManagerFactory)
    {
      this.parent = paramSimpleTrustManagerFactory;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\util\SimpleTrustManagerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */