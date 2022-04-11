package com.tplink.libtpnetwork.libwss;

import b.d.b.d.a.c;
import b.d.b.d.a.c.a;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.libtpnetwork.Utils.x;
import com.tplink.libtpnetwork.libwss.bean.WssException;
import com.tplink.libtpnetwork.libwss.bean.result.GoogleAssistantLinkInfoResult;
import io.reactivex.e;
import io.reactivex.f;
import io.reactivex.t;
import io.reactivex.u;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import kotlin.text.m;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.tls.OkHostnameVerifier;
import retrofit2.HttpException;
import retrofit2.adapter.rxjava2.g;
import retrofit2.r;
import retrofit2.r.b;

public final class GoogleAssistantRepository
  extends b.d.b.f.a
  implements c.a
{
  private static final Gson c = new com.google.gson.d().c().b();
  public static final a d = new a(null);
  private final com.tplink.libtpnetwork.libwss.b.b e;
  private final com.tplink.cloud.context.b f;
  
  public GoogleAssistantRepository(com.tplink.cloud.context.b paramb)
  {
    super(paramb);
    this.f = paramb;
    paramb = b.d.b.d.a.d.b(this).a("https://api-aog-smart-home.tplinknbu.com").b(com.tplink.libtpnetwork.libwss.b.b.class);
    kotlin.jvm.internal.j.d(paramb, "RetrofitProviders.of(thi…SmartHomeApi::class.java)");
    this.e = ((com.tplink.libtpnetwork.libwss.b.b)paramb);
  }
  
  private final f f()
  {
    return d.a;
  }
  
  private final <T> u<T, T> g()
  {
    return e.a;
  }
  
  public r c()
  {
    OkHttpClient.Builder localBuilder = new OkHttpClient.Builder();
    long l = 30;
    Object localObject = TimeUnit.SECONDS;
    localObject = localBuilder.connectTimeout(l, (TimeUnit)localObject).readTimeout(l, (TimeUnit)localObject).writeTimeout(l, (TimeUnit)localObject);
    ((OkHttpClient.Builder)localObject).hostnameVerifier(b.a);
    ((OkHttpClient.Builder)localObject).addInterceptor(new c(this));
    localObject = new r.b().c("https://api-aog-smart-home.tplinknbu.com").g(((OkHttpClient.Builder)localObject).build()).b(retrofit2.w.a.a.f()).a(g.d()).e();
    kotlin.jvm.internal.j.d(localObject, "Retrofit.Builder().baseU…e())\n            .build()");
    return (r)localObject;
  }
  
  public final io.reactivex.q<GoogleAssistantLinkInfoResult> h(String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "skillCode");
    paramString = this.e.a(paramString).i(g()).L0(io.reactivex.l0.a.c());
    kotlin.jvm.internal.j.d(paramString, "mGoogleSmartHomeApi.isGo…scribeOn(Schedulers.io())");
    return paramString;
  }
  
  public final io.reactivex.a i(String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "skillCode");
    paramString = this.e.b(paramString).f(f()).C(io.reactivex.l0.a.c());
    kotlin.jvm.internal.j.d(paramString, "mGoogleSmartHomeApi.unbi…scribeOn(Schedulers.io())");
    return paramString;
  }
  
  public static final class a {}
  
  static final class b
    implements HostnameVerifier
  {
    public static final b a = new b();
    
    public final boolean verify(String paramString, SSLSession paramSSLSession)
    {
      kotlin.jvm.internal.j.d(paramSSLSession, "session");
      boolean bool1 = kotlin.jvm.internal.j.a(paramString, paramSSLSession.getPeerHost());
      boolean bool2 = true;
      if (bool1)
      {
        kotlin.jvm.internal.j.d(paramString, "hostname");
        if (m.p(paramString, "tplinknbu.com", false, 2, null)) {
          return true;
        }
      }
      if (!HttpsURLConnection.getDefaultHostnameVerifier().verify(paramString, paramSSLSession)) {
        bool2 = OkHostnameVerifier.INSTANCE.verify(paramString, paramSSLSession);
      }
      return bool2;
    }
  }
  
  static final class c
    implements Interceptor
  {
    c(GoogleAssistantRepository paramGoogleAssistantRepository) {}
    
    public final Response intercept(Interceptor.Chain paramChain)
    {
      kotlin.jvm.internal.j.e(paramChain, "chain");
      Object localObject = paramChain.request();
      Request localRequest = paramChain.request();
      Request.Builder localBuilder = localRequest.newBuilder();
      if ((GoogleAssistantRepository.e(this.a) != null) && (GoogleAssistantRepository.e(this.a).c() != null))
      {
        TCAccountBean localTCAccountBean = GoogleAssistantRepository.e(this.a).c();
        kotlin.jvm.internal.j.d(localTCAccountBean, "mTcAccountContext.account");
        if ((localTCAccountBean.getToken() != null) && (((Request)localObject).header("Authorization") == null))
        {
          localObject = GoogleAssistantRepository.e(this.a).c();
          kotlin.jvm.internal.j.d(localObject, "mTcAccountContext.account");
          localBuilder.addHeader("Authorization", ((TCAccountBean)localObject).getToken());
        }
      }
      if (localRequest.header("Content-Type") == null)
      {
        localBuilder.addHeader("Content-Type", "application/json;charset=UTF-8");
      }
      else
      {
        localBuilder.removeHeader("Content-Type");
        localBuilder.addHeader("Content-Type", "application/json;charset=UTF-8");
      }
      localBuilder.addHeader("Locale", x.d(Locale.getDefault()));
      localBuilder.addHeader("X-App-Type", "android");
      return paramChain.proceed(localBuilder.build());
    }
  }
  
  static final class d
    implements f
  {
    public static final d a = new d();
    
    public final e a(io.reactivex.a parama)
    {
      kotlin.jvm.internal.j.e(parama, "upstream");
      return parama.u(new a());
    }
    
    public static final class a
      implements io.reactivex.g0.j<Throwable, e>
    {
      public e a(Throwable paramThrowable)
      {
        kotlin.jvm.internal.j.e(paramThrowable, "throwable");
        if ((paramThrowable instanceof HttpException))
        {
          Object localObject = ((HttpException)paramThrowable).response();
          kotlin.jvm.internal.j.c(localObject);
          localObject = ((retrofit2.q)localObject).d();
          if (localObject != null)
          {
            try
            {
              localObject = io.reactivex.a.m((Throwable)GoogleAssistantRepository.d().j(((ResponseBody)localObject).charStream(), WssException.class));
              kotlin.jvm.internal.j.d(localObject, "Completable.error(\n     …                        )");
              paramThrowable = (Throwable)localObject;
            }
            catch (JsonSyntaxException localJsonSyntaxException)
            {
              paramThrowable = io.reactivex.a.m(paramThrowable);
              kotlin.jvm.internal.j.d(paramThrowable, "Completable.error(throwable)");
            }
            return paramThrowable;
          }
        }
        paramThrowable = io.reactivex.a.m(paramThrowable);
        kotlin.jvm.internal.j.d(paramThrowable, "Completable.error(throwable)");
        return paramThrowable;
      }
    }
  }
  
  static final class e<Upstream, Downstream>
    implements u<T, T>
  {
    public static final e a = new e();
    
    public final t<T> a(io.reactivex.q<T> paramq)
    {
      kotlin.jvm.internal.j.e(paramq, "upstream");
      return paramq.o0(new a());
    }
    
    public static final class a
      implements io.reactivex.g0.j<Throwable, t<T>>
    {
      public t<T> a(Throwable paramThrowable)
        throws Exception
      {
        kotlin.jvm.internal.j.e(paramThrowable, "throwable");
        if ((paramThrowable instanceof HttpException))
        {
          Object localObject = ((HttpException)paramThrowable).response();
          if (localObject != null) {
            localObject = ((retrofit2.q)localObject).d();
          } else {
            localObject = null;
          }
          if (localObject != null)
          {
            try
            {
              localObject = io.reactivex.q.J((Throwable)GoogleAssistantRepository.d().j(((ResponseBody)localObject).charStream(), WssException.class));
              kotlin.jvm.internal.j.d(localObject, "Observable.error(\n      …                        )");
              paramThrowable = (Throwable)localObject;
            }
            catch (JsonSyntaxException localJsonSyntaxException)
            {
              paramThrowable = io.reactivex.q.J(paramThrowable);
              kotlin.jvm.internal.j.d(paramThrowable, "Observable.error(throwable)");
            }
            return paramThrowable;
          }
        }
        paramThrowable = io.reactivex.q.J(paramThrowable);
        kotlin.jvm.internal.j.d(paramThrowable, "Observable.error(throwable)");
        return paramThrowable;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\libwss\GoogleAssistantRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */