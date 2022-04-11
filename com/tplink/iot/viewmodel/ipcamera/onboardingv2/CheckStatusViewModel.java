package com.tplink.iot.viewmodel.ipcamera.onboardingv2;

import android.app.Application;
import android.net.wifi.ScanResult;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableInt;
import java.util.ArrayList;
import java.util.List;

public class CheckStatusViewModel
  extends OnBoardingFragmentViewModel
{
  public final ObservableInt a = new ObservableInt(0);
  
  public CheckStatusViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
  }
  
  private static boolean g(String paramString)
  {
    boolean bool;
    if ((!TextUtils.isEmpty(paramString)) && (paramString.matches("Tapo_Cam_[A-Fa-f0-9]{4}"))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public List<ScanResult> f(List<ScanResult> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j;
    if ((paramList != null) && (paramList.size() > 0)) {
      for (j = 0; j < paramList.size(); j++)
      {
        localObject = (ScanResult)paramList.get(j);
        if ((localObject != null) && (g(((ScanResult)localObject).SSID))) {
          localArrayList.add(localObject);
        }
      }
    }
    paramList = new ArrayList();
    Object localObject = new ArrayList();
    if (localArrayList.size() > 0) {
      for (j = i; j < localArrayList.size(); j++) {
        if (!((List)localObject).contains(((ScanResult)localArrayList.get(j)).SSID))
        {
          ((List)localObject).add(((ScanResult)localArrayList.get(j)).SSID);
          paramList.add(localArrayList.get(j));
        }
      }
    }
    this.a.set(paramList.size());
    return paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\onboardingv2\CheckStatusViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */