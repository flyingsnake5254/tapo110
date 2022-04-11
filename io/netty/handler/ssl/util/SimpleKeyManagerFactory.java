package io.netty.handler.ssl.util;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.Provider;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.KeyManagerFactorySpi;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509KeyManager;

public abstract class SimpleKeyManagerFactory
  extends KeyManagerFactory
{
  private static final FastThreadLocal<SimpleKeyManagerFactorySpi> CURRENT_SPI = new FastThreadLocal()
  {
    protected SimpleKeyManagerFactory.SimpleKeyManagerFactorySpi initialValue()
    {
      return new SimpleKeyManagerFactory.SimpleKeyManagerFactorySpi(null);
    }
  };
  private static final Provider PROVIDER = new Provider("", 0.0D, "")
  {
    private static final long serialVersionUID = -2680540247105807895L;
  };
  
  protected SimpleKeyManagerFactory()
  {
    this("");
  }
  
  protected SimpleKeyManagerFactory(String paramString)
  {
    super((KeyManagerFactorySpi)localFastThreadLocal.get(), PROVIDER, (String)ObjectUtil.checkNotNull(paramString, "name"));
    ((SimpleKeyManagerFactorySpi)localFastThreadLocal.get()).init(this);
    localFastThreadLocal.remove();
  }
  
  protected abstract KeyManager[] engineGetKeyManagers();
  
  protected abstract void engineInit(KeyStore paramKeyStore, char[] paramArrayOfChar)
    throws Exception;
  
  protected abstract void engineInit(ManagerFactoryParameters paramManagerFactoryParameters)
    throws Exception;
  
  private static final class SimpleKeyManagerFactorySpi
    extends KeyManagerFactorySpi
  {
    private volatile KeyManager[] keyManagers;
    private SimpleKeyManagerFactory parent;
    
    @SuppressJava6Requirement(reason="Usage guarded by java version check")
    private static void wrapIfNeeded(KeyManager[] paramArrayOfKeyManager)
    {
      for (int i = 0; i < paramArrayOfKeyManager.length; i++)
      {
        KeyManager localKeyManager = paramArrayOfKeyManager[i];
        if (((localKeyManager instanceof X509KeyManager)) && (!(localKeyManager instanceof X509ExtendedKeyManager))) {
          paramArrayOfKeyManager[i] = new X509KeyManagerWrapper((X509KeyManager)localKeyManager);
        }
      }
    }
    
    protected KeyManager[] engineGetKeyManagers()
    {
      KeyManager[] arrayOfKeyManager1 = this.keyManagers;
      KeyManager[] arrayOfKeyManager2 = arrayOfKeyManager1;
      if (arrayOfKeyManager1 == null)
      {
        arrayOfKeyManager2 = this.parent.engineGetKeyManagers();
        if (PlatformDependent.javaVersion() >= 7) {
          wrapIfNeeded(arrayOfKeyManager2);
        }
        this.keyManagers = arrayOfKeyManager2;
      }
      return (KeyManager[])arrayOfKeyManager2.clone();
    }
    
    protected void engineInit(KeyStore paramKeyStore, char[] paramArrayOfChar)
      throws KeyStoreException
    {
      try
      {
        this.parent.engineInit(paramKeyStore, paramArrayOfChar);
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
    
    void init(SimpleKeyManagerFactory paramSimpleKeyManagerFactory)
    {
      this.parent = paramSimpleKeyManagerFactory;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\util\SimpleKeyManagerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */