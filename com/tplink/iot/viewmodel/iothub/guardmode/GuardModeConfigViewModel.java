package com.tplink.iot.viewmodel.iothub.guardmode;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import b.d.b.f.b;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.params.PlayAlarmParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeAlarmTimeBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeAlarmTimeBean.Companion;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeConfigBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.HubRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import com.tplink.libtpnetwork.Utils.i;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.enumerate.EnumGuardMode;
import com.tplink.libtpnetwork.enumerate.EnumGuardModeAlarmTimeType;
import com.tplink.libtpnetwork.enumerate.EnumGuardModeAlarmVolume;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.l;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class GuardModeConfigViewModel
  extends AndroidViewModel
{
  private EnumGuardMode a = EnumGuardMode.HOME;
  private final HubRepository b;
  private final TPIoTClientManager c;
  private final String d;
  private final MediatorLiveData<List<BaseALIoTDevice<?>>> e;
  private final LiveData<List<BaseALIoTDevice<?>>> f;
  private final MediatorLiveData<GuardModeConfigBean> g;
  private boolean h;
  private GuardModeConfigBean i;
  private GuardModeConfigBean j;
  
  public GuardModeConfigViewModel(Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    HubRepository localHubRepository = (HubRepository)e.a(paramThingContext, HubRepository.class);
    this.b = localHubRepository;
    TPIoTClientManager localTPIoTClientManager = (TPIoTClientManager)b.a(paramThingContext.getAccountContext(), TPIoTClientManager.class);
    this.c = localTPIoTClientManager;
    this.d = paramThingContext.getDeviceIdMD5();
    MediatorLiveData localMediatorLiveData1 = new MediatorLiveData();
    this.e = localMediatorLiveData1;
    this.f = localMediatorLiveData1;
    MediatorLiveData localMediatorLiveData2 = new MediatorLiveData();
    this.g = localMediatorLiveData2;
    this.h = true;
    paramThingContext = this.a.getValue();
    List localList = l.d();
    paramApplication = (List)k().getValue();
    if (paramApplication != null)
    {
      paramApplication = (String)l.y(paramApplication);
      if (paramApplication != null) {}
    }
    else
    {
      paramApplication = "";
    }
    this.i = new GuardModeConfigBean(paramThingContext, localList, paramApplication, EnumGuardModeAlarmVolume.HIGH.getValue(), GuardModeAlarmTimeBean.Companion.getDefault());
    j.d(localHubRepository, "mHubRepository");
    localMediatorLiveData2.addSource(localHubRepository.l5(), new a(this));
    j.d(localTPIoTClientManager, "mTPIoTClientManager");
    localMediatorLiveData1.addSource(localTPIoTClientManager.C1(), new b(this));
  }
  
  private final boolean m()
  {
    Object localObject = this.j;
    if (localObject == null) {
      j.t("mOriginGuardModeConfigBean");
    }
    boolean bool1 = j.a(((GuardModeConfigBean)localObject).getAlarmTime(), this.i.getAlarmTime());
    localObject = this.j;
    if (localObject == null) {
      j.t("mOriginGuardModeConfigBean");
    }
    String str = ((GuardModeConfigBean)localObject).getAlarmTime().getType();
    localObject = EnumGuardModeAlarmTimeType.ALWAYS;
    boolean bool2 = j.a(str, ((EnumGuardModeAlarmTimeType)localObject).getValue());
    boolean bool3 = true;
    boolean bool4 = bool1;
    if (bool2)
    {
      bool4 = bool1;
      if (j.a(this.i.getAlarmTime().getType(), ((EnumGuardModeAlarmTimeType)localObject).getValue())) {
        bool4 = true;
      }
    }
    localObject = this.j;
    if (localObject == null) {
      j.t("mOriginGuardModeConfigBean");
    }
    if (((GuardModeConfigBean)localObject).getDeviceIdList().size() == this.i.getDeviceIdList().size())
    {
      localObject = this.j;
      if (localObject == null) {
        j.t("mOriginGuardModeConfigBean");
      }
      if (((GuardModeConfigBean)localObject).getDeviceIdList().containsAll(this.i.getDeviceIdList()))
      {
        k = 1;
        break label182;
      }
    }
    int k = 0;
    label182:
    if ((k != 0) && (bool4))
    {
      localObject = this.j;
      if (localObject == null) {
        j.t("mOriginGuardModeConfigBean");
      }
      if (j.a(((GuardModeConfigBean)localObject).getId(), this.i.getId()))
      {
        localObject = this.j;
        if (localObject == null) {
          j.t("mOriginGuardModeConfigBean");
        }
        if (j.a(((GuardModeConfigBean)localObject).getAlarmType(), this.i.getAlarmType()))
        {
          localObject = this.j;
          if (localObject == null) {
            j.t("mOriginGuardModeConfigBean");
          }
          if (j.a(((GuardModeConfigBean)localObject).getAlarmVolume(), this.i.getAlarmVolume()))
          {
            bool4 = bool3;
            break label295;
          }
        }
      }
    }
    bool4 = false;
    label295:
    return bool4;
  }
  
  private final void o(List<? extends BaseALIoTDevice<?>> paramList)
  {
    if (paramList != null)
    {
      Object localObject1 = new ArrayList();
      paramList = paramList.iterator();
      Object localObject2;
      while (paramList.hasNext())
      {
        localObject2 = paramList.next();
        BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)localObject2;
        int k;
        if ((localBaseALIoTDevice.isSubDevice()) && (j.a(localBaseALIoTDevice.getParentDeviceIDMD5(), this.d))) {
          k = 1;
        } else {
          k = 0;
        }
        if (k != 0) {
          ((Collection)localObject1).add(localObject2);
        }
      }
      this.e.postValue(localObject1);
      if (this.h)
      {
        localObject2 = this.i;
        paramList = new ArrayList(l.l((Iterable)localObject1, 10));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          paramList.add(((BaseALIoTDevice)((Iterator)localObject1).next()).getDeviceId());
        }
        ((GuardModeConfigBean)localObject2).setDeviceIdList(paramList);
        this.j = GuardModeConfigBean.copy$default(this.i, null, null, null, null, null, 31, null);
        this.g.postValue(this.i);
      }
    }
  }
  
  private final void p(GuardModeConfigBean paramGuardModeConfigBean)
  {
    this.h = false;
    this.j = GuardModeConfigBean.copy$default(paramGuardModeConfigBean, null, null, null, null, null, 31, null);
    paramGuardModeConfigBean = GuardModeConfigBean.copy$default(paramGuardModeConfigBean, null, null, null, null, null, 31, null);
    this.i = paramGuardModeConfigBean;
    this.g.postValue(paramGuardModeConfigBean);
  }
  
  private final void r(List<GuardModeConfigBean> paramList)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramList != null)
    {
      localObject1 = paramList.iterator();
      int k;
      do
      {
        paramList = (List<GuardModeConfigBean>)localObject2;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        paramList = ((Iterator)localObject1).next();
        if (((GuardModeConfigBean)paramList).getEnumGuardMode() == this.a) {
          k = 1;
        } else {
          k = 0;
        }
      } while (k == 0);
      localObject1 = (GuardModeConfigBean)paramList;
    }
    paramList = new StringBuilder();
    paramList.append("Find [");
    paramList.append(this.a.getValue());
    paramList.append("] Config：");
    paramList.append(localObject1);
    b.d.w.c.a.a(paramList.toString());
    paramList = this.j;
    if (paramList == null)
    {
      if (localObject1 != null)
      {
        p((GuardModeConfigBean)localObject1);
      }
      else
      {
        this.h = true;
        this.j = GuardModeConfigBean.copy$default(this.i, null, null, null, null, null, 31, null);
        this.g.postValue(this.i);
      }
    }
    else if (localObject1 != null)
    {
      if (paramList == null) {
        j.t("mOriginGuardModeConfigBean");
      }
      if ((j.a(paramList, localObject1) ^ true)) {
        p((GuardModeConfigBean)localObject1);
      }
    }
  }
  
  private final void z()
  {
    this.g.postValue(this.i);
  }
  
  public final LiveData<List<BaseALIoTDevice<?>>> h()
  {
    return this.f;
  }
  
  public final LiveData<GuardModeConfigBean> i()
  {
    return this.g;
  }
  
  public final void j()
  {
    HubRepository localHubRepository = this.b;
    j.d(localHubRepository, "mHubRepository");
    localHubRepository.p5().F0();
  }
  
  public final LiveData<List<String>> k()
  {
    Object localObject = this.b;
    j.d(localObject, "mHubRepository");
    localObject = ((HubRepository)localObject).q5();
    j.d(localObject, "mHubRepository.supportAlarmTypeListLiveData");
    return (LiveData<List<String>>)localObject;
  }
  
  public final boolean l()
  {
    GuardModeConfigBean localGuardModeConfigBean = this.j;
    boolean bool = true;
    if ((localGuardModeConfigBean == null) || ((!this.h) && (m()))) {
      bool = false;
    }
    return bool;
  }
  
  public final void n(String paramString, kotlin.jvm.b.a<p> parama)
  {
    j.e(paramString, "alarmType");
    j.e(parama, "errorAction");
    this.b.A6(new PlayAlarmParams(paramString, EnumGuardModeAlarmVolume.NORMAL.getValue())).r(io.reactivex.d0.b.a.a()).j(new c(parama)).y();
  }
  
  public final io.reactivex.a s()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Save GuardModeConfigBean: ");
    ((StringBuilder)localObject).append(i.f(this.i));
    b.d.w.c.a.a(((StringBuilder)localObject).toString());
    localObject = this.b.N6(this.i.toThingRuleGuardMode());
    j.d(localObject, "mHubRepository.setGuardM…n.toThingRuleGuardMode())");
    return (io.reactivex.a)localObject;
  }
  
  public final void t(EnumGuardModeAlarmTimeType paramEnumGuardModeAlarmTimeType, int paramInt)
  {
    j.e(paramEnumGuardModeAlarmTimeType, "timeType");
    this.i.setAlarmTime(new GuardModeAlarmTimeBean(paramEnumGuardModeAlarmTimeType.getValue(), paramInt));
    z();
  }
  
  public final void u(String paramString)
  {
    j.e(paramString, "type");
    this.i.setAlarmType(paramString);
    z();
  }
  
  public final void v(EnumGuardModeAlarmVolume paramEnumGuardModeAlarmVolume)
  {
    j.e(paramEnumGuardModeAlarmVolume, "volume");
    this.i.setAlarmVolume(paramEnumGuardModeAlarmVolume.getValue());
    z();
  }
  
  public final void w(EnumGuardMode paramEnumGuardMode)
  {
    j.e(paramEnumGuardMode, "mode");
    this.i.setId(paramEnumGuardMode.getValue());
    this.a = paramEnumGuardMode;
  }
  
  public final void x(List<String> paramList)
  {
    j.e(paramList, "deviceIdList");
    this.i.setDeviceIdList(paramList);
    z();
  }
  
  public final void y()
  {
    this.b.Q6().y();
  }
  
  static final class a<T>
    implements Observer<List<GuardModeConfigBean>>
  {
    a(GuardModeConfigViewModel paramGuardModeConfigViewModel) {}
    
    public final void a(List<GuardModeConfigBean> paramList)
    {
      GuardModeConfigViewModel.g(this.a, paramList);
    }
  }
  
  static final class b<T>
    implements Observer<List<BaseALIoTDevice<TDPIoTDevice>>>
  {
    b(GuardModeConfigViewModel paramGuardModeConfigViewModel) {}
    
    public final void a(List<BaseALIoTDevice<TDPIoTDevice>> paramList)
    {
      if (paramList != null) {
        GuardModeConfigViewModel.f(this.a, paramList);
      }
    }
  }
  
  static final class c<T>
    implements g<Throwable>
  {
    c(kotlin.jvm.b.a parama) {}
    
    public final void a(Throwable paramThrowable)
    {
      this.c.invoke();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\iothub\guardmode\GuardModeConfigViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */