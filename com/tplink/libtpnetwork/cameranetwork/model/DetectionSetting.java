package com.tplink.libtpnetwork.cameranetwork.model;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;

public final class DetectionSetting
{
  public static final Companion Companion = new Companion(null);
  private AlarmInfo alarmInfo;
  private BabyCryingDetectionInfo babyCryDetectionInfo;
  private HumanRecognitionInfo humanRecognitionInfo;
  private MsgPushInfo msgPushInfo;
  private TargetTrackInfo targetTrackInfo;
  
  public DetectionSetting(AlarmInfo paramAlarmInfo, MsgPushInfo paramMsgPushInfo, HumanRecognitionInfo paramHumanRecognitionInfo, BabyCryingDetectionInfo paramBabyCryingDetectionInfo, TargetTrackInfo paramTargetTrackInfo)
  {
    this.alarmInfo = paramAlarmInfo;
    this.msgPushInfo = paramMsgPushInfo;
    this.humanRecognitionInfo = paramHumanRecognitionInfo;
    this.babyCryDetectionInfo = paramBabyCryingDetectionInfo;
    this.targetTrackInfo = paramTargetTrackInfo;
  }
  
  public final AlarmInfo component1()
  {
    return this.alarmInfo;
  }
  
  public final MsgPushInfo component2()
  {
    return this.msgPushInfo;
  }
  
  public final HumanRecognitionInfo component3()
  {
    return this.humanRecognitionInfo;
  }
  
  public final BabyCryingDetectionInfo component4()
  {
    return this.babyCryDetectionInfo;
  }
  
  public final TargetTrackInfo component5()
  {
    return this.targetTrackInfo;
  }
  
  public final DetectionSetting copy(AlarmInfo paramAlarmInfo, MsgPushInfo paramMsgPushInfo, HumanRecognitionInfo paramHumanRecognitionInfo, BabyCryingDetectionInfo paramBabyCryingDetectionInfo, TargetTrackInfo paramTargetTrackInfo)
  {
    return new DetectionSetting(paramAlarmInfo, paramMsgPushInfo, paramHumanRecognitionInfo, paramBabyCryingDetectionInfo, paramTargetTrackInfo);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof DetectionSetting))
      {
        paramObject = (DetectionSetting)paramObject;
        if ((j.a(this.alarmInfo, ((DetectionSetting)paramObject).alarmInfo)) && (j.a(this.msgPushInfo, ((DetectionSetting)paramObject).msgPushInfo)) && (j.a(this.humanRecognitionInfo, ((DetectionSetting)paramObject).humanRecognitionInfo)) && (j.a(this.babyCryDetectionInfo, ((DetectionSetting)paramObject).babyCryDetectionInfo)) && (j.a(this.targetTrackInfo, ((DetectionSetting)paramObject).targetTrackInfo))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final AlarmInfo getAlarmInfo()
  {
    return this.alarmInfo;
  }
  
  public final BabyCryingDetectionInfo getBabyCryDetectionInfo()
  {
    return this.babyCryDetectionInfo;
  }
  
  public final HumanRecognitionInfo getHumanRecognitionInfo()
  {
    return this.humanRecognitionInfo;
  }
  
  public final MsgPushInfo getMsgPushInfo()
  {
    return this.msgPushInfo;
  }
  
  public final TargetTrackInfo getTargetTrackInfo()
  {
    return this.targetTrackInfo;
  }
  
  public int hashCode()
  {
    Object localObject = this.alarmInfo;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.msgPushInfo;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.humanRecognitionInfo;
    int m;
    if (localObject != null) {
      m = localObject.hashCode();
    } else {
      m = 0;
    }
    localObject = this.babyCryDetectionInfo;
    int n;
    if (localObject != null) {
      n = localObject.hashCode();
    } else {
      n = 0;
    }
    localObject = this.targetTrackInfo;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return (((j * 31 + k) * 31 + m) * 31 + n) * 31 + i;
  }
  
  public final void setAlarmInfo(AlarmInfo paramAlarmInfo)
  {
    this.alarmInfo = paramAlarmInfo;
  }
  
  public final void setBabyCryDetectionInfo(BabyCryingDetectionInfo paramBabyCryingDetectionInfo)
  {
    this.babyCryDetectionInfo = paramBabyCryingDetectionInfo;
  }
  
  public final void setHumanRecognitionInfo(HumanRecognitionInfo paramHumanRecognitionInfo)
  {
    this.humanRecognitionInfo = paramHumanRecognitionInfo;
  }
  
  public final void setMsgPushInfo(MsgPushInfo paramMsgPushInfo)
  {
    this.msgPushInfo = paramMsgPushInfo;
  }
  
  public final void setTargetTrackInfo(TargetTrackInfo paramTargetTrackInfo)
  {
    this.targetTrackInfo = paramTargetTrackInfo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DetectionSetting(alarmInfo=");
    localStringBuilder.append(this.alarmInfo);
    localStringBuilder.append(", msgPushInfo=");
    localStringBuilder.append(this.msgPushInfo);
    localStringBuilder.append(", humanRecognitionInfo=");
    localStringBuilder.append(this.humanRecognitionInfo);
    localStringBuilder.append(", babyCryDetectionInfo=");
    localStringBuilder.append(this.babyCryDetectionInfo);
    localStringBuilder.append(", targetTrackInfo=");
    localStringBuilder.append(this.targetTrackInfo);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static final class Companion
    implements UnwrapFromMultipleResponse<DetectionSetting>
  {
    public DetectionSetting fromMultipleResponse(MultipleResponse paramMultipleResponse)
    {
      j.e(paramMultipleResponse, "response");
      DetectionSetting localDetectionSetting = new DetectionSetting(null, null, null, null, null);
      paramMultipleResponse = paramMultipleResponse.getResponses();
      if (paramMultipleResponse != null)
      {
        paramMultipleResponse = paramMultipleResponse.iterator();
        while (paramMultipleResponse.hasNext())
        {
          Object localObject = (Response)paramMultipleResponse.next();
          Wrappers localWrappers = (Wrappers)((Response)localObject).getResult();
          localObject = ((Response)localObject).getMethod();
          if (j.a(localObject, Method.GET_ALERT_CONFIG.getValue())) {
            localDetectionSetting.setAlarmInfo((AlarmInfo)Model.typeCast(localWrappers, Module.MSG_ALARM, Section.MSG_ALARM_INFO));
          } else if (j.a(localObject, Method.GET_MSG_PUSH_CONFIG.getValue())) {
            localDetectionSetting.setMsgPushInfo((MsgPushInfo)Model.typeCast(localWrappers, Module.MSG_PUSH, Section.MSG_PUSH_INFO));
          } else if (j.a(localObject, Method.GET_PERSON_DETECTION_CONFIG.getValue())) {
            localDetectionSetting.setHumanRecognitionInfo((HumanRecognitionInfo)Model.typeCast(localWrappers, Module.PEOPLE_DETECTION, Section.DETECTION));
          } else if (j.a(localObject, Method.GET_BCD_CONFIG.getValue())) {
            localDetectionSetting.setBabyCryDetectionInfo((BabyCryingDetectionInfo)Model.typeCast(localWrappers, Module.SOUND_DETECTION, Section.BABY_CRYING_DETECTION));
          } else if (j.a(localObject, Method.GET_TARGET_TRACK_CONFIG.getValue())) {
            localDetectionSetting.setTargetTrackInfo((TargetTrackInfo)Model.typeCast(localWrappers, Module.TARGET_TRACK, Section.TARGET_TRACK_INFO));
          }
        }
      }
      return localDetectionSetting;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\DetectionSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */