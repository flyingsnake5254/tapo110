package com.tplink.libtpnetwork.cameranetwork.business.repo;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import android.util.Pair;
import com.google.gson.Gson;
import com.tplink.cloud.bean.device.result.DeviceConfigInfoListResult;
import com.tplink.cloud.bean.device.result.DeviceConfigInfoResult;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCDeviceRepository;
import com.tplink.libtpnetwork.Utils.i;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpnetwork.Utils.z;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.bean.CameraAvatarInfo;
import com.tplink.libtpnetwork.cameranetwork.bean.CameraBasicInfo;
import com.tplink.libtpnetwork.cameranetwork.bean.CameraDeviceFeatureCache;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceAvatarFeatureInfo;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceFeatureInfo;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.FirmwareManager;
import com.tplink.libtpnetwork.cameranetwork.f4;
import com.tplink.libtpnetwork.cameranetwork.g4.m;
import com.tplink.libtpnetwork.cameranetwork.model.Account;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmMultiInfo;
import com.tplink.libtpnetwork.cameranetwork.model.BasicInfo;
import com.tplink.libtpnetwork.cameranetwork.model.BindStatus;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.ComponentBean;
import com.tplink.libtpnetwork.cameranetwork.model.ComponentType;
import com.tplink.libtpnetwork.cameranetwork.model.HomePageDeviceInfo;
import com.tplink.libtpnetwork.cameranetwork.model.LastAlarmInfo;
import com.tplink.libtpnetwork.cameranetwork.model.Method;
import com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch;
import com.tplink.libtpnetwork.cameranetwork.model.P2PSharePwd;
import com.tplink.libtpnetwork.cameranetwork.model.RecordPlanInfo;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.Schedule;
import com.tplink.libtpnetwork.cameranetwork.model.ScheduleParser;
import com.tplink.libtpnetwork.cameranetwork.model.UpnpCommStatus;
import com.tplink.libtpnetwork.cameranetwork.model.UpnpMultiInfo;
import com.tplink.libtpnetwork.cameranetwork.model.UpnpPsk;
import com.tplink.libtpnetwork.cameranetwork.net.CameraException;
import com.tplink.libtpnetwork.cameranetwork.util.JsonUtils;
import com.tplink.libtpnetwork.enumerate.EnumIoTDeviceState;
import io.reactivex.g0.j;
import io.reactivex.g0.l;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.v;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonCameraRepository
  extends com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c
{
  private o d = o.h0();
  private TCDeviceRepository e;
  private io.reactivex.e0.b f = new io.reactivex.e0.b();
  private volatile boolean g = false;
  private long h;
  private io.reactivex.m0.g<com.tplink.libtpnetwork.cameranetwork.common.a<DeviceConfigInfoListResult>> i;
  private com.tplink.cloud.context.b j;
  private TPIoTClientManager k;
  
  public CommonCameraRepository(TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramTPCameraDeviceContext);
    com.tplink.cloud.context.b localb = paramTPCameraDeviceContext.getTcAccountContext();
    this.j = localb;
    this.k = ((TPIoTClientManager)b.d.b.f.b.a(localb, TPIoTClientManager.class));
    this.e = ((TCDeviceRepository)b.d.b.f.b.c(paramTPCameraDeviceContext.getTcAccountContext()).a(TCDeviceRepository.class));
    this.i = io.reactivex.m0.b.n1().l1();
    this.h = 0L;
  }
  
  private q<Boolean> L0()
  {
    ALCameraDevice localALCameraDevice = (ALCameraDevice)((TPCameraDeviceContext)this.a).getCameraDevice();
    if (localALCameraDevice == null) {
      return q.f0(Boolean.FALSE);
    }
    CameraComponent localCameraComponent = localALCameraDevice.getCameraComponent();
    if ((localALCameraDevice.isUserRoleTypeDevice()) && (localALCameraDevice.getP2PSharePwd() == null))
    {
      if ((localCameraComponent != null) && (localCameraComponent.hasComponent(ComponentType.DEVICE_SHARE))) {
        return h0().g0(h1.c);
      }
      return q.f0(Boolean.FALSE);
    }
    return q.f0(Boolean.TRUE);
  }
  
  private q<Boolean> M0()
  {
    Object localObject = (ALCameraDevice)((TPCameraDeviceContext)this.a).getCameraDevice();
    if (localObject == null) {
      return q.f0(Boolean.FALSE);
    }
    localObject = ((ALCameraDevice)localObject).getCameraComponent();
    if ((localObject != null) && (((CameraComponent)localObject).isSupportUpnp())) {
      return i0().g0(u1.c);
    }
    return q.f0(Boolean.FALSE);
  }
  
  private q<Boolean> P0()
  {
    if (!((TPCameraDeviceContext)this.a).isOwner()) {
      return q.J(new Exception("user cannot setup for FFS"));
    }
    Object localObject1 = ((TPCameraDeviceContext)this.a).getAccountContext().c();
    localObject1 = new Account(((TCAccountBean)localObject1).getCloudUserName(), ((TCAccountBean)localObject1).getPassword(), false);
    Object localObject2 = ScheduleParser.formatRecordSchedules(Collections.singletonList(new Schedule(0, 0, 24, 0, 2)));
    localObject2 = new RecordPlanInfo(OptionSwitch.ON.toString(), (String)localObject2, (String)localObject2, (String)localObject2, (String)localObject2, (String)localObject2, (String)localObject2, (String)localObject2);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(((TPCameraDeviceContext)this.a).getAccountContext().c().getCloudUserName());
    ((StringBuilder)localObject3).append("_");
    ((StringBuilder)localObject3).append(z.b(((ALCameraDevice)((TPCameraDeviceContext)this.a).getIoTDevice()).getDeviceMac()));
    localObject3 = ((StringBuilder)localObject3).toString();
    return l().c3((Account)localObject1, (String)localObject3, com.tplink.libtpnetwork.cameranetwork.util.c.b, com.tplink.libtpnetwork.cameranetwork.util.c.c, (RecordPlanInfo)localObject2).L(new a()).g0(new y()).v0(2L, new x());
  }
  
  private q<CameraComponent> Q0()
  {
    return l().E().i(m.a()).L0(io.reactivex.l0.a.c()).E(new d());
  }
  
  private q<Boolean> S0(final ALCameraDevice paramALCameraDevice)
  {
    CameraComponent localCameraComponent;
    if (paramALCameraDevice != null) {
      localCameraComponent = paramALCameraDevice.getCameraComponent();
    } else {
      localCameraComponent = null;
    }
    return l().V(localCameraComponent).g0(new h(paramALCameraDevice)).N(new g(paramALCameraDevice)).N(new f());
  }
  
  private void T0()
  {
    ALCameraDevice localALCameraDevice = (ALCameraDevice)((TPCameraDeviceContext)this.a).getCameraDevice();
    if (localALCameraDevice != null) {
      localALCameraDevice.setDeviceState(EnumIoTDeviceState.OFFLINE);
    }
  }
  
  private void U0()
  {
    ALCameraDevice localALCameraDevice = (ALCameraDevice)((TPCameraDeviceContext)this.a).getCameraDevice();
    if (localALCameraDevice != null) {
      localALCameraDevice.setDeviceState(EnumIoTDeviceState.ONLINE);
    }
  }
  
  private void V0(String paramString, List<ComponentBean> paramList)
  {
    paramString = new CameraDeviceFeatureCache(paramString, paramList);
    this.d.X0(((TPCameraDeviceContext)this.a).getDeviceIdMD5(), i.h(paramString));
  }
  
  private byte[] W(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    try
    {
      localByteArrayOutputStream.flush();
      localByteArrayOutputStream.close();
      paramBitmap = localByteArrayOutputStream.toByteArray();
    }
    catch (IOException paramBitmap)
    {
      b.d.w.c.a.d(paramBitmap.toString());
      paramBitmap = null;
    }
    return paramBitmap;
  }
  
  private void W0(ALCameraDevice paramALCameraDevice, CameraAvatarInfo paramCameraAvatarInfo, DeviceFeatureInfo paramDeviceFeatureInfo, String paramString)
  {
    paramDeviceFeatureInfo.setLastUpdateTimestamp(Long.valueOf(System.currentTimeMillis()));
    DeviceAvatarFeatureInfo localDeviceAvatarFeatureInfo = paramDeviceFeatureInfo.getDeviceAvatarFeatureInfo();
    if (localDeviceAvatarFeatureInfo != null)
    {
      paramDeviceFeatureInfo = paramCameraAvatarInfo;
      if (paramCameraAvatarInfo == null) {
        paramDeviceFeatureInfo = new CameraAvatarInfo();
      }
      paramDeviceFeatureInfo.setAvatarDefault(localDeviceAvatarFeatureInfo.isDefaultAvatarName());
      paramDeviceFeatureInfo.setAvatarName(localDeviceAvatarFeatureInfo.getAvatarName());
      paramDeviceFeatureInfo.setAvatarRemoteUrl(paramString);
      paramDeviceFeatureInfo.setAvatarNameModified(Boolean.FALSE);
      paramALCameraDevice.setCameraAvatarInfo(paramDeviceFeatureInfo);
    }
  }
  
  @SuppressLint({"CheckResult"})
  private void X(String paramString)
  {
    CameraDeviceFeatureCache localCameraDeviceFeatureCache = (CameraDeviceFeatureCache)i.b(this.d.S(((TPCameraDeviceContext)this.a).getDeviceIdMD5()), CameraDeviceFeatureCache.class);
    if ((paramString != null) && ((localCameraDeviceFeatureCache == null) || (!paramString.equals(localCameraDeviceFeatureCache.getFirmwareVersion())))) {
      Q0().G0(new o());
    }
  }
  
  private q<Boolean> Y()
  {
    return Z(null).E(new r1(this)).C(new n1(this));
  }
  
  private void Y0(ALCameraDevice paramALCameraDevice, String paramString1, String paramString2)
  {
    if (paramALCameraDevice.isRemoteOnline()) {
      X0(paramALCameraDevice, paramString1, paramString2);
    }
  }
  
  private q<Boolean> Z(Account paramAccount)
  {
    ALCameraDevice localALCameraDevice = (ALCameraDevice)((TPCameraDeviceContext)b()).getCameraDevice();
    if (localALCameraDevice == null) {
      return q.f0(Boolean.FALSE);
    }
    if (localALCameraDevice.isRemoteOnly()) {
      return q.f0(Boolean.TRUE);
    }
    if (this.g) {
      return q.f0(Boolean.TRUE);
    }
    return l().d2(paramAccount).g0(o1.c);
  }
  
  private void Z0(ALCameraDevice paramALCameraDevice, String paramString)
  {
    if (paramALCameraDevice.isRemoteOnline()) {
      a1(paramALCameraDevice, paramString, null, true);
    }
  }
  
  private void a1(ALCameraDevice paramALCameraDevice, String paramString1, String paramString2, boolean paramBoolean)
  {
    String str1 = paramALCameraDevice.getDeviceId();
    String str2 = ((TPCameraDeviceContext)b()).getTcAccountContext().c().getCloudUserName();
    String str3 = ((TPCameraDeviceContext)b()).getTcAccountContext().c().getToken();
    Object localObject = new DeviceFeatureInfo();
    ((DeviceFeatureInfo)localObject).setLastUpdateTimestamp(Long.valueOf(System.currentTimeMillis()));
    ((DeviceFeatureInfo)localObject).setDeviceAvatarFeatureInfo(new DeviceAvatarFeatureInfo(Boolean.valueOf(paramBoolean), paramString1));
    localObject = JsonUtils.g(localObject);
    paramALCameraDevice = this.e.X(str2, str1, (String)localObject, str3).C(io.reactivex.l0.a.c()).A(new l1(paramALCameraDevice, paramBoolean, paramString2, paramString1), f7.c);
    this.f.b(paramALCameraDevice);
  }
  
  private void b1(ALCameraDevice paramALCameraDevice)
  {
    CameraAvatarInfo localCameraAvatarInfo = paramALCameraDevice.getCameraAvatarInfo();
    if ((localCameraAvatarInfo != null) && (org.apache.commons.lang.b.b(localCameraAvatarInfo.getAvatarNameModified()))) {
      if (org.apache.commons.lang.b.b(localCameraAvatarInfo.getAvatarDefault())) {
        Z0(paramALCameraDevice, localCameraAvatarInfo.getAvatarName());
      } else {
        Y0(paramALCameraDevice, localCameraAvatarInfo.getAvatarName(), localCameraAvatarInfo.getAvatarRemoteUrl());
      }
    }
  }
  
  private q<Boolean> c0(ALCameraDevice paramALCameraDevice)
  {
    if (paramALCameraDevice.isFirmwareSupportIoTCloud()) {
      return q.f0(Boolean.TRUE);
    }
    return d0(paramALCameraDevice);
  }
  
  private q<Boolean> d0(final ALCameraDevice paramALCameraDevice)
  {
    return q.f0(paramALCameraDevice).L(new m()).N(new l()).N(new j(paramALCameraDevice)).g0(new i(paramALCameraDevice)).q0(Boolean.TRUE);
  }
  
  private q<Boolean> f0(ALCameraDevice paramALCameraDevice)
  {
    if ((paramALCameraDevice != null) && (paramALCameraDevice.getCameraComponent() != null) && (paramALCameraDevice.getCameraComponent().isSupportFirmware())) {
      ((FirmwareManager)b.d.b.f.b.a(((TPCameraDeviceContext)this.a).getAccountContext(), FirmwareManager.class)).f(paramALCameraDevice.getDeviceIdMD5());
    }
    return q.f0(Boolean.TRUE);
  }
  
  private byte[] g0(String paramString)
  {
    if ((paramString != null) && (paramString.length() == 32))
    {
      String[] arrayOfString = new String[16];
      int m = 0;
      int i2;
      for (int n = 0; n < 32; n = i2)
      {
        int i1 = n / 2;
        i2 = n + 2;
        arrayOfString[i1] = paramString.substring(n, i2);
      }
      paramString = new byte[16];
      for (n = m; n < 16; n++) {
        paramString[n] = ((byte)(byte)Integer.valueOf(arrayOfString[n], 16).intValue());
      }
      return paramString;
    }
    return null;
  }
  
  private q<P2PSharePwd> h0()
  {
    return l().g0().i(m.a()).L0(io.reactivex.l0.a.c()).E(new p1(this));
  }
  
  private q<UpnpMultiInfo> i0()
  {
    return l().x0().i(m.a()).L0(io.reactivex.l0.a.c()).E(new t1(this));
  }
  
  private boolean k0(ALCameraDevice paramALCameraDevice, DeviceConfigInfoResult paramDeviceConfigInfoResult)
  {
    DeviceFeatureInfo localDeviceFeatureInfo = (DeviceFeatureInfo)new Gson().l(paramDeviceConfigInfoResult.getFeatureInfo(), DeviceFeatureInfo.class);
    if (localDeviceFeatureInfo == null)
    {
      b1(paramALCameraDevice);
      return true;
    }
    CameraAvatarInfo localCameraAvatarInfo = paramALCameraDevice.getCameraAvatarInfo();
    DeviceAvatarFeatureInfo localDeviceAvatarFeatureInfo = localDeviceFeatureInfo.getDeviceAvatarFeatureInfo();
    if ((localDeviceAvatarFeatureInfo != null) && (localCameraAvatarInfo != null) && (m0(localDeviceAvatarFeatureInfo, new DeviceAvatarFeatureInfo(localCameraAvatarInfo.getAvatarDefault(), localCameraAvatarInfo.getAvatarName())))) {
      W0(paramALCameraDevice, localCameraAvatarInfo, localDeviceFeatureInfo, paramDeviceConfigInfoResult.getAvatarUrl());
    } else if ((localCameraAvatarInfo != null) && (org.apache.commons.lang.b.b(localCameraAvatarInfo.getAvatarNameModified())))
    {
      if (org.apache.commons.lang.b.b(localCameraAvatarInfo.getAvatarDefault())) {
        Z0(paramALCameraDevice, localCameraAvatarInfo.getAvatarName());
      } else {
        Y0(paramALCameraDevice, localCameraAvatarInfo.getAvatarName(), localCameraAvatarInfo.getAvatarRemoteUrl());
      }
    }
    else if ((localCameraAvatarInfo != null) && (org.apache.commons.lang.b.a(localCameraAvatarInfo.getAvatarNameModified()))) {
      W0(paramALCameraDevice, localCameraAvatarInfo, localDeviceFeatureInfo, paramDeviceConfigInfoResult.getAvatarUrl());
    } else if ((localCameraAvatarInfo == null) || (TextUtils.isEmpty(localCameraAvatarInfo.getAvatarRemoteUrl())) || (TextUtils.isEmpty(localCameraAvatarInfo.getAvatarName()))) {
      W0(paramALCameraDevice, localCameraAvatarInfo, localDeviceFeatureInfo, paramDeviceConfigInfoResult.getAvatarUrl());
    }
    return true;
  }
  
  private boolean l0()
  {
    String str = ((TPCameraDeviceContext)this.a).getDeviceIdMD5();
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (str != null) {
      if (((FirmwareManager)b.d.b.f.b.a(((TPCameraDeviceContext)this.a).getAccountContext(), FirmwareManager.class)).g(((TPCameraDeviceContext)this.a).getDeviceIdMD5()) == null) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
    }
    return bool2;
  }
  
  public q<CameraComponent> K0()
  {
    ALCameraDevice localALCameraDevice = (ALCameraDevice)((TPCameraDeviceContext)this.a).getCameraDevice();
    if ((localALCameraDevice != null) && (localALCameraDevice.getCameraComponent() != null)) {
      return q.f0(localALCameraDevice.getCameraComponent());
    }
    return Q0();
  }
  
  public boolean N0(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) && (paramObject2 == null)) {
      return true;
    }
    if (paramObject1 == null) {
      return false;
    }
    if (paramObject2 == null) {
      return false;
    }
    return paramObject1.equals(paramObject2);
  }
  
  public q<Boolean> O0(UpnpCommStatus paramUpnpCommStatus)
  {
    ALCameraDevice localALCameraDevice = (ALCameraDevice)((TPCameraDeviceContext)b()).getCameraDevice();
    if (localALCameraDevice != null) {
      localALCameraDevice.setUpnpCommStatus(paramUpnpCommStatus);
    }
    return l().Z2(paramUpnpCommStatus).g0(j1.c);
  }
  
  public q<Boolean> R0()
  {
    final ALCameraDevice localALCameraDevice = (ALCameraDevice)((TPCameraDeviceContext)this.a).getCameraDevice();
    if (localALCameraDevice == null) {
      return q.f0(Boolean.FALSE);
    }
    return l().Q().g0(new q(localALCameraDevice)).v0(1L, new p()).q0(Boolean.FALSE);
  }
  
  public void X0(ALCameraDevice paramALCameraDevice, String paramString1, String paramString2)
  {
    if (!this.e.K()) {
      return;
    }
    paramALCameraDevice = q.f0(paramString2).g0(new s1(this)).N(new k1(this, paramALCameraDevice)).L0(io.reactivex.l0.a.c()).H0(new q1(this, paramALCameraDevice, paramString1, paramString2), f7.c);
    this.f.b(paramALCameraDevice);
  }
  
  public void a0()
  {
    ALCameraDevice localALCameraDevice = (ALCameraDevice)((TPCameraDeviceContext)this.a).getCameraDevice();
    if (localALCameraDevice == null) {
      return;
    }
    localALCameraDevice.setP2PSharePwd(null);
    CameraComponent localCameraComponent = localALCameraDevice.getCameraComponent();
    if ((localALCameraDevice.isUserRoleTypeDevice()) && (localCameraComponent != null) && (localCameraComponent.hasComponent(ComponentType.DEVICE_SHARE))) {
      h0().L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).F0();
    }
  }
  
  public q<Pair<byte[], byte[]>> b0()
  {
    return l().w().i(m.a()).L0(io.reactivex.l0.a.c()).g0(new i1(this));
  }
  
  public q<Boolean> d()
  {
    return Y();
  }
  
  public void e()
  {
    super.e();
    this.f.dispose();
  }
  
  public q<Boolean> e0()
  {
    final ALCameraDevice localALCameraDevice = (ALCameraDevice)((TPCameraDeviceContext)b()).getCameraDevice();
    if (localALCameraDevice == null) {
      return q.f0(Boolean.FALSE);
    }
    return S0(localALCameraDevice).E(new b(localALCameraDevice));
  }
  
  public q<Boolean> f()
  {
    boolean bool;
    if ((((TPCameraDeviceContext)this.a).getIoTDevice() != null) && (((ALCameraDevice)((TPCameraDeviceContext)this.a).getIoTDevice()).isOnline())) {
      bool = true;
    } else {
      bool = false;
    }
    return q.f0(Boolean.valueOf(bool)).N(new c()).q0(Boolean.FALSE);
  }
  
  public q<Boolean> g()
  {
    return f();
  }
  
  public q<Boolean> h()
  {
    return q.f0(Boolean.TRUE).E(new n());
  }
  
  public q<Boolean> j()
  {
    final ALCameraDevice localALCameraDevice = (ALCameraDevice)((TPCameraDeviceContext)b()).getCameraDevice();
    if (localALCameraDevice == null) {
      return q.f0(Boolean.FALSE);
    }
    return l().Q().g0(new w(localALCameraDevice)).v0(1L, new v()).N(new u(localALCameraDevice)).N(new t()).N(new s()).E(new r(localALCameraDevice)).C(new k()).q0(Boolean.FALSE);
  }
  
  public q<UpnpPsk> j0()
  {
    return l().y0().i(m.a()).L0(io.reactivex.l0.a.c()).E(new m1(this)).C(new e());
  }
  
  public io.reactivex.a k()
  {
    l().e2();
    return io.reactivex.a.e();
  }
  
  public boolean m0(DeviceAvatarFeatureInfo paramDeviceAvatarFeatureInfo1, DeviceAvatarFeatureInfo paramDeviceAvatarFeatureInfo2)
  {
    if ((paramDeviceAvatarFeatureInfo1 == null) && (paramDeviceAvatarFeatureInfo2 == null)) {
      return true;
    }
    if ((paramDeviceAvatarFeatureInfo1 != null) && (paramDeviceAvatarFeatureInfo2 != null))
    {
      if (!N0(paramDeviceAvatarFeatureInfo1.getAvatarName(), paramDeviceAvatarFeatureInfo2.getAvatarName())) {
        return false;
      }
      return N0(paramDeviceAvatarFeatureInfo1.isDefaultAvatarName(), paramDeviceAvatarFeatureInfo2.isDefaultAvatarName());
    }
    return false;
  }
  
  class a
    implements l<Response<BindStatus>>
  {
    a() {}
    
    public boolean a(Response<BindStatus> paramResponse)
      throws Exception
    {
      return Method.CHANGE_ADMIN_PASSWORD.getValue().equals(paramResponse.getMethod());
    }
  }
  
  class b
    implements io.reactivex.g0.g<Boolean>
  {
    b(ALCameraDevice paramALCameraDevice) {}
    
    public void a(Boolean paramBoolean)
      throws Exception
    {
      CommonCameraRepository.S(CommonCameraRepository.this, localALCameraDevice).L0(io.reactivex.l0.a.c()).F0();
    }
  }
  
  class c
    implements j<Boolean, t<Boolean>>
  {
    c() {}
    
    public t<Boolean> a(Boolean paramBoolean)
      throws Exception
    {
      if (paramBoolean.booleanValue()) {
        return CommonCameraRepository.this.e0().E(new b()).C(new a());
      }
      return CommonCameraRepository.this.j().E(new c());
    }
    
    class a
      implements io.reactivex.g0.g<Throwable>
    {
      a() {}
      
      public void a(Throwable paramThrowable)
        throws Exception
      {
        String str;
        if (((TPCameraDeviceContext)CommonCameraRepository.v(CommonCameraRepository.this)).getCameraDevice() != null) {
          str = ((ALCameraDevice)((TPCameraDeviceContext)CommonCameraRepository.w(CommonCameraRepository.this)).getCameraDevice()).getDeviceMac();
        } else {
          str = "";
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("offline");
        localStringBuilder.append(str);
        localStringBuilder.append(paramThrowable.getMessage());
        b.d.w.c.a.c("cameraTest", localStringBuilder.toString());
        paramThrowable.printStackTrace();
        CommonCameraRepository.E(CommonCameraRepository.this);
        CommonCameraRepository.x(CommonCameraRepository.this).L3();
      }
    }
    
    class b
      implements io.reactivex.g0.g<Boolean>
    {
      b() {}
      
      public void a(Boolean paramBoolean)
        throws Exception
      {
        b.d.w.c.a.c("cameraTest", "online222222222222");
        CommonCameraRepository.R(CommonCameraRepository.this);
        CommonCameraRepository.y(CommonCameraRepository.this).L3();
        paramBoolean = (ALCameraDevice)((TPCameraDeviceContext)CommonCameraRepository.z(CommonCameraRepository.this)).getIoTDevice();
        if (paramBoolean != null) {
          CommonCameraRepository.A(CommonCameraRepository.this, paramBoolean.getSoftwareVersion());
        }
        if (CommonCameraRepository.P(CommonCameraRepository.this)) {
          CommonCameraRepository.Q(CommonCameraRepository.this, paramBoolean).F0();
        }
      }
    }
    
    class c
      implements io.reactivex.g0.g<Boolean>
    {
      c() {}
      
      public void a(Boolean paramBoolean)
        throws Exception
      {
        CommonCameraRepository.B(CommonCameraRepository.this).L3();
      }
    }
  }
  
  class d
    implements io.reactivex.g0.g<CameraComponent>
  {
    d() {}
    
    public void a(CameraComponent paramCameraComponent)
      throws Exception
    {
      ALCameraDevice localALCameraDevice = (ALCameraDevice)((TPCameraDeviceContext)CommonCameraRepository.C(CommonCameraRepository.this)).getCameraDevice();
      if (localALCameraDevice != null) {
        localALCameraDevice.setCameraComponent(paramCameraComponent);
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
      paramThrowable.getLocalizedMessage();
    }
  }
  
  class f
    implements j<Boolean, t<Boolean>>
  {
    f() {}
    
    public t<Boolean> a(Boolean paramBoolean)
      throws Exception
    {
      return CommonCameraRepository.U(CommonCameraRepository.this).q0(Boolean.TRUE);
    }
  }
  
  class g
    implements j<Boolean, t<Boolean>>
  {
    g(ALCameraDevice paramALCameraDevice) {}
    
    public t<Boolean> a(Boolean paramBoolean)
      throws Exception
    {
      if ((paramALCameraDevice.getBasicInfo() != null) && (paramALCameraDevice.getBasicInfo().isFfs())) {
        return CommonCameraRepository.V(CommonCameraRepository.this);
      }
      return q.f0(Boolean.TRUE);
    }
  }
  
  class h
    implements j<Response<AlarmMultiInfo>, Boolean>
  {
    h(ALCameraDevice paramALCameraDevice) {}
    
    public Boolean a(Response<AlarmMultiInfo> paramResponse)
      throws Exception
    {
      paramResponse = (AlarmMultiInfo)paramResponse.getResult();
      BasicInfo localBasicInfo = paramResponse.getDeviceInfo();
      Object localObject = paramResponse.getLastAlarmInfo();
      if (localBasicInfo != null) {
        paramALCameraDevice.setBasicInfo(localBasicInfo);
      }
      if (localObject != null) {
        paramALCameraDevice.setLastAlarmInfo((LastAlarmInfo)localObject);
      }
      localObject = paramALCameraDevice;
      if ((localObject != null) && (((ALCameraDevice)localObject).getCameraComponent() != null) && (paramALCameraDevice.getCameraComponent().isSupportUpnp()))
      {
        paramALCameraDevice.setUpnpInfo(paramResponse.getUpnpInfo());
        paramALCameraDevice.setUpnpCommStatus(paramResponse.getUpnpCommStatus());
        paramALCameraDevice.setUpnpStatus(paramResponse.getUpnpStatus());
        paramALCameraDevice.setPubIp(paramResponse.getPubIp());
        paramALCameraDevice.setUpnpPsk(paramResponse.getUpnpPsk());
      }
      return Boolean.TRUE;
    }
  }
  
  class i
    implements j<DeviceConfigInfoResult, Boolean>
  {
    i(ALCameraDevice paramALCameraDevice) {}
    
    public Boolean a(DeviceConfigInfoResult paramDeviceConfigInfoResult)
      throws Exception
    {
      return Boolean.valueOf(CommonCameraRepository.D(CommonCameraRepository.this, paramALCameraDevice, paramDeviceConfigInfoResult));
    }
  }
  
  class j
    implements j<DeviceConfigInfoListResult, t<DeviceConfigInfoResult>>
  {
    j(ALCameraDevice paramALCameraDevice) {}
    
    public t<DeviceConfigInfoResult> a(DeviceConfigInfoListResult paramDeviceConfigInfoListResult)
      throws Exception
    {
      paramDeviceConfigInfoListResult = paramDeviceConfigInfoListResult.getDeviceConfigInfo();
      if (paramDeviceConfigInfoListResult.isEmpty()) {
        return q.J(new Exception("DeviceConfigInfo is Empty"));
      }
      paramDeviceConfigInfoListResult = (DeviceConfigInfoResult)paramDeviceConfigInfoListResult.get(0);
      if (paramDeviceConfigInfoListResult.getDeviceId().equals(paramALCameraDevice.getDeviceId())) {
        return q.f0(paramDeviceConfigInfoListResult);
      }
      return q.J(new Exception("DeviceConfigInfo Not fit"));
    }
  }
  
  class k
    implements io.reactivex.g0.g<Throwable>
  {
    k() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      String str;
      if (((TPCameraDeviceContext)CommonCameraRepository.s(CommonCameraRepository.this)).getCameraDevice() != null) {
        str = ((ALCameraDevice)((TPCameraDeviceContext)CommonCameraRepository.t(CommonCameraRepository.this)).getCameraDevice()).getDeviceMac();
      } else {
        str = "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("offline--");
      localStringBuilder.append(str);
      localStringBuilder.append(paramThrowable.getMessage());
      b.d.w.c.a.c("cameraTest", localStringBuilder.toString());
      paramThrowable.printStackTrace();
      CommonCameraRepository.E(CommonCameraRepository.this);
    }
  }
  
  class l
    implements j<ALCameraDevice, t<DeviceConfigInfoListResult>>
  {
    l() {}
    
    public t<DeviceConfigInfoListResult> a(ALCameraDevice paramALCameraDevice)
      throws Exception
    {
      if ((CommonCameraRepository.F(CommonCameraRepository.this) > 0L) && (System.currentTimeMillis() - CommonCameraRepository.F(CommonCameraRepository.this) < 30000L)) {
        return CommonCameraRepository.H(CommonCameraRepository.this).Q0(1L).N(new a()).T0(15L, TimeUnit.SECONDS).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
      }
      CommonCameraRepository.G(CommonCameraRepository.this, System.currentTimeMillis());
      paramALCameraDevice = Collections.singletonList(paramALCameraDevice.getDeviceId());
      return CommonCameraRepository.I(CommonCameraRepository.this).z(paramALCameraDevice).E(new c()).C(new b());
    }
    
    class a
      implements j<com.tplink.libtpnetwork.cameranetwork.common.a<DeviceConfigInfoListResult>, t<DeviceConfigInfoListResult>>
    {
      a() {}
      
      public t<DeviceConfigInfoListResult> a(com.tplink.libtpnetwork.cameranetwork.common.a<DeviceConfigInfoListResult> parama)
        throws Exception
      {
        if (parama.a() != null) {
          return q.f0(parama.a());
        }
        return q.J(parama.b());
      }
    }
    
    class b
      implements io.reactivex.g0.g<Throwable>
    {
      b() {}
      
      public void a(Throwable paramThrowable)
        throws Exception
      {
        CommonCameraRepository.H(CommonCameraRepository.this).onNext(new com.tplink.libtpnetwork.cameranetwork.common.a(paramThrowable));
      }
    }
    
    class c
      implements io.reactivex.g0.g<DeviceConfigInfoListResult>
    {
      c() {}
      
      public void a(DeviceConfigInfoListResult paramDeviceConfigInfoListResult)
        throws Exception
      {
        CommonCameraRepository.H(CommonCameraRepository.this).onNext(new com.tplink.libtpnetwork.cameranetwork.common.a(paramDeviceConfigInfoListResult));
      }
    }
  }
  
  class m
    implements l<ALCameraDevice>
  {
    m() {}
    
    public boolean a(ALCameraDevice paramALCameraDevice)
      throws Exception
    {
      boolean bool;
      if ((paramALCameraDevice.isRemoteOnline()) && (!paramALCameraDevice.isLocalOnly())) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  class n
    implements io.reactivex.g0.g<Boolean>
  {
    n() {}
    
    public void a(Boolean paramBoolean)
      throws Exception
    {
      if ((((TPCameraDeviceContext)CommonCameraRepository.J(CommonCameraRepository.this)).getIoTDevice() == null) || (((ALCameraDevice)((TPCameraDeviceContext)CommonCameraRepository.K(CommonCameraRepository.this)).getIoTDevice()).getThingDevice() == null)) {
        if ((((TPCameraDeviceContext)CommonCameraRepository.L(CommonCameraRepository.this)).getCameraDevice() != null) && (!((ALCameraDevice)((TPCameraDeviceContext)CommonCameraRepository.M(CommonCameraRepository.this)).getCameraDevice()).isFirmwareSupportIoTCloud()) && (((ALCameraDevice)((TPCameraDeviceContext)CommonCameraRepository.N(CommonCameraRepository.this)).getCameraDevice()).getCloudCameraDevice() != null))
        {
          CommonCameraRepository.this.l().h2().i(m.g()).L0(io.reactivex.l0.a.c()).F0();
        }
        else
        {
          CommonCameraRepository.this.l().h2().i(m.g()).L0(io.reactivex.l0.a.c()).F0();
          CommonCameraRepository.this.l().e3().i(m.g()).L0(io.reactivex.l0.a.c()).F0();
        }
      }
    }
  }
  
  class o
    implements io.reactivex.g0.g<CameraComponent>
  {
    o() {}
    
    public void a(CameraComponent paramCameraComponent)
      throws Exception
    {
      Object localObject = (ALCameraDevice)((TPCameraDeviceContext)CommonCameraRepository.O(CommonCameraRepository.this)).getIoTDevice();
      if (localObject != null)
      {
        localObject = ((ALCameraDevice)localObject).getLocalIoTDevice();
        if (localObject != null) {
          CommonCameraRepository.u(CommonCameraRepository.this, ((CameraBasicInfo)localObject).getSoftwareVer(), paramCameraComponent.getComponentList());
        }
      }
    }
  }
  
  class p
    implements l<Throwable>
  {
    p() {}
    
    public boolean a(Throwable paramThrowable)
      throws Exception
    {
      return paramThrowable instanceof CameraException;
    }
  }
  
  class q
    implements j<Response<HomePageDeviceInfo>, Boolean>
  {
    q(ALCameraDevice paramALCameraDevice) {}
    
    public Boolean a(Response<HomePageDeviceInfo> paramResponse)
      throws Exception
    {
      Object localObject = (HomePageDeviceInfo)paramResponse.getResult();
      BasicInfo localBasicInfo = ((HomePageDeviceInfo)localObject).getDeviceInfo();
      paramResponse = ((HomePageDeviceInfo)localObject).getLastAlarmInfo();
      localObject = ((HomePageDeviceInfo)localObject).getComponentInfo();
      if (localBasicInfo != null) {
        localALCameraDevice.setBasicInfo(localBasicInfo);
      }
      if (paramResponse != null) {
        localALCameraDevice.setLastAlarmInfo(paramResponse);
      }
      if (localObject != null) {
        localALCameraDevice.setCameraComponent((CameraComponent)localObject);
      }
      if (localObject != null) {
        CommonCameraRepository.u(CommonCameraRepository.this, localALCameraDevice.getSoftwareVersion(), ((CameraComponent)localObject).getComponentList());
      }
      return Boolean.TRUE;
    }
  }
  
  class r
    implements io.reactivex.g0.g<Boolean>
  {
    r(ALCameraDevice paramALCameraDevice) {}
    
    public void a(Boolean paramBoolean)
      throws Exception
    {
      b.d.w.c.a.c("cameraTest", "online11111111");
      if ((localALCameraDevice.getDeviceState() != EnumIoTDeviceState.ONLINE) || (CommonCameraRepository.P(CommonCameraRepository.this))) {
        CommonCameraRepository.Q(CommonCameraRepository.this, localALCameraDevice).L0(io.reactivex.l0.a.c()).F0();
      }
      CommonCameraRepository.R(CommonCameraRepository.this);
      CommonCameraRepository.S(CommonCameraRepository.this, localALCameraDevice).L0(io.reactivex.l0.a.c()).F0();
      b.d.w.c.a.c("cameraTest", "online");
    }
  }
  
  class s
    implements j<Boolean, t<Boolean>>
  {
    s() {}
    
    public t<Boolean> a(Boolean paramBoolean)
      throws Exception
    {
      return CommonCameraRepository.T(CommonCameraRepository.this).q0(Boolean.TRUE);
    }
  }
  
  class t
    implements j<Boolean, t<Boolean>>
  {
    t() {}
    
    public t<Boolean> a(Boolean paramBoolean)
      throws Exception
    {
      return CommonCameraRepository.U(CommonCameraRepository.this).q0(Boolean.TRUE);
    }
  }
  
  class u
    implements j<Boolean, t<Boolean>>
  {
    u(ALCameraDevice paramALCameraDevice) {}
    
    public t<Boolean> a(Boolean paramBoolean)
      throws Exception
    {
      if ((localALCameraDevice.getBasicInfo() != null) && (localALCameraDevice.getBasicInfo().isFfs())) {
        return CommonCameraRepository.V(CommonCameraRepository.this);
      }
      return q.f0(Boolean.TRUE);
    }
  }
  
  class v
    implements l<Throwable>
  {
    v() {}
    
    public boolean a(Throwable paramThrowable)
      throws Exception
    {
      return paramThrowable instanceof CameraException;
    }
  }
  
  class w
    implements j<Response<HomePageDeviceInfo>, Boolean>
  {
    w(ALCameraDevice paramALCameraDevice) {}
    
    public Boolean a(Response<HomePageDeviceInfo> paramResponse)
      throws Exception
    {
      Object localObject = (HomePageDeviceInfo)paramResponse.getResult();
      paramResponse = ((HomePageDeviceInfo)localObject).getDeviceInfo();
      LastAlarmInfo localLastAlarmInfo = ((HomePageDeviceInfo)localObject).getLastAlarmInfo();
      localObject = ((HomePageDeviceInfo)localObject).getComponentInfo();
      if (paramResponse != null) {
        localALCameraDevice.setBasicInfo(paramResponse);
      }
      if (localLastAlarmInfo != null) {
        localALCameraDevice.setLastAlarmInfo(localLastAlarmInfo);
      }
      if (localObject != null) {
        localALCameraDevice.setCameraComponent((CameraComponent)localObject);
      }
      if (localObject != null) {
        CommonCameraRepository.u(CommonCameraRepository.this, localALCameraDevice.getSoftwareVersion(), ((CameraComponent)localObject).getComponentList());
      }
      return Boolean.TRUE;
    }
  }
  
  class x
    implements l<Throwable>
  {
    x() {}
    
    public boolean a(Throwable paramThrowable)
      throws Exception
    {
      return true;
    }
  }
  
  class y
    implements j<Response<BindStatus>, Boolean>
  {
    y() {}
    
    public Boolean a(Response<BindStatus> paramResponse)
      throws Exception
    {
      return Boolean.valueOf(paramResponse.isSuccess());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\repo\CommonCameraRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */