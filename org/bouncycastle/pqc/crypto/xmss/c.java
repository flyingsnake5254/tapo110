package org.bouncycastle.pqc.crypto.xmss;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class c
  implements q
{
  private static final Map<String, c> a;
  private final int b;
  private final String c;
  
  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(a("SHA-256", 32, 16, 67, 10), new c(16777217, "XMSS_SHA2-256_W16_H10"));
    localHashMap.put(a("SHA-256", 32, 16, 67, 16), new c(33554434, "XMSS_SHA2-256_W16_H16"));
    localHashMap.put(a("SHA-256", 32, 16, 67, 20), new c(50331651, "XMSS_SHA2-256_W16_H20"));
    localHashMap.put(a("SHA-512", 64, 16, 131, 10), new c(67108868, "XMSS_SHA2-512_W16_H10"));
    localHashMap.put(a("SHA-512", 64, 16, 131, 16), new c(83886085, "XMSS_SHA2-512_W16_H16"));
    localHashMap.put(a("SHA-512", 64, 16, 131, 20), new c(100663302, "XMSS_SHA2-512_W16_H20"));
    localHashMap.put(a("SHAKE128", 32, 16, 67, 10), new c(117440519, "XMSS_SHAKE128_W16_H10"));
    localHashMap.put(a("SHAKE128", 32, 16, 67, 16), new c(134217736, "XMSS_SHAKE128_W16_H16"));
    localHashMap.put(a("SHAKE128", 32, 16, 67, 20), new c(150994953, "XMSS_SHAKE128_W16_H20"));
    localHashMap.put(a("SHAKE256", 64, 16, 131, 10), new c(167772170, "XMSS_SHAKE256_W16_H10"));
    localHashMap.put(a("SHAKE256", 64, 16, 131, 16), new c(184549387, "XMSS_SHAKE256_W16_H16"));
    localHashMap.put(a("SHAKE256", 64, 16, 131, 20), new c(201326604, "XMSS_SHAKE256_W16_H20"));
    a = Collections.unmodifiableMap(localHashMap);
  }
  
  private c(int paramInt, String paramString)
  {
    this.b = paramInt;
    this.c = paramString;
  }
  
  private static String a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Objects.requireNonNull(paramString, "algorithmName == null");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("-");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("-");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("-");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("-");
    localStringBuilder.append(paramInt4);
    return localStringBuilder.toString();
  }
  
  public static c b(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Objects.requireNonNull(paramString, "algorithmName == null");
    return (c)a.get(a(paramString, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public String toString()
  {
    return this.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\crypto\xmss\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */