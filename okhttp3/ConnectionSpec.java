package okhttp3;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.Util;

public final class ConnectionSpec
{
  private static final CipherSuite[] APPROVED_CIPHER_SUITES;
  public static final ConnectionSpec CLEARTEXT = new Builder(false).build();
  public static final ConnectionSpec COMPATIBLE_TLS;
  public static final ConnectionSpec MODERN_TLS;
  private static final CipherSuite[] RESTRICTED_CIPHER_SUITES;
  public static final ConnectionSpec RESTRICTED_TLS;
  @Nullable
  final String[] cipherSuites;
  final boolean supportsTlsExtensions;
  final boolean tls;
  @Nullable
  final String[] tlsVersions;
  
  static
  {
    Object localObject1 = new CipherSuite[11];
    CipherSuite localCipherSuite1 = CipherSuite.TLS_AES_128_GCM_SHA256;
    localObject1[0] = localCipherSuite1;
    CipherSuite localCipherSuite2 = CipherSuite.TLS_AES_256_GCM_SHA384;
    localObject1[1] = localCipherSuite2;
    Object localObject2 = CipherSuite.TLS_CHACHA20_POLY1305_SHA256;
    localObject1[2] = localObject2;
    Object localObject3 = CipherSuite.TLS_AES_128_CCM_SHA256;
    localObject1[3] = localObject3;
    CipherSuite localCipherSuite3 = CipherSuite.TLS_AES_256_CCM_8_SHA256;
    localObject1[4] = localCipherSuite3;
    CipherSuite localCipherSuite4 = CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256;
    localObject1[5] = localCipherSuite4;
    CipherSuite localCipherSuite5 = CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256;
    localObject1[6] = localCipherSuite5;
    CipherSuite localCipherSuite6 = CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384;
    localObject1[7] = localCipherSuite6;
    Object localObject4 = CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384;
    localObject1[8] = localObject4;
    Object localObject5 = CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256;
    localObject1[9] = localObject5;
    CipherSuite localCipherSuite7 = CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256;
    localObject1[10] = localCipherSuite7;
    RESTRICTED_CIPHER_SUITES = (CipherSuite[])localObject1;
    CipherSuite[] arrayOfCipherSuite = new CipherSuite[18];
    arrayOfCipherSuite[0] = localCipherSuite1;
    arrayOfCipherSuite[1] = localCipherSuite2;
    arrayOfCipherSuite[2] = localObject2;
    arrayOfCipherSuite[3] = localObject3;
    arrayOfCipherSuite[4] = localCipherSuite3;
    arrayOfCipherSuite[5] = localCipherSuite4;
    arrayOfCipherSuite[6] = localCipherSuite5;
    arrayOfCipherSuite[7] = localCipherSuite6;
    arrayOfCipherSuite[8] = localObject4;
    arrayOfCipherSuite[9] = localObject5;
    arrayOfCipherSuite[10] = localCipherSuite7;
    arrayOfCipherSuite[11] = CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA;
    arrayOfCipherSuite[12] = CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA;
    arrayOfCipherSuite[13] = CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256;
    arrayOfCipherSuite[14] = CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384;
    arrayOfCipherSuite[15] = CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA;
    arrayOfCipherSuite[16] = CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA;
    arrayOfCipherSuite[17] = CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA;
    APPROVED_CIPHER_SUITES = arrayOfCipherSuite;
    localObject2 = new Builder(true).cipherSuites((CipherSuite[])localObject1);
    localObject4 = TlsVersion.TLS_1_3;
    localObject5 = TlsVersion.TLS_1_2;
    RESTRICTED_TLS = ((Builder)localObject2).tlsVersions(new TlsVersion[] { localObject4, localObject5 }).supportsTlsExtensions(true).build();
    localObject2 = new Builder(true).cipherSuites(arrayOfCipherSuite);
    localObject1 = TlsVersion.TLS_1_1;
    localObject3 = TlsVersion.TLS_1_0;
    MODERN_TLS = ((Builder)localObject2).tlsVersions(new TlsVersion[] { localObject4, localObject5, localObject1, localObject3 }).supportsTlsExtensions(true).build();
    COMPATIBLE_TLS = new Builder(true).cipherSuites(arrayOfCipherSuite).tlsVersions(new TlsVersion[] { localObject3 }).supportsTlsExtensions(true).build();
  }
  
  ConnectionSpec(Builder paramBuilder)
  {
    this.tls = paramBuilder.tls;
    this.cipherSuites = paramBuilder.cipherSuites;
    this.tlsVersions = paramBuilder.tlsVersions;
    this.supportsTlsExtensions = paramBuilder.supportsTlsExtensions;
  }
  
  private ConnectionSpec supportedSpec(SSLSocket paramSSLSocket, boolean paramBoolean)
  {
    String[] arrayOfString1;
    if (this.cipherSuites != null) {
      arrayOfString1 = Util.intersect(CipherSuite.ORDER_BY_NAME, paramSSLSocket.getEnabledCipherSuites(), this.cipherSuites);
    } else {
      arrayOfString1 = paramSSLSocket.getEnabledCipherSuites();
    }
    String[] arrayOfString2;
    if (this.tlsVersions != null) {
      arrayOfString2 = Util.intersect(Util.NATURAL_ORDER, paramSSLSocket.getEnabledProtocols(), this.tlsVersions);
    } else {
      arrayOfString2 = paramSSLSocket.getEnabledProtocols();
    }
    String[] arrayOfString3 = paramSSLSocket.getSupportedCipherSuites();
    int i = Util.indexOf(CipherSuite.ORDER_BY_NAME, arrayOfString3, "TLS_FALLBACK_SCSV");
    paramSSLSocket = arrayOfString1;
    if (paramBoolean)
    {
      paramSSLSocket = arrayOfString1;
      if (i != -1) {
        paramSSLSocket = Util.concat(arrayOfString1, arrayOfString3[i]);
      }
    }
    return new Builder(this).cipherSuites(paramSSLSocket).tlsVersions(arrayOfString2).build();
  }
  
  void apply(SSLSocket paramSSLSocket, boolean paramBoolean)
  {
    Object localObject = supportedSpec(paramSSLSocket, paramBoolean);
    String[] arrayOfString = ((ConnectionSpec)localObject).tlsVersions;
    if (arrayOfString != null) {
      paramSSLSocket.setEnabledProtocols(arrayOfString);
    }
    localObject = ((ConnectionSpec)localObject).cipherSuites;
    if (localObject != null) {
      paramSSLSocket.setEnabledCipherSuites((String[])localObject);
    }
  }
  
  @Nullable
  public List<CipherSuite> cipherSuites()
  {
    Object localObject = this.cipherSuites;
    if (localObject != null) {
      localObject = CipherSuite.forJavaNames((String[])localObject);
    } else {
      localObject = null;
    }
    return (List<CipherSuite>)localObject;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (!(paramObject instanceof ConnectionSpec)) {
      return false;
    }
    if (paramObject == this) {
      return true;
    }
    paramObject = (ConnectionSpec)paramObject;
    boolean bool = this.tls;
    if (bool != ((ConnectionSpec)paramObject).tls) {
      return false;
    }
    if (bool)
    {
      if (!Arrays.equals(this.cipherSuites, ((ConnectionSpec)paramObject).cipherSuites)) {
        return false;
      }
      if (!Arrays.equals(this.tlsVersions, ((ConnectionSpec)paramObject).tlsVersions)) {
        return false;
      }
      if (this.supportsTlsExtensions != ((ConnectionSpec)paramObject).supportsTlsExtensions) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int i;
    if (this.tls) {
      i = ((527 + Arrays.hashCode(this.cipherSuites)) * 31 + Arrays.hashCode(this.tlsVersions)) * 31 + (this.supportsTlsExtensions ^ true);
    } else {
      i = 17;
    }
    return i;
  }
  
  public boolean isCompatible(SSLSocket paramSSLSocket)
  {
    if (!this.tls) {
      return false;
    }
    String[] arrayOfString = this.tlsVersions;
    if ((arrayOfString != null) && (!Util.nonEmptyIntersection(Util.NATURAL_ORDER, arrayOfString, paramSSLSocket.getEnabledProtocols()))) {
      return false;
    }
    arrayOfString = this.cipherSuites;
    return (arrayOfString == null) || (Util.nonEmptyIntersection(CipherSuite.ORDER_BY_NAME, arrayOfString, paramSSLSocket.getEnabledCipherSuites()));
  }
  
  public boolean isTls()
  {
    return this.tls;
  }
  
  public boolean supportsTlsExtensions()
  {
    return this.supportsTlsExtensions;
  }
  
  @Nullable
  public List<TlsVersion> tlsVersions()
  {
    Object localObject = this.tlsVersions;
    if (localObject != null) {
      localObject = TlsVersion.forJavaNames((String[])localObject);
    } else {
      localObject = null;
    }
    return (List<TlsVersion>)localObject;
  }
  
  public String toString()
  {
    if (!this.tls) {
      return "ConnectionSpec()";
    }
    Object localObject = this.cipherSuites;
    String str = "[all enabled]";
    if (localObject != null) {
      localObject = cipherSuites().toString();
    } else {
      localObject = "[all enabled]";
    }
    if (this.tlsVersions != null) {
      str = tlsVersions().toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ConnectionSpec(cipherSuites=");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", tlsVersions=");
    localStringBuilder.append(str);
    localStringBuilder.append(", supportsTlsExtensions=");
    localStringBuilder.append(this.supportsTlsExtensions);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static final class Builder
  {
    @Nullable
    String[] cipherSuites;
    boolean supportsTlsExtensions;
    boolean tls;
    @Nullable
    String[] tlsVersions;
    
    public Builder(ConnectionSpec paramConnectionSpec)
    {
      this.tls = paramConnectionSpec.tls;
      this.cipherSuites = paramConnectionSpec.cipherSuites;
      this.tlsVersions = paramConnectionSpec.tlsVersions;
      this.supportsTlsExtensions = paramConnectionSpec.supportsTlsExtensions;
    }
    
    Builder(boolean paramBoolean)
    {
      this.tls = paramBoolean;
    }
    
    public Builder allEnabledCipherSuites()
    {
      if (this.tls)
      {
        this.cipherSuites = null;
        return this;
      }
      throw new IllegalStateException("no cipher suites for cleartext connections");
    }
    
    public Builder allEnabledTlsVersions()
    {
      if (this.tls)
      {
        this.tlsVersions = null;
        return this;
      }
      throw new IllegalStateException("no TLS versions for cleartext connections");
    }
    
    public ConnectionSpec build()
    {
      return new ConnectionSpec(this);
    }
    
    public Builder cipherSuites(String... paramVarArgs)
    {
      if (this.tls)
      {
        if (paramVarArgs.length != 0)
        {
          this.cipherSuites = ((String[])paramVarArgs.clone());
          return this;
        }
        throw new IllegalArgumentException("At least one cipher suite is required");
      }
      throw new IllegalStateException("no cipher suites for cleartext connections");
    }
    
    public Builder cipherSuites(CipherSuite... paramVarArgs)
    {
      if (this.tls)
      {
        String[] arrayOfString = new String[paramVarArgs.length];
        for (int i = 0; i < paramVarArgs.length; i++) {
          arrayOfString[i] = paramVarArgs[i].javaName;
        }
        return cipherSuites(arrayOfString);
      }
      throw new IllegalStateException("no cipher suites for cleartext connections");
    }
    
    public Builder supportsTlsExtensions(boolean paramBoolean)
    {
      if (this.tls)
      {
        this.supportsTlsExtensions = paramBoolean;
        return this;
      }
      throw new IllegalStateException("no TLS extensions for cleartext connections");
    }
    
    public Builder tlsVersions(String... paramVarArgs)
    {
      if (this.tls)
      {
        if (paramVarArgs.length != 0)
        {
          this.tlsVersions = ((String[])paramVarArgs.clone());
          return this;
        }
        throw new IllegalArgumentException("At least one TLS version is required");
      }
      throw new IllegalStateException("no TLS versions for cleartext connections");
    }
    
    public Builder tlsVersions(TlsVersion... paramVarArgs)
    {
      if (this.tls)
      {
        String[] arrayOfString = new String[paramVarArgs.length];
        for (int i = 0; i < paramVarArgs.length; i++) {
          arrayOfString[i] = paramVarArgs[i].javaName;
        }
        return tlsVersions(arrayOfString);
      }
      throw new IllegalStateException("no TLS versions for cleartext connections");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\ConnectionSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */