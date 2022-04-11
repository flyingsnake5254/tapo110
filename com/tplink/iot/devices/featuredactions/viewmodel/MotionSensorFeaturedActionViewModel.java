package com.tplink.iot.devices.featuredactions.viewmodel;

import android.app.Application;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartPeriodSetting;
import com.tplink.iot.cloud.bean.smart.common.SmartThingAction;
import com.tplink.iot.cloud.bean.smart.common.SmartThingFutureAction;
import com.tplink.iot.cloud.bean.smart.common.SmartThingTrigger;
import com.tplink.iot.cloud.bean.thing.params.ThingEventParams;
import com.tplink.iot.devices.featuredactions.viewmodel.base.AbstractFeaturedActionViewModel;
import com.tplink.iot.g.a.b.a;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.HubRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.enumerate.EnumGuardModeAlarmVolume;
import io.reactivex.q;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.b0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.n;

public final class MotionSensorFeaturedActionViewModel
  extends AbstractFeaturedActionViewModel
{
  public MotionSensorFeaturedActionViewModel(Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication, paramThingContext);
  }
  
  private final SmartThingTrigger H()
  {
    SmartThingTrigger localSmartThingTrigger = B(s());
    localSmartThingTrigger.setEvent(new ThingEventParams("motion"));
    return localSmartThingTrigger;
  }
  
  public final SmartInfo I(String paramString, List<? extends BaseALIoTDevice<?>> paramList)
  {
    j.e(paramString, "title");
    j.e(paramList, "devices");
    paramString = k(paramString, H(), paramList, a.c);
    paramList = i(9, 0, 18, 0);
    paramString.setEffectivePeriod(new SmartPeriodSetting("CUSTOM", l("0111110"), paramList));
    return paramString;
  }
  
  public final SmartInfo J(String paramString, List<? extends BaseALIoTDevice<?>> paramList)
  {
    j.e(paramString, "title");
    j.e(paramList, "devices");
    SmartThingFutureAction localSmartThingFutureAction = new SmartThingFutureAction(120, b0.e(new Pair[] { n.a("on", Boolean.FALSE) }));
    paramString = k(paramString, H(), paramList, new b(localSmartThingFutureAction));
    paramList = i(18, 0, 8, 0);
    paramString.setEffectivePeriod(new SmartPeriodSetting("CUSTOM", (byte)127, paramList));
    return paramString;
  }
  
  public final SmartInfo K(String paramString, List<? extends BaseALIoTDevice<?>> paramList)
  {
    j.e(paramString, "title");
    j.e(paramList, "devices");
    SmartThingFutureAction localSmartThingFutureAction = new SmartThingFutureAction(120, b0.e(new Pair[] { n.a("on", Boolean.FALSE) }));
    paramList = k(paramString, H(), paramList, new c(localSmartThingFutureAction));
    paramString = i(18, 0, 8, 0);
    paramList.setEffectivePeriod(new SmartPeriodSetting("CUSTOM", (byte)127, paramString));
    return paramList;
  }
  
  public final void L(BaseALIoTDevice<?> paramBaseALIoTDevice)
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
      j.e(paramBaseALIoTDevice, "device");
      paramSmartThingAction.setService(a.b(a.a, paramBaseALIoTDevice, EnumGuardModeAlarmVolume.HIGH, 60, null, 8, null));
    }
  }
  
  static final class b
    extends Lambda
    implements kotlin.jvm.b.p<SmartThingAction, BaseALIoTDevice<?>, kotlin.p>
  {
    b(SmartThingFutureAction paramSmartThingFutureAction)
    {
      super();
    }
    
    public final void a(SmartThingAction paramSmartThingAction, BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      j.e(paramSmartThingAction, "$receiver");
      j.e(paramBaseALIoTDevice, "it");
      paramSmartThingAction.setStateDesired(b0.e(new Pair[] { n.a("on", Boolean.TRUE) }));
      paramSmartThingAction.setFutureAction(this.c);
    }
  }
  
  static final class c
    extends Lambda
    implements kotlin.jvm.b.p<SmartThingAction, BaseALIoTDevice<?>, kotlin.p>
  {
    c(SmartThingFutureAction paramSmartThingFutureAction)
    {
      super();
    }
    
    public final void a(SmartThingAction paramSmartThingAction, BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      j.e(paramSmartThingAction, "$receiver");
      j.e(paramBaseALIoTDevice, "it");
      paramSmartThingAction.setStateDesired(b0.e(new Pair[] { n.a("on", Boolean.TRUE) }));
      paramSmartThingAction.setFutureAction(this.c);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\featuredactions\viewmodel\MotionSensorFeaturedActionViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */