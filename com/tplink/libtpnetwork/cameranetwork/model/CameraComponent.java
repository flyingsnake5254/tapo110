package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.j;

public final class CameraComponent
{
  @c("app_component_list")
  private final ArrayList<ComponentBean> componentList;
  
  public CameraComponent(ArrayList<ComponentBean> paramArrayList)
  {
    this.componentList = paramArrayList;
  }
  
  public final ArrayList<ComponentBean> component1()
  {
    return this.componentList;
  }
  
  public final CameraComponent copy(ArrayList<ComponentBean> paramArrayList)
  {
    j.e(paramArrayList, "componentList");
    return new CameraComponent(paramArrayList);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof CameraComponent))
      {
        paramObject = (CameraComponent)paramObject;
        if (j.a(this.componentList, ((CameraComponent)paramObject).componentList)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int getComponent(ComponentType paramComponentType)
  {
    j.e(paramComponentType, "type");
    Iterator localIterator = this.componentList.iterator();
    while (localIterator.hasNext())
    {
      ComponentBean localComponentBean = (ComponentBean)localIterator.next();
      if (paramComponentType == ComponentType.fromComponentName(localComponentBean.getName())) {
        return localComponentBean.getVersion();
      }
    }
    return -1;
  }
  
  public final ArrayList<ComponentBean> getComponentList()
  {
    return this.componentList;
  }
  
  public final boolean hasComponent(ComponentType paramComponentType)
  {
    j.e(paramComponentType, "type");
    return paramComponentType.isTargetComponentVersionAPPSupport(getComponent(paramComponentType));
  }
  
  public int hashCode()
  {
    ArrayList localArrayList = this.componentList;
    int i;
    if (localArrayList != null) {
      i = localArrayList.hashCode();
    } else {
      i = 0;
    }
    return i;
  }
  
  public final boolean isSupportBabyCry()
  {
    return hasComponent(ComponentType.BABY_CRYING_DETECTION);
  }
  
  public final boolean isSupportFirmware()
  {
    return hasComponent(ComponentType.FIRMWARE);
  }
  
  public final boolean isSupportFwAutoUpdate()
  {
    boolean bool;
    if (getComponent(ComponentType.FIRMWARE) >= 2) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final boolean isSupportIntrusionDetection()
  {
    return hasComponent(ComponentType.INTRUSION_DETECTION);
  }
  
  public final boolean isSupportIoTCloud()
  {
    return hasComponent(ComponentType.IOT_CLOUD);
  }
  
  public final boolean isSupportLineCrossingDetection()
  {
    return hasComponent(ComponentType.LINE_CROSSING_DETECTION);
  }
  
  public final boolean isSupportMsgPush()
  {
    boolean bool;
    if (getComponent(ComponentType.MSG_PUSH) >= 2) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final boolean isSupportNightVision()
  {
    return hasComponent(ComponentType.NIGHT_VISION_MODE);
  }
  
  public final boolean isSupportOsdLogo()
  {
    boolean bool;
    if (getComponent(ComponentType.OSD) >= 2) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final boolean isSupportPersonDetection()
  {
    return hasComponent(ComponentType.PERSON_DETECTION);
  }
  
  public final boolean isSupportPersonEnhanced()
  {
    boolean bool;
    if (getComponent(ComponentType.DETECTION) >= 2) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final boolean isSupportSnapshot()
  {
    boolean bool;
    if (getComponent(ComponentType.PLAYBACK) >= 3) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final boolean isSupportSubscriptionService()
  {
    return hasComponent(ComponentType.NEED_SUBSCRIPTION_SERVICE_LIST);
  }
  
  public final boolean isSupportTamperDetection()
  {
    return hasComponent(ComponentType.TAMPER_DETECTION);
  }
  
  public final boolean isSupportUpnp()
  {
    return hasComponent(ComponentType.UPNPC);
  }
  
  public final boolean isSupportUtcDst()
  {
    boolean bool;
    if (getComponent(ComponentType.PLAYBACK) >= 2) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final boolean isSupportVideoQuality()
  {
    boolean bool;
    if (getComponent(ComponentType.VIDEO) >= 2) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final boolean isSupportVideoQualityChange()
  {
    int i = getComponent(ComponentType.VIDEO);
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  public final boolean isSupportWhiteLampConfig()
  {
    boolean bool;
    if (getComponent(ComponentType.NIGHT_VISION_MODE) >= 2) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CameraComponent(componentList=");
    localStringBuilder.append(this.componentList);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\CameraComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */