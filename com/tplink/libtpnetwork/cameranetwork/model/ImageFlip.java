package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class ImageFlip
{
  @c("flip_type")
  private final String flipType;
  @c("force_wtl_state")
  private final String forceWtlState;
  @c("ldc")
  private final String ldc;
  @c("night_vision_mode")
  private final String nightVisionMode;
  @c("rotate_type")
  private final String rotateType;
  @c("schedule_end_time")
  private final Integer scheduleEndTime;
  @c("schedule_start_time")
  private final Integer scheduleStartTime;
  @c("switch_mode")
  private final String switchMode;
  @c("wtl_intensity_level")
  private final String wtlIntensityLevel;
  
  public ImageFlip(int paramInt)
  {
    this(null, null, null, null, null, null, null, String.valueOf(paramInt), null);
  }
  
  public ImageFlip(String paramString)
  {
    this(null, null, null, null, null, paramString, null, null, null);
  }
  
  public ImageFlip(String paramString1, Integer paramInteger1, Integer paramInteger2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this.switchMode = paramString1;
    this.scheduleStartTime = paramInteger1;
    this.scheduleEndTime = paramInteger2;
    this.flipType = paramString2;
    this.rotateType = paramString3;
    this.ldc = paramString4;
    this.nightVisionMode = paramString5;
    this.wtlIntensityLevel = paramString6;
    this.forceWtlState = paramString7;
  }
  
  public ImageFlip(boolean paramBoolean)
  {
    this(null, null, null, str, null, null, null, null, null);
  }
  
  public final String component1()
  {
    return this.switchMode;
  }
  
  public final Integer component2()
  {
    return this.scheduleStartTime;
  }
  
  public final Integer component3()
  {
    return this.scheduleEndTime;
  }
  
  public final String component4()
  {
    return this.flipType;
  }
  
  public final String component5()
  {
    return this.rotateType;
  }
  
  public final String component6()
  {
    return this.ldc;
  }
  
  public final String component7()
  {
    return this.nightVisionMode;
  }
  
  public final String component8()
  {
    return this.wtlIntensityLevel;
  }
  
  public final String component9()
  {
    return this.forceWtlState;
  }
  
  public final ImageFlip copy(String paramString1, Integer paramInteger1, Integer paramInteger2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    return new ImageFlip(paramString1, paramInteger1, paramInteger2, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ImageFlip))
      {
        paramObject = (ImageFlip)paramObject;
        if ((j.a(this.switchMode, ((ImageFlip)paramObject).switchMode)) && (j.a(this.scheduleStartTime, ((ImageFlip)paramObject).scheduleStartTime)) && (j.a(this.scheduleEndTime, ((ImageFlip)paramObject).scheduleEndTime)) && (j.a(this.flipType, ((ImageFlip)paramObject).flipType)) && (j.a(this.rotateType, ((ImageFlip)paramObject).rotateType)) && (j.a(this.ldc, ((ImageFlip)paramObject).ldc)) && (j.a(this.nightVisionMode, ((ImageFlip)paramObject).nightVisionMode)) && (j.a(this.wtlIntensityLevel, ((ImageFlip)paramObject).wtlIntensityLevel)) && (j.a(this.forceWtlState, ((ImageFlip)paramObject).forceWtlState))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getFlipType()
  {
    return this.flipType;
  }
  
  public final String getForceWtlState()
  {
    return this.forceWtlState;
  }
  
  public final String getLdc()
  {
    return this.ldc;
  }
  
  public final String getNightVisionMode()
  {
    return this.nightVisionMode;
  }
  
  public final NightVisionModeType getNightVisionModeType()
  {
    return NightVisionModeType.Companion.fromString(this.nightVisionMode);
  }
  
  public final String getRotateType()
  {
    return this.rotateType;
  }
  
  public final Integer getScheduleEndTime()
  {
    return this.scheduleEndTime;
  }
  
  public final Integer getScheduleStartTime()
  {
    return this.scheduleStartTime;
  }
  
  public final String getSwitchMode()
  {
    return this.switchMode;
  }
  
  public final String getWtlIntensityLevel()
  {
    return this.wtlIntensityLevel;
  }
  
  public int hashCode()
  {
    Object localObject = this.switchMode;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.scheduleStartTime;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.scheduleEndTime;
    int m;
    if (localObject != null) {
      m = localObject.hashCode();
    } else {
      m = 0;
    }
    localObject = this.flipType;
    int n;
    if (localObject != null) {
      n = localObject.hashCode();
    } else {
      n = 0;
    }
    localObject = this.rotateType;
    int i1;
    if (localObject != null) {
      i1 = localObject.hashCode();
    } else {
      i1 = 0;
    }
    localObject = this.ldc;
    int i2;
    if (localObject != null) {
      i2 = localObject.hashCode();
    } else {
      i2 = 0;
    }
    localObject = this.nightVisionMode;
    int i3;
    if (localObject != null) {
      i3 = localObject.hashCode();
    } else {
      i3 = 0;
    }
    localObject = this.wtlIntensityLevel;
    int i4;
    if (localObject != null) {
      i4 = localObject.hashCode();
    } else {
      i4 = 0;
    }
    localObject = this.forceWtlState;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return (((((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i;
  }
  
  public final boolean isWhiteLampOn()
  {
    return j.a(this.forceWtlState, "on");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ImageFlip(switchMode=");
    localStringBuilder.append(this.switchMode);
    localStringBuilder.append(", scheduleStartTime=");
    localStringBuilder.append(this.scheduleStartTime);
    localStringBuilder.append(", scheduleEndTime=");
    localStringBuilder.append(this.scheduleEndTime);
    localStringBuilder.append(", flipType=");
    localStringBuilder.append(this.flipType);
    localStringBuilder.append(", rotateType=");
    localStringBuilder.append(this.rotateType);
    localStringBuilder.append(", ldc=");
    localStringBuilder.append(this.ldc);
    localStringBuilder.append(", nightVisionMode=");
    localStringBuilder.append(this.nightVisionMode);
    localStringBuilder.append(", wtlIntensityLevel=");
    localStringBuilder.append(this.wtlIntensityLevel);
    localStringBuilder.append(", forceWtlState=");
    localStringBuilder.append(this.forceWtlState);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\ImageFlip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */