package org.bouncycastle.pqc.crypto.xmss;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class b
  implements q
{
  private static final Map<String, b> a;
  private final int b;
  private final String c;
  
  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(a("SHA-256", 32, 16, 67, 20, 2), new b(16777217, "XMSSMT_SHA2-256_W16_H20_D2"));
    localHashMap.put(a("SHA-256", 32, 16, 67, 20, 4), new b(16777217, "XMSSMT_SHA2-256_W16_H20_D4"));
    localHashMap.put(a("SHA-256", 32, 16, 67, 40, 2), new b(16777217, "XMSSMT_SHA2-256_W16_H40_D2"));
    localHashMap.put(a("SHA-256", 32, 16, 67, 40, 2), new b(16777217, "XMSSMT_SHA2-256_W16_H40_D4"));
    localHashMap.put(a("SHA-256", 32, 16, 67, 40, 4), new b(16777217, "XMSSMT_SHA2-256_W16_H40_D8"));
    localHashMap.put(a("SHA-256", 32, 16, 67, 60, 8), new b(16777217, "XMSSMT_SHA2-256_W16_H60_D3"));
    localHashMap.put(a("SHA-256", 32, 16, 67, 60, 6), new b(16777217, "XMSSMT_SHA2-256_W16_H60_D6"));
    localHashMap.put(a("SHA-256", 32, 16, 67, 60, 12), new b(16777217, "XMSSMT_SHA2-256_W16_H60_D12"));
    localHashMap.put(a("SHA2-512", 64, 16, 131, 20, 2), new b(16777217, "XMSSMT_SHA2-512_W16_H20_D2"));
    localHashMap.put(a("SHA2-512", 64, 16, 131, 20, 4), new b(16777217, "XMSSMT_SHA2-512_W16_H20_D4"));
    localHashMap.put(a("SHA2-512", 64, 16, 131, 40, 2), new b(16777217, "XMSSMT_SHA2-512_W16_H40_D2"));
    localHashMap.put(a("SHA2-512", 64, 16, 131, 40, 4), new b(16777217, "XMSSMT_SHA2-512_W16_H40_D4"));
    localHashMap.put(a("SHA2-512", 64, 16, 131, 40, 8), new b(16777217, "XMSSMT_SHA2-512_W16_H40_D8"));
    localHashMap.put(a("SHA2-512", 64, 16, 131, 60, 3), new b(16777217, "XMSSMT_SHA2-512_W16_H60_D3"));
    localHashMap.put(a("SHA2-512", 64, 16, 131, 60, 6), new b(16777217, "XMSSMT_SHA2-512_W16_H60_D6"));
    localHashMap.put(a("SHA2-512", 64, 16, 131, 60, 12), new b(16777217, "XMSSMT_SHA2-512_W16_H60_D12"));
    localHashMap.put(a("SHAKE128", 32, 16, 67, 20, 2), new b(16777217, "XMSSMT_SHAKE128_W16_H20_D2"));
    localHashMap.put(a("SHAKE128", 32, 16, 67, 20, 4), new b(16777217, "XMSSMT_SHAKE128_W16_H20_D4"));
    localHashMap.put(a("SHAKE128", 32, 16, 67, 40, 2), new b(16777217, "XMSSMT_SHAKE128_W16_H40_D2"));
    localHashMap.put(a("SHAKE128", 32, 16, 67, 40, 4), new b(16777217, "XMSSMT_SHAKE128_W16_H40_D4"));
    localHashMap.put(a("SHAKE128", 32, 16, 67, 40, 8), new b(16777217, "XMSSMT_SHAKE128_W16_H40_D8"));
    localHashMap.put(a("SHAKE128", 32, 16, 67, 60, 3), new b(16777217, "XMSSMT_SHAKE128_W16_H60_D3"));
    localHashMap.put(a("SHAKE128", 32, 16, 67, 60, 6), new b(16777217, "XMSSMT_SHAKE128_W16_H60_D6"));
    localHashMap.put(a("SHAKE128", 32, 16, 67, 60, 12), new b(16777217, "XMSSMT_SHAKE128_W16_H60_D12"));
    localHashMap.put(a("SHAKE256", 64, 16, 131, 20, 2), new b(16777217, "XMSSMT_SHAKE256_W16_H20_D2"));
    localHashMap.put(a("SHAKE256", 64, 16, 131, 20, 4), new b(16777217, "XMSSMT_SHAKE256_W16_H20_D4"));
    localHashMap.put(a("SHAKE256", 64, 16, 131, 40, 2), new b(16777217, "XMSSMT_SHAKE256_W16_H40_D2"));
    localHashMap.put(a("SHAKE256", 64, 16, 131, 40, 4), new b(16777217, "XMSSMT_SHAKE256_W16_H40_D4"));
    localHashMap.put(a("SHAKE256", 64, 16, 131, 40, 8), new b(16777217, "XMSSMT_SHAKE256_W16_H40_D8"));
    localHashMap.put(a("SHAKE256", 64, 16, 131, 60, 3), new b(16777217, "XMSSMT_SHAKE256_W16_H60_D3"));
    localHashMap.put(a("SHAKE256", 64, 16, 131, 60, 6), new b(16777217, "XMSSMT_SHAKE256_W16_H60_D6"));
    localHashMap.put(a("SHAKE256", 64, 16, 131, 60, 12), new b(16777217, "XMSSMT_SHAKE256_W16_H60_D12"));
    a = Collections.unmodifiableMap(localHashMap);
  }
  
  private b(int paramInt, String paramString)
  {
    this.b = paramInt;
    this.c = paramString;
  }
  
  private static String a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
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
    localStringBuilder.append("-");
    localStringBuilder.append(paramInt5);
    return localStringBuilder.toString();
  }
  
  public static b b(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Objects.requireNonNull(paramString, "algorithmName == null");
    return (b)a.get(a(paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5));
  }
  
  public String toString()
  {
    return this.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\crypto\xmss\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */