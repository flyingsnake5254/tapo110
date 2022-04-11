package com.tplink.libtpnetwork.enumerate;

import java.util.HashMap;
import java.util.Map;

public enum EnumNotificationMsgType
{
  private static Map<String, EnumNotificationMsgType> typeMap;
  private String name;
  
  static
  {
    EnumNotificationMsgType localEnumNotificationMsgType1 = new EnumNotificationMsgType("SHARE_LAUNCH", 0, "tapoShareLaunch");
    SHARE_LAUNCH = localEnumNotificationMsgType1;
    EnumNotificationMsgType localEnumNotificationMsgType2 = new EnumNotificationMsgType("NEW_FIRMWARE", 1, "tapoNewFirmware");
    NEW_FIRMWARE = localEnumNotificationMsgType2;
    EnumNotificationMsgType localEnumNotificationMsgType3 = new EnumNotificationMsgType("MOTION", 2, "Motion");
    MOTION = localEnumNotificationMsgType3;
    EnumNotificationMsgType localEnumNotificationMsgType4 = new EnumNotificationMsgType("AUDIO", 3, "Audio");
    AUDIO = localEnumNotificationMsgType4;
    EnumNotificationMsgType localEnumNotificationMsgType5 = new EnumNotificationMsgType("CRYING", 4, "BabyCry");
    CRYING = localEnumNotificationMsgType5;
    EnumNotificationMsgType localEnumNotificationMsgType6 = new EnumNotificationMsgType("FFS_NEW_DEVICE_FOUND", 5, "tapoFfsNewDeviceFound");
    FFS_NEW_DEVICE_FOUND = localEnumNotificationMsgType6;
    EnumNotificationMsgType localEnumNotificationMsgType7 = new EnumNotificationMsgType("DEVICE_ACTIVITY", 6, "smartTapoDeviceActivity");
    DEVICE_ACTIVITY = localEnumNotificationMsgType7;
    EnumNotificationMsgType localEnumNotificationMsgType8 = new EnumNotificationMsgType("PERSON_DETECTED", 7, "PersonDetected");
    PERSON_DETECTED = localEnumNotificationMsgType8;
    EnumNotificationMsgType localEnumNotificationMsgType9 = new EnumNotificationMsgType("PERSON_ENHANCED", 8, "PersonEnhanced");
    PERSON_ENHANCED = localEnumNotificationMsgType9;
    EnumNotificationMsgType localEnumNotificationMsgType10 = new EnumNotificationMsgType("SD_NEED_INITIALIZATION", 9, "tapoCameraSDNeedInitialization");
    SD_NEED_INITIALIZATION = localEnumNotificationMsgType10;
    EnumNotificationMsgType localEnumNotificationMsgType11 = new EnumNotificationMsgType("SD_INSUFFICIENT_STORAGE", 10, "tapoCameraSDInsufficientStorage");
    SD_INSUFFICIENT_STORAGE = localEnumNotificationMsgType11;
    EnumNotificationMsgType localEnumNotificationMsgType12 = new EnumNotificationMsgType("AREA_INTRUSION_DETECTION", 11, "tapoCameraAreaIntrusionDetection");
    AREA_INTRUSION_DETECTION = localEnumNotificationMsgType12;
    EnumNotificationMsgType localEnumNotificationMsgType13 = new EnumNotificationMsgType("LINE_CROSSING_DETECTION", 12, "tapoCameraLinecrossingDetection");
    LINE_CROSSING_DETECTION = localEnumNotificationMsgType13;
    EnumNotificationMsgType localEnumNotificationMsgType14 = new EnumNotificationMsgType("CAMERA_TAMPERING", 13, "tapoCameraCameraTampering");
    CAMERA_TAMPERING = localEnumNotificationMsgType14;
    EnumNotificationMsgType localEnumNotificationMsgType15 = new EnumNotificationMsgType("TAPO_CARE_TRIAL_EXPIRING_IN_3_DAYS", 14, "TAPO_CARE_TRIAL_EXPIRING_IN_3_DAYS");
    TAPO_CARE_TRIAL_EXPIRING_IN_3_DAYS = localEnumNotificationMsgType15;
    EnumNotificationMsgType localEnumNotificationMsgType16 = new EnumNotificationMsgType("TAPO_CARE_TRIAL_EXPIRED", 15, "TAPO_CARE_TRIAL_EXPIRED");
    TAPO_CARE_TRIAL_EXPIRED = localEnumNotificationMsgType16;
    EnumNotificationMsgType localEnumNotificationMsgType17 = new EnumNotificationMsgType("TAPO_CARE_SUBSCRIPTION_EXPIRING_IN_3_DAYS", 16, "TAPO_CARE_SUBSCRIPTION_EXPIRING_IN_3_DAYS");
    TAPO_CARE_SUBSCRIPTION_EXPIRING_IN_3_DAYS = localEnumNotificationMsgType17;
    EnumNotificationMsgType localEnumNotificationMsgType18 = new EnumNotificationMsgType("TAPO_CARE_SUBSCRIPTION_EXPIRED", 17, "TAPO_CARE_SUBSCRIPTION_EXPIRED");
    TAPO_CARE_SUBSCRIPTION_EXPIRED = localEnumNotificationMsgType18;
    EnumNotificationMsgType localEnumNotificationMsgType19 = new EnumNotificationMsgType("TAPO_CARE_SUBSCRIPTION_PAYMENT_FAILED", 18, "TAPO_CARE_SUBSCRIPTION_PAYMENT_FAILED");
    TAPO_CARE_SUBSCRIPTION_PAYMENT_FAILED = localEnumNotificationMsgType19;
    EnumNotificationMsgType localEnumNotificationMsgType20 = new EnumNotificationMsgType("TAPO_HUB_TRIGGERED", 19, "tapoHubTriggered");
    TAPO_HUB_TRIGGERED = localEnumNotificationMsgType20;
    EnumNotificationMsgType localEnumNotificationMsgType21 = new EnumNotificationMsgType("TAPO_CONTACT_SENSOR_TRIGGERED", 20, "tapoContactSensorTriggered");
    TAPO_CONTACT_SENSOR_TRIGGERED = localEnumNotificationMsgType21;
    EnumNotificationMsgType localEnumNotificationMsgType22 = new EnumNotificationMsgType("TAPO_MOTION_SENSOR_TRIGGERED", 21, "tapoMotionSensorTriggered");
    TAPO_MOTION_SENSOR_TRIGGERED = localEnumNotificationMsgType22;
    EnumNotificationMsgType localEnumNotificationMsgType23 = new EnumNotificationMsgType("TAPO_SMART_BUTTON_TRIGGERED", 22, "tapoSmartButtonTriggered");
    TAPO_SMART_BUTTON_TRIGGERED = localEnumNotificationMsgType23;
    EnumNotificationMsgType localEnumNotificationMsgType24 = new EnumNotificationMsgType("TAPO_SMART_SWITCH_TRIGGERED", 23, "tapoSmartSwitchTriggered");
    TAPO_SMART_SWITCH_TRIGGERED = localEnumNotificationMsgType24;
    EnumNotificationMsgType localEnumNotificationMsgType25 = new EnumNotificationMsgType("TAPO_THERMOSTAT_RADIATOR_VALVE", 24, "tapoThermostatRadiatorValve");
    TAPO_THERMOSTAT_RADIATOR_VALVE = localEnumNotificationMsgType25;
    EnumNotificationMsgType localEnumNotificationMsgType26 = new EnumNotificationMsgType("TAPO_DEVICE_LOW_BATTERY", 25, "tapoDeviceLowBattery");
    TAPO_DEVICE_LOW_BATTERY = localEnumNotificationMsgType26;
    EnumNotificationMsgType localEnumNotificationMsgType27 = new EnumNotificationMsgType("TAPO_SENSOR_FREQUENTLY_TRIGGERED", 26, "tapoSensorFrequentlyTriggered");
    TAPO_SENSOR_FREQUENTLY_TRIGGERED = localEnumNotificationMsgType27;
    Object localObject = new EnumNotificationMsgType("BRAND_PROMOTION", 27, "brandPromotion");
    BRAND_PROMOTION = (EnumNotificationMsgType)localObject;
    EnumNotificationMsgType localEnumNotificationMsgType28 = new EnumNotificationMsgType("MARKET_PROMOTION", 28, "marketPromotion");
    MARKET_PROMOTION = localEnumNotificationMsgType28;
    EnumNotificationMsgType localEnumNotificationMsgType29 = new EnumNotificationMsgType("ANNOUNCEMENT", 29, "announcement");
    ANNOUNCEMENT = localEnumNotificationMsgType29;
    EnumNotificationMsgType localEnumNotificationMsgType30 = new EnumNotificationMsgType("USER_RESEARCH", 30, "userResearch");
    USER_RESEARCH = localEnumNotificationMsgType30;
    EnumNotificationMsgType localEnumNotificationMsgType31 = new EnumNotificationMsgType("TAPO_DAILY_SUMMARY_CREATED", 31, "videosummaryGenerated");
    TAPO_DAILY_SUMMARY_CREATED = localEnumNotificationMsgType31;
    EnumNotificationMsgType localEnumNotificationMsgType32 = new EnumNotificationMsgType("TAPO_DAILY_SUMMARY_CAN_CREATE", 32, "videosummaryCanCreateFromClips");
    TAPO_DAILY_SUMMARY_CAN_CREATE = localEnumNotificationMsgType32;
    EnumNotificationMsgType localEnumNotificationMsgType33 = new EnumNotificationMsgType("OTHER", 33, "other");
    OTHER = localEnumNotificationMsgType33;
    $VALUES = new EnumNotificationMsgType[] { localEnumNotificationMsgType1, localEnumNotificationMsgType2, localEnumNotificationMsgType3, localEnumNotificationMsgType4, localEnumNotificationMsgType5, localEnumNotificationMsgType6, localEnumNotificationMsgType7, localEnumNotificationMsgType8, localEnumNotificationMsgType9, localEnumNotificationMsgType10, localEnumNotificationMsgType11, localEnumNotificationMsgType12, localEnumNotificationMsgType13, localEnumNotificationMsgType14, localEnumNotificationMsgType15, localEnumNotificationMsgType16, localEnumNotificationMsgType17, localEnumNotificationMsgType18, localEnumNotificationMsgType19, localEnumNotificationMsgType20, localEnumNotificationMsgType21, localEnumNotificationMsgType22, localEnumNotificationMsgType23, localEnumNotificationMsgType24, localEnumNotificationMsgType25, localEnumNotificationMsgType26, localEnumNotificationMsgType27, localObject, localEnumNotificationMsgType28, localEnumNotificationMsgType29, localEnumNotificationMsgType30, localEnumNotificationMsgType31, localEnumNotificationMsgType32, localEnumNotificationMsgType33 };
    typeMap = new HashMap();
    for (localEnumNotificationMsgType7 : values()) {
      typeMap.put(localEnumNotificationMsgType7.name, localEnumNotificationMsgType7);
    }
  }
  
  private EnumNotificationMsgType(String paramString)
  {
    this.name = paramString;
  }
  
  public static EnumNotificationMsgType fromString(String paramString)
  {
    return (EnumNotificationMsgType)typeMap.get(paramString);
  }
  
  public String getName()
  {
    return this.name;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\enumerate\EnumNotificationMsgType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */