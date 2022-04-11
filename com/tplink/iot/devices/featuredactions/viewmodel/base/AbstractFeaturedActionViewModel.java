package com.tplink.iot.devices.featuredactions.viewmodel.base;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.cloud.bean.smart.common.SmartAction;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartLocation;
import com.tplink.iot.cloud.bean.smart.common.SmartPeriodSetting;
import com.tplink.iot.cloud.bean.smart.common.SmartThingAction;
import com.tplink.iot.cloud.bean.smart.common.SmartThingTrigger;
import com.tplink.iot.cloud.bean.smart.common.SmartTimeSetting;
import com.tplink.iot.cloud.bean.smart.common.SmartTrigger;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.cloud.bean.thing.common.ThingInfo;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice<*>;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractSubThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.SmartRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import io.reactivex.e;
import io.reactivex.f;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import kotlin.collections.l;

public abstract class AbstractFeaturedActionViewModel
  extends AndroidViewModel
{
  private final kotlin.t.c b = new a();
  private final kotlin.t.c c = new b();
  private final kotlin.t.c d = new c();
  private final ALIoTDevice e;
  private final LiveData<List<BaseALIoTDevice<?>>> f;
  private final kotlin.t.c g;
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> h;
  private final LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> i;
  private final HashMap<String, com.tplink.iot.g.a.a.b> j;
  private final MutableLiveData<List<com.tplink.iot.g.a.a.b>> k;
  private final LiveData<List<com.tplink.iot.g.a.a.b>> l;
  
  public AbstractFeaturedActionViewModel(Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    this.e = ((ALIoTDevice)paramThingContext.getIoTDevice());
    paramApplication = v().C1();
    kotlin.jvm.internal.j.d(paramApplication, "mTPIoTClientManager.allIoTDeviceLiveData");
    this.f = paramApplication;
    this.g = com.tplink.iot.Utils.extension.c.a(paramThingContext);
    paramApplication = new MutableLiveData();
    this.h = paramApplication;
    this.i = paramApplication;
    this.j = new HashMap();
    paramApplication = new MutableLiveData();
    this.k = paramApplication;
    this.l = paramApplication;
  }
  
  private final void D()
  {
    this.k.postValue(new ArrayList(this.j.values()));
  }
  
  private final void E(final com.tplink.iot.g.a.a.b paramb, ThingFirmware paramThingFirmware, q<ThingFirmware> paramq)
  {
    if (paramThingFirmware != null) {
      paramb.d(paramThingFirmware);
    } else {
      paramq.E(new e(this, paramb)).F0();
    }
  }
  
  private final void p()
  {
    Iterator localIterator = new ArrayList(this.j.values()).iterator();
    while (localIterator.hasNext())
    {
      com.tplink.iot.g.a.a.b localb = (com.tplink.iot.g.a.a.b)localIterator.next();
      if (!localb.c())
      {
        Object localObject1 = localb.a().getDeviceIdMD5();
        kotlin.jvm.internal.j.d(localObject1, "deviceInfo.device.deviceIdMD5");
        localObject1 = com.tplink.libtpnetwork.IoTNetwork.util.c.d((String)localObject1);
        Object localObject2;
        if ((localObject1 instanceof AbstractThingRepository))
        {
          kotlin.jvm.internal.j.d(localb, "deviceInfo");
          localObject2 = (AbstractThingRepository)localObject1;
          localObject1 = ((AbstractThingRepository)localObject2).w1();
          kotlin.jvm.internal.j.d(localObject1, "repo.firmwareLatestInfoData");
          localObject1 = (ThingFirmware)((LiveData)localObject1).getValue();
          localObject2 = ((AbstractThingRepository)localObject2).v1();
          kotlin.jvm.internal.j.d(localObject2, "repo.firmwareLatestInfo");
          E(localb, (ThingFirmware)localObject1, (q)localObject2);
        }
        else if ((localObject1 instanceof AbstractSubThingRepository))
        {
          kotlin.jvm.internal.j.d(localb, "deviceInfo");
          localObject2 = (AbstractSubThingRepository)localObject1;
          localObject1 = ((AbstractSubThingRepository)localObject2).h1();
          kotlin.jvm.internal.j.d(localObject1, "repo.firmwareLatestInfoData");
          localObject1 = (ThingFirmware)((LiveData)localObject1).getValue();
          localObject2 = ((AbstractSubThingRepository)localObject2).g1();
          kotlin.jvm.internal.j.d(localObject2, "repo.firmwareLatestInfo");
          E(localb, (ThingFirmware)localObject1, (q)localObject2);
        }
      }
    }
    D();
  }
  
  protected final SmartThingAction A(BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    SmartThingAction localSmartThingAction = new SmartThingAction();
    Object localObject1 = null;
    if (paramBaseALIoTDevice != null) {
      localObject2 = paramBaseALIoTDevice.getDeviceId();
    } else {
      localObject2 = null;
    }
    localSmartThingAction.setThingName((String)localObject2);
    if (paramBaseALIoTDevice != null) {
      localObject2 = paramBaseALIoTDevice.getCategory();
    } else {
      localObject2 = null;
    }
    localSmartThingAction.setCategory((String)localObject2);
    SmartRepository localSmartRepository = u();
    Object localObject2 = localObject1;
    if (paramBaseALIoTDevice != null) {
      localObject2 = paramBaseALIoTDevice.getDeviceId();
    }
    paramBaseALIoTDevice = localSmartRepository.N((String)localObject2);
    if (paramBaseALIoTDevice != null)
    {
      localSmartThingAction.setNickname(paramBaseALIoTDevice.getNickname());
      localSmartThingAction.setAvatarUrl(paramBaseALIoTDevice.getAvatarUrl());
      localSmartThingAction.setSubThing(paramBaseALIoTDevice.isSubThing());
    }
    return localSmartThingAction;
  }
  
  protected final SmartThingTrigger B(BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    SmartThingTrigger localSmartThingTrigger = new SmartThingTrigger();
    Object localObject1 = null;
    if (paramBaseALIoTDevice != null) {
      localObject2 = paramBaseALIoTDevice.getDeviceId();
    } else {
      localObject2 = null;
    }
    localSmartThingTrigger.setThingName((String)localObject2);
    if (paramBaseALIoTDevice != null) {
      localObject2 = paramBaseALIoTDevice.getCategory();
    } else {
      localObject2 = null;
    }
    localSmartThingTrigger.setCategory((String)localObject2);
    SmartRepository localSmartRepository = u();
    Object localObject2 = localObject1;
    if (paramBaseALIoTDevice != null) {
      localObject2 = paramBaseALIoTDevice.getDeviceId();
    }
    paramBaseALIoTDevice = localSmartRepository.N((String)localObject2);
    if (paramBaseALIoTDevice != null)
    {
      localSmartThingTrigger.setNickname(paramBaseALIoTDevice.getNickname());
      localSmartThingTrigger.setAvatarUrl(paramBaseALIoTDevice.getAvatarUrl());
      localSmartThingTrigger.setSubThing(paramBaseALIoTDevice.isSubThing());
    }
    return localSmartThingTrigger;
  }
  
  protected final SmartTrigger C()
  {
    SmartTrigger localSmartTrigger = new SmartTrigger();
    localSmartTrigger.setManual(false);
    localSmartTrigger.setCondition(Byte.valueOf((byte)0));
    localSmartTrigger.setSchedules(null);
    localSmartTrigger.setThings(null);
    return localSmartTrigger;
  }
  
  protected final void F(SmartInfo paramSmartInfo)
  {
    kotlin.jvm.internal.j.e(paramSmartInfo, "smartInfo");
    String str = com.tplink.iot.view.smart.a.g.a(paramSmartInfo);
    int m;
    if (str.length() == 0) {
      m = 1;
    } else {
      m = 0;
    }
    if (m != 0) {
      str = SmartRepository.h[1];
    }
    paramSmartInfo.setAvatarUrl(str);
  }
  
  public final void G(List<com.tplink.iot.g.a.a.b> paramList)
  {
    kotlin.jvm.internal.j.e(paramList, "devices");
    this.j.clear();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      com.tplink.iot.g.a.a.b localb = (com.tplink.iot.g.a.a.b)localIterator.next();
      HashMap localHashMap = this.j;
      paramList = localb.a().getDeviceIdMD5();
      kotlin.jvm.internal.j.d(paramList, "deviceInfo.device.deviceIdMD5");
      localHashMap.put(paramList, localb);
    }
    p();
    D();
  }
  
  public final void g(SmartInfo[] paramArrayOfSmartInfo)
  {
    kotlin.jvm.internal.j.e(paramArrayOfSmartInfo, "smarts");
    ArrayList localArrayList = new ArrayList(paramArrayOfSmartInfo.length);
    int m = paramArrayOfSmartInfo.length;
    for (int n = 0; n < m; n++)
    {
      SmartInfo localSmartInfo = paramArrayOfSmartInfo[n];
      F(localSmartInfo);
      localArrayList.add(u().F(localSmartInfo));
    }
    io.reactivex.a.p(localArrayList).f(n()).y();
  }
  
  protected final SmartPeriodSetting h(byte paramByte, SmartTimeSetting paramSmartTimeSetting)
  {
    kotlin.jvm.internal.j.e(paramSmartTimeSetting, "timeSetting");
    return new SmartPeriodSetting("CUSTOM", paramByte, paramSmartTimeSetting);
  }
  
  protected final SmartTimeSetting i(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    SmartTimeSetting localSmartTimeSetting = new SmartTimeSetting();
    localSmartTimeSetting.setStartTime(paramInt1 * 60 + paramInt2);
    localSmartTimeSetting.setEndTime(paramInt3 * 60 + paramInt4);
    return localSmartTimeSetting;
  }
  
  protected final SmartInfo j(String paramString, SmartThingAction paramSmartThingAction, List<? extends BaseALIoTDevice<?>> paramList, kotlin.jvm.b.p<? super SmartThingTrigger, ? super BaseALIoTDevice<?>, kotlin.p> paramp)
  {
    kotlin.jvm.internal.j.e(paramString, "title");
    kotlin.jvm.internal.j.e(paramSmartThingAction, "thingAction");
    kotlin.jvm.internal.j.e(paramList, "devices");
    kotlin.jvm.internal.j.e(paramp, "configThingTrigger");
    paramString = z(paramString);
    Object localObject = y();
    ((SmartAction)localObject).setThings(l.h(new SmartThingAction[] { paramSmartThingAction }));
    paramSmartThingAction = kotlin.p.a;
    paramString.setActionSetting((SmartAction)localObject);
    paramSmartThingAction = C();
    localObject = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (BaseALIoTDevice)localIterator.next();
      SmartThingTrigger localSmartThingTrigger = B(paramList);
      paramp.invoke(localSmartThingTrigger, paramList);
      ((List)localObject).add(localSmartThingTrigger);
    }
    paramSmartThingAction.setThings((List)localObject);
    paramString.setTriggerSetting(paramSmartThingAction);
    return paramString;
  }
  
  protected final SmartInfo k(String paramString, SmartThingTrigger paramSmartThingTrigger, List<? extends BaseALIoTDevice<?>> paramList, kotlin.jvm.b.p<? super SmartThingAction, ? super BaseALIoTDevice<?>, kotlin.p> paramp)
  {
    kotlin.jvm.internal.j.e(paramString, "title");
    kotlin.jvm.internal.j.e(paramSmartThingTrigger, "thingTrigger");
    kotlin.jvm.internal.j.e(paramList, "devices");
    kotlin.jvm.internal.j.e(paramp, "configThingAction");
    paramString = z(paramString);
    Object localObject = C();
    ((SmartTrigger)localObject).setThings(l.h(new SmartThingTrigger[] { paramSmartThingTrigger }));
    paramSmartThingTrigger = kotlin.p.a;
    paramString.setTriggerSetting((SmartTrigger)localObject);
    paramSmartThingTrigger = y();
    localObject = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (BaseALIoTDevice)localIterator.next();
      SmartThingAction localSmartThingAction = A(paramList);
      paramp.invoke(localSmartThingAction, paramList);
      ((List)localObject).add(localSmartThingAction);
    }
    paramSmartThingTrigger.setThings((List)localObject);
    paramString.setActionSetting(paramSmartThingTrigger);
    return paramString;
  }
  
  protected final byte l(String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "days");
    int m;
    try
    {
      m = Integer.parseInt(paramString, kotlin.text.a.a(2));
    }
    catch (Exception paramString)
    {
      m = 127;
    }
    return (byte)m;
  }
  
  public final LiveData<List<BaseALIoTDevice<?>>> m()
  {
    return this.f;
  }
  
  protected final f n()
  {
    return new d(this);
  }
  
  public final LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> o()
  {
    return this.i;
  }
  
  public final LiveData<List<com.tplink.iot.g.a.a.b>> r()
  {
    return this.l;
  }
  
  protected final ALIoTDevice s()
  {
    return this.e;
  }
  
  protected final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> t()
  {
    return this.h;
  }
  
  protected final SmartRepository u()
  {
    return (SmartRepository)this.d.b(this, a[2]);
  }
  
  protected final TPIoTClientManager v()
  {
    return (TPIoTClientManager)this.c.b(this, a[1]);
  }
  
  protected final ThingCloudRepository w()
  {
    return (ThingCloudRepository)this.b.b(this, a[0]);
  }
  
  public final ThingModel x(BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    Object localObject1 = null;
    if (paramBaseALIoTDevice == null) {
      return null;
    }
    Object localObject2 = TPIoTClientManager.k2(paramBaseALIoTDevice.getDeviceIdMD5());
    kotlin.jvm.internal.j.d(localObject2, "thingContext");
    paramBaseALIoTDevice = ((ThingContext)localObject2).getThingModel();
    if (paramBaseALIoTDevice == null)
    {
      localObject2 = ((ThingContext)localObject2).getThingDevice();
      paramBaseALIoTDevice = (BaseALIoTDevice<?>)localObject1;
      if (localObject2 != null)
      {
        localObject2 = ((ThingDevice)localObject2).getThingModelId();
        paramBaseALIoTDevice = (BaseALIoTDevice<?>)localObject1;
        if (localObject2 != null) {
          paramBaseALIoTDevice = w().m0((String)localObject2);
        }
      }
    }
    return paramBaseALIoTDevice;
  }
  
  protected final SmartAction y()
  {
    SmartAction localSmartAction = new SmartAction();
    localSmartAction.setSmarts(null);
    localSmartAction.setThings(null);
    return localSmartAction;
  }
  
  protected final SmartInfo z(String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "title");
    SmartInfo localSmartInfo = new SmartInfo();
    localSmartInfo.setId(u().O());
    localSmartInfo.setName(paramString);
    localSmartInfo.setAvatarUrl(SmartRepository.h[1]);
    localSmartInfo.setEnabled(true);
    paramString = new SmartLocation();
    Object localObject = TimeZone.getDefault();
    kotlin.jvm.internal.j.d(localObject, "timezone");
    paramString.setRegion(((TimeZone)localObject).getID());
    paramString.setTimeDiff(Integer.valueOf(((TimeZone)localObject).getRawOffset() / 1000 / 60));
    localObject = kotlin.p.a;
    localSmartInfo.setAppLocationInfo(paramString);
    localSmartInfo.setEffectivePeriod(new SmartPeriodSetting("ALL_DAY", (byte)127));
    return localSmartInfo;
  }
  
  public static final class a
    implements kotlin.t.c<Object, ThingCloudRepository>
  {
    private final ThingCloudRepository a;
    
    public a()
    {
      b.d.b.f.a locala = b.d.b.f.b.a(b.d.s.a.a.f(), ThingCloudRepository.class);
      kotlin.jvm.internal.j.d(locala, "CloudRepositoryProviders…text(), REPO::class.java)");
      this.a = locala;
    }
    
    public ThingCloudRepository c(Object paramObject, kotlin.reflect.j<?> paramj)
    {
      kotlin.jvm.internal.j.e(paramObject, "thisRef");
      kotlin.jvm.internal.j.e(paramj, "property");
      return this.a;
    }
  }
  
  public static final class b
    implements kotlin.t.c<Object, TPIoTClientManager>
  {
    private final TPIoTClientManager a;
    
    public b()
    {
      b.d.b.f.a locala = b.d.b.f.b.a(b.d.s.a.a.f(), TPIoTClientManager.class);
      kotlin.jvm.internal.j.d(locala, "CloudRepositoryProviders…text(), REPO::class.java)");
      this.a = locala;
    }
    
    public TPIoTClientManager c(Object paramObject, kotlin.reflect.j<?> paramj)
    {
      kotlin.jvm.internal.j.e(paramObject, "thisRef");
      kotlin.jvm.internal.j.e(paramj, "property");
      return this.a;
    }
  }
  
  public static final class c
    implements kotlin.t.c<Object, SmartRepository>
  {
    private final SmartRepository a;
    
    public c()
    {
      b.d.b.f.a locala = b.d.b.f.b.a(b.d.s.a.a.f(), SmartRepository.class);
      kotlin.jvm.internal.j.d(locala, "CloudRepositoryProviders…text(), REPO::class.java)");
      this.a = locala;
    }
    
    public SmartRepository c(Object paramObject, kotlin.reflect.j<?> paramj)
    {
      kotlin.jvm.internal.j.e(paramObject, "thisRef");
      kotlin.jvm.internal.j.e(paramj, "property");
      return this.a;
    }
  }
  
  static final class d
    implements f
  {
    d(AbstractFeaturedActionViewModel paramAbstractFeaturedActionViewModel) {}
    
    public final e a(io.reactivex.a parama)
    {
      kotlin.jvm.internal.j.e(parama, "upstream");
      return parama.l(new a(this)).i(new b(this)).j(new c(this));
    }
    
    static final class a<T>
      implements io.reactivex.g0.g<io.reactivex.e0.c>
    {
      a(AbstractFeaturedActionViewModel.d paramd) {}
      
      public final void a(io.reactivex.e0.c paramc)
      {
        this.c.a.t().postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(100)));
      }
    }
    
    static final class b
      implements io.reactivex.g0.a
    {
      b(AbstractFeaturedActionViewModel.d paramd) {}
      
      public final void run()
      {
        this.a.a.t().postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(200)));
      }
    }
    
    static final class c<T>
      implements io.reactivex.g0.g<Throwable>
    {
      c(AbstractFeaturedActionViewModel.d paramd) {}
      
      public final void a(Throwable paramThrowable)
      {
        this.c.a.t().postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(300)));
      }
    }
  }
  
  static final class e<T>
    implements io.reactivex.g0.g<ThingFirmware>
  {
    e(AbstractFeaturedActionViewModel paramAbstractFeaturedActionViewModel, com.tplink.iot.g.a.a.b paramb) {}
    
    public final void a(ThingFirmware paramThingFirmware)
    {
      paramb.d(paramThingFirmware);
      AbstractFeaturedActionViewModel.f(this.c);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\featuredactions\viewmodel\base\AbstractFeaturedActionViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */