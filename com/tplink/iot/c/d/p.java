package com.tplink.iot.c.d;

import b.d.b.d.a.a.c;
import b.d.b.d.a.c.a;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient.Builder;
import okhttp3.logging.HttpLoggingInterceptor.Logger;
import retrofit2.r;
import retrofit2.r.b;

public class p
  implements c.a
{
  private String a;
  private a b;
  
  public p(String paramString, a parama)
  {
    this.a = paramString;
    this.b = parama;
  }
  
  public r c()
  {
    OkHttpClient.Builder localBuilder = new OkHttpClient.Builder();
    Object localObject = TimeUnit.SECONDS;
    localBuilder = localBuilder.connectTimeout(30L, (TimeUnit)localObject).readTimeout(30L, (TimeUnit)localObject).writeTimeout(30L, (TimeUnit)localObject);
    localObject = b.d.b.d.a.a.c(Collections.singletonList("-----BEGIN CERTIFICATE-----\nMIIDBzCCAe+gAwIBAgIQT5x0ma7QnINHCQvhnmzR9zANBgkqhkiG9w0BAQsFADAV\nMRMwEQYDVQQDEwp0cC1saW5rLUNBMCAXDTE4MDExOTA4Mjc1MloYDzIwNjgwMTE5\nMDgzNzUyWjAVMRMwEQYDVQQDEwp0cC1saW5rLUNBMIIBIjANBgkqhkiG9w0BAQEF\nAAOCAQ8AMIIBCgKCAQEAuGG8n5zEUN1j5wuvUz4pAIMurhKHbpfUUu+b2acFHKS6\niU9hNJWvDyhXcihY5Wz6aq9m4D5SZcgW3k31YoNNtrztDjdg2qw7AaX85S99/G0B\nVbIXktrhs34OW19WA/haDwut3dFhLem+gCRRKUXcmuqchZc84dY7JFVfhPcJci4m\nsRjLCFNO0ho9OX+MZwfO4BLaeAqKVoAor6rf4BXVtO0xjYHDKO0fb3AWLLJ4EjGe\nq6YieqPiYlPFEqRm5PrvBXTm0IuQogygyVpK4LHr/K207ZLyV33DxLLbsUgSEJVn\npZUv/WUujXjlIDgxIvyZZCYiXO3dle2/MEvpmZk6JQIDAQABo1EwTzALBgNVHQ8E\nBAMCAYYwDwYDVR0TAQH/BAUwAwEB/zAdBgNVHQ4EFgQUxu2iBRTsef5iNnsADVhM\nJDQWi6kwEAYJKwYBBAGCNxUBBAMCAQAwDQYJKoZIhvcNAQELBQADggEBAB52Majd\n+wo3cb5BsTo63z2Psbbyl4ACMUaw68NxUMy61Oihx3mcLzLJqiIZcKePiHskLqLJ\nF7QfT9TqjvizMjFJVgsLuVubUBXKBzqyN+3KKlQci0PO3mH+ObhyaE7BzV+qrS3P\ndVTgsCWFv8DkgLTRudSWxL7VwVoedc7lRz5EroGgJ33nRGCR0ngcW919tLTARDQO\npULmzulcdWeZgG+0PLX0xjJQIjFEvbOxR1Z+gxMupBz0rWFokmWYrcga8eWiWzjQ\nIa3/ASBVJ69srV77trWlfLumkChbXk9i64NXBKnce0Jmll0Y9OC1nMPqrbQKnzcn\ndSAA4fejD/qMQn0=\n-----END CERTIFICATE-----"));
    localBuilder.sslSocketFactory(((a.c)localObject).c(), ((a.c)localObject).d());
    localBuilder.hostnameVerifier(l.a);
    localBuilder.dns(new k(this));
    localBuilder.addInterceptor(new m(this.b));
    if (this.b.h() != null) {
      localObject = new o(this.b.h());
    } else {
      localObject = new o();
    }
    localBuilder.addNetworkInterceptor((Interceptor)localObject);
    return new r.b().c(this.a).g(localBuilder.build()).b(retrofit2.w.a.a.f()).a(new n()).e();
  }
  
  public static abstract interface a
  {
    public abstract String a();
    
    public abstract String b();
    
    public abstract String c();
    
    public abstract String e();
    
    public abstract b.d.b.e.k f();
    
    public abstract String g();
    
    public abstract String getUserAgent();
    
    public abstract HttpLoggingInterceptor.Logger h();
    
    public abstract String i();
    
    public abstract String j();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\c\d\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */