package com.tplink.iot.viewmodel.firmware;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.model.firmware.EnumIoTSeriesState;
import com.tplink.iot.model.firmware.FirmwareUpdateManager;
import com.tplink.iot.model.firmware.IotSeriesBean;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import java.util.Iterator;
import java.util.List;

public class FirmwareSlideViewModel
  extends AndroidViewModel
{
  private FirmwareUpdateManager a;
  private MediatorLiveData<List<IotSeriesBean>> b = new MediatorLiveData();
  private SingleLiveEvent<Boolean> c = new SingleLiveEvent();
  private SingleLiveEvent<Boolean> d = new SingleLiveEvent();
  private SingleLiveEvent<Boolean> e = new SingleLiveEvent();
  
  public FirmwareSlideViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    paramApplication = (FirmwareUpdateManager)b.d.b.f.b.a(b.d.s.a.a.f(), FirmwareUpdateManager.class);
    this.a = paramApplication;
    this.b.addSource(paramApplication.p(), new b(this));
    this.c.addSource(this.a.r(), new c(this));
    this.d.addSource(this.a.q(), new a(this));
  }
  
  private boolean l(List<IotSeriesBean> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (u((IotSeriesBean)paramList.next())) {
          return true;
        }
      }
    }
    boolean bool = false;
    return bool;
  }
  
  private boolean u(IotSeriesBean paramIotSeriesBean)
  {
    boolean bool;
    if ((paramIotSeriesBean.getCurrentState() != EnumIoTSeriesState.DOWNLOADING) && (paramIotSeriesBean.getCurrentState() != EnumIoTSeriesState.INSTALLING) && ((paramIotSeriesBean.getCurrentState() != EnumIoTSeriesState.SUCCESS) || (paramIotSeriesBean.getSuccessCount() != paramIotSeriesBean.getIoTDeviceStateList().size()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void f()
  {
    this.a.d();
  }
  
  public LiveData<List<IotSeriesBean>> g()
  {
    return this.b;
  }
  
  public SingleLiveEvent<Boolean> h()
  {
    return this.d;
  }
  
  public SingleLiveEvent<Boolean> i()
  {
    return this.c;
  }
  
  public SingleLiveEvent<Boolean> j()
  {
    return this.e;
  }
  
  public void k()
  {
    this.a.f0(true);
  }
  
  public void t()
  {
    this.a.f0(false);
  }
  
  public void v(List<IotSeriesBean> paramList)
  {
    this.e.postValue(Boolean.FALSE);
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      IotSeriesBean localIotSeriesBean = (IotSeriesBean)paramList.next();
      if (u(localIotSeriesBean)) {
        if (localIotSeriesBean.getCurrentState() == EnumIoTSeriesState.SUCCESS) {
          this.a.m0(localIotSeriesBean.getId(), true, true);
        } else {
          this.a.l0(localIotSeriesBean.getId());
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\firmware\FirmwareSlideViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */