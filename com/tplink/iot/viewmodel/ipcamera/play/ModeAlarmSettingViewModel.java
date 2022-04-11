package com.tplink.iot.viewmodel.ipcamera.play;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;

public class ModeAlarmSettingViewModel
  extends AndroidViewModel
{
  public ObservableBoolean a = new ObservableBoolean(false);
  public ObservableBoolean b = new ObservableBoolean(false);
  public ObservableBoolean c = new ObservableBoolean(false);
  public ObservableField<String> d = new ObservableField();
  public ObservableField<String> e = new ObservableField();
  public ObservableField<String> f = new ObservableField("00:00");
  public ObservableField<String> g = new ObservableField("23:59");
  public ObservableField<boolean[]> h = new ObservableField();
  public ObservableBoolean i = new ObservableBoolean(false);
  public ObservableBoolean j = new ObservableBoolean(false);
  
  public ModeAlarmSettingViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\play\ModeAlarmSettingViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */