package com.tplink.iot.viewmodel.quicksetup;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import b.d.b.f.b;
import b.d.s.a.a;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.repository.QuickDiscoveryRepository;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import java.util.List;

public class QuickDiscoveryViewModel
  extends AndroidViewModel
{
  private final QuickDiscoveryRepository a;
  private final TPIoTClientManager b;
  
  public QuickDiscoveryViewModel(Application paramApplication)
  {
    super(paramApplication);
    paramApplication = a.f();
    this.a = ((QuickDiscoveryRepository)b.a(paramApplication, QuickDiscoveryRepository.class));
    this.b = ((TPIoTClientManager)b.a(paramApplication, TPIoTClientManager.class));
  }
  
  public boolean f()
  {
    return this.a.x();
  }
  
  public LiveData<List<TDPIoTDevice>> g()
  {
    return this.a.y();
  }
  
  public void h(@NonNull TDPIoTDevice paramTDPIoTDevice)
  {
    this.b.Z3(paramTDPIoTDevice);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\quicksetup\QuickDiscoveryViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */