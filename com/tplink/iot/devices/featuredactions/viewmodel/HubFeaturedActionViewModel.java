package com.tplink.iot.devices.featuredactions.viewmodel;

import android.app.Application;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartThingAction;
import com.tplink.iot.cloud.bean.smart.common.SmartThingTrigger;
import com.tplink.iot.cloud.bean.thing.params.ThingEventParams;
import com.tplink.iot.devices.featuredactions.viewmodel.base.AbstractFeaturedActionViewModel;
import com.tplink.iot.g.a.b.a;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumGuardModeAlarmVolume;
import java.util.List;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public final class HubFeaturedActionViewModel
  extends AbstractFeaturedActionViewModel
{
  public HubFeaturedActionViewModel(Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication, paramThingContext);
  }
  
  private final SmartThingAction H(EnumGuardModeAlarmVolume paramEnumGuardModeAlarmVolume, int paramInt, String paramString)
  {
    SmartThingAction localSmartThingAction = A(s());
    localSmartThingAction.setService(a.a.a(s(), paramEnumGuardModeAlarmVolume, paramInt, paramString));
    return localSmartThingAction;
  }
  
  public final SmartInfo J(String paramString, List<? extends BaseALIoTDevice<?>> paramList)
  {
    j.e(paramString, "title");
    j.e(paramList, "devices");
    return j(paramString, H(EnumGuardModeAlarmVolume.HIGH, 300, "Alarm 4"), paramList, a.c);
  }
  
  public final SmartInfo K(String paramString, List<? extends BaseALIoTDevice<?>> paramList)
  {
    j.e(paramString, "title");
    j.e(paramList, "devices");
    return j(paramString, I(this, EnumGuardModeAlarmVolume.HIGH, 10, null, 4, null), paramList, b.c);
  }
  
  public final SmartInfo L(String paramString, List<? extends BaseALIoTDevice<?>> paramList)
  {
    j.e(paramString, "title");
    j.e(paramList, "devices");
    paramString = j(paramString, I(this, EnumGuardModeAlarmVolume.HIGH, 60, null, 4, null), paramList, c.c);
    paramList = i(9, 0, 18, 0);
    paramString.setEffectivePeriod(h(l("0111110"), paramList));
    return paramString;
  }
  
  public final SmartInfo M(String paramString, List<? extends BaseALIoTDevice<?>> paramList)
  {
    j.e(paramString, "title");
    j.e(paramList, "devices");
    return j(paramString, I(this, EnumGuardModeAlarmVolume.NORMAL, 10, null, 4, null), paramList, d.c);
  }
  
  public final SmartInfo N(String paramString, List<? extends BaseALIoTDevice<?>> paramList)
  {
    j.e(paramString, "title");
    j.e(paramList, "devices");
    paramString = j(paramString, I(this, EnumGuardModeAlarmVolume.HIGH, 60, null, 4, null), paramList, e.c);
    paramString.setEffectivePeriod(h((byte)Byte.MAX_VALUE, i(18, 0, 8, 0)));
    return paramString;
  }
  
  static final class a
    extends Lambda
    implements kotlin.jvm.b.p<SmartThingTrigger, BaseALIoTDevice<?>, kotlin.p>
  {
    public static final a c = new a();
    
    a()
    {
      super();
    }
    
    public final void a(SmartThingTrigger paramSmartThingTrigger, BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      j.e(paramSmartThingTrigger, "$receiver");
      j.e(paramBaseALIoTDevice, "it");
      paramSmartThingTrigger.setEvent(new ThingEventParams("singleClick"));
    }
  }
  
  static final class b
    extends Lambda
    implements kotlin.jvm.b.p<SmartThingTrigger, BaseALIoTDevice<?>, kotlin.p>
  {
    public static final b c = new b();
    
    b()
    {
      super();
    }
    
    public final void a(SmartThingTrigger paramSmartThingTrigger, BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      j.e(paramSmartThingTrigger, "$receiver");
      j.e(paramBaseALIoTDevice, "it");
      paramSmartThingTrigger.setEvent(new ThingEventParams("singleClick"));
    }
  }
  
  static final class c
    extends Lambda
    implements kotlin.jvm.b.p<SmartThingTrigger, BaseALIoTDevice<?>, kotlin.p>
  {
    public static final c c = new c();
    
    c()
    {
      super();
    }
    
    public final void a(SmartThingTrigger paramSmartThingTrigger, BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      j.e(paramSmartThingTrigger, "$receiver");
      j.e(paramBaseALIoTDevice, "it");
      paramSmartThingTrigger.setEvent(new ThingEventParams("motion"));
    }
  }
  
  static final class d
    extends Lambda
    implements kotlin.jvm.b.p<SmartThingTrigger, BaseALIoTDevice<?>, kotlin.p>
  {
    public static final d c = new d();
    
    d()
    {
      super();
    }
    
    public final void a(SmartThingTrigger paramSmartThingTrigger, BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      j.e(paramSmartThingTrigger, "$receiver");
      j.e(paramBaseALIoTDevice, "it");
      paramSmartThingTrigger.setEvent(new ThingEventParams("keepOpen"));
    }
  }
  
  static final class e
    extends Lambda
    implements kotlin.jvm.b.p<SmartThingTrigger, BaseALIoTDevice<?>, kotlin.p>
  {
    public static final e c = new e();
    
    e()
    {
      super();
    }
    
    public final void a(SmartThingTrigger paramSmartThingTrigger, BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      j.e(paramSmartThingTrigger, "$receiver");
      j.e(paramBaseALIoTDevice, "it");
      paramSmartThingTrigger.setEvent(new ThingEventParams("open"));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\featuredactions\viewmodel\HubFeaturedActionViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */