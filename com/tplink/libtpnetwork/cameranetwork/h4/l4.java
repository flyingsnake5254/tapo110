package com.tplink.libtpnetwork.cameranetwork.h4;

import com.tplink.libtpnetwork.cameranetwork.model.Account;
import com.tplink.libtpnetwork.cameranetwork.model.AccountInfo;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmInfo;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmPlanInfo;
import com.tplink.libtpnetwork.cameranetwork.model.ArmScheduleInfo;
import com.tplink.libtpnetwork.cameranetwork.model.AutoUpdateInfo;
import com.tplink.libtpnetwork.cameranetwork.model.BabyCryingDetectionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.CloudTerraceCruiseInfo;
import com.tplink.libtpnetwork.cameranetwork.model.CloudTerraceId;
import com.tplink.libtpnetwork.cameranetwork.model.CloudTerraceMoveInfo;
import com.tplink.libtpnetwork.cameranetwork.model.CloudTerraceMoveStepInfo;
import com.tplink.libtpnetwork.cameranetwork.model.CloudTerracePoint;
import com.tplink.libtpnetwork.cameranetwork.model.CloudTerraceResetInfo;
import com.tplink.libtpnetwork.cameranetwork.model.ComponentType;
import com.tplink.libtpnetwork.cameranetwork.model.CoverConfig;
import com.tplink.libtpnetwork.cameranetwork.model.CoverConfigRegion;
import com.tplink.libtpnetwork.cameranetwork.model.DailyPlaybackFilter;
import com.tplink.libtpnetwork.cameranetwork.model.DailyPlaybackUtcFilter;
import com.tplink.libtpnetwork.cameranetwork.model.DetectionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.DiskInfo;
import com.tplink.libtpnetwork.cameranetwork.model.HardDiskLoop;
import com.tplink.libtpnetwork.cameranetwork.model.HumanRecognitionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.ImageFlip;
import com.tplink.libtpnetwork.cameranetwork.model.IntrusionDetectionRegion;
import com.tplink.libtpnetwork.cameranetwork.model.LedStatus;
import com.tplink.libtpnetwork.cameranetwork.model.LensMaskInfo;
import com.tplink.libtpnetwork.cameranetwork.model.Light;
import com.tplink.libtpnetwork.cameranetwork.model.LineCrossingDetectionRegion;
import com.tplink.libtpnetwork.cameranetwork.model.MediaEncrypt;
import com.tplink.libtpnetwork.cameranetwork.model.Method;
import com.tplink.libtpnetwork.cameranetwork.model.MicroPhoneInfo;
import com.tplink.libtpnetwork.cameranetwork.model.Model;
import com.tplink.libtpnetwork.cameranetwork.model.Module;
import com.tplink.libtpnetwork.cameranetwork.model.MotionDetectConfig;
import com.tplink.libtpnetwork.cameranetwork.model.MotionDetectRegion;
import com.tplink.libtpnetwork.cameranetwork.model.MsgPushInfo;
import com.tplink.libtpnetwork.cameranetwork.model.MsgPushPlanInfo;
import com.tplink.libtpnetwork.cameranetwork.model.MultipleRequest;
import com.tplink.libtpnetwork.cameranetwork.model.NightMode;
import com.tplink.libtpnetwork.cameranetwork.model.NightVisionMode;
import com.tplink.libtpnetwork.cameranetwork.model.OsdElement;
import com.tplink.libtpnetwork.cameranetwork.model.OsdFont;
import com.tplink.libtpnetwork.cameranetwork.model.RebootInfo;
import com.tplink.libtpnetwork.cameranetwork.model.RecordAudioInfo;
import com.tplink.libtpnetwork.cameranetwork.model.RecordPlanInfo;
import com.tplink.libtpnetwork.cameranetwork.model.Request;
import com.tplink.libtpnetwork.cameranetwork.model.Resolution;
import com.tplink.libtpnetwork.cameranetwork.model.ResolutionType;
import com.tplink.libtpnetwork.cameranetwork.model.Section;
import com.tplink.libtpnetwork.cameranetwork.model.SnapshotPlaybackFilter;
import com.tplink.libtpnetwork.cameranetwork.model.SpeakerInfo;
import com.tplink.libtpnetwork.cameranetwork.model.SystemInfo;
import com.tplink.libtpnetwork.cameranetwork.model.TamperDetectConfig;
import com.tplink.libtpnetwork.cameranetwork.model.TargetTrackInfo;
import com.tplink.libtpnetwork.cameranetwork.model.Timezone;
import com.tplink.libtpnetwork.cameranetwork.model.UpnpCommStatus;
import com.tplink.libtpnetwork.cameranetwork.model.UpnpInfo;
import com.tplink.libtpnetwork.cameranetwork.model.WhiteLampConfig;
import com.tplink.libtpnetwork.cameranetwork.model.WhitelampState;
import com.tplink.libtpnetwork.cameranetwork.model.Wifi;
import com.tplink.libtpnetwork.cameranetwork.model.Wrapper;
import com.tplink.libtpnetwork.cameranetwork.model.Wrappers;
import com.tplink.libtpnetwork.cameranetwork.model.YearlyPlaybackFilter;
import com.tplink.libtpnetwork.cameranetwork.util.j;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class l4
{
  private final SimpleDateFormat a = new SimpleDateFormat("yyyyMMdd", Locale.US);
  
  private <T> Request<Wrappers> E(Method paramMethod, Module paramModule, Section paramSection, T paramT)
  {
    return new Request(paramMethod, F(new Wrapper(paramModule, paramSection, paramT)));
  }
  
  private <T> Wrappers F(Wrapper<T> paramWrapper)
  {
    return new Wrappers(Collections.singletonList(paramWrapper));
  }
  
  private Request<MultipleRequest> O0(Request<Wrapper> paramRequest)
  {
    return P0(new Request(paramRequest.getMethod(), new Wrappers(Collections.singletonList((Wrapper)paramRequest.getParams()))));
  }
  
  private Request<MultipleRequest> P0(Request<Wrappers> paramRequest)
  {
    return Q0(Collections.singletonList(paramRequest));
  }
  
  private Request<Wrappers> a(List<MotionDetectRegion> paramList)
  {
    paramList = Model.wrapper(paramList, Module.MOTION_DETECTION, Section.MOTION_DETECTION_ADD_REGION, "region_info");
    return new Request(Method.ADD_DETECTION_REGION, F(paramList));
  }
  
  private Request<Wrappers> a1(CoverConfig paramCoverConfig)
  {
    return E(Method.SET_COVER_CONFIG, Module.COVER, Section.COVER, paramCoverConfig);
  }
  
  private Request<Wrappers> b()
  {
    return E(Method.GET_BCD_CONFIG, Module.SOUND_DETECTION, Section.NAME, Section.BABY_CRYING_DETECTION.getValue());
  }
  
  private Request<Wrappers> d()
  {
    return E(Method.GET_PERSON_DETECTION_CONFIG, Module.PEOPLE_DETECTION, Section.NAME, Section.DETECTION.getValue());
  }
  
  private Request<Wrappers> f(AlarmInfo paramAlarmInfo)
  {
    return E(Method.SET_ALERT_CONFIG, Module.MSG_ALARM, Section.ALERT_INFO, paramAlarmInfo);
  }
  
  private Request<Wrappers> g(AlarmPlanInfo paramAlarmPlanInfo)
  {
    return E(Method.SET_ALERT_PLAN, Module.MSG_ALARM_PLAN, Section.MSG_ALARM_PLAN, paramAlarmPlanInfo);
  }
  
  private Request<Wrappers> h(boolean paramBoolean, String paramString)
  {
    return E(Method.SET_BCD_CONFIG, Module.SOUND_DETECTION, Section.BABY_CRYING_DETECTION, new BabyCryingDetectionInfo(paramBoolean, paramString));
  }
  
  private Request<Wrappers> i(boolean paramBoolean)
  {
    return E(Method.SET_PERSON_DETECTION_CONFIG, Module.PEOPLE_DETECTION, Section.DETECTION, new HumanRecognitionInfo(paramBoolean));
  }
  
  private Request<Wrappers> j(MotionDetectConfig paramMotionDetectConfig)
  {
    return E(Method.SET_DETECTION_CONFIG, Module.MOTION_DETECTION, Section.MOTION_DET, paramMotionDetectConfig);
  }
  
  private Request<Wrappers> k(List<CoverConfigRegion> paramList)
  {
    paramList = Model.wrapper(paramList, Module.COVER, Section.COVER_CONFIG_ADD_REGION, Section.REGION_INFO.getValue());
    return new Request(Method.ADD_COVER_REGION, F(paramList));
  }
  
  @SafeVarargs
  private final Request<MultipleRequest> u(Request<Wrappers>... paramVarArgs)
  {
    return Q0(Arrays.asList(paramVarArgs));
  }
  
  public Request<MultipleRequest> A(int paramInt)
  {
    Wrapper localWrapper = new Wrapper(Module.PRESET, Section.GOTO_PRESET, new CloudTerraceId(String.valueOf(paramInt)));
    return O0(new Request(Method.MOTOR_MOVE_TO_PRESET, localWrapper));
  }
  
  public Request<MultipleRequest> A0(CameraComponent paramCameraComponent)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    if (paramCameraComponent.hasComponent(ComponentType.SD_CARD))
    {
      localObject1 = Module.HARD_DISK_MANAGE;
      localObject2 = new Wrapper((Module)localObject1, Section.NAME, Collections.singletonList(Section.HARD_DISK_LOOP.getValue()));
      localObject1 = new Wrapper((Module)localObject1, Section.TABLE, Collections.singletonList(Section.HARD_DISK_INFO.getValue()));
      localArrayList.add(new Request(Method.GET_CIRCULAR_RECORDING_CONFIG, F((Wrapper)localObject2)));
      localArrayList.add(new Request(Method.GET_SD_CARD_STATUS, F((Wrapper)localObject1)));
    }
    if (paramCameraComponent.hasComponent(ComponentType.LED))
    {
      localObject2 = new Wrapper(Module.LED, Section.NAME, Collections.singletonList(Section.CONFIG.getValue()));
      localArrayList.add(new Request(Method.GET_LED_STATUS, F((Wrapper)localObject2)));
    }
    if (paramCameraComponent.hasComponent(ComponentType.TIME_ZONE))
    {
      localObject2 = new Wrapper(Module.SYSTEM, Section.NAME, Collections.singletonList(Section.BASIC.getValue()));
      localArrayList.add(new Request(Method.GET_TIMEZONE, F((Wrapper)localObject2)));
    }
    Object localObject2 = ComponentType.SYSTEM;
    if ((paramCameraComponent.hasComponent((ComponentType)localObject2)) || (paramCameraComponent.isSupportNightVision()))
    {
      localObject1 = new Wrapper(Module.IMAGE, Section.NAME, Collections.singletonList(Section.IMAGE_SWITCH.getValue()));
      localArrayList.add(new Request(Method.GET_ROTATION_STATUS, F((Wrapper)localObject1)));
    }
    if (paramCameraComponent.hasComponent((ComponentType)localObject2))
    {
      localObject2 = Module.TIMING_REBOOT;
      localObject1 = Section.NAME;
      localObject2 = new Wrapper((Module)localObject2, (Section)localObject1, Collections.singletonList(Section.REBOOT.getValue()));
      localObject1 = new Wrapper(Module.DEVICE_INFO, (Section)localObject1, Collections.singletonList(Section.BASIC_INFO.getValue()));
      localArrayList.add(new Request(Method.GET_REBOOT, F((Wrapper)localObject2)));
      localArrayList.add(new Request(Method.GET_DEVICE_INFO, F((Wrapper)localObject1)));
    }
    localObject2 = ComponentType.VIDEO;
    if ((paramCameraComponent.hasComponent((ComponentType)localObject2)) && (paramCameraComponent.getComponent((ComponentType)localObject2) >= 2))
    {
      Object localObject3 = Module.VIDEO;
      localObject2 = Section.NAME;
      localObject1 = Section.VIDEO_MAIN;
      localObject3 = new Wrapper((Module)localObject3, (Section)localObject2, Collections.singletonList(((Section)localObject1).getValue()));
      localArrayList.add(new Request(Method.GET_VIDEO_QUALITIES, F((Wrapper)localObject3)));
      localObject2 = new Wrapper(Module.VIDEO_CAPABILITY, (Section)localObject2, Collections.singletonList(((Section)localObject1).getValue()));
      localArrayList.add(new Request(Method.GET_VIDEO_CAPABILITY, F((Wrapper)localObject2)));
    }
    if (paramCameraComponent.isSupportSubscriptionService())
    {
      paramCameraComponent = new Wrapper(Module.TAPO_CARE, Section.NAME, Collections.singletonList(Section.SERVICE_LIST.getValue()));
      localArrayList.add(new Request(Method.GET_TAPO_CARE_SERVICE_LIST, F(paramCameraComponent)));
    }
    return Q0(localArrayList);
  }
  
  public Request<MultipleRequest> A1(boolean paramBoolean)
  {
    if (paramBoolean) {
      localObject = "on";
    } else {
      localObject = "off";
    }
    Object localObject = new OsdElement("0", "9150", null, (String)localObject);
    localObject = new Wrapper(Module.OSD, Section.OSD_LOGO, localObject);
    return P0(new Request(Method.SET_OSD, new Wrappers(Collections.singletonList(localObject))));
  }
  
  public Request<MultipleRequest> B()
  {
    Wrapper localWrapper = new Wrapper(Module.MOTOR, Section.MANUAL_CALI, Section.EMPTY.getValue());
    return O0(new Request(Method.MANUAL_CALIBRATE, localWrapper));
  }
  
  public Request<MultipleRequest> B0(CameraComponent paramCameraComponent)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = Module.LENS_MASK;
    Object localObject2 = Section.NAME;
    localObject1 = new Wrapper((Module)localObject1, (Section)localObject2, Collections.singletonList(Section.LENS_MASK_INFO.getValue()));
    localArrayList.add(new Request(Method.GET_LENS_MASK_CONFIG, F((Wrapper)localObject1)));
    Object localObject3 = Module.MOTION_DETECTION;
    localObject1 = new Wrapper((Module)localObject3, (Section)localObject2, Collections.singletonList(Section.MOTION_DET.getValue()));
    localObject3 = new Wrapper((Module)localObject3, Section.TABLE, Collections.singletonList(Section.REGION_INFO.getValue()));
    localArrayList.add(new Request(Method.GET_DETECTION_CONFIG, new Wrappers(Arrays.asList(new Wrapper[] { localObject1, localObject3 }))));
    localObject1 = new Wrapper(Module.MSG_ALARM, (Section)localObject2, Collections.singletonList(Section.MSG_ALARM_INFO.getValue()));
    localArrayList.add(new Request(Method.GET_ALERT_CONFIG, F((Wrapper)localObject1)));
    if (paramCameraComponent.isSupportLineCrossingDetection())
    {
      localObject1 = new Wrapper(Module.LINE_CROSSING_DETECTION, (Section)localObject2, Arrays.asList(new String[] { Section.DETECTION.getValue(), Section.ARMING_SCHEDULE.getValue() }));
      localArrayList.add(new Request(Method.GET_LINE_CROSSING_DETECTION_CONFIG, F((Wrapper)localObject1)));
    }
    if (paramCameraComponent.isSupportIntrusionDetection())
    {
      localObject1 = new Wrapper(Module.INTRUSION_DETECTION, (Section)localObject2, Arrays.asList(new String[] { Section.DETECTION.getValue(), Section.ARMING_SCHEDULE.getValue() }));
      localArrayList.add(new Request(Method.GET_INTRUSION_DETECTION_CONFIG, F((Wrapper)localObject1)));
    }
    if (paramCameraComponent.isSupportTamperDetection())
    {
      localObject1 = new Wrapper(Module.TAMPER_DETECTION, (Section)localObject2, Collections.singletonList(Section.TAMPER_DET.getValue()));
      localArrayList.add(new Request(Method.GET_TAMPER_DETECTION_CONFIG, F((Wrapper)localObject1)));
    }
    if (paramCameraComponent.isSupportNightVision())
    {
      localObject1 = new Wrapper(Module.IMAGE_CAPABILITY, (Section)localObject2, Collections.singletonList(Section.SUPPLEMENT_LAMP.getValue()));
      localArrayList.add(new Request(Method.GET_NIGHT_VISION_CAPABILITY, F((Wrapper)localObject1)));
    }
    localObject2 = new Wrapper(Module.RECORD_PLAN, (Section)localObject2, Collections.singletonList(Section.CHN1_CHANNEL.getValue()));
    localArrayList.add(new Request(Method.GET_RECORD_PLAN, F((Wrapper)localObject2)));
    if (paramCameraComponent.isSupportBabyCry()) {
      localArrayList.add(b());
    }
    if (paramCameraComponent.isSupportPersonDetection()) {
      localArrayList.add(d());
    }
    return Q0(localArrayList);
  }
  
  public Request<MultipleRequest> B1(RebootInfo paramRebootInfo)
  {
    paramRebootInfo = new Wrapper(Module.TIMING_REBOOT, Section.REBOOT, paramRebootInfo);
    return O0(new Request(Method.SET_REBOOT, paramRebootInfo));
  }
  
  public Request<MultipleRequest> C(CloudTerraceResetInfo paramCloudTerraceResetInfo)
  {
    paramCloudTerraceResetInfo = new Wrapper(Module.PRESET, Section.REMOVE_PRESET, paramCloudTerraceResetInfo);
    return O0(new Request(Method.DELETE_PRESET, paramCloudTerraceResetInfo));
  }
  
  public Request<MultipleRequest> C0(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    Wrapper localWrapper = new Wrapper(Module.PLAYBACK, Section.PLAYBACK_SNAPSHOT_LIST, new SnapshotPlaybackFilter(paramLong1, paramLong2, paramInt1, paramInt2));
    return O0(new Request(Method.SEARCH_SEARCH_SNAPSHOT, localWrapper));
  }
  
  public Request<MultipleRequest> C1(boolean paramBoolean)
  {
    Module localModule = Module.AUDIO_CONFIG;
    Section localSection = Section.RECORD_AUDIO;
    if (paramBoolean) {
      localObject = "on";
    } else {
      localObject = "off";
    }
    Object localObject = new Wrapper(localModule, localSection, new RecordAudioInfo((String)localObject));
    return O0(new Request(Method.SET_RECORD_AUDIO, localObject));
  }
  
  public Request<MultipleRequest> D()
  {
    Wrapper localWrapper = new Wrapper(Module.HARD_DISK_MANAGE, Section.HARD_DISK_FORMAT, "1");
    return O0(new Request(Method.FORMAT_SD_CARD, localWrapper));
  }
  
  public Request<MultipleRequest> D0()
  {
    Wrapper localWrapper = new Wrapper(Module.TAMPER_DETECTION, Section.NAME, Collections.singletonList(Section.TAMPER_DET.getValue()));
    return O0(new Request(Method.GET_TAMPER_DETECTION_CONFIG, localWrapper));
  }
  
  public Request<MultipleRequest> D1(RecordPlanInfo paramRecordPlanInfo)
  {
    paramRecordPlanInfo = new Wrapper(Module.RECORD_PLAN, Section.CHN1_CHANNEL, paramRecordPlanInfo);
    return O0(new Request(Method.SET_RECORD_PLAN, paramRecordPlanInfo));
  }
  
  public Request<MultipleRequest> E0()
  {
    Wrapper localWrapper = new Wrapper(Module.TARGET_TRACK, Section.NAME, Section.TARGET_TRACK_INFO.getValue());
    return O0(new Request(Method.GET_TARGET_TRACK_CONFIG, localWrapper));
  }
  
  public Request<MultipleRequest> E1(ResolutionType paramResolutionType)
  {
    paramResolutionType = new Wrapper(Module.VIDEO, Section.SET_RESOLUTION, new Resolution(paramResolutionType));
    return O0(new Request(Method.SET_RESOLUTION, paramResolutionType));
  }
  
  public Request<MultipleRequest> F0()
  {
    Wrapper localWrapper = new Wrapper(Module.USER_MANAGEMENT, Section.NAME, Collections.singletonList(Section.THIRD_ACCOUNT.getValue()));
    return O0(new Request(Method.GET_THIRD_ACCOUNT, localWrapper));
  }
  
  public Request<MultipleRequest> F1(SpeakerInfo paramSpeakerInfo)
  {
    paramSpeakerInfo = new Wrapper(Module.AUDIO_CONFIG, Section.SPEAKER, paramSpeakerInfo);
    return O0(new Request(Method.SET_SPEAKER_VOLUME, paramSpeakerInfo));
  }
  
  public Request<MultipleRequest> G()
  {
    Wrapper localWrapper = new Wrapper(Module.CERT, Section.GET_AES_KEY, Collections.emptyMap());
    return O0(new Request(Method.GET_AES_ENCRYPT_KEY, localWrapper));
  }
  
  public Request<MultipleRequest> G0()
  {
    Wrapper localWrapper = new Wrapper(Module.SYSTEM, Section.NAME, Collections.singletonList(Section.BASIC.getValue()));
    return O0(new Request(Method.GET_TIMEZONE, localWrapper));
  }
  
  public Request<MultipleRequest> G1(TamperDetectConfig paramTamperDetectConfig)
  {
    paramTamperDetectConfig = new Wrapper(Module.TAMPER_DETECTION, Section.TAMPER_DET, paramTamperDetectConfig);
    return O0(new Request(Method.SET_TAMPER_DETECTION_CONFIG, paramTamperDetectConfig));
  }
  
  public Request<MultipleRequest> H()
  {
    Wrapper localWrapper = new Wrapper(Module.MSG_ALARM_PLAN, Section.NAME, Collections.singletonList(Section.MSG_ALARM_PLAN.getValue()));
    return O0(new Request(Method.GET_ALERT_PLAN, localWrapper));
  }
  
  public Request<MultipleRequest> H0()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(E(Method.GET_UPNP_INFO, Module.UPNPC, Section.NAME, Section.UPNPC_INFO.getValue()));
    return Q0(localArrayList);
  }
  
  public Request<MultipleRequest> H1(boolean paramBoolean)
  {
    Wrapper localWrapper = new Wrapper(Module.TARGET_TRACK, Section.TARGET_TRACK_INFO, new TargetTrackInfo(paramBoolean));
    return O0(new Request(Method.SET_TARGET_TRACK_CONFIG, localWrapper));
  }
  
  public Request<MultipleRequest> I()
  {
    Wrapper localWrapper = new Wrapper(Module.MSG_ALARM, Section.NAME, Collections.singletonList(Section.MSG_ALARM_INFO.getValue()));
    return O0(new Request(Method.GET_ALERT_CONFIG, localWrapper));
  }
  
  public Request<MultipleRequest> I0()
  {
    Object localObject1 = Module.UPNPC;
    Object localObject2 = Section.NAME;
    Wrapper localWrapper1 = new Wrapper((Module)localObject1, (Section)localObject2, Collections.singletonList(Section.UPNPC_INFO.getValue()));
    Wrapper localWrapper2 = new Wrapper((Module)localObject1, Section.TABLE, Collections.singletonList(Section.UPNP_STATUS.getValue()));
    Wrapper localWrapper3 = new Wrapper((Module)localObject1, (Section)localObject2, Collections.singletonList(Section.PUB_IP.getValue()));
    localObject2 = new Wrapper((Module)localObject1, (Section)localObject2, Collections.singletonList(Section.COMMUNICATE.getValue()));
    Wrapper localWrapper4 = new Wrapper(Module.CERT, Section.GET_HTTPS_PSK, Collections.singletonList(Section.EMPTY.getValue()));
    localObject1 = new ArrayList();
    ((List)localObject1).add(new Request(Method.GET_UPNP_INFO, F(localWrapper1)));
    ((List)localObject1).add(new Request(Method.GET_UPNP_STATUS, F(localWrapper2)));
    ((List)localObject1).add(new Request(Method.GET_PUB_IP, F(localWrapper3)));
    ((List)localObject1).add(new Request(Method.GET_UPNP_COMM_STATUS, F((Wrapper)localObject2)));
    ((List)localObject1).add(new Request(Method.GET_UPNP_PSK, F(localWrapper4)));
    return Q0((List)localObject1);
  }
  
  public Request<MultipleRequest> I1(String paramString1, String paramString2)
  {
    paramString1 = new Wrapper(Module.SYSTEM, Section.BASIC, new Timezone(paramString1, paramString2));
    return O0(new Request(Method.SET_TIMEZONE, paramString1));
  }
  
  public Request<MultipleRequest> J()
  {
    Wrapper localWrapper = new Wrapper(Module.AUDIO_CONFIG, Section.NAME, new String[] { Section.SPEAKER.getValue(), Section.MICROPHONE.getValue() });
    return O0(new Request(Method.GET_AUDIO_CONFIG, localWrapper));
  }
  
  public Request<MultipleRequest> J0()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(E(Method.GET_UPNP_PSK, Module.CERT, Section.GET_HTTPS_PSK, Section.EMPTY.getValue()));
    return Q0(localArrayList);
  }
  
  public Request<MultipleRequest> J1(UpnpCommStatus paramUpnpCommStatus)
  {
    paramUpnpCommStatus = new Wrapper(Module.UPNPC, Section.COMMUNICATE, paramUpnpCommStatus);
    return O0(new Request(Method.SET_UPNP_COMM_STATUS, paramUpnpCommStatus));
  }
  
  public Request<MultipleRequest> K()
  {
    Wrapper localWrapper = new Wrapper(Module.AUTO_UPDATE, Section.NAME, Collections.singletonList(Section.COMMON.getValue()));
    return O0(new Request(Method.GET_FIRMWARE_AUTO_UPGRADE_CONFIG, localWrapper));
  }
  
  public Request<MultipleRequest> K0()
  {
    Wrapper localWrapper = new Wrapper(Module.SYSTEM, Section.USER_ID, Section.EMPTY.getValue());
    return O0(new Request(Method.GET_USER_ID, localWrapper));
  }
  
  public Request<MultipleRequest> K1(UpnpInfo paramUpnpInfo)
  {
    paramUpnpInfo = new Wrapper(Module.UPNPC, Section.UPNPC_INFO, paramUpnpInfo);
    return O0(new Request(Method.SET_UPNP_INFO, paramUpnpInfo));
  }
  
  public Request<MultipleRequest> L()
  {
    ArrayList localArrayList = new ArrayList();
    Method localMethod = Method.GET_CLOCK_STATUS;
    Module localModule = Module.SYSTEM;
    Section localSection = Section.NAME;
    localArrayList.add(E(localMethod, localModule, localSection, Section.CLOCK_STATUS.getValue()));
    localArrayList.add(E(Method.GET_TIMEZONE, localModule, localSection, Section.BASIC.getValue()));
    localArrayList.add(E(Method.GET_DST_RULE, localModule, localSection, Section.DST.getValue()));
    return Q0(localArrayList);
  }
  
  public Request<MultipleRequest> L0()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(E(Method.GET_WHITE_LAMP_CONFIG, Module.IMAGE, Section.NAME, Section.SWITCH.getValue()));
    return Q0(localArrayList);
  }
  
  public Request<MultipleRequest> L1(WhiteLampConfig paramWhiteLampConfig)
  {
    paramWhiteLampConfig = new Wrapper(Module.IMAGE, Section.SWITCH, paramWhiteLampConfig);
    return O0(new Request(Method.SET_WHITE_LAMP_CONFIG, paramWhiteLampConfig));
  }
  
  public Request<MultipleRequest> M()
  {
    ArrayList localArrayList = new ArrayList();
    Method localMethod = Method.GET_CLOCK_STATUS;
    Module localModule = Module.SYSTEM;
    Section localSection = Section.NAME;
    localArrayList.add(E(localMethod, localModule, localSection, Section.CLOCK_STATUS.getValue()));
    localArrayList.add(E(Method.GET_TIMEZONE, localModule, localSection, Section.BASIC.getValue()));
    return Q0(localArrayList);
  }
  
  public Request<MultipleRequest> M0(Date paramDate1, Date paramDate2)
  {
    paramDate1 = new Wrapper(Module.PLAYBACK, Section.PLAYBACK_DATE_FILTER, new YearlyPlaybackFilter(this.a.format(paramDate1), this.a.format(paramDate2)));
    return O0(new Request(Method.SEARCH_DATE_WITH_VIDEO, paramDate1));
  }
  
  public Request<MultipleRequest> M1(Account paramAccount, String paramString1, String paramString2, String paramString3, RecordPlanInfo paramRecordPlanInfo)
  {
    paramAccount = paramAccount.copy(paramAccount.getUsername(), paramAccount.getPassword(), false);
    paramAccount = new AccountInfo(new Account("admin", j.a(paramString1), false), paramAccount.getPassword());
    paramAccount = new Wrapper(Module.USER_MANAGEMENT, Section.CHANGE_ADMIN_PASSWORD, paramAccount);
    paramAccount = new Request(Method.CHANGE_ADMIN_PASSWORD, F(paramAccount));
    paramString1 = new Wrapper(Module.CERT, Section.CERT_MEDIA_ENCRYPT, new MediaEncrypt("on"));
    paramString1 = new Request(Method.SET_OSD, F(paramString1));
    paramString2 = new Wrapper(Module.SYSTEM, Section.BASIC, new Timezone(paramString2, paramString3));
    paramString2 = new Request(Method.SET_TIMEZONE, F(paramString2));
    paramString3 = new Wrapper(Module.RECORD_PLAN, Section.CHN1_CHANNEL, paramRecordPlanInfo);
    return Q0(Arrays.asList(new Request[] { paramAccount, paramString1, paramString2, new Request(Method.SET_RECORD_PLAN, F(paramString3)) }));
  }
  
  public Request<MultipleRequest> N()
  {
    Wrapper localWrapper = new Wrapper(Module.PRESET, Section.NAME, new String[] { Section.PRESET.getValue() });
    return O0(new Request(Method.GET_PRESET_CONFIG, localWrapper));
  }
  
  public Request<Account> N0(Account paramAccount)
  {
    Account localAccount = paramAccount;
    if (!paramAccount.getHashed()) {
      localAccount = Model.passwordDigest(paramAccount);
    }
    return new Request(Method.LOGIN, localAccount);
  }
  
  public Request<MultipleRequest> N1(Account paramAccount, String paramString1, String paramString2, RecordPlanInfo paramRecordPlanInfo)
  {
    Account localAccount = paramAccount.copy(paramAccount.getUsername(), paramAccount.getPassword(), false);
    paramAccount = new ArrayList();
    Object localObject = new Wrapper(Module.CLOUD_CONFIG, Section.CLOUD_BIND, localAccount);
    paramAccount.add(new Request(Method.BIND_TO_CLOUD, new Wrappers(Collections.singletonList(localObject))));
    localObject = new AccountInfo(new Account("admin", "admin", false), localAccount.getPassword());
    localObject = new Wrapper(Module.USER_MANAGEMENT, Section.CHANGE_ADMIN_PASSWORD, localObject);
    paramAccount.add(new Request(Method.CHANGE_ADMIN_PASSWORD, F((Wrapper)localObject)));
    localObject = new Wrapper(Module.CERT, Section.CERT_MEDIA_ENCRYPT, new MediaEncrypt("on"));
    paramAccount.add(new Request(Method.SET_OSD, F((Wrapper)localObject)));
    if ((paramString1 != null) && (paramString2 != null))
    {
      paramString1 = new Wrapper(Module.SYSTEM, Section.BASIC, new Timezone(paramString1, paramString2));
      paramAccount.add(new Request(Method.SET_TIMEZONE, F(paramString1)));
    }
    if (paramRecordPlanInfo != null)
    {
      paramString1 = new Wrapper(Module.RECORD_PLAN, Section.CHN1_CHANNEL, paramRecordPlanInfo);
      paramAccount.add(new Request(Method.SET_RECORD_PLAN, F(paramString1)));
    }
    return Q0(paramAccount);
  }
  
  public Request<MultipleRequest> O()
  {
    Wrapper localWrapper = new Wrapper(Module.APP_COMPONENT, Section.NAME, Section.APP_COMPONENT_LIST.getValue());
    return O0(new Request(Method.GET_APP_COMPONENT_LIST, localWrapper));
  }
  
  public Request<MultipleRequest> O1()
  {
    Wrapper localWrapper = new Wrapper(Module.SYSTEM, Section.SOFT_RESET, Collections.emptyMap());
    return O0(new Request(Method.SOFT_RESET, localWrapper));
  }
  
  public Request<Wrapper> P()
  {
    Wrapper localWrapper = new Wrapper(Module.ON_BOARDING, Section.GET_CONNECT_STATUS, Collections.emptyMap());
    return new Request(Method.GET_CONNECT_STATUS, localWrapper);
  }
  
  public Request<MultipleRequest> P1()
  {
    Wrapper localWrapper = new Wrapper(Module.CLOUD_CONFIG, Section.FIRMWARE_DOWNLOAD, Section.EMPTY.getValue());
    return O0(new Request(Method.START_FIRMWARE_UPGRADE, localWrapper));
  }
  
  public Request<MultipleRequest> Q()
  {
    Object localObject = Module.COVER;
    Wrapper localWrapper = new Wrapper((Module)localObject, Section.NAME, Collections.singletonList(Section.COVER.getValue()));
    localObject = new Wrapper((Module)localObject, Section.TABLE, Collections.singletonList(Section.REGION_INFO.getValue()));
    return P0(new Request(Method.GET_COVER_CONFIG, new Wrappers(Arrays.asList(new Wrapper[] { localWrapper, localObject }))));
  }
  
  public Request<MultipleRequest> Q0(List<Request<Wrappers>> paramList)
  {
    return new Request(Method.MULTIPLE_REQUEST, new MultipleRequest(paramList));
  }
  
  public Request<MultipleRequest> Q1()
  {
    Wrapper localWrapper = new Wrapper(Module.MOTOR, Section.CRUISE_STOP, Section.EMPTY.getValue());
    return O0(new Request(Method.CRUISE_STOP, localWrapper));
  }
  
  public Request<MultipleRequest> R(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    paramString = new Wrapper(Module.PLAYBACK, Section.PLAYBACK_TIME_FILTER, new DailyPlaybackFilter(paramInt1, paramString, paramInt2, paramInt3));
    return O0(new Request(Method.SEARCH_VIDEO_OF_DAY, paramString));
  }
  
  public Request<MultipleRequest> R0()
  {
    Wrapper localWrapper = new Wrapper(Module.SYSTEM, Section.REBOOT, Collections.emptyMap());
    return O0(new Request(Method.REBOOT_DEVICE, localWrapper));
  }
  
  public Request<MultipleRequest> R1()
  {
    Wrapper localWrapper = new Wrapper(Module.MOTOR, Section.STOP, Section.EMPTY.getValue());
    return O0(new Request(Method.STOP_MOVE, localWrapper));
  }
  
  public Request<MultipleRequest> S(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3)
  {
    Wrapper localWrapper = new Wrapper(Module.PLAYBACK, Section.PLAYBACK_TIME_FILTER_UTC, new DailyPlaybackUtcFilter(paramInt1, paramLong1, paramLong2, paramInt2, paramInt3));
    return O0(new Request(Method.SEARCH_VIDEO_WITH_UTC, localWrapper));
  }
  
  public Request<MultipleRequest> S0()
  {
    Wrapper localWrapper = new Wrapper(Module.SYSTEM, Section.RESET, Collections.emptyMap());
    return O0(new Request(Method.RESET, localWrapper));
  }
  
  public Request<MultipleRequest> S1(String paramString1, String paramString2)
  {
    paramString1 = new AccountInfo(paramString1, paramString2);
    paramString1 = new Wrapper(Module.USER_MANAGEMENT, Section.VERIFY_THIRD_ACCOUNT, paramString1);
    return O0(new Request(Method.VERIFY_THIRD_ACCOUNT, paramString1));
  }
  
  public Request<MultipleRequest> T(CameraComponent paramCameraComponent)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = Module.MSG_ALARM;
    Section localSection = Section.NAME;
    localObject = new Wrapper((Module)localObject, localSection, Collections.singletonList(Section.MSG_ALARM_INFO.getValue()));
    localArrayList.add(new Request(Method.GET_ALERT_CONFIG, F((Wrapper)localObject)));
    if (paramCameraComponent.isSupportMsgPush())
    {
      localObject = new Wrapper(Module.MSG_PUSH, localSection, Collections.singletonList(Section.MSG_PUSH_INFO.getValue()));
      localArrayList.add(new Request(Method.GET_MSG_PUSH_CONFIG, F((Wrapper)localObject)));
    }
    if (paramCameraComponent.isSupportPersonDetection()) {
      localArrayList.add(d());
    }
    if (paramCameraComponent.isSupportBabyCry()) {
      localArrayList.add(b());
    }
    if (paramCameraComponent.hasComponent(ComponentType.TARGET_TRACK))
    {
      paramCameraComponent = new Wrapper(Module.TARGET_TRACK, localSection, Collections.singletonList(Section.TARGET_TRACK_INFO.getValue()));
      localArrayList.add(new Request(Method.GET_TARGET_TRACK_CONFIG, F(paramCameraComponent)));
    }
    return Q0(localArrayList);
  }
  
  public Request<MultipleRequest> T0()
  {
    Wrapper localWrapper = new Wrapper(Module.SYSTEM, Section.RESET_CONFIG_ONLY, Collections.emptyMap());
    return O0(new Request(Method.RESET_CONFIG_ONLY, localWrapper));
  }
  
  public Request<MultipleRequest> U()
  {
    Wrapper localWrapper = new Wrapper(Module.DEVICE_INFO, Section.NAME, Collections.singletonList(Section.BASIC_INFO.getValue()));
    return O0(new Request(Method.GET_DEVICE_INFO, localWrapper));
  }
  
  public Request<Wrapper> U0()
  {
    Wrapper localWrapper = new Wrapper(Module.ON_BOARDING, Section.SCAN, Collections.emptyMap());
    return new Request(Method.SCAN_WIFI_LIST, localWrapper);
  }
  
  public Request<MultipleRequest> V()
  {
    Wrapper localWrapper = new Wrapper(Module.SYSTEM, Section.NAME, Section.SYS.getValue());
    return O0(new Request(Method.GET_DIAGNOSE_MODE, localWrapper));
  }
  
  public Request<MultipleRequest> V0(AlarmInfo paramAlarmInfo)
  {
    paramAlarmInfo = new Wrapper(Module.MSG_ALARM, Section.ALERT_INFO, paramAlarmInfo);
    return O0(new Request(Method.SET_ALERT_CONFIG, paramAlarmInfo));
  }
  
  public Request<MultipleRequest> W()
  {
    return u(new Request[] { e(), c() });
  }
  
  public Request<MultipleRequest> W0(AlarmPlanInfo paramAlarmPlanInfo)
  {
    paramAlarmPlanInfo = new Wrapper(Module.MSG_ALARM_PLAN, Section.MSG_ALARM_PLAN, paramAlarmPlanInfo);
    return O0(new Request(Method.SET_ALERT_PLAN, paramAlarmPlanInfo));
  }
  
  public Request<MultipleRequest> X()
  {
    Wrapper localWrapper = new Wrapper(Module.CLOUD_CONFIG, Section.NAME, Section.UPGRADE_STATUS.getValue());
    return O0(new Request(Method.GET_FIRMWARE_UPDATE_STATUS, localWrapper));
  }
  
  public Request<MultipleRequest> X0(AutoUpdateInfo paramAutoUpdateInfo)
  {
    paramAutoUpdateInfo = new Wrapper(Module.AUTO_UPDATE, Section.COMMON, paramAutoUpdateInfo);
    return O0(new Request(Method.SET_FIRMWARE_AUTO_UPGRADE_CONFIG, paramAutoUpdateInfo));
  }
  
  public Request<MultipleRequest> Y()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(E(Method.GET_FORCE_WHITELAMP_STATE, Module.IMAGE, Section.NAME, Section.SWITCH.getValue()));
    return Q0(localArrayList);
  }
  
  public Request<MultipleRequest> Y0(boolean paramBoolean, String paramString)
  {
    return u(new Request[] { h(paramBoolean, paramString) });
  }
  
  public Request<MultipleRequest> Z()
  {
    Object localObject1 = Module.DEVICE_INFO;
    Object localObject2 = Section.NAME;
    Wrapper localWrapper = new Wrapper((Module)localObject1, (Section)localObject2, Collections.singletonList(Section.BASIC_INFO.getValue()));
    localObject1 = new Wrapper(Module.SYSTEM, (Section)localObject2, Collections.singletonList(Section.LAST_ALARM_INFO.getValue()));
    localObject2 = new Wrapper(Module.APP_COMPONENT, (Section)localObject2, Collections.singletonList(Section.APP_COMPONENT_LIST.getValue()));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new Request(Method.GET_DEVICE_INFO, F(localWrapper)));
    localArrayList.add(new Request(Method.GET_LAST_ALARM_INFO, F((Wrapper)localObject1)));
    localArrayList.add(new Request(Method.GET_APP_COMPONENT_LIST, F((Wrapper)localObject2)));
    return Q0(localArrayList);
  }
  
  public Request<Wrapper> Z0(String paramString)
  {
    paramString = new Wrapper(Module.SERVER_TYPE, Section.EMPTY, paramString);
    return new Request(Method.SET_CLOUD_SERVER_TYPE, paramString);
  }
  
  public Request<MultipleRequest> a0()
  {
    Wrapper localWrapper = new Wrapper(Module.INTRUSION_DETECTION, Section.NAME, Arrays.asList(new String[] { Section.DETECTION.getValue(), Section.ARMING_SCHEDULE.getValue() }));
    return O0(new Request(Method.GET_INTRUSION_DETECTION_CONFIG, localWrapper));
  }
  
  public Request<MultipleRequest> b0()
  {
    Wrapper localWrapper = new Wrapper(Module.INTRUSION_DETECTION, Section.TABLE, Collections.singletonList(Section.REGION_INFO.getValue()));
    return O0(new Request(Method.GET_INTRUSION_DETECTION_REGION, localWrapper));
  }
  
  public Request<MultipleRequest> b1(boolean paramBoolean)
  {
    return u(new Request[] { a1(new CoverConfig(paramBoolean)) });
  }
  
  public Request<Wrappers> c()
  {
    return E(Method.GET_CLOUD_CONFIG, Module.CLOUD_CONFIG, Section.NAME, Collections.singletonList(Section.UPGRADE_INFO.getValue()));
  }
  
  public Request<MultipleRequest> c0()
  {
    Wrapper localWrapper = new Wrapper(Module.NETWORK, Section.NAME, Collections.singletonList(Section.WAN.getValue()));
    return O0(new Request(Method.GET_DEVICE_IP_ADDRESS, localWrapper));
  }
  
  public Request<MultipleRequest> c1(String paramString)
  {
    SystemInfo localSystemInfo = new SystemInfo();
    localSystemInfo.setAlias(paramString);
    paramString = new Wrapper(Module.SYSTEM, Section.SYS, localSystemInfo);
    return O0(new Request(Method.SET_DEVICE_ALIAS, paramString));
  }
  
  public Request<MultipleRequest> d0(CameraComponent paramCameraComponent)
  {
    Object localObject1 = Module.DEVICE_INFO;
    Object localObject2 = Section.NAME;
    Wrapper localWrapper1 = new Wrapper((Module)localObject1, (Section)localObject2, Collections.singletonList(Section.BASIC_INFO.getValue()));
    Wrapper localWrapper2 = new Wrapper(Module.SYSTEM, (Section)localObject2, Collections.singletonList(Section.LAST_ALARM_INFO.getValue()));
    localObject1 = new ArrayList();
    ((List)localObject1).add(new Request(Method.GET_DEVICE_INFO, F(localWrapper1)));
    ((List)localObject1).add(new Request(Method.GET_LAST_ALARM_INFO, F(localWrapper2)));
    if ((paramCameraComponent != null) && (paramCameraComponent.isSupportUpnp()))
    {
      Object localObject3 = Module.UPNPC;
      paramCameraComponent = new Wrapper((Module)localObject3, (Section)localObject2, Collections.singletonList(Section.UPNPC_INFO.getValue()));
      localWrapper2 = new Wrapper((Module)localObject3, Section.TABLE, Collections.singletonList(Section.UPNP_STATUS.getValue()));
      localWrapper1 = new Wrapper((Module)localObject3, (Section)localObject2, Collections.singletonList(Section.PUB_IP.getValue()));
      localObject2 = new Wrapper((Module)localObject3, (Section)localObject2, Collections.singletonList(Section.COMMUNICATE.getValue()));
      localObject3 = new Wrapper(Module.CERT, Section.GET_HTTPS_PSK, Collections.singletonList(Section.EMPTY.getValue()));
      ((List)localObject1).add(new Request(Method.GET_UPNP_INFO, F(paramCameraComponent)));
      ((List)localObject1).add(new Request(Method.GET_UPNP_STATUS, F(localWrapper2)));
      ((List)localObject1).add(new Request(Method.GET_PUB_IP, F(localWrapper1)));
      ((List)localObject1).add(new Request(Method.GET_UPNP_COMM_STATUS, F((Wrapper)localObject2)));
      ((List)localObject1).add(new Request(Method.GET_UPNP_PSK, F((Wrapper)localObject3)));
    }
    return Q0((List)localObject1);
  }
  
  public Request<MultipleRequest> d1(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramString1 != null)
    {
      SystemInfo localSystemInfo = new SystemInfo();
      localSystemInfo.setAlias(paramString1);
      localArrayList.add(E(Method.SET_DEVICE_ALIAS, Module.SYSTEM, Section.SYS, localSystemInfo));
    }
    if (paramString2 != null)
    {
      paramString1 = new SystemInfo();
      paramString1.setAvatar(paramString2);
      localArrayList.add(E(Method.SET_DEVICE_AVATAR, Module.SYSTEM, Section.SYS, paramString1));
    }
    return Q0(localArrayList);
  }
  
  public Request<Wrappers> e()
  {
    return E(Method.CHECK_FIRMWARE_VERSION_BY_CLOUD, Module.CLOUD_CONFIG, Section.FIRMWARE_NOTIFY, Section.EMPTY.getValue());
  }
  
  public Request<MultipleRequest> e0()
  {
    Wrapper localWrapper = new Wrapper(Module.IMAGE, Section.NAME, Section.SWITCH.getValue());
    return O0(new Request(Method.GET_LDC, localWrapper));
  }
  
  public Request<MultipleRequest> e1(String paramString)
  {
    SystemInfo localSystemInfo = new SystemInfo();
    localSystemInfo.setAvatar(paramString);
    paramString = new Wrapper(Module.SYSTEM, Section.SYS, localSystemInfo);
    return O0(new Request(Method.SET_DEVICE_AVATAR, paramString));
  }
  
  public Request<MultipleRequest> f0()
  {
    Wrapper localWrapper = new Wrapper(Module.LENS_MASK, Section.NAME, Collections.singletonList(Section.LENS_MASK_INFO.getValue()));
    return O0(new Request(Method.GET_LENS_MASK_CONFIG, localWrapper));
  }
  
  public Request<MultipleRequest> f1(boolean paramBoolean)
  {
    SystemInfo localSystemInfo = new SystemInfo();
    if (paramBoolean) {
      localObject = "on";
    } else {
      localObject = "off";
    }
    localSystemInfo.setDiagnoseMode((String)localObject);
    Object localObject = new Wrapper(Module.SYSTEM, Section.SYS, localSystemInfo);
    return O0(new Request(Method.SET_DIAGNOSE_MODE, localObject));
  }
  
  public Request<MultipleRequest> g0()
  {
    Wrapper localWrapper = new Wrapper(Module.IMAGE, Section.NAME, Section.COMMON.getValue());
    return O0(new Request(Method.GET_LIGHT_FREQUENCY_INFO, localWrapper));
  }
  
  public Request<MultipleRequest> g1(WhitelampState paramWhitelampState)
  {
    paramWhitelampState = new Wrapper(Module.IMAGE, Section.SWITCH, paramWhitelampState);
    return O0(new Request(Method.SET_FORCE_WHITELAMP_STATE, paramWhitelampState));
  }
  
  public Request<MultipleRequest> h0()
  {
    Wrapper localWrapper = new Wrapper(Module.LINE_CROSSING_DETECTION, Section.NAME, Arrays.asList(new String[] { Section.DETECTION.getValue(), Section.ARMING_SCHEDULE.getValue() }));
    return O0(new Request(Method.GET_LINE_CROSSING_DETECTION_CONFIG, localWrapper));
  }
  
  public Request<MultipleRequest> h1(boolean paramBoolean)
  {
    return u(new Request[] { i(paramBoolean) });
  }
  
  public Request<MultipleRequest> i0()
  {
    Wrapper localWrapper = new Wrapper(Module.LINE_CROSSING_DETECTION, Section.TABLE, Collections.singletonList(Section.REGION_INFO.getValue()));
    return O0(new Request(Method.GET_LINE_CROSSING_DETECTION_REGION, localWrapper));
  }
  
  public Request<MultipleRequest> i1(boolean paramBoolean)
  {
    Object localObject = new ImageFlip(paramBoolean);
    localObject = new Wrapper(Module.IMAGE, Section.IMAGE_SWITCH, localObject);
    return O0(new Request(Method.SET_ROTATION_STATUS, localObject));
  }
  
  public Request<MultipleRequest> j0()
  {
    Wrapper localWrapper = new Wrapper(Module.VIDEO, Section.NAME, Collections.singletonList(Section.VIDEO_MAIN.getValue()));
    return O0(new Request(Method.GET_VIDEO_QUALITIES, localWrapper));
  }
  
  public Request<MultipleRequest> j1(DetectionInfo paramDetectionInfo)
  {
    paramDetectionInfo = new Wrapper(Module.INTRUSION_DETECTION, Section.DETECTION, paramDetectionInfo);
    return O0(new Request(Method.SET_INTRUSION_DETECTION_CONFIG, paramDetectionInfo));
  }
  
  public Request<MultipleRequest> k0()
  {
    Object localObject = Module.MOTION_DETECTION;
    Wrapper localWrapper = new Wrapper((Module)localObject, Section.NAME, Collections.singletonList(Section.MOTION_DET.getValue()));
    localObject = new Wrapper((Module)localObject, Section.TABLE, Collections.singletonList(Section.REGION_INFO.getValue()));
    return P0(new Request(Method.GET_DETECTION_CONFIG, new Wrappers(Arrays.asList(new Wrapper[] { localWrapper, localObject }))));
  }
  
  public Request<MultipleRequest> k1(ArmScheduleInfo paramArmScheduleInfo)
  {
    paramArmScheduleInfo = new Wrapper(Module.INTRUSION_DETECTION, Section.ARMING_SCHEDULE, paramArmScheduleInfo);
    return O0(new Request(Method.SET_INTRUSION_DETECTION_SCHEDULE, paramArmScheduleInfo));
  }
  
  public Request<MultipleRequest> l(List<CoverConfigRegion> paramList)
  {
    return u(new Request[] { k(paramList) });
  }
  
  public Request<MultipleRequest> l0()
  {
    Wrapper localWrapper = new Wrapper(Module.MSG_PUSH, Section.NAME, Collections.singletonList(Section.MSG_PUSH_INFO.getValue()));
    return O0(new Request(Method.GET_MSG_PUSH_CONFIG, localWrapper));
  }
  
  public Request<Wrapper> l1(String paramString)
  {
    paramString = new Wrapper(Module.LANGUAGE, Section.EMPTY, paramString);
    return new Request(Method.SET_LANGUAGE, paramString);
  }
  
  public Request<MultipleRequest> m(Map<String, List<IntrusionDetectionRegion>> paramMap)
  {
    paramMap = new Wrapper(Module.INTRUSION_DETECTION, Section.ADD_REGIONS, paramMap);
    return O0(new Request(Method.ADD_INTRUSION_DETECTION_REGION, paramMap));
  }
  
  public Request<MultipleRequest> m0()
  {
    Wrapper localWrapper = new Wrapper(Module.MSG_PUSH_PLAN, Section.NAME, Collections.singletonList(Section.MSG_PUSH_PLAN.getValue()));
    return O0(new Request(Method.GET_MSG_PUSH_PLAN, localWrapper));
  }
  
  public Request<MultipleRequest> m1(boolean paramBoolean)
  {
    Module localModule = Module.IMAGE;
    Section localSection = Section.SWITCH;
    if (paramBoolean) {
      localObject = "on";
    } else {
      localObject = "off";
    }
    Object localObject = new Wrapper(localModule, localSection, new ImageFlip((String)localObject));
    return O0(new Request(Method.SET_LDC, localObject));
  }
  
  public Request<MultipleRequest> n(Map<String, List<LineCrossingDetectionRegion>> paramMap)
  {
    paramMap = new Wrapper(Module.LINE_CROSSING_DETECTION, Section.ADD_REGIONS, paramMap);
    return O0(new Request(Method.ADD_LINE_CROSSING_DETECTION_REGION, paramMap));
  }
  
  public Request<MultipleRequest> n0()
  {
    Wrapper localWrapper = new Wrapper(Module.NETWORK, Section.GET_NETWORK_INFO, Section.EMPTY.getValue());
    return O0(new Request(Method.GET_CONNECTION_TYPE, localWrapper));
  }
  
  public Request<MultipleRequest> n1(String paramString)
  {
    paramString = new Wrapper(Module.LED, Section.CONFIG, new LedStatus(paramString));
    return O0(new Request(Method.SET_LED_STATUS, paramString));
  }
  
  public Request<MultipleRequest> o(List<MotionDetectRegion> paramList)
  {
    paramList = Model.wrapper(paramList, Module.MOTION_DETECTION, Section.MOTION_DETECTION_ADD_REGION, Section.REGION_INFO.getValue());
    return O0(new Request(Method.ADD_DETECTION_REGION, paramList));
  }
  
  public Request<MultipleRequest> o0(boolean paramBoolean)
  {
    Object localObject1 = new ArrayList();
    if (paramBoolean) {
      ((List)localObject1).add(Section.OSD_LOGO.getValue());
    }
    ((List)localObject1).add(Section.OSD_DATE.getValue());
    ((List)localObject1).add(Section.OSD_WEEK.getValue());
    ((List)localObject1).add(Section.OSD_FONT.getValue());
    Object localObject2 = Collections.singletonList(Section.OSD_LABEL_INFO.getValue());
    Module localModule = Module.OSD;
    localObject1 = new Wrapper(localModule, Section.NAME, localObject1);
    localObject2 = new Wrapper(localModule, Section.TABLE, localObject2);
    return P0(new Request(Method.GET_OSD, new Wrappers(Arrays.asList(new Wrapper[] { localObject1, localObject2 }))));
  }
  
  public Request<MultipleRequest> o1(LensMaskInfo paramLensMaskInfo)
  {
    paramLensMaskInfo = new Wrapper(Module.LENS_MASK, Section.LENS_MASK_INFO, paramLensMaskInfo);
    return Q0(Collections.singletonList(new Request(Method.SET_LENS_MASK_CONFIG, F(paramLensMaskInfo))));
  }
  
  public Request<MultipleRequest> p(String paramString1, String paramString2)
  {
    paramString1 = new AccountInfo(new Account("admin", j.a(paramString1), false), paramString2);
    paramString1 = new Wrapper(Module.USER_MANAGEMENT, Section.CHANGE_ADMIN_PASSWORD, paramString1);
    return O0(new Request(Method.CHANGE_ADMIN_PASSWORD, paramString1));
  }
  
  public Request<MultipleRequest> p0()
  {
    Wrapper localWrapper = new Wrapper(Module.USER_MANAGEMENT, Section.GET_P2P_SHARE_PWD, Collections.emptyMap());
    return O0(new Request(Method.GET_P2P_SHARE_PWD, localWrapper));
  }
  
  public Request<MultipleRequest> p1(LensMaskInfo paramLensMaskInfo)
  {
    Object localObject = new Wrapper(Module.LENS_MASK, Section.LENS_MASK_INFO, paramLensMaskInfo);
    localObject = new Request(Method.SET_LENS_MASK_CONFIG, F((Wrapper)localObject));
    Module localModule = Module.LED;
    Section localSection = Section.CONFIG;
    String str = paramLensMaskInfo.getEnabled();
    paramLensMaskInfo = "on";
    if (str.equals("on")) {
      paramLensMaskInfo = "off";
    }
    paramLensMaskInfo = new Wrapper(localModule, localSection, new LedStatus(paramLensMaskInfo));
    return Q0(Arrays.asList(new Request[] { localObject, new Request(Method.SET_LED_STATUS, F(paramLensMaskInfo)) }));
  }
  
  public Request<MultipleRequest> q(MotionDetectConfig paramMotionDetectConfig)
  {
    return u(new Request[] { j(paramMotionDetectConfig) });
  }
  
  public Request<MultipleRequest> q0()
  {
    Wrapper localWrapper = new Wrapper(Module.TIMING_REBOOT, Section.NAME, Collections.singletonList(Section.REBOOT.getValue()));
    return O0(new Request(Method.GET_REBOOT, localWrapper));
  }
  
  public Request<MultipleRequest> q1(String paramString)
  {
    paramString = new Wrapper(Module.IMAGE, Section.COMMON, new Light(paramString, null));
    return O0(new Request(Method.SET_LIGHT_FREQUENCY_INFO, paramString));
  }
  
  public Request<MultipleRequest> r(String paramString1, String paramString2)
  {
    paramString1 = new AccountInfo(paramString1, paramString2);
    paramString1 = new Wrapper(Module.USER_MANAGEMENT, Section.CHANGE_THIRD_ACCOUNT, paramString1);
    return O0(new Request(Method.CHANGE_THIRD_ACCOUNT, paramString1));
  }
  
  public Request<MultipleRequest> r0()
  {
    Wrapper localWrapper = new Wrapper(Module.AUDIO_CONFIG, Section.NAME, new String[] { Section.RECORD_AUDIO.getValue() });
    return O0(new Request(Method.GET_AUDIO_CONFIG, localWrapper));
  }
  
  public Request<MultipleRequest> r1(DetectionInfo paramDetectionInfo)
  {
    paramDetectionInfo = new Wrapper(Module.LINE_CROSSING_DETECTION, Section.DETECTION, paramDetectionInfo);
    return O0(new Request(Method.SET_LINE_CROSSING_DETECTION_CONFIG, paramDetectionInfo));
  }
  
  public Request<MultipleRequest> s()
  {
    Wrapper localWrapper = new Wrapper(Module.SYSTEM, Section.CHECK_DIAGNOSE_STATUS, "");
    return O0(new Request(Method.CHECK_DIAGNOSE_STATUS, localWrapper));
  }
  
  public Request<MultipleRequest> s0()
  {
    Wrapper localWrapper = new Wrapper(Module.RECORD_PLAN, Section.NAME, Collections.singletonList(Section.CHN1_CHANNEL.getValue()));
    return O0(new Request(Method.GET_RECORD_PLAN, localWrapper));
  }
  
  public Request<MultipleRequest> s1(ArmScheduleInfo paramArmScheduleInfo)
  {
    paramArmScheduleInfo = new Wrapper(Module.LINE_CROSSING_DETECTION, Section.ARMING_SCHEDULE, paramArmScheduleInfo);
    return O0(new Request(Method.SET_LINE_CROSSING_DETECTION_SCHEDULE, paramArmScheduleInfo));
  }
  
  public Request<MultipleRequest> t()
  {
    Wrapper localWrapper = new Wrapper(Module.SYSTEM, Section.RESET_WIFI_SUPPORTED, Collections.emptyMap());
    return O0(new Request(Method.CHECK_RESET_WIFI, localWrapper));
  }
  
  public List<Request<Wrappers>> t0(MotionDetectConfig paramMotionDetectConfig, AlarmInfo paramAlarmInfo, MsgPushInfo paramMsgPushInfo, DetectionInfo paramDetectionInfo1, DetectionInfo paramDetectionInfo2, TamperDetectConfig paramTamperDetectConfig, HumanRecognitionInfo paramHumanRecognitionInfo, BabyCryingDetectionInfo paramBabyCryingDetectionInfo, TargetTrackInfo paramTargetTrackInfo)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramMotionDetectConfig != null) {
      localArrayList.add(j(paramMotionDetectConfig));
    }
    if (paramAlarmInfo != null) {
      localArrayList.add(f(paramAlarmInfo));
    }
    if (paramMsgPushInfo != null) {
      localArrayList.add(E(Method.SET_MSG_PUSH_CONFIG, Module.MSG_PUSH, Section.MSG_PUSH_INFO, paramMsgPushInfo));
    }
    if (paramDetectionInfo1 != null) {
      localArrayList.add(E(Method.SET_INTRUSION_DETECTION_CONFIG, Module.INTRUSION_DETECTION, Section.DETECTION, paramDetectionInfo1));
    }
    if (paramDetectionInfo2 != null) {
      localArrayList.add(E(Method.SET_LINE_CROSSING_DETECTION_CONFIG, Module.LINE_CROSSING_DETECTION, Section.DETECTION, paramDetectionInfo2));
    }
    if (paramTamperDetectConfig != null) {
      localArrayList.add(E(Method.SET_TAMPER_DETECTION_CONFIG, Module.TAMPER_DETECTION, Section.TAMPER_DET, paramTamperDetectConfig));
    }
    if (paramHumanRecognitionInfo != null) {
      localArrayList.add(E(Method.SET_PERSON_DETECTION_CONFIG, Module.PEOPLE_DETECTION, Section.DETECTION, paramHumanRecognitionInfo));
    }
    if (paramBabyCryingDetectionInfo != null) {
      localArrayList.add(E(Method.SET_BCD_CONFIG, Module.SOUND_DETECTION, Section.BABY_CRYING_DETECTION, paramBabyCryingDetectionInfo));
    }
    if (paramTargetTrackInfo != null) {
      localArrayList.add(E(Method.SET_TARGET_TRACK_CONFIG, Module.TARGET_TRACK, Section.TARGET_TRACK_INFO, paramTargetTrackInfo));
    }
    return localArrayList;
  }
  
  public Request<MultipleRequest> t1(boolean paramBoolean)
  {
    if (paramBoolean) {
      localObject = "on";
    } else {
      localObject = "off";
    }
    Object localObject = new HardDiskLoop((String)localObject);
    localObject = new Wrapper(Module.HARD_DISK_MANAGE, Section.HARD_DISK_LOOP, localObject);
    return O0(new Request(Method.SET_CIRCULAR_RECORDING_CONFIG, localObject));
  }
  
  public Request<MultipleRequest> u0(AlarmPlanInfo paramAlarmPlanInfo, MsgPushPlanInfo paramMsgPushPlanInfo, ArmScheduleInfo paramArmScheduleInfo1, ArmScheduleInfo paramArmScheduleInfo2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramAlarmPlanInfo != null) {
      localArrayList.add(g(paramAlarmPlanInfo));
    }
    if (paramMsgPushPlanInfo != null) {
      localArrayList.add(E(Method.SET_MSG_PUSH_PLAN, Module.MSG_PUSH_PLAN, Section.MSG_PUSH_PLAN, paramMsgPushPlanInfo));
    }
    if (paramArmScheduleInfo1 != null) {
      localArrayList.add(E(Method.SET_INTRUSION_DETECTION_SCHEDULE, Module.INTRUSION_DETECTION, Section.ARMING_SCHEDULE, paramArmScheduleInfo1));
    }
    if (paramArmScheduleInfo2 != null) {
      localArrayList.add(E(Method.SET_LINE_CROSSING_DETECTION_SCHEDULE, Module.LINE_CROSSING_DETECTION, Section.ARMING_SCHEDULE, paramArmScheduleInfo2));
    }
    return Q0(localArrayList);
  }
  
  public Request<MultipleRequest> u1(MicroPhoneInfo paramMicroPhoneInfo)
  {
    paramMicroPhoneInfo = new Wrapper(Module.AUDIO_CONFIG, Section.MICROPHONE, paramMicroPhoneInfo);
    return O0(new Request(Method.SET_MICROPHONE_VOLUME, paramMicroPhoneInfo));
  }
  
  public Request<Wrapper<Wifi>> v(Wifi paramWifi)
  {
    paramWifi = new Wrapper(Module.ON_BOARDING, Section.CONNECT, paramWifi);
    return new Request(Method.CONNECT_AP, paramWifi);
  }
  
  public Request<MultipleRequest> v0(List<MotionDetectRegion> paramList, Map<String, List<IntrusionDetectionRegion>> paramMap, HashMap<String, List<LineCrossingDetectionRegion>> paramHashMap)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null) {
      localArrayList.add(a(paramList));
    }
    if (paramMap != null) {
      localArrayList.add(E(Method.ADD_INTRUSION_DETECTION_REGION, Module.INTRUSION_DETECTION, Section.ADD_REGIONS, paramMap));
    }
    if (paramHashMap != null) {
      localArrayList.add(E(Method.ADD_LINE_CROSSING_DETECTION_REGION, Module.LINE_CROSSING_DETECTION, Section.ADD_REGIONS, paramHashMap));
    }
    return Q0(localArrayList);
  }
  
  public Request<MultipleRequest> v1(MsgPushInfo paramMsgPushInfo)
  {
    paramMsgPushInfo = new Wrapper(Module.MSG_PUSH, Section.MSG_PUSH_INFO, paramMsgPushInfo);
    return O0(new Request(Method.SET_MSG_PUSH_CONFIG, paramMsgPushInfo));
  }
  
  public Request<MultipleRequest> w(CloudTerracePoint paramCloudTerracePoint)
  {
    paramCloudTerracePoint = new Wrapper(Module.PRESET, Section.SET_PRESET, paramCloudTerracePoint);
    return O0(new Request(Method.ADD_MOTOR_POSITION, paramCloudTerracePoint));
  }
  
  public Request<MultipleRequest> w0()
  {
    Wrapper localWrapper = new Wrapper(Module.HARD_DISK_MANAGE, Section.TABLE, Collections.singletonList(Section.HARD_DISK_INFO.getValue()));
    return P0(new Request(Method.GET_SD_CARD_STATUS, new Wrappers(Arrays.asList(new Wrapper[] { localWrapper }))));
  }
  
  public Request<MultipleRequest> w1(MsgPushPlanInfo paramMsgPushPlanInfo)
  {
    paramMsgPushPlanInfo = new Wrapper(Module.MSG_PUSH_PLAN, Section.MSG_PUSH_PLAN, paramMsgPushPlanInfo);
    return O0(new Request(Method.SET_MSG_PUSH_PLAN, paramMsgPushPlanInfo));
  }
  
  public Request<MultipleRequest> x(boolean paramBoolean)
  {
    Module localModule = Module.MOTOR;
    Section localSection = Section.CRUISE;
    if (paramBoolean) {
      localObject = "y";
    } else {
      localObject = "x";
    }
    Object localObject = new Wrapper(localModule, localSection, new CloudTerraceCruiseInfo((String)localObject));
    return O0(new Request(Method.CRUISE_MOVE, localObject));
  }
  
  public Request<MultipleRequest> x0()
  {
    Wrapper localWrapper = new Wrapper(Module.HARD_DISK_MANAGE, Section.HARD_DISK_FORMAT_STATUS, DiskInfo.getSingletonDisk());
    return O0(new Request(Method.GET_SD_CARD_FORMAT_STATUS, localWrapper));
  }
  
  public Request<MultipleRequest> x1(NightMode paramNightMode)
  {
    paramNightMode = new Wrapper(Module.IMAGE, Section.COMMON, new Light(null, paramNightMode.getRaw()));
    return O0(new Request(Method.SET_DAY_NIGHT_MODE_CONFIG, paramNightMode));
  }
  
  public Request<MultipleRequest> y(CloudTerraceMoveInfo paramCloudTerraceMoveInfo)
  {
    paramCloudTerraceMoveInfo = new Wrapper(Module.MOTOR, Section.MOVE, paramCloudTerraceMoveInfo);
    return O0(new Request(Method.MOTOR_MOVE, paramCloudTerraceMoveInfo));
  }
  
  public Request<MultipleRequest> y0()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = Module.HARD_DISK_MANAGE;
    Wrapper localWrapper = new Wrapper((Module)localObject, Section.NAME, Collections.singletonList(Section.HARD_DISK_LOOP.getValue()));
    localObject = new Wrapper((Module)localObject, Section.TABLE, Collections.singletonList(Section.HARD_DISK_INFO.getValue()));
    localArrayList.add(new Request(Method.GET_CIRCULAR_RECORDING_CONFIG, F(localWrapper)));
    localArrayList.add(new Request(Method.GET_SD_CARD_STATUS, F((Wrapper)localObject)));
    return Q0(localArrayList);
  }
  
  public Request<MultipleRequest> y1(NightVisionMode paramNightVisionMode)
  {
    paramNightVisionMode = new Wrapper(Module.IMAGE, Section.SWITCH, paramNightVisionMode);
    return O0(new Request(Method.SET_NIGHT_VISION_MODE_CONFIG, paramNightVisionMode));
  }
  
  public Request<MultipleRequest> z(String paramString)
  {
    paramString = new Wrapper(Module.MOTOR, Section.MOVE_STEP, new CloudTerraceMoveStepInfo(paramString));
    return O0(new Request(Method.SIGNAL_MOVE, paramString));
  }
  
  public Request<MultipleRequest> z0()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(E(Method.GET_TAPO_CARE_SERVICE_LIST, Module.TAPO_CARE, Section.NAME, Section.SERVICE_LIST.getValue()));
    return Q0(localArrayList);
  }
  
  public Request<MultipleRequest> z1(boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3)
  {
    Object localObject1 = "on";
    if (paramBoolean1) {
      localObject2 = "on";
    } else {
      localObject2 = "off";
    }
    if (!paramBoolean2) {
      localObject1 = "off";
    }
    Object localObject3 = new OsdElement("0", "0", null, (String)localObject2);
    Object localObject4 = new OsdElement("0", "0", null, "off");
    if ((paramBoolean3) && (!paramBoolean1)) {
      localObject2 = "0";
    } else {
      localObject2 = "500";
    }
    OsdElement localOsdElement = new OsdElement("0", (String)localObject2, paramString, (String)localObject1);
    paramString = new OsdFont();
    Object localObject2 = Module.OSD;
    localObject1 = new Wrapper((Module)localObject2, Section.OSD_DATE, localObject3);
    localObject4 = new Wrapper((Module)localObject2, Section.OSD_WEEK, localObject4);
    localObject3 = new Wrapper((Module)localObject2, Section.OSD_LABEL_INFO_FIRST, localOsdElement);
    paramString = new Wrapper((Module)localObject2, Section.OSD_FONT, paramString);
    return P0(new Request(Method.SET_OSD, new Wrappers(Arrays.asList(new Wrapper[] { localObject1, localObject4, paramString, localObject3 }))));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\h4\l4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */