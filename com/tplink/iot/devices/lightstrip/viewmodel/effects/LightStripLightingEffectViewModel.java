package com.tplink.iot.devices.lightstrip.viewmodel.effects;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import b.d.b.f.b;
import com.tplink.iot.Utils.w0.a;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.IoTLightStripDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.PredefinedEffect;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.LightStripRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.LightingEffectRepository;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import io.reactivex.q;
import java.util.List;
import kotlin.t.c;

public final class LightStripLightingEffectViewModel
  extends AndroidViewModel
{
  private final c b;
  private final c c;
  private final boolean d;
  private final boolean e;
  private final int[] f;
  private final ThingContext g;
  
  public LightStripLightingEffectViewModel(Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    this.g = paramThingContext;
    this.b = new b(paramThingContext);
    this.c = new a(paramThingContext);
    paramApplication = (ALIoTDevice)paramThingContext.getIoTDevice();
    boolean bool1 = false;
    if (paramApplication != null) {
      bool2 = paramApplication.isSupportIoTComponent(EnumIoTComponent.SEGMENT);
    } else {
      bool2 = false;
    }
    this.d = bool2;
    paramApplication = (ALIoTDevice)paramThingContext.getIoTDevice();
    boolean bool2 = bool1;
    if (paramApplication != null) {
      bool2 = paramApplication.isSupportIoTComponent(EnumIoTComponent.COLOR_TEMPERATURE);
    }
    this.e = bool2;
    paramApplication = (ALIoTDevice)paramThingContext.getIoTDevice();
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
    this.f = paramApplication;
  }
  
  private final LightingEffectRepository h()
  {
    return (LightingEffectRepository)this.c.b(this, a[1]);
  }
  
  public final int[] f()
  {
    return this.f;
  }
  
  public final LiveData<List<CustomizedEffect>> g()
  {
    return h().X();
  }
  
  public final LiveData<List<PredefinedEffect>> i()
  {
    return h().b0();
  }
  
  public final boolean j()
  {
    return this.e;
  }
  
  public final boolean k()
  {
    boolean bool;
    if (a.a(this.g.getDeviceIdMD5(), EnumIoTComponent.LIGHT_STRIP_LIGHTING_EFFECT) >= 2) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final boolean l()
  {
    return this.d;
  }
  
  public final void m()
  {
    h().W().F0();
  }
  
  public final void n()
  {
    h().a0().F0();
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\viewmodel\effects\LightStripLightingEffectViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */