package com.tplink.libtpnetwork.Utils;

import android.text.TextUtils;
import b.d.w.h.a;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.libtpnetwork.IoTNetwork.transport.http.c;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import com.tplink.tdp.bean.BaseTDPDevice;

public class z
{
  public static c a(TCAccountBean paramTCAccountBean, TDPIoTDevice paramTDPIoTDevice)
  {
    if ((paramTCAccountBean != null) && (paramTDPIoTDevice != null))
    {
      int i;
      if ((paramTDPIoTDevice.getHttpPort() != 0) && (!paramTDPIoTDevice.isSupportHttps())) {
        i = paramTDPIoTDevice.getHttpPort();
      } else {
        i = 80;
      }
      Object localObject;
      if (("amazon_atr".equals(paramTDPIoTDevice.getObdSrc())) && (paramTCAccountBean.getCloudUserName() != null))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(a.g(paramTCAccountBean.getCloudUserName()));
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(b(paramTDPIoTDevice.getMac()));
        localObject = a.g(((StringBuilder)localObject).toString());
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramTCAccountBean.getCloudUserName());
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(b(paramTDPIoTDevice.getMac()));
        localObject = ((StringBuilder)localObject).toString();
      }
      return new c(paramTDPIoTDevice.getIp(), i, paramTCAccountBean.getCloudUserName(), paramTCAccountBean.getPassword(), paramTDPIoTDevice.getDeviceIdMd5(), (String)localObject);
    }
    return null;
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if (paramString.contains("-")) {
      return paramString.replace("-", ":");
    }
    Object localObject = paramString;
    if (!paramString.contains(":")) {
      if (paramString.length() != 12)
      {
        localObject = paramString;
      }
      else
      {
        localObject = new StringBuilder();
        for (int i = 0; i < 12; i++)
        {
          ((StringBuilder)localObject).append(paramString.charAt(i));
          if ((i % 2 == 1) && (i <= 9)) {
            ((StringBuilder)localObject).append(":");
          }
        }
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return (String)localObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\Utils\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */