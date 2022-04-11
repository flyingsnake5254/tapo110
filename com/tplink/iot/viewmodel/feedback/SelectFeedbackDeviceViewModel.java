package com.tplink.iot.viewmodel.feedback;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import b.d.b.f.b;
import com.tplink.iot.Utils.z0.r;
import com.tplink.iot.view.feedback.EnumFeedbackCategory;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SelectFeedbackDeviceViewModel
  extends AndroidViewModel
{
  private TPIoTClientManager a;
  private MediatorLiveData<List<BaseALIoTDevice>> b = new MediatorLiveData();
  
  public SelectFeedbackDeviceViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    paramApplication = (TPIoTClientManager)b.a(b.d.s.a.a.f(), TPIoTClientManager.class);
    this.a = paramApplication;
    this.b.addSource(paramApplication.C1(), new a());
  }
  
  private void g(BaseALIoTDevice paramBaseALIoTDevice, List<BaseALIoTDevice> paramList, EnumFeedbackCategory paramEnumFeedbackCategory)
  {
    if (paramEnumFeedbackCategory == EnumFeedbackCategory.LIGHT_STRIP)
    {
      if (paramBaseALIoTDevice.isLightStrip()) {
        paramList.add(paramBaseALIoTDevice);
      }
    }
    else if ((paramEnumFeedbackCategory == EnumFeedbackCategory.BULB) && (paramEnumFeedbackCategory.getDeviceType().equals(paramBaseALIoTDevice.getEnumDeviceType())) && (!paramBaseALIoTDevice.isLightStrip())) {
      paramList.add(paramBaseALIoTDevice);
    }
  }
  
  private void h(BaseALIoTDevice paramBaseALIoTDevice, List<BaseALIoTDevice> paramList, EnumFeedbackCategory paramEnumFeedbackCategory)
  {
    int i = b.a[paramEnumFeedbackCategory.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if ((i == 3) && (r.j(paramBaseALIoTDevice))) {
          paramList.add(paramBaseALIoTDevice);
        }
      }
      else if (r.k(paramBaseALIoTDevice)) {
        paramList.add(paramBaseALIoTDevice);
      }
    }
    else if (r.l(paramBaseALIoTDevice)) {
      paramList.add(paramBaseALIoTDevice);
    }
  }
  
  private void l(List<BaseALIoTDevice> paramList)
  {
    Collections.sort(paramList, a.c);
  }
  
  public List<BaseALIoTDevice> i(List<BaseALIoTDevice> paramList, String paramString)
  {
    if ((paramList != null) && (paramString != null))
    {
      paramString = EnumFeedbackCategory.fromCategory(paramString);
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)paramList.next();
        if (paramString.getDeviceType() == EnumDeviceType.BULB) {
          g(localBaseALIoTDevice, localArrayList, paramString);
        } else if (paramString.getDeviceType() == EnumDeviceType.SENSOR) {
          h(localBaseALIoTDevice, localArrayList, paramString);
        } else if (localBaseALIoTDevice.getEnumDeviceType().equals(paramString.getDeviceType())) {
          localArrayList.add(localBaseALIoTDevice);
        }
      }
      if (localArrayList.size() > 1) {
        l(localArrayList);
      }
      return localArrayList;
    }
    return null;
  }
  
  public MediatorLiveData<List<BaseALIoTDevice>> j()
  {
    return this.b;
  }
  
  class a
    implements Observer<List<BaseALIoTDevice>>
  {
    a() {}
    
    public void a(@Nullable List<BaseALIoTDevice> paramList)
    {
      SelectFeedbackDeviceViewModel.f(SelectFeedbackDeviceViewModel.this).postValue(paramList);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\feedback\SelectFeedbackDeviceViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */