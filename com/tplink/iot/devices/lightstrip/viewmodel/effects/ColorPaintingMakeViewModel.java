package com.tplink.iot.devices.lightstrip.viewmodel.effects;

import android.app.Application;
import androidx.annotation.ColorInt;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import b.d.b.f.b;
import com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizedEffect;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.LightStripRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.LightingEffectRepository;
import com.tplink.libtpnetwork.Utils.y;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import io.reactivex.f;
import io.reactivex.g0.g;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.u;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.l;

public final class ColorPaintingMakeViewModel
  extends AndroidViewModel
{
  private final kotlin.t.c b;
  private final kotlin.t.c c;
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> d;
  private final LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> e;
  private final boolean f;
  private final MutableLiveData<String> g;
  private final LiveData<String> h;
  private String i;
  @ColorInt
  private int j;
  private final ObservableInt k;
  
  public ColorPaintingMakeViewModel(Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    this.b = new b(paramThingContext);
    this.c = new a(paramThingContext);
    paramApplication = new MutableLiveData();
    this.d = paramApplication;
    this.e = paramApplication;
    paramApplication = (ALIoTDevice)paramThingContext.getIoTDevice();
    boolean bool;
    if (paramApplication != null) {
      bool = paramApplication.isSupportIoTComponent(EnumIoTComponent.SEGMENT);
    } else {
      bool = false;
    }
    this.f = bool;
    paramApplication = new MutableLiveData();
    this.g = paramApplication;
    this.h = paramApplication;
    this.i = "";
    this.j = -1;
    this.k = new ObservableInt(this.j);
  }
  
  private final <T> u<T, T> i()
  {
    return new c(this);
  }
  
  private final f l()
  {
    return new d(this);
  }
  
  private final LightingEffectRepository p()
  {
    return (LightingEffectRepository)this.c.b(this, a[1]);
  }
  
  public final void g(CustomizedEffect paramCustomizedEffect)
  {
    kotlin.jvm.internal.j.e(paramCustomizedEffect, "effect");
    p().N(paramCustomizedEffect).i(i()).F0();
  }
  
  public final void h(String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "effectId");
    p().P(paramString).f(l()).y();
  }
  
  public final LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> j()
  {
    return this.e;
  }
  
  public final q<CustomizedEffect> k(String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "effectId");
    return p().U(paramString);
  }
  
  public final String m()
  {
    return this.i;
  }
  
  public final LiveData<String> n()
  {
    return this.h;
  }
  
  public final q<Integer> o()
  {
    q localq = q.f0(Integer.valueOf(50));
    kotlin.jvm.internal.j.d(localq, "Observable.just(LightStripUtils.DEFAULT_SEGMENTS)");
    return localq;
  }
  
  public final int r()
  {
    return this.j;
  }
  
  public final ObservableInt s()
  {
    return this.k;
  }
  
  public final int t()
  {
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
          if (d.q((CustomizedEffect)((Iterator)localObject).next()))
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
  
  public final void u(String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "value");
    this.i = paramString;
    this.g.setValue(paramString);
  }
  
  public final void v(int paramInt)
  {
    this.j = paramInt;
    this.k.set(paramInt);
  }
  
  public final CustomizedEffect w(String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "effectId");
    return p().V(paramString);
  }
  
  public final void x(CustomizedEffect paramCustomizedEffect)
  {
    kotlin.jvm.internal.j.e(paramCustomizedEffect, "effect");
    p().l0(paramCustomizedEffect).i(i()).F0();
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
  
  static final class c<Upstream, Downstream>
    implements u<T, T>
  {
    c(ColorPaintingMakeViewModel paramColorPaintingMakeViewModel) {}
    
    public final t<T> a(q<T> paramq)
    {
      kotlin.jvm.internal.j.e(paramq, "source");
      return paramq.F(new a(this)).z(new b(this)).C(new c(this));
    }
    
    static final class a<T>
      implements g<io.reactivex.e0.c>
    {
      a(ColorPaintingMakeViewModel.c paramc) {}
      
      public final void a(io.reactivex.e0.c paramc)
      {
        ColorPaintingMakeViewModel.f(this.c.a).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(100)));
      }
    }
    
    static final class b
      implements io.reactivex.g0.a
    {
      b(ColorPaintingMakeViewModel.c paramc) {}
      
      public final void run()
      {
        ColorPaintingMakeViewModel.f(this.a.a).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(200)));
      }
    }
    
    static final class c<T>
      implements g<Throwable>
    {
      c(ColorPaintingMakeViewModel.c paramc) {}
      
      public final void a(Throwable paramThrowable)
      {
        int i = y.a(paramThrowable);
        if (i != 15019)
        {
          if (i != 15020) {
            ColorPaintingMakeViewModel.f(this.c.a).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(300)));
          } else {
            ColorPaintingMakeViewModel.f(this.c.a).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(500)));
          }
        }
        else {
          ColorPaintingMakeViewModel.f(this.c.a).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(400)));
        }
      }
    }
  }
  
  static final class d
    implements f
  {
    d(ColorPaintingMakeViewModel paramColorPaintingMakeViewModel) {}
    
    public final io.reactivex.e a(io.reactivex.a parama)
    {
      kotlin.jvm.internal.j.e(parama, "source");
      return parama.l(new a(this)).i(new b(this)).j(new c(this));
    }
    
    static final class a<T>
      implements g<io.reactivex.e0.c>
    {
      a(ColorPaintingMakeViewModel.d paramd) {}
      
      public final void a(io.reactivex.e0.c paramc)
      {
        ColorPaintingMakeViewModel.f(this.c.a).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(100)));
      }
    }
    
    static final class b
      implements io.reactivex.g0.a
    {
      b(ColorPaintingMakeViewModel.d paramd) {}
      
      public final void run()
      {
        ColorPaintingMakeViewModel.f(this.a.a).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(200)));
      }
    }
    
    static final class c<T>
      implements g<Throwable>
    {
      c(ColorPaintingMakeViewModel.d paramd) {}
      
      public final void a(Throwable paramThrowable)
      {
        ColorPaintingMakeViewModel.f(this.c.a).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(300)));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\viewmodel\effects\ColorPaintingMakeViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */