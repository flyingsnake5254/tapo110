package com.tplink.iot.devices.featuredactions.viewmodel;

import android.app.Application;
import com.google.gson.k;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartThingAction;
import com.tplink.iot.cloud.bean.smart.common.SmartThingTrigger;
import com.tplink.iot.cloud.bean.smart.common.SmartThingTriggerState;
import com.tplink.iot.cloud.bean.smart.common.SmartThingTriggerStateValue;
import com.tplink.iot.cloud.bean.thing.params.ThingEventParams;
import com.tplink.iot.cloud.bean.thing.params.ThingServiceParams;
import com.tplink.iot.cloud.enumerate.StateOperator;
import com.tplink.iot.cloud.enumerate.StateValueDataType;
import com.tplink.iot.devices.featuredactions.viewmodel.base.AbstractFeaturedActionViewModel;
import com.tplink.iot.g.a.b.a;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.HubRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.enumerate.EnumGuardModeAlarmVolume;
import io.reactivex.q;
import java.util.List;
import kotlin.collections.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public final class ButtonFeaturedActionViewModel
  extends AbstractFeaturedActionViewModel
{
  public ButtonFeaturedActionViewModel(Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication, paramThingContext);
  }
  
  private final SmartThingTrigger H(boolean paramBoolean)
  {
    SmartThingTrigger localSmartThingTrigger = B(s());
    SmartThingTriggerState localSmartThingTriggerState = new SmartThingTriggerState();
    localSmartThingTriggerState.setValue(new SmartThingTriggerStateValue("0"));
    localSmartThingTriggerState.setDataType(StateValueDataType.INT);
    localSmartThingTriggerState.setKey("rotate_deg");
    StateOperator localStateOperator;
    if (paramBoolean) {
      localStateOperator = StateOperator.GT;
    } else {
      localStateOperator = StateOperator.LT;
    }
    localSmartThingTriggerState.setOp(localStateOperator);
    localSmartThingTrigger.setEvent(new ThingEventParams("rotation", l.b(localSmartThingTriggerState)));
    return localSmartThingTrigger;
  }
  
  private final SmartThingTrigger I()
  {
    SmartThingTrigger localSmartThingTrigger = B(s());
    localSmartThingTrigger.setEvent(new ThingEventParams("singleClick"));
    return localSmartThingTrigger;
  }
  
  public final SmartInfo[] J(String paramString, List<? extends BaseALIoTDevice<?>> paramList)
  {
    j.e(paramString, "title");
    j.e(paramList, "devices");
    return new SmartInfo[] { k(paramString, H(true), paramList, b.c), k(paramString, H(false), paramList, a.c) };
  }
  
  public final SmartInfo[] K(String paramString, List<? extends BaseALIoTDevice<?>> paramList)
  {
    j.e(paramString, "title");
    j.e(paramList, "devices");
    return new SmartInfo[] { k(paramString, H(true), paramList, d.c), k(paramString, H(false), paramList, c.c) };
  }
  
  public final SmartInfo L(String paramString, List<? extends BaseALIoTDevice<?>> paramList)
  {
    j.e(paramString, "title");
    j.e(paramList, "devices");
    return k(paramString, I(), paramList, e.c);
  }
  
  public final SmartInfo[] M(String paramString, List<? extends BaseALIoTDevice<?>> paramList)
  {
    j.e(paramString, "title");
    j.e(paramList, "devices");
    return new SmartInfo[] { k(paramString, H(true), paramList, g.c), k(paramString, H(false), paramList, f.c) };
  }
  
  public final SmartInfo N(String paramString, List<? extends BaseALIoTDevice<?>> paramList)
  {
    j.e(paramString, "title");
    j.e(paramList, "devices");
    return k(paramString, I(), paramList, h.c);
  }
  
  public final void O(BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    j.e(paramBaseALIoTDevice, "device");
    if (paramBaseALIoTDevice.isHub())
    {
      paramBaseALIoTDevice = e.d(paramBaseALIoTDevice.getDeviceIdMD5(), HubRepository.class);
      j.d(paramBaseALIoTDevice, "IoTDeviceRepositoryProvi…ubRepository::class.java)");
      ((HubRepository)paramBaseALIoTDevice).p5().F0();
    }
  }
  
  static final class a
    extends Lambda
    implements kotlin.jvm.b.p<SmartThingAction, BaseALIoTDevice<?>, kotlin.p>
  {
    public static final a c = new a();
    
    a()
    {
      super();
    }
    
    public final void a(SmartThingAction paramSmartThingAction, BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      j.e(paramSmartThingAction, "$receiver");
      j.e(paramBaseALIoTDevice, "it");
      paramSmartThingAction.setService(new ThingServiceParams("decreaseBrightness", new k()));
    }
  }
  
  static final class b
    extends Lambda
    implements kotlin.jvm.b.p<SmartThingAction, BaseALIoTDevice<?>, kotlin.p>
  {
    public static final b c = new b();
    
    b()
    {
      super();
    }
    
    public final void a(SmartThingAction paramSmartThingAction, BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      j.e(paramSmartThingAction, "$receiver");
      j.e(paramBaseALIoTDevice, "it");
      paramSmartThingAction.setService(new ThingServiceParams("increaseBrightness", new k()));
    }
  }
  
  static final class c
    extends Lambda
    implements kotlin.jvm.b.p<SmartThingAction, BaseALIoTDevice<?>, kotlin.p>
  {
    public static final c c = new c();
    
    c()
    {
      super();
    }
    
    public final void a(SmartThingAction paramSmartThingAction, BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      j.e(paramSmartThingAction, "$receiver");
      j.e(paramBaseALIoTDevice, "it");
      paramSmartThingAction.setService(new ThingServiceParams("decreaseCCT", new k()));
    }
  }
  
  static final class d
    extends Lambda
    implements kotlin.jvm.b.p<SmartThingAction, BaseALIoTDevice<?>, kotlin.p>
  {
    public static final d c = new d();
    
    d()
    {
      super();
    }
    
    public final void a(SmartThingAction paramSmartThingAction, BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      j.e(paramSmartThingAction, "$receiver");
      j.e(paramBaseALIoTDevice, "it");
      paramSmartThingAction.setService(new ThingServiceParams("increaseCCT", new k()));
    }
  }
  
  static final class e
    extends Lambda
    implements kotlin.jvm.b.p<SmartThingAction, BaseALIoTDevice<?>, kotlin.p>
  {
    public static final e c = new e();
    
    e()
    {
      super();
    }
    
    public final void a(SmartThingAction paramSmartThingAction, BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      j.e(paramSmartThingAction, "$receiver");
      j.e(paramBaseALIoTDevice, "device");
      paramSmartThingAction.setService(a.b(a.a, paramBaseALIoTDevice, EnumGuardModeAlarmVolume.HIGH, 30, null, 8, null));
    }
  }
  
  static final class f
    extends Lambda
    implements kotlin.jvm.b.p<SmartThingAction, BaseALIoTDevice<?>, kotlin.p>
  {
    public static final f c = new f();
    
    f()
    {
      super();
    }
    
    public final void a(SmartThingAction paramSmartThingAction, BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      j.e(paramSmartThingAction, "$receiver");
      j.e(paramBaseALIoTDevice, "it");
      paramSmartThingAction.setService(new ThingServiceParams("randomColor", new k()));
    }
  }
  
  static final class g
    extends Lambda
    implements kotlin.jvm.b.p<SmartThingAction, BaseALIoTDevice<?>, kotlin.p>
  {
    public static final g c = new g();
    
    g()
    {
      super();
    }
    
    public final void a(SmartThingAction paramSmartThingAction, BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      j.e(paramSmartThingAction, "$receiver");
      j.e(paramBaseALIoTDevice, "it");
      paramSmartThingAction.setService(new ThingServiceParams("randomColor", new k()));
    }
  }
  
  static final class h
    extends Lambda
    implements kotlin.jvm.b.p<SmartThingAction, BaseALIoTDevice<?>, kotlin.p>
  {
    public static final h c = new h();
    
    h()
    {
      super();
    }
    
    public final void a(SmartThingAction paramSmartThingAction, BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      j.e(paramSmartThingAction, "$receiver");
      j.e(paramBaseALIoTDevice, "it");
      paramSmartThingAction.setService(new ThingServiceParams("reverseStatus", new k()));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\featuredactions\viewmodel\ButtonFeaturedActionViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */