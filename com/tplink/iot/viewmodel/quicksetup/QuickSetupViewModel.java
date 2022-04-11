package com.tplink.iot.viewmodel.quicksetup;

import android.annotation.SuppressLint;
import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.cloud.bean.family.common.FamilyInfo;
import com.tplink.iot.cloud.bean.family.common.RoomInfo;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.view.quicksetup.base.QuickSetupInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.IoTDataWrapper;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.IoTDeviceFeatureCache;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CloudConnectStateResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CloudConnectStatus;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.ComponentBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.IoTPlugDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.DeviceTimeParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.InheritInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.QuickSetupDeviceInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.QuickSetupInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.InheritInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.QuickSetupComponentResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.QuickSetupInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.WirelessScanInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.PlugRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.QuickSetupRepository;
import com.tplink.libtpnetwork.IoTNetwork.u;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyManagerRepository;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.exception.IoTException;
import com.tplink.libtpnetwork.exception.IoTTransportException;
import com.tplink.tpble.v;
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

public class QuickSetupViewModel
  extends AndroidViewModel
{
  private String a = QuickSetupViewModel.class.getSimpleName();
  private o b = o.h0();
  private QuickSetupRepository c;
  private TPIoTClientManager d;
  private FamilyManagerRepository e;
  private io.reactivex.e0.c f;
  private io.reactivex.e0.c g;
  private io.reactivex.e0.c h;
  private io.reactivex.e0.c i;
  private io.reactivex.e0.c j;
  private io.reactivex.e0.c k;
  private io.reactivex.m0.d<Boolean> l;
  private boolean m;
  private boolean n;
  private int o;
  private b.d.d0.h2.a.b p;
  private int q = 0;
  private MutableLiveData<i<QuickSetupComponentResult>> r = new MutableLiveData();
  private MutableLiveData<i<List<WirelessScanInfoBean>>> s = new MutableLiveData();
  private MutableLiveData<i<QuickSetupInfoResult>> t = new MutableLiveData();
  private MutableLiveData<i<Boolean>> u = new MutableLiveData();
  private MediatorLiveData<i<InheritInfoResult>> v = new MediatorLiveData();
  private MediatorLiveData<i<Boolean>> w = new MediatorLiveData();
  private MutableLiveData<Boolean> x = new MutableLiveData();
  private int y;
  
  public QuickSetupViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    this.d = ((TPIoTClientManager)b.d.b.f.b.a(b.d.s.a.a.f(), TPIoTClientManager.class));
    this.e = ((FamilyManagerRepository)b.d.b.f.b.a(b.d.s.a.a.f(), FamilyManagerRepository.class));
  }
  
  public QuickSetupViewModel(@NonNull Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    this.c = ((QuickSetupRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(paramThingContext, QuickSetupRepository.class));
    this.d = ((TPIoTClientManager)b.d.b.f.b.a(b.d.s.a.a.f(), TPIoTClientManager.class));
    this.e = ((FamilyManagerRepository)b.d.b.f.b.a(b.d.s.a.a.f(), FamilyManagerRepository.class));
  }
  
  private void A0(int paramInt)
  {
    if ((this.m) && (this.n))
    {
      io.reactivex.m0.d locald = this.l;
      if ((locald != null) && (!locald.j1()))
      {
        this.l.onNext(Boolean.FALSE);
        this.l.onComplete();
      }
    }
  }
  
  private void B0(String paramString, boolean paramBoolean)
  {
    this.m = true;
    z0(543, paramString, paramBoolean);
  }
  
  private void C0()
  {
    this.m = true;
    A0(543);
  }
  
  private void E(final String paramString, final boolean paramBoolean)
  {
    this.o += 1;
    this.i = q.f0(Boolean.TRUE).o(10L, TimeUnit.SECONDS).N(new y(paramString)).H0(new w(paramBoolean, paramString), new x(paramString, paramBoolean));
  }
  
  private void E0()
  {
    QuickSetupRepository localQuickSetupRepository = this.c;
    if (localQuickSetupRepository == null) {
      return;
    }
    localQuickSetupRepository.S0().y();
  }
  
  private void G()
  {
    io.reactivex.e0.c localc = this.i;
    if ((localc != null) && (!localc.isDisposed())) {
      this.i.dispose();
    }
    localc = this.h;
    if ((localc != null) && (!localc.isDisposed())) {
      this.h.dispose();
    }
    localc = this.g;
    if ((localc != null) && (!localc.isDisposed())) {
      this.g.dispose();
    }
    localc = this.j;
    if ((localc != null) && (!localc.isDisposed())) {
      this.j.dispose();
    }
    localc = this.k;
    if ((localc != null) && (!localc.isDisposed())) {
      this.k.dispose();
    }
  }
  
  private void H()
  {
    io.reactivex.e0.c localc = this.f;
    if ((localc != null) && (!localc.isDisposed())) {
      this.f.dispose();
    }
  }
  
  @SuppressLint({"CheckResult"})
  private void H0(String paramString1, String paramString2, String paramString3)
  {
    Iterator localIterator = Z().iterator();
    while (localIterator.hasNext())
    {
      localObject = (RoomInfo)localIterator.next();
      if (TextUtils.equals(((RoomInfo)localObject).getName(), paramString2))
      {
        localObject = ((RoomInfo)localObject).getId();
        bool = false;
        break label64;
      }
    }
    Object localObject = null;
    boolean bool = true;
    label64:
    this.e.b1(paramString3, paramString1, (String)localObject, paramString2, bool, true).y();
  }
  
  private void I()
  {
    this.n = true;
    Q();
  }
  
  private void J(final String paramString)
  {
    q.f0(Boolean.TRUE).o(3L, TimeUnit.SECONDS).E(new z(paramString)).F0();
  }
  
  private q<Boolean> K(String paramString)
  {
    return this.d.u1(paramString);
  }
  
  private q<Boolean> L(String paramString)
  {
    return q.W0(10L, TimeUnit.SECONDS).N(new a(this, paramString));
  }
  
  private void M(String paramString, r<i<Boolean>> paramr)
  {
    i locali = new i(0, Boolean.FALSE);
    paramString = L(paramString).s0(new c(locali, paramr)).E(new b(locali, paramr));
    paramr.getClass();
    this.k = paramString.C(new h(paramr)).L0(io.reactivex.l0.a.c()).F0();
  }
  
  private void M0()
  {
    this.d.T3();
  }
  
  private q<i<Boolean>> N(final String paramString)
  {
    return q.m(new q(paramString));
  }
  
  private void N0(final String paramString, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    this.f = q.f0(Boolean.valueOf(n0())).N(new m(paramString, paramBoolean1)).l0(io.reactivex.d0.b.a.a()).H0(new j(paramBoolean2, paramString, paramBoolean1), new l());
  }
  
  private void O(String paramString)
  {
    if (this.c == null)
    {
      y0(546);
      return;
    }
    this.j = N(paramString).L(new p()).T0(110L, TimeUnit.SECONDS).E(new o()).C(new n()).F0();
  }
  
  private void O0()
  {
    this.m = true;
    Q();
  }
  
  private void Q()
  {
    io.reactivex.m0.d locald = this.l;
    if ((locald != null) && (!locald.j1()))
    {
      this.l.onNext(Boolean.TRUE);
      this.l.onComplete();
      if (!this.m) {
        H();
      }
      if (!this.n) {
        G();
      }
    }
  }
  
  private String R()
  {
    b.d.d0.h2.a.b localb = this.p;
    if (localb != null) {
      return localb.l();
    }
    return null;
  }
  
  private void S(r<CloudConnectStatus> paramr)
  {
    Object localObject = new CloudConnectStatus(2, null);
    localObject = U().s0(new g((CloudConnectStatus)localObject, paramr)).E(new d((CloudConnectStatus)localObject, paramr));
    paramr.getClass();
    this.h = ((q)localObject).C(new h(paramr)).L0(io.reactivex.l0.a.c()).F0();
  }
  
  private q<CloudConnectStatus> T()
  {
    return q.m(new e(this));
  }
  
  private q<CloudConnectStateResult> U()
  {
    return q.W0(2L, TimeUnit.SECONDS).N(new f(this));
  }
  
  private void V(final String paramString, final boolean paramBoolean)
  {
    if (this.c == null)
    {
      x0(546, paramString, paramBoolean);
      return;
    }
    this.g = T().E(new u()).L(new t()).T0(60L, TimeUnit.SECONDS).E(new s(paramString, paramBoolean)).C(new r(paramString, paramBoolean)).F0();
  }
  
  private q<List<ComponentBean>> Y(final ThingContext paramThingContext)
  {
    this.y = 0;
    return ((PlugRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(paramThingContext, PlugRepository.class)).g1().L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).x0(new c(paramThingContext)).E(new b(paramThingContext));
  }
  
  private boolean m0(Throwable paramThrowable)
  {
    boolean bool;
    if ((!(paramThrowable instanceof ConnectException)) && (!(paramThrowable instanceof IoTTransportException)) && (!(paramThrowable instanceof TimeoutException)) && (!(paramThrowable instanceof InterruptedIOException))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private boolean n0()
  {
    boolean bool;
    if ((b.d.w.f.b.j(getApplication())) && (b.d.w.f.b.i(getApplication()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void x0(int paramInt, String paramString, boolean paramBoolean)
  {
    this.n = true;
    z0(paramInt, paramString, paramBoolean);
  }
  
  private void y0(int paramInt)
  {
    this.n = true;
    A0(paramInt);
  }
  
  private void z0(int paramInt, String paramString, boolean paramBoolean)
  {
    this.q = paramInt;
    if ((this.m) && (this.n))
    {
      io.reactivex.m0.d locald = this.l;
      if ((locald != null) && (!locald.j1())) {
        if (this.o > 0)
        {
          this.o = 0;
          this.l.onNext(Boolean.FALSE);
          this.l.onComplete();
        }
        else
        {
          E(paramString, paramBoolean);
        }
      }
    }
  }
  
  public void D()
  {
    Object localObject = this.c;
    if ((localObject != null) && (((com.tplink.libtpnetwork.IoTNetwork.repository.kb.c)localObject).b() != null) && (((ThingContext)this.c.b()).getIoTDevice() != null)) {
      localObject = ((ALIoTDevice)((ThingContext)this.c.b()).getIoTDevice()).getDeviceId();
    } else {
      localObject = null;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QuickSetupViewModel addDeviceToCurrentFamilyCommonSortList deviceId: ");
      localStringBuilder.append((String)localObject);
      b.d.w.c.a.n("HomeSort", localStringBuilder.toString());
      this.e.O0(Collections.singletonList(localObject));
    }
  }
  
  public q<u> D0()
  {
    v localv = new v("00008641-0000-1000-8000-00805f9b34fb");
    b.d.d0.h2.a.b localb = new b.d.d0.h2.a.b(null, "00008641-0000-1000-8000-00805f9b34fb", "00008882-0000-1000-8000-00805f9b34fb", "00008883-0000-1000-8000-00805f9b34fb", 200);
    this.p = localb;
    return this.d.Y0(AppContext.c, localv, localb).l0(io.reactivex.d0.b.a.a()).E(new d());
  }
  
  public void F()
  {
    H();
    G();
  }
  
  public void F0(String paramString)
  {
    M0();
    E0();
    J(paramString);
  }
  
  public q<List<ComponentBean>> G0(String paramString, final boolean paramBoolean)
  {
    return this.d.P3(AppContext.c, 60, paramString).l0(io.reactivex.d0.b.a.a()).g0(new a(paramBoolean)).N(new h0());
  }
  
  @SuppressLint({"CheckResult"})
  public void I0(String paramString1, final String paramString2)
  {
    final String str;
    if (this.d.Q1() != null) {
      str = this.d.Q1().getId();
    } else {
      str = null;
    }
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramString2))) {
      if (TextUtils.isEmpty(paramString1)) {
        this.c.q5().G0(new a0(str, paramString2));
      } else {
        H0(str, paramString2, paramString1);
      }
    }
  }
  
  public void J0(QuickSetupDeviceInfoBean paramQuickSetupDeviceInfoBean, int paramInt)
  {
    QuickSetupRepository localQuickSetupRepository = this.c;
    if (localQuickSetupRepository == null)
    {
      this.u.postValue(new i(1, null));
      return;
    }
    localQuickSetupRepository.y5(paramQuickSetupDeviceInfoBean, paramInt).i(new g0()).j(new f0()).y();
  }
  
  public void K0(final InheritInfoParams paramInheritInfoParams)
  {
    QuickSetupRepository localQuickSetupRepository = this.c;
    if (localQuickSetupRepository == null)
    {
      this.w.postValue(new i(1, Boolean.valueOf(paramInheritInfoParams.isInherit())));
      return;
    }
    localQuickSetupRepository.x5(paramInheritInfoParams).r(io.reactivex.d0.b.a.a()).i(new h(paramInheritInfoParams)).j(new g(paramInheritInfoParams)).y();
  }
  
  public void L0(QuickSetupInfoParams paramQuickSetupInfoParams)
  {
    QuickSetupRepository localQuickSetupRepository = this.c;
    if (localQuickSetupRepository == null)
    {
      this.t.postValue(new i(1, null));
      return;
    }
    localQuickSetupRepository.z5(paramQuickSetupInfoParams).E(new e0()).C(new d0()).F0();
  }
  
  public void P(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.x.postValue(Boolean.FALSE);
      return;
    }
    this.l = io.reactivex.m0.d.n1();
    BaseALIoTDevice localBaseALIoTDevice = this.d.Z1(paramString);
    if ((localBaseALIoTDevice instanceof ALIoTDevice)) {
      ((ALIoTDevice)localBaseALIoTDevice).setTDPIoTDevice(null);
    }
    this.m = false;
    this.n = false;
    if (paramBoolean2) {
      O(paramString);
    } else {
      V(paramString, paramBoolean1);
    }
    N0(paramString, paramBoolean1, paramBoolean2);
    int i1;
    if (paramBoolean2) {
      i1 = 120;
    } else {
      i1 = 90;
    }
    this.l.T0(i1, TimeUnit.SECONDS).q0(Boolean.FALSE).E(new i()).F0();
  }
  
  public LiveData<i<QuickSetupComponentResult>> W()
  {
    return this.r;
  }
  
  public void X()
  {
    QuickSetupRepository localQuickSetupRepository = this.c;
    if (localQuickSetupRepository == null)
    {
      this.r.postValue(new i(1, null));
      return;
    }
    localQuickSetupRepository.s5().E(new v()).C(new k()).F0();
  }
  
  public List<RoomInfo> Z()
  {
    if (this.d.Q1() == null) {
      return null;
    }
    return this.d.Q1().getRooms();
  }
  
  public DeviceTimeParams a0()
  {
    long l1 = System.currentTimeMillis() / 1000L;
    TimeZone localTimeZone = TimeZone.getDefault();
    return new DeviceTimeParams(l1, localTimeZone.getRawOffset() / 1000 / 60, localTimeZone.getID());
  }
  
  public MutableLiveData<Boolean> b0()
  {
    return this.x;
  }
  
  public void c0()
  {
    QuickSetupRepository localQuickSetupRepository = this.c;
    if (localQuickSetupRepository == null)
    {
      this.v.postValue(new i(1, null));
      return;
    }
    localQuickSetupRepository.o5().E(new f()).C(new e()).F0();
  }
  
  public void close()
  {
    QuickSetupRepository localQuickSetupRepository = this.c;
    if (localQuickSetupRepository != null) {
      localQuickSetupRepository.h5();
    }
  }
  
  public MediatorLiveData<i<InheritInfoResult>> d0()
  {
    return this.v;
  }
  
  public QuickSetupInfoBean e0(QuickSetupInfoBean paramQuickSetupInfoBean)
  {
    QuickSetupInfoBean localQuickSetupInfoBean = paramQuickSetupInfoBean;
    if (paramQuickSetupInfoBean == null)
    {
      String str = R();
      localQuickSetupInfoBean = paramQuickSetupInfoBean;
      if (!TextUtils.isEmpty(str)) {
        localQuickSetupInfoBean = new QuickSetupInfoBean(str, 0L);
      }
    }
    return localQuickSetupInfoBean;
  }
  
  public LiveData<i<Boolean>> f0()
  {
    return this.u;
  }
  
  public MediatorLiveData<i<Boolean>> g0()
  {
    return this.w;
  }
  
  public LiveData<i<QuickSetupInfoResult>> h0()
  {
    return this.t;
  }
  
  public LiveData<i<List<WirelessScanInfoBean>>> i0()
  {
    return this.s;
  }
  
  public void j0()
  {
    QuickSetupRepository localQuickSetupRepository = this.c;
    if (localQuickSetupRepository == null)
    {
      this.s.postValue(new i(1, null));
      return;
    }
    localQuickSetupRepository.i5().E(new c0()).C(new b0()).F0();
  }
  
  public void k0(String paramString)
  {
    this.d.s2(paramString);
  }
  
  public boolean l0()
  {
    QuickSetupRepository localQuickSetupRepository = this.c;
    boolean bool;
    if ((localQuickSetupRepository != null) && (localQuickSetupRepository.u5())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  class a
    implements j<u, u>
  {
    a(boolean paramBoolean) {}
    
    public u a(u paramu)
      throws Exception
    {
      if ((paramu.d()) && (paramu.c() != null) && (!paramBoolean)) {
        QuickSetupViewModel.x(QuickSetupViewModel.this, (QuickSetupRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(paramu.c(), QuickSetupRepository.class));
      }
      return paramu;
    }
  }
  
  class a0
    implements io.reactivex.g0.g<IoTDataWrapper<LocalIoTBaseDevice>>
  {
    a0(String paramString1, String paramString2) {}
    
    public void a(IoTDataWrapper<LocalIoTBaseDevice> paramIoTDataWrapper)
      throws Exception
    {
      if ((paramIoTDataWrapper.getData() != null) && (!TextUtils.isEmpty(((LocalIoTBaseDevice)paramIoTDataWrapper.getData()).getDeviceId()))) {
        QuickSetupViewModel.u(QuickSetupViewModel.this, str, paramString2, ((LocalIoTBaseDevice)paramIoTDataWrapper.getData()).getDeviceId());
      }
    }
  }
  
  class b
    implements io.reactivex.g0.g<List<ComponentBean>>
  {
    b(ThingContext paramThingContext) {}
    
    public void a(List<ComponentBean> paramList)
      throws Exception
    {
      Object localObject = new IoTDeviceFeatureCache(null, paramList);
      QuickSetupViewModel.y(QuickSetupViewModel.this).X0(paramThingContext.getDeviceIdMD5(), com.tplink.libtpnetwork.Utils.i.h(localObject));
      if (paramThingContext.getIoTDevice() != null)
      {
        localObject = new IoTPlugDevice();
        ((LocalIoTBaseDevice)localObject).setComponents(paramList);
        ((ALIoTDevice)paramThingContext.getIoTDevice()).setLocalIoTDevice((LocalIoTBaseDevice)localObject);
      }
    }
  }
  
  class b0
    implements io.reactivex.g0.g<Throwable>
  {
    b0() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      QuickSetupViewModel.g(QuickSetupViewModel.this).postValue(new i(1, null));
    }
  }
  
  class c
    implements j<q<Throwable>, t<Boolean>>
  {
    c(ThingContext paramThingContext) {}
    
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
        if (QuickSetupViewModel.z(QuickSetupViewModel.this) >= 2) {
          return q.J(paramThrowable);
        }
        if (QuickSetupViewModel.B(QuickSetupViewModel.this, paramThrowable))
        {
          b.d.w.c.a.e("QuickSetupViewModel", "enableAfterQuickSetupTransport");
          QuickSetupViewModel.A(QuickSetupViewModel.this);
          QuickSetupViewModel.C(QuickSetupViewModel.this).q1(QuickSetupViewModel.c.this.c.getDeviceIdMD5());
          return q.f0(Boolean.TRUE).o(5L, TimeUnit.SECONDS);
        }
        return q.J(paramThrowable);
      }
    }
  }
  
  class c0
    implements io.reactivex.g0.g<List<WirelessScanInfoBean>>
  {
    c0() {}
    
    public void a(List<WirelessScanInfoBean> paramList)
      throws Exception
    {
      QuickSetupViewModel.g(QuickSetupViewModel.this).postValue(new i(0, paramList));
    }
  }
  
  class d
    implements io.reactivex.g0.g<u>
  {
    d() {}
    
    public void a(u paramu)
      throws Exception
    {
      if ((paramu.d()) && (paramu.c() != null)) {
        QuickSetupViewModel.x(QuickSetupViewModel.this, (QuickSetupRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(paramu.c(), QuickSetupRepository.class));
      }
    }
  }
  
  class d0
    implements io.reactivex.g0.g<Throwable>
  {
    d0() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      if ((paramThrowable instanceof IoTException)) {
        QuickSetupViewModel.s(QuickSetupViewModel.this).postValue(new i(((IoTException)paramThrowable).getErrCode(), null));
      } else {
        QuickSetupViewModel.s(QuickSetupViewModel.this).postValue(new i(1, null));
      }
    }
  }
  
  class e
    implements io.reactivex.g0.g<Throwable>
  {
    e() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      QuickSetupViewModel.h(QuickSetupViewModel.this).postValue(new i(1, null));
    }
  }
  
  class e0
    implements io.reactivex.g0.g<QuickSetupInfoResult>
  {
    e0() {}
    
    public void a(QuickSetupInfoResult paramQuickSetupInfoResult)
      throws Exception
    {
      QuickSetupViewModel.s(QuickSetupViewModel.this).postValue(new i(0, paramQuickSetupInfoResult));
    }
  }
  
  class f
    implements io.reactivex.g0.g<InheritInfoResult>
  {
    f() {}
    
    public void a(InheritInfoResult paramInheritInfoResult)
      throws Exception
    {
      QuickSetupViewModel.h(QuickSetupViewModel.this).postValue(new i(0, paramInheritInfoResult));
    }
  }
  
  class f0
    implements io.reactivex.g0.g<Throwable>
  {
    f0() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      QuickSetupViewModel.v(QuickSetupViewModel.this).postValue(new i(1, null));
    }
  }
  
  class g
    implements io.reactivex.g0.g<Throwable>
  {
    g(InheritInfoParams paramInheritInfoParams) {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      QuickSetupViewModel.i(QuickSetupViewModel.this).postValue(new i(1, Boolean.valueOf(paramInheritInfoParams.isInherit())));
    }
  }
  
  class g0
    implements io.reactivex.g0.a
  {
    g0() {}
    
    public void run()
      throws Exception
    {
      QuickSetupViewModel.v(QuickSetupViewModel.this).postValue(new i(0, Boolean.TRUE));
    }
  }
  
  class h
    implements io.reactivex.g0.a
  {
    h(InheritInfoParams paramInheritInfoParams) {}
    
    public void run()
      throws Exception
    {
      QuickSetupViewModel.i(QuickSetupViewModel.this).postValue(new i(0, Boolean.valueOf(paramInheritInfoParams.isInherit())));
    }
  }
  
  class h0
    implements j<u, t<List<ComponentBean>>>
  {
    h0() {}
    
    public t<List<ComponentBean>> a(u paramu)
      throws Exception
    {
      if ((paramu.d()) && (paramu.c() != null)) {
        return QuickSetupViewModel.w(QuickSetupViewModel.this, paramu.c());
      }
      return q.f0(new ArrayList());
    }
  }
  
  class i
    implements io.reactivex.g0.g<Boolean>
  {
    i() {}
    
    public void a(Boolean paramBoolean)
      throws Exception
    {
      QuickSetupViewModel.this.F();
      MutableLiveData localMutableLiveData = QuickSetupViewModel.j(QuickSetupViewModel.this);
      boolean bool;
      if ((paramBoolean != null) && (paramBoolean.booleanValue())) {
        bool = true;
      } else {
        bool = false;
      }
      localMutableLiveData.postValue(Boolean.valueOf(bool));
    }
  }
  
  class j
    implements io.reactivex.g0.g<List<ComponentBean>>
  {
    j(boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
    
    public void a(List<ComponentBean> paramList)
      throws Exception
    {
      if (!paramList.isEmpty()) {
        QuickSetupViewModel.k(QuickSetupViewModel.this);
      } else if (paramBoolean2) {
        QuickSetupViewModel.l(QuickSetupViewModel.this);
      } else {
        QuickSetupViewModel.m(QuickSetupViewModel.this, paramString, paramBoolean1);
      }
    }
  }
  
  class k
    implements io.reactivex.g0.g<Throwable>
  {
    k() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      QuickSetupViewModel.f(QuickSetupViewModel.this).postValue(new i(1, null));
    }
  }
  
  class l
    implements io.reactivex.g0.g<Throwable>
  {
    l() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      QuickSetupViewModel.k(QuickSetupViewModel.this);
    }
  }
  
  class m
    implements j<Boolean, t<List<ComponentBean>>>
  {
    m(String paramString, boolean paramBoolean) {}
    
    public t<List<ComponentBean>> a(Boolean paramBoolean)
      throws Exception
    {
      if (paramBoolean.booleanValue()) {
        return QuickSetupViewModel.this.G0(paramString, paramBoolean1);
      }
      return q.f0(new ArrayList());
    }
  }
  
  class n
    implements io.reactivex.g0.g<Throwable>
  {
    n() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      QuickSetupViewModel.n(QuickSetupViewModel.this, 548);
      b.d.w.c.a.d("findDeviceByCloud doOnError 1111");
    }
  }
  
  class o
    implements io.reactivex.g0.g<i<Boolean>>
  {
    o() {}
    
    public void a(i<Boolean> parami)
      throws Exception
    {
      b.d.w.c.a.d("findDeviceByCloud doOnNext 2222");
      QuickSetupViewModel.o(QuickSetupViewModel.this);
    }
  }
  
  class p
    implements l<i<Boolean>>
  {
    p() {}
    
    public boolean a(i<Boolean> parami)
      throws Exception
    {
      return ((Boolean)parami.a()).booleanValue();
    }
  }
  
  class q
    implements s<i<Boolean>>
  {
    q(String paramString) {}
    
    public void subscribe(r<i<Boolean>> paramr)
      throws Exception
    {
      QuickSetupViewModel.p(QuickSetupViewModel.this, paramString, paramr);
    }
  }
  
  class r
    implements io.reactivex.g0.g<Throwable>
  {
    r(String paramString, boolean paramBoolean) {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      QuickSetupViewModel.r(QuickSetupViewModel.this, 545, paramString, paramBoolean);
    }
  }
  
  class s
    implements io.reactivex.g0.g<CloudConnectStatus>
  {
    s(String paramString, boolean paramBoolean) {}
    
    public void a(CloudConnectStatus paramCloudConnectStatus)
      throws Exception
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("连云成功 status=");
      localStringBuilder.append(paramCloudConnectStatus.getErrorCode());
      b.d.w.c.a.d(localStringBuilder.toString());
      QuickSetupViewModel.t(QuickSetupViewModel.this, paramString, paramBoolean);
    }
  }
  
  class t
    implements l<CloudConnectStatus>
  {
    t() {}
    
    public boolean a(CloudConnectStatus paramCloudConnectStatus)
      throws Exception
    {
      boolean bool;
      if ((paramCloudConnectStatus != null) && (paramCloudConnectStatus.getErrorCode() == 0)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  class u
    implements io.reactivex.g0.g<CloudConnectStatus>
  {
    u() {}
    
    public void a(CloudConnectStatus paramCloudConnectStatus)
      throws Exception
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("status=");
      localStringBuilder.append(paramCloudConnectStatus.getErrorCode());
      b.d.w.c.a.d(localStringBuilder.toString());
    }
  }
  
  class v
    implements io.reactivex.g0.g<QuickSetupComponentResult>
  {
    v() {}
    
    public void a(QuickSetupComponentResult paramQuickSetupComponentResult)
      throws Exception
    {
      QuickSetupViewModel.f(QuickSetupViewModel.this).postValue(new i(0, paramQuickSetupComponentResult));
    }
  }
  
  class w
    implements io.reactivex.g0.g<Boolean>
  {
    w(boolean paramBoolean, String paramString) {}
    
    public void a(Boolean paramBoolean)
      throws Exception
    {
      if (paramBoolean.booleanValue())
      {
        if (!paramBoolean) {
          QuickSetupViewModel.x(QuickSetupViewModel.this, (QuickSetupRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(paramString, QuickSetupRepository.class));
        }
        QuickSetupViewModel.o(QuickSetupViewModel.this);
      }
      else
      {
        QuickSetupViewModel.r(QuickSetupViewModel.this, 547, paramString, paramBoolean);
      }
    }
  }
  
  class x
    implements io.reactivex.g0.g<Throwable>
  {
    x(String paramString, boolean paramBoolean) {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      QuickSetupViewModel.r(QuickSetupViewModel.this, 548, paramString, paramBoolean);
    }
  }
  
  class y
    implements j<Boolean, t<Boolean>>
  {
    y(String paramString) {}
    
    public t<Boolean> a(Boolean paramBoolean)
      throws Exception
    {
      return QuickSetupViewModel.C(QuickSetupViewModel.this).v1(paramString);
    }
  }
  
  class z
    implements io.reactivex.g0.g<Boolean>
  {
    z(String paramString) {}
    
    public void a(Boolean paramBoolean)
      throws Exception
    {
      com.tplink.iot.view.quicksetup.base.d.h(new QuickSetupInfoBean(paramString, 0L));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\quicksetup\QuickSetupViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */