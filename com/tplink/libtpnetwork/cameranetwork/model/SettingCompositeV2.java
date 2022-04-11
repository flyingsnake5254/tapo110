package com.tplink.libtpnetwork.cameranetwork.model;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;

public final class SettingCompositeV2
{
  public static final Companion Companion = new Companion(null);
  private AlarmInfo alarmInfo;
  private BabyCryingDetectionInfo babyCryDetectionInfo;
  private HumanRecognitionInfo humanRecognitionInfo;
  private IntrusionDetectionInfo intrusionDetectionInfo;
  private LensMaskInfo lensMaskInfo;
  private LineCrossingDetectionInfo lineCrossingDetectionInfo;
  private MotionDetectionInfo motionDetectionInfo;
  private NightVisionCapability nightVisionCapability;
  private RecordPlanInfo recordPlanInfo;
  private TamperDetectConfig tamperDetectConfig;
  
  public SettingCompositeV2(LensMaskInfo paramLensMaskInfo, MotionDetectionInfo paramMotionDetectionInfo, AlarmInfo paramAlarmInfo, LineCrossingDetectionInfo paramLineCrossingDetectionInfo, IntrusionDetectionInfo paramIntrusionDetectionInfo, TamperDetectConfig paramTamperDetectConfig, RecordPlanInfo paramRecordPlanInfo, NightVisionCapability paramNightVisionCapability, BabyCryingDetectionInfo paramBabyCryingDetectionInfo, HumanRecognitionInfo paramHumanRecognitionInfo)
  {
    this.lensMaskInfo = paramLensMaskInfo;
    this.motionDetectionInfo = paramMotionDetectionInfo;
    this.alarmInfo = paramAlarmInfo;
    this.lineCrossingDetectionInfo = paramLineCrossingDetectionInfo;
    this.intrusionDetectionInfo = paramIntrusionDetectionInfo;
    this.tamperDetectConfig = paramTamperDetectConfig;
    this.recordPlanInfo = paramRecordPlanInfo;
    this.nightVisionCapability = paramNightVisionCapability;
    this.babyCryDetectionInfo = paramBabyCryingDetectionInfo;
    this.humanRecognitionInfo = paramHumanRecognitionInfo;
  }
  
  public final LensMaskInfo component1()
  {
    return this.lensMaskInfo;
  }
  
  public final HumanRecognitionInfo component10()
  {
    return this.humanRecognitionInfo;
  }
  
  public final MotionDetectionInfo component2()
  {
    return this.motionDetectionInfo;
  }
  
  public final AlarmInfo component3()
  {
    return this.alarmInfo;
  }
  
  public final LineCrossingDetectionInfo component4()
  {
    return this.lineCrossingDetectionInfo;
  }
  
  public final IntrusionDetectionInfo component5()
  {
    return this.intrusionDetectionInfo;
  }
  
  public final TamperDetectConfig component6()
  {
    return this.tamperDetectConfig;
  }
  
  public final RecordPlanInfo component7()
  {
    return this.recordPlanInfo;
  }
  
  public final NightVisionCapability component8()
  {
    return this.nightVisionCapability;
  }
  
  public final BabyCryingDetectionInfo component9()
  {
    return this.babyCryDetectionInfo;
  }
  
  public final SettingCompositeV2 copy(LensMaskInfo paramLensMaskInfo, MotionDetectionInfo paramMotionDetectionInfo, AlarmInfo paramAlarmInfo, LineCrossingDetectionInfo paramLineCrossingDetectionInfo, IntrusionDetectionInfo paramIntrusionDetectionInfo, TamperDetectConfig paramTamperDetectConfig, RecordPlanInfo paramRecordPlanInfo, NightVisionCapability paramNightVisionCapability, BabyCryingDetectionInfo paramBabyCryingDetectionInfo, HumanRecognitionInfo paramHumanRecognitionInfo)
  {
    return new SettingCompositeV2(paramLensMaskInfo, paramMotionDetectionInfo, paramAlarmInfo, paramLineCrossingDetectionInfo, paramIntrusionDetectionInfo, paramTamperDetectConfig, paramRecordPlanInfo, paramNightVisionCapability, paramBabyCryingDetectionInfo, paramHumanRecognitionInfo);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof SettingCompositeV2))
      {
        paramObject = (SettingCompositeV2)paramObject;
        if ((j.a(this.lensMaskInfo, ((SettingCompositeV2)paramObject).lensMaskInfo)) && (j.a(this.motionDetectionInfo, ((SettingCompositeV2)paramObject).motionDetectionInfo)) && (j.a(this.alarmInfo, ((SettingCompositeV2)paramObject).alarmInfo)) && (j.a(this.lineCrossingDetectionInfo, ((SettingCompositeV2)paramObject).lineCrossingDetectionInfo)) && (j.a(this.intrusionDetectionInfo, ((SettingCompositeV2)paramObject).intrusionDetectionInfo)) && (j.a(this.tamperDetectConfig, ((SettingCompositeV2)paramObject).tamperDetectConfig)) && (j.a(this.recordPlanInfo, ((SettingCompositeV2)paramObject).recordPlanInfo)) && (j.a(this.nightVisionCapability, ((SettingCompositeV2)paramObject).nightVisionCapability)) && (j.a(this.babyCryDetectionInfo, ((SettingCompositeV2)paramObject).babyCryDetectionInfo)) && (j.a(this.humanRecognitionInfo, ((SettingCompositeV2)paramObject).humanRecognitionInfo))) {}
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
  
  public final IntrusionDetectionInfo getIntrusionDetectionInfo()
  {
    return this.intrusionDetectionInfo;
  }
  
  public final LensMaskInfo getLensMaskInfo()
  {
    return this.lensMaskInfo;
  }
  
  public final LineCrossingDetectionInfo getLineCrossingDetectionInfo()
  {
    return this.lineCrossingDetectionInfo;
  }
  
  public final MotionDetectionInfo getMotionDetectionInfo()
  {
    return this.motionDetectionInfo;
  }
  
  public final NightVisionCapability getNightVisionCapability()
  {
    return this.nightVisionCapability;
  }
  
  public final RecordPlanInfo getRecordPlanInfo()
  {
    return this.recordPlanInfo;
  }
  
  public final TamperDetectConfig getTamperDetectConfig()
  {
    return this.tamperDetectConfig;
  }
  
  public int hashCode()
  {
    Object localObject = this.lensMaskInfo;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.motionDetectionInfo;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.alarmInfo;
    int m;
    if (localObject != null) {
      m = localObject.hashCode();
    } else {
      m = 0;
    }
    localObject = this.lineCrossingDetectionInfo;
    int n;
    if (localObject != null) {
      n = localObject.hashCode();
    } else {
      n = 0;
    }
    localObject = this.intrusionDetectionInfo;
    int i1;
    if (localObject != null) {
      i1 = localObject.hashCode();
    } else {
      i1 = 0;
    }
    localObject = this.tamperDetectConfig;
    int i2;
    if (localObject != null) {
      i2 = localObject.hashCode();
    } else {
      i2 = 0;
    }
    localObject = this.recordPlanInfo;
    int i3;
    if (localObject != null) {
      i3 = localObject.hashCode();
    } else {
      i3 = 0;
    }
    localObject = this.nightVisionCapability;
    int i4;
    if (localObject != null) {
      i4 = localObject.hashCode();
    } else {
      i4 = 0;
    }
    localObject = this.babyCryDetectionInfo;
    int i5;
    if (localObject != null) {
      i5 = localObject.hashCode();
    } else {
      i5 = 0;
    }
    localObject = this.humanRecognitionInfo;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return ((((((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i;
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
  
  public final void setIntrusionDetectionInfo(IntrusionDetectionInfo paramIntrusionDetectionInfo)
  {
    this.intrusionDetectionInfo = paramIntrusionDetectionInfo;
  }
  
  public final void setLensMaskInfo(LensMaskInfo paramLensMaskInfo)
  {
    this.lensMaskInfo = paramLensMaskInfo;
  }
  
  public final void setLineCrossingDetectionInfo(LineCrossingDetectionInfo paramLineCrossingDetectionInfo)
  {
    this.lineCrossingDetectionInfo = paramLineCrossingDetectionInfo;
  }
  
  public final void setMotionDetectionInfo(MotionDetectionInfo paramMotionDetectionInfo)
  {
    this.motionDetectionInfo = paramMotionDetectionInfo;
  }
  
  public final void setNightVisionCapability(NightVisionCapability paramNightVisionCapability)
  {
    this.nightVisionCapability = paramNightVisionCapability;
  }
  
  public final void setRecordPlanInfo(RecordPlanInfo paramRecordPlanInfo)
  {
    this.recordPlanInfo = paramRecordPlanInfo;
  }
  
  public final void setTamperDetectConfig(TamperDetectConfig paramTamperDetectConfig)
  {
    this.tamperDetectConfig = paramTamperDetectConfig;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SettingCompositeV2(lensMaskInfo=");
    localStringBuilder.append(this.lensMaskInfo);
    localStringBuilder.append(", motionDetectionInfo=");
    localStringBuilder.append(this.motionDetectionInfo);
    localStringBuilder.append(", alarmInfo=");
    localStringBuilder.append(this.alarmInfo);
    localStringBuilder.append(", lineCrossingDetectionInfo=");
    localStringBuilder.append(this.lineCrossingDetectionInfo);
    localStringBuilder.append(", intrusionDetectionInfo=");
    localStringBuilder.append(this.intrusionDetectionInfo);
    localStringBuilder.append(", tamperDetectConfig=");
    localStringBuilder.append(this.tamperDetectConfig);
    localStringBuilder.append(", recordPlanInfo=");
    localStringBuilder.append(this.recordPlanInfo);
    localStringBuilder.append(", nightVisionCapability=");
    localStringBuilder.append(this.nightVisionCapability);
    localStringBuilder.append(", babyCryDetectionInfo=");
    localStringBuilder.append(this.babyCryDetectionInfo);
    localStringBuilder.append(", humanRecognitionInfo=");
    localStringBuilder.append(this.humanRecognitionInfo);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static final class Companion
    implements UnwrapFromMultipleResponse<SettingCompositeV2>
  {
    public SettingCompositeV2 fromMultipleResponse(MultipleResponse paramMultipleResponse)
    {
      j.e(paramMultipleResponse, "response");
      SettingCompositeV2 localSettingCompositeV2 = new SettingCompositeV2(null, null, null, null, null, null, null, null, null, null);
      paramMultipleResponse = paramMultipleResponse.getResponses();
      if (paramMultipleResponse != null)
      {
        paramMultipleResponse = paramMultipleResponse.iterator();
        while (paramMultipleResponse.hasNext())
        {
          Object localObject = (Response)paramMultipleResponse.next();
          Wrappers localWrappers = (Wrappers)((Response)localObject).getResult();
          localObject = ((Response)localObject).getMethod();
          if (j.a(localObject, Method.GET_LENS_MASK_CONFIG.getValue())) {
            localSettingCompositeV2.setLensMaskInfo((LensMaskInfo)Model.typeCast(localWrappers, Module.LENS_MASK, Section.LENS_MASK_INFO));
          } else if (j.a(localObject, Method.GET_DETECTION_CONFIG.getValue())) {
            localSettingCompositeV2.setMotionDetectionInfo(new MotionDetectionInfo(localWrappers));
          } else if (j.a(localObject, Method.GET_ALERT_CONFIG.getValue())) {
            localSettingCompositeV2.setAlarmInfo((AlarmInfo)Model.typeCast(localWrappers, Module.MSG_ALARM, Section.MSG_ALARM_INFO));
          } else if (j.a(localObject, Method.GET_LINE_CROSSING_DETECTION_CONFIG.getValue())) {
            localSettingCompositeV2.setLineCrossingDetectionInfo(new LineCrossingDetectionInfo(localWrappers));
          } else if (j.a(localObject, Method.GET_INTRUSION_DETECTION_CONFIG.getValue())) {
            localSettingCompositeV2.setIntrusionDetectionInfo(new IntrusionDetectionInfo(localWrappers));
          } else if (j.a(localObject, Method.GET_TAMPER_DETECTION_CONFIG.getValue())) {
            localSettingCompositeV2.setTamperDetectConfig((TamperDetectConfig)Model.typeCast(localWrappers, Module.TAMPER_DETECTION, Section.TAMPER_DET));
          } else if (j.a(localObject, Method.GET_RECORD_PLAN.getValue())) {
            localSettingCompositeV2.setRecordPlanInfo((RecordPlanInfo)Model.typeCast(localWrappers, Module.RECORD_PLAN, Section.CHN1_CHANNEL));
          } else if (j.a(localObject, Method.GET_NIGHT_VISION_CAPABILITY.getValue())) {
            localSettingCompositeV2.setNightVisionCapability((NightVisionCapability)Model.typeCast(localWrappers, Module.IMAGE_CAPABILITY, Section.SUPPLEMENT_LAMP));
          } else if (j.a(localObject, Method.GET_BCD_CONFIG.getValue())) {
            localSettingCompositeV2.setBabyCryDetectionInfo((BabyCryingDetectionInfo)Model.typeCast(localWrappers, Module.SOUND_DETECTION, Section.BABY_CRYING_DETECTION));
          } else if (j.a(localObject, Method.GET_PERSON_DETECTION_CONFIG.getValue())) {
            localSettingCompositeV2.setHumanRecognitionInfo((HumanRecognitionInfo)Model.typeCast(localWrappers, Module.PEOPLE_DETECTION, Section.DETECTION));
          }
        }
      }
      return localSettingCompositeV2;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\SettingCompositeV2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */