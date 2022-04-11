package com.tplink.iot.model.about;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.cloud.context.b;
import com.tplink.iot.Utils.t0;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.QuickSetupComponentExtraInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.Utils.x;
import com.tplink.libtpnetwork.cameranetwork.util.f;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class d
{
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("&locale=");
    localStringBuilder.append(f());
    return localStringBuilder.toString();
  }
  
  private static FaqsParamBean b(Context paramContext, String paramString)
  {
    Object localObject1 = b.d.s.a.a.f().c();
    String str1 = t0.b(paramContext);
    Object localObject2 = new Timestamp(System.currentTimeMillis());
    String str2 = new SimpleDateFormat("yyyyMMdd").format((Date)localObject2);
    String str3 = t0.a(paramContext);
    String str4 = t0.d(paramContext);
    String str5 = com.tplink.iot.d.a.a.toLowerCase();
    Object localObject3 = "";
    if (localObject1 != null)
    {
      if (((TCAccountBean)localObject1).getCloudUserName() == null) {
        localObject2 = "";
      } else {
        localObject2 = ((TCAccountBean)localObject1).getCloudUserName();
      }
      if (((TCAccountBean)localObject1).getNickName() == null) {
        paramContext = "";
      } else {
        paramContext = ((TCAccountBean)localObject1).getNickName();
      }
    }
    else
    {
      paramContext = "";
      localObject2 = paramContext;
    }
    String str6 = Build.BRAND;
    localObject1 = localObject3;
    if (str6 != null)
    {
      String str7 = Build.MODEL;
      localObject1 = localObject3;
      if (str7 != null)
      {
        String str8 = Build.DEVICE;
        localObject1 = localObject3;
        if (str8 != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(str6);
          ((StringBuilder)localObject1).append(" ");
          ((StringBuilder)localObject1).append(str7);
          ((StringBuilder)localObject1).append("(");
          ((StringBuilder)localObject1).append(str8);
          ((StringBuilder)localObject1).append(")");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
    }
    localObject3 = new FaqsParamBean();
    ((FaqsParamBean)localObject3).setModeltype("Tapo");
    ((FaqsParamBean)localObject3).setArea(str1);
    ((FaqsParamBean)localObject3).setTimeStamp(str2);
    ((FaqsParamBean)localObject3).setCountry(str3);
    ((FaqsParamBean)localObject3).setAppVersion(str4);
    ((FaqsParamBean)localObject3).setMobileOsVersion(str5);
    ((FaqsParamBean)localObject3).setId((String)localObject2);
    ((FaqsParamBean)localObject3).setName(paramContext);
    ((FaqsParamBean)localObject3).setMobileType((String)localObject1);
    ((FaqsParamBean)localObject3).setTotalProductType(paramString);
    return (FaqsParamBean)localObject3;
  }
  
  public static String c(Context paramContext, List<BaseALIoTDevice> paramList, String paramString)
  {
    paramString = b(paramContext, paramString);
    paramContext = new ArrayList();
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)localIterator.next();
        if ((localBaseALIoTDevice != null) && (!TextUtils.isEmpty(localBaseALIoTDevice.getDeviceModel())))
        {
          paramList = new DeviceInfo();
          paramList.setMac(f.a(localBaseALIoTDevice.getDeviceMac()));
          paramList.setHardwareVersion(localBaseALIoTDevice.getDeviceHwVer());
          paramList.setFirmwareVersion(localBaseALIoTDevice.getDeviceFwVer());
          paramList.setProductModel(localBaseALIoTDevice.getDeviceModel());
          paramList.setProductType(localBaseALIoTDevice.getDeviceType());
          paramContext.add(paramList);
        }
      }
    }
    paramString.setDeviceInfoList(paramContext);
    return new Gson().u(paramString);
  }
  
  public static String d(Context paramContext)
  {
    return e(paramContext, null);
  }
  
  public static String e(Context paramContext, QuickSetupComponentExtraInfoBean paramQuickSetupComponentExtraInfoBean)
  {
    FaqsParamBean localFaqsParamBean = b(paramContext, "");
    paramContext = new ArrayList();
    if ((paramQuickSetupComponentExtraInfoBean != null) && (!TextUtils.isEmpty(paramQuickSetupComponentExtraInfoBean.getDeviceModel())))
    {
      DeviceInfo localDeviceInfo = new DeviceInfo();
      localDeviceInfo.setMac("");
      localDeviceInfo.setHardwareVersion("");
      localDeviceInfo.setFirmwareVersion("");
      localDeviceInfo.setProductModel(paramQuickSetupComponentExtraInfoBean.getDeviceModel());
      paramContext.add(localDeviceInfo);
    }
    localFaqsParamBean.setDeviceInfoList(paramContext);
    return new Gson().u(localFaqsParamBean);
  }
  
  public static String f()
  {
    return x.d(Locale.getDefault());
  }
  
  public static String g()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://www.tapo.com/app/user-improvement-program/");
    localStringBuilder.append(f());
    localStringBuilder.append("/");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\model\about\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */