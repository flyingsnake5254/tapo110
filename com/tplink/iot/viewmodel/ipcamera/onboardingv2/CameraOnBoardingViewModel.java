package com.tplink.iot.viewmodel.ipcamera.onboardingv2;

import android.annotation.SuppressLint;
import android.app.Application;
import android.net.wifi.ScanResult;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.databinding.ObservableList;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.Utils.z0.h;
import com.tplink.iot.cloud.bean.cloudvideo.common.DeviceCloudProduct;
import com.tplink.iot.core.AppContext;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.WirelessInfoParams;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPCameraDevice;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceBean;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyManagerRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCDeviceRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.bean.CameraAvatarInfo;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceAvatarFeatureInfo;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceFeatureInfo;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;
import com.tplink.libtpnetwork.cameranetwork.business.repo.OnBoardingRepository;
import com.tplink.libtpnetwork.cameranetwork.f4;
import com.tplink.libtpnetwork.cameranetwork.model.Account;
import com.tplink.libtpnetwork.cameranetwork.model.AutoUpdateInfo;
import com.tplink.libtpnetwork.cameranetwork.model.BasicInfo;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch;
import com.tplink.libtpnetwork.cameranetwork.model.RecordPlanInfo;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.Schedule;
import com.tplink.libtpnetwork.cameranetwork.model.ScheduleParser;
import com.tplink.libtpnetwork.cameranetwork.model.Wifi;
import com.tplink.libtpnetwork.cameranetwork.util.JsonUtils;
import com.tplink.libtpnetwork.cameranetwork.util.i.b;
import com.tplink.libtpnetwork.exception.IoTTransportException;
import com.tplink.tdp.bean.BaseTDPDevice;
import io.reactivex.g0.g;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CameraOnBoardingViewModel
  extends AndroidViewModel
{
  private MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> A = new MutableLiveData();
  private MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> B = new MutableLiveData();
  private Wifi C;
  private String D;
  private String E;
  private String F;
  private DeviceModel G = DeviceModel.CAMERA_C200;
  private TDPCameraDevice H;
  private OnBoardingRepository I;
  private TPIoTClientManager J = (TPIoTClientManager)b.d.b.f.b.a(b.d.s.a.a.f(), TPIoTClientManager.class);
  private ThingCloudRepository K = (ThingCloudRepository)b.d.b.f.b.a(b.d.s.a.a.f(), ThingCloudRepository.class);
  private TCDeviceRepository L = (TCDeviceRepository)b.d.b.f.b.a(b.d.s.a.a.f(), TCDeviceRepository.class);
  private FamilyManagerRepository M = (FamilyManagerRepository)b.d.b.f.b.a(b.d.s.a.a.f(), FamilyManagerRepository.class);
  private io.reactivex.e0.b N = new io.reactivex.e0.b();
  private ALCameraDevice O;
  private CameraAvatarInfo P;
  private boolean Q = false;
  private TCDeviceBean R = null;
  private ThingDevice S = null;
  private BasicInfo T = null;
  private boolean U = false;
  private boolean V = false;
  private CameraComponent W;
  public String X;
  public boolean Y = true;
  private io.reactivex.e0.c Z;
  public final ObservableField<String> a = new ObservableField("");
  private boolean a0 = false;
  public final ObservableField<String> b = new ObservableField("");
  private boolean b0 = false;
  public final ObservableField<String> c = new ObservableField("");
  private DeviceCloudProduct c0;
  public final ObservableBoolean d = new ObservableBoolean(false);
  public final ObservableList<TDPCameraDevice> d0 = new ObservableArrayList();
  public final ObservableBoolean e = new ObservableBoolean(true);
  public final ObservableInt f = new ObservableInt(0);
  public final ObservableInt g = new ObservableInt(0);
  public final ObservableList<ScanResult> h = new ObservableArrayList();
  public final ObservableList<Wifi> i = new ObservableArrayList();
  public final ObservableBoolean j = new ObservableBoolean(false);
  public final ObservableBoolean k = new ObservableBoolean(false);
  public final ObservableBoolean l = new ObservableBoolean(false);
  private List<WirelessInfoParams> m = new ArrayList();
  public final ObservableList<TDPCameraDevice> n = new ObservableArrayList();
  private int o = 10002;
  private boolean p = false;
  private boolean q = true;
  private MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> r = new MutableLiveData();
  private MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> s = new MutableLiveData();
  private MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> t = new MutableLiveData();
  private MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> u = new MutableLiveData();
  private MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> v = new MutableLiveData();
  private MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> w = new MutableLiveData();
  private MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> x = new MutableLiveData();
  private MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> y = new MutableLiveData();
  public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> z = new MutableLiveData();
  
  public CameraOnBoardingViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
  }
  
  @Nullable
  private String E()
  {
    Object localObject = this.H;
    if ((localObject != null) && (!TextUtils.isEmpty(((TDPCameraDevice)localObject).getDeviceId()))) {
      return this.H.getDeviceId();
    }
    localObject = this.R;
    if ((localObject != null) && (!TextUtils.isEmpty(((TCDeviceBean)localObject).getDeviceId()))) {
      return this.R.getDeviceId();
    }
    localObject = this.S;
    if ((localObject != null) && (!TextUtils.isEmpty(((ThingDevice)localObject).getThingName()))) {
      return this.S.getThingName();
    }
    return null;
  }
  
  private f4 M()
  {
    if ((g0()) && (this.S != null))
    {
      localObject1 = new TPCameraDeviceContext(b.d.s.a.a.f(), new ALCameraDevice(this.S));
      localObject2 = new f4();
      ((f4)localObject2).u(new com.tplink.libtpnetwork.cameranetwork.h4.n4.d(this.S.getThingName(), (TPCameraDeviceContext)localObject1));
      return (f4)localObject2;
    }
    f4 localf4 = new f4();
    com.tplink.cloud.context.b localb = b.d.s.a.a.f();
    Object localObject2 = com.tplink.iot.core.n.c();
    TCDeviceBean localTCDeviceBean = this.R;
    Object localObject1 = localObject2;
    if (localTCDeviceBean != null)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(localTCDeviceBean.getAppServerUrl())) {
        localObject1 = this.R.getAppServerUrl();
      }
    }
    localf4.h3(localb, this.H.getDeviceId(), (String)localObject1);
    return localf4;
  }
  
  private void P1()
  {
    this.I.G().E(new e0(this)).C(new m(this)).F0();
  }
  
  private String T(String paramString)
  {
    return com.tplink.libtpnetwork.Utils.o.h0().V(paramString);
  }
  
  private void U(Response paramResponse, Throwable paramThrowable)
  {
    this.r.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.FALSE));
    if (paramThrowable != null) {
      paramThrowable.printStackTrace();
    }
  }
  
  private void V1()
  {
    Object localObject = this.H;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((TDPIoTDevice)localObject).getDeviceIdMd5();
    }
    this.Z = com.tplink.libtpnetwork.IoTNetwork.v.e(AppContext.c, null, 60, (String)localObject, this.j.get()).F(new a1(this)).y(new x(this)).n(new TDPCameraDevice()).E(new v(this)).F0();
  }
  
  private void X1(String paramString1, String paramString2)
  {
    paramString1 = this.I.l().t2((String)this.c.get(), x()).i(com.tplink.libtpnetwork.cameranetwork.g4.m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).g0(y0.c).x0(new com.tplink.libtpnetwork.cameranetwork.g4.l(3, 3000)).H0(new q0(this, paramString1, paramString2), new p0(this));
    this.N.b(paramString1);
  }
  
  private void Y1(int paramInt)
  {
    io.reactivex.e0.c localc = this.I.I(new AutoUpdateInfo("on", r2(paramInt), Integer.valueOf(120))).L0(io.reactivex.l0.a.c()).Z().v(1L, new e()).r(io.reactivex.d0.b.a.a()).i(u0.a).j(w.c).y();
    this.N.b(localc);
  }
  
  private void Z1(int paramInt)
  {
    if (this.I != null) {
      this.N.b(M().o2(new AutoUpdateInfo("on", r2(paramInt), Integer.valueOf(120))).H0(n.c, y.c));
    }
  }
  
  private boolean b0(Throwable paramThrowable)
  {
    boolean bool;
    if ((!(paramThrowable instanceof ConnectException)) && (!(paramThrowable instanceof IoTTransportException)) && (!(paramThrowable instanceof TimeoutException)) && (!(paramThrowable instanceof InterruptedIOException))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private void h2(String paramString1, String paramString2)
  {
    if (this.I != null) {
      this.N.b(M().t2(paramString1, paramString2).H0(new d1(this, paramString1, paramString2), new n0(this)));
    }
  }
  
  private void k()
  {
    Object localObject1 = b.d.q.b.i.a();
    if (b.d.q.b.i.c() != null) {
      localObject2 = b.d.q.b.i.c();
    } else {
      localObject2 = "";
    }
    Account localAccount = new Account((String)localObject1, (String)localObject2, false);
    localObject1 = com.tplink.libtpnetwork.cameranetwork.util.i.d();
    Object localObject2 = ScheduleParser.formatRecordSchedules(Collections.singletonList(new Schedule(0, 0, 24, 0, 2)));
    RecordPlanInfo localRecordPlanInfo = new RecordPlanInfo(OptionSwitch.ON.toString(), (String)localObject2, (String)localObject2, (String)localObject2, (String)localObject2, (String)localObject2, (String)localObject2, (String)localObject2);
    f4 localf4 = this.I.l();
    if (this.b0) {
      localObject2 = null;
    } else {
      localObject2 = ((i.b)localObject1).c();
    }
    if (this.b0) {
      localObject1 = null;
    } else {
      localObject1 = ((i.b)localObject1).d();
    }
    if (this.b0) {
      localRecordPlanInfo = null;
    }
    localObject2 = localf4.d3(localAccount, (String)localObject2, (String)localObject1, localRecordPlanInfo).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).x0(new com.tplink.libtpnetwork.cameranetwork.g4.l(3, 3000)).H0(new t0(this), new o(this));
    this.N.b((io.reactivex.e0.c)localObject2);
  }
  
  private void n(boolean paramBoolean)
  {
    this.I.s().E(new j(this, paramBoolean)).C(new h0(this)).F0();
  }
  
  private void o()
  {
    ALCameraDevice localALCameraDevice = new ALCameraDevice(this.H);
    TPCameraDeviceContext localTPCameraDeviceContext = new TPCameraDeviceContext(b.d.s.a.a.f(), localALCameraDevice);
    OnBoardingRepository localOnBoardingRepository = this.I;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(com.tplink.iot.Utils.f0.a(localALCameraDevice.getDeviceMac()));
    localStringBuilder.append("softReset");
    localOnBoardingRepository.n(localTPCameraDeviceContext, new Account("guest", localStringBuilder.toString(), false)).x0(new com.tplink.libtpnetwork.cameranetwork.g4.l(3, 3000, true)).H0(new k0(this), new z0(this));
  }
  
  private void p2(List<Wifi> paramList)
  {
    if (this.k.get()) {
      Collections.sort(paramList, i0.c);
    } else {
      Collections.sort(paramList, z.c);
    }
    this.i.clear();
    this.i.addAll(paramList);
  }
  
  private String r2(int paramInt)
  {
    int i1 = paramInt / 60 % 24;
    paramInt %= 60;
    Object localObject = new java/lang/StringBuilder;
    if (i1 < 10)
    {
      ((StringBuilder)localObject).<init>();
      ((StringBuilder)localObject).append("0");
    }
    else
    {
      ((StringBuilder)localObject).<init>();
      ((StringBuilder)localObject).append("");
    }
    ((StringBuilder)localObject).append(i1);
    String str = ((StringBuilder)localObject).toString();
    if (paramInt < 10)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("0");
      ((StringBuilder)localObject).append(paramInt);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramInt);
      localObject = ((StringBuilder)localObject).toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(":");
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
  
  private void s2(TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    paramTPCameraDeviceContext = this.I.m(paramTPCameraDeviceContext).L0(io.reactivex.l0.a.c()).H0(new w0(this), new l(this));
    this.N.b(paramTPCameraDeviceContext);
  }
  
  private List<TDPCameraDevice> t(List<TDPCameraDevice> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = this.o;
    TDPCameraDevice localTDPCameraDevice;
    if (i1 != 10002)
    {
      if (i1 == 10003)
      {
        paramList = paramList.iterator();
        do
        {
          if (!paramList.hasNext()) {
            break;
          }
          localTDPCameraDevice = (TDPCameraDevice)paramList.next();
        } while ((this.H == null) || (!TextUtils.equals(localTDPCameraDevice.getMac(), this.H.getMac())) || (TextUtils.isEmpty(localTDPCameraDevice.getConnectSsid())));
        localArrayList.add(localTDPCameraDevice);
        this.H = localTDPCameraDevice;
        this.V = true;
        this.z.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.TRUE));
        b.d.w.c.a.e("cameraIsSetFindDevice", "3333333333333--- true");
        q2();
      }
    }
    else
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localTDPCameraDevice = (TDPCameraDevice)paramList.next();
        if (localTDPCameraDevice.getMac() != null)
        {
          t2(localTDPCameraDevice);
          W();
          if (!TextUtils.isEmpty(localTDPCameraDevice.getOwner()))
          {
            if ((this.j.get()) && (localTDPCameraDevice.isResetWiFi()))
            {
              if ((b.d.q.b.i.b() != null) && (localTDPCameraDevice.getOwner().equals(b.d.w.h.a.g(b.d.q.b.i.b()).toUpperCase()))) {
                this.A.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.TRUE));
              } else {
                this.A.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.FALSE));
              }
            }
            else if (TextUtils.equals("192.168.191.1", localTDPCameraDevice.getIp()))
            {
              q2();
              com.tplink.libtpnetwork.Utils.e0.b(AppContext.c, com.tplink.libtpnetwork.TDPNetwork.a.q().r());
              if ((b.d.q.b.i.b() != null) && (localTDPCameraDevice.getOwner().equals(b.d.w.h.a.g(b.d.q.b.i.b()).toUpperCase()))) {
                n(true);
              } else {
                o();
              }
            }
          }
          else
          {
            m();
            localArrayList.add(localTDPCameraDevice);
          }
        }
      }
    }
    return localArrayList;
  }
  
  private void t2(TDPCameraDevice paramTDPCameraDevice)
  {
    this.H = paramTDPCameraDevice;
    DeviceModel localDeviceModel = DeviceModel.fromValue(paramTDPCameraDevice.getDeviceModel());
    if (localDeviceModel != null)
    {
      paramTDPCameraDevice = localDeviceModel;
      if (localDeviceModel != DeviceModel.CAMERA_OTHER) {}
    }
    else
    {
      paramTDPCameraDevice = DeviceModel.CAMERA_C200;
    }
    localDeviceModel = this.G;
    if ((localDeviceModel != null) && (localDeviceModel != paramTDPCameraDevice))
    {
      f2(paramTDPCameraDevice);
      b.d.w.c.a.e("cameraModelNotMatch", "go on config...");
    }
  }
  
  private io.reactivex.q<Boolean> u(final String paramString)
  {
    return this.L.y().g0(new f(paramString)).q0(Boolean.FALSE);
  }
  
  private boolean u2(List<Wifi> paramList)
  {
    p2(paramList);
    Object localObject1 = new ArrayList();
    paramList = paramList.iterator();
    Object localObject3;
    while (paramList.hasNext())
    {
      localObject2 = (Wifi)paramList.next();
      Iterator localIterator = this.m.iterator();
      while (localIterator.hasNext())
      {
        localObject3 = (WirelessInfoParams)localIterator.next();
        if (TextUtils.equals(((Wifi)localObject2).getSsid(), ((WirelessInfoParams)localObject3).getSsid())) {
          ((List)localObject1).add(localObject2);
        }
      }
    }
    int i1 = ((List)localObject1).size();
    boolean bool = false;
    if (i1 == 0) {
      return false;
    }
    Object localObject2 = ((List)localObject1).iterator();
    localObject1 = null;
    i1 = 0;
    while (((Iterator)localObject2).hasNext())
    {
      paramList = (Wifi)((Iterator)localObject2).next();
      if (paramList.getRssi() > i1)
      {
        i1 = paramList.getRssi();
        localObject1 = paramList;
      }
    }
    if (localObject1 != null)
    {
      paramList = this.d;
      if (((Wifi)localObject1).getAuth() != 0) {
        bool = true;
      }
      paramList.set(bool);
      this.C = ((Wifi)localObject1);
      localObject3 = this.a;
      bool = TextUtils.isEmpty(((Wifi)localObject1).getSsid());
      localObject2 = "";
      if (!bool) {
        paramList = ((Wifi)localObject1).getSsid();
      } else {
        paramList = "";
      }
      ((ObservableField)localObject3).set(paramList);
      localObject3 = T(((Wifi)localObject1).getSsid());
      paramList = (List<Wifi>)localObject3;
      if (((Wifi)localObject1).getAuth() == 0)
      {
        paramList = (List<Wifi>)localObject3;
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          paramList = new WirelessInfoParams((String)this.a.get(), "", "");
          com.tplink.libtpnetwork.Utils.o.h0().r0(paramList);
          paramList = "";
        }
      }
      localObject3 = this.b;
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramList)) {
        localObject1 = paramList;
      }
      ((ObservableField)localObject3).set(localObject1);
      this.e.set(TextUtils.isEmpty(paramList) ^ true);
    }
    return true;
  }
  
  private io.reactivex.q<Boolean> v2(ALCameraDevice paramALCameraDevice, String paramString, boolean paramBoolean)
  {
    Object localObject = b.d.s.a.a.f();
    TCDeviceRepository localTCDeviceRepository = (TCDeviceRepository)b.d.b.f.b.c((com.tplink.cloud.context.b)localObject).a(TCDeviceRepository.class);
    String str1 = paramALCameraDevice.getDeviceId();
    String str2 = ((com.tplink.cloud.context.b)localObject).c().getCloudUserName();
    String str3 = ((com.tplink.cloud.context.b)localObject).c().getToken();
    this.E = paramString;
    localObject = new DeviceFeatureInfo();
    ((DeviceFeatureInfo)localObject).setLastUpdateTimestamp(Long.valueOf(System.currentTimeMillis()));
    ((DeviceFeatureInfo)localObject).setDeviceAvatarFeatureInfo(new DeviceAvatarFeatureInfo(Boolean.valueOf(paramBoolean), paramString));
    return localTCDeviceRepository.X(str2, str1, JsonUtils.g(localObject), str3).C(io.reactivex.l0.a.c()).J().g0(new s(paramALCameraDevice, paramBoolean, paramString));
  }
  
  private io.reactivex.q<Boolean> w(String paramString)
  {
    return this.K.U().g0(new k(this, paramString)).q0(Boolean.FALSE);
  }
  
  public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> A()
  {
    return this.t;
  }
  
  public TDPCameraDevice B()
  {
    return this.H;
  }
  
  public String C()
  {
    return this.E;
  }
  
  public DeviceModel D()
  {
    return this.G;
  }
  
  public String F()
  {
    TDPCameraDevice localTDPCameraDevice = this.H;
    if (localTDPCameraDevice != null) {
      return localTDPCameraDevice.getHardwareVer();
    }
    return "";
  }
  
  public LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> G()
  {
    return this.r;
  }
  
  public LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> H()
  {
    return this.y;
  }
  
  public LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> I()
  {
    return this.v;
  }
  
  public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> J()
  {
    return this.B;
  }
  
  public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> K()
  {
    return this.A;
  }
  
  public LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> L()
  {
    return this.s;
  }
  
  public OnBoardingRepository N()
  {
    return this.I;
  }
  
  public void N1()
  {
    List localList = com.tplink.libtpnetwork.Utils.o.h0().z();
    this.m.clear();
    this.m.addAll(localList);
  }
  
  public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> O()
  {
    return this.u;
  }
  
  public io.reactivex.q<Boolean> O1()
  {
    com.tplink.libtpnetwork.Utils.e0.a(AppContext.c);
    return io.reactivex.q.W0(5L, TimeUnit.SECONDS).l0(io.reactivex.d0.b.a.a()).g0(l0.c);
  }
  
  public String P()
  {
    return this.F;
  }
  
  public String Q()
  {
    return this.D;
  }
  
  @SuppressLint({"CheckResult"})
  public void Q1(boolean paramBoolean)
  {
    if (this.I == null) {
      W();
    }
    if (paramBoolean)
    {
      P1();
    }
    else
    {
      ALCameraDevice localALCameraDevice = new ALCameraDevice(this.H);
      TPCameraDeviceContext localTPCameraDeviceContext = new TPCameraDeviceContext(b.d.s.a.a.f(), localALCameraDevice);
      OnBoardingRepository localOnBoardingRepository = this.I;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(com.tplink.iot.Utils.f0.a(localALCameraDevice.getDeviceMac()));
      localStringBuilder.append("softReset");
      localOnBoardingRepository.n(localTPCameraDeviceContext, new Account("guest", localStringBuilder.toString(), false)).x0(new com.tplink.libtpnetwork.cameranetwork.g4.l(3, 3000, true)).H0(new r(this), new u(this, localTPCameraDeviceContext));
    }
  }
  
  public LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> R()
  {
    return this.x;
  }
  
  public void R1()
  {
    Object localObject = this.H;
    if (localObject != null)
    {
      localObject = ((BaseTDPDevice)localObject).getMac();
      if (localObject != null)
      {
        int i1 = ((String)localObject).length();
        if (i1 >= 4)
        {
          ObservableField localObservableField = this.c;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.H.getDeviceName());
          localStringBuilder.append("_");
          localStringBuilder.append(((String)localObject).substring(i1 - 4, i1));
          localObservableField.set(localStringBuilder.toString());
        }
      }
    }
  }
  
  public int S()
  {
    DeviceCloudProduct localDeviceCloudProduct = this.c0;
    if (localDeviceCloudProduct == null) {
      return 8;
    }
    if (localDeviceCloudProduct.getTrialQualified()) {
      return 0;
    }
    return 8;
  }
  
  public void S1()
  {
    this.C = null;
    this.H = null;
    this.S = null;
    this.R = null;
    this.T = null;
    this.W = null;
    this.a.set("");
    this.b.set("");
    this.d0.clear();
    this.c.set("");
    this.I = null;
    this.h.clear();
    this.j.set(false);
    this.U = false;
    this.V = false;
    Boolean localBoolean = Boolean.FALSE;
    this.v = new MutableLiveData(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(localBoolean, true));
    this.z = new MutableLiveData(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(localBoolean, true));
    this.b0 = false;
    this.A = new MutableLiveData(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(localBoolean, true));
  }
  
  public void T1(String paramString1, String paramString2)
  {
    if (g0()) {
      return;
    }
    paramString1 = b.d.s.a.a.f().c();
    this.H.setOwner(com.tplink.libtpnetwork.cameranetwork.util.j.a(paramString1.getCloudUserName()));
    this.O.setTDPIoTDevice(this.H);
    this.O.setCameraAvatarInfo(this.P);
    v2(this.O, this.P.getAvatarName(), true).q0(Boolean.TRUE).N(new g0(this)).y(new t(this)).F0();
  }
  
  public void U1()
  {
    Object localObject = this.I;
    if (localObject != null)
    {
      localObject = ((OnBoardingRepository)localObject).H().v0(1L, new a()).H0(new f0(this), new j0(this));
      this.N.b((io.reactivex.e0.c)localObject);
    }
    else
    {
      this.s.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.FALSE));
    }
  }
  
  public boolean V()
  {
    return this.Q;
  }
  
  public void W()
  {
    TPCameraDeviceContext localTPCameraDeviceContext = new TPCameraDeviceContext(b.d.s.a.a.f(), new ALCameraDevice(this.H));
    if (this.H != null) {
      this.I = ((OnBoardingRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.b(localTPCameraDeviceContext, OnBoardingRepository.class));
    }
  }
  
  public void W1()
  {
    V1();
  }
  
  public boolean X()
  {
    return com.tplink.iot.Utils.v0.d.a();
  }
  
  public boolean Y(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\"");
    localStringBuilder.append(paramString);
    localStringBuilder.append("\"");
    return TextUtils.equals(localStringBuilder.toString(), com.tplink.libtpwifi.b.k().l());
  }
  
  public boolean Z()
  {
    boolean bool;
    if (this.W != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean a0()
  {
    return this.b0;
  }
  
  public void a2(int paramInt)
  {
    if (this.U) {
      Z1(paramInt);
    }
    if (b.d.q.b.i.c() != null) {
      localObject = b.d.q.b.i.c();
    } else {
      localObject = "";
    }
    Object localObject = new Account("admin", (String)localObject, false);
    this.O = new ALCameraDevice(this.H);
    TPCameraDeviceContext localTPCameraDeviceContext = new TPCameraDeviceContext(b.d.s.a.a.f(), this.O);
    localObject = this.I.n(localTPCameraDeviceContext, (Account)localObject).x0(new com.tplink.libtpnetwork.cameranetwork.g4.l(3, 3000)).v0(1L, new d()).H0(new b0(this, paramInt), new o0(this));
    this.N.b((io.reactivex.e0.c)localObject);
  }
  
  public void b2(CameraAvatarInfo paramCameraAvatarInfo)
  {
    this.P = paramCameraAvatarInfo;
  }
  
  public boolean c0(String paramString, int paramInt)
  {
    if (paramInt == 0) {
      return false;
    }
    return b.d.w.e.b.b(paramString) ^ true;
  }
  
  public void c2(Wifi paramWifi)
  {
    this.C = paramWifi;
  }
  
  public boolean d0()
  {
    String str = com.tplink.libtpwifi.b.k().l();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\"");
    localStringBuilder.append(this.D);
    localStringBuilder.append("\"");
    boolean bool;
    if ((TextUtils.equals(str, localStringBuilder.toString())) && (com.tplink.iot.view.ipcamera.base.e.a(getApplication()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void d2()
  {
    if (this.I != null)
    {
      boolean bool = g0();
      if ((com.tplink.libtpnetwork.Utils.a0.j()) && (bool))
      {
        Object localObject = com.tplink.libtpnetwork.Utils.a0.a();
        localObject = this.I.J((String)localObject).w0(new c()).H0(b1.c, p.c);
        this.N.b((io.reactivex.e0.c)localObject);
      }
    }
  }
  
  public boolean e0(String paramString)
  {
    boolean bool;
    if ((!TextUtils.isEmpty(paramString)) && (paramString.length() <= 32) && (paramString.length() != 0)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void e2(TDPCameraDevice paramTDPCameraDevice)
  {
    this.H = paramTDPCameraDevice;
  }
  
  public boolean f0()
  {
    CameraComponent localCameraComponent = this.W;
    boolean bool;
    if ((localCameraComponent != null) && (localCameraComponent.isSupportFwAutoUpdate())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void f2(DeviceModel paramDeviceModel)
  {
    this.G = paramDeviceModel;
  }
  
  public boolean g0()
  {
    Object localObject = this.H;
    if (localObject != null) {
      return ((TDPIoTDevice)localObject).isSupportIoTCloud();
    }
    localObject = this.W;
    if (localObject != null) {
      return ((CameraComponent)localObject).isSupportIoTCloud();
    }
    return false;
  }
  
  public void g2()
  {
    String str1 = (String)this.c.get();
    String str2 = x();
    if (this.U) {
      h2(str1, str2);
    }
    if (b.d.q.b.i.c() != null) {
      localObject = b.d.q.b.i.c();
    } else {
      localObject = "";
    }
    Object localObject = new Account("admin", (String)localObject, false);
    this.O = new ALCameraDevice(this.H);
    TPCameraDeviceContext localTPCameraDeviceContext = new TPCameraDeviceContext(b.d.s.a.a.f(), this.O);
    localObject = this.I.n(localTPCameraDeviceContext, (Account)localObject).x0(new com.tplink.libtpnetwork.cameranetwork.g4.l(3, 3000)).v0(1L, new b()).H0(new q(this, str1, str2), new s0(this));
    this.N.b((io.reactivex.e0.c)localObject);
  }
  
  public boolean h0()
  {
    return this.a0;
  }
  
  public void i2(boolean paramBoolean)
  {
    this.Q = paramBoolean;
  }
  
  public void j()
  {
    String str = E();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("addCameraToCurrentFamilyCommonSortList deviceId: ");
    localStringBuilder.append(str);
    b.d.w.c.a.n("HomeSort", localStringBuilder.toString());
    if (!TextUtils.isEmpty(str)) {
      this.M.O0(Collections.singletonList(str));
    }
  }
  
  public void j2(boolean paramBoolean)
  {
    this.b0 = paramBoolean;
  }
  
  public void k2()
  {
    if (this.I != null)
    {
      boolean bool = Locale.getDefault().toString().startsWith("en_");
      OnBoardingRepository localOnBoardingRepository = this.I;
      if (bool) {
        localObject = "EN";
      } else {
        localObject = "other";
      }
      Object localObject = localOnBoardingRepository.K((String)localObject).C(v0.c).F0();
      this.N.b((io.reactivex.e0.c)localObject);
    }
  }
  
  public void l()
  {
    Object localObject = this.H;
    if (localObject == null)
    {
      U(null, new RuntimeException("currentDevice is null"));
      return;
    }
    this.O = new ALCameraDevice((TDPCameraDevice)localObject);
    localObject = new TPCameraDeviceContext(b.d.s.a.a.f(), this.O);
    OnBoardingRepository localOnBoardingRepository = this.I;
    if (localOnBoardingRepository == null)
    {
      U(null, new RuntimeException("repository is null"));
    }
    else
    {
      localObject = localOnBoardingRepository.n((TPCameraDeviceContext)localObject, new Account("admin", "admin", false)).x0(new com.tplink.libtpnetwork.cameranetwork.g4.l(3, 3000, true)).H0(new c0(this), new r0(this, (TPCameraDeviceContext)localObject));
      this.N.b((io.reactivex.e0.c)localObject);
    }
  }
  
  public void l2(String paramString)
  {
    this.F = paramString;
  }
  
  public void m()
  {
    com.tplink.libtpnetwork.Utils.e0.b(AppContext.c, com.tplink.libtpnetwork.TDPNetwork.a.q().r());
    this.v.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.TRUE));
    b.d.w.c.a.e("cameraIsFindDevice", "2222222222--- true");
  }
  
  public void m2(String paramString)
  {
    this.D = paramString;
  }
  
  public void n2(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void o2(int paramInt)
  {
    this.x.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(paramInt)));
  }
  
  protected void onCleared()
  {
    super.onCleared();
    q2();
  }
  
  public void p()
  {
    Object localObject1 = this.H;
    if ((localObject1 != null) && (((TDPIoTDevice)localObject1).getDeviceIdMd5() != null))
    {
      Object localObject2 = this.J.Z1(this.H.getDeviceIdMd5());
      localObject1 = localObject2;
      if (!(localObject2 instanceof ALCameraDevice)) {
        localObject1 = new ALCameraDevice();
      }
      localObject2 = (ALCameraDevice)localObject1;
      if (TextUtils.isEmpty(this.H.getOwner()))
      {
        localObject1 = b.d.s.a.a.f();
        if ((localObject1 != null) && (((com.tplink.cloud.context.b)localObject1).c() != null) && (((com.tplink.cloud.context.b)localObject1).c().getCloudUserName() != null)) {
          this.H.setOwner(b.d.w.h.a.g(((com.tplink.cloud.context.b)localObject1).c().getCloudUserName()));
        }
      }
      if (this.U)
      {
        if (this.V) {
          ((ALCameraDevice)localObject2).setTDPIoTDevice(this.H);
        }
        ((ALCameraDevice)localObject2).setThingDevice(this.S);
        ((ALCameraDevice)localObject2).setCloudIoTDevice(this.R);
      }
      else
      {
        ((ALCameraDevice)localObject2).setTDPIoTDevice(this.H);
      }
      ((ALCameraDevice)localObject2).setDeviceAlias((String)this.c.get());
      if (g0()) {
        ((ALCameraDevice)localObject2).setCameraAvatar(x());
      } else {
        ((ALCameraDevice)localObject2).setCameraAvatarInfo(this.P);
      }
      ((ALCameraDevice)localObject2).setBasicInfo(this.T);
      ((ALCameraDevice)localObject2).setCameraComponent(this.W);
      this.J.Y3((ALCameraDevice)localObject2);
    }
  }
  
  public void q2()
  {
    this.a0 = false;
    io.reactivex.e0.c localc = this.Z;
    if (localc != null) {
      localc.dispose();
    }
  }
  
  @SuppressLint({"CheckResult"})
  public io.reactivex.q<DeviceCloudProduct> r()
  {
    return h.i(B().getDeviceIdMd5(), false).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new g());
  }
  
  public void s(Wifi paramWifi)
  {
    Object localObject1 = this.a;
    if (!TextUtils.isEmpty(paramWifi.getSsid())) {
      localObject2 = paramWifi.getSsid();
    } else {
      localObject2 = "";
    }
    ((ObservableField)localObject1).set(localObject2);
    localObject1 = T(paramWifi.getSsid());
    Object localObject2 = localObject1;
    if (paramWifi.getAuth() == 0)
    {
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        paramWifi = new WirelessInfoParams((String)this.a.get(), "", "");
        com.tplink.libtpnetwork.Utils.o.h0().r0(paramWifi);
        localObject2 = "";
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      this.e.set(true);
      this.b.set(localObject2);
    }
    else
    {
      this.e.set(false);
      this.b.set("");
    }
  }
  
  public void v()
  {
    if ((this.I != null) && (!this.U))
    {
      io.reactivex.q localq;
      if (g0()) {
        localq = w(this.H.getDeviceIdMd5());
      } else {
        localq = u(this.H.getDeviceIdMd5());
      }
      this.N.b(localq.N(new x0(this)).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).C(a0.c).G0(new e1(this)));
    }
  }
  
  public String x()
  {
    if (g0())
    {
      CameraAvatarInfo localCameraAvatarInfo = this.P;
      if (localCameraAvatarInfo != null) {
        return localCameraAvatarInfo.getAvatarName();
      }
    }
    return null;
  }
  
  public void y()
  {
    Object localObject = this.I;
    if (localObject != null)
    {
      localObject = ((OnBoardingRepository)localObject).u().H0(new f1(this), d0.c);
      this.N.b((io.reactivex.e0.c)localObject);
    }
  }
  
  public Wifi z()
  {
    return this.C;
  }
  
  class a
    implements io.reactivex.g0.l<Throwable>
  {
    a() {}
    
    public boolean a(Throwable paramThrowable)
      throws Exception
    {
      if (CameraOnBoardingViewModel.f(CameraOnBoardingViewModel.this, paramThrowable))
      {
        b.d.w.c.a.d("scanCameraWifi NetInterruptException");
        com.tplink.libtpnetwork.Utils.e0.b(AppContext.c, com.tplink.libtpnetwork.TDPNetwork.a.q().r());
        return true;
      }
      return false;
    }
  }
  
  class b
    implements io.reactivex.g0.l<Throwable>
  {
    b() {}
    
    public boolean a(Throwable paramThrowable)
      throws Exception
    {
      if ((CameraOnBoardingViewModel.f(CameraOnBoardingViewModel.this, paramThrowable)) && (!CameraOnBoardingViewModel.g(CameraOnBoardingViewModel.this)))
      {
        com.tplink.libtpnetwork.Utils.e0.b(AppContext.c, com.tplink.libtpnetwork.TDPNetwork.a.q().r());
        return true;
      }
      return false;
    }
  }
  
  class c
    implements io.reactivex.g0.l<Throwable>
  {
    c() {}
    
    public boolean a(@NonNull Throwable paramThrowable)
      throws Exception
    {
      if (CameraOnBoardingViewModel.f(CameraOnBoardingViewModel.this, paramThrowable))
      {
        com.tplink.libtpnetwork.Utils.e0.b(AppContext.c, com.tplink.libtpnetwork.TDPNetwork.a.q().r());
        return true;
      }
      return false;
    }
  }
  
  class d
    implements io.reactivex.g0.l<Throwable>
  {
    d() {}
    
    public boolean a(Throwable paramThrowable)
      throws Exception
    {
      if ((CameraOnBoardingViewModel.f(CameraOnBoardingViewModel.this, paramThrowable)) && (!CameraOnBoardingViewModel.g(CameraOnBoardingViewModel.this)))
      {
        com.tplink.libtpnetwork.Utils.e0.b(AppContext.c, com.tplink.libtpnetwork.TDPNetwork.a.q().r());
        return true;
      }
      return false;
    }
  }
  
  class e
    implements io.reactivex.g0.l<Throwable>
  {
    e() {}
    
    public boolean a(Throwable paramThrowable)
      throws Exception
    {
      return (CameraOnBoardingViewModel.f(CameraOnBoardingViewModel.this, paramThrowable)) && (!CameraOnBoardingViewModel.g(CameraOnBoardingViewModel.this));
    }
  }
  
  class f
    implements io.reactivex.g0.j<List<TCDeviceBean>, Boolean>
  {
    f(String paramString) {}
    
    public Boolean a(@NonNull List<TCDeviceBean> paramList)
      throws Exception
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        TCDeviceBean localTCDeviceBean = (TCDeviceBean)paramList.next();
        if (TextUtils.equals(paramString, b.d.w.h.a.g(localTCDeviceBean.getDeviceId())))
        {
          CameraOnBoardingViewModel.h(CameraOnBoardingViewModel.this, localTCDeviceBean);
          return Boolean.TRUE;
        }
      }
      return Boolean.FALSE;
    }
  }
  
  class g
    implements g<DeviceCloudProduct>
  {
    g() {}
    
    public void a(DeviceCloudProduct paramDeviceCloudProduct)
      throws Exception
    {
      CameraOnBoardingViewModel.i(CameraOnBoardingViewModel.this, paramDeviceCloudProduct);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\onboardingv2\CameraOnBoardingViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */