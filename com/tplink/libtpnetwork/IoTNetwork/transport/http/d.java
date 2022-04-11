package com.tplink.libtpnetwork.IoTNetwork.transport.http;

import android.annotation.SuppressLint;
import com.tplink.libtpnetwork.IoTNetwork.transport.http.cookie.c;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient.Builder;
import retrofit2.adapter.rxjava2.g;
import retrofit2.r;
import retrofit2.r.b;

public class d
{
  private X509TrustManager a;
  private SSLSocketFactory b;
  
  public d(InputStream paramInputStream)
  {
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      if (paramInputStream != null)
      {
        this.a = d(paramInputStream);
      }
      else
      {
        paramInputStream = new com/tplink/libtpnetwork/IoTNetwork/transport/http/d$b;
        paramInputStream.<init>(null);
        this.a = paramInputStream;
      }
      localSSLContext.init(null, new TrustManager[] { this.a }, null);
      this.b = localSSLContext.getSocketFactory();
      return;
    }
    catch (GeneralSecurityException paramInputStream)
    {
      throw new RuntimeException(paramInputStream);
    }
  }
  
  private KeyStore c(char[] paramArrayOfChar)
    throws GeneralSecurityException
  {
    try
    {
      KeyStore localKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
      localKeyStore.load(null, paramArrayOfChar);
      return localKeyStore;
    }
    catch (IOException paramArrayOfChar)
    {
      throw new AssertionError(paramArrayOfChar);
    }
  }
  
  private X509TrustManager d(InputStream paramInputStream)
    throws GeneralSecurityException
  {
    Object localObject1 = CertificateFactory.getInstance("X.509").generateCertificates(paramInputStream);
    if (!((Collection)localObject1).isEmpty())
    {
      Object localObject2 = "password".toCharArray();
      paramInputStream = c((char[])localObject2);
      localObject1 = ((Collection)localObject1).iterator();
      for (int i = 0; ((Iterator)localObject1).hasNext(); i++)
      {
        Certificate localCertificate = (Certificate)((Iterator)localObject1).next();
        paramInputStream.setCertificateEntry(Integer.toString(i), localCertificate);
      }
      KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm()).init(paramInputStream, (char[])localObject2);
      localObject2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      ((TrustManagerFactory)localObject2).init(paramInputStream);
      paramInputStream = ((TrustManagerFactory)localObject2).getTrustManagers();
      if ((paramInputStream.length == 1) && ((paramInputStream[0] instanceof X509TrustManager))) {
        return (X509TrustManager)paramInputStream[0];
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Unexpected default trust managers:");
      ((StringBuilder)localObject2).append(Arrays.toString(paramInputStream));
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
    throw new IllegalArgumentException("expected non-empty set of trusted certificates");
  }
  
  public <T> T a(String paramString, Class<T> paramClass, c paramc, boolean paramBoolean)
  {
    return (T)b(paramString, paramc, paramBoolean).b(paramClass);
  }
  
  public r b(String paramString, c paramc, boolean paramBoolean)
  {
    OkHttpClient.Builder localBuilder = new OkHttpClient.Builder();
    localBuilder.hostnameVerifier(new a());
    localBuilder.cookieJar(new com.tplink.libtpnetwork.IoTNetwork.transport.http.cookie.a(paramc));
    localBuilder.addInterceptor(new com.tplink.libtpnetwork.IoTNetwork.transport.http.f.a(paramString));
    paramc = TimeUnit.SECONDS;
    localBuilder.readTimeout(30L, paramc);
    localBuilder.writeTimeout(30L, paramc);
    localBuilder.connectTimeout(30L, paramc);
    localBuilder.sslSocketFactory(this.b, this.a);
    paramc = new Dispatcher();
    paramc.setMaxRequestsPerHost(4);
    localBuilder.dispatcher(paramc);
    paramc = localBuilder.build();
    paramc = new r.b().c(paramString).g(paramc).b(retrofit2.w.a.a.g(new com.google.gson.d().c().b()));
    if (paramBoolean) {
      paramString = g.e();
    } else {
      paramString = g.d();
    }
    return paramc.a(paramString).e();
  }
  
  class a
    implements HostnameVerifier
  {
    a() {}
    
    public boolean verify(String paramString, SSLSession paramSSLSession)
    {
      return true;
    }
  }
  
  private static class b
    implements X509TrustManager
  {
    @SuppressLint({"TrustAllX509TrustManager"})
    public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
      throws CertificateException
    {}
    
    @SuppressLint({"TrustAllX509TrustManager"})
    public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
      throws CertificateException
    {}
    
    public X509Certificate[] getAcceptedIssuers()
    {
      return new X509Certificate[0];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\transport\http\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */