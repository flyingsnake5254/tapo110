package com.tplink.libtpnetwork.cameranetwork.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.l;
import kotlin.jvm.internal.j;

public final class SettingComposite
{
  public static final Companion Companion = new Companion(null);
  private AccountInfo accountInfo;
  private CameraInfo cameraInfo;
  private HardDiskInfo hardDiskInfo;
  private HardDiskLoop hardDiskLoop;
  private ImageFlip imageFlip;
  private LedStatus ledStatus;
  private ServiceList needPayServiceList;
  private RebootInfo rebootInfo;
  private Timezone timezone;
  private VideoCapability videoCapability;
  private VideoQuality videoQuality;
  
  public SettingComposite(HardDiskLoop paramHardDiskLoop, HardDiskInfo paramHardDiskInfo, Timezone paramTimezone, AccountInfo paramAccountInfo, LedStatus paramLedStatus, ImageFlip paramImageFlip, RebootInfo paramRebootInfo, CameraInfo paramCameraInfo, VideoQuality paramVideoQuality, VideoCapability paramVideoCapability, ServiceList paramServiceList)
  {
    this.hardDiskLoop = paramHardDiskLoop;
    this.hardDiskInfo = paramHardDiskInfo;
    this.timezone = paramTimezone;
    this.accountInfo = paramAccountInfo;
    this.ledStatus = paramLedStatus;
    this.imageFlip = paramImageFlip;
    this.rebootInfo = paramRebootInfo;
    this.cameraInfo = paramCameraInfo;
    this.videoQuality = paramVideoQuality;
    this.videoCapability = paramVideoCapability;
    this.needPayServiceList = paramServiceList;
  }
  
  public final HardDiskLoop component1()
  {
    return this.hardDiskLoop;
  }
  
  public final VideoCapability component10()
  {
    return this.videoCapability;
  }
  
  public final ServiceList component11()
  {
    return this.needPayServiceList;
  }
  
  public final HardDiskInfo component2()
  {
    return this.hardDiskInfo;
  }
  
  public final Timezone component3()
  {
    return this.timezone;
  }
  
  public final AccountInfo component4()
  {
    return this.accountInfo;
  }
  
  public final LedStatus component5()
  {
    return this.ledStatus;
  }
  
  public final ImageFlip component6()
  {
    return this.imageFlip;
  }
  
  public final RebootInfo component7()
  {
    return this.rebootInfo;
  }
  
  public final CameraInfo component8()
  {
    return this.cameraInfo;
  }
  
  public final VideoQuality component9()
  {
    return this.videoQuality;
  }
  
  public final SettingComposite copy(HardDiskLoop paramHardDiskLoop, HardDiskInfo paramHardDiskInfo, Timezone paramTimezone, AccountInfo paramAccountInfo, LedStatus paramLedStatus, ImageFlip paramImageFlip, RebootInfo paramRebootInfo, CameraInfo paramCameraInfo, VideoQuality paramVideoQuality, VideoCapability paramVideoCapability, ServiceList paramServiceList)
  {
    return new SettingComposite(paramHardDiskLoop, paramHardDiskInfo, paramTimezone, paramAccountInfo, paramLedStatus, paramImageFlip, paramRebootInfo, paramCameraInfo, paramVideoQuality, paramVideoCapability, paramServiceList);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof SettingComposite))
      {
        paramObject = (SettingComposite)paramObject;
        if ((j.a(this.hardDiskLoop, ((SettingComposite)paramObject).hardDiskLoop)) && (j.a(this.hardDiskInfo, ((SettingComposite)paramObject).hardDiskInfo)) && (j.a(this.timezone, ((SettingComposite)paramObject).timezone)) && (j.a(this.accountInfo, ((SettingComposite)paramObject).accountInfo)) && (j.a(this.ledStatus, ((SettingComposite)paramObject).ledStatus)) && (j.a(this.imageFlip, ((SettingComposite)paramObject).imageFlip)) && (j.a(this.rebootInfo, ((SettingComposite)paramObject).rebootInfo)) && (j.a(this.cameraInfo, ((SettingComposite)paramObject).cameraInfo)) && (j.a(this.videoQuality, ((SettingComposite)paramObject).videoQuality)) && (j.a(this.videoCapability, ((SettingComposite)paramObject).videoCapability)) && (j.a(this.needPayServiceList, ((SettingComposite)paramObject).needPayServiceList))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final AccountInfo getAccountInfo()
  {
    return this.accountInfo;
  }
  
  public final CameraInfo getCameraInfo()
  {
    return this.cameraInfo;
  }
  
  public final HardDiskInfo getHardDiskInfo()
  {
    return this.hardDiskInfo;
  }
  
  public final HardDiskLoop getHardDiskLoop()
  {
    return this.hardDiskLoop;
  }
  
  public final ImageFlip getImageFlip()
  {
    return this.imageFlip;
  }
  
  public final LedStatus getLedStatus()
  {
    return this.ledStatus;
  }
  
  public final ServiceList getNeedPayServiceList()
  {
    return this.needPayServiceList;
  }
  
  public final RebootInfo getRebootInfo()
  {
    return this.rebootInfo;
  }
  
  public final Timezone getTimezone()
  {
    return this.timezone;
  }
  
  public final VideoCapability getVideoCapability()
  {
    return this.videoCapability;
  }
  
  public final VideoQuality getVideoQuality()
  {
    return this.videoQuality;
  }
  
  public int hashCode()
  {
    Object localObject = this.hardDiskLoop;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.hardDiskInfo;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.timezone;
    int m;
    if (localObject != null) {
      m = localObject.hashCode();
    } else {
      m = 0;
    }
    localObject = this.accountInfo;
    int n;
    if (localObject != null) {
      n = localObject.hashCode();
    } else {
      n = 0;
    }
    localObject = this.ledStatus;
    int i1;
    if (localObject != null) {
      i1 = localObject.hashCode();
    } else {
      i1 = 0;
    }
    localObject = this.imageFlip;
    int i2;
    if (localObject != null) {
      i2 = localObject.hashCode();
    } else {
      i2 = 0;
    }
    localObject = this.rebootInfo;
    int i3;
    if (localObject != null) {
      i3 = localObject.hashCode();
    } else {
      i3 = 0;
    }
    localObject = this.cameraInfo;
    int i4;
    if (localObject != null) {
      i4 = localObject.hashCode();
    } else {
      i4 = 0;
    }
    localObject = this.videoQuality;
    int i5;
    if (localObject != null) {
      i5 = localObject.hashCode();
    } else {
      i5 = 0;
    }
    localObject = this.videoCapability;
    int i6;
    if (localObject != null) {
      i6 = localObject.hashCode();
    } else {
      i6 = 0;
    }
    localObject = this.needPayServiceList;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return (((((((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i;
  }
  
  public final void setAccountInfo(AccountInfo paramAccountInfo)
  {
    this.accountInfo = paramAccountInfo;
  }
  
  public final void setCameraInfo(CameraInfo paramCameraInfo)
  {
    this.cameraInfo = paramCameraInfo;
  }
  
  public final void setHardDiskInfo(HardDiskInfo paramHardDiskInfo)
  {
    this.hardDiskInfo = paramHardDiskInfo;
  }
  
  public final void setHardDiskLoop(HardDiskLoop paramHardDiskLoop)
  {
    this.hardDiskLoop = paramHardDiskLoop;
  }
  
  public final void setImageFlip(ImageFlip paramImageFlip)
  {
    this.imageFlip = paramImageFlip;
  }
  
  public final void setLedStatus(LedStatus paramLedStatus)
  {
    this.ledStatus = paramLedStatus;
  }
  
  public final void setNeedPayServiceList(ServiceList paramServiceList)
  {
    this.needPayServiceList = paramServiceList;
  }
  
  public final void setRebootInfo(RebootInfo paramRebootInfo)
  {
    this.rebootInfo = paramRebootInfo;
  }
  
  public final void setTimezone(Timezone paramTimezone)
  {
    this.timezone = paramTimezone;
  }
  
  public final void setVideoCapability(VideoCapability paramVideoCapability)
  {
    this.videoCapability = paramVideoCapability;
  }
  
  public final void setVideoQuality(VideoQuality paramVideoQuality)
  {
    this.videoQuality = paramVideoQuality;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SettingComposite(hardDiskLoop=");
    localStringBuilder.append(this.hardDiskLoop);
    localStringBuilder.append(", hardDiskInfo=");
    localStringBuilder.append(this.hardDiskInfo);
    localStringBuilder.append(", timezone=");
    localStringBuilder.append(this.timezone);
    localStringBuilder.append(", accountInfo=");
    localStringBuilder.append(this.accountInfo);
    localStringBuilder.append(", ledStatus=");
    localStringBuilder.append(this.ledStatus);
    localStringBuilder.append(", imageFlip=");
    localStringBuilder.append(this.imageFlip);
    localStringBuilder.append(", rebootInfo=");
    localStringBuilder.append(this.rebootInfo);
    localStringBuilder.append(", cameraInfo=");
    localStringBuilder.append(this.cameraInfo);
    localStringBuilder.append(", videoQuality=");
    localStringBuilder.append(this.videoQuality);
    localStringBuilder.append(", videoCapability=");
    localStringBuilder.append(this.videoCapability);
    localStringBuilder.append(", needPayServiceList=");
    localStringBuilder.append(this.needPayServiceList);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static final class Companion
    implements UnwrapFromMultipleResponse<SettingComposite>
  {
    public SettingComposite fromMultipleResponse(MultipleResponse paramMultipleResponse)
    {
      j.e(paramMultipleResponse, "response");
      SettingComposite localSettingComposite = new SettingComposite(null, null, null, null, null, null, null, null, null, null, null);
      paramMultipleResponse = paramMultipleResponse.getResponses();
      if (paramMultipleResponse != null)
      {
        Iterator localIterator = paramMultipleResponse.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (Response)localIterator.next();
          paramMultipleResponse = (Wrappers)((Response)localObject).getResult();
          localObject = ((Response)localObject).getMethod();
          if (j.a(localObject, Method.GET_CIRCULAR_RECORDING_CONFIG.getValue()))
          {
            localSettingComposite.setHardDiskLoop((HardDiskLoop)Model.typeCast(paramMultipleResponse, Module.HARD_DISK_MANAGE, Section.HARD_DISK_LOOP));
          }
          else if (j.a(localObject, Method.GET_SD_CARD_STATUS.getValue()))
          {
            localObject = (List)Model.typeCast(paramMultipleResponse, Module.HARD_DISK_MANAGE, Section.HARD_DISK_INFO);
            if (localObject != null)
            {
              paramMultipleResponse = new ArrayList(l.l((Iterable)localObject, 10));
              localObject = ((Iterable)localObject).iterator();
              while (((Iterator)localObject).hasNext()) {
                paramMultipleResponse.add((HardDiskInfo)l.w(((Map)((Iterator)localObject).next()).values()));
              }
              paramMultipleResponse = (HardDiskInfo)l.x(paramMultipleResponse);
            }
            else
            {
              paramMultipleResponse = null;
            }
            localSettingComposite.setHardDiskInfo(paramMultipleResponse);
          }
          else if (j.a(localObject, Method.GET_TIMEZONE.getValue()))
          {
            localSettingComposite.setTimezone((Timezone)Model.typeCast(paramMultipleResponse, Module.SYSTEM, Section.BASIC));
          }
          else if (j.a(localObject, Method.GET_LED_STATUS.getValue()))
          {
            localSettingComposite.setLedStatus((LedStatus)Model.typeCast(paramMultipleResponse, Module.LED, Section.CONFIG));
          }
          else if (j.a(localObject, Method.GET_ROTATION_STATUS.getValue()))
          {
            localSettingComposite.setImageFlip((ImageFlip)Model.typeCast(paramMultipleResponse, Module.IMAGE, Section.IMAGE_SWITCH));
          }
          else if (j.a(localObject, Method.GET_REBOOT.getValue()))
          {
            localSettingComposite.setRebootInfo((RebootInfo)Model.typeCast(paramMultipleResponse, Module.TIMING_REBOOT, Section.REBOOT));
          }
          else if (j.a(localObject, Method.GET_DEVICE_INFO.getValue()))
          {
            localSettingComposite.setCameraInfo(new CameraInfo(paramMultipleResponse));
          }
          else if (j.a(localObject, Method.GET_VIDEO_QUALITIES.getValue()))
          {
            localSettingComposite.setVideoQuality((VideoQuality)Model.typeCast(paramMultipleResponse, Module.VIDEO, Section.VIDEO_MAIN));
          }
          else if (j.a(localObject, Method.GET_VIDEO_CAPABILITY.getValue()))
          {
            localSettingComposite.setVideoCapability((VideoCapability)Model.typeCast(paramMultipleResponse, Module.VIDEO_CAPABILITY, Section.VIDEO_MAIN));
          }
          else if (j.a(localObject, Method.GET_TAPO_CARE_SERVICE_LIST.getValue()))
          {
            localSettingComposite.setNeedPayServiceList((ServiceList)Model.typeCast(paramMultipleResponse, Module.TAPO_CARE, Section.SERVICE_LIST));
          }
        }
      }
      return localSettingComposite;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\SettingComposite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */