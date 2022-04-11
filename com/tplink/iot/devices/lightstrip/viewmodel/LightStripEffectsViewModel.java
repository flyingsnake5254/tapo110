package com.tplink.iot.devices.lightstrip.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import b.d.b.f.b;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.PredefinedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import com.tplink.libtpnetwork.IoTNetwork.repository.LightStripRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.LightingEffectRepository;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import io.reactivex.f;
import io.reactivex.g0.g;
import io.reactivex.q;

public final class LightStripEffectsViewModel
  extends AndroidViewModel
{
  private final kotlin.t.c b;
  private final kotlin.t.c c;
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> d;
  private final LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> e;
  private final boolean f;
  
  public LightStripEffectsViewModel(Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    this.b = new b(paramThingContext);
    this.c = new a(paramThingContext);
    paramApplication = new MutableLiveData();
    this.d = paramApplication;
    this.e = paramApplication;
    this.f = com.tplink.iot.Utils.w0.a.f(paramThingContext, EnumIoTComponent.SEGMENT);
  }
  
  private final f g()
  {
    return new c(this);
  }
  
  private final LightStripRepository j()
  {
    return (LightStripRepository)this.b.b(this, a[0]);
  }
  
  private final LightingEffectRepository k()
  {
    return (LightingEffectRepository)this.c.b(this, a[1]);
  }
  
  public final LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> h()
  {
    return this.e;
  }
  
  public final q<CustomizedEffect> i(String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "effectId");
    return k().U(paramString);
  }
  
  public final q<PredefinedEffect> l(String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "predefinedEffectId");
    return k().Y(paramString);
  }
  
  public final PredefinedEffect m(String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "predefinedEffectId");
    return k().Z(paramString);
  }
  
  public final boolean n()
  {
    return this.f;
  }
  
  public final void o(LightStateBean paramLightStateBean)
  {
    kotlin.jvm.internal.j.e(paramLightStateBean, "lightState");
    j().G5(paramLightStateBean).f(g()).y();
  }
  
  public final io.reactivex.a p(LightingEffectData paramLightingEffectData)
  {
    kotlin.jvm.internal.j.e(paramLightingEffectData, "effectData");
    paramLightingEffectData = j().I5(paramLightingEffectData).f(g());
    kotlin.jvm.internal.j.d(paramLightingEffectData, "mLightStripRepository.se…EffectEventTransformer())");
    return paramLightingEffectData;
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
    c(LightStripEffectsViewModel paramLightStripEffectsViewModel) {}
    
    public final io.reactivex.e a(io.reactivex.a parama)
    {
      kotlin.jvm.internal.j.e(parama, "source");
      return parama.l(new a(this)).i(new b(this)).j(new c(this));
    }
    
    static final class a<T>
      implements g<io.reactivex.e0.c>
    {
      a(LightStripEffectsViewModel.c paramc) {}
      
      public final void a(io.reactivex.e0.c paramc)
      {
        LightStripEffectsViewModel.f(this.c.a).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(100)));
      }
    }
    
    static final class b
      implements io.reactivex.g0.a
    {
      b(LightStripEffectsViewModel.c paramc) {}
      
      public final void run()
      {
        LightStripEffectsViewModel.f(this.a.a).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(200)));
      }
    }
    
    static final class c<T>
      implements g<Throwable>
    {
      c(LightStripEffectsViewModel.c paramc) {}
      
      public final void a(Throwable paramThrowable)
      {
        LightStripEffectsViewModel.f(this.c.a).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(300)));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\viewmodel\LightStripEffectsViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */