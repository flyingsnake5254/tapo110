package com.tplink.libtpnetwork.cameranetwork.model;

import com.tplink.libtpnetwork.Utils.i;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;

public final class UpnpMultiInfo
{
  public static final Companion Companion = new Companion(null);
  private PubIp pubIp;
  private UpnpCommStatus upnpCommStatus;
  private UpnpInfo upnpInfo;
  private UpnpPsk upnpPsk;
  private UpnpStatus upnpStatus;
  
  public UpnpMultiInfo(UpnpInfo paramUpnpInfo, UpnpStatus paramUpnpStatus, UpnpCommStatus paramUpnpCommStatus, PubIp paramPubIp, UpnpPsk paramUpnpPsk)
  {
    this.upnpInfo = paramUpnpInfo;
    this.upnpStatus = paramUpnpStatus;
    this.upnpCommStatus = paramUpnpCommStatus;
    this.pubIp = paramPubIp;
    this.upnpPsk = paramUpnpPsk;
  }
  
  public final UpnpInfo component1()
  {
    return this.upnpInfo;
  }
  
  public final UpnpStatus component2()
  {
    return this.upnpStatus;
  }
  
  public final UpnpCommStatus component3()
  {
    return this.upnpCommStatus;
  }
  
  public final PubIp component4()
  {
    return this.pubIp;
  }
  
  public final UpnpPsk component5()
  {
    return this.upnpPsk;
  }
  
  public final UpnpMultiInfo copy(UpnpInfo paramUpnpInfo, UpnpStatus paramUpnpStatus, UpnpCommStatus paramUpnpCommStatus, PubIp paramPubIp, UpnpPsk paramUpnpPsk)
  {
    return new UpnpMultiInfo(paramUpnpInfo, paramUpnpStatus, paramUpnpCommStatus, paramPubIp, paramUpnpPsk);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof UpnpMultiInfo))
      {
        paramObject = (UpnpMultiInfo)paramObject;
        if ((j.a(this.upnpInfo, ((UpnpMultiInfo)paramObject).upnpInfo)) && (j.a(this.upnpStatus, ((UpnpMultiInfo)paramObject).upnpStatus)) && (j.a(this.upnpCommStatus, ((UpnpMultiInfo)paramObject).upnpCommStatus)) && (j.a(this.pubIp, ((UpnpMultiInfo)paramObject).pubIp)) && (j.a(this.upnpPsk, ((UpnpMultiInfo)paramObject).upnpPsk))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
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
    Object localObject = this.upnpInfo;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.upnpStatus;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.upnpCommStatus;
    int m;
    if (localObject != null) {
      m = localObject.hashCode();
    } else {
      m = 0;
    }
    localObject = this.pubIp;
    int n;
    if (localObject != null) {
      n = localObject.hashCode();
    } else {
      n = 0;
    }
    localObject = this.upnpPsk;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return (((j * 31 + k) * 31 + m) * 31 + n) * 31 + i;
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
    localStringBuilder.append("UpnpMultiInfo(upnpInfo=");
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
    implements UnwrapFromMultipleResponse<UpnpMultiInfo>
  {
    public UpnpMultiInfo fromMultipleResponse(MultipleResponse paramMultipleResponse)
    {
      j.e(paramMultipleResponse, "response");
      UpnpMultiInfo localUpnpMultiInfo = new UpnpMultiInfo(null, null, null, null, null);
      paramMultipleResponse = paramMultipleResponse.getResponses();
      if (paramMultipleResponse != null)
      {
        paramMultipleResponse = paramMultipleResponse.iterator();
        while (paramMultipleResponse.hasNext())
        {
          Object localObject = (Response)paramMultipleResponse.next();
          Wrappers localWrappers = (Wrappers)((Response)localObject).getResult();
          localObject = ((Response)localObject).getMethod();
          if (j.a(localObject, Method.GET_UPNP_INFO.getValue())) {
            localUpnpMultiInfo.setUpnpInfo((UpnpInfo)Model.typeCast(localWrappers, Module.UPNPC, Section.UPNPC_INFO));
          } else if (j.a(localObject, Method.GET_UPNP_STATUS.getValue())) {
            localUpnpMultiInfo.setUpnpStatus(new UpnpStatus(localWrappers));
          } else if (j.a(localObject, Method.GET_UPNP_COMM_STATUS.getValue())) {
            localUpnpMultiInfo.setUpnpCommStatus((UpnpCommStatus)Model.typeCast(localWrappers, Module.UPNPC, Section.COMMUNICATE));
          } else if (j.a(localObject, Method.GET_PUB_IP.getValue())) {
            localUpnpMultiInfo.setPubIp((PubIp)Model.typeCast(localWrappers, Module.UPNPC, Section.PUB_IP));
          } else if ((j.a(localObject, Method.GET_UPNP_PSK.getValue())) && (localWrappers.getWrapperList() != null) && ((localWrappers.getWrapperList().isEmpty() ^ true)) && (((Wrapper)localWrappers.getWrapperList().get(0)).getData() != null)) {
            localUpnpMultiInfo.setUpnpPsk((UpnpPsk)i.b(String.valueOf(((Wrapper)localWrappers.getWrapperList().get(0)).getData()), UpnpPsk.class));
          }
        }
      }
      return localUpnpMultiInfo;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\UpnpMultiInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */