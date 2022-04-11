package com.tplink.iot.Utils.z0;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.tplink.iot.Utils.extension.b;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.Utils.p0;
import com.tplink.iot.Utils.q0;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.view.iotsensor.ButtonReplaceBatteryFragment;
import com.tplink.iot.view.iotsensor.ContactSensorReplaceBatteryFragment;
import com.tplink.iot.view.iotsensor.MotionSensorReplaceBatteryFragment;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.common.TriggerLog;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumButtonAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumContactSensorAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumSensorAvatarType;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

public class r
{
  @NonNull
  public static String a(String paramString)
  {
    String str = AppContext.c.getString(2131954057);
    if (TextUtils.isEmpty(paramString)) {
      return str;
    }
    paramString.hashCode();
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 78189475: 
      if (paramString.equals("S200B")) {
        i = 2;
      }
      break;
    case 2551100: 
      if (paramString.equals("T110")) {
        i = 1;
      }
      break;
    case 2551069: 
      if (paramString.equals("T100")) {
        i = 0;
      }
      break;
    }
    switch (i)
    {
    default: 
      return str;
    case 2: 
      return AppContext.c.getString(2131954030);
    case 1: 
      return AppContext.c.getString(2131952871);
    }
    return AppContext.c.getString(2131952877);
  }
  
  public static String b(Context paramContext, BaseALIoTDevice<?> paramBaseALIoTDevice, TriggerLog paramTriggerLog)
  {
    if ((paramBaseALIoTDevice != null) && (paramTriggerLog != null) && (paramContext != null))
    {
      TimeZone localTimeZone = p0.d(paramBaseALIoTDevice.getDeviceRegion());
      Date localDate = new Date(paramTriggerLog.getTimestamp() * 1000L);
      if (q0.f(localDate, new Date(), localTimeZone))
      {
        if (o0.p(paramContext)) {
          paramBaseALIoTDevice = "H:mm";
        } else {
          paramBaseALIoTDevice = "h:mm a";
        }
      }
      else if (o0.p(paramContext)) {
        paramBaseALIoTDevice = "MM/dd H:mm";
      } else {
        paramBaseALIoTDevice = "MM/dd h:mm a";
      }
      paramBaseALIoTDevice = b.b(localDate, paramBaseALIoTDevice, localTimeZone);
      if ("open".equals(paramTriggerLog.getEvent())) {
        return paramContext.getString(2131952850, new Object[] { paramBaseALIoTDevice });
      }
      if ("close".equals(paramTriggerLog.getEvent())) {
        return paramContext.getString(2131952847, new Object[] { paramBaseALIoTDevice });
      }
      if ("singleClick".equals(paramTriggerLog.getEvent())) {
        return paramContext.getString(2131952851, new Object[] { paramBaseALIoTDevice });
      }
      if ("doubleClick".equals(paramTriggerLog.getEvent())) {
        return paramContext.getString(2131952848, new Object[] { paramBaseALIoTDevice });
      }
      if ("rotation".equals(paramTriggerLog.getEvent()))
      {
        if (m(paramTriggerLog) < 0.0D) {
          return paramContext.getString(2131952845, new Object[] { paramBaseALIoTDevice });
        }
        return paramContext.getString(2131952846, new Object[] { paramBaseALIoTDevice });
      }
      if ("keepOpen".equals(paramTriggerLog.getEvent())) {
        return paramContext.getString(2131952849, new Object[] { Integer.valueOf(1), paramBaseALIoTDevice });
      }
      return paramContext.getString(2131952828, new Object[] { paramBaseALIoTDevice });
    }
    return "";
  }
  
  private static int c(EnumButtonAvatarType paramEnumButtonAvatarType, int paramInt)
  {
    int i;
    if (paramInt == 1) {
      i = 2131689968;
    } else if (paramInt == 2) {
      i = 2131689969;
    } else {
      i = 2131689970;
    }
    int j = i;
    if (paramEnumButtonAvatarType != null) {
      if (paramEnumButtonAvatarType == EnumButtonAvatarType.DOORBELL)
      {
        if (paramInt == 1) {
          j = 2131689988;
        } else if (paramInt == 2) {
          j = 2131689989;
        } else {
          j = 2131689990;
        }
      }
      else if (paramEnumButtonAvatarType == EnumButtonAvatarType.BULB)
      {
        if (paramInt == 1) {
          j = 2131689964;
        } else if (paramInt == 2) {
          j = 2131689965;
        } else {
          j = 2131689967;
        }
      }
      else
      {
        j = i;
        if (paramEnumButtonAvatarType == EnumButtonAvatarType.WINDOW) {
          if (paramInt == 1) {
            j = 2131690460;
          } else if (paramInt == 2) {
            j = 2131690461;
          } else {
            j = 2131690462;
          }
        }
      }
    }
    return j;
  }
  
  private static int d(EnumContactSensorAvatarType paramEnumContactSensorAvatarType, int paramInt)
  {
    int i;
    if (paramInt == 1) {
      i = 2131690051;
    } else if (paramInt == 2) {
      i = 2131690052;
    } else {
      i = 2131690053;
    }
    int j = i;
    if (paramEnumContactSensorAvatarType != null) {
      if (paramEnumContactSensorAvatarType == EnumContactSensorAvatarType.OUTDOOR)
      {
        if (paramInt == 1) {
          j = 2131690238;
        } else if (paramInt == 2) {
          j = 2131690239;
        } else {
          j = 2131690240;
        }
      }
      else if (paramEnumContactSensorAvatarType == EnumContactSensorAvatarType.HALLWAY)
      {
        if (paramInt == 1) {
          j = 2131689692;
        } else if (paramInt == 2) {
          j = 2131689693;
        } else {
          j = 2131689694;
        }
      }
      else if (paramEnumContactSensorAvatarType == EnumContactSensorAvatarType.WINDOW)
      {
        if (paramInt == 1) {
          j = 2131690460;
        } else if (paramInt == 2) {
          j = 2131690461;
        } else {
          j = 2131690462;
        }
      }
      else if (paramEnumContactSensorAvatarType == EnumContactSensorAvatarType.BEDROOM)
      {
        if (paramInt == 1) {
          j = 2131689505;
        } else if (paramInt == 2) {
          j = 2131689506;
        } else {
          j = 2131689507;
        }
      }
      else
      {
        j = i;
        if (paramEnumContactSensorAvatarType == EnumContactSensorAvatarType.LIVING_ROOM) {
          if (paramInt == 1) {
            j = 2131690165;
          } else if (paramInt == 2) {
            j = 2131690166;
          } else {
            j = 2131690167;
          }
        }
      }
    }
    return j;
  }
  
  public static int e(String paramString1, String paramString2)
  {
    return i(paramString1, paramString2, 1);
  }
  
  public static int f(String paramString1, String paramString2)
  {
    return i(paramString1, paramString2, 2);
  }
  
  public static int g(String paramString1, String paramString2)
  {
    return i(paramString1, paramString2, 3);
  }
  
  private static int h(EnumSensorAvatarType paramEnumSensorAvatarType, int paramInt)
  {
    int i;
    if (paramInt == 1) {
      i = 2131690048;
    } else if (paramInt == 2) {
      i = 2131690049;
    } else {
      i = 2131690050;
    }
    int j = i;
    if (paramEnumSensorAvatarType != null) {
      if (paramEnumSensorAvatarType == EnumSensorAvatarType.OUTDOOR)
      {
        if (paramInt == 1) {
          j = 2131690238;
        } else if (paramInt == 2) {
          j = 2131690239;
        } else {
          j = 2131690240;
        }
      }
      else if (paramEnumSensorAvatarType == EnumSensorAvatarType.HALLWAY)
      {
        if (paramInt == 1) {
          j = 2131689692;
        } else if (paramInt == 2) {
          j = 2131689693;
        } else {
          j = 2131689694;
        }
      }
      else if (paramEnumSensorAvatarType == EnumSensorAvatarType.WINDOW)
      {
        if (paramInt == 1) {
          j = 2131690460;
        } else if (paramInt == 2) {
          j = 2131690461;
        } else {
          j = 2131690462;
        }
      }
      else if (paramEnumSensorAvatarType == EnumSensorAvatarType.BEDROOM)
      {
        if (paramInt == 1) {
          j = 2131689505;
        } else if (paramInt == 2) {
          j = 2131689506;
        } else {
          j = 2131689507;
        }
      }
      else
      {
        j = i;
        if (paramEnumSensorAvatarType == EnumSensorAvatarType.LIVING_ROOM) {
          if (paramInt == 1) {
            j = 2131690165;
          } else if (paramInt == 2) {
            j = 2131690166;
          } else {
            j = 2131690167;
          }
        }
      }
    }
    return j;
  }
  
  private static int i(String paramString1, String paramString2, int paramInt)
  {
    if ("T110".equals(paramString2)) {
      return d(EnumContactSensorAvatarType.fromString(paramString1), paramInt);
    }
    if ("S200B".equals(paramString2)) {
      return c(EnumButtonAvatarType.fromString(paramString1), paramInt);
    }
    return h(EnumSensorAvatarType.fromString(paramString1), paramInt);
  }
  
  public static boolean j(@Nullable BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    if (paramBaseALIoTDevice == null) {
      return false;
    }
    return "S200B".equals(paramBaseALIoTDevice.getDeviceModel());
  }
  
  public static boolean k(@Nullable BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    if (paramBaseALIoTDevice == null) {
      return false;
    }
    return "T110".equals(paramBaseALIoTDevice.getDeviceModel());
  }
  
  public static boolean l(@Nullable BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    if (paramBaseALIoTDevice == null) {
      return false;
    }
    return "T100".equals(paramBaseALIoTDevice.getDeviceModel());
  }
  
  private static double m(@NonNull TriggerLog paramTriggerLog)
  {
    if (paramTriggerLog.getParams() != null) {
      paramTriggerLog = paramTriggerLog.getParams().get("rotate_deg");
    } else {
      paramTriggerLog = null;
    }
    try
    {
      double d = Double.parseDouble(String.valueOf(paramTriggerLog));
      return d;
    }
    catch (Exception paramTriggerLog)
    {
      paramTriggerLog.printStackTrace();
    }
    return 0.0D;
  }
  
  public static void n(@Nullable FragmentManager paramFragmentManager, @Nullable BaseALIoTDevice paramBaseALIoTDevice)
  {
    if ((paramFragmentManager != null) && (paramBaseALIoTDevice != null) && (paramBaseALIoTDevice.isSensor())) {
      if (l(paramBaseALIoTDevice)) {
        new MotionSensorReplaceBatteryFragment().show(paramFragmentManager, null);
      } else if (k(paramBaseALIoTDevice)) {
        new ContactSensorReplaceBatteryFragment().show(paramFragmentManager, null);
      } else if (j(paramBaseALIoTDevice)) {
        new ButtonReplaceBatteryFragment().show(paramFragmentManager, null);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\z0\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */