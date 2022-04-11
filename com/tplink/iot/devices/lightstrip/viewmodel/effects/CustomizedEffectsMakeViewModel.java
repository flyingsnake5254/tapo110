package com.tplink.iot.devices.lightstrip.viewmodel.effects;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import b.d.b.f.b;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.PredefinedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.PredefinedEffectTemplate;
import com.tplink.libtpnetwork.IoTNetwork.repository.LightStripRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.LightingEffectRepository;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import io.reactivex.f;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.l;

public final class CustomizedEffectsMakeViewModel
  extends AndroidViewModel
{
  private final kotlin.t.c b;
  private final kotlin.t.c c;
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> d;
  private final LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> e;
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> f;
  private final LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> g;
  private final MutableLiveData<String> h;
  private final LiveData<String> i;
  private String j;
  private final ThingContext k;
  
  public CustomizedEffectsMakeViewModel(Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    this.k = paramThingContext;
    this.b = new b(paramThingContext);
    this.c = new a(paramThingContext);
    paramApplication = new MutableLiveData();
    this.d = paramApplication;
    this.e = paramApplication;
    paramApplication = new MutableLiveData();
    this.f = paramApplication;
    this.g = paramApplication;
    paramApplication = new MutableLiveData();
    this.h = paramApplication;
    this.i = paramApplication;
    this.j = "";
  }
  
  private final f k()
  {
    return new c(this);
  }
  
  private final LightingEffectRepository p()
  {
    return (LightingEffectRepository)this.c.b(this, a[1]);
  }
  
  public final q<CustomizedEffect> h(CustomizedEffect paramCustomizedEffect)
  {
    kotlin.jvm.internal.j.e(paramCustomizedEffect, "effect");
    return p().N(paramCustomizedEffect);
  }
  
  public final void i(String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "effectId");
    p().P(paramString).f(k()).y();
  }
  
  public final q<CustomizedEffect> j(String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "effectId");
    return p().U(paramString);
  }
  
  public final LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> l()
  {
    return this.g;
  }
  
  public final String m()
  {
    return this.j;
  }
  
  public final LiveData<String> n()
  {
    return this.i;
  }
  
  public final LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> o()
  {
    return this.e;
  }
  
  public final q<PredefinedEffect> r(String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "predefinedEffectId");
    return p().Y(paramString);
  }
  
  public final LiveData<List<PredefinedEffect>> s()
  {
    return p().b0();
  }
  
  public final q<PredefinedEffectTemplate> t(String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "predefinedEffectId");
    return p().c0(paramString);
  }
  
  public final boolean u()
  {
    boolean bool;
    if (com.tplink.iot.Utils.w0.a.a(this.k.getDeviceIdMD5(), EnumIoTComponent.LIGHT_STRIP_LIGHTING_EFFECT) >= 2) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final void v()
  {
    p().a0().F(new d(this)).z(new e(this)).C(new f(this)).F0();
  }
  
  public final int w(String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "predefinedEffectId");
    Object localObject = (List)p().X().getValue();
    int m = 0;
    int n = 0;
    int i1 = m;
    if (localObject != null) {
      if (((Collection)localObject).isEmpty())
      {
        i1 = m;
      }
      else
      {
        localObject = ((Iterable)localObject).iterator();
        for (;;)
        {
          i1 = n;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          if (kotlin.jvm.internal.j.a(((CustomizedEffect)((Iterator)localObject).next()).getPredefinedEffectId(), paramString))
          {
            i1 = n + 1;
            n = i1;
            if (i1 < 0)
            {
              l.j();
              n = i1;
            }
          }
        }
      }
    }
    return i1 + 1;
  }
  
  public final void x(String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "value");
    this.j = paramString;
    this.h.setValue(paramString);
  }
  
  public final q<CustomizedEffect> y(CustomizedEffect paramCustomizedEffect)
  {
    kotlin.jvm.internal.j.e(paramCustomizedEffect, "effect");
    return p().l0(paramCustomizedEffect);
  }
  
  public static final class a
    implements kotlin.t.c<Object, LightingEffectRepository>
  {
    private final LightingEffectRepository a;
    
    public a(ThingContext paramThingContext)
    {
      paramThingContext = b.a(paramThingContext.getAccountContext(), LightingEffectRepository.class);
      kotlin.jvm.internal.j.d(paramThingContext, "CloudRepositoryProviders…ontext, REPO::class.java)");
      this.a = paramThingContext;
    }
    
    public LightingEffectRepository c(Object paramObject, kotlin.reflect.j<?> paramj)
    {
      kotlin.jvm.internal.j.e(paramObject, "thisRef");
      kotlin.jvm.internal.j.e(paramj, "property");
      return this.a;
    }
  }
  
  public static final class b
    implements kotlin.t.c<Object, LightStripRepository>
  {
    private final LightStripRepository a;
    
    public b(ThingContext paramThingContext)
    {
      paramThingContext = com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(paramThingContext, LightStripRepository.class);
      kotlin.jvm.internal.j.d(paramThingContext, "IoTDeviceRepositoryProvi…sitory, REPO::class.java)");
      this.a = paramThingContext;
    }
    
    public LightStripRepository c(Object paramObject, kotlin.reflect.j<?> paramj)
    {
      kotlin.jvm.internal.j.e(paramObject, "thisRef");
      kotlin.jvm.internal.j.e(paramj, "property");
      return this.a;
    }
  }
  
  static final class c
    implements f
  {
    c(CustomizedEffectsMakeViewModel paramCustomizedEffectsMakeViewModel) {}
    
    public final io.reactivex.e a(io.reactivex.a parama)
    {
      kotlin.jvm.internal.j.e(parama, "source");
      return parama.l(new a(this)).i(new b(this)).j(new c(this));
    }
    
    static final class a<T>
      implements g<io.reactivex.e0.c>
    {
      a(CustomizedEffectsMakeViewModel.c paramc) {}
      
      public final void a(io.reactivex.e0.c paramc)
      {
        CustomizedEffectsMakeViewModel.f(this.c.a).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(100)));
      }
    }
    
    static final class b
      implements io.reactivex.g0.a
    {
      b(CustomizedEffectsMakeViewModel.c paramc) {}
      
      public final void run()
      {
        CustomizedEffectsMakeViewModel.f(this.a.a).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(200)));
      }
    }
    
    static final class c<T>
      implements g<Throwable>
    {
      c(CustomizedEffectsMakeViewModel.c paramc) {}
      
      public final void a(Throwable paramThrowable)
      {
        CustomizedEffectsMakeViewModel.f(this.c.a).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(300)));
      }
    }
  }
  
  static final class d<T>
    implements g<io.reactivex.e0.c>
  {
    d(CustomizedEffectsMakeViewModel paramCustomizedEffectsMakeViewModel) {}
    
    public final void a(io.reactivex.e0.c paramc)
    {
      CustomizedEffectsMakeViewModel.g(this.c).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(100)));
    }
  }
  
  static final class e
    implements io.reactivex.g0.a
  {
    e(CustomizedEffectsMakeViewModel paramCustomizedEffectsMakeViewModel) {}
    
    public final void run()
    {
      CustomizedEffectsMakeViewModel.g(this.a).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(200)));
    }
  }
  
  static final class f<T>
    implements g<Throwable>
  {
    f(CustomizedEffectsMakeViewModel paramCustomizedEffectsMakeViewModel) {}
    
    public final void a(Throwable paramThrowable)
    {
      CustomizedEffectsMakeViewModel.g(this.c).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(300)));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\viewmodel\effects\CustomizedEffectsMakeViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */