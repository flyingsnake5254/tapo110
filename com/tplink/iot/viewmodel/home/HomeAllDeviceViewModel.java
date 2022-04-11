package com.tplink.iot.viewmodel.home;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import b.d.b.f.b;
import b.d.s.a.a;
import com.tplink.iot.cloud.bean.family.common.FamilyInfo;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyManagerRepository;

public class HomeAllDeviceViewModel
  extends AndroidViewModel
{
  private MediatorLiveData<FamilyInfo> a = new MediatorLiveData();
  
  public HomeAllDeviceViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    paramApplication = (FamilyManagerRepository)b.a(a.f(), FamilyManagerRepository.class);
    this.a.addSource(paramApplication.c0(), new a());
  }
  
  public MediatorLiveData<FamilyInfo> g()
  {
    return this.a;
  }
  
  class a
    implements Observer<FamilyInfo>
  {
    a() {}
    
    public void a(@Nullable FamilyInfo paramFamilyInfo)
    {
      HomeAllDeviceViewModel.f(HomeAllDeviceViewModel.this).postValue(paramFamilyInfo);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\home\HomeAllDeviceViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */