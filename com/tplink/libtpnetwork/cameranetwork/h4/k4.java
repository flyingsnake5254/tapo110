package com.tplink.libtpnetwork.cameranetwork.h4;

import b.d.b.d.a.a.c;
import com.google.gson.Gson;
import com.tplink.libtpnetwork.cameranetwork.h4.p4.f;
import com.tplink.libtpnetwork.cameranetwork.model.TypeAdapter;
import com.tplink.libtpnetwork.cameranetwork.model.Wrapper;
import com.tplink.libtpnetwork.cameranetwork.model.Wrappers;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient.Builder;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.adapter.rxjava2.g;
import retrofit2.r;
import retrofit2.r.b;

public class k4
{
  private Gson a = new com.google.gson.d().d(Wrapper.class, TypeAdapter.getWrapperSerializer()).d(Wrapper.class, TypeAdapter.getWrapperDeserializer()).d(Wrappers.class, TypeAdapter.getWrapperListSerializer()).d(Wrappers.class, TypeAdapter.getWrapperListDeserializer()).b();
  
  private r d(String paramString1, com.tplink.libtpnetwork.cameranetwork.h4.m4.b.b paramb, com.tplink.libtpnetwork.cameranetwork.h4.m4.a.a parama, String paramString2)
  {
    new HttpLoggingInterceptor(f4.a).setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient.Builder localBuilder = new OkHttpClient.Builder();
    localBuilder.hostnameVerifier(e4.a);
    localBuilder.cookieJar(new com.tplink.libtpnetwork.cameranetwork.h4.m4.b.a(paramb, paramString2));
    localBuilder.addInterceptor(new com.tplink.libtpnetwork.cameranetwork.h4.m4.a.b(paramString1, parama, paramString2));
    paramb = TimeUnit.SECONDS;
    localBuilder.readTimeout(30L, paramb);
    localBuilder.writeTimeout(30L, paramb);
    localBuilder.connectTimeout(30L, paramb);
    paramb = b.d.b.d.a.a.c(Collections.singletonList("-----BEGIN CERTIFICATE-----\nMIIDBzCCAe+gAwIBAgIQT5x0ma7QnINHCQvhnmzR9zANBgkqhkiG9w0BAQsFADAV\nMRMwEQYDVQQDEwp0cC1saW5rLUNBMCAXDTE4MDExOTA4Mjc1MloYDzIwNjgwMTE5\nMDgzNzUyWjAVMRMwEQYDVQQDEwp0cC1saW5rLUNBMIIBIjANBgkqhkiG9w0BAQEF\nAAOCAQ8AMIIBCgKCAQEAuGG8n5zEUN1j5wuvUz4pAIMurhKHbpfUUu+b2acFHKS6\niU9hNJWvDyhXcihY5Wz6aq9m4D5SZcgW3k31YoNNtrztDjdg2qw7AaX85S99/G0B\nVbIXktrhs34OW19WA/haDwut3dFhLem+gCRRKUXcmuqchZc84dY7JFVfhPcJci4m\nsRjLCFNO0ho9OX+MZwfO4BLaeAqKVoAor6rf4BXVtO0xjYHDKO0fb3AWLLJ4EjGe\nq6YieqPiYlPFEqRm5PrvBXTm0IuQogygyVpK4LHr/K207ZLyV33DxLLbsUgSEJVn\npZUv/WUujXjlIDgxIvyZZCYiXO3dle2/MEvpmZk6JQIDAQABo1EwTzALBgNVHQ8E\nBAMCAYYwDwYDVR0TAQH/BAUwAwEB/zAdBgNVHQ4EFgQUxu2iBRTsef5iNnsADVhM\nJDQWi6kwEAYJKwYBBAGCNxUBBAMCAQAwDQYJKoZIhvcNAQELBQADggEBAB52Majd\n+wo3cb5BsTo63z2Psbbyl4ACMUaw68NxUMy61Oihx3mcLzLJqiIZcKePiHskLqLJ\nF7QfT9TqjvizMjFJVgsLuVubUBXKBzqyN+3KKlQci0PO3mH+ObhyaE7BzV+qrS3P\ndVTgsCWFv8DkgLTRudSWxL7VwVoedc7lRz5EroGgJ33nRGCR0ngcW919tLTARDQO\npULmzulcdWeZgG+0PLX0xjJQIjFEvbOxR1Z+gxMupBz0rWFokmWYrcga8eWiWzjQ\nIa3/ASBVJ69srV77trWlfLumkChbXk9i64NXBKnce0Jmll0Y9OC1nMPqrbQKnzcn\ndSAA4fejD/qMQn0=\n-----END CERTIFICATE-----"));
    localBuilder.sslSocketFactory(paramb.c(), paramb.d());
    localBuilder.connectionPool(new ConnectionPool(10, 5L, TimeUnit.MINUTES));
    return new r.b().c(paramString1).b(retrofit2.w.a.a.g(this.a)).a(g.d()).g(localBuilder.build()).e();
  }
  
  public f a(String paramString1, com.tplink.libtpnetwork.cameranetwork.h4.m4.b.b paramb, com.tplink.libtpnetwork.cameranetwork.h4.m4.a.a parama, String paramString2)
  {
    return new f(paramString2, (com.tplink.libtpnetwork.cameranetwork.h4.p4.d)d(paramString1, paramb, parama, paramString2).b(com.tplink.libtpnetwork.cameranetwork.h4.p4.d.class));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\h4\k4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */