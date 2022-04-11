package org.bouncycastle.pqc.crypto.xmss;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

final class i
  implements q
{
  private static final Map<String, i> a;
  private final int b;
  private final String c;
  
  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(a("SHA-256", 32, 16, 67), new i(16777217, "WOTSP_SHA2-256_W16"));
    localHashMap.put(a("SHA-512", 64, 16, 131), new i(33554434, "WOTSP_SHA2-512_W16"));
    localHashMap.put(a("SHAKE128", 32, 16, 67), new i(50331651, "WOTSP_SHAKE128_W16"));
    localHashMap.put(a("SHAKE256", 64, 16, 131), new i(67108868, "WOTSP_SHAKE256_W16"));
    a = Collections.unmodifiableMap(localHashMap);
  }
  
  private i(int paramInt, String paramString)
  {
    this.b = paramInt;
    this.c = paramString;
  }
  
  private static String a(String paramString, int paramInt1, int paramInt2, int paramInt3)
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
    return localStringBuilder.toString();
  }
  
  protected static i b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Objects.requireNonNull(paramString, "algorithmName == null");
    return (i)a.get(a(paramString, paramInt1, paramInt2, paramInt3));
  }
  
  public String toString()
  {
    return this.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\crypto\xmss\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */