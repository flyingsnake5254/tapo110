package com.tplink.iot.viewmodel.quicksetup.subg;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import b.d.s.a.a;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.List;

public class SubGHubEmptyViewModel
  extends SubGBaseViewModel
{
  private TPIoTClientManager a;
  private MediatorLiveData<List<BaseALIoTDevice>> b = new MediatorLiveData();
  
  public SubGHubEmptyViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    paramApplication = (TPIoTClientManager)b.d.b.f.b.a(a.f(), TPIoTClientManager.class);
    this.a = paramApplication;
    this.b.addSource(paramApplication.C1(), new b(this));
  }
  
  public LiveData<List<BaseALIoTDevice>> f()
  {
    return this.b;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\quicksetup\subg\SubGHubEmptyViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */