package com.tplink.iot.Utils.z0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumGuardMode;
import com.tplink.libtpnetwork.enumerate.EnumGuardMode.a;
import com.tplink.libtpnetwork.enumerate.EnumHubAvatarType;
import java.util.Iterator;
import java.util.List;

public class p
{
  public static boolean a(@Nullable BaseALIoTDevice paramBaseALIoTDevice, @Nullable List<BaseALIoTDevice> paramList)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramBaseALIoTDevice != null)
    {
      bool2 = bool1;
      if (paramList != null)
      {
        bool2 = bool1;
        if (!paramList.isEmpty())
        {
          paramBaseALIoTDevice = paramBaseALIoTDevice.getDeviceIdMD5();
          paramList = paramList.iterator();
          int i = 0;
          int j;
          do
          {
            BaseALIoTDevice localBaseALIoTDevice;
            do
            {
              j = i;
              if (!paramList.hasNext()) {
                break;
              }
              localBaseALIoTDevice = (BaseALIoTDevice)paramList.next();
            } while ((!localBaseALIoTDevice.isSubDevice()) || (!TextUtils.equals(localBaseALIoTDevice.getParentDeviceIDMD5(), paramBaseALIoTDevice)));
            j = i + h(localBaseALIoTDevice);
            i = j;
          } while (j < 64);
          bool2 = bool1;
          if (j >= 64) {
            bool2 = true;
          }
        }
      }
    }
    return bool2;
  }
  
  public static int b(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = EnumGuardMode.Companion.a(str);
    if (paramString == EnumGuardMode.AWAY) {
      return 2131689706;
    }
    if (paramString == EnumGuardMode.SLEEP) {
      return 2131689708;
    }
    return 2131689707;
  }
  
  public static int c(String paramString)
  {
    if ("high".equals(paramString)) {
      return 2131953833;
    }
    if ("middle".equals(paramString)) {
      return 2131953835;
    }
    return 2131952855;
  }
  
  public static int d(EnumHubAvatarType paramEnumHubAvatarType)
  {
    return g(paramEnumHubAvatarType, 1);
  }
  
  public static int e(EnumHubAvatarType paramEnumHubAvatarType)
  {
    return g(paramEnumHubAvatarType, 2);
  }
  
  public static int f(EnumHubAvatarType paramEnumHubAvatarType)
  {
    return g(paramEnumHubAvatarType, 3);
  }
  
  private static int g(EnumHubAvatarType paramEnumHubAvatarType, int paramInt)
  {
    int i;
    if (paramInt == 1) {
      i = 2131690021;
    } else if (paramInt == 2) {
      i = 2131690022;
    } else {
      i = 2131690023;
    }
    int j = i;
    if (paramEnumHubAvatarType != null) {
      switch (a.a[paramEnumHubAvatarType.ordinal()])
      {
      default: 
        j = i;
        break;
      case 6: 
        if (paramInt == 1) {
          j = 2131690006;
        } else if (paramInt == 2) {
          j = 2131690007;
        } else {
          j = 2131690008;
        }
        break;
      case 5: 
        if (paramInt == 1) {
          j = 2131689978;
        } else if (paramInt == 2) {
          j = 2131689979;
        } else {
          j = 2131689980;
        }
        break;
      case 4: 
        if (paramInt == 1) {
          j = 2131689981;
        } else if (paramInt == 2) {
          j = 2131689982;
        } else {
          j = 2131689983;
        }
        break;
      case 3: 
        if (paramInt == 1) {
          j = 2131689988;
        } else if (paramInt == 2) {
          j = 2131689989;
        } else {
          j = 2131689990;
        }
        break;
      case 2: 
        if (paramInt == 1) {
          j = 2131689943;
        } else if (paramInt == 2) {
          j = 2131689944;
        } else {
          j = 2131689945;
        }
        break;
      case 1: 
        if (paramInt == 1) {
          j = 2131689946;
        } else if (paramInt == 2) {
          j = 2131689947;
        } else {
          j = 2131689948;
        }
        break;
      }
    }
    return j;
  }
  
  private static int h(@NonNull BaseALIoTDevice paramBaseALIoTDevice)
  {
    return 1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\z0\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */