package com.tplink.iot.model.firmware;

import android.annotation.SuppressLint;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.Utils.n;
import com.tplink.iot.cloud.bean.thing.common.FirmwareDownloadState;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractSubThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.BulbRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.HubRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.LightStripRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.PlugRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.SensorRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.SwitchRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.TRVRepository;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.business.repo.FirmwareRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.FirmwareManager;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.u;
import com.tplink.libtpnetwork.enumerate.EnumIoTDeviceState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class FirmwareUpdateManager
  extends b.d.b.f.a
{
  private TPIoTClientManager c;
  private FirmwareManager d;
  private Map<String, IotSeriesBean> e = new HashMap();
  private Map<String, IotSeriesBean> f = new HashMap();
  private MutableLiveData<List<IotSeriesBean>> g = new MutableLiveData();
  private SingleLiveEvent<Boolean> h = new SingleLiveEvent();
  private SingleLiveEvent<Boolean> i = new SingleLiveEvent();
  private Map<String, io.reactivex.e0.c> j = new HashMap();
  
  public FirmwareUpdateManager(com.tplink.cloud.context.b paramb)
  {
    super(paramb);
    this.c = ((TPIoTClientManager)b.d.b.f.b.a(paramb, TPIoTClientManager.class));
    this.d = ((FirmwareManager)b.d.b.f.b.a(paramb, FirmwareManager.class));
  }
  
  private void d0(List<t> paramList)
  {
    if (paramList == null) {
      return;
    }
    String str = b.d.s.a.a.h();
    com.google.gson.f localf = new com.google.gson.f();
    com.google.gson.k localk1 = new com.google.gson.k();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      t localt = (t)paramList.next();
      com.google.gson.k localk2 = new com.google.gson.k();
      localk2.m("type", "SMART.IPCAMERA");
      localk2.m("model", localt.d().getDeviceModel());
      localk2.m("device_id", localt.a());
      localf.j(localk2);
    }
    localk1.j("success_upgrade_device_list", localf);
    localk1.m("user_email", str);
    n.b().f("firmware_update", "firmware_update_complete", com.tplink.libtpnetwork.Utils.i.f(localk1));
  }
  
  private void e(IotSeriesBean paramIotSeriesBean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramIotSeriesBean.getIoTDeviceStateList().iterator();
    int k = 0;
    int i1;
    for (int m = 0; localIterator.hasNext(); m = i1)
    {
      localObject = (t)localIterator.next();
      int n = k;
      i1 = m;
      if (((t)localObject).b() == 2)
      {
        n = k + 1;
        i1 = m + ((t)localObject).f();
      }
      localStringBuilder.append("[");
      localStringBuilder.append(((t)localObject).b());
      localStringBuilder.append(", ");
      localStringBuilder.append(((t)localObject).f());
      localStringBuilder.append("] ");
      k = n;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("checkSeriesIsDownloadingAndDeal ");
    ((StringBuilder)localObject).append(paramIotSeriesBean.getId());
    ((StringBuilder)localObject).append(" state list: ");
    ((StringBuilder)localObject).append(localStringBuilder);
    b.d.w.c.a.e("FirmwareUpdateManager", ((StringBuilder)localObject).toString());
    if (k == paramIotSeriesBean.getIoTDeviceStateList().size())
    {
      paramIotSeriesBean.setCurrentState(EnumIoTSeriesState.DOWNLOADING);
      paramIotSeriesBean.setProgress(m / paramIotSeriesBean.getIoTDeviceStateList().size());
      paramIotSeriesBean = paramIotSeriesBean.getIoTDeviceStateList().iterator();
      while (paramIotSeriesBean.hasNext()) {
        k((t)paramIotSeriesBean.next());
      }
    }
  }
  
  private void e0(boolean paramBoolean)
  {
    if (this.e.size() == 0)
    {
      this.f.clear();
    }
    else
    {
      Object localObject1 = this.f.entrySet().iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (this.e.get(((Map.Entry)localObject2).getKey()) == null) {
          ((Iterator)localObject1).remove();
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("publishRefreshSeriesList SeriesMap.values() size: ");
      ((StringBuilder)localObject1).append(this.e.values().size());
      b.d.w.c.a.e("FirmwareUpdateManager", ((StringBuilder)localObject1).toString());
      Iterator localIterator = this.e.values().iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (IotSeriesBean)localIterator.next();
        localObject1 = (IotSeriesBean)this.f.get(((IotSeriesBean)localObject2).getId());
        if (localObject1 != null) {
          b.d.w.c.a.e("FirmwareUpdateManager", ((IotSeriesBean)localObject1).toString());
        }
        if ((localObject1 != null) && (((IotSeriesBean)localObject1).getCurrentState() == EnumIoTSeriesState.DOWNLOADING))
        {
          ((IotSeriesBean)localObject1).replaceAllDevices(((IotSeriesBean)localObject2).getIoTDeviceStateList());
          m0(((IotSeriesBean)localObject2).getId(), false, false);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("start(tempIotSeriesBean.getId(), false, false): ");
          ((StringBuilder)localObject1).append(((IotSeriesBean)localObject2).getId());
          b.d.w.c.a.c("FirmwareUpdateManager", ((StringBuilder)localObject1).toString());
        }
        else
        {
          Map localMap = this.f;
          if (localObject1 != null) {
            localObject1 = ((IotSeriesBean)localObject1).getId();
          } else {
            localObject1 = ((IotSeriesBean)localObject2).getId();
          }
          localMap.put(localObject1, localObject2);
          if (((IotSeriesBean)localObject2).getIoTDeviceStateList() != null) {
            localObject1 = (t)((IotSeriesBean)localObject2).getIoTDeviceStateList().get(0);
          } else {
            localObject1 = null;
          }
          if ((localObject1 != null) && (!((t)localObject1).j()))
          {
            if (((t)localObject1).n()) {
              f((IotSeriesBean)localObject2);
            } else {
              e((IotSeriesBean)localObject2);
            }
          }
          else if ((localObject1 != null) && (((t)localObject1).j()))
          {
            g((IotSeriesBean)localObject2);
            b.d.w.c.a.c("FirmwareUpdateManager", "publishRefreshSeriesList: checkSeriesIsInstallingAndDeal");
          }
        }
      }
    }
    this.g.postValue(new ArrayList(this.f.values()));
    if (paramBoolean) {
      this.h.postValue(Boolean.FALSE);
    } else {
      this.i.postValue(Boolean.FALSE);
    }
  }
  
  private void f(IotSeriesBean paramIotSeriesBean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramIotSeriesBean.getIoTDeviceStateList().iterator();
    int k = 0;
    int i2;
    for (int m = 0; localIterator.hasNext(); m = i2)
    {
      localObject = (t)localIterator.next();
      int n = ((t)localObject).b();
      int i1;
      if ((n != 2) && (n != 3))
      {
        i1 = k;
        i2 = m;
        if (n != 1) {}
      }
      else
      {
        i1 = k + 1;
        if (n == 3) {
          i2 = 100;
        } else {
          i2 = ((t)localObject).f();
        }
        i2 = m + i2;
      }
      localStringBuilder.append("[");
      localStringBuilder.append(((t)localObject).b());
      localStringBuilder.append(", ");
      localStringBuilder.append(((t)localObject).f());
      localStringBuilder.append("] ");
      k = i1;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("checkSeriesIsDownloadingAndDealForSubDevice ");
    ((StringBuilder)localObject).append(paramIotSeriesBean.getId());
    ((StringBuilder)localObject).append(" state list: ");
    ((StringBuilder)localObject).append(localStringBuilder);
    b.d.w.c.a.e("FirmwareUpdateManager", ((StringBuilder)localObject).toString());
    if (k == paramIotSeriesBean.getIoTDeviceStateList().size())
    {
      paramIotSeriesBean.setCurrentState(EnumIoTSeriesState.DOWNLOADING);
      paramIotSeriesBean.setProgress(m / paramIotSeriesBean.getIoTDeviceStateList().size());
      paramIotSeriesBean = paramIotSeriesBean.getIoTDeviceStateList().iterator();
      while (paramIotSeriesBean.hasNext()) {
        k((t)paramIotSeriesBean.next());
      }
    }
  }
  
  private void g(IotSeriesBean paramIotSeriesBean)
  {
    if ((paramIotSeriesBean != null) && (paramIotSeriesBean.getIoTDeviceStateList() != null))
    {
      Iterator localIterator = paramIotSeriesBean.getIoTDeviceStateList().iterator();
      while (localIterator.hasNext())
      {
        t localt = (t)localIterator.next();
        Object localObject = (ALCameraDevice)localt.d();
        localObject = this.d.g(((ALCameraDevice)localObject).getDeviceIdMD5());
        if ((localObject != null) && (!((u)localObject).f()))
        {
          paramIotSeriesBean.setCurrentState(EnumIoTSeriesState.INSTALLING);
          paramIotSeriesBean.setProgress(100);
          b.d.w.c.a.c("FirmwareUpdate", "checkSeriesIsInstallingAndDeal: --- camera installing");
          n(paramIotSeriesBean, localt);
        }
      }
    }
  }
  
  private void g0(IotSeriesBean paramIotSeriesBean)
  {
    if ((paramIotSeriesBean != null) && (this.f.size() != 0))
    {
      Object localObject = paramIotSeriesBean.getIoTDeviceStateList();
      int k = 0;
      boolean bool = ((t)((List)localObject).get(0)).j();
      Iterator localIterator = paramIotSeriesBean.getIoTDeviceStateList().iterator();
      int m = 0;
      int n = 0;
      while (localIterator.hasNext())
      {
        localObject = (t)localIterator.next();
        int i1 = n + ((t)localObject).f();
        int i2 = k;
        if (((t)localObject).l()) {
          i2 = k + 1;
        }
        k = i2;
        n = i1;
        if (bool)
        {
          k = i2;
          n = i1;
          if (((t)localObject).c() != EnumIoTSeriesState.IDLE)
          {
            m++;
            k = i2;
            n = i1;
          }
        }
      }
      paramIotSeriesBean.setSuccessCount(k);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshSeriesBean -- downloadSuccessCount = ");
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append(" cameraCompleteCount = ");
      ((StringBuilder)localObject).append(m);
      b.d.w.c.a.c("FirmwareUpdate", ((StringBuilder)localObject).toString());
      paramIotSeriesBean.setProgress(n / paramIotSeriesBean.getIoTDeviceStateList().size());
      if ((bool) && (m == paramIotSeriesBean.getIoTDeviceStateList().size()))
      {
        paramIotSeriesBean.setCurrentState(EnumIoTSeriesState.SUCCESS);
        b.d.w.c.a.c("FirmwareUpdate", "refreshSeriesBean setCurrentState EnumIoTSeriesState.SUCCESS");
      }
      else if ((!bool) && (paramIotSeriesBean.getProgress() < 100))
      {
        paramIotSeriesBean.setCurrentState(EnumIoTSeriesState.DOWNLOADING);
        b.d.w.c.a.c("FirmwareUpdate", "refreshSeriesBean setCurrentState EnumIoTSeriesState.DOWNLOADING");
      }
      else if (paramIotSeriesBean.getProgress() == 100)
      {
        paramIotSeriesBean.setCurrentState(EnumIoTSeriesState.INSTALLING);
        b.d.w.c.a.c("FirmwareUpdate", "refreshSeriesBean setCurrentState EnumIoTSeriesState.INSTALLING");
        if (!bool) {
          if (paramIotSeriesBean.isInstallFollowDownloaded())
          {
            io.reactivex.q.W0(paramIotSeriesBean.getInstallTime(), TimeUnit.SECONDS).E(new g(this, paramIotSeriesBean)).F0();
          }
          else
          {
            paramIotSeriesBean.setCurrentState(EnumIoTSeriesState.SUCCESS);
            this.g.postValue(new ArrayList(this.f.values()));
          }
        }
      }
      this.g.postValue(new ArrayList(this.f.values()));
      return;
    }
    this.g.postValue(new ArrayList(this.f.values()));
  }
  
  @SuppressLint({"CheckResult"})
  private void h(IotSeriesBean paramIotSeriesBean, t paramt)
  {
    u localu = this.d.g(paramt.a());
    if (localu != null) {
      localu.j(false);
    }
    b.d.w.c.a.c("FirmwareUpdate", "doCameraFirmware");
    ((FirmwareRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(paramt.a(), FirmwareRepository.class)).V().H0(new d(this, paramIotSeriesBean, paramt), new a(this, paramt, paramIotSeriesBean));
  }
  
  private io.reactivex.a h0(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return ((BulbRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(paramString, BulbRepository.class)).d5();
    }
    return ((PlugRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(paramString, PlugRepository.class)).d5();
  }
  
  private FirmwareDownloadState i()
  {
    FirmwareDownloadState localFirmwareDownloadState = new FirmwareDownloadState();
    localFirmwareDownloadState.setDownloadProgress(100);
    localFirmwareDownloadState.setStatus(3);
    return localFirmwareDownloadState;
  }
  
  @SuppressLint({"CheckResult"})
  private void i0(t paramt, IotSeriesBean paramIotSeriesBean)
  {
    h0(paramt.a(), paramt.i()).A(new q(this, paramt), new p(this, paramt, paramIotSeriesBean));
  }
  
  private io.reactivex.q<Boolean> j(BaseALIoTDevice paramBaseALIoTDevice, Map<String, IotSeriesBean> paramMap)
  {
    return io.reactivex.q.f1(m(paramBaseALIoTDevice), l(paramBaseALIoTDevice, true), new r(paramBaseALIoTDevice, paramMap));
  }
  
  private void j0(t paramt, IotSeriesBean paramIotSeriesBean)
  {
    if ((!paramt.m()) && (!paramt.p()))
    {
      if (paramt.o()) {
        t(paramt.d()).n1().E(new k(this, paramt, paramIotSeriesBean)).C(new h(this, paramt, paramIotSeriesBean)).F0();
      } else {
        i0(paramt, paramIotSeriesBean);
      }
      return;
    }
    paramIotSeriesBean = new StringBuilder();
    paramIotSeriesBean.append("SKIP-TransferRelated: ");
    paramIotSeriesBean.append(paramt.d().getDeviceId());
    b.d.w.c.a.e("FirmwareUpdateManager", paramIotSeriesBean.toString());
  }
  
  private void k(t paramt)
  {
    IotSeriesBean localIotSeriesBean = (IotSeriesBean)this.f.get(paramt.g());
    if ((this.f.size() != 0) && (localIotSeriesBean != null) && (localIotSeriesBean.isInSeries(paramt))) {
      l(paramt.d(), false).E(new b(this, paramt, localIotSeriesBean)).C(new j(this, paramt, localIotSeriesBean)).F0();
    }
  }
  
  private void k0(IotSeriesBean paramIotSeriesBean, t paramt, boolean paramBoolean)
  {
    paramt.s(100);
    int k;
    if (paramBoolean) {
      k = 3;
    } else {
      k = 64535;
    }
    paramt.q(k);
    EnumIoTSeriesState localEnumIoTSeriesState;
    if (paramBoolean) {
      localEnumIoTSeriesState = EnumIoTSeriesState.SUCCESS;
    } else {
      localEnumIoTSeriesState = EnumIoTSeriesState.INSTALLING;
    }
    paramt.r(localEnumIoTSeriesState);
    if (paramBoolean) {
      d0(paramIotSeriesBean.getIoTDeviceStateList());
    }
    b.d.w.c.a.c("FirmwareUpdate", "setCameraFirmwareResult ");
    g0(paramIotSeriesBean);
  }
  
  private io.reactivex.q<FirmwareDownloadState> l(BaseALIoTDevice paramBaseALIoTDevice, boolean paramBoolean)
  {
    if ((paramBaseALIoTDevice != null) && (paramBaseALIoTDevice.getDeviceIdMD5() != null))
    {
      String str = paramBaseALIoTDevice.getDeviceIdMD5();
      if (paramBaseALIoTDevice.isCamera()) {
        return ((FirmwareRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(str, FirmwareRepository.class)).w().g0(new o(this, str));
      }
      if (paramBaseALIoTDevice.isSubDevice())
      {
        if (paramBoolean) {
          return t(paramBaseALIoTDevice).O0();
        }
        return t(paramBaseALIoTDevice).e1();
      }
      return u(paramBaseALIoTDevice).u1();
    }
    return io.reactivex.q.J(new Exception("device is null"));
  }
  
  private io.reactivex.q<ThingFirmware> m(BaseALIoTDevice paramBaseALIoTDevice)
  {
    if ((paramBaseALIoTDevice != null) && (paramBaseALIoTDevice.getDeviceIdMD5() != null))
    {
      String str = paramBaseALIoTDevice.getDeviceIdMD5();
      if (paramBaseALIoTDevice.isCamera()) {
        return ((FirmwareRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(str, FirmwareRepository.class)).u().N(new m(this, str, paramBaseALIoTDevice));
      }
      if ((!paramBaseALIoTDevice.isSwitch()) && (!paramBaseALIoTDevice.isSensor())) {
        return u(paramBaseALIoTDevice).v1();
      }
      return t(paramBaseALIoTDevice).g1();
    }
    return io.reactivex.q.f0(new ThingFirmware());
  }
  
  private void n(IotSeriesBean paramIotSeriesBean, t paramt)
  {
    FirmwareRepository localFirmwareRepository = (FirmwareRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(paramt.a(), FirmwareRepository.class);
    io.reactivex.e0.c localc = (io.reactivex.e0.c)this.j.get(paramt.a());
    if (localc != null) {
      localc.dispose();
    }
    paramIotSeriesBean = localFirmwareRepository.w().t0(f.c).x0(new com.tplink.libtpnetwork.cameranetwork.g4.k(com.tplink.libtpnetwork.cameranetwork.g4.k.d)).H0(new l(this, paramt, paramIotSeriesBean), new c(this, paramt, paramIotSeriesBean));
    this.j.put(paramt.a(), paramIotSeriesBean);
  }
  
  @SuppressLint({"CheckResult"})
  private void n0(String paramString)
  {
    paramString = (IotSeriesBean)this.f.get(paramString);
    if (paramString == null) {
      return;
    }
    Iterator localIterator = paramString.getIoTDeviceStateList().iterator();
    while (localIterator.hasNext())
    {
      t localt = (t)localIterator.next();
      if (localt.j()) {
        h(paramString, localt);
      } else if (localt.n()) {
        j0(localt, paramString);
      } else {
        i0(localt, paramString);
      }
    }
  }
  
  private void o0(t paramt)
  {
    if (paramt.b() != 3) {
      return;
    }
    paramt = paramt.d();
    if ((paramt != null) && (paramt.getDeviceIdMD5() != null) && (!paramt.isCamera())) {
      if ((!paramt.isSwitch()) && (!paramt.isSensor())) {
        u(paramt).y4(false);
      } else {
        t(paramt).O3(false);
      }
    }
  }
  
  private int s(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2))
    {
      if ((paramInt != 3) && (paramInt != 4)) {
        return 64535;
      }
      return 3;
    }
    return 2;
  }
  
  private AbstractSubThingRepository t(BaseALIoTDevice paramBaseALIoTDevice)
  {
    String str = paramBaseALIoTDevice.getDeviceIdMD5();
    if (paramBaseALIoTDevice.isSwitch()) {
      return (AbstractSubThingRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(str, SwitchRepository.class);
    }
    if (com.tplink.iot.g.d.a.b.k(paramBaseALIoTDevice)) {
      return (AbstractSubThingRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(str, TRVRepository.class);
    }
    return (AbstractSubThingRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(str, SensorRepository.class);
  }
  
  private AbstractThingRepository u(BaseALIoTDevice paramBaseALIoTDevice)
  {
    String str = paramBaseALIoTDevice.getDeviceIdMD5();
    if (paramBaseALIoTDevice.isBulb())
    {
      if (paramBaseALIoTDevice.isLightStrip()) {
        return (AbstractThingRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(str, LightStripRepository.class);
      }
      return (AbstractThingRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(str, BulbRepository.class);
    }
    if (paramBaseALIoTDevice.isHub()) {
      return (AbstractThingRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(str, HubRepository.class);
    }
    return (AbstractThingRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(str, PlugRepository.class);
  }
  
  public void d()
  {
    this.f.clear();
    this.g.postValue(new ArrayList(this.f.values()));
  }
  
  public void f0(boolean paramBoolean)
  {
    this.e.clear();
    if (paramBoolean)
    {
      this.f.clear();
      this.h.postValue(Boolean.TRUE);
    }
    else
    {
      this.i.postValue(Boolean.TRUE);
    }
    Object localObject1 = (List)this.c.C1().getValue();
    if ((localObject1 != null) && (((List)localObject1).size() != 0))
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("AllIoTDevicesList size: ");
      ((StringBuilder)localObject2).append(((List)localObject1).size());
      b.d.w.c.a.e("FirmwareUpdateManager", ((StringBuilder)localObject2).toString());
      localObject2 = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)((Iterator)localObject1).next();
        if (localBaseALIoTDevice.getDeviceState() == EnumIoTDeviceState.ONLINE) {
          ((List)localObject2).add(localBaseALIoTDevice);
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("OnlineDevices size: ");
      ((StringBuilder)localObject1).append(((List)localObject2).size());
      b.d.w.c.a.e("FirmwareUpdateManager", ((StringBuilder)localObject1).toString());
      if (((List)localObject2).size() == 0)
      {
        e0(paramBoolean);
      }
      else
      {
        localObject1 = new io.reactivex.t[((List)localObject2).size()];
        for (int k = 0; k < ((List)localObject2).size(); k++) {
          localObject1[k] = j((BaseALIoTDevice)((List)localObject2).get(k), this.e);
        }
        io.reactivex.q.i0((io.reactivex.t[])localObject1).T0(30L, TimeUnit.SECONDS).L0(io.reactivex.l0.a.c()).z(new e(this, paramBoolean)).C(new i(this, paramBoolean)).F0();
      }
      return;
    }
    e0(paramBoolean);
  }
  
  public void l0(String paramString)
  {
    m0(paramString, false, true);
  }
  
  public void m0(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    IotSeriesBean localIotSeriesBean = (IotSeriesBean)this.f.get(paramString);
    if ((localIotSeriesBean != null) && (!localIotSeriesBean.getIoTDeviceStateList().isEmpty()))
    {
      boolean bool = ((t)localIotSeriesBean.getIoTDeviceStateList().get(0)).j();
      Object localObject;
      if (paramBoolean1)
      {
        localIotSeriesBean.removeUpdateSuccessDevices();
        if (bool)
        {
          localObject = localIotSeriesBean.getIoTDeviceStateList().iterator();
          while (((Iterator)localObject).hasNext()) {
            ((t)((Iterator)localObject).next()).r(EnumIoTSeriesState.IDLE);
          }
        }
      }
      if ((paramBoolean2) && (!bool))
      {
        Iterator localIterator = localIotSeriesBean.getIoTDeviceStateList().iterator();
        while (localIterator.hasNext())
        {
          localObject = (t)localIterator.next();
          if ((!((t)localObject).m()) && (!((t)localObject).p()))
          {
            ((t)localObject).s(0);
            ((t)localObject).q(0);
          }
          else
          {
            ((t)localObject).s(100);
          }
        }
      }
      if (bool) {
        localObject = EnumIoTSeriesState.INSTALLING;
      } else {
        localObject = EnumIoTSeriesState.DOWNLOADING;
      }
      localIotSeriesBean.setCurrentState((EnumIoTSeriesState)localObject);
      g0(localIotSeriesBean);
      n0(paramString);
      return;
    }
    g0(localIotSeriesBean);
  }
  
  public IotSeriesBean o(String paramString)
  {
    return (IotSeriesBean)this.f.get(paramString);
  }
  
  public MutableLiveData<List<IotSeriesBean>> p()
  {
    return this.g;
  }
  
  public SingleLiveEvent<Boolean> q()
  {
    return this.i;
  }
  
  public SingleLiveEvent<Boolean> r()
  {
    return this.h;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\model\firmware\FirmwareUpdateManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */