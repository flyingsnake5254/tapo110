package com.tplink.libtpnetwork.IoTNetwork.repository;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.cloud.bean.thing.common.ThingDetail;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingRealTimeInfo;
import com.tplink.iot.cloud.bean.thing.common.ThingSetting;
import com.tplink.iot.cloud.bean.thing.common.ThingShadow;
import com.tplink.iot.cloud.bean.thing.common.ThingShadowState;
import com.tplink.iot.cloud.bean.thing.params.ThingShadowUpdateParams;
import com.tplink.iot.cloud.bean.thing.result.ThingShadowResult;
import com.tplink.iot.cloud.mqtt.MqttRepository;
import com.tplink.libtpnetwork.IoTNetwork.EnumIoTTransportType;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.IoTDataWrapper;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceResetParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.DeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.common.ChildRequestData;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.common.IoTSubRequest;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.common.IoTSubResponse;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.common.SubMultipleRequest;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.c;
import com.tplink.libtpnetwork.IoTNetwork.x;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import com.tplink.libtpnetwork.Utils.n;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.exception.IoTTransportException;
import io.reactivex.g0.j;
import io.reactivex.m0.d;
import io.reactivex.q;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ThingBaseRepository
  extends com.tplink.libtpnetwork.IoTNetwork.repository.kb.b
  implements jb.c
{
  protected ThingCloudRepository d;
  protected MqttRepository e;
  private boolean f = false;
  protected io.reactivex.m0.g<IoTDataWrapper<ThingShadowResult>> g = d.n1();
  protected jb h;
  protected DeviceInfoParams i;
  protected ThingSetting j;
  protected AtomicInteger k = new AtomicInteger(0);
  protected AtomicBoolean l = new AtomicBoolean(false);
  private boolean m;
  protected MutableLiveData<LocalIoTBaseDevice> n = new MutableLiveData();
  protected MutableLiveData<ThingRealTimeInfo> o = new MutableLiveData();
  
  public ThingBaseRepository(ThingContext paramThingContext)
  {
    super(paramThingContext);
    b.d.b.d.b.b localb = b.d.b.f.b.c(paramThingContext.getAccountContext());
    this.d = ((ThingCloudRepository)localb.a(ThingCloudRepository.class));
    this.e = ((MqttRepository)localb.a(MqttRepository.class));
    this.h = new jb(paramThingContext, this.d, this, this);
  }
  
  private void B0(String paramString1, String paramString2)
  {
    if (((ThingContext)this.a).isThingOnline()) {
      z(paramString1, paramString2).F0();
    }
  }
  
  private io.reactivex.a E0()
  {
    String str1 = u();
    String str2 = y();
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
      return this.e.B0(str1, str2, this.h);
    }
    return io.reactivex.a.e();
  }
  
  private io.reactivex.a G0()
  {
    String str1 = u();
    String str2 = y();
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
      return this.e.C0(str1, str2);
    }
    return io.reactivex.a.e();
  }
  
  private void I0(ThingSetting paramThingSetting)
  {
    ThingSetting localThingSetting = ((ThingContext)this.a).getThingSetting();
    if ((localThingSetting != null) && (paramThingSetting != null))
    {
      if (!TextUtils.isEmpty(paramThingSetting.getAvatarUrl())) {
        localThingSetting.setAvatarUrl(paramThingSetting.getAvatarUrl());
      }
      if (!TextUtils.isEmpty(paramThingSetting.getNickname())) {
        localThingSetting.setNickname(paramThingSetting.getNickname());
      }
      if (paramThingSetting.getCommonDevice() != null) {
        localThingSetting.setCommonDevice(paramThingSetting.getCommonDevice());
      }
      if (!TextUtils.isEmpty(paramThingSetting.getRegion())) {
        localThingSetting.setRegion(paramThingSetting.getRegion());
      }
      if (!TextUtils.isEmpty(paramThingSetting.getLang())) {
        localThingSetting.setLang(paramThingSetting.getLang());
      }
      if (paramThingSetting.getTimeDiff() != null) {
        localThingSetting.setTimeDiff(paramThingSetting.getTimeDiff());
      }
      if (paramThingSetting.getLongitude() != null) {
        localThingSetting.setLongitude(paramThingSetting.getLongitude());
      }
      if (paramThingSetting.getLatitude() != null) {
        localThingSetting.setLatitude(paramThingSetting.getLatitude());
      }
      if (!TextUtils.isEmpty(paramThingSetting.getSpecs())) {
        localThingSetting.setSpecs(paramThingSetting.getSpecs());
      }
      if (paramThingSetting.getDefaultStates() != null) {
        localThingSetting.setDefaultStates(paramThingSetting.getDefaultStates());
      }
      this.b.L3();
    }
  }
  
  private <T> T n(ThingDetail paramThingDetail, ThingSetting paramThingSetting, ThingShadowResult paramThingShadowResult, ThingModel paramThingModel, Class<T> paramClass)
    throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
  {
    if (paramThingModel != null) {
      ((ThingContext)this.a).setThingModel(paramThingModel);
    }
    return (T)paramClass.getConstructor(new Class[] { ThingDetail.class, ThingSetting.class, ThingShadowResult.class, ThingModel.class }).newInstance(new Object[] { paramThingDetail, paramThingSetting, paramThingShadowResult, paramThingModel });
  }
  
  private String u()
  {
    Object localObject = this.a;
    if (localObject != null) {
      localObject = ((ThingContext)localObject).getThingGatewayUrlV2();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  private ThingShadowState v0(ThingShadowState paramThingShadowState1, ThingShadowState paramThingShadowState2)
  {
    if ((paramThingShadowState1 != null) && (paramThingShadowState1.getDesired() != null))
    {
      Object localObject1 = paramThingShadowState2.getDesired();
      paramThingShadowState2 = paramThingShadowState1.getReported();
      if (localObject1 != null)
      {
        Object localObject2 = ((Map)localObject1).get("on");
        if ((localObject2 instanceof Boolean)) {
          paramThingShadowState2.put("on", Boolean.valueOf(((Boolean)localObject2).booleanValue()));
        }
        localObject2 = ((Map)localObject1).get("brightness");
        if ((localObject2 instanceof Number)) {
          paramThingShadowState2.put("brightness", Integer.valueOf(((Number)localObject2).intValue()));
        }
        localObject2 = ((Map)localObject1).get("auto");
        if ((localObject2 instanceof Boolean)) {
          paramThingShadowState2.put("auto", Boolean.valueOf(((Boolean)localObject2).booleanValue()));
        }
        localObject2 = ((Map)localObject1).get("color_temp");
        if ((localObject2 instanceof Number)) {
          paramThingShadowState2.put("color_temp", Integer.valueOf(((Number)localObject2).intValue()));
        }
        localObject2 = ((Map)localObject1).get("hue");
        if ((localObject2 instanceof Number)) {
          paramThingShadowState2.put("hue", Integer.valueOf(((Number)localObject2).intValue()));
        }
        localObject2 = ((Map)localObject1).get("saturation");
        if ((localObject2 instanceof Number)) {
          paramThingShadowState2.put("saturation", Integer.valueOf(((Number)localObject2).intValue()));
        }
        localObject2 = ((Map)localObject1).get("dynamic_light_effect_enable");
        if ((localObject2 instanceof Boolean)) {
          paramThingShadowState2.put("dynamic_light_effect_enable", Boolean.valueOf(((Boolean)localObject2).booleanValue()));
        }
        localObject1 = ((Map)localObject1).get("dynamic_light_effect_id");
        if ((localObject1 instanceof String)) {
          paramThingShadowState2.put("dynamic_light_effect_id", (String)localObject1);
        }
      }
      return paramThingShadowState1;
    }
    return new ThingShadowState(paramThingShadowState2.getDesired(), paramThingShadowState2.getDesired());
  }
  
  private q<ThingModel> w()
  {
    return this.d.n0(((ThingContext)this.a).getThingUrl(), ((ThingContext)this.a).getThingModelId());
  }
  
  private q<com.tplink.libtpnetwork.IoTNetwork.common.a> x(String paramString1, String paramString2)
  {
    com.tplink.libtpnetwork.IoTNetwork.common.a locala = new com.tplink.libtpnetwork.IoTNetwork.common.a();
    return w().N(new ia(this, locala, paramString1, paramString2)).g0(new ma(locala));
  }
  
  private String y()
  {
    Object localObject = this.a;
    if (localObject != null) {
      localObject = ((ThingContext)localObject).getThingName();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  private q<ThingRealTimeInfo> z(String paramString1, String paramString2)
  {
    return this.d.p0(paramString1, paramString2).E(new c());
  }
  
  protected <T extends DeviceRunningInfoResult> q<T> A(String paramString1, String paramString2, Class<T> paramClass, boolean paramBoolean)
  {
    return q.e1(this.d.f0(paramString1, paramString2), B(paramString1, paramString2), x(paramString1, paramString2), new x9(this, paramBoolean, paramClass));
  }
  
  protected <T, R> q<R> A0(String paramString, T paramT, final Class<R> paramClass, EnumIoTTransportType paramEnumIoTTransportType)
  {
    paramT = new IoTSubRequest("multipleRequest", new SubMultipleRequest(Arrays.asList(new IoTSubRequest[] { new IoTSubRequest(paramString, paramT) })));
    ((ALIoTDevice)((ThingContext)this.a).getIoTDevice()).getDeviceId();
    return z0("control_child", new ChildRequestData(paramT, ((ALIoTDevice)((ThingContext)this.a).getIoTDevice()).getDeviceId()), com.google.gson.i.class, paramEnumIoTTransportType).i(n.b(paramString, paramClass)).g0(new b(paramClass));
  }
  
  protected q<ThingSetting> B(String paramString1, String paramString2)
  {
    return q.X(new w9(this)).N(new pa(this, paramString1, paramString2)).L0(io.reactivex.l0.a.c());
  }
  
  protected q<ThingShadowResult> C(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      return q.X(new la(this)).N(new da(this, paramString1, paramString2)).L0(io.reactivex.l0.a.c());
    }
    return q.f0(s());
  }
  
  public io.reactivex.a C0(int paramInt)
  {
    return y0("device_reset", new DeviceResetParams(paramInt), Boolean.class).Z();
  }
  
  public boolean D()
  {
    x localx = this.c;
    boolean bool;
    if ((localx != null) && (localx.s())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected q<Boolean> D0(EnumIoTTransportType paramEnumIoTTransportType)
  {
    return q.X(new ja(this, paramEnumIoTTransportType));
  }
  
  protected boolean E()
  {
    String str1 = u();
    String str2 = y();
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
      return this.e.D(str1, str2);
    }
    return false;
  }
  
  protected boolean F()
  {
    boolean bool;
    if (((ThingContext)this.a).getThingDevice() != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected boolean F0(Throwable paramThrowable)
  {
    boolean bool;
    if ((F()) && (IoTTransportException.isTransportNotAvailableException(paramThrowable))) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool) {
      p();
    }
    return bool;
  }
  
  protected void H0()
  {
    G0().C(io.reactivex.l0.a.c()).y();
  }
  
  public io.reactivex.a J0(boolean paramBoolean)
  {
    if (((ThingContext)this.a).getIoTDevice() != null)
    {
      this.m = ((ALIoTDevice)((ThingContext)this.a).getIoTDevice()).isCommonDevice();
      this.b.L3();
      ((ALIoTDevice)((ThingContext)this.a).getIoTDevice()).setCommonDevice(paramBoolean);
    }
    ThingSetting localThingSetting = new ThingSetting();
    localThingSetting.setCommonDevice(Boolean.valueOf(paramBoolean));
    return this.d.s1(((ThingContext)this.a).getThingUrl(), ((ThingContext)this.a).getThingName(), localThingSetting).j(new ca(this));
  }
  
  protected ThingShadowResult K0(ThingShadowResult paramThingShadowResult)
  {
    ThingShadowResult localThingShadowResult = new ThingShadowResult();
    localThingShadowResult.setThingName(paramThingShadowResult.getThingName());
    localThingShadowResult.setVersion(paramThingShadowResult.getVersion());
    localThingShadowResult.setState(paramThingShadowResult.getState());
    Object localObject = ((ThingContext)this.a).getThingShadow();
    if (localObject != null)
    {
      localObject = ((ThingShadow)localObject).getState();
      if (localObject != null) {
        localThingShadowResult.setState(v0(paramThingShadowResult.getState(), (ThingShadowState)localObject));
      }
    }
    return localThingShadowResult;
  }
  
  protected <T> q<com.google.gson.i> L0(String paramString, T paramT)
  {
    return this.d.p1(((ThingContext)this.a).getThingUrl(), ((ThingContext)this.a).getThingName(), paramString, com.tplink.libtpnetwork.Utils.i.i(paramT));
  }
  
  protected io.reactivex.a M0(ThingSetting paramThingSetting)
  {
    this.j = paramThingSetting;
    return this.d.s1(((ThingContext)this.a).getThingUrl(), ((ThingContext)this.a).getThingName(), paramThingSetting).l(new na(this, paramThingSetting)).j(new d()).h(new fa(this));
  }
  
  public void a()
  {
    if ((((ThingContext)this.a).getIoTDevice() != null) && (((ALIoTDevice)((ThingContext)this.a).getIoTDevice()).getLocalIoTDevice() != null)) {
      this.n.postValue(((ALIoTDevice)((ThingContext)this.a).getIoTDevice()).getLocalIoTDevice());
    }
    this.b.L3();
  }
  
  protected void e()
  {
    this.c.l();
    this.k.set(0);
    H0();
    super.e();
  }
  
  public q<Boolean> h()
  {
    return C0(0).J();
  }
  
  protected <T extends DeviceInfoParams> ThingShadowUpdateParams o(T paramT)
  {
    return new ThingShadowUpdateParams(((ThingContext)this.a).getThingShadowVersion() + 1L, new ThingShadowState(paramT.toMap()));
  }
  
  protected void p()
  {
    E0().C(io.reactivex.l0.a.c()).y();
  }
  
  protected ThingShadowResult q(ThingShadowResult paramThingShadowResult)
  {
    ThingShadowResult localThingShadowResult = paramThingShadowResult;
    if (!this.h.f())
    {
      localThingShadowResult = paramThingShadowResult;
      if (paramThingShadowResult.getVersion() > ((ThingContext)this.a).getThingShadowVersion())
      {
        localThingShadowResult = K0(paramThingShadowResult);
        ((ThingContext)this.a).setThingShadow(localThingShadowResult);
      }
    }
    return localThingShadowResult;
  }
  
  @SuppressLint({"CheckResult"})
  protected void r(String paramString1, String paramString2)
  {
    q.f0(Integer.valueOf(1)).L0(io.reactivex.l0.a.d()).L(new z9(this)).N(new oa(this, paramString1, paramString2)).l0(io.reactivex.l0.a.d()).H0(new ha(this), new qa(this));
  }
  
  protected ThingShadowResult s()
  {
    ThingShadowResult localThingShadowResult = new ThingShadowResult();
    localThingShadowResult.setThingName(((ThingContext)this.a).getThingName());
    Object localObject = ((ThingContext)this.a).getThingShadow();
    if (localObject != null)
    {
      localThingShadowResult.setVersion(((ThingShadow)localObject).getVersion());
      ThingShadowState localThingShadowState = ((ThingShadow)localObject).getState();
      if (localThingShadowState != null)
      {
        localObject = new HashMap();
        if (localThingShadowState.getReported() != null) {
          ((Map)localObject).putAll(localThingShadowState.getReported());
        }
        if (localThingShadowState.getDesired() != null) {
          ((Map)localObject).putAll(localThingShadowState.getDesired());
        }
        localThingShadowResult.setState(new ThingShadowState(localThingShadowState.getDesired(), (Map)localObject));
      }
    }
    return localThingShadowResult;
  }
  
  protected q<com.google.gson.i> t(String paramString)
  {
    return this.d.i0(((ThingContext)this.a).getThingUrl(), ((ThingContext)this.a).getThingName(), paramString);
  }
  
  protected <T extends LocalIoTBaseDevice> q<T> v(String paramString1, String paramString2, Class<T> paramClass)
  {
    return q.e1(this.d.f0(paramString1, paramString2), B(paramString1, paramString2), x(paramString1, paramString2), new ea(this, paramClass));
  }
  
  public q<ThingShadowResult> w0(String paramString1, String paramString2)
  {
    return this.g.Q0(1L).F(new ka(this, paramString1, paramString2)).l0(io.reactivex.l0.a.c()).N(ba.c);
  }
  
  protected <R> q<R> x0(String paramString, Class<R> paramClass)
  {
    return y0(paramString, null, paramClass);
  }
  
  protected <T, R> q<R> y0(String paramString, T paramT, Class<R> paramClass)
  {
    if (((ThingContext)this.a).isSubDevice()) {
      return A0(paramString, paramT, paramClass, null);
    }
    return z0(paramString, paramT, paramClass, null);
  }
  
  protected <T, R> q<R> z0(String paramString, T paramT, Class<R> paramClass, EnumIoTTransportType paramEnumIoTTransportType)
  {
    return D0(paramEnumIoTTransportType).N(new v9(this, paramString, paramT, paramClass, paramEnumIoTTransportType)).g0(new ga(paramClass)).E(new a());
  }
  
  class a
    implements io.reactivex.g0.g<R>
  {
    a() {}
    
    public void accept(R paramR)
      throws Exception
    {
      ThingBaseRepository.this.H0();
    }
  }
  
  class b
    implements j<IoTSubResponse<R>, R>
  {
    b(Class paramClass) {}
    
    public R a(IoTSubResponse<R> paramIoTSubResponse)
      throws Exception
    {
      if ((paramIoTSubResponse.getResult() == null) && (paramClass == Boolean.class)) {
        return Boolean.TRUE;
      }
      if (paramIoTSubResponse.getResult() == null) {
        return (R)paramClass.newInstance();
      }
      return (R)paramIoTSubResponse.getResult();
    }
  }
  
  class c
    implements io.reactivex.g0.g<ThingRealTimeInfo>
  {
    c() {}
    
    public void a(ThingRealTimeInfo paramThingRealTimeInfo)
      throws Exception
    {
      ThingBaseRepository.this.o.postValue(paramThingRealTimeInfo);
      Object localObject = (ALIoTDevice)((ThingContext)ThingBaseRepository.l(ThingBaseRepository.this)).getIoTDevice();
      if (localObject != null)
      {
        localObject = ((ALIoTDevice)localObject).getLocalIoTDevice();
        if (localObject != null) {
          ((LocalIoTBaseDevice)localObject).updateThingRealTimeInfo(paramThingRealTimeInfo);
        }
      }
      localObject = (LocalIoTBaseDevice)ThingBaseRepository.this.n.getValue();
      if (localObject != null)
      {
        ((LocalIoTBaseDevice)localObject).updateThingRealTimeInfo(paramThingRealTimeInfo);
        ThingBaseRepository.this.n.postValue(localObject);
      }
    }
  }
  
  class d
    implements io.reactivex.g0.g<Throwable>
  {
    d() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      paramThrowable = ThingBaseRepository.this;
      ThingBaseRepository.m(paramThrowable, paramThrowable.j);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\repository\ThingBaseRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */