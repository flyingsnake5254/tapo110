package com.tplink.iot.viewmodel.cloudvideo;

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
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.Utils.x0.w;
import com.tplink.iot.cloud.bean.cloudvideo.common.CloudVideo;
import com.tplink.iot.cloud.bean.cloudvideo.common.DeviceCloudProduct;
import com.tplink.iot.cloud.bean.cloudvideo.common.HasVideoTime;
import com.tplink.iot.cloud.bean.cloudvideo.common.OrderInfo;
import com.tplink.iot.cloud.bean.cloudvideo.result.TrialResult;
import com.tplink.iot.dailysummary.network.bean.result.SummarySupportResult;
import com.tplink.iot.model.cloudvideo.CloudVideoItem;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.CloudVideoRepository;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.bean.CameraBasicInfo;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.model.AccountInfoCache;
import com.tplink.libtpnetwork.cameranetwork.model.SdCardStatus;
import com.tplink.libtpnetwork.cameranetwork.model.SettingsData;
import io.reactivex.q;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class CloudVideoViewModel
  extends AndroidViewModel
{
  private CloudVideoRepository a;
  private b.d.w.g.a b;
  private SingleLiveEvent<List<CloudVideo>> c = new SingleLiveEvent();
  private SingleLiveEvent<com.tplink.iot.model.cloudvideo.a> d = new SingleLiveEvent();
  private SingleLiveEvent<DeviceCloudProduct> e = new SingleLiveEvent();
  private SingleLiveEvent<Boolean> f = new SingleLiveEvent();
  private MediatorLiveData<List<OrderInfo>> g = new MediatorLiveData();
  private SingleLiveEvent<List<HasVideoTime>> h = new SingleLiveEvent();
  private SingleLiveEvent<List<HasVideoTime>> i = new SingleLiveEvent();
  private MediatorLiveData<Boolean> j = new MediatorLiveData();
  private MutableLiveData<Boolean> k = new MutableLiveData();
  private MutableLiveData<Boolean> l = new MutableLiveData();
  private MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> m = new MutableLiveData();
  private MutableLiveData<SummarySupportResult> n = new MutableLiveData();
  private MutableLiveData<Boolean> o = new MutableLiveData();
  private List<CloudVideoItem> p = Collections.synchronizedList(new ArrayList());
  private io.reactivex.e0.b q = new io.reactivex.e0.b();
  private io.reactivex.e0.c r;
  private io.reactivex.e0.c s;
  private String t;
  private long u = 0L;
  private com.tplink.iot.Utils.v0.f.a v;
  private final SimpleDateFormat w = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
  private String x = TimeZone.getDefault().getID();
  
  public CloudVideoViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    Object localObject = new com.tplink.iot.Utils.v0.f.b(paramApplication);
    this.v = ((com.tplink.iot.Utils.v0.f.a)localObject);
    ((com.tplink.iot.Utils.v0.f.a)localObject).d();
    localObject = b.d.s.a.a.f();
    this.t = ((com.tplink.cloud.context.b)localObject).c().getAccountId();
    localObject = (CloudVideoRepository)b.d.b.f.b.a((com.tplink.cloud.context.b)localObject, CloudVideoRepository.class);
    this.a = ((CloudVideoRepository)localObject);
    this.g.addSource(((CloudVideoRepository)localObject).c0(), new a());
    this.j.addSource(this.a.V(), new i(this));
    this.b = new b.d.w.g.a(paramApplication.getApplicationContext(), "DailySummary");
  }
  
  private void E0(String paramString)
  {
    Object localObject = this.v.f(paramString);
    paramString = new ArrayList();
    if (localObject != null)
    {
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        localObject = (Long)localIterator.next();
        if (localObject != null)
        {
          HasVideoTime localHasVideoTime = new HasVideoTime();
          localHasVideoTime.setUtcTime(((Long)localObject).longValue());
          localHasVideoTime.setDeviceLocalTime(this.w.format(new Date(((Long)localObject).longValue())));
          paramString.add(localHasVideoTime);
        }
      }
    }
    this.i.postValue(paramString);
  }
  
  private boolean V(SdCardStatus paramSdCardStatus)
  {
    boolean bool;
    if ((paramSdCardStatus != SdCardStatus.NORMAL) && (paramSdCardStatus != SdCardStatus.FULL)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private boolean W(String paramString, long paramLong)
  {
    DeviceCloudProduct localDeviceCloudProduct = (DeviceCloudProduct)this.e.getValue();
    if (localDeviceCloudProduct == null) {
      return false;
    }
    TrialResult localTrialResult = localDeviceCloudProduct.getTrial();
    if ((localTrialResult != null) && ("active".equals(localTrialResult.getStatus()))) {
      return false;
    }
    if (localDeviceCloudProduct.isAutoRenew()) {
      return false;
    }
    if (paramLong <= 0L) {
      return false;
    }
    paramLong -= localDeviceCloudProduct.getTimestamp();
    if (paramLong >= 0L)
    {
      boolean bool1 = paramLong < 604800000L;
      if (!bool1)
      {
        boolean bool2 = paramLong < 259200000L;
        if ((bool2) && (bool1)) {
          return !o.h0().Z(paramString);
        }
        bool1 = paramLong < 86400000L;
        if ((bool1) && (bool2)) {
          return !o.h0().a0(paramString);
        }
        if (bool1) {
          return !o.h0().Y(paramString);
        }
        return false;
      }
    }
    o.h0().e1(paramString, false);
    o.h0().f1(paramString, false);
    o.h0().f1(paramString, false);
    return false;
  }
  
  private void m(HasVideoTime paramHasVideoTime)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cal device timezone HasVideoTime: UtcTime=");
    localStringBuilder.append(paramHasVideoTime.getUtcTime());
    localStringBuilder.append("|DeviceLocalTime=");
    localStringBuilder.append(paramHasVideoTime.getDeviceLocalTime());
    b.d.w.c.a.c("CloudVideoListFragment", localStringBuilder.toString());
    long l1 = paramHasVideoTime.getUtcTime();
    long l2 = o0.s(paramHasVideoTime.getDeviceLocalTime(), "GMT+00:00");
    paramHasVideoTime = new StringBuilder();
    paramHasVideoTime.append("cal device timezone : maxDeviceLocalTime=");
    paramHasVideoTime.append(l2);
    b.d.w.c.a.c("CloudVideoListFragment", paramHasVideoTime.toString());
    int i1 = (int)((l2 - l1) / 3600000L);
    if (i1 >= 0)
    {
      paramHasVideoTime = new StringBuilder();
      paramHasVideoTime.append("GMT+");
      paramHasVideoTime.append(Math.abs(i1));
      paramHasVideoTime.append(":00");
      this.x = paramHasVideoTime.toString();
    }
    else
    {
      paramHasVideoTime = new StringBuilder();
      paramHasVideoTime.append("GMT-");
      paramHasVideoTime.append(Math.abs(i1));
      paramHasVideoTime.append(":00");
      this.x = paramHasVideoTime.toString();
    }
    paramHasVideoTime = new StringBuilder();
    paramHasVideoTime.append("cal device timezone = ");
    paramHasVideoTime.append(this.x);
    b.d.w.c.a.c("CloudVideoListFragment", paramHasVideoTime.toString());
  }
  
  private void r()
  {
    io.reactivex.e0.c localc = this.r;
    if ((localc != null) && (!localc.isDisposed())) {
      this.r.dispose();
    }
    localc = this.s;
    if ((localc != null) && (!localc.isDisposed())) {
      this.s.dispose();
    }
  }
  
  private void s()
  {
    this.a.T(0, 1).E(new j(this)).C(l.c).F0();
  }
  
  private void w0(List<OrderInfo> paramList)
  {
    Collections.sort(paramList, a.c);
  }
  
  private q<Boolean> x(String paramString)
  {
    long l1 = this.u;
    if (l1 == 0L) {
      return z(paramString).g0(new c()).q0(Boolean.TRUE);
    }
    if (l1 == -1L) {
      return q.f0(Boolean.TRUE);
    }
    return q.f0(Boolean.TRUE);
  }
  
  private void x0(List<HasVideoTime> paramList)
  {
    Collections.sort(paramList, k.c);
  }
  
  private com.tplink.iot.view.ipcamera.widget.calendar.d y0(Long paramLong, String paramString)
  {
    if (paramLong == null) {
      return null;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeZone(TimeZone.getTimeZone(paramString));
    localCalendar.setTimeInMillis(paramLong.longValue());
    return new com.tplink.iot.view.ipcamera.widget.calendar.d(localCalendar.get(1), localCalendar.get(2) + 1, localCalendar.get(5));
  }
  
  private q<DeviceCloudProduct> z(final String paramString)
  {
    return this.a.M(paramString).E(new g(paramString)).C(new f()).l0(io.reactivex.d0.b.a.a());
  }
  
  public LiveData<Boolean> A()
  {
    return this.j;
  }
  
  public void A0()
  {
    o.h0().H0(System.currentTimeMillis());
  }
  
  public List<CloudVideoItem> B()
  {
    return this.p;
  }
  
  public void B0()
  {
    o.h0().I0(System.currentTimeMillis());
  }
  
  public LiveData<List<CloudVideo>> C()
  {
    return this.c;
  }
  
  public void C0()
  {
    o.h0().Z0(System.currentTimeMillis());
  }
  
  public SingleLiveEvent<com.tplink.iot.model.cloudvideo.a> D()
  {
    return this.d;
  }
  
  public void D0(String paramString)
  {
    if (this.u <= 0L) {
      return;
    }
    long l1 = System.currentTimeMillis();
    l1 = this.u - l1;
    boolean bool1 = l1 < 259200000L;
    if ((bool1) && (l1 < 604800000L))
    {
      o.h0().e1(paramString, true);
    }
    else
    {
      boolean bool2 = l1 < 86400000L;
      if ((bool2) && (bool1)) {
        o.h0().f1(paramString, true);
      } else if (bool2) {
        o.h0().d1(paramString, true);
      }
    }
  }
  
  public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> E()
  {
    return this.m;
  }
  
  public SingleLiveEvent<Boolean> F()
  {
    return this.f;
  }
  
  public String G(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = TPIoTClientManager.K1(paramString);
    if (paramString != null)
    {
      paramString = (ALCameraDevice)paramString.getCameraDevice();
      if ((paramString != null) && (paramString.getBasicInfo() != null)) {
        return paramString.getBasicInfo().getDeviceId();
      }
    }
    return null;
  }
  
  public boolean H(List<OrderInfo> paramList, String paramString)
  {
    if ((paramList != null) && (paramString != null))
    {
      paramString = paramList.iterator();
      while (paramString.hasNext())
      {
        paramList = (OrderInfo)paramString.next();
        if ((paramList != null) && (paramList.getTrial() == 0) && ("active".equals(paramList.getStatus()))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void I(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    String str = null;
    if (bool)
    {
      this.h.postValue(null);
      return;
    }
    Object localObject1 = this.v.b(paramString);
    if (this.v.g(paramString) != null)
    {
      this.x = this.v.g(paramString);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getCachedDeviceTimeZone  deviceId:");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("|mTimeZoneStr:");
      ((StringBuilder)localObject2).append(this.x);
      b.d.w.c.a.c("CloudVideoListFragment", ((StringBuilder)localObject2).toString());
    }
    this.w.setTimeZone(TimeZone.getTimeZone(this.x));
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("simpleDateFormat TimeZone  deviceId:");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("|mTimeZoneStr:");
    ((StringBuilder)localObject2).append(this.x);
    b.d.w.c.a.c("CloudVideoListFragment", ((StringBuilder)localObject2).toString());
    Object localObject3 = this.v.f(paramString);
    localObject2 = new ArrayList();
    if (localObject3 != null)
    {
      Iterator localIterator = ((List)localObject3).iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        if (localLong != null)
        {
          localObject3 = new HasVideoTime();
          ((HasVideoTime)localObject3).setUtcTime(localLong.longValue());
          ((HasVideoTime)localObject3).setDeviceLocalTime(this.w.format(new Date(localLong.longValue())));
          ((List)localObject2).add(localObject3);
        }
      }
    }
    long l1 = System.currentTimeMillis();
    if (localObject1 != null)
    {
      str = this.w.format(new Date(((Long)localObject1).longValue()));
      localObject1 = this.w.format(new Date(l1));
    }
    else
    {
      localObject1 = null;
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("getHasVideoDateList  deviceId:");
    ((StringBuilder)localObject3).append(paramString);
    ((StringBuilder)localObject3).append("|mTimeZoneStr:");
    ((StringBuilder)localObject3).append(this.x);
    ((StringBuilder)localObject3).append("|startDate:");
    ((StringBuilder)localObject3).append(str);
    ((StringBuilder)localObject3).append("|endDate:");
    ((StringBuilder)localObject3).append((String)localObject1);
    b.d.w.c.a.c("CloudVideoListFragment", ((StringBuilder)localObject3).toString());
    this.a.Y(paramString, str, (String)localObject1).E(new c(this, paramString, l1, (List)localObject2)).C(new f(this)).l0(io.reactivex.d0.b.a.a()).F0();
  }
  
  public SingleLiveEvent<List<HasVideoTime>> J()
  {
    return this.h;
  }
  
  public MutableLiveData<Boolean> K()
  {
    return this.l;
  }
  
  public LiveData<List<HasVideoTime>> L()
  {
    return this.i;
  }
  
  public MutableLiveData<Boolean> M()
  {
    return this.o;
  }
  
  public LiveData<List<OrderInfo>> N()
  {
    return this.g;
  }
  
  public void O()
  {
    this.a.d0().l0(io.reactivex.d0.b.a.a()).F0();
  }
  
  public void P(String paramString)
  {
    this.a.R(paramString, 10, null, null).E(new g(this)).C(new b(this)).l0(io.reactivex.d0.b.a.a()).F0();
  }
  
  public OrderInfo Q(List<OrderInfo> paramList, String paramString)
  {
    paramString = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      OrderInfo localOrderInfo = (OrderInfo)paramList.next();
      if ((localOrderInfo != null) && (localOrderInfo.getTrial() == 0) && ("active".equals(localOrderInfo.getStatus())) && (!localOrderInfo.isAutoRenew())) {
        paramString.add(localOrderInfo);
      }
    }
    if (paramString.size() > 1) {
      w0(paramString);
    }
    if (paramString.size() >= 1) {
      return (OrderInfo)paramString.get(0);
    }
    return null;
  }
  
  public int R(DeviceCloudProduct paramDeviceCloudProduct, boolean paramBoolean)
  {
    return this.a.g0(paramDeviceCloudProduct, paramBoolean);
  }
  
  public String S()
  {
    return this.x;
  }
  
  public MutableLiveData<Boolean> T()
  {
    return this.k;
  }
  
  public void U(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    r();
    paramString1 = q.f1(this.a.R(paramString1, 20, paramString2, paramString3), x(paramString1), new h(this, paramString1, paramLong)).C(new d(this)).l0(io.reactivex.d0.b.a.a()).F0();
    this.r = paramString1;
    this.q.b(paramString1);
  }
  
  public boolean X(DeviceCloudProduct paramDeviceCloudProduct)
  {
    return this.a.k0(paramDeviceCloudProduct);
  }
  
  public boolean Y(String paramString)
  {
    if (paramString == null) {
      return true;
    }
    paramString = TPIoTClientManager.K1(paramString);
    if (paramString != null)
    {
      paramString = (ALCameraDevice)paramString.getCameraDevice();
      if (paramString != null) {
        return paramString.isUserRoleTypeDevice();
      }
    }
    return true;
  }
  
  public boolean n()
  {
    boolean bool;
    if (System.currentTimeMillis() - o.h0().F() > 2592000000L) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean o()
  {
    boolean bool;
    if (System.currentTimeMillis() - o.h0().G() > 2592000000L) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.q.d();
  }
  
  public boolean p()
  {
    boolean bool;
    if (System.currentTimeMillis() - o.h0().U() > 2592000000L) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean t(DeviceCloudProduct paramDeviceCloudProduct)
  {
    return this.a.C(paramDeviceCloudProduct);
  }
  
  public void t0(String paramString1, String paramString2, String paramString3)
  {
    r();
    Object localObject = this.p;
    if (localObject != null)
    {
      int i1 = ((List)localObject).size();
      if (i1 >= 1)
      {
        localObject = (CloudVideoItem)this.p.get(i1 - 1);
        if (localObject != null)
        {
          localObject = ((CloudVideoItem)localObject).getCloudVideo();
          if (localObject != null)
          {
            localObject = ((CloudVideo)localObject).getEventLocalTime();
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              break label88;
            }
          }
        }
      }
    }
    localObject = "";
    label88:
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramString3 = (String)localObject;
    }
    paramString1 = this.a.R(paramString1, 20, paramString2, paramString3).E(new e(this)).C(new b()).l0(io.reactivex.d0.b.a.a()).F0();
    this.s = paramString1;
    this.q.b(paramString1);
  }
  
  public boolean u(DeviceCloudProduct paramDeviceCloudProduct)
  {
    return this.a.D(paramDeviceCloudProduct);
  }
  
  public void u0(List<CloudVideoItem> paramList)
  {
    try
    {
      this.p.removeAll(paramList);
    }
    catch (Exception paramList)
    {
      b.d.w.c.a.d("removeAll Exception");
    }
  }
  
  public void v(String paramString, List<CloudVideoItem> paramList)
  {
    if ((paramString != null) && (paramList != null))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(((CloudVideoItem)paramList.next()).getCloudVideo().getUuid());
      }
      w.x(b.d.w.h.a.g(paramString));
      this.a.F(paramString, localArrayList).i(new e()).j(new d()).r(io.reactivex.d0.b.a.a()).y();
      return;
    }
    this.f.postValue(Boolean.FALSE);
  }
  
  public void v0(String paramString, long paramLong)
  {
    this.v.a(paramString, paramLong);
    E0(paramString);
  }
  
  public void w(String paramString)
  {
    z(paramString).F0();
  }
  
  public LiveData<DeviceCloudProduct> y()
  {
    return this.e;
  }
  
  public List<com.tplink.iot.view.ipcamera.widget.calendar.d> z0(List<HasVideoTime> paramList, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (HasVideoTime)paramList.next();
      if (localObject != null)
      {
        long l1 = o0.s(((HasVideoTime)localObject).getDeviceLocalTime(), paramString);
        if (l1 != -1L)
        {
          localObject = y0(Long.valueOf(l1), paramString);
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
      }
    }
    return localArrayList;
  }
  
  class a
    implements Observer<List<OrderInfo>>
  {
    a() {}
    
    public void a(@Nullable List<OrderInfo> paramList)
    {
      CloudVideoViewModel.f(CloudVideoViewModel.this).postValue(paramList);
    }
  }
  
  class b
    implements io.reactivex.g0.g<Throwable>
  {
    b() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      CloudVideoViewModel.g(CloudVideoViewModel.this).postValue(new com.tplink.iot.model.cloudvideo.a(true, false));
    }
  }
  
  class c
    implements io.reactivex.g0.j<DeviceCloudProduct, Boolean>
  {
    c() {}
    
    public Boolean a(DeviceCloudProduct paramDeviceCloudProduct)
      throws Exception
    {
      return Boolean.TRUE;
    }
  }
  
  class d
    implements io.reactivex.g0.g<Throwable>
  {
    d() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      CloudVideoViewModel.h(CloudVideoViewModel.this).postValue(Boolean.FALSE);
    }
  }
  
  class e
    implements io.reactivex.g0.a
  {
    e() {}
    
    public void run()
      throws Exception
    {
      CloudVideoViewModel.h(CloudVideoViewModel.this).postValue(Boolean.TRUE);
    }
  }
  
  class f
    implements io.reactivex.g0.g<Throwable>
  {
    f() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      CloudVideoViewModel.i(CloudVideoViewModel.this, -1L);
      CloudVideoViewModel.j(CloudVideoViewModel.this).postValue(null);
    }
  }
  
  class g
    implements io.reactivex.g0.g<DeviceCloudProduct>
  {
    g(String paramString) {}
    
    public void a(final DeviceCloudProduct paramDeviceCloudProduct)
      throws Exception
    {
      CloudVideoViewModel.i(CloudVideoViewModel.this, paramDeviceCloudProduct.getEndTime());
      CloudVideoViewModel.j(CloudVideoViewModel.this).postValue(paramDeviceCloudProduct);
      final CameraSettingRepository localCameraSettingRepository = (CameraSettingRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(b.d.w.h.a.g(paramString), CameraSettingRepository.class);
      q.f1(localCameraSettingRepository.H(), localCameraSettingRepository.M(), new a(localCameraSettingRepository, paramDeviceCloudProduct)).L0(io.reactivex.l0.a.c()).F0();
    }
    
    class a
      implements io.reactivex.g0.c<SdCardStatus, Boolean, Boolean>
    {
      a(CameraSettingRepository paramCameraSettingRepository, DeviceCloudProduct paramDeviceCloudProduct) {}
      
      public Boolean a(SdCardStatus paramSdCardStatus, Boolean paramBoolean)
        throws Exception
      {
        paramBoolean = localCameraSettingRepository.x().getAccountInfo();
        if (paramBoolean != null) {
          paramBoolean = paramBoolean.getUsername();
        } else {
          paramBoolean = "";
        }
        if ((CloudVideoViewModel.this.X(paramDeviceCloudProduct)) && (CloudVideoViewModel.k(CloudVideoViewModel.this, paramSdCardStatus)) && (!TextUtils.isEmpty(paramBoolean)) && (!"---".equals(paramBoolean))) {
          CloudVideoViewModel.l(CloudVideoViewModel.this).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.TRUE));
        } else {
          o.h0().C0(CloudVideoViewModel.g.this.c, true);
        }
        return Boolean.TRUE;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\cloudvideo\CloudVideoViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */