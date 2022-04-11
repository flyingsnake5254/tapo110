package com.tplink.iot.viewmodel.cloudconnect;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.tplink.cloud.bean.device.result.DeviceInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCDeviceRepository;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;
import kotlin.jvm.internal.j;

public final class CameraCloudConnectViewModel
  extends AndroidViewModel
{
  private final String a;
  private c b;
  private final TCDeviceRepository c;
  private final TPIoTClientManager d;
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> e;
  private final MutableLiveData<Boolean> f;
  private final TPCameraDeviceContext g;
  
  public CameraCloudConnectViewModel(Application paramApplication, TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramApplication);
    this.g = paramTPCameraDeviceContext;
    this.a = "CameraCloudConnectViewModel";
    this.e = new MutableLiveData();
    this.f = new MutableLiveData();
    paramApplication = b.d.b.f.b.c(paramTPCameraDeviceContext.getTcAccountContext());
    j.d(paramApplication, "CloudRepositoryProviders…Context.tcAccountContext)");
    paramApplication = paramApplication.a(TCDeviceRepository.class);
    j.d(paramApplication, "repositoryProvider.get(T…ceRepository::class.java)");
    this.c = ((TCDeviceRepository)paramApplication);
    paramApplication = b.d.b.f.b.a(paramTPCameraDeviceContext.getTcAccountContext(), TPIoTClientManager.class);
    j.d(paramApplication, "CloudRepositoryProviders…lientManager::class.java)");
    this.d = ((TPIoTClientManager)paramApplication);
  }
  
  public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> g()
  {
    return this.e;
  }
  
  public final MutableLiveData<Boolean> h()
  {
    return this.f;
  }
  
  public final void i()
  {
    TCDeviceRepository localTCDeviceRepository = this.c;
    Object localObject = (ALCameraDevice)this.g.getCameraDevice();
    if (localObject != null) {
      localObject = ((ALCameraDevice)localObject).getDeviceId();
    } else {
      localObject = null;
    }
    this.b = localTCDeviceRepository.A((String)localObject).F(new a(this)).y(new b(this)).L0(io.reactivex.l0.a.c()).H0(new c(this), new d(this));
  }
  
  public final void j()
  {
    c localc = this.b;
    if (localc != null)
    {
      j.c(localc);
      localc.dispose();
      this.b = null;
    }
  }
  
  static final class a<T>
    implements g<c>
  {
    a(CameraCloudConnectViewModel paramCameraCloudConnectViewModel) {}
    
    public final void a(c paramc)
    {
      this.c.h().postValue(Boolean.TRUE);
    }
  }
  
  static final class b
    implements io.reactivex.g0.a
  {
    b(CameraCloudConnectViewModel paramCameraCloudConnectViewModel) {}
    
    public final void run()
    {
      this.a.h().postValue(Boolean.FALSE);
    }
  }
  
  static final class c<T>
    implements g<DeviceInfoResult>
  {
    c(CameraCloudConnectViewModel paramCameraCloudConnectViewModel) {}
    
    public final void a(DeviceInfoResult paramDeviceInfoResult)
    {
      j.e(paramDeviceInfoResult, "info");
      b.d.w.c.a.b(CameraCloudConnectViewModel.f(this.c), paramDeviceInfoResult);
      this.c.g().postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.TRUE));
    }
  }
  
  static final class d<T>
    implements g<Throwable>
  {
    d(CameraCloudConnectViewModel paramCameraCloudConnectViewModel) {}
    
    public final void a(Throwable paramThrowable)
    {
      j.e(paramThrowable, "throwable");
      b.d.w.c.a.e(CameraCloudConnectViewModel.f(this.c), Log.getStackTraceString(paramThrowable));
      this.c.g().postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.FALSE));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\cloudconnect\CameraCloudConnectViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */