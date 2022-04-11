package com.tplink.libtpnetwork.TPCloudNetwork.bean;

import com.tplink.iot.cloud.bean.thing.common.ThingInfo;
import com.tplink.iot.cloud.bean.thing.common.ThingSetting;
import com.tplink.iot.cloud.bean.thing.common.ThingShadow;
import com.tplink.iot.cloud.bean.thing.common.ThingShadowState;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ThingDevice
  implements Serializable
{
  private ThingInfo mThingInfo;
  private ThingSetting mThingSetting;
  private ThingShadow mThingShadow;
  
  public ThingDevice(ThingInfo paramThingInfo)
  {
    this.mThingInfo = paramThingInfo;
  }
  
  public String getCategory()
  {
    Object localObject = this.mThingInfo;
    if (localObject != null) {
      localObject = ((ThingInfo)localObject).getCategory();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public String getDeviceType()
  {
    Object localObject = this.mThingInfo;
    if (localObject != null) {
      localObject = ((ThingInfo)localObject).getDeviceType();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public String getEdgeThingName()
  {
    Object localObject = this.mThingInfo;
    if (localObject != null) {
      localObject = ((ThingInfo)localObject).getEdgeThingName();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public String getFamilyId()
  {
    Object localObject = this.mThingInfo;
    if (localObject != null) {
      localObject = ((ThingInfo)localObject).getFamilyId();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public String getLang()
  {
    Object localObject = this.mThingSetting;
    if (localObject != null) {
      localObject = ((ThingSetting)localObject).getLang();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public String getMac()
  {
    Object localObject = this.mThingInfo;
    if (localObject != null) {
      localObject = ((ThingInfo)localObject).getMac();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public String getModel()
  {
    Object localObject = this.mThingInfo;
    if (localObject != null) {
      localObject = ((ThingInfo)localObject).getModel();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public String getNickname()
  {
    Object localObject = this.mThingInfo;
    if (localObject != null) {
      localObject = ((ThingInfo)localObject).getNickname();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public int getOnBoardingTime()
  {
    ThingInfo localThingInfo = this.mThingInfo;
    if (localThingInfo != null) {
      return localThingInfo.getOnboardingTime();
    }
    return 0;
  }
  
  public String getRoomId()
  {
    Object localObject = this.mThingInfo;
    if (localObject != null) {
      localObject = ((ThingInfo)localObject).getRoomId();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public String getThingGatewayUrl()
  {
    Object localObject = this.mThingInfo;
    if (localObject != null) {
      localObject = ((ThingInfo)localObject).getCloudGatewayUrl();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public String getThingGatewayUrlV2()
  {
    Object localObject = this.mThingInfo;
    if (localObject != null) {
      localObject = ((ThingInfo)localObject).getCloudGatewayUrlV2();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public ThingInfo getThingInfo()
  {
    return this.mThingInfo;
  }
  
  public String getThingModelId()
  {
    Object localObject = this.mThingInfo;
    if (localObject != null) {
      localObject = ((ThingInfo)localObject).getThingModelId();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public String getThingName()
  {
    Object localObject = this.mThingInfo;
    if (localObject != null) {
      localObject = ((ThingInfo)localObject).getThingName();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public ThingSetting getThingSetting()
  {
    return this.mThingSetting;
  }
  
  public ThingShadow getThingShadow()
  {
    return this.mThingShadow;
  }
  
  public String getThingUrl()
  {
    Object localObject = this.mThingInfo;
    if (localObject != null) {
      localObject = ((ThingInfo)localObject).getAppServerUrl();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public boolean isCamera()
  {
    boolean bool;
    if (EnumDeviceType.CAMERA == EnumDeviceType.fromType(getDeviceType())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isCommonDevice()
  {
    ThingInfo localThingInfo = this.mThingInfo;
    if (localThingInfo != null) {
      return localThingInfo.isCommonDevice();
    }
    return true;
  }
  
  public boolean isHasThingInfo()
  {
    boolean bool;
    if (this.mThingInfo != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isSubThing()
  {
    ThingInfo localThingInfo = this.mThingInfo;
    boolean bool;
    if ((localThingInfo != null) && (localThingInfo.isSubThing())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isThingOnline()
  {
    ThingInfo localThingInfo = this.mThingInfo;
    boolean bool = true;
    if ((localThingInfo == null) || (localThingInfo.getStatus() != 1)) {
      bool = false;
    }
    return bool;
  }
  
  public void setCommonDevice(boolean paramBoolean)
  {
    ThingInfo localThingInfo = this.mThingInfo;
    if (localThingInfo != null) {
      localThingInfo.setCommonDevice(paramBoolean);
    }
  }
  
  public void setFamilyId(String paramString)
  {
    ThingInfo localThingInfo = this.mThingInfo;
    if (localThingInfo != null) {
      localThingInfo.setFamilyId(paramString);
    }
  }
  
  public void setRoomId(String paramString)
  {
    ThingInfo localThingInfo = this.mThingInfo;
    if (localThingInfo != null) {
      localThingInfo.setFamilyId(paramString);
    }
  }
  
  public void setThingInfo(ThingInfo paramThingInfo)
  {
    this.mThingInfo = paramThingInfo;
  }
  
  public void setThingSetting(ThingSetting paramThingSetting)
  {
    this.mThingSetting = paramThingSetting;
  }
  
  public void setThingShadow(ThingShadow paramThingShadow)
  {
    this.mThingShadow = paramThingShadow;
  }
  
  public void updateThingShadow(long paramLong, Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    Object localObject = this.mThingShadow;
    if (localObject == null)
    {
      localObject = paramMap1;
      if (paramMap1 == null) {
        localObject = new HashMap();
      }
      paramMap1 = paramMap2;
      if (paramMap2 == null) {
        paramMap1 = new HashMap();
      }
      this.mThingShadow = new ThingShadow(paramLong, new ThingShadowState((Map)localObject, paramMap1));
    }
    else if (paramLong >= ((ThingShadow)localObject).getVersion())
    {
      this.mThingShadow.setVersion(paramLong);
      if (paramMap1 != null)
      {
        localObject = this.mThingShadow.getState().getDesired();
        if (localObject == null)
        {
          paramMap1 = new HashMap(paramMap1);
          this.mThingShadow.getState().setDesired(paramMap1);
        }
        else
        {
          ((Map)localObject).putAll(paramMap1);
        }
      }
      if (paramMap2 != null)
      {
        paramMap1 = this.mThingShadow.getState().getReported();
        if (paramMap1 == null)
        {
          paramMap1 = new HashMap(paramMap2);
          this.mThingShadow.getState().setReported(paramMap1);
        }
        else
        {
          paramMap1.putAll(paramMap2);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TPCloudNetwork\bean\ThingDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */