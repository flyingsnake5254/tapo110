package b.d.b.e;

import android.net.Uri;
import b.d.b.d.a.a.c;
import b.d.b.d.a.c.a;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient.Builder;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import okhttp3.logging.HttpLoggingInterceptor.Logger;
import retrofit2.r;
import retrofit2.r.b;

public class o
  implements c.a
{
  private final a a;
  private j.b b;
  
  public o(a parama)
  {
    this.a = parama;
  }
  
  private boolean a(String paramString, SSLSession paramSSLSession)
  {
    String str = Uri.parse(this.a.j()).getHost();
    if (str != null)
    {
      int i = str.lastIndexOf(".");
      int j = -1;
      if (i > 0) {
        j = str.substring(0, i).lastIndexOf(".");
      }
      if ((paramString.equals(paramSSLSession.getPeerHost())) && (paramString.endsWith(str.substring(j + 1)))) {
        return true;
      }
    }
    if (HttpsURLConnection.getDefaultHostnameVerifier().verify(paramString, paramSSLSession)) {
      return true;
    }
    return OkHostnameVerifier.INSTANCE.verify(paramString, paramSSLSession);
  }
  
  public r c()
  {
    OkHttpClient.Builder localBuilder = new OkHttpClient.Builder();
    Object localObject = TimeUnit.SECONDS;
    localBuilder = localBuilder.connectTimeout(30L, (TimeUnit)localObject).readTimeout(30L, (TimeUnit)localObject).writeTimeout(30L, (TimeUnit)localObject);
    if (this.a.k() != null) {
      localObject = b.d.b.d.a.a.c(this.a.k());
    } else {
      localObject = b.d.b.d.a.a.c(Collections.singletonList("-----BEGIN CERTIFICATE-----\nMIIDBzCCAe+gAwIBAgIQT5x0ma7QnINHCQvhnmzR9zANBgkqhkiG9w0BAQsFADAV\nMRMwEQYDVQQDEwp0cC1saW5rLUNBMCAXDTE4MDExOTA4Mjc1MloYDzIwNjgwMTE5\nMDgzNzUyWjAVMRMwEQYDVQQDEwp0cC1saW5rLUNBMIIBIjANBgkqhkiG9w0BAQEF\nAAOCAQ8AMIIBCgKCAQEAuGG8n5zEUN1j5wuvUz4pAIMurhKHbpfUUu+b2acFHKS6\niU9hNJWvDyhXcihY5Wz6aq9m4D5SZcgW3k31YoNNtrztDjdg2qw7AaX85S99/G0B\nVbIXktrhs34OW19WA/haDwut3dFhLem+gCRRKUXcmuqchZc84dY7JFVfhPcJci4m\nsRjLCFNO0ho9OX+MZwfO4BLaeAqKVoAor6rf4BXVtO0xjYHDKO0fb3AWLLJ4EjGe\nq6YieqPiYlPFEqRm5PrvBXTm0IuQogygyVpK4LHr/K207ZLyV33DxLLbsUgSEJVn\npZUv/WUujXjlIDgxIvyZZCYiXO3dle2/MEvpmZk6JQIDAQABo1EwTzALBgNVHQ8E\nBAMCAYYwDwYDVR0TAQH/BAUwAwEB/zAdBgNVHQ4EFgQUxu2iBRTsef5iNnsADVhM\nJDQWi6kwEAYJKwYBBAGCNxUBBAMCAQAwDQYJKoZIhvcNAQELBQADggEBAB52Majd\n+wo3cb5BsTo63z2Psbbyl4ACMUaw68NxUMy61Oihx3mcLzLJqiIZcKePiHskLqLJ\nF7QfT9TqjvizMjFJVgsLuVubUBXKBzqyN+3KKlQci0PO3mH+ObhyaE7BzV+qrS3P\ndVTgsCWFv8DkgLTRudSWxL7VwVoedc7lRz5EroGgJ33nRGCR0ngcW919tLTARDQO\npULmzulcdWeZgG+0PLX0xjJQIjFEvbOxR1Z+gxMupBz0rWFokmWYrcga8eWiWzjQ\nIa3/ASBVJ69srV77trWlfLumkChbXk9i64NXBKnce0Jmll0Y9OC1nMPqrbQKnzcn\ndSAA4fejD/qMQn0=\n-----END CERTIFICATE-----"));
    }
    localBuilder.sslSocketFactory(((a.c)localObject).c(), ((a.c)localObject).d());
    localBuilder.hostnameVerifier(new i(this));
    localBuilder.dns(new h(this));
    localBuilder.addInterceptor(new m(this.a));
    if ((this.a.m() != null) && (this.a.q() != null)) {
      localBuilder.addInterceptor(new n(this.a.m(), this.a.q()));
    }
    localBuilder.addInterceptor(new l());
    if (this.a.h() != null)
    {
      localObject = new HttpLoggingInterceptor(this.a.h());
      ((HttpLoggingInterceptor)localObject).setLevel(HttpLoggingInterceptor.Level.BODY);
    }
    else
    {
      localObject = com.tplink.cloud.context.a.k();
    }
    if (localObject != null) {
      localBuilder.addNetworkInterceptor((Interceptor)localObject);
    }
    return new r.b().c(this.a.j()).g(localBuilder.build()).b(retrofit2.w.a.a.f()).a(new j(this.b)).e();
  }
  
  public void f(j.b paramb)
  {
    this.b = paramb;
  }
  
  public static abstract interface a
  {
    public abstract String a();
    
    public abstract String b();
    
    public abstract String c();
    
    public abstract String d();
    
    public abstract k f();
    
    public abstract String getToken();
    
    public abstract HttpLoggingInterceptor.Logger h();
    
    public abstract String i();
    
    public abstract String j();
    
    public abstract List<String> k();
    
    public abstract String l();
    
    public abstract String m();
    
    public abstract String n();
    
    public abstract String o();
    
    public abstract String p();
    
    public abstract String q();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\b\e\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */