package io.netty.handler.ssl.util;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SuppressJava6Requirement;
import java.net.Socket;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509KeyManager;

@SuppressJava6Requirement(reason="Usage guarded by java version check")
final class X509KeyManagerWrapper
  extends X509ExtendedKeyManager
{
  private final X509KeyManager delegate;
  
  X509KeyManagerWrapper(X509KeyManager paramX509KeyManager)
  {
    this.delegate = ((X509KeyManager)ObjectUtil.checkNotNull(paramX509KeyManager, "delegate"));
  }
  
  public String chooseClientAlias(String[] paramArrayOfString, Principal[] paramArrayOfPrincipal, Socket paramSocket)
  {
    return this.delegate.chooseClientAlias(paramArrayOfString, paramArrayOfPrincipal, paramSocket);
  }
  
  public String chooseEngineClientAlias(String[] paramArrayOfString, Principal[] paramArrayOfPrincipal, SSLEngine paramSSLEngine)
  {
    return this.delegate.chooseClientAlias(paramArrayOfString, paramArrayOfPrincipal, null);
  }
  
  public String chooseEngineServerAlias(String paramString, Principal[] paramArrayOfPrincipal, SSLEngine paramSSLEngine)
  {
    return this.delegate.chooseServerAlias(paramString, paramArrayOfPrincipal, null);
  }
  
  public String chooseServerAlias(String paramString, Principal[] paramArrayOfPrincipal, Socket paramSocket)
  {
    return this.delegate.chooseServerAlias(paramString, paramArrayOfPrincipal, paramSocket);
  }
  
  public X509Certificate[] getCertificateChain(String paramString)
  {
    return this.delegate.getCertificateChain(paramString);
  }
  
  public String[] getClientAliases(String paramString, Principal[] paramArrayOfPrincipal)
  {
    return this.delegate.getClientAliases(paramString, paramArrayOfPrincipal);
  }
  
  public PrivateKey getPrivateKey(String paramString)
  {
    return this.delegate.getPrivateKey(paramString);
  }
  
  public String[] getServerAliases(String paramString, Principal[] paramArrayOfPrincipal)
  {
    return this.delegate.getServerAliases(paramString, paramArrayOfPrincipal);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\util\X509KeyManagerWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */