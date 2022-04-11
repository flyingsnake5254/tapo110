package com.tplink.iot.Utils.z0;

import android.text.TextUtils;
import androidx.annotation.DrawableRes;
import b.d.b.f.b;
import com.tplink.iot.model.iot.EnumDeviceNicknameType;
import com.tplink.iot.view.quicksetup.base.EnumCountry;
import com.tplink.iot.view.quicksetup.base.c;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyManagerRepository;
import com.tplink.libtpnetwork.enumerate.EnumIoTAvatarType;

public class q
{
  @DrawableRes
  public static int a(EnumCountry paramEnumCountry, String paramString)
  {
    if (paramEnumCountry == null) {
      return 2131690395;
    }
    int i = a.b[paramEnumCountry.ordinal()];
    if (i != 2)
    {
      if (i != 3)
      {
        if (i != 4)
        {
          if (i != 5)
          {
            if ("P115".equals(paramString)) {
              return 2131690398;
            }
            return 2131690395;
          }
          return 2131690396;
        }
        return 2131690399;
      }
      return 2131690397;
    }
    return 2131690400;
  }
  
  private static int b(int paramInt)
  {
    int i;
    if (paramInt == 1) {
      i = 2131690038;
    } else if (paramInt == 2) {
      i = 2131690039;
    } else {
      i = 2131690041;
    }
    EnumCountry localEnumCountry = c.p();
    if (a.b[localEnumCountry.ordinal()] == 1) {
      if (paramInt == 1) {
        i = 2131690042;
      } else if (paramInt == 2) {
        i = 2131690043;
      } else {
        i = 2131690044;
      }
    }
    return i;
  }
  
  private static String c(BaseALIoTDevice paramBaseALIoTDevice)
  {
    if ((paramBaseALIoTDevice != null) && (!paramBaseALIoTDevice.isUserRoleTypeDevice()))
    {
      String str = paramBaseALIoTDevice.getFamilyId();
      paramBaseALIoTDevice = paramBaseALIoTDevice.getRoomId();
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramBaseALIoTDevice)))
      {
        paramBaseALIoTDevice = ((FamilyManagerRepository)b.a(b.d.s.a.a.f(), FamilyManagerRepository.class)).f0(str, paramBaseALIoTDevice);
        if (TextUtils.isEmpty(paramBaseALIoTDevice)) {
          return "";
        }
        return paramBaseALIoTDevice;
      }
    }
    return "";
  }
  
  private static String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return EnumDeviceNicknameType.fromType(EnumDeviceNicknameType.BEDROOM);
    }
    EnumDeviceNicknameType localEnumDeviceNicknameType = EnumDeviceNicknameType.fromString(paramString);
    if (localEnumDeviceNicknameType == null) {
      return b.d.w.h.a.a(paramString);
    }
    return EnumDeviceNicknameType.fromType(localEnumDeviceNicknameType);
  }
  
  public static String e(BaseALIoTDevice paramBaseALIoTDevice)
  {
    String str = c(paramBaseALIoTDevice);
    if ((paramBaseALIoTDevice != null) && (!paramBaseALIoTDevice.isSupportIoTCloud())) {
      return d(paramBaseALIoTDevice.getDeviceLocation());
    }
    return str;
  }
  
  private static int f(EnumIoTAvatarType paramEnumIoTAvatarType, int paramInt)
  {
    int i;
    if (paramInt == 1) {
      i = 2131690038;
    } else if (paramInt == 2) {
      i = 2131690039;
    } else {
      i = 2131690041;
    }
    int j = i;
    if (paramEnumIoTAvatarType != null) {
      switch (a.a[paramEnumIoTAvatarType.ordinal()])
      {
      default: 
        j = i;
        break;
      case 15: 
        if (paramInt == 1) {
          j = 2131690018;
        } else if (paramInt == 2) {
          j = 2131690019;
        } else {
          j = 2131690020;
        }
        break;
      case 14: 
        if (paramInt == 1) {
          j = 2131689961;
        } else if (paramInt == 2) {
          j = 2131689962;
        } else {
          j = 2131689963;
        }
        break;
      case 13: 
        if (paramInt == 1) {
          j = 2131689991;
        } else if (paramInt == 2) {
          j = 2131689992;
        } else {
          j = 2131689993;
        }
        break;
      case 12: 
        if (paramInt == 1) {
          j = 2131690027;
        } else if (paramInt == 2) {
          j = 2131690028;
        } else {
          j = 2131690029;
        }
        break;
      case 11: 
        if (paramInt == 1) {
          j = 2131689984;
        } else if (paramInt == 2) {
          j = 2131689985;
        } else {
          j = 2131689986;
        }
        break;
      case 10: 
        if (paramInt == 1) {
          j = 2131690030;
        } else if (paramInt == 2) {
          j = 2131690031;
        } else {
          j = 2131690032;
        }
        break;
      case 9: 
        if (paramInt == 1) {
          j = 2131690024;
        } else if (paramInt == 2) {
          j = 2131690025;
        } else {
          j = 2131690026;
        }
        break;
      case 8: 
        if (paramInt == 1) {
          j = 2131690045;
        } else if (paramInt == 2) {
          j = 2131690046;
        } else {
          j = 2131690047;
        }
        break;
      case 7: 
        if (paramInt == 1) {
          j = 2131690055;
        } else if (paramInt == 2) {
          j = 2131690056;
        } else {
          j = 2131690057;
        }
        break;
      case 6: 
        if (paramInt == 1) {
          j = 2131690108;
        } else if (paramInt == 2) {
          j = 2131690109;
        } else {
          j = 2131690110;
        }
        break;
      case 5: 
        if (paramInt == 1) {
          j = 2131690093;
        } else if (paramInt == 2) {
          j = 2131690094;
        } else {
          j = 2131690095;
        }
        break;
      case 4: 
        if (paramInt == 1) {
          j = 2131689975;
        } else if (paramInt == 2) {
          j = 2131689976;
        } else {
          j = 2131689977;
        }
        break;
      case 3: 
        if (paramInt == 1) {
          j = 2131690081;
        } else if (paramInt == 2) {
          j = 2131690085;
        } else {
          j = 2131690092;
        }
        break;
      case 2: 
        if (paramInt == 1) {
          j = 2131689994;
        } else if (paramInt == 2) {
          j = 2131689995;
        } else {
          j = 2131689996;
        }
        break;
      case 1: 
        j = b(paramInt);
      }
    }
    return j;
  }
  
  public static int g(EnumIoTAvatarType paramEnumIoTAvatarType)
  {
    return f(paramEnumIoTAvatarType, 1);
  }
  
  public static int h(EnumIoTAvatarType paramEnumIoTAvatarType)
  {
    return f(paramEnumIoTAvatarType, 2);
  }
  
  public static int i(EnumIoTAvatarType paramEnumIoTAvatarType)
  {
    return f(paramEnumIoTAvatarType, 3);
  }
  
  public static boolean j(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    if ((paramString.startsWith("P110")) || (paramString.startsWith("P115"))) {
      bool2 = true;
    }
    return bool2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\z0\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */