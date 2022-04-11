package com.tplink.iot.Utils.z0;

import android.content.Context;
import android.graphics.Color;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DesiredStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;

public class i
{
  public static int a(int paramInt1, int paramInt2)
  {
    return Color.HSVToColor(new float[] { (float)(paramInt1 * 1.0D), (float)(paramInt2 * 1.0D / 100.0D), 1.0F });
  }
  
  public static String b(Context paramContext, String paramString)
  {
    int i;
    if ("light_track".equals(paramString)) {
      i = 2131952982;
    } else {
      i = 2131952909;
    }
    return paramContext.getString(i);
  }
  
  public static int c(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0) {
      return a(paramInt2, paramInt3);
    }
    return -1;
  }
  
  public static int d(LightStateBean paramLightStateBean)
  {
    if (paramLightStateBean == null) {
      return -1;
    }
    return c(paramLightStateBean.getColorTemp(), paramLightStateBean.getHue(), paramLightStateBean.getSaturation());
  }
  
  public static String e(int paramInt)
  {
    if (paramInt == 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" (");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("K)");
    return localStringBuilder.toString();
  }
  
  public static int f(String paramString)
  {
    if ("L2".equals(paramString)) {
      return 2131689710;
    }
    return 2131689711;
  }
  
  public static int g(DesiredStatesBean paramDesiredStatesBean)
  {
    if ((paramDesiredStatesBean != null) && ((!paramDesiredStatesBean.isOn()) || (!paramDesiredStatesBean.isAuto())))
    {
      if (paramDesiredStatesBean.isOn())
      {
        if (paramDesiredStatesBean.getColorTemp() != 0) {
          return -2147483647;
        }
        return a(paramDesiredStatesBean.getHue(), paramDesiredStatesBean.getSaturation());
      }
      return Color.parseColor("#D4E2EE");
    }
    return 0;
  }
  
  public static String h(int paramInt)
  {
    String str = Integer.toHexString(paramInt & 0xFFFFFF).toUpperCase();
    int i = str.length();
    StringBuilder localStringBuilder = new StringBuilder();
    for (paramInt = 0; paramInt < 6 - i; paramInt++) {
      localStringBuilder.append("0");
    }
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\z0\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */