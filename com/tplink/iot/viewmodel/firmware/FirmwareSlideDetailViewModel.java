package com.tplink.iot.viewmodel.firmware;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import b.d.b.f.b;
import b.d.s.a.a;
import com.tplink.iot.model.firmware.EnumIoTSeriesState;
import com.tplink.iot.model.firmware.FirmwareUpdateManager;
import com.tplink.iot.model.firmware.IotSeriesBean;
import java.util.List;

public class FirmwareSlideDetailViewModel
  extends AndroidViewModel
{
  private FirmwareUpdateManager a;
  private String b;
  private MediatorLiveData<IotSeriesBean> c = new MediatorLiveData();
  
  public FirmwareSlideDetailViewModel(@NonNull Application paramApplication, String paramString)
  {
    super(paramApplication);
    this.b = paramString;
    paramApplication = (FirmwareUpdateManager)b.a(a.f(), FirmwareUpdateManager.class);
    this.a = paramApplication;
    this.c.addSource(paramApplication.p(), new a());
  }
  
  public MediatorLiveData<IotSeriesBean> i()
  {
    return this.c;
  }
  
  public void j()
  {
    IotSeriesBean localIotSeriesBean = this.a.o(this.b);
    if (localIotSeriesBean != null)
    {
      Object localObject = localIotSeriesBean.getCurrentState();
      EnumIoTSeriesState localEnumIoTSeriesState = EnumIoTSeriesState.IDLE;
      if ((localObject == localEnumIoTSeriesState) || ((localIotSeriesBean.getCurrentState() == EnumIoTSeriesState.SUCCESS) && (localIotSeriesBean.getSuccessCount() < localIotSeriesBean.getIoTDeviceStateList().size())))
      {
        localObject = this.a;
        String str = localIotSeriesBean.getId();
        boolean bool;
        if (localIotSeriesBean.getCurrentState() != localEnumIoTSeriesState) {
          bool = true;
        } else {
          bool = false;
        }
        ((FirmwareUpdateManager)localObject).m0(str, bool, true);
      }
    }
  }
  
  class a
    implements Observer<List<IotSeriesBean>>
  {
    a() {}
    
    public void a(@Nullable List<IotSeriesBean> paramList)
    {
      paramList = FirmwareSlideDetailViewModel.g(FirmwareSlideDetailViewModel.this).o(FirmwareSlideDetailViewModel.f(FirmwareSlideDetailViewModel.this));
      if (paramList != null) {
        FirmwareSlideDetailViewModel.h(FirmwareSlideDetailViewModel.this).postValue(paramList);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\firmware\FirmwareSlideDetailViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */