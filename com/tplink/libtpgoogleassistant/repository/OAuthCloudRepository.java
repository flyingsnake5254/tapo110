package com.tplink.libtpgoogleassistant.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import b.d.b.d.a.a.c;
import b.d.b.d.a.c.a;
import b.d.b.d.a.d;
import com.tplink.libtpgoogleassistant.bean.params.AuthClientListParams;
import com.tplink.libtpgoogleassistant.bean.params.AuthCodeParams;
import com.tplink.libtpgoogleassistant.bean.result.AuthCodeResult;
import com.tplink.libtpgoogleassistant.bean.result.AuthResult;
import com.tplink.libtpgoogleassistant.bean.result.AuthValidClientList;
import io.reactivex.q;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient.Builder;
import retrofit2.adapter.rxjava2.g;
import retrofit2.r;
import retrofit2.r.b;

public class OAuthCloudRepository
  extends b.d.b.f.a
  implements c.a
{
  private b.d.k.c.a c = (b.d.k.c.a)d.b(this).a("https://n-oauth.tplinkcloud.com").b(b.d.k.c.a.class);
  private MutableLiveData<Boolean> d = new MutableLiveData();
  
  public OAuthCloudRepository(com.tplink.cloud.context.b paramb)
  {
    super(paramb);
  }
  
  private boolean g(AuthResult<AuthValidClientList> paramAuthResult)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramAuthResult != null) {
      if (paramAuthResult.getErrorCode() != 0)
      {
        bool2 = bool1;
      }
      else
      {
        paramAuthResult = (AuthValidClientList)paramAuthResult.getResult();
        bool2 = bool1;
        if (paramAuthResult != null)
        {
          bool2 = bool1;
          if (paramAuthResult.getClientList() != null)
          {
            bool2 = bool1;
            if (!paramAuthResult.getClientList().isEmpty()) {
              bool2 = true;
            }
          }
        }
      }
    }
    return bool2;
  }
  
  public r c()
  {
    Object localObject1 = new OkHttpClient.Builder();
    Object localObject2 = TimeUnit.SECONDS;
    localObject2 = ((OkHttpClient.Builder)localObject1).connectTimeout(30L, (TimeUnit)localObject2).readTimeout(30L, (TimeUnit)localObject2).writeTimeout(30L, (TimeUnit)localObject2);
    localObject1 = b.d.b.d.a.a.c(Collections.singletonList("-----BEGIN CERTIFICATE-----\nMIIDBzCCAe+gAwIBAgIQT5x0ma7QnINHCQvhnmzR9zANBgkqhkiG9w0BAQsFADAV\nMRMwEQYDVQQDEwp0cC1saW5rLUNBMCAXDTE4MDExOTA4Mjc1MloYDzIwNjgwMTE5\nMDgzNzUyWjAVMRMwEQYDVQQDEwp0cC1saW5rLUNBMIIBIjANBgkqhkiG9w0BAQEF\nAAOCAQ8AMIIBCgKCAQEAuGG8n5zEUN1j5wuvUz4pAIMurhKHbpfUUu+b2acFHKS6\niU9hNJWvDyhXcihY5Wz6aq9m4D5SZcgW3k31YoNNtrztDjdg2qw7AaX85S99/G0B\nVbIXktrhs34OW19WA/haDwut3dFhLem+gCRRKUXcmuqchZc84dY7JFVfhPcJci4m\nsRjLCFNO0ho9OX+MZwfO4BLaeAqKVoAor6rf4BXVtO0xjYHDKO0fb3AWLLJ4EjGe\nq6YieqPiYlPFEqRm5PrvBXTm0IuQogygyVpK4LHr/K207ZLyV33DxLLbsUgSEJVn\npZUv/WUujXjlIDgxIvyZZCYiXO3dle2/MEvpmZk6JQIDAQABo1EwTzALBgNVHQ8E\nBAMCAYYwDwYDVR0TAQH/BAUwAwEB/zAdBgNVHQ4EFgQUxu2iBRTsef5iNnsADVhM\nJDQWi6kwEAYJKwYBBAGCNxUBBAMCAQAwDQYJKoZIhvcNAQELBQADggEBAB52Majd\n+wo3cb5BsTo63z2Psbbyl4ACMUaw68NxUMy61Oihx3mcLzLJqiIZcKePiHskLqLJ\nF7QfT9TqjvizMjFJVgsLuVubUBXKBzqyN+3KKlQci0PO3mH+ObhyaE7BzV+qrS3P\ndVTgsCWFv8DkgLTRudSWxL7VwVoedc7lRz5EroGgJ33nRGCR0ngcW919tLTARDQO\npULmzulcdWeZgG+0PLX0xjJQIjFEvbOxR1Z+gxMupBz0rWFokmWYrcga8eWiWzjQ\nIa3/ASBVJ69srV77trWlfLumkChbXk9i64NXBKnce0Jmll0Y9OC1nMPqrbQKnzcn\ndSAA4fejD/qMQn0=\n-----END CERTIFICATE-----"));
    ((OkHttpClient.Builder)localObject2).sslSocketFactory(((a.c)localObject1).c(), ((a.c)localObject1).d());
    ((OkHttpClient.Builder)localObject2).hostnameVerifier(b.a);
    ((OkHttpClient.Builder)localObject2).addInterceptor(c.a);
    return new r.b().c("https://n-oauth.tplinkcloud.com").g(((OkHttpClient.Builder)localObject2).build()).b(retrofit2.w.a.a.f()).a(g.d()).e();
  }
  
  public q<AuthResult<AuthCodeResult>> d(AuthCodeParams paramAuthCodeParams)
  {
    return this.c.a(paramAuthCodeParams).L0(io.reactivex.l0.a.c());
  }
  
  public q<AuthResult<AuthValidClientList>> e(String paramString)
  {
    paramString = new AuthClientListParams(paramString);
    return this.c.b(paramString).L0(io.reactivex.l0.a.c()).E(new a(this));
  }
  
  public Boolean f()
  {
    return (Boolean)this.d.getValue();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpgoogleassistant\repository\OAuthCloudRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */