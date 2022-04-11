package com.tplink.iot.viewmodel.ipcamera.play;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import com.tplink.iot.Utils.v0.d;

public class ModeNotificationSettingViewModel
  extends AndroidViewModel
{
  public ObservableBoolean a = new ObservableBoolean(false);
  public ObservableBoolean b = new ObservableBoolean(false);
  public ObservableBoolean c = new ObservableBoolean(false);
  public ObservableBoolean d = new ObservableBoolean(false);
  public ObservableField<String> e = new ObservableField("09:00");
  public ObservableField<String> f = new ObservableField("17:00");
  public ObservableField<boolean[]> g = new ObservableField();
  public ObservableBoolean h = new ObservableBoolean(false);
  public ObservableBoolean i;
  public int j;
  public int k;
  public int l;
  
  public ModeNotificationSettingViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    paramApplication = new ObservableBoolean(false);
    this.i = paramApplication;
    this.j = 540;
    this.k = 1020;
    this.l = 127;
    paramApplication.set(d.a());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\play\ModeNotificationSettingViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */