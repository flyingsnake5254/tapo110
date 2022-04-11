package com.tplink.libtpnetwork.TPCloudNetwork.bean;

import android.text.TextUtils;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumMsgSubscribeType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubscribeItemBean
  implements Serializable
{
  private static final int BIT_CAMERA_MOTION = 1;
  private static HashMap<EnumMsgSubscribeType, Integer> subscribeTypeBitMap;
  private String deviceId;
  private int deviceSubscribeOffBit;
  @Deprecated
  private int subscribeBit;
  
  static
  {
    HashMap localHashMap = new HashMap();
    subscribeTypeBitMap = localHashMap;
    localHashMap.put(EnumMsgSubscribeType.CAMERA_MOTION, Integer.valueOf(1));
  }
  
  public SubscribeItemBean(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public SubscribeItemBean(String paramString, int paramInt)
  {
    this.deviceId = paramString;
    this.deviceSubscribeOffBit = paramInt;
  }
  
  private boolean isDeviceSubscribeByType(EnumMsgSubscribeType paramEnumMsgSubscribeType)
  {
    boolean bool = false;
    if (paramEnumMsgSubscribeType == null) {
      return false;
    }
    paramEnumMsgSubscribeType = (Integer)subscribeTypeBitMap.get(paramEnumMsgSubscribeType);
    if (paramEnumMsgSubscribeType == null) {
      return false;
    }
    int i = this.deviceSubscribeOffBit;
    if ((paramEnumMsgSubscribeType.intValue() & i) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public void addSubscribeFunc(EnumMsgSubscribeType paramEnumMsgSubscribeType)
  {
    if (paramEnumMsgSubscribeType != null)
    {
      paramEnumMsgSubscribeType = (Integer)subscribeTypeBitMap.get(paramEnumMsgSubscribeType);
      if (paramEnumMsgSubscribeType != null)
      {
        int i = this.deviceSubscribeOffBit | paramEnumMsgSubscribeType.intValue();
        this.deviceSubscribeOffBit = i;
        this.deviceSubscribeOffBit = (paramEnumMsgSubscribeType.intValue() ^ i);
      }
    }
  }
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public int getDeviceSubscribeOffBit()
  {
    return this.deviceSubscribeOffBit;
  }
  
  @Deprecated
  public int getSubscribeBit()
  {
    return this.subscribeBit;
  }
  
  public boolean isSubscribeCameraMotion()
  {
    return isDeviceSubscribeByType(EnumMsgSubscribeType.CAMERA_MOTION);
  }
  
  @Deprecated
  public boolean isSubscribeCameraMotionOld()
  {
    boolean bool;
    if ((this.subscribeBit & 0x4) == 4) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @Deprecated
  public boolean isSubscribeNewFirmwareOld()
  {
    int i = this.subscribeBit;
    boolean bool = true;
    if ((i & 0x1) != 1) {
      bool = false;
    }
    return bool;
  }
  
  public void removeSubscribeFunc(EnumMsgSubscribeType paramEnumMsgSubscribeType)
  {
    if (paramEnumMsgSubscribeType != null)
    {
      paramEnumMsgSubscribeType = (Integer)subscribeTypeBitMap.get(paramEnumMsgSubscribeType);
      if (paramEnumMsgSubscribeType != null)
      {
        int i = this.deviceSubscribeOffBit;
        this.deviceSubscribeOffBit = (paramEnumMsgSubscribeType.intValue() | i);
      }
    }
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public void setDeviceSubscribeOffBit(int paramInt)
  {
    this.deviceSubscribeOffBit = paramInt;
  }
  
  @Deprecated
  public void setSubscribeBit(int paramInt)
  {
    this.subscribeBit = paramInt;
  }
  
  public List<String> toSubscribeList(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(this.deviceId))
    {
      boolean bool1 = o.h0().b0();
      boolean bool2 = o.h0().e0();
      if (TextUtils.isEmpty(paramString)) {
        paramString = EnumDeviceType.UNKNOWN;
      } else {
        paramString = EnumDeviceType.fromType(paramString);
      }
      EnumDeviceType localEnumDeviceType = EnumDeviceType.CAMERA;
      if ((paramString == localEnumDeviceType) && (bool1) && (bool2) && (this.deviceSubscribeOffBit == 0))
      {
        localArrayList.add(EnumMsgSubscribeType.ALL.getName());
      }
      else if ((bool1) && (this.deviceSubscribeOffBit == 0))
      {
        localArrayList.add(EnumMsgSubscribeType.ALL.getName());
      }
      else
      {
        if (bool1) {
          localArrayList.add(EnumMsgSubscribeType.NEW_FIRMWARE.getName());
        }
        if (paramString == localEnumDeviceType)
        {
          if (bool2)
          {
            localArrayList.add(EnumMsgSubscribeType.CAMERA_SD_NEED_INITIALIZATION.getName());
            localArrayList.add(EnumMsgSubscribeType.CAMERA_SD_INSUFFICIENT_STORAGE.getName());
          }
          if (isSubscribeCameraMotion())
          {
            localArrayList.add(EnumMsgSubscribeType.CAMERA_MOTION.getName());
            localArrayList.add(EnumMsgSubscribeType.CAMERA_AREA_INTRUSION_DETECTION.getName());
            localArrayList.add(EnumMsgSubscribeType.CAMERA_LINE_CROSSING_DETECTION.getName());
            localArrayList.add(EnumMsgSubscribeType.CAMERA_TAMPERING.getName());
            localArrayList.add(EnumMsgSubscribeType.CAMERA_PERSON_DETECTED.getName());
            localArrayList.add(EnumMsgSubscribeType.CAMERA_PERSON_ENHANCED.getName());
            localArrayList.add(EnumMsgSubscribeType.CAMERA_CRYING.getName());
          }
        }
        else if (paramString == EnumDeviceType.PLUG)
        {
          if (isSubscribeCameraMotion()) {
            localArrayList.add(EnumMsgSubscribeType.DEVICE_ACTIVITY.getName());
          }
        }
        else if (paramString == EnumDeviceType.HUB)
        {
          if (isSubscribeCameraMotion()) {
            localArrayList.add(EnumMsgSubscribeType.TAPO_HUB_TRIGGERED.getName());
          }
        }
        else if (paramString == EnumDeviceType.SWITCH)
        {
          if (isSubscribeCameraMotion()) {
            localArrayList.add(EnumMsgSubscribeType.TAPO_SMART_SWITCH_TRIGGERED.getName());
          }
          localArrayList.add(EnumMsgSubscribeType.TAPO_DEVICE_LOW_BATTERY.getName());
        }
        else if (paramString == EnumDeviceType.SENSOR)
        {
          if (isSubscribeCameraMotion())
          {
            localArrayList.add(EnumMsgSubscribeType.TAPO_MOTION_SENSOR_TRIGGERED.getName());
            localArrayList.add(EnumMsgSubscribeType.TAPO_CONTACT_SENSOR_TRIGGERED.getName());
            localArrayList.add(EnumMsgSubscribeType.TAPO_SMART_BUTTON_TRIGGERED.getName());
          }
          localArrayList.add(EnumMsgSubscribeType.TAPO_DEVICE_LOW_BATTERY.getName());
          localArrayList.add(EnumMsgSubscribeType.TAPO_SENSOR_FREQUENTLY_TRIGGERED.getName());
        }
        else if ((paramString == EnumDeviceType.ENERGY) && (isSubscribeCameraMotion()))
        {
          localArrayList.add(EnumMsgSubscribeType.TAPO_THERMOSTAT_RADIATOR_VALVE.getName());
        }
      }
    }
    return localArrayList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TPCloudNetwork\bean\SubscribeItemBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */