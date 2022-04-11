package io.netty.handler.codec.http2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Http2SecurityUtil
{
  public static final List<String> CIPHERS;
  private static final List<String> CIPHERS_JAVA_MOZILLA_MODERN_SECURITY;
  
  static
  {
    List localList = Collections.unmodifiableList(Arrays.asList(new String[] { "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256" }));
    CIPHERS_JAVA_MOZILLA_MODERN_SECURITY = localList;
    CIPHERS = Collections.unmodifiableList(new ArrayList(localList));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2SecurityUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */