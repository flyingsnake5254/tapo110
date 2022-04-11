package io.netty.handler.ssl;

import io.netty.util.internal.SuppressJava6Requirement;
import java.security.AlgorithmConstraints;
import javax.net.ssl.SSLParameters;

final class Java7SslParametersUtils
{
  @SuppressJava6Requirement(reason="Usage guarded by java version check")
  static void setAlgorithmConstraints(SSLParameters paramSSLParameters, Object paramObject)
  {
    paramSSLParameters.setAlgorithmConstraints((AlgorithmConstraints)paramObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\Java7SslParametersUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */