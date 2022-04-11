package com.tplink.libtpnetwork.cameranetwork.business.repo.firmware;

import androidx.lifecycle.LiveData;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.FirmwareRepository;
import com.tplink.libtpnetwork.cameranetwork.model.LatestFirmwareInfo;
import com.tplink.libtpnetwork.enumerate.EnumIoTDeviceState;
import io.reactivex.m0.d;
import io.reactivex.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class FirmwareManager
  extends b.d.b.f.a
{
  private List<String> c = new ArrayList();
  private Map<String, u> d = new ConcurrentHashMap();
  private d<String> e;
  private io.reactivex.e0.b f = new io.reactivex.e0.b();
  private io.reactivex.m0.g<t<List<String>>> g;
  private TPIoTClientManager h;
  
  public FirmwareManager(com.tplink.cloud.context.b paramb)
  {
    super(paramb);
    io.reactivex.m0.g localg = io.reactivex.m0.b.n1().l1();
    this.g = localg;
    localg.onNext(new t(new ArrayList()));
    this.e = d.n1();
    this.h = ((TPIoTClientManager)b.d.b.f.b.a(paramb, TPIoTClientManager.class));
    J();
  }
  
  private void J()
  {
    this.h.M1().observeForever(new g(this));
  }
  
  private void d(List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject1 = (String)paramList.next();
        Object localObject2 = TPIoTClientManager.I1((String)localObject1);
        if ((localObject2 != null) && (EnumIoTDeviceState.ONLINE != ((BaseALIoTDevice)localObject2).getDeviceState()))
        {
          K((String)localObject1, "normal", Boolean.FALSE);
        }
        else
        {
          CommonCameraRepository localCommonCameraRepository = (CommonCameraRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c((String)localObject1, CommonCameraRepository.class);
          localObject2 = (FirmwareRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c((String)localObject1, FirmwareRepository.class);
          localObject1 = localCommonCameraRepository.K0().L(l.c).N(new h((FirmwareRepository)localObject2)).x0(new com.tplink.libtpnetwork.cameranetwork.g4.k(new int[] { 60, 60 })).E(new n(this, (String)localObject1)).C(new k(this, (String)localObject1)).F0();
          this.f.b((io.reactivex.e0.c)localObject1);
        }
      }
    }
  }
  
  private void e(List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject1 = (String)paramList.next();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getAllDeviceFirmwareInfo:  ");
        ((StringBuilder)localObject2).append((String)localObject1);
        b.d.w.c.a.c("FirmwareManager", ((StringBuilder)localObject2).toString());
        localObject2 = TPIoTClientManager.I1((String)localObject1);
        if ((localObject2 == null) || (EnumIoTDeviceState.ONLINE == ((BaseALIoTDevice)localObject2).getDeviceState()))
        {
          localObject2 = (CommonCameraRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c((String)localObject1, CommonCameraRepository.class);
          FirmwareRepository localFirmwareRepository = (FirmwareRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c((String)localObject1, FirmwareRepository.class);
          localObject1 = ((CommonCameraRepository)localObject2).K0().L(c.c).N(new e(this, localFirmwareRepository, (String)localObject1)).H0(new f((String)localObject1), r.c);
          this.f.b((io.reactivex.e0.c)localObject1);
        }
      }
    }
  }
  
  public void I()
  {
    this.g.D0(1L).Q0(1L).g0(i.c).N(new p(this)).T0(30L, TimeUnit.SECONDS).F0();
  }
  
  public void K(String paramString1, String paramString2, Boolean paramBoolean)
  {
    u localu1 = (u)this.d.get(paramString1);
    u localu2 = localu1;
    if (localu1 == null) {
      localu2 = new u();
    }
    localu2.j("normal".equals(paramString2));
    localu2.k(paramBoolean.booleanValue());
    this.d.put(paramString1, localu2);
    this.e.onNext(paramString1);
  }
  
  public void L(String paramString, LatestFirmwareInfo paramLatestFirmwareInfo)
  {
    u localu = (u)this.d.get(paramString);
    Object localObject = localu;
    if (localu == null) {
      localObject = new u();
    }
    ((u)localObject).i(paramLatestFirmwareInfo.getVersion());
    ((u)localObject).g(paramLatestFirmwareInfo.getRelease_log());
    ((u)localObject).h(paramLatestFirmwareInfo.getType());
    this.d.put(paramString, localObject);
    localObject = this.h.Z1(paramString);
    if (localObject != null) {
      this.h.T0(paramString, s.a((BaseALIoTDevice)localObject, paramLatestFirmwareInfo));
    }
  }
  
  public void M(String paramString)
  {
    this.d.remove(paramString);
    f(paramString);
  }
  
  public void f(String paramString)
  {
    CommonCameraRepository localCommonCameraRepository = (CommonCameraRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(paramString, CommonCameraRepository.class);
    FirmwareRepository localFirmwareRepository = (FirmwareRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(paramString, FirmwareRepository.class);
    paramString = localCommonCameraRepository.K0().L(b.c).N(new a(this, localFirmwareRepository, paramString)).H0(new m(paramString), r.c);
    this.f.b(paramString);
  }
  
  public u g(String paramString)
  {
    return (u)this.d.get(paramString);
  }
  
  public io.reactivex.q<u> h(String paramString)
  {
    return this.e.L(new q(paramString)).g0(new o(this)).l0(io.reactivex.d0.b.a.a());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\repo\firmware\FirmwareManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */