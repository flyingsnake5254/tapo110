package io.netty.handler.ssl;

import io.netty.handler.ssl.util.SimpleKeyManagerFactory;
import io.netty.util.internal.ObjectUtil;
import java.security.KeyStore;
import javax.net.ssl.KeyManager;
import javax.net.ssl.ManagerFactoryParameters;

final class KeyManagerFactoryWrapper
  extends SimpleKeyManagerFactory
{
  private final KeyManager km;
  
  KeyManagerFactoryWrapper(KeyManager paramKeyManager)
  {
    this.km = ((KeyManager)ObjectUtil.checkNotNull(paramKeyManager, "km"));
  }
  
  protected KeyManager[] engineGetKeyManagers()
  {
    return new KeyManager[] { this.km };
  }
  
  protected void engineInit(KeyStore paramKeyStore, char[] paramArrayOfChar)
    throws Exception
  {}
  
  protected void engineInit(ManagerFactoryParameters paramManagerFactoryParameters)
    throws Exception
  {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\KeyManagerFactoryWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */