package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.internal.Util;

public final class Address
{
  @Nullable
  final CertificatePinner certificatePinner;
  final List<ConnectionSpec> connectionSpecs;
  final Dns dns;
  @Nullable
  final HostnameVerifier hostnameVerifier;
  final List<Protocol> protocols;
  @Nullable
  final Proxy proxy;
  final Authenticator proxyAuthenticator;
  final ProxySelector proxySelector;
  final SocketFactory socketFactory;
  @Nullable
  final SSLSocketFactory sslSocketFactory;
  final HttpUrl url;
  
  public Address(String paramString, int paramInt, Dns paramDns, SocketFactory paramSocketFactory, @Nullable SSLSocketFactory paramSSLSocketFactory, @Nullable HostnameVerifier paramHostnameVerifier, @Nullable CertificatePinner paramCertificatePinner, Authenticator paramAuthenticator, @Nullable Proxy paramProxy, List<Protocol> paramList, List<ConnectionSpec> paramList1, ProxySelector paramProxySelector)
  {
    HttpUrl.Builder localBuilder = new HttpUrl.Builder();
    String str;
    if (paramSSLSocketFactory != null) {
      str = "https";
    } else {
      str = "http";
    }
    this.url = localBuilder.scheme(str).host(paramString).port(paramInt).build();
    Objects.requireNonNull(paramDns, "dns == null");
    this.dns = paramDns;
    Objects.requireNonNull(paramSocketFactory, "socketFactory == null");
    this.socketFactory = paramSocketFactory;
    Objects.requireNonNull(paramAuthenticator, "proxyAuthenticator == null");
    this.proxyAuthenticator = paramAuthenticator;
    Objects.requireNonNull(paramList, "protocols == null");
    this.protocols = Util.immutableList(paramList);
    Objects.requireNonNull(paramList1, "connectionSpecs == null");
    this.connectionSpecs = Util.immutableList(paramList1);
    Objects.requireNonNull(paramProxySelector, "proxySelector == null");
    this.proxySelector = paramProxySelector;
    this.proxy = paramProxy;
    this.sslSocketFactory = paramSSLSocketFactory;
    this.hostnameVerifier = paramHostnameVerifier;
    this.certificatePinner = paramCertificatePinner;
  }
  
  @Nullable
  public CertificatePinner certificatePinner()
  {
    return this.certificatePinner;
  }
  
  public List<ConnectionSpec> connectionSpecs()
  {
    return this.connectionSpecs;
  }
  
  public Dns dns()
  {
    return this.dns;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof Address))
    {
      HttpUrl localHttpUrl = this.url;
      paramObject = (Address)paramObject;
      if ((localHttpUrl.equals(((Address)paramObject).url)) && (equalsNonHost((Address)paramObject))) {
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
  
  boolean equalsNonHost(Address paramAddress)
  {
    boolean bool;
    if ((this.dns.equals(paramAddress.dns)) && (this.proxyAuthenticator.equals(paramAddress.proxyAuthenticator)) && (this.protocols.equals(paramAddress.protocols)) && (this.connectionSpecs.equals(paramAddress.connectionSpecs)) && (this.proxySelector.equals(paramAddress.proxySelector)) && (Util.equal(this.proxy, paramAddress.proxy)) && (Util.equal(this.sslSocketFactory, paramAddress.sslSocketFactory)) && (Util.equal(this.hostnameVerifier, paramAddress.hostnameVerifier)) && (Util.equal(this.certificatePinner, paramAddress.certificatePinner)) && (url().port() == paramAddress.url().port())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    int i = this.url.hashCode();
    int j = this.dns.hashCode();
    int k = this.proxyAuthenticator.hashCode();
    int m = this.protocols.hashCode();
    int n = this.connectionSpecs.hashCode();
    int i1 = this.proxySelector.hashCode();
    Object localObject = this.proxy;
    int i2 = 0;
    int i3;
    if (localObject != null) {
      i3 = ((Proxy)localObject).hashCode();
    } else {
      i3 = 0;
    }
    localObject = this.sslSocketFactory;
    int i4;
    if (localObject != null) {
      i4 = localObject.hashCode();
    } else {
      i4 = 0;
    }
    localObject = this.hostnameVerifier;
    int i5;
    if (localObject != null) {
      i5 = localObject.hashCode();
    } else {
      i5 = 0;
    }
    localObject = this.certificatePinner;
    if (localObject != null) {
      i2 = ((CertificatePinner)localObject).hashCode();
    }
    return (((((((((527 + i) * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i2;
  }
  
  @Nullable
  public HostnameVerifier hostnameVerifier()
  {
    return this.hostnameVerifier;
  }
  
  public List<Protocol> protocols()
  {
    return this.protocols;
  }
  
  @Nullable
  public Proxy proxy()
  {
    return this.proxy;
  }
  
  public Authenticator proxyAuthenticator()
  {
    return this.proxyAuthenticator;
  }
  
  public ProxySelector proxySelector()
  {
    return this.proxySelector;
  }
  
  public SocketFactory socketFactory()
  {
    return this.socketFactory;
  }
  
  @Nullable
  public SSLSocketFactory sslSocketFactory()
  {
    return this.sslSocketFactory;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Address{");
    localStringBuilder.append(this.url.host());
    localStringBuilder.append(":");
    localStringBuilder.append(this.url.port());
    if (this.proxy != null)
    {
      localStringBuilder.append(", proxy=");
      localStringBuilder.append(this.proxy);
    }
    else
    {
      localStringBuilder.append(", proxySelector=");
      localStringBuilder.append(this.proxySelector);
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public HttpUrl url()
  {
    return this.url;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\Address.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */