package com.tplink.iot.model.firmware;

import android.content.Context;
import androidx.annotation.Nullable;
import com.tplink.iot.Utils.z0.r;
import com.tplink.iot.g.d.a.b;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import java.util.List;

public class s
{
  public static String a(Context paramContext, IotSeriesBean paramIotSeriesBean, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 2131952699;
    } else {
      i = 2131952700;
    }
    int j = i;
    if (paramIotSeriesBean != null)
    {
      j = i;
      if (!paramIotSeriesBean.getIoTDeviceStateList().isEmpty())
      {
        paramIotSeriesBean = (t)paramIotSeriesBean.getIoTDeviceStateList().get(0);
        j = i;
        if (paramIotSeriesBean != null)
        {
          j = i;
          if (paramIotSeriesBean.d() != null)
          {
            paramIotSeriesBean = paramIotSeriesBean.d();
            if (paramIotSeriesBean.isCamera())
            {
              if (paramBoolean) {
                j = 2131954032;
              } else {
                j = 2131952698;
              }
            }
            else if (paramIotSeriesBean.isBulb())
            {
              if (paramIotSeriesBean.isLightStrip())
              {
                if (paramBoolean) {
                  j = 2131954052;
                } else {
                  j = 2131952875;
                }
              }
              else if (paramBoolean) {
                j = 2131954029;
              } else {
                j = 2131952697;
              }
            }
            else if (paramIotSeriesBean.isHub())
            {
              if (paramBoolean) {
                j = 2131954050;
              } else {
                j = 2131954051;
              }
            }
            else if (paramIotSeriesBean.isSensor())
            {
              if (r.j(paramIotSeriesBean))
              {
                if (paramBoolean) {
                  j = 2131954030;
                } else {
                  j = 2131954031;
                }
              }
              else if (paramBoolean) {
                j = 2131954057;
              } else {
                j = 2131954058;
              }
            }
            else if (paramIotSeriesBean.isSwitch())
            {
              if (paramBoolean) {
                j = 2131954061;
              } else {
                j = 2131954062;
              }
            }
            else
            {
              j = i;
              if (b.k(paramIotSeriesBean)) {
                if (paramBoolean) {
                  j = 2131954078;
                } else {
                  j = 2131954079;
                }
              }
            }
          }
        }
      }
    }
    return paramContext.getString(j);
  }
  
  public static String b(IotSeriesBean paramIotSeriesBean)
  {
    String str1 = EnumDeviceType.PLUG.getDeviceType();
    String str2 = str1;
    if (paramIotSeriesBean != null)
    {
      str2 = str1;
      if (!paramIotSeriesBean.getIoTDeviceStateList().isEmpty())
      {
        paramIotSeriesBean = (t)paramIotSeriesBean.getIoTDeviceStateList().get(0);
        str2 = str1;
        if (paramIotSeriesBean != null)
        {
          str2 = str1;
          if (paramIotSeriesBean.d() != null) {
            str2 = paramIotSeriesBean.d().getDeviceType();
          }
        }
      }
    }
    return str2;
  }
  
  public static boolean c(@Nullable BaseALIoTDevice paramBaseALIoTDevice)
  {
    if (paramBaseALIoTDevice == null) {
      return true;
    }
    return paramBaseALIoTDevice.isSensor() ^ true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\model\firmware\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */