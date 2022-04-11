package com.tplink.iot.viewmodel.iotsensor;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.repository.SensorRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import io.reactivex.a;
import kotlin.jvm.internal.j;

public final class SensorSetReportIntervalViewModel
  extends AndroidViewModel
{
  private final SensorRepository a;
  private final LiveData<Integer> b;
  
  public SensorSetReportIntervalViewModel(Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    paramApplication = e.a(paramThingContext, SensorRepository.class);
    j.d(paramApplication, "IoTDeviceRepositoryProvi…orRepository::class.java)");
    paramApplication = (SensorRepository)paramApplication;
    this.a = paramApplication;
    this.b = paramApplication.l4();
  }
  
  public final LiveData<Integer> f()
  {
    return this.b;
  }
  
  public final a g(int paramInt)
  {
    return this.a.p4(paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\iotsensor\SensorSetReportIntervalViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */