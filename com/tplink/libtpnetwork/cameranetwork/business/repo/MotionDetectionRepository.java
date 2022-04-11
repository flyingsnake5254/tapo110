package com.tplink.libtpnetwork.cameranetwork.business.repo;

import androidx.annotation.NonNull;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.SubscribeItemBean;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCMessagePushRepository;
import com.tplink.libtpnetwork.Utils.u;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.business.model.d;
import com.tplink.libtpnetwork.cameranetwork.business.model.g;
import com.tplink.libtpnetwork.cameranetwork.f4;
import com.tplink.libtpnetwork.cameranetwork.g4.m;
import com.tplink.libtpnetwork.cameranetwork.model.MotionDetectConfig;
import com.tplink.libtpnetwork.cameranetwork.model.MotionDetectRegion;
import com.tplink.libtpnetwork.cameranetwork.model.MotionDetectionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch;
import com.tplink.libtpnetwork.cameranetwork.util.j;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang.e;

public class MotionDetectionRepository
  extends com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c
{
  private g d = new g();
  private ALCameraDevice e;
  private TCMessagePushRepository f;
  
  public MotionDetectionRepository(TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramTPCameraDeviceContext);
    this.e = ((ALCameraDevice)paramTPCameraDeviceContext.getCameraDevice());
    this.f = ((TCMessagePushRepository)b.d.b.f.b.c(paramTPCameraDeviceContext.getAccountContext()).a(TCMessagePushRepository.class));
  }
  
  private boolean C(String paramString)
  {
    paramString = x(paramString);
    boolean bool;
    if ((paramString != null) && (paramString.isSubscribeCameraMotion())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void Y(boolean paramBoolean)
  {
    if ((b() != null) && (((TPCameraDeviceContext)b()).getDeviceIdMD5() != null) && (!u.e(((TPCameraDeviceContext)b()).getDeviceIdMD5())) && (paramBoolean)) {
      u.m(((TPCameraDeviceContext)b()).getDeviceIdMD5(), true);
    }
  }
  
  private static g Z(@NonNull MotionDetectionInfo paramMotionDetectionInfo)
  {
    Object localObject1 = paramMotionDetectionInfo.getConfig();
    Object localObject2 = paramMotionDetectionInfo.getRegions();
    g localg = new g();
    if (localObject1 != null)
    {
      localg.h(OptionSwitch.isOn(((MotionDetectConfig)localObject1).getEnabled()));
      localg.k(j.e(((MotionDetectConfig)localObject1).getDigitalSensitivity(), 0));
      if ((e.a(((MotionDetectConfig)localObject1).getEnhanced()) ^ true)) {
        paramMotionDetectionInfo = Boolean.valueOf(OptionSwitch.isOn(((MotionDetectConfig)localObject1).getEnhanced()));
      } else {
        paramMotionDetectionInfo = null;
      }
      localg.i(paramMotionDetectionInfo);
    }
    if (localObject2 != null)
    {
      paramMotionDetectionInfo = new ArrayList(((List)localObject2).size());
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MotionDetectRegion)((Iterator)localObject1).next();
        d locald = new d();
        locald.g(j.e(((MotionDetectRegion)localObject2).getX(), 0));
        locald.h(j.e(((MotionDetectRegion)localObject2).getY(), 0));
        locald.f(j.e(((MotionDetectRegion)localObject2).getWidth(), 0));
        locald.e(j.e(((MotionDetectRegion)localObject2).getHeight(), 0));
        paramMotionDetectionInfo.add(locald);
      }
      localg.j(paramMotionDetectionInfo);
    }
    return localg;
  }
  
  private q<Boolean> u(boolean paramBoolean, int paramInt, Boolean paramBoolean1)
  {
    return l().j(new MotionDetectConfig(paramInt, paramBoolean, paramBoolean1)).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new m3(this, paramBoolean, paramInt)).g0(f3.c);
  }
  
  private SubscribeItemBean x(String paramString)
  {
    return this.f.E(paramString);
  }
  
  public boolean A()
  {
    ALCameraDevice localALCameraDevice = this.e;
    boolean bool;
    if ((localALCameraDevice != null) && (localALCameraDevice.isOnline())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean B()
  {
    ALCameraDevice localALCameraDevice = this.e;
    if (localALCameraDevice != null) {
      return C(localALCameraDevice.getDeviceId());
    }
    return false;
  }
  
  public q<Boolean> X()
  {
    return l().b0().i(m.a()).L0(io.reactivex.l0.a.c()).g0(e3.c).l0(io.reactivex.d0.b.a.a()).E(new o3(this)).g0(i3.c);
  }
  
  public q<Boolean> a0(List<d> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(w((d)localIterator.next()));
    }
    return l().f(localArrayList).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new j3(this, paramList)).g0(p3.c);
  }
  
  public void b0(MotionDetectionInfo paramMotionDetectionInfo)
  {
    this.d = Z(paramMotionDetectionInfo).a();
  }
  
  public q<Boolean> c0(boolean paramBoolean)
  {
    ALCameraDevice localALCameraDevice = this.e;
    if ((localALCameraDevice != null) && (localALCameraDevice.isRemote())) {
      return q.f0(this.e).N(new h3(this, paramBoolean));
    }
    return q.f0(Boolean.FALSE);
  }
  
  public void d0(MotionDetectConfig paramMotionDetectConfig)
  {
    if (paramMotionDetectConfig != null)
    {
      this.d.h(OptionSwitch.isOn(paramMotionDetectConfig.getEnabled()));
      this.d.k(j.e(paramMotionDetectConfig.getDigitalSensitivity(), 0));
      boolean bool = e.a(paramMotionDetectConfig.getEnhanced());
      g localg = this.d;
      if ((bool ^ true)) {
        paramMotionDetectConfig = Boolean.valueOf(OptionSwitch.isOn(paramMotionDetectConfig.getEnhanced()));
      } else {
        paramMotionDetectConfig = null;
      }
      localg.i(paramMotionDetectConfig);
    }
  }
  
  public q<Boolean> s(boolean paramBoolean, int paramInt)
  {
    return l().j(new MotionDetectConfig(paramInt, paramBoolean, null)).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new l3(this, paramBoolean, paramInt)).g0(d3.c);
  }
  
  public q<Boolean> t(Boolean paramBoolean)
  {
    boolean bool = this.d.e();
    int i = this.d.d();
    return l().j(new MotionDetectConfig(i, bool, paramBoolean)).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new n3(this, bool, i, paramBoolean)).g0(g3.c);
  }
  
  public q<Boolean> v(boolean paramBoolean)
  {
    g localg = this.d;
    if (localg == null) {
      return X().N(new k3(this, paramBoolean));
    }
    return u(paramBoolean, localg.d(), this.d.b());
  }
  
  public MotionDetectRegion w(d paramd)
  {
    return new MotionDetectRegion(paramd.c(), paramd.d(), paramd.b(), paramd.a());
  }
  
  public g y()
  {
    return this.d;
  }
  
  public boolean z()
  {
    ALCameraDevice localALCameraDevice = this.e;
    boolean bool;
    if ((localALCameraDevice != null) && (localALCameraDevice.getCloudIoTDevice() != null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\repo\MotionDetectionRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */