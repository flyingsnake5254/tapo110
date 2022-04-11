package com.tplink.libtpnetwork.cameranetwork.model;

public enum Method
{
  private final String value;
  
  static
  {
    Method localMethod1 = new Method("PASS_THROUGH", 0, "passthrough");
    PASS_THROUGH = localMethod1;
    Method localMethod2 = new Method("MULTIPLE_REQUEST", 1, "multipleRequest");
    MULTIPLE_REQUEST = localMethod2;
    Method localMethod3 = new Method("SCAN_WIFI_LIST", 2, "scanApList");
    SCAN_WIFI_LIST = localMethod3;
    Method localMethod4 = new Method("CHANGE_PASSWORD", 3, "changePassword");
    CHANGE_PASSWORD = localMethod4;
    Method localMethod5 = new Method("GET_SD_CARD_STATUS", 4, "getSdCardStatus");
    GET_SD_CARD_STATUS = localMethod5;
    Method localMethod6 = new Method("FORMAT_SD_CARD", 5, "formatSdCard");
    FORMAT_SD_CARD = localMethod6;
    Method localMethod7 = new Method("GET_SD_CARD_FORMAT_STATUS", 6, "getSdCardFormatStatus");
    GET_SD_CARD_FORMAT_STATUS = localMethod7;
    Method localMethod8 = new Method("GET_TIMEZONE", 7, "getTimezone");
    GET_TIMEZONE = localMethod8;
    Method localMethod9 = new Method("SET_TIMEZONE", 8, "setTimezone");
    SET_TIMEZONE = localMethod9;
    Method localMethod10 = new Method("GET_DEVICE_INFO", 9, "getDeviceInfo");
    GET_DEVICE_INFO = localMethod10;
    Method localMethod11 = new Method("GET_DEVICE_ALIAS", 10, "getDeviceAlias");
    GET_DEVICE_ALIAS = localMethod11;
    Method localMethod12 = new Method("SET_DEVICE_ALIAS", 11, "setDeviceAlias");
    SET_DEVICE_ALIAS = localMethod12;
    Method localMethod13 = new Method("GET_CONNECTION_TYPE", 12, "getConnectionType");
    GET_CONNECTION_TYPE = localMethod13;
    Method localMethod14 = new Method("GET_DEVICE_IP_ADDRESS", 13, "getDeviceIpAddress");
    GET_DEVICE_IP_ADDRESS = localMethod14;
    Method localMethod15 = new Method("GET_REBOOT", 14, "getReboot");
    GET_REBOOT = localMethod15;
    Method localMethod16 = new Method("SET_REBOOT", 15, "setReboot");
    SET_REBOOT = localMethod16;
    Method localMethod17 = new Method("REBOOT_DEVICE", 16, "rebootDevice");
    REBOOT_DEVICE = localMethod17;
    Method localMethod18 = new Method("RESET", 17, "reset");
    RESET = localMethod18;
    Method localMethod19 = new Method("SOFT_RESET", 18, "softReset");
    SOFT_RESET = localMethod19;
    Method localMethod20 = new Method("RESET_CONFIG_ONLY", 19, "resetConfigOnly");
    RESET_CONFIG_ONLY = localMethod20;
    Method localMethod21 = new Method("CHECK_RESET_WIFI", 20, "checkResetWiFi");
    CHECK_RESET_WIFI = localMethod21;
    Method localMethod22 = new Method("SET_DEVICE_AVATAR", 21, "setDeviceAvatar");
    SET_DEVICE_AVATAR = localMethod22;
    Method localMethod23 = new Method("GET_LED_STATUS", 22, "getLedStatus");
    GET_LED_STATUS = localMethod23;
    Method localMethod24 = new Method("SET_LED_STATUS", 23, "setLedStatus");
    SET_LED_STATUS = localMethod24;
    Method localMethod25 = new Method("GET_CLOCK_STATUS", 24, "getClockStatus");
    GET_CLOCK_STATUS = localMethod25;
    Method localMethod26 = new Method("GET_USER_ID", 25, "getUserID");
    GET_USER_ID = localMethod26;
    Method localMethod27 = new Method("GET_SCALE_LIST", 26, "getScaleList");
    GET_SCALE_LIST = localMethod27;
    Method localMethod28 = new Method("SEARCH_VIDEO_OF_DAY", 27, "searchVideoOfDay");
    SEARCH_VIDEO_OF_DAY = localMethod28;
    Method localMethod29 = new Method("SEARCH_DATE_WITH_VIDEO", 28, "searchDateWithVideo");
    SEARCH_DATE_WITH_VIDEO = localMethod29;
    Method localMethod30 = new Method("SEARCH_SEARCH_SNAPSHOT", 29, "searchDetectionList");
    SEARCH_SEARCH_SNAPSHOT = localMethod30;
    Method localMethod31 = new Method("GET_DST_RULE", 30, "getDstRule");
    GET_DST_RULE = localMethod31;
    Method localMethod32 = new Method("SEARCH_VIDEO_WITH_UTC", 31, "searchVideoWithUTC");
    SEARCH_VIDEO_WITH_UTC = localMethod32;
    Method localMethod33 = new Method("GET_LAST_ALARM_INFO", 32, "getLastAlarmInfo");
    GET_LAST_ALARM_INFO = localMethod33;
    Method localMethod34 = new Method("GET_DETECTION_CONFIG", 33, "getDetectionConfig");
    GET_DETECTION_CONFIG = localMethod34;
    Method localMethod35 = new Method("SET_DETECTION_CONFIG", 34, "setDetectionConfig");
    SET_DETECTION_CONFIG = localMethod35;
    Method localMethod36 = new Method("GET_DETECTION_REGION", 35, "getDetectionRegion");
    GET_DETECTION_REGION = localMethod36;
    Method localMethod37 = new Method("ADD_DETECTION_REGION", 36, "addDetectionRegion");
    ADD_DETECTION_REGION = localMethod37;
    Method localMethod38 = new Method("GET_ALERT_CONFIG", 37, "getAlertConfig");
    GET_ALERT_CONFIG = localMethod38;
    Method localMethod39 = new Method("SET_ALERT_CONFIG", 38, "setAlertConfig");
    SET_ALERT_CONFIG = localMethod39;
    Method localMethod40 = new Method("GET_ALERT_PLAN", 39, "getAlertPlan");
    GET_ALERT_PLAN = localMethod40;
    Method localMethod41 = new Method("SET_ALERT_PLAN", 40, "setAlertPlan");
    SET_ALERT_PLAN = localMethod41;
    Method localMethod42 = new Method("GET_MSG_PUSH_CONFIG", 41, "getMsgPushConfig");
    GET_MSG_PUSH_CONFIG = localMethod42;
    Method localMethod43 = new Method("SET_MSG_PUSH_CONFIG", 42, "setMsgPushConfig");
    SET_MSG_PUSH_CONFIG = localMethod43;
    Method localMethod44 = new Method("GET_MSG_PUSH_PLAN", 43, "getMsgPushPlan");
    GET_MSG_PUSH_PLAN = localMethod44;
    Method localMethod45 = new Method("SET_MSG_PUSH_PLAN", 44, "setMsgPushPlan");
    SET_MSG_PUSH_PLAN = localMethod45;
    Method localMethod46 = new Method("GET_CLOUD_CONFIG", 45, "getCloudConfig");
    GET_CLOUD_CONFIG = localMethod46;
    Method localMethod47 = new Method("CHECK_FIRMWARE_VERSION_BY_CLOUD", 46, "checkFirmwareVersionByCloud");
    CHECK_FIRMWARE_VERSION_BY_CLOUD = localMethod47;
    Method localMethod48 = new Method("GET_FIRMWARE_UPDATE_STATUS", 47, "getFirmwareUpdateStatus");
    GET_FIRMWARE_UPDATE_STATUS = localMethod48;
    Method localMethod49 = new Method("START_FIRMWARE_UPGRADE", 48, "startFirmwareUpgrade");
    START_FIRMWARE_UPGRADE = localMethod49;
    Method localMethod50 = new Method("UNBIND_CLOUD", 49, "unbindCloud");
    UNBIND_CLOUD = localMethod50;
    Method localMethod51 = new Method("GET_BIND_STATUS", 50, "getBindStatus");
    GET_BIND_STATUS = localMethod51;
    Method localMethod52 = new Method("GET_THIRD_ACCOUNT", 51, "getThirdAccount");
    GET_THIRD_ACCOUNT = localMethod52;
    Method localMethod53 = new Method("CHANGE_THIRD_ACCOUNT", 52, "changeThirdAccount");
    CHANGE_THIRD_ACCOUNT = localMethod53;
    Method localMethod54 = new Method("VERIFY_THIRD_ACCOUNT", 53, "verifyThirdAccount");
    VERIFY_THIRD_ACCOUNT = localMethod54;
    Method localMethod55 = new Method("LOGIN", 54, "login");
    LOGIN = localMethod55;
    Method localMethod56 = new Method("LOGOUT", 55, "logout");
    LOGOUT = localMethod56;
    Method localMethod57 = new Method("BIND_TO_CLOUD", 56, "bindToCloud");
    BIND_TO_CLOUD = localMethod57;
    Method localMethod58 = new Method("CHANGE_ADMIN_PASSWORD", 57, "changeAdminPassword");
    CHANGE_ADMIN_PASSWORD = localMethod58;
    Method localMethod59 = new Method("SET_MEDIA_ENCRYPT", 58, "setMediaEncrypt");
    SET_MEDIA_ENCRYPT = localMethod59;
    Method localMethod60 = new Method("SET_LANGUAGE", 59, "setLanguage");
    SET_LANGUAGE = localMethod60;
    Method localMethod61 = new Method("SCAN_AP_LIST", 60, "scanApList");
    SCAN_AP_LIST = localMethod61;
    Method localMethod62 = new Method("CONNECT_AP", 61, "connectAp");
    CONNECT_AP = localMethod62;
    Method localMethod63 = new Method("GET_CONNECT_STATUS", 62, "getConnectStatus");
    GET_CONNECT_STATUS = localMethod63;
    Method localMethod64 = new Method("MOTOR_MOVE", 63, "motorMove");
    MOTOR_MOVE = localMethod64;
    Method localMethod65 = new Method("ADD_MOTOR_POSITION", 64, "addMotorPostion");
    ADD_MOTOR_POSITION = localMethod65;
    Method localMethod66 = new Method("MOTOR_MOVE_TO_PRESET", 65, "motorMoveToPreset");
    MOTOR_MOVE_TO_PRESET = localMethod66;
    Method localMethod67 = new Method("RELATIVE_MOVE", 66, "relativeMove");
    RELATIVE_MOVE = localMethod67;
    Method localMethod68 = new Method("SIGNAL_MOVE", 67, "singalMove");
    SIGNAL_MOVE = localMethod68;
    Method localMethod69 = new Method("STOP_MOVE", 68, "stopMove");
    STOP_MOVE = localMethod69;
    Method localMethod70 = new Method("MANUAL_CALIBRATE", 69, "manualCalibrate");
    MANUAL_CALIBRATE = localMethod70;
    Method localMethod71 = new Method("CRUISE_MOVE", 70, "cruiseMove");
    CRUISE_MOVE = localMethod71;
    Method localMethod72 = new Method("CRUISE_STOP", 71, "cruiseStop");
    CRUISE_STOP = localMethod72;
    Method localMethod73 = new Method("GET_PRESET_CONFIG", 72, "getPresetConfig");
    GET_PRESET_CONFIG = localMethod73;
    Method localMethod74 = new Method("DELETE_PRESET", 73, "deletePreset");
    DELETE_PRESET = localMethod74;
    Method localMethod75 = new Method("GET_MEDIA_ENCRYPT", 74, "getMediaEncrypt");
    GET_MEDIA_ENCRYPT = localMethod75;
    Method localMethod76 = new Method("GET_VIDEO_QUALITIES", 75, "getVideoQualities");
    GET_VIDEO_QUALITIES = localMethod76;
    Method localMethod77 = new Method("GET_SERVER_PORT", 76, "getServerPort");
    GET_SERVER_PORT = localMethod77;
    Method localMethod78 = new Method("SET_RESOLUTION", 77, "setResolution");
    SET_RESOLUTION = localMethod78;
    Method localMethod79 = new Method("GET_VIDEO_CAPABILITY", 78, "getVideoCapability");
    GET_VIDEO_CAPABILITY = localMethod79;
    Method localMethod80 = new Method("GET_LENS_MASK_CONFIG", 79, "getLensMaskConfig");
    GET_LENS_MASK_CONFIG = localMethod80;
    Method localMethod81 = new Method("SET_LENS_MASK_CONFIG", 80, "setLensMaskConfig");
    SET_LENS_MASK_CONFIG = localMethod81;
    Method localMethod82 = new Method("GET_LIGHT_FREQUENCY_INFO", 81, "getLightFrequencyInfo");
    GET_LIGHT_FREQUENCY_INFO = localMethod82;
    Method localMethod83 = new Method("SET_LIGHT_FREQUENCY_INFO", 82, "setLightFrequencyInfo");
    SET_LIGHT_FREQUENCY_INFO = localMethod83;
    Method localMethod84 = new Method("GET_DAY_NIGHT_MODE_CONFIG", 83, "getDayNightModeConfig");
    GET_DAY_NIGHT_MODE_CONFIG = localMethod84;
    Method localMethod85 = new Method("SET_DAY_NIGHT_MODE_CONFIG", 84, "setDayNightModeConfig");
    SET_DAY_NIGHT_MODE_CONFIG = localMethod85;
    Method localMethod86 = new Method("GET_OSD", 85, "getOsd");
    GET_OSD = localMethod86;
    Method localMethod87 = new Method("SET_OSD", 86, "setOsd");
    SET_OSD = localMethod87;
    Method localMethod88 = new Method("GET_RECORD_PLAN", 87, "getRecordPlan");
    GET_RECORD_PLAN = localMethod88;
    Method localMethod89 = new Method("SET_RECORD_PLAN", 88, "setRecordPlan");
    SET_RECORD_PLAN = localMethod89;
    Method localMethod90 = new Method("GET_CIRCULAR_RECORDING_CONFIG", 89, "getCircularRecordingConfig");
    GET_CIRCULAR_RECORDING_CONFIG = localMethod90;
    Method localMethod91 = new Method("SET_CIRCULAR_RECORDING_CONFIG", 90, "setCircularRecordingConfig");
    SET_CIRCULAR_RECORDING_CONFIG = localMethod91;
    Method localMethod92 = new Method("GET_ROTATION_STATUS", 91, "getRotationStatus");
    GET_ROTATION_STATUS = localMethod92;
    Method localMethod93 = new Method("SET_ROTATION_STATUS", 92, "setRotationStatus");
    SET_ROTATION_STATUS = localMethod93;
    Method localMethod94 = new Method("GET_AUDIO_CONFIG", 93, "getAudioConfig");
    GET_AUDIO_CONFIG = localMethod94;
    Method localMethod95 = new Method("SET_RECORD_AUDIO", 94, "setRecordAudio");
    SET_RECORD_AUDIO = localMethod95;
    Method localMethod96 = new Method("SET_MICROPHONE_VOLUME", 95, "setMicrophoneVolume");
    SET_MICROPHONE_VOLUME = localMethod96;
    Method localMethod97 = new Method("SET_SPEAKER_VOLUME", 96, "setSpeakerVolume");
    SET_SPEAKER_VOLUME = localMethod97;
    Method localMethod98 = new Method("GET_APP_COMPONENT_LIST", 97, "getAppComponentList");
    GET_APP_COMPONENT_LIST = localMethod98;
    Method localMethod99 = new Method("GET_LDC", 98, "getLdc");
    GET_LDC = localMethod99;
    Method localMethod100 = new Method("SET_LDC", 99, "setLdc");
    SET_LDC = localMethod100;
    Method localMethod101 = new Method("CHECK_DIAGNOSE_STATUS", 100, "checkDiagnoseStatus");
    CHECK_DIAGNOSE_STATUS = localMethod101;
    Method localMethod102 = new Method("GET_DIAGNOSE_MODE", 101, "getDiagnoseMode");
    GET_DIAGNOSE_MODE = localMethod102;
    Method localMethod103 = new Method("SET_DIAGNOSE_MODE", 102, "setDiagnoseMode");
    SET_DIAGNOSE_MODE = localMethod103;
    Method localMethod104 = new Method("GET_COVER_CONFIG", 103, "getCoverConfig");
    GET_COVER_CONFIG = localMethod104;
    Method localMethod105 = new Method("SET_COVER_CONFIG", 104, "setCoverConfig");
    SET_COVER_CONFIG = localMethod105;
    Method localMethod106 = new Method("GET_COVER_REGION", 105, "getCoverRegion");
    GET_COVER_REGION = localMethod106;
    Method localMethod107 = new Method("ADD_COVER_REGION", 106, "addCoverRegion");
    ADD_COVER_REGION = localMethod107;
    Method localMethod108 = new Method("GET_TARGET_TRACK_CONFIG", 107, "getTargetTrackConfig");
    GET_TARGET_TRACK_CONFIG = localMethod108;
    Method localMethod109 = new Method("SET_TARGET_TRACK_CONFIG", 108, "setTargetTrackConfig");
    SET_TARGET_TRACK_CONFIG = localMethod109;
    Method localMethod110 = new Method("GET_BCD_CONFIG", 109, "getBCDConfig");
    GET_BCD_CONFIG = localMethod110;
    Method localMethod111 = new Method("SET_BCD_CONFIG", 110, "setBCDConfig");
    SET_BCD_CONFIG = localMethod111;
    Method localMethod112 = new Method("GET_PERSON_DETECTION_CONFIG", 111, "getPersonDetectionConfig");
    GET_PERSON_DETECTION_CONFIG = localMethod112;
    Method localMethod113 = new Method("SET_PERSON_DETECTION_CONFIG", 112, "setPersonDetectionConfig");
    SET_PERSON_DETECTION_CONFIG = localMethod113;
    Method localMethod114 = new Method("GET_P2P_SHARE_PWD", 113, "getP2PSharePassword");
    GET_P2P_SHARE_PWD = localMethod114;
    Method localMethod115 = new Method("GET_AES_ENCRYPT_KEY", 114, "getAESEncryptKey");
    GET_AES_ENCRYPT_KEY = localMethod115;
    Method localMethod116 = new Method("GET_TAMPER_DETECTION_CONFIG", 115, "getTamperDetectionConfig");
    GET_TAMPER_DETECTION_CONFIG = localMethod116;
    Method localMethod117 = new Method("SET_TAMPER_DETECTION_CONFIG", 116, "setTamperDetectionConfig");
    SET_TAMPER_DETECTION_CONFIG = localMethod117;
    Method localMethod118 = new Method("GET_INTRUSION_DETECTION_CONFIG", 117, "getIntrusionDetectionConfig");
    GET_INTRUSION_DETECTION_CONFIG = localMethod118;
    Method localMethod119 = new Method("SET_INTRUSION_DETECTION_CONFIG", 118, "setIntrusionDetectionConfig");
    SET_INTRUSION_DETECTION_CONFIG = localMethod119;
    Method localMethod120 = new Method("SET_INTRUSION_DETECTION_SCHEDULE", 119, "setIntrusionDetectionSchedule");
    SET_INTRUSION_DETECTION_SCHEDULE = localMethod120;
    Method localMethod121 = new Method("GET_INTRUSION_DETECTION_REGION", 120, "getIntrusionDetectionRegion");
    GET_INTRUSION_DETECTION_REGION = localMethod121;
    Method localMethod122 = new Method("ADD_INTRUSION_DETECTION_REGION", 121, "addIntrusionDetectionRegion");
    ADD_INTRUSION_DETECTION_REGION = localMethod122;
    Method localMethod123 = new Method("GET_LINE_CROSSING_DETECTION_CONFIG", 122, "getLinecrossingDetectionConfig");
    GET_LINE_CROSSING_DETECTION_CONFIG = localMethod123;
    Method localMethod124 = new Method("SET_LINE_CROSSING_DETECTION_CONFIG", 123, "setLinecrossingDetectionConfig");
    SET_LINE_CROSSING_DETECTION_CONFIG = localMethod124;
    Method localMethod125 = new Method("SET_LINE_CROSSING_DETECTION_SCHEDULE", 124, "setLinecrossingDetectionSchedule");
    SET_LINE_CROSSING_DETECTION_SCHEDULE = localMethod125;
    Method localMethod126 = new Method("GET_LINE_CROSSING_DETECTION_REGION", 125, "getLinecrossingDetectionRegion");
    GET_LINE_CROSSING_DETECTION_REGION = localMethod126;
    Method localMethod127 = new Method("ADD_LINE_CROSSING_DETECTION_REGION", 126, "addLinecrossingDetectionRegion");
    ADD_LINE_CROSSING_DETECTION_REGION = localMethod127;
    Method localMethod128 = new Method("GET_NIGHT_VISION_MODE_CONFIG", 127, "getNightVisionModeConfig");
    GET_NIGHT_VISION_MODE_CONFIG = localMethod128;
    Method localMethod129 = new Method("SET_NIGHT_VISION_MODE_CONFIG", 128, "setNightVisionModeConfig");
    SET_NIGHT_VISION_MODE_CONFIG = localMethod129;
    Method localMethod130 = new Method("GET_NIGHT_VISION_CAPABILITY", 129, "getNightVisionCapability");
    GET_NIGHT_VISION_CAPABILITY = localMethod130;
    Method localMethod131 = new Method("GET_FORCE_WHITELAMP_STATE", 130, "getForceWhitelampState");
    GET_FORCE_WHITELAMP_STATE = localMethod131;
    Method localMethod132 = new Method("SET_FORCE_WHITELAMP_STATE", 131, "setForceWhitelampState");
    SET_FORCE_WHITELAMP_STATE = localMethod132;
    Method localMethod133 = new Method("GET_WHITE_LAMP_CONFIG", 132, "getWhitelampConfig");
    GET_WHITE_LAMP_CONFIG = localMethod133;
    Method localMethod134 = new Method("SET_WHITE_LAMP_CONFIG", 133, "setWhitelampConfig");
    SET_WHITE_LAMP_CONFIG = localMethod134;
    Method localMethod135 = new Method("GET_FIRMWARE_AUTO_UPGRADE_CONFIG", 134, "getFirmwareAutoUpgradeConfig");
    GET_FIRMWARE_AUTO_UPGRADE_CONFIG = localMethod135;
    Method localMethod136 = new Method("SET_FIRMWARE_AUTO_UPGRADE_CONFIG", 135, "setFirmwareAutoUpgradeConfig");
    SET_FIRMWARE_AUTO_UPGRADE_CONFIG = localMethod136;
    Method localMethod137 = new Method("SET_CLOUD_SERVER_TYPE", 136, "setCloudServerType");
    SET_CLOUD_SERVER_TYPE = localMethod137;
    Method localMethod138 = new Method("GET_UPNP_INFO", 137, "getUpnpInfo");
    GET_UPNP_INFO = localMethod138;
    Method localMethod139 = new Method("SET_UPNP_INFO", 138, "setUpnpInfo");
    SET_UPNP_INFO = localMethod139;
    Method localMethod140 = new Method("GET_UPNP_STATUS", 139, "getUpnpStatus");
    GET_UPNP_STATUS = localMethod140;
    Method localMethod141 = new Method("GET_PUB_IP", 140, "getPubIP");
    GET_PUB_IP = localMethod141;
    Method localMethod142 = new Method("GET_UPNP_COMM_STATUS", 141, "getUpnpCommStatus");
    GET_UPNP_COMM_STATUS = localMethod142;
    Method localMethod143 = new Method("SET_UPNP_COMM_STATUS", 142, "setUpnpCommStatus");
    SET_UPNP_COMM_STATUS = localMethod143;
    Method localMethod144 = new Method("GET_UPNP_PSK", 143, "getUpnpPsk");
    GET_UPNP_PSK = localMethod144;
    Method localMethod145 = new Method("GET_TAPO_CARE_SERVICE_LIST", 144, "getTapoCareServiceList");
    GET_TAPO_CARE_SERVICE_LIST = localMethod145;
    $VALUES = new Method[] { localMethod1, localMethod2, localMethod3, localMethod4, localMethod5, localMethod6, localMethod7, localMethod8, localMethod9, localMethod10, localMethod11, localMethod12, localMethod13, localMethod14, localMethod15, localMethod16, localMethod17, localMethod18, localMethod19, localMethod20, localMethod21, localMethod22, localMethod23, localMethod24, localMethod25, localMethod26, localMethod27, localMethod28, localMethod29, localMethod30, localMethod31, localMethod32, localMethod33, localMethod34, localMethod35, localMethod36, localMethod37, localMethod38, localMethod39, localMethod40, localMethod41, localMethod42, localMethod43, localMethod44, localMethod45, localMethod46, localMethod47, localMethod48, localMethod49, localMethod50, localMethod51, localMethod52, localMethod53, localMethod54, localMethod55, localMethod56, localMethod57, localMethod58, localMethod59, localMethod60, localMethod61, localMethod62, localMethod63, localMethod64, localMethod65, localMethod66, localMethod67, localMethod68, localMethod69, localMethod70, localMethod71, localMethod72, localMethod73, localMethod74, localMethod75, localMethod76, localMethod77, localMethod78, localMethod79, localMethod80, localMethod81, localMethod82, localMethod83, localMethod84, localMethod85, localMethod86, localMethod87, localMethod88, localMethod89, localMethod90, localMethod91, localMethod92, localMethod93, localMethod94, localMethod95, localMethod96, localMethod97, localMethod98, localMethod99, localMethod100, localMethod101, localMethod102, localMethod103, localMethod104, localMethod105, localMethod106, localMethod107, localMethod108, localMethod109, localMethod110, localMethod111, localMethod112, localMethod113, localMethod114, localMethod115, localMethod116, localMethod117, localMethod118, localMethod119, localMethod120, localMethod121, localMethod122, localMethod123, localMethod124, localMethod125, localMethod126, localMethod127, localMethod128, localMethod129, localMethod130, localMethod131, localMethod132, localMethod133, localMethod134, localMethod135, localMethod136, localMethod137, localMethod138, localMethod139, localMethod140, localMethod141, localMethod142, localMethod143, localMethod144, localMethod145 };
  }
  
  private Method(String paramString)
  {
    this.value = paramString;
  }
  
  public final String getValue()
  {
    return this.value;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\Method.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */