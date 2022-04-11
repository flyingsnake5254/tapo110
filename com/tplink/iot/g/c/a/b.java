package com.tplink.iot.g.c.a;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.tplink.iot.devices.switches.view.SwitchReplaceBatteryFragment;
import com.tplink.iot.devices.switches.view.SwitchReplaceBatteryFragment.a;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumSwitchAvatarType;
import kotlin.jvm.internal.j;

public final class b
{
  public static final b a = new b();
  
  public static final int a(EnumSwitchAvatarType paramEnumSwitchAvatarType, String paramString)
  {
    return d(paramEnumSwitchAvatarType, 1, paramString);
  }
  
  public static final int b(EnumSwitchAvatarType paramEnumSwitchAvatarType, String paramString)
  {
    return d(paramEnumSwitchAvatarType, 2, paramString);
  }
  
  public static final int c(EnumSwitchAvatarType paramEnumSwitchAvatarType, String paramString)
  {
    return d(paramEnumSwitchAvatarType, 3, paramString);
  }
  
  private static final int d(EnumSwitchAvatarType paramEnumSwitchAvatarType, int paramInt, String paramString)
  {
    int i = 2131690072;
    int j;
    if (paramInt == 1) {
      j = 2131690071;
    } else if (paramInt == 2) {
      j = 2131690072;
    } else {
      j = 2131690073;
    }
    boolean bool = j.a("S220", paramString);
    int k = 2131690062;
    if (bool) {
      if (paramInt == 1) {
        j = 2131690061;
      } else if (paramInt == 2) {
        j = 2131690062;
      } else {
        j = 2131690063;
      }
    }
    if (paramEnumSwitchAvatarType == null) {
      paramInt = j;
    } else {
      switch (a.a[paramEnumSwitchAvatarType.ordinal()])
      {
      default: 
        paramInt = j;
        break;
      case 14: 
        if (paramInt == 1) {
          paramInt = 2131689994;
        } else if (paramInt == 2) {
          paramInt = 2131689995;
        } else {
          paramInt = 2131689996;
        }
        break;
      case 13: 
        if (paramInt == 1) {
          paramInt = 2131690015;
        } else if (paramInt == 2) {
          paramInt = 2131690016;
        } else {
          paramInt = 2131690017;
        }
        break;
      case 12: 
        if (paramInt == 1) {
          paramInt = 2131690012;
        } else if (paramInt == 2) {
          paramInt = 2131690013;
        } else {
          paramInt = 2131690014;
        }
        break;
      case 11: 
        if (paramInt == 1) {
          paramInt = 2131690009;
        } else if (paramInt == 2) {
          paramInt = 2131690010;
        } else {
          paramInt = 2131690011;
        }
        break;
      case 10: 
        if (paramInt == 1) {
          paramInt = 2131690003;
        } else if (paramInt == 2) {
          paramInt = 2131690004;
        } else {
          paramInt = 2131690005;
        }
        break;
      case 9: 
        if (paramInt == 1) {
          paramInt = 2131690000;
        } else if (paramInt == 2) {
          paramInt = 2131690001;
        } else {
          paramInt = 2131690002;
        }
        break;
      case 8: 
        if (paramInt == 1) {
          paramInt = 2131689997;
        } else if (paramInt == 2) {
          paramInt = 2131689998;
        } else {
          paramInt = 2131689999;
        }
        break;
      case 7: 
        if (paramInt == 1) {
          paramInt = 2131690089;
        } else if (paramInt == 2) {
          paramInt = 2131690090;
        } else {
          paramInt = 2131690091;
        }
        break;
      case 6: 
        if (paramInt == 1) {
          paramInt = 2131690086;
        } else if (paramInt == 2) {
          paramInt = 2131690087;
        } else {
          paramInt = 2131690088;
        }
        break;
      case 5: 
        if (paramInt == 1) {
          paramInt = 2131690082;
        } else if (paramInt == 2) {
          paramInt = 2131690083;
        } else {
          paramInt = 2131690084;
        }
        break;
      case 4: 
        if (paramInt == 1) {
          paramInt = 2131690078;
        } else if (paramInt == 2) {
          paramInt = 2131690079;
        } else {
          paramInt = 2131690080;
        }
        break;
      case 3: 
        if (paramInt == 1) {
          paramInt = 2131690075;
        } else if (paramInt == 2) {
          paramInt = 2131690076;
        } else {
          paramInt = 2131690077;
        }
        break;
      case 2: 
        if (paramInt == 1) {
          paramInt = 2131690071;
        } else if (paramInt == 2) {
          paramInt = i;
        } else {
          paramInt = 2131690073;
        }
        break;
      case 1: 
        if (paramInt == 1) {
          paramInt = 2131690061;
        } else if (paramInt == 2) {
          paramInt = k;
        } else {
          paramInt = 2131690063;
        }
        break;
      }
    }
    return paramInt;
  }
  
  public static final void e(FragmentManager paramFragmentManager, BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    j.e(paramFragmentManager, "fragmentManager");
    if (paramBaseALIoTDevice != null)
    {
      paramBaseALIoTDevice = paramBaseALIoTDevice.getDeviceModel();
      if (paramBaseALIoTDevice != null) {}
    }
    else
    {
      paramBaseALIoTDevice = "S210";
    }
    SwitchReplaceBatteryFragment.p1.a(paramBaseALIoTDevice).show(paramFragmentManager, null);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\g\c\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */