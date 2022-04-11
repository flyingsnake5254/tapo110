package com.tplink.libtpnetwork.IoTNetwork.repository;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.IoTPlugDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.params.PlugDeviceInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.result.EnergyUsageResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.result.PlugDeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.b;
import com.tplink.libtpnetwork.IoTNetwork.x;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import io.reactivex.a;
import io.reactivex.q;

public class PlugRepository
  extends AbstractThingRepository
{
  private MutableLiveData<EnergyUsageResult> C = new MutableLiveData();
  
  public PlugRepository(ThingContext paramThingContext)
  {
    super(paramThingContext, IoTPlugDevice.class, PlugDeviceRunningInfoResult.class);
    paramThingContext = (ALIoTDevice)paramThingContext.getIoTDevice();
    if ((paramThingContext != null) && ((paramThingContext.getLocalIoTDevice() instanceof IoTPlugDevice)))
    {
      paramThingContext = (IoTPlugDevice)paramThingContext.getLocalIoTDevice();
      this.n.postValue(paramThingContext);
    }
    else
    {
      this.n.postValue(new IoTPlugDevice());
    }
  }
  
  protected void e()
  {
    this.c.l();
    super.e();
  }
  
  public LiveData<IoTPlugDevice> e5()
  {
    return Transformations.map(super.j1(), new a());
  }
  
  public q<EnergyUsageResult> f5()
  {
    return y0("get_energy_usage", null, EnergyUsageResult.class).o0(new f8(this)).E(new g8(this));
  }
  
  public LiveData<EnergyUsageResult> g5()
  {
    return this.C;
  }
  
  public a i(boolean paramBoolean)
  {
    return J4(new PlugDeviceInfoParams(Boolean.valueOf(paramBoolean)));
  }
  
  public a m5(DefaultStatesBean paramDefaultStatesBean)
  {
    return G4(new PlugDeviceInfoParams(paramDefaultStatesBean));
  }
  
  public a n5(String paramString)
  {
    return G4(new PlugDeviceInfoParams(paramString));
  }
  
  class a
    implements Function<LocalIoTBaseDevice, IoTPlugDevice>
  {
    a() {}
    
    public IoTPlugDevice a(LocalIoTBaseDevice paramLocalIoTBaseDevice)
    {
      if ((paramLocalIoTBaseDevice instanceof IoTPlugDevice)) {
        return (IoTPlugDevice)paramLocalIoTBaseDevice;
      }
      return null;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\repository\PlugRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */