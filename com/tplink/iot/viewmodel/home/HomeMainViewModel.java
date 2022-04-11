package com.tplink.iot.viewmodel.home;

import android.annotation.SuppressLint;
import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.tplink.cloud.bean.account.result.TopicSubscriptionResult;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.cloud.bean.cloudvideo.common.CloudVideo;
import com.tplink.iot.cloud.bean.common.AsyncResult;
import com.tplink.iot.cloud.bean.family.common.FamilyInfo;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.cloud.bean.share.EnumDeviceShareRole;
import com.tplink.iot.cloud.bean.share.EnumDeviceShareStatus;
import com.tplink.iot.cloud.bean.share.result.ShareDeviceResult;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartTrigger;
import com.tplink.iot.cloud.bean.thing.common.NextEvent;
import com.tplink.iot.cloud.bean.thing.common.ThingNextEvent;
import com.tplink.iot.cloud.exception.IoTCloudException;
import com.tplink.iot.model.home.d;
import com.tplink.iot.model.notification.NotificationCenterManager;
import com.tplink.libmediaapi.live.LiveMediaAPI;
import com.tplink.libtpgoogleassistant.repository.OAuthCloudRepository;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.RunShortCutResultBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.group.GroupBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.DeviceShareRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.GroupRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.QuickDiscoveryRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.SmartRepository;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.CloudVideoRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyManagerRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyManagerRepository.p;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.NBUCloudRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCAccountRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCDeviceRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.FirmwareManager;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.u;
import com.tplink.libtpnetwork.enumerate.EnumHomeState;
import com.tplink.libtpnetwork.enumerate.EnumLoginResult;
import io.reactivex.e0.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HomeMainViewModel
  extends HomeBaseViewModel
  implements FamilyManagerRepository.p
{
  private SmartRepository H3;
  private CloudVideoRepository I3;
  private NotificationCenterManager J3;
  private com.tplink.iot.view.home.f0.a K3;
  private QuickDiscoveryRepository L3;
  private Map<String, com.tplink.iot.model.home.k> M3 = new HashMap();
  private List<com.tplink.iot.model.home.k> N3 = new ArrayList();
  private List<com.tplink.iot.model.home.k> O3 = new ArrayList();
  private List<String> P3 = new ArrayList();
  private Map<String, com.tplink.iot.model.home.g> Q3 = new LinkedHashMap();
  private List<com.tplink.iot.model.home.g> R3 = new ArrayList();
  private List<com.tplink.iot.model.home.g> S3 = new ArrayList();
  private boolean T3 = false;
  private EnumHomeState U3;
  private int V3 = 0;
  private boolean W3;
  private boolean X3;
  private c Y3 = null;
  private c Z3 = null;
  private c a4 = null;
  private c b4 = null;
  private c c4 = null;
  private MediatorLiveData<EnumHomeState> d4 = new MediatorLiveData();
  private MediatorLiveData<List<com.tplink.iot.model.home.e>> e4 = new MediatorLiveData();
  private MediatorLiveData<FamilyInfo> f4 = new MediatorLiveData();
  private MediatorLiveData<Boolean> g4 = new MediatorLiveData();
  private MediatorLiveData<List<com.tplink.iot.model.home.e>> h4 = new MediatorLiveData();
  private MediatorLiveData<Boolean> i4 = new MediatorLiveData();
  private MutableLiveData<Boolean> j4 = new MutableLiveData();
  private MediatorLiveData<Boolean> k4 = new MediatorLiveData();
  private MediatorLiveData<List<SmartInfo>> l4 = new MediatorLiveData();
  private MediatorLiveData<ThingNextEvent> m4 = new MediatorLiveData();
  private SingleLiveEvent<RunShortCutResultBean> n4 = new SingleLiveEvent();
  private MutableLiveData<Boolean> o4 = new MutableLiveData();
  private NBUCloudRepository p0;
  private TCDeviceRepository p1;
  private DeviceShareRepository p2;
  private OAuthCloudRepository p3;
  private MediatorLiveData<Boolean> p4 = new MediatorLiveData();
  private MediatorLiveData<Boolean> q4 = new MediatorLiveData();
  private MediatorLiveData<Boolean> r4 = new MediatorLiveData();
  private MediatorLiveData<Boolean> s4 = new MediatorLiveData();
  private MediatorLiveData<Boolean> t4 = new MediatorLiveData();
  private MediatorLiveData<Boolean> u4 = new MediatorLiveData();
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> v4 = new MutableLiveData();
  private TCAccountRepository z;
  
  public HomeMainViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    paramApplication = b.d.s.a.a.f();
    this.z = ((TCAccountRepository)b.d.b.f.b.a(paramApplication, TCAccountRepository.class));
    this.p0 = ((NBUCloudRepository)b.d.b.f.b.a(paramApplication, NBUCloudRepository.class));
    this.H3 = ((SmartRepository)b.d.b.f.b.a(paramApplication, SmartRepository.class));
    this.p1 = ((TCDeviceRepository)b.d.b.f.b.a(paramApplication, TCDeviceRepository.class));
    this.p2 = ((DeviceShareRepository)b.d.b.f.b.a(paramApplication, DeviceShareRepository.class));
    this.I3 = ((CloudVideoRepository)b.d.b.f.b.a(paramApplication, CloudVideoRepository.class));
    this.J3 = ((NotificationCenterManager)b.d.b.f.b.a(paramApplication, NotificationCenterManager.class));
    this.p3 = ((OAuthCloudRepository)b.d.b.f.b.a(paramApplication, OAuthCloudRepository.class));
    this.L3 = ((QuickDiscoveryRepository)b.d.b.f.b.a(paramApplication, QuickDiscoveryRepository.class));
    this.K3 = com.tplink.iot.view.home.f0.a.h();
    EnumHomeState localEnumHomeState = X0();
    this.U3 = localEnumHomeState;
    this.d4.postValue(localEnumHomeState);
    this.h4.addSource(this.x.d(), new k());
    this.d4.addSource(this.c.X1(), new v());
    this.f4.addSource(this.d.c0(), new b0());
    this.f4.addSource(this.d.a0(), new c0());
    this.e4.addSource(this.c.C1(), new d0());
    this.e4.addSource(this.q.T(), new e0());
    this.r4.addSource(this.c.o2(), new f0());
    this.l4.addSource(this.H3.P(), new g0());
    this.r4.addSource(this.x.e(), new h0());
    this.s4.addSource(this.J3.x(), new a());
    this.t4.addSource(this.c.e2(), new b());
    H0().removeSource(this.L3.z());
    H0().addSource(this.L3.z(), new c());
    this.u4.addSource(this.L3.y(), new d());
    F0().removeSource(this.I3.X());
    F0().addSource(this.I3.X(), new n(this));
    this.x.f();
    if ((paramApplication.c() != null) && (!TextUtils.isEmpty(paramApplication.c().getToken()))) {
      this.p3.e(paramApplication.c().getToken()).F0();
    }
    this.d.a1(this);
  }
  
  private void A0()
  {
    this.J3.u();
  }
  
  private List<com.tplink.iot.model.home.e> M0()
  {
    if (k1())
    {
      if (this.P3.isEmpty()) {
        return O0();
      }
      return N0();
    }
    ArrayList localArrayList = new ArrayList(this.N3);
    t.g(localArrayList);
    return new ArrayList(localArrayList);
  }
  
  private List<com.tplink.iot.model.home.e> N0()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.S3);
    localArrayList.addAll(this.O3);
    t.i(localArrayList, this.P3);
    return localArrayList;
  }
  
  private void N1()
  {
    if (this.T3) {
      this.y.I();
    }
  }
  
  private List<com.tplink.iot.model.home.e> O0()
  {
    ArrayList localArrayList1 = new ArrayList(this.O3);
    t.j(localArrayList1, new ArrayList());
    ArrayList localArrayList2 = new ArrayList(this.S3);
    t.f(localArrayList2);
    localArrayList2 = new ArrayList(localArrayList2);
    localArrayList2.addAll(localArrayList1);
    return localArrayList2;
  }
  
  private void O1(List<SmartInfo> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (SmartInfo)localIterator.next();
        if ((paramList.getTriggerSetting() != null) && (paramList.getTriggerSetting().isManual())) {
          localArrayList.add(paramList);
        }
      }
      this.l4.postValue(localArrayList);
      return;
    }
    this.l4.postValue(new ArrayList());
  }
  
  private void Q1()
  {
    if ((this.T3) && (k1()))
    {
      this.H3.S().F0();
      w0();
    }
  }
  
  private void U0(AsyncResult paramAsyncResult, String paramString)
  {
    paramAsyncResult = com.tplink.iot.view.smart.a.g.d(paramAsyncResult, paramString);
    this.n4.postValue(paramAsyncResult);
  }
  
  private void V0(Throwable paramThrowable, String paramString)
  {
    if ((paramThrowable instanceof IoTCloudException))
    {
      paramThrowable = (IoTCloudException)paramThrowable;
      this.n4.postValue(new RunShortCutResultBean(paramString, paramThrowable.getCode()));
    }
    else
    {
      this.n4.postValue(new RunShortCutResultBean(paramString, -1));
    }
  }
  
  private void W0()
  {
    n2();
    Object localObject1;
    if (k1())
    {
      this.V3 = 0;
      this.N3.clear();
      this.R3.clear();
      this.O3.clear();
      this.S3.clear();
      localObject1 = this.M3.values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tplink.iot.model.home.k)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((com.tplink.iot.model.home.k)localObject2).g() != null))
        {
          if (h((com.tplink.iot.model.home.k)localObject2)) {
            this.N3.add(localObject2);
          }
          if (d1((com.tplink.iot.model.home.k)localObject2)) {
            this.O3.add(localObject2);
          }
          if (c1((com.tplink.iot.model.home.k)localObject2)) {
            this.V3 += 1;
          }
        }
      }
      localObject1 = this.Q3.values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tplink.iot.model.home.g)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((com.tplink.iot.model.home.g)localObject2).h() != null))
        {
          if (i((com.tplink.iot.model.home.g)localObject2)) {
            this.R3.add(localObject2);
          }
          if (e1((com.tplink.iot.model.home.g)localObject2)) {
            this.S3.add(localObject2);
          }
        }
      }
    }
    this.V3 = 0;
    this.N3.clear();
    Object localObject2 = this.M3.values().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (com.tplink.iot.model.home.k)((Iterator)localObject2).next();
      if ((localObject1 != null) && (((com.tplink.iot.model.home.k)localObject1).g() != null))
      {
        this.N3.add(localObject1);
        if (Z0((com.tplink.iot.model.home.k)localObject1)) {
          this.V3 += 1;
        }
      }
    }
  }
  
  private EnumHomeState X0()
  {
    EnumLoginResult localEnumLoginResult = this.c.W1();
    if (localEnumLoginResult == null) {
      return EnumHomeState.NO_INTERNET;
    }
    int i = a0.a[localEnumLoginResult.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return EnumHomeState.NO_INTERNET;
        }
        return EnumHomeState.NO_INTERNET;
      }
      return EnumHomeState.LOCAL_OFFLINE;
    }
    return EnumHomeState.ONLINE;
  }
  
  private void X1()
  {
    if (this.T3)
    {
      e2(0L);
      g2(20L);
    }
  }
  
  private boolean Z0(com.tplink.iot.model.home.k paramk)
  {
    return paramk.g() instanceof ALCameraDevice;
  }
  
  private void b0()
  {
    Boolean localBoolean = (Boolean)r.g().e().getValue();
    if ((localBoolean != null) && (localBoolean.booleanValue())) {
      return;
    }
    this.p2.D(EnumDeviceShareStatus.READY.name(), EnumDeviceShareRole.SHARER.getName(), null).E(new s()).C(new r()).F0();
  }
  
  private boolean c1(com.tplink.iot.model.home.k paramk)
  {
    boolean bool;
    if ((Z0(paramk)) && (h(paramk))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean d1(com.tplink.iot.model.home.k paramk)
  {
    return this.d.h0(paramk.w(), paramk.u(), paramk.q(), paramk.i());
  }
  
  private void d2(final ThingNextEvent paramThingNextEvent, final long paramLong)
  {
    Object localObject = this.b4;
    if (localObject != null) {
      ((c)localObject).dispose();
    }
    localObject = paramThingNextEvent.getNextEvent();
    this.b4 = io.reactivex.q.a0(0L, 1L, TimeUnit.SECONDS).E(new z(paramLong, (NextEvent)localObject, paramThingNextEvent)).F0();
  }
  
  private boolean e1(com.tplink.iot.model.home.g paramg)
  {
    return this.d.i0(paramg.j(), paramg.g());
  }
  
  private void e2(final long paramLong)
  {
    h2();
    this.Y3 = io.reactivex.q.W0(paramLong, TimeUnit.SECONDS).N(new l()).x0(new j(paramLong)).t0(new i(paramLong)).C(new h()).F0();
  }
  
  private void f2(ThingNextEvent paramThingNextEvent)
  {
    i2();
    if ((paramThingNextEvent != null) && (paramThingNextEvent.getNextEvent() != null))
    {
      NextEvent localNextEvent = paramThingNextEvent.getNextEvent();
      if (localNextEvent.getType() == 1) {}
      long l;
      for (int i = localNextEvent.getStartTime();; i = localNextEvent.getEndTime())
      {
        l = i;
        break label87;
        if (localNextEvent.getType() != 3) {
          break;
        }
      }
      if (localNextEvent.getType() == 2)
      {
        l = localNextEvent.getStartTime();
        d2(paramThingNextEvent, l);
      }
      else
      {
        l = 0L;
      }
      label87:
      l -= System.currentTimeMillis() / 1000L;
      if (l > 0L) {
        this.a4 = io.reactivex.q.W0(l, TimeUnit.SECONDS).G0(new y());
      } else {
        this.m4.postValue(new ThingNextEvent());
      }
    }
  }
  
  private void g2(final long paramLong)
  {
    j2();
    this.Z3 = io.reactivex.q.W0(paramLong, TimeUnit.SECONDS).N(new o()).x0(new n(paramLong)).t0(new m(paramLong)).F0();
  }
  
  private void h2()
  {
    c localc = this.Y3;
    if ((localc != null) && (!localc.isDisposed())) {
      this.Y3.dispose();
    }
  }
  
  private void j2()
  {
    c localc = this.Z3;
    if ((localc != null) && (!localc.isDisposed())) {
      this.Z3.dispose();
    }
  }
  
  private boolean m1(List paramList)
  {
    boolean bool;
    if ((paramList != null) && (!paramList.isEmpty())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private io.reactivex.a m2(String paramString, List<String> paramList)
  {
    return this.d.j1(paramString, paramList).C(io.reactivex.l0.a.c());
  }
  
  private void n2()
  {
    this.P3.clear();
    List localList = this.d.b0();
    if (localList != null) {
      this.P3.addAll(localList);
    }
  }
  
  private void o2(@NonNull List<String> paramList)
  {
    if ((g() != null) && (g().getId() != null) && (!paramList.isEmpty())) {
      m2(g().getId(), paramList).i(new j(this, paramList)).j(new l(this)).y();
    }
  }
  
  private void p2(@Nullable List<String> paramList)
  {
    if (k1())
    {
      ArrayList localArrayList = new ArrayList();
      if ((paramList != null) && (!paramList.isEmpty())) {
        localArrayList.addAll(paramList);
      }
      W0();
      paramList = M0().iterator();
      while (paramList.hasNext())
      {
        Object localObject1 = (com.tplink.iot.model.home.e)paramList.next();
        Object localObject2;
        if ((localObject1 instanceof com.tplink.iot.model.home.k))
        {
          localObject2 = (com.tplink.iot.model.home.k)localObject1;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Device-");
          ((StringBuilder)localObject1).append(((com.tplink.iot.model.home.k)localObject2).d());
          localArrayList.add(((StringBuilder)localObject1).toString());
        }
        else if ((localObject1 instanceof com.tplink.iot.model.home.g))
        {
          localObject1 = (com.tplink.iot.model.home.g)localObject1;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Group-");
          ((StringBuilder)localObject2).append(((com.tplink.iot.model.home.g)localObject1).d());
          localArrayList.add(((StringBuilder)localObject2).toString());
        }
      }
      paramList = new StringBuilder();
      paramList.append("updateDeviceGroupCommonSortList commonSortIds: ");
      paramList.append(com.tplink.libtpnetwork.Utils.i.j(localArrayList));
      b.d.w.c.a.n("HomeSort", paramList.toString());
      o2(localArrayList);
    }
  }
  
  private void r2(com.tplink.iot.model.home.f paramf)
  {
    if (paramf == null) {
      return;
    }
    s.c(this.M3, paramf.a());
    W0();
    if (paramf.b()) {
      this.h4.postValue(M0());
    }
  }
  
  private void s2(List<BaseALIoTDevice> paramList)
  {
    EnumHomeState localEnumHomeState = (EnumHomeState)this.c.X1().getValue();
    if (this.M3.isEmpty()) {
      this.x.h();
    }
    s.a(this.M3, paramList);
    v2();
    if (localEnumHomeState == EnumHomeState.ONLINE) {
      this.x.n(new ArrayList(this.M3.values()));
    }
    k();
  }
  
  private void t2(List<GroupInfo> paramList)
  {
    s.b(this.Q3, paramList);
    v2();
    k();
  }
  
  private void v0()
  {
    if ((this.T3) && (k1()))
    {
      this.d.U().z(new f(this)).F0();
      this.q.P().F0();
      this.H3.S().F0();
      this.I3.I().F0();
      this.I3.d0().F0();
    }
  }
  
  private void v2()
  {
    Iterator localIterator = this.Q3.values().iterator();
    while (localIterator.hasNext())
    {
      GroupBean localGroupBean = ((com.tplink.iot.model.home.g)localIterator.next()).h();
      if (localGroupBean != null) {
        localGroupBean.setGroupState(com.tplink.libtpnetwork.Utils.g.j(localGroupBean));
      }
    }
  }
  
  private void w0()
  {
    if ((k1()) && (g() != null) && (g().getId() != null)) {
      this.f.Y(g().getId()).l0(io.reactivex.d0.b.a.a()).E(new q()).C(new p()).F0();
    }
  }
  
  private void w2(Boolean paramBoolean1, Boolean paramBoolean2)
  {
    MediatorLiveData localMediatorLiveData = this.r4;
    boolean bool;
    if (((paramBoolean1 != null) && (paramBoolean1.booleanValue())) || ((paramBoolean2 != null) && (paramBoolean2.booleanValue()))) {
      bool = true;
    } else {
      bool = false;
    }
    localMediatorLiveData.postValue(Boolean.valueOf(bool));
  }
  
  public MediatorLiveData<Boolean> B0()
  {
    return this.s4;
  }
  
  public SingleLiveEvent<RunShortCutResultBean> C0()
  {
    return this.n4;
  }
  
  public io.reactivex.q<Boolean> D0(String paramString)
  {
    CameraSettingRepository localCameraSettingRepository = (CameraSettingRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(paramString, CameraSettingRepository.class);
    return io.reactivex.q.f0(com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(paramString, CommonCameraRepository.class)).N(p.c).N(new g(localCameraSettingRepository));
  }
  
  public MediatorLiveData<List<SmartInfo>> E0()
  {
    return this.l4;
  }
  
  public MediatorLiveData<d> F0()
  {
    return this.K3.i();
  }
  
  public LiveData<Boolean> G0()
  {
    return this.K3.j();
  }
  
  public MediatorLiveData<List<TDPIoTDevice>> H0()
  {
    return this.K3.k();
  }
  
  public MediatorLiveData<Boolean> I0()
  {
    return this.q4;
  }
  
  public void I1()
  {
    this.c.d3().C(io.reactivex.l0.a.c()).l(new w()).h(new u()).y();
  }
  
  public LiveData<Boolean> J0()
  {
    return this.K3.l();
  }
  
  public void J1()
  {
    this.L3.C();
  }
  
  public LiveData<Integer> K0()
  {
    return this.K3.m();
  }
  
  public void K1()
  {
    if (!com.tplink.libtpnetwork.Utils.t.a())
    {
      List localList = (List)this.c.C1().getValue();
      if (localList != null) {
        com.tplink.libtpnetwork.Utils.t.c(localList);
      }
    }
  }
  
  public LiveData<TCAccountBean> L0()
  {
    return this.z.w();
  }
  
  public void L1()
  {
    this.W3 = false;
    h2();
    j2();
    LiveMediaAPI.onDetectPipePause();
  }
  
  public void M1()
  {
    this.W3 = true;
    this.X3 = false;
    X1();
    v0();
    b0();
    A0();
    LiveMediaAPI.onDetectPipeResume();
  }
  
  public LiveData<TCAccountBean> P0()
  {
    return this.z.r();
  }
  
  public void P1()
  {
    if (this.T3) {
      e2(0L);
    }
  }
  
  public MutableLiveData<Boolean> Q0()
  {
    return this.H3.n0();
  }
  
  public MediatorLiveData<ThingNextEvent> R0()
  {
    return this.m4;
  }
  
  public void R1()
  {
    X1();
    v0();
    N1();
  }
  
  public MutableLiveData<Boolean> S0()
  {
    return this.o4;
  }
  
  public void S1()
  {
    this.H3.S().F0();
  }
  
  public void T0(int paramInt, List<com.tplink.iot.model.home.e> paramList)
  {
    paramList = (com.tplink.iot.model.home.e)paramList.get(paramInt);
    if ((paramList instanceof com.tplink.iot.model.home.k))
    {
      paramList = (com.tplink.iot.model.home.k)paramList;
      paramList.B(false);
      r(false, paramList.l());
    }
  }
  
  public void T1()
  {
    if (this.T3) {
      this.c.t3(false).F0();
    }
  }
  
  public void U1(List<com.tplink.iot.model.home.e> paramList)
  {
    this.x.i(paramList, true);
  }
  
  public void V1()
  {
    this.x.j();
  }
  
  @SuppressLint({"CheckResult"})
  public void W1(String paramString)
  {
    this.H3.J(paramString).I0(new m(this, paramString), new e(this, paramString), k.a);
  }
  
  public void X()
  {
    this.K3.a();
  }
  
  @SuppressLint({"CheckResult"})
  public void Y(String paramString)
  {
    this.d.N(paramString).l0(io.reactivex.d0.b.a.a()).E(new h(this)).C(new t()).F0();
  }
  
  public boolean Y0()
  {
    boolean bool1 = k1();
    boolean bool2 = false;
    boolean bool3 = false;
    if (bool1)
    {
      localList = this.N3;
      int i;
      if ((localList != null) && (!localList.isEmpty())) {
        i = 0;
      } else {
        i = 1;
      }
      localList = this.R3;
      int j;
      if ((localList != null) && (!localList.isEmpty())) {
        j = 0;
      } else {
        j = 1;
      }
      bool2 = bool3;
      if (i != 0)
      {
        bool2 = bool3;
        if (j != 0) {
          bool2 = true;
        }
      }
      return bool2;
    }
    List localList = this.N3;
    if ((localList == null) || (localList.isEmpty())) {
      bool2 = true;
    }
    return bool2;
  }
  
  public void Y1()
  {
    this.K3.o();
  }
  
  public void Z()
  {
    this.X3 = true;
  }
  
  public void Z1()
  {
    this.K3.p();
  }
  
  public void a(@NonNull List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (String)localIterator.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Device-");
      localStringBuilder.append(paramList);
      localArrayList.add(localStringBuilder.toString());
    }
    p2(localArrayList);
  }
  
  public void a0()
  {
    boolean bool;
    if (this.U3 == EnumHomeState.ONLINE) {
      bool = true;
    } else {
      bool = false;
    }
    io.reactivex.q.f0(Boolean.valueOf(bool)).N(new g()).C(new f()).y(new e()).F0();
  }
  
  public boolean a1()
  {
    boolean bool;
    if (this.V3 == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void a2()
  {
    this.K3.c();
  }
  
  public void b(@NonNull List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (String)localIterator.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Group-");
      localStringBuilder.append(paramList);
      localArrayList.add(localStringBuilder.toString());
    }
    p2(localArrayList);
  }
  
  public boolean b1(FamilyInfo paramFamilyInfo)
  {
    return this.d.g0(paramFamilyInfo);
  }
  
  public void b2()
  {
    this.K3.r();
  }
  
  public List<FamilyInfo> c0()
  {
    return this.d.T();
  }
  
  public void c2(int paramInt)
  {
    this.K3.s(paramInt);
  }
  
  public LiveData<Boolean> d0()
  {
    return this.K3.g();
  }
  
  public void e()
  {
    b.d.w.c.a.n("HomeSort", "onDeviceOrGroupRemoved");
    p2(null);
  }
  
  public void e0(boolean paramBoolean)
  {
    String str1 = b.d.s.a.a.f().c().getAccountId();
    String str2 = com.tplink.iot.Utils.f.b(getApplication());
    if ((str1 != null) && (str2 != null))
    {
      long l1 = com.tplink.libtpnetwork.Utils.o.h0().w(str1);
      long l2 = System.currentTimeMillis();
      if ((paramBoolean) || (l2 - l1 > 54000000L) || (com.tplink.iot.Utils.f.a(new Date(l1), new Date(l2)) >= 1)) {
        this.c4 = this.p0.g(str1, com.tplink.iot.core.n.a, "TP-Link_Tapo_Android", str2.toUpperCase(), paramBoolean ^ true, (int)(l2 / 1000L)).l0(io.reactivex.d0.b.a.a()).H0(new o(this), q.c);
      }
    }
  }
  
  public BaseALIoTDevice f0(String paramString)
  {
    return this.c.Z1(paramString);
  }
  
  public boolean f1()
  {
    boolean bool1 = k1();
    boolean bool2 = false;
    boolean bool3 = false;
    if (bool1)
    {
      localList = this.O3;
      int i;
      if ((localList != null) && (!localList.isEmpty())) {
        i = 0;
      } else {
        i = 1;
      }
      localList = this.S3;
      int j;
      if ((localList != null) && (!localList.isEmpty())) {
        j = 0;
      } else {
        j = 1;
      }
      bool2 = bool3;
      if (i != 0)
      {
        bool2 = bool3;
        if (j != 0) {
          bool2 = true;
        }
      }
      return bool2;
    }
    List localList = this.N3;
    if ((localList == null) || (localList.isEmpty())) {
      bool2 = true;
    }
    return bool2;
  }
  
  public int g0()
  {
    return this.V3;
  }
  
  public boolean g1()
  {
    return this.X3;
  }
  
  public MediatorLiveData<Boolean> h0()
  {
    return this.k4;
  }
  
  public boolean h1()
  {
    return this.d.l0();
  }
  
  public io.reactivex.q<CloudVideo> i0(String paramString1, String paramString2)
  {
    return this.I3.S(paramString1, paramString2).g0(i.c).C(q.c);
  }
  
  public Boolean i1()
  {
    return this.p3.f();
  }
  
  public void i2()
  {
    c localc = this.a4;
    if (localc != null) {
      localc.dispose();
    }
    localc = this.b4;
    if (localc != null) {
      localc.dispose();
    }
  }
  
  public u j0(String paramString)
  {
    FirmwareManager localFirmwareManager = this.y;
    if (localFirmwareManager != null) {
      return localFirmwareManager.g(paramString);
    }
    return null;
  }
  
  public boolean j1()
  {
    boolean bool;
    if (this.U3 == EnumHomeState.NO_INTERNET) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void k()
  {
    W0();
    this.f4.postValue(g());
    this.g4.postValue(Boolean.valueOf(h1()));
    this.e4.postValue(M0());
  }
  
  public LiveData<Boolean> k0()
  {
    return this.i4;
  }
  
  public boolean k1()
  {
    boolean bool;
    if (this.U3 == EnumHomeState.ONLINE) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void k2()
  {
    this.K3.f();
  }
  
  protected void l(String paramString)
  {
    this.M3.remove(paramString);
  }
  
  public LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<BaseALIoTDevice>> l0()
  {
    return this.c.T1();
  }
  
  public boolean l1()
  {
    return this.W3;
  }
  
  public void l2(String paramString1, String paramString2, String paramString3)
  {
    this.z.P(paramString1, paramString2, paramString3).C(io.reactivex.l0.a.c()).r(io.reactivex.d0.b.a.a()).y();
  }
  
  public MediatorLiveData<List<com.tplink.iot.model.home.e>> m0()
  {
    return this.h4;
  }
  
  protected void n(String paramString)
  {
    this.Q3.remove(paramString);
  }
  
  public LiveData<Boolean> n0()
  {
    return this.u4;
  }
  
  public boolean n1(String paramString)
  {
    return this.H3.q0(paramString);
  }
  
  public void o(List<com.tplink.iot.model.home.e> paramList)
  {
    super.o(paramList);
    if (m1(paramList)) {
      return;
    }
    Q1();
  }
  
  public void o0()
  {
    this.I3.W().F0();
  }
  
  public boolean o1()
  {
    return this.K3.b();
  }
  
  protected void onCleared()
  {
    super.onCleared();
    h2();
    Object localObject = this.x;
    if (localObject != null)
    {
      ((r)localObject).c();
      this.x = null;
    }
    localObject = this.c4;
    if ((localObject != null) && (!((c)localObject).isDisposed())) {
      this.c4.dispose();
    }
  }
  
  public void p0(String paramString)
  {
    this.z.x(paramString, "NBU").L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new x()).F0();
  }
  
  public MediatorLiveData<Boolean> q0()
  {
    return this.g4;
  }
  
  @SuppressLint({"CheckResult"})
  public void q2(List<com.tplink.iot.model.home.e> paramList)
  {
    b.d.w.c.a.n("HomeSort", "updateDeviceGroupOrder");
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = (com.tplink.iot.model.home.e)paramList.next();
      Object localObject2;
      if ((localObject1 instanceof com.tplink.iot.model.home.k))
      {
        localObject2 = (com.tplink.iot.model.home.k)localObject1;
        if (d1((com.tplink.iot.model.home.k)localObject2))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Device-");
          ((StringBuilder)localObject1).append(((com.tplink.iot.model.home.k)localObject2).d());
          localArrayList.add(((StringBuilder)localObject1).toString());
        }
      }
      else if ((localObject1 instanceof com.tplink.iot.model.home.g))
      {
        localObject2 = (com.tplink.iot.model.home.g)localObject1;
        if (e1((com.tplink.iot.model.home.g)localObject2))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Group-");
          ((StringBuilder)localObject1).append(((com.tplink.iot.model.home.g)localObject2).d());
          localArrayList.add(((StringBuilder)localObject1).toString());
        }
      }
    }
    o2(localArrayList);
  }
  
  public MediatorLiveData<FamilyInfo> r0()
  {
    return this.f4;
  }
  
  public LiveData<List<com.tplink.iot.model.home.e>> s0()
  {
    return this.e4;
  }
  
  public MediatorLiveData<EnumHomeState> t0()
  {
    return this.d4;
  }
  
  public MediatorLiveData<Boolean> u0()
  {
    return this.t4;
  }
  
  public void u2(String paramString, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("GlobalMarketing", Boolean.valueOf(paramBoolean));
    this.z.a0(paramString, "NBU", localHashMap).C(io.reactivex.l0.a.c()).r(io.reactivex.d0.b.a.a()).y();
  }
  
  protected void v()
  {
    this.x.o(new ArrayList(this.M3.values()), true);
  }
  
  public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> x0()
  {
    return this.v4;
  }
  
  public MutableLiveData<Boolean> y0()
  {
    return this.j4;
  }
  
  public MediatorLiveData<Boolean> z0()
  {
    return this.r4;
  }
  
  class a
    implements Observer<Boolean>
  {
    a() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      HomeMainViewModel.y(HomeMainViewModel.this).postValue(paramBoolean);
    }
  }
  
  class b
    implements Observer<Boolean>
  {
    b() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      HomeMainViewModel.A(HomeMainViewModel.this).postValue(paramBoolean);
    }
  }
  
  class b0
    implements Observer<FamilyInfo>
  {
    b0() {}
    
    public void a(@Nullable FamilyInfo paramFamilyInfo)
    {
      if (paramFamilyInfo != null)
      {
        HomeMainViewModel.Q(HomeMainViewModel.this);
        HomeMainViewModel.this.k();
      }
    }
  }
  
  class c
    implements Observer<List<TDPIoTDevice>>
  {
    c() {}
    
    public void a(List<TDPIoTDevice> paramList)
    {
      HomeMainViewModel.B(HomeMainViewModel.this).q(paramList);
    }
  }
  
  class c0
    implements Observer<List<String>>
  {
    c0() {}
    
    public void a(List<String> paramList)
    {
      if (paramList != null) {
        HomeMainViewModel.this.k();
      }
    }
  }
  
  class d
    implements Observer<List<TDPIoTDevice>>
  {
    d() {}
    
    public void a(List<TDPIoTDevice> paramList)
    {
      if ((paramList != null) && (!paramList.isEmpty())) {
        HomeMainViewModel.C(HomeMainViewModel.this).postValue(Boolean.TRUE);
      } else {
        HomeMainViewModel.C(HomeMainViewModel.this).postValue(Boolean.FALSE);
      }
    }
  }
  
  class d0
    implements Observer<List<BaseALIoTDevice>>
  {
    d0() {}
    
    public void a(@Nullable List<BaseALIoTDevice> paramList)
    {
      HomeMainViewModel.R(HomeMainViewModel.this, paramList);
    }
  }
  
  class e
    implements io.reactivex.g0.a
  {
    e() {}
    
    public void run()
      throws Exception
    {
      if (HomeMainViewModel.D(HomeMainViewModel.this))
      {
        HomeMainViewModel.E(HomeMainViewModel.this, 60L);
        HomeMainViewModel.F(HomeMainViewModel.this, 20L);
      }
      HomeMainViewModel.G(HomeMainViewModel.this, true);
      HomeMainViewModel.A(HomeMainViewModel.this).postValue(Boolean.TRUE);
    }
  }
  
  class e0
    implements Observer<List<GroupInfo>>
  {
    e0() {}
    
    public void a(List<GroupInfo> paramList)
    {
      HomeMainViewModel.S(HomeMainViewModel.this, paramList);
    }
  }
  
  class f
    implements io.reactivex.g0.g<Throwable>
  {
    f() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      HomeMainViewModel.H(HomeMainViewModel.this).postValue(Boolean.TRUE);
    }
  }
  
  class f0
    implements Observer<Boolean>
  {
    f0() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      HomeMainViewModel.T(HomeMainViewModel.this).postValue(paramBoolean);
      HomeMainViewModel localHomeMainViewModel = HomeMainViewModel.this;
      HomeMainViewModel.V(localHomeMainViewModel, paramBoolean, (Boolean)HomeMainViewModel.U(localHomeMainViewModel).getValue());
    }
  }
  
  class g
    implements io.reactivex.g0.j<Boolean, io.reactivex.t<?>>
  {
    g() {}
    
    public io.reactivex.t<?> a(Boolean paramBoolean)
      throws Exception
    {
      if (paramBoolean.booleanValue()) {
        return HomeMainViewModel.this.c.c2(com.tplink.iot.core.n.a());
      }
      return HomeMainViewModel.this.c.b2();
    }
  }
  
  class g0
    implements Observer<List<SmartInfo>>
  {
    g0() {}
    
    public void a(@Nullable List<SmartInfo> paramList)
    {
      HomeMainViewModel.W(HomeMainViewModel.this, paramList);
    }
  }
  
  class h
    implements io.reactivex.g0.g<Throwable>
  {
    h() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      HomeMainViewModel.H(HomeMainViewModel.this).postValue(Boolean.TRUE);
      if (HomeMainViewModel.this.c.u2(paramThrowable)) {
        HomeMainViewModel.this.I1();
      }
    }
  }
  
  class h0
    implements Observer<Boolean>
  {
    h0() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      HomeMainViewModel.U(HomeMainViewModel.this).postValue(paramBoolean);
      HomeMainViewModel localHomeMainViewModel = HomeMainViewModel.this;
      HomeMainViewModel.V(localHomeMainViewModel, (Boolean)HomeMainViewModel.T(localHomeMainViewModel).getValue(), paramBoolean);
    }
  }
  
  class i
    implements io.reactivex.g0.j<io.reactivex.q<Object>, io.reactivex.t<?>>
  {
    i(long paramLong) {}
    
    public io.reactivex.t<?> a(io.reactivex.q<Object> paramq)
      throws Exception
    {
      return paramq.o(60L - paramLong, TimeUnit.SECONDS);
    }
  }
  
  class j
    implements io.reactivex.g0.j<io.reactivex.q<Throwable>, io.reactivex.t<Boolean>>
  {
    j(long paramLong) {}
    
    public io.reactivex.t<Boolean> a(io.reactivex.q<Throwable> paramq)
      throws Exception
    {
      return paramq.N(new a());
    }
    
    class a
      implements io.reactivex.g0.j<Throwable, io.reactivex.t<Boolean>>
    {
      a() {}
      
      public io.reactivex.t<Boolean> a(Throwable paramThrowable)
        throws Exception
      {
        if (HomeMainViewModel.this.c.u2(paramThrowable)) {
          return io.reactivex.q.J(paramThrowable);
        }
        return io.reactivex.q.f0(Boolean.TRUE).o(60L - HomeMainViewModel.j.this.c, TimeUnit.SECONDS);
      }
    }
  }
  
  class k
    implements Observer<com.tplink.iot.model.home.f>
  {
    k() {}
    
    public void a(@Nullable com.tplink.iot.model.home.f paramf)
    {
      HomeMainViewModel.w(HomeMainViewModel.this, paramf);
    }
  }
  
  class l
    implements io.reactivex.g0.j<Long, io.reactivex.t<Boolean>>
  {
    l() {}
    
    public io.reactivex.t<Boolean> a(Long paramLong)
      throws Exception
    {
      if (HomeMainViewModel.x(HomeMainViewModel.this) == EnumHomeState.ONLINE) {
        return HomeMainViewModel.this.c.p3(com.tplink.iot.core.n.a(), HomeMainViewModel.this.j());
      }
      return HomeMainViewModel.this.c.o3(com.tplink.iot.core.n.a(), HomeMainViewModel.this.j());
    }
  }
  
  class m
    implements io.reactivex.g0.j<io.reactivex.q<Object>, io.reactivex.t<?>>
  {
    m(long paramLong) {}
    
    public io.reactivex.t<?> a(io.reactivex.q<Object> paramq)
      throws Exception
    {
      return paramq.o(20L - paramLong, TimeUnit.SECONDS);
    }
  }
  
  class n
    implements io.reactivex.g0.j<io.reactivex.q<Throwable>, io.reactivex.t<Boolean>>
  {
    n(long paramLong) {}
    
    public io.reactivex.t<Boolean> a(io.reactivex.q<Throwable> paramq)
      throws Exception
    {
      return paramq.N(new a());
    }
    
    class a
      implements io.reactivex.g0.j<Throwable, io.reactivex.t<Boolean>>
    {
      a() {}
      
      public io.reactivex.t<Boolean> a(Throwable paramThrowable)
        throws Exception
      {
        return io.reactivex.q.f0(Boolean.TRUE).o(20L - HomeMainViewModel.n.this.c, TimeUnit.SECONDS);
      }
    }
  }
  
  class o
    implements io.reactivex.g0.j<Long, io.reactivex.t<Boolean>>
  {
    o() {}
    
    public io.reactivex.t<Boolean> a(Long paramLong)
      throws Exception
    {
      return HomeMainViewModel.this.c.q3();
    }
  }
  
  class p
    implements io.reactivex.g0.g<Throwable>
  {
    p() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      HomeMainViewModel.I(HomeMainViewModel.this).postValue(new ThingNextEvent());
      HomeMainViewModel.this.i2();
    }
  }
  
  class q
    implements io.reactivex.g0.g<ThingNextEvent>
  {
    q() {}
    
    public void a(ThingNextEvent paramThingNextEvent)
      throws Exception
    {
      HomeMainViewModel.I(HomeMainViewModel.this).postValue(paramThingNextEvent);
      HomeMainViewModel.K(HomeMainViewModel.this, paramThingNextEvent);
    }
  }
  
  class r
    implements io.reactivex.g0.g<Throwable>
  {
    r() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      r.g().p(null);
    }
  }
  
  class s
    implements io.reactivex.g0.g<List<ShareDeviceResult>>
  {
    s() {}
    
    public void a(List<ShareDeviceResult> paramList)
      throws Exception
    {
      r.g().p(paramList);
    }
  }
  
  class t
    implements io.reactivex.g0.g<Throwable>
  {
    t() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      HomeMainViewModel.this.k();
      HomeMainViewModel.L(HomeMainViewModel.this).postValue(Boolean.FALSE);
    }
  }
  
  class u
    implements io.reactivex.g0.a
  {
    u() {}
    
    public void run()
      throws Exception
    {
      HomeMainViewModel.M(HomeMainViewModel.this).postValue(Boolean.TRUE);
    }
  }
  
  class v
    implements Observer<EnumHomeState>
  {
    v() {}
    
    public void a(@Nullable EnumHomeState paramEnumHomeState)
    {
      if (HomeMainViewModel.x(HomeMainViewModel.this) != paramEnumHomeState)
      {
        HomeMainViewModel.z(HomeMainViewModel.this, paramEnumHomeState);
        HomeMainViewModel.J(HomeMainViewModel.this).postValue(paramEnumHomeState);
        HomeMainViewModel.this.k();
      }
    }
  }
  
  class w
    implements io.reactivex.g0.g<c>
  {
    w() {}
    
    public void a(c paramc)
      throws Exception
    {
      HomeMainViewModel.M(HomeMainViewModel.this).postValue(null);
    }
  }
  
  class x
    implements io.reactivex.g0.g<TopicSubscriptionResult>
  {
    x() {}
    
    public void a(TopicSubscriptionResult paramTopicSubscriptionResult)
    {
      if ((paramTopicSubscriptionResult != null) && (paramTopicSubscriptionResult.getTopicSubscription() != null))
      {
        paramTopicSubscriptionResult = (Boolean)paramTopicSubscriptionResult.getTopicSubscription().get("GlobalMarketing");
        if (paramTopicSubscriptionResult != null) {
          HomeMainViewModel.N(HomeMainViewModel.this).setValue(paramTopicSubscriptionResult);
        } else {
          HomeMainViewModel.N(HomeMainViewModel.this).setValue(Boolean.FALSE);
        }
      }
    }
  }
  
  class y
    implements io.reactivex.g0.g<Long>
  {
    y() {}
    
    public void a(Long paramLong)
      throws Exception
    {
      HomeMainViewModel.Q(HomeMainViewModel.this);
      if (HomeMainViewModel.O(HomeMainViewModel.this) != null) {
        HomeMainViewModel.O(HomeMainViewModel.this).dispose();
      }
    }
  }
  
  class z
    implements io.reactivex.g0.g<Long>
  {
    z(long paramLong, NextEvent paramNextEvent, ThingNextEvent paramThingNextEvent) {}
    
    public void a(Long paramLong)
      throws Exception
    {
      long l1 = System.currentTimeMillis() / 1000L;
      long l2 = paramLong;
      if (l1 > l2)
      {
        HomeMainViewModel.I(HomeMainViewModel.this).postValue(new ThingNextEvent());
        if (HomeMainViewModel.P(HomeMainViewModel.this) != null) {
          HomeMainViewModel.P(HomeMainViewModel.this).dispose();
        }
      }
      else
      {
        paramThingNextEvent.setEndTime((int)(l2 - System.currentTimeMillis() / 1000L));
        HomeMainViewModel.I(HomeMainViewModel.this).postValue(this.f);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\home\HomeMainViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */