package com.tplink.libtpnetwork.libwss;

import androidx.lifecycle.MutableLiveData;
import b.d.b.d.a.c.a;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tplink.cloud.context.b;
import com.tplink.libtpnetwork.libwss.bean.WssException;
import com.tplink.libtpnetwork.libwss.bean.params.SkillActiveParams;
import com.tplink.libtpnetwork.libwss.enumerate.WssAccountBindState;
import io.reactivex.e;
import io.reactivex.f;
import io.reactivex.g0.j;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import okhttp3.OkHttpClient.Builder;
import okhttp3.ResponseBody;
import okhttp3.internal.tls.OkHostnameVerifier;
import retrofit2.HttpException;
import retrofit2.adapter.rxjava2.g;
import retrofit2.q;
import retrofit2.r;
import retrofit2.r.b;

public class WssCloudRepository
  extends b.d.b.f.a
  implements c.a
{
  private static final Gson c = new com.google.gson.d().c().b();
  private b d;
  private com.tplink.libtpnetwork.libwss.b.c e;
  private MutableLiveData<WssAccountBindState> f = new MutableLiveData();
  
  public WssCloudRepository(b paramb)
  {
    super(paramb);
    this.d = paramb;
    this.e = ((com.tplink.libtpnetwork.libwss.b.c)b.d.b.d.a.d.b(this).a("https://alexa-ffs.tplinknbu.com/").b(com.tplink.libtpnetwork.libwss.b.c.class));
    this.f.postValue(WssAccountBindState.UNKNOWN);
  }
  
  private f g()
  {
    return new b();
  }
  
  public r c()
  {
    OkHttpClient.Builder localBuilder = new OkHttpClient.Builder();
    Object localObject = TimeUnit.SECONDS;
    localObject = localBuilder.connectTimeout(30L, (TimeUnit)localObject).readTimeout(30L, (TimeUnit)localObject).writeTimeout(30L, (TimeUnit)localObject);
    ((OkHttpClient.Builder)localObject).hostnameVerifier(new a());
    ((OkHttpClient.Builder)localObject).addInterceptor(new a(this));
    return new r.b().c("https://alexa-ffs.tplinknbu.com/").g(((OkHttpClient.Builder)localObject).build()).b(retrofit2.w.a.a.f()).a(g.d()).e();
  }
  
  public io.reactivex.a f(String paramString, SkillActiveParams paramSkillActiveParams)
  {
    return this.e.a(paramString, paramSkillActiveParams).f(g()).i(new c()).C(io.reactivex.l0.a.c());
  }
  
  public io.reactivex.a j(String paramString)
  {
    return this.e.b(paramString).f(g()).C(io.reactivex.l0.a.c());
  }
  
  class a
    implements HostnameVerifier
  {
    a() {}
    
    public boolean verify(String paramString, SSLSession paramSSLSession)
    {
      if ((paramString.equals(paramSSLSession.getPeerHost())) && (paramString.endsWith("tplinknbu.com"))) {
        return true;
      }
      if (HttpsURLConnection.getDefaultHostnameVerifier().verify(paramString, paramSSLSession)) {
        return true;
      }
      return OkHostnameVerifier.INSTANCE.verify(paramString, paramSSLSession);
    }
  }
  
  class b
    implements f
  {
    b() {}
    
    public e a(io.reactivex.a parama)
    {
      return parama.u(new a());
    }
    
    class a
      implements j<Throwable, e>
    {
      a() {}
      
      public e a(Throwable paramThrowable)
        throws Exception
      {
        if ((paramThrowable instanceof HttpException))
        {
          Object localObject = ((HttpException)paramThrowable).response().d();
          if (localObject != null) {
            try
            {
              localObject = io.reactivex.a.m((Throwable)WssCloudRepository.d().j(((ResponseBody)localObject).charStream(), WssException.class));
              return (e)localObject;
            }
            catch (JsonSyntaxException localJsonSyntaxException)
            {
              return io.reactivex.a.m(paramThrowable);
            }
          }
        }
        return io.reactivex.a.m(paramThrowable);
      }
    }
  }
  
  class c
    implements io.reactivex.g0.a
  {
    c() {}
    
    public void run()
      throws Exception
    {
      WssCloudRepository.e(WssCloudRepository.this).postValue(WssAccountBindState.BIND);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\libwss\WssCloudRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */