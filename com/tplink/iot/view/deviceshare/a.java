package com.tplink.iot.view.deviceshare;

import android.app.Activity;
import android.text.TextUtils;
import b.d.b.f.b;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceUserInfoBean;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCDeviceRepository;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import java.util.Iterator;
import java.util.List;

public class a
{
  public static String a(Activity paramActivity, String paramString)
  {
    int i = d(paramString);
    if ((paramString != null) && (EnumDeviceType.CAMERA == EnumDeviceType.fromType(paramString)))
    {
      paramString = new StringBuilder();
      paramString.append(i);
      paramString.append("");
      paramActivity = paramActivity.getString(2131953904, new Object[] { paramString.toString() });
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append(i);
      paramString.append("");
      paramActivity = paramActivity.getString(2131953905, new Object[] { paramString.toString() });
    }
    return paramActivity;
  }
  
  public static String b(Activity paramActivity, List<BaseALIoTDevice> paramList)
  {
    paramList = paramList.iterator();
    int i = 0;
    int j = 0;
    Object localObject;
    while (paramList.hasNext())
    {
      localObject = (BaseALIoTDevice)paramList.next();
      if ((((BaseALIoTDevice)localObject).getDeviceType() != null) && (EnumDeviceType.CAMERA == EnumDeviceType.fromType(((BaseALIoTDevice)localObject).getDeviceType()))) {
        i = 1;
      } else {
        j = 1;
      }
    }
    int k = d(null);
    int m = d(EnumDeviceType.CAMERA.getDeviceType());
    if ((i != 0) && (j != 0))
    {
      paramList = new StringBuilder();
      paramList.append(m);
      paramList.append("");
      paramList = paramList.toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append("");
      paramActivity = paramActivity.getString(2131953930, new Object[] { paramList, ((StringBuilder)localObject).toString() });
    }
    else if (i != 0)
    {
      paramList = new StringBuilder();
      paramList.append(m);
      paramList.append("");
      paramActivity = paramActivity.getString(2131953895, new Object[] { paramList.toString() });
    }
    else
    {
      paramList = new StringBuilder();
      paramList.append(k);
      paramList.append("");
      paramActivity = paramActivity.getString(2131953931, new Object[] { paramList.toString() });
    }
    return paramActivity;
  }
  
  public static String c(TCDeviceUserInfoBean paramTCDeviceUserInfoBean)
  {
    if (!TextUtils.isEmpty(paramTCDeviceUserInfoBean.getNickname())) {
      return paramTCDeviceUserInfoBean.getNickname();
    }
    paramTCDeviceUserInfoBean = paramTCDeviceUserInfoBean.getCloudUserName();
    if (TextUtils.isEmpty(paramTCDeviceUserInfoBean)) {
      return "";
    }
    int i = paramTCDeviceUserInfoBean.indexOf("@");
    if (i == -1) {
      return paramTCDeviceUserInfoBean;
    }
    return paramTCDeviceUserInfoBean.substring(0, i);
  }
  
  public static int d(String paramString)
  {
    return ((TCDeviceRepository)b.a(b.d.s.a.a.f(), TCDeviceRepository.class)).F(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\deviceshare\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */