package io.netty.handler.ssl;

import io.netty.util.ReferenceCounted;
import java.security.cert.X509Certificate;

abstract interface OpenSslKeyMaterial
  extends ReferenceCounted
{
  public abstract X509Certificate[] certificateChain();
  
  public abstract long certificateChainAddress();
  
  public abstract long privateKeyAddress();
  
  public abstract boolean release();
  
  public abstract boolean release(int paramInt);
  
  public abstract OpenSslKeyMaterial retain();
  
  public abstract OpenSslKeyMaterial retain(int paramInt);
  
  public abstract OpenSslKeyMaterial touch();
  
  public abstract OpenSslKeyMaterial touch(Object paramObject);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\OpenSslKeyMaterial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */