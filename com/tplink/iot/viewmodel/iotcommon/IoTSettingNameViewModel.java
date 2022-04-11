package com.tplink.iot.viewmodel.iotcommon;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.Utils.w;
import com.tplink.iot.Utils.z0.l;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractSubThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.PlugRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.IoTNetwork.util.c;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import io.reactivex.g0.g;

public class IoTSettingNameViewModel
  extends AndroidViewModel
{
  private SingleLiveEvent<Integer> a = new SingleLiveEvent();
  private AbstractThingRepository b;
  private AbstractSubThingRepository c;
  private final ThingContext d;
  private EnumDeviceType e = EnumDeviceType.PLUG;
  private boolean f = false;
  
  public IoTSettingNameViewModel(@NonNull Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    this.d = paramThingContext;
    if (paramThingContext.getIoTDevice() != null)
    {
      this.e = EnumDeviceType.fromType(((ALIoTDevice)paramThingContext.getIoTDevice()).getDeviceType());
      this.f = ((ALIoTDevice)paramThingContext.getIoTDevice()).isSubDevice();
    }
    paramApplication = c.a(paramThingContext);
    if ((paramApplication instanceof AbstractThingRepository)) {
      this.b = ((AbstractThingRepository)paramApplication);
    } else if ((paramApplication instanceof AbstractSubThingRepository)) {
      this.c = ((AbstractSubThingRepository)paramApplication);
    } else {
      this.b = ((AbstractThingRepository)e.a(paramThingContext, PlugRepository.class));
    }
    paramThingContext = new StringBuilder();
    paramThingContext.append("ThingRepository class: ");
    if (paramApplication != null) {
      paramApplication = paramApplication.getClass().getSimpleName();
    } else {
      paramApplication = "";
    }
    paramThingContext.append(paramApplication);
    b.d.w.c.a.e("DeviceCommon", paramThingContext.toString());
  }
  
  private String h()
  {
    if ((this.d.getIoTDevice() != null) && (((ALIoTDevice)this.d.getIoTDevice()).getDeviceModel() != null)) {
      return ((ALIoTDevice)this.d.getIoTDevice()).getDeviceModel();
    }
    return "";
  }
  
  private String i()
  {
    if ((this.d.getIoTDevice() != null) && (((ALIoTDevice)this.d.getIoTDevice()).getDeviceName() != null)) {
      return ((ALIoTDevice)this.d.getIoTDevice()).getDeviceName();
    }
    return "";
  }
  
  public String g(Context paramContext)
  {
    EnumDeviceType localEnumDeviceType = this.e;
    if (localEnumDeviceType != null) {
      return l.e(paramContext, localEnumDeviceType.getDeviceType(), i(), h());
    }
    return "";
  }
  
  public String j()
  {
    return i();
  }
  
  @SuppressLint({"CheckResult"})
  public void k(String paramString)
  {
    Object localObject;
    if (this.f)
    {
      localObject = this.c;
      if (localObject != null) {
        paramString = ((AbstractSubThingRepository)localObject).a4(paramString);
      } else {
        paramString = io.reactivex.a.m(new Throwable("Null Device Repository"));
      }
    }
    else
    {
      localObject = this.b;
      if (localObject != null) {
        paramString = ((AbstractThingRepository)localObject).O4(paramString);
      } else {
        paramString = io.reactivex.a.m(new Throwable("Null Device Repository"));
      }
    }
    paramString.r(io.reactivex.d0.b.a.a()).A(new a(), new b());
  }
  
  class a
    implements io.reactivex.g0.a
  {
    a() {}
    
    public void run()
      throws Exception
    {
      IoTSettingNameViewModel.f(IoTSettingNameViewModel.this).postValue(Integer.valueOf(0));
    }
  }
  
  class b
    implements g<Throwable>
  {
    b() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      if (w.d(paramThrowable)) {
        w.f();
      } else {
        IoTSettingNameViewModel.f(IoTSettingNameViewModel.this).postValue(Integer.valueOf(-1));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\iotcommon\IoTSettingNameViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */