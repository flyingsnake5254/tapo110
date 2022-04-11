package com.tplink.iot.viewmodel.smart.taskdevice;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.gson.k;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingService;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.params.PlayAlarmParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeAlarmTimeBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeAlarmTimeBean.Companion;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeConfigBean;
import com.tplink.libtpnetwork.IoTNetwork.repository.HubRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.enumerate.EnumGuardMode;
import com.tplink.libtpnetwork.enumerate.EnumGuardModeAlarmTimeType;
import com.tplink.libtpnetwork.enumerate.EnumGuardModeAlarmVolume;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.l;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.internal.Lambda;
import kotlin.p;
import kotlin.t.c;

public final class TaskHubControlViewModel
  extends AndroidViewModel
{
  private final c b;
  private final c c;
  private final f d;
  private final GuardModeConfigBean e;
  private final MutableLiveData<GuardModeConfigBean> f;
  private final LiveData<GuardModeConfigBean> g;
  private final boolean h;
  private final boolean i;
  private final boolean j;
  
  public TaskHubControlViewModel(Application paramApplication, final ThingContext paramThingContext)
  {
    super(paramApplication);
    this.b = new b(paramThingContext);
    paramApplication = paramThingContext.getAccountContext();
    kotlin.jvm.internal.j.d(paramApplication, "iotDeviceContext.accountContext");
    this.c = new a(paramApplication);
    this.d = h.b(new d(this, paramThingContext));
    Object localObject = EnumGuardMode.HOME.getValue();
    paramThingContext = l.d();
    paramApplication = j().q5();
    kotlin.jvm.internal.j.d(paramApplication, "mHubRepository.supportAlarmTypeListLiveData");
    paramApplication = (List)paramApplication.getValue();
    if (paramApplication != null)
    {
      paramApplication = (String)l.y(paramApplication);
      if (paramApplication != null) {}
    }
    else
    {
      paramApplication = "";
    }
    paramApplication = new GuardModeConfigBean((String)localObject, paramThingContext, paramApplication, EnumGuardModeAlarmVolume.HIGH.getValue(), GuardModeAlarmTimeBean.Companion.getDefault());
    this.e = paramApplication;
    paramApplication = new MutableLiveData(paramApplication);
    this.f = paramApplication;
    this.g = paramApplication;
    paramApplication = l();
    boolean bool1 = true;
    if (paramApplication != null)
    {
      paramApplication = paramApplication.getServices();
      if ((paramApplication != null) && (!paramApplication.isEmpty()))
      {
        paramApplication = paramApplication.iterator();
        while (paramApplication.hasNext())
        {
          paramThingContext = (ThingService)paramApplication.next();
          kotlin.jvm.internal.j.d(paramThingContext, "it");
          if (kotlin.jvm.internal.j.a("ring", paramThingContext.getId()))
          {
            bool2 = true;
            break label256;
          }
        }
      }
    }
    boolean bool2 = false;
    label256:
    this.h = bool2;
    paramApplication = l();
    paramThingContext = null;
    if (paramApplication != null) {
      paramApplication = paramApplication.getThingProperty("guard_on");
    } else {
      paramApplication = null;
    }
    if (paramApplication != null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.i = bool2;
    localObject = l();
    paramApplication = paramThingContext;
    if (localObject != null) {
      paramApplication = ((ThingModel)localObject).getThingProperty("guard_mode");
    }
    if (paramApplication != null) {
      bool2 = bool1;
    } else {
      bool2 = false;
    }
    this.j = bool2;
  }
  
  private final HubRepository j()
  {
    return (HubRepository)this.b.b(this, a[0]);
  }
  
  private final ThingCloudRepository k()
  {
    return (ThingCloudRepository)this.c.b(this, a[1]);
  }
  
  private final ThingModel l()
  {
    return (ThingModel)this.d.getValue();
  }
  
  private final void x()
  {
    this.f.postValue(this.e);
  }
  
  public final k h()
  {
    k localk = new k();
    localk.m("type", this.e.getAlarmType());
    localk.m("volume", this.e.getAlarmVolume());
    EnumGuardModeAlarmTimeType localEnumGuardModeAlarmTimeType = this.e.getAlarmTime().getEnumType();
    int k = a.a[localEnumGuardModeAlarmTimeType.ordinal()];
    if (k != 1)
    {
      if (k == 2) {
        localk.l("duration", Integer.valueOf(this.e.getAlarmTime().getTime()));
      }
    }
    else {
      localk.l("duration", Integer.valueOf(0));
    }
    return localk;
  }
  
  public final LiveData<GuardModeConfigBean> i()
  {
    return this.g;
  }
  
  public final void m()
  {
    j().p5().E(new c(this)).F0();
  }
  
  public final LiveData<List<String>> n()
  {
    MutableLiveData localMutableLiveData = j().q5();
    kotlin.jvm.internal.j.d(localMutableLiveData, "mHubRepository.supportAlarmTypeListLiveData");
    return localMutableLiveData;
  }
  
  public final boolean o()
  {
    return this.j;
  }
  
  public final boolean p()
  {
    return this.i;
  }
  
  public final boolean r()
  {
    return this.h;
  }
  
  public final void s(String paramString, kotlin.jvm.b.a<p> parama)
  {
    kotlin.jvm.internal.j.e(paramString, "alarmType");
    kotlin.jvm.internal.j.e(parama, "errorAction");
    j().A6(new PlayAlarmParams(paramString, EnumGuardModeAlarmVolume.NORMAL.getValue())).r(io.reactivex.d0.b.a.a()).j(new e(parama)).y();
  }
  
  public final void t()
  {
    j().Q6().y();
  }
  
  public final void u(EnumGuardModeAlarmTimeType paramEnumGuardModeAlarmTimeType, int paramInt)
  {
    kotlin.jvm.internal.j.e(paramEnumGuardModeAlarmTimeType, "timeType");
    this.e.setAlarmTime(new GuardModeAlarmTimeBean(paramEnumGuardModeAlarmTimeType.getValue(), paramInt));
    x();
  }
  
  public final void v(String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "type");
    this.e.setAlarmType(paramString);
    x();
  }
  
  public final void w(EnumGuardModeAlarmVolume paramEnumGuardModeAlarmVolume)
  {
    kotlin.jvm.internal.j.e(paramEnumGuardModeAlarmVolume, "volume");
    this.e.setAlarmVolume(paramEnumGuardModeAlarmVolume.getValue());
    x();
  }
  
  public static final class a
    implements c<Object, ThingCloudRepository>
  {
    private final ThingCloudRepository a;
    
    public a(com.tplink.cloud.context.b paramb)
    {
      paramb = b.d.b.f.b.a(paramb, ThingCloudRepository.class);
      kotlin.jvm.internal.j.d(paramb, "CloudRepositoryProviders…sitory, REPO::class.java)");
      this.a = paramb;
    }
    
    public ThingCloudRepository c(Object paramObject, kotlin.reflect.j<?> paramj)
    {
      kotlin.jvm.internal.j.e(paramObject, "thisRef");
      kotlin.jvm.internal.j.e(paramj, "property");
      return this.a;
    }
  }
  
  public static final class b
    implements c<Object, HubRepository>
  {
    private final HubRepository a;
    
    public b(ThingContext paramThingContext)
    {
      paramThingContext = e.a(paramThingContext, HubRepository.class);
      kotlin.jvm.internal.j.d(paramThingContext, "IoTDeviceRepositoryProvi…sitory, REPO::class.java)");
      this.a = paramThingContext;
    }
    
    public HubRepository c(Object paramObject, kotlin.reflect.j<?> paramj)
    {
      kotlin.jvm.internal.j.e(paramObject, "thisRef");
      kotlin.jvm.internal.j.e(paramj, "property");
      return this.a;
    }
  }
  
  static final class c<T>
    implements g<List<String>>
  {
    c(TaskHubControlViewModel paramTaskHubControlViewModel) {}
    
    public final void a(List<String> paramList)
    {
      int i = TaskHubControlViewModel.f(this.c).getAlarmType().length();
      int j = 1;
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        i = j;
        if (paramList != null) {
          if (paramList.isEmpty()) {
            i = j;
          } else {
            i = 0;
          }
        }
        if (i == 0)
        {
          TaskHubControlViewModel localTaskHubControlViewModel = this.c;
          paramList = l.x(paramList);
          kotlin.jvm.internal.j.d(paramList, "it.first()");
          localTaskHubControlViewModel.v((String)paramList);
        }
      }
    }
  }
  
  static final class d
    extends Lambda
    implements kotlin.jvm.b.a<ThingModel>
  {
    d(TaskHubControlViewModel paramTaskHubControlViewModel, ThingContext paramThingContext)
    {
      super();
    }
    
    public final ThingModel a()
    {
      Object localObject1 = paramThingContext.getThingModel();
      if (localObject1 == null)
      {
        localObject1 = this.c;
        Object localObject2 = paramThingContext.getThingDevice();
        if (localObject2 != null)
        {
          localObject2 = ((ThingDevice)localObject2).getThingModelId();
          if (localObject2 != null) {
            return TaskHubControlViewModel.g((TaskHubControlViewModel)localObject1).m0((String)localObject2);
          }
        }
        localObject1 = null;
      }
      return (ThingModel)localObject1;
    }
  }
  
  static final class e<T>
    implements g<Throwable>
  {
    e(kotlin.jvm.b.a parama) {}
    
    public final void a(Throwable paramThrowable)
    {
      this.c.invoke();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\smart\taskdevice\TaskHubControlViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */