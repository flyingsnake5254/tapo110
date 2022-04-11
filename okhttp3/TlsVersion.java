package okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum TlsVersion
{
  final String javaName;
  
  static
  {
    TlsVersion localTlsVersion1 = new TlsVersion("TLS_1_3", 0, "TLSv1.3");
    TLS_1_3 = localTlsVersion1;
    TlsVersion localTlsVersion2 = new TlsVersion("TLS_1_2", 1, "TLSv1.2");
    TLS_1_2 = localTlsVersion2;
    TlsVersion localTlsVersion3 = new TlsVersion("TLS_1_1", 2, "TLSv1.1");
    TLS_1_1 = localTlsVersion3;
    TlsVersion localTlsVersion4 = new TlsVersion("TLS_1_0", 3, "TLSv1");
    TLS_1_0 = localTlsVersion4;
    TlsVersion localTlsVersion5 = new TlsVersion("SSL_3_0", 4, "SSLv3");
    SSL_3_0 = localTlsVersion5;
    $VALUES = new TlsVersion[] { localTlsVersion1, localTlsVersion2, localTlsVersion3, localTlsVersion4, localTlsVersion5 };
  }
  
  private TlsVersion(String paramString)
  {
    this.javaName = paramString;
  }
  
  public static TlsVersion forJavaName(String paramString)
  {
    paramString.hashCode();
    int i = paramString.hashCode();
    int j = -1;
    switch (i)
    {
    default: 
      break;
    case 79923350: 
      if (paramString.equals("TLSv1")) {
        j = 4;
      }
      break;
    case 79201641: 
      if (paramString.equals("SSLv3")) {
        j = 3;
      }
      break;
    case -503070501: 
      if (paramString.equals("TLSv1.3")) {
        j = 2;
      }
      break;
    case -503070502: 
      if (paramString.equals("TLSv1.2")) {
        j = 1;
      }
      break;
    case -503070503: 
      if (paramString.equals("TLSv1.1")) {
        j = 0;
      }
      break;
    }
    switch (j)
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unexpected TLS version: ");
      localStringBuilder.append(paramString);
      throw new IllegalArgumentException(localStringBuilder.toString());
    case 4: 
      return TLS_1_0;
    case 3: 
      return SSL_3_0;
    case 2: 
      return TLS_1_3;
    case 1: 
      return TLS_1_2;
    }
    return TLS_1_1;
  }
  
  static List<TlsVersion> forJavaNames(String... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList(paramVarArgs.length);
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++) {
      localArrayList.add(forJavaName(paramVarArgs[j]));
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public String javaName()
  {
    return this.javaName;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\TlsVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */