package com.tplink.libtpnetwork.TPCloudNetwork.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import b.d.b.d.a.b;
import com.tplink.cloud.define.CloudException;
import com.tplink.iot.cloud.bean.common.PageListResult;
import com.tplink.iot.cloud.bean.thing.params.ThingLightingEffectParams;
import com.tplink.iot.cloud.repository.AbstractIoTCloudRepository;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.AbstractLightingEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.LightingEffectMeta;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.PredefinedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.PredefinedEffectTemplate;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingListPageParams;
import io.reactivex.g0.g;
import io.reactivex.q;
import io.reactivex.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;

public final class LightingEffectRepository
  extends AbstractIoTCloudRepository
{
  private static final int[] h = { 1, 2 };
  public static final a i = new a(null);
  private final com.tplink.iot.c.b.j j;
  private final Map<String, CustomizedEffect> k;
  private final MutableLiveData<List<CustomizedEffect>> l;
  private final LiveData<List<CustomizedEffect>> m;
  private final Map<String, PredefinedEffect> n;
  private final MutableLiveData<List<PredefinedEffect>> o;
  private final LiveData<List<PredefinedEffect>> p;
  private final Map<String, PredefinedEffectTemplate> q;
  
  public LightingEffectRepository(com.tplink.iot.c.c.a parama)
  {
    super(parama);
    this.j = ((com.tplink.iot.c.b.j)parama.k().R1(com.tplink.iot.c.b.j.class));
    this.k = new LinkedHashMap();
    parama = new MutableLiveData();
    this.l = parama;
    this.m = parama;
    this.n = new LinkedHashMap();
    parama = new MutableLiveData();
    this.o = parama;
    this.p = parama;
    this.q = new LinkedHashMap();
  }
  
  private final q<com.google.gson.i> O(String paramString, ThingLightingEffectParams paramThingLightingEffectParams)
  {
    paramString = this.j.m1(paramString, paramThingLightingEffectParams).L0(io.reactivex.l0.a.c());
    kotlin.jvm.internal.j.d(paramString, "mThingApi.createCustomiz…scribeOn(Schedulers.io())");
    return paramString;
  }
  
  private final io.reactivex.a Q(String paramString1, String paramString2)
  {
    paramString1 = this.j.C(paramString1, paramString2).C(io.reactivex.l0.a.c());
    kotlin.jvm.internal.j.d(paramString1, "mThingApi.deleteCustomiz…scribeOn(Schedulers.io())");
    return paramString1;
  }
  
  private final q<List<com.google.gson.i>> R(ThingListPageParams paramThingListPageParams)
  {
    return S(paramThingListPageParams, new i(this));
  }
  
  private final q<List<com.google.gson.i>> S(final ThingListPageParams paramThingListPageParams, p<? super String, ? super ThingListPageParams, ? extends q<PageListResult<com.google.gson.i>>> paramp)
  {
    final ArrayList localArrayList = new ArrayList();
    paramThingListPageParams = d().N(new j(paramp, paramThingListPageParams, localArrayList));
    kotlin.jvm.internal.j.d(paramThingListPageParams, "checkAppServerUrl()\n    …          }\n            }");
    return paramThingListPageParams;
  }
  
  private final q<List<com.google.gson.i>> T(ThingListPageParams paramThingListPageParams)
  {
    return S(paramThingListPageParams, new k(this));
  }
  
  private final q<PageListResult<com.google.gson.i>> d0(String paramString1, int paramInt1, int paramInt2, String paramString2, int[] paramArrayOfInt)
  {
    paramArrayOfInt = kotlin.collections.e.q(paramArrayOfInt, ",", null, null, 0, null, null, 62, null);
    paramString1 = this.j.r1(paramString1, paramInt1, paramInt2, paramString2, paramArrayOfInt).L0(io.reactivex.l0.a.c());
    kotlin.jvm.internal.j.d(paramString1, "mThingApi.retrieveCustom…scribeOn(Schedulers.io())");
    return paramString1;
  }
  
  private final q<PageListResult<com.google.gson.i>> e0(String paramString1, int paramInt1, int paramInt2, String paramString2, int[] paramArrayOfInt)
  {
    paramArrayOfInt = kotlin.collections.e.q(paramArrayOfInt, ",", null, null, 0, null, null, 62, null);
    paramString1 = this.j.e0(paramString1, paramInt1, paramInt2, paramString2, paramArrayOfInt).L0(io.reactivex.l0.a.c());
    kotlin.jvm.internal.j.d(paramString1, "mThingApi.retrievePredef…scribeOn(Schedulers.io())");
    return paramString1;
  }
  
  private final q<PageListResult<com.google.gson.i>> f0(String paramString1, int paramInt1, int paramInt2, String paramString2, int[] paramArrayOfInt)
  {
    paramArrayOfInt = kotlin.collections.e.q(paramArrayOfInt, ",", null, null, 0, null, null, 62, null);
    paramString1 = this.j.B1(paramString1, paramInt1, paramInt2, paramString2, paramArrayOfInt).L0(io.reactivex.l0.a.c());
    kotlin.jvm.internal.j.d(paramString1, "mThingApi.retrievePredef…scribeOn(Schedulers.io())");
    return paramString1;
  }
  
  private final List<CustomizedEffect> g0(List<? extends CustomizedEffect> paramList)
  {
    return kotlin.collections.l.O(paramList, new w());
  }
  
  private final List<PredefinedEffect> h0(List<? extends PredefinedEffect> paramList)
  {
    return kotlin.collections.l.O(paramList, new x());
  }
  
  private final CustomizedEffect i0(com.google.gson.i parami)
  {
    try
    {
      localObject = (CustomizedEffect)com.tplink.libtpnetwork.Utils.i.a(parami, CustomizedEffect.class);
      if (localObject != null) {
        parami = ((AbstractLightingEffect)localObject).getId();
      } else {
        parami = null;
      }
      if (parami != null)
      {
        i1 = parami.length();
        if (i1 != 0)
        {
          i1 = 0;
          break label50;
        }
      }
      int i1 = 1;
      label50:
      if (i1 == 0) {
        return (CustomizedEffect)localObject;
      }
    }
    catch (Exception parami)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Parse JsonElement to CustomizedEffect Error: ");
      ((StringBuilder)localObject).append(parami);
      b.d.w.c.a.e("LightingEffectRepository", ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  private final PredefinedEffect j0(com.google.gson.i parami)
  {
    try
    {
      PredefinedEffect localPredefinedEffect = (PredefinedEffect)com.tplink.libtpnetwork.Utils.i.a(parami, PredefinedEffect.class);
      if (localPredefinedEffect != null) {
        parami = localPredefinedEffect.getId();
      } else {
        parami = null;
      }
      if (parami != null)
      {
        i1 = parami.length();
        if (i1 != 0)
        {
          i1 = 0;
          break label50;
        }
      }
      int i1 = 1;
      label50:
      if (i1 == 0) {
        return localPredefinedEffect;
      }
    }
    catch (Exception localException)
    {
      parami = new StringBuilder();
      parami.append("Parse JsonElement to PredefinedEffect Error: ");
      parami.append(localException);
      b.d.w.c.a.e("LightingEffectRepository", parami.toString());
    }
    return null;
  }
  
  private final PredefinedEffectTemplate k0(com.google.gson.i parami)
  {
    try
    {
      PredefinedEffectTemplate localPredefinedEffectTemplate = (PredefinedEffectTemplate)com.tplink.libtpnetwork.Utils.i.a(parami, PredefinedEffectTemplate.class);
      if (localPredefinedEffectTemplate != null) {
        parami = localPredefinedEffectTemplate.getPredefinedEffectId();
      } else {
        parami = null;
      }
      if (parami != null)
      {
        i1 = parami.length();
        if (i1 != 0)
        {
          i1 = 0;
          break label50;
        }
      }
      int i1 = 1;
      label50:
      if (i1 == 0) {
        return localPredefinedEffectTemplate;
      }
    }
    catch (Exception localException)
    {
      parami = new StringBuilder();
      parami.append("Parse JsonElement to PredefinedEffectTemplate Error: ");
      parami.append(localException);
      b.d.w.c.a.e("LightingEffectRepository", parami.toString());
    }
    return null;
  }
  
  private final q<com.google.gson.i> m0(String paramString, ThingLightingEffectParams paramThingLightingEffectParams)
  {
    paramString = this.j.N1(paramString, paramThingLightingEffectParams).L0(io.reactivex.l0.a.c());
    kotlin.jvm.internal.j.d(paramString, "mThingApi.updateCustomiz…scribeOn(Schedulers.io())");
    return paramString;
  }
  
  public final q<CustomizedEffect> N(final CustomizedEffect paramCustomizedEffect)
  {
    kotlin.jvm.internal.j.e(paramCustomizedEffect, "effect");
    paramCustomizedEffect = new ThingLightingEffectParams(com.tplink.libtpnetwork.Utils.i.i(paramCustomizedEffect));
    paramCustomizedEffect = d().N(new b(this, paramCustomizedEffect)).g0(c.c).E(new d(this)).C(new e(this));
    kotlin.jvm.internal.j.d(paramCustomizedEffect, "checkAppServerUrl()\n    …ode(it)}\" }\n            }");
    return paramCustomizedEffect;
  }
  
  public final io.reactivex.a P(final String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "effectId");
    int i1;
    if (paramString.length() == 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      paramString = io.reactivex.a.m(new Throwable("The CustomizedEffect id is empty."));
      kotlin.jvm.internal.j.d(paramString, "Completable.error(Throwa…zedEffect id is empty.\"))");
      return paramString;
    }
    paramString = d().R(new f(this, paramString)).i(new g(this, paramString)).j(new h(this));
    kotlin.jvm.internal.j.d(paramString, "checkAppServerUrl()\n    …ode(it)}\" }\n            }");
    return paramString;
  }
  
  public final q<CustomizedEffect> U(final String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "effectId");
    int i1;
    if (paramString.length() == 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      paramString = q.I();
      kotlin.jvm.internal.j.d(paramString, "Observable.empty()");
      return paramString;
    }
    CustomizedEffect localCustomizedEffect = (CustomizedEffect)this.k.get(paramString);
    if (localCustomizedEffect != null)
    {
      paramString = q.f0(localCustomizedEffect);
      kotlin.jvm.internal.j.d(paramString, "Observable.just(effect)");
    }
    else
    {
      paramString = d().N(new l(this, paramString)).N(new m(this, paramString)).E(new n(this));
      kotlin.jvm.internal.j.d(paramString, "checkAppServerUrl()\n    …Time())\n                }");
    }
    return paramString;
  }
  
  public final CustomizedEffect V(String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "effectId");
    return (CustomizedEffect)this.k.get(paramString);
  }
  
  public final q<List<CustomizedEffect>> W()
  {
    q localq = R(new ThingListPageParams(0, 10)).g0(new o(this));
    kotlin.jvm.internal.j.d(localq, "getAllCustomizedEffectsB…dEffectList\n            }");
    return localq;
  }
  
  public final LiveData<List<CustomizedEffect>> X()
  {
    return this.m;
  }
  
  public final q<PredefinedEffect> Y(final String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "predefinedEffectId");
    int i1;
    if (paramString.length() == 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      paramString = q.I();
      kotlin.jvm.internal.j.d(paramString, "Observable.empty()");
      return paramString;
    }
    PredefinedEffect localPredefinedEffect = (PredefinedEffect)this.n.get(paramString);
    if (localPredefinedEffect != null)
    {
      paramString = q.f0(localPredefinedEffect);
      kotlin.jvm.internal.j.d(paramString, "Observable.just(effect)");
    }
    else
    {
      paramString = d().N(new p(this, paramString)).N(new q(this, paramString)).E(new r(this));
      kotlin.jvm.internal.j.d(paramString, "checkAppServerUrl()\n    …Name())\n                }");
    }
    return paramString;
  }
  
  public final PredefinedEffect Z(String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "predefinedEffectId");
    return (PredefinedEffect)this.n.get(paramString);
  }
  
  public final q<List<PredefinedEffect>> a0()
  {
    Object localObject = h0(new ArrayList(this.n.values()));
    if ((((Collection)localObject).isEmpty() ^ true))
    {
      this.o.postValue(localObject);
      localObject = q.f0(localObject);
      kotlin.jvm.internal.j.d(localObject, "Observable.just(predefinedEffects)");
      return (q<List<PredefinedEffect>>)localObject;
    }
    localObject = T(new ThingListPageParams(0, 10)).g0(new s(this));
    kotlin.jvm.internal.j.d(localObject, "getAllPredefinedEffectsB…dEffectList\n            }");
    return (q<List<PredefinedEffect>>)localObject;
  }
  
  public final LiveData<List<PredefinedEffect>> b0()
  {
    return this.p;
  }
  
  public final q<PredefinedEffectTemplate> c0(final String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "predefinedEffectId");
    PredefinedEffectTemplate localPredefinedEffectTemplate = (PredefinedEffectTemplate)this.q.get(paramString);
    if (localPredefinedEffectTemplate != null)
    {
      paramString = q.f0(localPredefinedEffectTemplate);
      kotlin.jvm.internal.j.d(paramString, "Observable.just(template)");
    }
    else
    {
      paramString = d().N(new t(this, paramString)).N(new u(this, paramString)).E(new v(this));
      kotlin.jvm.internal.j.d(paramString, "checkAppServerUrl()\n    …d] = it\n                }");
    }
    return paramString;
  }
  
  public final q<CustomizedEffect> l0(final CustomizedEffect paramCustomizedEffect)
  {
    kotlin.jvm.internal.j.e(paramCustomizedEffect, "effect");
    String str = paramCustomizedEffect.getId();
    int i1;
    if ((str != null) && (str.length() != 0)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if (i1 != 0)
    {
      paramCustomizedEffect = q.J(new Throwable("The CustomizedEffect id is null or empty."));
      kotlin.jvm.internal.j.d(paramCustomizedEffect, "Observable.error(Throwab…t id is null or empty.\"))");
      return paramCustomizedEffect;
    }
    paramCustomizedEffect = new ThingLightingEffectParams(com.tplink.libtpnetwork.Utils.i.i(paramCustomizedEffect));
    paramCustomizedEffect = d().N(new y(this, paramCustomizedEffect)).g0(z.c).E(new a0(this)).C(new b0(this));
    kotlin.jvm.internal.j.d(paramCustomizedEffect, "checkAppServerUrl()\n    …ode(it)}\" }\n            }");
    return paramCustomizedEffect;
  }
  
  public static final class a {}
  
  static final class a0<T>
    implements g<CustomizedEffect>
  {
    a0(LightingEffectRepository paramLightingEffectRepository) {}
    
    public final void a(CustomizedEffect paramCustomizedEffect)
    {
      kotlin.jvm.internal.j.d(paramCustomizedEffect, "customizedEffect");
      String str = paramCustomizedEffect.getId();
      int i;
      if ((str != null) && (str.length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0) {
        str = null;
      }
      if (str != null) {
        LightingEffectRepository.A(this.c).put(str, paramCustomizedEffect);
      }
      LightingEffectRepository.z(this.c).postValue(LightingEffectRepository.H(this.c, new ArrayList(LightingEffectRepository.A(this.c).values())));
    }
  }
  
  static final class b<T, R>
    implements io.reactivex.g0.j<String, t<? extends com.google.gson.i>>
  {
    b(LightingEffectRepository paramLightingEffectRepository, ThingLightingEffectParams paramThingLightingEffectParams) {}
    
    public final t<? extends com.google.gson.i> a(String paramString)
    {
      kotlin.jvm.internal.j.e(paramString, "it");
      return LightingEffectRepository.w(this.c, paramString, paramCustomizedEffect);
    }
  }
  
  static final class b0<T>
    implements g<Throwable>
  {
    b0(LightingEffectRepository paramLightingEffectRepository) {}
    
    public final void a(Throwable paramThrowable) {}
  }
  
  static final class c<T, R>
    implements io.reactivex.g0.j<com.google.gson.i, CustomizedEffect>
  {
    public static final c c = new c();
    
    public final CustomizedEffect a(com.google.gson.i parami)
    {
      kotlin.jvm.internal.j.e(parami, "it");
      return (CustomizedEffect)com.tplink.libtpnetwork.Utils.i.a(parami, CustomizedEffect.class);
    }
  }
  
  static final class d<T>
    implements g<CustomizedEffect>
  {
    d(LightingEffectRepository paramLightingEffectRepository) {}
    
    public final void a(CustomizedEffect paramCustomizedEffect)
    {
      kotlin.jvm.internal.j.d(paramCustomizedEffect, "customizedEffect");
      String str = paramCustomizedEffect.getId();
      int i;
      if ((str != null) && (str.length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0) {
        str = null;
      }
      if (str != null) {
        LightingEffectRepository.A(this.c).put(str, paramCustomizedEffect);
      }
      LightingEffectRepository.z(this.c).postValue(LightingEffectRepository.H(this.c, new ArrayList(LightingEffectRepository.A(this.c).values())));
    }
  }
  
  static final class e<T>
    implements g<Throwable>
  {
    e(LightingEffectRepository paramLightingEffectRepository) {}
    
    public final void a(Throwable paramThrowable) {}
  }
  
  static final class f<T, R>
    implements io.reactivex.g0.j<String, io.reactivex.e>
  {
    f(LightingEffectRepository paramLightingEffectRepository, String paramString) {}
    
    public final io.reactivex.e a(String paramString)
    {
      kotlin.jvm.internal.j.e(paramString, "it");
      return LightingEffectRepository.x(this.c, paramString, paramString);
    }
  }
  
  static final class g
    implements io.reactivex.g0.a
  {
    g(LightingEffectRepository paramLightingEffectRepository, String paramString) {}
    
    public final void run()
    {
      LightingEffectRepository.A(this.a).remove(paramString);
      LightingEffectRepository.z(this.a).postValue(LightingEffectRepository.H(this.a, new ArrayList(LightingEffectRepository.A(this.a).values())));
    }
  }
  
  static final class h<T>
    implements g<Throwable>
  {
    h(LightingEffectRepository paramLightingEffectRepository) {}
    
    public final void a(Throwable paramThrowable) {}
  }
  
  static final class i
    extends Lambda
    implements p<String, ThingListPageParams, q<PageListResult<com.google.gson.i>>>
  {
    i(LightingEffectRepository paramLightingEffectRepository)
    {
      super();
    }
    
    public final q<PageListResult<com.google.gson.i>> a(final String paramString, ThingListPageParams paramThingListPageParams)
    {
      kotlin.jvm.internal.j.e(paramString, "url");
      kotlin.jvm.internal.j.e(paramThingListPageParams, "pageParams");
      paramString = q.f0(paramThingListPageParams).N(new a(this, paramString));
      kotlin.jvm.internal.j.d(paramString, "Observable.just(pagePara…rsions)\n                }");
      return paramString;
    }
    
    static final class a<T, R>
      implements io.reactivex.g0.j<ThingListPageParams, t<? extends PageListResult<com.google.gson.i>>>
    {
      a(LightingEffectRepository.i parami, String paramString) {}
      
      public final t<? extends PageListResult<com.google.gson.i>> a(ThingListPageParams paramThingListPageParams)
      {
        kotlin.jvm.internal.j.e(paramThingListPageParams, "it");
        return LightingEffectRepository.E(this.c.c, paramString, paramThingListPageParams.getPage(), paramThingListPageParams.getPageSize(), null, LightingEffectRepository.y());
      }
    }
  }
  
  static final class j<T, R>
    implements io.reactivex.g0.j<String, t<? extends List<? extends com.google.gson.i>>>
  {
    j(p paramp, ThingListPageParams paramThingListPageParams, List paramList) {}
    
    public final t<? extends List<com.google.gson.i>> a(String paramString)
    {
      kotlin.jvm.internal.j.e(paramString, "it");
      return ((q)this.c.invoke(paramString, paramThingListPageParams)).g0(new a(this)).w0(b.c);
    }
    
    static final class a<T, R>
      implements io.reactivex.g0.j<PageListResult<com.google.gson.i>, List<? extends com.google.gson.i>>
    {
      a(LightingEffectRepository.j paramj) {}
      
      public final List<com.google.gson.i> a(PageListResult<com.google.gson.i> paramPageListResult)
      {
        kotlin.jvm.internal.j.e(paramPageListResult, "pageResult");
        if (paramPageListResult.getTotal() == 0L) {
          return kotlin.collections.l.d();
        }
        List localList1 = paramPageListResult.getData();
        int i;
        if ((localList1 != null) && (!localList1.isEmpty())) {
          i = 0;
        } else {
          i = 1;
        }
        if (i == 0)
        {
          List localList2 = this.c.f;
          localList1 = paramPageListResult.getData();
          kotlin.jvm.internal.j.d(localList1, "pageResult.data");
          localList2.addAll(localList1);
        }
        if (this.c.f.size() >= paramPageListResult.getTotal()) {
          return this.c.f;
        }
        paramPageListResult = this.c.d;
        paramPageListResult.setPage(paramPageListResult.getPage() + 1);
        throw new CloudException(-2, "retry_get_data");
      }
    }
    
    static final class b<T>
      implements io.reactivex.g0.l<Throwable>
    {
      public static final b c = new b();
      
      public final boolean a(Throwable paramThrowable)
      {
        kotlin.jvm.internal.j.e(paramThrowable, "t");
        if ((paramThrowable instanceof CloudException))
        {
          paramThrowable = (CloudException)paramThrowable;
          if ((kotlin.jvm.internal.j.a(paramThrowable.getMsg(), "retry_get_data")) && (paramThrowable.getErrCode() == -2)) {
            return true;
          }
        }
        boolean bool = false;
        return bool;
      }
    }
  }
  
  static final class k
    extends Lambda
    implements p<String, ThingListPageParams, q<PageListResult<com.google.gson.i>>>
  {
    k(LightingEffectRepository paramLightingEffectRepository)
    {
      super();
    }
    
    public final q<PageListResult<com.google.gson.i>> a(final String paramString, ThingListPageParams paramThingListPageParams)
    {
      kotlin.jvm.internal.j.e(paramString, "url");
      kotlin.jvm.internal.j.e(paramThingListPageParams, "pageParams");
      paramString = q.f0(paramThingListPageParams).N(new a(this, paramString));
      kotlin.jvm.internal.j.d(paramString, "Observable.just(pagePara…rsions)\n                }");
      return paramString;
    }
    
    static final class a<T, R>
      implements io.reactivex.g0.j<ThingListPageParams, t<? extends PageListResult<com.google.gson.i>>>
    {
      a(LightingEffectRepository.k paramk, String paramString) {}
      
      public final t<? extends PageListResult<com.google.gson.i>> a(ThingListPageParams paramThingListPageParams)
      {
        kotlin.jvm.internal.j.e(paramThingListPageParams, "it");
        return LightingEffectRepository.G(this.c.c, paramString, paramThingListPageParams.getPage(), paramThingListPageParams.getPageSize(), null, LightingEffectRepository.y());
      }
    }
  }
  
  static final class l<T, R>
    implements io.reactivex.g0.j<String, t<? extends PageListResult<com.google.gson.i>>>
  {
    l(LightingEffectRepository paramLightingEffectRepository, String paramString) {}
    
    public final t<? extends PageListResult<com.google.gson.i>> a(String paramString)
    {
      kotlin.jvm.internal.j.e(paramString, "it");
      return LightingEffectRepository.E(this.c, paramString, 0, 10, paramString, LightingEffectRepository.y());
    }
  }
  
  static final class m<T, R>
    implements io.reactivex.g0.j<PageListResult<com.google.gson.i>, t<? extends CustomizedEffect>>
  {
    m(LightingEffectRepository paramLightingEffectRepository, String paramString) {}
    
    public final t<? extends CustomizedEffect> a(PageListResult<com.google.gson.i> paramPageListResult)
    {
      kotlin.jvm.internal.j.e(paramPageListResult, "pageResult");
      paramPageListResult = paramPageListResult.getData();
      int i;
      if ((paramPageListResult != null) && (!paramPageListResult.isEmpty())) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0) {
        return q.J(new Throwable("Null CustomizedEffect"));
      }
      paramPageListResult = paramPageListResult.iterator();
      while (paramPageListResult.hasNext())
      {
        Object localObject = (com.google.gson.i)paramPageListResult.next();
        LightingEffectRepository localLightingEffectRepository = this.c;
        kotlin.jvm.internal.j.d(localObject, "e");
        localObject = LightingEffectRepository.J(localLightingEffectRepository, (com.google.gson.i)localObject);
        if ((localObject != null) && (kotlin.jvm.internal.j.a(((AbstractLightingEffect)localObject).getId(), paramString))) {
          return q.f0(localObject);
        }
      }
      return q.J(new Throwable("Null CustomizedEffect"));
    }
  }
  
  static final class n<T>
    implements g<CustomizedEffect>
  {
    n(LightingEffectRepository paramLightingEffectRepository) {}
    
    public final void a(CustomizedEffect paramCustomizedEffect)
    {
      Map localMap = LightingEffectRepository.A(this.c);
      kotlin.jvm.internal.j.d(paramCustomizedEffect, "it");
      String str = paramCustomizedEffect.getId();
      kotlin.jvm.internal.j.d(str, "it.id");
      localMap.put(str, paramCustomizedEffect);
      LightingEffectRepository.z(this.c).postValue(LightingEffectRepository.H(this.c, new ArrayList(LightingEffectRepository.A(this.c).values())));
    }
  }
  
  static final class o<T, R>
    implements io.reactivex.g0.j<List<? extends com.google.gson.i>, List<? extends CustomizedEffect>>
  {
    o(LightingEffectRepository paramLightingEffectRepository) {}
    
    public final List<CustomizedEffect> a(List<? extends com.google.gson.i> paramList)
    {
      kotlin.jvm.internal.j.e(paramList, "effects");
      if (paramList.isEmpty())
      {
        LightingEffectRepository.z(this.c).postValue(kotlin.collections.l.d());
        return kotlin.collections.l.d();
      }
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject1 = (com.google.gson.i)paramList.next();
        localObject1 = LightingEffectRepository.J(this.c, (com.google.gson.i)localObject1);
        if (localObject1 != null) {
          localArrayList.add(localObject1);
        }
      }
      LightingEffectRepository.A(this.c).clear();
      Object localObject1 = LightingEffectRepository.A(this.c);
      paramList = localArrayList.iterator();
      while (paramList.hasNext())
      {
        Object localObject2 = paramList.next();
        ((Map)localObject1).put(((CustomizedEffect)localObject2).getId(), localObject2);
      }
      LightingEffectRepository.z(this.c).postValue(LightingEffectRepository.H(this.c, new ArrayList(LightingEffectRepository.A(this.c).values())));
      return localArrayList;
    }
  }
  
  static final class p<T, R>
    implements io.reactivex.g0.j<String, t<? extends PageListResult<com.google.gson.i>>>
  {
    p(LightingEffectRepository paramLightingEffectRepository, String paramString) {}
    
    public final t<? extends PageListResult<com.google.gson.i>> a(String paramString)
    {
      kotlin.jvm.internal.j.e(paramString, "it");
      return LightingEffectRepository.G(this.c, paramString, 0, 10, paramString, LightingEffectRepository.y());
    }
  }
  
  static final class q<T, R>
    implements io.reactivex.g0.j<PageListResult<com.google.gson.i>, t<? extends PredefinedEffect>>
  {
    q(LightingEffectRepository paramLightingEffectRepository, String paramString) {}
    
    public final t<? extends PredefinedEffect> a(PageListResult<com.google.gson.i> paramPageListResult)
    {
      kotlin.jvm.internal.j.e(paramPageListResult, "pageResult");
      paramPageListResult = paramPageListResult.getData();
      int i;
      if ((paramPageListResult != null) && (!paramPageListResult.isEmpty())) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0) {
        return q.J(new Throwable("Null PredefinedEffect"));
      }
      paramPageListResult = paramPageListResult.iterator();
      while (paramPageListResult.hasNext())
      {
        Object localObject = (com.google.gson.i)paramPageListResult.next();
        LightingEffectRepository localLightingEffectRepository = this.c;
        kotlin.jvm.internal.j.d(localObject, "e");
        localObject = LightingEffectRepository.K(localLightingEffectRepository, (com.google.gson.i)localObject);
        if ((localObject != null) && (kotlin.jvm.internal.j.a(((AbstractLightingEffect)localObject).getId(), paramString))) {
          return q.f0(localObject);
        }
      }
      return q.J(new Throwable("Null PredefinedEffect"));
    }
  }
  
  static final class r<T>
    implements g<PredefinedEffect>
  {
    r(LightingEffectRepository paramLightingEffectRepository) {}
    
    public final void a(PredefinedEffect paramPredefinedEffect)
    {
      Map localMap = LightingEffectRepository.C(this.c);
      kotlin.jvm.internal.j.d(paramPredefinedEffect, "it");
      String str = paramPredefinedEffect.getId();
      kotlin.jvm.internal.j.d(str, "it.id");
      localMap.put(str, paramPredefinedEffect);
      LightingEffectRepository.B(this.c).postValue(LightingEffectRepository.I(this.c, new ArrayList(LightingEffectRepository.C(this.c).values())));
    }
  }
  
  static final class s<T, R>
    implements io.reactivex.g0.j<List<? extends com.google.gson.i>, List<? extends PredefinedEffect>>
  {
    s(LightingEffectRepository paramLightingEffectRepository) {}
    
    public final List<PredefinedEffect> a(List<? extends com.google.gson.i> paramList)
    {
      kotlin.jvm.internal.j.e(paramList, "effects");
      if (paramList.isEmpty())
      {
        LightingEffectRepository.B(this.c).postValue(kotlin.collections.l.d());
        return kotlin.collections.l.d();
      }
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject1 = (com.google.gson.i)paramList.next();
        localObject1 = LightingEffectRepository.K(this.c, (com.google.gson.i)localObject1);
        if (localObject1 != null) {
          localArrayList.add(localObject1);
        }
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getAllPredefinedEffectsByPage peList: ");
      Object localObject1 = new ArrayList(kotlin.collections.l.l(localArrayList, 10));
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        paramList = ((PredefinedEffect)localIterator.next()).getMeta();
        kotlin.jvm.internal.j.d(paramList, "it.meta");
        ((Collection)localObject1).add(paramList.getAlias());
      }
      ((StringBuilder)localObject2).append(localObject1);
      b.d.w.c.a.n("LightStrip", ((StringBuilder)localObject2).toString());
      LightingEffectRepository.C(this.c).clear();
      localObject2 = LightingEffectRepository.C(this.c);
      paramList = localArrayList.iterator();
      while (paramList.hasNext())
      {
        localObject1 = paramList.next();
        ((Map)localObject2).put(((PredefinedEffect)localObject1).getId(), localObject1);
      }
      LightingEffectRepository.B(this.c).postValue(LightingEffectRepository.I(this.c, new ArrayList(LightingEffectRepository.C(this.c).values())));
      return localArrayList;
    }
  }
  
  static final class t<T, R>
    implements io.reactivex.g0.j<String, t<? extends PageListResult<com.google.gson.i>>>
  {
    t(LightingEffectRepository paramLightingEffectRepository, String paramString) {}
    
    public final t<? extends PageListResult<com.google.gson.i>> a(String paramString)
    {
      kotlin.jvm.internal.j.e(paramString, "it");
      return LightingEffectRepository.F(this.c, paramString, 0, 10, paramString, LightingEffectRepository.y());
    }
  }
  
  static final class u<T, R>
    implements io.reactivex.g0.j<PageListResult<com.google.gson.i>, t<? extends PredefinedEffectTemplate>>
  {
    u(LightingEffectRepository paramLightingEffectRepository, String paramString) {}
    
    public final t<? extends PredefinedEffectTemplate> a(PageListResult<com.google.gson.i> paramPageListResult)
    {
      kotlin.jvm.internal.j.e(paramPageListResult, "pageResult");
      paramPageListResult = paramPageListResult.getData();
      int i;
      if ((paramPageListResult != null) && (!paramPageListResult.isEmpty())) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0) {
        return q.J(new Throwable("Null PredefinedEffectTemplate"));
      }
      paramPageListResult = paramPageListResult.iterator();
      while (paramPageListResult.hasNext())
      {
        Object localObject = (com.google.gson.i)paramPageListResult.next();
        LightingEffectRepository localLightingEffectRepository = this.c;
        kotlin.jvm.internal.j.d(localObject, "t");
        localObject = LightingEffectRepository.L(localLightingEffectRepository, (com.google.gson.i)localObject);
        if ((localObject != null) && (kotlin.jvm.internal.j.a(((PredefinedEffectTemplate)localObject).getPredefinedEffectId(), paramString))) {
          return q.f0(localObject);
        }
      }
      return q.J(new Throwable("Null PredefinedEffectTemplate"));
    }
  }
  
  static final class v<T>
    implements g<PredefinedEffectTemplate>
  {
    v(LightingEffectRepository paramLightingEffectRepository) {}
    
    public final void a(PredefinedEffectTemplate paramPredefinedEffectTemplate)
    {
      Map localMap = LightingEffectRepository.D(this.c);
      kotlin.jvm.internal.j.d(paramPredefinedEffectTemplate, "it");
      String str = paramPredefinedEffectTemplate.getPredefinedEffectId();
      kotlin.jvm.internal.j.d(str, "it.predefinedEffectId");
      localMap.put(str, paramPredefinedEffectTemplate);
    }
  }
  
  public static final class w<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      return kotlin.q.a.a(((CustomizedEffect)paramT1).getCreatedOn(), ((CustomizedEffect)paramT2).getCreatedOn());
    }
  }
  
  public static final class x<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      paramT1 = ((PredefinedEffect)paramT1).getMeta();
      Object localObject = null;
      if (paramT1 != null) {
        paramT1 = paramT1.getAlias();
      } else {
        paramT1 = null;
      }
      LightingEffectMeta localLightingEffectMeta = ((PredefinedEffect)paramT2).getMeta();
      paramT2 = (T)localObject;
      if (localLightingEffectMeta != null) {
        paramT2 = localLightingEffectMeta.getAlias();
      }
      return kotlin.q.a.a(paramT1, paramT2);
    }
  }
  
  static final class y<T, R>
    implements io.reactivex.g0.j<String, t<? extends com.google.gson.i>>
  {
    y(LightingEffectRepository paramLightingEffectRepository, ThingLightingEffectParams paramThingLightingEffectParams) {}
    
    public final t<? extends com.google.gson.i> a(String paramString)
    {
      kotlin.jvm.internal.j.e(paramString, "it");
      return LightingEffectRepository.M(this.c, paramString, paramCustomizedEffect);
    }
  }
  
  static final class z<T, R>
    implements io.reactivex.g0.j<com.google.gson.i, CustomizedEffect>
  {
    public static final z c = new z();
    
    public final CustomizedEffect a(com.google.gson.i parami)
    {
      kotlin.jvm.internal.j.e(parami, "it");
      return (CustomizedEffect)com.tplink.libtpnetwork.Utils.i.a(parami, CustomizedEffect.class);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TPCloudNetwork\repository\LightingEffectRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */