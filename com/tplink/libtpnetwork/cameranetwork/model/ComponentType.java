package com.tplink.libtpnetwork.cameranetwork.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum ComponentType
{
  private List<Integer> appSupportVersions;
  private String componentName;
  
  static
  {
    ComponentType localComponentType1 = new ComponentType("UNKNOWN", 0, "unknown", null);
    UNKNOWN = localComponentType1;
    Object localObject1 = Integer.valueOf(1);
    ComponentType localComponentType2 = new ComponentType("SD_CARD", 1, "sdCard", Collections.singletonList(localObject1));
    SD_CARD = localComponentType2;
    Object localObject2 = Collections.singletonList(localObject1);
    Object localObject3 = Integer.valueOf(2);
    ComponentType localComponentType3 = new ComponentType("TIME_ZONE", 2, "timezone", (List)localObject2);
    TIME_ZONE = localComponentType3;
    Object localObject4 = Integer.valueOf(3);
    ComponentType localComponentType4 = new ComponentType("SYSTEM", 3, "system", Arrays.asList(new Integer[] { localObject1, localObject3, localObject4, Integer.valueOf(4) }));
    SYSTEM = localComponentType4;
    localObject2 = new ComponentType("LED", 4, "led", Collections.singletonList(localObject1));
    LED = (ComponentType)localObject2;
    ComponentType localComponentType5 = new ComponentType("PLAYBACK", 5, "playback", Arrays.asList(new Integer[] { localObject1, localObject3, localObject4 }));
    PLAYBACK = localComponentType5;
    ComponentType localComponentType6 = new ComponentType("DETECTION", 6, "detection", Arrays.asList(new Integer[] { localObject1, localObject3 }));
    DETECTION = localComponentType6;
    ComponentType localComponentType7 = new ComponentType("ALERT", 7, "alert", Collections.singletonList(localObject1));
    ALERT = localComponentType7;
    ComponentType localComponentType8 = new ComponentType("FIRMWARE", 8, "firmware", Arrays.asList(new Integer[] { localObject1, localObject3 }));
    FIRMWARE = localComponentType8;
    ComponentType localComponentType9 = new ComponentType("ACCOUNT", 9, "account", Collections.singletonList(localObject1));
    ACCOUNT = localComponentType9;
    ComponentType localComponentType10 = new ComponentType("QUICK_SETUP", 10, "quickSetup", Collections.singletonList(localObject1));
    QUICK_SETUP = localComponentType10;
    ComponentType localComponentType11 = new ComponentType("PTZ", 11, "ptz", Collections.singletonList(localObject1));
    PTZ = localComponentType11;
    ComponentType localComponentType12 = new ComponentType("VIDEO", 12, "video", Arrays.asList(new Integer[] { localObject1, localObject3 }));
    VIDEO = localComponentType12;
    ComponentType localComponentType13 = new ComponentType("LEN_MASK", 13, "lensMask", Arrays.asList(new Integer[] { localObject1, localObject3 }));
    LEN_MASK = localComponentType13;
    ComponentType localComponentType14 = new ComponentType("LIGHT_FREQUENCY", 14, "lightFrequency", Collections.singletonList(localObject1));
    LIGHT_FREQUENCY = localComponentType14;
    ComponentType localComponentType15 = new ComponentType("DAY_NIGHT_MODE", 15, "dayNightMode", Collections.singletonList(localObject1));
    DAY_NIGHT_MODE = localComponentType15;
    ComponentType localComponentType16 = new ComponentType("OSD", 16, "osd", Arrays.asList(new Integer[] { localObject1, localObject3 }));
    OSD = localComponentType16;
    ComponentType localComponentType17 = new ComponentType("RECORD", 17, "record", Collections.singletonList(localObject1));
    RECORD = localComponentType17;
    ComponentType localComponentType18 = new ComponentType("VIDEO_ROTATION", 18, "videoRotation", Collections.singletonList(localObject1));
    VIDEO_ROTATION = localComponentType18;
    ComponentType localComponentType19 = new ComponentType("AUDIO", 19, "audio", Arrays.asList(new Integer[] { localObject1, localObject3 }));
    AUDIO = localComponentType19;
    ComponentType localComponentType20 = new ComponentType("DIAGNOSE", 20, "diagnose", Collections.singletonList(localObject1));
    DIAGNOSE = localComponentType20;
    ComponentType localComponentType21 = new ComponentType("LDC", 21, "ldc", Collections.singletonList(localObject1));
    LDC = localComponentType21;
    ComponentType localComponentType22 = new ComponentType("MSG_PUSH", 22, "msgPush", Collections.singletonList(localObject3));
    MSG_PUSH = localComponentType22;
    ComponentType localComponentType23 = new ComponentType("DEVICE_SHARE", 23, "deviceShare", Collections.singletonList(localObject1));
    DEVICE_SHARE = localComponentType23;
    ComponentType localComponentType24 = new ComponentType("TAMPER_DETECTION", 24, "tamperDetection", Collections.singletonList(localObject1));
    TAMPER_DETECTION = localComponentType24;
    ComponentType localComponentType25 = new ComponentType("INTRUSION_DETECTION", 25, "intrusionDetection", Collections.singletonList(localObject3));
    INTRUSION_DETECTION = localComponentType25;
    ComponentType localComponentType26 = new ComponentType("LINE_CROSSING_DETECTION", 26, "linecrossingDetection", Collections.singletonList(localObject3));
    LINE_CROSSING_DETECTION = localComponentType26;
    ComponentType localComponentType27 = new ComponentType("PERSON_DETECTION", 27, "personDetection", Collections.singletonList(localObject1));
    PERSON_DETECTION = localComponentType27;
    ComponentType localComponentType28 = new ComponentType("TAPO_CARE", 28, "tapoCare", Collections.singletonList(localObject1));
    TAPO_CARE = localComponentType28;
    ComponentType localComponentType29 = new ComponentType("BABY_CRYING_DETECTION", 29, "babyCryDetection", Collections.singletonList(localObject1));
    BABY_CRYING_DETECTION = localComponentType29;
    ComponentType localComponentType30 = new ComponentType("BLOCK_ZONE", 30, "blockZone", Collections.singletonList(localObject1));
    BLOCK_ZONE = localComponentType30;
    ComponentType localComponentType31 = new ComponentType("TARGET_TRACK", 31, "targetTrack", Collections.singletonList(localObject1));
    TARGET_TRACK = localComponentType31;
    ComponentType localComponentType32 = new ComponentType("AI_DETECTION", 32, "aiDetection", Collections.singletonList(localObject1));
    AI_DETECTION = localComponentType32;
    ComponentType localComponentType33 = new ComponentType("NIGHT_VISION_MODE", 33, "nightVisionMode", Arrays.asList(new Integer[] { localObject1, localObject3 }));
    NIGHT_VISION_MODE = localComponentType33;
    localObject4 = new ComponentType("IOT_CLOUD", 34, "iotCloud", Collections.singletonList(localObject1));
    IOT_CLOUD = (ComponentType)localObject4;
    localObject3 = new ComponentType("UPNPC", 35, "upnpc", Collections.singletonList(localObject3));
    UPNPC = (ComponentType)localObject3;
    localObject1 = new ComponentType("NEED_SUBSCRIPTION_SERVICE_LIST", 36, "needSubscriptionServiceList", Collections.singletonList(localObject1));
    NEED_SUBSCRIPTION_SERVICE_LIST = (ComponentType)localObject1;
    $VALUES = new ComponentType[] { localComponentType1, localComponentType2, localComponentType3, localComponentType4, localObject2, localComponentType5, localComponentType6, localComponentType7, localComponentType8, localComponentType9, localComponentType10, localComponentType11, localComponentType12, localComponentType13, localComponentType14, localComponentType15, localComponentType16, localComponentType17, localComponentType18, localComponentType19, localComponentType20, localComponentType21, localComponentType22, localComponentType23, localComponentType24, localComponentType25, localComponentType26, localComponentType27, localComponentType28, localComponentType29, localComponentType30, localComponentType31, localComponentType32, localComponentType33, localObject4, localObject3, localObject1 };
  }
  
  private ComponentType(String paramString, List<Integer> paramList)
  {
    this.componentName = paramString;
    this.appSupportVersions = paramList;
  }
  
  public static ComponentType fromComponentName(String paramString)
  {
    for (ComponentType localComponentType : ) {
      if (localComponentType.getComponentName().equals(paramString)) {
        return localComponentType;
      }
    }
    return UNKNOWN;
  }
  
  public String getComponentName()
  {
    return this.componentName;
  }
  
  public boolean isTargetComponentVersionAPPSupport(int paramInt)
  {
    List localList = this.appSupportVersions;
    boolean bool;
    if ((localList != null) && (localList.contains(Integer.valueOf(paramInt)))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\ComponentType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */