package com.tplink.iot.viewmodel.ipcamera;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.tplink.iot.cloud.bean.cloudvideo.common.OrderInfo;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.CloudVideoRepository;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.FirmwareManager;
import com.tplink.libtpnetwork.cameranetwork.g4.k;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;

public final class CameraPreviewViewModel
  extends AndroidViewModel
{
  private final TPIoTClientManager a;
  private c b;
  private final MediatorLiveData<List<ALCameraDevice>> c;
  private final FirmwareManager d;
  private final MediatorLiveData<List<OrderInfo>> e;
  private final CloudVideoRepository f;
  
  public CameraPreviewViewModel(Application paramApplication)
  {
    super(paramApplication);
    Object localObject1 = new MediatorLiveData();
    this.c = ((MediatorLiveData)localObject1);
    paramApplication = new MediatorLiveData();
    this.e = paramApplication;
    com.tplink.cloud.context.b localb = b.d.s.a.a.f();
    Object localObject2 = b.d.b.f.b.a(localb, TPIoTClientManager.class);
    j.d(localObject2, "CloudRepositoryProviders…lientManager::class.java)");
    localObject2 = (TPIoTClientManager)localObject2;
    this.a = ((TPIoTClientManager)localObject2);
    b.d.b.f.a locala = b.d.b.f.b.a(localb, FirmwareManager.class);
    j.d(locala, "CloudRepositoryProviders…mwareManager::class.java)");
    this.d = ((FirmwareManager)locala);
    ((MediatorLiveData)localObject1).addSource(((TPIoTClientManager)localObject2).M1(), new a(this));
    localObject1 = b.d.b.f.b.a(localb, CloudVideoRepository.class);
    j.d(localObject1, "CloudRepositoryProviders…eoRepository::class.java)");
    localObject1 = (CloudVideoRepository)localObject1;
    this.f = ((CloudVideoRepository)localObject1);
    paramApplication.addSource(((CloudVideoRepository)localObject1).c0(), new b(this));
  }
  
  private final boolean j()
  {
    boolean bool;
    if ((b.d.w.f.b.j(getApplication())) && (b.d.w.f.b.i(getApplication()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final MediatorLiveData<List<ALCameraDevice>> h()
  {
    return this.c;
  }
  
  public final MutableLiveData<List<OrderInfo>> i()
  {
    return this.e;
  }
  
  public final void k()
  {
    this.d.I();
  }
  
  public final void l()
  {
    c localc = this.b;
    if (localc != null) {
      localc.dispose();
    }
    this.b = this.a.k3(j()).x0(new k()).C(c.c).F0();
    k();
  }
  
  protected void onCleared()
  {
    super.onCleared();
    c localc = this.b;
    if (localc != null) {
      localc.dispose();
    }
  }
  
  static final class a<T>
    implements Observer<List<ALCameraDevice>>
  {
    a(CameraPreviewViewModel paramCameraPreviewViewModel) {}
    
    public final void a(List<ALCameraDevice> paramList)
    {
      if (paramList != null) {
        CameraPreviewViewModel.f(this.a).postValue(new ArrayList(paramList));
      }
    }
  }
  
  static final class b<T>
    implements Observer<List<OrderInfo>>
  {
    b(CameraPreviewViewModel paramCameraPreviewViewModel) {}
    
    public final void a(List<OrderInfo> paramList)
    {
      CameraPreviewViewModel.g(this.a).postValue(paramList);
    }
  }
  
  static final class c<T>
    implements g<Throwable>
  {
    public static final c c = new c();
    
    public final void a(Throwable paramThrowable) {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\CameraPreviewViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */