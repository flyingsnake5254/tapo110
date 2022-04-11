package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.Gson;
import com.google.gson.i;
import com.google.gson.r.a;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.b0;
import kotlin.jvm.internal.j;
import kotlin.n;

public final class TypeDispatcher
{
  public static final TypeDispatcher INSTANCE;
  private static final Gson gson;
  private static final Map<String, Map<String, Type>> typeMap;
  
  static
  {
    TypeDispatcher localTypeDispatcher = new TypeDispatcher();
    INSTANCE = localTypeDispatcher;
    typeMap = new LinkedHashMap();
    gson = new Gson();
    localTypeDispatcher.registerType(Module.DEVICE_INFO, Section.BASIC_INFO, BasicInfo.class);
    Object localObject1 = Module.SYSTEM;
    localTypeDispatcher.registerType((Module)localObject1, Section.SYS, SystemInfo.class);
    localTypeDispatcher.registerType((Module)localObject1, Section.BASIC, Timezone.class);
    localTypeDispatcher.registerType((Module)localObject1, Section.USER_ID, VodUserId.class);
    localObject1 = Module.ON_BOARDING;
    localTypeDispatcher.registerType((Module)localObject1, Section.SCAN, WifiList.class);
    localTypeDispatcher.registerType((Module)localObject1, Section.CONNECT, ConnectResult.class);
    localTypeDispatcher.registerType((Module)localObject1, Section.GET_CONNECT_STATUS, ConnectStatus.class);
    localTypeDispatcher.registerType(Module.LED, Section.CONFIG, LedStatus.class);
    Object localObject2 = Module.OSD;
    localTypeDispatcher.registerType((Module)localObject2, Section.OSD_LOGO, OsdElement.class);
    localTypeDispatcher.registerType((Module)localObject2, Section.OSD_DATE, OsdElement.class);
    localTypeDispatcher.registerType((Module)localObject2, Section.OSD_WEEK, OsdElement.class);
    localTypeDispatcher.registerType((Module)localObject2, Section.OSD_FONT, OsdFont.class);
    Object localObject3 = Section.OSD_LABEL_INFO;
    localObject1 = new a() {}.getType();
    j.d(localObject1, "object : TypeToken<List<…, OsdElement>>>() {}.type");
    localTypeDispatcher.registerType((Module)localObject2, (Section)localObject3, (Type)localObject1);
    localObject2 = Module.HARD_DISK_MANAGE;
    localTypeDispatcher.registerType((Module)localObject2, Section.HARD_DISK_LOOP, HardDiskLoop.class);
    localObject3 = Section.HARD_DISK_INFO;
    localObject1 = new a() {}.getType();
    j.d(localObject1, "object : TypeToken<List<…HardDiskInfo>>>() {}.type");
    localTypeDispatcher.registerType((Module)localObject2, (Section)localObject3, (Type)localObject1);
    localTypeDispatcher.registerType(Module.WLAN, Section.WLAN_DEFAULT_AP, DefaultAp.class);
    localTypeDispatcher.registerType(Module.MSG_ALARM, Section.MSG_ALARM_INFO, AlarmInfo.class);
    localTypeDispatcher.registerType(Module.MSG_ALARM_PLAN, Section.MSG_ALARM_PLAN, AlarmPlanInfo.class);
    localTypeDispatcher.registerType(Module.MSG_PUSH, Section.MSG_PUSH_INFO, MsgPushInfo.class);
    localTypeDispatcher.registerType(Module.MSG_PUSH_PLAN, Section.MSG_PUSH_PLAN, MsgPushPlanInfo.class);
    localObject1 = Module.CERT;
    localTypeDispatcher.registerType((Module)localObject1, Section.CERT_MEDIA_ENCRYPT, MediaEncrypt.class);
    localTypeDispatcher.registerType((Module)localObject1, Section.CERT_SERVER_PORT, StreamService.class);
    localObject3 = Module.CLOUD_STATUS;
    localTypeDispatcher.registerType((Module)localObject3, Section.CLOUD_BIND, BindStatus.class);
    localTypeDispatcher.registerType((Module)localObject3, Section.CLOUD_UNBIND, BindStatus.class);
    localTypeDispatcher.registerType(Module.LENS_MASK, Section.LENS_MASK_INFO, LensMaskInfo.class);
    localObject2 = Module.CLOUD_CONFIG;
    localTypeDispatcher.registerType((Module)localObject2, Section.UPGRADE_STATUS, FirmwareUpdateStatus.class);
    localObject1 = Module.PLAYBACK;
    Object localObject4 = Section.PLAYBACK_MONTHLY;
    Object localObject5 = new a() {}.getType();
    j.d(localObject5, "object : TypeToken<List<…PlaybackItem>>>() {}.type");
    localTypeDispatcher.registerType((Module)localObject1, (Section)localObject4, (Type)localObject5);
    localObject5 = Section.PLAYBACK_DAILY;
    localObject4 = new a() {}.getType();
    j.d(localObject4, "object : TypeToken<List<…PlaybackItem>>>() {}.type");
    localTypeDispatcher.registerType((Module)localObject1, (Section)localObject5, (Type)localObject4);
    localObject5 = Section.PLAYBACK_SNAPSHOT_LIST;
    localObject4 = new a() {}.getType();
    j.d(localObject4, "object : TypeToken<List<…tPlaybackItem>>() {}.type");
    localTypeDispatcher.registerType((Module)localObject1, (Section)localObject5, (Type)localObject4);
    localObject1 = Module.IMAGE;
    localTypeDispatcher.registerType((Module)localObject1, Section.COMMON, Light.class);
    localTypeDispatcher.registerType((Module)localObject1, Section.IMAGE_SWITCH, ImageFlip.class);
    localTypeDispatcher.registerType(Module.TIMING_REBOOT, Section.REBOOT, RebootInfo.class);
    localTypeDispatcher.registerType(Module.NETWORK, Section.WAN, Wan.class);
    localTypeDispatcher.registerType(Module.RECORD_PLAN, Section.CHN1_CHANNEL, RecordPlanInfo.class);
    localTypeDispatcher.registerType((Module)localObject2, Section.NEW_FIRMWARE, NewFirmware.class);
    localObject4 = Module.MOTION_DETECTION;
    localTypeDispatcher.registerType((Module)localObject4, Section.MOTION_DET, MotionDetectConfig.class);
    localObject1 = Section.REGION_INFO;
    localObject5 = new a() {}.getType();
    j.d(localObject5, "object : TypeToken<List<…DetectRegion>>>() {}.type");
    localTypeDispatcher.registerType((Module)localObject4, (Section)localObject1, (Type)localObject5);
    localObject4 = Module.MOTOR;
    localTypeDispatcher.registerType((Module)localObject4, Section.MOVE, CloudTerraceMoveInfo.class);
    Object localObject6 = Module.PRESET;
    localTypeDispatcher.registerType((Module)localObject6, Section.SET_PRESET, CloudTerracePoint.class);
    localTypeDispatcher.registerType((Module)localObject6, Section.GOTO_PRESET, CloudTerraceResetInfo.class);
    localTypeDispatcher.registerType(Module.USER_MANAGEMENT, Section.THIRD_ACCOUNT, AccountInfo.class);
    Module localModule = Module.VIDEO;
    localObject5 = Section.VIDEO_MAIN;
    localTypeDispatcher.registerType(localModule, (Section)localObject5, VideoQuality.class);
    Section localSection = Section.VIDEO_MINOR;
    localTypeDispatcher.registerType(localModule, localSection, VideoQuality.class);
    localTypeDispatcher.registerType(localModule, Section.SET_RESOLUTION, Resolution.class);
    localModule = Module.VIDEO_CAPABILITY;
    localTypeDispatcher.registerType(localModule, (Section)localObject5, VideoCapability.class);
    localTypeDispatcher.registerType(localModule, localSection, VideoCapability.class);
    localTypeDispatcher.registerType((Module)localObject4, Section.MANUAL_CALI, String.class);
    localTypeDispatcher.registerType((Module)localObject6, Section.PRESET, MarkedPositionListInfo.class);
    localTypeDispatcher.registerType((Module)localObject3, Section.CLIENT_INFO, FirmwareUpdateInfo.class);
    localObject3 = Module.AUDIO_CONFIG;
    localTypeDispatcher.registerType((Module)localObject3, Section.MICROPHONE, MicroPhoneInfo.class);
    localTypeDispatcher.registerType((Module)localObject3, Section.SPEAKER, SpeakerInfo.class);
    localTypeDispatcher.registerType((Module)localObject3, Section.RECORD_AUDIO, RecordAudioInfo.class);
    localObject3 = Module.SYSTEM;
    localTypeDispatcher.registerType((Module)localObject3, Section.CLOCK_STATUS, ClockStatus.class);
    localTypeDispatcher.registerType((Module)localObject2, Section.UPGRADE_INFO, LatestFirmwareInfo.class);
    localTypeDispatcher.registerType((Module)localObject3, Section.LAST_ALARM_INFO, LastAlarmInfo.class);
    localTypeDispatcher.registerType((Module)localObject4, Section.CRUISE_STOP, String.class);
    localTypeDispatcher.registerType(Module.APP_COMPONENT, Section.APP_COMPONENT_LIST, CameraComponent.class);
    localObject2 = Module.COVER;
    localTypeDispatcher.registerType((Module)localObject2, Section.COVER, CoverConfig.class);
    localObject4 = new a() {}.getType();
    j.d(localObject4, "object : TypeToken<List<…ConfigRegion>>>() {}.type");
    localTypeDispatcher.registerType((Module)localObject2, (Section)localObject1, (Type)localObject4);
    localTypeDispatcher.registerType(Module.TARGET_TRACK, Section.TARGET_TRACK_INFO, TargetTrackInfo.class);
    localTypeDispatcher.registerType(Module.SOUND_DETECTION, Section.BABY_CRYING_DETECTION, BabyCryingDetectionInfo.class);
    localObject4 = Module.PEOPLE_DETECTION;
    localObject2 = Section.DETECTION;
    localTypeDispatcher.registerType((Module)localObject4, (Section)localObject2, HumanRecognitionInfo.class);
    localTypeDispatcher.registerType(Module.TAMPER_DETECTION, Section.TAMPER_DET, TamperDetectConfig.class);
    localObject5 = Module.INTRUSION_DETECTION;
    localTypeDispatcher.registerType((Module)localObject5, (Section)localObject2, DetectionInfo.class);
    localObject4 = Section.ARMING_SCHEDULE;
    localTypeDispatcher.registerType((Module)localObject5, (Section)localObject4, ArmScheduleInfo.class);
    localObject6 = new a() {}.getType();
    j.d(localObject6, "object : TypeToken<List<…ectionRegion>>>() {}.type");
    localTypeDispatcher.registerType((Module)localObject5, (Section)localObject1, (Type)localObject6);
    localObject5 = Module.LINE_CROSSING_DETECTION;
    localTypeDispatcher.registerType((Module)localObject5, (Section)localObject2, DetectionInfo.class);
    localTypeDispatcher.registerType((Module)localObject5, (Section)localObject4, ArmScheduleInfo.class);
    localObject2 = new a() {}.getType();
    j.d(localObject2, "object : TypeToken<List<…ectionRegion>>>() {}.type");
    localTypeDispatcher.registerType((Module)localObject5, (Section)localObject1, (Type)localObject2);
    localTypeDispatcher.registerType((Module)localObject3, Section.DST, DstInfo.class);
    localTypeDispatcher.registerType(Module.PLAYBACK, Section.PLAYBACK_SNAPSHOT_ENABLE, Boolean.TYPE);
    localTypeDispatcher.registerType(Module.IMAGE_CAPABILITY, Section.SUPPLEMENT_LAMP, NightVisionCapability.class);
    localTypeDispatcher.registerType((Module)localObject3, Section.RESET_WIFI_SUPPORTED, ResetSupportInfo.class);
    localTypeDispatcher.registerType(Module.AUTO_UPDATE, Section.COMMON, AutoUpdateInfo.class);
    localObject3 = Module.UPNPC;
    localTypeDispatcher.registerType((Module)localObject3, Section.UPNPC_INFO, UpnpInfo.class);
    localObject1 = Section.UPNP_STATUS;
    localObject2 = new a() {}.getType();
    j.d(localObject2, "object : TypeToken<List<UpnpStatus>>(){}.type");
    localTypeDispatcher.registerType((Module)localObject3, (Section)localObject1, (Type)localObject2);
    localTypeDispatcher.registerType((Module)localObject3, Section.PUB_IP, PubIp.class);
    localTypeDispatcher.registerType((Module)localObject3, Section.COMMUNICATE, UpnpCommStatus.class);
    localTypeDispatcher.registerType(Module.TAPO_CARE, Section.SERVICE_LIST, ServiceList.class);
  }
  
  private final void registerType(Module paramModule, Section paramSection, Type paramType)
  {
    registerType(paramModule.getValue(), paramSection.getValue(), paramType);
  }
  
  private final void registerType(String paramString1, String paramString2, Type paramType)
  {
    Map localMap1 = typeMap;
    Map localMap2 = (Map)localMap1.get(paramString1);
    Map localMap3 = localMap2;
    if (localMap2 == null)
    {
      localMap3 = b0.g(new Pair[] { n.a(paramString2, paramType) });
      localMap1.put(paramString1, localMap3);
    }
    localMap3.put(paramString2, paramType);
  }
  
  public final <T> T fromJson(i parami, Class<T> paramClass)
  {
    j.e(parami, "jsonElement");
    j.e(paramClass, "clazz");
    return (T)gson.g(parami, paramClass);
  }
  
  public final Type getRawType(String paramString1, String paramString2)
  {
    j.e(paramString1, "module");
    j.e(paramString2, "section");
    paramString1 = (Map)typeMap.get(paramString1);
    if (paramString1 != null)
    {
      paramString1 = (Type)paramString1.get(paramString2);
      if (paramString1 != null) {
        return paramString1;
      }
    }
    paramString1 = new a() {}.getType();
    j.d(paramString1, "object : TypeToken<Map<String, Any>>() {}.type");
    return paramString1;
  }
  
  public final boolean isValidModuleName(String paramString)
  {
    j.e(paramString, "module");
    return typeMap.containsKey(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\TypeDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */