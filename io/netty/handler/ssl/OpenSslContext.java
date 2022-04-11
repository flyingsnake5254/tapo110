package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import java.security.cert.Certificate;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;

public abstract class OpenSslContext
  extends ReferenceCountedOpenSslContext
{
  OpenSslContext(Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, ApplicationProtocolConfig paramApplicationProtocolConfig, long paramLong1, long paramLong2, int paramInt, Certificate[] paramArrayOfCertificate, ClientAuth paramClientAuth, String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2)
    throws SSLException
  {
    super(paramIterable, paramCipherSuiteFilter, paramApplicationProtocolConfig, paramLong1, paramLong2, paramInt, paramArrayOfCertificate, paramClientAuth, paramArrayOfString, paramBoolean1, paramBoolean2, false);
  }
  
  OpenSslContext(Iterable<String> paramIterable, CipherSuiteFilter paramCipherSuiteFilter, OpenSslApplicationProtocolNegotiator paramOpenSslApplicationProtocolNegotiator, long paramLong1, long paramLong2, int paramInt, Certificate[] paramArrayOfCertificate, ClientAuth paramClientAuth, String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2)
    throws SSLException
  {
    super(paramIterable, paramCipherSuiteFilter, paramOpenSslApplicationProtocolNegotiator, paramLong1, paramLong2, paramInt, paramArrayOfCertificate, paramClientAuth, paramArrayOfString, paramBoolean1, paramBoolean2, false);
  }
  
  protected final void finalize()
    throws Throwable
  {
    super.finalize();
    OpenSsl.releaseIfNeeded(this);
  }
  
  final SSLEngine newEngine0(ByteBufAllocator paramByteBufAllocator, String paramString, int paramInt, boolean paramBoolean)
  {
    return new OpenSslEngine(this, paramByteBufAllocator, paramString, paramInt, paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\OpenSslContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */