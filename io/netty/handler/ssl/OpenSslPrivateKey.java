package io.netty.handler.ssl;

import io.netty.internal.tcnative.SSL;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.internal.EmptyArrays;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

final class OpenSslPrivateKey
  extends AbstractReferenceCounted
  implements PrivateKey
{
  private long privateKeyAddress;
  
  OpenSslPrivateKey(long paramLong)
  {
    this.privateKeyAddress = paramLong;
  }
  
  private long privateKeyAddress()
  {
    if (refCnt() > 0) {
      return this.privateKeyAddress;
    }
    throw new IllegalReferenceCountException();
  }
  
  protected void deallocate()
  {
    SSL.freePrivateKey(this.privateKeyAddress);
    this.privateKeyAddress = 0L;
  }
  
  public void destroy()
  {
    release(refCnt());
  }
  
  public String getAlgorithm()
  {
    return "unknown";
  }
  
  public byte[] getEncoded()
  {
    return null;
  }
  
  public String getFormat()
  {
    return null;
  }
  
  public boolean isDestroyed()
  {
    boolean bool;
    if (refCnt() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  OpenSslKeyMaterial newKeyMaterial(long paramLong, X509Certificate[] paramArrayOfX509Certificate)
  {
    return new OpenSslPrivateKeyMaterial(paramLong, paramArrayOfX509Certificate);
  }
  
  public OpenSslPrivateKey retain()
  {
    super.retain();
    return this;
  }
  
  public OpenSslPrivateKey retain(int paramInt)
  {
    super.retain(paramInt);
    return this;
  }
  
  public OpenSslPrivateKey touch()
  {
    super.touch();
    return this;
  }
  
  public OpenSslPrivateKey touch(Object paramObject)
  {
    return this;
  }
  
  final class OpenSslPrivateKeyMaterial
    extends AbstractReferenceCounted
    implements OpenSslKeyMaterial
  {
    long certificateChain;
    private final X509Certificate[] x509CertificateChain;
    
    OpenSslPrivateKeyMaterial(long paramLong, X509Certificate[] paramArrayOfX509Certificate)
    {
      this.certificateChain = paramLong;
      X509Certificate[] arrayOfX509Certificate = paramArrayOfX509Certificate;
      if (paramArrayOfX509Certificate == null) {
        arrayOfX509Certificate = EmptyArrays.EMPTY_X509_CERTIFICATES;
      }
      this.x509CertificateChain = arrayOfX509Certificate;
      OpenSslPrivateKey.this.retain();
    }
    
    private void releaseChain()
    {
      SSL.freeX509Chain(this.certificateChain);
      this.certificateChain = 0L;
    }
    
    public X509Certificate[] certificateChain()
    {
      return (X509Certificate[])this.x509CertificateChain.clone();
    }
    
    public long certificateChainAddress()
    {
      if (refCnt() > 0) {
        return this.certificateChain;
      }
      throw new IllegalReferenceCountException();
    }
    
    protected void deallocate()
    {
      releaseChain();
      OpenSslPrivateKey.this.release();
    }
    
    public long privateKeyAddress()
    {
      if (refCnt() > 0) {
        return OpenSslPrivateKey.this.privateKeyAddress();
      }
      throw new IllegalReferenceCountException();
    }
    
    public OpenSslKeyMaterial retain()
    {
      super.retain();
      return this;
    }
    
    public OpenSslKeyMaterial retain(int paramInt)
    {
      super.retain(paramInt);
      return this;
    }
    
    public OpenSslKeyMaterial touch()
    {
      OpenSslPrivateKey.this.touch();
      return this;
    }
    
    public OpenSslKeyMaterial touch(Object paramObject)
    {
      OpenSslPrivateKey.this.touch(paramObject);
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\OpenSslPrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */