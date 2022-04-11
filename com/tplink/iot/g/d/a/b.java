package com.tplink.iot.g.d.a;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.tplink.iot.devices.trv.view.TRVReplaceBatteryFragment;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.Utils.i;
import com.tplink.libtpnetwork.enumerate.EnumTRVAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumTRVState;
import com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit;
import com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit.b;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.j;

public final class b
{
  public static final b a = new b();
  
  public static final IoTSubDevice a(IoTSubDevice paramIoTSubDevice)
  {
    if (paramIoTSubDevice != null) {
      return (IoTSubDevice)i.d(i.f(paramIoTSubDevice), IoTSubDevice.class);
    }
    return null;
  }
  
  public static final String b(float paramFloat, EnumTemperatureUnit paramEnumTemperatureUnit)
  {
    j.e(paramEnumTemperatureUnit, "enumUnit");
    int i = (int)paramFloat;
    if (i == paramFloat)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(paramEnumTemperatureUnit.getUnitText());
      return ((StringBuilder)localObject).toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = String.format("%.1f", Arrays.copyOf(new Object[] { Float.valueOf(paramFloat) }, 1));
    j.d(localObject, "java.lang.String.format(this, *args)");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(paramEnumTemperatureUnit.getUnitText());
    return localStringBuilder.toString();
  }
  
  public static final String c(float paramFloat, String paramString)
  {
    return b(paramFloat, EnumTemperatureUnit.Companion.a(paramString));
  }
  
  public static final String d(int paramInt, EnumTemperatureUnit paramEnumTemperatureUnit)
  {
    j.e(paramEnumTemperatureUnit, "enumUnit");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append(paramEnumTemperatureUnit.getUnitText());
    return localStringBuilder.toString();
  }
  
  public static final String e(int paramInt, String paramString)
  {
    return d(paramInt, EnumTemperatureUnit.Companion.a(paramString));
  }
  
  public static final int f(EnumTRVAvatarType paramEnumTRVAvatarType)
  {
    return i(paramEnumTRVAvatarType, 1);
  }
  
  public static final int g(EnumTRVAvatarType paramEnumTRVAvatarType)
  {
    return i(paramEnumTRVAvatarType, 2);
  }
  
  public static final int h(EnumTRVAvatarType paramEnumTRVAvatarType)
  {
    return i(paramEnumTRVAvatarType, 3);
  }
  
  private static final int i(EnumTRVAvatarType paramEnumTRVAvatarType, int paramInt)
  {
    int i = 2131690097;
    int j;
    if (paramInt == 1) {
      j = 2131690096;
    } else if (paramInt == 2) {
      j = 2131690097;
    } else {
      j = 2131690098;
    }
    if (paramEnumTRVAvatarType == null) {
      paramInt = j;
    } else {
      switch (a.a[paramEnumTRVAvatarType.ordinal()])
      {
      default: 
        paramInt = j;
        break;
      case 9: 
        if (paramInt == 1) {
          paramInt = 2131689498;
        } else if (paramInt == 2) {
          paramInt = 2131689499;
        } else {
          paramInt = 2131689500;
        }
        break;
      case 8: 
        if (paramInt == 1) {
          paramInt = 2131690404;
        } else if (paramInt == 2) {
          paramInt = 2131690405;
        } else {
          paramInt = 2131690406;
        }
        break;
      case 7: 
        if (paramInt == 1) {
          paramInt = 2131690232;
        } else if (paramInt == 2) {
          paramInt = 2131690233;
        } else {
          paramInt = 2131690234;
        }
        break;
      case 6: 
        if (paramInt == 1) {
          paramInt = 2131689502;
        } else if (paramInt == 2) {
          paramInt = 2131689503;
        } else {
          paramInt = 2131689504;
        }
        break;
      case 5: 
        if (paramInt == 1) {
          paramInt = 2131689638;
        } else if (paramInt == 2) {
          paramInt = 2131689639;
        } else {
          paramInt = 2131689640;
        }
        break;
      case 4: 
        if (paramInt == 1) {
          paramInt = 2131690113;
        } else if (paramInt == 2) {
          paramInt = 2131690114;
        } else {
          paramInt = 2131690115;
        }
        break;
      case 3: 
        if (paramInt == 1) {
          paramInt = 2131689505;
        } else if (paramInt == 2) {
          paramInt = 2131689506;
        } else {
          paramInt = 2131689507;
        }
        break;
      case 2: 
        if (paramInt == 1) {
          paramInt = 2131690165;
        } else if (paramInt == 2) {
          paramInt = 2131690166;
        } else {
          paramInt = 2131690167;
        }
        break;
      case 1: 
        if (paramInt == 1) {
          paramInt = 2131690096;
        } else if (paramInt == 2) {
          paramInt = i;
        } else {
          paramInt = 2131690098;
        }
        break;
      }
    }
    return paramInt;
  }
  
  public static final boolean j(IoTSubDevice paramIoTSubDevice)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramIoTSubDevice != null)
    {
      paramIoTSubDevice = paramIoTSubDevice.getTrvStates();
      bool2 = bool1;
      if (paramIoTSubDevice != null) {
        if (!paramIoTSubDevice.isEmpty())
        {
          bool2 = bool1;
          if (paramIoTSubDevice.size() == 1)
          {
            bool2 = bool1;
            if (!paramIoTSubDevice.contains(EnumTRVState.LOW_BATTERY)) {}
          }
        }
        else
        {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  public static final boolean k(BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    if (paramBaseALIoTDevice != null) {
      paramBaseALIoTDevice = paramBaseALIoTDevice.getDeviceModel();
    } else {
      paramBaseALIoTDevice = null;
    }
    return l(paramBaseALIoTDevice);
  }
  
  public static final boolean l(String paramString)
  {
    boolean bool;
    if (paramString != null) {
      bool = j.a("E100", paramString);
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static final boolean m(IoTSubDevice paramIoTSubDevice)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramIoTSubDevice != null)
    {
      List localList = paramIoTSubDevice.getTrvStates();
      if ((localList == null) || (localList.contains(EnumTRVState.FROST_PROTECTION) != true))
      {
        bool2 = bool1;
        if (j(paramIoTSubDevice))
        {
          bool2 = bool1;
          if (!paramIoTSubDevice.isFrostProtectionOn()) {}
        }
      }
      else
      {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public static final boolean n(IoTSubDevice paramIoTSubDevice)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramIoTSubDevice != null)
    {
      List localList = paramIoTSubDevice.getTrvStates();
      if ((localList == null) || (localList.contains(EnumTRVState.HEATING) != true))
      {
        bool2 = bool1;
        if (j(paramIoTSubDevice))
        {
          bool2 = bool1;
          if (paramIoTSubDevice.isFrostProtectionOn()) {}
        }
      }
      else
      {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public static final void o(FragmentManager paramFragmentManager, BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    if (paramFragmentManager != null) {
      new TRVReplaceBatteryFragment().show(paramFragmentManager, null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\g\d\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */