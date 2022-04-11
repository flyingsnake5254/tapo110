package com.tplink.libtpnetwork.enumerate;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

public enum EnumMsgSubscribeType
{
  private static Map<String, EnumMsgSubscribeType> stringToEnum;
  private String name;
  private int value;
  
  static
  {
    EnumMsgSubscribeType localEnumMsgSubscribeType1 = new EnumMsgSubscribeType("ALL", 0, 1, "all");
    ALL = localEnumMsgSubscribeType1;
    EnumMsgSubscribeType localEnumMsgSubscribeType2 = new EnumMsgSubscribeType("NEW_FIRMWARE", 1, 1, "tapoNewFirmware");
    NEW_FIRMWARE = localEnumMsgSubscribeType2;
    EnumMsgSubscribeType localEnumMsgSubscribeType3 = new EnumMsgSubscribeType("DEVICE_SHARE", 2, 2, "tapoShareLaunch");
    DEVICE_SHARE = localEnumMsgSubscribeType3;
    EnumMsgSubscribeType localEnumMsgSubscribeType4 = new EnumMsgSubscribeType("CAMERA_MOTION", 3, 3, "Motion");
    CAMERA_MOTION = localEnumMsgSubscribeType4;
    EnumMsgSubscribeType localEnumMsgSubscribeType5 = new EnumMsgSubscribeType("CAMERA_AUDIO", 4, 4, "Audio");
    CAMERA_AUDIO = localEnumMsgSubscribeType5;
    EnumMsgSubscribeType localEnumMsgSubscribeType6 = new EnumMsgSubscribeType("CAMERA_CRYING", 5, 5, "BabyCry");
    CAMERA_CRYING = localEnumMsgSubscribeType6;
    EnumMsgSubscribeType localEnumMsgSubscribeType7 = new EnumMsgSubscribeType("IN_APP_MARKETING", 6, 6, "in_app_marketing");
    IN_APP_MARKETING = localEnumMsgSubscribeType7;
    EnumMsgSubscribeType localEnumMsgSubscribeType8 = new EnumMsgSubscribeType("FFS_NEW_DEVICE_FOUND", 7, 7, "tapoFfsNewDeviceFound");
    FFS_NEW_DEVICE_FOUND = localEnumMsgSubscribeType8;
    EnumMsgSubscribeType localEnumMsgSubscribeType9 = new EnumMsgSubscribeType("DEVICE_ACTIVITY", 8, 8, "smartTapoDeviceActivity");
    DEVICE_ACTIVITY = localEnumMsgSubscribeType9;
    EnumMsgSubscribeType localEnumMsgSubscribeType10 = new EnumMsgSubscribeType("CAMERA_SD_NEED_INITIALIZATION", 9, 9, "tapoCameraSDNeedInitialization");
    CAMERA_SD_NEED_INITIALIZATION = localEnumMsgSubscribeType10;
    EnumMsgSubscribeType localEnumMsgSubscribeType11 = new EnumMsgSubscribeType("CAMERA_SD_INSUFFICIENT_STORAGE", 10, 10, "tapoCameraSDInsufficientStorage");
    CAMERA_SD_INSUFFICIENT_STORAGE = localEnumMsgSubscribeType11;
    EnumMsgSubscribeType localEnumMsgSubscribeType12 = new EnumMsgSubscribeType("CAMERA_AREA_INTRUSION_DETECTION", 11, 11, "tapoCameraAreaIntrusionDetection");
    CAMERA_AREA_INTRUSION_DETECTION = localEnumMsgSubscribeType12;
    EnumMsgSubscribeType localEnumMsgSubscribeType13 = new EnumMsgSubscribeType("CAMERA_LINE_CROSSING_DETECTION", 12, 12, "tapoCameraLinecrossingDetection");
    CAMERA_LINE_CROSSING_DETECTION = localEnumMsgSubscribeType13;
    EnumMsgSubscribeType localEnumMsgSubscribeType14 = new EnumMsgSubscribeType("CAMERA_TAMPERING", 13, 13, "tapoCameraCameraTampering");
    CAMERA_TAMPERING = localEnumMsgSubscribeType14;
    EnumMsgSubscribeType localEnumMsgSubscribeType15 = new EnumMsgSubscribeType("CAMERA_PERSON_DETECTED", 14, 11, "PersonDetected");
    CAMERA_PERSON_DETECTED = localEnumMsgSubscribeType15;
    Object localObject = new EnumMsgSubscribeType("CAMERA_PERSON_ENHANCED", 15, 12, "PersonEnhanced");
    CAMERA_PERSON_ENHANCED = (EnumMsgSubscribeType)localObject;
    EnumMsgSubscribeType localEnumMsgSubscribeType16 = new EnumMsgSubscribeType("TAPO_CARE_TRIAL_EXPIRING_IN_3_DAYS", 16, 13, "TAPO_CARE_TRIAL_EXPIRING_IN_3_DAYS");
    TAPO_CARE_TRIAL_EXPIRING_IN_3_DAYS = localEnumMsgSubscribeType16;
    EnumMsgSubscribeType localEnumMsgSubscribeType17 = new EnumMsgSubscribeType("TAPO_CARE_TRIAL_EXPIRED", 17, 14, "TAPO_CARE_TRIAL_EXPIRED");
    TAPO_CARE_TRIAL_EXPIRED = localEnumMsgSubscribeType17;
    EnumMsgSubscribeType localEnumMsgSubscribeType18 = new EnumMsgSubscribeType("TAPO_CARE_SUBSCRIPTION_EXPIRING_IN_3_DAYS", 18, 15, "TAPO_CARE_SUBSCRIPTION_EXPIRING_IN_3_DAYS");
    TAPO_CARE_SUBSCRIPTION_EXPIRING_IN_3_DAYS = localEnumMsgSubscribeType18;
    EnumMsgSubscribeType localEnumMsgSubscribeType19 = new EnumMsgSubscribeType("TAPO_CARE_SUBSCRIPTION_EXPIRED", 19, 16, "TAPO_CARE_SUBSCRIPTION_EXPIRED");
    TAPO_CARE_SUBSCRIPTION_EXPIRED = localEnumMsgSubscribeType19;
    EnumMsgSubscribeType localEnumMsgSubscribeType20 = new EnumMsgSubscribeType("TAPO_CARE_SUBSCRIPTION_PAYMENT_FAILED", 20, 17, "TAPO_CARE_SUBSCRIPTION_PAYMENT_FAILED");
    TAPO_CARE_SUBSCRIPTION_PAYMENT_FAILED = localEnumMsgSubscribeType20;
    EnumMsgSubscribeType localEnumMsgSubscribeType21 = new EnumMsgSubscribeType("TAPO_CARE_DOWNGRADE_TO_HANDLE", 21, 18, "tapoCareSubscriptionDowngradePreference");
    TAPO_CARE_DOWNGRADE_TO_HANDLE = localEnumMsgSubscribeType21;
    EnumMsgSubscribeType localEnumMsgSubscribeType22 = new EnumMsgSubscribeType("TAPO_CARE_DOWNGRADE_HANDLED", 22, 19, "tapoCareSubscriptionDowngradeActivated");
    TAPO_CARE_DOWNGRADE_HANDLED = localEnumMsgSubscribeType22;
    EnumMsgSubscribeType localEnumMsgSubscribeType23 = new EnumMsgSubscribeType("IAC_PUSH_TASK_ID", 23, 20, "pushWithTaskId");
    IAC_PUSH_TASK_ID = localEnumMsgSubscribeType23;
    EnumMsgSubscribeType localEnumMsgSubscribeType24 = new EnumMsgSubscribeType("TAPO_HUB_TRIGGERED", 24, 21, "tapoHubTriggered");
    TAPO_HUB_TRIGGERED = localEnumMsgSubscribeType24;
    EnumMsgSubscribeType localEnumMsgSubscribeType25 = new EnumMsgSubscribeType("TAPO_CONTACT_SENSOR_TRIGGERED", 25, 22, "tapoContactSensorTriggered");
    TAPO_CONTACT_SENSOR_TRIGGERED = localEnumMsgSubscribeType25;
    EnumMsgSubscribeType localEnumMsgSubscribeType26 = new EnumMsgSubscribeType("TAPO_MOTION_SENSOR_TRIGGERED", 26, 23, "tapoMotionSensorTriggered");
    TAPO_MOTION_SENSOR_TRIGGERED = localEnumMsgSubscribeType26;
    EnumMsgSubscribeType localEnumMsgSubscribeType27 = new EnumMsgSubscribeType("TAPO_SMART_BUTTON_TRIGGERED", 27, 24, "tapoSmartButtonTriggered");
    TAPO_SMART_BUTTON_TRIGGERED = localEnumMsgSubscribeType27;
    EnumMsgSubscribeType localEnumMsgSubscribeType28 = new EnumMsgSubscribeType("TAPO_SMART_SWITCH_TRIGGERED", 28, 25, "tapoSmartSwitchTriggered");
    TAPO_SMART_SWITCH_TRIGGERED = localEnumMsgSubscribeType28;
    EnumMsgSubscribeType localEnumMsgSubscribeType29 = new EnumMsgSubscribeType("TAPO_THERMOSTAT_RADIATOR_VALVE", 29, 26, "tapoThermostatRadiatorValve");
    TAPO_THERMOSTAT_RADIATOR_VALVE = localEnumMsgSubscribeType29;
    EnumMsgSubscribeType localEnumMsgSubscribeType30 = new EnumMsgSubscribeType("TAPO_DEVICE_LOW_BATTERY", 30, 27, "tapoDeviceLowBattery");
    TAPO_DEVICE_LOW_BATTERY = localEnumMsgSubscribeType30;
    EnumMsgSubscribeType localEnumMsgSubscribeType31 = new EnumMsgSubscribeType("TAPO_SENSOR_FREQUENTLY_TRIGGERED", 31, 28, "tapoSensorFrequentlyTriggered");
    TAPO_SENSOR_FREQUENTLY_TRIGGERED = localEnumMsgSubscribeType31;
    EnumMsgSubscribeType localEnumMsgSubscribeType32 = new EnumMsgSubscribeType("TAPO_DAILY_SUMMARY_CREATED", 32, 29, "videosummaryGenerated");
    TAPO_DAILY_SUMMARY_CREATED = localEnumMsgSubscribeType32;
    EnumMsgSubscribeType localEnumMsgSubscribeType33 = new EnumMsgSubscribeType("TAPO_DAILY_SUMMARY_CAN_CREATE", 33, 30, "videosummaryCanCreateFromClips");
    TAPO_DAILY_SUMMARY_CAN_CREATE = localEnumMsgSubscribeType33;
    EnumMsgSubscribeType localEnumMsgSubscribeType34 = new EnumMsgSubscribeType("UNKNOWN", 34, 100, "unknown");
    UNKNOWN = localEnumMsgSubscribeType34;
    $VALUES = new EnumMsgSubscribeType[] { localEnumMsgSubscribeType1, localEnumMsgSubscribeType2, localEnumMsgSubscribeType3, localEnumMsgSubscribeType4, localEnumMsgSubscribeType5, localEnumMsgSubscribeType6, localEnumMsgSubscribeType7, localEnumMsgSubscribeType8, localEnumMsgSubscribeType9, localEnumMsgSubscribeType10, localEnumMsgSubscribeType11, localEnumMsgSubscribeType12, localEnumMsgSubscribeType13, localEnumMsgSubscribeType14, localEnumMsgSubscribeType15, localObject, localEnumMsgSubscribeType16, localEnumMsgSubscribeType17, localEnumMsgSubscribeType18, localEnumMsgSubscribeType19, localEnumMsgSubscribeType20, localEnumMsgSubscribeType21, localEnumMsgSubscribeType22, localEnumMsgSubscribeType23, localEnumMsgSubscribeType24, localEnumMsgSubscribeType25, localEnumMsgSubscribeType26, localEnumMsgSubscribeType27, localEnumMsgSubscribeType28, localEnumMsgSubscribeType29, localEnumMsgSubscribeType30, localEnumMsgSubscribeType31, localEnumMsgSubscribeType32, localEnumMsgSubscribeType33, localEnumMsgSubscribeType34 };
    stringToEnum = new HashMap();
    for (localEnumMsgSubscribeType7 : values()) {
      stringToEnum.put(localEnumMsgSubscribeType7.getName(), localEnumMsgSubscribeType7);
    }
  }
  
  private EnumMsgSubscribeType(int paramInt, String paramString)
  {
    this.value = paramInt;
    this.name = paramString;
  }
  
  public static EnumMsgSubscribeType fromString(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return UNKNOWN;
    }
    if (stringToEnum.get(paramString) == null) {
      paramString = UNKNOWN;
    } else {
      paramString = (EnumMsgSubscribeType)stringToEnum.get(paramString);
    }
    return paramString;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getValue()
  {
    return this.value;
  }
  
  @NonNull
  public String toString()
  {
    return getName();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\enumerate\EnumMsgSubscribeType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */