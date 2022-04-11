package com.tplink.libtpnetwork.cameranetwork.business.repo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.f4;
import com.tplink.libtpnetwork.cameranetwork.g4.m;
import com.tplink.libtpnetwork.cameranetwork.model.AutoUpdateInfo;
import com.tplink.libtpnetwork.cameranetwork.model.FirmwareUpdateStatus;
import com.tplink.libtpnetwork.cameranetwork.model.LatestFirmwareInfo;
import com.tplink.libtpnetwork.cameranetwork.model.StartUpdateFirmwareInfo;
import io.reactivex.m0.b;
import io.reactivex.m0.g;
import io.reactivex.q;
import java.util.concurrent.TimeUnit;

public class FirmwareRepository
  extends com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c
{
  public final MutableLiveData<Boolean> d = new MutableLiveData();
  public final MutableLiveData<AutoUpdateInfo> e = new MutableLiveData();
  private long f = 0L;
  private g<com.tplink.libtpnetwork.cameranetwork.common.a<LatestFirmwareInfo>> g = b.n1().l1();
  private long h = 0L;
  private g<com.tplink.libtpnetwork.cameranetwork.common.a<FirmwareUpdateStatus>> i = b.n1().l1();
  private long j = 0L;
  
  public FirmwareRepository(TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramTPCameraDeviceContext);
  }
  
  private boolean R()
  {
    boolean bool;
    if ((this.h > 0L) && (System.currentTimeMillis() - this.h <= 30000L)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private boolean S()
  {
    boolean bool;
    if ((this.j > 0L) && (System.currentTimeMillis() - this.j <= 30000L)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void T()
  {
    this.h = 0L;
    this.j = 0L;
  }
  
  public q<Boolean> U(AutoUpdateInfo paramAutoUpdateInfo)
  {
    return l().o2(paramAutoUpdateInfo).C(f7.c).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).g0(c2.c).E(new v1(this, paramAutoUpdateInfo));
  }
  
  public q<StartUpdateFirmwareInfo> V()
  {
    return l().s().i(m.a()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new b2(this));
  }
  
  protected void e()
  {
    super.e();
    this.f = 0L;
    this.h = 0L;
    this.j = 0L;
  }
  
  public <T> boolean s(MutableLiveData<T> paramMutableLiveData, T paramT)
  {
    if ((paramMutableLiveData.getValue() == null) && (paramT == null)) {
      return true;
    }
    if ((paramMutableLiveData.getValue() != null) && (paramT != null)) {
      return paramMutableLiveData.getValue().equals(paramT);
    }
    return false;
  }
  
  public q<AutoUpdateInfo> t()
  {
    return l().A().i(m.a()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new y1(this));
  }
  
  public q<LatestFirmwareInfo> u()
  {
    ALCameraDevice localALCameraDevice = (ALCameraDevice)((TPCameraDeviceContext)b()).getCameraDevice();
    if ((localALCameraDevice != null) && (!localALCameraDevice.isUserRoleTypeDevice())) {
      return l().N().i(m.a()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new d2(this)).C(new a2(this));
    }
    return q.f0(new LatestFirmwareInfo(null, null, null, null, null)).l0(io.reactivex.d0.b.a.a()).E(new f2(this));
  }
  
  public q<LatestFirmwareInfo> v()
  {
    if (!R()) {
      return this.g.Q0(1L).N(x1.c).T0(15L, TimeUnit.SECONDS).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
    }
    this.h = System.currentTimeMillis();
    return u();
  }
  
  public q<FirmwareUpdateStatus> w()
  {
    return l().O().i(m.a()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new z1(this)).C(new e2(this));
  }
  
  public q<FirmwareUpdateStatus> x()
  {
    if (!S()) {
      return this.i.Q0(1L).N(w1.c).T0(15L, TimeUnit.SECONDS).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
    }
    this.j = System.currentTimeMillis();
    return w();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\repo\FirmwareRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */