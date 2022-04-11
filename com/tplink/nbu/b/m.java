package com.tplink.nbu.b;

import b.d.b.d.a.a.c;
import com.tplink.cloud.context.TCAccountBean;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient.Builder;
import retrofit2.r;
import retrofit2.r.b;

public class m
  extends b.d.b.d.a.b
  implements n.a
{
  private final com.tplink.cloud.context.b d;
  private final String e;
  private String f;
  private String g;
  
  public m(com.tplink.cloud.context.b paramb)
  {
    super("https://api.i.tplinknbu.com");
    this.d = paramb;
    Map localMap = paramb.e().g();
    this.f = ((String)localMap.get("nbu_access_key"));
    this.g = ((String)localMap.get("nbu_secret"));
    this.e = String.format("app:%1$s:%2$s:%3$s", new Object[] { (String)localMap.get("nbu_app_cid_app_type"), paramb.e().d(), paramb.e().q() });
  }
  
  public String E()
  {
    return String.valueOf(this.d.e().g().get("nbu_alexa_app_type_x"));
  }
  
  public String S1()
  {
    return this.f;
  }
  
  public String T1()
  {
    return this.g;
  }
  
  public String a()
  {
    return this.d.e().d();
  }
  
  public String b()
  {
    return this.d.e().n();
  }
  
  public r c()
  {
    Object localObject1 = new OkHttpClient.Builder();
    Object localObject2 = TimeUnit.SECONDS;
    localObject2 = ((OkHttpClient.Builder)localObject1).connectTimeout(30L, (TimeUnit)localObject2).readTimeout(30L, (TimeUnit)localObject2).writeTimeout(30L, (TimeUnit)localObject2);
    localObject1 = o.a();
    if (localObject1 != null) {
      ((OkHttpClient.Builder)localObject2).sslSocketFactory(((a.c)localObject1).c(), ((a.c)localObject1).d());
    }
    ((OkHttpClient.Builder)localObject2).hostnameVerifier(k.a);
    ((OkHttpClient.Builder)localObject2).addInterceptor(new n(this));
    if ((S1() != null) && (T1() != null)) {
      ((OkHttpClient.Builder)localObject2).addInterceptor(new p(S1(), T1()));
    }
    localObject1 = com.tplink.cloud.context.a.k();
    if (localObject1 != null) {
      ((OkHttpClient.Builder)localObject2).addNetworkInterceptor((Interceptor)localObject1);
    }
    return new r.b().c("https://api.i.tplinknbu.com").g(((OkHttpClient.Builder)localObject2).build()).b(retrofit2.w.a.a.f()).a(new l()).e();
  }
  
  public String d()
  {
    return this.d.e().q();
  }
  
  public String e()
  {
    return this.d.c().getToken();
  }
  
  public String g()
  {
    return this.e;
  }
  
  public String i()
  {
    return this.d.e().b();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\nbu\b\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */