package com.tplink.libtpnetwork.cameranetwork.model;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;

public final class HomePageDeviceInfo
{
  public static final Companion Companion = new Companion(null);
  private CameraComponent componentInfo;
  private BasicInfo deviceInfo;
  private LastAlarmInfo lastAlarmInfo;
  
  public HomePageDeviceInfo(BasicInfo paramBasicInfo, LastAlarmInfo paramLastAlarmInfo, CameraComponent paramCameraComponent)
  {
    this.deviceInfo = paramBasicInfo;
    this.lastAlarmInfo = paramLastAlarmInfo;
    this.componentInfo = paramCameraComponent;
  }
  
  public final BasicInfo component1()
  {
    return this.deviceInfo;
  }
  
  public final LastAlarmInfo component2()
  {
    return this.lastAlarmInfo;
  }
  
  public final CameraComponent component3()
  {
    return this.componentInfo;
  }
  
  public final HomePageDeviceInfo copy(BasicInfo paramBasicInfo, LastAlarmInfo paramLastAlarmInfo, CameraComponent paramCameraComponent)
  {
    return new HomePageDeviceInfo(paramBasicInfo, paramLastAlarmInfo, paramCameraComponent);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof HomePageDeviceInfo))
      {
        paramObject = (HomePageDeviceInfo)paramObject;
        if ((j.a(this.deviceInfo, ((HomePageDeviceInfo)paramObject).deviceInfo)) && (j.a(this.lastAlarmInfo, ((HomePageDeviceInfo)paramObject).lastAlarmInfo)) && (j.a(this.componentInfo, ((HomePageDeviceInfo)paramObject).componentInfo))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final CameraComponent getComponentInfo()
  {
    return this.componentInfo;
  }
  
  public final BasicInfo getDeviceInfo()
  {
    return this.deviceInfo;
  }
  
  public final LastAlarmInfo getLastAlarmInfo()
  {
    return this.lastAlarmInfo;
  }
  
  public int hashCode()
  {
    Object localObject = this.deviceInfo;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.lastAlarmInfo;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.componentInfo;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return (j * 31 + k) * 31 + i;
  }
  
  public final void setComponentInfo(CameraComponent paramCameraComponent)
  {
    this.componentInfo = paramCameraComponent;
  }
  
  public final void setDeviceInfo(BasicInfo paramBasicInfo)
  {
    this.deviceInfo = paramBasicInfo;
  }
  
  public final void setLastAlarmInfo(LastAlarmInfo paramLastAlarmInfo)
  {
    this.lastAlarmInfo = paramLastAlarmInfo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HomePageDeviceInfo(deviceInfo=");
    localStringBuilder.append(this.deviceInfo);
    localStringBuilder.append(", lastAlarmInfo=");
    localStringBuilder.append(this.lastAlarmInfo);
    localStringBuilder.append(", componentInfo=");
    localStringBuilder.append(this.componentInfo);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static final class Companion
    implements UnwrapFromMultipleResponse<HomePageDeviceInfo>
  {
    public HomePageDeviceInfo fromMultipleResponse(MultipleResponse paramMultipleResponse)
    {
      j.e(paramMultipleResponse, "response");
      HomePageDeviceInfo localHomePageDeviceInfo = new HomePageDeviceInfo(null, null, null);
      paramMultipleResponse = paramMultipleResponse.getResponses();
      if (paramMultipleResponse != null)
      {
        Iterator localIterator = paramMultipleResponse.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (Response)localIterator.next();
          paramMultipleResponse = (Wrappers)((Response)localObject).getResult();
          localObject = ((Response)localObject).getMethod();
          if (j.a(localObject, Method.GET_DEVICE_INFO.getValue())) {
            localHomePageDeviceInfo.setDeviceInfo((BasicInfo)Model.typeCast(paramMultipleResponse, Module.DEVICE_INFO, Section.BASIC_INFO));
          } else if (j.a(localObject, Method.GET_LAST_ALARM_INFO.getValue())) {
            localHomePageDeviceInfo.setLastAlarmInfo((LastAlarmInfo)Model.typeCast(paramMultipleResponse, Module.SYSTEM, Section.LAST_ALARM_INFO));
          } else if (j.a(localObject, Method.GET_APP_COMPONENT_LIST.getValue())) {
            localHomePageDeviceInfo.setComponentInfo((CameraComponent)Model.typeCast(paramMultipleResponse, Module.APP_COMPONENT, Section.APP_COMPONENT_LIST));
          }
        }
      }
      return localHomePageDeviceInfo;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\HomePageDeviceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */