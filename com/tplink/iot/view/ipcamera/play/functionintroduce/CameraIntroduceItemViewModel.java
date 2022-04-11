package com.tplink.iot.view.ipcamera.play.functionintroduce;

import android.app.Activity;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.tplink.iot.Utils.v0.e;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.iot.view.tapocare.BillingActivity;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;

public class CameraIntroduceItemViewModel
  extends AndroidViewModel
{
  public CameraIntroduceItemViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
  }
  
  public int f(String paramString, DeviceModel paramDeviceModel)
  {
    paramString.hashCode();
    int i = paramString.hashCode();
    int j = -1;
    switch (i)
    {
    default: 
      break;
    case 1342629676: 
      if (paramString.equals("Intruders Beware")) {
        j = 8;
      }
      break;
    case 713308156: 
      if (paramString.equals("Smart Night Vision Mode")) {
        j = 7;
      }
      break;
    case -292972771: 
      if (paramString.equals("Event Alerts")) {
        j = 6;
      }
      break;
    case -413987853: 
      if (paramString.equals("Realtime Call")) {
        j = 5;
      }
      break;
    case -422763131: 
      if (paramString.equals("Tapo Care")) {
        j = 4;
      }
      break;
    case -424404370: 
      if (paramString.equals("Look Around")) {
        j = 3;
      }
      break;
    case -590254602: 
      if (paramString.equals("Activity Zones")) {
        j = 2;
      }
      break;
    case -978993028: 
      if (paramString.equals("Full Color Sight At Night")) {
        j = 1;
      }
      break;
    case -1936095366: 
      if (paramString.equals("Person Detection")) {
        j = 0;
      }
      break;
    }
    switch (j)
    {
    default: 
      return 0;
    case 8: 
      return 2131689935;
    case 7: 
      return 2131689940;
    case 6: 
      return 2131689933;
    case 5: 
      if (c.t(paramDeviceModel)) {
        return 2131689938;
      }
      if (c.u(paramDeviceModel)) {}
      return 2131689939;
    case 4: 
      return 2131689941;
    case 3: 
      if (c.t(paramDeviceModel)) {
        return 2131689936;
      }
      if (c.u(paramDeviceModel)) {}
      return 2131689936;
    case 2: 
      if (c.t(paramDeviceModel)) {
        return 2131689930;
      }
      if (c.u(paramDeviceModel)) {
        return 2131689930;
      }
      if (c.v(paramDeviceModel)) {
        return 2131689931;
      }
      return 2131689930;
    case 1: 
      return 2131689934;
    }
    return 2131689937;
  }
  
  public String g(String paramString)
  {
    return getApplication().getString(2131954500);
  }
  
  public String h(String paramString, DeviceModel paramDeviceModel)
  {
    paramString.hashCode();
    int i = paramString.hashCode();
    int j = -1;
    switch (i)
    {
    default: 
      break;
    case 1342629676: 
      if (paramString.equals("Intruders Beware")) {
        j = 8;
      }
      break;
    case 713308156: 
      if (paramString.equals("Smart Night Vision Mode")) {
        j = 7;
      }
      break;
    case -292972771: 
      if (paramString.equals("Event Alerts")) {
        j = 6;
      }
      break;
    case -413987853: 
      if (paramString.equals("Realtime Call")) {
        j = 5;
      }
      break;
    case -422763131: 
      if (paramString.equals("Tapo Care")) {
        j = 4;
      }
      break;
    case -424404370: 
      if (paramString.equals("Look Around")) {
        j = 3;
      }
      break;
    case -590254602: 
      if (paramString.equals("Activity Zones")) {
        j = 2;
      }
      break;
    case -978993028: 
      if (paramString.equals("Full Color Sight At Night")) {
        j = 1;
      }
      break;
    case -1936095366: 
      if (paramString.equals("Person Detection")) {
        j = 0;
      }
      break;
    }
    switch (j)
    {
    default: 
      return "";
    case 8: 
      return getApplication().getString(2131951926);
    case 7: 
      return getApplication().getString(2131951936);
    case 6: 
      return getApplication().getString(2131951921);
    case 5: 
      return getApplication().getString(2131951934);
    case 4: 
      return getApplication().getString(2131954231, new Object[] { "30" });
    case 3: 
      return getApplication().getString(2131951930);
    case 2: 
      return getApplication().getString(2131951920);
    case 1: 
      return getApplication().getString(2131951923);
    }
    return getApplication().getString(2131951932);
  }
  
  public String i(String paramString)
  {
    paramString.hashCode();
    int i = paramString.hashCode();
    int j = -1;
    switch (i)
    {
    default: 
      break;
    case 1342629676: 
      if (paramString.equals("Intruders Beware")) {
        j = 8;
      }
      break;
    case 713308156: 
      if (paramString.equals("Smart Night Vision Mode")) {
        j = 7;
      }
      break;
    case -292972771: 
      if (paramString.equals("Event Alerts")) {
        j = 6;
      }
      break;
    case -413987853: 
      if (paramString.equals("Realtime Call")) {
        j = 5;
      }
      break;
    case -422763131: 
      if (paramString.equals("Tapo Care")) {
        j = 4;
      }
      break;
    case -424404370: 
      if (paramString.equals("Look Around")) {
        j = 3;
      }
      break;
    case -590254602: 
      if (paramString.equals("Activity Zones")) {
        j = 2;
      }
      break;
    case -978993028: 
      if (paramString.equals("Full Color Sight At Night")) {
        j = 1;
      }
      break;
    case -1936095366: 
      if (paramString.equals("Person Detection")) {
        j = 0;
      }
      break;
    }
    switch (j)
    {
    default: 
      return "";
    case 8: 
      return getApplication().getString(2131951927);
    case 7: 
      return getApplication().getString(2131951937);
    case 6: 
      return getApplication().getString(2131951922);
    case 5: 
      return getApplication().getString(2131951935);
    case 4: 
      return getApplication().getString(2131951938);
    case 3: 
      return getApplication().getString(2131951929);
    case 2: 
      return getApplication().getString(2131953866);
    case 1: 
      return getApplication().getString(2131951924);
    }
    return getApplication().getString(2131951933);
  }
  
  public void j(Activity paramActivity)
  {
    BillingActivity.f1(paramActivity, e.x());
  }
  
  public boolean k(String paramString)
  {
    return "Tapo Care".equals(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\play\functionintroduce\CameraIntroduceItemViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */