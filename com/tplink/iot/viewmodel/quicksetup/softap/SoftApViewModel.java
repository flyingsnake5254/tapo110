package com.tplink.iot.viewmodel.quicksetup.softap;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;

public class SoftApViewModel
  extends SoftApBaseViewModel
{
  private MutableLiveData<a<Integer>> a = new MutableLiveData();
  
  public SoftApViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\quicksetup\softap\SoftApViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */