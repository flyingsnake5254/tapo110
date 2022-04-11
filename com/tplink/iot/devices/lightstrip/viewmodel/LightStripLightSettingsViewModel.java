package com.tplink.iot.devices.lightstrip.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import b.d.b.f.b;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.IoTLightStripDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.PredefinedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.LightStripRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.LightingEffectRepository;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import io.reactivex.a;
import io.reactivex.q;
import kotlin.t.c;

public final class LightStripLightSettingsViewModel
  extends AndroidViewModel
{
  private final c b;
  private final c c;
  private final BaseALIoTDevice<?> d;
  private final boolean e;
  private final boolean f;
  private final boolean g;
  private final boolean h;
  private final int[] i;
  
  public LightStripLightSettingsViewModel(Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    this.b = new b(paramThingContext);
    this.c = new a(paramThingContext);
    paramApplication = (ALIoTDevice)paramThingContext.getIoTDevice();
    this.d = paramApplication;
    boolean bool1 = false;
    if (paramApplication != null) {
      bool2 = paramApplication.isSupportIoTComponent(EnumIoTComponent.COLOR_TEMPERATURE);
    } else {
      bool2 = false;
    }
    this.e = bool2;
    if (paramApplication != null) {
      bool2 = paramApplication.isSupportIoTComponent(EnumIoTComponent.COLOR);
    } else {
      bool2 = false;
    }
    this.f = bool2;
    if (paramApplication != null) {
      bool2 = paramApplication.isSupportIoTComponent(EnumIoTComponent.LIGHT_STRIP_LIGHTING_EFFECT);
    } else {
      bool2 = false;
    }
    this.g = bool2;
    boolean bool2 = bool1;
    if (paramApplication != null) {
      bool2 = paramApplication.isSupportIoTComponent(EnumIoTComponent.SEGMENT);
    }
    this.h = bool2;
    Object localObject = null;
    if (paramApplication != null) {
      paramApplication = paramApplication.getLocalIoTDevice();
    } else {
      paramApplication = null;
    }
    paramThingContext = paramApplication;
    if (!(paramApplication instanceof IoTLightStripDevice)) {
      paramThingContext = null;
    }
    paramThingContext = (IoTLightStripDevice)paramThingContext;
    paramApplication = (Application)localObject;
    if (paramThingContext != null) {
      paramApplication = paramThingContext.getColorTempRange();
    }
    this.i = paramApplication;
  }
  
  private final LightStripRepository h()
  {
    return (LightStripRepository)this.b.b(this, a[0]);
  }
  
  private final LightingEffectRepository i()
  {
    return (LightingEffectRepository)this.c.b(this, a[1]);
  }
  
  public final int[] f()
  {
    return this.i;
  }
  
  public final q<CustomizedEffect> g(String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "effectId");
    return i().U(paramString);
  }
  
  public final q<PredefinedEffect> j(String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "predefinedEffectId");
    return i().Y(paramString);
  }
  
  public final PredefinedEffect k(String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "predefinedEffectId");
    return i().Z(paramString);
  }
  
  public final boolean l()
  {
    return this.f;
  }
  
  public final boolean m()
  {
    return this.e;
  }
  
  public final boolean n()
  {
    return this.g;
  }
  
  public final boolean o()
  {
    return this.h;
  }
  
  public final void p(LightStateBean paramLightStateBean)
  {
    kotlin.jvm.internal.j.e(paramLightStateBean, "lightState");
    h().B5(paramLightStateBean).y();
  }
  
  public final a r(LightingEffectData paramLightingEffectData)
  {
    kotlin.jvm.internal.j.e(paramLightingEffectData, "effectData");
    return h().I5(paramLightingEffectData);
  }
  
  public static final class a
    implements c<Object, LightingEffectRepository>
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
    implements c<Object, LightStripRepository>
  {
    private final LightStripRepository a;
    
    public b(ThingContext paramThingContext)
    {
      paramThingContext = e.a(paramThingContext, LightStripRepository.class);
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
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\viewmodel\LightStripLightSettingsViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */