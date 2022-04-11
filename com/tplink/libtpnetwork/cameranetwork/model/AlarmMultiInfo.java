package com.tplink.libtpnetwork.cameranetwork.model;

import com.tplink.libtpnetwork.Utils.i;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;

public final class AlarmMultiInfo
{
  public static final Companion Companion = new Companion(null);
  private BasicInfo deviceInfo;
  private LastAlarmInfo lastAlarmInfo;
  private PubIp pubIp;
  private UpnpCommStatus upnpCommStatus;
  private UpnpInfo upnpInfo;
  private UpnpPsk upnpPsk;
  private UpnpStatus upnpStatus;
  
  public AlarmMultiInfo(BasicInfo paramBasicInfo, LastAlarmInfo paramLastAlarmInfo, UpnpInfo paramUpnpInfo, UpnpStatus paramUpnpStatus, UpnpCommStatus paramUpnpCommStatus, PubIp paramPubIp, UpnpPsk paramUpnpPsk)
  {
    this.deviceInfo = paramBasicInfo;
    this.lastAlarmInfo = paramLastAlarmInfo;
    this.upnpInfo = paramUpnpInfo;
    this.upnpStatus = paramUpnpStatus;
    this.upnpCommStatus = paramUpnpCommStatus;
    this.pubIp = paramPubIp;
    this.upnpPsk = paramUpnpPsk;
  }
  
  public final BasicInfo component1()
  {
    return this.deviceInfo;
  }
  
  public final LastAlarmInfo component2()
  {
    return this.lastAlarmInfo;
  }
  
  public final UpnpInfo component3()
  {
    return this.upnpInfo;
  }
  
  public final UpnpStatus component4()
  {
    return this.upnpStatus;
  }
  
  public final UpnpCommStatus component5()
  {
    return this.upnpCommStatus;
  }
  
  public final PubIp component6()
  {
    return this.pubIp;
  }
  
  public final UpnpPsk component7()
  {
    return this.upnpPsk;
  }
  
  public final AlarmMultiInfo copy(BasicInfo paramBasicInfo, LastAlarmInfo paramLastAlarmInfo, UpnpInfo paramUpnpInfo, UpnpStatus paramUpnpStatus, UpnpCommStatus paramUpnpCommStatus, PubIp paramPubIp, UpnpPsk paramUpnpPsk)
  {
    return new AlarmMultiInfo(paramBasicInfo, paramLastAlarmInfo, paramUpnpInfo, paramUpnpStatus, paramUpnpCommStatus, paramPubIp, paramUpnpPsk);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof AlarmMultiInfo))
      {
        paramObject = (AlarmMultiInfo)paramObject;
        if ((j.a(this.deviceInfo, ((AlarmMultiInfo)paramObject).deviceInfo)) && (j.a(this.lastAlarmInfo, ((AlarmMultiInfo)paramObject).lastAlarmInfo)) && (j.a(this.upnpInfo, ((AlarmMultiInfo)paramObject).upnpInfo)) && (j.a(this.upnpStatus, ((AlarmMultiInfo)paramObject).upnpStatus)) && (j.a(this.upnpCommStatus, ((AlarmMultiInfo)paramObject).upnpCommStatus)) && (j.a(this.pubIp, ((AlarmMultiInfo)paramObject).pubIp)) && (j.a(this.upnpPsk, ((AlarmMultiInfo)paramObject).upnpPsk))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final BasicInfo getDeviceInfo()
  {
    return this.deviceInfo;
  }
  
  public final LastAlarmInfo getLastAlarmInfo()
  {
    return this.lastAlarmInfo;
  }
  
  public final PubIp getPubIp()
  {
    return this.pubIp;
  }
  
  public final UpnpCommStatus getUpnpCommStatus()
  {
    return this.upnpCommStatus;
  }
  
  public final UpnpInfo getUpnpInfo()
  {
    return this.upnpInfo;
  }
  
  public final UpnpPsk getUpnpPsk()
  {
    return this.upnpPsk;
  }
  
  public final UpnpStatus getUpnpStatus()
  {
    return this.upnpStatus;
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
    localObject = this.upnpInfo;
    int m;
    if (localObject != null) {
      m = localObject.hashCode();
    } else {
      m = 0;
    }
    localObject = this.upnpStatus;
    int n;
    if (localObject != null) {
      n = localObject.hashCode();
    } else {
      n = 0;
    }
    localObject = this.upnpCommStatus;
    int i1;
    if (localObject != null) {
      i1 = localObject.hashCode();
    } else {
      i1 = 0;
    }
    localObject = this.pubIp;
    int i2;
    if (localObject != null) {
      i2 = localObject.hashCode();
    } else {
      i2 = 0;
    }
    localObject = this.upnpPsk;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return (((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i;
  }
  
  public final void setDeviceInfo(BasicInfo paramBasicInfo)
  {
    this.deviceInfo = paramBasicInfo;
  }
  
  public final void setLastAlarmInfo(LastAlarmInfo paramLastAlarmInfo)
  {
    this.lastAlarmInfo = paramLastAlarmInfo;
  }
  
  public final void setPubIp(PubIp paramPubIp)
  {
    this.pubIp = paramPubIp;
  }
  
  public final void setUpnpCommStatus(UpnpCommStatus paramUpnpCommStatus)
  {
    this.upnpCommStatus = paramUpnpCommStatus;
  }
  
  public final void setUpnpInfo(UpnpInfo paramUpnpInfo)
  {
    this.upnpInfo = paramUpnpInfo;
  }
  
  public final void setUpnpPsk(UpnpPsk paramUpnpPsk)
  {
    this.upnpPsk = paramUpnpPsk;
  }
  
  public final void setUpnpStatus(UpnpStatus paramUpnpStatus)
  {
    this.upnpStatus = paramUpnpStatus;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AlarmMultiInfo(deviceInfo=");
    localStringBuilder.append(this.deviceInfo);
    localStringBuilder.append(", lastAlarmInfo=");
    localStringBuilder.append(this.lastAlarmInfo);
    localStringBuilder.append(", upnpInfo=");
    localStringBuilder.append(this.upnpInfo);
    localStringBuilder.append(", upnpStatus=");
    localStringBuilder.append(this.upnpStatus);
    localStringBuilder.append(", upnpCommStatus=");
    localStringBuilder.append(this.upnpCommStatus);
    localStringBuilder.append(", pubIp=");
    localStringBuilder.append(this.pubIp);
    localStringBuilder.append(", upnpPsk=");
    localStringBuilder.append(this.upnpPsk);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static final class Companion
    implements UnwrapFromMultipleResponse<AlarmMultiInfo>
  {
    public AlarmMultiInfo fromMultipleResponse(MultipleResponse paramMultipleResponse)
    {
      j.e(paramMultipleResponse, "response");
      AlarmMultiInfo localAlarmMultiInfo = new AlarmMultiInfo(null, null, null, null, null, null, null);
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
            localAlarmMultiInfo.setDeviceInfo((BasicInfo)Model.typeCast(paramMultipleResponse, Module.DEVICE_INFO, Section.BASIC_INFO));
          } else if (j.a(localObject, Method.GET_LAST_ALARM_INFO.getValue())) {
            localAlarmMultiInfo.setLastAlarmInfo((LastAlarmInfo)Model.typeCast(paramMultipleResponse, Module.SYSTEM, Section.LAST_ALARM_INFO));
          } else if (j.a(localObject, Method.GET_UPNP_INFO.getValue())) {
            localAlarmMultiInfo.setUpnpInfo((UpnpInfo)Model.typeCast(paramMultipleResponse, Module.UPNPC, Section.UPNPC_INFO));
          } else if (j.a(localObject, Method.GET_UPNP_STATUS.getValue())) {
            localAlarmMultiInfo.setUpnpStatus(new UpnpStatus(paramMultipleResponse));
          } else if (j.a(localObject, Method.GET_UPNP_COMM_STATUS.getValue())) {
            localAlarmMultiInfo.setUpnpCommStatus((UpnpCommStatus)Model.typeCast(paramMultipleResponse, Module.UPNPC, Section.COMMUNICATE));
          } else if (j.a(localObject, Method.GET_PUB_IP.getValue())) {
            localAlarmMultiInfo.setPubIp((PubIp)Model.typeCast(paramMultipleResponse, Module.UPNPC, Section.PUB_IP));
          } else if ((j.a(localObject, Method.GET_UPNP_PSK.getValue())) && (paramMultipleResponse.getWrapperList() != null) && ((paramMultipleResponse.getWrapperList().isEmpty() ^ true)) && (((Wrapper)paramMultipleResponse.getWrapperList().get(0)).getData() != null)) {
            localAlarmMultiInfo.setUpnpPsk((UpnpPsk)i.b(String.valueOf(((Wrapper)paramMultipleResponse.getWrapperList().get(0)).getData()), UpnpPsk.class));
          }
        }
      }
      return localAlarmMultiInfo;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\AlarmMultiInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */