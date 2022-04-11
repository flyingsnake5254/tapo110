package com.tplink.iot.viewmodel.quicksetup.subg;

import android.annotation.SuppressLint;
import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.cloud.bean.family.common.FamilyInfo;
import com.tplink.iot.cloud.bean.family.common.RoomInfo;
import com.tplink.iot.cloud.bean.thing.common.SubThingCategoryBean;
import com.tplink.iot.cloud.bean.thing.common.SubThingSetupInfo;
import com.tplink.iot.cloud.bean.thing.params.SubThingAddListParams;
import com.tplink.iot.cloud.bean.thing.params.SubThingAddParams;
import com.tplink.iot.cloud.bean.thing.params.SubThingCategoryScanParams;
import com.tplink.iot.cloud.bean.thing.params.SubThingQuickSetupInfoListParams;
import com.tplink.iot.cloud.bean.thing.result.SubThingScanListResult;
import com.tplink.iot.view.quicksetup.sub.common.SubDeviceModel;
import com.tplink.iot.view.quicksetup.sub.common.e.b;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.IoTDataWrapper;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.RulePageParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.SubGQuickSetupRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingListPageParams;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyManagerRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import io.reactivex.e0.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SubGViewModel
  extends SubGBaseViewModel
{
  private SubDeviceModel a = SubDeviceModel.SENSOR_T100;
  private com.tplink.iot.view.quicksetup.sub.common.e b = e.b.b;
  private SubThingSetupInfo c;
  private String d;
  private String e;
  private ALIoTDevice f;
  private io.reactivex.m0.e<Integer> g;
  private c h;
  private c i;
  private boolean j;
  private boolean k;
  private boolean l = true;
  public final ObservableField<String> m = new ObservableField("");
  public final ObservableField<String> n = new ObservableField("");
  public final ObservableField<String> o = new ObservableField("");
  public final ObservableInt p = new ObservableInt(0);
  public final ObservableInt q = new ObservableInt(0);
  public final ObservableBoolean r = new ObservableBoolean(false);
  public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<com.tplink.iot.viewmodel.quicksetup.i<SubThingScanListResult>>> s = new MutableLiveData();
  public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> t = new MutableLiveData();
  public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> u = new MutableLiveData();
  public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> v = new MutableLiveData();
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> w = new MutableLiveData();
  private final FamilyManagerRepository x;
  private final ThingCloudRepository y;
  private SubGQuickSetupRepository z;
  
  public SubGViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    paramApplication = b.d.b.f.b.c(b.d.s.a.a.f());
    this.x = ((FamilyManagerRepository)paramApplication.a(FamilyManagerRepository.class));
    this.y = ((ThingCloudRepository)paramApplication.a(ThingCloudRepository.class));
  }
  
  private boolean B()
  {
    SubDeviceModel localSubDeviceModel = this.a;
    boolean bool;
    if ((localSubDeviceModel != SubDeviceModel.SWITCH_S210) && (localSubDeviceModel != SubDeviceModel.SWITCH_S220)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  @SuppressLint({"CheckResult"})
  private void B0(String paramString1, String paramString2, List<String> paramList)
  {
    Object localObject = s();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        RoomInfo localRoomInfo = (RoomInfo)((Iterator)localObject).next();
        if (TextUtils.equals(localRoomInfo.getName(), paramString2))
        {
          localObject = localRoomInfo.getId();
          bool = false;
          break label73;
        }
      }
    }
    localObject = null;
    boolean bool = true;
    label73:
    this.x.M(paramList, paramString1, (String)localObject, paramString2, bool, true).y();
  }
  
  private void F0()
  {
    this.k = true;
    n(1);
  }
  
  private void G0(@Nullable IoTSubDevice paramIoTSubDevice, @Nullable ThingDevice paramThingDevice)
  {
    if (this.f == null) {
      this.f = new ALIoTDevice(paramIoTSubDevice);
    }
    if (paramIoTSubDevice != null) {
      this.f.setLocalIoTDevice(paramIoTSubDevice);
    }
    if (paramThingDevice != null) {
      this.f.setThingDevice(paramThingDevice);
    }
  }
  
  private void i()
  {
    c localc = this.i;
    if ((localc != null) && (!localc.isDisposed())) {
      this.i.dispose();
    }
  }
  
  private void j()
  {
    c localc = this.h;
    if ((localc != null) && (!localc.isDisposed())) {
      this.h.dispose();
    }
  }
  
  private void k()
  {
    this.j = true;
    n(2);
  }
  
  private void l()
  {
    TimeUnit localTimeUnit = TimeUnit.SECONDS;
    this.i = io.reactivex.q.W0(3L, localTimeUnit).N(new l(this)).T0(20L, localTimeUnit).E(new h(this)).C(new i(this)).F0();
  }
  
  private void n(int paramInt)
  {
    io.reactivex.m0.e locale = this.g;
    if ((locale != null) && (!locale.j1()))
    {
      this.g.onNext(Integer.valueOf(paramInt));
      this.g.onComplete();
      if (!this.k) {
        j();
      }
      if (!this.j) {
        i();
      }
    }
  }
  
  private void o0()
  {
    this.j = true;
    p0(548);
  }
  
  @SuppressLint({"CheckResult"})
  private void p()
  {
    if ((this.z != null) && (this.c != null))
    {
      RulePageParams localRulePageParams = new RulePageParams(0);
      this.h = this.z.a1(localRulePageParams).g0(new s(this, localRulePageParams)).w0(o.c).y(new a(this)).H0(new f(this), new k(this));
      return;
    }
    this.k = true;
    p0(543);
    b.d.w.c.a.e("SubGViewModel", "getChildDeviceList()  return ");
  }
  
  private void p0(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("noFindDeviceResult errorCode: ");
    ((StringBuilder)localObject).append(paramInt);
    b.d.w.c.a.d(((StringBuilder)localObject).toString());
    if ((this.k) && (this.j))
    {
      localObject = this.g;
      if ((localObject != null) && (!((io.reactivex.m0.e)localObject).j1()))
      {
        this.g.onNext(Integer.valueOf(0));
        this.g.onComplete();
      }
    }
  }
  
  private void q0()
  {
    this.k = true;
    p0(543);
  }
  
  private io.reactivex.q<Boolean> r0()
  {
    ThingListPageParams localThingListPageParams = new ThingListPageParams(0, 20);
    IoTDataWrapper localIoTDataWrapper = new IoTDataWrapper(Integer.valueOf(0));
    return this.y.l0(localThingListPageParams, b.d.s.c.a.b()).g0(new y(this, localThingListPageParams, localIoTDataWrapper)).w0(w.c).L0(io.reactivex.l0.a.c());
  }
  
  private String w()
  {
    Object localObject1 = this.d;
    Object localObject2 = localObject1;
    if (this.a == SubDeviceModel.SWITCH_S210)
    {
      localObject2 = this.f;
      if (localObject2 != null)
      {
        localObject2 = ((ALIoTDevice)localObject2).getDeviceId();
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("00");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getRealChildDeviceId deviceModel: ");
    ((StringBuilder)localObject1).append(this.a.value());
    ((StringBuilder)localObject1).append(" id: ");
    ((StringBuilder)localObject1).append((String)localObject2);
    b.d.w.c.a.d(((StringBuilder)localObject1).toString());
    return (String)localObject2;
  }
  
  private void w0(int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("setChildDeviceQsInfo findType = ");
    ((StringBuilder)localObject1).append(paramInt);
    b.d.w.c.a.e("SubGViewModel", ((StringBuilder)localObject1).toString());
    h();
    localObject1 = w();
    Object localObject2;
    if (paramInt == 1)
    {
      localObject2 = new DeviceInfoParams();
      ((DeviceInfoParams)localObject2).setAvatar((String)this.o.get());
      ((DeviceInfoParams)localObject2).setNickname((String)this.m.get());
      this.z.p5((DeviceInfoParams)localObject2, (String)localObject1).i(new r(this)).j(new t(this)).y();
    }
    else
    {
      localObject2 = new ArrayList();
      ((List)localObject2).add(this.z.g5((String)localObject1, (String)this.m.get(), (String)this.o.get()));
      localObject1 = new SubThingQuickSetupInfoListParams();
      ((SubThingQuickSetupInfoListParams)localObject1).setDataList((List)localObject2);
      b.d.w.c.a.e("SubGViewModel", "setChildDeviceQsInfo By Cloud");
      this.z.o5((SubThingQuickSetupInfoListParams)localObject1).i(new n(this)).j(new g(this)).y();
    }
    if (this.l)
    {
      this.l = false;
      C0((String)this.n.get());
    }
  }
  
  public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> A()
  {
    return this.w;
  }
  
  public void A0(String paramString)
  {
    this.e = paramString;
    this.z = ((SubGQuickSetupRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(paramString, SubGQuickSetupRepository.class));
  }
  
  @SuppressLint({"CheckResult"})
  public void C0(String paramString)
  {
    String str1;
    if (this.x.X() != null) {
      str1 = this.x.X().getId();
    } else {
      str1 = null;
    }
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(paramString)))
    {
      String str2 = w();
      if (!TextUtils.isEmpty(str2)) {
        B0(str1, paramString, Collections.singletonList(str2));
      }
      return;
    }
    b.d.w.c.a.d("setDeviceFamilyAndRoom2Cloud return");
  }
  
  public void D0(String paramString, List<String> paramList)
  {
    String str;
    if (this.x.X() != null) {
      str = this.x.X().getId();
    } else {
      str = null;
    }
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramString)))
    {
      if ((paramList != null) && (!paramList.isEmpty())) {
        B0(str, paramString, paramList);
      }
      return;
    }
    b.d.w.c.a.d("setDeviceFamilyAndRoom2Cloud return");
  }
  
  public void E0(int paramInt)
  {
    this.w.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(paramInt)));
  }
  
  public void f()
  {
    if (this.z != null)
    {
      Object localObject = this.c;
      if (localObject != null)
      {
        localObject = new SubThingAddParams(((SubThingSetupInfo)localObject).getDeviceId(), this.c.getCategory());
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localObject);
        localObject = new SubThingAddListParams(localArrayList);
        this.z.e5((SubThingAddListParams)localObject).C(io.reactivex.l0.a.c()).i(new m(this)).j(new j(this)).y();
        return;
      }
    }
    this.u.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.FALSE));
  }
  
  public void g()
  {
    String str = w();
    if (!TextUtils.isEmpty(str))
    {
      Object localObject = Collections.singletonList(str);
      if (this.a == SubDeviceModel.SWITCH_S220)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("00");
        localObject = ((StringBuilder)localObject).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("01");
        localObject = Arrays.asList(new String[] { localObject, localStringBuilder.toString() });
      }
      this.x.O0((List)localObject);
    }
  }
  
  public void h()
  {
    j();
    i();
  }
  
  public void m()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("findDeviceByTDPAndCloud child deviceId = ");
    localStringBuilder.append(this.d);
    b.d.w.c.a.e("SubGViewModel", localStringBuilder.toString());
    if (TextUtils.isEmpty(this.d))
    {
      b.d.w.c.a.e("SubGViewModel", "findDeviceByTDPAndCloud empty child deviceId");
      this.v.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.FALSE));
      return;
    }
    this.g = io.reactivex.m0.e.n1();
    this.k = false;
    this.j = false;
    l();
    p();
    this.g.T0(30L, TimeUnit.SECONDS).q0(Integer.valueOf(0)).E(new x(this)).F0();
  }
  
  public String[] o()
  {
    SubDeviceModel localSubDeviceModel = this.a;
    if (localSubDeviceModel == null) {
      return new String[] { "all" };
    }
    return new String[] { localSubDeviceModel.getCategory() };
  }
  
  public String r()
  {
    return this.d;
  }
  
  @Nullable
  public List<RoomInfo> s()
  {
    if (this.x.X() == null) {
      return null;
    }
    return this.x.X().getRooms();
  }
  
  public void s0()
  {
    if (TextUtils.isEmpty((CharSequence)this.m.get()))
    {
      String str = this.b.i();
      this.m.set(str);
    }
  }
  
  public String t()
  {
    return this.e;
  }
  
  public void t0()
  {
    this.s.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(new com.tplink.iot.viewmodel.quicksetup.i(1, null), true));
    this.u.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.FALSE, true));
    this.c = null;
    this.d = null;
  }
  
  @NonNull
  public SubDeviceModel u()
  {
    return this.a;
  }
  
  public void u0()
  {
    this.z.q5().y();
  }
  
  public EnumDeviceType v()
  {
    return this.b.f();
  }
  
  public void v0(String... paramVarArgs)
  {
    if (this.z == null)
    {
      this.s.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(new com.tplink.iot.viewmodel.quicksetup.i(1, null)));
      return;
    }
    SubThingCategoryScanParams localSubThingCategoryScanParams = new SubThingCategoryScanParams();
    ArrayList localArrayList = new ArrayList();
    int i1 = paramVarArgs.length;
    for (int i2 = 0; i2 < i1; i2++) {
      localArrayList.add(new SubThingCategoryBean(paramVarArgs[i2]));
    }
    localSubThingCategoryScanParams.setScanList(localArrayList);
    this.z.f5(localSubThingCategoryScanParams).C(io.reactivex.l0.a.c()).i(new v(this, paramVarArgs)).j(new p(this)).y();
  }
  
  public void x(String... paramVarArgs)
  {
    if (this.z == null)
    {
      this.s.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(new com.tplink.iot.viewmodel.quicksetup.i(1, null)));
      return;
    }
    SubThingCategoryScanParams localSubThingCategoryScanParams = new SubThingCategoryScanParams();
    ArrayList localArrayList = new ArrayList();
    int i1 = paramVarArgs.length;
    for (int i2 = 0; i2 < i1; i2++) {
      localArrayList.add(new SubThingCategoryBean(paramVarArgs[i2]));
    }
    localSubThingCategoryScanParams.setScanList(localArrayList);
    this.z.h5(localSubThingCategoryScanParams).L0(io.reactivex.l0.a.c()).E(new q(this)).C(new u(this)).F0();
  }
  
  public void x0(SubThingSetupInfo paramSubThingSetupInfo)
  {
    this.c = paramSubThingSetupInfo;
  }
  
  public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<com.tplink.iot.viewmodel.quicksetup.i<SubThingScanListResult>>> y()
  {
    return this.s;
  }
  
  public void y0(String paramString)
  {
    this.d = paramString;
  }
  
  @NonNull
  public com.tplink.iot.view.quicksetup.sub.common.e z()
  {
    return this.b;
  }
  
  public void z0(String paramString)
  {
    paramString = SubDeviceModel.fromValue(paramString);
    this.a = paramString;
    this.b = com.tplink.iot.view.quicksetup.sub.common.g.a(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\quicksetup\subg\SubGViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */