package com.tplink.iot.devicecommon.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;

public final class IoTDeviceInfoCommonViewModel
  extends AndroidViewModel
{
  private final kotlin.t.c b;
  
  public IoTDeviceInfoCommonViewModel(Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    this.b = com.tplink.iot.Utils.extension.c.a(paramThingContext);
  }
  
  public final LiveData<BaseALIoTDevice<?>> f()
  {
    return (LiveData)this.b.b(this, a[0]);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devicecommon\viewmodel\IoTDeviceInfoCommonViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */