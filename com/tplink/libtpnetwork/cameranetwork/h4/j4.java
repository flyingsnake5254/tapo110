package com.tplink.libtpnetwork.cameranetwork.h4;

import android.annotation.SuppressLint;
import com.google.gson.Gson;
import com.google.gson.d;
import com.tplink.libtpnetwork.cameranetwork.h4.o4.t;
import com.tplink.libtpnetwork.cameranetwork.model.TypeAdapter;
import com.tplink.libtpnetwork.cameranetwork.model.Wrapper;
import com.tplink.libtpnetwork.cameranetwork.model.Wrappers;
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
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient.Builder;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.adapter.rxjava2.g;
import retrofit2.r.b;

public class j4
{
  private X509TrustManager a;
  private SSLSocketFactory b;
  private Gson c = new d().d(Wrapper.class, TypeAdapter.getWrapperSerializer()).d(Wrapper.class, TypeAdapter.getWrapperDeserializer()).d(Wrappers.class, TypeAdapter.getWrapperListSerializer()).d(Wrappers.class, TypeAdapter.getWrapperListDeserializer()).b();
  
  public j4(InputStream paramInputStream)
  {
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      if (paramInputStream != null)
      {
        this.a = f(paramInputStream);
      }
      else
      {
        paramInputStream = new com/tplink/libtpnetwork/cameranetwork/h4/j4$b;
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
  
  private KeyStore d(char[] paramArrayOfChar)
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
  
  private retrofit2.r e(String paramString1, com.tplink.libtpnetwork.cameranetwork.h4.m4.b.b paramb, com.tplink.libtpnetwork.cameranetwork.h4.m4.a.a parama, String paramString2)
  {
    new HttpLoggingInterceptor(c4.a).setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient.Builder localBuilder = new OkHttpClient.Builder();
    localBuilder.hostnameVerifier(d4.a);
    localBuilder.cookieJar(new com.tplink.libtpnetwork.cameranetwork.h4.m4.b.a(paramb, paramString2));
    localBuilder.addInterceptor(new com.tplink.libtpnetwork.cameranetwork.h4.m4.a.b(paramString1, parama, paramString2));
    paramb = TimeUnit.SECONDS;
    localBuilder.readTimeout(30L, paramb);
    localBuilder.writeTimeout(30L, paramb);
    localBuilder.connectTimeout(30L, paramb);
    localBuilder.sslSocketFactory(this.b, this.a);
    localBuilder.connectionPool(new ConnectionPool(10, 5L, TimeUnit.MINUTES));
    return new r.b().c(paramString1).b(retrofit2.w.a.a.g(this.c)).a(g.d()).g(localBuilder.build()).e();
  }
  
  private X509TrustManager f(InputStream paramInputStream)
    throws GeneralSecurityException
  {
    Object localObject1 = CertificateFactory.getInstance("X.509").generateCertificates(paramInputStream);
    if (!((Collection)localObject1).isEmpty())
    {
      Object localObject2 = "password".toCharArray();
      paramInputStream = d((char[])localObject2);
      localObject1 = ((Collection)localObject1).iterator();
      for (int i = 0; ((Iterator)localObject1).hasNext(); i++)
      {
        Certificate localCertificate = (Certificate)((Iterator)localObject1).next();
        paramInputStream.setCertificateEntry(Integer.toString(i), localCertificate);
      }
      KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm()).init(paramInputStream, (char[])localObject2);
      localObject2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      ((TrustManagerFactory)localObject2).init(paramInputStream);
      localObject2 = ((TrustManagerFactory)localObject2).getTrustManagers();
      if ((localObject2.length == 1) && ((localObject2[0] instanceof X509TrustManager))) {
        return (X509TrustManager)localObject2[0];
      }
      paramInputStream = new StringBuilder();
      paramInputStream.append("Unexpected default trust managers:");
      paramInputStream.append(Arrays.toString((Object[])localObject2));
      throw new IllegalStateException(paramInputStream.toString());
    }
    throw new IllegalArgumentException("expected non-empty set of trusted certificates");
  }
  
  public t a(String paramString1, com.tplink.libtpnetwork.cameranetwork.h4.m4.b.b paramb, com.tplink.libtpnetwork.cameranetwork.h4.m4.a.a parama, String paramString2)
  {
    return new t(paramString2, (com.tplink.libtpnetwork.cameranetwork.h4.o4.r)e(paramString1, paramb, parama, paramString2).b(com.tplink.libtpnetwork.cameranetwork.h4.o4.r.class));
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\h4\j4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */