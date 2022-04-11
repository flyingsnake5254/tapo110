package com.tplink.iot.viewmodel.ipcamera.basic;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.AndroidViewModel;

public class RegionEditViewModel
  extends AndroidViewModel
{
  public ObservableBoolean a = new ObservableBoolean(false);
  public ObservableBoolean b = new ObservableBoolean(false);
  public ObservableBoolean c = new ObservableBoolean(false);
  public ObservableBoolean d = new ObservableBoolean(false);
  
  public RegionEditViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\basic\RegionEditViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */