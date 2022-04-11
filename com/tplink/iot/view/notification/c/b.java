package com.tplink.iot.view.notification.c;

import android.graphics.Bitmap;
import io.reactivex.q;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;

public class b
{
  private static SSLSocketFactory a()
  {
    Object localObject1 = null;
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      b localb = new com/tplink/iot/view/notification/c/b$b;
      localb.<init>(null);
      Object localObject2 = new java/security/SecureRandom;
      ((SecureRandom)localObject2).<init>();
      localSSLContext.init(null, new TrustManager[] { localb }, (SecureRandom)localObject2);
      localObject2 = localSSLContext.getSocketFactory();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return (SSLSocketFactory)localObject1;
  }
  
  public static q<Bitmap> b(String paramString)
  {
    return q.f0(Integer.valueOf(1)).N(new a(paramString)).L0(io.reactivex.l0.a.c());
  }
  
  private static OkHttpClient c()
  {
    return new OkHttpClient.Builder().hostnameVerifier(new a()).sslSocketFactory(a()).build();
  }
  
  static final class a
    implements HostnameVerifier
  {
    public boolean verify(String paramString, SSLSession paramSSLSession)
    {
      return true;
    }
  }
  
  private static class b
    implements X509TrustManager
  {
    public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
      throws CertificateException
    {}
    
    public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
      throws CertificateException
    {}
    
    public X509Certificate[] getAcceptedIssuers()
    {
      return new X509Certificate[0];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\notification\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */