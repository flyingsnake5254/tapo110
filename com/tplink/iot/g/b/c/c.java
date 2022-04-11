package com.tplink.iot.g.b.c;

import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DesiredStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.IoTLightStripDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumLightStripAvatarType;
import kotlin.jvm.internal.j;
import kotlin.text.m;

public final class c
{
  public static final c a = new c();
  
  @DrawableRes
  public static final int a(String paramString)
  {
    int i;
    if ((paramString != null) && (paramString.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    int j = 2131689767;
    if (i != 0) {
      return 2131689767;
    }
    if (!m.D(paramString, "L920", false, 2, null))
    {
      i = j;
      if (!m.D(paramString, "L930", false, 2, null)) {}
    }
    else
    {
      i = 2131689768;
    }
    return i;
  }
  
  public static final int b(EnumLightStripAvatarType paramEnumLightStripAvatarType)
  {
    return e(paramEnumLightStripAvatarType, 1);
  }
  
  public static final int c(EnumLightStripAvatarType paramEnumLightStripAvatarType)
  {
    return e(paramEnumLightStripAvatarType, 2);
  }
  
  public static final int d(EnumLightStripAvatarType paramEnumLightStripAvatarType)
  {
    return e(paramEnumLightStripAvatarType, 3);
  }
  
  private static final int e(EnumLightStripAvatarType paramEnumLightStripAvatarType, int paramInt)
  {
    int i = 2131690034;
    int j;
    if (paramInt == 1) {
      j = 2131690033;
    } else if (paramInt == 2) {
      j = 2131690034;
    } else {
      j = 2131690035;
    }
    if (paramEnumLightStripAvatarType == null) {
      paramInt = j;
    } else {
      switch (b.a[paramEnumLightStripAvatarType.ordinal()])
      {
      default: 
        paramInt = j;
        break;
      case 10: 
        if (paramInt == 1) {
          paramInt = 2131690105;
        } else if (paramInt == 2) {
          paramInt = 2131690106;
        } else {
          paramInt = 2131690107;
        }
        break;
      case 9: 
        if (paramInt == 1) {
          paramInt = 2131690102;
        } else if (paramInt == 2) {
          paramInt = 2131690103;
        } else {
          paramInt = 2131690104;
        }
        break;
      case 8: 
        if (paramInt == 1) {
          paramInt = 2131690099;
        } else if (paramInt == 2) {
          paramInt = 2131690100;
        } else {
          paramInt = 2131690101;
        }
        break;
      case 7: 
        if (paramInt == 1) {
          paramInt = 2131690058;
        } else if (paramInt == 2) {
          paramInt = 2131690059;
        } else {
          paramInt = 2131690060;
        }
        break;
      case 6: 
        if (paramInt == 1) {
          paramInt = 2131689972;
        } else if (paramInt == 2) {
          paramInt = 2131689973;
        } else {
          paramInt = 2131689974;
        }
        break;
      case 5: 
        if (paramInt == 1) {
          paramInt = 2131689958;
        } else if (paramInt == 2) {
          paramInt = 2131689959;
        } else {
          paramInt = 2131689960;
        }
        break;
      case 4: 
        if (paramInt == 1) {
          paramInt = 2131689955;
        } else if (paramInt == 2) {
          paramInt = 2131689956;
        } else {
          paramInt = 2131689957;
        }
        break;
      case 3: 
        if (paramInt == 1) {
          paramInt = 2131689952;
        } else if (paramInt == 2) {
          paramInt = 2131689953;
        } else {
          paramInt = 2131689954;
        }
        break;
      case 2: 
        if (paramInt == 1) {
          paramInt = 2131689949;
        } else if (paramInt == 2) {
          paramInt = 2131689950;
        } else {
          paramInt = 2131689951;
        }
        break;
      case 1: 
        if (paramInt == 1) {
          paramInt = 2131690033;
        } else if (paramInt == 2) {
          paramInt = i;
        } else {
          paramInt = 2131690035;
        }
        break;
      }
    }
    return paramInt;
  }
  
  public static final int f(DesiredStatesBean paramDesiredStatesBean)
  {
    int i = 0;
    if (paramDesiredStatesBean == null) {
      return 0;
    }
    if (paramDesiredStatesBean.isOn())
    {
      if (!paramDesiredStatesBean.isAuto()) {
        if (paramDesiredStatesBean.getColorTemp() != 0) {
          i = -1;
        } else {
          i = new com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c(paramDesiredStatesBean.getHue(), paramDesiredStatesBean.getSaturation(), 100).f();
        }
      }
      return i;
    }
    return Color.parseColor("#D4E2EE");
  }
  
  public static final boolean g(String paramString)
  {
    if (paramString != null) {
      return m.A(paramString, "L900", false, 2, null);
    }
    return false;
  }
  
  public static final boolean h(String paramString)
  {
    j.e(paramString, "deviceIdMD5");
    paramString = TPIoTClientManager.I1(paramString);
    boolean bool;
    if (paramString != null) {
      bool = paramString.isLightStrip();
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static final boolean i(String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramString != null) {
      if ((!m.A(paramString, "L900", false, 2, null)) && (!m.A(paramString, "L920", false, 2, null)))
      {
        bool2 = bool1;
        if (!m.A(paramString, "L930", false, 2, null)) {}
      }
      else
      {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public static final boolean j(String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramString != null) {
      if (!m.A(paramString, "L920", false, 2, null))
      {
        bool2 = bool1;
        if (!m.A(paramString, "L930", false, 2, null)) {}
      }
      else
      {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public static final boolean k(int[] paramArrayOfInt, boolean paramBoolean)
  {
    paramArrayOfInt = n(paramArrayOfInt);
    boolean bool = true;
    if ((paramBoolean) && (paramArrayOfInt[0] != paramArrayOfInt[1])) {
      paramBoolean = bool;
    } else {
      paramBoolean = false;
    }
    return paramBoolean;
  }
  
  public static final boolean l(int[] paramArrayOfInt, boolean paramBoolean)
  {
    paramArrayOfInt = n(paramArrayOfInt);
    boolean bool = true;
    if ((paramBoolean) && (paramArrayOfInt[0] == paramArrayOfInt[1])) {
      paramBoolean = bool;
    } else {
      paramBoolean = false;
    }
    return paramBoolean;
  }
  
  @ColorInt
  public static final int m(IoTLightStripDevice paramIoTLightStripDevice)
  {
    int i = -1;
    if (paramIoTLightStripDevice == null) {
      return -1;
    }
    if (paramIoTLightStripDevice.getColorTemp() == 0) {
      i = new com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c(paramIoTLightStripDevice.getHue(), paramIoTLightStripDevice.getSaturation(), paramIoTLightStripDevice.getBrightness()).g();
    }
    return i;
  }
  
  public static final int[] n(int[] paramArrayOfInt)
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 'ৄ';
    int[] tmp11_5 = tmp5_4;
    tmp11_5[1] = 'ᥤ';
    tmp11_5;
    if (paramArrayOfInt != null) {
      if (paramArrayOfInt.length == 1)
      {
        arrayOfInt = new int[2];
        arrayOfInt[0] = paramArrayOfInt[0];
        arrayOfInt[1] = paramArrayOfInt[0];
      }
      else if (paramArrayOfInt.length >= 2)
      {
        arrayOfInt = new int[2];
        arrayOfInt[0] = paramArrayOfInt[0];
        arrayOfInt[1] = paramArrayOfInt[1];
      }
    }
    return arrayOfInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\g\b\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */