package com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel;

public class ThingModelDefine
{
  public static final class Event
  {
    public static final String EVENT_ALARM = "alarm";
    public static final String EVENT_CAMERA_AREA_INTRUSION_DETECTION = "tapoCameraAreaIntrusionDetection";
    public static final String EVENT_CAMERA_BABY_CRY = "Babycry";
    public static final String EVENT_CAMERA_CAMERA_TAMPERING = "tapoCameraCameraTampering";
    public static final String EVENT_CAMERA_LINE_CROSSING_DETECTION = "tapoCameraLinecrossingDetection";
    public static final String EVENT_CAMERA_MOTION = "Motion";
    public static final String EVENT_CAMERA_PERSON_DETECTED = "PersonDetected";
    public static final String EVENT_CAMERA_SD_INSUFFICIENT_STORAGE = "tapoCameraSDInsufficientStorage";
    public static final String EVENT_CAMERA_SD_NEED_INITIALIZATION = "tapoCameraSDNeedInitialization";
    public static final String EVENT_CLOSE = "close";
    public static final String EVENT_DOUBLE_CLICK = "doubleClick";
    public static final String EVENT_KEEP_OPEN = "keepOpen";
    public static final String EVENT_LOW_BATTERY = "lowBattery";
    public static final String EVENT_MOTION = "motion";
    public static final String EVENT_OPEN = "open";
    public static final String EVENT_ROTATION = "rotation";
    public static final String EVENT_SINGLE_CLICK = "singleClick";
    public static final String EVENT_WINDOW_OPEN = "windowOpen";
    public static final String UPLOAD_PARAMS_DEVICE_ID = "device_id";
    public static final String UPLOAD_PARAMS_GUARD_MODE = "guard_mode";
    public static final String UPLOAD_PARAMS_NICKNAME = "nickname";
    public static final String UPLOAD_PARAMS_ROTATE_DEG = "rotate_deg";
  }
  
  public static final class Property
  {
    public static final String PROPERTY_AT_LOW_BATTERY = "at_low_battery";
    public static final String PROPERTY_AUTO = "auto";
    public static final String PROPERTY_AUTO_MODE = "auto_mode";
    public static final String PROPERTY_BRIGHTNESS = "brightness";
    public static final String PROPERTY_CAMERA_DAY_NIGHT_MODE = "dayNightMode";
    public static final String PROPERTY_CAMERA_LENS_MASK = "lensMask";
    public static final String PROPERTY_COLOR_TEMP = "color_temp";
    public static final String PROPERTY_CURRENT_TEMP = "current_temp";
    public static final String PROPERTY_DYNAMIC_LIGHT_EFFECT_ENABLE = "dynamic_light_effect_enable";
    public static final String PROPERTY_DYNAMIC_LIGHT_EFFECT_ID = "dynamic_light_effect_id";
    public static final String PROPERTY_FROST_PROTECTION_ON = "frost_protection_on";
    public static final String PROPERTY_GUARD_MODE = "guard_mode";
    public static final String PROPERTY_GUARD_ON = "guard_on";
    public static final String PROPERTY_HUE = "hue";
    public static final String PROPERTY_IN_ALARM = "in_alarm";
    public static final String PROPERTY_LIGHTING_EFFECT = "lighting_effect";
    public static final String PROPERTY_MAX_CONTROL_TEMP = "max_control_temp";
    public static final String PROPERTY_MIN_CONTROL_TEMP = "min_control_temp";
    public static final String PROPERTY_MUSIC_RHYTHM_ENABLE = "music_rhythm_enable";
    public static final String PROPERTY_MUSIC_RHYTHM_MODE = "music_rhythm_mode";
    public static final String PROPERTY_ON = "on";
    public static final String PROPERTY_SATURATION = "saturation";
    public static final String PROPERTY_TARGET_TEMP = "target_temp";
    public static final String PROPERTY_TEMP_OFFSET = "temp_offset";
    public static final String PROPERTY_TEMP_UNIT = "temp_unit";
    public static final String PROPERTY_TRV_STATES = "trv_states";
  }
  
  public static final class Service
  {
    public static final String INPUT_PARAM_DURATION = "duration";
    public static final String INPUT_PARAM_TYPE = "type";
    public static final String INPUT_PARAM_VOLUME = "volume";
    public static final String OUTPUT_PARAMS_RESULT = "result";
    public static final String SERVICE_DECREASE_BRIGHTNESS = "decreaseBrightness";
    public static final String SERVICE_DECREASE_COLOR_TEMP = "decreaseCCT";
    public static final String SERVICE_GET_FW_DOWNLOAD_STATE = "getFwDownloadState";
    public static final String SERVICE_INCREASE_BRIGHTNESS = "increaseBrightness";
    public static final String SERVICE_INCREASE_COLOR_TEMP = "increaseCCT";
    public static final String SERVICE_PROGRESS_CALIBRATION = "progressCalibration";
    public static final String SERVICE_RANDOM_COLOR = "randomColor";
    public static final String SERVICE_REMOVE_SCALE = "removeScale";
    public static final String SERVICE_REVERSE_STATUS = "reverseStatus";
    public static final String SERVICE_RING = "ring";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\thingmodel\ThingModelDefine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */