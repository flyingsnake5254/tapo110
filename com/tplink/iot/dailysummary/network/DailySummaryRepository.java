package com.tplink.iot.dailysummary.network;

import android.text.TextUtils;
import com.tplink.iot.cloud.repository.AbstractIoTCloudRepository;
import com.tplink.iot.dailysummary.network.bean.common.SummaryConfig;
import com.tplink.iot.dailysummary.network.bean.params.CancelCreateSummaryParams;
import com.tplink.iot.dailysummary.network.bean.params.CreateSummaryParams;
import com.tplink.iot.dailysummary.network.bean.params.DeleteSummaryParams;
import com.tplink.iot.dailysummary.network.bean.result.RecentSummaryListResult;
import com.tplink.iot.dailysummary.network.bean.result.SummaryClipInfoResult;
import com.tplink.iot.dailysummary.network.bean.result.SummaryEventIdResult;
import com.tplink.iot.dailysummary.network.bean.result.SummaryListResult;
import com.tplink.iot.dailysummary.network.bean.result.SummaryResult;
import com.tplink.iot.dailysummary.network.bean.result.SummarySupportResult;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.AppUrlRepository;
import io.reactivex.e;
import io.reactivex.e0.c;
import io.reactivex.g0.l;
import io.reactivex.m0.d;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicBoolean;

public final class DailySummaryRepository
  extends AbstractIoTCloudRepository
{
  public static final a h = new a(null);
  private a i;
  private AppUrlRepository j;
  private String k = "";
  private final AtomicBoolean l = new AtomicBoolean(false);
  private final io.reactivex.m0.g<Boolean> m;
  
  public DailySummaryRepository(com.tplink.iot.c.c.a parama)
  {
    super(parama);
    Object localObject = d.n1().l1();
    kotlin.jvm.internal.j.d(localObject, "PublishSubject.create<Boolean>().toSerialized()");
    this.m = ((io.reactivex.m0.g)localObject);
    localObject = parama.k().R1(a.class);
    kotlin.jvm.internal.j.d(localObject, "accountContext.ioTCloudC…lySummaryApi::class.java)");
    this.i = ((a)localObject);
    parama = b.d.b.f.b.a(parama, AppUrlRepository.class);
    kotlin.jvm.internal.j.d(parama, "CloudRepositoryProviders…ory::class.java\n        )");
    parama = (AppUrlRepository)parama;
    this.j = parama;
    parama = parama.f();
    if (parama != null) {
      this.k = parama;
    }
  }
  
  private final q<Boolean> D()
  {
    Object localObject;
    if (!TextUtils.isEmpty(this.k))
    {
      localObject = q.f0(Boolean.TRUE);
      kotlin.jvm.internal.j.d(localObject, "Observable.just(true)");
    }
    else
    {
      if (!TextUtils.isEmpty(this.j.f()))
      {
        localObject = this.j.f();
        kotlin.jvm.internal.j.d(localObject, "appUrlRepository.tapoCareUrl");
        this.k = ((String)localObject);
        localObject = q.f0(Boolean.TRUE);
      }
      else
      {
        localObject = this.m.Q0(1L).F(new c(this)).N(d.c);
      }
      kotlin.jvm.internal.j.d(localObject, "if (!TextUtils.isEmpty(a…              }\n        }");
    }
    return (q<Boolean>)localObject;
  }
  
  private final void e()
  {
    q.f0(Integer.valueOf(1)).L(new g(this)).N(new h(this)).l0(io.reactivex.l0.a.d()).H0(new i(this), new j(this));
  }
  
  public final q<SummaryEventIdResult> C(final CancelCreateSummaryParams paramCancelCreateSummaryParams)
  {
    kotlin.jvm.internal.j.e(paramCancelCreateSummaryParams, "params");
    paramCancelCreateSummaryParams = D().N(new b(this, paramCancelCreateSummaryParams)).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
    kotlin.jvm.internal.j.d(paramCancelCreateSummaryParams, "checkTapoCareUrl().flatM…dSchedulers.mainThread())");
    return paramCancelCreateSummaryParams;
  }
  
  public final q<SummaryEventIdResult> E(final CreateSummaryParams paramCreateSummaryParams)
  {
    kotlin.jvm.internal.j.e(paramCreateSummaryParams, "params");
    paramCreateSummaryParams = D().N(new e(this, paramCreateSummaryParams)).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
    kotlin.jvm.internal.j.d(paramCreateSummaryParams, "checkTapoCareUrl().flatM…dSchedulers.mainThread())");
    return paramCreateSummaryParams;
  }
  
  public final io.reactivex.a F(final DeleteSummaryParams paramDeleteSummaryParams)
  {
    kotlin.jvm.internal.j.e(paramDeleteSummaryParams, "params");
    paramDeleteSummaryParams = D().R(new f(this, paramDeleteSummaryParams)).C(io.reactivex.l0.a.c()).r(io.reactivex.d0.b.a.a());
    kotlin.jvm.internal.j.d(paramDeleteSummaryParams, "checkTapoCareUrl().flatM…dSchedulers.mainThread())");
    return paramDeleteSummaryParams;
  }
  
  public final AppUrlRepository G()
  {
    return this.j;
  }
  
  public final q<RecentSummaryListResult> H(final String paramString, final int paramInt)
  {
    kotlin.jvm.internal.j.e(paramString, "deviceId");
    paramString = D().N(new k(this, paramString, paramInt)).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
    kotlin.jvm.internal.j.d(paramString, "checkTapoCareUrl().flatM…dSchedulers.mainThread())");
    return paramString;
  }
  
  public final q<SummaryResult> I(final String paramString1, final String paramString2)
  {
    kotlin.jvm.internal.j.e(paramString1, "deviceId");
    kotlin.jvm.internal.j.e(paramString2, "date");
    paramString1 = D().N(new l(this, paramString1, paramString2)).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
    kotlin.jvm.internal.j.d(paramString1, "checkTapoCareUrl().flatM…dSchedulers.mainThread())");
    return paramString1;
  }
  
  public final q<SummaryClipInfoResult> J(final String paramString1, final String paramString2, final String paramString3)
  {
    kotlin.jvm.internal.j.e(paramString1, "deviceId");
    kotlin.jvm.internal.j.e(paramString2, "date");
    kotlin.jvm.internal.j.e(paramString3, "uuid");
    paramString1 = D().N(new m(this, paramString1, paramString2, paramString3)).L0(io.reactivex.l0.a.d()).l0(io.reactivex.d0.b.a.a());
    kotlin.jvm.internal.j.d(paramString1, "checkTapoCareUrl().flatM…dSchedulers.mainThread())");
    return paramString1;
  }
  
  public final q<SummaryConfig> K(final String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "deviceId");
    paramString = D().N(new n(this, paramString)).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
    kotlin.jvm.internal.j.d(paramString, "checkTapoCareUrl().flatM…dSchedulers.mainThread())");
    return paramString;
  }
  
  public final q<SummaryListResult> L(final String paramString, final int paramInt1, final int paramInt2)
  {
    kotlin.jvm.internal.j.e(paramString, "deviceId");
    paramString = D().N(new o(this, paramString, paramInt1, paramInt2)).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
    kotlin.jvm.internal.j.d(paramString, "checkTapoCareUrl().flatM…dSchedulers.mainThread())");
    return paramString;
  }
  
  public final q<SummarySupportResult> M(final String paramString1, final String paramString2, final String paramString3)
  {
    kotlin.jvm.internal.j.e(paramString1, "deviceId");
    kotlin.jvm.internal.j.e(paramString2, "timezone");
    kotlin.jvm.internal.j.e(paramString3, "deviceType");
    paramString1 = D().N(new p(this, paramString1, paramString2, paramString3)).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
    kotlin.jvm.internal.j.d(paramString1, "checkTapoCareUrl().flatM…dSchedulers.mainThread())");
    return paramString1;
  }
  
  public final io.reactivex.a N(final SummaryConfig paramSummaryConfig)
  {
    kotlin.jvm.internal.j.e(paramSummaryConfig, "params");
    paramSummaryConfig = D().R(new q(this, paramSummaryConfig)).C(io.reactivex.l0.a.c()).r(io.reactivex.d0.b.a.a());
    kotlin.jvm.internal.j.d(paramSummaryConfig, "checkTapoCareUrl().flatM…dSchedulers.mainThread())");
    return paramSummaryConfig;
  }
  
  public static final class a {}
  
  static final class b<T, R>
    implements io.reactivex.g0.j<Boolean, t<? extends SummaryEventIdResult>>
  {
    b(DailySummaryRepository paramDailySummaryRepository, CancelCreateSummaryParams paramCancelCreateSummaryParams) {}
    
    public final t<? extends SummaryEventIdResult> a(Boolean paramBoolean)
    {
      kotlin.jvm.internal.j.e(paramBoolean, "it");
      if (paramBoolean.booleanValue()) {
        paramBoolean = DailySummaryRepository.y(this.c).i(DailySummaryRepository.x(this.c), paramCancelCreateSummaryParams);
      } else {
        paramBoolean = q.J(new Exception("tapocare url empty!"));
      }
      return paramBoolean;
    }
  }
  
  static final class c<T>
    implements io.reactivex.g0.g<c>
  {
    c(DailySummaryRepository paramDailySummaryRepository) {}
    
    public final void a(c paramc)
    {
      DailySummaryRepository.w(this.c);
    }
  }
  
  static final class d<T, R>
    implements io.reactivex.g0.j<Boolean, t<? extends Boolean>>
  {
    public static final d c = new d();
    
    public final t<? extends Boolean> a(Boolean paramBoolean)
    {
      kotlin.jvm.internal.j.e(paramBoolean, "it");
      if (paramBoolean.booleanValue()) {
        paramBoolean = q.f0(Boolean.TRUE);
      } else {
        paramBoolean = q.J(new Exception("tapocare url empty!!"));
      }
      return paramBoolean;
    }
  }
  
  static final class e<T, R>
    implements io.reactivex.g0.j<Boolean, t<? extends SummaryEventIdResult>>
  {
    e(DailySummaryRepository paramDailySummaryRepository, CreateSummaryParams paramCreateSummaryParams) {}
    
    public final t<? extends SummaryEventIdResult> a(Boolean paramBoolean)
    {
      kotlin.jvm.internal.j.e(paramBoolean, "it");
      if (paramBoolean.booleanValue()) {
        paramBoolean = DailySummaryRepository.y(this.c).b(DailySummaryRepository.x(this.c), paramCreateSummaryParams);
      } else {
        paramBoolean = q.J(new Exception("tapocare url empty!"));
      }
      return paramBoolean;
    }
  }
  
  static final class f<T, R>
    implements io.reactivex.g0.j<Boolean, e>
  {
    f(DailySummaryRepository paramDailySummaryRepository, DeleteSummaryParams paramDeleteSummaryParams) {}
    
    public final e a(Boolean paramBoolean)
    {
      kotlin.jvm.internal.j.e(paramBoolean, "it");
      if (paramBoolean.booleanValue()) {
        paramBoolean = DailySummaryRepository.y(this.c).h(DailySummaryRepository.x(this.c), paramDeleteSummaryParams);
      } else {
        paramBoolean = io.reactivex.a.m(new Exception("tapocare url empty!"));
      }
      return paramBoolean;
    }
  }
  
  static final class g<T>
    implements l<Integer>
  {
    g(DailySummaryRepository paramDailySummaryRepository) {}
    
    public final boolean a(Integer paramInteger)
    {
      kotlin.jvm.internal.j.e(paramInteger, "it");
      return DailySummaryRepository.A(this.c).get() ^ true;
    }
  }
  
  static final class h<T, R>
    implements io.reactivex.g0.j<Integer, t<? extends Boolean>>
  {
    h(DailySummaryRepository paramDailySummaryRepository) {}
    
    public final t<? extends Boolean> a(Integer paramInteger)
    {
      kotlin.jvm.internal.j.e(paramInteger, "it");
      DailySummaryRepository.A(this.c).set(true);
      return this.c.G().d().E(new a(this)).C(b.c);
    }
    
    static final class a<T>
      implements io.reactivex.g0.g<Boolean>
    {
      a(DailySummaryRepository.h paramh) {}
      
      public final void a(Boolean paramBoolean)
      {
        kotlin.jvm.internal.j.d(paramBoolean, "it");
        if ((paramBoolean.booleanValue()) && (!TextUtils.isEmpty(this.c.c.G().f())))
        {
          DailySummaryRepository localDailySummaryRepository = this.c.c;
          paramBoolean = localDailySummaryRepository.G().f();
          kotlin.jvm.internal.j.d(paramBoolean, "appUrlRepository.tapoCareUrl");
          DailySummaryRepository.B(localDailySummaryRepository, paramBoolean);
        }
      }
    }
    
    static final class b<T>
      implements io.reactivex.g0.g<Throwable>
    {
      public static final b c = new b();
      
      public final void a(Throwable paramThrowable)
      {
        paramThrowable.printStackTrace();
      }
    }
  }
  
  static final class i<T>
    implements io.reactivex.g0.g<Boolean>
  {
    i(DailySummaryRepository paramDailySummaryRepository) {}
    
    public final void a(Boolean paramBoolean)
    {
      DailySummaryRepository.A(this.c).set(false);
      DailySummaryRepository.z(this.c).onNext(Boolean.TRUE);
    }
  }
  
  static final class j<T>
    implements io.reactivex.g0.g<Throwable>
  {
    j(DailySummaryRepository paramDailySummaryRepository) {}
    
    public final void a(Throwable paramThrowable)
    {
      DailySummaryRepository.A(this.c).set(false);
      DailySummaryRepository.z(this.c).onNext(Boolean.FALSE);
    }
  }
  
  static final class k<T, R>
    implements io.reactivex.g0.j<Boolean, t<? extends RecentSummaryListResult>>
  {
    k(DailySummaryRepository paramDailySummaryRepository, String paramString, int paramInt) {}
    
    public final t<? extends RecentSummaryListResult> a(Boolean paramBoolean)
    {
      kotlin.jvm.internal.j.e(paramBoolean, "it");
      if (paramBoolean.booleanValue()) {
        paramBoolean = DailySummaryRepository.y(this.c).c(DailySummaryRepository.x(this.c), paramString, paramInt);
      } else {
        paramBoolean = q.J(new Exception("tapocare url empty!"));
      }
      return paramBoolean;
    }
  }
  
  static final class l<T, R>
    implements io.reactivex.g0.j<Boolean, t<? extends SummaryResult>>
  {
    l(DailySummaryRepository paramDailySummaryRepository, String paramString1, String paramString2) {}
    
    public final t<? extends SummaryResult> a(Boolean paramBoolean)
    {
      kotlin.jvm.internal.j.e(paramBoolean, "it");
      if (paramBoolean.booleanValue()) {
        paramBoolean = DailySummaryRepository.y(this.c).e(DailySummaryRepository.x(this.c), paramString1, paramString2);
      } else {
        paramBoolean = q.J(new Exception("tapocare url empty!"));
      }
      return paramBoolean;
    }
  }
  
  static final class m<T, R>
    implements io.reactivex.g0.j<Boolean, t<? extends SummaryClipInfoResult>>
  {
    m(DailySummaryRepository paramDailySummaryRepository, String paramString1, String paramString2, String paramString3) {}
    
    public final t<? extends SummaryClipInfoResult> a(Boolean paramBoolean)
    {
      kotlin.jvm.internal.j.e(paramBoolean, "it");
      if (paramBoolean.booleanValue()) {
        paramBoolean = DailySummaryRepository.y(this.c).d(DailySummaryRepository.x(this.c), paramString1, paramString2, paramString3);
      } else {
        paramBoolean = q.J(new Exception("tapocare url empty!"));
      }
      return paramBoolean;
    }
  }
  
  static final class n<T, R>
    implements io.reactivex.g0.j<Boolean, t<? extends SummaryConfig>>
  {
    n(DailySummaryRepository paramDailySummaryRepository, String paramString) {}
    
    public final t<? extends SummaryConfig> a(Boolean paramBoolean)
    {
      kotlin.jvm.internal.j.e(paramBoolean, "it");
      if (paramBoolean.booleanValue()) {
        paramBoolean = DailySummaryRepository.y(this.c).a(DailySummaryRepository.x(this.c), paramString);
      } else {
        paramBoolean = q.J(new Exception("tapocare url empty!"));
      }
      return paramBoolean;
    }
  }
  
  static final class o<T, R>
    implements io.reactivex.g0.j<Boolean, t<? extends SummaryListResult>>
  {
    o(DailySummaryRepository paramDailySummaryRepository, String paramString, int paramInt1, int paramInt2) {}
    
    public final t<? extends SummaryListResult> a(Boolean paramBoolean)
    {
      kotlin.jvm.internal.j.e(paramBoolean, "it");
      if (paramBoolean.booleanValue()) {
        paramBoolean = DailySummaryRepository.y(this.c).g(DailySummaryRepository.x(this.c), paramString, paramInt1, paramInt2);
      } else {
        paramBoolean = q.J(new Exception("tapocare url empty!"));
      }
      return paramBoolean;
    }
  }
  
  static final class p<T, R>
    implements io.reactivex.g0.j<Boolean, t<? extends SummarySupportResult>>
  {
    p(DailySummaryRepository paramDailySummaryRepository, String paramString1, String paramString2, String paramString3) {}
    
    public final t<? extends SummarySupportResult> a(Boolean paramBoolean)
    {
      kotlin.jvm.internal.j.e(paramBoolean, "it");
      if (paramBoolean.booleanValue()) {
        paramBoolean = DailySummaryRepository.y(this.c).f(DailySummaryRepository.x(this.c), paramString1, paramString2, paramString3);
      } else {
        paramBoolean = q.J(new Exception("tapocare url empty!"));
      }
      return paramBoolean;
    }
  }
  
  static final class q<T, R>
    implements io.reactivex.g0.j<Boolean, e>
  {
    q(DailySummaryRepository paramDailySummaryRepository, SummaryConfig paramSummaryConfig) {}
    
    public final e a(Boolean paramBoolean)
    {
      kotlin.jvm.internal.j.e(paramBoolean, "it");
      if (paramBoolean.booleanValue()) {
        paramBoolean = DailySummaryRepository.y(this.c).j(DailySummaryRepository.x(this.c), paramSummaryConfig);
      } else {
        paramBoolean = io.reactivex.a.m(new Exception("tapocare url empty!"));
      }
      return paramBoolean;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\network\DailySummaryRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */