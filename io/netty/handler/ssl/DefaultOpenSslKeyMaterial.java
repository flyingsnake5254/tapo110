package io.netty.handler.ssl;

import io.netty.internal.tcnative.SSL;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetectorFactory;
import io.netty.util.ResourceLeakTracker;
import java.security.cert.X509Certificate;

final class DefaultOpenSslKeyMaterial
  extends AbstractReferenceCounted
  implements OpenSslKeyMaterial
{
  private static final ResourceLeakDetector<DefaultOpenSslKeyMaterial> leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(DefaultOpenSslKeyMaterial.class);
  private long chain;
  private final ResourceLeakTracker<DefaultOpenSslKeyMaterial> leak;
  private long privateKey;
  private final X509Certificate[] x509CertificateChain;
  
  DefaultOpenSslKeyMaterial(long paramLong1, long paramLong2, X509Certificate[] paramArrayOfX509Certificate)
  {
    this.chain = paramLong1;
    this.privateKey = paramLong2;
    this.x509CertificateChain = paramArrayOfX509Certificate;
    this.leak = leakDetector.track(this);
  }
  
  public X509Certificate[] certificateChain()
  {
    return (X509Certificate[])this.x509CertificateChain.clone();
  }
  
  public long certificateChainAddress()
  {
    if (refCnt() > 0) {
      return this.chain;
    }
    throw new IllegalReferenceCountException();
  }
  
  protected void deallocate()
  {
    SSL.freeX509Chain(this.chain);
    this.chain = 0L;
    SSL.freePrivateKey(this.privateKey);
    this.privateKey = 0L;
    ResourceLeakTracker localResourceLeakTracker = this.leak;
    if (localResourceLeakTracker != null) {
      localResourceLeakTracker.close(this);
    }
  }
  
  public long privateKeyAddress()
  {
    if (refCnt() > 0) {
      return this.privateKey;
    }
    throw new IllegalReferenceCountException();
  }
  
  public boolean release()
  {
    ResourceLeakTracker localResourceLeakTracker = this.leak;
    if (localResourceLeakTracker != null) {
      localResourceLeakTracker.record();
    }
    return super.release();
  }
  
  public boolean release(int paramInt)
  {
    ResourceLeakTracker localResourceLeakTracker = this.leak;
    if (localResourceLeakTracker != null) {
      localResourceLeakTracker.record();
    }
    return super.release(paramInt);
  }
  
  public DefaultOpenSslKeyMaterial retain()
  {
    ResourceLeakTracker localResourceLeakTracker = this.leak;
    if (localResourceLeakTracker != null) {
      localResourceLeakTracker.record();
    }
    super.retain();
    return this;
  }
  
  public DefaultOpenSslKeyMaterial retain(int paramInt)
  {
    ResourceLeakTracker localResourceLeakTracker = this.leak;
    if (localResourceLeakTracker != null) {
      localResourceLeakTracker.record();
    }
    super.retain(paramInt);
    return this;
  }
  
  public DefaultOpenSslKeyMaterial touch()
  {
    ResourceLeakTracker localResourceLeakTracker = this.leak;
    if (localResourceLeakTracker != null) {
      localResourceLeakTracker.record();
    }
    super.touch();
    return this;
  }
  
  public DefaultOpenSslKeyMaterial touch(Object paramObject)
  {
    ResourceLeakTracker localResourceLeakTracker = this.leak;
    if (localResourceLeakTracker != null) {
      localResourceLeakTracker.record(paramObject);
    }
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\DefaultOpenSslKeyMaterial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */