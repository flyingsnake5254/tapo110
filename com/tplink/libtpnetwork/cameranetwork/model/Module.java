package com.tplink.libtpnetwork.cameranetwork.model;

public enum Module
{
  private final String value;
  
  static
  {
    Module localModule1 = new Module("DATA", 0, "data");
    DATA = localModule1;
    Module localModule2 = new Module("ON_BOARDING", 1, "onboarding");
    ON_BOARDING = localModule2;
    Module localModule3 = new Module("SYSTEM", 2, "system");
    SYSTEM = localModule3;
    Module localModule4 = new Module("DEVICE_INFO", 3, "device_info");
    DEVICE_INFO = localModule4;
    Module localModule5 = new Module("LED", 4, "led");
    LED = localModule5;
    Module localModule6 = new Module("OSD", 5, "OSD");
    OSD = localModule6;
    Module localModule7 = new Module("USER_MANAGEMENT", 6, "user_management");
    USER_MANAGEMENT = localModule7;
    Module localModule8 = new Module("HARD_DISK_MANAGE", 7, "harddisk_manage");
    HARD_DISK_MANAGE = localModule8;
    Module localModule9 = new Module("VIDEO", 8, "video");
    VIDEO = localModule9;
    Module localModule10 = new Module("VIDEO_CAPABILITY", 9, "video_capability");
    VIDEO_CAPABILITY = localModule10;
    Module localModule11 = new Module("WLAN", 10, "wlan");
    WLAN = localModule11;
    Module localModule12 = new Module("NETWORK", 11, "network");
    NETWORK = localModule12;
    Module localModule13 = new Module("MSG_ALARM", 12, "msg_alarm");
    MSG_ALARM = localModule13;
    Module localModule14 = new Module("MSG_ALARM_PLAN", 13, "msg_alarm_plan");
    MSG_ALARM_PLAN = localModule14;
    Module localModule15 = new Module("CERT", 14, "cet");
    CERT = localModule15;
    Module localModule16 = new Module("CLOUD_STATUS", 15, "cloud_status");
    CLOUD_STATUS = localModule16;
    Module localModule17 = new Module("CLOUD_CONFIG", 16, "cloud_config");
    CLOUD_CONFIG = localModule17;
    Module localModule18 = new Module("PLAYBACK", 17, "playback");
    PLAYBACK = localModule18;
    Module localModule19 = new Module("LENS_MASK", 18, "lens_mask");
    LENS_MASK = localModule19;
    Module localModule20 = new Module("TIMING_REBOOT", 19, "timing_reboot");
    TIMING_REBOOT = localModule20;
    Module localModule21 = new Module("IMAGE", 20, "image");
    IMAGE = localModule21;
    Module localModule22 = new Module("RECORD_PLAN", 21, "record_plan");
    RECORD_PLAN = localModule22;
    Module localModule23 = new Module("MOTION_DETECTION", 22, "motion_detection");
    MOTION_DETECTION = localModule23;
    Module localModule24 = new Module("MOTOR", 23, "motor");
    MOTOR = localModule24;
    Module localModule25 = new Module("PRESET", 24, "preset");
    PRESET = localModule25;
    Module localModule26 = new Module("AUDIO_CONFIG", 25, "audio_config");
    AUDIO_CONFIG = localModule26;
    Module localModule27 = new Module("LANGUAGE", 26, "language");
    LANGUAGE = localModule27;
    Module localModule28 = new Module("APP_COMPONENT", 27, "app_component");
    APP_COMPONENT = localModule28;
    Module localModule29 = new Module("COVER", 28, "cover");
    COVER = localModule29;
    Module localModule30 = new Module("TARGET_TRACK", 29, "target_track");
    TARGET_TRACK = localModule30;
    Module localModule31 = new Module("SOUND_DETECTION", 30, "sound_detection");
    SOUND_DETECTION = localModule31;
    Module localModule32 = new Module("PEOPLE_DETECTION", 31, "people_detection");
    PEOPLE_DETECTION = localModule32;
    Module localModule33 = new Module("EMPTY", 32, "null");
    EMPTY = localModule33;
    Module localModule34 = new Module("MSG_PUSH", 33, "msg_push");
    MSG_PUSH = localModule34;
    Module localModule35 = new Module("MSG_PUSH_PLAN", 34, "msg_push_plan");
    MSG_PUSH_PLAN = localModule35;
    Module localModule36 = new Module("TAMPER_DETECTION", 35, "tamper_detection");
    TAMPER_DETECTION = localModule36;
    Module localModule37 = new Module("INTRUSION_DETECTION", 36, "intrusion_detection");
    INTRUSION_DETECTION = localModule37;
    Module localModule38 = new Module("LINE_CROSSING_DETECTION", 37, "linecrossing_detection");
    LINE_CROSSING_DETECTION = localModule38;
    Module localModule39 = new Module("IMAGE_CAPABILITY", 38, "image_capability");
    IMAGE_CAPABILITY = localModule39;
    Module localModule40 = new Module("AUTO_UPDATE", 39, "auto_upgrade");
    AUTO_UPDATE = localModule40;
    Module localModule41 = new Module("SERVER_TYPE", 40, "server_type");
    SERVER_TYPE = localModule41;
    Module localModule42 = new Module("UPNPC", 41, "upnpc");
    UPNPC = localModule42;
    Module localModule43 = new Module("TAPO_CARE", 42, "tapo_care");
    TAPO_CARE = localModule43;
    $VALUES = new Module[] { localModule1, localModule2, localModule3, localModule4, localModule5, localModule6, localModule7, localModule8, localModule9, localModule10, localModule11, localModule12, localModule13, localModule14, localModule15, localModule16, localModule17, localModule18, localModule19, localModule20, localModule21, localModule22, localModule23, localModule24, localModule25, localModule26, localModule27, localModule28, localModule29, localModule30, localModule31, localModule32, localModule33, localModule34, localModule35, localModule36, localModule37, localModule38, localModule39, localModule40, localModule41, localModule42, localModule43 };
  }
  
  private Module(String paramString)
  {
    this.value = paramString;
  }
  
  public final String getValue()
  {
    return this.value;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\Module.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */