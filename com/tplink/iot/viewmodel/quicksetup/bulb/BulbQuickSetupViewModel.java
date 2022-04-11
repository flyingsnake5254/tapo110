package com.tplink.iot.viewmodel.quicksetup.bulb;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.Utils.v;
import com.tplink.iot.cloud.bean.family.common.FamilyInfo;
import com.tplink.iot.cloud.bean.family.common.RoomInfo;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.view.quicksetup.bulb.utils.QuickSetupInfoBundle;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.IoTDataWrapper;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.ComponentBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.DeviceTimeParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.InheritInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.LoginAccountParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.QuickSetupDeviceInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.QuickSetupExtraInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.QuickSetupInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.UserNameParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.WirelessInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.InheritInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.QuickSetupComponentResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.QuickSetupInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.WirelessScanInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.QuickDiscoveryRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.QuickSetupRepository;
import com.tplink.libtpnetwork.IoTNetwork.u;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyManagerRepository;
import com.tplink.libtpnetwork.Utils.e0;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.exception.IoTTransportException;
import io.reactivex.g0.g;
import io.reactivex.g0.j;
import io.reactivex.g0.l;
import io.reactivex.q;
import io.reactivex.r;
import io.reactivex.s;
import io.reactivex.t;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BulbQuickSetupViewModel
  extends AndroidViewModel
{
  private QuickSetupRepository a;
  private TPIoTClientManager b = (TPIoTClientManager)b.d.b.f.b.a(b.d.s.a.a.f(), TPIoTClientManager.class);
  private FamilyManagerRepository c;
  private QuickDiscoveryRepository d;
  private MediatorLiveData<i<QuickSetupComponentResult>> e = new MediatorLiveData();
  private MediatorLiveData<i<List<WirelessScanInfoBean>>> f = new MediatorLiveData();
  private MediatorLiveData<i<QuickSetupInfoResult>> g = new MediatorLiveData();
  private MediatorLiveData<i<InheritInfoResult>> h = new MediatorLiveData();
  private MediatorLiveData<i<Boolean>> i = new MediatorLiveData();
  private MediatorLiveData<i<Boolean>> j = new MediatorLiveData();
  private MutableLiveData<Integer> k = new MutableLiveData();
  private io.reactivex.e0.c l;
  private io.reactivex.e0.c m;
  private io.reactivex.e0.c n;
  private io.reactivex.m0.e<Integer> o;
  private boolean p;
  private boolean q;
  private String r = EnumDeviceType.BULB.getDeviceType();
  private String s = null;
  private int t;
  
  public BulbQuickSetupViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    this.c = ((FamilyManagerRepository)b.d.b.f.b.a(b.d.s.a.a.f(), FamilyManagerRepository.class));
    this.d = ((QuickDiscoveryRepository)b.d.b.f.b.a(b.d.s.a.a.f(), QuickDiscoveryRepository.class));
  }
  
  public BulbQuickSetupViewModel(Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    this.a = ((QuickSetupRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(paramThingContext, QuickSetupRepository.class));
    this.c = ((FamilyManagerRepository)b.d.b.f.b.a(b.d.s.a.a.f(), FamilyManagerRepository.class));
    this.d = ((QuickDiscoveryRepository)b.d.b.f.b.a(b.d.s.a.a.f(), QuickDiscoveryRepository.class));
  }
  
  private void E0(InheritInfoParams paramInheritInfoParams, final QuickSetupInfoParams paramQuickSetupInfoParams)
  {
    QuickSetupRepository localQuickSetupRepository = this.a;
    if (localQuickSetupRepository == null)
    {
      this.g.postValue(new i(1, null));
      return;
    }
    localQuickSetupRepository.x5(paramInheritInfoParams).D(10L, TimeUnit.SECONDS).r(io.reactivex.d0.b.a.a()).i(new a(paramQuickSetupInfoParams)).j(new g0(paramQuickSetupInfoParams)).y();
  }
  
  @SuppressLint({"CheckResult"})
  private void F0(QuickSetupInfoParams paramQuickSetupInfoParams)
  {
    QuickSetupRepository localQuickSetupRepository = this.a;
    if (localQuickSetupRepository == null)
    {
      this.g.postValue(new i(1, null));
      return;
    }
    localQuickSetupRepository.z5(paramQuickSetupInfoParams).T0(15L, TimeUnit.SECONDS).E(new c()).C(new b()).F0();
  }
  
  private void G()
  {
    io.reactivex.e0.c localc = this.m;
    if ((localc != null) && (!localc.isDisposed())) {
      this.m.dispose();
    }
    localc = this.n;
    if ((localc != null) && (!localc.isDisposed())) {
      this.n.dispose();
    }
  }
  
  private void H()
  {
    io.reactivex.e0.c localc = this.l;
    if ((localc != null) && (!localc.isDisposed())) {
      this.l.dispose();
    }
  }
  
  private void H0(final String paramString, final boolean paramBoolean)
  {
    this.l = q.f0(Boolean.valueOf(i0())).N(new t(paramString)).N(new s(paramBoolean)).l0(io.reactivex.d0.b.a.a()).H0(new q(), new r());
  }
  
  private void I()
  {
    this.q = true;
    P(3);
  }
  
  private void I0(boolean paramBoolean)
  {
    int i1 = 1;
    this.p = true;
    if (!paramBoolean) {
      i1 = 2;
    }
    P(i1);
  }
  
  private q<Boolean> J(String paramString)
  {
    return this.b.u1(paramString);
  }
  
  private q<Boolean> K(String paramString)
  {
    return q.W0(10L, TimeUnit.SECONDS).N(new d(this, paramString));
  }
  
  private void L(String paramString, r<i<Boolean>> paramr)
  {
    i locali = new i(0, Boolean.FALSE);
    paramString = K(paramString).s0(new a(locali, paramr)).E(new e(locali, paramr));
    paramr.getClass();
    this.n = paramString.C(new f(paramr)).L0(io.reactivex.l0.a.c()).F0();
  }
  
  private q<i<Boolean>> M(final String paramString)
  {
    return q.m(new z(paramString));
  }
  
  private void N(String paramString)
  {
    if (this.a == null)
    {
      q0(546);
      return;
    }
    this.m = M(paramString).L(new y()).T0(150L, TimeUnit.SECONDS).E(new x()).C(new w()).F0();
  }
  
  private void P(int paramInt)
  {
    io.reactivex.m0.e locale = this.o;
    if ((locale != null) && (!locale.j1()))
    {
      this.o.onNext(Integer.valueOf(paramInt));
      this.o.onComplete();
      if (!this.p) {
        H();
      }
      if (!this.q) {
        G();
      }
    }
  }
  
  private q<List<ComponentBean>> Q(final ThingContext paramThingContext)
  {
    this.t = 0;
    QuickSetupRepository localQuickSetupRepository = (QuickSetupRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(paramThingContext, QuickSetupRepository.class);
    return q.f1(localQuickSetupRepository.q5(), localQuickSetupRepository.g1(), new c(this, paramThingContext)).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).x0(new n(paramThingContext)).C(new m());
  }
  
  private String T()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((com.tplink.libtpnetwork.IoTNetwork.repository.kb.c)localObject).b() != null) && (((ThingContext)this.a.b()).getIoTDevice() != null))
    {
      localObject = ((ALIoTDevice)((ThingContext)this.a.b()).getIoTDevice()).getDeviceId();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        return (String)localObject;
      }
    }
    return this.s;
  }
  
  private q<i<Boolean>> X()
  {
    return this.a.o5().g0(new u());
  }
  
  private boolean g0(Throwable paramThrowable)
  {
    boolean bool;
    if ((!(paramThrowable instanceof ConnectException)) && (!(paramThrowable instanceof IoTTransportException)) && (!(paramThrowable instanceof TimeoutException)) && (!(paramThrowable instanceof InterruptedIOException))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private boolean h0(QuickSetupInfoBundle paramQuickSetupInfoBundle)
  {
    boolean bool;
    if ((paramQuickSetupInfoBundle != null) && (com.tplink.iot.view.quicksetup.base.d.B(paramQuickSetupInfoBundle.getComponentResult()) > 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean i0()
  {
    return e0.c(getApplication());
  }
  
  private void q0(int paramInt)
  {
    this.q = true;
    r0(paramInt);
  }
  
  private void r0(int paramInt)
  {
    if ((this.p) && (this.q))
    {
      io.reactivex.m0.e locale = this.o;
      if ((locale != null) && (!locale.j1()))
      {
        this.o.onNext(Integer.valueOf(0));
        this.o.onComplete();
      }
    }
  }
  
  private void s0()
  {
    this.p = true;
    r0(543);
  }
  
  private q<List<ComponentBean>> w0(String paramString)
  {
    return this.b.P3(AppContext.c, 180, paramString).l0(io.reactivex.d0.b.a.a()).g0(new l()).N(new j());
  }
  
  @SuppressLint({"CheckResult"})
  private void z0(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = R().iterator();
    while (((Iterator)localObject).hasNext())
    {
      RoomInfo localRoomInfo = (RoomInfo)((Iterator)localObject).next();
      if (TextUtils.equals(localRoomInfo.getName(), paramString2))
      {
        localObject = localRoomInfo.getId();
        bool = false;
        break label64;
      }
    }
    localObject = null;
    boolean bool = true;
    label64:
    this.c.b1(paramString3, paramString1, (String)localObject, paramString2, bool, true).y();
  }
  
  @SuppressLint({"CheckResult"})
  public void A0(final String paramString)
  {
    final String str1;
    if (this.b.Q1() != null) {
      str1 = this.b.Q1().getId();
    } else {
      str1 = null;
    }
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(paramString)))
    {
      String str2 = T();
      if (TextUtils.isEmpty(str2))
      {
        b.d.w.c.a.d("setDeviceFamilyAndRoom2Cloud TDP find");
        this.a.q5().G0(new o(str1, paramString));
      }
      else
      {
        b.d.w.c.a.d("setDeviceFamilyAndRoom2Cloud cloud find");
        z0(str1, paramString, str2);
      }
      return;
    }
    b.d.w.c.a.d("setDeviceFamilyAndRoom2Cloud return");
  }
  
  public void B0(String paramString)
  {
    this.r = com.tplink.iot.view.quicksetup.bulb.utils.b.l(paramString).getDeviceType();
  }
  
  public void C0(QuickSetupInfoBundle paramQuickSetupInfoBundle, QuickSetupInfoParams paramQuickSetupInfoParams)
  {
    if (this.a == null)
    {
      this.g.postValue(new i(1, null));
      return;
    }
    if (paramQuickSetupInfoBundle.inNeedDisplayInherit()) {
      E0(new InheritInfoParams(paramQuickSetupInfoBundle.isSelectFollowInherit()), paramQuickSetupInfoParams);
    } else {
      F0(paramQuickSetupInfoParams);
    }
  }
  
  public void D()
  {
    String str = T();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("addDeviceToCurrentFamilyCommonSortList deviceId: ");
    localStringBuilder.append(str);
    b.d.w.c.a.n("HomeSort", localStringBuilder.toString());
    if (!TextUtils.isEmpty(str)) {
      this.c.O0(Collections.singletonList(str));
    }
  }
  
  public void D0(final InheritInfoParams paramInheritInfoParams)
  {
    QuickSetupRepository localQuickSetupRepository = this.a;
    if (localQuickSetupRepository == null)
    {
      this.i.postValue(new i(1, Boolean.valueOf(paramInheritInfoParams.isInherit())));
      return;
    }
    localQuickSetupRepository.x5(paramInheritInfoParams).r(io.reactivex.d0.b.a.a()).i(new g(paramInheritInfoParams)).j(new f(paramInheritInfoParams)).y();
  }
  
  public QuickSetupInfoParams E(Context paramContext, WirelessInfoParams paramWirelessInfoParams, QuickSetupInfoBundle paramQuickSetupInfoBundle)
  {
    QuickSetupInfoParams localQuickSetupInfoParams = new QuickSetupInfoParams();
    localQuickSetupInfoParams.setWireless(paramWirelessInfoParams);
    localQuickSetupInfoParams.setTime(S(paramQuickSetupInfoBundle));
    LoginAccountParams localLoginAccountParams = new LoginAccountParams();
    paramWirelessInfoParams = b.d.s.a.a.f();
    Object localObject = "";
    if ((paramWirelessInfoParams != null) && (b.d.s.a.a.f().c() != null))
    {
      TCAccountBean localTCAccountBean = b.d.s.a.a.f().c();
      if ((localTCAccountBean != null) && (localTCAccountBean.getCloudUserName() != null)) {
        paramWirelessInfoParams = localTCAccountBean.getCloudUserName();
      } else {
        paramWirelessInfoParams = "";
      }
      paramQuickSetupInfoBundle = (QuickSetupInfoBundle)localObject;
      if (localTCAccountBean != null)
      {
        paramQuickSetupInfoBundle = (QuickSetupInfoBundle)localObject;
        if (localTCAccountBean.getPassword() != null) {
          paramQuickSetupInfoBundle = localTCAccountBean.getPassword();
        }
      }
      localObject = paramWirelessInfoParams;
    }
    else
    {
      paramQuickSetupInfoBundle = "";
    }
    localLoginAccountParams.setUsername((String)localObject);
    localLoginAccountParams.setPassword(paramQuickSetupInfoBundle);
    localQuickSetupInfoParams.setAccount(localLoginAccountParams);
    paramWirelessInfoParams = new QuickSetupExtraInfoParams();
    paramWirelessInfoParams.setSpecs(com.tplink.iot.view.quicksetup.bulb.utils.a.a(paramContext));
    localQuickSetupInfoParams.setExtraInfo(paramWirelessInfoParams);
    return localQuickSetupInfoParams;
  }
  
  public void F()
  {
    H();
    G();
  }
  
  public void G0(QuickSetupDeviceInfoBean paramQuickSetupDeviceInfoBean, int paramInt)
  {
    if (this.a == null)
    {
      b.d.w.c.a.d("setQuickSetupDeviceInfo");
      this.j.postValue(new i(1, null));
      return;
    }
    paramQuickSetupDeviceInfoBean = new QuickSetupDeviceInfoBean(paramQuickSetupDeviceInfoBean.getNickname(), paramQuickSetupDeviceInfoBean.getAvatar());
    this.a.y5(paramQuickSetupDeviceInfoBean, paramInt).i(new i()).j(new h()).y();
  }
  
  public void O(String paramString, boolean paramBoolean)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Integer localInteger = Integer.valueOf(0);
    if (bool)
    {
      this.k.postValue(localInteger);
      return;
    }
    this.o = io.reactivex.m0.e.n1();
    BaseALIoTDevice localBaseALIoTDevice = this.b.Z1(paramString);
    if ((localBaseALIoTDevice instanceof ALIoTDevice)) {
      ((ALIoTDevice)localBaseALIoTDevice).setTDPIoTDevice(null);
    }
    this.p = false;
    this.q = false;
    N(paramString);
    H0(paramString, paramBoolean);
    this.o.T0(160L, TimeUnit.SECONDS).q0(localInteger).E(new p()).F0();
  }
  
  public List<RoomInfo> R()
  {
    if (this.b.Q1() == null) {
      return null;
    }
    return this.b.Q1().getRooms();
  }
  
  public DeviceTimeParams S(QuickSetupInfoBundle paramQuickSetupInfoBundle)
  {
    long l1 = System.currentTimeMillis() / 1000L;
    Object localObject = TimeZone.getDefault();
    DeviceTimeParams localDeviceTimeParams = new DeviceTimeParams(l1, ((TimeZone)localObject).getRawOffset() / 1000 / 60, ((TimeZone)localObject).getID());
    if (h0(paramQuickSetupInfoBundle))
    {
      localObject = paramQuickSetupInfoBundle.getLongitude();
      paramQuickSetupInfoBundle = paramQuickSetupInfoBundle.getLatitude();
      if (com.tplink.iot.view.quicksetup.base.d.P((Integer)localObject, paramQuickSetupInfoBundle))
      {
        localDeviceTimeParams.setLongitude((Integer)localObject);
        localDeviceTimeParams.setLatitude(paramQuickSetupInfoBundle);
      }
    }
    return localDeviceTimeParams;
  }
  
  public MutableLiveData<Integer> U()
  {
    return this.k;
  }
  
  public void V()
  {
    if (this.a == null)
    {
      this.h.postValue(new i(1, null));
      return;
    }
    if ((b.d.s.a.a.f() != null) && (b.d.s.a.a.f().c() != null))
    {
      localObject = b.d.s.a.a.f().c();
      if ((localObject != null) && (((TCAccountBean)localObject).getCloudUserName() != null))
      {
        localObject = ((TCAccountBean)localObject).getCloudUserName();
        break label69;
      }
    }
    Object localObject = "";
    label69:
    this.a.p5(new UserNameParams((String)localObject)).E(new e()).C(new d()).F0();
  }
  
  public LiveData<i<InheritInfoResult>> W()
  {
    return this.h;
  }
  
  public void Y()
  {
    QuickSetupRepository localQuickSetupRepository = this.a;
    if (localQuickSetupRepository == null)
    {
      this.e.postValue(new i(1, null));
      return;
    }
    localQuickSetupRepository.s5().v0(2L, new c0()).E(new b0()).C(new a0()).F0();
  }
  
  public LiveData<i<QuickSetupComponentResult>> Z()
  {
    return this.e;
  }
  
  public LiveData<i<Boolean>> a0()
  {
    return this.i;
  }
  
  public LiveData<i<Boolean>> b0()
  {
    return this.j;
  }
  
  public LiveData<i<QuickSetupInfoResult>> c0()
  {
    return this.g;
  }
  
  public void d0()
  {
    QuickSetupRepository localQuickSetupRepository = this.a;
    if (localQuickSetupRepository == null)
    {
      this.f.postValue(new i(1, null));
      return;
    }
    localQuickSetupRepository.i5().v0(1L, new f0()).E(new e0()).C(new d0()).F0();
  }
  
  public LiveData<i<List<WirelessScanInfoBean>>> e0()
  {
    return this.f;
  }
  
  public void f0(String paramString)
  {
    this.a = ((QuickSetupRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(paramString, QuickSetupRepository.class));
  }
  
  public q<u> t0(EnumDeviceType paramEnumDeviceType)
  {
    return this.b.N3(AppContext.c, 70, paramEnumDeviceType.getDeviceType()).l0(io.reactivex.d0.b.a.a());
  }
  
  public void u0(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("removeDiscoveryDeviceIfNeeded deviceIdMD5: ");
    localStringBuilder.append(paramString);
    b.d.w.c.a.n("QuickDiscovery", localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString)) {
      this.d.D(paramString);
    }
  }
  
  public q<Boolean> v0()
  {
    e0.a(AppContext.c);
    return q.W0(5L, TimeUnit.SECONDS).l0(io.reactivex.d0.b.a.a()).g0(b.c);
  }
  
  public q<u> x0(EnumDeviceType paramEnumDeviceType)
  {
    return this.b.N3(AppContext.c, 70, paramEnumDeviceType.getDeviceType()).l0(io.reactivex.d0.b.a.a()).E(new v());
  }
  
  public q<u> y0(String paramString, EnumDeviceType paramEnumDeviceType)
  {
    return this.b.O3(AppContext.c, paramString, 70, paramEnumDeviceType.getDeviceType()).l0(io.reactivex.d0.b.a.a()).E(new k());
  }
  
  class a
    implements io.reactivex.g0.a
  {
    a(QuickSetupInfoParams paramQuickSetupInfoParams) {}
    
    public void run()
      throws Exception
    {
      BulbQuickSetupViewModel.y(BulbQuickSetupViewModel.this, paramQuickSetupInfoParams);
    }
  }
  
  class a0
    implements g<Throwable>
  {
    a0() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      b.d.w.c.a.d("getQsComponent doOnError");
      BulbQuickSetupViewModel.h(BulbQuickSetupViewModel.this).postValue(new i(1, null));
    }
  }
  
  class b
    implements g<Throwable>
  {
    b() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      BulbQuickSetupViewModel.z(BulbQuickSetupViewModel.this).postValue(new i(1, null));
    }
  }
  
  class b0
    implements g<QuickSetupComponentResult>
  {
    b0() {}
    
    public void a(QuickSetupComponentResult paramQuickSetupComponentResult)
      throws Exception
    {
      b.d.w.c.a.d("getQsComponent doOnNext");
      BulbQuickSetupViewModel.h(BulbQuickSetupViewModel.this).postValue(new i(0, paramQuickSetupComponentResult));
    }
  }
  
  class c
    implements g<QuickSetupInfoResult>
  {
    c() {}
    
    public void a(QuickSetupInfoResult paramQuickSetupInfoResult)
      throws Exception
    {
      BulbQuickSetupViewModel.z(BulbQuickSetupViewModel.this).postValue(new i(0, paramQuickSetupInfoResult));
    }
  }
  
  class c0
    implements l<Throwable>
  {
    c0() {}
    
    public boolean a(Throwable paramThrowable)
      throws Exception
    {
      if (BulbQuickSetupViewModel.u(BulbQuickSetupViewModel.this, paramThrowable))
      {
        v.b("getQsComponent  try again and enable before");
        BulbQuickSetupViewModel.w(BulbQuickSetupViewModel.this).r1(((ThingContext)BulbQuickSetupViewModel.f(BulbQuickSetupViewModel.this).b()).getDeviceIdMD5());
        return true;
      }
      return false;
    }
  }
  
  class d
    implements g<Throwable>
  {
    d() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      BulbQuickSetupViewModel.A(BulbQuickSetupViewModel.this).postValue(new i(1, null));
    }
  }
  
  class d0
    implements g<Throwable>
  {
    d0() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      BulbQuickSetupViewModel.x(BulbQuickSetupViewModel.this).postValue(new i(1, null));
    }
  }
  
  class e
    implements g<InheritInfoResult>
  {
    e() {}
    
    public void a(InheritInfoResult paramInheritInfoResult)
      throws Exception
    {
      BulbQuickSetupViewModel.A(BulbQuickSetupViewModel.this).postValue(new i(0, paramInheritInfoResult));
    }
  }
  
  class e0
    implements g<List<WirelessScanInfoBean>>
  {
    e0() {}
    
    public void a(List<WirelessScanInfoBean> paramList)
      throws Exception
    {
      BulbQuickSetupViewModel.x(BulbQuickSetupViewModel.this).postValue(new i(0, paramList));
    }
  }
  
  class f
    implements g<Throwable>
  {
    f(InheritInfoParams paramInheritInfoParams) {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      BulbQuickSetupViewModel.B(BulbQuickSetupViewModel.this).postValue(new i(1, Boolean.valueOf(paramInheritInfoParams.isInherit())));
    }
  }
  
  class f0
    implements l<Throwable>
  {
    f0() {}
    
    public boolean a(Throwable paramThrowable)
      throws Exception
    {
      if (BulbQuickSetupViewModel.u(BulbQuickSetupViewModel.this, paramThrowable))
      {
        BulbQuickSetupViewModel.w(BulbQuickSetupViewModel.this).r1(((ThingContext)BulbQuickSetupViewModel.f(BulbQuickSetupViewModel.this).b()).getDeviceIdMD5());
        return true;
      }
      return false;
    }
  }
  
  class g
    implements io.reactivex.g0.a
  {
    g(InheritInfoParams paramInheritInfoParams) {}
    
    public void run()
      throws Exception
    {
      BulbQuickSetupViewModel.B(BulbQuickSetupViewModel.this).postValue(new i(0, Boolean.valueOf(paramInheritInfoParams.isInherit())));
    }
  }
  
  class g0
    implements g<Throwable>
  {
    g0(QuickSetupInfoParams paramQuickSetupInfoParams) {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      BulbQuickSetupViewModel.y(BulbQuickSetupViewModel.this, paramQuickSetupInfoParams);
    }
  }
  
  class h
    implements g<Throwable>
  {
    h() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      b.d.w.c.a.d("setQuickSetupDeviceInfo fail");
      BulbQuickSetupViewModel.C(BulbQuickSetupViewModel.this).postValue(new i(1, null));
    }
  }
  
  class i
    implements io.reactivex.g0.a
  {
    i() {}
    
    public void run()
      throws Exception
    {
      b.d.w.c.a.d("setQuickSetupDeviceInfo success");
      BulbQuickSetupViewModel.C(BulbQuickSetupViewModel.this).postValue(new i(0, Boolean.TRUE));
    }
  }
  
  class j
    implements j<u, t<List<ComponentBean>>>
  {
    j() {}
    
    public t<List<ComponentBean>> a(u paramu)
      throws Exception
    {
      if ((paramu.d()) && (paramu.c() != null)) {
        return BulbQuickSetupViewModel.i(BulbQuickSetupViewModel.this, paramu.c());
      }
      return q.f0(new ArrayList());
    }
  }
  
  class k
    implements g<u>
  {
    k() {}
    
    public void a(u paramu)
      throws Exception
    {
      if ((paramu.d()) && (paramu.c() != null)) {
        BulbQuickSetupViewModel.g(BulbQuickSetupViewModel.this, (QuickSetupRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(paramu.c(), QuickSetupRepository.class));
      }
    }
  }
  
  class l
    implements j<u, u>
  {
    l() {}
    
    public u a(u paramu)
      throws Exception
    {
      if ((paramu.d()) && (paramu.c() != null)) {
        BulbQuickSetupViewModel.g(BulbQuickSetupViewModel.this, (QuickSetupRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(paramu.c(), QuickSetupRepository.class));
      }
      return paramu;
    }
  }
  
  class m
    implements g<Throwable>
  {
    m() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      v.b("get component fail");
    }
  }
  
  class n
    implements j<q<Throwable>, t<Boolean>>
  {
    n(ThingContext paramThingContext) {}
    
    public t<Boolean> a(q<Throwable> paramq)
      throws Exception
    {
      return paramq.N(new a());
    }
    
    class a
      implements j<Throwable, t<Boolean>>
    {
      a() {}
      
      public t<Boolean> a(Throwable paramThrowable)
        throws Exception
      {
        if (BulbQuickSetupViewModel.j(BulbQuickSetupViewModel.this) >= 2) {
          return q.J(paramThrowable);
        }
        if (BulbQuickSetupViewModel.u(BulbQuickSetupViewModel.this, paramThrowable))
        {
          v.b("try to enable transport");
          BulbQuickSetupViewModel.k(BulbQuickSetupViewModel.this);
          BulbQuickSetupViewModel.w(BulbQuickSetupViewModel.this).q1(BulbQuickSetupViewModel.n.this.c.getDeviceIdMD5());
          return q.f0(Boolean.TRUE).o(5L, TimeUnit.SECONDS);
        }
        return q.J(paramThrowable);
      }
    }
  }
  
  class o
    implements g<IoTDataWrapper<LocalIoTBaseDevice>>
  {
    o(String paramString1, String paramString2) {}
    
    public void a(IoTDataWrapper<LocalIoTBaseDevice> paramIoTDataWrapper)
      throws Exception
    {
      if ((paramIoTDataWrapper.getData() != null) && (!TextUtils.isEmpty(((LocalIoTBaseDevice)paramIoTDataWrapper.getData()).getDeviceId())))
      {
        b.d.w.c.a.d("setDeviceFamilyAndRoom2Cloud getDeviceId");
        BulbQuickSetupViewModel.l(BulbQuickSetupViewModel.this, str1, paramString, ((LocalIoTBaseDevice)paramIoTDataWrapper.getData()).getDeviceId());
      }
    }
  }
  
  class p
    implements g<Integer>
  {
    p() {}
    
    public void a(Integer paramInteger)
      throws Exception
    {
      b.d.w.c.a.d("findDeviceByTDPAndCloud doOnNext clearAllDisposable");
      BulbQuickSetupViewModel.this.F();
      BulbQuickSetupViewModel.m(BulbQuickSetupViewModel.this).postValue(paramInteger);
    }
  }
  
  class q
    implements g<i<Boolean>>
  {
    q() {}
    
    public void a(i<Boolean> parami)
      throws Exception
    {
      if ((parami != null) && (parami.b() == 0))
      {
        boolean bool = ((Boolean)parami.a()).booleanValue();
        BulbQuickSetupViewModel.n(BulbQuickSetupViewModel.this, bool);
      }
      else
      {
        BulbQuickSetupViewModel.o(BulbQuickSetupViewModel.this);
      }
    }
  }
  
  class r
    implements g<Throwable>
  {
    r() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      BulbQuickSetupViewModel.n(BulbQuickSetupViewModel.this, false);
    }
  }
  
  class s
    implements j<List<ComponentBean>, t<i<Boolean>>>
  {
    s(boolean paramBoolean) {}
    
    public t<i<Boolean>> a(List<ComponentBean> paramList)
      throws Exception
    {
      if (paramList.isEmpty()) {
        return q.f0(new i(1, Boolean.FALSE));
      }
      if (paramBoolean) {
        return q.f0(new i(0, Boolean.FALSE));
      }
      return BulbQuickSetupViewModel.p(BulbQuickSetupViewModel.this);
    }
  }
  
  class t
    implements j<Boolean, t<List<ComponentBean>>>
  {
    t(String paramString) {}
    
    public t<List<ComponentBean>> a(Boolean paramBoolean)
      throws Exception
    {
      if (paramBoolean.booleanValue()) {
        return BulbQuickSetupViewModel.r(BulbQuickSetupViewModel.this, paramString);
      }
      return q.f0(new ArrayList());
    }
  }
  
  class u
    implements j<InheritInfoResult, i<Boolean>>
  {
    u() {}
    
    public i<Boolean> a(InheritInfoResult paramInheritInfoResult)
      throws Exception
    {
      boolean bool;
      if ((paramInheritInfoResult != null) && (paramInheritInfoResult.isInheritStatus())) {
        bool = true;
      } else {
        bool = false;
      }
      return new i(0, Boolean.valueOf(bool));
    }
  }
  
  class v
    implements g<u>
  {
    v() {}
    
    public void a(u paramu)
      throws Exception
    {
      if ((paramu.d()) && (paramu.c() != null)) {
        BulbQuickSetupViewModel.g(BulbQuickSetupViewModel.this, (QuickSetupRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(paramu.c(), QuickSetupRepository.class));
      }
    }
  }
  
  class w
    implements g<Throwable>
  {
    w() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      b.d.w.c.a.d("findDeviceByCloud doOnError");
      BulbQuickSetupViewModel.s(BulbQuickSetupViewModel.this, 548);
    }
  }
  
  class x
    implements g<i<Boolean>>
  {
    x() {}
    
    public void a(i<Boolean> parami)
      throws Exception
    {
      b.d.w.c.a.d("findDeviceByCloud doOnNext");
      BulbQuickSetupViewModel.t(BulbQuickSetupViewModel.this);
    }
  }
  
  class y
    implements l<i<Boolean>>
  {
    y() {}
    
    public boolean a(i<Boolean> parami)
      throws Exception
    {
      return ((Boolean)parami.a()).booleanValue();
    }
  }
  
  class z
    implements s<i<Boolean>>
  {
    z(String paramString) {}
    
    public void subscribe(r<i<Boolean>> paramr)
      throws Exception
    {
      BulbQuickSetupViewModel.v(BulbQuickSetupViewModel.this, paramString, paramr);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\quicksetup\bulb\BulbQuickSetupViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */