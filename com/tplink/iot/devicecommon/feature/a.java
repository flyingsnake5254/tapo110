package com.tplink.iot.devicecommon.feature;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tplink.iot.viewmodel.home.u;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;

public final class a
{
  private boolean a;
  
  public final void b(Activity paramActivity, BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    if (!this.a)
    {
      this.a = true;
      String str1 = null;
      String str2;
      if (paramBaseALIoTDevice != null) {
        str2 = paramBaseALIoTDevice.getDeviceType();
      } else {
        str2 = null;
      }
      String str3;
      if (paramBaseALIoTDevice != null) {
        str3 = paramBaseALIoTDevice.getDeviceModel();
      } else {
        str3 = null;
      }
      if (paramBaseALIoTDevice != null) {
        str1 = paramBaseALIoTDevice.getDeviceHwVer();
      }
      u.k(paramActivity, str2, str3, str1, new a(this));
    }
  }
  
  static final class a
    implements DialogInterface.OnDismissListener
  {
    a(a parama) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      a.a(this.c, false);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devicecommon\feature\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */